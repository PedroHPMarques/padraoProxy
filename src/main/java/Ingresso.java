import java.util.Arrays;
import java.util.List;

public class Ingresso implements IIngresso {

    private Integer codigo;
    private String nome;
    private Float preco;
    private Float desconto;


    public Ingresso(int codigo){
        this.codigo = codigo;
        Ingresso objeto = BD.getIngresso(codigo);
        this.nome = objeto.nome;
        this.preco = objeto.preco;
        this.desconto = objeto.desconto;
    }

    public Ingresso(Integer codigo, String nome, Float preco, Float desconto){
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.desconto = desconto;
    }
    public Integer getCodigo() {
        return codigo;
    }

    @Override
    public List<String> obterDetalhes() {
        return Arrays.asList(this.nome, this.preco.toString());
    }

    @Override
    public Float obterdesconto(Torcedor torcedor) {
        return this.desconto;
    }

}
