grammar SmallLangV1;
prog: statement+;
statement:
	variabledecl ';' (NEWLINE)?
	| assignment ';' (NEWLINE)?
	| printStat ';' (NEWLINE)?
	| ifStat (NEWLINE)?
	| forStat (NEWLINE)?
	| whileStat (NEWLINE)?
	| returnStat ';' (NEWLINE)?
	| funcDecl (NEWLINE)?;

variabledecl: 'let' ID ':' (type | auto) '=' expr;

assignment: ID '=' expr;

printStat: 'print' expr;

ifStat: 'if' '(' expr ')' block ('else' block)?;

forStat:
	'for' '(' (variabledecl)? ';' expr ';' (assignment)? ')' block;

whileStat: 'while' '(' expr ')' block;

returnStat: 'return' expr;

funcDecl:
	'ff' ID '(' (formalParams)? ')' ':' (type | auto) block;

formalParams: formalParam+;

formalParam: ID ':' type (',')?;

block: '{' (statement+)? '}';

expr: simpleExpr (relOp simpleExpr)?;

simpleExpr: term (addOp term)?;

term: factor (mulOp factor)?;

factor: literal | ID | funcCall | subExpr | unary;

literal: bool | INT | FLOAT;

funcCall: ID '(' (actualParams)? ')';

actualParams: actualParam+;

actualParam: expr (',')?;

subExpr: '(' expr ')';

unary: unaryOp expr;

unaryOp: ('-' | 'not');

type: 'int' | 'bool' | 'float';
auto: 'auto';

relOp: '<' | '>' | '==' | '<>' | '<=' | '>=';
addOp: '+' | '-' | 'or';
mulOp: '*' | '/' | 'and';
bool: 'true' | 'false';

NEWLINE: [\r\n]+;
INT: [0-9]+;
FLOAT: INT '.' INT;
ID: [a-zA-Z]+;
WS: [ \t\r\n]+ -> skip;