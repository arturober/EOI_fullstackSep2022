public class Mamifero extends Animal {
    private boolean carnivoro;

    public Mamifero(String nombre, double peso, boolean carnivoro) {
        super(nombre, peso);
        this.carnivoro = carnivoro;
    }
    
    public boolean isCarnivoro() {
        return carnivoro;
    }

    public void setCarnivoro(boolean carnivoro) {
        this.carnivoro = carnivoro;
    }
    
    @Override
    public void comer() {
        super.comer();
        System.out.println("He comido: " + (carnivoro ? "carne" : "hierba"));
    }
}
