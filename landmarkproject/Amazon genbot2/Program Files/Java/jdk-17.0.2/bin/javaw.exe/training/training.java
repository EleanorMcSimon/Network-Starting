package training;
import java.awt.image.BufferedImage;
import java.io.File;  
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import javax.imageio.ImageIO;



public class training {
	 char anser;
	 String url;
	 String answer ="";
	 int slice = 0;
	 boolean finished =false;
	 int silefrom = 0;
	 int it = 0;
	 int it2 = 0;
	int[] f;
	int[] n;
	 public String url() {
		 if(this.slice >= this.answer.length())
		 {
			 return ""+this.anser;
		 }
		 else
		 {
			 return url;
		 }
	 }
public char getanerse()
{return anser;}
private int[] decimalToBinary(int num)
{
    // Creating and assigning binary array size
    int[] binary = new int[35];
    int id = 0;

    // Number should be positive
    while (num > 0) {
        binary[id++] = num % 2;
        num = num / 2;
    }
return binary;
   
}
public ArrayList<Double> Bakedread() throws FileNotFoundException
{
	ArrayList<Double> d = new ArrayList<Double>();
	Scanner sc = new Scanner(new File("C:\\Users\\ellies\\Downloads\\archive (3)\\letter-recognition.csv"));  
	//Scanner ansers = new Scanner(new File("C:\\Users\\ellies\\Downloads\\archive\\Arabic Handwritten Digits Dataset CSV\\csvTestLabel 10k x 1.csv"));
	//FileInputStream ansers=new FileInputStream(new File("C:\\Users\\ellies\\Downloads\\archive\\Arabic Handwritten Digits Dataset CSV\\csvTestLabel 10k x 1.csv"));  
	
	//evaluating cell type   
	sc.useDelimiter(",");		
	int t =0;
	int randomValue = ThreadLocalRandom.current().nextInt(1, 50);

	while(t < randomValue)
	{
	sc.nextLine();	
	//ansers.nextLine();
	t++;
	}
String f = sc.nextLine();
anser	= f.charAt(0);
for(int x =1; x < f.length(); x++)
{
int[] a=this.decimalToBinary(Character.getNumericValue(f.charAt(x)));
System.out.print(a.length);
for(int y=0; y < a.length; y++) {
	
	d.add(Double.valueOf(a[y]));
}
	
}

//System.out.print(d.size());
//anser = Integer.parseInt(ansers.nextLine());
sc.close();

		return d;
}

public  ArrayList<Double> nameread() throws IOException{
	//System.out.println("named");
	this.slice++;
	if(this.slice >= this.answer.length() ) {
		this.slice =0;
		this.silefrom =10;
		
		return this.altread();
	}else
	{
		if(Character.isDigit(this.answer.charAt(this.slice))) {
			
		return this.nextc();
		}else
		{
			this.slice =0;
			this.silefrom =10;
			
			return this.altread();
		}
	}
}
private ArrayList<Double> nextc() throws IOException {
	ArrayList<Double> d = new ArrayList<Double>();
	String trainingpath = "C:\\Users\\\\ellies\\Downloads\\archive (5)\\train_v2\\train\\"+ url;
	BufferedImage img;
	
	int discarded = 0;
	int width = this.silefrom+20;
	img = ImageIO.read(new File(trainingpath));
	for (int y = 0; y < img.getHeight(); y++) {
	    for (int x =silefrom; x < img.getWidth(); x++) {
	    
	    	if(img.getRGB(x, y)> 0) {
	    	int[] a= decimalToBinary(img.getRGB(x, y));
	    	boolean discard = true;
	    	for(int z=0; z < a.length; y++) {
	    		if(a[z] == 1)
	    		{
	    			discard =false;
	    		}
	    		
	    	}
	    	if(!discard) {
	    	for(int z0 =0; z0 < a.length; z0++) {
	    		//System.out.print(a[z0]);
	    		d.add(Double.valueOf(a[z0]));
	    	}
	    	}
	    	else {
	    		discarded++;

	    	}
	    	 
	    	}
	    	d.add(Double.valueOf(img.getRGB(x, y)));
	    }
	   
	    }
	this.anser=this.answer.charAt(this.slice);
	this.silefrom= this.silefrom+20;
	return d; 
}
private ArrayList<Double> altread() throws IOException
{
	ArrayList<Double> d = new ArrayList<Double>();
Scanner sc = new Scanner(new File("C:\\Users\\ellies\\Downloads\\archive (5)\\written_name_train_v2.csv")); 
sc.useDelimiter(",");

int t =0;
while(t < n[it2])
{
sc.nextLine();	

t++;
}
this.url = sc.next();
this.answer=sc.next();
String trainingpath = "C:\\Users\\ellies\\Downloads\\archive (5)\\train_v2\\train\\"+ url;
BufferedImage img;
int width = this.silefrom+20;
img = ImageIO.read(new File(trainingpath));
int discarded =0;
if(img.getHeight() == 0) {
	//System.out.print("reload");
	this.altread();
}
//System.out.print(img.getHeight());
for (int y = 0; y < img.getHeight(); y++) {
    for (int x =silefrom; x < img.getWidth(); x++) {
    
    	if(img.getRGB(x, y)> 0) {
    	int[] a= decimalToBinary(img.getRGB(x, y));
    	boolean discard = true;
    	for(int z=0; z < a.length; y++) {
    		if(a[z] == 1)
    		{
    			discard =false;
    		}
    		
    	}
    	if(!discard) {
    	for(int z0 =0; z0 < a.length; z0++) {
    		//System.out.print(a[z0]);
    		d.add(Double.valueOf(a[z0]));
    	}
    	}
    	else {
    		discarded++;

    	}
    	 
    	}
    	d.add(Double.valueOf(img.getRGB(x, y)));
    }
   
    }
this.anser=this.answer.charAt(this.slice);
this.silefrom= this.silefrom+20;
it2++;
if(n.length >= it2) {
	it2 =0;
}
return d; 
}
public void settrainingvalue(int random) {
this.f = new int[random];
this.n = new int[random];
	for(int x =0; x < random; x++) {
		f[x] = ThreadLocalRandom.current().nextInt(0, 1000);
	}
	for(int y =0; y < random; y++) {
		n[y] = ThreadLocalRandom.current().nextInt(0, 330962);
	}
}

	public ArrayList<Double> read() throws FileNotFoundException
	{
		ArrayList<Double> d = new ArrayList<Double>();
		Scanner sc = new Scanner(new File("C:\\Users\\ellies\\Downloads\\archive (3)\\letter-recognition.csv"));  
	
		//FileInputStream ansers=new FileInputStream(new File("C:\\Users\\ellies\\Downloads\\archive\\Arabic Handwritten Digits Dataset CSV\\csvTestLabel 10k x 1.csv"));  
		
		//evaluating cell type   
		sc.useDelimiter(",");		
		int t =0;
		
		
		while(t < f[it])
		{
		sc.nextLine();	
		
		t++;
		}
		
	String f = sc.nextLine();
	anser= f.charAt(0);

	for(int x =1; x < f.length(); x++)
	{///System.out.print(f.charAt(x));
	int[] a=this.decimalToBinary(Character.getNumericValue(f.charAt(x)));
	for(int y=0; y < a.length; y++) {
		
		d.add(Double.valueOf(a[y]));
	}
		
	}		
	this.it++;
	if(it >= this.f.length) {
		it =0;
	}
	
			return d;
	}


}
