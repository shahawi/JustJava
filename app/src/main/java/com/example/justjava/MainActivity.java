package com.example.justjava;

import android.*;
import android.os.*;
import android.support.v7.appcompat.*;
import android.view.*;
import android.widget.*;
import java.text.*;
import java.util.*;
import android.util.*;
import android.support.v7.app.*;


/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity
{


	int number= 0;
	@Override
    protected void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
  displayPrice(0, "", "");
		}

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view)
	{

        write();
		
		displayPrice(number * 5, "Total   ", "\nThank you");
    }
	public void addValue(View view)
	{
		number++;


		display(number);
	}

	public void minusValue(View view)
	{
		while (number > 0)

		{
			number--;
			display(number);
			return;
		}



	}

	/**
	 * This method displays the given price on the screen.
	 */
	private void displayPrice(int number, String aa, String bb)
	{
		TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
		priceTextView.setText (aa + NumberFormat.getCurrencyInstance().format(number)+bb);
	}

	/**
     * This method displays the given quantity value on the screen.
     */


	private void display(int number)
	{

        EditText quantityTextView = (EditText) findViewById(
			R.id.quantity_text_view);

		quantityTextView.setText("" + number);

    }
	public void write()

	{
		EditText quantityTextView = (EditText) findViewById(
			R.id.quantity_text_view);
		String quantityT= quantityTextView.getText().toString();
		number = Integer.parseInt(quantityT);

	}
}
