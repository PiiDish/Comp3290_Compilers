// Comp3290 Assignment 1
// Main Class
// Author: Jason Disher
// Student No: c3185333
// Last Modified 20/7/2021

public class A1
{
		//Dummy driver code for assignment specs
	public static void main(String[] args)
	{
		Lexer lexer;
		StringBuilder putLine;
		Token tok = null;
		String str;
		final int LINEMAX = 66;

		for(int i=0; i<args.length; i++)
		{
			lexer = new Lexer(args[i]);

			System.out.println("\n\tLexically analysing: " + args[i] + "\n");

			do
			{
				putLine = new StringBuilder();

				while(putLine.length() < LINEMAX)
				{
					tok = lexer.getNextToken();
					str = tok.toString();

					if(tok.tag == Tag.TUNDF && putLine.length() != 0)
					{
						System.out.println(putLine.toString());
						System.out.println(str);
						putLine = new StringBuilder();
					}
					else if((tok.tag == Tag.TSTRG || tok.tag == Tag.TIDEN) && putLine.length()+str.length() > LINEMAX)
					{
						int l = LINEMAX - putLine.length()-1;
						int index = 0;
						while(true)
						{
							putLine.append(str.substring(index, l));
							System.out.println(putLine.toString());
							putLine = new StringBuilder();
							index = l;
							l += LINEMAX-1;
							if(str.length()-index < LINEMAX+1)
							{
								putLine.append(str.substring(index, str.length()));

								while(putLine.length()%6 != 0)
									putLine.append(' ');

								break;
							}
						}

					}
					else if(putLine.length()+str.length() > LINEMAX && putLine.length() != 0 && tok.tag != Tag.TUNDF)
					{
						System.out.println(putLine.toString());
						putLine = new StringBuilder(str);
					}
					else
						putLine.append(tok);

					if(tok.tag == Tag.T_EOF)
						break;
				}
				if(putLine.length() != 0)
					System.out.println(putLine.toString());

			}while(tok.tag != Tag.T_EOF);
		}
	}
}