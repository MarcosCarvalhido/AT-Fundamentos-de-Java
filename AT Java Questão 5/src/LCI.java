public class LCI extends RendaFixa {
    
    public LCI(String nome, String cpf, String banco, double capital, double cdi, int meses){
        super(nome, cpf, banco, capital, cdi, meses);
        cdi = 1.0;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
