package g313.yanev.lab04;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox[] chk = new CheckBox[4];
    EditText[] prices = new EditText[4];
    EditText[] quantities = new EditText[4];
    RadioButton rB1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeComponents();
    }

    public void onCalc(View v) {


        float sum = 0.0f;
        String strRes = "";

        for (int i = 0; i < 4; i++) {

            if (prices[i].getText().toString().equals("")) { prices[i].setText("0"); }

            if (quantities[i].getText().toString().equals("")) { quantities[i].setText("0"); }

            if (chk[i].isChecked()) {

                int quant = Integer.parseInt(quantities[i].getText().toString());
                float price = Float.parseFloat(prices[i].getText().toString());

                float tempVal = (float) quant * price;
                sum += tempVal;
                strRes += String.format("%d: %d x %s = %d x %.2f = %.2f\n",
                        i, quant, chk[i].getText().toString(), quant, price, tempVal);
            }
        }

        strRes += String.format("Total: %.2f", sum);
        // Вывод в Logcat
        // Log.d("ВЫВОД", strRes);

        if (rB1.isChecked()) {
            AlertDialog dialog = new AlertDialog.Builder(this).create();
            dialog.setIcon(R.drawable.icon1);
            dialog.setTitle("Результат");
            dialog.setMessage(strRes);
            dialog.show();

        } else {
            Toast.makeText(this, strRes, Toast.LENGTH_SHORT).show();
        }
    }


    private void initializeComponents() {
        // Кол-во фруктов (шт.)
        quantities[0] = findViewById(R.id.quant1);
        quantities[1] = findViewById(R.id.quant2);
        quantities[2] = findViewById(R.id.quant3);
        quantities[3] = findViewById(R.id.quant4);

        // Стоимость 1 шт.
        prices[0] = findViewById(R.id.price1);
        prices[1] = findViewById(R.id.price2);
        prices[2] = findViewById(R.id.price3);
        prices[3] = findViewById(R.id.price4);

        // Массив checkBox-ов
        chk[0] = findViewById(R.id.cB1);
        chk[1] = findViewById(R.id.cB2);
        chk[2] = findViewById(R.id.cB3);
        chk[3] = findViewById(R.id.cB4);

        // price[0] = 10.25f;
        // Вместо этого - динамическое задание цен

        rB1 = findViewById(R.id.rB1);
    }
}