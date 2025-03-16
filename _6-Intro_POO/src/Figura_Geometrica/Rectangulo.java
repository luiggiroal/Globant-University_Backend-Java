package Figura_Geometrica;

public class Rectangulo {
    private Double ancho;
    private Double alto;
    private static Integer contadorRectangulos = 0;

    public Rectangulo(Double ancho, Double alto) {
        this.alto = alto;
        this.ancho = ancho;
        contadorRectangulos++;
    }

    public Double getAncho() {
        return this.ancho;
    }

    public Double getAlto() {
        return this.alto;
    }

    public Double area() {
        return this.ancho * this.alto;
    }
    public Double perimetro() {
        return (2 * (this.ancho + this.alto));
    }

    public void imprimirArea() {
        System.out.printf("El área del rectángulo es %s%n", this.area());
    }
    public void imprimirPerimetro() {
        System.out.printf("El perimetro del rectángulo es %s%n", this.perimetro());
    }

    public static Integer obtenerNumeroRectangulos() {
        return contadorRectangulos;
    }

}
