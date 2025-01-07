package model;

public class EnviaRelatorio {
    private MeioEnvio meioEnvio;

    public EnviaRelatorio(MeioEnvio meioEnvio) {
        this.meioEnvio = meioEnvio;
    }

    public void enviarRelatorio(String conteudo) {
        meioEnvio.enviar(conteudo);
    }
}