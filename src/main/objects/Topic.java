package main.objects;
import java.util.List;
import java.util.ArrayList;

public class Topic {
    private List<String> preferenciais;
    private List<String> normais;
    private int capacidade;
    private int qtdPrefenciais;

    public Topic(int capacidade, int qtdPrefenciais){
        preferenciais = new ArrayList<String>();
        normais = new ArrayList<String>();
        this.capacidade = capacidade;
        this.qtdPrefenciais = qtdPrefenciais;
        for(int i = 0; i < capacidade; i++){
            if(qtdPrefenciais > 0){
                preferenciais.add("@");
                qtdPrefenciais--;
            }
            else
                normais.add("=");
        }
    }

    public boolean subir(Passageiro passageiro){
        if(passageiro.isIdoso()){

        }
        return true;
    }

    public boolean descer(String id){
        return true;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "preferenciais=" + preferenciais +
                ", normais=" + normais +
                ", capacidade=" + capacidade +
                ", qtdPrefenciais=" + qtdPrefenciais +
                '}';
    }

    public boolean isTopicCheia(){
        return true;
    }

    public boolean isPassageiroPresente(String id){
        return true;
    }

    public void alocarPresencial(Passageiro passageiro){

    }

    public void alocarNormal(Passageiro passageiro){

    }
}
