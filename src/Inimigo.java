import java.util.Random;

public class Inimigo{

    private int vida;
    private int ataque;
    private int defesa;


    public Inimigo() {
        this.vida = 30;
        this.defesa = gerarValoresAleatorios();
        this.ataque = gerarValoresAleatorios();
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    private int gerarValoresAleatorios() {
        Random random = new Random();
        return random.nextInt(20) + 1;
    }

    public void atacar(Jogador jogador) {
        setAtaque(gerarValoresAleatorios());
        int defesaJogador = jogador.getDefesa();
        int vidaJodador = jogador.getVida();

        if (ataque > defesaJogador) {
            System.out.println("Ataque inimigo: " + ataque);
            vidaJodador = vidaJodador - (ataque - defesaJogador);
            jogador.setVida(vidaJodador);
            System.out.println("Vida do inimigo:"+vida);
        } else {
            System.out.println("Você errou o ataque!");
        }
    }

    public void defender(Jogador jogador) {
        int ataqueJogador = jogador.getAtaque();
        int vidaInimigo = getVida();

        if (ataqueJogador > defesa) {
            System.out.println("Defesa inimigo: " + defesa);
            vidaInimigo = vidaInimigo - (ataqueJogador - defesa);
            setVida(vidaInimigo);
            System.out.println("O inimigo está vivo. Vida restante:  " + vida);
        } else {
            System.out.println("Defesa inimigo: " + defesa);
            System.out.println("O inimigo não sofreu dano.");
        }
        setDefesa(gerarValoresAleatorios());
    }

    public int estaVivo() {
        if (vida > 0) {
            return 1;
        } else {
            System.out.println("Inimigo está morto");
            return 0;
        }
    }
}
