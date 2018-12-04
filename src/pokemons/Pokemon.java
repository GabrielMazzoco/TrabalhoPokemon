package pokemons;

import java.util.Random;

public abstract class Pokemon {
    protected String name;
    protected int vida;
    protected int atkNormal;
    protected int atkForte;
    protected int atkEspecial;
    protected int preco;

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int atacar() {
        return atkNormal;
    }

    public void setAtkNormal(int atkNormal) {
        this.atkNormal = atkNormal;
    }

    public int atacarEspecial() {
        return atkEspecial;
    }

    public void setAtkEspecial(int atkEspecial) {
        this.atkEspecial = atkEspecial;
    }

    public String getName() {
        return name;
    }

    public int getAtkForte() {
        return atkForte;
    }

    public void setAtkForte(int atkForte) {
        this.atkForte = atkForte;
    }

    /**
     * Funcao que diminuiu a vida do Pokemon
     * @param i Parametro de quanto a vida sera diminuida
     */
    public void serAtacado(int i) {
        vida -= i;
    }

    /**
     * Ataque do tipo Elemental do pokemon, determinado pelo seu tipo
     * @param e Pokemon inimigo para verificar a vantagem ou desvantagem
     * @return Retorna o dano que o ataque causara
     */
    public abstract int atacarTipo(Pokemon e);

    public abstract String getAtkTipo();
    
    public abstract void emitirSom();
}
