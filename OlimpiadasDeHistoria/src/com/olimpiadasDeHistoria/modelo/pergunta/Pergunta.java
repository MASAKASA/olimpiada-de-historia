package com.olimpiadasDeHistoria.modelo.pergunta;

public class Pergunta {

	private int codigo;
	private String enuciado;
	private String reposta1;
	private String reposta2;
	private String reposta3;
	private String reposta4;
	private String reposta5;
	private String repostaCerta;
	
	//Contrutor defult
	public Pergunta() {
		
	}

	//Contrutor sem o atributo codigo
	public Pergunta(String enuciado, String reposta1, String reposta2, String reposta3, String reposta4,
			String reposta5, String repostaCerta) {
		this.enuciado = enuciado;
		this.reposta1 = reposta1;
		this.reposta2 = reposta2;
		this.reposta3 = reposta3;
		this.reposta4 = reposta4;
		this.reposta5 = reposta5;
		this.repostaCerta = repostaCerta;
	}

	//construtor com todos atributos
	public Pergunta(int codigo, String enuciado, String reposta1, String reposta2, String reposta3, String reposta4,
			String reposta5, String repostaCerta) {
		this.codigo = codigo;
		this.enuciado = enuciado;
		this.reposta1 = reposta1;
		this.reposta2 = reposta2;
		this.reposta3 = reposta3;
		this.reposta4 = reposta4;
		this.reposta5 = reposta5;
		this.repostaCerta = repostaCerta;
	}

	//Gets e sets
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getEnuciado() {
		return enuciado;
	}

	public void setEnuciado(String enuciado) {
		this.enuciado = enuciado;
	}

	public String getReposta1() {
		return reposta1;
	}

	public void setReposta1(String reposta1) {
		this.reposta1 = reposta1;
	}

	public String getReposta2() {
		return reposta2;
	}

	public void setReposta2(String reposta2) {
		this.reposta2 = reposta2;
	}

	public String getReposta3() {
		return reposta3;
	}

	public void setReposta3(String reposta3) {
		this.reposta3 = reposta3;
	}

	public String getReposta4() {
		return reposta4;
	}

	public void setReposta4(String reposta4) {
		this.reposta4 = reposta4;
	}

	public String getReposta5() {
		return reposta5;
	}

	public void setReposta5(String reposta5) {
		this.reposta5 = reposta5;
	}

	public String getRepostaCerta() {
		return repostaCerta;
	}

	public void setRepostaCerta(String repostaCerta) {
		this.repostaCerta = repostaCerta;
	}
}
