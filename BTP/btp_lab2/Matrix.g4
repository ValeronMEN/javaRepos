// rank(A^(-1) + C*B) - task
// The program can parse strings like this:
// (A^1 + C * B)^R
// (A)^R
// A^1
// A * B + C * D + E
// (A^1 + B * C + D^1)^R
grammar Matrix;

// (A + B)^1 - impossible // A^1 - possible

//       C^1 *  A    +       B + F * E
//                   ^
// mult: C^1 *  A            B + F * E
//           ^                 ^
//inver: C^1    A            B   F * E
//                                 ^
//  exp: C                       F   E

options
{
	language = Java;
}

// there're symbols (including operations)
NL     : '\n';
WS     : [ \t\r]+ -> skip;
ID     : [a-zA-Z_][a-zA-Z_0-9]*;
NUMBER : '-'?([0-9]+ | [0-9]+'.'[0-9]+); // numbers in the matrix initialization
LCOVER : '(';
RCOVER : ')';
EQUAL  : '=';
SUM    : '+';
MULT   : '*';
RANK   : '^R';
INVER  : '^1';

// firstly, it checks the end of an input
root: 
    input EOF                       #MainRule // #MainRule is a name of the functions in the generated classes in the 'target' folder, that correspond to this rule
    ;

// secondly, it parses input string
input:
    init                            #GoToInitialize // it checks initialization operation in the start (A = ...) (once)
    | rank                          #GoToRank       // it can calculate rank (once)
    ;                                               // cause SUM operation has the lowest priority

// appropriation of the matrix (A = ...)
init: 
    ID EQUAL input                  #Initialize // A =
    ;

// check a rank operation beyond multiplication, inversion and sum    
rank:
    (LCOVER)? sum (RCOVER)?(RANK)?  #RankRule // (sum)^R // !sum^R
    ;

// this class checks every PLUS symbol from the left side to the right one
// A * A "+" A + A * A + A 
//        ^                 firstly, it takes the leftmost symbol
// these's no PLUS symbol in the left side of the entry after that!
// then the program go to MULTIPLICATION operation, that can be interpreted like INVERSION operation
sum:
    mult SUM sum                    #MultSumSumOp
    | mult                          #MultOp     
    ;
    
mult:
    inver MULT mult                 #InverMultMultOp
    | inver                         #InverOp    
    ;

// inversion of the matrix
inver:
    exp (INVER)?                    #Inversion // A^1
    ;

// it's a new matrix or the already initialized matrix
exp: // expression
    matr                            #GoToMatrix
    | ID                            #Variable // already initialized symbol (f.e. A, B, C ... )
    ;

// [[9,0],[8,7]] ?
// initialize a matrix  
matr: 
    '['vect(','vect)*']'            #GoToVect
    ;

// initialize each element in the matrix
vect: 
    '['NUMBER(','NUMBER)*']'        #GoToNumber 
    ;