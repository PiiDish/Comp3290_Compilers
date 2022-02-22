// Comp3290 Assignment 1
// Token Real Token Class
// Author: Jason Disher
// Student No: c3185333
// Last Modified 19/7/2021

//package Lexer

public class Real extends Token
{
	public final double value;

	//---------------------------------------------------------------------------
	//Pre-Condition: NIL
	//Post_Condition: Contructs NEW Real inherited from TOKEN
	//---------------------------------------------------------------------------
	public Real(double v)
	{
		super(Tag.TFLIT);
		value = v;
	}
	//---------------------------------------------------------------------------
	//Pre-Condition: Double value line no. and column no.
	//Post_Condition: Contructs NEW Real inherited from TOKEN
	//---------------------------------------------------------------------------
	public Real(double v, int i, int j)
	{
		super(Tag.TFLIT, i, j);
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