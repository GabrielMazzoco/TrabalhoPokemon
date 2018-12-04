/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojapokemon;

import exceptions.ValorInvalidoException;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Properties;
import java.util.Scanner;
import pokemons.Pokedex;
import pokemons.Pokemon;

/**
 *
 * @author mazzoco
 */
public class Loja{
    private Pokedex listapokemons;
    
    public Loja(String propertiesPath)  throws Exception{
        Properties props = new Properties();
        FileInputStream file = new FileInputStream(propertiesPath);
        props.load(file);
        
        String nomes = props.getProperty("prop.pokemons.nomes");     
        String tipos = props.getProperty("prop.pokemons.tipos");
        
        listapokemons = new Pokedex(nomes, tipos);
    }
    
    public void comprar() throws ValorInvalidoException, Exception{
        ArrayList<Pokemon> pokemons = new ArrayList();
        
        System.out.println("Escolha os pokemons que deseja comprar(Digite um valor negativo para encerrar) : ");
        listapokemons.imprimirPokemons();
        int x = lerValor();
        while(x >= 0){
            Pokemon p = listapokemons.escolherPokemon(x);
            System.out.println(p.getName());
            System.out.println("Preco R$ " + p.getPreco());
            System.out.println("Deseja levar quantos : ");
            int j = lerValor();
            if(j < 0)
                ValorInvalidoException("Quantidade deve ser maior ou igual a 0(ERRO)");
            for(int i=0 ; i<j ; i++){
                pokemons.add(p);
            }
            listapokemons.imprimirPokemons();
            System.out.println("Digite um valor negativo para sair.");
            x = lerValor();
        }
        
        System.out.println("Valor Total da compra : ");
        int total = valorTotal(pokemons);
        System.out.println(total);
        
        gravarCompra(pokemons, total);
        
        System.exit(0);
    }
    
    public int lerValor(){
        Scanner sc = new Scanner(System.in);
        try{
            int i = sc.nextInt();
            return i;
        }catch (InputMismatchException e){
            System.out.println("Digite um valor valido(Erro) : ");
            int i = lerValor();
            return i;
        }
    }
    
    public int valorTotal(ArrayList<Pokemon> pokemons){
        int total = 0;
        for(Pokemon itens : pokemons){
            total += itens.getPreco();
        }
        return total;
    }
    
    public void gravarCompra(ArrayList<Pokemon> pokemons, int total) throws IOException{
        FileWriter fw = new FileWriter("Vendas.txt", true);
        PrintWriter out = new PrintWriter(fw);
        out.println();
        out.println("Compra Realizada : ");
        for(Pokemon itens : pokemons){
            out.printf(itens.getName() + "(R$" + itens.getPreco() + ")" + "   ");
        }
        out.println();
        out.printf("Valor Total : " + total);
        fw.flush();
        System.out.println("Venda salva com sucesso.");
    }

    private Exception ValorInvalidoException(String valor_NegativoERRO) throws exceptions.ValorInvalidoException {
        throw new ValorInvalidoException(valor_NegativoERRO); //To change body of generated methods, choose Tools | Templates.
    }
}
