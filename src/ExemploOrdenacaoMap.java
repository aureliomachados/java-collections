import java.util.*;

public class ExemploOrdenacaoMap {
    public static void main(String[] args) {
        System.out.println("Ordem aleatória");

        Map<String, Livro> meusLivros = new HashMap<>(){{
           put("Hawking, Stephen", new Livro("Uma breve história do tempo", 256));
           put("Duhigg, Charles", new Livro("O poder do hábito", 408));
           put("Harari, Yuval Noah", new Livro("21 Lições para o século 21", 256));
        }};

        for(Map.Entry<String, Livro> livro: meusLivros.entrySet()){
            System.out.println(livro.getKey() + " - " + livro.getValue());
        }

        System.out.println("Imprimir na ordem em que foram adicionados: ");
        Map<String, Livro> meusLivrosLinked = new LinkedHashMap<>(){{
            put("Hawking, Stephen", new Livro("Uma breve história do tempo", 256));
            put("Duhigg, Charles", new Livro("O poder do hábito", 408));
            put("Harari, Yuval Noah", new Livro("21 Lições para o século 21", 256));
        }};

        for(Map.Entry<String, Livro> livro: meusLivrosLinked.entrySet()){
            System.out.println(livro.getKey() + " - " + livro.getValue());
        }


        System.out.println("Imprimir na ordem alfabética das chaves: ");

        Map<String, Livro> meusLivrosTree = new TreeMap<>(){{
            put("Hawking, Stephen", new Livro("Uma breve história do tempo", 256));
            put("Duhigg, Charles", new Livro("O poder do hábito", 408));
            put("Harari, Yuval Noah", new Livro("21 Lições para o século 21", 256));
        }};

        for(Map.Entry<String, Livro> livro: meusLivrosTree.entrySet()){
            System.out.println(livro.getKey() + " - " + livro.getValue());
        }

        System.out.println("Ordem alfabética dos nomes dos livros: ");

        Set<Map.Entry<String, Livro>> meusLivros3 = new TreeSet<>(new ComparatorNome());
        meusLivros3.addAll(meusLivros.entrySet());

        for(Map.Entry<String, Livro> livro: meusLivros3){
            System.out.println(livro.getKey() + " - " + livro.getValue());
        }

        System.out.println("Ordenar por número de páginas: ");

        Set<Map.Entry<String, Livro>> meusLivros4 = new TreeSet<>(new ComparatorNumeroPagina());
        meusLivros4.addAll(meusLivros.entrySet());

        for (Map.Entry<String, Livro> livro:
        meusLivros4){
            System.out.println(livro.getKey() + " - " + livro.getValue());
        }
    }
}
class Livro{
    private String nome;
    private Integer pagina;

    public Livro(String nome, Integer pagina) {
        this.nome = nome;
        this.pagina = pagina;
    }

    public String getNome() {
        return nome;
    }

    public Integer getPagina() {
        return pagina;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return Objects.equals(nome, livro.nome) && Objects.equals(pagina, livro.pagina);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, pagina);
    }

    @Override
    public String toString() {
        return "Livro{" +
                "nome='" + nome + '\'' +
                ", pagina=" + pagina +
                '}';
    }
}

class ComparatorNome implements Comparator<Map.Entry<String, Livro>>{

    @Override
    public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
        return l1.getValue().getNome().compareToIgnoreCase(l2.getValue().getNome());
    }
}

class ComparatorNumeroPagina implements Comparator<Map.Entry<String, Livro>>{

    @Override
    public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
        return l1.getValue().getPagina().compareTo(l2.getValue().getPagina());
    }
}