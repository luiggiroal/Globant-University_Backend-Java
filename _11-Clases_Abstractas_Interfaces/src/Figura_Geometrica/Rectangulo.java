package Figura_Geometrica;

public class Rectangulo extends Figura implements Dibujable{
    private double base;
    private double altura;
    public Rectangulo(double base, double altura) {
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
    @Override
    public double calcularArea() {
        return this.base * this.altura;
    }
    @Override
    public double calcularPerimetro() {
        return 2 * (this.base + this.altura);
    }
    @Override
    public void dibujar(){
        System.out.println("Dibujando rectángulo...");
    }
}
