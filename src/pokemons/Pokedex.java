package pokemons;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class Pokedex {
    private String[] nomes;
    private String[] tipos;

    public Pokedex(String n, String t) {
        nomes = n.split(",");
        tipos = t.split(",");
    }

    /**
     * Imprime os pokemons presentes na Pokedex
     */
    public void imprimirPokemons() {
        System.out.println("Escolha o Pokemon na lista abaixo : ");
        for (int i = 0; i < nomes.length; i++) {
            System.out.println(i + " - " + nomes[i] + "(" + tipos[i] + ")");
        }
    }

    /**
     * Funcao que permite a escolha do pokemon desejado da pokedex
     * @param x Int que determinara o pokemon
     * @return Retorna um objeto da classe Especie
     */
    public Pokemon escolherPokemon(int x){
        for (int i = 0; i < nomes.length; i++) {
            if (x == i) {
                Pokemon poke;
                if(tipos[i].equals("Pedra")){
                    poke = new Pedra(nomes[i]);
                }
                else if(tipos[i].equals("Grama")){
                    poke = new Grama(nomes[i]);
                }
                else if(tipos[i].equals("Fogo")){
                    poke = new Fogo(nomes[i]);
                }
                else if(tipos[i].equals("Eletrico")){
                    poke = new Eletrico(nomes[i]);
                }
                else{
                    poke = new Agua(nomes[i]);
                }
                return poke;
            }
        }
        return null;
    }

    /**
     * Funcao para auxiliar em iteracoes de loops
     * @return Retorna a quantidade de pokemons na pokedex
     */
    public int getTam(){
        return nomes.length;
    }
}
