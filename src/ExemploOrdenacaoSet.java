import java.util.*;

public class ExemploOrdenacaoSet {
    public static void main(String[] args) {

        System.out.println("Aleatório");

        Set<Serie> series = new HashSet<>(){{
            add(new Serie("got", "fantasia", 60));
            add(new Serie("dark", "drama", 60));
            add(new Serie("tha '70s show", "comédia", 25));
        }};

        for (Serie serie :
                series) {
            System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());
        }
        System.out.println("Ordem inserção: ");

        Set<Serie> seriesLinked = new LinkedHashSet<>(){{
            add(new Serie("got", "fantasia", 60));
            add(new Serie("dark", "drama", 60));
            add(new Serie("that '70s show", "comédia", 25));
        }};

        for (Serie serie :
                seriesLinked) {
            System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());
        }

        System.out.println("Ordem natural TempoEpisódio");
        Set<Serie> seriesTree = new TreeSet<>(seriesLinked);

        System.out.println(seriesTree);

        Set<Serie> serieTree1  = new TreeSet<>(new ComparatorNomeGeneroTempoEpisodio());
        serieTree1.addAll(seriesTree);

        System.out.println(serieTree1);

        System.out.println("Ordena por gênero: ");
        Set<Serie> seriesPorGenero = new TreeSet<>(new ComparatorGenero());

        seriesPorGenero.addAll(series);
        System.out.println(seriesPorGenero);

        System.out.println("Ordena por tempoEpisódio: ");
        Set<Serie> seriesPorTempoEpisodio = new TreeSet<>(new ComparatorTempoEpisodio());

        seriesPorTempoEpisodio.addAll(series);
        System.out.println(seriesPorTempoEpisodio);
    }
}

class Serie implements Comparable<Serie>{
    private String nome;
    private String genero;
    private Integer tempoEpisodio;

    public Serie(String nome, String genero, Integer tempoEpisodio) {
        this.nome = nome;
        this.genero = genero;
        this.tempoEpisodio = tempoEpisodio;
    }

    public String getNome() {
        return nome;
    }

    public String getGenero() {
        return genero;
    }

    public Integer getTempoEpisodio() {
        return tempoEpisodio;
    }

    @Override
    public String toString() {
        return "\nSerie{" +
                "nome='" + nome + '\'' +
                ", genero='" + genero + '\'' +
                ", tempoEpisodio=" + tempoEpisodio +
                '}' + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Serie serie = (Serie) o;
        return Objects.equals(nome, serie.nome) && Objects.equals(genero, serie.genero) && Objects.equals(tempoEpisodio, serie.tempoEpisodio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, genero, tempoEpisodio);
    }

    @Override
    public int compareTo(Serie serie) {
        int tempoEpisodio = this.getTempoEpisodio().compareTo(serie.getTempoEpisodio());
        int genero = this.genero.compareTo(serie.genero);
        if(tempoEpisodio != 0){
            return tempoEpisodio;
        }
        else{
            return genero;
        }


    }
}

class ComparatorNomeGeneroTempoEpisodio implements Comparator<Serie>{

    @Override
    public int compare(Serie s1, Serie s2) {
        int nome = s1.getNome().compareToIgnoreCase(s2.getNome());
        if(nome != 0){
            return nome;
        }
        int genero = s1.getGenero().compareTo(s2.getGenero());
        if(genero != 0){
            return genero;
        }
        int tempoEpisodio = s1.getTempoEpisodio().compareTo(s2.getTempoEpisodio());
        return tempoEpisodio;
    }
}

class ComparatorGenero implements Comparator<Serie>{

    @Override
    public int compare(Serie s1, Serie s2) {
        return s1.getGenero().compareToIgnoreCase(s2.getGenero());
    }
}

class ComparatorTempoEpisodio implements Comparator<Serie>{

    @Override
    public int compare(Serie s1, Serie s2) {
        return s1.getTempoEpisodio().compareTo(s2.getTempoEpisodio());
    }
}
