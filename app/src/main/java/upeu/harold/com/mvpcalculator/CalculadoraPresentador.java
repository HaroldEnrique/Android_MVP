package upeu.harold.com.mvpcalculator;

public class CalculadoraPresentador implements Main.Presentador {

    private Main.Model model;
    private Main.Vista vista;


    public CalculadoraPresentador (Main.Vista vista){
        this.vista = vista;
        model = new CalculadoraModel(this);
    }

    @Override
    public void pshowResult(String r) {

        if(vista != null){
            vista.vshowResult(r);
        }

    }

    @Override
    public void psumar(Double a, Double b) {
        if(vista!=null){
            model.msumar(a,b);
        }
    }

    @Override
    public void presta(Double a, Double b) {
        if(vista!=null){
            model.mresta(a,b);
        }
    }

    @Override
    public void pmultiplicar(Double a, Double b) {
        if(vista!=null){
            model.mmultiplicar(a,b);
        }
    }

    @Override
    public void pdividir(Double a, Double b) {
        if(vista!=null){
            model.mdividir(a,b);
        }
    }

    @Override
    public void praiz(Double a, Double b) {
        if(vista!=null){
            model.mraiz(a,b);
        }
    }
}
