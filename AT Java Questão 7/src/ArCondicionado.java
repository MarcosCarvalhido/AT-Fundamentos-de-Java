
public class ArCondicionado  {
    protected double temperatura;
    protected double incrimento;
    protected double maximo;
    protected double minimo;

    //Define o valor inicial dos atributos de um objeto Arcondicionado.
    public ArCondicionado(double maximo, double minimo){

        this.maximo = maximo;
        this.maximo = minimo;
        this.temperatura = 25.0;
        this.incrimento = 5.0;
    }
    
    //Acessa o valor das propriedades.
    public double getTemperatura() {
        return temperatura;
    }
    public double getMaximo() {
        return maximo;
    }
    public double getMinimo() {
        return minimo;
    }
    public double getIncrimento() {
        return incrimento;
    }

    //Aumenta o valor da temperatura, sem passar do limite maximo.
    public void aumentarTemperatura(){
        double novaTemperatura = this.temperatura += this.incrimento; 
        if (novaTemperatura > this.maximo) {
            this.temperatura = this.maximo;
        }
        else{
            this.temperatura = novaTemperatura;
        }
    }

    //Diminui o valor da temperatura, sem passar do limite minimo.
    public void diminuirTemperatura(){
        double novaTemperatura = this.temperatura += this.incrimento; 
        if (novaTemperatura < this.minimo) {
            this.temperatura = this.minimo;
        }
        else{
            this.temperatura = novaTemperatura;
        }
    }

    //Define o valor da propriedade incremento.
    public void setIncrimento(double incrimento) {
        this.incrimento = incrimento;
    }
    
    @Override
    public String toString() {

        return "Temperatura atual: " + this.temperatura + ", Temperatura Maxima: " + this.maximo + ", Temperatura Minima: " + ", Incremento de Temperatura: " + this.incrimento;
    }
}