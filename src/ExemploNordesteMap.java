import java.util.*;

public class ExemploNordesteMap {
    public static void main(String[] args) {
        System.out.println("Crie um dicionário e relacione os estados e suas populações: ");

        Map<String, Integer> estados = new HashMap<>(){{
            put("PE", 9616621);
            put("AL", 3351543);
            put("CE", 9187103);
            put("RN", 3534265);
        }};

        System.out.println(estados);

        System.out.println("Subistitua a população do estado do RN por 3.534164");

        estados.put("RN", 3534165);

        System.out.println(estados);
        System.out.println("Confira se o estado PB está no dicionário, caso não adicione: " + estados.containsKey("PB"));
        if(!estados.containsKey("PB")){
            estados.put("PB", 4039277);
        }

        System.out.println("Estados: " + estados);

        System.out.println("Exiba a população de PE: " + estados.get("PE"));

        System.out.println("Exiba todos os estados e suas populações na ordem que foi informados: ");

        Map<String, Integer> estadosEmOrdem = new LinkedHashMap<>(){{
            put("PE", 9616621);
            put("AL", 3351543);
            put("CE", 9187103);
            put("RN", 3534265);
        }};

        Set<Map.Entry<String, Integer>> entries = estadosEmOrdem.entrySet();

        for (Map.Entry<String, Integer> estado :
                entries) {
            System.out.println("Estado: " + estado.getKey() + " - Cidade: " + estado.getValue());
        }

        System.out.println("Exiba os estados e suas populações em ordem alfabética: ");
        Map<String, Integer> estadosTreeOrdemAlfabetica = new TreeMap<>(){{
            put("PE", 9616621);
            put("AL", 3351543);
            put("CE", 9187103);
            put("RN", 3534265);
        }};

        Set<Map.Entry<String, Integer>> entriesOrdemAlfabetica = estadosTreeOrdemAlfabetica.entrySet();

        for (Map.Entry<String, Integer> estado :
                entriesOrdemAlfabetica) {
            System.out.println("Estado: " + estado.getKey() + " - Cidade: " + estado.getValue());
        }

        System.out.println("Exiba o estado com a menor população e sua quantidade: ");
        Integer min = Collections.min(estados.values());

        for (Map.Entry<String,Integer> estado:
        entries){
            if (estado.getValue().equals(min)){
                System.out.println(estado.getKey() + " - " + estado.getValue());
            }
        }

        System.out.println("Exiba o estado com a maior população e sua quantidade: ");
        Integer max = Collections.max(estados.values());

        for (Map.Entry<String, Integer> estado:
        entries){
            if (estado.getValue().equals(max)){
                System.out.println(estado.getKey() + " - " + estado.getValue());
            }
        }

        System.out.println("Exiba a soma da população desses estados: ");
        Integer soma = 0;
        for (Map.Entry<String, Integer> estado:
             entries) {
            soma += estado.getValue();
        }
        System.out.println("A soma das populações é: " + soma);

        System.out.println("A média das populações é: " + soma / estados.size());

        System.out.println("Remova os estados com a populaçao menor que 4.000.000");
        for (Map.Entry<String, Integer> estado:
             entries) {
            if(estado.getValue() < 4000000){
                estados.remove(estado.getKey());
            }
        }

        System.out.println(estados);

        System.out.println("Apague o dicionário: ");
        estados.clear();

        System.out.println("Confira se o dicionário está vazio: " + estados.isEmpty());
    }
}

class Estado {
    private String uf;
    private Integer populacao;
}
