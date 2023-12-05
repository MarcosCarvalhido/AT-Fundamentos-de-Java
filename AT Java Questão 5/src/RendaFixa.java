import java.text.MessageFormat;

public abstract class RendaFixa {
    protected String nome; //Nome titular da aplicação.
    protected String cpf; //CPF do titular da aplicação.
    protected String banco; //Banco onde a aplicação vai ser feita

    protected double capital; //Quantidade de capital aplicado.
    protected double cdi; //valor do juros CDI mensal
    protected int meses; //Tempo em meses gasto na aplicação.
    protected double resgate; //Valor que sera resgatado no final da aplicação. Com o IR descontado.

    public RendaFixa(String nome, String cpf, String banco, double capital, double cdi, int meses){
        this.nome = nome;
        this.cpf = cpf;
        this.banco = banco;
        this.capital = capital;
        this.cdi = cdi;
        this.meses = meses;
    }

    public String getNome() {
        return nome;
    }
    public String getCpf() {
        return cpf;
    }
    public String getBanco() {
        return banco;
    }
    public double getCapital() {
        return capital;
    }
    public double getCdi() {
        return cdi;
    }
    public int getMeses() {
        return meses;
    }
    public double getResgate() {
        return resgate;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public void setBanco(String banco) {
        this.banco = banco;
    }
    public void setCapital(double capital) {
        this.capital = capital;
    }
    public void setCdi(double cdi) {
        this.cdi = cdi;
    }
    public void setMeses(int meses) {
        this.meses = meses;
    }
    public void setResgate(double resgate) {
        this.resgate = resgate;
    }

    //Calcula o Resgate final.
    public double calcularResgate(){
        return capital * (Math.pow((1 + cdi), meses));
    }

    @Override
    public String toString() {

        return MessageFormat.format("Nome: {0}, CPF: {1}, Banco: {2}, Capital: {3}, CDI: {4}, Meses{5}", this.nome,this.cpf,this.banco,this.capital,this.cdi,this.meses);
    }
}
