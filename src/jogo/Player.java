package jogo;
import pokemons.Pokemon;

import java.util.Random;
import java.util.Scanner;

public class Player extends Treinador{
    private static int numEspecial = 5;
    private boolean cooldown = false;

    /**
     * Funcao para o Player iniciar o pokemon, seta a vida o ataque normal o ataque
     * especial do Pokemon e o ataque forte.
     */
    public void prepararPokemon(Pokemon p){ //exeption para escrever nome com espaço

        poke =  p;
        poke.setVida(150);
        poke.setAtkNormal(7);
        poke.setAtkForte(15);
        poke.setAtkEspecial(25);
    }


    /**
     * Funcao que dependendo do parametro retorna o ataque do pokemon
     * @param i Int que determinara o ataque
     * @param m Objeto da classe pokemon usado como parametro no atkTipo para ver a vantagem ou desvantagem
     * @return Retorna um Int com o dano do ataque
     */
    public int mandarAtacar(int i, Pokemon m){
        Random r = new Random();
        if(i == 1) {
            cooldown = false;
            if(r.nextFloat() < 0.8)
                return poke.atacar();
            else
                return 0;
        }
        else if(i == 2){
            cooldown = false;
            if(r.nextFloat() < 0.5)
                return poke.getAtkForte();
            else
                return 0;
        }
        else if(i == 3 && !cooldown){
            cooldown = true;
            return poke.atacarTipo(m);
        }
        else if(i == 4 && numEspecial > 0){
            cooldown = false;
            numEspecial--;
            return poke.atacarEspecial();
        }
        else
            //System.out.println(poke.getName() + " errou o ataque.");
            return 0;
    }

    /**
     * Funcao que serve para ver o estado atual do pokemon
     */
    public void statusPokemon(){
        super.statusPokemon();
        System.out.println("Especiais : " + numEspecial);
    }

    /**
     * Verifica se a habilidade elemental do pokemon esta em tempo de recarga
     * @return String para imprimir se esta ou nao em Cooldown
     */
    public String imprimirCooldown(){
        if(cooldown)
            return "(Cooldown)";
        else
            return "";
    }
}
