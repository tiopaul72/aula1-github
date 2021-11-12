package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entidades.ContratoHora;
import entidades.Departamento;
import entidades.Trabalhador;
import entidades.enums.TrabalhadorNivel;
public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Nome do Departamento: ");
		String departNome = sc.nextLine();
		System.out.println("Digite os dados do trabalhador:");
		System.out.println("Nome: ");
		String trabNome = sc.nextLine();		
		System.out.println("Nível: ");
		String trabNivel = sc.nextLine();		
		System.out.println("Salário Base: ");
		double baseSalario = sc.nextDouble();
		Trabalhador trabalhador = new Trabalhador(trabNome, TrabalhadorNivel.valueOf(trabNivel), baseSalario, new Departamento(departNome));

		System.out.print("Quantos contratos para esse trabalhador: ");
		int n = sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.println("Dados do contrato #" + i + ": ");
			System.out.print("Data (DD/MM/YYYY): ");
			Date dataContrato = sdf.parse(sc.next());
			System.out.print("Valor por hora: ");
			double valorHora = sc.nextDouble();
			System.out.print("Duração (horas): ");
			int horas = sc.nextInt();
			ContratoHora contrato = new ContratoHora(dataContrato, valorHora, horas);
			trabalhador.addContrato(contrato);			
		}
		
		System.out.println();
		System.out.print("Digite mês e ano para calcular renda: (MM/YYYY): ");
		String mesAno = sc.next();
		int mes = Integer.parseInt(mesAno.substring(0, 2));
		int ano = Integer.parseInt(mesAno.substring(3));
		System.out.println("Nome: " + trabalhador.getNome());
		System.out.println("Departamento: " + trabalhador.getDepartamento().getNome());
		System.out.println("Renda de " + mesAno + ": " + String.format("%.2f", trabalhador.renda(ano, mes)));
			
		sc.close();
	}

}
