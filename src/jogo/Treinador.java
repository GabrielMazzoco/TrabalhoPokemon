package jogo;

import pokemons.Pokemon;

/**
 * Classe abstrata Pai do treinador maquina e o treinador player que possuem um pokemon
 */
public abstract class  Treinador {
    Pokemon poke;

    /**
     * Funcao que serve para ver o estado atual do pokemon
     */
    public void statusPokemon(){
        System.out.println("HP Pokemon :  " + poke.getVida());
    }

    public abstract int mandarAtacar(int i, Pokemon m);
}
