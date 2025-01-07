package service;

import model.MeioEnvio;

public class EnvioEmail implements MeioEnvio {
    @Override
    public void enviar(String conteudo) {
        System.out.println("Enviando por e-mail: " + conteudo);
    }
}
