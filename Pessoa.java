
public class Pessoa {
	
	protected String nome;
	protected String cpf;
	
	public void nomear(String nome) {
		this.nome = nome;
	}
	
	public void inserirCPF(String cpf) {
		this.cpf = cpf;
	}
	
	 @Override
	    public String toString() {
	        return "{" +
	                "Nome = " + nome + 
	                ", CPF = " + cpf + '}';
	    }
	
}
