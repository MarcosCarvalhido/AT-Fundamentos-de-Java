import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Livro {
    static Scanner userInput = new Scanner(System.in,"UTF-16");
    protected String titulo;
    protected String editora;
    protected String ano; //Ano modificado para tipo String por motivos esteticos. int print = "2.023" e string print = "2023"
    protected ArrayList<Autor> autores = new ArrayList<Autor>();

    //Define os atributos iniciais de um objeto livro.
    public Livro(String titulo, String editora, String ano){
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
    public String getAno() {
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
    public void setAno(String ano) {
        this.ano = ano;
    }

    //Adciona um autor na lista de autores do livro.
    public void adicionarAutor(Autor autor) {
        this.autores.add(autor);
    }

    //Retorna a ficha catalografica do livro contendo todas as suas informações.
    public String imprimirFichaCatalografica(){
        return MessageFormat.format("{0} {1}. {2}, {3}.",todosOsAutores(),this.titulo,this.editora,this.ano);
    }

    //Retorna a citação bibliografica de todos os autores do livro.
    public String todosOsAutores(){
        String todosOsAutores = "";
        for (Autor autor : autores) {
            todosOsAutores += autor.CitacaoBibliografica();
        }
        return todosOsAutores;
    }

    //Retorna uma lista do nome completo de todos os autores do livro.
    public String listarAutores(){
        String resultado = "";
        for (int index = 0; index < autores.size(); index++) {

            if (index == autores.size() -1) {
                resultado += autores.get(index).getNomeCompleto() + ".";
            }
            else if (index == autores.size() -2) {
                resultado += autores.get(index).getNomeCompleto() + " e ";
            }
            else{
                resultado += autores.get(index).getNomeCompleto() + ", ";
            }
        }
        return resultado;
    }

    //Busca pela ocorrencia de um autor pelo seu nome completo.=.
    private Autor pesquisarAutor(String nomeCompleto){
        Autor autorEncotrado = null;
        for (Autor autor : autores) {
            if(autor.getNomeCompleto().equals(nomeCompleto)){
                autorEncotrado = autor;
            }
        }
        return autorEncotrado;
    }

    //Retorna se um livro possui ou não o autor pesquisado.
    public String buscarAutor(String nomeCompleto){
        Autor autor = pesquisarAutor(nomeCompleto);

        if(autor != null){
            return "Autor encontrado: " + autor.getNomeCompleto();
        }
        else{
            return "Autor não encontrado";
        }
    }

    public String removerAutor(String nomeCompleto){
        Autor autor = pesquisarAutor(nomeCompleto);

        if(autor != null){
            autores.remove(autor);
            return "Autor encontrado removido com sucesso: " + autor.getNomeCompleto();
        }
        else{
            return "Autor não encontrado";
        }   
    }
}
