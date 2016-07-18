
package com.example.justjava;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends ActionBarActivity {

    int numberOfCoffees = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {

        EditText text = (EditText) findViewById(R.id.name_field);
        String name = text.getText().toString();

       //Figure out if the user wants whipped cream
        CheckBox whippedCreamCheckBox =(CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean haswhippedCream = whippedCreamCheckBox.isChecked();
        Log.v("MainActivity", "Has whipped cream:" + haswhippedCream);

        //Figure out if the user wants chocolate
        CheckBox chocolateCheckBox =(CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean haschocolate = chocolateCheckBox.isChecked();
        Log.v("MainActivity", "Has chocolate:" + haschocolate);


        display(numberOfCoffees);
        displayPrice(numberOfCoffees * 5);
        String priceMessage =   "Name: " + name +"\n" + "Add whipped cream? " + haswhippedCream + "\nAdd chocolate? " + haschocolate + "\nQuantity: " + numberOfCoffees  + "\n"+ "total " + "$ " + numberOfCoffees*5 + "\n" + "Thank you";
        displayMessage(priceMessage);
    }



    public void increment(View view) {
        numberOfCoffees = numberOfCoffees + 1 ;
        display(numberOfCoffees);
    }

    public void decrement(View view) {
        numberOfCoffees = numberOfCoffees - 1 ;
        display(numberOfCoffees);

    }



    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.orderSummary_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.orderSummary_text_view);
        priceTextView.setText(message);
    }
}