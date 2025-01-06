package main;

import model.EnviaRelatorio;
import service.GeradorRelatorio;

public class Main {
    public static void main(String[] args) {
        // Gerando o relatório
        GeradorRelatorio geradorRelatorio = new GeradorRelatorio();
        geradorRelatorio.gerarRelatorio();

        // Enviando o relatório por e-mail
        EnviaRelatorio enviaRelatorio = new EnviaRelatorio();
        enviaRelatorio.enviarPorEmail();
    }
}