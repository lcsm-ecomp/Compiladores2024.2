grammar Imp;
// Análise Léxica
OP : '+' | '-' | '*' | '/' | '^' ;
NUM : [0-9]+ ;
VAR : [a-z]+ ;

BLABLABLA : (' '|'\n') -> skip ;

// Análise Sintática
start : com EOF ; 

//Comandos
com : 'print' '(' e=expr ')' ';' #Print
    | v=VAR '=' e=expr ';' #Atrib
    | '{' com* '}' #Block
    ;
//Expressoes
expr : n=NUM #Const | n=VAR #Var
     | e=expr o=OP d=expr #Op
     | '(' e=expr ')' #Group
     ;
     
