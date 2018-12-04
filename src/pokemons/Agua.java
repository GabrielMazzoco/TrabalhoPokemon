package pokemons;

import java.util.Random;

public class Agua extends Pokemon {

    private String atkTipo;

    public Agua(String nome) {
        name = nome;
        atkTipo = "Hidro Bomba";
        Random rand = new Random();
        preco = rand.nextInt(35)+15;
    }

    @Override
    public int atacarTipo(Pokemon e) {
        if(e instanceof Fogo)
            return 15;
        else if(e instanceof Pedra)
            return 15;
        else if(e instanceof Grama)
            return 5;
        else if(e instanceof Eletrico)
            return 5;
        else if(e instanceof Agua)
            return 5;
        else
            return 7;
    }

    @Override
    public String getAtkTipo() {
        return atkTipo;
    }

    @Override
    public void emitirSom() {
        if(name.equals("Squirtle"))
            System.out.println("Squirrrrrrrrtle");
        else if(name.equals("Poliwag"))
            System.out.println("Poooooooliwag");
        else if(name.equals("Tentacool"))
            System.out.println("Tentacoooooool");
        else if(name.equals("Vaporeon"))
            System.out.println("Vapooooooooreon");
    }
}
