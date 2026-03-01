package modelos;

public abstract class Empleado {
  private String documento;
  private String nombre;
  private double sueldoHora;
  private double horasTrabajadas;
  private Empresa empresa;

  public Empleado() {
  }

  public Empleado(String documento, String nombre,
      double sueldoHora, double horasTrabajadas, Empresa empresa) {
    this.documento = documento;
    this.nombre = nombre;
    this.sueldoHora = sueldoHora;
    this.horasTrabajadas = horasTrabajadas;
    this.empresa = empresa;
  }

  public String getDocumento() {
    return documento;
  }

  public void setDocumento(String documento) {
    this.documento = documento;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public double getSueldoHora() {
    return sueldoHora;
  }

  public void setSueldoHora(double sueldoHora) {
    this.sueldoHora = sueldoHora;
  }

  public double getHorasTrabajadas() {
    return horasTrabajadas;
  }

  public void setHorasTrabajadas(double horasTrabajadas) {
    this.horasTrabajadas = horasTrabajadas;
  }

  public Empresa getEmpresa() {
    return empresa;
  }

  public void setEmpresa(Empresa emp) {
    this.empresa = emp;
  }

  public double calcularSueldo() {
    return sueldoHora * horasTrabajadas;
  }

  @Override
  public String toString() {
    return String.format(
        "Doc: %-10s | Nombre: %-20s | Tipo: %-18s | Sueldo/h: $%8.2f | Horas: %5.1f | Empresa: %s",
        documento, nombre, getClass().getSimpleName(), sueldoHora, horasTrabajadas,
        empresa != null ? empresa.getNombre() : "Sin empresa");
  }
}
