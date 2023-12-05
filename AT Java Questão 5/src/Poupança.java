public class Poupança extends RendaFixa {
    //Define os atributos iniciais de um objeto Poupança.
    public Poupança(String nome, String cpf, String banco, double capital, double cdi, int meses){
        super(nome, cpf, banco, capital, cdi, meses);
    }    

    //Sobrescreve o metodo de calcular a renda com os valores da poupança.
    @Override
    public double calcularResgate(){
        return 666;
    }

    //Imprime os valores usados para calcular a renda.
    @Override
    public String toString() {
        return super.toString();
    }
}
