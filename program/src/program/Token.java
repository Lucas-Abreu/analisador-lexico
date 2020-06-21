package program;

public class Token {
	
	private int codigo;
	private String valor;
	private String descricao;

	
	public Token(String valor, Tipo tipo)
	{
		this.valor = valor;
		this.codigo = tipo.codigo;
		this.descricao = tipo.descricao;
	}


	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
