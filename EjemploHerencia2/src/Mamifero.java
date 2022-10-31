public class Mamifero extends Animal {
    private boolean carnivoro;

    public Mamifero(String nombre, double peso, boolean carnivoro) {
        super(nombre, peso);
        this.carnivoro = carnivoro;
    }

    public Mamifero(Mamifero m) {
        super(m.getNombre(), m.getPeso());
        this.carnivoro = m.carnivoro;
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

    @Override
    public String tipoAnimal() {
        return "Mamífero";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + (carnivoro ? 1231 : 1237);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Mamifero other = (Mamifero) obj;
        if (carnivoro != other.carnivoro)
            return false;
        return true;
    }
}
