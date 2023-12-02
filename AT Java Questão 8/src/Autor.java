import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Autor {
    protected String nome;
    protected String sobrenome;

    //Define os atributos iniciais de um objeto autor.
    public Autor(String nome, String sobrenome){
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    //Acessa o valor das propriedades.
    public String getNome() {
        return nome;
    }
    public String getSobrenome() {
        return sobrenome;
    }

    //Modifica o valor das propriedades.
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    //Retorna o nome completo do autor, com nome e sobrenome.
    public String getNomeCompleto(){
        return this.nome + " " + this.sobrenome;
    }

    //Retorna a inicial do nome do autor
    public String inicial(){
        return Character.toString(getNome().charAt(0));
    }

    //Retorna o ultimo sobrenome do Autor.
    public String ultimoSobreNome(){
        List<String> separados = Arrays.asList(getSobrenome().split(" "));
        return (separados.get(separados.size() -1));
    }

    //Retorna o nome do autor na forma de citação bibliografica.
    public String CitacaoBibliografica(){
        return MessageFormat.format("{0}, {1}. ",ultimoSobreNome().toUpperCase(),inicial().toUpperCase());
    }
}
