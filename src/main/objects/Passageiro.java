package main.objects;

public class Passageiro {
    private String id;
    private int idade;

    public Passageiro(String id, int idade){
        this.id = id;
        this.idade = idade;
    }

    public String getId(){
        return id;
    }

    public int getIdade(){
        return idade;
    }

    public boolean isIdoso(){
        return idade >= 65;
    }

    @Override
    public String toString() {
        return "Passageiro{" +
                "id='" + id + '\'' +
                ", idade=" + idade +
                '}';
    }
}
