// Comp3290 Assignment 1
// Token Undefined Token Class
// Author: Jason Disher
// Student No: c3185333
// Last Modified 23/7/2021

//package Lexer

public class Undef extends Word
{
	private final String message;

	//---------------------------------------------------------------------------
	//Pre-Condition: String lexeme, String error message, TOKEN Tag
	//Post_Condition: Contructs NEW Undef inherited from WORD
	//---------------------------------------------------------------------------
	public Undef(String s, String m, int tag)
	{
		super(s, tag);
		message = m;
	}
	//---------------------------------------------------------------------------
	//Pre-Condition: String lexeme, String error message, TOKEN Tag, lineno and column no.
	//Post_Condition: Contructs NEW Undef inherited from WORD
	//---------------------------------------------------------------------------
	public Undef(String s, String m, int tag, int i, int j)
	{
		super(s, tag, i, j);
		message = m;
	}
	//---------------------------------------------------------------------------
	//Pre-Condition: NIL
	//Post_Condition: Output string representation of class
	//---------------------------------------------------------------------------
	public String toString()
	{
		StringBuilder output = new StringBuilder(Tag.TPRINT[tag]+"\nLexical ERROR? "+lexeme+message+" Line "+lineNo+" Column "+colNo);

		/*if(output.length() >= 72)
			output.insert(72, '\n');
		if((output.length()) > 138)
			output.insert(138, '\n');
		if((output.length()) > 204)
			output.insert(204, '\n');*/
		output.append(' ');

		//while(output.length()%6 != 0)
		//	output.append(' ');

		return output.toString();
	}
} 