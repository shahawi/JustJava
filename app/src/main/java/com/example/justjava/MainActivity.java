package com.example.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;


/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    String Whipped = "";
    int price = 5;
    int number = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayPrice("", 0, "", "\n", Whipped, "");
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {

        write();

        displayPrice("That will be ", number * price, "Total   ", "\n", Whipped, "\n Thank you");
    }

    public void addValue(View view) {
        number++;


        display(number);
    }

    public void minusValue(View view) {
        while (number > 0)

        {
            number--;
            display(number);
            return;
        }


    }

    public void displayWhippedcream(View view) {
        Boolean checked = ((CheckBox) view).isChecked();
        if (checked) {
            Whipped = "Topping: Whipped cream";
            if (!(price > 5))
                price = price + 5;
        } else {
            Whipped = "";
            price = 5;
        }
    }


    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(String ee, int number, String aa, String bb, String dd, String cc) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(ee + aa + "  " + NumberFormat.getCurrencyInstance().format(number) + bb + dd + cc);
    }

    /**
     * This method displays the given quantity value on the screen.
     */


    private void display(int number) {

        EditText quantityTextView = (EditText) findViewById(
                R.id.quantity_text_view);

        quantityTextView.setText("" + number);

    }

    public void write()

    {
        EditText quantityTextView = (EditText) findViewById(
                R.id.quantity_text_view);
        String quantityT = quantityTextView.getText().toString();
        number = Integer.parseInt(quantityT);

    }
}
