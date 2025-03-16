package Figuras_Geometricas_1;

public class Rectangulo {
    private double ancho;
    private double alto;

    public Rectangulo() {}
    public Rectangulo(double ancho, double alto) {
        this.ancho = ancho;
        this.alto = alto;
    }
    public void setAncho(double ancho) {
        this.ancho = ancho;
    }
    public void setAlto(double alto) {
        this.alto = alto;
    }
    public double getAncho() {
        return this.ancho;
    }
    public double getAlto() {
        return this.alto;
    }

    public double area() {
        return this.alto * this.ancho;
    }
    public double perimetro() {
        return 2 * (this.ancho + this.alto);
    }
    public void imprimirDatos() {
        System.out.printf("""

                - Rectangulo con alto %s y ancho %s:
                   * Area: %s
                   * Perimetro: %s
                """, this.alto, this.ancho, this.area(), this.perimetro());
    }
}
