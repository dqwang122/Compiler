grammar MyminiJava;


/* Lexer Rules */
IDENTIFIER  :  [a-zA-Z] [a-zA-Z0-9_]* ;
INTEGER_LITERAL :   [0-9]+  ;
Binary_operators    :   '&&' | '<' | '+' | '-' | '*'    ;
WS  :   [ \t\r\n]+ -> skip  ;

LineComment    :   '//' ~('\r' | '\n')* ->  channel(HIDDEN)  ;
MultiLineComment    :   '/*' (MultiLineComment|.)*? '*/'  -> channel(HIDDEN)    ;



/* Parser Rules */
goal    :   mainClass ( classDeclaration )* EOF;
mainClass   :   'class' identifier '{' 'public' 'static' 'void' 'main' '(' 'String' '[' ']' identifier ')' '{' statement '}' '}';
classDeclaration    :   'class' identifier ( 'extends' identifier )? '{' ( varDeclaration )* ( methodDeclaration )* '}';
varDeclaration  :   type identifier ';';
methodDeclaration   :   'public' type identifier '(' (type identifier ( ',' type identifier )*)? ')' '{' ( varDeclaration )* ( statement )* 'return' expression ';' '}';


type    :   'int' '[' ']'   # arrayType
        |   'boolean'       # booleanType
        |   'int'           # intType
        |   identifier      # idType
        ;

statement   :   '{' ( statement )* '}'                                # blockStat
            |   'if' '(' expression ')' statement 'else' statement      # ifStat
            |   'while' '(' expression ')' statement                    # whileStat
            |   'System.out.println' '(' expression ')' ';'             # printStat
            |   identifier '=' expression ';'                           # assignStat
            |   identifier '[' expression ']' '=' expression ';'        # arrayStat
            ;

expression  :   expression  Binary_operators  expression    # binaryExpr
            |   expression '[' expression ']'               # arrayExpr
            |   expression '.' 'length'                     # exprlen
            |   expression '.' identifier '(' (expression  ( ',' expression )*)? ')'   # callExpr
            |   INTEGER_LITERAL        # numberExpr
            |   'true'                  # trueExpr
            |   'false'                 # falseExpr
            |   identifier              # idExpr
            |   'this'                  # thisExpr
            |   'new' 'int' '[' expression ']'  # newarrayExpr
            |   'new' identifier '(' ')'        # newExpr
            |   '!' expression                  # notExpr
            |   '(' expression ')'              # innerExpr
            ;


identifier  :   IDENTIFIER    ;




