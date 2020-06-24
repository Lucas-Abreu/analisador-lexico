package program;

public enum Tipo {
	
	PROGRAM(1,  	  "Palavra reservada"),
	LABEL(2,		  "Palavra reservada"),
	CONST(3, 		  "Palavra reservada"),
	VAR(4, 			  "Palavra reservada"),
	PROCEDURE(5,	  "Palavra reservada"),
	BEGIN(6,   	      "Palavra reservada"),
	END(7,       	  "Palavra reservada"),
	INTEGER(8,  	  "Palavra reservada"),
	ARRAY(9,    	  "Palavra reservada"),
	OF(10,      	  "Palavra reservada"),
	CALL(11,    	  "Palavra reservada"),
	GOTO(12,    	  "Palavra reservada"),
	IF(13,      	  "Palavra reservada"),
	THEN(14,     	  "Palavra reservada"),
	ELSE(15,     	  "Palavra reservada"),
	WHILE(16,    	  "Palavra reservada"),
	DO(17, 	    	  "Palavra reservada"),
	REPEAT(18,  	  "Palavra reservada"),
	UNTIL(19,         "Palavra reservada"),
	READLN(20,  	  "Palavra reservada"),
	WRITELN(21, 	  "Palavra reservada"),
	OR(22,       	  "Operador Lógico"),
	AND(23, 	 	  "Operador Lógico"),
	NOT(24,			  "Operador de Negação"),
	IDENTIFICADOR(25, "Identificador"),
	INTEIRO(26,       "Número inteiro"),
	FOR(27,			  "Palavra reservada"),
	TO(28,       	  "Palavra reservada"),
	CASE(29,     	  "Palavra reservada"),
	ADICAO(30, 	 	  "Operador de Adição"),
	SUBTRACAO(31,	  "Operador de Subtração"),
	MULTIPLICACAO(32, "Operador de Multiplicação"),
	DIVISAO(33,		  "Operador de Divisão"),
	ABRE_COLCH(34,    "Caractere especial - Abre colchete"),
	FECHA_COLCH(35,   "Caractere especial - Fecha colchete"),
	ABRE_PAR(36,	  "Caractere especial - Abre parenteses"),
	FECHA_PAR(37, 	  "Caractere especial - Fecha parenteses"),
	ATRIBUICAO(38, 	  "Operador de Atribuição"),
	DOIS_PONTOS(39,   "Caractere especial - Dois pontos"),
	IGUALIDADE(40,	  "Operador relacional - Igualdade"),
	MAIOR(41, 		  "Operador relacional - Maior"),
	MAIOR_IGUAL(42,   "Operador relacional - Maior igual"),
	MENOR(43,		  "Operador relacional - Menor"),
	MENOR_IGUAL(44,   "Operador relacional - Menor igual"),
	DIFERENTE(45,	  "Operador relacional - Diferente"),
	VIRGULA(46, 	  "Caractere especial - Vírgula"),
	PONTO_VIRGULA(47, "Caractere especial - Ponto e vírgula"),
	LITERAL(48, 	  "Literal"),
	PONTO(49, 		  "Caractere especial - Ponto"),
	PONTO_PONTO(50,   "Caractere especial - Ponto e ponto"),
	FINAL(51, 		  "Caractere especial - Delimitador Final");

	int codigo;
	String descricao;
	
	Tipo(int codigo, String descricao)
	{
		this.codigo    = codigo;
		this.descricao = descricao;
	}
}
