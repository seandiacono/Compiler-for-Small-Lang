grammar smallLangV2;
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

variabledecl:
	'let' ID ':' (type | auto) '=' expr
	| 'let' ID arrSize ':' (type | auto) ('=' expr)?;

assignment: identifier '=' expr;

printStat: 'print' expr;

ifStat: 'if' '(' expr ')' block ('else' block)?;

forStat:
	'for' '(' (variabledecl)? ';' expr ';' (assignment)? ')' block;

whileStat: 'while' '(' expr ')' block;

returnStat: 'return' expr;

funcDecl:
	'ff' ID '(' (formalParams)? ')' ':' (type | auto) block;

formalParams: formalParam+;

formalParam: identifier ':' type (',')?;

block: '{' (statement+)? '}';

expr: simpleExpr (relOp simpleExpr)?;

simpleExpr: term (addOp term)?;

term: factor (mulOp factor)?;

factor:
	literal
	| identifier
	| funcCall
	| subExpr
	| unary
	| array;

literal: bool | INT | FLOAT | '\'' CHAR '\'';

funcCall: ID '(' (actualParams)? ')';

actualParams: actualParam+;

actualParam: expr (',')?;

array: '{' actualParam+ '}';

subExpr: '(' expr ')';

unary: ('-' | 'not') expr;


identifier: ID (arrSize)?;

arrSize: '[' (expr)? ']';

type: 'int' | 'bool' | 'float' | 'char';
auto: 'auto';

relOp: '<' | '>' | '==' | '<>' | '<=' | '>=';
addOp: '+' | '-' | 'or';
mulOp: '*' | '/' | 'and';
bool: 'true' | 'false';

NEWLINE: [\r\n]+;
INT: [0-9]+;
FLOAT: INT '.' INT;
ID: [_a-zA-Z] | [_a-zA-Z0-9]+;
CHAR: [.];
WS: [ \t\r\n]+ -> skip;