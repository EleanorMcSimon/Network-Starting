package Ai;

import java.util.Stack;

import object.ticTactoebord;



public class minMax implements Cloneable {
	ticTactoebord div = new ticTactoebord();
	Stack<int[]> move = new Stack<>();
	int max = 0;
	Stack<ticTactoebord> minMaxStack = new Stack<>();
	public int[] simulateturns(ticTactoebord bord) {
		//move.clear();
		bord.setvalue(getvalues(bord));
	//minMax(bord);
		div = new ticTactoebord();
		div.setblankBord();
		
		bord.setvalue(getvalues(bord));
		div.copy(bord);
		//print(div);
		div.checkWin();
		 firstLoopSim();
	//	minMaxStack.push(bord);
		 checkForloss();
		 minMaxStack.clear();
		// move.pop();
		 int[] f = move.peek();

		 
		 System.out.print(move.size());
		 System.out.print(f[0]+" "+ f[1]);
		 return move.peek();
	}
	public void checkForloss()
	{
		for(int h = 0; h < move.size();h++){
			// end = false;
			
			for(int x = 0;  x < 3; x++)
			{
				for(int y =0; y < 3; y++)
				{
					ticTactoebord  n = new ticTactoebord();
					n.setblankBord();
					
					n.copy(minMaxStack.peek());
				
					n.checkWin();
					if(n.setspace(x, y, true))
					{
						n.checkformatche();
					
						//n.setvalue(getvalues(n));
						n.checkWin();
						print(n);
						
						if(n.play1hasWon())
						{
							System.out.print("badStates");
							print(n);
							//System.out.print(move.peek());
							move.pop();
							
						//	end = true;
							minMaxStack.pop();
							if(minMaxStack.size() == 1 )
							{
								ansersim();
								
							}
							
							//break;
							//n.setblankBord();
						}
					}
				
				n.setblankBord();
				}
				}
			
		//	minMaxStack.pop(); 
			
		}
	}
	public void ansersim()
	{
		for(int x = 0;  x < 3; x++)
		{
			for(int y =0; y < 3; y++)
			{
				ticTactoebord  fx = new ticTactoebord();
				//fx = div;
				fx.setblankBord();
				fx.copy(div);
				if(fx.setspace(x, y, false))
				{
					fx.checkformatche();
					 fx.setvalue(getvalues(fx)); 
					 fx.checkWin();
				fx.clear();
					 int array[] = {x,y};
					 minMaxStack.push(fx);
					// fx.setblankBord();
					// fx.setblankBord();
					 move.push(array);
				}
			}}
			
	}
	public void firstLoopSim() {
		//move.clear();
		
		for(int x = 0;  x < 3; x++)
		{
			for(int y =0; y < 3; y++)
			{
				ticTactoebord  fx = new ticTactoebord();
				//fx = div;
				fx.setblankBord();
				fx.copy(div);
				//print(fx);
			//fx.checkWin();
				fx.clear();
				if(fx.setspace(x, y, false))
				{
					fx.checkformatche();
					 fx.setvalue(getvalues(fx)); 
					 fx.checkWin();
					 if(fx.play2hasWon())
					 {
						 fx.setvalue(100);
					 }
					 if(fx.getvalue() >= div.getvalue())
					 {
					//print(fx);
						div.checkWin();
						;
						 int array[] = {x,y};
						 minMaxStack.push(fx);
						// fx.setblankBord();
						// fx.setblankBord();
						 move.push(array);
						 
						 
				}
				}
				else
				{
					fx.checkWin();
				}
				
			}
		}
	}
	public void addbasestack(ticTactoebord n) {
		div = n;
	}
	public int getvalues(ticTactoebord hero)
	{
		//hero.checkformatche();
		int value = 0;
		for(int y =0; y <3; y++)
		{
			for(int x =0; x <3; x++)
			{	
				for( int h =0; h< 8; h++)
				{
					if(!hero.print(x, y).getxOrO())
					{
					  switch (hero.print(x, y).adjectgetspace(h)) {
					  case 1: value++;
					  break; 
					  case 2: value=value+2;
					  break;  
					  }
					}
					  else if(hero.print(x, y).getxOrO()) {
						  switch (hero.print(x, y).adjectgetspace(h)) {
						  case 1: value--;
						  break; 
						  case 2: value=value-3;
						  break;
						  case 3: value= value-200;
						  }
				
					  }
					  
					  }
					}
			}
		
		return value;
	}
	
	public void print(ticTactoebord b)
	{
		for(int f =0; f < 3; f++)
		{
			for(int h =0; h< 3; h++)
			{
				if(b.print(f,h).isblank());
				{
					System.out.print("  ");	
				}
				if(! b.print(f,h).isblank()){
					if(b.print(f,h).getxOrO())
					{
						System.out.print( "X");
						
					}
					else if(!b.print(f,h).getxOrO())
					{
						System.out.print("O");	
					}
				}
			}
			System.out.println("");	
		}
	}
}
