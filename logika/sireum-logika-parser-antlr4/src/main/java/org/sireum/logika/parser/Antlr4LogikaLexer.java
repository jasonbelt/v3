// Generated from /Users/robby/Repositories/Sireum-Private/sireum-v3/logika/sireum-logika-parser-antlr4/src/main/resources/org/sireum/logika/parser/Antlr4Logika.g4 by ANTLR 4.5.1
package org.sireum.logika.parser;

// @formatter:off

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class Antlr4LogikaLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, T__47=48, T__48=49, T__49=50, T__50=51, T__51=52, 
		T__52=53, T__53=54, T__54=55, T__55=56, T__56=57, T__57=58, T__58=59, 
		T__59=60, T__60=61, T__61=62, T__62=63, T__63=64, T__64=65, T__65=66, 
		T__66=67, T__67=68, T__68=69, T__69=70, T__70=71, T__71=72, T__72=73, 
		T__73=74, T__74=75, T__75=76, T__76=77, T__77=78, T__78=79, T__79=80, 
		T__80=81, T__81=82, T__82=83, T__83=84, T__84=85, T__85=86, T__86=87, 
		T__87=88, T__88=89, T__89=90, T__90=91, T__91=92, T__92=93, T__93=94, 
		T__94=95, T__95=96, T__96=97, T__97=98, T__98=99, T__99=100, HLINE=101, 
		INT=102, NUM=103, ID=104, STRING=105, LINE_COMMENT=106, COMMENT=107, NL=108, 
		WS=109, RESERVED=110, ERROR_CHAR=111;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
		"T__25", "T__26", "T__27", "T__28", "T__29", "T__30", "T__31", "T__32", 
		"T__33", "T__34", "T__35", "T__36", "T__37", "T__38", "T__39", "T__40", 
		"T__41", "T__42", "T__43", "T__44", "T__45", "T__46", "T__47", "T__48", 
		"T__49", "T__50", "T__51", "T__52", "T__53", "T__54", "T__55", "T__56", 
		"T__57", "T__58", "T__59", "T__60", "T__61", "T__62", "T__63", "T__64", 
		"T__65", "T__66", "T__67", "T__68", "T__69", "T__70", "T__71", "T__72", 
		"T__73", "T__74", "T__75", "T__76", "T__77", "T__78", "T__79", "T__80", 
		"T__81", "T__82", "T__83", "T__84", "T__85", "T__86", "T__87", "T__88", 
		"T__89", "T__90", "T__91", "T__92", "T__93", "T__94", "T__95", "T__96", 
		"T__97", "T__98", "T__99", "HLINE", "INT", "NUM", "ID", "STRING", "LINE_COMMENT", 
		"COMMENT", "NL", "WS", "RESERVED", "ERROR_CHAR"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "','", "'|-'", "'⊢'", "'{'", "'}'", "'.'", "'assume'", "'_|_'", 
		"'⊥'", "'('", "')'", "'$result'", "'*'", "'/'", "'%'", "'+'", "'-'", "'<'", 
		"'<='", "'≤'", "'>'", "'>='", "'≥'", "'=='", "'!='", "'≠'", "'not'", "'!'", 
		"'~'", "'¬'", "'and'", "'&&'", "'∧'", "'or'", "'||'", "'∨'", "'implies'", 
		"'⇒'", "'=>'", "'forall'", "'all'", "'∀'", "'exists'", "'some'", "'∃'", 
		"'|'", "'premise'", "'andi'", "'ande1'", "'ande2'", "'ori1'", "'ori2'", 
		"'ore'", "'impliesi'", "'impliese'", "'noti'", "'note'", "'Pbc'", "'foalli'", 
		"'alli'", "'foalle'", "'alle'", "'existsi'", "'somei'", "'existse'", "'somee'", 
		"'algebra'", "'auto'", "'import'", "'_'", "';'", "'var'", "'val'", "':'", 
		"'='", "'assert'", "'if'", "'else'", "'while'", "'l'", "'\"\"\"'", "'readInt'", 
		"'print'", "'println'", "'s'", "'clone'", "'true'", "'false'", "'BigInt'", 
		"'Seq'", "'Boolean'", "'['", "']'", "'invariant'", "'modifies'", "'def'", 
		"'return'", "'requires'", "'ensures'", "'fact'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, "HLINE", "INT", "NUM", "ID", "STRING", "LINE_COMMENT", 
		"COMMENT", "NL", "WS", "RESERVED", "ERROR_CHAR"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public Antlr4LogikaLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Antlr4Logika.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2q\u039a\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]\t]\4^\t^\4_\t_\4"+
		"`\t`\4a\ta\4b\tb\4c\tc\4d\td\4e\te\4f\tf\4g\tg\4h\th\4i\ti\4j\tj\4k\t"+
		"k\4l\tl\4m\tm\4n\tn\4o\to\4p\tp\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3"+
		"\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\13"+
		"\3\13\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\20"+
		"\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\26\3\26"+
		"\3\27\3\27\3\27\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\34"+
		"\3\34\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3 \3 \3!\3!\3!\3\""+
		"\3\"\3#\3#\3#\3$\3$\3$\3%\3%\3&\3&\3&\3&\3&\3&\3&\3&\3\'\3\'\3(\3(\3("+
		"\3)\3)\3)\3)\3)\3)\3)\3*\3*\3*\3*\3+\3+\3,\3,\3,\3,\3,\3,\3,\3-\3-\3-"+
		"\3-\3-\3.\3.\3/\3/\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\61\3\61\3"+
		"\61\3\61\3\61\3\62\3\62\3\62\3\62\3\62\3\62\3\63\3\63\3\63\3\63\3\63\3"+
		"\63\3\64\3\64\3\64\3\64\3\64\3\65\3\65\3\65\3\65\3\65\3\66\3\66\3\66\3"+
		"\66\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\38\38\38\38\38\38\38"+
		"\38\38\39\39\39\39\39\3:\3:\3:\3:\3:\3;\3;\3;\3;\3<\3<\3<\3<\3<\3<\3<"+
		"\3=\3=\3=\3=\3=\3>\3>\3>\3>\3>\3>\3>\3?\3?\3?\3?\3?\3@\3@\3@\3@\3@\3@"+
		"\3@\3@\3A\3A\3A\3A\3A\3A\3B\3B\3B\3B\3B\3B\3B\3B\3C\3C\3C\3C\3C\3C\3D"+
		"\3D\3D\3D\3D\3D\3D\3D\3E\3E\3E\3E\3E\3F\3F\3F\3F\3F\3F\3F\3G\3G\3H\3H"+
		"\3I\3I\3I\3I\3J\3J\3J\3J\3K\3K\3L\3L\3M\3M\3M\3M\3M\3M\3M\3N\3N\3N\3O"+
		"\3O\3O\3O\3O\3P\3P\3P\3P\3P\3P\3Q\3Q\3R\3R\3R\3R\3S\3S\3S\3S\3S\3S\3S"+
		"\3S\3T\3T\3T\3T\3T\3T\3U\3U\3U\3U\3U\3U\3U\3U\3V\3V\3W\3W\3W\3W\3W\3W"+
		"\3X\3X\3X\3X\3X\3Y\3Y\3Y\3Y\3Y\3Y\3Z\3Z\3Z\3Z\3Z\3Z\3Z\3[\3[\3[\3[\3\\"+
		"\3\\\3\\\3\\\3\\\3\\\3\\\3\\\3]\3]\3^\3^\3_\3_\3_\3_\3_\3_\3_\3_\3_\3"+
		"_\3`\3`\3`\3`\3`\3`\3`\3`\3`\3a\3a\3a\3a\3b\3b\3b\3b\3b\3b\3b\3c\3c\3"+
		"c\3c\3c\3c\3c\3c\3c\3d\3d\3d\3d\3d\3d\3d\3d\3e\3e\3e\3e\3e\3f\3f\3f\6"+
		"f\u029e\nf\rf\16f\u029f\3g\3g\5g\u02a4\ng\3g\3g\7g\u02a8\ng\fg\16g\u02ab"+
		"\13g\5g\u02ad\ng\3h\3h\3h\7h\u02b2\nh\fh\16h\u02b5\13h\5h\u02b7\nh\3i"+
		"\3i\7i\u02bb\ni\fi\16i\u02be\13i\3j\3j\7j\u02c2\nj\fj\16j\u02c5\13j\3"+
		"j\3j\3k\3k\3k\3k\7k\u02cd\nk\fk\16k\u02d0\13k\3k\3k\3l\3l\3l\3l\7l\u02d8"+
		"\nl\fl\16l\u02db\13l\3l\3l\3l\3l\3l\3m\5m\u02e3\nm\3m\3m\3n\6n\u02e8\n"+
		"n\rn\16n\u02e9\3n\3n\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3"+
		"o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3"+
		"o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3"+
		"o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3"+
		"o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3"+
		"o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3"+
		"o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3"+
		"o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\3o\5o\u0397\no\3p\3p\3\u02d9"+
		"\2q\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36"+
		";\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67"+
		"m8o9q:s;u<w=y>{?}@\177A\u0081B\u0083C\u0085D\u0087E\u0089F\u008bG\u008d"+
		"H\u008fI\u0091J\u0093K\u0095L\u0097M\u0099N\u009bO\u009dP\u009fQ\u00a1"+
		"R\u00a3S\u00a5T\u00a7U\u00a9V\u00abW\u00adX\u00afY\u00b1Z\u00b3[\u00b5"+
		"\\\u00b7]\u00b9^\u00bb_\u00bd`\u00bfa\u00c1b\u00c3c\u00c5d\u00c7e\u00c9"+
		"f\u00cbg\u00cdh\u00cfi\u00d1j\u00d3k\u00d5l\u00d7m\u00d9n\u00dbo\u00dd"+
		"p\u00dfq\3\2\n\3\2\63;\3\2\62;\4\2C\\c|\5\2\62;C\\c|\4\2\"#%\u0081\4\2"+
		"\f\f\17\17\5\2\13\13\16\16\"\"\4\2%%BB\u03c7\2\3\3\2\2\2\2\5\3\2\2\2\2"+
		"\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2"+
		"\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2"+
		"\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2"+
		"\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2"+
		"\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2"+
		"\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2"+
		"M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3"+
		"\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2"+
		"\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2"+
		"s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177"+
		"\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085\3\2\2\2\2\u0087\3\2\2"+
		"\2\2\u0089\3\2\2\2\2\u008b\3\2\2\2\2\u008d\3\2\2\2\2\u008f\3\2\2\2\2\u0091"+
		"\3\2\2\2\2\u0093\3\2\2\2\2\u0095\3\2\2\2\2\u0097\3\2\2\2\2\u0099\3\2\2"+
		"\2\2\u009b\3\2\2\2\2\u009d\3\2\2\2\2\u009f\3\2\2\2\2\u00a1\3\2\2\2\2\u00a3"+
		"\3\2\2\2\2\u00a5\3\2\2\2\2\u00a7\3\2\2\2\2\u00a9\3\2\2\2\2\u00ab\3\2\2"+
		"\2\2\u00ad\3\2\2\2\2\u00af\3\2\2\2\2\u00b1\3\2\2\2\2\u00b3\3\2\2\2\2\u00b5"+
		"\3\2\2\2\2\u00b7\3\2\2\2\2\u00b9\3\2\2\2\2\u00bb\3\2\2\2\2\u00bd\3\2\2"+
		"\2\2\u00bf\3\2\2\2\2\u00c1\3\2\2\2\2\u00c3\3\2\2\2\2\u00c5\3\2\2\2\2\u00c7"+
		"\3\2\2\2\2\u00c9\3\2\2\2\2\u00cb\3\2\2\2\2\u00cd\3\2\2\2\2\u00cf\3\2\2"+
		"\2\2\u00d1\3\2\2\2\2\u00d3\3\2\2\2\2\u00d5\3\2\2\2\2\u00d7\3\2\2\2\2\u00d9"+
		"\3\2\2\2\2\u00db\3\2\2\2\2\u00dd\3\2\2\2\2\u00df\3\2\2\2\3\u00e1\3\2\2"+
		"\2\5\u00e3\3\2\2\2\7\u00e6\3\2\2\2\t\u00e8\3\2\2\2\13\u00ea\3\2\2\2\r"+
		"\u00ec\3\2\2\2\17\u00ee\3\2\2\2\21\u00f5\3\2\2\2\23\u00f9\3\2\2\2\25\u00fb"+
		"\3\2\2\2\27\u00fd\3\2\2\2\31\u00ff\3\2\2\2\33\u0107\3\2\2\2\35\u0109\3"+
		"\2\2\2\37\u010b\3\2\2\2!\u010d\3\2\2\2#\u010f\3\2\2\2%\u0111\3\2\2\2\'"+
		"\u0113\3\2\2\2)\u0116\3\2\2\2+\u0118\3\2\2\2-\u011a\3\2\2\2/\u011d\3\2"+
		"\2\2\61\u011f\3\2\2\2\63\u0122\3\2\2\2\65\u0125\3\2\2\2\67\u0127\3\2\2"+
		"\29\u012b\3\2\2\2;\u012d\3\2\2\2=\u012f\3\2\2\2?\u0131\3\2\2\2A\u0135"+
		"\3\2\2\2C\u0138\3\2\2\2E\u013a\3\2\2\2G\u013d\3\2\2\2I\u0140\3\2\2\2K"+
		"\u0142\3\2\2\2M\u014a\3\2\2\2O\u014c\3\2\2\2Q\u014f\3\2\2\2S\u0156\3\2"+
		"\2\2U\u015a\3\2\2\2W\u015c\3\2\2\2Y\u0163\3\2\2\2[\u0168\3\2\2\2]\u016a"+
		"\3\2\2\2_\u016c\3\2\2\2a\u0174\3\2\2\2c\u0179\3\2\2\2e\u017f\3\2\2\2g"+
		"\u0185\3\2\2\2i\u018a\3\2\2\2k\u018f\3\2\2\2m\u0193\3\2\2\2o\u019c\3\2"+
		"\2\2q\u01a5\3\2\2\2s\u01aa\3\2\2\2u\u01af\3\2\2\2w\u01b3\3\2\2\2y\u01ba"+
		"\3\2\2\2{\u01bf\3\2\2\2}\u01c6\3\2\2\2\177\u01cb\3\2\2\2\u0081\u01d3\3"+
		"\2\2\2\u0083\u01d9\3\2\2\2\u0085\u01e1\3\2\2\2\u0087\u01e7\3\2\2\2\u0089"+
		"\u01ef\3\2\2\2\u008b\u01f4\3\2\2\2\u008d\u01fb\3\2\2\2\u008f\u01fd\3\2"+
		"\2\2\u0091\u01ff\3\2\2\2\u0093\u0203\3\2\2\2\u0095\u0207\3\2\2\2\u0097"+
		"\u0209\3\2\2\2\u0099\u020b\3\2\2\2\u009b\u0212\3\2\2\2\u009d\u0215\3\2"+
		"\2\2\u009f\u021a\3\2\2\2\u00a1\u0220\3\2\2\2\u00a3\u0222\3\2\2\2\u00a5"+
		"\u0226\3\2\2\2\u00a7\u022e\3\2\2\2\u00a9\u0234\3\2\2\2\u00ab\u023c\3\2"+
		"\2\2\u00ad\u023e\3\2\2\2\u00af\u0244\3\2\2\2\u00b1\u0249\3\2\2\2\u00b3"+
		"\u024f\3\2\2\2\u00b5\u0256\3\2\2\2\u00b7\u025a\3\2\2\2\u00b9\u0262\3\2"+
		"\2\2\u00bb\u0264\3\2\2\2\u00bd\u0266\3\2\2\2\u00bf\u0270\3\2\2\2\u00c1"+
		"\u0279\3\2\2\2\u00c3\u027d\3\2\2\2\u00c5\u0284\3\2\2\2\u00c7\u028d\3\2"+
		"\2\2\u00c9\u0295\3\2\2\2\u00cb\u029a\3\2\2\2\u00cd\u02ac\3\2\2\2\u00cf"+
		"\u02b6\3\2\2\2\u00d1\u02b8\3\2\2\2\u00d3\u02bf\3\2\2\2\u00d5\u02c8\3\2"+
		"\2\2\u00d7\u02d3\3\2\2\2\u00d9\u02e2\3\2\2\2\u00db\u02e7\3\2\2\2\u00dd"+
		"\u0396\3\2\2\2\u00df\u0398\3\2\2\2\u00e1\u00e2\7.\2\2\u00e2\4\3\2\2\2"+
		"\u00e3\u00e4\7~\2\2\u00e4\u00e5\7/\2\2\u00e5\6\3\2\2\2\u00e6\u00e7\7\u22a4"+
		"\2\2\u00e7\b\3\2\2\2\u00e8\u00e9\7}\2\2\u00e9\n\3\2\2\2\u00ea\u00eb\7"+
		"\177\2\2\u00eb\f\3\2\2\2\u00ec\u00ed\7\60\2\2\u00ed\16\3\2\2\2\u00ee\u00ef"+
		"\7c\2\2\u00ef\u00f0\7u\2\2\u00f0\u00f1\7u\2\2\u00f1\u00f2\7w\2\2\u00f2"+
		"\u00f3\7o\2\2\u00f3\u00f4\7g\2\2\u00f4\20\3\2\2\2\u00f5\u00f6\7a\2\2\u00f6"+
		"\u00f7\7~\2\2\u00f7\u00f8\7a\2\2\u00f8\22\3\2\2\2\u00f9\u00fa\7\u22a7"+
		"\2\2\u00fa\24\3\2\2\2\u00fb\u00fc\7*\2\2\u00fc\26\3\2\2\2\u00fd\u00fe"+
		"\7+\2\2\u00fe\30\3\2\2\2\u00ff\u0100\7&\2\2\u0100\u0101\7t\2\2\u0101\u0102"+
		"\7g\2\2\u0102\u0103\7u\2\2\u0103\u0104\7w\2\2\u0104\u0105\7n\2\2\u0105"+
		"\u0106\7v\2\2\u0106\32\3\2\2\2\u0107\u0108\7,\2\2\u0108\34\3\2\2\2\u0109"+
		"\u010a\7\61\2\2\u010a\36\3\2\2\2\u010b\u010c\7\'\2\2\u010c \3\2\2\2\u010d"+
		"\u010e\7-\2\2\u010e\"\3\2\2\2\u010f\u0110\7/\2\2\u0110$\3\2\2\2\u0111"+
		"\u0112\7>\2\2\u0112&\3\2\2\2\u0113\u0114\7>\2\2\u0114\u0115\7?\2\2\u0115"+
		"(\3\2\2\2\u0116\u0117\7\u2266\2\2\u0117*\3\2\2\2\u0118\u0119\7@\2\2\u0119"+
		",\3\2\2\2\u011a\u011b\7@\2\2\u011b\u011c\7?\2\2\u011c.\3\2\2\2\u011d\u011e"+
		"\7\u2267\2\2\u011e\60\3\2\2\2\u011f\u0120\7?\2\2\u0120\u0121\7?\2\2\u0121"+
		"\62\3\2\2\2\u0122\u0123\7#\2\2\u0123\u0124\7?\2\2\u0124\64\3\2\2\2\u0125"+
		"\u0126\7\u2262\2\2\u0126\66\3\2\2\2\u0127\u0128\7p\2\2\u0128\u0129\7q"+
		"\2\2\u0129\u012a\7v\2\2\u012a8\3\2\2\2\u012b\u012c\7#\2\2\u012c:\3\2\2"+
		"\2\u012d\u012e\7\u0080\2\2\u012e<\3\2\2\2\u012f\u0130\7\u00ae\2\2\u0130"+
		">\3\2\2\2\u0131\u0132\7c\2\2\u0132\u0133\7p\2\2\u0133\u0134\7f\2\2\u0134"+
		"@\3\2\2\2\u0135\u0136\7(\2\2\u0136\u0137\7(\2\2\u0137B\3\2\2\2\u0138\u0139"+
		"\7\u2229\2\2\u0139D\3\2\2\2\u013a\u013b\7q\2\2\u013b\u013c\7t\2\2\u013c"+
		"F\3\2\2\2\u013d\u013e\7~\2\2\u013e\u013f\7~\2\2\u013fH\3\2\2\2\u0140\u0141"+
		"\7\u222a\2\2\u0141J\3\2\2\2\u0142\u0143\7k\2\2\u0143\u0144\7o\2\2\u0144"+
		"\u0145\7r\2\2\u0145\u0146\7n\2\2\u0146\u0147\7k\2\2\u0147\u0148\7g\2\2"+
		"\u0148\u0149\7u\2\2\u0149L\3\2\2\2\u014a\u014b\7\u21d4\2\2\u014bN\3\2"+
		"\2\2\u014c\u014d\7?\2\2\u014d\u014e\7@\2\2\u014eP\3\2\2\2\u014f\u0150"+
		"\7h\2\2\u0150\u0151\7q\2\2\u0151\u0152\7t\2\2\u0152\u0153\7c\2\2\u0153"+
		"\u0154\7n\2\2\u0154\u0155\7n\2\2\u0155R\3\2\2\2\u0156\u0157\7c\2\2\u0157"+
		"\u0158\7n\2\2\u0158\u0159\7n\2\2\u0159T\3\2\2\2\u015a\u015b\7\u2202\2"+
		"\2\u015bV\3\2\2\2\u015c\u015d\7g\2\2\u015d\u015e\7z\2\2\u015e\u015f\7"+
		"k\2\2\u015f\u0160\7u\2\2\u0160\u0161\7v\2\2\u0161\u0162\7u\2\2\u0162X"+
		"\3\2\2\2\u0163\u0164\7u\2\2\u0164\u0165\7q\2\2\u0165\u0166\7o\2\2\u0166"+
		"\u0167\7g\2\2\u0167Z\3\2\2\2\u0168\u0169\7\u2205\2\2\u0169\\\3\2\2\2\u016a"+
		"\u016b\7~\2\2\u016b^\3\2\2\2\u016c\u016d\7r\2\2\u016d\u016e\7t\2\2\u016e"+
		"\u016f\7g\2\2\u016f\u0170\7o\2\2\u0170\u0171\7k\2\2\u0171\u0172\7u\2\2"+
		"\u0172\u0173\7g\2\2\u0173`\3\2\2\2\u0174\u0175\7c\2\2\u0175\u0176\7p\2"+
		"\2\u0176\u0177\7f\2\2\u0177\u0178\7k\2\2\u0178b\3\2\2\2\u0179\u017a\7"+
		"c\2\2\u017a\u017b\7p\2\2\u017b\u017c\7f\2\2\u017c\u017d\7g\2\2\u017d\u017e"+
		"\7\63\2\2\u017ed\3\2\2\2\u017f\u0180\7c\2\2\u0180\u0181\7p\2\2\u0181\u0182"+
		"\7f\2\2\u0182\u0183\7g\2\2\u0183\u0184\7\64\2\2\u0184f\3\2\2\2\u0185\u0186"+
		"\7q\2\2\u0186\u0187\7t\2\2\u0187\u0188\7k\2\2\u0188\u0189\7\63\2\2\u0189"+
		"h\3\2\2\2\u018a\u018b\7q\2\2\u018b\u018c\7t\2\2\u018c\u018d\7k\2\2\u018d"+
		"\u018e\7\64\2\2\u018ej\3\2\2\2\u018f\u0190\7q\2\2\u0190\u0191\7t\2\2\u0191"+
		"\u0192\7g\2\2\u0192l\3\2\2\2\u0193\u0194\7k\2\2\u0194\u0195\7o\2\2\u0195"+
		"\u0196\7r\2\2\u0196\u0197\7n\2\2\u0197\u0198\7k\2\2\u0198\u0199\7g\2\2"+
		"\u0199\u019a\7u\2\2\u019a\u019b\7k\2\2\u019bn\3\2\2\2\u019c\u019d\7k\2"+
		"\2\u019d\u019e\7o\2\2\u019e\u019f\7r\2\2\u019f\u01a0\7n\2\2\u01a0\u01a1"+
		"\7k\2\2\u01a1\u01a2\7g\2\2\u01a2\u01a3\7u\2\2\u01a3\u01a4\7g\2\2\u01a4"+
		"p\3\2\2\2\u01a5\u01a6\7p\2\2\u01a6\u01a7\7q\2\2\u01a7\u01a8\7v\2\2\u01a8"+
		"\u01a9\7k\2\2\u01a9r\3\2\2\2\u01aa\u01ab\7p\2\2\u01ab\u01ac\7q\2\2\u01ac"+
		"\u01ad\7v\2\2\u01ad\u01ae\7g\2\2\u01aet\3\2\2\2\u01af\u01b0\7R\2\2\u01b0"+
		"\u01b1\7d\2\2\u01b1\u01b2\7e\2\2\u01b2v\3\2\2\2\u01b3\u01b4\7h\2\2\u01b4"+
		"\u01b5\7q\2\2\u01b5\u01b6\7c\2\2\u01b6\u01b7\7n\2\2\u01b7\u01b8\7n\2\2"+
		"\u01b8\u01b9\7k\2\2\u01b9x\3\2\2\2\u01ba\u01bb\7c\2\2\u01bb\u01bc\7n\2"+
		"\2\u01bc\u01bd\7n\2\2\u01bd\u01be\7k\2\2\u01bez\3\2\2\2\u01bf\u01c0\7"+
		"h\2\2\u01c0\u01c1\7q\2\2\u01c1\u01c2\7c\2\2\u01c2\u01c3\7n\2\2\u01c3\u01c4"+
		"\7n\2\2\u01c4\u01c5\7g\2\2\u01c5|\3\2\2\2\u01c6\u01c7\7c\2\2\u01c7\u01c8"+
		"\7n\2\2\u01c8\u01c9\7n\2\2\u01c9\u01ca\7g\2\2\u01ca~\3\2\2\2\u01cb\u01cc"+
		"\7g\2\2\u01cc\u01cd\7z\2\2\u01cd\u01ce\7k\2\2\u01ce\u01cf\7u\2\2\u01cf"+
		"\u01d0\7v\2\2\u01d0\u01d1\7u\2\2\u01d1\u01d2\7k\2\2\u01d2\u0080\3\2\2"+
		"\2\u01d3\u01d4\7u\2\2\u01d4\u01d5\7q\2\2\u01d5\u01d6\7o\2\2\u01d6\u01d7"+
		"\7g\2\2\u01d7\u01d8\7k\2\2\u01d8\u0082\3\2\2\2\u01d9\u01da\7g\2\2\u01da"+
		"\u01db\7z\2\2\u01db\u01dc\7k\2\2\u01dc\u01dd\7u\2\2\u01dd\u01de\7v\2\2"+
		"\u01de\u01df\7u\2\2\u01df\u01e0\7g\2\2\u01e0\u0084\3\2\2\2\u01e1\u01e2"+
		"\7u\2\2\u01e2\u01e3\7q\2\2\u01e3\u01e4\7o\2\2\u01e4\u01e5\7g\2\2\u01e5"+
		"\u01e6\7g\2\2\u01e6\u0086\3\2\2\2\u01e7\u01e8\7c\2\2\u01e8\u01e9\7n\2"+
		"\2\u01e9\u01ea\7i\2\2\u01ea\u01eb\7g\2\2\u01eb\u01ec\7d\2\2\u01ec\u01ed"+
		"\7t\2\2\u01ed\u01ee\7c\2\2\u01ee\u0088\3\2\2\2\u01ef\u01f0\7c\2\2\u01f0"+
		"\u01f1\7w\2\2\u01f1\u01f2\7v\2\2\u01f2\u01f3\7q\2\2\u01f3\u008a\3\2\2"+
		"\2\u01f4\u01f5\7k\2\2\u01f5\u01f6\7o\2\2\u01f6\u01f7\7r\2\2\u01f7\u01f8"+
		"\7q\2\2\u01f8\u01f9\7t\2\2\u01f9\u01fa\7v\2\2\u01fa\u008c\3\2\2\2\u01fb"+
		"\u01fc\7a\2\2\u01fc\u008e\3\2\2\2\u01fd\u01fe\7=\2\2\u01fe\u0090\3\2\2"+
		"\2\u01ff\u0200\7x\2\2\u0200\u0201\7c\2\2\u0201\u0202\7t\2\2\u0202\u0092"+
		"\3\2\2\2\u0203\u0204\7x\2\2\u0204\u0205\7c\2\2\u0205\u0206\7n\2\2\u0206"+
		"\u0094\3\2\2\2\u0207\u0208\7<\2\2\u0208\u0096\3\2\2\2\u0209\u020a\7?\2"+
		"\2\u020a\u0098\3\2\2\2\u020b\u020c\7c\2\2\u020c\u020d\7u\2\2\u020d\u020e"+
		"\7u\2\2\u020e\u020f\7g\2\2\u020f\u0210\7t\2\2\u0210\u0211\7v\2\2\u0211"+
		"\u009a\3\2\2\2\u0212\u0213\7k\2\2\u0213\u0214\7h\2\2\u0214\u009c\3\2\2"+
		"\2\u0215\u0216\7g\2\2\u0216\u0217\7n\2\2\u0217\u0218\7u\2\2\u0218\u0219"+
		"\7g\2\2\u0219\u009e\3\2\2\2\u021a\u021b\7y\2\2\u021b\u021c\7j\2\2\u021c"+
		"\u021d\7k\2\2\u021d\u021e\7n\2\2\u021e\u021f\7g\2\2\u021f\u00a0\3\2\2"+
		"\2\u0220\u0221\7n\2\2\u0221\u00a2\3\2\2\2\u0222\u0223\7$\2\2\u0223\u0224"+
		"\7$\2\2\u0224\u0225\7$\2\2\u0225\u00a4\3\2\2\2\u0226\u0227\7t\2\2\u0227"+
		"\u0228\7g\2\2\u0228\u0229\7c\2\2\u0229\u022a\7f\2\2\u022a\u022b\7K\2\2"+
		"\u022b\u022c\7p\2\2\u022c\u022d\7v\2\2\u022d\u00a6\3\2\2\2\u022e\u022f"+
		"\7r\2\2\u022f\u0230\7t\2\2\u0230\u0231\7k\2\2\u0231\u0232\7p\2\2\u0232"+
		"\u0233\7v\2\2\u0233\u00a8\3\2\2\2\u0234\u0235\7r\2\2\u0235\u0236\7t\2"+
		"\2\u0236\u0237\7k\2\2\u0237\u0238\7p\2\2\u0238\u0239\7v\2\2\u0239\u023a"+
		"\7n\2\2\u023a\u023b\7p\2\2\u023b\u00aa\3\2\2\2\u023c\u023d\7u\2\2\u023d"+
		"\u00ac\3\2\2\2\u023e\u023f\7e\2\2\u023f\u0240\7n\2\2\u0240\u0241\7q\2"+
		"\2\u0241\u0242\7p\2\2\u0242\u0243\7g\2\2\u0243\u00ae\3\2\2\2\u0244\u0245"+
		"\7v\2\2\u0245\u0246\7t\2\2\u0246\u0247\7w\2\2\u0247\u0248\7g\2\2\u0248"+
		"\u00b0\3\2\2\2\u0249\u024a\7h\2\2\u024a\u024b\7c\2\2\u024b\u024c\7n\2"+
		"\2\u024c\u024d\7u\2\2\u024d\u024e\7g\2\2\u024e\u00b2\3\2\2\2\u024f\u0250"+
		"\7D\2\2\u0250\u0251\7k\2\2\u0251\u0252\7i\2\2\u0252\u0253\7K\2\2\u0253"+
		"\u0254\7p\2\2\u0254\u0255\7v\2\2\u0255\u00b4\3\2\2\2\u0256\u0257\7U\2"+
		"\2\u0257\u0258\7g\2\2\u0258\u0259\7s\2\2\u0259\u00b6\3\2\2\2\u025a\u025b"+
		"\7D\2\2\u025b\u025c\7q\2\2\u025c\u025d\7q\2\2\u025d\u025e\7n\2\2\u025e"+
		"\u025f\7g\2\2\u025f\u0260\7c\2\2\u0260\u0261\7p\2\2\u0261\u00b8\3\2\2"+
		"\2\u0262\u0263\7]\2\2\u0263\u00ba\3\2\2\2\u0264\u0265\7_\2\2\u0265\u00bc"+
		"\3\2\2\2\u0266\u0267\7k\2\2\u0267\u0268\7p\2\2\u0268\u0269\7x\2\2\u0269"+
		"\u026a\7c\2\2\u026a\u026b\7t\2\2\u026b\u026c\7k\2\2\u026c\u026d\7c\2\2"+
		"\u026d\u026e\7p\2\2\u026e\u026f\7v\2\2\u026f\u00be\3\2\2\2\u0270\u0271"+
		"\7o\2\2\u0271\u0272\7q\2\2\u0272\u0273\7f\2\2\u0273\u0274\7k\2\2\u0274"+
		"\u0275\7h\2\2\u0275\u0276\7k\2\2\u0276\u0277\7g\2\2\u0277\u0278\7u\2\2"+
		"\u0278\u00c0\3\2\2\2\u0279\u027a\7f\2\2\u027a\u027b\7g\2\2\u027b\u027c"+
		"\7h\2\2\u027c\u00c2\3\2\2\2\u027d\u027e\7t\2\2\u027e\u027f\7g\2\2\u027f"+
		"\u0280\7v\2\2\u0280\u0281\7w\2\2\u0281\u0282\7t\2\2\u0282\u0283\7p\2\2"+
		"\u0283\u00c4\3\2\2\2\u0284\u0285\7t\2\2\u0285\u0286\7g\2\2\u0286\u0287"+
		"\7s\2\2\u0287\u0288\7w\2\2\u0288\u0289\7k\2\2\u0289\u028a\7t\2\2\u028a"+
		"\u028b\7g\2\2\u028b\u028c\7u\2\2\u028c\u00c6\3\2\2\2\u028d\u028e\7g\2"+
		"\2\u028e\u028f\7p\2\2\u028f\u0290\7u\2\2\u0290\u0291\7w\2\2\u0291\u0292"+
		"\7t\2\2\u0292\u0293\7g\2\2\u0293\u0294\7u\2\2\u0294\u00c8\3\2\2\2\u0295"+
		"\u0296\7h\2\2\u0296\u0297\7c\2\2\u0297\u0298\7e\2\2\u0298\u0299\7v\2\2"+
		"\u0299\u00ca\3\2\2\2\u029a\u029b\7/\2\2\u029b\u029d\7/\2\2\u029c\u029e"+
		"\7/\2\2\u029d\u029c\3\2\2\2\u029e\u029f\3\2\2\2\u029f\u029d\3\2\2\2\u029f"+
		"\u02a0\3\2\2\2\u02a0\u00cc\3\2\2\2\u02a1\u02ad\7\62\2\2\u02a2\u02a4\7"+
		"/\2\2\u02a3\u02a2\3\2\2\2\u02a3\u02a4\3\2\2\2\u02a4\u02a5\3\2\2\2\u02a5"+
		"\u02a9\t\2\2\2\u02a6\u02a8\t\3\2\2\u02a7\u02a6\3\2\2\2\u02a8\u02ab\3\2"+
		"\2\2\u02a9\u02a7\3\2\2\2\u02a9\u02aa\3\2\2\2\u02aa\u02ad\3\2\2\2\u02ab"+
		"\u02a9\3\2\2\2\u02ac\u02a1\3\2\2\2\u02ac\u02a3\3\2\2\2\u02ad\u00ce\3\2"+
		"\2\2\u02ae\u02b7\7\62\2\2\u02af\u02b3\t\2\2\2\u02b0\u02b2\t\3\2\2\u02b1"+
		"\u02b0\3\2\2\2\u02b2\u02b5\3\2\2\2\u02b3\u02b1\3\2\2\2\u02b3\u02b4\3\2"+
		"\2\2\u02b4\u02b7\3\2\2\2\u02b5\u02b3\3\2\2\2\u02b6\u02ae\3\2\2\2\u02b6"+
		"\u02af\3\2\2\2\u02b7\u00d0\3\2\2\2\u02b8\u02bc\t\4\2\2\u02b9\u02bb\t\5"+
		"\2\2\u02ba\u02b9\3\2\2\2\u02bb\u02be\3\2\2\2\u02bc\u02ba\3\2\2\2\u02bc"+
		"\u02bd\3\2\2\2\u02bd\u00d2\3\2\2\2\u02be\u02bc\3\2\2\2\u02bf\u02c3\7$"+
		"\2\2\u02c0\u02c2\t\6\2\2\u02c1\u02c0\3\2\2\2\u02c2\u02c5\3\2\2\2\u02c3"+
		"\u02c1\3\2\2\2\u02c3\u02c4\3\2\2\2\u02c4\u02c6\3\2\2\2\u02c5\u02c3\3\2"+
		"\2\2\u02c6\u02c7\7$\2\2\u02c7\u00d4\3\2\2\2\u02c8\u02c9\7\61\2\2\u02c9"+
		"\u02ca\7\61\2\2\u02ca\u02ce\3\2\2\2\u02cb\u02cd\n\7\2\2\u02cc\u02cb\3"+
		"\2\2\2\u02cd\u02d0\3\2\2\2\u02ce\u02cc\3\2\2\2\u02ce\u02cf\3\2\2\2\u02cf"+
		"\u02d1\3\2\2\2\u02d0\u02ce\3\2\2\2\u02d1\u02d2\bk\2\2\u02d2\u00d6\3\2"+
		"\2\2\u02d3\u02d4\7\61\2\2\u02d4\u02d5\7,\2\2\u02d5\u02d9\3\2\2\2\u02d6"+
		"\u02d8\13\2\2\2\u02d7\u02d6\3\2\2\2\u02d8\u02db\3\2\2\2\u02d9\u02da\3"+
		"\2\2\2\u02d9\u02d7\3\2\2\2\u02da\u02dc\3\2\2\2\u02db\u02d9\3\2\2\2\u02dc"+
		"\u02dd\7,\2\2\u02dd\u02de\7\61\2\2\u02de\u02df\3\2\2\2\u02df\u02e0\bl"+
		"\2\2\u02e0\u00d8\3\2\2\2\u02e1\u02e3\7\17\2\2\u02e2\u02e1\3\2\2\2\u02e2"+
		"\u02e3\3\2\2\2\u02e3\u02e4\3\2\2\2\u02e4\u02e5\7\f\2\2\u02e5\u00da\3\2"+
		"\2\2\u02e6\u02e8\t\b\2\2\u02e7\u02e6\3\2\2\2\u02e8\u02e9\3\2\2\2\u02e9"+
		"\u02e7\3\2\2\2\u02e9\u02ea\3\2\2\2\u02ea\u02eb\3\2\2\2\u02eb\u02ec\bn"+
		"\2\2\u02ec\u00dc\3\2\2\2\u02ed\u02ee\7c\2\2\u02ee\u02ef\7d\2\2\u02ef\u02f0"+
		"\7u\2\2\u02f0\u02f1\7v\2\2\u02f1\u02f2\7t\2\2\u02f2\u02f3\7c\2\2\u02f3"+
		"\u02f4\7e\2\2\u02f4\u0397\7v\2\2\u02f5\u02f6\7e\2\2\u02f6\u02f7\7c\2\2"+
		"\u02f7\u02f8\7u\2\2\u02f8\u0397\7g\2\2\u02f9\u02fa\7e\2\2\u02fa\u02fb"+
		"\7c\2\2\u02fb\u02fc\7v\2\2\u02fc\u02fd\7e\2\2\u02fd\u0397\7j\2\2\u02fe"+
		"\u02ff\7e\2\2\u02ff\u0300\7n\2\2\u0300\u0301\7c\2\2\u0301\u0302\7u\2\2"+
		"\u0302\u0397\7u\2\2\u0303\u0304\7f\2\2\u0304\u0397\7q\2\2\u0305\u0306"+
		"\7g\2\2\u0306\u0307\7z\2\2\u0307\u0308\7v\2\2\u0308\u0309\7g\2\2\u0309"+
		"\u030a\7p\2\2\u030a\u030b\7f\2\2\u030b\u0397\7u\2\2\u030c\u030d\7h\2\2"+
		"\u030d\u030e\7k\2\2\u030e\u030f\7p\2\2\u030f\u0310\7c\2\2\u0310\u0397"+
		"\7n\2\2\u0311\u0312\7h\2\2\u0312\u0313\7k\2\2\u0313\u0314\7p\2\2\u0314"+
		"\u0315\7c\2\2\u0315\u0316\7n\2\2\u0316\u0317\7n\2\2\u0317\u0397\7{\2\2"+
		"\u0318\u0319\7h\2\2\u0319\u031a\7q\2\2\u031a\u0397\7t\2\2\u031b\u031c"+
		"\7h\2\2\u031c\u031d\7q\2\2\u031d\u031e\7t\2\2\u031e\u031f\7U\2\2\u031f"+
		"\u0320\7q\2\2\u0320\u0321\7o\2\2\u0321\u0397\7g\2\2\u0322\u0323\7k\2\2"+
		"\u0323\u0324\7o\2\2\u0324\u0325\7r\2\2\u0325\u0326\7n\2\2\u0326\u0327"+
		"\7k\2\2\u0327\u0328\7e\2\2\u0328\u0329\7k\2\2\u0329\u0397\7v\2\2\u032a"+
		"\u032b\7n\2\2\u032b\u032c\7c\2\2\u032c\u032d\7|\2\2\u032d\u0397\7{\2\2"+
		"\u032e\u032f\7o\2\2\u032f\u0330\7c\2\2\u0330\u0331\7e\2\2\u0331\u0332"+
		"\7t\2\2\u0332\u0397\7q\2\2\u0333\u0334\7o\2\2\u0334\u0335\7c\2\2\u0335"+
		"\u0336\7v\2\2\u0336\u0337\7e\2\2\u0337\u0397\7j\2\2\u0338\u0339\7p\2\2"+
		"\u0339\u033a\7g\2\2\u033a\u0397\7y\2\2\u033b\u033c\7p\2\2\u033c\u033d"+
		"\7w\2\2\u033d\u033e\7n\2\2\u033e\u0397\7n\2\2\u033f\u0340\7q\2\2\u0340"+
		"\u0341\7d\2\2\u0341\u0342\7l\2\2\u0342\u0343\7g\2\2\u0343\u0344\7e\2\2"+
		"\u0344\u0397\7v\2\2\u0345\u0346\7q\2\2\u0346\u0347\7x\2\2\u0347\u0348"+
		"\7g\2\2\u0348\u0349\7t\2\2\u0349\u034a\7t\2\2\u034a\u034b\7k\2\2\u034b"+
		"\u034c\7f\2\2\u034c\u0397\7g\2\2\u034d\u034e\7r\2\2\u034e\u034f\7c\2\2"+
		"\u034f\u0350\7e\2\2\u0350\u0351\7m\2\2\u0351\u0352\7c\2\2\u0352\u0353"+
		"\7i\2\2\u0353\u0397\7g\2\2\u0354\u0355\7r\2\2\u0355\u0356\7t\2\2\u0356"+
		"\u0357\7k\2\2\u0357\u0358\7x\2\2\u0358\u0359\7c\2\2\u0359\u035a\7v\2\2"+
		"\u035a\u0397\7g\2\2\u035b\u035c\7r\2\2\u035c\u035d\7t\2\2\u035d\u035e"+
		"\7q\2\2\u035e\u035f\7v\2\2\u035f\u0360\7g\2\2\u0360\u0361\7e\2\2\u0361"+
		"\u0362\7v\2\2\u0362\u0363\7g\2\2\u0363\u0397\7f\2\2\u0364\u0365\7u\2\2"+
		"\u0365\u0366\7g\2\2\u0366\u0367\7c\2\2\u0367\u0368\7n\2\2\u0368\u0369"+
		"\7g\2\2\u0369\u0397\7f\2\2\u036a\u036b\7u\2\2\u036b\u036c\7w\2\2\u036c"+
		"\u036d\7r\2\2\u036d\u036e\7g\2\2\u036e\u0397\7t\2\2\u036f\u0370\7v\2\2"+
		"\u0370\u0371\7j\2\2\u0371\u0372\7k\2\2\u0372\u0397\7u\2\2\u0373\u0374"+
		"\7v\2\2\u0374\u0375\7j\2\2\u0375\u0376\7t\2\2\u0376\u0377\7q\2\2\u0377"+
		"\u0397\7y\2\2\u0378\u0379\7v\2\2\u0379\u037a\7t\2\2\u037a\u037b\7c\2\2"+
		"\u037b\u037c\7k\2\2\u037c\u0397\7v\2\2\u037d\u037e\7v\2\2\u037e\u037f"+
		"\7t\2\2\u037f\u0397\7{\2\2\u0380\u0381\7v\2\2\u0381\u0382\7{\2\2\u0382"+
		"\u0383\7r\2\2\u0383\u0397\7g\2\2\u0384\u0385\7y\2\2\u0385\u0386\7k\2\2"+
		"\u0386\u0387\7v\2\2\u0387\u0397\7j\2\2\u0388\u0389\7{\2\2\u0389\u038a"+
		"\7k\2\2\u038a\u038b\7g\2\2\u038b\u038c\7n\2\2\u038c\u0397\7f\2\2\u038d"+
		"\u038e\7>\2\2\u038e\u0397\7/\2\2\u038f\u0390\7>\2\2\u0390\u0397\7<\2\2"+
		"\u0391\u0392\7>\2\2\u0392\u0397\7\'\2\2\u0393\u0394\7@\2\2\u0394\u0397"+
		"\7<\2\2\u0395\u0397\t\t\2\2\u0396\u02ed\3\2\2\2\u0396\u02f5\3\2\2\2\u0396"+
		"\u02f9\3\2\2\2\u0396\u02fe\3\2\2\2\u0396\u0303\3\2\2\2\u0396\u0305\3\2"+
		"\2\2\u0396\u030c\3\2\2\2\u0396\u0311\3\2\2\2\u0396\u0318\3\2\2\2\u0396"+
		"\u031b\3\2\2\2\u0396\u0322\3\2\2\2\u0396\u032a\3\2\2\2\u0396\u032e\3\2"+
		"\2\2\u0396\u0333\3\2\2\2\u0396\u0338\3\2\2\2\u0396\u033b\3\2\2\2\u0396"+
		"\u033f\3\2\2\2\u0396\u0345\3\2\2\2\u0396\u034d\3\2\2\2\u0396\u0354\3\2"+
		"\2\2\u0396\u035b\3\2\2\2\u0396\u0364\3\2\2\2\u0396\u036a\3\2\2\2\u0396"+
		"\u036f\3\2\2\2\u0396\u0373\3\2\2\2\u0396\u0378\3\2\2\2\u0396\u037d\3\2"+
		"\2\2\u0396\u0380\3\2\2\2\u0396\u0384\3\2\2\2\u0396\u0388\3\2\2\2\u0396"+
		"\u038d\3\2\2\2\u0396\u038f\3\2\2\2\u0396\u0391\3\2\2\2\u0396\u0393\3\2"+
		"\2\2\u0396\u0395\3\2\2\2\u0397\u00de\3\2\2\2\u0398\u0399\13\2\2\2\u0399"+
		"\u00e0\3\2\2\2\20\2\u029f\u02a3\u02a9\u02ac\u02b3\u02b6\u02bc\u02c3\u02ce"+
		"\u02d9\u02e2\u02e9\u0396\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}