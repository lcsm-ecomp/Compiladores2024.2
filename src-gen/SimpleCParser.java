// Generated from java-escape by ANTLR 4.11.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class SimpleCParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, OP1=11, OP2=12, OP3=13, NUM=14, VAR=15, BLABLABLA=16;
	public static final int
		RULE_start = 0, RULE_com = 1, RULE_expr = 2;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "com", "expr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'print'", "'('", "')'", "';'", "'='", "'if'", "'else'", "'while'", 
			"'{'", "'}'", null, null, "'^'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, "OP1", 
			"OP2", "OP3", "NUM", "VAR", "BLABLABLA"
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
	public String getGrammarFileName() { return "java-escape"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SimpleCParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StartContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(SimpleCParser.EOF, 0); }
		public List<ComContext> com() {
			return getRuleContexts(ComContext.class);
		}
		public ComContext com(int i) {
			return getRuleContext(ComContext.class,i);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCListener ) ((SimpleCListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCListener ) ((SimpleCListener)listener).exitStart(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(7); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(6);
				com();
				}
				}
				setState(9); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((_la) & ~0x3f) == 0 && ((1L << _la) & 33602L) != 0 );
			setState(11);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ComContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode VAR() { return getToken(SimpleCParser.VAR, 0); }
		public List<ComContext> com() {
			return getRuleContexts(ComContext.class);
		}
		public ComContext com(int i) {
			return getRuleContext(ComContext.class,i);
		}
		public ComContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_com; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCListener ) ((SimpleCListener)listener).enterCom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCListener ) ((SimpleCListener)listener).exitCom(this);
		}
	}

	public final ComContext com() throws RecognitionException {
		ComContext _localctx = new ComContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_com);
		int _la;
		try {
			setState(47);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(13);
				match(T__0);
				setState(14);
				match(T__1);
				setState(15);
				expr(0);
				setState(16);
				match(T__2);
				setState(17);
				match(T__3);
				}
				break;
			case VAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(19);
				match(VAR);
				setState(20);
				match(T__4);
				setState(21);
				expr(0);
				setState(22);
				match(T__3);
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 3);
				{
				setState(24);
				match(T__5);
				setState(25);
				match(T__1);
				setState(26);
				expr(0);
				setState(27);
				match(T__2);
				setState(28);
				com();
				setState(31);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
				case 1:
					{
					setState(29);
					match(T__6);
					setState(30);
					com();
					}
					break;
				}
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 4);
				{
				setState(33);
				match(T__7);
				setState(34);
				match(T__1);
				setState(35);
				expr(0);
				setState(36);
				match(T__2);
				setState(37);
				com();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 5);
				{
				setState(39);
				match(T__8);
				setState(43);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((_la) & ~0x3f) == 0 && ((1L << _la) & 33602L) != 0) {
					{
					{
					setState(40);
					com();
					}
					}
					setState(45);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(46);
				match(T__9);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public TerminalNode NUM() { return getToken(SimpleCParser.NUM, 0); }
		public TerminalNode VAR() { return getToken(SimpleCParser.VAR, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OP3() { return getToken(SimpleCParser.OP3, 0); }
		public TerminalNode OP2() { return getToken(SimpleCParser.OP2, 0); }
		public TerminalNode OP1() { return getToken(SimpleCParser.OP1, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCListener ) ((SimpleCListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCListener ) ((SimpleCListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUM:
				{
				setState(50);
				match(NUM);
				}
				break;
			case VAR:
				{
				setState(51);
				match(VAR);
				}
				break;
			case T__1:
				{
				setState(52);
				match(T__1);
				setState(53);
				expr(0);
				setState(54);
				match(T__2);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(69);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(67);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(58);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(59);
						match(OP3);
						setState(60);
						expr(5);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(61);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(62);
						match(OP2);
						setState(63);
						expr(4);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(64);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(65);
						match(OP1);
						setState(66);
						expr(3);
						}
						break;
					}
					} 
				}
				setState(71);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
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
		case 2:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		case 1:
			return precpred(_ctx, 3);
		case 2:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0010I\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0001\u0000\u0004\u0000\b\b\u0000\u000b\u0000\f\u0000"+
		"\t\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0003\u0001 \b\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0005\u0001*\b\u0001\n\u0001\f\u0001-\t\u0001\u0001\u0001\u0003\u0001"+
		"0\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0003\u00029\b\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0005\u0002D\b\u0002\n\u0002\f\u0002G\t\u0002\u0001\u0002"+
		"\u0000\u0001\u0004\u0003\u0000\u0002\u0004\u0000\u0000Q\u0000\u0007\u0001"+
		"\u0000\u0000\u0000\u0002/\u0001\u0000\u0000\u0000\u00048\u0001\u0000\u0000"+
		"\u0000\u0006\b\u0003\u0002\u0001\u0000\u0007\u0006\u0001\u0000\u0000\u0000"+
		"\b\t\u0001\u0000\u0000\u0000\t\u0007\u0001\u0000\u0000\u0000\t\n\u0001"+
		"\u0000\u0000\u0000\n\u000b\u0001\u0000\u0000\u0000\u000b\f\u0005\u0000"+
		"\u0000\u0001\f\u0001\u0001\u0000\u0000\u0000\r\u000e\u0005\u0001\u0000"+
		"\u0000\u000e\u000f\u0005\u0002\u0000\u0000\u000f\u0010\u0003\u0004\u0002"+
		"\u0000\u0010\u0011\u0005\u0003\u0000\u0000\u0011\u0012\u0005\u0004\u0000"+
		"\u0000\u00120\u0001\u0000\u0000\u0000\u0013\u0014\u0005\u000f\u0000\u0000"+
		"\u0014\u0015\u0005\u0005\u0000\u0000\u0015\u0016\u0003\u0004\u0002\u0000"+
		"\u0016\u0017\u0005\u0004\u0000\u0000\u00170\u0001\u0000\u0000\u0000\u0018"+
		"\u0019\u0005\u0006\u0000\u0000\u0019\u001a\u0005\u0002\u0000\u0000\u001a"+
		"\u001b\u0003\u0004\u0002\u0000\u001b\u001c\u0005\u0003\u0000\u0000\u001c"+
		"\u001f\u0003\u0002\u0001\u0000\u001d\u001e\u0005\u0007\u0000\u0000\u001e"+
		" \u0003\u0002\u0001\u0000\u001f\u001d\u0001\u0000\u0000\u0000\u001f \u0001"+
		"\u0000\u0000\u0000 0\u0001\u0000\u0000\u0000!\"\u0005\b\u0000\u0000\""+
		"#\u0005\u0002\u0000\u0000#$\u0003\u0004\u0002\u0000$%\u0005\u0003\u0000"+
		"\u0000%&\u0003\u0002\u0001\u0000&0\u0001\u0000\u0000\u0000\'+\u0005\t"+
		"\u0000\u0000(*\u0003\u0002\u0001\u0000)(\u0001\u0000\u0000\u0000*-\u0001"+
		"\u0000\u0000\u0000+)\u0001\u0000\u0000\u0000+,\u0001\u0000\u0000\u0000"+
		",.\u0001\u0000\u0000\u0000-+\u0001\u0000\u0000\u0000.0\u0005\n\u0000\u0000"+
		"/\r\u0001\u0000\u0000\u0000/\u0013\u0001\u0000\u0000\u0000/\u0018\u0001"+
		"\u0000\u0000\u0000/!\u0001\u0000\u0000\u0000/\'\u0001\u0000\u0000\u0000"+
		"0\u0003\u0001\u0000\u0000\u000012\u0006\u0002\uffff\uffff\u000029\u0005"+
		"\u000e\u0000\u000039\u0005\u000f\u0000\u000045\u0005\u0002\u0000\u0000"+
		"56\u0003\u0004\u0002\u000067\u0005\u0003\u0000\u000079\u0001\u0000\u0000"+
		"\u000081\u0001\u0000\u0000\u000083\u0001\u0000\u0000\u000084\u0001\u0000"+
		"\u0000\u00009E\u0001\u0000\u0000\u0000:;\n\u0004\u0000\u0000;<\u0005\r"+
		"\u0000\u0000<D\u0003\u0004\u0002\u0005=>\n\u0003\u0000\u0000>?\u0005\f"+
		"\u0000\u0000?D\u0003\u0004\u0002\u0004@A\n\u0002\u0000\u0000AB\u0005\u000b"+
		"\u0000\u0000BD\u0003\u0004\u0002\u0003C:\u0001\u0000\u0000\u0000C=\u0001"+
		"\u0000\u0000\u0000C@\u0001\u0000\u0000\u0000DG\u0001\u0000\u0000\u0000"+
		"EC\u0001\u0000\u0000\u0000EF\u0001\u0000\u0000\u0000F\u0005\u0001\u0000"+
		"\u0000\u0000GE\u0001\u0000\u0000\u0000\u0007\t\u001f+/8CE";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}