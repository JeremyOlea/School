

class Prism extends Rectangle implements Cloneable, Resizeable{
	private Double height;

	@Override
	public void shrink(double val) {
		if(val > LIMIT) {
			super.shrink(val);
			height /= val;
		}
		else throw new SizeFactorException(LIMIT);
	}

	@Override
	public void enlarge(double val) {
		if(val > LIMIT) {
			super.enlarge(val);
			height *= val;	
		}
		else throw new SizeFactorException(LIMIT);
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		Prism obj = (Prism)super.clone();
		return obj;
	}

	public Prism(Double x, Double y, Double l, Double w, Double h, String  name, Colour colour)
	{
		super(x, y, l, w, name, colour);
		height = h;
	}
	
	public void  set_height(Double h)
	{
		height = h;
	}
	
	public Double  height() 
	{
		return height;
	}
	
	public Double  area()
	{
		return  2 * (length * width) + 2 * (height * length) + 2 * (height * width); 
	}
	
	public Double  perimeter()
	{
		return  width  * 2 + length * 2;
	}
	
	public Double  volume()
	{
		return  width  * length * height;
	}
	
	
	public String toString()
	{
		String s = super.toString()+ "\nHeight: " + height;
		return s;
	}
}