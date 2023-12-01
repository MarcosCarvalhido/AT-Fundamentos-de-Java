import java.text.MessageFormat;

public class Endereco {
    protected String logradouro;
    protected String numero;
    protected String complemento;
    protected String bairro;
    protected String municipio;
    protected String estado;
    protected String pais;

        //Define os atributos iniciais de um objeto endereço.
    public Endereco(String logradouro, String numero, String complemento 
        ,String bairro ,String municipio, String estado ,String pais){
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.municipio = municipio;
        this.estado = estado;
        this.pais = pais;
    }

    //Acessa o valor das propriedades.
    public String getLogradouro() {
        return logradouro;
    }
    public String getNumero() {
        return numero;
    }
    public String getComplemento() {
        return complemento;
    }
    public String getBairro() {
        return bairro;
    }
    public String getMunicipio() {
        return municipio;
    }
    public String getEstado() {
        return estado;
    }
    public String getPais() {
        return pais;
    }

    //Modifica o valor das propriedades.
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }public void setPais(String pais) {
        this.pais = pais;
    }

    //Gera o endereço por escrito com base nas informações fornecidas.
    public String ImprimirEndereco(){
        return MessageFormat.format("{0}, {1} - {2}, {3}, {4} - {5} - {6}", logradouro, numero, complemento, bairro, municipio, estado, pais);
    }
}
