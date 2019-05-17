package com.olimpiadasDeHistoria.modelo.participante;

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

public class ParticipanteDAO implements IRepositorioParticipante <Participante, String>{
	
	private Participante participante;
	public static final String NOME_TABELA_PARTICITANTES = "participantes";
	private IFactoryObjetoCompleto factoryObjetoCompleto;
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	private int bancoDados = 0;
	
	//Construtor sem argumentos
	public ParticipanteDAO () throws Exception {
	    this.connection = ConexaoBanco.getConexao(BancoDeDados.MYSQL);
	    this.bancoDados = BancoDeDados.MYSQL;
	    factoryObjetoCompleto = new FactoryObjetoCompleto();
	}

	//Construtor com argumentos
	public ParticipanteDAO (int bancoDados) throws Exception {
	    this.connection = ConexaoBanco.getConexao(bancoDados);
	    this.bancoDados = bancoDados;
	    factoryObjetoCompleto = new FactoryObjetoCompleto();
	}

	@Override
	public void cadatrarParticipante(Participante participante) {

		try {
			
			String comandoSQL = "insert into " + NOME_TABELA_PARTICITANTES + 
					" (nome, pontuacao) " +
					"values (?,?)"; 
		
			preparedStatement = connection.prepareStatement(comandoSQL);
			
			preparedStatement.setString(1, participante.getNome());
			preparedStatement.setInt(2, participante.getPontuacao());
			
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
	public void atualizarParticipante(Participante participante, String chave) {
		
		try {
			String comandoSQL = "update " + NOME_TABELA_PARTICITANTES + " set " +
					"pontuacao = ?, " +
					"nome = ? " +
					"where nome = ?" ;
	
			preparedStatement = connection.prepareStatement(comandoSQL);
			
			preparedStatement.setInt(1, participante.getPontuacao());
			preparedStatement.setString(2, participante.getNome());
			preparedStatement.setString(3, chave);
			
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
	public void excluirParticipante(String nome) {
		
		try {
			String comandoSQL = "delete from " + NOME_TABELA_PARTICITANTES + 
					" where nome = ?";
	
			preparedStatement = connection.prepareStatement(comandoSQL);
			
			preparedStatement.setString(1, nome);
			
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
	public List<Participante> listaParticipantes() {

		List<Participante> listaParticipantes = new ArrayList<>();
		
		try {
			String comandoSQL = "select * from " + NOME_TABELA_PARTICITANTES;
			
			preparedStatement = connection.prepareStatement(comandoSQL);
			
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				participante = factoryObjetoCompleto.criarParticipante(resultSet.getString(1), resultSet.getInt(2));
				listaParticipantes.add(participante);
			}
		} catch (SQLException e) {
			return listaParticipantes;
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
		return listaParticipantes;
	}

	@Override
	public boolean isParticipante(String nome) {
		
		boolean existe = false;
		
		try {
			String comandoSQL = "select nome from " + NOME_TABELA_PARTICITANTES +
					" where nome = ?";
			
			preparedStatement = connection.prepareStatement(comandoSQL);
			
			preparedStatement.setString(1, nome);
			
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
	public void pontuar(Participante participante) {
		
		try {
			String comandoSQL = "update " + NOME_TABELA_PARTICITANTES + " set " +
					"pontuacao = ? " +
					"where nome = ?" ;
	
			preparedStatement = connection.prepareStatement(comandoSQL);
			
			preparedStatement.setInt(1, participante.getPontuacao());
			preparedStatement.setString(2, participante.getNome());
			
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
}
