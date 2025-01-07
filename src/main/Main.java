package main;

import model.EnviaRelatorio;
import model.MeioEnvio;
import service.EnvioChat;
import service.EnvioEmail;
import service.GeradorRelatorio;

public class Main {
    public static void main(String[] args) {

        GeradorRelatorio geradorRelatorio = new GeradorRelatorio();
        String conteudoRelatorio = geradorRelatorio.gerarRelatorio();

        MeioEnvio envioEmail = new EnvioEmail();
        EnviaRelatorio enviaRelatorio = new EnviaRelatorio(envioEmail);
        enviaRelatorio.enviarRelatorio(conteudoRelatorio);

        MeioEnvio envioChat = new EnvioChat();
        EnviaRelatorio enviaRelatorioChat = new EnviaRelatorio(envioChat);
        enviaRelatorioChat.enviarRelatorio(conteudoRelatorio);
    }
}