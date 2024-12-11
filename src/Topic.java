import java.util.Arrays;

public class Topic {
    private String[] preferenciais;
    private String[] normais;
    private int capacidade;
    private int qtdPreferenciais;
    private int qtdNormais;

    public Topic(int capacidade, int qtdPreferenciais) {
        this.capacidade = capacidade;
        this.qtdPreferenciais = qtdPreferenciais;
        qtdNormais = capacidade-qtdPreferenciais;
        preferenciais = new String[qtdPreferenciais];
        normais = new String[qtdNormais];
        inicializarAssentosPreferenciais(qtdPreferenciais);
        inicializarAssentosNormais(qtdNormais);
    }

    private void inicializarAssentosNormais(int capacidade){
        for(int i = 0; i < capacidade; i++)
            normais[i] = "=";
    }

    private void inicializarAssentosPreferenciais(int capacidade){
        for(int i = 0; i < capacidade; i++)
            preferenciais[i] = "@";
    }

    public Passageiro getPassageiroAssentoNormal(int lugar) {
        if(lugar < qtdNormais){
            if(!normais[lugar].endsWith("=")) {
                String[] passageiroString = normais[lugar].split("[=:]");
                return new Passageiro(passageiroString[1], Integer.parseInt(passageiroString[2]));
            }
            else
                return null;
        }
        else
            return null;
    }

    public Passageiro getPassageiroAssentoPrioritario(int lugar) {
        if(lugar < qtdPreferenciais){
            if(!preferenciais[lugar].endsWith("@")) {
                String[] passageiroString = preferenciais[lugar].split("[@:]");
                return new Passageiro(passageiroString[1], Integer.parseInt(passageiroString[2]));
            }
            else
                return new Passageiro("",0);
        }
        else
            return null;
    }

    public int getNumeroAssentosPrioritarios() {
        return qtdPreferenciais;
    }
    public int getNumeroAssentosNormais() {
        return qtdNormais;
    }

    public int getVagas() {
        int cont = 0;
        for(int i = 0; i < capacidade; i++){
            if(i < qtdPreferenciais){
                if(preferenciais[i].endsWith("@"))
                    cont++;
            }
            else{
                if(normais[i-qtdPreferenciais].endsWith("="))
                    cont++;
            }
        }
        return cont;
    }

    private int vagaPreferencial(){
        for(int i = 0; i < qtdPreferenciais; i++){
            if(preferenciais[i].endsWith("@"))
                return i;
        }

        return -1;
    }

    private int vagaNormal(){
        for(int i = 0; i < qtdNormais; i++){
            if(normais[i].endsWith("="))
                return i;
        }

        return -1;
    }

    private boolean buscaPassageiro(String nome){
        for(int i = 0; i < capacidade; i++){
            if(i < qtdPreferenciais) {
                if (preferenciais[i].replaceAll("[@:0-9]", "").contentEquals(nome))
                    return true;
            }
            else {
                if (normais[i - qtdPreferenciais].replaceAll("[=:0-9]", "").contentEquals(nome))
                    return true;
            }
        }
        return false;
    }

    public boolean subir(Passageiro passageiro) {
        if(!buscaPassageiro(passageiro.getNome())) {
            if (getVagas() > 0) {
                int vagaPreferencial = vagaPreferencial();
                int vagaNormal = vagaNormal();
                if ((passageiro.ePrioritario() && vagaPreferencial >= 0) || (vagaNormal < 0))
                    preferenciais[vagaPreferencial] += passageiro.getNome() + ":" + passageiro.getIdade();
                else
                    normais[vagaNormal] += passageiro.getNome() + ":" + passageiro.getIdade();
                return true;
            }
            else {
                System.out.println("Topic lotada.");
                return false;
            }
        }
        else {
            System.out.println("Passageiro já está na topic.");
            return false;
        }
    }

    public boolean descer(String nome) {
        for(int i = 0; i < capacidade; i++){
            if(i < qtdPreferenciais) {
                if (preferenciais[i].replaceAll("[@:0-9]", "").contentEquals(nome)) {
                    preferenciais[i] = "@";
                    return true;
                }
            }
            else {
                if (normais[i - qtdPreferenciais].replaceAll("[=:0-9]", "").contentEquals(nome)) {
                    normais[i - qtdPreferenciais] = "=";
                    return true;
                }
            }
        }

        System.out.println("Passageiro não está na topic");
        return false;
    }

    @Override
    public String toString() {
        String regex = "[\\[\\],]";
        return "[" +
                Arrays.toString(preferenciais).replaceAll(regex, "") + " " +
                Arrays.toString(normais).replaceAll(regex, "") + " " +
                ']';
    }
}