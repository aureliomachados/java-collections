import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ExemploOrdenacaoList {
    public static void main(String[] args) {
        List<Gato> gatos = new ArrayList<>(){{
            add(new Gato("Jon", 18, "preto"));
            add(new Gato("Simba", 6, "tigrado"));
            add(new Gato("Jon", 12, "amarelo"));
        }};

        System.out.println(gatos);

        System.out.println("Na ordem aleatória: ");

        Collections.shuffle(gatos);

        System.out.println(gatos);

        System.out.println("Colocque na ordem natural: ");

        Collections.sort(gatos);

        System.out.println(gatos);

        //Collections.sort(gatos, new ComparatorIdade());
        gatos.sort(new ComparatorIdade());
        System.out.println(gatos);

        //ordena pela cor
        gatos.sort(new ComparatorCor());
        System.out.println(gatos);

        //ordena pela cor, nom e idade
        gatos.sort(new ComparatorNomeCorIdade());
        System.out.println(gatos);
    }
}

class Gato implements Comparable<Gato>{
    private String nome;
    private Integer idade;
    private String cor;

    public Gato(String nome, Integer idade, String cor) {
        this.nome = nome;
        this.idade = idade;
        this.cor = cor;
    }

    public String getNome() {
        return nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public String getCor() {
        return cor;
    }

    @Override
    public String toString() {
        return "\nGato{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", cor='" + cor + '\'' +
                '}' + "\n";
    }

    @Override
    public int compareTo(Gato o) {
        return this.getNome().compareToIgnoreCase(o.getNome());
    }
}

class ComparatorIdade implements Comparator<Gato>{

    @Override
    public int compare(Gato o1, Gato o2) {
//        return o1.getIdade().compareTo(o2.getIdade());
        return Integer.compare(o1.getIdade(), o2.getIdade());
    }
}

class ComparatorCor implements Comparator<Gato>{
    @Override
    public int compare(Gato o1, Gato o2) {
        return o1.getCor().compareToIgnoreCase(o2.getCor());
    }
}

class ComparatorNomeCorIdade implements Comparator<Gato>{
    @Override
    public int compare(Gato g1, Gato g2) {
        int nome = g1.getNome().compareToIgnoreCase(g2.getNome());
        if(nome != 0) return nome;
        int cor = g1.getCor().compareToIgnoreCase(g2.getNome());
        if(cor != 0) return cor;
        return Integer.compare(g1.getIdade(), g2.getIdade());
    }
}


