package entidades;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entidades.enums.TrabalhadorNivel;

public class Trabalhador {
	
	private String nome;
	private TrabalhadorNivel nivel;
	private Double baseSalario;
	
	private Departamento departamento;
	
	private List<ContratoHora> contratos = new ArrayList<>();
	
	public Trabalhador() {		
	}

	public Trabalhador(String nome, TrabalhadorNivel nivel, Double baseSalario, Departamento departamento) {
		this.nome = nome;
		this.nivel = nivel;
		this.baseSalario = baseSalario;
		this.departamento = departamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TrabalhadorNivel getNivel() {
		return nivel;
	}

	public void setNivel(TrabalhadorNivel nivel) {
		this.nivel = nivel;
	}

	public Double getBaseSalario() {
		return baseSalario;
	}

	public void setBaseSalario(Double baseSalario) {
		this.baseSalario = baseSalario;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<ContratoHora> getContratos() {
		return contratos;
	}
	
	public void addContrato(ContratoHora contrato) {
		contratos.add(contrato);
	}
	public void removeContrato(ContratoHora contrato) {
		contratos.remove(contrato);
	}
	
	public double renda(int ano, int mes) {
		double soma = baseSalario;
		Calendar cal = Calendar.getInstance();
		for (ContratoHora c : contratos) {
			cal.setTime(c.getData());
			int c_ano = cal.get(Calendar.YEAR);
			int c_mes = 1 + cal.get(Calendar.MONTH);
			if (ano == c_ano && mes == c_mes) {
				soma += c.totalValor();
			}			
		}
		return soma;
	}
}
