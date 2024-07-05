grammar Imp;

// Análise Sintática
start : com EOF ; 

//Comandos
com : 'print' '(' e=expr ')' ';' #Print
    | v=VAR '=' e=expr ';' #Atrib
    | '{' com* '}' #Block
    | 'if'  '(' e=expr ')' cTrue=com 'else' cFalse=com #If
    | 'while' '(' e=expr ')' cRep=com #While
    | 'int' name=VAR '=' vInic=expr ';' #Dec
    ;
//Expressoes
expr : n=NUM #Const 
    | n=VAR #Var
    | e=expr o=OP d=expr #Op
    | '(' e=expr ')' #Group
    ;
     
// Análise Léxica
OP : '+' | '-' | '*' | '/' | '>' ;
NUM : [0-9]+ ;
VAR : [a-z]+ ;

ESPACOS : (' '|'\n') -> skip ;
