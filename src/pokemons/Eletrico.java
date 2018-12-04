package pokemons;

import java.util.Random;

public class Eletrico extends Pokemon {

    private String atkTipo;

    public Eletrico(String nome) {
        name = nome;
        atkTipo = "Choque do Trovão";
        Random rand = new Random();
        preco = rand.nextInt(35)+15;
    }

    @Override
    public int atacarTipo(Pokemon e) {
        if(e instanceof Agua)
            return 15;
        else if(e instanceof Grama)
            return 5;
        else if(e instanceof Eletrico)
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
        if(name.equals("Pikachu"))
            System.out.println("Pika Pika CHUUU");
        else if(name.equals("Magnemite"))
            System.out.println("Magnemiteeeeeeee");
        else if(name.equals("Voltorb"))
            System.out.println("Vooooltorrrrrrb");
        else if(name.equals("Jolteon"))
            System.out.println("Jolteonnnnnnnnn");
    }
}
