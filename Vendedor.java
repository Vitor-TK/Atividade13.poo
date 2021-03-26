public class Vendedor extends Empregado implements Salario {

	private double totalDasVendas;
	private double comissao;

	public double getTotalDasVendas() {
		return totalDasVendas;
	}

	public void setTotalDasVendas(double totalDasVendas) {
		this.totalDasVendas = totalDasVendas;
	}

	public double getComissao() {
		return comissao;
	}

	public void setComissao(double comissao) {
		this.comissao = comissao;
	}

	@Override
	public double calcularSalario(double totalDeVendas, double comissao) {
		double aux = totalDeVendas * comissao;
		return aux;
	}

}
