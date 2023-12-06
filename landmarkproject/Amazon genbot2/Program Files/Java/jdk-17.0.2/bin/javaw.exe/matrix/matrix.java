package matrix;

import java.io.Serializable;
import java.util.Arrays;

public class matrix  implements Serializable {
	boolean output;
	boolean inpute;
	int nextSize;
	matrix last;
	double change[];
	double runchage[];
	netruron row[];
 int count =0;
	public matrix(int size, matrix before, boolean out, boolean in) {
		row = new netruron[size];
		last = before;
		output = out;
		inpute = in;
		change = new double[row.length];
		runchage = new double[row.length];
	}
	public boolean isout(){
		return output;
	}
	public int sizeofoption()
	{
		return row.length;
	}
	public netruron getn(int x) {
		return row[x];
	}
	public void clear()
	{
for(int x =0; x < row.length; x++) {
			
			
			row[x].weight = 0.0;

		}	
	}
	public void run()

	{
		//weightset();
		
		for(int x =0; x < row.length; x++) {
		
			//row[x].weight =  row[x].weight;
			row[x].sigmoidA1();

		}
		
		
	}
	private double softmax(double input, double[] neuronValues) {
	
	    double total = Arrays.stream(neuronValues).map(Math::exp).sum();
	    return Math.exp(input) / total;
	}
	public void softmaxlayer() {
		this.rowreaship();
		
		for(int x =0; x < this.row.length; x++) {
			double[] n = new double[this.last.row.length];
			for(int y =0; y < n.length; y++) {
				this.last.row[y].addvoitoset(x);
			}
			row[x]=new netruron();
			row[x].weight = this.softmax(this.last.row[x].weight,n);
		}
	}
	public void rowreaship(){
		for(int x = 0; x <last.row.length; x++) {
			
			last.row[x].setrelationsize(last.row.length);
		}
	}
	
	public void outputlayer(char[] f) {
		//System.out.print(row.length);
		if(output) {
		for(int x =0; x<this.row.length; x++)
		{
			row[x].output = true;
			row[x].setcharcter(f[x]);
		}
		}
	}
	public void change()
	{
	for(int x=0; x < row.length; x++)
	{
		row[x].weight= (row[x].weight*0.01)+change[x];
		
		change[x] =0;
		
	}
	
	if(last != null)
	{
		last.change();
	}
	}
	public void getchange()
	{
		for(int x =0; x < runchage.length; x++)
		{
			
		change[x] = change[x]+ runchage[x]; 
		}
	}
	public void hiddenoutpute(double[] change) 
	{
	if(last != null) {
		
	
	double[] changeinoutpute = new double[row.length];
	for(int y =0; y < change.length; y++)
	{
		for(int x =0; x <changeinoutpute.length; x++)
		{
			if(y < row[x].random.length && y <last.row.length )
			{
				
		changeinoutpute[x] = (row[x].random[y]*change[y])+ row[x].desigmoidA();
			}
			
		}
	
	}	
	for(int z=0; z < changeinoutpute.length; z++)
	{
		this.runchage[z] = this.runchage[z] + (changeinoutpute[z]);
	}
	this.getchange();
	if(last != null && last.sizeofoption() !=0)
	{
		last.hiddenoutpute(this.runchage);
	}
	}
	}
	public void comparout(char c) 
	{
		count++;
	double change[] = new double[row.length];
		for(int x=0; x < row.length; x++)
		{
			if(Character.compare(row[x].chacterAssingment, c) ==0&& row[x].weight <=1.00) {
			
			//double h=row[x].desigmoidA()*(1.00 - row[x].weight);
				//change[x]=	h*10;
				
				change[x] = -1*Math.log(row[x].desigmoidA());
				//System.out.println(change[x]);
			}
			else if(Character.compare(row[x].chacterAssingment,c) >0 && row[x].weight > 0){
				double h=(0.0 - row[x].weight);
				//change[x]=	h*10;
				change[x] = h;
				//System.out.println(change[x]);
			}
		}
		for(int i =0; i < change.length; i++)
		{
	
		
	   this.change[i] =   this.change[i]+ change[i];
		
	
		}
	
		this.last.hiddenoutpute(change);	
		
		
		if(count > 9) {
			System.out.println("Learning");
			this.change();
			count =0;
		}
		
	}
	public void inputegen() {
		if(inpute == true)
		{
			System.out.print("In gen");
			System.out.print(row.length);
		for(int x =0; x < row.length; x++)
		{
			row[x]=new netruron();
			row[x].weight = 0.0;
		}
		}
	}
	public void weightset() {
		for(int x =0; x < row.length; x++)
		{
			if(!inpute) {
			double weight =0.0;
			
		for(int y =0; y < last.row.length; y++)
		{
		if(x < last.row[y].random.length) {
			
		
			weight = weight+ last.row[y].addvoitoset(x);
		}
		}
		
		
		row[x].weight = weight;
		weight =0;
			}
			}
		
		
	}
	public void hiddenlayergen(boolean f) 
	{MaxPooling m = new MaxPooling(last.sizeofoption(), 2, last);
	rowreaship();
	double weight =0.0;
		if(!output ) {
			if(f) {
				
			
			m.MaxPooling();
			//System.out.println(m.argList.length);
			}
	if(!f) {	
	for(int x =0; x < row.length; x++)
	{
		row[x]=new netruron();
	

		for(int y =0; y < last.row.length; y++)
	{
		weight = weight* last.row[y].addvoitoset(x);
	}
		row[x].weight =weight; 
		weight =0;
	}
	}
if(f) {
		
		for(int x =0; x < m.argList.length; x++)
		{
	
		row[x]=new netruron();
		
		double[] r= {m.argList[x]};

	this.row[x].random = r;
	
		weight= weight +  m.argList[x];
		
			
		
		row[x].weight = weight;
		weight =0;
		count++;
	}
}
	}
	
		
	
	
	
	
		 

	}
	}
	
	

