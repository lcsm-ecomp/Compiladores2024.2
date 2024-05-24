grammar SimpleC;

// Análise Sintática
start : com+ EOF ; 

//Comandos
com : 'print' '(' expr ')' ';'
    | VAR '=' expr ';'
    | 'if' '(' expr ')' com ('elif' '(' expr ')' com)* ('else' com)?
    ;
//Expressoes
expr : NUM | VAR
     | expr OP3 expr
     | expr OP2 expr 
     | expr OP1 expr
     | '(' expr ')'
     ;
     
// Análise Léxica
OP1 : '+' | '-' ;
OP2 : '*' | '/' ;
OP3 : '^' ;
NUM : [0-9]+ ;
VAR : [a-z]+ ;
BLABLABLA : (' '|'\n') -> skip ; 
