package Figura_Geometrica;

public class Circulo extends Figura implements Dibujable {
    private double radio;
    private final double PI  = Math.PI;
    public Circulo(double radio) {
        this.radio = radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public double getRadio() {
        return this.radio;
    }
    @Override
    public double calcularArea() {
        return this.PI * Math.pow(this.radio, 2);
    }
    @Override
    public double calcularPerimetro() {
        return 2 * this.PI * this.radio;
    }

    @Override
    public void dibujar(){
        System.out.println("Dibujando círculo...");
    }
}
