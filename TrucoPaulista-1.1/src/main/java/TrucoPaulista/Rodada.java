package TrucoPaulista;

public interface Rodada {
    void jogar();
    int getPontos();
}

// Classe para rodada normal
class RodadaNormal implements Rodada {
    private Mesa mesa;
    private int pontos;

    public RodadaNormal(Mesa mesa) {
        this.mesa = mesa;
        this.pontos = 1;
    }

    @Override
    public void jogar() {
        // Implementar a lógica de jogar a rodada normal aqui
        // Exemplo simples: a dupla que ganhar a rodada recebe pontos
        Jogador vencedorTurno = mesa.determinarVencedorTurno();
        int duplaVencedora = vencedorTurno.getDupla();
        mesa.atualizarPontos(duplaVencedora, pontos);
    }

    @Override
    public int getPontos() {
        return pontos;
    }
}

// Outras classes de Rodada para Truco, Seis, Nove e Doze
class RodadaTruco implements Rodada {
    private Mesa mesa;
    private int pontos;

    public RodadaTruco(Mesa mesa) {
        this.mesa = mesa;
        this.pontos = 3;
    }

    @Override
    public void jogar() {
        Jogador vencedorTurno = mesa.determinarVencedorTurno();
        int duplaVencedora = vencedorTurno.getDupla();
        mesa.atualizarPontos(duplaVencedora, pontos);
    }

    @Override
    public int getPontos() {
        return pontos;
    }
}

class RodadaSeis implements Rodada {
    private Mesa mesa;
    private int pontos;

    public RodadaSeis(Mesa mesa) {
        this.mesa = mesa;
        this.pontos = 6;
    }

    @Override
    public void jogar() {
        Jogador vencedorTurno = mesa.determinarVencedorTurno();
        int duplaVencedora = vencedorTurno.getDupla();
        mesa.atualizarPontos(duplaVencedora, pontos);
    }

    @Override
    public int getPontos() {
        return pontos;
    }
}

class RodadaNove implements Rodada {
    private Mesa mesa;
    private int pontos;

    public RodadaNove(Mesa mesa) {
        this.mesa = mesa;
        this.pontos = 9;
    }

    @Override
    public void jogar() {
        Jogador vencedorTurno = mesa.determinarVencedorTurno();
        int duplaVencedora = vencedorTurno.getDupla();
        mesa.atualizarPontos(duplaVencedora, pontos);
    }

    @Override
    public int getPontos() {
        return pontos;
    }
}

class RodadaDoze implements Rodada {
    private Mesa mesa;
    private int pontos;

    public RodadaDoze(Mesa mesa) {
        this.mesa = mesa;
        this.pontos = 12;
    }

    @Override
    public void jogar() {
        Jogador vencedorTurno = mesa.determinarVencedorTurno();
        int duplaVencedora = vencedorTurno.getDupla();
        mesa.atualizarPontos(duplaVencedora, pontos);
    }

    @Override
    public int getPontos() {
        return pontos;
    }
}

// Factory para criar diferentes tipos de Rodada
class RodadaFactory {
    public static Rodada criarRodada(String tipo, Mesa mesa) {
        switch (tipo.toLowerCase()) {
            case "truco":
                return new RodadaTruco(mesa);
            case "seis":
                return new RodadaSeis(mesa);
            case "nove":
                return new RodadaNove(mesa);
            case "doze":
                return new RodadaDoze(mesa);
            default:
                return new RodadaNormal(mesa);
        }
    }
}