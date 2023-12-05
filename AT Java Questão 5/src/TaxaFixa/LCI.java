package TaxaFixa;
import Ultilitarios.Interface;

public final class LCI extends RendaFixa implements Interface{
    private double taxaFixa; // Taxa fixa de CDI para este tipo de investimento.

    //Define os atributos iniciais de um objeto LCI.
    public LCI(String nome, String cpf, String banco, double capital, double cdi, int meses){
        super(nome, cpf, banco, capital, cdi, meses);
        this.taxaFixa = 1.0;
    }

    //Sobrescreve o metodo de calcular a renda com os valores da LCI.
    @Override
    public double calcularResgate(){
        return Math.round(capital * (Math.pow((1 + cdi * (this.taxaFixa /100)) , meses)));
    }
    
    //Imprime os valores usados para calcular a renda.
    @Override
    public String toString() {
        return super.toString();
    }
}
