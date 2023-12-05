public class Poupança extends RendaFixa {

    public Poupança(String nome, String cpf, String banco, double capital, double cdi, int meses){
        super(nome, cpf, banco, capital, cdi, meses);
    }    

    @Override
    public double calcularResgate(){
        return 666;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
