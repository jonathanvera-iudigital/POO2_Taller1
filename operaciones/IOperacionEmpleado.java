package operaciones;

import modelos.Empleado;

public interface IOperacionEmpleado {
  void agregarEmpleado(Empleado e);
  void listarEmpleados();
  Empleado buscarPorDocumento(String documento);
  double calcularSueldo(String documento);
  int contarEmpleadosEnEmpresa(String nit);
}
