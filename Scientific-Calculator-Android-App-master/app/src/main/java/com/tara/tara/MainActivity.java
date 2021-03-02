package com.tara.tara;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.mariuszgromada.math.mxparser.Expression;

public class MainActivity extends AppCompatActivity {

    private TextView previousCalulation;
    private EditText display;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        previousCalulation = (TextView) findViewById(R.id.previouscal);
        display= (EditText) findViewById(R.id.displaymath);
        display.setShowSoftInputOnFocus(false);
    }

    private void updateText(String strToAdd) {
        String oldStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftstr = oldStr.substring(0, cursorPos);
        String rightstr = oldStr.substring(cursorPos);

        display.setText(String.format("%s%s%s", leftstr, strToAdd, rightstr));
        display.setSelection(cursorPos + strToAdd.length());

    }
    public void zeroBtnPush(View view) {
        updateText("0");
    }

    public void oneBtnPush(View view) {
        updateText("1");
    }

    public void twoBtnPush(View view) {
        updateText("2");
    }

    public void threeBtnPush(View view) {
        updateText("3");
    }

    public void fourBtnPush(View view) {
        updateText("4");
    }

    public void fiveBtnPush(View view) {
        updateText("5");
    }

    public void sixBtnPush(View view) {
        updateText("6");
    }

    public void sevenBtnPush(View view) {
        updateText("7");
    }

    public void eightBtnPush(View view) {
        updateText("8");
    }

    public void nineBtnPush(View view) {
        updateText("9");
    }

    public void plusBtnPush(View view) {
        updateText("+");
    }

    public void substarctionBtnPush(View view) {
        updateText("-");
    }

    public void divideBtnPush(View view) {
        updateText("/");
    }

    public void multiplyPush(View view) {
        updateText("*");
    }

    public void clearBtnPush(View view) {
        display.setText("");

    }

    public void parOpenBtnPush(View view) {
        updateText("(");
    }

    public void paracloseBtnPush(View view) {
        updateText(")");
    }

    public void doteBtnPush(View view) {
        updateText(".");
    }

    public void backBtnPush(View view) {
        int cursorposition = display.getSelectionStart();
        int textLen = display.getText().length();

        if ( cursorposition != 0 & textLen != 0 ){
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorposition - 1, cursorposition, "");
            display.setText(selection);
            display.setSelection(cursorposition - 1);
        }
    }

    public void eqaulBtnPush(View view) {
        String userExp = display.getText().toString();

        //  userExp = userExp.replaceAll(getResources().getString(R.string.multifyTxt),"*");

        Expression exp = new Expression(userExp);
        String result = String.valueOf(exp.calculate());

        display.setText(result);
        display.setSelection(result.length());


    }



}