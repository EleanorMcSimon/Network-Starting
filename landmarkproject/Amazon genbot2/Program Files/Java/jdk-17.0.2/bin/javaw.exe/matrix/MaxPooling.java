package matrix;

public class MaxPooling {
	int lenght;
	int width;
	double[] argList;
	matrix past;
	public MaxPooling(int lenth, int width, matrix m) {
		lenght = lenth;
		this.width = width;
		past =m;
		
		int f = lenth/width;
		System.out.print(f);
		argList = new double[f];
	}
	public void MaxPooling() {
		int setter =0;
		int count = 0;
		double value =0.0;
		for(int x=0; x < argList.length; x++) {
		value= Math.max(value, past.row[x].weight);
		count++;
		if(count == width) {
			setter++;
			argList[setter]= value;
			value =0;
			count =0;
		}
		}
	}
}
