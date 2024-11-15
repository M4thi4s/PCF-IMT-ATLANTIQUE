grammar PCF;

// syntactic rules

term : LIT                                   # Lit
     | ID                                    # Var
     | term term                             # App
     | term ('*' | '/') term                 # BOp
     | term ('+' | '-') term                 # BOp
     | 'ifz' term 'then' term 'else' term    # IfZ
     | 'let' ID '=' term 'in' term           # Let
     | 'fun' ID '->' term                    # Fun
     | 'fixfun' ID ID '->' term              # FixFun
     | 'fix' ID term                         # Fix
     | '(' term ')'                          # Par
     | '[]'                                  # Nil
     | '[' term (',' term)* ']'              # List
     | <assoc=right> term ':' term           # Cons
     ;

// lexical rules

LIT : '0' | [1-9][0-9]* ;
// rules provided by the ANTLR plugin (Ctlr-J/command-J)
ID : [a-zA-Z_]+ [a-zA-Z0-9_]*;
LINE_COMMENT : '//' ~'\n'* '\n' -> channel(HIDDEN) ;
WS : [ \t\n\r]+ -> channel(HIDDEN) ;


