public class Cuadrado implements IFigura {
    private double lado;

    public Cuadrado(double lado) {
        this.lado = lado;
    }

    public double getLado() {
        return lado;
    }

    @Override
    public double getArea() {
        return Math.pow(lado, 2);
    }

    @Override
    public double getPerimetro() {
        return lado * 4;
    }

}
