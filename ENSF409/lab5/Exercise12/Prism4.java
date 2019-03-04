

class Prism extends Rectangle implements Cloneable{
	private Double height;

	public void shrink(double n) throws SizeFactorException {
		if(n < LIMIT) {
			throw new SizeFactorException(LIMIT);
		}
		super.shrink(n);
		height /= n;
	}

	public void enlarge(double n) throws SizeFactorException {
		if(n < LIMIT) {
			throw new SizeFactorException(LIMIT);
		}
		super.enlarge(n);
		height /= n;
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