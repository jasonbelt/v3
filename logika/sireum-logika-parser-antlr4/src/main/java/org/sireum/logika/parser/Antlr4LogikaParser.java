// Generated from /Users/robby/Repositories/Sireum-Private/sireum-v3/logika/sireum-logika-parser-antlr4/src/main/resources/org/sireum/logika/parser/Antlr4Logika.g4 by ANTLR 4.5.1
package org.sireum.logika.parser;

// @formatter:off

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class Antlr4LogikaParser extends Parser {
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
		T__94=95, T__95=96, T__96=97, T__97=98, T__98=99, T__99=100, T__100=101, 
		T__101=102, T__102=103, T__103=104, T__104=105, T__105=106, T__106=107, 
		T__107=108, T__108=109, T__109=110, T__110=111, T__111=112, T__112=113, 
		T__113=114, T__114=115, T__115=116, T__116=117, T__117=118, T__118=119, 
		T__119=120, T__120=121, T__121=122, T__122=123, T__123=124, HLINE=125, 
		NUM=126, ID=127, SSTRING=128, STRING=129, RESERVED=130, NL=131, LINE_COMMENT=132, 
		COMMENT=133, WS=134, ERROR_CHAR=135;
	public static final int
		RULE_sequentFile = 0, RULE_proofFile = 1, RULE_programFile = 2, RULE_sequent = 3, 
		RULE_proof = 4, RULE_proofStep = 5, RULE_formula = 6, RULE_qformula = 7, 
		RULE_type = 8, RULE_justification = 9, RULE_numOrId = 10, RULE_program = 11, 
		RULE_facts = 12, RULE_factOrFun = 13, RULE_fact = 14, RULE_fun = 15, RULE_param = 16, 
		RULE_stmts = 17, RULE_stmt = 18, RULE_exp = 19, RULE_loopInvariant = 20, 
		RULE_modifies = 21, RULE_methodContract = 22, RULE_invariants = 23;
	public static final String[] ruleNames = {
		"sequentFile", "proofFile", "programFile", "sequent", "proof", "proofStep", 
		"formula", "qformula", "type", "justification", "numOrId", "program", 
		"facts", "factOrFun", "fact", "fun", "param", "stmts", "stmt", "exp", 
		"loopInvariant", "modifies", "methodContract", "invariants"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "','", "'|-'", "'⊢'", "'{'", "'}'", "'.'", "':'", "'assume'", "'true'", 
		"'T'", "'⊤'", "'false'", "'F'", "'_|_'", "'⊥'", "'('", "')'", "'result'", 
		"'Z'", "'ZS'", "'*'", "'/'", "'%'", "'+'", "'-'", "'<'", "'<='", "'≤'", 
		"'>'", "'>='", "'≥'", "'='", "'=='", "'!='", "'≠'", "'not'", "'!'", "'~'", 
		"'¬'", "'and'", "'&&'", "'^'", "'∧'", "'or'", "'||'", "'V'", "'∨'", "'implies'", 
		"'->'", "'→'", "'forall'", "'all'", "'A'", "'∀'", "'exists'", "'some'", 
		"'E'", "'∃'", "'..'", "'|'", "'B'", "'premise'", "'andi'", "'^i'", "'ande1'", 
		"'^e1'", "'ande2'", "'^e2'", "'ori1'", "'Vi1'", "'ori2'", "'Vi2'", "'ore'", 
		"'Ve'", "'impliesi'", "'impliese'", "'noti'", "'negi'", "'note'", "'nege'", 
		"'bottome'", "'falsee'", "'Pbc'", "'subst1'", "'subst2'", "'algebra'", 
		"'foralli'", "'alli'", "'Ai'", "'foralle'", "'alle'", "'Ae'", "'existsi'", 
		"'somei'", "'Ei'", "'existse'", "'somee'", "'Ee'", "'invariant'", "'auto'", 
		"'import'", "'logika'", "'_'", "'l\"\"\"'", "'\"\"\"'", "'fact'", "'def'", 
		"'var'", "'val'", "'assert'", "'if'", "'else'", "'while'", "'print'", 
		"'println'", "'Unit'", "'return'", "'readInt'", "'+:'", "'modifies'", 
		"'requires'", "'pre'", "'ensures'", "'post'"
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
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, "HLINE", "NUM", "ID", "SSTRING", "STRING", 
		"RESERVED", "NL", "LINE_COMMENT", "COMMENT", "WS", "ERROR_CHAR"
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

	@Override
	public String getGrammarFileName() { return "Antlr4Logika.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public Antlr4LogikaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class SequentFileContext extends ParserRuleContext {
		public SequentContext sequent() {
			return getRuleContext(SequentContext.class,0);
		}
		public TerminalNode EOF() { return getToken(Antlr4LogikaParser.EOF, 0); }
		public List<TerminalNode> NL() { return getTokens(Antlr4LogikaParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(Antlr4LogikaParser.NL, i);
		}
		public ProofContext proof() {
			return getRuleContext(ProofContext.class,0);
		}
		public SequentFileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sequentFile; }
	}

	public final SequentFileContext sequentFile() throws RecognitionException {
		SequentFileContext _localctx = new SequentFileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_sequentFile);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			sequent();
			setState(52);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(49);
					match(NL);
					}
					} 
				}
				setState(54);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(56);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(55);
				proof();
				}
			}

			setState(61);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(58);
				match(NL);
				}
				}
				setState(63);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(64);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProofFileContext extends ParserRuleContext {
		public ProofContext proof() {
			return getRuleContext(ProofContext.class,0);
		}
		public TerminalNode EOF() { return getToken(Antlr4LogikaParser.EOF, 0); }
		public ProofFileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_proofFile; }
	}

	public final ProofFileContext proofFile() throws RecognitionException {
		ProofFileContext _localctx = new ProofFileContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_proofFile);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			proof();
			setState(67);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProgramFileContext extends ParserRuleContext {
		public ProgramContext program() {
			return getRuleContext(ProgramContext.class,0);
		}
		public TerminalNode EOF() { return getToken(Antlr4LogikaParser.EOF, 0); }
		public ProgramFileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programFile; }
	}

	public final ProgramFileContext programFile() throws RecognitionException {
		ProgramFileContext _localctx = new ProgramFileContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_programFile);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			program();
			setState(70);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SequentContext extends ParserRuleContext {
		public FormulaContext formula;
		public List<FormulaContext> premises = new ArrayList<FormulaContext>();
		public List<FormulaContext> conclusions = new ArrayList<FormulaContext>();
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public TerminalNode HLINE() { return getToken(Antlr4LogikaParser.HLINE, 0); }
		public SequentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sequent; }
	}

	public final SequentContext sequent() throws RecognitionException {
		SequentContext _localctx = new SequentContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_sequent);
		int _la;
		try {
			setState(103);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(80);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57))) != 0) || _la==NUM || _la==ID) {
					{
					setState(72);
					((SequentContext)_localctx).formula = formula(0);
					((SequentContext)_localctx).premises.add(((SequentContext)_localctx).formula);
					setState(77);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(73);
						match(T__0);
						setState(74);
						((SequentContext)_localctx).formula = formula(0);
						((SequentContext)_localctx).premises.add(((SequentContext)_localctx).formula);
						}
						}
						setState(79);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(82);
				_la = _input.LA(1);
				if ( !(_la==T__1 || _la==T__2) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(83);
				((SequentContext)_localctx).formula = formula(0);
				((SequentContext)_localctx).conclusions.add(((SequentContext)_localctx).formula);
				setState(88);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(84);
					match(T__0);
					setState(85);
					((SequentContext)_localctx).formula = formula(0);
					((SequentContext)_localctx).conclusions.add(((SequentContext)_localctx).formula);
					}
					}
					setState(90);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(94);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57))) != 0) || _la==NUM || _la==ID) {
					{
					{
					setState(91);
					((SequentContext)_localctx).formula = formula(0);
					((SequentContext)_localctx).premises.add(((SequentContext)_localctx).formula);
					}
					}
					setState(96);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(97);
				match(HLINE);
				setState(99); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(98);
					((SequentContext)_localctx).formula = formula(0);
					((SequentContext)_localctx).conclusions.add(((SequentContext)_localctx).formula);
					}
					}
					setState(101); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57))) != 0) || _la==NUM || _la==ID );
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProofContext extends ParserRuleContext {
		public Token tb;
		public Token te;
		public List<ProofStepContext> proofStep() {
			return getRuleContexts(ProofStepContext.class);
		}
		public ProofStepContext proofStep(int i) {
			return getRuleContext(ProofStepContext.class,i);
		}
		public List<TerminalNode> NL() { return getTokens(Antlr4LogikaParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(Antlr4LogikaParser.NL, i);
		}
		public ProofContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_proof; }
	}

	public final ProofContext proof() throws RecognitionException {
		ProofContext _localctx = new ProofContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_proof);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			((ProofContext)_localctx).tb = match(T__3);
			setState(107);
			_la = _input.LA(1);
			if (_la==NUM) {
				{
				setState(106);
				proofStep();
				}
			}

			setState(119);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(110); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(109);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(112); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(115);
				_la = _input.LA(1);
				if (_la==NUM) {
					{
					setState(114);
					proofStep();
					}
				}

				}
				}
				setState(121);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(122);
			((ProofContext)_localctx).te = match(T__4);
			setState(126);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(123);
					match(NL);
					}
					} 
				}
				setState(128);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProofStepContext extends ParserRuleContext {
		public ProofStepContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_proofStep; }
	 
		public ProofStepContext() { }
		public void copyFrom(ProofStepContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SubProofContext extends ProofStepContext {
		public Token sub;
		public Token assume;
		public Token ate;
		public List<TerminalNode> NUM() { return getTokens(Antlr4LogikaParser.NUM); }
		public TerminalNode NUM(int i) {
			return getToken(Antlr4LogikaParser.NUM, i);
		}
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public List<TerminalNode> NL() { return getTokens(Antlr4LogikaParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(Antlr4LogikaParser.NL, i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<ProofStepContext> proofStep() {
			return getRuleContexts(ProofStepContext.class);
		}
		public ProofStepContext proofStep(int i) {
			return getRuleContext(ProofStepContext.class,i);
		}
		public SubProofContext(ProofStepContext ctx) { copyFrom(ctx); }
	}
	public static class StepContext extends ProofStepContext {
		public TerminalNode NUM() { return getToken(Antlr4LogikaParser.NUM, 0); }
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public JustificationContext justification() {
			return getRuleContext(JustificationContext.class,0);
		}
		public StepContext(ProofStepContext ctx) { copyFrom(ctx); }
	}

	public final ProofStepContext proofStep() throws RecognitionException {
		ProofStepContext _localctx = new ProofStepContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_proofStep);
		int _la;
		try {
			int _alt;
			setState(183);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				_localctx = new StepContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(129);
				match(NUM);
				setState(130);
				match(T__5);
				setState(131);
				formula(0);
				setState(132);
				justification();
				}
				break;
			case 2:
				_localctx = new SubProofContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(134);
				((SubProofContext)_localctx).sub = match(NUM);
				setState(135);
				match(T__5);
				setState(139);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(136);
					match(NL);
					}
					}
					setState(141);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(142);
				match(T__3);
				setState(146);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(143);
					match(NL);
					}
					}
					setState(148);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(149);
				((SubProofContext)_localctx).assume = match(NUM);
				setState(150);
				match(T__5);
				setState(167);
				switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
				case 1:
					{
					setState(151);
					match(ID);
					setState(154);
					_la = _input.LA(1);
					if (_la==T__6) {
						{
						setState(152);
						match(T__6);
						setState(153);
						type();
						}
					}

					}
					break;
				case 2:
					{
					setState(156);
					formula(0);
					setState(157);
					((SubProofContext)_localctx).ate = match(T__7);
					}
					break;
				case 3:
					{
					setState(159);
					match(ID);
					setState(162);
					_la = _input.LA(1);
					if (_la==T__6) {
						{
						setState(160);
						match(T__6);
						setState(161);
						type();
						}
					}

					setState(164);
					formula(0);
					setState(165);
					((SubProofContext)_localctx).ate = match(T__7);
					}
					break;
				}
				setState(179);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(170); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(169);
							match(NL);
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(172); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					setState(175);
					_la = _input.LA(1);
					if (_la==NUM) {
						{
						setState(174);
						proofStep();
						}
					}

					}
					}
					setState(181);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(182);
				match(T__4);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormulaContext extends ParserRuleContext {
		public FormulaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formula; }
	 
		public FormulaContext() { }
		public void copyFrom(FormulaContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class VarContext extends FormulaContext {
		public Token tb;
		public Token te;
		public List<TerminalNode> ID() { return getTokens(Antlr4LogikaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(Antlr4LogikaParser.ID, i);
		}
		public VarContext(FormulaContext ctx) { copyFrom(ctx); }
	}
	public static class ApplyContext extends FormulaContext {
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public ApplyContext(FormulaContext ctx) { copyFrom(ctx); }
	}
	public static class BigIntContext extends FormulaContext {
		public TerminalNode STRING() { return getToken(Antlr4LogikaParser.STRING, 0); }
		public BigIntContext(FormulaContext ctx) { copyFrom(ctx); }
	}
	public static class BinaryContext extends FormulaContext {
		public FormulaContext l;
		public Token op;
		public FormulaContext r;
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public TerminalNode NL() { return getToken(Antlr4LogikaParser.NL, 0); }
		public BinaryContext(FormulaContext ctx) { copyFrom(ctx); }
	}
	public static class BooleanContext extends FormulaContext {
		public Token t;
		public BooleanContext(FormulaContext ctx) { copyFrom(ctx); }
	}
	public static class UnaryContext extends FormulaContext {
		public Token op;
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public UnaryContext(FormulaContext ctx) { copyFrom(ctx); }
	}
	public static class IntContext extends FormulaContext {
		public TerminalNode NUM() { return getToken(Antlr4LogikaParser.NUM, 0); }
		public IntContext(FormulaContext ctx) { copyFrom(ctx); }
	}
	public static class SeqContext extends FormulaContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public SeqContext(FormulaContext ctx) { copyFrom(ctx); }
	}
	public static class ParenContext extends FormulaContext {
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public ParenContext(FormulaContext ctx) { copyFrom(ctx); }
	}
	public static class ResultContext extends FormulaContext {
		public ResultContext(FormulaContext ctx) { copyFrom(ctx); }
	}
	public static class QuantContext extends FormulaContext {
		public QformulaContext qformula() {
			return getRuleContext(QformulaContext.class,0);
		}
		public QuantContext(FormulaContext ctx) { copyFrom(ctx); }
	}

	public final FormulaContext formula() throws RecognitionException {
		return formula(0);
	}

	private FormulaContext formula(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		FormulaContext _localctx = new FormulaContext(_ctx, _parentState);
		FormulaContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_formula, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(232);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				{
				_localctx = new UnaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(186);
				((UnaryContext)_localctx).op = match(T__24);
				setState(187);
				formula(6);
				}
				break;
			case 2:
				{
				_localctx = new UnaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(188);
				((UnaryContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38))) != 0)) ) {
					((UnaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(189);
				formula(5);
				}
				break;
			case 3:
				{
				_localctx = new BooleanContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(190);
				((BooleanContext)_localctx).t = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14))) != 0)) ) {
					((BooleanContext)_localctx).t = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				break;
			case 4:
				{
				_localctx = new VarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(191);
				((VarContext)_localctx).tb = match(ID);
				setState(194);
				switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
				case 1:
					{
					setState(192);
					match(T__5);
					setState(193);
					((VarContext)_localctx).te = match(ID);
					}
					break;
				}
				}
				break;
			case 5:
				{
				_localctx = new ParenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(196);
				match(T__15);
				setState(197);
				formula(0);
				setState(198);
				match(T__16);
				}
				break;
			case 6:
				{
				_localctx = new ResultContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(200);
				match(T__17);
				}
				break;
			case 7:
				{
				_localctx = new ApplyContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(201);
				match(ID);
				setState(202);
				match(T__15);
				setState(203);
				formula(0);
				setState(208);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(204);
					match(T__0);
					setState(205);
					formula(0);
					}
					}
					setState(210);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(211);
				match(T__16);
				}
				break;
			case 8:
				{
				_localctx = new IntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(213);
				match(NUM);
				}
				break;
			case 9:
				{
				_localctx = new BigIntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(214);
				match(T__18);
				setState(215);
				match(T__15);
				setState(216);
				match(STRING);
				setState(217);
				match(T__16);
				}
				break;
			case 10:
				{
				_localctx = new SeqContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(218);
				match(T__19);
				setState(219);
				match(T__15);
				setState(228);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__36))) != 0) || ((((_la - 118)) & ~0x3f) == 0 && ((1L << (_la - 118)) & ((1L << (T__117 - 118)) | (1L << (NUM - 118)) | (1L << (ID - 118)))) != 0)) {
					{
					setState(220);
					exp(0);
					setState(225);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(221);
						match(T__0);
						setState(222);
						exp(0);
						}
						}
						setState(227);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(230);
				match(T__16);
				}
				break;
			case 11:
				{
				_localctx = new QuantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(231);
				qformula();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(278);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(276);
					switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(234);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(235);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__20) | (1L << T__21) | (1L << T__22))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(237);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(236);
							match(NL);
							}
						}

						setState(239);
						((BinaryContext)_localctx).r = formula(11);
						}
						break;
					case 2:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(240);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(241);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__23 || _la==T__24) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(243);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(242);
							match(NL);
							}
						}

						setState(245);
						((BinaryContext)_localctx).r = formula(10);
						}
						break;
					case 3:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(246);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(247);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(249);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(248);
							match(NL);
							}
						}

						setState(251);
						((BinaryContext)_localctx).r = formula(9);
						}
						break;
					case 4:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(252);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(253);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(255);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(254);
							match(NL);
							}
						}

						setState(257);
						((BinaryContext)_localctx).r = formula(8);
						}
						break;
					case 5:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(258);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(259);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(261);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(260);
							match(NL);
							}
						}

						setState(263);
						((BinaryContext)_localctx).r = formula(5);
						}
						break;
					case 6:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(264);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(265);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(267);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(266);
							match(NL);
							}
						}

						setState(269);
						((BinaryContext)_localctx).r = formula(4);
						}
						break;
					case 7:
						{
						_localctx = new BinaryContext(new FormulaContext(_parentctx, _parentState));
						((BinaryContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_formula);
						setState(270);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(271);
						((BinaryContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__47) | (1L << T__48) | (1L << T__49))) != 0)) ) {
							((BinaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(273);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(272);
							match(NL);
							}
						}

						setState(275);
						((BinaryContext)_localctx).r = formula(3);
						}
						break;
					}
					} 
				}
				setState(280);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class QformulaContext extends ParserRuleContext {
		public Token q;
		public Token ID;
		public List<Token> vars = new ArrayList<Token>();
		public ExpContext lo;
		public Token ll;
		public Token lh;
		public ExpContext hi;
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(Antlr4LogikaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(Antlr4LogikaParser.ID, i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode NL() { return getToken(Antlr4LogikaParser.NL, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public QformulaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qformula; }
	}

	public final QformulaContext qformula() throws RecognitionException {
		QformulaContext _localctx = new QformulaContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_qformula);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(281);
			((QformulaContext)_localctx).q = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57))) != 0)) ) {
				((QformulaContext)_localctx).q = (Token)_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(282);
			((QformulaContext)_localctx).ID = match(ID);
			((QformulaContext)_localctx).vars.add(((QformulaContext)_localctx).ID);
			setState(287);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(283);
				match(T__0);
				setState(284);
				((QformulaContext)_localctx).ID = match(ID);
				((QformulaContext)_localctx).vars.add(((QformulaContext)_localctx).ID);
				}
				}
				setState(289);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(303);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				{
				setState(290);
				match(T__6);
				setState(291);
				type();
				}
				break;
			case 2:
				{
				setState(292);
				match(T__6);
				setState(293);
				((QformulaContext)_localctx).lo = exp(0);
				setState(295);
				_la = _input.LA(1);
				if (_la==T__25) {
					{
					setState(294);
					((QformulaContext)_localctx).ll = match(T__25);
					}
				}

				setState(297);
				match(T__58);
				setState(299);
				_la = _input.LA(1);
				if (_la==T__25) {
					{
					setState(298);
					((QformulaContext)_localctx).lh = match(T__25);
					}
				}

				setState(301);
				((QformulaContext)_localctx).hi = exp(0);
				}
				break;
			}
			setState(305);
			match(T__59);
			setState(307);
			_la = _input.LA(1);
			if (_la==NL) {
				{
				setState(306);
				match(NL);
				}
			}

			setState(309);
			formula(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	 
		public TypeContext() { }
		public void copyFrom(TypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BooleanTypeContext extends TypeContext {
		public Token t;
		public BooleanTypeContext(TypeContext ctx) { copyFrom(ctx); }
	}
	public static class IntSeqTypeContext extends TypeContext {
		public Token t;
		public IntSeqTypeContext(TypeContext ctx) { copyFrom(ctx); }
	}
	public static class IntTypeContext extends TypeContext {
		public Token t;
		public IntTypeContext(TypeContext ctx) { copyFrom(ctx); }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_type);
		try {
			setState(314);
			switch (_input.LA(1)) {
			case T__60:
				_localctx = new BooleanTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(311);
				((BooleanTypeContext)_localctx).t = match(T__60);
				}
				break;
			case T__18:
				_localctx = new IntTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(312);
				((IntTypeContext)_localctx).t = match(T__18);
				}
				break;
			case T__19:
				_localctx = new IntSeqTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(313);
				((IntSeqTypeContext)_localctx).t = match(T__19);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class JustificationContext extends ParserRuleContext {
		public JustificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_justification; }
	 
		public JustificationContext() { }
		public void copyFrom(JustificationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class InvariantContext extends JustificationContext {
		public Token tb;
		public InvariantContext(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class ForallElimContext extends JustificationContext {
		public Token tb;
		public NumOrIdContext stepOrFact;
		public NumOrIdContext numOrId() {
			return getRuleContext(NumOrIdContext.class,0);
		}
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public ForallElimContext(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class ExistsIntroContext extends JustificationContext {
		public Token tb;
		public Token existsStep;
		public TerminalNode NUM() { return getToken(Antlr4LogikaParser.NUM, 0); }
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
		public ExistsIntroContext(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class AndIntroContext extends JustificationContext {
		public Token tb;
		public Token lStep;
		public Token rStep;
		public List<TerminalNode> NUM() { return getTokens(Antlr4LogikaParser.NUM); }
		public TerminalNode NUM(int i) {
			return getToken(Antlr4LogikaParser.NUM, i);
		}
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
		public AndIntroContext(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class OrIntroContext extends JustificationContext {
		public Token tb;
		public Token step;
		public TerminalNode NUM() { return getToken(Antlr4LogikaParser.NUM, 0); }
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
		public OrIntroContext(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class ForallIntroContext extends JustificationContext {
		public Token tb;
		public Token subProof;
		public TerminalNode NUM() { return getToken(Antlr4LogikaParser.NUM, 0); }
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
		public ForallIntroContext(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class ExistsElimContext extends JustificationContext {
		public Token tb;
		public NumOrIdContext stepOrFact;
		public Token subproof;
		public Token t;
		public Token subProof;
		public NumOrIdContext numOrId() {
			return getRuleContext(NumOrIdContext.class,0);
		}
		public TerminalNode NUM() { return getToken(Antlr4LogikaParser.NUM, 0); }
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
		public ExistsElimContext(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class ImpliesElimContext extends JustificationContext {
		public Token tb;
		public Token impliesStep;
		public Token antecedentStep;
		public List<TerminalNode> NUM() { return getTokens(Antlr4LogikaParser.NUM); }
		public TerminalNode NUM(int i) {
			return getToken(Antlr4LogikaParser.NUM, i);
		}
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
		public ImpliesElimContext(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class PremiseContext extends JustificationContext {
		public Token t;
		public PremiseContext(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class AndElimContext extends JustificationContext {
		public Token tb;
		public Token andStep;
		public TerminalNode NUM() { return getToken(Antlr4LogikaParser.NUM, 0); }
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
		public AndElimContext(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class NegIntroContext extends JustificationContext {
		public Token tb;
		public Token subProof;
		public TerminalNode NUM() { return getToken(Antlr4LogikaParser.NUM, 0); }
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
		public NegIntroContext(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class NegElimContext extends JustificationContext {
		public Token tb;
		public Token step;
		public Token negStep;
		public List<TerminalNode> NUM() { return getTokens(Antlr4LogikaParser.NUM); }
		public TerminalNode NUM(int i) {
			return getToken(Antlr4LogikaParser.NUM, i);
		}
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
		public NegElimContext(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class PbcContext extends JustificationContext {
		public Token tb;
		public Token subProof;
		public TerminalNode NUM() { return getToken(Antlr4LogikaParser.NUM, 0); }
		public PbcContext(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class Subst2Context extends JustificationContext {
		public Token tb;
		public NumOrIdContext eqStep;
		public Token step;
		public NumOrIdContext numOrId() {
			return getRuleContext(NumOrIdContext.class,0);
		}
		public TerminalNode NUM() { return getToken(Antlr4LogikaParser.NUM, 0); }
		public Subst2Context(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class AutoContext extends JustificationContext {
		public Token tb;
		public NumOrIdContext numOrId;
		public List<NumOrIdContext> stepOrFacts = new ArrayList<NumOrIdContext>();
		public List<NumOrIdContext> numOrId() {
			return getRuleContexts(NumOrIdContext.class);
		}
		public NumOrIdContext numOrId(int i) {
			return getRuleContext(NumOrIdContext.class,i);
		}
		public AutoContext(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class Subst1Context extends JustificationContext {
		public Token tb;
		public NumOrIdContext eqStep;
		public Token step;
		public NumOrIdContext numOrId() {
			return getRuleContext(NumOrIdContext.class,0);
		}
		public TerminalNode NUM() { return getToken(Antlr4LogikaParser.NUM, 0); }
		public Subst1Context(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class AlgebraContext extends JustificationContext {
		public Token tb;
		public NumOrIdContext numOrId;
		public List<NumOrIdContext> steps = new ArrayList<NumOrIdContext>();
		public List<NumOrIdContext> numOrId() {
			return getRuleContexts(NumOrIdContext.class);
		}
		public NumOrIdContext numOrId(int i) {
			return getRuleContext(NumOrIdContext.class,i);
		}
		public AlgebraContext(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class BottomElimContext extends JustificationContext {
		public Token tb;
		public Token bottomStep;
		public TerminalNode NUM() { return getToken(Antlr4LogikaParser.NUM, 0); }
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
		public BottomElimContext(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class OrElimContext extends JustificationContext {
		public Token tb;
		public Token orStep;
		public Token lSubProof;
		public Token rSubProof;
		public List<TerminalNode> NUM() { return getTokens(Antlr4LogikaParser.NUM); }
		public TerminalNode NUM(int i) {
			return getToken(Antlr4LogikaParser.NUM, i);
		}
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
		public OrElimContext(JustificationContext ctx) { copyFrom(ctx); }
	}
	public static class ImpliesIntroContext extends JustificationContext {
		public Token tb;
		public Token subProof;
		public TerminalNode NUM() { return getToken(Antlr4LogikaParser.NUM, 0); }
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
		public ImpliesIntroContext(JustificationContext ctx) { copyFrom(ctx); }
	}

	public final JustificationContext justification() throws RecognitionException {
		JustificationContext _localctx = new JustificationContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_justification);
		int _la;
		try {
			setState(448);
			switch ( getInterpreter().adaptivePredict(_input,59,_ctx) ) {
			case 1:
				_localctx = new PremiseContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(316);
				((PremiseContext)_localctx).t = match(T__61);
				}
				break;
			case 2:
				_localctx = new AndIntroContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(320);
				switch (_input.LA(1)) {
				case T__62:
				case T__63:
					{
					setState(317);
					((AndIntroContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__62 || _la==T__63) ) {
						((AndIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					break;
				case T__40:
				case T__42:
					{
					setState(318);
					((AndIntroContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__40 || _la==T__42) ) {
						((AndIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(319);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(322);
				((AndIntroContext)_localctx).lStep = match(NUM);
				setState(323);
				((AndIntroContext)_localctx).rStep = match(NUM);
				}
				break;
			case 3:
				_localctx = new AndElimContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(327);
				switch (_input.LA(1)) {
				case T__64:
				case T__65:
				case T__66:
				case T__67:
					{
					setState(324);
					((AndElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (T__64 - 65)) | (1L << (T__65 - 65)) | (1L << (T__66 - 65)) | (1L << (T__67 - 65)))) != 0)) ) {
						((AndElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					break;
				case T__40:
				case T__42:
					{
					setState(325);
					((AndElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__40 || _la==T__42) ) {
						((AndElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(326);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(329);
				((AndElimContext)_localctx).andStep = match(NUM);
				}
				break;
			case 4:
				_localctx = new OrIntroContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(333);
				switch (_input.LA(1)) {
				case T__68:
				case T__69:
				case T__70:
				case T__71:
					{
					setState(330);
					((OrIntroContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (T__68 - 69)) | (1L << (T__69 - 69)) | (1L << (T__70 - 69)) | (1L << (T__71 - 69)))) != 0)) ) {
						((OrIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					break;
				case T__44:
				case T__46:
					{
					setState(331);
					((OrIntroContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__44 || _la==T__46) ) {
						((OrIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(332);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(335);
				((OrIntroContext)_localctx).step = match(NUM);
				}
				break;
			case 5:
				_localctx = new OrElimContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(339);
				switch (_input.LA(1)) {
				case T__72:
				case T__73:
					{
					setState(336);
					((OrElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__72 || _la==T__73) ) {
						((OrElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					break;
				case T__44:
				case T__46:
					{
					setState(337);
					((OrElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__44 || _la==T__46) ) {
						((OrElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(338);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(341);
				((OrElimContext)_localctx).orStep = match(NUM);
				setState(342);
				((OrElimContext)_localctx).lSubProof = match(NUM);
				setState(343);
				((OrElimContext)_localctx).rSubProof = match(NUM);
				}
				break;
			case 6:
				_localctx = new ImpliesIntroContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(347);
				switch (_input.LA(1)) {
				case T__74:
					{
					setState(344);
					((ImpliesIntroContext)_localctx).tb = match(T__74);
					}
					break;
				case T__48:
				case T__49:
					{
					setState(345);
					((ImpliesIntroContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__48 || _la==T__49) ) {
						((ImpliesIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(346);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(349);
				((ImpliesIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case 7:
				_localctx = new ImpliesElimContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(353);
				switch (_input.LA(1)) {
				case T__75:
					{
					setState(350);
					((ImpliesElimContext)_localctx).tb = match(T__75);
					}
					break;
				case T__48:
				case T__49:
					{
					setState(351);
					((ImpliesElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__48 || _la==T__49) ) {
						((ImpliesElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(352);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(355);
				((ImpliesElimContext)_localctx).impliesStep = match(NUM);
				setState(356);
				((ImpliesElimContext)_localctx).antecedentStep = match(NUM);
				}
				break;
			case 8:
				_localctx = new NegIntroContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(360);
				switch (_input.LA(1)) {
				case T__76:
				case T__77:
					{
					setState(357);
					((NegIntroContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__76 || _la==T__77) ) {
						((NegIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					break;
				case T__36:
				case T__37:
				case T__38:
					{
					setState(358);
					((NegIntroContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__36) | (1L << T__37) | (1L << T__38))) != 0)) ) {
						((NegIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(359);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(362);
				((NegIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case 9:
				_localctx = new NegElimContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(367);
				switch (_input.LA(1)) {
				case T__78:
					{
					setState(363);
					((NegElimContext)_localctx).tb = match(T__78);
					}
					break;
				case T__79:
					{
					setState(364);
					((NegElimContext)_localctx).tb = match(T__79);
					}
					break;
				case T__36:
				case T__37:
				case T__38:
					{
					setState(365);
					((NegElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__36) | (1L << T__37) | (1L << T__38))) != 0)) ) {
						((NegElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(366);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(369);
				((NegElimContext)_localctx).step = match(NUM);
				setState(370);
				((NegElimContext)_localctx).negStep = match(NUM);
				}
				break;
			case 10:
				_localctx = new BottomElimContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(374);
				switch (_input.LA(1)) {
				case T__80:
				case T__81:
					{
					setState(371);
					((BottomElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__80 || _la==T__81) ) {
						((BottomElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					break;
				case T__13:
				case T__14:
					{
					setState(372);
					((BottomElimContext)_localctx).tb = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__13 || _la==T__14) ) {
						((BottomElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(373);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(376);
				((BottomElimContext)_localctx).bottomStep = match(NUM);
				}
				break;
			case 11:
				_localctx = new PbcContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(377);
				((PbcContext)_localctx).tb = match(T__82);
				setState(378);
				((PbcContext)_localctx).subProof = match(NUM);
				}
				break;
			case 12:
				_localctx = new Subst1Context(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(379);
				((Subst1Context)_localctx).tb = match(T__83);
				setState(380);
				((Subst1Context)_localctx).eqStep = numOrId();
				setState(381);
				((Subst1Context)_localctx).step = match(NUM);
				}
				break;
			case 13:
				_localctx = new Subst2Context(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(383);
				((Subst2Context)_localctx).tb = match(T__84);
				setState(384);
				((Subst2Context)_localctx).eqStep = numOrId();
				setState(385);
				((Subst2Context)_localctx).step = match(NUM);
				}
				break;
			case 14:
				_localctx = new AlgebraContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(387);
				((AlgebraContext)_localctx).tb = match(T__85);
				setState(391);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NUM || _la==ID) {
					{
					{
					setState(388);
					((AlgebraContext)_localctx).numOrId = numOrId();
					((AlgebraContext)_localctx).steps.add(((AlgebraContext)_localctx).numOrId);
					}
					}
					setState(393);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 15:
				_localctx = new ForallIntroContext(_localctx);
				enterOuterAlt(_localctx, 15);
				{
				setState(399);
				switch (_input.LA(1)) {
				case T__86:
					{
					setState(394);
					((ForallIntroContext)_localctx).tb = match(T__86);
					}
					break;
				case T__87:
					{
					setState(395);
					((ForallIntroContext)_localctx).tb = match(T__87);
					}
					break;
				case T__88:
					{
					setState(396);
					((ForallIntroContext)_localctx).tb = match(T__88);
					}
					break;
				case T__53:
					{
					setState(397);
					((ForallIntroContext)_localctx).tb = match(T__53);
					setState(398);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(401);
				((ForallIntroContext)_localctx).subProof = match(NUM);
				}
				break;
			case 16:
				_localctx = new ForallElimContext(_localctx);
				enterOuterAlt(_localctx, 16);
				{
				setState(407);
				switch (_input.LA(1)) {
				case T__89:
					{
					setState(402);
					((ForallElimContext)_localctx).tb = match(T__89);
					}
					break;
				case T__90:
					{
					setState(403);
					((ForallElimContext)_localctx).tb = match(T__90);
					}
					break;
				case T__91:
					{
					setState(404);
					((ForallElimContext)_localctx).tb = match(T__91);
					}
					break;
				case T__53:
					{
					setState(405);
					((ForallElimContext)_localctx).tb = match(T__53);
					setState(406);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(409);
				((ForallElimContext)_localctx).stepOrFact = numOrId();
				setState(411); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(410);
					formula(0);
					}
					}
					setState(413); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57))) != 0) || _la==NUM || _la==ID );
				}
				break;
			case 17:
				_localctx = new ExistsIntroContext(_localctx);
				enterOuterAlt(_localctx, 17);
				{
				setState(415);
				((ExistsIntroContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 93)) & ~0x3f) == 0 && ((1L << (_la - 93)) & ((1L << (T__92 - 93)) | (1L << (T__93 - 93)) | (1L << (T__94 - 93)))) != 0)) ) {
					((ExistsIntroContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(416);
				((ExistsIntroContext)_localctx).existsStep = match(NUM);
				setState(418); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(417);
					formula(0);
					}
					}
					setState(420); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57))) != 0) || _la==NUM || _la==ID );
				}
				break;
			case 18:
				_localctx = new ExistsElimContext(_localctx);
				enterOuterAlt(_localctx, 18);
				{
				setState(422);
				((ExistsElimContext)_localctx).tb = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 96)) & ~0x3f) == 0 && ((1L << (_la - 96)) & ((1L << (T__95 - 96)) | (1L << (T__96 - 96)) | (1L << (T__97 - 96)))) != 0)) ) {
					((ExistsElimContext)_localctx).tb = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(423);
				((ExistsElimContext)_localctx).stepOrFact = numOrId();
				setState(424);
				((ExistsElimContext)_localctx).subproof = match(NUM);
				}
				break;
			case 19:
				_localctx = new ExistsIntroContext(_localctx);
				enterOuterAlt(_localctx, 19);
				{
				setState(426);
				if (!("∃".equals(_input.LT(1).getText()) &&
				     "i".equals(_input.LT(2).getText()))) throw new FailedPredicateException(this, "\"∃\".equals(_input.LT(1).getText()) &&\n     \"i\".equals(_input.LT(2).getText())");
				setState(427);
				((ExistsIntroContext)_localctx).tb = match(T__57);
				setState(428);
				match(ID);
				setState(429);
				((ExistsIntroContext)_localctx).existsStep = match(NUM);
				setState(431); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(430);
					formula(0);
					}
					}
					setState(433); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57))) != 0) || _la==NUM || _la==ID );
				}
				break;
			case 20:
				_localctx = new ExistsElimContext(_localctx);
				enterOuterAlt(_localctx, 20);
				{
				setState(435);
				((ExistsElimContext)_localctx).tb = match(T__57);
				setState(436);
				((ExistsElimContext)_localctx).t = match(ID);
				setState(437);
				((ExistsElimContext)_localctx).stepOrFact = numOrId();
				setState(438);
				((ExistsElimContext)_localctx).subProof = match(NUM);
				}
				break;
			case 21:
				_localctx = new InvariantContext(_localctx);
				enterOuterAlt(_localctx, 21);
				{
				setState(440);
				((InvariantContext)_localctx).tb = match(T__98);
				}
				break;
			case 22:
				_localctx = new AutoContext(_localctx);
				enterOuterAlt(_localctx, 22);
				{
				setState(441);
				((AutoContext)_localctx).tb = match(T__99);
				setState(445);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NUM || _la==ID) {
					{
					{
					setState(442);
					((AutoContext)_localctx).numOrId = numOrId();
					((AutoContext)_localctx).stepOrFacts.add(((AutoContext)_localctx).numOrId);
					}
					}
					setState(447);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumOrIdContext extends ParserRuleContext {
		public Token t;
		public TerminalNode NUM() { return getToken(Antlr4LogikaParser.NUM, 0); }
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
		public NumOrIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numOrId; }
	}

	public final NumOrIdContext numOrId() throws RecognitionException {
		NumOrIdContext _localctx = new NumOrIdContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_numOrId);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(450);
			((NumOrIdContext)_localctx).t = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==NUM || _la==ID) ) {
				((NumOrIdContext)_localctx).t = (Token)_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProgramContext extends ParserRuleContext {
		public Token tb;
		public Token org;
		public Token sireum;
		public Token te;
		public List<TerminalNode> NL() { return getTokens(Antlr4LogikaParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(Antlr4LogikaParser.NL, i);
		}
		public StmtsContext stmts() {
			return getRuleContext(StmtsContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(Antlr4LogikaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(Antlr4LogikaParser.ID, i);
		}
		public FactsContext facts() {
			return getRuleContext(FactsContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_program);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(455);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(452);
				match(NL);
				}
				}
				setState(457);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(483);
			_la = _input.LA(1);
			if (_la==T__100) {
				{
				setState(458);
				((ProgramContext)_localctx).tb = match(T__100);
				setState(459);
				((ProgramContext)_localctx).org = match(ID);
				setState(460);
				match(T__5);
				setState(461);
				((ProgramContext)_localctx).sireum = match(ID);
				setState(462);
				match(T__5);
				setState(463);
				match(T__101);
				setState(464);
				match(T__5);
				setState(465);
				((ProgramContext)_localctx).te = match(T__102);
				setState(467); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(466);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(469); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,61,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(480);
				switch ( getInterpreter().adaptivePredict(_input,63,_ctx) ) {
				case 1:
					{
					setState(471);
					match(T__103);
					setState(472);
					facts();
					setState(473);
					((ProgramContext)_localctx).te = match(T__104);
					setState(477);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,62,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(474);
							match(NL);
							}
							} 
						}
						setState(479);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,62,_ctx);
					}
					}
					break;
				}
				setState(482);
				stmts();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FactsContext extends ParserRuleContext {
		public Token ftb;
		public Token te;
		public List<TerminalNode> NL() { return getTokens(Antlr4LogikaParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(Antlr4LogikaParser.NL, i);
		}
		public List<FactOrFunContext> factOrFun() {
			return getRuleContexts(FactOrFunContext.class);
		}
		public FactOrFunContext factOrFun(int i) {
			return getRuleContext(FactOrFunContext.class,i);
		}
		public FactsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_facts; }
	}

	public final FactsContext facts() throws RecognitionException {
		FactsContext _localctx = new FactsContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_facts);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(485);
			match(T__3);
			setState(489);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(486);
				match(NL);
				}
				}
				setState(491);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(492);
			((FactsContext)_localctx).ftb = match(T__105);
			setState(496);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,66,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(493);
					match(NL);
					}
					} 
				}
				setState(498);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,66,_ctx);
			}
			setState(500);
			_la = _input.LA(1);
			if (_la==T__106 || _la==ID) {
				{
				setState(499);
				factOrFun();
				}
			}

			setState(512);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(503); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(502);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(505); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,68,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(508);
				_la = _input.LA(1);
				if (_la==T__106 || _la==ID) {
					{
					setState(507);
					factOrFun();
					}
				}

				}
				}
				setState(514);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(515);
			((FactsContext)_localctx).te = match(T__4);
			setState(519);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(516);
				match(NL);
				}
				}
				setState(521);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FactOrFunContext extends ParserRuleContext {
		public FactContext fact() {
			return getRuleContext(FactContext.class,0);
		}
		public FunContext fun() {
			return getRuleContext(FunContext.class,0);
		}
		public FactOrFunContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factOrFun; }
	}

	public final FactOrFunContext factOrFun() throws RecognitionException {
		FactOrFunContext _localctx = new FactOrFunContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_factOrFun);
		try {
			setState(524);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(522);
				fact();
				}
				break;
			case T__106:
				enterOuterAlt(_localctx, 2);
				{
				setState(523);
				fun();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FactContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public FactContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fact; }
	}

	public final FactContext fact() throws RecognitionException {
		FactContext _localctx = new FactContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_fact);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(526);
			match(ID);
			setState(527);
			match(T__5);
			setState(528);
			formula(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunContext extends ParserRuleContext {
		public Token tb;
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode NL() { return getToken(Antlr4LogikaParser.NL, 0); }
		public FunContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fun; }
	}

	public final FunContext fun() throws RecognitionException {
		FunContext _localctx = new FunContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_fun);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(530);
			((FunContext)_localctx).tb = match(T__106);
			setState(531);
			match(ID);
			setState(533);
			_la = _input.LA(1);
			if (_la==NL) {
				{
				setState(532);
				match(NL);
				}
			}

			setState(535);
			match(T__15);
			setState(536);
			param();
			setState(541);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(537);
				match(T__0);
				setState(538);
				param();
				}
				}
				setState(543);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(544);
			match(T__16);
			setState(545);
			match(T__6);
			setState(546);
			type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(548);
			match(ID);
			setState(549);
			match(T__6);
			setState(550);
			type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StmtsContext extends ParserRuleContext {
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public List<TerminalNode> NL() { return getTokens(Antlr4LogikaParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(Antlr4LogikaParser.NL, i);
		}
		public StmtsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmts; }
	}

	public final StmtsContext stmts() throws RecognitionException {
		StmtsContext _localctx = new StmtsContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_stmts);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(553);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__36))) != 0) || ((((_la - 104)) & ~0x3f) == 0 && ((1L << (_la - 104)) & ((1L << (T__103 - 104)) | (1L << (T__106 - 104)) | (1L << (T__107 - 104)) | (1L << (T__108 - 104)) | (1L << (T__109 - 104)) | (1L << (T__110 - 104)) | (1L << (T__112 - 104)) | (1L << (T__113 - 104)) | (1L << (T__114 - 104)) | (1L << (T__117 - 104)) | (1L << (NUM - 104)) | (1L << (ID - 104)))) != 0)) {
				{
				setState(552);
				stmt();
				}
			}

			setState(565);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(556); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(555);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(558); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,76,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(561);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__36))) != 0) || ((((_la - 104)) & ~0x3f) == 0 && ((1L << (_la - 104)) & ((1L << (T__103 - 104)) | (1L << (T__106 - 104)) | (1L << (T__107 - 104)) | (1L << (T__108 - 104)) | (1L << (T__109 - 104)) | (1L << (T__110 - 104)) | (1L << (T__112 - 104)) | (1L << (T__113 - 104)) | (1L << (T__114 - 104)) | (1L << (T__117 - 104)) | (1L << (NUM - 104)) | (1L << (ID - 104)))) != 0)) {
					{
					setState(560);
					stmt();
					}
				}

				}
				}
				setState(567);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StmtContext extends ParserRuleContext {
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
	 
		public StmtContext() { }
		public void copyFrom(StmtContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SeqAssignStmtContext extends StmtContext {
		public Token tb;
		public ExpContext index;
		public ExpContext r;
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode NL() { return getToken(Antlr4LogikaParser.NL, 0); }
		public SeqAssignStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	public static class ExpStmtContext extends StmtContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public ExpStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	public static class AssignVarStmtContext extends StmtContext {
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode NL() { return getToken(Antlr4LogikaParser.NL, 0); }
		public AssignVarStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	public static class IfStmtContext extends StmtContext {
		public StmtsContext ts;
		public StmtsContext fs;
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public List<StmtsContext> stmts() {
			return getRuleContexts(StmtsContext.class);
		}
		public StmtsContext stmts(int i) {
			return getRuleContext(StmtsContext.class,i);
		}
		public List<TerminalNode> NL() { return getTokens(Antlr4LogikaParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(Antlr4LogikaParser.NL, i);
		}
		public IfStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	public static class PrintStmtContext extends StmtContext {
		public Token op;
		public TerminalNode SSTRING() { return getToken(Antlr4LogikaParser.SSTRING, 0); }
		public PrintStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	public static class MethodDeclStmtContext extends StmtContext {
		public Token rtb;
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
		public StmtsContext stmts() {
			return getRuleContext(StmtsContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> NL() { return getTokens(Antlr4LogikaParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(Antlr4LogikaParser.NL, i);
		}
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public MethodContractContext methodContract() {
			return getRuleContext(MethodContractContext.class,0);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public MethodDeclStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	public static class WhileStmtContext extends StmtContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public StmtsContext stmts() {
			return getRuleContext(StmtsContext.class,0);
		}
		public List<TerminalNode> NL() { return getTokens(Antlr4LogikaParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(Antlr4LogikaParser.NL, i);
		}
		public LoopInvariantContext loopInvariant() {
			return getRuleContext(LoopInvariantContext.class,0);
		}
		public WhileStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	public static class LogikaStmtContext extends StmtContext {
		public ProofContext proof() {
			return getRuleContext(ProofContext.class,0);
		}
		public SequentContext sequent() {
			return getRuleContext(SequentContext.class,0);
		}
		public InvariantsContext invariants() {
			return getRuleContext(InvariantsContext.class,0);
		}
		public LogikaStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	public static class VarDeclStmtContext extends StmtContext {
		public Token modifier;
		public TerminalNode ID() { return getToken(Antlr4LogikaParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode NL() { return getToken(Antlr4LogikaParser.NL, 0); }
		public VarDeclStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	public static class AssertStmtContext extends StmtContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public AssertStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_stmt);
		int _la;
		try {
			setState(725);
			switch ( getInterpreter().adaptivePredict(_input,99,_ctx) ) {
			case 1:
				_localctx = new VarDeclStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(568);
				((VarDeclStmtContext)_localctx).modifier = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__107 || _la==T__108) ) {
					((VarDeclStmtContext)_localctx).modifier = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(569);
				match(ID);
				setState(570);
				match(T__6);
				setState(571);
				type();
				setState(572);
				match(T__31);
				setState(574);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(573);
					match(NL);
					}
				}

				setState(576);
				exp(0);
				}
				break;
			case 2:
				_localctx = new AssignVarStmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(578);
				match(ID);
				setState(579);
				match(T__31);
				setState(581);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(580);
					match(NL);
					}
				}

				setState(583);
				exp(0);
				}
				break;
			case 3:
				_localctx = new AssertStmtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(584);
				match(T__109);
				setState(585);
				match(T__15);
				setState(586);
				exp(0);
				setState(587);
				match(T__16);
				}
				break;
			case 4:
				_localctx = new IfStmtContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(589);
				match(T__110);
				setState(590);
				match(T__15);
				setState(591);
				exp(0);
				setState(592);
				match(T__16);
				setState(596);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(593);
					match(NL);
					}
					}
					setState(598);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(599);
				match(T__3);
				setState(600);
				((IfStmtContext)_localctx).ts = stmts();
				setState(601);
				match(T__4);
				setState(613);
				_la = _input.LA(1);
				if (_la==T__111) {
					{
					setState(602);
					match(T__111);
					setState(606);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(603);
						match(NL);
						}
						}
						setState(608);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(609);
					match(T__3);
					setState(610);
					((IfStmtContext)_localctx).fs = stmts();
					setState(611);
					match(T__4);
					}
				}

				}
				break;
			case 5:
				_localctx = new WhileStmtContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(615);
				match(T__112);
				setState(616);
				match(T__15);
				setState(617);
				exp(0);
				setState(618);
				match(T__16);
				setState(622);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(619);
					match(NL);
					}
					}
					setState(624);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(625);
				match(T__3);
				setState(636);
				switch ( getInterpreter().adaptivePredict(_input,86,_ctx) ) {
				case 1:
					{
					setState(629);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(626);
						match(NL);
						}
						}
						setState(631);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(632);
					match(T__103);
					setState(633);
					loopInvariant();
					setState(634);
					match(T__104);
					}
					break;
				}
				setState(638);
				stmts();
				setState(639);
				match(T__4);
				}
				break;
			case 6:
				_localctx = new PrintStmtContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(641);
				((PrintStmtContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__113 || _la==T__114) ) {
					((PrintStmtContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(642);
				match(T__15);
				setState(643);
				match(SSTRING);
				setState(644);
				match(T__16);
				}
				break;
			case 7:
				_localctx = new SeqAssignStmtContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(645);
				((SeqAssignStmtContext)_localctx).tb = match(ID);
				setState(646);
				match(T__15);
				setState(647);
				((SeqAssignStmtContext)_localctx).index = exp(0);
				setState(648);
				match(T__16);
				setState(649);
				match(T__31);
				setState(651);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(650);
					match(NL);
					}
				}

				setState(653);
				((SeqAssignStmtContext)_localctx).r = exp(0);
				}
				break;
			case 8:
				_localctx = new MethodDeclStmtContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(655);
				match(T__106);
				setState(656);
				match(ID);
				setState(658);
				_la = _input.LA(1);
				if (_la==NL) {
					{
					setState(657);
					match(NL);
					}
				}

				setState(660);
				match(T__15);
				setState(669);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(661);
					param();
					setState(666);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(662);
						match(T__0);
						setState(663);
						param();
						}
						}
						setState(668);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(671);
				match(T__16);
				setState(672);
				match(T__6);
				setState(675);
				switch (_input.LA(1)) {
				case T__18:
				case T__19:
				case T__60:
					{
					setState(673);
					type();
					}
					break;
				case T__115:
					{
					setState(674);
					match(T__115);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(677);
				match(T__31);
				setState(681);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(678);
					match(NL);
					}
					}
					setState(683);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(684);
				match(T__3);
				setState(701);
				switch ( getInterpreter().adaptivePredict(_input,95,_ctx) ) {
				case 1:
					{
					setState(688);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(685);
						match(NL);
						}
						}
						setState(690);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(691);
					match(T__103);
					setState(692);
					methodContract();
					setState(696);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(693);
						match(NL);
						}
						}
						setState(698);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(699);
					match(T__104);
					}
					break;
				}
				setState(703);
				stmts();
				setState(712);
				_la = _input.LA(1);
				if (_la==T__116) {
					{
					setState(704);
					((MethodDeclStmtContext)_localctx).rtb = match(T__116);
					setState(705);
					exp(0);
					setState(709);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(706);
						match(NL);
						}
						}
						setState(711);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(714);
				match(T__4);
				}
				break;
			case 9:
				_localctx = new LogikaStmtContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(716);
				match(T__103);
				setState(720);
				switch ( getInterpreter().adaptivePredict(_input,98,_ctx) ) {
				case 1:
					{
					setState(717);
					proof();
					}
					break;
				case 2:
					{
					setState(718);
					sequent();
					}
					break;
				case 3:
					{
					setState(719);
					invariants();
					}
					break;
				}
				setState(722);
				match(T__104);
				}
				break;
			case 10:
				_localctx = new ExpStmtContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(724);
				exp(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpContext extends ParserRuleContext {
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
	 
		public ExpContext() { }
		public void copyFrom(ExpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IdExpContext extends ExpContext {
		public Token tb;
		public Token te;
		public List<TerminalNode> ID() { return getTokens(Antlr4LogikaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(Antlr4LogikaParser.ID, i);
		}
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public IdExpContext(ExpContext ctx) { copyFrom(ctx); }
	}
	public static class ParenExpContext extends ExpContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public ParenExpContext(ExpContext ctx) { copyFrom(ctx); }
	}
	public static class BooleanExpContext extends ExpContext {
		public Token t;
		public BooleanExpContext(ExpContext ctx) { copyFrom(ctx); }
	}
	public static class ReadIntExpContext extends ExpContext {
		public TerminalNode STRING() { return getToken(Antlr4LogikaParser.STRING, 0); }
		public ReadIntExpContext(ExpContext ctx) { copyFrom(ctx); }
	}
	public static class BigIntExpContext extends ExpContext {
		public TerminalNode STRING() { return getToken(Antlr4LogikaParser.STRING, 0); }
		public BigIntExpContext(ExpContext ctx) { copyFrom(ctx); }
	}
	public static class UnaryExpContext extends ExpContext {
		public Token op;
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public UnaryExpContext(ExpContext ctx) { copyFrom(ctx); }
	}
	public static class IntExpContext extends ExpContext {
		public TerminalNode NUM() { return getToken(Antlr4LogikaParser.NUM, 0); }
		public IntExpContext(ExpContext ctx) { copyFrom(ctx); }
	}
	public static class SeqExpContext extends ExpContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public SeqExpContext(ExpContext ctx) { copyFrom(ctx); }
	}
	public static class BinaryExpContext extends ExpContext {
		public ExpContext l;
		public Token op;
		public ExpContext r;
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode NL() { return getToken(Antlr4LogikaParser.NL, 0); }
		public BinaryExpContext(ExpContext ctx) { copyFrom(ctx); }
	}

	public final ExpContext exp() throws RecognitionException {
		return exp(0);
	}

	private ExpContext exp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpContext _localctx = new ExpContext(_ctx, _parentState);
		ExpContext _prevctx = _localctx;
		int _startState = 38;
		enterRecursionRule(_localctx, 38, RULE_exp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(776);
			switch (_input.LA(1)) {
			case T__24:
			case T__36:
				{
				_localctx = new UnaryExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(728);
				((UnaryExpContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__24 || _la==T__36) ) {
					((UnaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(729);
				exp(8);
				}
				break;
			case T__8:
			case T__9:
			case T__10:
			case T__11:
			case T__12:
			case T__13:
			case T__14:
				{
				_localctx = new BooleanExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(730);
				((BooleanExpContext)_localctx).t = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14))) != 0)) ) {
					((BooleanExpContext)_localctx).t = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				break;
			case NUM:
				{
				_localctx = new IntExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(731);
				match(NUM);
				}
				break;
			case ID:
				{
				_localctx = new IdExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(732);
				((IdExpContext)_localctx).tb = match(ID);
				setState(747);
				switch ( getInterpreter().adaptivePredict(_input,102,_ctx) ) {
				case 1:
					{
					setState(733);
					match(T__15);
					setState(742);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__36))) != 0) || ((((_la - 118)) & ~0x3f) == 0 && ((1L << (_la - 118)) & ((1L << (T__117 - 118)) | (1L << (NUM - 118)) | (1L << (ID - 118)))) != 0)) {
						{
						setState(734);
						exp(0);
						setState(739);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==T__0) {
							{
							{
							setState(735);
							match(T__0);
							setState(736);
							exp(0);
							}
							}
							setState(741);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(744);
					match(T__16);
					}
					break;
				case 2:
					{
					setState(745);
					match(T__5);
					setState(746);
					((IdExpContext)_localctx).te = match(ID);
					}
					break;
				}
				}
				break;
			case T__18:
				{
				_localctx = new BigIntExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(749);
				match(T__18);
				setState(750);
				match(T__15);
				setState(751);
				match(STRING);
				setState(752);
				match(T__16);
				}
				break;
			case T__19:
				{
				_localctx = new SeqExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(753);
				match(T__19);
				setState(754);
				match(T__15);
				setState(763);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__36))) != 0) || ((((_la - 118)) & ~0x3f) == 0 && ((1L << (_la - 118)) & ((1L << (T__117 - 118)) | (1L << (NUM - 118)) | (1L << (ID - 118)))) != 0)) {
					{
					setState(755);
					exp(0);
					setState(760);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(756);
						match(T__0);
						setState(757);
						exp(0);
						}
						}
						setState(762);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(765);
				match(T__16);
				}
				break;
			case T__117:
				{
				_localctx = new ReadIntExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(766);
				match(T__117);
				setState(767);
				match(T__15);
				setState(769);
				_la = _input.LA(1);
				if (_la==STRING) {
					{
					setState(768);
					match(STRING);
					}
				}

				setState(771);
				match(T__16);
				}
				break;
			case T__15:
				{
				_localctx = new ParenExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(772);
				match(T__15);
				setState(773);
				exp(0);
				setState(774);
				match(T__16);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(822);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,115,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(820);
					switch ( getInterpreter().adaptivePredict(_input,114,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(778);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(779);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__20) | (1L << T__21) | (1L << T__22))) != 0)) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(781);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(780);
							match(NL);
							}
						}

						setState(783);
						((BinaryExpContext)_localctx).r = exp(8);
						}
						break;
					case 2:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(784);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(785);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__23 || _la==T__24 || _la==T__118) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(787);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(786);
							match(NL);
							}
						}

						setState(789);
						((BinaryExpContext)_localctx).r = exp(7);
						}
						break;
					case 3:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(790);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(791);
						((BinaryExpContext)_localctx).op = match(T__118);
						setState(793);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(792);
							match(NL);
							}
						}

						setState(795);
						((BinaryExpContext)_localctx).r = exp(6);
						}
						break;
					case 4:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(796);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(797);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__25) | (1L << T__26) | (1L << T__28) | (1L << T__29))) != 0)) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(799);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(798);
							match(NL);
							}
						}

						setState(801);
						((BinaryExpContext)_localctx).r = exp(5);
						}
						break;
					case 5:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(802);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(803);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__32 || _la==T__33) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(805);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(804);
							match(NL);
							}
						}

						setState(807);
						((BinaryExpContext)_localctx).r = exp(4);
						}
						break;
					case 6:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(808);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(809);
						((BinaryExpContext)_localctx).op = match(T__40);
						setState(811);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(810);
							match(NL);
							}
						}

						setState(813);
						((BinaryExpContext)_localctx).r = exp(3);
						}
						break;
					case 7:
						{
						_localctx = new BinaryExpContext(new ExpContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(814);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(815);
						((BinaryExpContext)_localctx).op = match(T__44);
						setState(817);
						_la = _input.LA(1);
						if (_la==NL) {
							{
							setState(816);
							match(NL);
							}
						}

						setState(819);
						((BinaryExpContext)_localctx).r = exp(2);
						}
						break;
					}
					} 
				}
				setState(824);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,115,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class LoopInvariantContext extends ParserRuleContext {
		public Token tb;
		public Token itb;
		public Token te;
		public ModifiesContext modifies() {
			return getRuleContext(ModifiesContext.class,0);
		}
		public List<TerminalNode> NL() { return getTokens(Antlr4LogikaParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(Antlr4LogikaParser.NL, i);
		}
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public LoopInvariantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loopInvariant; }
	}

	public final LoopInvariantContext loopInvariant() throws RecognitionException {
		LoopInvariantContext _localctx = new LoopInvariantContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_loopInvariant);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(825);
			((LoopInvariantContext)_localctx).tb = match(T__3);
			setState(829);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(826);
				match(NL);
				}
				}
				setState(831);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(832);
			((LoopInvariantContext)_localctx).itb = match(T__98);
			setState(836);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,117,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(833);
					match(NL);
					}
					} 
				}
				setState(838);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,117,_ctx);
			}
			setState(840);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57))) != 0) || _la==NUM || _la==ID) {
				{
				setState(839);
				formula(0);
				}
			}

			setState(852);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(843); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(842);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(845); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,119,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(848);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57))) != 0) || _la==NUM || _la==ID) {
					{
					setState(847);
					formula(0);
					}
				}

				}
				}
				setState(854);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(855);
			modifies();
			setState(856);
			((LoopInvariantContext)_localctx).te = match(T__4);
			setState(860);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(857);
				match(NL);
				}
				}
				setState(862);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ModifiesContext extends ParserRuleContext {
		public Token tb;
		public List<TerminalNode> ID() { return getTokens(Antlr4LogikaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(Antlr4LogikaParser.ID, i);
		}
		public List<TerminalNode> NL() { return getTokens(Antlr4LogikaParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(Antlr4LogikaParser.NL, i);
		}
		public ModifiesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modifies; }
	}

	public final ModifiesContext modifies() throws RecognitionException {
		ModifiesContext _localctx = new ModifiesContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_modifies);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(863);
			((ModifiesContext)_localctx).tb = match(T__119);
			setState(872);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(864);
				match(ID);
				setState(869);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(865);
					match(T__0);
					setState(866);
					match(ID);
					}
					}
					setState(871);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(877);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,125,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(874);
					match(NL);
					}
					} 
				}
				setState(879);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,125,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodContractContext extends ParserRuleContext {
		public Token tb;
		public FormulaContext formula;
		public List<FormulaContext> rs = new ArrayList<FormulaContext>();
		public List<FormulaContext> es = new ArrayList<FormulaContext>();
		public Token te;
		public List<TerminalNode> NL() { return getTokens(Antlr4LogikaParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(Antlr4LogikaParser.NL, i);
		}
		public ModifiesContext modifies() {
			return getRuleContext(ModifiesContext.class,0);
		}
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public MethodContractContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodContract; }
	}

	public final MethodContractContext methodContract() throws RecognitionException {
		MethodContractContext _localctx = new MethodContractContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_methodContract);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(880);
			((MethodContractContext)_localctx).tb = match(T__3);
			setState(884);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,126,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(881);
					match(NL);
					}
					} 
				}
				setState(886);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,126,_ctx);
			}
			setState(908);
			_la = _input.LA(1);
			if (_la==T__120 || _la==T__121) {
				{
				setState(887);
				_la = _input.LA(1);
				if ( !(_la==T__120 || _la==T__121) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(891);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(888);
					match(NL);
					}
					}
					setState(893);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(894);
				((MethodContractContext)_localctx).formula = formula(0);
				((MethodContractContext)_localctx).rs.add(((MethodContractContext)_localctx).formula);
				setState(905);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,130,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(896); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(895);
								match(NL);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(898); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,128,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						setState(901);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57))) != 0) || _la==NUM || _la==ID) {
							{
							setState(900);
							((MethodContractContext)_localctx).formula = formula(0);
							((MethodContractContext)_localctx).rs.add(((MethodContractContext)_localctx).formula);
							}
						}

						}
						} 
					}
					setState(907);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,130,_ctx);
				}
				}
			}

			setState(913);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,132,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(910);
					match(NL);
					}
					} 
				}
				setState(915);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,132,_ctx);
			}
			setState(917);
			_la = _input.LA(1);
			if (_la==T__119) {
				{
				setState(916);
				modifies();
				}
			}

			setState(940);
			_la = _input.LA(1);
			if (_la==T__122 || _la==T__123) {
				{
				setState(919);
				_la = _input.LA(1);
				if ( !(_la==T__122 || _la==T__123) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(923);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(920);
					match(NL);
					}
					}
					setState(925);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(926);
				((MethodContractContext)_localctx).formula = formula(0);
				((MethodContractContext)_localctx).es.add(((MethodContractContext)_localctx).formula);
				setState(937);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,137,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(928); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(927);
								match(NL);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(930); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,135,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						setState(933);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57))) != 0) || _la==NUM || _la==ID) {
							{
							setState(932);
							((MethodContractContext)_localctx).formula = formula(0);
							((MethodContractContext)_localctx).es.add(((MethodContractContext)_localctx).formula);
							}
						}

						}
						} 
					}
					setState(939);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,137,_ctx);
				}
				}
			}

			setState(945);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(942);
				match(NL);
				}
				}
				setState(947);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(948);
			((MethodContractContext)_localctx).te = match(T__4);
			setState(952);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,140,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(949);
					match(NL);
					}
					} 
				}
				setState(954);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,140,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InvariantsContext extends ParserRuleContext {
		public Token tb;
		public Token te;
		public List<TerminalNode> NL() { return getTokens(Antlr4LogikaParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(Antlr4LogikaParser.NL, i);
		}
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public InvariantsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_invariants; }
	}

	public final InvariantsContext invariants() throws RecognitionException {
		InvariantsContext _localctx = new InvariantsContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_invariants);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(955);
			((InvariantsContext)_localctx).tb = match(T__3);
			setState(959);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(956);
				match(NL);
				}
				}
				setState(961);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(962);
			match(T__98);
			setState(966);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,142,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(963);
					match(NL);
					}
					} 
				}
				setState(968);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,142,_ctx);
			}
			setState(970);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57))) != 0) || _la==NUM || _la==ID) {
				{
				setState(969);
				formula(0);
				}
			}

			setState(982);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(973); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(972);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(975); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,144,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(978);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__24) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57))) != 0) || _la==NUM || _la==ID) {
					{
					setState(977);
					formula(0);
					}
				}

				}
				}
				setState(984);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(985);
			((InvariantsContext)_localctx).te = match(T__4);
			setState(989);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(986);
				match(NL);
				}
				}
				setState(991);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 6:
			return formula_sempred((FormulaContext)_localctx, predIndex);
		case 9:
			return justification_sempred((JustificationContext)_localctx, predIndex);
		case 19:
			return exp_sempred((ExpContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean formula_sempred(FormulaContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 10);
		case 1:
			return precpred(_ctx, 9);
		case 2:
			return precpred(_ctx, 8);
		case 3:
			return precpred(_ctx, 7);
		case 4:
			return precpred(_ctx, 4);
		case 5:
			return precpred(_ctx, 3);
		case 6:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean justification_sempred(JustificationContext _localctx, int predIndex) {
		switch (predIndex) {
		case 7:
			return "∃".equals(_input.LT(1).getText()) &&
		     "i".equals(_input.LT(2).getText());
		}
		return true;
	}
	private boolean exp_sempred(ExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 8:
			return precpred(_ctx, 7);
		case 9:
			return precpred(_ctx, 6);
		case 10:
			return precpred(_ctx, 5);
		case 11:
			return precpred(_ctx, 4);
		case 12:
			return precpred(_ctx, 3);
		case 13:
			return precpred(_ctx, 2);
		case 14:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\u0089\u03e3\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\3\2\3\2\7\2\65\n\2\f\2\16\28\13\2\3\2\5\2;\n\2\3\2\7\2>\n\2\f\2\16\2"+
		"A\13\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\7\5N\n\5\f\5\16\5Q"+
		"\13\5\5\5S\n\5\3\5\3\5\3\5\3\5\7\5Y\n\5\f\5\16\5\\\13\5\3\5\7\5_\n\5\f"+
		"\5\16\5b\13\5\3\5\3\5\6\5f\n\5\r\5\16\5g\5\5j\n\5\3\6\3\6\5\6n\n\6\3\6"+
		"\6\6q\n\6\r\6\16\6r\3\6\5\6v\n\6\7\6x\n\6\f\6\16\6{\13\6\3\6\3\6\7\6\177"+
		"\n\6\f\6\16\6\u0082\13\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7\u008c\n\7"+
		"\f\7\16\7\u008f\13\7\3\7\3\7\7\7\u0093\n\7\f\7\16\7\u0096\13\7\3\7\3\7"+
		"\3\7\3\7\3\7\5\7\u009d\n\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u00a5\n\7\3\7\3"+
		"\7\3\7\5\7\u00aa\n\7\3\7\6\7\u00ad\n\7\r\7\16\7\u00ae\3\7\5\7\u00b2\n"+
		"\7\7\7\u00b4\n\7\f\7\16\7\u00b7\13\7\3\7\5\7\u00ba\n\7\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\5\b\u00c5\n\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\7\b\u00d1\n\b\f\b\16\b\u00d4\13\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\7\b\u00e2\n\b\f\b\16\b\u00e5\13\b\5\b\u00e7\n\b\3\b\3"+
		"\b\5\b\u00eb\n\b\3\b\3\b\3\b\5\b\u00f0\n\b\3\b\3\b\3\b\3\b\5\b\u00f6\n"+
		"\b\3\b\3\b\3\b\3\b\5\b\u00fc\n\b\3\b\3\b\3\b\3\b\5\b\u0102\n\b\3\b\3\b"+
		"\3\b\3\b\5\b\u0108\n\b\3\b\3\b\3\b\3\b\5\b\u010e\n\b\3\b\3\b\3\b\3\b\5"+
		"\b\u0114\n\b\3\b\7\b\u0117\n\b\f\b\16\b\u011a\13\b\3\t\3\t\3\t\3\t\7\t"+
		"\u0120\n\t\f\t\16\t\u0123\13\t\3\t\3\t\3\t\3\t\3\t\5\t\u012a\n\t\3\t\3"+
		"\t\5\t\u012e\n\t\3\t\3\t\5\t\u0132\n\t\3\t\3\t\5\t\u0136\n\t\3\t\3\t\3"+
		"\n\3\n\3\n\5\n\u013d\n\n\3\13\3\13\3\13\3\13\5\13\u0143\n\13\3\13\3\13"+
		"\3\13\3\13\3\13\5\13\u014a\n\13\3\13\3\13\3\13\3\13\5\13\u0150\n\13\3"+
		"\13\3\13\3\13\3\13\5\13\u0156\n\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13"+
		"\u015e\n\13\3\13\3\13\3\13\3\13\5\13\u0164\n\13\3\13\3\13\3\13\3\13\3"+
		"\13\5\13\u016b\n\13\3\13\3\13\3\13\3\13\3\13\5\13\u0172\n\13\3\13\3\13"+
		"\3\13\3\13\3\13\5\13\u0179\n\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\7\13\u0188\n\13\f\13\16\13\u018b\13\13\3\13"+
		"\3\13\3\13\3\13\3\13\5\13\u0192\n\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13"+
		"\u019a\n\13\3\13\3\13\6\13\u019e\n\13\r\13\16\13\u019f\3\13\3\13\3\13"+
		"\6\13\u01a5\n\13\r\13\16\13\u01a6\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\6\13\u01b2\n\13\r\13\16\13\u01b3\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\7\13\u01be\n\13\f\13\16\13\u01c1\13\13\5\13\u01c3\n\13\3\f"+
		"\3\f\3\r\7\r\u01c8\n\r\f\r\16\r\u01cb\13\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\6\r\u01d6\n\r\r\r\16\r\u01d7\3\r\3\r\3\r\3\r\7\r\u01de\n\r\f"+
		"\r\16\r\u01e1\13\r\5\r\u01e3\n\r\3\r\5\r\u01e6\n\r\3\16\3\16\7\16\u01ea"+
		"\n\16\f\16\16\16\u01ed\13\16\3\16\3\16\7\16\u01f1\n\16\f\16\16\16\u01f4"+
		"\13\16\3\16\5\16\u01f7\n\16\3\16\6\16\u01fa\n\16\r\16\16\16\u01fb\3\16"+
		"\5\16\u01ff\n\16\7\16\u0201\n\16\f\16\16\16\u0204\13\16\3\16\3\16\7\16"+
		"\u0208\n\16\f\16\16\16\u020b\13\16\3\17\3\17\5\17\u020f\n\17\3\20\3\20"+
		"\3\20\3\20\3\21\3\21\3\21\5\21\u0218\n\21\3\21\3\21\3\21\3\21\7\21\u021e"+
		"\n\21\f\21\16\21\u0221\13\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3"+
		"\23\5\23\u022c\n\23\3\23\6\23\u022f\n\23\r\23\16\23\u0230\3\23\5\23\u0234"+
		"\n\23\7\23\u0236\n\23\f\23\16\23\u0239\13\23\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\5\24\u0241\n\24\3\24\3\24\3\24\3\24\3\24\5\24\u0248\n\24\3\24\3"+
		"\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\7\24\u0255\n\24\f\24"+
		"\16\24\u0258\13\24\3\24\3\24\3\24\3\24\3\24\7\24\u025f\n\24\f\24\16\24"+
		"\u0262\13\24\3\24\3\24\3\24\3\24\5\24\u0268\n\24\3\24\3\24\3\24\3\24\3"+
		"\24\7\24\u026f\n\24\f\24\16\24\u0272\13\24\3\24\3\24\7\24\u0276\n\24\f"+
		"\24\16\24\u0279\13\24\3\24\3\24\3\24\3\24\5\24\u027f\n\24\3\24\3\24\3"+
		"\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u028e\n\24"+
		"\3\24\3\24\3\24\3\24\3\24\5\24\u0295\n\24\3\24\3\24\3\24\3\24\7\24\u029b"+
		"\n\24\f\24\16\24\u029e\13\24\5\24\u02a0\n\24\3\24\3\24\3\24\3\24\5\24"+
		"\u02a6\n\24\3\24\3\24\7\24\u02aa\n\24\f\24\16\24\u02ad\13\24\3\24\3\24"+
		"\7\24\u02b1\n\24\f\24\16\24\u02b4\13\24\3\24\3\24\3\24\7\24\u02b9\n\24"+
		"\f\24\16\24\u02bc\13\24\3\24\3\24\5\24\u02c0\n\24\3\24\3\24\3\24\3\24"+
		"\7\24\u02c6\n\24\f\24\16\24\u02c9\13\24\5\24\u02cb\n\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\5\24\u02d3\n\24\3\24\3\24\3\24\5\24\u02d8\n\24\3\25\3"+
		"\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\7\25\u02e4\n\25\f\25\16\25"+
		"\u02e7\13\25\5\25\u02e9\n\25\3\25\3\25\3\25\5\25\u02ee\n\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\7\25\u02f9\n\25\f\25\16\25\u02fc\13"+
		"\25\5\25\u02fe\n\25\3\25\3\25\3\25\3\25\5\25\u0304\n\25\3\25\3\25\3\25"+
		"\3\25\3\25\5\25\u030b\n\25\3\25\3\25\3\25\5\25\u0310\n\25\3\25\3\25\3"+
		"\25\3\25\5\25\u0316\n\25\3\25\3\25\3\25\3\25\5\25\u031c\n\25\3\25\3\25"+
		"\3\25\3\25\5\25\u0322\n\25\3\25\3\25\3\25\3\25\5\25\u0328\n\25\3\25\3"+
		"\25\3\25\3\25\5\25\u032e\n\25\3\25\3\25\3\25\3\25\5\25\u0334\n\25\3\25"+
		"\7\25\u0337\n\25\f\25\16\25\u033a\13\25\3\26\3\26\7\26\u033e\n\26\f\26"+
		"\16\26\u0341\13\26\3\26\3\26\7\26\u0345\n\26\f\26\16\26\u0348\13\26\3"+
		"\26\5\26\u034b\n\26\3\26\6\26\u034e\n\26\r\26\16\26\u034f\3\26\5\26\u0353"+
		"\n\26\7\26\u0355\n\26\f\26\16\26\u0358\13\26\3\26\3\26\3\26\7\26\u035d"+
		"\n\26\f\26\16\26\u0360\13\26\3\27\3\27\3\27\3\27\7\27\u0366\n\27\f\27"+
		"\16\27\u0369\13\27\5\27\u036b\n\27\3\27\7\27\u036e\n\27\f\27\16\27\u0371"+
		"\13\27\3\30\3\30\7\30\u0375\n\30\f\30\16\30\u0378\13\30\3\30\3\30\7\30"+
		"\u037c\n\30\f\30\16\30\u037f\13\30\3\30\3\30\6\30\u0383\n\30\r\30\16\30"+
		"\u0384\3\30\5\30\u0388\n\30\7\30\u038a\n\30\f\30\16\30\u038d\13\30\5\30"+
		"\u038f\n\30\3\30\7\30\u0392\n\30\f\30\16\30\u0395\13\30\3\30\5\30\u0398"+
		"\n\30\3\30\3\30\7\30\u039c\n\30\f\30\16\30\u039f\13\30\3\30\3\30\6\30"+
		"\u03a3\n\30\r\30\16\30\u03a4\3\30\5\30\u03a8\n\30\7\30\u03aa\n\30\f\30"+
		"\16\30\u03ad\13\30\5\30\u03af\n\30\3\30\7\30\u03b2\n\30\f\30\16\30\u03b5"+
		"\13\30\3\30\3\30\7\30\u03b9\n\30\f\30\16\30\u03bc\13\30\3\31\3\31\7\31"+
		"\u03c0\n\31\f\31\16\31\u03c3\13\31\3\31\3\31\7\31\u03c7\n\31\f\31\16\31"+
		"\u03ca\13\31\3\31\5\31\u03cd\n\31\3\31\6\31\u03d0\n\31\r\31\16\31\u03d1"+
		"\3\31\5\31\u03d5\n\31\7\31\u03d7\n\31\f\31\16\31\u03da\13\31\3\31\3\31"+
		"\7\31\u03de\n\31\f\31\16\31\u03e1\13\31\3\31\2\4\16(\32\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\32\34\36 \"$&(*,.\60\2#\3\2\4\5\3\2&)\3\2\13\21\3\2\27"+
		"\31\3\2\32\33\3\2\34!\3\2\"%\3\2*-\3\2.\61\3\2\62\64\3\2\65<\3\2AB\4\2"+
		"++--\3\2CF\3\2GJ\4\2//\61\61\3\2KL\3\2\63\64\3\2OP\3\2\')\3\2ST\3\2\20"+
		"\21\3\2_a\3\2bd\3\2\u0080\u0081\3\2no\3\2tu\4\2\33\33\'\'\4\2\32\33yy"+
		"\4\2\34\35\37 \3\2#$\3\2{|\3\2}~\u049d\2\62\3\2\2\2\4D\3\2\2\2\6G\3\2"+
		"\2\2\bi\3\2\2\2\nk\3\2\2\2\f\u00b9\3\2\2\2\16\u00ea\3\2\2\2\20\u011b\3"+
		"\2\2\2\22\u013c\3\2\2\2\24\u01c2\3\2\2\2\26\u01c4\3\2\2\2\30\u01c9\3\2"+
		"\2\2\32\u01e7\3\2\2\2\34\u020e\3\2\2\2\36\u0210\3\2\2\2 \u0214\3\2\2\2"+
		"\"\u0226\3\2\2\2$\u022b\3\2\2\2&\u02d7\3\2\2\2(\u030a\3\2\2\2*\u033b\3"+
		"\2\2\2,\u0361\3\2\2\2.\u0372\3\2\2\2\60\u03bd\3\2\2\2\62\66\5\b\5\2\63"+
		"\65\7\u0085\2\2\64\63\3\2\2\2\658\3\2\2\2\66\64\3\2\2\2\66\67\3\2\2\2"+
		"\67:\3\2\2\28\66\3\2\2\29;\5\n\6\2:9\3\2\2\2:;\3\2\2\2;?\3\2\2\2<>\7\u0085"+
		"\2\2=<\3\2\2\2>A\3\2\2\2?=\3\2\2\2?@\3\2\2\2@B\3\2\2\2A?\3\2\2\2BC\7\2"+
		"\2\3C\3\3\2\2\2DE\5\n\6\2EF\7\2\2\3F\5\3\2\2\2GH\5\30\r\2HI\7\2\2\3I\7"+
		"\3\2\2\2JO\5\16\b\2KL\7\3\2\2LN\5\16\b\2MK\3\2\2\2NQ\3\2\2\2OM\3\2\2\2"+
		"OP\3\2\2\2PS\3\2\2\2QO\3\2\2\2RJ\3\2\2\2RS\3\2\2\2ST\3\2\2\2TU\t\2\2\2"+
		"UZ\5\16\b\2VW\7\3\2\2WY\5\16\b\2XV\3\2\2\2Y\\\3\2\2\2ZX\3\2\2\2Z[\3\2"+
		"\2\2[j\3\2\2\2\\Z\3\2\2\2]_\5\16\b\2^]\3\2\2\2_b\3\2\2\2`^\3\2\2\2`a\3"+
		"\2\2\2ac\3\2\2\2b`\3\2\2\2ce\7\177\2\2df\5\16\b\2ed\3\2\2\2fg\3\2\2\2"+
		"ge\3\2\2\2gh\3\2\2\2hj\3\2\2\2iR\3\2\2\2i`\3\2\2\2j\t\3\2\2\2km\7\6\2"+
		"\2ln\5\f\7\2ml\3\2\2\2mn\3\2\2\2ny\3\2\2\2oq\7\u0085\2\2po\3\2\2\2qr\3"+
		"\2\2\2rp\3\2\2\2rs\3\2\2\2su\3\2\2\2tv\5\f\7\2ut\3\2\2\2uv\3\2\2\2vx\3"+
		"\2\2\2wp\3\2\2\2x{\3\2\2\2yw\3\2\2\2yz\3\2\2\2z|\3\2\2\2{y\3\2\2\2|\u0080"+
		"\7\7\2\2}\177\7\u0085\2\2~}\3\2\2\2\177\u0082\3\2\2\2\u0080~\3\2\2\2\u0080"+
		"\u0081\3\2\2\2\u0081\13\3\2\2\2\u0082\u0080\3\2\2\2\u0083\u0084\7\u0080"+
		"\2\2\u0084\u0085\7\b\2\2\u0085\u0086\5\16\b\2\u0086\u0087\5\24\13\2\u0087"+
		"\u00ba\3\2\2\2\u0088\u0089\7\u0080\2\2\u0089\u008d\7\b\2\2\u008a\u008c"+
		"\7\u0085\2\2\u008b\u008a\3\2\2\2\u008c\u008f\3\2\2\2\u008d\u008b\3\2\2"+
		"\2\u008d\u008e\3\2\2\2\u008e\u0090\3\2\2\2\u008f\u008d\3\2\2\2\u0090\u0094"+
		"\7\6\2\2\u0091\u0093\7\u0085\2\2\u0092\u0091\3\2\2\2\u0093\u0096\3\2\2"+
		"\2\u0094\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0097\3\2\2\2\u0096\u0094"+
		"\3\2\2\2\u0097\u0098\7\u0080\2\2\u0098\u00a9\7\b\2\2\u0099\u009c\7\u0081"+
		"\2\2\u009a\u009b\7\t\2\2\u009b\u009d\5\22\n\2\u009c\u009a\3\2\2\2\u009c"+
		"\u009d\3\2\2\2\u009d\u00aa\3\2\2\2\u009e\u009f\5\16\b\2\u009f\u00a0\7"+
		"\n\2\2\u00a0\u00aa\3\2\2\2\u00a1\u00a4\7\u0081\2\2\u00a2\u00a3\7\t\2\2"+
		"\u00a3\u00a5\5\22\n\2\u00a4\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a6"+
		"\3\2\2\2\u00a6\u00a7\5\16\b\2\u00a7\u00a8\7\n\2\2\u00a8\u00aa\3\2\2\2"+
		"\u00a9\u0099\3\2\2\2\u00a9\u009e\3\2\2\2\u00a9\u00a1\3\2\2\2\u00aa\u00b5"+
		"\3\2\2\2\u00ab\u00ad\7\u0085\2\2\u00ac\u00ab\3\2\2\2\u00ad\u00ae\3\2\2"+
		"\2\u00ae\u00ac\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b1\3\2\2\2\u00b0\u00b2"+
		"\5\f\7\2\u00b1\u00b0\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b4\3\2\2\2\u00b3"+
		"\u00ac\3\2\2\2\u00b4\u00b7\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b5\u00b6\3\2"+
		"\2\2\u00b6\u00b8\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b8\u00ba\7\7\2\2\u00b9"+
		"\u0083\3\2\2\2\u00b9\u0088\3\2\2\2\u00ba\r\3\2\2\2\u00bb\u00bc\b\b\1\2"+
		"\u00bc\u00bd\7\33\2\2\u00bd\u00eb\5\16\b\b\u00be\u00bf\t\3\2\2\u00bf\u00eb"+
		"\5\16\b\7\u00c0\u00eb\t\4\2\2\u00c1\u00c4\7\u0081\2\2\u00c2\u00c3\7\b"+
		"\2\2\u00c3\u00c5\7\u0081\2\2\u00c4\u00c2\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5"+
		"\u00eb\3\2\2\2\u00c6\u00c7\7\22\2\2\u00c7\u00c8\5\16\b\2\u00c8\u00c9\7"+
		"\23\2\2\u00c9\u00eb\3\2\2\2\u00ca\u00eb\7\24\2\2\u00cb\u00cc\7\u0081\2"+
		"\2\u00cc\u00cd\7\22\2\2\u00cd\u00d2\5\16\b\2\u00ce\u00cf\7\3\2\2\u00cf"+
		"\u00d1\5\16\b\2\u00d0\u00ce\3\2\2\2\u00d1\u00d4\3\2\2\2\u00d2\u00d0\3"+
		"\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d5\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d5"+
		"\u00d6\7\23\2\2\u00d6\u00eb\3\2\2\2\u00d7\u00eb\7\u0080\2\2\u00d8\u00d9"+
		"\7\25\2\2\u00d9\u00da\7\22\2\2\u00da\u00db\7\u0083\2\2\u00db\u00eb\7\23"+
		"\2\2\u00dc\u00dd\7\26\2\2\u00dd\u00e6\7\22\2\2\u00de\u00e3\5(\25\2\u00df"+
		"\u00e0\7\3\2\2\u00e0\u00e2\5(\25\2\u00e1\u00df\3\2\2\2\u00e2\u00e5\3\2"+
		"\2\2\u00e3\u00e1\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e7\3\2\2\2\u00e5"+
		"\u00e3\3\2\2\2\u00e6\u00de\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00e8\3\2"+
		"\2\2\u00e8\u00eb\7\23\2\2\u00e9\u00eb\5\20\t\2\u00ea\u00bb\3\2\2\2\u00ea"+
		"\u00be\3\2\2\2\u00ea\u00c0\3\2\2\2\u00ea\u00c1\3\2\2\2\u00ea\u00c6\3\2"+
		"\2\2\u00ea\u00ca\3\2\2\2\u00ea\u00cb\3\2\2\2\u00ea\u00d7\3\2\2\2\u00ea"+
		"\u00d8\3\2\2\2\u00ea\u00dc\3\2\2\2\u00ea\u00e9\3\2\2\2\u00eb\u0118\3\2"+
		"\2\2\u00ec\u00ed\f\f\2\2\u00ed\u00ef\t\5\2\2\u00ee\u00f0\7\u0085\2\2\u00ef"+
		"\u00ee\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\u0117\5\16"+
		"\b\r\u00f2\u00f3\f\13\2\2\u00f3\u00f5\t\6\2\2\u00f4\u00f6\7\u0085\2\2"+
		"\u00f5\u00f4\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7\u0117"+
		"\5\16\b\f\u00f8\u00f9\f\n\2\2\u00f9\u00fb\t\7\2\2\u00fa\u00fc\7\u0085"+
		"\2\2\u00fb\u00fa\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd"+
		"\u0117\5\16\b\13\u00fe\u00ff\f\t\2\2\u00ff\u0101\t\b\2\2\u0100\u0102\7"+
		"\u0085\2\2\u0101\u0100\3\2\2\2\u0101\u0102\3\2\2\2\u0102\u0103\3\2\2\2"+
		"\u0103\u0117\5\16\b\n\u0104\u0105\f\6\2\2\u0105\u0107\t\t\2\2\u0106\u0108"+
		"\7\u0085\2\2\u0107\u0106\3\2\2\2\u0107\u0108\3\2\2\2\u0108\u0109\3\2\2"+
		"\2\u0109\u0117\5\16\b\7\u010a\u010b\f\5\2\2\u010b\u010d\t\n\2\2\u010c"+
		"\u010e\7\u0085\2\2\u010d\u010c\3\2\2\2\u010d\u010e\3\2\2\2\u010e\u010f"+
		"\3\2\2\2\u010f\u0117\5\16\b\6\u0110\u0111\f\4\2\2\u0111\u0113\t\13\2\2"+
		"\u0112\u0114\7\u0085\2\2\u0113\u0112\3\2\2\2\u0113\u0114\3\2\2\2\u0114"+
		"\u0115\3\2\2\2\u0115\u0117\5\16\b\5\u0116\u00ec\3\2\2\2\u0116\u00f2\3"+
		"\2\2\2\u0116\u00f8\3\2\2\2\u0116\u00fe\3\2\2\2\u0116\u0104\3\2\2\2\u0116"+
		"\u010a\3\2\2\2\u0116\u0110\3\2\2\2\u0117\u011a\3\2\2\2\u0118\u0116\3\2"+
		"\2\2\u0118\u0119\3\2\2\2\u0119\17\3\2\2\2\u011a\u0118\3\2\2\2\u011b\u011c"+
		"\t\f\2\2\u011c\u0121\7\u0081\2\2\u011d\u011e\7\3\2\2\u011e\u0120\7\u0081"+
		"\2\2\u011f\u011d\3\2\2\2\u0120\u0123\3\2\2\2\u0121\u011f\3\2\2\2\u0121"+
		"\u0122\3\2\2\2\u0122\u0131\3\2\2\2\u0123\u0121\3\2\2\2\u0124\u0125\7\t"+
		"\2\2\u0125\u0132\5\22\n\2\u0126\u0127\7\t\2\2\u0127\u0129\5(\25\2\u0128"+
		"\u012a\7\34\2\2\u0129\u0128\3\2\2\2\u0129\u012a\3\2\2\2\u012a\u012b\3"+
		"\2\2\2\u012b\u012d\7=\2\2\u012c\u012e\7\34\2\2\u012d\u012c\3\2\2\2\u012d"+
		"\u012e\3\2\2\2\u012e\u012f\3\2\2\2\u012f\u0130\5(\25\2\u0130\u0132\3\2"+
		"\2\2\u0131\u0124\3\2\2\2\u0131\u0126\3\2\2\2\u0131\u0132\3\2\2\2\u0132"+
		"\u0133\3\2\2\2\u0133\u0135\7>\2\2\u0134\u0136\7\u0085\2\2\u0135\u0134"+
		"\3\2\2\2\u0135\u0136\3\2\2\2\u0136\u0137\3\2\2\2\u0137\u0138\5\16\b\2"+
		"\u0138\21\3\2\2\2\u0139\u013d\7?\2\2\u013a\u013d\7\25\2\2\u013b\u013d"+
		"\7\26\2\2\u013c\u0139\3\2\2\2\u013c\u013a\3\2\2\2\u013c\u013b\3\2\2\2"+
		"\u013d\23\3\2\2\2\u013e\u01c3\7@\2\2\u013f\u0143\t\r\2\2\u0140\u0141\t"+
		"\16\2\2\u0141\u0143\7\u0081\2\2\u0142\u013f\3\2\2\2\u0142\u0140\3\2\2"+
		"\2\u0143\u0144\3\2\2\2\u0144\u0145\7\u0080\2\2\u0145\u01c3\7\u0080\2\2"+
		"\u0146\u014a\t\17\2\2\u0147\u0148\t\16\2\2\u0148\u014a\7\u0081\2\2\u0149"+
		"\u0146\3\2\2\2\u0149\u0147\3\2\2\2\u014a\u014b\3\2\2\2\u014b\u01c3\7\u0080"+
		"\2\2\u014c\u0150\t\20\2\2\u014d\u014e\t\21\2\2\u014e\u0150\7\u0081\2\2"+
		"\u014f\u014c\3\2\2\2\u014f\u014d\3\2\2\2\u0150\u0151\3\2\2\2\u0151\u01c3"+
		"\7\u0080\2\2\u0152\u0156\t\22\2\2\u0153\u0154\t\21\2\2\u0154\u0156\7\u0081"+
		"\2\2\u0155\u0152\3\2\2\2\u0155\u0153\3\2\2\2\u0156\u0157\3\2\2\2\u0157"+
		"\u0158\7\u0080\2\2\u0158\u0159\7\u0080\2\2\u0159\u01c3\7\u0080\2\2\u015a"+
		"\u015e\7M\2\2\u015b\u015c\t\23\2\2\u015c\u015e\7\u0081\2\2\u015d\u015a"+
		"\3\2\2\2\u015d\u015b\3\2\2\2\u015e\u015f\3\2\2\2\u015f\u01c3\7\u0080\2"+
		"\2\u0160\u0164\7N\2\2\u0161\u0162\t\23\2\2\u0162\u0164\7\u0081\2\2\u0163"+
		"\u0160\3\2\2\2\u0163\u0161\3\2\2\2\u0164\u0165\3\2\2\2\u0165\u0166\7\u0080"+
		"\2\2\u0166\u01c3\7\u0080\2\2\u0167\u016b\t\24\2\2\u0168\u0169\t\25\2\2"+
		"\u0169\u016b\7\u0081\2\2\u016a\u0167\3\2\2\2\u016a\u0168\3\2\2\2\u016b"+
		"\u016c\3\2\2\2\u016c\u01c3\7\u0080\2\2\u016d\u0172\7Q\2\2\u016e\u0172"+
		"\7R\2\2\u016f\u0170\t\25\2\2\u0170\u0172\7\u0081\2\2\u0171\u016d\3\2\2"+
		"\2\u0171\u016e\3\2\2\2\u0171\u016f\3\2\2\2\u0172\u0173\3\2\2\2\u0173\u0174"+
		"\7\u0080\2\2\u0174\u01c3\7\u0080\2\2\u0175\u0179\t\26\2\2\u0176\u0177"+
		"\t\27\2\2\u0177\u0179\7\u0081\2\2\u0178\u0175\3\2\2\2\u0178\u0176\3\2"+
		"\2\2\u0179\u017a\3\2\2\2\u017a\u01c3\7\u0080\2\2\u017b\u017c\7U\2\2\u017c"+
		"\u01c3\7\u0080\2\2\u017d\u017e\7V\2\2\u017e\u017f\5\26\f\2\u017f\u0180"+
		"\7\u0080\2\2\u0180\u01c3\3\2\2\2\u0181\u0182\7W\2\2\u0182\u0183\5\26\f"+
		"\2\u0183\u0184\7\u0080\2\2\u0184\u01c3\3\2\2\2\u0185\u0189\7X\2\2\u0186"+
		"\u0188\5\26\f\2\u0187\u0186\3\2\2\2\u0188\u018b\3\2\2\2\u0189\u0187\3"+
		"\2\2\2\u0189\u018a\3\2\2\2\u018a\u01c3\3\2\2\2\u018b\u0189\3\2\2\2\u018c"+
		"\u0192\7Y\2\2\u018d\u0192\7Z\2\2\u018e\u0192\7[\2\2\u018f\u0190\78\2\2"+
		"\u0190\u0192\7\u0081\2\2\u0191\u018c\3\2\2\2\u0191\u018d\3\2\2\2\u0191"+
		"\u018e\3\2\2\2\u0191\u018f\3\2\2\2\u0192\u0193\3\2\2\2\u0193\u01c3\7\u0080"+
		"\2\2\u0194\u019a\7\\\2\2\u0195\u019a\7]\2\2\u0196\u019a\7^\2\2\u0197\u0198"+
		"\78\2\2\u0198\u019a\7\u0081\2\2\u0199\u0194\3\2\2\2\u0199\u0195\3\2\2"+
		"\2\u0199\u0196\3\2\2\2\u0199\u0197\3\2\2\2\u019a\u019b\3\2\2\2\u019b\u019d"+
		"\5\26\f\2\u019c\u019e\5\16\b\2\u019d\u019c\3\2\2\2\u019e\u019f\3\2\2\2"+
		"\u019f\u019d\3\2\2\2\u019f\u01a0\3\2\2\2\u01a0\u01c3\3\2\2\2\u01a1\u01a2"+
		"\t\30\2\2\u01a2\u01a4\7\u0080\2\2\u01a3\u01a5\5\16\b\2\u01a4\u01a3\3\2"+
		"\2\2\u01a5\u01a6\3\2\2\2\u01a6\u01a4\3\2\2\2\u01a6\u01a7\3\2\2\2\u01a7"+
		"\u01c3\3\2\2\2\u01a8\u01a9\t\31\2\2\u01a9\u01aa\5\26\f\2\u01aa\u01ab\7"+
		"\u0080\2\2\u01ab\u01c3\3\2\2\2\u01ac\u01ad\6\13\t\2\u01ad\u01ae\7<\2\2"+
		"\u01ae\u01af\7\u0081\2\2\u01af\u01b1\7\u0080\2\2\u01b0\u01b2\5\16\b\2"+
		"\u01b1\u01b0\3\2\2\2\u01b2\u01b3\3\2\2\2\u01b3\u01b1\3\2\2\2\u01b3\u01b4"+
		"\3\2\2\2\u01b4\u01c3\3\2\2\2\u01b5\u01b6\7<\2\2\u01b6\u01b7\7\u0081\2"+
		"\2\u01b7\u01b8\5\26\f\2\u01b8\u01b9\7\u0080\2\2\u01b9\u01c3\3\2\2\2\u01ba"+
		"\u01c3\7e\2\2\u01bb\u01bf\7f\2\2\u01bc\u01be\5\26\f\2\u01bd\u01bc\3\2"+
		"\2\2\u01be\u01c1\3\2\2\2\u01bf\u01bd\3\2\2\2\u01bf\u01c0\3\2\2\2\u01c0"+
		"\u01c3\3\2\2\2\u01c1\u01bf\3\2\2\2\u01c2\u013e\3\2\2\2\u01c2\u0142\3\2"+
		"\2\2\u01c2\u0149\3\2\2\2\u01c2\u014f\3\2\2\2\u01c2\u0155\3\2\2\2\u01c2"+
		"\u015d\3\2\2\2\u01c2\u0163\3\2\2\2\u01c2\u016a\3\2\2\2\u01c2\u0171\3\2"+
		"\2\2\u01c2\u0178\3\2\2\2\u01c2\u017b\3\2\2\2\u01c2\u017d\3\2\2\2\u01c2"+
		"\u0181\3\2\2\2\u01c2\u0185\3\2\2\2\u01c2\u0191\3\2\2\2\u01c2\u0199\3\2"+
		"\2\2\u01c2\u01a1\3\2\2\2\u01c2\u01a8\3\2\2\2\u01c2\u01ac\3\2\2\2\u01c2"+
		"\u01b5\3\2\2\2\u01c2\u01ba\3\2\2\2\u01c2\u01bb\3\2\2\2\u01c3\25\3\2\2"+
		"\2\u01c4\u01c5\t\32\2\2\u01c5\27\3\2\2\2\u01c6\u01c8\7\u0085\2\2\u01c7"+
		"\u01c6\3\2\2\2\u01c8\u01cb\3\2\2\2\u01c9\u01c7\3\2\2\2\u01c9\u01ca\3\2"+
		"\2\2\u01ca\u01e5\3\2\2\2\u01cb\u01c9\3\2\2\2\u01cc\u01cd\7g\2\2\u01cd"+
		"\u01ce\7\u0081\2\2\u01ce\u01cf\7\b\2\2\u01cf\u01d0\7\u0081\2\2\u01d0\u01d1"+
		"\7\b\2\2\u01d1\u01d2\7h\2\2\u01d2\u01d3\7\b\2\2\u01d3\u01d5\7i\2\2\u01d4"+
		"\u01d6\7\u0085\2\2\u01d5\u01d4\3\2\2\2\u01d6\u01d7\3\2\2\2\u01d7\u01d5"+
		"\3\2\2\2\u01d7\u01d8\3\2\2\2\u01d8\u01e2\3\2\2\2\u01d9\u01da\7j\2\2\u01da"+
		"\u01db\5\32\16\2\u01db\u01df\7k\2\2\u01dc\u01de\7\u0085\2\2\u01dd\u01dc"+
		"\3\2\2\2\u01de\u01e1\3\2\2\2\u01df\u01dd\3\2\2\2\u01df\u01e0\3\2\2\2\u01e0"+
		"\u01e3\3\2\2\2\u01e1\u01df\3\2\2\2\u01e2\u01d9\3\2\2\2\u01e2\u01e3\3\2"+
		"\2\2\u01e3\u01e4\3\2\2\2\u01e4\u01e6\5$\23\2\u01e5\u01cc\3\2\2\2\u01e5"+
		"\u01e6\3\2\2\2\u01e6\31\3\2\2\2\u01e7\u01eb\7\6\2\2\u01e8\u01ea\7\u0085"+
		"\2\2\u01e9\u01e8\3\2\2\2\u01ea\u01ed\3\2\2\2\u01eb\u01e9\3\2\2\2\u01eb"+
		"\u01ec\3\2\2\2\u01ec\u01ee\3\2\2\2\u01ed\u01eb\3\2\2\2\u01ee\u01f2\7l"+
		"\2\2\u01ef\u01f1\7\u0085\2\2\u01f0\u01ef\3\2\2\2\u01f1\u01f4\3\2\2\2\u01f2"+
		"\u01f0\3\2\2\2\u01f2\u01f3\3\2\2\2\u01f3\u01f6\3\2\2\2\u01f4\u01f2\3\2"+
		"\2\2\u01f5\u01f7\5\34\17\2\u01f6\u01f5\3\2\2\2\u01f6\u01f7\3\2\2\2\u01f7"+
		"\u0202\3\2\2\2\u01f8\u01fa\7\u0085\2\2\u01f9\u01f8\3\2\2\2\u01fa\u01fb"+
		"\3\2\2\2\u01fb\u01f9\3\2\2\2\u01fb\u01fc\3\2\2\2\u01fc\u01fe\3\2\2\2\u01fd"+
		"\u01ff\5\34\17\2\u01fe\u01fd\3\2\2\2\u01fe\u01ff\3\2\2\2\u01ff\u0201\3"+
		"\2\2\2\u0200\u01f9\3\2\2\2\u0201\u0204\3\2\2\2\u0202\u0200\3\2\2\2\u0202"+
		"\u0203\3\2\2\2\u0203\u0205\3\2\2\2\u0204\u0202\3\2\2\2\u0205\u0209\7\7"+
		"\2\2\u0206\u0208\7\u0085\2\2\u0207\u0206\3\2\2\2\u0208\u020b\3\2\2\2\u0209"+
		"\u0207\3\2\2\2\u0209\u020a\3\2\2\2\u020a\33\3\2\2\2\u020b\u0209\3\2\2"+
		"\2\u020c\u020f\5\36\20\2\u020d\u020f\5 \21\2\u020e\u020c\3\2\2\2\u020e"+
		"\u020d\3\2\2\2\u020f\35\3\2\2\2\u0210\u0211\7\u0081\2\2\u0211\u0212\7"+
		"\b\2\2\u0212\u0213\5\16\b\2\u0213\37\3\2\2\2\u0214\u0215\7m\2\2\u0215"+
		"\u0217\7\u0081\2\2\u0216\u0218\7\u0085\2\2\u0217\u0216\3\2\2\2\u0217\u0218"+
		"\3\2\2\2\u0218\u0219\3\2\2\2\u0219\u021a\7\22\2\2\u021a\u021f\5\"\22\2"+
		"\u021b\u021c\7\3\2\2\u021c\u021e\5\"\22\2\u021d\u021b\3\2\2\2\u021e\u0221"+
		"\3\2\2\2\u021f\u021d\3\2\2\2\u021f\u0220\3\2\2\2\u0220\u0222\3\2\2\2\u0221"+
		"\u021f\3\2\2\2\u0222\u0223\7\23\2\2\u0223\u0224\7\t\2\2\u0224\u0225\5"+
		"\22\n\2\u0225!\3\2\2\2\u0226\u0227\7\u0081\2\2\u0227\u0228\7\t\2\2\u0228"+
		"\u0229\5\22\n\2\u0229#\3\2\2\2\u022a\u022c\5&\24\2\u022b\u022a\3\2\2\2"+
		"\u022b\u022c\3\2\2\2\u022c\u0237\3\2\2\2\u022d\u022f\7\u0085\2\2\u022e"+
		"\u022d\3\2\2\2\u022f\u0230\3\2\2\2\u0230\u022e\3\2\2\2\u0230\u0231\3\2"+
		"\2\2\u0231\u0233\3\2\2\2\u0232\u0234\5&\24\2\u0233\u0232\3\2\2\2\u0233"+
		"\u0234\3\2\2\2\u0234\u0236\3\2\2\2\u0235\u022e\3\2\2\2\u0236\u0239\3\2"+
		"\2\2\u0237\u0235\3\2\2\2\u0237\u0238\3\2\2\2\u0238%\3\2\2\2\u0239\u0237"+
		"\3\2\2\2\u023a\u023b\t\33\2\2\u023b\u023c\7\u0081\2\2\u023c\u023d\7\t"+
		"\2\2\u023d\u023e\5\22\n\2\u023e\u0240\7\"\2\2\u023f\u0241\7\u0085\2\2"+
		"\u0240\u023f\3\2\2\2\u0240\u0241\3\2\2\2\u0241\u0242\3\2\2\2\u0242\u0243"+
		"\5(\25\2\u0243\u02d8\3\2\2\2\u0244\u0245\7\u0081\2\2\u0245\u0247\7\"\2"+
		"\2\u0246\u0248\7\u0085\2\2\u0247\u0246\3\2\2\2\u0247\u0248\3\2\2\2\u0248"+
		"\u0249\3\2\2\2\u0249\u02d8\5(\25\2\u024a\u024b\7p\2\2\u024b\u024c\7\22"+
		"\2\2\u024c\u024d\5(\25\2\u024d\u024e\7\23\2\2\u024e\u02d8\3\2\2\2\u024f"+
		"\u0250\7q\2\2\u0250\u0251\7\22\2\2\u0251\u0252\5(\25\2\u0252\u0256\7\23"+
		"\2\2\u0253\u0255\7\u0085\2\2\u0254\u0253\3\2\2\2\u0255\u0258\3\2\2\2\u0256"+
		"\u0254\3\2\2\2\u0256\u0257\3\2\2\2\u0257\u0259\3\2\2\2\u0258\u0256\3\2"+
		"\2\2\u0259\u025a\7\6\2\2\u025a\u025b\5$\23\2\u025b\u0267\7\7\2\2\u025c"+
		"\u0260\7r\2\2\u025d\u025f\7\u0085\2\2\u025e\u025d\3\2\2\2\u025f\u0262"+
		"\3\2\2\2\u0260\u025e\3\2\2\2\u0260\u0261\3\2\2\2\u0261\u0263\3\2\2\2\u0262"+
		"\u0260\3\2\2\2\u0263\u0264\7\6\2\2\u0264\u0265\5$\23\2\u0265\u0266\7\7"+
		"\2\2\u0266\u0268\3\2\2\2\u0267\u025c\3\2\2\2\u0267\u0268\3\2\2\2\u0268"+
		"\u02d8\3\2\2\2\u0269\u026a\7s\2\2\u026a\u026b\7\22\2\2\u026b\u026c\5("+
		"\25\2\u026c\u0270\7\23\2\2\u026d\u026f\7\u0085\2\2\u026e\u026d\3\2\2\2"+
		"\u026f\u0272\3\2\2\2\u0270\u026e\3\2\2\2\u0270\u0271\3\2\2\2\u0271\u0273"+
		"\3\2\2\2\u0272\u0270\3\2\2\2\u0273\u027e\7\6\2\2\u0274\u0276\7\u0085\2"+
		"\2\u0275\u0274\3\2\2\2\u0276\u0279\3\2\2\2\u0277\u0275\3\2\2\2\u0277\u0278"+
		"\3\2\2\2\u0278\u027a\3\2\2\2\u0279\u0277\3\2\2\2\u027a\u027b\7j\2\2\u027b"+
		"\u027c\5*\26\2\u027c\u027d\7k\2\2\u027d\u027f\3\2\2\2\u027e\u0277\3\2"+
		"\2\2\u027e\u027f\3\2\2\2\u027f\u0280\3\2\2\2\u0280\u0281\5$\23\2\u0281"+
		"\u0282\7\7\2\2\u0282\u02d8\3\2\2\2\u0283\u0284\t\34\2\2\u0284\u0285\7"+
		"\22\2\2\u0285\u0286\7\u0082\2\2\u0286\u02d8\7\23\2\2\u0287\u0288\7\u0081"+
		"\2\2\u0288\u0289\7\22\2\2\u0289\u028a\5(\25\2\u028a\u028b\7\23\2\2\u028b"+
		"\u028d\7\"\2\2\u028c\u028e\7\u0085\2\2\u028d\u028c\3\2\2\2\u028d\u028e"+
		"\3\2\2\2\u028e\u028f\3\2\2\2\u028f\u0290\5(\25\2\u0290\u02d8\3\2\2\2\u0291"+
		"\u0292\7m\2\2\u0292\u0294\7\u0081\2\2\u0293\u0295\7\u0085\2\2\u0294\u0293"+
		"\3\2\2\2\u0294\u0295\3\2\2\2\u0295\u0296\3\2\2\2\u0296\u029f\7\22\2\2"+
		"\u0297\u029c\5\"\22\2\u0298\u0299\7\3\2\2\u0299\u029b\5\"\22\2\u029a\u0298"+
		"\3\2\2\2\u029b\u029e\3\2\2\2\u029c\u029a\3\2\2\2\u029c\u029d\3\2\2\2\u029d"+
		"\u02a0\3\2\2\2\u029e\u029c\3\2\2\2\u029f\u0297\3\2\2\2\u029f\u02a0\3\2"+
		"\2\2\u02a0\u02a1\3\2\2\2\u02a1\u02a2\7\23\2\2\u02a2\u02a5\7\t\2\2\u02a3"+
		"\u02a6\5\22\n\2\u02a4\u02a6\7v\2\2\u02a5\u02a3\3\2\2\2\u02a5\u02a4\3\2"+
		"\2\2\u02a6\u02a7\3\2\2\2\u02a7\u02ab\7\"\2\2\u02a8\u02aa\7\u0085\2\2\u02a9"+
		"\u02a8\3\2\2\2\u02aa\u02ad\3\2\2\2\u02ab\u02a9\3\2\2\2\u02ab\u02ac\3\2"+
		"\2\2\u02ac\u02ae\3\2\2\2\u02ad\u02ab\3\2\2\2\u02ae\u02bf\7\6\2\2\u02af"+
		"\u02b1\7\u0085\2\2\u02b0\u02af\3\2\2\2\u02b1\u02b4\3\2\2\2\u02b2\u02b0"+
		"\3\2\2\2\u02b2\u02b3\3\2\2\2\u02b3\u02b5\3\2\2\2\u02b4\u02b2\3\2\2\2\u02b5"+
		"\u02b6\7j\2\2\u02b6\u02ba\5.\30\2\u02b7\u02b9\7\u0085\2\2\u02b8\u02b7"+
		"\3\2\2\2\u02b9\u02bc\3\2\2\2\u02ba\u02b8\3\2\2\2\u02ba\u02bb\3\2\2\2\u02bb"+
		"\u02bd\3\2\2\2\u02bc\u02ba\3\2\2\2\u02bd\u02be\7k\2\2\u02be\u02c0\3\2"+
		"\2\2\u02bf\u02b2\3\2\2\2\u02bf\u02c0\3\2\2\2\u02c0\u02c1\3\2\2\2\u02c1"+
		"\u02ca\5$\23\2\u02c2\u02c3\7w\2\2\u02c3\u02c7\5(\25\2\u02c4\u02c6\7\u0085"+
		"\2\2\u02c5\u02c4\3\2\2\2\u02c6\u02c9\3\2\2\2\u02c7\u02c5\3\2\2\2\u02c7"+
		"\u02c8\3\2\2\2\u02c8\u02cb\3\2\2\2\u02c9\u02c7\3\2\2\2\u02ca\u02c2\3\2"+
		"\2\2\u02ca\u02cb\3\2\2\2\u02cb\u02cc\3\2\2\2\u02cc\u02cd\7\7\2\2\u02cd"+
		"\u02d8\3\2\2\2\u02ce\u02d2\7j\2\2\u02cf\u02d3\5\n\6\2\u02d0\u02d3\5\b"+
		"\5\2\u02d1\u02d3\5\60\31\2\u02d2\u02cf\3\2\2\2\u02d2\u02d0\3\2\2\2\u02d2"+
		"\u02d1\3\2\2\2\u02d3\u02d4\3\2\2\2\u02d4\u02d5\7k\2\2\u02d5\u02d8\3\2"+
		"\2\2\u02d6\u02d8\5(\25\2\u02d7\u023a\3\2\2\2\u02d7\u0244\3\2\2\2\u02d7"+
		"\u024a\3\2\2\2\u02d7\u024f\3\2\2\2\u02d7\u0269\3\2\2\2\u02d7\u0283\3\2"+
		"\2\2\u02d7\u0287\3\2\2\2\u02d7\u0291\3\2\2\2\u02d7\u02ce\3\2\2\2\u02d7"+
		"\u02d6\3\2\2\2\u02d8\'\3\2\2\2\u02d9\u02da\b\25\1\2\u02da\u02db\t\35\2"+
		"\2\u02db\u030b\5(\25\n\u02dc\u030b\t\4\2\2\u02dd\u030b\7\u0080\2\2\u02de"+
		"\u02ed\7\u0081\2\2\u02df\u02e8\7\22\2\2\u02e0\u02e5\5(\25\2\u02e1\u02e2"+
		"\7\3\2\2\u02e2\u02e4\5(\25\2\u02e3\u02e1\3\2\2\2\u02e4\u02e7\3\2\2\2\u02e5"+
		"\u02e3\3\2\2\2\u02e5\u02e6\3\2\2\2\u02e6\u02e9\3\2\2\2\u02e7\u02e5\3\2"+
		"\2\2\u02e8\u02e0\3\2\2\2\u02e8\u02e9\3\2\2\2\u02e9\u02ea\3\2\2\2\u02ea"+
		"\u02ee\7\23\2\2\u02eb\u02ec\7\b\2\2\u02ec\u02ee\7\u0081\2\2\u02ed\u02df"+
		"\3\2\2\2\u02ed\u02eb\3\2\2\2\u02ed\u02ee\3\2\2\2\u02ee\u030b\3\2\2\2\u02ef"+
		"\u02f0\7\25\2\2\u02f0\u02f1\7\22\2\2\u02f1\u02f2\7\u0083\2\2\u02f2\u030b"+
		"\7\23\2\2\u02f3\u02f4\7\26\2\2\u02f4\u02fd\7\22\2\2\u02f5\u02fa\5(\25"+
		"\2\u02f6\u02f7\7\3\2\2\u02f7\u02f9\5(\25\2\u02f8\u02f6\3\2\2\2\u02f9\u02fc"+
		"\3\2\2\2\u02fa\u02f8\3\2\2\2\u02fa\u02fb\3\2\2\2\u02fb\u02fe\3\2\2\2\u02fc"+
		"\u02fa\3\2\2\2\u02fd\u02f5\3\2\2\2\u02fd\u02fe\3\2\2\2\u02fe\u02ff\3\2"+
		"\2\2\u02ff\u030b\7\23\2\2\u0300\u0301\7x\2\2\u0301\u0303\7\22\2\2\u0302"+
		"\u0304\7\u0083\2\2\u0303\u0302\3\2\2\2\u0303\u0304\3\2\2\2\u0304\u0305"+
		"\3\2\2\2\u0305\u030b\7\23\2\2\u0306\u0307\7\22\2\2\u0307\u0308\5(\25\2"+
		"\u0308\u0309\7\23\2\2\u0309\u030b\3\2\2\2\u030a\u02d9\3\2\2\2\u030a\u02dc"+
		"\3\2\2\2\u030a\u02dd\3\2\2\2\u030a\u02de\3\2\2\2\u030a\u02ef\3\2\2\2\u030a"+
		"\u02f3\3\2\2\2\u030a\u0300\3\2\2\2\u030a\u0306\3\2\2\2\u030b\u0338\3\2"+
		"\2\2\u030c\u030d\f\t\2\2\u030d\u030f\t\5\2\2\u030e\u0310\7\u0085\2\2\u030f"+
		"\u030e\3\2\2\2\u030f\u0310\3\2\2\2\u0310\u0311\3\2\2\2\u0311\u0337\5("+
		"\25\n\u0312\u0313\f\b\2\2\u0313\u0315\t\36\2\2\u0314\u0316\7\u0085\2\2"+
		"\u0315\u0314\3\2\2\2\u0315\u0316\3\2\2\2\u0316\u0317\3\2\2\2\u0317\u0337"+
		"\5(\25\t\u0318\u0319\f\7\2\2\u0319\u031b\7y\2\2\u031a\u031c\7\u0085\2"+
		"\2\u031b\u031a\3\2\2\2\u031b\u031c\3\2\2\2\u031c\u031d\3\2\2\2\u031d\u0337"+
		"\5(\25\b\u031e\u031f\f\6\2\2\u031f\u0321\t\37\2\2\u0320\u0322\7\u0085"+
		"\2\2\u0321\u0320\3\2\2\2\u0321\u0322\3\2\2\2\u0322\u0323\3\2\2\2\u0323"+
		"\u0337\5(\25\7\u0324\u0325\f\5\2\2\u0325\u0327\t \2\2\u0326\u0328\7\u0085"+
		"\2\2\u0327\u0326\3\2\2\2\u0327\u0328\3\2\2\2\u0328\u0329\3\2\2\2\u0329"+
		"\u0337\5(\25\6\u032a\u032b\f\4\2\2\u032b\u032d\7+\2\2\u032c\u032e\7\u0085"+
		"\2\2\u032d\u032c\3\2\2\2\u032d\u032e\3\2\2\2\u032e\u032f\3\2\2\2\u032f"+
		"\u0337\5(\25\5\u0330\u0331\f\3\2\2\u0331\u0333\7/\2\2\u0332\u0334\7\u0085"+
		"\2\2\u0333\u0332\3\2\2\2\u0333\u0334\3\2\2\2\u0334\u0335\3\2\2\2\u0335"+
		"\u0337\5(\25\4\u0336\u030c\3\2\2\2\u0336\u0312\3\2\2\2\u0336\u0318\3\2"+
		"\2\2\u0336\u031e\3\2\2\2\u0336\u0324\3\2\2\2\u0336\u032a\3\2\2\2\u0336"+
		"\u0330\3\2\2\2\u0337\u033a\3\2\2\2\u0338\u0336\3\2\2\2\u0338\u0339\3\2"+
		"\2\2\u0339)\3\2\2\2\u033a\u0338\3\2\2\2\u033b\u033f\7\6\2\2\u033c\u033e"+
		"\7\u0085\2\2\u033d\u033c\3\2\2\2\u033e\u0341\3\2\2\2\u033f\u033d\3\2\2"+
		"\2\u033f\u0340\3\2\2\2\u0340\u0342\3\2\2\2\u0341\u033f\3\2\2\2\u0342\u0346"+
		"\7e\2\2\u0343\u0345\7\u0085\2\2\u0344\u0343\3\2\2\2\u0345\u0348\3\2\2"+
		"\2\u0346\u0344\3\2\2\2\u0346\u0347\3\2\2\2\u0347\u034a\3\2\2\2\u0348\u0346"+
		"\3\2\2\2\u0349\u034b\5\16\b\2\u034a\u0349\3\2\2\2\u034a\u034b\3\2\2\2"+
		"\u034b\u0356\3\2\2\2\u034c\u034e\7\u0085\2\2\u034d\u034c\3\2\2\2\u034e"+
		"\u034f\3\2\2\2\u034f\u034d\3\2\2\2\u034f\u0350\3\2\2\2\u0350\u0352\3\2"+
		"\2\2\u0351\u0353\5\16\b\2\u0352\u0351\3\2\2\2\u0352\u0353\3\2\2\2\u0353"+
		"\u0355\3\2\2\2\u0354\u034d\3\2\2\2\u0355\u0358\3\2\2\2\u0356\u0354\3\2"+
		"\2\2\u0356\u0357\3\2\2\2\u0357\u0359\3\2\2\2\u0358\u0356\3\2\2\2\u0359"+
		"\u035a\5,\27\2\u035a\u035e\7\7\2\2\u035b\u035d\7\u0085\2\2\u035c\u035b"+
		"\3\2\2\2\u035d\u0360\3\2\2\2\u035e\u035c\3\2\2\2\u035e\u035f\3\2\2\2\u035f"+
		"+\3\2\2\2\u0360\u035e\3\2\2\2\u0361\u036a\7z\2\2\u0362\u0367\7\u0081\2"+
		"\2\u0363\u0364\7\3\2\2\u0364\u0366\7\u0081\2\2\u0365\u0363\3\2\2\2\u0366"+
		"\u0369\3\2\2\2\u0367\u0365\3\2\2\2\u0367\u0368\3\2\2\2\u0368\u036b\3\2"+
		"\2\2\u0369\u0367\3\2\2\2\u036a\u0362\3\2\2\2\u036a\u036b\3\2\2\2\u036b"+
		"\u036f\3\2\2\2\u036c\u036e\7\u0085\2\2\u036d\u036c\3\2\2\2\u036e\u0371"+
		"\3\2\2\2\u036f\u036d\3\2\2\2\u036f\u0370\3\2\2\2\u0370-\3\2\2\2\u0371"+
		"\u036f\3\2\2\2\u0372\u0376\7\6\2\2\u0373\u0375\7\u0085\2\2\u0374\u0373"+
		"\3\2\2\2\u0375\u0378\3\2\2\2\u0376\u0374\3\2\2\2\u0376\u0377\3\2\2\2\u0377"+
		"\u038e\3\2\2\2\u0378\u0376\3\2\2\2\u0379\u037d\t!\2\2\u037a\u037c\7\u0085"+
		"\2\2\u037b\u037a\3\2\2\2\u037c\u037f\3\2\2\2\u037d\u037b\3\2\2\2\u037d"+
		"\u037e\3\2\2\2\u037e\u0380\3\2\2\2\u037f\u037d\3\2\2\2\u0380\u038b\5\16"+
		"\b\2\u0381\u0383\7\u0085\2\2\u0382\u0381\3\2\2\2\u0383\u0384\3\2\2\2\u0384"+
		"\u0382\3\2\2\2\u0384\u0385\3\2\2\2\u0385\u0387\3\2\2\2\u0386\u0388\5\16"+
		"\b\2\u0387\u0386\3\2\2\2\u0387\u0388\3\2\2\2\u0388\u038a\3\2\2\2\u0389"+
		"\u0382\3\2\2\2\u038a\u038d\3\2\2\2\u038b\u0389\3\2\2\2\u038b\u038c\3\2"+
		"\2\2\u038c\u038f\3\2\2\2\u038d\u038b\3\2\2\2\u038e\u0379\3\2\2\2\u038e"+
		"\u038f\3\2\2\2\u038f\u0393\3\2\2\2\u0390\u0392\7\u0085\2\2\u0391\u0390"+
		"\3\2\2\2\u0392\u0395\3\2\2\2\u0393\u0391\3\2\2\2\u0393\u0394\3\2\2\2\u0394"+
		"\u0397\3\2\2\2\u0395\u0393\3\2\2\2\u0396\u0398\5,\27\2\u0397\u0396\3\2"+
		"\2\2\u0397\u0398\3\2\2\2\u0398\u03ae\3\2\2\2\u0399\u039d\t\"\2\2\u039a"+
		"\u039c\7\u0085\2\2\u039b\u039a\3\2\2\2\u039c\u039f\3\2\2\2\u039d\u039b"+
		"\3\2\2\2\u039d\u039e\3\2\2\2\u039e\u03a0\3\2\2\2\u039f\u039d\3\2\2\2\u03a0"+
		"\u03ab\5\16\b\2\u03a1\u03a3\7\u0085\2\2\u03a2\u03a1\3\2\2\2\u03a3\u03a4"+
		"\3\2\2\2\u03a4\u03a2\3\2\2\2\u03a4\u03a5\3\2\2\2\u03a5\u03a7\3\2\2\2\u03a6"+
		"\u03a8\5\16\b\2\u03a7\u03a6\3\2\2\2\u03a7\u03a8\3\2\2\2\u03a8\u03aa\3"+
		"\2\2\2\u03a9\u03a2\3\2\2\2\u03aa\u03ad\3\2\2\2\u03ab\u03a9\3\2\2\2\u03ab"+
		"\u03ac\3\2\2\2\u03ac\u03af\3\2\2\2\u03ad\u03ab\3\2\2\2\u03ae\u0399\3\2"+
		"\2\2\u03ae\u03af\3\2\2\2\u03af\u03b3\3\2\2\2\u03b0\u03b2\7\u0085\2\2\u03b1"+
		"\u03b0\3\2\2\2\u03b2\u03b5\3\2\2\2\u03b3\u03b1\3\2\2\2\u03b3\u03b4\3\2"+
		"\2\2\u03b4\u03b6\3\2\2\2\u03b5\u03b3\3\2\2\2\u03b6\u03ba\7\7\2\2\u03b7"+
		"\u03b9\7\u0085\2\2\u03b8\u03b7\3\2\2\2\u03b9\u03bc\3\2\2\2\u03ba\u03b8"+
		"\3\2\2\2\u03ba\u03bb\3\2\2\2\u03bb/\3\2\2\2\u03bc\u03ba\3\2\2\2\u03bd"+
		"\u03c1\7\6\2\2\u03be\u03c0\7\u0085\2\2\u03bf\u03be\3\2\2\2\u03c0\u03c3"+
		"\3\2\2\2\u03c1\u03bf\3\2\2\2\u03c1\u03c2\3\2\2\2\u03c2\u03c4\3\2\2\2\u03c3"+
		"\u03c1\3\2\2\2\u03c4\u03c8\7e\2\2\u03c5\u03c7\7\u0085\2\2\u03c6\u03c5"+
		"\3\2\2\2\u03c7\u03ca\3\2\2\2\u03c8\u03c6\3\2\2\2\u03c8\u03c9\3\2\2\2\u03c9"+
		"\u03cc\3\2\2\2\u03ca\u03c8\3\2\2\2\u03cb\u03cd\5\16\b\2\u03cc\u03cb\3"+
		"\2\2\2\u03cc\u03cd\3\2\2\2\u03cd\u03d8\3\2\2\2\u03ce\u03d0\7\u0085\2\2"+
		"\u03cf\u03ce\3\2\2\2\u03d0\u03d1\3\2\2\2\u03d1\u03cf\3\2\2\2\u03d1\u03d2"+
		"\3\2\2\2\u03d2\u03d4\3\2\2\2\u03d3\u03d5\5\16\b\2\u03d4\u03d3\3\2\2\2"+
		"\u03d4\u03d5\3\2\2\2\u03d5\u03d7\3\2\2\2\u03d6\u03cf\3\2\2\2\u03d7\u03da"+
		"\3\2\2\2\u03d8\u03d6\3\2\2\2\u03d8\u03d9\3\2\2\2\u03d9\u03db\3\2\2\2\u03da"+
		"\u03d8\3\2\2\2\u03db\u03df\7\7\2\2\u03dc\u03de\7\u0085\2\2\u03dd\u03dc"+
		"\3\2\2\2\u03de\u03e1\3\2\2\2\u03df\u03dd\3\2\2\2\u03df\u03e0\3\2\2\2\u03e0"+
		"\61\3\2\2\2\u03e1\u03df\3\2\2\2\u0096\66:?ORZ`gimruy\u0080\u008d\u0094"+
		"\u009c\u00a4\u00a9\u00ae\u00b1\u00b5\u00b9\u00c4\u00d2\u00e3\u00e6\u00ea"+
		"\u00ef\u00f5\u00fb\u0101\u0107\u010d\u0113\u0116\u0118\u0121\u0129\u012d"+
		"\u0131\u0135\u013c\u0142\u0149\u014f\u0155\u015d\u0163\u016a\u0171\u0178"+
		"\u0189\u0191\u0199\u019f\u01a6\u01b3\u01bf\u01c2\u01c9\u01d7\u01df\u01e2"+
		"\u01e5\u01eb\u01f2\u01f6\u01fb\u01fe\u0202\u0209\u020e\u0217\u021f\u022b"+
		"\u0230\u0233\u0237\u0240\u0247\u0256\u0260\u0267\u0270\u0277\u027e\u028d"+
		"\u0294\u029c\u029f\u02a5\u02ab\u02b2\u02ba\u02bf\u02c7\u02ca\u02d2\u02d7"+
		"\u02e5\u02e8\u02ed\u02fa\u02fd\u0303\u030a\u030f\u0315\u031b\u0321\u0327"+
		"\u032d\u0333\u0336\u0338\u033f\u0346\u034a\u034f\u0352\u0356\u035e\u0367"+
		"\u036a\u036f\u0376\u037d\u0384\u0387\u038b\u038e\u0393\u0397\u039d\u03a4"+
		"\u03a7\u03ab\u03ae\u03b3\u03ba\u03c1\u03c8\u03cc\u03d1\u03d4\u03d8\u03df";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}