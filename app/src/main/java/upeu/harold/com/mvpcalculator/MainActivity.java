package upeu.harold.com.mvpcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Main.Vista {


    private Main.Presentador presentador;

    private TextView result;
    private String operand;
    private String operator;
    private List<String> numbers;
    private List<String> operators;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presentador = new CalculadoraPresentador(this);
        result = (TextView) findViewById(R.id.result);

    }


    private void initNumbers() {
        numbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numbers.add(Integer.toString(i));
        }
    }


    private void initOperators() {
        operators = new ArrayList<>();
        String[] ops = { "+", "-", "*", "/" ,"sqrt"};
        for (String operator : ops) {
            operators.add(operator);
        }
    }


    public void handleClick(View view) {
        Button clicked = (Button) view;
        String value = clicked.getText().toString();
        System.out.println("click boton" + value);
        if (isNumerical(value)) {
            System.out.println("Valor numerico");
            if (!isDefaultResult(result.getText().toString())) {
                value = result.getText().toString() + value;
                //vshowResult(value);
                System.out.println("el resultado no esta en default");
                result.setText(value);
            }else{
                result.setText(value);
            }
        } else if (isOperator(value)) {
            operand = result.getText().toString();
            operator = value;
            System.out.println("es operador");
            result.setText(value);
        } else if (isClear(value)) {
            value = getString(R.string.result_default);
            //vshowResult(value);
            //result.setText(value);
            System.out.println("esta limpio");
            result.setText(value);
        } else {

            if(operator.equals("sqrt")){

                double a = Double.parseDouble(operand);

                String indice = result.getText().toString();
                String[] ar = indice.split("sqrt");


                Double b = Double.parseDouble(ar[1]);
                //Double b = Double.parseDouble(ar[3]);

                presentador.praiz(a, b);

                //value = Double.toString(Math.pow(a,1/b));
                //System.out.println("raiz >> " + a + " --- " + b + "operacion " + value);



            }else{
                double a = Double.parseDouble(operand), b;
                String numberb =  result.getText().toString();
                String[] array =numberb.split("");
                int wide = array.length -1;

                String newvalue="";
                for(int i=2; i<=wide; i++){
                    System.out.println(array[i]);
                    newvalue = newvalue + array[i];
                }
                System.out.println("obteniendo nuevo valor " + newvalue);
                b = Double.parseDouble(newvalue);
                if (operator.equals("+")) {
                    System.out.println("esta sumando" + a + " --- " + b );
                    presentador.psumar(a, b);
                    //value = Double.toString(a + b);

                    //System.out.println("esta sumando" + value);
                }else if(operator.equals("-")){
                    //value = Double.toString(a - b);
                    System.out.println("esta restando" + a + " --- " + b );
                    presentador.presta(a,b);
                }else if(operator.equals("*")){
                    System.out.println("esta mutliplicando" + a + " --- " + b );
                    presentador.pmultiplicar(a,b);
                    //value = Double.toString(a * b);
                    //System.out.println("esta multiplicando" + a + " --- " + b + "operacion " + value);
                }
            }




            // Reset values.
            operator = null;
            operand = null;
        }

        //result.setText(value);
    }

    private boolean isClear(String value) {
        return value.equals(getString(R.string.buttonClear));
    }


    private boolean isOperator(String value) {
        if (operators == null) {
            initOperators();
        }
        return operators.contains(value);
    }


    private boolean isDefaultResult(String value) {
        System.out.println("string value>> " +value + "   valor defult + " + getString(R.string.result_default));
        return value.equals(getString(R.string.result_default));
    }


    private boolean isNumerical(String value) {
        if (numbers == null) {
            initNumbers();
        }
        return numbers.contains(value);
    }


    @Override
    public void vshowResult(String r) {
        Toast.makeText(getApplicationContext(), "Resultado >>>: " + r, Toast.LENGTH_SHORT).show();
        result.setText(r);
    }
}
