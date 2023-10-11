import java.util.List;
public interface IIngresso {
    List<String> obterDetalhes();

    Float obterdesconto(Torcedor torcedor);
}
