package network;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Stack;

import javax.imageio.stream.FileImageInputStream;

import matrix.matrix;
import training.training;



public class netwrok extends Thread{
	training tn = new training();
	Stack<String> wrong = new Stack<String>();
	char last ='z';
	int times = 9;
	ArrayList<matrix> out = new ArrayList<matrix>();
	int obsever =0;
	int baked =0;
	int amount =0;
	int count = 0;
	int correctrate =0;
	boolean gen = false;
	public boolean isgen() {
		return gen;
	}
	public void writeout() throws FileNotFoundException, IOException {
		 File myObj = new File("save.bin");
		 if(myObj.exists()) {
			 myObj.delete();
		 }
		FileOutputStream s = new FileOutputStream("save.bin");
		ObjectOutputStream on = new ObjectOutputStream(s);
		for(int x=0; x <this.out.size(); x++) {
			on.writeObject(out.get(x));;
		}
		on.close();
	}
	public void readin(int[] a) throws FileNotFoundException, IOException, ClassNotFoundException {
		 File myObj = new File("save.bin");
		if(myObj.exists()) {
			gen = true;
		FileInputStream st = new FileInputStream("save.bin");
		ObjectInputStream in = new ObjectInputStream(st);
		for(int x =0; x < a.length; x++) {
			matrix ik = (matrix) in.readObject();
		out.add(ik);
		}
		}
	}
public void networkgen(int[] a,char[] outs)
{
	
	boolean stopdoublegen= false;
boolean flip = true;

	for(int x =0; x < a.length; x++) {
		
		if(out.isEmpty())
		{
			matrix in=new matrix(a[x],null,false,true);
			in.inputegen();
			
			this.out.add(in);
			stopdoublegen= true;
		}else if(x+1 == a.length)
		{int fk = a[x];
			matrix outn=new matrix(a[x],this.out.get(this.out.size()-1),true,false);
		outn.softmaxlayer();
		outn.outputlayer(outs);
		this.out.add(outn);
		
		stopdoublegen = true;
		
		}else if(!stopdoublegen ) {
			matrix out=new matrix(a[x],this.out.get(this.out.size()-1),false,false);
			
			out.hiddenlayergen(flip);
			if(flip) {
				flip =false;
			}
			else if(!flip) {
				flip = true;
			}
			this.out.add(out);
		}
		stopdoublegen = false;
	}
}
public void caluaterate() {
	System.out.print("piv" + amount);
	System.out.print(correctrate);
	double a=Double.valueOf(this.correctrate)/Double.valueOf(count);
	System.out.println("rate of correct"+a);
}
@Override
public void run() {
	tn.settrainingvalue(10);
  if(baked < 50)
	{
  ArrayList<Double> out = new ArrayList<Double>();
try {
	out.clear();
	out.addAll(tn.nameread());
	train(out,tn.getanerse());
	if(baked%5 ==0) {
		for(int f =0; f < 5; f++) {
			out.clear();
			out.addAll(tn.nameread());
			this.obsereve(tn.nameread());
		}
	}
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	
	 
	 baked++;
	 
	}
  else
  {
		trainwithbakeset();
		baked =0;
  }
 //System.out.println(this.out.size());
  //train(out,tn.getanerse());
}
public void trainwithbakeset()
{ ArrayList<Double> out = new ArrayList<Double>();
/**
 * Train with 50 Characters ten times then 10 Letters 10 times
 */
	for(int x =0; x < 500; x++)
	{
		
		try {
			out.clear();
			out = tn.Bakedread();
			 train(out,tn.getanerse());
			 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	for(int y= 0; y < 100; y++) {
		try {
			out.clear();
			out = tn.read();
			 train(out,tn.getanerse());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
public void obsereve(ArrayList<Double> n) {
	/**
	 * Unsuperized training time
	 */
	for(int x =0; x < n.size(); x++)
	{
		if(out.get(0).sizeofoption() <= x) {
			break;
		}
		//System.out.print(out.get(0).sizeofoption());
		out.get(0).getn(x).weightchange(n.get(x));
		out.get(0).getn(x).sigmoid();
	}
	for(int y=1; y < out.size(); y++)
	{

			out.get(y).run();
		

	}
}
public void train(ArrayList<Double> n, char a)
{


	//System.out.print(n.size());
for(int x =0; x < n.size(); x++)
{
	if(out.get(0).sizeofoption() <= x) {
		break;
	}
	//System.out.print(out.get(0).sizeofoption());
	out.get(0).getn(x).weightchange(n.get(x));
	out.get(0).getn(x).sigmoidA();
}
for(int y=1; y < out.size(); y++)
{

		out.get(y).run();
	

}
printeguess(a);
System.out.println("Answer"+a);
out.get(out.size()-1).comparout(a);



}

	
public void erros() {
	for(String x: this.wrong) {
		System.out.println(x);
	}
}
public void printeguess(char a)
{
	double h = 0.0;
	char f='A';
	
for(int x =0; x < out.get(out.size()-1).sizeofoption(); x++)
{	
if(out.get(out.size()-1).getn(x).getweight() >=h)
	{
	System.out.println("outpute " +out.get(out.size()-1).getn(x).getout() +"Weight "+ out.get(out.size()-1).getn(x).getweight());
	f = out.get(out.size()-1).getn(x).getout();
	h = out.get(out.size()-1).getn(x).getweight();
	}
	
		
	
}
System.out.print(f);
if(Character.compare(this.last, f) == 0) {
	this.times--;
}
if(Character.compare(this.last, f) !=0) {
	if(times <=0) {
		times = 10;
		this.last = f;
	}
	else {
		amount++;
		System.out.println("piv");
		times=5;
		
		this.last = f;
	}
}
count++;
if(Character.compare(a,f) == 0)
{
	correctrate++;
}
else {
	this.wrong.push(tn.url());
}

}	

}
