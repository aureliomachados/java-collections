import java.util.*;
import java.util.stream.Collectors;

public class ExemploSet {
    public static void main(String[] args) {
        System.out.println("Crie um conjunto e adicione notas: ");

        Set<Double> notas = new HashSet<>();

        notas.add(7d);
        notas.add(8.5);
        notas.add(9.3);
        notas.add(5d);
        notas.add(7d);
        notas.add(0d);
        notas.add(3.6);

        System.out.println("Exiba a posição da nota 5.0: ");
        System.out.println(notas.toString());

        System.out.println("Confira se a nota 5.0 está no conjunto: " + notas.contains(5d));

        System.out.println("Exiba a menor nota: " + Collections.min(notas));

        System.out.println("Exiba a maior nota: " + Collections.max(notas));

        Iterator<Double> iterator = notas.iterator();
        int somaValores = 0;
        while (iterator.hasNext()){
            Double next = iterator.next();
            somaValores += next;
        }

        System.out.println("Exiba a soma dos valores: " + somaValores);

        System.out.println("A méda é: " + somaValores / notas.size());

        System.out.println("Remova a nota 0: ");
        notas.remove(0d);

        Iterator<Double> iterator1 = notas.iterator();
        while (iterator1.hasNext()){
            Double next = iterator1.next();
            if(next < 7){
                iterator1.remove();
            }
        }

        System.out.println("Remova as notas menores que 7: " + notas);


        Set<Double> notas2 = new LinkedHashSet<>();
        notas2.add(7d);
        notas2.add(8.5);
        notas2.add(9.3);
        notas2.add(5d);
        notas2.add(7d);
        notas2.add(0d);
        notas2.add(3.6);

        Set<Double> notas3 = new TreeSet<>(notas2);

        System.out.println("Exiba as notas ordenadas");

        System.out.println(notas3);

        System.out.println("Apague todo o conjunto: ");

        notas.clear();

        System.out.println(notas);

        System.out.println("Verifica se está vazio: " + notas.isEmpty());

    }
}
