package projeto.model;

import javax.swing.JOptionPane;
import java.util.Date;

public class Curso {

	protected int codigoCurso;
	protected String nomeCurso;
	protected String horarioPrevisto;
	protected Date dataInicio, dataTermino;
	protected int numeroVagas;
	protected double valorCurso;
	
	public Curso() {}
	
	/* GETTERS */
	public int getCodigoCurso() {
		return codigoCurso;
	}
	public String getNomeCurso() {
		return nomeCurso;
	}
	public String getHorarioPrevisto() {
		return horarioPrevisto;
	}
	public Date getDataInicio() {
		return dataInicio;
	}
	public Date getDataTermino() {
		return dataTermino;
	}
	public int getNumeroVagas() {
		return numeroVagas;
	}
	public double getValorCurso() {
		return valorCurso;
	}
	
	/* SETTERS */
	public void setCodigoCurso(int codigoCurso) {
		this.codigoCurso = codigoCurso;
	}
	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}
	public void setHorarioPrevisto(String horarioPrevisto) {
		this.horarioPrevisto = horarioPrevisto;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	public void setDataTermino(Date dataTermino) {
		this.dataTermino = dataTermino;
	}
	public void setNumeroVagas(int numeroVagas) {
		this.numeroVagas = numeroVagas;
	}
	public void setValorCurso(double valorCurso) {
		this.valorCurso = valorCurso;
	}
	
	/* C.R.U.D */
	public void incluir(int codCurso, String nomeCurso, Date dataInicio, Date dataTermino, String horario, int numeroVagas, double valor){
		Curso curso = new Curso();
		
		curso.setCodigoCurso(codCurso);
		curso.setNomeCurso(nomeCurso);
		curso.setDataInicio(dataInicio);
		curso.setDataTermino(dataTermino);
		curso.setHorarioPrevisto(horario);
		curso.setNumeroVagas(numeroVagas);
		curso.setValorCurso(valor);
		
		CursoDAO bd = new CursoDAO();
		
		if(bd.incluir(curso)) {
			JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!");
		}
	}
	public void alterar() {
		
	}
	public void excluir() {
		
	}
	public void consultar() {
		
	}
	
	public void consultarCursosDisponiveis() {
			
	}
	
}// fim da classe