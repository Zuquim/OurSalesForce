package model;

public abstract class Person {

	private String name;
	private String document;
	private int id;

	private static int instances = 0;

	public Person(String document) {
		this(document, "Shulambs");
	}

	public Person(String document, String name) {
		setDocumento(document);
		setNome(name);
	}

	public String getName() {
		return name;
	}

	public void setNome(String name) {
		this.name = name;
	}

	public String getDocument() {
		return document;
	}

	public void setDocumento(String documento) {
		this.document = documento;
	}

	public static int getInstances() {
		return instances;
	}

	public static void setInstances(int newInstance) {
		instances = newInstance;
	}

	public int getId() {
		return id;
	}

	public void setId() {
		this.id = getInstances();
		setInstances(getInstances() + 1);
	}

	@Override
	public String toString() {
		return "Id: " + getId() + "\nNome: " + getName() +
				"\nNúmero do documento: " + getDocument();
	}

}
