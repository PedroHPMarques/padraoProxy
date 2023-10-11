public class Torcedor {
    private String nome;
    private boolean socio;
    public Torcedor(String nome, boolean socio) {
        this.nome = nome;
        this.socio = socio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isSocio() {
        return socio;
    }

    public void setSocio(boolean socio) {
        this.socio = socio;
    }
}
