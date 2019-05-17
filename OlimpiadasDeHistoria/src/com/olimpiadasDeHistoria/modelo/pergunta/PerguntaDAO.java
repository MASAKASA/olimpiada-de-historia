package com.olimpiadasDeHistoria.modelo.pergunta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.olimpiadasDeHistoria.util.BancoDeDados;
import com.olimpiadasDeHistoria.util.ConexaoBanco;
import com.olimpiadasDeHistoria.util.FactoryObjetoCompleto;
import com.olimpiadasDeHistoria.util.IFactoryObjetoCompleto;

public class PerguntaDAO implements IRepositorioPergunta<Pergunta, String, Integer> {

	private Pergunta pergunta;
	public static final String NOME_TABELA_PERGUNTAS = "perguntas";
	private IFactoryObjetoCompleto factoryObjetoCompleto;
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	private int bancoDados = 0;
	
	//Construtor sem argumentos
	public PerguntaDAO () throws Exception {
	    this.connection = ConexaoBanco.getConexao(BancoDeDados.MYSQL);
	    this.bancoDados = BancoDeDados.MYSQL;
	    factoryObjetoCompleto = new FactoryObjetoCompleto();
	}

	//Construtor com argumentos
	public PerguntaDAO (int bancoDados) throws Exception {
	    this.connection = ConexaoBanco.getConexao(bancoDados);
	    this.bancoDados = bancoDados;
	    factoryObjetoCompleto = new FactoryObjetoCompleto();
	}

	@Override
	public void cadastrarPergunta(Pergunta pergunta) {
		
		try {
			
			String comandoSQL = "insert into " + NOME_TABELA_PERGUNTAS + 
					" (enunciado, resposta1, resposta2, resposta3, resposta4, resposta5, respostaCerta) " +
					"values (?,?,?,?,?,?,?)"; 
		
			preparedStatement = connection.prepareStatement(comandoSQL);
			
			preparedStatement.setString(1, pergunta.getEnuciado());
			preparedStatement.setString(2, pergunta.getReposta1());
			preparedStatement.setString(3, pergunta.getReposta2());
			preparedStatement.setString(4, pergunta.getReposta3());
			preparedStatement.setString(5, pergunta.getReposta4());
			preparedStatement.setString(6, pergunta.getReposta5());
			preparedStatement.setString(7, pergunta.getRepostaCerta());
			
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void atualizarPergunta(Pergunta pergunta) {
	
		try {
			String comandoSQL = "update " + NOME_TABELA_PERGUNTAS + " set " +
					"enunciado = ?, " +
					"resposta1 = ?, " +
					"resposta2 = ?, " +
					"resposta3 = ?, " +
					"resposta4 = ?, " +
					"resposta5 = ?, " +
					"respostaCerta = ? " +
					"where codigo = ?" ;
	
			preparedStatement = connection.prepareStatement(comandoSQL);
			
			preparedStatement.setString(1, pergunta.getEnuciado());
			preparedStatement.setString(2, pergunta.getReposta1());
			preparedStatement.setString(3, pergunta.getReposta2());
			preparedStatement.setString(4, pergunta.getReposta3());
			preparedStatement.setString(5, pergunta.getReposta4());
			preparedStatement.setString(6, pergunta.getReposta5());
			preparedStatement.setString(7, pergunta.getRepostaCerta());
			preparedStatement.setInt(8, pergunta.getCodigo());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void excluirPergunta(Integer codigo) {
		
		try {
			String comandoSQL = "delete from " + NOME_TABELA_PERGUNTAS + 
					" where codigo = ?";
	
			preparedStatement = connection.prepareStatement(comandoSQL);
			
			preparedStatement.setInt(1, codigo);
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<Pergunta> perquisarPergunta(String enuciado) {
		
		List<Pergunta> resultadoPesquisa = new ArrayList<>();
		try {
			String comandoSQL = "select * from " + NOME_TABELA_PERGUNTAS +
					" where enunciado like '" + enuciado +"%'" +
					" order by codigo asc";
			
			preparedStatement = connection.prepareStatement(comandoSQL);
			
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				pergunta = factoryObjetoCompleto.criarPergunta(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), 
						resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), 
						resultSet.getString(8));
				resultadoPesquisa.add(pergunta);
			}
		} catch (SQLException e) {
			return resultadoPesquisa; 
		} finally {
			try {
				preparedStatement.close();
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return resultadoPesquisa;
	}
	
	@Override
	public List<Pergunta> listaPerguntas() {
		
		List<Pergunta> lista = new ArrayList<>();
		
		try {
			String comandoSQL = "select * from " + NOME_TABELA_PERGUNTAS;
			
			preparedStatement = connection.prepareStatement(comandoSQL);
			
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				pergunta = factoryObjetoCompleto.criarPergunta(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), 
						resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), 
						resultSet.getString(8));
				lista.add(pergunta);
			}
		} catch (SQLException e) {
			return lista;
		} finally {
			try {
				preparedStatement.close();
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return lista; 
	}

	@Override
	public boolean isEnuciado(String enuciado) {

		boolean existe = false;
		
		try {
			String comandoSQL = "select enunciado from " + NOME_TABELA_PERGUNTAS +
					" where enunciado = ?";
			
			preparedStatement = connection.prepareStatement(comandoSQL);
			
			preparedStatement.setString(1, enuciado);
			
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
				existe = true;
			}
		} catch (SQLException e) {
			return existe;
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return existe;
	}

	@Override
	public boolean isCodigo(Integer codigo) {

		boolean existe = false;
		
		try {
			String comandoSQL = "select codigo from " + NOME_TABELA_PERGUNTAS +
					" where codigo = ?";
			
			preparedStatement = connection.prepareStatement(comandoSQL);
			
			preparedStatement.setInt(1, codigo);
			
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
				existe = true;
			}
		} catch (SQLException e) {
			return existe;
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return existe;
	}
}