// Comp3290 Assignment 1
// Tag Class
// Author: Jason Disher
// Student No: c3185333
// Last Modified 10/7/2021

//package Lexer;

public class Tag
{
	public final static int
				//Tokens to be used in your Compiler

		T_EOF =  0,	  // Token value for end of file

		// The 31 keywords

		TCD21 =  1,	TCONS = 2,	TTYPS = 3,	TTTIS = 4,	TARRS = 5,	TMAIN = 6,
		TBEGN =  7,	TTEND = 8,	TARAY = 9,	TTTOF = 10,	TFUNC = 11,	TVOID = 12,
		TCNST = 13,	TINTG = 14,	TREAL = 15,	TBOOL = 16,	TTFOR = 17,	TREPT = 18,
		TUNTL = 19,	TIFTH = 20,	TELSE = 21,	TINPT = 22,	TOUTP = 23,	TOUTL = 24,
		TRETN = 25,	TNOTT = 26,	TTAND = 27,	TTTOR = 28,	TTXOR = 29,	TTRUE = 30,
		TFALS = 31,

		// the operators and delimiters
				    TCOMA = 32,	TLBRK = 33,	TRBRK = 34,	TLPAR = 35,	TRPAR = 36,
		TEQUL = 37,	TPLUS = 38,	TMINS = 39,	TSTAR = 40,	TDIVD = 41,	TPERC = 42,
		TCART = 43,	TLESS = 44,	TGRTR = 45,	TCOLN = 46,	TLEQL = 47,	TGEQL = 48,
		TNEQL = 49,	TEQEQ = 50,	TPLEQ = 51,	TMNEQ = 52,	TSTEQ = 53,	TDVEQ = 54,
		TSEMI = 56,	TDOTT = 57, TGRGR = 58, TLSLS = 59,

		// the tokens which need tuple values

		TIDEN = 60,	TILIT = 61,	TFLIT = 62,	TSTRG = 63,	TUNDF = 64;

	public final static String TPRINT[] = {  
			"T_EOF ",
			"TCD21 ",	"TCONS ",	"TTYPS ",	"TTTIS ",	"TARRS ",	"TMAIN ",
			"TBEGN ",	"TTEND ",	"TARAY ",	"TTTOF ",	"TFUNC ",	"TVOID ",
			"TCNST ",	"TINTG ",	"TREAL ",	"TBOOL ",	"TTFOR ",	"TREPT ",
			"TUNTL ",	"TIFTH ",	"TELSE ",	"TINPT ",	"TOUTP ",	"TOUTL ",
			"TRETN ",	"TNOTT ",	"TTAND ",	"TTTOR ",	"TTXOR ",	"TTRUE ",
			"TFALS ",	"TCOMA ",	"TLBRK ",	"TRBRK ",	"TLPAR ",	"TRPAR ",
			"TEQUL ",	"TPLUS ",	"TMINS ",	"TSTAR ",	"TDIVD ",	"TPERC ",
			"TCART ",	"TLESS ",	"TGRTR ",	"TCOLN ",	"TLEQL ",	"TGEQL ",
			"TNEQL ",	"TEQEQ ",	"TPLEQ ",	"TMNEQ ",	"TSTEQ ",	"TDVEQ ",
			"dummy ",	"TSEMI ",	"TDOTT ",	"TGRGR ",	"TLSLS ",
			"TIDEN ",	"TILIT ",	"TFLIT ",	"TSTRG ",	"TUNDF "};
}