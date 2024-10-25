// Generated from /Users/mnocet/Documents/Education/IMT-Atlantique/S5/ingenierie-des-langages/PCF-V2/PCF/src/parser/PCF.g4 by ANTLR 4.13.2
package parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class PCFParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, LIT=16, ID=17, 
		LINE_COMMENT=18, WS=19;
	public static final int
		RULE_term = 0;
	private static String[] makeRuleNames() {
		return new String[] {
			"term"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'*'", "'/'", "'+'", "'-'", "'ifz'", "'then'", "'else'", "'let'", 
			"'='", "'in'", "'fun'", "'->'", "'fix'", "'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "LIT", "ID", "LINE_COMMENT", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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
	public String getGrammarFileName() { return "PCF.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PCFParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TermContext extends ParserRuleContext {
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
	 
		public TermContext() { }
		public void copyFrom(TermContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParContext extends TermContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public ParContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PCFListener ) ((PCFListener)listener).enterPar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PCFListener ) ((PCFListener)listener).exitPar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCFVisitor ) return ((PCFVisitor<? extends T>)visitor).visitPar(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AppContext extends TermContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public AppContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PCFListener ) ((PCFListener)listener).enterApp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PCFListener ) ((PCFListener)listener).exitApp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCFVisitor ) return ((PCFVisitor<? extends T>)visitor).visitApp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BOpContext extends TermContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public BOpContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PCFListener ) ((PCFListener)listener).enterBOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PCFListener ) ((PCFListener)listener).exitBOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCFVisitor ) return ((PCFVisitor<? extends T>)visitor).visitBOp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FixContext extends TermContext {
		public TerminalNode ID() { return getToken(PCFParser.ID, 0); }
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public FixContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PCFListener ) ((PCFListener)listener).enterFix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PCFListener ) ((PCFListener)listener).exitFix(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCFVisitor ) return ((PCFVisitor<? extends T>)visitor).visitFix(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LitContext extends TermContext {
		public TerminalNode LIT() { return getToken(PCFParser.LIT, 0); }
		public LitContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PCFListener ) ((PCFListener)listener).enterLit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PCFListener ) ((PCFListener)listener).exitLit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCFVisitor ) return ((PCFVisitor<? extends T>)visitor).visitLit(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VarContext extends TermContext {
		public TerminalNode ID() { return getToken(PCFParser.ID, 0); }
		public VarContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PCFListener ) ((PCFListener)listener).enterVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PCFListener ) ((PCFListener)listener).exitVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCFVisitor ) return ((PCFVisitor<? extends T>)visitor).visitVar(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LetContext extends TermContext {
		public TerminalNode ID() { return getToken(PCFParser.ID, 0); }
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public LetContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PCFListener ) ((PCFListener)listener).enterLet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PCFListener ) ((PCFListener)listener).exitLet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCFVisitor ) return ((PCFVisitor<? extends T>)visitor).visitLet(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IfZContext extends TermContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public IfZContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PCFListener ) ((PCFListener)listener).enterIfZ(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PCFListener ) ((PCFListener)listener).exitIfZ(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCFVisitor ) return ((PCFVisitor<? extends T>)visitor).visitIfZ(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FunContext extends TermContext {
		public TerminalNode ID() { return getToken(PCFParser.ID, 0); }
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public FunContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PCFListener ) ((PCFListener)listener).enterFun(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PCFListener ) ((PCFListener)listener).exitFun(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCFVisitor ) return ((PCFVisitor<? extends T>)visitor).visitFun(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		return term(0);
	}

	private TermContext term(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TermContext _localctx = new TermContext(_ctx, _parentState);
		TermContext _prevctx = _localctx;
		int _startState = 0;
		enterRecursionRule(_localctx, 0, RULE_term, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LIT:
				{
				_localctx = new LitContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(3);
				match(LIT);
				}
				break;
			case ID:
				{
				_localctx = new VarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(4);
				match(ID);
				}
				break;
			case T__4:
				{
				_localctx = new IfZContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(5);
				match(T__4);
				setState(6);
				term(0);
				setState(7);
				match(T__5);
				setState(8);
				term(0);
				setState(9);
				match(T__6);
				setState(10);
				term(5);
				}
				break;
			case T__7:
				{
				_localctx = new LetContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(12);
				match(T__7);
				setState(13);
				match(ID);
				setState(14);
				match(T__8);
				setState(15);
				term(0);
				setState(16);
				match(T__9);
				setState(17);
				term(4);
				}
				break;
			case T__10:
				{
				_localctx = new FunContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(19);
				match(T__10);
				setState(20);
				match(ID);
				setState(21);
				match(T__11);
				setState(22);
				term(3);
				}
				break;
			case T__12:
				{
				_localctx = new FixContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(23);
				match(T__12);
				setState(24);
				match(ID);
				setState(25);
				term(2);
				}
				break;
			case T__13:
				{
				_localctx = new ParContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(26);
				match(T__13);
				setState(27);
				term(0);
				setState(28);
				match(T__14);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(42);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(40);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
					case 1:
						{
						_localctx = new AppContext(new TermContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(32);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(33);
						term(9);
						}
						break;
					case 2:
						{
						_localctx = new BOpContext(new TermContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(34);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(35);
						_la = _input.LA(1);
						if ( !(_la==T__0 || _la==T__1) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(36);
						term(8);
						}
						break;
					case 3:
						{
						_localctx = new BOpContext(new TermContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(37);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(38);
						_la = _input.LA(1);
						if ( !(_la==T__2 || _la==T__3) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(39);
						term(7);
						}
						break;
					}
					} 
				}
				setState(44);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 0:
			return term_sempred((TermContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean term_sempred(TermContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 8);
		case 1:
			return precpred(_ctx, 7);
		case 2:
			return precpred(_ctx, 6);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0013.\u0002\u0000\u0007\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0003\u0000\u001f\b\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0005"+
		"\u0000)\b\u0000\n\u0000\f\u0000,\t\u0000\u0001\u0000\u0000\u0001\u0000"+
		"\u0001\u0000\u0000\u0002\u0001\u0000\u0001\u0002\u0001\u0000\u0003\u0004"+
		"5\u0000\u001e\u0001\u0000\u0000\u0000\u0002\u0003\u0006\u0000\uffff\uffff"+
		"\u0000\u0003\u001f\u0005\u0010\u0000\u0000\u0004\u001f\u0005\u0011\u0000"+
		"\u0000\u0005\u0006\u0005\u0005\u0000\u0000\u0006\u0007\u0003\u0000\u0000"+
		"\u0000\u0007\b\u0005\u0006\u0000\u0000\b\t\u0003\u0000\u0000\u0000\t\n"+
		"\u0005\u0007\u0000\u0000\n\u000b\u0003\u0000\u0000\u0005\u000b\u001f\u0001"+
		"\u0000\u0000\u0000\f\r\u0005\b\u0000\u0000\r\u000e\u0005\u0011\u0000\u0000"+
		"\u000e\u000f\u0005\t\u0000\u0000\u000f\u0010\u0003\u0000\u0000\u0000\u0010"+
		"\u0011\u0005\n\u0000\u0000\u0011\u0012\u0003\u0000\u0000\u0004\u0012\u001f"+
		"\u0001\u0000\u0000\u0000\u0013\u0014\u0005\u000b\u0000\u0000\u0014\u0015"+
		"\u0005\u0011\u0000\u0000\u0015\u0016\u0005\f\u0000\u0000\u0016\u001f\u0003"+
		"\u0000\u0000\u0003\u0017\u0018\u0005\r\u0000\u0000\u0018\u0019\u0005\u0011"+
		"\u0000\u0000\u0019\u001f\u0003\u0000\u0000\u0002\u001a\u001b\u0005\u000e"+
		"\u0000\u0000\u001b\u001c\u0003\u0000\u0000\u0000\u001c\u001d\u0005\u000f"+
		"\u0000\u0000\u001d\u001f\u0001\u0000\u0000\u0000\u001e\u0002\u0001\u0000"+
		"\u0000\u0000\u001e\u0004\u0001\u0000\u0000\u0000\u001e\u0005\u0001\u0000"+
		"\u0000\u0000\u001e\f\u0001\u0000\u0000\u0000\u001e\u0013\u0001\u0000\u0000"+
		"\u0000\u001e\u0017\u0001\u0000\u0000\u0000\u001e\u001a\u0001\u0000\u0000"+
		"\u0000\u001f*\u0001\u0000\u0000\u0000 !\n\b\u0000\u0000!)\u0003\u0000"+
		"\u0000\t\"#\n\u0007\u0000\u0000#$\u0007\u0000\u0000\u0000$)\u0003\u0000"+
		"\u0000\b%&\n\u0006\u0000\u0000&\'\u0007\u0001\u0000\u0000\')\u0003\u0000"+
		"\u0000\u0007( \u0001\u0000\u0000\u0000(\"\u0001\u0000\u0000\u0000(%\u0001"+
		"\u0000\u0000\u0000),\u0001\u0000\u0000\u0000*(\u0001\u0000\u0000\u0000"+
		"*+\u0001\u0000\u0000\u0000+\u0001\u0001\u0000\u0000\u0000,*\u0001\u0000"+
		"\u0000\u0000\u0003\u001e(*";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}