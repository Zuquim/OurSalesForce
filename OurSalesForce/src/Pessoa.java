
public abstract class Pessoa {

	private String nome;
	private String documento;

	public Pessoa(String documento) {
		this(documento, "Shulambs");
	}

	public Pessoa(String documento, String nome) {
		setDocumento(documento);
		setNome(nome);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	@Override
	public String toString() {
		return "Nome: " + getNome() + "\nNúmero do documento: " + getDocumento();
	}

}
