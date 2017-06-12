package model;

public abstract class Pessoa {

	private String nome;
	private String documento;
	private int id;

	private static int instancias = 0;

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

	public static int getInstancias() {
		return instancias;
	}

	public static void setInstancias(int novaInstacia) {
		instancias = novaInstacia;
	}

	public int getId() {
		return id;
	}

	public void setId() {
		this.id = getInstancias();
		setInstancias(getInstancias() + 1);
	}

	@Override
	public String toString() {
		return "Id: " + getId() + "\nNome: " + getNome() + "\nNúmero do documento: " + getDocumento();
	}

}
