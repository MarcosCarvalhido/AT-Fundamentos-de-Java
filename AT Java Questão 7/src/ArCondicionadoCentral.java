public class ArCondicionadoCentral {
    protected ArCondicionado maquina1;
    protected ArCondicionado maquina2;
    protected ArCondicionado maquina3;

      //Define o valor inicial dos atributos de um objeto Arcondicionado Central.
    public ArCondicionadoCentral(ArCondicionado maquina1, ArCondicionado maquina2, ArCondicionado maquina3){
        this.maquina1 = maquina1;
        this.maquina2 = maquina2;
        this.maquina3 = maquina3;
    }

    //Define o objeto dos arcondicionados
    public void setMaquina1(ArCondicionado maquina1) {
        this.maquina1 = maquina1;
    }
    public void setMaquina2(ArCondicionado maquina2) {
        this.maquina2 = maquina2;
    }
    public void setMaquina3(ArCondicionado maquina3) {
        this.maquina3 = maquina3;
    }

    //Mostra o status te uma maquina.
    public String verMaquina(ArCondicionado maquina){
        return maquina.toString();
    }

    //Mostra a temperatura media entre todas as maquinas.
    public double temperaturaMedia(){
        return ((maquina1.getTemperatura() + maquina2.getTemperatura() + maquina3.getTemperatura()) / 3);
    }
}
