package jogo;

import pokemons.Pokedex;
import pokemons.Pokemon;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.InputMismatchException;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

public class Jogo {
    private CampoBatalha cb;
    private Pokedex listaPokemons;
    private String propertiesPath;
    private Properties props;

    public Jogo(String propertiePath) throws Exception {
        this.propertiesPath = propertiePath;
        props = new Properties();
        FileInputStream file = new FileInputStream(propertiesPath);
        props.load(file);
    }

    /**
     * Funcao que inicia o Campo de Batalha onde os Treinadores batalham
     * e para apenas quando o player principal escolher desistir da
     * partida.
     */
    public void iniciarJogo() throws Exception{
        cb = new CampoBatalha();

        Scanner leitor = new Scanner(System.in);

        int desistir = 0;
        while(desistir == 0){
            //Implemente o jogo aqui
            System.out.println("-----Digite 0 a qualquer momento para fechar o game-----");
            int recorde = 0;
            prepararPlayer();
            while(cb.player.poke.getVida() > 0 ) {
                recorde++;
                prepararMaquina();
                System.out.println("Voce ira enfrentar um " + cb.maquina.poke.getName());
                while (cb.player.poke.getVida() > 0 && cb.maquina.poke.getVida() > 0) {
                    imprimirInformacoes();

                    System.out.println("Escolha seu Ataque : ");//coleta de dados do ataque deve ficar em jogo
                    System.out.println("(1) - Investida");
                    System.out.println("(2) - Ataque Forte");
                    System.out.println("(3) - " + cb.player.poke.getAtkTipo() + cb.player.imprimirCooldown());
                    System.out.println("(4) - Especial");

                    int i = lerValorAtk();
                    
                    if(i == 0){//Opçao 0 é para encerrar o jogo
                        cb.player.poke.setVida(0);
                    }

                    cb.rodadaAtaques(i);
                }
            }
            cb.maquina.reiniciar();

            int x = Integer.parseInt(props.getProperty("prop.jogo.recorde"));
            if(recorde > x){
                System.out.println("Novo Recorde : " + recorde + " inimigos derrotados.");
                props.setProperty("prop.jogo.recorde", Integer.toString(recorde));
                FileOutputStream fos = new FileOutputStream(propertiesPath);
                props.store(fos, "");
                fos.close();
            }

            System.out.println("Fim de jogo, deseja desistir ? (1) - Sim   (0) - Nao");
            desistir = leitor.nextInt();
            if(desistir == 1)
                System.exit(0);
        }
    }

    /**
     * Inicia a pokedex com todos os pokemons e seus tipos incluidos no arquivo de configuracao
     * @param nomes String com os nomes dos pokemons separados por virgula
     * @param tipos String com os respectivos tipos separados por virgula
     */
    public void iniciarPokedex(String nomes, String tipos){
        listaPokemons = new Pokedex(nomes, tipos);
    }

    /**
     * Prepara um Treinador que sera o inimigo do usuario com um pokemon
     * aleatorio da pokedex
     */
    public void prepararMaquina(){
        cb.maquina = new Maquina();
        Random rand = new Random();
        int x = rand.nextInt(listaPokemons.getTam());
        Pokemon m = listaPokemons.escolherPokemon(x);
        cb.maquina.prepararPokemon(m);
    }

    /**
     * Prepara um Treinador para o player e pergunta qual pokemon da lista
     * em pokedex ele deseja escolher.
     */
    public void prepararPlayer(){
        cb.player = new Player();
        listaPokemons.imprimirPokemons();
        int x = lerValorPoke();
        Pokemon p = listaPokemons.escolherPokemon(x);
        cb.player.prepararPokemon(p);
    }

    /**
     * Imprime as informacoes dos pokemons que estao batalhando no campo de
     * Batalha.
     */
    public void imprimirInformacoes(){
        System.out.println("==================");
        System.out.println(cb.player.poke.getName());
        cb.player.statusPokemon();
        System.out.println("\n" + cb.maquina.poke.getName());
        cb.maquina.statusPokemon();
        System.out.println("==================");
    }

    /**
     * Funcao para ler um valor e tratar se caso o usuario insira um valor invalido
     * @return Retorna um valor int digitado pelo Usuario
     */
    public int lerValorAtk(){
        Scanner sc = new Scanner(System.in);
        try{
            int i = sc.nextInt();
            return i;
        }catch (InputMismatchException e){
            System.out.println("Digite um valor valido(Erro) : ");
            int i = lerValorAtk();
            return i;
        }
    }

    public int lerValorPoke(){
        Scanner sc = new Scanner(System.in);
        try{
            int i = sc.nextInt();
            return i;
        } catch (InputMismatchException e){
            System.out.println("Digite um valor valido(Erro) : ");
            int i = lerValorPoke();
            return i;
        }
    }
}
//alocar os treinadores e setar seus pokemons.