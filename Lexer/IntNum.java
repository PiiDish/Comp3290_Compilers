// Comp3290 Assignment 1
// Token Integer Literal Class
// Author: Jason Disher
// Student No: c3185333
// Last Modified 10/7/2021

//package lexer;

public class IntNum extends Token
{
	public final long value;

	//---------------------------------------------------------------------------
	//Pre-Condition: NIL
	//Post_Condition: Contructs NEW IntNum inherited from TOKEN
	//---------------------------------------------------------------------------
	public IntNum(long v)
	{
		super(Tag.TILIT);
		value = v;
	}
	//---------------------------------------------------------------------------
	//Pre-Condition: Long value
	//Post_Condition: Contructs NEW InrNum inherited from TOKEN
	//---------------------------------------------------------------------------
	public IntNum(long v, int i, int j)
	{
		super(Tag.TILIT, i, j);
		value = v;
	}
	//---------------------------------------------------------------------------
	//Pre-Condition: NIL
	//Post_Condition: Output string representation of class
	//---------------------------------------------------------------------------
	public String toString()
	{
		StringBuilder output = new StringBuilder(Tag.TPRINT[tag]+String.valueOf(value));

		output.append(' ');
		while(output.length()%6 != 0)
			output.append(' ');

		return output.toString();
	}

} 