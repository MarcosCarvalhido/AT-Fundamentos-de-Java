import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Livro {
    protected String titulo;
    protected String editora;
    protected int ano;
    protected ArrayList<Autor> autores;

    //Define os atributos iniciais de um objeto livro.
    public Livro(String titulo, String editora, int ano){
        this.titulo = titulo;
        this.editora = editora;
        this.ano = ano;
    }

    //Acessa o valor das propriedades.
    public String getTitulo() {
        return titulo;
    }
    public String getEditora() {
        return editora;
    }
    public int getAno() {
        return ano;
    }
    public ArrayList<Autor> getAutores() {
        return autores;
    }

    //Modifica o valor das propriedades.
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void setEditora(String editora) {
        this.editora = editora;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }

    //Adciona um autor na lista de autores do livro.
    public void adicionarAutor(Autor autor) {
        this.autores.add(autor);
    }

    public String imprimirFichaCatalografica(){
        return MessageFormat.format(editora, null);
    }

    public void NomeDoAutor(){
        // String resultado;
        // String nome;
        String sobrenomes;
        // String portaSobrenomes [] = new String[5];
        // ArrayList<String> portaNomes2 = new ArrayList<String>();

        for (Autor autor : this.autores) {
            sobrenomes = autor.getSobrenome();
            // portaSobrenomes = nome.split(" ");
            List<String> items = Arrays.asList(sobrenomes.split(" "));
            sobrenomes = items.get(items.size() -1);
            System.out.println(sobrenomes);
        }
    }
}
