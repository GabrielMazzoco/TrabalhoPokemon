package pokemons;

import java.util.Random;

public class Pedra extends Pokemon {

    private String atkTipo;

    public Pedra(String nome) {
        name = nome;
        atkTipo = "Arremesso de Pedra";
        Random rand = new Random();
        preco = rand.nextInt(35)+15;
    }

    @Override
    public int atacarTipo(Pokemon e){
        if(e instanceof Fogo)
            return 15;
        else if(e instanceof Grama)
            return 15;
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
        if(name.equals("Geodude"))
            System.out.println("Geoduuuudeeeeee");
        else if(name.equals("Onix"))
            System.out.println("OOOOOnixxxxxxx");
    }
}
