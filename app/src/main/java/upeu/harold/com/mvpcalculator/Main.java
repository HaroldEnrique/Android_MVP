package upeu.harold.com.mvpcalculator;

public interface Main {


    public interface Vista{
        public void vshowResult(String r);
    }

    public interface Presentador{
        public void pshowResult(String r);
        public void psumar(Double a, Double b);
        public void presta(Double a, Double b);
        public void pmultiplicar(Double a, Double b);
        public void pdividir(Double a, Double b);
        public void praiz(Double a, Double b);
    }


    public interface Model{
        public void msumar(Double a, Double b);
        public void mresta(Double a, Double b);
        public void mmultiplicar(Double a, Double b);
        public void mdividir(Double a, Double b);
        public void mraiz(Double a, Double b);

    }
}
