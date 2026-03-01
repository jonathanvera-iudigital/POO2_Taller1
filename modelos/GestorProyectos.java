package modelos;

public class GestorProyectos extends Empleado {

  private String area;

  public GestorProyectos() {
  }

  public GestorProyectos(String documento, String nombre,
      double sueldoHora, double horasTrabajadas,
      Empresa empresa, String area) {
    super(documento, nombre, sueldoHora, horasTrabajadas, empresa);
    this.area = area;
  }

  public String getArea() {
    return area;
  }

  public void setArea(String area) {
    this.area = area;
  }

  @Override
  public String toString() {
    return super.toString() + " | Area: " + area;
  }
}
