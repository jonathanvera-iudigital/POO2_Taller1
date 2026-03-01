package operaciones;

import modelos.Empleado;
import java.util.ArrayList;
import java.util.List;

public class OperacionEmpleado implements IOperacionEmpleado {

  private final List<Empleado> empleados = new ArrayList<>();

  @Override
  public void agregarEmpleado(Empleado e) {
    empleados.add(e);
    System.out.println("✔ Empleado '" + e.getNombre() + "' registrado.");
  }

  @Override
  public void listarEmpleados() {
    if (empleados.isEmpty()) {
      System.out.println("No hay empleados registrados.");
      return;
    }
    System.out.println("\n===== LISTA DE EMPLEADOS (" + empleados.size() + ") =====");
    for (Empleado emp : empleados) {
      System.out.println("  " + emp);
    }
  }

  @Override
  public Empleado buscarPorDocumento(String documento) {
    for (Empleado emp : empleados) {
      if (emp.getDocumento().equalsIgnoreCase(documento))
        return emp;
    }
    return null;
  }

  @Override
  public double calcularSueldo(String documento) {
    Empleado emp = buscarPorDocumento(documento);
    if (emp == null) {
      System.out.println("Empleado no encontrado.");
      return 0;
    }
    double sueldo = emp.calcularSueldo();
    System.out.printf("Sueldo de %s: $%.2f%n", emp.getNombre(), sueldo);
    return sueldo;
  }

  @Override
  public int contarEmpleadosEnEmpresa(String nit) {
    int count = 0;
    for (Empleado emp : empleados) {
      if (emp.getEmpresa() != null &&
          emp.getEmpresa().getNit().equalsIgnoreCase(nit)) {
        count++;
      }
    }
    System.out.println("Empleados en empresa NIT '" + nit + "': " + count);
    return count;
  }

  public List<Empleado> getEmpleados() {
    return empleados;
  }
}
