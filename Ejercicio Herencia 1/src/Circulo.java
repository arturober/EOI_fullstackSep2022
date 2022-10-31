public class Circulo extends Figura {
    private double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    public double getRadio() {
        return radio;
    }

    @Override
    public double getArea() {
        return Math.pow(radio, 2) * Math.PI;
    }

    @Override
    public double getPerimetro() {
        return 2 * radio * Math.PI;
    }
}
