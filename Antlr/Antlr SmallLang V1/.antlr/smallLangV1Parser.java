// Generated from c:\Users\seand\OneDrive\Documents\University\Compiler Theory\Compiler-for-Small-Lang\src\Antlr\Antlr SmallLang V1\smallLangV1.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class smallLangV1Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, NEWLINE=36, INT=37, FLOAT=38, 
		ID=39, WS=40;
	public static final int
		RULE_prog = 0, RULE_statement = 1, RULE_variabledecl = 2, RULE_assignment = 3, 
		RULE_printStat = 4, RULE_ifStat = 5, RULE_forStat = 6, RULE_whileStat = 7, 
		RULE_returnStat = 8, RULE_funcDecl = 9, RULE_formalParams = 10, RULE_formalParam = 11, 
		RULE_block = 12, RULE_expr = 13, RULE_simpleExpr = 14, RULE_term = 15, 
		RULE_factor = 16, RULE_literal = 17, RULE_funcCall = 18, RULE_actualParams = 19, 
		RULE_actualParam = 20, RULE_subExpr = 21, RULE_unary = 22, RULE_type = 23, 
		RULE_auto = 24, RULE_relOp = 25, RULE_addOp = 26, RULE_mulOp = 27, RULE_bool = 28;
	public static final String[] ruleNames = {
		"prog", "statement", "variabledecl", "assignment", "printStat", "ifStat", 
		"forStat", "whileStat", "returnStat", "funcDecl", "formalParams", "formalParam", 
		"block", "expr", "simpleExpr", "term", "factor", "literal", "funcCall", 
		"actualParams", "actualParam", "subExpr", "unary", "type", "auto", "relOp", 
		"addOp", "mulOp", "bool"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'let'", "':'", "'='", "'print'", "'if'", "'('", "')'", "'else'", 
		"'for'", "'while'", "'return'", "'ff'", "','", "'{'", "'}'", "'-'", "'not'", 
		"'int'", "'bool'", "'float'", "'auto'", "'<'", "'>'", "'=='", "'<>'", 
		"'<='", "'>='", "'+'", "'or'", "'*'", "'/'", "'and'", "'true'", "'false'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"NEWLINE", "INT", "FLOAT", "ID", "WS"
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
	public String getGrammarFileName() { return "smallLangV1.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public smallLangV1Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(58);
				statement();
				}
				}
				setState(61); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__4) | (1L << T__5) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << ID))) != 0) );
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

	public static class StatementContext extends ParserRuleContext {
		public VariabledeclContext variabledecl() {
			return getRuleContext(VariabledeclContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(smallLangV1Parser.NEWLINE, 0); }
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public PrintStatContext printStat() {
			return getRuleContext(PrintStatContext.class,0);
		}
		public IfStatContext ifStat() {
			return getRuleContext(IfStatContext.class,0);
		}
		public ForStatContext forStat() {
			return getRuleContext(ForStatContext.class,0);
		}
		public WhileStatContext whileStat() {
			return getRuleContext(WhileStatContext.class,0);
		}
		public ReturnStatContext returnStat() {
			return getRuleContext(ReturnStatContext.class,0);
		}
		public FuncDeclContext funcDecl() {
			return getRuleContext(FuncDeclContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		int _la;
		try {
			setState(99);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				enterOuterAlt(_localctx, 1);
				{
				setState(63);
				variabledecl();
				setState(64);
				match(T__0);
				setState(66);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NEWLINE) {
					{
					setState(65);
					match(NEWLINE);
					}
				}

				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(68);
				assignment();
				setState(69);
				match(T__0);
				setState(71);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NEWLINE) {
					{
					setState(70);
					match(NEWLINE);
					}
				}

				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 3);
				{
				setState(73);
				printStat();
				setState(74);
				match(T__0);
				setState(76);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NEWLINE) {
					{
					setState(75);
					match(NEWLINE);
					}
				}

				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 4);
				{
				setState(78);
				ifStat();
				setState(80);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NEWLINE) {
					{
					setState(79);
					match(NEWLINE);
					}
				}

				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 5);
				{
				setState(82);
				forStat();
				setState(84);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NEWLINE) {
					{
					setState(83);
					match(NEWLINE);
					}
				}

				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 6);
				{
				setState(86);
				whileStat();
				setState(88);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NEWLINE) {
					{
					setState(87);
					match(NEWLINE);
					}
				}

				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 7);
				{
				setState(90);
				returnStat();
				setState(91);
				match(T__0);
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NEWLINE) {
					{
					setState(92);
					match(NEWLINE);
					}
				}

				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 8);
				{
				setState(95);
				funcDecl();
				setState(97);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NEWLINE) {
					{
					setState(96);
					match(NEWLINE);
					}
				}

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

	public static class VariabledeclContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(smallLangV1Parser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public AutoContext auto() {
			return getRuleContext(AutoContext.class,0);
		}
		public VariabledeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variabledecl; }
	}

	public final VariabledeclContext variabledecl() throws RecognitionException {
		VariabledeclContext _localctx = new VariabledeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_variabledecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			match(T__1);
			setState(102);
			match(ID);
			setState(103);
			match(T__2);
			setState(106);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__18:
			case T__19:
			case T__20:
				{
				setState(104);
				type();
				}
				break;
			case T__21:
				{
				setState(105);
				auto();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(108);
			match(T__3);
			setState(109);
			expr();
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

	public static class AssignmentContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(smallLangV1Parser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(ID);
			setState(112);
			match(T__3);
			setState(113);
			expr();
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

	public static class PrintStatContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public PrintStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printStat; }
	}

	public final PrintStatContext printStat() throws RecognitionException {
		PrintStatContext _localctx = new PrintStatContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_printStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			match(T__4);
			setState(116);
			expr();
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

	public static class IfStatContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public IfStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStat; }
	}

	public final IfStatContext ifStat() throws RecognitionException {
		IfStatContext _localctx = new IfStatContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_ifStat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			match(T__5);
			setState(119);
			match(T__6);
			setState(120);
			expr();
			setState(121);
			match(T__7);
			setState(122);
			block();
			setState(125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(123);
				match(T__8);
				setState(124);
				block();
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

	public static class ForStatContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public VariabledeclContext variabledecl() {
			return getRuleContext(VariabledeclContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public ForStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStat; }
	}

	public final ForStatContext forStat() throws RecognitionException {
		ForStatContext _localctx = new ForStatContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_forStat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			match(T__9);
			setState(128);
			match(T__6);
			setState(130);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(129);
				variabledecl();
				}
			}

			setState(132);
			match(T__0);
			setState(133);
			expr();
			setState(134);
			match(T__0);
			setState(136);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(135);
				assignment();
				}
			}

			setState(138);
			match(T__7);
			setState(139);
			block();
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

	public static class WhileStatContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public WhileStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStat; }
	}

	public final WhileStatContext whileStat() throws RecognitionException {
		WhileStatContext _localctx = new WhileStatContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_whileStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			match(T__10);
			setState(142);
			match(T__6);
			setState(143);
			expr();
			setState(144);
			match(T__7);
			setState(145);
			block();
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

	public static class ReturnStatContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ReturnStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStat; }
	}

	public final ReturnStatContext returnStat() throws RecognitionException {
		ReturnStatContext _localctx = new ReturnStatContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_returnStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			match(T__11);
			setState(148);
			expr();
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

	public static class FuncDeclContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(smallLangV1Parser.ID, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public AutoContext auto() {
			return getRuleContext(AutoContext.class,0);
		}
		public FormalParamsContext formalParams() {
			return getRuleContext(FormalParamsContext.class,0);
		}
		public FuncDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcDecl; }
	}

	public final FuncDeclContext funcDecl() throws RecognitionException {
		FuncDeclContext _localctx = new FuncDeclContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_funcDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			match(T__12);
			setState(151);
			match(ID);
			setState(152);
			match(T__6);
			setState(154);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(153);
				formalParams();
				}
			}

			setState(156);
			match(T__7);
			setState(157);
			match(T__2);
			setState(160);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__18:
			case T__19:
			case T__20:
				{
				setState(158);
				type();
				}
				break;
			case T__21:
				{
				setState(159);
				auto();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(162);
			block();
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

	public static class FormalParamsContext extends ParserRuleContext {
		public List<FormalParamContext> formalParam() {
			return getRuleContexts(FormalParamContext.class);
		}
		public FormalParamContext formalParam(int i) {
			return getRuleContext(FormalParamContext.class,i);
		}
		public FormalParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParams; }
	}

	public final FormalParamsContext formalParams() throws RecognitionException {
		FormalParamsContext _localctx = new FormalParamsContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_formalParams);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(164);
				formalParam();
				}
				}
				setState(167); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
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

	public static class FormalParamContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(smallLangV1Parser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public FormalParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParam; }
	}

	public final FormalParamContext formalParam() throws RecognitionException {
		FormalParamContext _localctx = new FormalParamContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_formalParam);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			match(ID);
			setState(170);
			match(T__2);
			setState(171);
			type();
			setState(173);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__13) {
				{
				setState(172);
				match(T__13);
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

	public static class BlockContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			match(T__14);
			setState(181);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__4) | (1L << T__5) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << ID))) != 0)) {
				{
				setState(177); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(176);
					statement();
					}
					}
					setState(179); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__4) | (1L << T__5) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << ID))) != 0) );
				}
			}

			setState(183);
			match(T__15);
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

	public static class ExprContext extends ParserRuleContext {
		public List<SimpleExprContext> simpleExpr() {
			return getRuleContexts(SimpleExprContext.class);
		}
		public SimpleExprContext simpleExpr(int i) {
			return getRuleContext(SimpleExprContext.class,i);
		}
		public RelOpContext relOp() {
			return getRuleContext(RelOpContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			simpleExpr();
			setState(189);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(186);
				relOp();
				setState(187);
				simpleExpr();
				}
				break;
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

	public static class SimpleExprContext extends ParserRuleContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public AddOpContext addOp() {
			return getRuleContext(AddOpContext.class,0);
		}
		public SimpleExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleExpr; }
	}

	public final SimpleExprContext simpleExpr() throws RecognitionException {
		SimpleExprContext _localctx = new SimpleExprContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_simpleExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			term();
			setState(195);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				{
				setState(192);
				addOp();
				setState(193);
				term();
				}
				break;
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

	public static class TermContext extends ParserRuleContext {
		public List<FactorContext> factor() {
			return getRuleContexts(FactorContext.class);
		}
		public FactorContext factor(int i) {
			return getRuleContext(FactorContext.class,i);
		}
		public MulOpContext mulOp() {
			return getRuleContext(MulOpContext.class,0);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_term);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			factor();
			setState(201);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				{
				setState(198);
				mulOp();
				setState(199);
				factor();
				}
				break;
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

	public static class FactorContext extends ParserRuleContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public TerminalNode ID() { return getToken(smallLangV1Parser.ID, 0); }
		public FuncCallContext funcCall() {
			return getRuleContext(FuncCallContext.class,0);
		}
		public SubExprContext subExpr() {
			return getRuleContext(SubExprContext.class,0);
		}
		public UnaryContext unary() {
			return getRuleContext(UnaryContext.class,0);
		}
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_factor);
		try {
			setState(208);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(203);
				literal();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(204);
				match(ID);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(205);
				funcCall();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(206);
				subExpr();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(207);
				unary();
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

	public static class LiteralContext extends ParserRuleContext {
		public BoolContext bool() {
			return getRuleContext(BoolContext.class,0);
		}
		public TerminalNode INT() { return getToken(smallLangV1Parser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(smallLangV1Parser.FLOAT, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_literal);
		try {
			setState(213);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__33:
			case T__34:
				enterOuterAlt(_localctx, 1);
				{
				setState(210);
				bool();
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(211);
				match(INT);
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 3);
				{
				setState(212);
				match(FLOAT);
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

	public static class FuncCallContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(smallLangV1Parser.ID, 0); }
		public ActualParamsContext actualParams() {
			return getRuleContext(ActualParamsContext.class,0);
		}
		public FuncCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcCall; }
	}

	public final FuncCallContext funcCall() throws RecognitionException {
		FuncCallContext _localctx = new FuncCallContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_funcCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			match(ID);
			setState(216);
			match(T__6);
			setState(218);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__16) | (1L << T__17) | (1L << T__33) | (1L << T__34) | (1L << INT) | (1L << FLOAT) | (1L << ID))) != 0)) {
				{
				setState(217);
				actualParams();
				}
			}

			setState(220);
			match(T__7);
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

	public static class ActualParamsContext extends ParserRuleContext {
		public List<ActualParamContext> actualParam() {
			return getRuleContexts(ActualParamContext.class);
		}
		public ActualParamContext actualParam(int i) {
			return getRuleContext(ActualParamContext.class,i);
		}
		public ActualParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_actualParams; }
	}

	public final ActualParamsContext actualParams() throws RecognitionException {
		ActualParamsContext _localctx = new ActualParamsContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_actualParams);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(222);
				actualParam();
				}
				}
				setState(225); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__16) | (1L << T__17) | (1L << T__33) | (1L << T__34) | (1L << INT) | (1L << FLOAT) | (1L << ID))) != 0) );
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

	public static class ActualParamContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ActualParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_actualParam; }
	}

	public final ActualParamContext actualParam() throws RecognitionException {
		ActualParamContext _localctx = new ActualParamContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_actualParam);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
			expr();
			setState(229);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__13) {
				{
				setState(228);
				match(T__13);
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

	public static class SubExprContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public SubExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subExpr; }
	}

	public final SubExprContext subExpr() throws RecognitionException {
		SubExprContext _localctx = new SubExprContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_subExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			match(T__6);
			setState(232);
			expr();
			setState(233);
			match(T__7);
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

	public static class UnaryContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public UnaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary; }
	}

	public final UnaryContext unary() throws RecognitionException {
		UnaryContext _localctx = new UnaryContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_unary);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(235);
			_la = _input.LA(1);
			if ( !(_la==T__16 || _la==T__17) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(236);
			expr();
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
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(238);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__18) | (1L << T__19) | (1L << T__20))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
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

	public static class AutoContext extends ParserRuleContext {
		public AutoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_auto; }
	}

	public final AutoContext auto() throws RecognitionException {
		AutoContext _localctx = new AutoContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_auto);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(240);
			match(T__21);
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

	public static class RelOpContext extends ParserRuleContext {
		public RelOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relOp; }
	}

	public final RelOpContext relOp() throws RecognitionException {
		RelOpContext _localctx = new RelOpContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_relOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(242);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
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

	public static class AddOpContext extends ParserRuleContext {
		public AddOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addOp; }
	}

	public final AddOpContext addOp() throws RecognitionException {
		AddOpContext _localctx = new AddOpContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_addOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__16) | (1L << T__28) | (1L << T__29))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
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

	public static class MulOpContext extends ParserRuleContext {
		public MulOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mulOp; }
	}

	public final MulOpContext mulOp() throws RecognitionException {
		MulOpContext _localctx = new MulOpContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_mulOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(246);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__30) | (1L << T__31) | (1L << T__32))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
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

	public static class BoolContext extends ParserRuleContext {
		public BoolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool; }
	}

	public final BoolContext bool() throws RecognitionException {
		BoolContext _localctx = new BoolContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_bool);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(248);
			_la = _input.LA(1);
			if ( !(_la==T__33 || _la==T__34) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3*\u00fd\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\3\2\6\2>\n\2\r\2\16"+
		"\2?\3\3\3\3\3\3\5\3E\n\3\3\3\3\3\3\3\5\3J\n\3\3\3\3\3\3\3\5\3O\n\3\3\3"+
		"\3\3\5\3S\n\3\3\3\3\3\5\3W\n\3\3\3\3\3\5\3[\n\3\3\3\3\3\3\3\5\3`\n\3\3"+
		"\3\3\3\5\3d\n\3\5\3f\n\3\3\4\3\4\3\4\3\4\3\4\5\4m\n\4\3\4\3\4\3\4\3\5"+
		"\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u0080\n\7\3\b"+
		"\3\b\3\b\5\b\u0085\n\b\3\b\3\b\3\b\3\b\5\b\u008b\n\b\3\b\3\b\3\b\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\13\5\13\u009d\n\13\3\13"+
		"\3\13\3\13\3\13\5\13\u00a3\n\13\3\13\3\13\3\f\6\f\u00a8\n\f\r\f\16\f\u00a9"+
		"\3\r\3\r\3\r\3\r\5\r\u00b0\n\r\3\16\3\16\6\16\u00b4\n\16\r\16\16\16\u00b5"+
		"\5\16\u00b8\n\16\3\16\3\16\3\17\3\17\3\17\3\17\5\17\u00c0\n\17\3\20\3"+
		"\20\3\20\3\20\5\20\u00c6\n\20\3\21\3\21\3\21\3\21\5\21\u00cc\n\21\3\22"+
		"\3\22\3\22\3\22\3\22\5\22\u00d3\n\22\3\23\3\23\3\23\5\23\u00d8\n\23\3"+
		"\24\3\24\3\24\5\24\u00dd\n\24\3\24\3\24\3\25\6\25\u00e2\n\25\r\25\16\25"+
		"\u00e3\3\26\3\26\5\26\u00e8\n\26\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3"+
		"\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\36\2\2\37"+
		"\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:\2\b\3\2"+
		"\23\24\3\2\25\27\3\2\31\36\4\2\23\23\37 \3\2!#\3\2$%\2\u0105\2=\3\2\2"+
		"\2\4e\3\2\2\2\6g\3\2\2\2\bq\3\2\2\2\nu\3\2\2\2\fx\3\2\2\2\16\u0081\3\2"+
		"\2\2\20\u008f\3\2\2\2\22\u0095\3\2\2\2\24\u0098\3\2\2\2\26\u00a7\3\2\2"+
		"\2\30\u00ab\3\2\2\2\32\u00b1\3\2\2\2\34\u00bb\3\2\2\2\36\u00c1\3\2\2\2"+
		" \u00c7\3\2\2\2\"\u00d2\3\2\2\2$\u00d7\3\2\2\2&\u00d9\3\2\2\2(\u00e1\3"+
		"\2\2\2*\u00e5\3\2\2\2,\u00e9\3\2\2\2.\u00ed\3\2\2\2\60\u00f0\3\2\2\2\62"+
		"\u00f2\3\2\2\2\64\u00f4\3\2\2\2\66\u00f6\3\2\2\28\u00f8\3\2\2\2:\u00fa"+
		"\3\2\2\2<>\5\4\3\2=<\3\2\2\2>?\3\2\2\2?=\3\2\2\2?@\3\2\2\2@\3\3\2\2\2"+
		"AB\5\6\4\2BD\7\3\2\2CE\7&\2\2DC\3\2\2\2DE\3\2\2\2Ef\3\2\2\2FG\5\b\5\2"+
		"GI\7\3\2\2HJ\7&\2\2IH\3\2\2\2IJ\3\2\2\2Jf\3\2\2\2KL\5\n\6\2LN\7\3\2\2"+
		"MO\7&\2\2NM\3\2\2\2NO\3\2\2\2Of\3\2\2\2PR\5\f\7\2QS\7&\2\2RQ\3\2\2\2R"+
		"S\3\2\2\2Sf\3\2\2\2TV\5\16\b\2UW\7&\2\2VU\3\2\2\2VW\3\2\2\2Wf\3\2\2\2"+
		"XZ\5\20\t\2Y[\7&\2\2ZY\3\2\2\2Z[\3\2\2\2[f\3\2\2\2\\]\5\22\n\2]_\7\3\2"+
		"\2^`\7&\2\2_^\3\2\2\2_`\3\2\2\2`f\3\2\2\2ac\5\24\13\2bd\7&\2\2cb\3\2\2"+
		"\2cd\3\2\2\2df\3\2\2\2eA\3\2\2\2eF\3\2\2\2eK\3\2\2\2eP\3\2\2\2eT\3\2\2"+
		"\2eX\3\2\2\2e\\\3\2\2\2ea\3\2\2\2f\5\3\2\2\2gh\7\4\2\2hi\7)\2\2il\7\5"+
		"\2\2jm\5\60\31\2km\5\62\32\2lj\3\2\2\2lk\3\2\2\2mn\3\2\2\2no\7\6\2\2o"+
		"p\5\34\17\2p\7\3\2\2\2qr\7)\2\2rs\7\6\2\2st\5\34\17\2t\t\3\2\2\2uv\7\7"+
		"\2\2vw\5\34\17\2w\13\3\2\2\2xy\7\b\2\2yz\7\t\2\2z{\5\34\17\2{|\7\n\2\2"+
		"|\177\5\32\16\2}~\7\13\2\2~\u0080\5\32\16\2\177}\3\2\2\2\177\u0080\3\2"+
		"\2\2\u0080\r\3\2\2\2\u0081\u0082\7\f\2\2\u0082\u0084\7\t\2\2\u0083\u0085"+
		"\5\6\4\2\u0084\u0083\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0086\3\2\2\2\u0086"+
		"\u0087\7\3\2\2\u0087\u0088\5\34\17\2\u0088\u008a\7\3\2\2\u0089\u008b\5"+
		"\b\5\2\u008a\u0089\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u008c\3\2\2\2\u008c"+
		"\u008d\7\n\2\2\u008d\u008e\5\32\16\2\u008e\17\3\2\2\2\u008f\u0090\7\r"+
		"\2\2\u0090\u0091\7\t\2\2\u0091\u0092\5\34\17\2\u0092\u0093\7\n\2\2\u0093"+
		"\u0094\5\32\16\2\u0094\21\3\2\2\2\u0095\u0096\7\16\2\2\u0096\u0097\5\34"+
		"\17\2\u0097\23\3\2\2\2\u0098\u0099\7\17\2\2\u0099\u009a\7)\2\2\u009a\u009c"+
		"\7\t\2\2\u009b\u009d\5\26\f\2\u009c\u009b\3\2\2\2\u009c\u009d\3\2\2\2"+
		"\u009d\u009e\3\2\2\2\u009e\u009f\7\n\2\2\u009f\u00a2\7\5\2\2\u00a0\u00a3"+
		"\5\60\31\2\u00a1\u00a3\5\62\32\2\u00a2\u00a0\3\2\2\2\u00a2\u00a1\3\2\2"+
		"\2\u00a3\u00a4\3\2\2\2\u00a4\u00a5\5\32\16\2\u00a5\25\3\2\2\2\u00a6\u00a8"+
		"\5\30\r\2\u00a7\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00a7\3\2\2\2"+
		"\u00a9\u00aa\3\2\2\2\u00aa\27\3\2\2\2\u00ab\u00ac\7)\2\2\u00ac\u00ad\7"+
		"\5\2\2\u00ad\u00af\5\60\31\2\u00ae\u00b0\7\20\2\2\u00af\u00ae\3\2\2\2"+
		"\u00af\u00b0\3\2\2\2\u00b0\31\3\2\2\2\u00b1\u00b7\7\21\2\2\u00b2\u00b4"+
		"\5\4\3\2\u00b3\u00b2\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b5"+
		"\u00b6\3\2\2\2\u00b6\u00b8\3\2\2\2\u00b7\u00b3\3\2\2\2\u00b7\u00b8\3\2"+
		"\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00ba\7\22\2\2\u00ba\33\3\2\2\2\u00bb\u00bf"+
		"\5\36\20\2\u00bc\u00bd\5\64\33\2\u00bd\u00be\5\36\20\2\u00be\u00c0\3\2"+
		"\2\2\u00bf\u00bc\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\35\3\2\2\2\u00c1\u00c5"+
		"\5 \21\2\u00c2\u00c3\5\66\34\2\u00c3\u00c4\5 \21\2\u00c4\u00c6\3\2\2\2"+
		"\u00c5\u00c2\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\37\3\2\2\2\u00c7\u00cb"+
		"\5\"\22\2\u00c8\u00c9\58\35\2\u00c9\u00ca\5\"\22\2\u00ca\u00cc\3\2\2\2"+
		"\u00cb\u00c8\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc!\3\2\2\2\u00cd\u00d3\5"+
		"$\23\2\u00ce\u00d3\7)\2\2\u00cf\u00d3\5&\24\2\u00d0\u00d3\5,\27\2\u00d1"+
		"\u00d3\5.\30\2\u00d2\u00cd\3\2\2\2\u00d2\u00ce\3\2\2\2\u00d2\u00cf\3\2"+
		"\2\2\u00d2\u00d0\3\2\2\2\u00d2\u00d1\3\2\2\2\u00d3#\3\2\2\2\u00d4\u00d8"+
		"\5:\36\2\u00d5\u00d8\7\'\2\2\u00d6\u00d8\7(\2\2\u00d7\u00d4\3\2\2\2\u00d7"+
		"\u00d5\3\2\2\2\u00d7\u00d6\3\2\2\2\u00d8%\3\2\2\2\u00d9\u00da\7)\2\2\u00da"+
		"\u00dc\7\t\2\2\u00db\u00dd\5(\25\2\u00dc\u00db\3\2\2\2\u00dc\u00dd\3\2"+
		"\2\2\u00dd\u00de\3\2\2\2\u00de\u00df\7\n\2\2\u00df\'\3\2\2\2\u00e0\u00e2"+
		"\5*\26\2\u00e1\u00e0\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e3"+
		"\u00e4\3\2\2\2\u00e4)\3\2\2\2\u00e5\u00e7\5\34\17\2\u00e6\u00e8\7\20\2"+
		"\2\u00e7\u00e6\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8+\3\2\2\2\u00e9\u00ea"+
		"\7\t\2\2\u00ea\u00eb\5\34\17\2\u00eb\u00ec\7\n\2\2\u00ec-\3\2\2\2\u00ed"+
		"\u00ee\t\2\2\2\u00ee\u00ef\5\34\17\2\u00ef/\3\2\2\2\u00f0\u00f1\t\3\2"+
		"\2\u00f1\61\3\2\2\2\u00f2\u00f3\7\30\2\2\u00f3\63\3\2\2\2\u00f4\u00f5"+
		"\t\4\2\2\u00f5\65\3\2\2\2\u00f6\u00f7\t\5\2\2\u00f7\67\3\2\2\2\u00f8\u00f9"+
		"\t\6\2\2\u00f99\3\2\2\2\u00fa\u00fb\t\7\2\2\u00fb;\3\2\2\2\36?DINRVZ_"+
		"cel\177\u0084\u008a\u009c\u00a2\u00a9\u00af\u00b5\u00b7\u00bf\u00c5\u00cb"+
		"\u00d2\u00d7\u00dc\u00e3\u00e7";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}