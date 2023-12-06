package matrix;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class netruron implements Serializable  {
	 int outputname;
	 char chacterAssingment;
	 boolean output = false;;
	double weight = 0;
	double bi = 0.0;
	 double random[]; 
	 double oldweight =0.0;
	 double shortterm = 0.0;
	 double delate =1.0;
	 public void setrandom(double[] r) {
		 this.random = r;
	 }
	  public static Double transfer_derivative(Double output) {
	        return output * (1.0 - output);
	    }
	 public char getout()
	 {
		 return chacterAssingment;
	 }
	 protected void setcharcter(char a)
	 {
		 if(output) {
		 chacterAssingment =a;
		 }
	 }
	
	 public void setrelationsize(int a)
	 {HashSet<Double> hs = new HashSet<Double>();
		 random = new double[a];
		 Random r = new Random();
		 double hiddenvalue = 0.1;
		 while(hiddenvalue*a <= 1)
		 {
			
			 hiddenvalue=0.1*hiddenvalue;
		 }
		 for(int x = 0; x < a; x++)
		 {
				
			
			
				//hs.add(1 + (1 - 0) * r.nextDouble());
				hs.add(r.nextGaussian(1.0, hiddenvalue));
				
			  
		 
		 }
		 int in=0;
		 Iterator<Double> it = hs.iterator();
		 while(it.hasNext()) {
			 if(in >= random.length)
			 {
				 break;
			 }
			 random[in]=it.next();
			 in++;
		 }
	 }
	
	 public double addvoitoset(int a)
	 {
		 
		 
		 return (this.weight*random[a]);
	 }
	 public double desigmoidA() {
		 return this.sigmoid()*(1-this.sigmoid());
	 }
	 public double tanh(double weight2) {
		 return Math.tanh(weight2);
	 }
	 public double sigmoid()
	 {
		 return 1.0/( 1.0 + Math.pow(Math.E,(-1.00*weight)));
	 }
	 public void sigmoidA1() 
	 {
		 this.weight= this.sigmoid();
	 }
	 public void sigmoidA() 
	 {
		if(weight > 0.01) {
			
			this.weight=this.shortterm+this.weight;

		}
		else {
			this.weight = 0;
	
		}
	//	this.oldweight=this.oldweight+this.weight*0.01;
		
		this.weight= this.sigmoid();
		this.oldweight = this.weight*this.oldweight;

	 this.oldweight = this.oldweight*(this.sigmoid()*tanh(weight));
	
		
		 weight=(this.weight)*(this.tanh(this.oldweight)); 
		
		 this.shortterm = this.weight;
		weight=Math.pow(weight, 2);
	 }
	public void weightchange(double m)
	{
		
		weight =m;
	}
	public double getweight()
	{
		return weight;
	}
	
	public double erro(double wanted)
	{
		 double needed = wanted - weight;
		 return(needed);
	}
	 public Double getDelta() {
	        return this.delate;
	    }

	    public void setDelta(Double delta) {
	    	 this.delate = delta;
	    }
}
