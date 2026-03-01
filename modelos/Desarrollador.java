package modelos;

public class Desarrollador extends Empleado {
  public Desarrollador() {
  }

  public Desarrollador(String documento, String nombre,
      double sueldoHora, double horasTrabajadas, Empresa empresa) {
    super(documento, nombre, sueldoHora, horasTrabajadas, empresa);
  }
}
