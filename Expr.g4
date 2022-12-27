grammar Expr;

program : expr EOF ;

expr : elem #Term
     | expr SUM expr #Soma 
     | expr MULT expr #Mult
     ;
     
elem : NUM
     | '(' expr ')';
     
     
     
NUM : [0-9]+ ;
SUM : '+' ;
MULT : '*' ;

SPACES : (' '|'\n') -> skip ;