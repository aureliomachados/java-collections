import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.DoubleStream;

public class ExemploTemperaturaList {
    public static void main(String[] args) {
        List<Clima> temperaturas = new ArrayList<>();


            temperaturas.add(new Clima("Janeiro", 20));
            temperaturas.add(new Clima("Fevereiro", 30));
            temperaturas.add(new Clima("Março", 25));
            temperaturas.add(new Clima("Abril", 20));
            temperaturas.add(new Clima("Maio", 15));
            temperaturas.add(new Clima("Junho", 13));

        int somaTemperaturas = 0;

        Iterator<Clima> iterator = temperaturas.iterator();
        while (iterator.hasNext()){
             var next = iterator.next();
            somaTemperaturas += next.getTemperatura();
        }

        int mediaTemperaturas = (somaTemperaturas / 6);
        System.out.println("A média semestral das temperaturas é: " + mediaTemperaturas);



        for (Clima temperatura :
                temperaturas) {
            if (temperatura.getTemperatura() > mediaTemperaturas) {
                System.out.println("As temperaturas acima da média são: " + temperatura.getTemperatura());
            }
            }


    }
}

class Clima{
    private String mes;
    private Integer temperatura;

    public Clima(String mes, Integer temperatura) {
        this.mes = mes;
        this.temperatura = temperatura;
    }

    public String getMes() {
        return mes;
    }

    public Integer getTemperatura() {
        return temperatura;
    }

    @Override
    public String toString() {
        return "\nClima{" +
                "mes='" + mes + '\'' +
                ", temperatura=" + temperatura +
                '}' + "\n";
    }
}
