import java.util.List;

public class IngressoProxy implements IIngresso{

    private Ingresso ingresso;

    private Integer codigo;

    public IngressoProxy(Integer codigo){
        this.codigo = codigo;
    }
    @Override
    public List<String> obterDetalhes() {
        if (this.ingresso == null) {
            this.ingresso = new Ingresso(this.codigo);
        }
        return this.ingresso.obterDetalhes();
    }

    @Override
    public Float obterdesconto(Torcedor torcedor) {
        if (!torcedor.isSocio()) {
            throw new IllegalArgumentException("Torcedor não autorizado");
        }
        if (this.ingresso == null) {
            this.ingresso = new Ingresso(this.codigo);
        }
        return this.ingresso.obterdesconto(torcedor);
    }
}
