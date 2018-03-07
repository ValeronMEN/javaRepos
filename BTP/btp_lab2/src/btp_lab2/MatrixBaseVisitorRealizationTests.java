package btp_lab2;

import org.antlr.v4.runtime.*;
import org.junit.Rule;
import org.junit.Test;
import java.util.NoSuchElementException;
import java.util.Arrays;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.*;

public class MatrixBaseVisitorRealizationTests {
	protected MatrixParser parser;
    protected MatrixBaseVisitorRealization visitor = new MatrixBaseVisitorRealization();

    @Rule
    public ExpectedException expExcNone = ExpectedException.none();
    
    @Test
    public void sumOfTwoMatrixes()
    {
        double[][] expected = {
                {12,10},
                {8,8}
        };
        assertTrue(Arrays.deepEquals(getMatrix("[[6,5],[4, 4]] + [[6,5],[4, 4]]"), expected));
    }

    @Test
    public void multiplicateTwoMatrixesAndRankIt() {
        double[][] toCompare = new double[][]{
                {1.00}
        };
        assertEquals(true, Arrays.deepEquals(getMatrix("([[1,1]] * [[2,2],[1,3]])^R"), toCompare));
    }

    @Test
    public void inverseMatrix(){
        double[][] toCompare = new double[][]{
                {0.75, -0.25},
                {-0.50, 0.25}
        };
        assertEquals(true, Arrays.deepEquals(getMatrix("[[4,4],[8,12]]^1"), toCompare));
    }

    @Test
    public void completeExpressionOfMatrix() {
        double[][] toCompare = new double[][]{{ 2.00 }};
        assertEquals(true, Arrays.deepEquals(getMatrix("([[4,4],[8,12]]+[[2,2],[1,3]]*[[2,3],[6,2]]^1)^R"), toCompare));
    }

    @Test
    public void testMatrixDimensions(){
    	expExcNone.expect(IllegalArgumentException.class);
    	expExcNone.expectMessage("\nInvalid dimensions inside matrix");
        getMatrix("[[1,2], [1,2,3],[1],[13,2,-123,1]]");
    }

    @Test
    public void multiplicationOfTwoMatrixesWithWrongDimensions(){
    	expExcNone.expect(IllegalArgumentException.class);
    	expExcNone.expectMessage("\nInvalid dimensions while performing '*' operation");
        getMatrix("[[2,1], [1,4], [6,9]] * [[1,0,7,6,4,6,4]]");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void dimensionsOfMatrixesWithMultiplyTry(){
    	getMatrix("[[1,2], [1,2,3],[1],[13,2,-123,1]] * [[1,2]]");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void dimensiondfdsOfMatrixesWithMultiplyTry(){
    	getMatrix("[[1,2], [1,2,3],[1],[13,2,-123,1]] + [[1,2]]");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void setWrongFormatOfMatrix(){
    	getMatrix("[2,2]");
    }

    @Test(expected = IllegalArgumentException.class)
    public void setExpressionWithoutMatrix(){
    	getMatrix("[[2,2]]*");
    }

    @Test(expected = IllegalArgumentException.class)
    public void setNotFullExpression(){
    	getMatrix("[[2]");
    }
    
    @SuppressWarnings("deprecation")
	protected double[][] getMatrix(String expression) {
        parser = new MatrixParser(new CommonTokenStream(new MatrixLexer(new ANTLRInputStream(expression))));
        
        parser.setErrorHandler(new DefaultErrorStrategy(){
            @Override
            public Token recoverInline(Parser recognizer){
            	throw new IllegalArgumentException("Invalid request!");
            }
            @Override
            public void reportError(Parser recognizer, RecognitionException e){
            	throw new IllegalArgumentException("Invalid request!\n");
            }
        });

        try{
            return visitor.visit(parser.root()).getArray();
        }catch(IllegalArgumentException e){
            throw e;
        }catch(NoSuchElementException e){
        	throw e;
        }
    }
}