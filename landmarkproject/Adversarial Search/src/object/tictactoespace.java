package object;

public class tictactoespace implements Cloneable {

private int top = 0;
private int left = 0;
private int bottem = 0;
private int right = 0;
private int righttop = 0;
private int lefttop = 0;
private int rightbottem = 0;
private int leftbottem = 0;
private int value = 0;
private boolean blank = true;
public void copy(tictactoespace s)
{
	this.adjectsent = s.adjectsent;
	this.blank = s.blank;
	this.xORO = s.xORO;
}
private int[] adjectsent = {top, left, bottem, right, righttop,lefttop,rightbottem,leftbottem};
private boolean xORO;
public boolean isblank(){return blank;}
public int adjectgetspace(int h){return adjectsent[h];}
public void setadjectspace(int h,int f) { adjectsent[h] = f;}
public void setvalue(int f) { value = f;}
public int getvalue() { return value;}
public void setxOrO(boolean f) { xORO = f; blank = false;}
public boolean getxOrO() { return xORO;}
}
