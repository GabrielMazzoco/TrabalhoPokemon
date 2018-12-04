package pokemons;

import java.util.Random;

public class Grama extends Pokemon {

    private String atkTipo;

    public Grama(String nome) {
        name = nome;
        atkTipo = "Tempestade de Folhas";
        Random rand = new Random();
        preco = rand.nextInt(35)+15;
    }


    @Override
    public int atacarTipo(Pokemon e) {
        if(e instanceof Agua)
            return 15;
        else if(e instanceof Pedra)
            return 15;
        else if(e instanceof Fogo)
            return 5;
        else if(e instanceof Grama)
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
        if(name.equals("Bulbasaur"))
            System.out.println("Bulbasaurrrrrr");
        else if(name.equals("Oddish"))
            System.out.println("Oddishhhhhhhhhh");
        else if(name.equals("Bellsprout"))
            System.out.println("Bellsssssssprout");
    }
}
