public class LCA extends RendaFixa {
    
    public LCA(String nome, String cpf, String banco, double capital, double cdi, int meses){
        super(nome, cpf, banco, capital, cdi, meses);
        cdi = 1.05;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
