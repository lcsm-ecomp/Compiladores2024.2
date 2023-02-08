grammar Expr;

program : expr EOF ;

expr : NUM #Elem
     | expr MULT expr #Produto
     | expr SUM expr #Soma
     | '(' expr ')' #Grupo 
     | VAR #Variavel
     ;
     
VAR : [a-zA-Z][a-zA-Z0-9]* ;     
NUM : [0-9]+ ;
SUM : '+' ;
MULT : '*' ;
SPACES : (' '|'\n') -> skip ;