

class Colour implements Cloneable
{
    private String colour;
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		Colour obj = (Colour)super.clone();
		return obj;
	}
	
	public Colour(String s) {
		colour = new String(s);
	}
	
    public void setColour(String newColour){
    	colour = newColour;
    }
    
	@Override
	public String toString(){
		return colour;
	}

}
