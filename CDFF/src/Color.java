public class Color
{
	private double l;
	private double a;
	private double b;

	Color(double l, double a, double b){
		this.l = l;
		this.a = a;
		this.b = b;
	}

	public void setL(double l)
	{
		this.l = l;
	}

	public double getL()
	{
		return l;
	}

	public void setA(double a)
	{
		this.a = a;
	}

	public double getA()
	{
		return a;
	}

	public void setB(double b)
	{
		this.b = b;
	}

	public double getB()
	{
		return b;
	}

	public static double colorDifference(Color color1, Color color2)
	{
		double dL = Math.pow((color1.l - color2.l),2);
		double da = Math.pow((color1.a - color2.a),2);
		double db = Math.pow((color1.b - color2.b),2);

		double dE76 = Math.sqrt(dL + da + db);
		return dE76;
	}
}
