package soal1;

abstract class Shape {

	protected String shapeName;
	
	public Shape(String shapeName) {
		this.shapeName = shapeName;
	}
	
	protected abstract double area();
	
	public String toString() {
		return this.shapeName;
	}
}