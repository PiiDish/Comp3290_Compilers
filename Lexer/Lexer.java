// Comp3290 Assignment 1
// Lexer Class
// Author: Jason Disher
// Student No: c3185333
// Last Modified 8/8/2021

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.StringBuilder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

//package Lexer

public class Lexer
{
	private int lineNo;
	private int colNo;
	private BufferedReader br;
	private char peek = ' ';
	private StringBuilder illegal;
	private Hashtable<String, Token> keywords;
	private final double MAXDOUBLE = 9223372037000000000.0;

	//---------------------------------------------------------------------------
	//Pre-Condition: Filename
	//Post_Condition: Returns Lexer object ready to produce TOKENS
	//---------------------------------------------------------------------------
	public Lexer(String fileName)
	{
		keywords = new Hashtable<String, Token>();
		lineNo = 1;
		colNo = 0;
		illegal = new StringBuilder();

		keywords.put("cd21", new Token(Tag.TCD21));
		keywords.put("constants", new Token(Tag.TCONS));
		keywords.put("types", new Token(Tag.TTYPS));
		keywords.put("is", new Token(Tag.TTTIS));
		keywords.put("arrays", new Token(Tag.TARRS));
		keywords.put("main", new Token(Tag.TMAIN)); 
		keywords.put("begin", new Token(Tag.TBEGN));
		keywords.put("end", new Token(Tag.TTEND));
		keywords.put("array", new Token(Tag.TARAY)); 
		keywords.put("of", new Token(Tag.TTTOF)); 
		keywords.put("func", new Token(Tag.TFUNC)); 
		keywords.put("void", new Token(Tag.TVOID)); 
		keywords.put("const", new Token(Tag.TCNST)); 
		keywords.put("integer", new Token(Tag.TINTG)); 
		keywords.put("real", new Token(Tag.TREAL)); 
		keywords.put("boolean", new Token(Tag.TBOOL)); 
		keywords.put("for", new Token(Tag.TTFOR)); 
		keywords.put("repeat", new Token(Tag.TREPT)); 
		keywords.put("until", new Token(Tag.TUNTL)); 
		keywords.put("if", new Token(Tag.TIFTH)); 
		keywords.put("else", new Token(Tag.TELSE)); 
		keywords.put("in", new Token(Tag.TINPT));
		keywords.put("out", new Token(Tag.TOUTP)); 
		keywords.put("line", new Token(Tag.TOUTL)); 
		keywords.put("return", new Token(Tag.TRETN)); 
		keywords.put("not", new Token(Tag.TNOTT)); 
		keywords.put("and", new Token(Tag.TTAND)); 
		keywords.put("or", new Token(Tag.TTTOR));
		keywords.put("xor", new Token(Tag.TTXOR)); 
		keywords.put("true", new Token(Tag.TTRUE)); 
		keywords.put("false", new Token(Tag.TFALS));

		try 
		{

      		br = new BufferedReader(new FileReader(new File(fileName)));
      	}
      	catch(FileNotFoundException fnfe)
		{
			System.out.println("FILE DOES NOT EXSIST...");
			System.exit(1);
		}
	}
	//---------------------------------------------------------------------------
	//Pre-Condition: NIL
	//Post_Condition: adds keyword TOKENS to hashtable
	//---------------------------------------------------------------------------
	private void reserve(String key, Token w)
	{
		keywords.put(key, w);
	}
	//---------------------------------------------------------------------------
	//Pre-Condition: NIL
	//Post_Condition: Moves look ahead character one character. Adds column No. Adds line No. End of file
	//---------------------------------------------------------------------------
	private void readChar() throws IOException
	{
		int charInt = br.read();

		if(charInt == -1)
			charInt=0;
		else if(charInt == 10) //NewLine 
		{
			colNo = 0; //Carridge return comes before line feed No point catching it
			lineNo++;
		}
		else if(charInt == 9)
			colNo += 4;	//Tab size
		else
			colNo++;

		peek = (char)charInt;
	}
	//---------------------------------------------------------------------------
	//Pre-Condition: Char to test against next look a head
	//Post_Condition: Returns boolean
	//---------------------------------------------------------------------------
	private boolean readChar(char c) throws IOException
	{
		readChar();

		if(peek != c)
			return false;

		peek = ' ';
		return true;
	}
	//---------------------------------------------------------------------------
	//Pre-Condition: NIL
	//Post_Condition: Returns next vaild TOKEN
	//---------------------------------------------------------------------------
	public Token getNextToken()
	{
		Token tok = null;

		try
		{
			for( ; ; readChar())
			{
				if(peek == ' ' || peek == '\t' || peek == '\r' || peek == '\n')
				{
					if(illegal.length() > 0)
						return getUndefined();
					else
						continue;
				}
				else
					break;
			}

 
        	switch (peek) 
        	{
            	case '\0': 
            			if(illegal.length() > 0)
							return getUndefined();
						else
            				return new Token(Tag.T_EOF, lineNo, colNo);
            	case ',': 
            			if(illegal.length() > 0)
							return getUndefined();
						else
            			{
            				readChar(); 
            				return new Token(Tag.TCOMA, lineNo, colNo);
            			}
            	case '[': 
            			if(illegal.length() > 0)
							return getUndefined();
						else
						{
            				readChar(); 
            				return new Token(Tag.TLBRK, lineNo, colNo);
            			}
            	case ']': 
            			if(illegal.length() > 0)
							return getUndefined();
						else
						{
            				readChar(); 
            				return new Token(Tag.TRBRK, lineNo, colNo);
            			}
            	case '(': 
            			if(illegal.length() > 0)
							return getUndefined();
						else
						{
            				readChar(); 
            				return new Token(Tag.TLPAR, lineNo, colNo);
            			}
            	case ')': 
            			if(illegal.length() > 0)
							return getUndefined();
						else
						{
            				readChar(); 
            				return new Token(Tag.TRPAR, lineNo, colNo);
            			}
            	case '=':
            			if(illegal.length() > 0)
							return getUndefined();
						else 
            				return followPattern('=', Tag.TEQEQ, Tag.TEQUL);
            	case '+':
            			if(illegal.length() > 0)
							return getUndefined();
						else 
            				return followPattern('=', Tag.TPLEQ, Tag.TPLUS);
            	case '-':
            			if(illegal.length() > 0)
							return getUndefined();
						else 
            				return followPattern('=', Tag.TMNEQ, Tag.TMINS);
            	case '*':
            			if(illegal.length() > 0)
							return getUndefined();
						else 
            				return followPattern('=', Tag.TSTEQ, Tag.TSTAR);
            	case '/':
            			if(illegal.length() > 0)
							return getUndefined();
						else
            				return divPattern();
            	case '%': 
            			if(illegal.length() > 0)
							return getUndefined();
						else
						{
            				readChar(); 
            				return new Token(Tag.TPERC, lineNo, colNo);
            			}
            	case '^':
            			if(illegal.length() > 0)
							return getUndefined();
						else
						{
            				readChar(); 
            				return new Token(Tag.TCART, lineNo, colNo);
            			}
            	case '<':
            			if(illegal.length() > 0)
							return getUndefined();
						else 
            				return decsionPattern('=', '<', Tag.TLESS, Tag.TLEQL, Tag.TLSLS);
            	case '>':
            			if(illegal.length() > 0)
							return getUndefined();
						else
            				return decsionPattern('=', '>', Tag.TGRTR, Tag.TGEQL, Tag.TGRGR);
            	case ':':
            			if(illegal.length() > 0)
							return getUndefined();
						else
						{
            				readChar(); 
            				return new Token(Tag.TCOLN, lineNo, colNo);
            			}
            	case '!':
            			char tmp = peek;
            			br.mark(2);
            			tok = followPattern('=', Tag.TNEQL, Tag.TUNDF);
            			if(tok.tag == Tag.TUNDF)
            			{
            				illegal.append(tmp);
            				return getNextToken();
            			}
            			else if(illegal.length() > 0)
            			{
            				br.reset();
      						peek = tmp;
            				return getUndefined();
            			}
            			else
            				return tok;
            	case ';':
            			if(illegal.length() > 0)
							return getUndefined();
						else
						{
            				readChar(); 
            				return new Token(Tag.TSEMI, lineNo, colNo);
            			}
            	case '.': 
            			if(illegal.length() > 0)
							return getUndefined();
						else
            			{
            				readChar();
            				return new Token(Tag.TDOTT, lineNo, colNo);
            			}
            	case '"':	//String Lit
            			if(illegal.length() > 0)
							return getUndefined();
						 
            			StringBuffer buff = new StringBuffer();
            		
        				do
        				{
        					buff.append(peek);
        					readChar();

        					if(peek == '\r')
        						return new Undef(buff.toString(), " Unclosed quote(\") -", Tag.TUNDF, lineNo, colNo);
      
        				}while(peek != '"');

        				buff.append(peek);
        				peek = ' ';
        				String str = buff.toString();

        				//if(str.length() >60)
        					//return new Undef(buff.toString(), " exceeds MAX 60 characters", Tag.TUNDF, lineNo, colNo);
        				
        				return new Word(str, Tag.TSTRG, lineNo, colNo);
        	}

        	if(Character.isDigit(peek))
        	{
        		if(illegal.length() > 0)
					return getUndefined();

        		long num = 0;
        		double real = 0.0;
        		StringBuilder numStr = new StringBuilder();

        		numStr.append(getNums());
        		//if(numStr.length() > 60)
        		//			return new Undef(numStr.toString(), " Integer number exceeds 60 characters", Tag.TUNDF, lineNo, colNo);

        		if(peek != '.')
        		{
          			try
          			{
          				num = Long.parseLong(numStr.toString());
          			}
          			catch(Exception e)
          			{
          				return new Undef(numStr.toString(), " exceeds 2^64 Bits", Tag.TUNDF, lineNo, colNo);
          			}

          			return new IntNum(num, lineNo, colNo);
        		}
        		else
        		{
        			char p = peek;
        			readChar();

        			if(!Character.isDigit(peek))
        			{
        				br.reset();
        				peek = ' ';
        				//if(numStr.length() > 60)
        				//	return new Undef(numStr.toString(), " Integer number exceeds 60 characters", Tag.TUNDF, lineNo, colNo);

        				try
          				{
          					num = Long.parseLong(numStr.toString()); 
          				}
          				catch(Exception e)
          				{
          					return new Undef(numStr.toString(), " exceeds 2^64 Bits", Tag.TUNDF, lineNo, colNo);
          				}

        				return new IntNum(num, lineNo, colNo);
        			}
        			else
        			{
        				numStr.append(p);
        				numStr.append(getNums());

        				//if(numStr.length() > 60)
        				//	return new Undef(numStr.toString(), " Real number exceeds 60 characters", Tag.TUNDF, lineNo, colNo);

        				try
          				{
          					Double r = Double.parseDouble(numStr.toString());//new Double();
      
          					real = (double)r;
          					if(real > MAXDOUBLE)
          						return new Undef(numStr.toString(), " exceeds 2^64 Limit", Tag.TUNDF, lineNo, colNo);
          				}
          				catch(Exception e)
          				{
          					return new Undef(numStr.toString(), " exceeds 2^64 Limit", Tag.TUNDF, lineNo, colNo);
          				}

        				return new Real(real, lineNo, colNo);
        			}
        		}
        	}
        	if(Character.isLetter(peek))
        	{
        		if(illegal.length() > 0)
					return getUndefined();

        		StringBuffer buff = new StringBuffer();

        		do
        		{
        			buff.append(peek);
        			readChar();
        		}while(Character.isLetterOrDigit(peek));

        		String str = buff.toString();

        		tok = (Token)keywords.get(str.toLowerCase());

        		if(tok != null)
        			return new Token(tok, lineNo, colNo);
        		Word w = new Word(str, Tag.TIDEN, lineNo, colNo);

        		return w;
        	}

        	// Panic mode 
        	// Catching unknown symbols
        	illegal.append(peek);
        	readChar();
        }
        catch(IOException e)
        {
        	e.printStackTrace();
        }

        return getNextToken();
	}
	//---------------------------------------------------------------------------
	//Pre-Condition: Excpected Character TOKENS for yes or no
	//Post_Condition: Returns TOKEN of yes or no
	//---------------------------------------------------------------------------
	private Token followPattern(char expect, int ifyes, int ifno) throws IOException
	{
        String currentChar = Character.toString(peek);

        if(readChar(expect))
        {
            readChar();

            return new Token(ifyes, lineNo, colNo);
        }
        if(ifno == Tag.TUNDF) 
            return new Undef(currentChar, " is unknown", ifno, lineNo, colNo);

        return new Token(ifno, lineNo, colNo);
    }
    //---------------------------------------------------------------------------
	//Pre-Condition: / is look a head
	//Post_Condition: Returns / or /+ TOKENS or consumes characters after /-- or /** to **/ 
	//---------------------------------------------------------------------------
    private Token divPattern() throws IOException
    {
    	br.mark(2);
        readChar();

        char tmp = peek;
            		
        if(peek == '-')
        {
            readChar();
            if(peek == '-')
            {
            	chewChars(true);
            	return getNextToken();
            }
        }
        else if(peek == '*')
        {
            readChar();
            if(peek == '*')
            {
            	chewChars(false);
            	return getNextToken();
            }
        }
        else if(peek == '=')
        {
        	readChar();
        	return new Token(Tag.TDVEQ, lineNo, colNo);
        }
        br.reset();
        peek = ' ';
		
		return new Token(Tag.TDIVD, lineNo, colNo);
    }
    //---------------------------------------------------------------------------
	//Pre-Condition: Boolean of line comment
	//Post_Condition: Comsumes charcters for comments
	//---------------------------------------------------------------------------
    private void chewChars(boolean lineComment) throws IOException
    {
    	if(lineComment)
    	{
    		while(!readChar('\r'))
    			if(peek == '\0')
    				break;
    	}
    	else
    	{
    		while(peek != '\0')
    		{
    			readChar();
    			if(peek == '*')
    			{
    				br.mark(1);
    				readChar();
    				if(peek =='*')
    				{
    					readChar();
    					if(peek =='/')
    					{
    						peek = ' ';
    						break;
    					}
    					else
    						br.reset();
    				}
    			}
    		}
    	}
    }
    //---------------------------------------------------------------------------
	//Pre-Condition: Look a head is number
	//Post_Condition: Returns string sequence of numbers
	//---------------------------------------------------------------------------
    private String getNums() throws IOException
    {
    	StringBuilder num = new StringBuilder();

    	do
        {
        	br.mark(2);
        	num.append(peek);
        	readChar();

        }while(Character.isDigit(peek));

        return num.toString();
    }
    //---------------------------------------------------------------------------
	//Pre-Condition: Exspected characters and possible return TOKENS
	//Post_Condition: Returns TOKEN decesion
	//---------------------------------------------------------------------------
    private Token decsionPattern(char expected1, char expected2, int ifNo, int ifYes1, int ifYes2) throws IOException
    {    			
		if(readChar(expected1))
		{
            peek = ' ';

            return new Token(ifYes1, lineNo, colNo);
		}
        else if(peek == expected2)
        {
            peek = ' ';

            return new Token(ifYes2, lineNo, colNo);
        }
        else
            return new Token(ifNo, lineNo, colNo);
    }
    //---------------------------------------------------------------------------
	//Pre-Condition: Collected unknown symbols
	//Post_Condition: Returns UNDEF TOKEN
	//---------------------------------------------------------------------------
    private Token getUndefined()
    {
    	String s = illegal.toString();
    	//illegal.delete(0, illegal.length());
    	illegal = new StringBuilder();

    	return new Undef(s, " is unknown", Tag.TUNDF, lineNo, colNo);
    }
}