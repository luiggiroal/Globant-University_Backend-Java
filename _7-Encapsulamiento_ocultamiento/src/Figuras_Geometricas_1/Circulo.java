package Figuras_Geometricas_1;

public class Circulo {
    private final double PI = Math.PI;
    private double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }
    public void setRadio(double radio) {
        this.radio = radio;
    }
    public double getRadio() {
        return this.radio;
    }

    public double area() {
        return this.PI * Math.pow(this.radio, 2);
    }
    public double perimetro() {
        return 2 * this.PI * this.radio;
    }
    public void imprimirDatos() {
        System.out.printf("""
                
                - Círculo de radio %s:
                   * Área: %s
                   * Perimetro: %s
                """, this.radio, this.area(), this.perimetro());
    }
}

