

class Circle extends Shape implements Cloneable, Resizealbe
{
	private Double radius;

	@Override
	public void shrink(double val) {
		if(val > LIMIT) {
			radius /= val;
		}
		else throw new SizeFactorException(LIMIT);
	}

	@Override
	public void enlarge(double val) {
		if(val > LIMIT) {
			radius *= val;
		}
		else throw new SizeFactorException(LIMIT);
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		Circle obj = (Circle)super.clone();
		return obj;
	}

	Circle(Double x_origin, Double y_origin, Double newradius,  String name, Colour colour){
		super(x_origin, y_origin, name, colour);
		radius = newradius;
	}
	
	
	public void set_radius(Double newradius){
		radius = newradius;
	}
	
	public Double get_radius() {
		return radius;
	}
	
	public Double area() {
		return Math.PI * Math.pow(radius, 2);
	}
	
	public Double perimeter() {
		return 2 * Math.PI * radius;
	}
	
	public Double  volume(){
		return 0.0;
	}
	
	
	public String toString(){
		String s = super.toString()+ "\nRadius: " + radius;
		return s;
	}
         
}