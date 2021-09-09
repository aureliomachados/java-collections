import java.util.*;

public class ExemploCoresArcoIrisSet {
    public static void main(String[] args) {

        System.out.println("");
        Set<String> coresArcoIris = new HashSet<>(){{
            add("vermelho");
            add("laranja");
            add("amarelo");
            add("verde");
            add("azul");
            add("anil");
            add("violeta");
        }};

        System.out.println("Exiba todas as cores uma abaixo da outra: ");
        for (String corArcoIris :
                coresArcoIris) {
            System.out.println(corArcoIris);
        }

        System.out.println("Mostre a quantidade de cores que o arco-iris tem: " + coresArcoIris.size());

        System.out.println("Exiba as cores em ordem alfabética: ");
        Set<String> stringTreeSet = new TreeSet<>(new ComparatorCorArcoIris());

        stringTreeSet.addAll(coresArcoIris);

        for (String corAlfabetica :
            stringTreeSet) {
            System.out.println(corAlfabetica);
        }

        System.out.println("Exiba as cores na ordem inversa da que foi informada: ");

        List<String> listaDoSetArcoIris = new ArrayList<>(coresArcoIris);

        System.out.println("Exiba todas as cores que começam com a letra V: ");

        for (String corArcoIris :
                coresArcoIris) {
            if (corArcoIris.startsWith("v")) {
                System.out.println(corArcoIris);
            }
        }

        System.out.println("Remova todas as cores que não começam com a letra V: ");
//        for (String corArcoIris :
//                coresArcoIris) {
//            if (!corArcoIris.startsWith("v")) {
//                coresArcoIris.remove(corArcoIris)
//            }
//        }

        System.out.println("Limpe o conjunto: ");
        coresArcoIris.clear();

        System.out.println(coresArcoIris);

        System.out.println("Confira se o conjunto está vazio: " + coresArcoIris.isEmpty());
    }
}
class ComparatorCorArcoIris implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return o1.compareToIgnoreCase(o2);
    }
}