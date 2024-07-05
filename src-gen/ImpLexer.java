// Generated from java-escape by ANTLR 4.11.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class ImpLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, OP=12, NUM=13, VAR=14, ESPACOS=15;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "OP", "NUM", "VAR", "ESPACOS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'print'", "'('", "')'", "';'", "'='", "'{'", "'}'", "'if'", "'else'", 
			"'while'", "'int'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"OP", "NUM", "VAR", "ESPACOS"
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


	public ImpLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Imp.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u000fS\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0004\fG\b\f\u000b\f\f\fH\u0001"+
		"\r\u0004\rL\b\r\u000b\r\f\rM\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0000\u0000\u000f\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004"+
		"\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017"+
		"\f\u0019\r\u001b\u000e\u001d\u000f\u0001\u0000\u0004\u0004\u0000*+--/"+
		"/>>\u0001\u000009\u0001\u0000az\u0002\u0000\n\n  T\u0000\u0001\u0001\u0000"+
		"\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000"+
		"\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000"+
		"\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000"+
		"\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000"+
		"\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000"+
		"\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000"+
		"\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000"+
		"\u0001\u001f\u0001\u0000\u0000\u0000\u0003%\u0001\u0000\u0000\u0000\u0005"+
		"\'\u0001\u0000\u0000\u0000\u0007)\u0001\u0000\u0000\u0000\t+\u0001\u0000"+
		"\u0000\u0000\u000b-\u0001\u0000\u0000\u0000\r/\u0001\u0000\u0000\u0000"+
		"\u000f1\u0001\u0000\u0000\u0000\u00114\u0001\u0000\u0000\u0000\u00139"+
		"\u0001\u0000\u0000\u0000\u0015?\u0001\u0000\u0000\u0000\u0017C\u0001\u0000"+
		"\u0000\u0000\u0019F\u0001\u0000\u0000\u0000\u001bK\u0001\u0000\u0000\u0000"+
		"\u001dO\u0001\u0000\u0000\u0000\u001f \u0005p\u0000\u0000 !\u0005r\u0000"+
		"\u0000!\"\u0005i\u0000\u0000\"#\u0005n\u0000\u0000#$\u0005t\u0000\u0000"+
		"$\u0002\u0001\u0000\u0000\u0000%&\u0005(\u0000\u0000&\u0004\u0001\u0000"+
		"\u0000\u0000\'(\u0005)\u0000\u0000(\u0006\u0001\u0000\u0000\u0000)*\u0005"+
		";\u0000\u0000*\b\u0001\u0000\u0000\u0000+,\u0005=\u0000\u0000,\n\u0001"+
		"\u0000\u0000\u0000-.\u0005{\u0000\u0000.\f\u0001\u0000\u0000\u0000/0\u0005"+
		"}\u0000\u00000\u000e\u0001\u0000\u0000\u000012\u0005i\u0000\u000023\u0005"+
		"f\u0000\u00003\u0010\u0001\u0000\u0000\u000045\u0005e\u0000\u000056\u0005"+
		"l\u0000\u000067\u0005s\u0000\u000078\u0005e\u0000\u00008\u0012\u0001\u0000"+
		"\u0000\u00009:\u0005w\u0000\u0000:;\u0005h\u0000\u0000;<\u0005i\u0000"+
		"\u0000<=\u0005l\u0000\u0000=>\u0005e\u0000\u0000>\u0014\u0001\u0000\u0000"+
		"\u0000?@\u0005i\u0000\u0000@A\u0005n\u0000\u0000AB\u0005t\u0000\u0000"+
		"B\u0016\u0001\u0000\u0000\u0000CD\u0007\u0000\u0000\u0000D\u0018\u0001"+
		"\u0000\u0000\u0000EG\u0007\u0001\u0000\u0000FE\u0001\u0000\u0000\u0000"+
		"GH\u0001\u0000\u0000\u0000HF\u0001\u0000\u0000\u0000HI\u0001\u0000\u0000"+
		"\u0000I\u001a\u0001\u0000\u0000\u0000JL\u0007\u0002\u0000\u0000KJ\u0001"+
		"\u0000\u0000\u0000LM\u0001\u0000\u0000\u0000MK\u0001\u0000\u0000\u0000"+
		"MN\u0001\u0000\u0000\u0000N\u001c\u0001\u0000\u0000\u0000OP\u0007\u0003"+
		"\u0000\u0000PQ\u0001\u0000\u0000\u0000QR\u0006\u000e\u0000\u0000R\u001e"+
		"\u0001\u0000\u0000\u0000\u0003\u0000HM\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}