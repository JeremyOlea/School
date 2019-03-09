

class Rectangle extends Shape implements Cloneable
{
	protected Double width, length;

	public void shrink(double n) throws SizeFactorException {
		if(n < LIMIT) {
			throw new SizeFactorException(LIMIT);
		}
		width /= n;
		length /= n;
	}

	public void enlarge(double n) throws SizeFactorException {
		if(n < LIMIT) {
			throw new SizeFactorException(LIMIT);
		}
		width *= n;
		length *= n;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		Rectangle obj = (Rectangle)super.clone();
		return obj;
	}
	
	public Rectangle(Double x_origin, Double y_origin, Double newlength, Double newwidth, String  name, Colour colour){
		super(x_origin, y_origin, name, colour);
		length= newlength;
		width =newwidth;
	}
	
	protected void  set_length(Double newlength){
		length = newlength;
	}
	
	protected Double  get_length() {
		return length;
	}
	
	protected Double  area(){
		return  width *length;
	}
	
	protected Double  perimeter(){
		return  width  * 2 + length * 2;
	}
	
	protected Double  volume(){
		return 0.0;
	}
	
	@Override
	public String toString(){
		String s = super.toString()+ "\nWidth: " + width + "\nLength: " + length;
		return s;
	}
        	
}