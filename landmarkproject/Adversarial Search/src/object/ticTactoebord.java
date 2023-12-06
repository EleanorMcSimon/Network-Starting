package object;

import java.lang.reflect.Array;

public class ticTactoebord implements Cloneable {
	boolean xHaswon = false;
	boolean oHaswon = false;
	boolean catsgame = false;
	private int value = 0;
	tictactoespace n = new tictactoespace();
	private tictactoespace[][] board = new tictactoespace[3][3];  
	public tictactoespace print(int x, int y) {
		return board[x][y];
	}
	public int getvalue()
	{
		return value;
	}
	public void setvalue(int n)
	{
		 value =n;
	}
	
	public void setblankBord() {
		xHaswon = false;
		oHaswon = false;
		for(int x =0; x < 3; x++)
		{
			for(int y =0; y< 3; y++)
			{
				this.board[x][y] = new tictactoespace();
				if(x == 1 && y==1) {
					board[x][y].setvalue(1);
				}
			}
		}
	}

	public void setcatsGame()
	{
		catsgame = true;	
	}
	public boolean catsGame() {
		
	return catsgame;
	}
	public boolean play1hasWon() {
		return xHaswon;
	}
	public boolean play2hasWon() {
		return oHaswon;
	}
	public void copy(ticTactoebord div)
	{
		for(int x =0; x < 3; x++)
		{
			for(int y =0; y < 3; y++)
			{
				this.board[x][y].copy(div.print(x, y));
			}
		}
	}
	public void clear()
	{
		for(int x =0; x < 3; x++)
		{
			for(int y =0; y < 3; y++)
			{
				for( int h =0; h< 8; h++)
				{
				this.board[x][y].setadjectspace(h, 0);
				}
			}
		}
	}
	public void checkWin()
	{
	
		for(int x =0; x < 3; x++)
		{	//System.out.print("called");
			for(int y =0; y < 3; y++)
			{
				for( int h =0; h< 8; h++)
				{
					if(board[x][y].adjectgetspace(h) >= 3)
					{
						System.out.print(board[x][y].adjectgetspace(h));
						 if(board[x][y].getxOrO()) {
							 System.out.print("winforx");
							 xHaswon = true;
						 }
						 else if(!board[x][y].getxOrO()) {
							 System.out.print("winforO");
							 oHaswon = true;
						 }
					}
				
					//board[x][y].setadjectspace(h, 0);
					}
				}
			
			}
		clear();
		}	
	public void checkstates(int x, int y, int number,int other, int to)
	{
		if(board[x+number][other+y].getxOrO() == board[x][y].getxOrO()&&board[x+number][other+y] != board[x][y])
		{
			int e = 0;
			e = board[x+number][other+y].adjectgetspace(to); 
			e++;
			board[x][y].setadjectspace(to, e);
		    board[x+number][y+other].setadjectspace(to, e);
		}
	}
	public void checkformatche() {
		for(int x =0; x < 3; x++)
		{int h = x+1;
		int p = x-1;
			for(int y =0; y < 3; y++)
			{
				
				int f = y-1;
				int a = y+1;	
				if(!board[x][y].isblank())
				{
		
				switch(x)
				{
				case 0:  checkstates(x,y,2,0,0);
				break;
				 case 1: checkstates(x,y,1,0,0);
				break;
				 case 2: checkstates(x,y,-1,0,0);
				 break;
				 }
				switch(y)
				{
				case 0:  checkstates(x,y,0,2,1);
				break;
				 case 1: checkstates(x,y,0,1,1);
				break;
				 case 2: checkstates(x,y,0,-1,1);
				 break;
				 }
					
				}
			if(x < 2&& y < 2)
			{
				 checkstates(x,y,1,1,3);
				
		
			}
			else if(x > 0 && y > 0)
			{
				checkstates(x,y,-1,-1,3);
				 checkstates(x,y,-1,-1,3);
				
			}
			if(x < 2&& y > 0)
			{
				 checkstates(x,y,1,-1,4);
				 
		
			}
			else if(x > 0 && y < 2)
			{
				checkstates(x,y,-1,1,4);
				checkstates(x,y,-1,1,4);
				
			}
					
			
			}
				
				
				}
			
		}
		
		
			
		
	public boolean setspace(int x, int y, boolean n) {
		if(board[x][y].isblank())
				{
			board[x][y].setxOrO(n);
			
		
			return true;
	}
		return false;
				}
		
		
		
		
	
}
