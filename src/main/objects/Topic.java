package main.objects;
import java.util.List;

public class Topic {
    private List preferenciais;
    private List normais;
    private int capacidade;
    private int qtdPrefenciais;

    public Topic(int capacidade, int qtdPrefenciais){
        this.capacidade = capacidade;
        this.qtdPrefenciais = qtdPrefenciais;
    }

    public boolean subir(Passageiro passageiro){
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
