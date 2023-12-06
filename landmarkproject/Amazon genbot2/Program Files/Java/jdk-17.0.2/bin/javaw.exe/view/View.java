package view;

import java.io.IOException;

import network.netwrok;

public class View {

	public static void main(String[] args) {
		System.out.println("Starting");
		// TODO Auto-generated method stub
		netwrok net = new netwrok();
		int[] a = {2000,1000,1000,500,500,250,250,125,125,26};
		
		char[] o = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	try {
		net.readin(a);
		
	} catch (ClassNotFoundException | IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
		if(!net.isgen()) {
			net.networkgen(a, o);	
		}
		
	
	for(int x =0; x < 500; x++)
	{
	
	net.run();
	}
	net.erros();
	net.caluaterate();
	try {
		net.writeout();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
