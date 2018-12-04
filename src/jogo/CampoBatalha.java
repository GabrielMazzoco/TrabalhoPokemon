package jogo;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class CampoBatalha {
    Player player;
    Maquina maquina;

    /**
     * Funcao que permite o player atacar o inimigo, e se ele nao for derrotado
     * a maquina faz um ataque contra o player.
     */
    public void rodadaAtaques(int i){
        Random r = new Random();

        int x = player.mandarAtacar(i, maquina.poke);
        maquina.poke.serAtacado(x);
        if(x == 0)
            System.out.println(player.poke.getName() + " errou o ataque.");
        else
            System.out.println(player.poke.getName() + " causou " + x + " de dano no inimigo.");

        if(maquina.poke.getVida() > 0){
            x = maquina.mandarAtacar(r.nextInt(4)+1, player.poke);
            player.poke.serAtacado(x);
            if(x == 0)
                System.out.println(maquina.poke.getName() + " errou o ataque.");
            else
                System.out.println(maquina.poke.getName() + " causou " + x + " de dano.");
        }
        else
            System.out.println(maquina.poke.getName() + " Inimigo Derrotado");
    }
}