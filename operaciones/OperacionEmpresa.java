package operaciones;

import modelos.Empresa;
import java.util.ArrayList;
import java.util.List;

public class OperacionEmpresa implements IOperacionEmpresa {

  private final List<Empresa> empresas = new ArrayList<>();

  @Override
  public void agregarEmpresa(Empresa e) {
    empresas.add(e);
    System.out.println("✔ Empresa '" + e.getNombre() + "' registrada.");
  }

  @Override
  public void listarEmpresas() {
    if (empresas.isEmpty()) {
      System.out.println("No hay empresas registradas.");
      return;
    }
    System.out.println("\n===== LISTA DE EMPRESAS (" + empresas.size() + ") =====");
    for (Empresa emp : empresas) {
      System.out.println("  " + emp);
    }
  }

  @Override
  public Empresa buscarPorNit(String nit) {
    for (Empresa e : empresas) {
      if (e.getNit().equalsIgnoreCase(nit))
        return e;
    }
    return null;
  }

  public List<Empresa> getEmpresas() {
    return empresas;
  }
}
