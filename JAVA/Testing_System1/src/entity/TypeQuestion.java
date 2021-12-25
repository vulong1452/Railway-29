package entity;

public class TypeQuestion {
	public int id;
	public TypeName name;

	public enum TypeName {
	Essay, Multiple_Choice
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TypeName getName() {
		return name;
	}

	public void setName(TypeName name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "TypeQuestion [id=" + id + ", name=" + name + "]";
	}
	
}
