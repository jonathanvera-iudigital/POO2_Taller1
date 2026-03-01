import javax.swing.JOptionPane;
import modelos.*;
import operaciones.*;

public class Main {
  static IOperacionEmpresa opEmpresa = new OperacionEmpresa();
  static IOperacionEmpleado opEmpleado = new OperacionEmpleado();

  public static void main(String[] args) {
    int opcion;
    boolean ejecutando = true; 

    do {
      String menu = """
          ╔══════════════════════════════╗
          ║     GESTIÓN DE EMPLEADOS     ║
          ╠══════════════════════════════╣
          ║  1. Registrar empresa        ║
          ║  2. Listar empresas          ║
          ║  3. Registrar empleado       ║
          ║  4. Listar empleados         ║
          ║  5. Buscar empleado por doc  ║
          ║  6. Calcular sueldo          ║
          ║  7. Contar empls. en empresa ║
          ║  0. Salir                    ║
          ╚══════════════════════════════╝
          """;

      String input = JOptionPane.showInputDialog(null, menu, "Menú Principal",
          JOptionPane.QUESTION_MESSAGE);
      if (input == null)
        break;

      try {
        opcion = Integer.parseInt(input.trim());
      } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Ingresa un número válido.");
        continue;
      }

      switch (opcion) {
        case 1 -> registrarEmpresa();
        case 2 -> {
          StringBuilder sb = new StringBuilder();
          ((OperacionEmpresa) opEmpresa).getEmpresas()
              .forEach(e -> sb.append(e).append("\n"));
          JOptionPane.showMessageDialog(null,
              sb.isEmpty() ? "Sin empresas." : sb.toString(), "Empresas", 1);
        }
        case 3 -> registrarEmpleado();
        case 4 -> {
          StringBuilder sb = new StringBuilder();
          ((OperacionEmpleado) opEmpleado).getEmpleados()
              .forEach(e -> sb.append(e).append("\n"));
          JOptionPane.showMessageDialog(null,
              sb.isEmpty() ? "Sin empleados." : sb.toString(), "Empleados", 1);
        }
        case 5 -> {
          String doc = JOptionPane.showInputDialog("Documento a buscar:");
          if (doc == null)
            break;
          Empleado found = opEmpleado.buscarPorDocumento(doc.trim());
          JOptionPane.showMessageDialog(null,
              found != null ? found.toString() : "No encontrado.");
        }
        case 6 -> {
          String doc = JOptionPane.showInputDialog("Documento del empleado:");
          if (doc == null)
            break;
          Empleado emp = opEmpleado.buscarPorDocumento(doc.trim());
          if (emp == null) {
            JOptionPane.showMessageDialog(null, "No encontrado.");
            break;
          }
          JOptionPane.showMessageDialog(null,
              String.format("Sueldo de %s: $%.2f", emp.getNombre(), emp.calcularSueldo()));
        }
        case 7 -> {
          String nit = JOptionPane.showInputDialog("NIT de la empresa:");
          if (nit == null)
            break;
          int count = opEmpleado.contarEmpleadosEnEmpresa(nit.trim());
          JOptionPane.showMessageDialog(null,
              "Empleados en empresa NIT '" + nit + "': " + count);
        }
        case 0 -> {
          JOptionPane.showMessageDialog(null, "¡Hasta luego!");
          ejecutando = false;
        }
        default -> JOptionPane.showMessageDialog(null, "Opción inválida.");
      }

    } while (ejecutando);
  }

  private static void registrarEmpresa() {
    String nit = JOptionPane.showInputDialog("NIT:");
    String nom = JOptionPane.showInputDialog("Nombre:");
    String dir = JOptionPane.showInputDialog("Dirección:");
    String ciu = JOptionPane.showInputDialog("Ciudad:");
    if (nit == null || nom == null)
      return;

    String tipo = JOptionPane.showInputDialog("Tipo:\n1. Empresa general\n2. Empresa de desarrollo");
    Empresa empresa = "2".equals(tipo)
        ? new EmpresaDesarrollo(nit, nom, dir, ciu)
        : new Empresa(nit, nom, dir, ciu);

    opEmpresa.agregarEmpresa(empresa);
    JOptionPane.showMessageDialog(null, "Empresa registrada: " + empresa.getNombre());
  }

  private static void registrarEmpleado() {
    if (((OperacionEmpresa) opEmpresa).getEmpresas().isEmpty()) {
      JOptionPane.showMessageDialog(null, "Primero registra al menos una empresa.");
      return;
    }

    StringBuilder empresasList = new StringBuilder("Empresas disponibles:\n");
    ((OperacionEmpresa) opEmpresa).getEmpresas()
        .forEach(e -> empresasList.append("  NIT: ").append(e.getNit())
            .append(" → ").append(e.getNombre()).append("\n"));

    String nit = JOptionPane.showInputDialog(empresasList + "\nIngresa el NIT de la empresa:");
    if (nit == null)
      return;
    Empresa empresa = opEmpresa.buscarPorNit(nit.trim());
    if (empresa == null) {
      JOptionPane.showMessageDialog(null, "Empresa no encontrada.");
      return;
    }

    String doc = JOptionPane.showInputDialog("Documento:");
    if (doc == null)
      return;

    if (opEmpleado.buscarPorDocumento(doc.trim()) != null) {
      JOptionPane.showMessageDialog(null,
          "⚠ Ya existe un empleado con el documento '" + doc.trim() + "'.",
          "Documento duplicado", JOptionPane.WARNING_MESSAGE);
      return;
    }

    String nom = JOptionPane.showInputDialog("Nombre:");
    String sh = JOptionPane.showInputDialog("Sueldo por hora ($):");
    String ht = JOptionPane.showInputDialog("Horas trabajadas:");
    if (nom == null || sh == null || ht == null)
      return;

    try {
      double sueldoHora = Double.parseDouble(sh.trim());
      double horasTrabajadas = Double.parseDouble(ht.trim());

      String tipo = JOptionPane.showInputDialog(
          "Tipo de empleado:\n1. Desarrollador\n2. Gestor de Proyectos\n3. Admin");

      Empleado empleado;
      switch (tipo != null ? tipo.trim() : "1") {
        case "2" -> {
          String area = JOptionPane.showInputDialog("Área del gestor:");
          empleado = new GestorProyectos(doc, nom, sueldoHora, horasTrabajadas, empresa,
              area != null ? area : "");
        }
        case "3" -> empleado = new Admin(doc, nom, sueldoHora, horasTrabajadas, empresa);
        default -> empleado = new Desarrollador(doc, nom, sueldoHora, horasTrabajadas, empresa);
      }

      opEmpleado.agregarEmpleado(empleado);
      JOptionPane.showMessageDialog(null, "Empleado registrado:\n" + empleado);

    } catch (NumberFormatException e) {
      JOptionPane.showMessageDialog(null, "Error: ingresa valores numéricos correctos.");
    }
  }
}
