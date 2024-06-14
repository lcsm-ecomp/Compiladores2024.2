grammar Expr;

program : expr EOF ;

expr : n=NUM #Const
     | e=expr MULT d=expr #Produto
     | e=expr SUM d=expr #Soma
     | '(' e=expr ')' #Grupo 
     ;

NUM : [0-9]+ ;
SUM : '+' ;
MULT : '*' ;
SPACES : (' '|'\n') -> skip ;