package modelos;

public class Admin extends Empleado {

  public Admin() {
  }

  public Admin(String documento, String nombre,
      double sueldoHora, double horasTrabajadas, Empresa empresa) {
    super(documento, nombre, sueldoHora, horasTrabajadas, empresa);
  }
}
