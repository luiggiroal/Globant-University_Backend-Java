package Figuras_Geometricas_1;

public class Triangulo {
    private double base;
    private double altura;

    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }
    public void setBase(double base) {
        this.base = base;
    }
    public void setAltura(double altura) {
        this.altura = altura;
    }
    public double getBase() {
        return this.base;
    }
    public double getAltura() {
        return this.altura;
    }

    public double area() {
        return (this.base * this.altura) / 2;
    }
    public void imprimirDatos() {
        System.out.printf("""
                
                - Triángulo con base %s y altura %s:
                   * Área: %s
                """, this.base, this.altura, this.area());
    }
}
