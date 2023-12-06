package controller;

import Ai.minMax;
import object.ticTactoebord;
import object.tictactoespace;

public class controller {

	private boolean gameOver = false;
	private boolean turn = true;
	ticTactoebord b = new ticTactoebord();
public void setboard()
{
	b.setblankBord();
}
public boolean isgameover() {
	return gameOver;
}
public void Hasplayerwon()
{if(b.play1hasWon())
{
	System.out.println("Player 1 has won");
	gameOver =true;
}
else if(b.play2hasWon())
{
	System.out.println("Player 2 has won");
	gameOver =true;
}
else if(b.catsGame())
{
	System.out.println("no one has won");
	gameOver =true;	
}
}
public void print()
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
public int[] simulateturn() {
	if(gameOver != true)
	{
	minMax f = new minMax();
	int[] s = f.simulateturns(b);
	if(b.setspace(s[0], s[1], false))
		{
		//b.checkformatche();
		b.checkWin();
		Hasplayerwon();
		///();
		return s;
		}
	else {
		b.setcatsGame();
	}
	}
	return null;
}
public void Playerturn(int x, int y) {
	
	if(b.setspace(x, y, turn) == true)
	{
	//b.checkformatche();
		b.checkWin();
		Hasplayerwon();
		//print();
	
		
	
	
	}
	else 
	{
		System.out.println("guess erro");
	}

	//return b;
	
}
}
