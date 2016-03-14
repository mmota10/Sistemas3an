package projeto.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CursoDAO {

	private Connection conexao;

	public CursoDAO() {
		this.conexao = new Conexao().getConnection();
	}

	public boolean incluir(CursoTO curso) {
		boolean ok = false;
		String sql = "insert into curso " + "(idCurso, nome, dataInicio, dataTermino, horario, numeroVagas, valor)"
				+ " values (?,?,?,?,?,?)";

		try {
			// prepared statement para inserção
			PreparedStatement stmt = conexao.prepareStatement(sql);

			// seta os valores

			Date dataInicioSQL = new Date(curso.getDataInicio().getTime());
			Date dataTerminoSQL = new Date(curso.getDataTermino().getTime());

			stmt.setInt(1, curso.getCodigoCurso());
			stmt.setString(2, curso.getNomeCurso());
			stmt.setDate(3, dataInicioSQL);
			stmt.setDate(4, dataTerminoSQL);
			stmt.setString(5, curso.getHorarioPrevisto());
			stmt.setInt(6, curso.getNumeroVagas());
			stmt.setDouble(7, curso.getValorCurso());

			// executa
			stmt.executeUpdate();
			stmt.close();
			
			ok = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ok;
	}

	/*
	 * public boolean alterar() {
	 * 
	 * }
	 * 
	 * public boolean consultar() {
	 * 
	 * }
	 * 
	 * public boolean excluir() {
	 * 
	 * }
	 */

}// fim da classe