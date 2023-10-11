import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
class IngressoProxyTest {
    @BeforeEach
    void setUp() {
        BD.addIngresso(new Ingresso(5001, "City x United", 100.0f, 20f));
        BD.addIngresso(new Ingresso(5002, "Barça x Real", 150.0f, 25f));
    }

    @Test
    void deveRetornarDetalhesIngresso() {
        IngressoProxy ingresso = new IngressoProxy(5001);

        assertEquals(Arrays.asList("City x United", "100.0"), ingresso.obterDetalhes());
    }

    @Test
    void deveRetonarQuantidadeDescontoIngresso() {
        Torcedor torcedor = new Torcedor("Pedro", true);
        IngressoProxy ingresso = new IngressoProxy(5002);

        assertEquals(25.0f, ingresso.obterdesconto(torcedor));
    }

    @Test
    void deveRetonarExcecaoUsuarioNaoAutorizadoConsultarDesconto() {
        try {
            Torcedor torcedor = new Torcedor("Pedro", false);
            IngressoProxy ingresso = new IngressoProxy(5001);

            ingresso.obterdesconto(torcedor);
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("Torcedor não autorizado", e.getMessage());
        }
    }
}