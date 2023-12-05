package TaxaFixa;
import Ultilitarios.Interface;

public final class Poupança extends RendaFixa  implements Interface{
    private double taxaFixa; // Taxa fixa de CDI para este tipo de investimento.
    
    //Define os atributos iniciais de um objeto Poupança.
    public Poupança(String nome, String cpf, String banco, double capital, double cdi, int meses){
        super(nome, cpf, banco, capital, cdi, meses);
        this.taxaFixa = CalcularTaxa();
    }    

    //Sobrescreve o metodo de calcular a renda com os valores da poupança.
    @Override
    public double calcularResgate(){
        return Math.round(capital * (Math.pow((1 + cdi * (this.taxaFixa /100)) , meses)));
    }

    //Calcula a taxa Selic da poupança.
    private double CalcularTaxa(){
        if ( this.cdi >= 8.5) {
            return 0.005;
        }
        else{
            return 0.7;
        }
    }
    //Imprime os valores usados para calcular a renda.
    @Override
    public String toString() {
        return super.toString();
    }
}