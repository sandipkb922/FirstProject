package product;

public class Shoe extends Footware {
	private String type;

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type=type;
	}

	public String toString() {
		return super.toString()+"   Shoe [type=" + type + "]";
	}
	public void getInput() {
		super.getInput();
		System.out.println("Type: ");
		this.setType(sc.nextLine());
	}
	
	public boolean matchesWith(Shoe other) {
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (size != other.size)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;		
	}
	
	
}