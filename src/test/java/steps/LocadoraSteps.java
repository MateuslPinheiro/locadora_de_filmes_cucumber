package steps;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import entidades.NotaAluguel;
import org.junit.Assert;
import servicos.AluguelService;
import entidades.Filme;

import java.util.Calendar;
import java.util.Date;

public class LocadoraSteps {
    private AluguelService aluguel = new AluguelService();
    private Filme filme;
    private NotaAluguel nota;
    @Dado("^um filme com estoque de (\\d+) unidades$")
    public void umFilmeComEstoqueDeUnidades(int arg1) throws Throwable {
        filme = new Filme();
        filme.setEstoque(arg1);
    }

    @Dado("^que o preço do aluguel seja R\\$ (\\d+)$")
    public void queOPreçoDoAluguelSejaR$(int arg1) throws Throwable {
        filme.setAluguel(arg1);
    }

    @Quando("^alugar$")
    public void alugar() throws Throwable {
        nota = aluguel.alugar(filme);

    }

    @Então("^o preço do aluguel será R\\$ (\\d+)$")
    public void oPreçoDoAluguelSeráR$(int arg1) throws Throwable {
        Assert.assertEquals(arg1, nota.getPreco());

    }

    @Então("^a data de entrega será no dia seguinte$")
    public void aDataDeEntregaSeráNoDiaSeguinte() throws Throwable {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 1);

        Date dataRetorno = nota.getDataEntrega();
        Calendar calRetorno = Calendar.getInstance();
        calRetorno.setTime(dataRetorno);

        Assert.assertEquals(cal.get(Calendar.DAY_OF_MONTH), calRetorno.get(Calendar.DAY_OF_MONTH));
        Assert.assertEquals(cal.get(Calendar.MONTH), calRetorno.get(Calendar.MONTH));
        Assert.assertEquals(cal.get(Calendar.YEAR), calRetorno.get(Calendar.YEAR));
    }

    @Então("^o estoque do filme será (\\d+) unidade$")
    public void oEstoqueDoFilmeSeráUnidade(int arg1) throws Throwable {
        Assert.assertEquals(arg1, filme.getEstoque());

    }
}
