package product;

public class Flat extends Footware {
	private String color;
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color=color;
	}
	

	
	@Override
	public String toString() {
		return super.toString()+"  Flat [color=" + color + "]";
	}
	public void getInput() {
		super.getInput();
		System.out.println("Color: ");
		this.setColor(sc.nextLine());
	}
	
	public boolean matchesWith(Flat other) {
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
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		return true;
	}
}

