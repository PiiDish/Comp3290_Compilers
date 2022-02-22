// Comp3290 Assignment 1
// Token Super Class
// Author: Jason Disher
// Student No: c3185333
// Last Modified 10/7/2021

//package lexer;

public class Token
{
	public final int tag;
	protected int lineNo;
	protected int colNo;

	//---------------------------------------------------------------------------
	//Pre-Condition: NIL
	//Post_Condition: Contructs NEW TOKEN
	//---------------------------------------------------------------------------
	public Token(int tokenNo)
	{
		tag = tokenNo;
		lineNo = 0;
		colNo = 0;
	}
	//---------------------------------------------------------------------------
	//Pre-Condition: Interger of TOKEN tag line no. and column no.
	//Post_Condition: Contructs NEW TOKEN
	//---------------------------------------------------------------------------
	public Token(int tokenNo, int i, int j)
	{
		tag = tokenNo;
		lineNo = i;
		colNo = j;
	}
	//---------------------------------------------------------------------------
	//Pre-Condition: TOKEN line no. and column no.
	//Post_Condition: Contructs NEW TOKEN
	//---------------------------------------------------------------------------
	public Token(Token tok, int i, int j)
	{
		tag = tok.tag;
		lineNo = i;
		colNo = j;
	}
	//---------------------------------------------------------------------------
	//Pre-Condition: Integers line no. i and column no. j 
	//Post_Condition: Sets Line and Column Numbers
	//---------------------------------------------------------------------------
	public void setLoc(int i, int j)
	{
		lineNo = i;
		colNo = j;
	}
	//---------------------------------------------------------------------------
	//Pre-Condition: NIL
	//Post_Condition: Returns Line Number
	//---------------------------------------------------------------------------
	public int getLine()
	{
		return lineNo;
	}
	//---------------------------------------------------------------------------
	//Pre-Condition: NIL
	//Post_Condition: Returns Column Number
	//---------------------------------------------------------------------------
	public int getCol()
	{
		return colNo;
	}
	//---------------------------------------------------------------------------
	//Pre-Condition: NIL
	//Post_Condition: Output string representation of class
	//---------------------------------------------------------------------------
	public String toString()
	{
		return Tag.TPRINT[tag];
	}
}