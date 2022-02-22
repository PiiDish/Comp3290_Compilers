// Comp3290 Assignment 1
// Token Word Token Class
// Author: Jason Disher
// Student No: c3185333
// Last Modified 19/7/2021

//package Lexer

public class Word extends Token
{
	protected String lexeme = "";

	//---------------------------------------------------------------------------
	//Pre-Condition: Strong Lexeme and TOKEN tag
	//Post_Condition: Contructs NEW Word inherited from TOKEN
	//---------------------------------------------------------------------------
	public Word(String s, int tag)
	{
		super(tag);
		lexeme = s;
	}
	//---------------------------------------------------------------------------
	//Pre-Condition: String lexeme, TOKEN tag, line no. and column no.
	//Post_Condition: Contructs NEW Word inherited from TOKEN
	//---------------------------------------------------------------------------
	public Word(String s, int tag, int i, int j)
	{
		super(tag, i, j);
		lexeme = s;
	}
	//---------------------------------------------------------------------------
	//Pre-Condition: NIL
	//Post_Condition: Returns String of Lexeme
	//---------------------------------------------------------------------------
	public String getLexeme()
	{
		return lexeme;
	}
	//---------------------------------------------------------------------------
	//Pre-Condition: NIL
	//Post_Condition: Output string representation of class
	//---------------------------------------------------------------------------
	public String toString()
	{
		StringBuilder output = new StringBuilder(Tag.TPRINT[tag]+lexeme);

		output.append(' ');
		if(output.length() < 66)
			while(output.length()%6 != 0)
				output.append(' ');

		return output.toString();//+" "+output.length();
	}
} 