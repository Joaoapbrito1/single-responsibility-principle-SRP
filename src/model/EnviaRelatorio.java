package model;

public class EnviaRelatorio {
    private MeioEnvio meioEnvio;

    // O meio de envio é injetado via construtor
    public EnviaRelatorio(MeioEnvio meioEnvio) {
        this.meioEnvio = meioEnvio;
    }

    public void enviarRelatorio(String conteudo) {
        meioEnvio.enviar(conteudo);
    }
}