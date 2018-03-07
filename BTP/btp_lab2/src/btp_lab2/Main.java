package btp_lab2;

import org.antlr.v4.runtime.*;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        MatrixBaseVisitorRealization matrix = new MatrixBaseVisitorRealization();
        System.out.println("Hello, it's the Matrix Calculator 9000");
        System.out.println("To initialize matrix type sth like this: A = [[8,7],[6,8]]");
        System.out.println("To rank matrix type: B = (A)^R (it can be only one time in the top of the entry)");
        System.out.println("To multiply matrixes type: A * B");
        System.out.println("To find a sum of the matrix type: A + B");
        System.out.println("To inverse: A^1");
        System.out.println("Type 'exit' to exit from the program");
        while (true){
            System.out.print(">> ");
            String input = scanner.nextLine();
            
            if (input.isEmpty()){
            	continue;
            }
            else if (input.equals("exit")){
                scanner.close();
                return;
            }
            
            MatrixParser parser = new MatrixParser(new CommonTokenStream(new MatrixLexer(new ANTLRInputStream(input))));
            
            // set error handlers for the parser
            parser.setErrorHandler(
            		new DefaultErrorStrategy(){
            			@Override
                        public Token recoverInline(Parser recognizer){
                            throw new IllegalArgumentException("Invalid request!");
                        }
                        @Override
                        public void reportError(Parser recognizer, RecognitionException e){
                            throw new IllegalArgumentException("Invalid request!");
                        }
            		}
            );
            
            // the program starts from the root of the tree and then visits every leaf that corresponds to special operation
            // after that it prints the result in the console
            try {
                matrix.visit(parser.root()).print(1, 2);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }catch (NoSuchElementException e){
            	System.out.println(e.getMessage());
            }
        }
	}

}
