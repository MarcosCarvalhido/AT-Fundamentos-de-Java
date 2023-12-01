import java.text.MessageFormat;

public class Pessoa {
    protected String nome;
    protected String sobrenome;
    protected double peso;
    protected int idade;
    protected Endereco endereco;

    //Define os atributos iniciais de um objeto pessoa.
    public Pessoa(String nome, double peso,int idade){
        this.nome = nome;
        this.peso = peso;
        this.idade = idade;
    }
    public Pessoa(String nome, String sobrenome, Endereco endereco){
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.endereco = endereco;
    }
    public Pessoa() {}

    //Acessa o valor das propriedades.
    public String getNome() {
        return nome;
    }
    public double getPeso() {
        return peso;
    }
    public int getIdade() {
        return idade;
    }
    public String getSobrenome() {
        return sobrenome;
    }

    //Modifica o valor das propriedades.
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    //Determina se uma pessoa pode doar sangue.
    public boolean DoadorDeSangue(){
        if ((this.idade >= 18) && (this.idade <= 69) && (this.peso >= 50)) { 
            return true;
        }
        else{
            return false;
        }
    }

    //Combina o nome e sobrenome, retornando o nome completo da pessoa.
    public String NomeCompleto(){
        return MessageFormat.format("{0} {1}",this.nome, this.sobrenome);
    }

    //Gera as inicias da pessoa com base no nome e sobrenome fornecidos.
    public String Iniciais(){
        char nomeLetra = this.nome.charAt(0);
        char sobrenomeLetra = this.sobrenome.charAt(0);
        Character.toUpperCase(nomeLetra);
        Character.toUpperCase(sobrenomeLetra);
        
        return MessageFormat.format("{0}.{1}.", Character.toString(nomeLetra), Character.toString(sobrenomeLetra));
    }

    //Combiba o nome completo e o endereço, retornando o endereço completo da pessoa.
    public String Destinatario(){
        return MessageFormat.format("{0}. {1}", NomeCompleto(), this.endereco.ImprimirEndereco());
    }
}