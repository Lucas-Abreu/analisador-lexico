package app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import program.Tipo;
import program.Token;

public class MainController {
	

	private final Map<String, Tipo> PALAVRAS_RESERVADAS = new HashMap<String, Tipo>();
	// private final ArrayList<String> PALAVRAS_RESERVADAS = new ArrayList<String>();
	
	private final Map<String, Tipo> CARACTERES_ESPECIAIS = new HashMap<String, Tipo>();
	// private final ArrayList<String> CARACTERES_ESPECIAIS = new ArrayList<String>();
	
	private final Map<String, Tipo> OPERADORES = new HashMap<String, Tipo>();
	// private final ArrayList<String> OPERADORES = new ArrayList<String>();
	
	private final Map<String, Tipo> OUTROS = new HashMap<String, Tipo>();
	
	private final ArrayList<Token> resultado = new ArrayList<Token>();
	
	@FXML
	TextArea codigo;
	
	public void inicia()
	{
		carregaTabelaDados();
		
		String codigoFinalizado = codigo.getText() + "$";
		String [] caracteres = codigoFinalizado.split("");
		String atual = "";
		
		for (int i = 0; i < caracteres.length; i++)
		{
			if (caracteres[i].equalsIgnoreCase(" ") || checkCaracterEspecial(caracteres[i]) || checkOperador(caracteres[i]) || caracteres[i].equalsIgnoreCase("$"))
			{ 

				if (!caracteres[i].equalsIgnoreCase(""))
				{
					
					String check = atual.toUpperCase();
					check = check.trim();
					
					if (caracteres[i].equalsIgnoreCase(">")
							|| caracteres[i].equalsIgnoreCase("<")
							|| caracteres[i].equalsIgnoreCase(".")
							|| caracteres[i].equalsIgnoreCase(":"))
					{
						atual = caracteres[i] + caracteres[i + 1];
					}

					if (checkOutros(atual))
					{
						Token token = new Token(atual, OUTROS.get(atual)); 
						resultado.add(token);
						atual = "";
						i = i +2;
					}
					
					if (!atual.equalsIgnoreCase(""))
					{
						if (checkPalavra(check))
						{
							Token token = new Token(atual, PALAVRAS_RESERVADAS.get(check)); 
							resultado.add(token);
							atual = "";
						} 
						else 
						{
							Token token = new Token(atual, Tipo.IDENTIFICADOR); 
							resultado.add(token);
							atual = "";
						}
					}

					if (checkCaracterEspecial(caracteres[i]))
					{
						Token token = new Token(caracteres[i], CARACTERES_ESPECIAIS.get(caracteres[i])); 
						resultado.add(token);
					}
					
					if (checkOperador(caracteres[i]))
					{
						Token token = new Token(caracteres[i], OPERADORES.get(caracteres[i])); 
						resultado.add(token);
					}
				}
			}
			else
			{
				if (!caracteres[i].equalsIgnoreCase("$"))
				{
					atual += caracteres[i];
				}
			}
			
		}
		
		for (int i = 0; i < resultado.size(); i ++)
		{
			System.out.println(resultado.get(i).getValor() + " - " + resultado.get(i).getDescricao());
		}

		resultado.clear();
		
	}
	
	public boolean checkCaracterEspecial(String caracter)
	{
		for (int i = 0; i < CARACTERES_ESPECIAIS.size(); i++)
		{
			if (CARACTERES_ESPECIAIS.get(caracter) != null)
			{
				return true;
			}
		}
		return false;
	}
	
	public boolean checkOperador(String caracter)
	{
		for (int i = 0; i < OPERADORES.size(); i++)
		{
			if (OPERADORES.get(caracter) != null)
			{
				return true;
			}
		}
		return false;
	}
	
	public boolean checkPalavra(String atual)
	{
		for (int i = 0; i < PALAVRAS_RESERVADAS.size(); i++)
		{
			if (PALAVRAS_RESERVADAS.get(atual) != null)
			{
				return true;
			}
		}
		return false;
	}
	
	public boolean checkOutros(String atual)
	{
		for (int i = 0; i < OUTROS.size(); i++)
		{
			if (OUTROS.get(atual) != null)
			{
				return true;
			}
		}
		return false;
	}
	
	public void carregaTabelaDados()
	{
		
		PALAVRAS_RESERVADAS.put("PROGRAM", Tipo.PROGRAM); //1
		PALAVRAS_RESERVADAS.put("LABEL",   Tipo.LABEL); // 2
		PALAVRAS_RESERVADAS.put("CONST",   Tipo.CONST); // 3
		PALAVRAS_RESERVADAS.put("VAR", 	   Tipo.VAR); // 4
		PALAVRAS_RESERVADAS.put("PROCEDURE", Tipo.PROCEDURE); // 5
		PALAVRAS_RESERVADAS.put("BEGIN", Tipo.BEGIN); // 6
		PALAVRAS_RESERVADAS.put("END", Tipo.END); // 7 
		PALAVRAS_RESERVADAS.put("INTEIRO", Tipo.INTEIRO); // 8
		PALAVRAS_RESERVADAS.put("ARRAY", Tipo.ARRAY); // 9
		PALAVRAS_RESERVADAS.put("OF", Tipo.OF); // 10
		PALAVRAS_RESERVADAS.put("CALL", Tipo.CALL); // 11
		PALAVRAS_RESERVADAS.put("GOTO", Tipo.GOTO); // 12
		PALAVRAS_RESERVADAS.put("IF", Tipo.IF); // 13
		PALAVRAS_RESERVADAS.put("THEN", Tipo.THEN); // 14
		PALAVRAS_RESERVADAS.put("ELSE", Tipo.ELSE); // 15
		PALAVRAS_RESERVADAS.put("WHILE", Tipo.WHILE); // 16
		PALAVRAS_RESERVADAS.put("DO", Tipo.DO); // 17
		PALAVRAS_RESERVADAS.put("REPEAT", Tipo.REPEAT); // 18
		PALAVRAS_RESERVADAS.put("UNTIL", Tipo.UNTIL); // 19
		PALAVRAS_RESERVADAS.put("READLN", Tipo.READLN); // 20
		PALAVRAS_RESERVADAS.put("WRITELN", Tipo.WRITELN); // 21
		

		PALAVRAS_RESERVADAS.put("OR", Tipo.OR); // 22
		PALAVRAS_RESERVADAS.put("AND", Tipo.AND); // 23
		PALAVRAS_RESERVADAS.put("NOT", Tipo.NOT); // 24
		
		
		PALAVRAS_RESERVADAS.put("FOR", Tipo.FOR); // 27
		PALAVRAS_RESERVADAS.put("TO", Tipo.TO); // 28
		PALAVRAS_RESERVADAS.put("CASE", Tipo.CASE); // 29
		
		
		OPERADORES.put("+", Tipo.ADICAO); // 30
		OPERADORES.put("-", Tipo.SUBTRACAO); // 31
		OPERADORES.put("*", Tipo.MULTIPLICACAO); // 32
		OPERADORES.put("/", Tipo.DIVISAO); // 33
		
		CARACTERES_ESPECIAIS.put("[", Tipo.ABRE_COLCH); // 34
		CARACTERES_ESPECIAIS.put("]", Tipo.FECHA_COLCH); // 35
		CARACTERES_ESPECIAIS.put("(", Tipo.ABRE_PAR); // 36
		CARACTERES_ESPECIAIS.put(")", Tipo.FECHA_PAR); // 37
		
		OUTROS.put(":=", Tipo.ATRIBUICAO); // 38
		
		CARACTERES_ESPECIAIS.put(":", Tipo.DOIS_PONTOS); // 39

		OPERADORES.put("=", Tipo.IGUALIDADE); // 40
		
		OPERADORES.put(">", Tipo.MAIOR); // 41
		
		OUTROS.put(">=", Tipo.MAIOR_IGUAL);  // 42
		
		OPERADORES.put("<", Tipo.MENOR); // 43
		
		OUTROS.put("<=", Tipo.MENOR_IGUAL); // 44

		OUTROS.put("<>", Tipo.EQUIVALENTE); // 45
		
		CARACTERES_ESPECIAIS.put(",", Tipo.VIRGULA); // 46
		
		CARACTERES_ESPECIAIS.put(";", Tipo.PONTO_VIRGULA); // 47
		
		CARACTERES_ESPECIAIS.put(".", Tipo.PONTO); // 49

		OUTROS.put("..", Tipo.PONTO_PONTO); // 50
	}
    	
}
