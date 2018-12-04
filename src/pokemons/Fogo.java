package pokemons;

import java.util.Random;

public class Fogo extends Pokemon {

    private String atkTipo;

    public Fogo(String nome) {
        name = nome;
        atkTipo = "Incineração";
        Random rand = new Random();
        preco = rand.nextInt(35)+15;
        
    }

    @Override
    public int atacarTipo(Pokemon e) {
        if(e instanceof Grama)
            return 15;
        else if(e instanceof Agua)
            return 5;
        else if(e instanceof Pedra)
            return 5;
        else if(e instanceof Fogo)
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
        if(name.equals("Flareon"))
            System.out.println("Flaaaaaaaareon");
        else if(name.equals("Ponyta"))
            System.out.println("Ponyyyyyyyyyyta");
        else if(name.equals("Vulpix"))
            System.out.println("Vulpixxxxxxxxx");
        else if(name.equals("Charmander"))
            System.out.println("Charrrrrrrmander");
    }
}
