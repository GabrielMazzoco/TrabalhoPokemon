package jogo;

import pokemons.Pokemon;

import java.util.Random;

public class Maquina extends Treinador{
    private static int cont = 0;

    public Maquina(){
        cont ++;
    }

    /**
     * Funcao que inicia o pokemon da Maquina com um tipo sorteado
     * e inicia sua vida com a vida padrao do pokemon da maquina.
     */
    public void prepararPokemon(Pokemon p){
        poke =  p;
        poke.setVida(20 + 5*(cont/5));
        poke.setAtkNormal(5 + (cont/5));
        poke.setAtkForte(10 + (cont/5));
        poke.setAtkEspecial(0);
    }

    /**
     * Funcao que faz o inimigo mandar seu pokemon fazer um ataque
     */
    public int mandarAtacar(int i, Pokemon m){
        Random r = new Random();
        if(i == 1) {
            if(r.nextFloat() < 0.8)
                return poke.atacar();
            else
                return 0;
        }
        else if(i == 2){
            if(r.nextFloat() < 0.40)
                return poke.getAtkForte();
            else
                return 0;
        }
        else if(i == 3){
            return (int) (0.7 * poke.atacarTipo(m));
        }
        else
            return 0;
    }

    /**
     * Reinicia o contador estatico de treinadores Maquina, para quando o jogo acabar e o player
     * nao desistir, resetar a maquina, para que o usuario nao lute contra os treinadores mais fortes
     */
    public void reiniciar(){
        cont = 0;
    }
}
