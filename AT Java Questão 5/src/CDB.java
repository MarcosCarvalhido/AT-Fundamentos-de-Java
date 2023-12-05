public class CDB extends RendaFixa {
    
    public CDB(String nome, String cpf, String banco, double capital, double cdi, int meses){
        super(nome, cpf, banco, capital, cdi, meses);
        cdi = 1.20;
    }
    @Override
    public String toString() {
        return super.toString();
    }
}
