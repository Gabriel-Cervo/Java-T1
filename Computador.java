public class Computador {
    private String nome;
    private int trabalho;
    
    public Computador(String nome, int trabalho) {
        this.nome = nome;
        this.trabalho = trabalho;
    }

    public Computador(int trabalho) {
        this.nome = "Sem nome";
        this.trabalho = trabalho;
    }

    public Computador(String nome) {
        this.nome = nome;
        this.trabalho = 0;
    }

    public String getNome() {
        return nome;
    }

    public int getTrabalho() {
        return trabalho;
    }

    public void setTrabalho(int trabalho) {
        this.trabalho = trabalho;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
