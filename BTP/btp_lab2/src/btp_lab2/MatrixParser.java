package btp_lab2;
// Generated from Matrix.g4 by ANTLR 4.7
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MatrixParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, NL=4, WS=5, ID=6, NUMBER=7, LCOVER=8, RCOVER=9, 
		EQUAL=10, SUM=11, MULT=12, RANK=13, INVER=14;
	public static final int
		RULE_root = 0, RULE_input = 1, RULE_init = 2, RULE_rank = 3, RULE_sum = 4, 
		RULE_mult = 5, RULE_inver = 6, RULE_exp = 7, RULE_matr = 8, RULE_vect = 9;
	public static final String[] ruleNames = {
		"root", "input", "init", "rank", "sum", "mult", "inver", "exp", "matr", 
		"vect"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'['", "','", "']'", "'\n'", null, null, null, "'('", "')'", "'='", 
		"'+'", "'*'", "'^R'", "'^1'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, "NL", "WS", "ID", "NUMBER", "LCOVER", "RCOVER", 
		"EQUAL", "SUM", "MULT", "RANK", "INVER"
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
	public String getGrammarFileName() { return "Matrix.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MatrixParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class RootContext extends ParserRuleContext {
		public RootContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_root; }
	 
		public RootContext() { }
		public void copyFrom(RootContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MainRuleContext extends RootContext {
		public InputContext input() {
			return getRuleContext(InputContext.class,0);
		}
		public TerminalNode EOF() { return getToken(MatrixParser.EOF, 0); }
		public MainRuleContext(RootContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixListener ) ((MatrixListener)listener).enterMainRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixListener ) ((MatrixListener)listener).exitMainRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MatrixVisitor ) return ((MatrixVisitor<? extends T>)visitor).visitMainRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RootContext root() throws RecognitionException {
		RootContext _localctx = new RootContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_root);
		try {
			_localctx = new MainRuleContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(20);
			input();
			setState(21);
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

	public static class InputContext extends ParserRuleContext {
		public InputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_input; }
	 
		public InputContext() { }
		public void copyFrom(InputContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class GoToInitializeContext extends InputContext {
		public InitContext init() {
			return getRuleContext(InitContext.class,0);
		}
		public GoToInitializeContext(InputContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixListener ) ((MatrixListener)listener).enterGoToInitialize(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixListener ) ((MatrixListener)listener).exitGoToInitialize(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MatrixVisitor ) return ((MatrixVisitor<? extends T>)visitor).visitGoToInitialize(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GoToRankContext extends InputContext {
		public RankContext rank() {
			return getRuleContext(RankContext.class,0);
		}
		public GoToRankContext(InputContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixListener ) ((MatrixListener)listener).enterGoToRank(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixListener ) ((MatrixListener)listener).exitGoToRank(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MatrixVisitor ) return ((MatrixVisitor<? extends T>)visitor).visitGoToRank(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GoToSumContext extends InputContext {
		public SumContext sum() {
			return getRuleContext(SumContext.class,0);
		}
		public GoToSumContext(InputContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixListener ) ((MatrixListener)listener).enterGoToSum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixListener ) ((MatrixListener)listener).exitGoToSum(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MatrixVisitor ) return ((MatrixVisitor<? extends T>)visitor).visitGoToSum(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InputContext input() throws RecognitionException {
		InputContext _localctx = new InputContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_input);
		try {
			setState(26);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				_localctx = new GoToInitializeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(23);
				init();
				}
				break;
			case 2:
				_localctx = new GoToRankContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(24);
				rank();
				}
				break;
			case 3:
				_localctx = new GoToSumContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(25);
				sum();
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

	public static class InitContext extends ParserRuleContext {
		public InitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_init; }
	 
		public InitContext() { }
		public void copyFrom(InitContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class InitializeContext extends InitContext {
		public TerminalNode ID() { return getToken(MatrixParser.ID, 0); }
		public TerminalNode EQUAL() { return getToken(MatrixParser.EQUAL, 0); }
		public InputContext input() {
			return getRuleContext(InputContext.class,0);
		}
		public InitializeContext(InitContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixListener ) ((MatrixListener)listener).enterInitialize(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixListener ) ((MatrixListener)listener).exitInitialize(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MatrixVisitor ) return ((MatrixVisitor<? extends T>)visitor).visitInitialize(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitContext init() throws RecognitionException {
		InitContext _localctx = new InitContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_init);
		try {
			_localctx = new InitializeContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			match(ID);
			setState(29);
			match(EQUAL);
			setState(30);
			input();
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

	public static class RankContext extends ParserRuleContext {
		public RankContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rank; }
	 
		public RankContext() { }
		public void copyFrom(RankContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class RankRuleContext extends RankContext {
		public SumContext sum() {
			return getRuleContext(SumContext.class,0);
		}
		public TerminalNode LCOVER() { return getToken(MatrixParser.LCOVER, 0); }
		public TerminalNode RCOVER() { return getToken(MatrixParser.RCOVER, 0); }
		public TerminalNode RANK() { return getToken(MatrixParser.RANK, 0); }
		public RankRuleContext(RankContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixListener ) ((MatrixListener)listener).enterRankRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixListener ) ((MatrixListener)listener).exitRankRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MatrixVisitor ) return ((MatrixVisitor<? extends T>)visitor).visitRankRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RankContext rank() throws RecognitionException {
		RankContext _localctx = new RankContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_rank);
		int _la;
		try {
			_localctx = new RankRuleContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(33);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LCOVER) {
				{
				setState(32);
				match(LCOVER);
				}
			}

			setState(35);
			sum();
			setState(37);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RCOVER) {
				{
				setState(36);
				match(RCOVER);
				}
			}

			setState(40);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RANK) {
				{
				setState(39);
				match(RANK);
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

	public static class SumContext extends ParserRuleContext {
		public SumContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sum; }
	 
		public SumContext() { }
		public void copyFrom(SumContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MultSumSumOpContext extends SumContext {
		public MultContext mult() {
			return getRuleContext(MultContext.class,0);
		}
		public TerminalNode SUM() { return getToken(MatrixParser.SUM, 0); }
		public SumContext sum() {
			return getRuleContext(SumContext.class,0);
		}
		public MultSumSumOpContext(SumContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixListener ) ((MatrixListener)listener).enterMultSumSumOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixListener ) ((MatrixListener)listener).exitMultSumSumOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MatrixVisitor ) return ((MatrixVisitor<? extends T>)visitor).visitMultSumSumOp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultOpContext extends SumContext {
		public MultContext mult() {
			return getRuleContext(MultContext.class,0);
		}
		public MultOpContext(SumContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixListener ) ((MatrixListener)listener).enterMultOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixListener ) ((MatrixListener)listener).exitMultOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MatrixVisitor ) return ((MatrixVisitor<? extends T>)visitor).visitMultOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SumContext sum() throws RecognitionException {
		SumContext _localctx = new SumContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_sum);
		try {
			setState(47);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				_localctx = new MultSumSumOpContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(42);
				mult();
				setState(43);
				match(SUM);
				setState(44);
				sum();
				}
				break;
			case 2:
				_localctx = new MultOpContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(46);
				mult();
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

	public static class MultContext extends ParserRuleContext {
		public MultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mult; }
	 
		public MultContext() { }
		public void copyFrom(MultContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class InverOpContext extends MultContext {
		public InverContext inver() {
			return getRuleContext(InverContext.class,0);
		}
		public InverOpContext(MultContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixListener ) ((MatrixListener)listener).enterInverOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixListener ) ((MatrixListener)listener).exitInverOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MatrixVisitor ) return ((MatrixVisitor<? extends T>)visitor).visitInverOp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InverMultMultOpContext extends MultContext {
		public InverContext inver() {
			return getRuleContext(InverContext.class,0);
		}
		public TerminalNode MULT() { return getToken(MatrixParser.MULT, 0); }
		public MultContext mult() {
			return getRuleContext(MultContext.class,0);
		}
		public InverMultMultOpContext(MultContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixListener ) ((MatrixListener)listener).enterInverMultMultOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixListener ) ((MatrixListener)listener).exitInverMultMultOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MatrixVisitor ) return ((MatrixVisitor<? extends T>)visitor).visitInverMultMultOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultContext mult() throws RecognitionException {
		MultContext _localctx = new MultContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_mult);
		try {
			setState(54);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new InverMultMultOpContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(49);
				inver();
				setState(50);
				match(MULT);
				setState(51);
				mult();
				}
				break;
			case 2:
				_localctx = new InverOpContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(53);
				inver();
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

	public static class InverContext extends ParserRuleContext {
		public InverContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inver; }
	 
		public InverContext() { }
		public void copyFrom(InverContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class InversionContext extends InverContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode INVER() { return getToken(MatrixParser.INVER, 0); }
		public InversionContext(InverContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixListener ) ((MatrixListener)listener).enterInversion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixListener ) ((MatrixListener)listener).exitInversion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MatrixVisitor ) return ((MatrixVisitor<? extends T>)visitor).visitInversion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InverContext inver() throws RecognitionException {
		InverContext _localctx = new InverContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_inver);
		int _la;
		try {
			_localctx = new InversionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			exp();
			setState(58);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INVER) {
				{
				setState(57);
				match(INVER);
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
	public static class VariableContext extends ExpContext {
		public TerminalNode ID() { return getToken(MatrixParser.ID, 0); }
		public VariableContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixListener ) ((MatrixListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixListener ) ((MatrixListener)listener).exitVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MatrixVisitor ) return ((MatrixVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GoToMatrixContext extends ExpContext {
		public MatrContext matr() {
			return getRuleContext(MatrContext.class,0);
		}
		public GoToMatrixContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixListener ) ((MatrixListener)listener).enterGoToMatrix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixListener ) ((MatrixListener)listener).exitGoToMatrix(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MatrixVisitor ) return ((MatrixVisitor<? extends T>)visitor).visitGoToMatrix(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		ExpContext _localctx = new ExpContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_exp);
		try {
			setState(62);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				_localctx = new GoToMatrixContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(60);
				matr();
				}
				break;
			case ID:
				_localctx = new VariableContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(61);
				match(ID);
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

	public static class MatrContext extends ParserRuleContext {
		public MatrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matr; }
	 
		public MatrContext() { }
		public void copyFrom(MatrContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class GoToVectContext extends MatrContext {
		public List<VectContext> vect() {
			return getRuleContexts(VectContext.class);
		}
		public VectContext vect(int i) {
			return getRuleContext(VectContext.class,i);
		}
		public GoToVectContext(MatrContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixListener ) ((MatrixListener)listener).enterGoToVect(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixListener ) ((MatrixListener)listener).exitGoToVect(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MatrixVisitor ) return ((MatrixVisitor<? extends T>)visitor).visitGoToVect(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MatrContext matr() throws RecognitionException {
		MatrContext _localctx = new MatrContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_matr);
		int _la;
		try {
			_localctx = new GoToVectContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			match(T__0);
			setState(65);
			vect();
			setState(70);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(66);
				match(T__1);
				setState(67);
				vect();
				}
				}
				setState(72);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(73);
			match(T__2);
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

	public static class VectContext extends ParserRuleContext {
		public VectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vect; }
	 
		public VectContext() { }
		public void copyFrom(VectContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class GoToNumberContext extends VectContext {
		public List<TerminalNode> NUMBER() { return getTokens(MatrixParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(MatrixParser.NUMBER, i);
		}
		public GoToNumberContext(VectContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixListener ) ((MatrixListener)listener).enterGoToNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MatrixListener ) ((MatrixListener)listener).exitGoToNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MatrixVisitor ) return ((MatrixVisitor<? extends T>)visitor).visitGoToNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VectContext vect() throws RecognitionException {
		VectContext _localctx = new VectContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_vect);
		int _la;
		try {
			_localctx = new GoToNumberContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			match(T__0);
			setState(76);
			match(NUMBER);
			setState(81);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(77);
				match(T__1);
				setState(78);
				match(NUMBER);
				}
				}
				setState(83);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(84);
			match(T__2);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\20Y\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\3"+
		"\2\3\2\3\2\3\3\3\3\3\3\5\3\35\n\3\3\4\3\4\3\4\3\4\3\5\5\5$\n\5\3\5\3\5"+
		"\5\5(\n\5\3\5\5\5+\n\5\3\6\3\6\3\6\3\6\3\6\5\6\62\n\6\3\7\3\7\3\7\3\7"+
		"\3\7\5\79\n\7\3\b\3\b\5\b=\n\b\3\t\3\t\5\tA\n\t\3\n\3\n\3\n\3\n\7\nG\n"+
		"\n\f\n\16\nJ\13\n\3\n\3\n\3\13\3\13\3\13\3\13\7\13R\n\13\f\13\16\13U\13"+
		"\13\3\13\3\13\3\13\2\2\f\2\4\6\b\n\f\16\20\22\24\2\2\2Y\2\26\3\2\2\2\4"+
		"\34\3\2\2\2\6\36\3\2\2\2\b#\3\2\2\2\n\61\3\2\2\2\f8\3\2\2\2\16:\3\2\2"+
		"\2\20@\3\2\2\2\22B\3\2\2\2\24M\3\2\2\2\26\27\5\4\3\2\27\30\7\2\2\3\30"+
		"\3\3\2\2\2\31\35\5\6\4\2\32\35\5\b\5\2\33\35\5\n\6\2\34\31\3\2\2\2\34"+
		"\32\3\2\2\2\34\33\3\2\2\2\35\5\3\2\2\2\36\37\7\b\2\2\37 \7\f\2\2 !\5\4"+
		"\3\2!\7\3\2\2\2\"$\7\n\2\2#\"\3\2\2\2#$\3\2\2\2$%\3\2\2\2%\'\5\n\6\2&"+
		"(\7\13\2\2\'&\3\2\2\2\'(\3\2\2\2(*\3\2\2\2)+\7\17\2\2*)\3\2\2\2*+\3\2"+
		"\2\2+\t\3\2\2\2,-\5\f\7\2-.\7\r\2\2./\5\n\6\2/\62\3\2\2\2\60\62\5\f\7"+
		"\2\61,\3\2\2\2\61\60\3\2\2\2\62\13\3\2\2\2\63\64\5\16\b\2\64\65\7\16\2"+
		"\2\65\66\5\f\7\2\669\3\2\2\2\679\5\16\b\28\63\3\2\2\28\67\3\2\2\29\r\3"+
		"\2\2\2:<\5\20\t\2;=\7\20\2\2<;\3\2\2\2<=\3\2\2\2=\17\3\2\2\2>A\5\22\n"+
		"\2?A\7\b\2\2@>\3\2\2\2@?\3\2\2\2A\21\3\2\2\2BC\7\3\2\2CH\5\24\13\2DE\7"+
		"\4\2\2EG\5\24\13\2FD\3\2\2\2GJ\3\2\2\2HF\3\2\2\2HI\3\2\2\2IK\3\2\2\2J"+
		"H\3\2\2\2KL\7\5\2\2L\23\3\2\2\2MN\7\3\2\2NS\7\t\2\2OP\7\4\2\2PR\7\t\2"+
		"\2QO\3\2\2\2RU\3\2\2\2SQ\3\2\2\2ST\3\2\2\2TV\3\2\2\2US\3\2\2\2VW\7\5\2"+
		"\2W\25\3\2\2\2\f\34#\'*\618<@HS";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}