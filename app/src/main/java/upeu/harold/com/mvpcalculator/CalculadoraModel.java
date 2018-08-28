package upeu.harold.com.mvpcalculator;

public class CalculadoraModel implements Main.Model {
    private Main.Presentador presentador;
    String value= "";
    public CalculadoraModel(Main.Presentador presentador){
        this.presentador = presentador;
    }


    @Override
    public void msumar(Double a, Double b) {
        value = Double.toString(a + b);

        System.out.println("esta sumando" + value);
        presentador.pshowResult(value);
    }

    @Override
    public void mresta(Double a, Double b) {
        value = Double.toString(a - b);
        System.out.println("esta restando" + a + " --- " + b + "operacion " + value);
        presentador.pshowResult(value);
    }

    @Override
    public void mmultiplicar(Double a, Double b) {
        value = Double.toString(a * b);
        System.out.println("esta multiplicando" + a + " --- " + b + "operacion " + value);
        presentador.pshowResult(value);
    }

    @Override
    public void mdividir(Double a, Double b) {

    }

    @Override
    public void mraiz(Double a, Double b) {

        //double bd = Double.valueOf(b);
        value = Double.toString(Math.pow(a,1/b));
        System.out.println("raiz >> " + a + " --- " + b + "operacion " + value);
        presentador.pshowResult(value);
    }
}
