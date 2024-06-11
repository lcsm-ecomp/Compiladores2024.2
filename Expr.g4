grammar Expr;

program : expr EOF ;

expr : NUM #Const
     | expr MULT expr #Produto
     | expr SUM expr #Soma
     | '(' expr ')' #Grupo 
     ;

NUM : [0-9]+ ;
SUM : '+' ;
MULT : '*' ;
SPACES : (' '|'\n') -> skip ;