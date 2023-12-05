public class CDB extends RendaFixa {
    //Define os atributos iniciais de um objeto CDB.
    public CDB(String nome, String cpf, String banco, double capital, double cdi, int meses){
        super(nome, cpf, banco, capital, cdi, meses);
        cdi = 1.20;
    }
    
    //Sobrescreve o metodo de calcular a renda com os valores da CDB.
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
