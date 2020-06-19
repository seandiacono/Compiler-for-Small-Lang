package Antlr.AntlrSmallLangV2;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({ "all", "warnings", "unchecked", "unused", "cast" })
public class smallLangV2Parser extends Parser {
	static {
		RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION);
	}

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache = new PredictionContextCache();
	public static final int T__0 = 1, T__1 = 2, T__2 = 3, T__3 = 4, T__4 = 5, T__5 = 6, T__6 = 7, T__7 = 8, T__8 = 9,
			T__9 = 10, T__10 = 11, T__11 = 12, T__12 = 13, T__13 = 14, T__14 = 15, T__15 = 16, T__16 = 17, T__17 = 18,
			T__18 = 19, T__19 = 20, T__20 = 21, T__21 = 22, T__22 = 23, T__23 = 24, T__24 = 25, T__25 = 26, T__26 = 27,
			T__27 = 28, T__28 = 29, T__29 = 30, T__30 = 31, T__31 = 32, T__32 = 33, T__33 = 34, T__34 = 35, T__35 = 36,
			T__36 = 37, T__37 = 38, T__38 = 39, NEWLINE = 40, INT = 41, FLOAT = 42, ID = 43, CHAR = 44, WS = 45;
	public static final int RULE_prog = 0, RULE_statement = 1, RULE_variabledecl = 2, RULE_assignment = 3,
			RULE_printStat = 4, RULE_ifStat = 5, RULE_forStat = 6, RULE_whileStat = 7, RULE_returnStat = 8,
			RULE_funcDecl = 9, RULE_formalParams = 10, RULE_formalParam = 11, RULE_block = 12, RULE_expr = 13,
			RULE_simpleExpr = 14, RULE_term = 15, RULE_factor = 16, RULE_literal = 17, RULE_funcCall = 18,
			RULE_actualParams = 19, RULE_actualParam = 20, RULE_array = 21, RULE_subExpr = 22, RULE_unary = 23,
			RULE_identifier = 24, RULE_arrSize = 25, RULE_type = 26, RULE_auto = 27, RULE_relOp = 28, RULE_addOp = 29,
			RULE_mulOp = 30, RULE_bool = 31;

	private static String[] makeRuleNames() {
		return new String[] { "prog", "statement", "variabledecl", "assignment", "printStat", "ifStat", "forStat",
				"whileStat", "returnStat", "funcDecl", "formalParams", "formalParam", "block", "expr", "simpleExpr",
				"term", "factor", "literal", "funcCall", "actualParams", "actualParam", "array", "subExpr", "unary",
				"identifier", "arrSize", "type", "auto", "relOp", "addOp", "mulOp", "bool" };
	}

	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] { null, "';'", "'let'", "':'", "'='", "'print'", "'if'", "'('", "')'", "'else'", "'for'",
				"'while'", "'return'", "'ff'", "','", "'{'", "'}'", "'''", "'-'", "'not'", "'['", "']'", "'int'",
				"'bool'", "'float'", "'char'", "'auto'", "'<'", "'>'", "'=='", "'<>'", "'<='", "'>='", "'+'", "'or'",
				"'*'", "'/'", "'and'", "'true'", "'false'" };
	}

	private static final String[] _LITERAL_NAMES = makeLiteralNames();

	private static String[] makeSymbolicNames() {
		return new String[] { null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
				null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
				null, null, null, null, null, null, null, null, "NEWLINE", "INT", "FLOAT", "ID", "CHAR", "WS" };
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
	public String getGrammarFileName() {
		return "smallLangV2.g4";
	}

	@Override
	public String[] getRuleNames() {
		return ruleNames;
	}

	@Override
	public String getSerializedATN() {
		return _serializedATN;
	}

	@Override
	public ATN getATN() {
		return _ATN;
	}

	public smallLangV2Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
	}

	public static class ProgContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}

		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class, i);
		}

		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_prog;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof smallLangV2Listener)
				((smallLangV2Listener) listener).enterProg(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof smallLangV2Listener)
				((smallLangV2Listener) listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(65);
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
						{
							setState(64);
							statement();
						}
					}
					setState(67);
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__4) | (1L << T__5)
						| (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << ID))) != 0));
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public VariabledeclContext variabledecl() {
			return getRuleContext(VariabledeclContext.class, 0);
		}

		public TerminalNode NEWLINE() {
			return getToken(smallLangV2Parser.NEWLINE, 0);
		}

		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class, 0);
		}

		public PrintStatContext printStat() {
			return getRuleContext(PrintStatContext.class, 0);
		}

		public IfStatContext ifStat() {
			return getRuleContext(IfStatContext.class, 0);
		}

		public ForStatContext forStat() {
			return getRuleContext(ForStatContext.class, 0);
		}

		public WhileStatContext whileStat() {
			return getRuleContext(WhileStatContext.class, 0);
		}

		public ReturnStatContext returnStat() {
			return getRuleContext(ReturnStatContext.class, 0);
		}

		public FuncDeclContext funcDecl() {
			return getRuleContext(FuncDeclContext.class, 0);
		}

		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_statement;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof smallLangV2Listener)
				((smallLangV2Listener) listener).enterStatement(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof smallLangV2Listener)
				((smallLangV2Listener) listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		int _la;
		try {
			setState(105);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
				case T__1:
					enterOuterAlt(_localctx, 1); {
					setState(69);
					variabledecl();
					setState(70);
					match(T__0);
					setState(72);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la == NEWLINE) {
						{
							setState(71);
							match(NEWLINE);
						}
					}

				}
					break;
				case ID:
					enterOuterAlt(_localctx, 2); {
					setState(74);
					assignment();
					setState(75);
					match(T__0);
					setState(77);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la == NEWLINE) {
						{
							setState(76);
							match(NEWLINE);
						}
					}

				}
					break;
				case T__4:
					enterOuterAlt(_localctx, 3); {
					setState(79);
					printStat();
					setState(80);
					match(T__0);
					setState(82);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la == NEWLINE) {
						{
							setState(81);
							match(NEWLINE);
						}
					}

				}
					break;
				case T__5:
					enterOuterAlt(_localctx, 4); {
					setState(84);
					ifStat();
					setState(86);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la == NEWLINE) {
						{
							setState(85);
							match(NEWLINE);
						}
					}

				}
					break;
				case T__9:
					enterOuterAlt(_localctx, 5); {
					setState(88);
					forStat();
					setState(90);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la == NEWLINE) {
						{
							setState(89);
							match(NEWLINE);
						}
					}

				}
					break;
				case T__10:
					enterOuterAlt(_localctx, 6); {
					setState(92);
					whileStat();
					setState(94);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la == NEWLINE) {
						{
							setState(93);
							match(NEWLINE);
						}
					}

				}
					break;
				case T__11:
					enterOuterAlt(_localctx, 7); {
					setState(96);
					returnStat();
					setState(97);
					match(T__0);
					setState(99);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la == NEWLINE) {
						{
							setState(98);
							match(NEWLINE);
						}
					}

				}
					break;
				case T__12:
					enterOuterAlt(_localctx, 8); {
					setState(101);
					funcDecl();
					setState(103);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la == NEWLINE) {
						{
							setState(102);
							match(NEWLINE);
						}
					}

				}
					break;
				default:
					throw new NoViableAltException(this);
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariabledeclContext extends ParserRuleContext {
		public TerminalNode ID() {
			return getToken(smallLangV2Parser.ID, 0);
		}

		public ExprContext expr() {
			return getRuleContext(ExprContext.class, 0);
		}

		public TypeContext type() {
			return getRuleContext(TypeContext.class, 0);
		}

		public AutoContext auto() {
			return getRuleContext(AutoContext.class, 0);
		}

		public ArrSizeContext arrSize() {
			return getRuleContext(ArrSizeContext.class, 0);
		}

		public VariabledeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_variabledecl;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof smallLangV2Listener)
				((smallLangV2Listener) listener).enterVariabledecl(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof smallLangV2Listener)
				((smallLangV2Listener) listener).exitVariabledecl(this);
		}
	}

	public final VariabledeclContext variabledecl() throws RecognitionException {
		VariabledeclContext _localctx = new VariabledeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_variabledecl);
		int _la;
		try {
			setState(129);
			_errHandler.sync(this);
			switch (getInterpreter().adaptivePredict(_input, 13, _ctx)) {
				case 1:
					enterOuterAlt(_localctx, 1); {
					setState(107);
					match(T__1);
					setState(108);
					match(ID);
					setState(109);
					match(T__2);
					setState(112);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
						case T__21:
						case T__22:
						case T__23:
						case T__24: {
							setState(110);
							type();
						}
							break;
						case T__25: {
							setState(111);
							auto();
						}
							break;
						default:
							throw new NoViableAltException(this);
					}
					setState(114);
					match(T__3);
					setState(115);
					expr();
				}
					break;
				case 2:
					enterOuterAlt(_localctx, 2); {
					setState(117);
					match(T__1);
					setState(118);
					match(ID);
					setState(119);
					arrSize();
					setState(120);
					match(T__2);
					setState(123);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
						case T__21:
						case T__22:
						case T__23:
						case T__24: {
							setState(121);
							type();
						}
							break;
						case T__25: {
							setState(122);
							auto();
						}
							break;
						default:
							throw new NoViableAltException(this);
					}
					setState(127);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la == T__3) {
						{
							setState(125);
							match(T__3);
							setState(126);
							expr();
						}
					}

				}
					break;
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignmentContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class, 0);
		}

		public ExprContext expr() {
			return getRuleContext(ExprContext.class, 0);
		}

		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_assignment;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof smallLangV2Listener)
				((smallLangV2Listener) listener).enterAssignment(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof smallLangV2Listener)
				((smallLangV2Listener) listener).exitAssignment(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(131);
				identifier();
				setState(132);
				match(T__3);
				setState(133);
				expr();
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrintStatContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class, 0);
		}

		public PrintStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_printStat;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof smallLangV2Listener)
				((smallLangV2Listener) listener).enterPrintStat(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof smallLangV2Listener)
				((smallLangV2Listener) listener).exitPrintStat(this);
		}
	}

	public final PrintStatContext printStat() throws RecognitionException {
		PrintStatContext _localctx = new PrintStatContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_printStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(135);
				match(T__4);
				setState(136);
				expr();
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfStatContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class, 0);
		}

		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}

		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class, i);
		}

		public IfStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_ifStat;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof smallLangV2Listener)
				((smallLangV2Listener) listener).enterIfStat(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof smallLangV2Listener)
				((smallLangV2Listener) listener).exitIfStat(this);
		}
	}

	public final IfStatContext ifStat() throws RecognitionException {
		IfStatContext _localctx = new IfStatContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_ifStat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(138);
				match(T__5);
				setState(139);
				match(T__6);
				setState(140);
				expr();
				setState(141);
				match(T__7);
				setState(142);
				block();
				setState(145);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la == T__8) {
					{
						setState(143);
						match(T__8);
						setState(144);
						block();
					}
				}

			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForStatContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class, 0);
		}

		public BlockContext block() {
			return getRuleContext(BlockContext.class, 0);
		}

		public VariabledeclContext variabledecl() {
			return getRuleContext(VariabledeclContext.class, 0);
		}

		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class, 0);
		}

		public ForStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_forStat;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof smallLangV2Listener)
				((smallLangV2Listener) listener).enterForStat(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof smallLangV2Listener)
				((smallLangV2Listener) listener).exitForStat(this);
		}
	}

	public final ForStatContext forStat() throws RecognitionException {
		ForStatContext _localctx = new ForStatContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_forStat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(147);
				match(T__9);
				setState(148);
				match(T__6);
				setState(150);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la == T__1) {
					{
						setState(149);
						variabledecl();
					}
				}

				setState(152);
				match(T__0);
				setState(153);
				expr();
				setState(154);
				match(T__0);
				setState(156);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la == ID) {
					{
						setState(155);
						assignment();
					}
				}

				setState(158);
				match(T__7);
				setState(159);
				block();
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhileStatContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class, 0);
		}

		public BlockContext block() {
			return getRuleContext(BlockContext.class, 0);
		}

		public WhileStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_whileStat;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof smallLangV2Listener)
				((smallLangV2Listener) listener).enterWhileStat(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof smallLangV2Listener)
				((smallLangV2Listener) listener).exitWhileStat(this);
		}
	}

	public final WhileStatContext whileStat() throws RecognitionException {
		WhileStatContext _localctx = new WhileStatContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_whileStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(161);
				match(T__10);
				setState(162);
				match(T__6);
				setState(163);
				expr();
				setState(164);
				match(T__7);
				setState(165);
				block();
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReturnStatContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class, 0);
		}

		public ReturnStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_returnStat;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof smallLangV2Listener)
				((smallLangV2Listener) listener).enterReturnStat(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof smallLangV2Listener)
				((smallLangV2Listener) listener).exitReturnStat(this);
		}
	}

	public final ReturnStatContext returnStat() throws RecognitionException {
		ReturnStatContext _localctx = new ReturnStatContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_returnStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(167);
				match(T__11);
				setState(168);
				expr();
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncDeclContext extends ParserRuleContext {
		public TerminalNode ID() {
			return getToken(smallLangV2Parser.ID, 0);
		}

		public BlockContext block() {
			return getRuleContext(BlockContext.class, 0);
		}

		public TypeContext type() {
			return getRuleContext(TypeContext.class, 0);
		}

		public AutoContext auto() {
			return getRuleContext(AutoContext.class, 0);
		}

		public FormalParamsContext formalParams() {
			return getRuleContext(FormalParamsContext.class, 0);
		}

		public FuncDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_funcDecl;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof smallLangV2Listener)
				((smallLangV2Listener) listener).enterFuncDecl(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof smallLangV2Listener)
				((smallLangV2Listener) listener).exitFuncDecl(this);
		}
	}

	public final FuncDeclContext funcDecl() throws RecognitionException {
		FuncDeclContext _localctx = new FuncDeclContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_funcDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(170);
				match(T__12);
				setState(171);
				match(ID);
				setState(172);
				match(T__6);
				setState(174);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la == ID) {
					{
						setState(173);
						formalParams();
					}
				}

				setState(176);
				match(T__7);
				setState(177);
				match(T__2);
				setState(180);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
					case T__21:
					case T__22:
					case T__23:
					case T__24: {
						setState(178);
						type();
					}
						break;
					case T__25: {
						setState(179);
						auto();
					}
						break;
					default:
						throw new NoViableAltException(this);
				}
				setState(182);
				block();
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormalParamsContext extends ParserRuleContext {
		public List<FormalParamContext> formalParam() {
			return getRuleContexts(FormalParamContext.class);
		}

		public FormalParamContext formalParam(int i) {
			return getRuleContext(FormalParamContext.class, i);
		}

		public FormalParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_formalParams;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof smallLangV2Listener)
				((smallLangV2Listener) listener).enterFormalParams(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof smallLangV2Listener)
				((smallLangV2Listener) listener).exitFormalParams(this);
		}
	}

	public final FormalParamsContext formalParams() throws RecognitionException {
		FormalParamsContext _localctx = new FormalParamsContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_formalParams);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(185);
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
						{
							setState(184);
							formalParam();
						}
					}
					setState(187);
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while (_la == ID);
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormalParamContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class, 0);
		}

		public TypeContext type() {
			return getRuleContext(TypeContext.class, 0);
		}

		public FormalParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_formalParam;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof smallLangV2Listener)
				((smallLangV2Listener) listener).enterFormalParam(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof smallLangV2Listener)
				((smallLangV2Listener) listener).exitFormalParam(this);
		}
	}

	public final FormalParamContext formalParam() throws RecognitionException {
		FormalParamContext _localctx = new FormalParamContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_formalParam);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(189);
				identifier();
				setState(190);
				match(T__2);
				setState(191);
				type();
				setState(193);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la == T__13) {
					{
						setState(192);
						match(T__13);
					}
				}

			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}

		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class, i);
		}

		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_block;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof smallLangV2Listener)
				((smallLangV2Listener) listener).enterBlock(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof smallLangV2Listener)
				((smallLangV2Listener) listener).exitBlock(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(195);
				match(T__14);
				setState(201);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__4) | (1L << T__5) | (1L << T__9)
						| (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << ID))) != 0)) {
					{
						setState(197);
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
								{
									setState(196);
									statement();
								}
							}
							setState(199);
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__4) | (1L << T__5)
								| (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << ID))) != 0));
					}
				}

				setState(203);
				match(T__15);
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public List<SimpleExprContext> simpleExpr() {
			return getRuleContexts(SimpleExprContext.class);
		}

		public SimpleExprContext simpleExpr(int i) {
			return getRuleContext(SimpleExprContext.class, i);
		}

		public RelOpContext relOp() {
			return getRuleContext(RelOpContext.class, 0);
		}

		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_expr;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof smallLangV2Listener)
				((smallLangV2Listener) listener).enterExpr(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof smallLangV2Listener)
				((smallLangV2Listener) listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(205);
				simpleExpr();
				setState(209);
				_errHandler.sync(this);
				switch (getInterpreter().adaptivePredict(_input, 23, _ctx)) {
					case 1: {
						setState(206);
						relOp();
						setState(207);
						simpleExpr();
					}
						break;
				}
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SimpleExprContext extends ParserRuleContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}

		public TermContext term(int i) {
			return getRuleContext(TermContext.class, i);
		}

		public AddOpContext addOp() {
			return getRuleContext(AddOpContext.class, 0);
		}

		public SimpleExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_simpleExpr;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof smallLangV2Listener)
				((smallLangV2Listener) listener).enterSimpleExpr(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof smallLangV2Listener)
				((smallLangV2Listener) listener).exitSimpleExpr(this);
		}
	}

	public final SimpleExprContext simpleExpr() throws RecognitionException {
		SimpleExprContext _localctx = new SimpleExprContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_simpleExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(211);
				term();
				setState(215);
				_errHandler.sync(this);
				switch (getInterpreter().adaptivePredict(_input, 24, _ctx)) {
					case 1: {
						setState(212);
						addOp();
						setState(213);
						term();
					}
						break;
				}
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TermContext extends ParserRuleContext {
		public List<FactorContext> factor() {
			return getRuleContexts(FactorContext.class);
		}

		public FactorContext factor(int i) {
			return getRuleContext(FactorContext.class, i);
		}

		public MulOpContext mulOp() {
			return getRuleContext(MulOpContext.class, 0);
		}

		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_term;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof smallLangV2Listener)
				((smallLangV2Listener) listener).enterTerm(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof smallLangV2Listener)
				((smallLangV2Listener) listener).exitTerm(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_term);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(217);
				factor();
				setState(221);
				_errHandler.sync(this);
				switch (getInterpreter().adaptivePredict(_input, 25, _ctx)) {
					case 1: {
						setState(218);
						mulOp();
						setState(219);
						factor();
					}
						break;
				}
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FactorContext extends ParserRuleContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class, 0);
		}

		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class, 0);
		}

		public FuncCallContext funcCall() {
			return getRuleContext(FuncCallContext.class, 0);
		}

		public SubExprContext subExpr() {
			return getRuleContext(SubExprContext.class, 0);
		}

		public UnaryContext unary() {
			return getRuleContext(UnaryContext.class, 0);
		}

		public ArrayContext array() {
			return getRuleContext(ArrayContext.class, 0);
		}

		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_factor;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof smallLangV2Listener)
				((smallLangV2Listener) listener).enterFactor(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof smallLangV2Listener)
				((smallLangV2Listener) listener).exitFactor(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_factor);
		try {
			setState(229);
			_errHandler.sync(this);
			switch (getInterpreter().adaptivePredict(_input, 26, _ctx)) {
				case 1:
					enterOuterAlt(_localctx, 1); {
					setState(223);
					literal();
				}
					break;
				case 2:
					enterOuterAlt(_localctx, 2); {
					setState(224);
					identifier();
				}
					break;
				case 3:
					enterOuterAlt(_localctx, 3); {
					setState(225);
					funcCall();
				}
					break;
				case 4:
					enterOuterAlt(_localctx, 4); {
					setState(226);
					subExpr();
				}
					break;
				case 5:
					enterOuterAlt(_localctx, 5); {
					setState(227);
					unary();
				}
					break;
				case 6:
					enterOuterAlt(_localctx, 6); {
					setState(228);
					array();
				}
					break;
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteralContext extends ParserRuleContext {
		public BoolContext bool() {
			return getRuleContext(BoolContext.class, 0);
		}

		public TerminalNode INT() {
			return getToken(smallLangV2Parser.INT, 0);
		}

		public TerminalNode FLOAT() {
			return getToken(smallLangV2Parser.FLOAT, 0);
		}

		public TerminalNode CHAR() {
			return getToken(smallLangV2Parser.CHAR, 0);
		}

		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_literal;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof smallLangV2Listener)
				((smallLangV2Listener) listener).enterLiteral(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof smallLangV2Listener)
				((smallLangV2Listener) listener).exitLiteral(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_literal);
		try {
			setState(237);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
				case T__37:
				case T__38:
					enterOuterAlt(_localctx, 1); {
					setState(231);
					bool();
				}
					break;
				case INT:
					enterOuterAlt(_localctx, 2); {
					setState(232);
					match(INT);
				}
					break;
				case FLOAT:
					enterOuterAlt(_localctx, 3); {
					setState(233);
					match(FLOAT);
				}
					break;
				case T__16:
					enterOuterAlt(_localctx, 4); {
					setState(234);
					match(T__16);
					setState(235);
					match(CHAR);
					setState(236);
					match(T__16);
				}
					break;
				default:
					throw new NoViableAltException(this);
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncCallContext extends ParserRuleContext {
		public TerminalNode ID() {
			return getToken(smallLangV2Parser.ID, 0);
		}

		public ActualParamsContext actualParams() {
			return getRuleContext(ActualParamsContext.class, 0);
		}

		public FuncCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_funcCall;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof smallLangV2Listener)
				((smallLangV2Listener) listener).enterFuncCall(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof smallLangV2Listener)
				((smallLangV2Listener) listener).exitFuncCall(this);
		}
	}

	public final FuncCallContext funcCall() throws RecognitionException {
		FuncCallContext _localctx = new FuncCallContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_funcCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(239);
				match(ID);
				setState(240);
				match(T__6);
				setState(242);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0
						&& ((1L << _la) & ((1L << T__6) | (1L << T__14) | (1L << T__16) | (1L << T__17) | (1L << T__18)
								| (1L << T__37) | (1L << T__38) | (1L << INT) | (1L << FLOAT) | (1L << ID))) != 0)) {
					{
						setState(241);
						actualParams();
					}
				}

				setState(244);
				match(T__7);
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ActualParamsContext extends ParserRuleContext {
		public List<ActualParamContext> actualParam() {
			return getRuleContexts(ActualParamContext.class);
		}

		public ActualParamContext actualParam(int i) {
			return getRuleContext(ActualParamContext.class, i);
		}

		public ActualParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_actualParams;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof smallLangV2Listener)
				((smallLangV2Listener) listener).enterActualParams(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof smallLangV2Listener)
				((smallLangV2Listener) listener).exitActualParams(this);
		}
	}

	public final ActualParamsContext actualParams() throws RecognitionException {
		ActualParamsContext _localctx = new ActualParamsContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_actualParams);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(247);
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
						{
							setState(246);
							actualParam();
						}
					}
					setState(249);
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ((((_la) & ~0x3f) == 0
						&& ((1L << _la) & ((1L << T__6) | (1L << T__14) | (1L << T__16) | (1L << T__17) | (1L << T__18)
								| (1L << T__37) | (1L << T__38) | (1L << INT) | (1L << FLOAT) | (1L << ID))) != 0));
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ActualParamContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class, 0);
		}

		public ActualParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_actualParam;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof smallLangV2Listener)
				((smallLangV2Listener) listener).enterActualParam(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof smallLangV2Listener)
				((smallLangV2Listener) listener).exitActualParam(this);
		}
	}

	public final ActualParamContext actualParam() throws RecognitionException {
		ActualParamContext _localctx = new ActualParamContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_actualParam);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(251);
				expr();
				setState(253);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la == T__13) {
					{
						setState(252);
						match(T__13);
					}
				}

			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayContext extends ParserRuleContext {
		public List<ActualParamContext> actualParam() {
			return getRuleContexts(ActualParamContext.class);
		}

		public ActualParamContext actualParam(int i) {
			return getRuleContext(ActualParamContext.class, i);
		}

		public ArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_array;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof smallLangV2Listener)
				((smallLangV2Listener) listener).enterArray(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof smallLangV2Listener)
				((smallLangV2Listener) listener).exitArray(this);
		}
	}

	public final ArrayContext array() throws RecognitionException {
		ArrayContext _localctx = new ArrayContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_array);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(255);
				match(T__14);
				setState(257);
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
						{
							setState(256);
							actualParam();
						}
					}
					setState(259);
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ((((_la) & ~0x3f) == 0
						&& ((1L << _la) & ((1L << T__6) | (1L << T__14) | (1L << T__16) | (1L << T__17) | (1L << T__18)
								| (1L << T__37) | (1L << T__38) | (1L << INT) | (1L << FLOAT) | (1L << ID))) != 0));
				setState(261);
				match(T__15);
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SubExprContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class, 0);
		}

		public SubExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_subExpr;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof smallLangV2Listener)
				((smallLangV2Listener) listener).enterSubExpr(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof smallLangV2Listener)
				((smallLangV2Listener) listener).exitSubExpr(this);
		}
	}

	public final SubExprContext subExpr() throws RecognitionException {
		SubExprContext _localctx = new SubExprContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_subExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(263);
				match(T__6);
				setState(264);
				expr();
				setState(265);
				match(T__7);
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnaryContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class, 0);
		}

		public UnaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_unary;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof smallLangV2Listener)
				((smallLangV2Listener) listener).enterUnary(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof smallLangV2Listener)
				((smallLangV2Listener) listener).exitUnary(this);
		}
	}

	public final UnaryContext unary() throws RecognitionException {
		UnaryContext _localctx = new UnaryContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_unary);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(267);
				_la = _input.LA(1);
				if (!(_la == T__17 || _la == T__18)) {
					_errHandler.recoverInline(this);
				} else {
					if (_input.LA(1) == Token.EOF)
						matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(268);
				expr();
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentifierContext extends ParserRuleContext {
		public TerminalNode ID() {
			return getToken(smallLangV2Parser.ID, 0);
		}

		public ArrSizeContext arrSize() {
			return getRuleContext(ArrSizeContext.class, 0);
		}

		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_identifier;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof smallLangV2Listener)
				((smallLangV2Listener) listener).enterIdentifier(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof smallLangV2Listener)
				((smallLangV2Listener) listener).exitIdentifier(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_identifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(270);
				match(ID);
				setState(272);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la == T__19) {
					{
						setState(271);
						arrSize();
					}
				}

			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrSizeContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class, 0);
		}

		public ArrSizeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_arrSize;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof smallLangV2Listener)
				((smallLangV2Listener) listener).enterArrSize(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof smallLangV2Listener)
				((smallLangV2Listener) listener).exitArrSize(this);
		}
	}

	public final ArrSizeContext arrSize() throws RecognitionException {
		ArrSizeContext _localctx = new ArrSizeContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_arrSize);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(274);
				match(T__19);
				setState(276);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0
						&& ((1L << _la) & ((1L << T__6) | (1L << T__14) | (1L << T__16) | (1L << T__17) | (1L << T__18)
								| (1L << T__37) | (1L << T__38) | (1L << INT) | (1L << FLOAT) | (1L << ID))) != 0)) {
					{
						setState(275);
						expr();
					}
				}

				setState(278);
				match(T__20);
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_type;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof smallLangV2Listener)
				((smallLangV2Listener) listener).enterType(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof smallLangV2Listener)
				((smallLangV2Listener) listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(280);
				_la = _input.LA(1);
				if (!((((_la) & ~0x3f) == 0
						&& ((1L << _la) & ((1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24))) != 0))) {
					_errHandler.recoverInline(this);
				} else {
					if (_input.LA(1) == Token.EOF)
						matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AutoContext extends ParserRuleContext {
		public AutoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_auto;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof smallLangV2Listener)
				((smallLangV2Listener) listener).enterAuto(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof smallLangV2Listener)
				((smallLangV2Listener) listener).exitAuto(this);
		}
	}

	public final AutoContext auto() throws RecognitionException {
		AutoContext _localctx = new AutoContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_auto);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(282);
				match(T__25);
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RelOpContext extends ParserRuleContext {
		public RelOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_relOp;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof smallLangV2Listener)
				((smallLangV2Listener) listener).enterRelOp(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof smallLangV2Listener)
				((smallLangV2Listener) listener).exitRelOp(this);
		}
	}

	public final RelOpContext relOp() throws RecognitionException {
		RelOpContext _localctx = new RelOpContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_relOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(284);
				_la = _input.LA(1);
				if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__26) | (1L << T__27) | (1L << T__28)
						| (1L << T__29) | (1L << T__30) | (1L << T__31))) != 0))) {
					_errHandler.recoverInline(this);
				} else {
					if (_input.LA(1) == Token.EOF)
						matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AddOpContext extends ParserRuleContext {
		public AddOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_addOp;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof smallLangV2Listener)
				((smallLangV2Listener) listener).enterAddOp(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof smallLangV2Listener)
				((smallLangV2Listener) listener).exitAddOp(this);
		}
	}

	public final AddOpContext addOp() throws RecognitionException {
		AddOpContext _localctx = new AddOpContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_addOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(286);
				_la = _input.LA(1);
				if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__17) | (1L << T__32) | (1L << T__33))) != 0))) {
					_errHandler.recoverInline(this);
				} else {
					if (_input.LA(1) == Token.EOF)
						matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MulOpContext extends ParserRuleContext {
		public MulOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_mulOp;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof smallLangV2Listener)
				((smallLangV2Listener) listener).enterMulOp(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof smallLangV2Listener)
				((smallLangV2Listener) listener).exitMulOp(this);
		}
	}

	public final MulOpContext mulOp() throws RecognitionException {
		MulOpContext _localctx = new MulOpContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_mulOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(288);
				_la = _input.LA(1);
				if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__34) | (1L << T__35) | (1L << T__36))) != 0))) {
					_errHandler.recoverInline(this);
				} else {
					if (_input.LA(1) == Token.EOF)
						matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BoolContext extends ParserRuleContext {
		public BoolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_bool;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof smallLangV2Listener)
				((smallLangV2Listener) listener).enterBool(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof smallLangV2Listener)
				((smallLangV2Listener) listener).exitBool(this);
		}
	}

	public final BoolContext bool() throws RecognitionException {
		BoolContext _localctx = new BoolContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_bool);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(290);
				_la = _input.LA(1);
				if (!(_la == T__37 || _la == T__38)) {
					_errHandler.recoverInline(this);
				} else {
					if (_input.LA(1) == Token.EOF)
						matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN = "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3/\u0127\4\2\t\2\4"
			+ "\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"
			+ "\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"
			+ "\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"
			+ "\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"
			+ "\t!\3\2\6\2D\n\2\r\2\16\2E\3\3\3\3\3\3\5\3K\n\3\3\3\3\3\3\3\5\3P\n\3\3"
			+ "\3\3\3\3\3\5\3U\n\3\3\3\3\3\5\3Y\n\3\3\3\3\3\5\3]\n\3\3\3\3\3\5\3a\n\3"
			+ "\3\3\3\3\3\3\5\3f\n\3\3\3\3\3\5\3j\n\3\5\3l\n\3\3\4\3\4\3\4\3\4\3\4\5"
			+ "\4s\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4~\n\4\3\4\3\4\5\4\u0082"
			+ "\n\4\5\4\u0084\n\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7"
			+ "\3\7\5\7\u0094\n\7\3\b\3\b\3\b\5\b\u0099\n\b\3\b\3\b\3\b\3\b\5\b\u009f"
			+ "\n\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3"
			+ "\13\5\13\u00b1\n\13\3\13\3\13\3\13\3\13\5\13\u00b7\n\13\3\13\3\13\3\f"
			+ "\6\f\u00bc\n\f\r\f\16\f\u00bd\3\r\3\r\3\r\3\r\5\r\u00c4\n\r\3\16\3\16"
			+ "\6\16\u00c8\n\16\r\16\16\16\u00c9\5\16\u00cc\n\16\3\16\3\16\3\17\3\17"
			+ "\3\17\3\17\5\17\u00d4\n\17\3\20\3\20\3\20\3\20\5\20\u00da\n\20\3\21\3"
			+ "\21\3\21\3\21\5\21\u00e0\n\21\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u00e8"
			+ "\n\22\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u00f0\n\23\3\24\3\24\3\24\5\24"
			+ "\u00f5\n\24\3\24\3\24\3\25\6\25\u00fa\n\25\r\25\16\25\u00fb\3\26\3\26"
			+ "\5\26\u0100\n\26\3\27\3\27\6\27\u0104\n\27\r\27\16\27\u0105\3\27\3\27"
			+ "\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\5\32\u0113\n\32\3\33\3\33"
			+ "\5\33\u0117\n\33\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 "
			+ "\3 \3!\3!\3!\2\2\"\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60"
			+ "\62\64\668:<>@\2\b\3\2\24\25\3\2\30\33\3\2\35\"\4\2\24\24#$\3\2%\'\3\2"
			+ "()\2\u0134\2C\3\2\2\2\4k\3\2\2\2\6\u0083\3\2\2\2\b\u0085\3\2\2\2\n\u0089"
			+ "\3\2\2\2\f\u008c\3\2\2\2\16\u0095\3\2\2\2\20\u00a3\3\2\2\2\22\u00a9\3"
			+ "\2\2\2\24\u00ac\3\2\2\2\26\u00bb\3\2\2\2\30\u00bf\3\2\2\2\32\u00c5\3\2"
			+ "\2\2\34\u00cf\3\2\2\2\36\u00d5\3\2\2\2 \u00db\3\2\2\2\"\u00e7\3\2\2\2"
			+ "$\u00ef\3\2\2\2&\u00f1\3\2\2\2(\u00f9\3\2\2\2*\u00fd\3\2\2\2,\u0101\3"
			+ "\2\2\2.\u0109\3\2\2\2\60\u010d\3\2\2\2\62\u0110\3\2\2\2\64\u0114\3\2\2"
			+ "\2\66\u011a\3\2\2\28\u011c\3\2\2\2:\u011e\3\2\2\2<\u0120\3\2\2\2>\u0122"
			+ "\3\2\2\2@\u0124\3\2\2\2BD\5\4\3\2CB\3\2\2\2DE\3\2\2\2EC\3\2\2\2EF\3\2"
			+ "\2\2F\3\3\2\2\2GH\5\6\4\2HJ\7\3\2\2IK\7*\2\2JI\3\2\2\2JK\3\2\2\2Kl\3\2"
			+ "\2\2LM\5\b\5\2MO\7\3\2\2NP\7*\2\2ON\3\2\2\2OP\3\2\2\2Pl\3\2\2\2QR\5\n"
			+ "\6\2RT\7\3\2\2SU\7*\2\2TS\3\2\2\2TU\3\2\2\2Ul\3\2\2\2VX\5\f\7\2WY\7*\2"
			+ "\2XW\3\2\2\2XY\3\2\2\2Yl\3\2\2\2Z\\\5\16\b\2[]\7*\2\2\\[\3\2\2\2\\]\3"
			+ "\2\2\2]l\3\2\2\2^`\5\20\t\2_a\7*\2\2`_\3\2\2\2`a\3\2\2\2al\3\2\2\2bc\5"
			+ "\22\n\2ce\7\3\2\2df\7*\2\2ed\3\2\2\2ef\3\2\2\2fl\3\2\2\2gi\5\24\13\2h"
			+ "j\7*\2\2ih\3\2\2\2ij\3\2\2\2jl\3\2\2\2kG\3\2\2\2kL\3\2\2\2kQ\3\2\2\2k"
			+ "V\3\2\2\2kZ\3\2\2\2k^\3\2\2\2kb\3\2\2\2kg\3\2\2\2l\5\3\2\2\2mn\7\4\2\2"
			+ "no\7-\2\2or\7\5\2\2ps\5\66\34\2qs\58\35\2rp\3\2\2\2rq\3\2\2\2st\3\2\2"
			+ "\2tu\7\6\2\2uv\5\34\17\2v\u0084\3\2\2\2wx\7\4\2\2xy\7-\2\2yz\5\64\33\2"
			+ "z}\7\5\2\2{~\5\66\34\2|~\58\35\2}{\3\2\2\2}|\3\2\2\2~\u0081\3\2\2\2\177"
			+ "\u0080\7\6\2\2\u0080\u0082\5\34\17\2\u0081\177\3\2\2\2\u0081\u0082\3\2"
			+ "\2\2\u0082\u0084\3\2\2\2\u0083m\3\2\2\2\u0083w\3\2\2\2\u0084\7\3\2\2\2"
			+ "\u0085\u0086\5\62\32\2\u0086\u0087\7\6\2\2\u0087\u0088\5\34\17\2\u0088"
			+ "\t\3\2\2\2\u0089\u008a\7\7\2\2\u008a\u008b\5\34\17\2\u008b\13\3\2\2\2"
			+ "\u008c\u008d\7\b\2\2\u008d\u008e\7\t\2\2\u008e\u008f\5\34\17\2\u008f\u0090"
			+ "\7\n\2\2\u0090\u0093\5\32\16\2\u0091\u0092\7\13\2\2\u0092\u0094\5\32\16"
			+ "\2\u0093\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094\r\3\2\2\2\u0095\u0096"
			+ "\7\f\2\2\u0096\u0098\7\t\2\2\u0097\u0099\5\6\4\2\u0098\u0097\3\2\2\2\u0098"
			+ "\u0099\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u009b\7\3\2\2\u009b\u009c\5\34"
			+ "\17\2\u009c\u009e\7\3\2\2\u009d\u009f\5\b\5\2\u009e\u009d\3\2\2\2\u009e"
			+ "\u009f\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a1\7\n\2\2\u00a1\u00a2\5\32"
			+ "\16\2\u00a2\17\3\2\2\2\u00a3\u00a4\7\r\2\2\u00a4\u00a5\7\t\2\2\u00a5\u00a6"
			+ "\5\34\17\2\u00a6\u00a7\7\n\2\2\u00a7\u00a8\5\32\16\2\u00a8\21\3\2\2\2"
			+ "\u00a9\u00aa\7\16\2\2\u00aa\u00ab\5\34\17\2\u00ab\23\3\2\2\2\u00ac\u00ad"
			+ "\7\17\2\2\u00ad\u00ae\7-\2\2\u00ae\u00b0\7\t\2\2\u00af\u00b1\5\26\f\2"
			+ "\u00b0\u00af\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b3"
			+ "\7\n\2\2\u00b3\u00b6\7\5\2\2\u00b4\u00b7\5\66\34\2\u00b5\u00b7\58\35\2"
			+ "\u00b6\u00b4\3\2\2\2\u00b6\u00b5\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00b9"
			+ "\5\32\16\2\u00b9\25\3\2\2\2\u00ba\u00bc\5\30\r\2\u00bb\u00ba\3\2\2\2\u00bc"
			+ "\u00bd\3\2\2\2\u00bd\u00bb\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\27\3\2\2"
			+ "\2\u00bf\u00c0\5\62\32\2\u00c0\u00c1\7\5\2\2\u00c1\u00c3\5\66\34\2\u00c2"
			+ "\u00c4\7\20\2\2\u00c3\u00c2\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\31\3\2\2"
			+ "\2\u00c5\u00cb\7\21\2\2\u00c6\u00c8\5\4\3\2\u00c7\u00c6\3\2\2\2\u00c8"
			+ "\u00c9\3\2\2\2\u00c9\u00c7\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00cc\3\2"
			+ "\2\2\u00cb\u00c7\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd"
			+ "\u00ce\7\22\2\2\u00ce\33\3\2\2\2\u00cf\u00d3\5\36\20\2\u00d0\u00d1\5:"
			+ "\36\2\u00d1\u00d2\5\36\20\2\u00d2\u00d4\3\2\2\2\u00d3\u00d0\3\2\2\2\u00d3"
			+ "\u00d4\3\2\2\2\u00d4\35\3\2\2\2\u00d5\u00d9\5 \21\2\u00d6\u00d7\5<\37"
			+ "\2\u00d7\u00d8\5 \21\2\u00d8\u00da\3\2\2\2\u00d9\u00d6\3\2\2\2\u00d9\u00da"
			+ "\3\2\2\2\u00da\37\3\2\2\2\u00db\u00df\5\"\22\2\u00dc\u00dd\5> \2\u00dd"
			+ "\u00de\5\"\22\2\u00de\u00e0\3\2\2\2\u00df\u00dc\3\2\2\2\u00df\u00e0\3"
			+ "\2\2\2\u00e0!\3\2\2\2\u00e1\u00e8\5$\23\2\u00e2\u00e8\5\62\32\2\u00e3"
			+ "\u00e8\5&\24\2\u00e4\u00e8\5.\30\2\u00e5\u00e8\5\60\31\2\u00e6\u00e8\5"
			+ ",\27\2\u00e7\u00e1\3\2\2\2\u00e7\u00e2\3\2\2\2\u00e7\u00e3\3\2\2\2\u00e7"
			+ "\u00e4\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e7\u00e6\3\2\2\2\u00e8#\3\2\2\2"
			+ "\u00e9\u00f0\5@!\2\u00ea\u00f0\7+\2\2\u00eb\u00f0\7,\2\2\u00ec\u00ed\7"
			+ "\23\2\2\u00ed\u00ee\7.\2\2\u00ee\u00f0\7\23\2\2\u00ef\u00e9\3\2\2\2\u00ef"
			+ "\u00ea\3\2\2\2\u00ef\u00eb\3\2\2\2\u00ef\u00ec\3\2\2\2\u00f0%\3\2\2\2"
			+ "\u00f1\u00f2\7-\2\2\u00f2\u00f4\7\t\2\2\u00f3\u00f5\5(\25\2\u00f4\u00f3"
			+ "\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6\u00f7\7\n\2\2\u00f7"
			+ "\'\3\2\2\2\u00f8\u00fa\5*\26\2\u00f9\u00f8\3\2\2\2\u00fa\u00fb\3\2\2\2"
			+ "\u00fb\u00f9\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc)\3\2\2\2\u00fd\u00ff\5"
			+ "\34\17\2\u00fe\u0100\7\20\2\2\u00ff\u00fe\3\2\2\2\u00ff\u0100\3\2\2\2"
			+ "\u0100+\3\2\2\2\u0101\u0103\7\21\2\2\u0102\u0104\5*\26\2\u0103\u0102\3"
			+ "\2\2\2\u0104\u0105\3\2\2\2\u0105\u0103\3\2\2\2\u0105\u0106\3\2\2\2\u0106"
			+ "\u0107\3\2\2\2\u0107\u0108\7\22\2\2\u0108-\3\2\2\2\u0109\u010a\7\t\2\2"
			+ "\u010a\u010b\5\34\17\2\u010b\u010c\7\n\2\2\u010c/\3\2\2\2\u010d\u010e"
			+ "\t\2\2\2\u010e\u010f\5\34\17\2\u010f\61\3\2\2\2\u0110\u0112\7-\2\2\u0111"
			+ "\u0113\5\64\33\2\u0112\u0111\3\2\2\2\u0112\u0113\3\2\2\2\u0113\63\3\2"
			+ "\2\2\u0114\u0116\7\26\2\2\u0115\u0117\5\34\17\2\u0116\u0115\3\2\2\2\u0116"
			+ "\u0117\3\2\2\2\u0117\u0118\3\2\2\2\u0118\u0119\7\27\2\2\u0119\65\3\2\2"
			+ "\2\u011a\u011b\t\3\2\2\u011b\67\3\2\2\2\u011c\u011d\7\34\2\2\u011d9\3"
			+ "\2\2\2\u011e\u011f\t\4\2\2\u011f;\3\2\2\2\u0120\u0121\t\5\2\2\u0121=\3"
			+ "\2\2\2\u0122\u0123\t\6\2\2\u0123?\3\2\2\2\u0124\u0125\t\7\2\2\u0125A\3"
			+ "\2\2\2$EJOTX\\`eikr}\u0081\u0083\u0093\u0098\u009e\u00b0\u00b6\u00bd\u00c3"
			+ "\u00c9\u00cb\u00d3\u00d9\u00df\u00e7\u00ef\u00f4\u00fb\u00ff\u0105\u0112" + "\u0116";
	public static final ATN _ATN = new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}