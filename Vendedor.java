
public class Vendedor extends Empregado {

	private double totalDasVendas;
	private double comissao;
	
	public void inserirVendas(double vendas) {
		this.totalDasVendas = vendas;
	}

	public void inserirComissao(double comissao) {
		this.comissao = comissao;
	}

}
