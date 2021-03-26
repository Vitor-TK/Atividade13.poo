public class Gerente extends Empregado implements Bonus {

	private double salario;
	private double bonus;

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	@Override
	public double calcularBonus(double salario, double bonus) {
		double aux = salario * bonus;
		return aux;
	}

}
