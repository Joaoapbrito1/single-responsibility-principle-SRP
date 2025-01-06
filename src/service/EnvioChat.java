package service;

import model.MeioEnvio;

public class EnvioChat implements MeioEnvio {
    @Override
    public void enviar(String conteudo) {
        System.out.println("Enviando por chat: " + conteudo);
    }
}