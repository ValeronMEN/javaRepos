package btp_lab2;

import Jama.Matrix;

import java.util.Hashtable;
import java.util.NoSuchElementException;

/* This class overrides MatrixBaseVisitor<T> to realize operations with Matrixes. */
public class MatrixBaseVisitorRealization extends MatrixBaseVisitor <Matrix> {
    private Hashtable<String, Matrix> savedVariables = new Hashtable<String, Matrix>();

    @Override
    public Matrix visitGoToRank(MatrixParser.GoToRankContext context) {
        return visit(context.rank());
    }
    
    @Override
    public Matrix visitGoToSum(MatrixParser.GoToSumContext context) {
        return visit(context.sum());
    }

    @Override
    public Matrix visitMainRule(MatrixParser.MainRuleContext context){
        return visit(context.getChild(0));
    }
    
    // initialization
    @Override
    public Matrix visitInitialize(MatrixParser.InitializeContext context) {
        Matrix toSave = visit(context.input());
        if(toSave != null){
            savedVariables.put(context.ID().getText(), toSave);
        }
        else {
            throw new IllegalArgumentException("\nInvalid entry! There's can't be null value!");
        }
        return toSave;
    }
    
    // it searches for existing matrixes
    @Override
    public Matrix visitVariable(MatrixParser.VariableContext context) {
        String id = context.ID().getText();
        boolean haveId = savedVariables.containsKey(id);
        if (haveId)
            return savedVariables.get(id);
        else
            throw new NoSuchElementException("\nNo such element in table");
    }
    
    // creation of the matrix
    @Override
    public Matrix visitGoToVect(MatrixParser.GoToVectContext context) {
        double[][] values = new double[context.vect().size()][];
        int vectorIndex = 0;
        for(int i = 1; i < context.getChildCount();i+=2) {
            values[vectorIndex] = new double[context.getChild(i).getChildCount()/2];
            int numberIndex = 0;
            for (int j = 1; j < context.getChild(i).getChildCount(); j+=2) {
                values[vectorIndex][numberIndex++] = Double.parseDouble(context.getChild(i).getChild(j).getText());
            }
            vectorIndex++;
        }
        try {
            return new Matrix(values);
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException("\nInvalid dimensions inside matrix");
        }
    }
    
    // rank
    @Override
    public Matrix visitRankRule(MatrixParser.RankRuleContext context) {
        if(context.RANK() != null && context.LCOVER() != null && context.RCOVER() != null) {
            int rank = visit(context.sum()).rank();
            double[][] arr = new double[1][1];
            arr[0][0] = rank;
            return new Matrix(arr);
        }
        if(context.RANK() == null && context.LCOVER() == null && context.RCOVER() == null) {
        	return visit(context.sum());
        }
        throw new IllegalArgumentException("\nInvalid rank input!");
    }
    
    // inversion
    @Override
    public Matrix visitInversion(MatrixParser.InversionContext context) {
        if(context.INVER() != null) {
            return visit(context.exp()).inverse();
        }
        return visit(context.exp());
    }
    
    // sum
    @Override
    public Matrix visitMultSumSumOp(MatrixParser.MultSumSumOpContext context) {
        try {
            Matrix firstMatrix = visit(context.mult());
            Matrix secondMatrix = visit(context.sum());

            return firstMatrix.plus(secondMatrix);
        }
        catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("\nInvalid dimensions while performing '+' operation");
        }
    }
    
    // multiplication
    @Override
    public Matrix visitInverMultMultOp(MatrixParser.InverMultMultOpContext context) {
        try {
            Matrix firstMatrix = visit(context.inver());
            Matrix secondMatrix = visit(context.mult());

            if(firstMatrix.getRowDimension() == 1 && firstMatrix.getColumnDimension() == 1)
                return secondMatrix.times(firstMatrix.get(0, 0));
            else if(secondMatrix.getRowDimension() == 1 && secondMatrix.getColumnDimension() == 1)
                return firstMatrix.times(secondMatrix.get(0, 0));
            else
                return firstMatrix.times(secondMatrix);
        }
        catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("\nInvalid dimensions while performing '*' operation");
        }
    }
}
