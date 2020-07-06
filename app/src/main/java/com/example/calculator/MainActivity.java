package com.example.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.*;

public class MainActivity extends AppCompatActivity {

    private static final int MAX = 200;
    EditText num1;
    TextView result;
    Button plusButton, histButton, minusButton, multButton, divButton, modButton;
    int flag,a;
    float res;
    double res1;
    boolean lock;
    String number1,number2, temp;
    StringBuffer str = new StringBuffer(MAX);
    @Override
    protected void onCreate(Bundle savedInstanceState)throws NumberFormatException, NullPointerException{
        super.onCreate(savedInstanceState);
        this.getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        num1 = (EditText)findViewById(R.id.editText1);
        result = (TextView)findViewById(R.id.textView3);
        num1.setShowSoftInputOnFocus(false);
        num1.requestFocus();
    }
    public int validateIfEmpty()
    {
        if(TextUtils.isEmpty(num1.getText()))
        {
            num1.setError("Enter expression");
            num1.requestFocus();
            return 0;
        }
        else
        {
            return 1;
        }
    }
    public void appendNumber(View v)
    {
        str.append(numpad.returnInt(v));
        num1.setText(str);
    }
    public void appendOperator(View v)
    {
        str.append(operations.returnOp(v));
        num1.setText(str);
    }
    public void nuke(View v)
    {
        num1.getText().clear();
        result.setText("");
        str.setLength(0);
        num1.requestFocus();
    }

    public void evaluate(View v)
    {
        char[] tokens = temp.toCharArray();
        Stack<Float> values = new Stack<Float>();
        Stack<Character> ops = new Stack<Character>();
        for (int i = 0; i < tokens.length; i++)
        {
            if (tokens[i] == ' ')
                continue;

            if (tokens[i] >= '0' && tokens[i] <= '9')
            {
                StringBuffer sbuf = new StringBuffer();
                while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9' || tokens[i]=='.')
                    sbuf.append(tokens[i++]);
                values.push(Float.parseFloat(sbuf.toString()));
            }
            else if (tokens[i] == '(')
                ops.push(tokens[i]);
            else if (tokens[i] == ')')
            {
                while (ops.peek() != '(')
                {
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                }
                ops.pop();
            }
            else if (tokens[i] == '+' || tokens[i] == '-' ||
                    tokens[i] == '*' || tokens[i] == '/')
            {
                while (!ops.empty() && hasPrecedence(tokens[i], ops.peek()))
                {
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                }
                ops.push(tokens[i]);
            }
        }
        while (!ops.empty())
        {
            values.push(applyOp(ops.pop(), values.pop(), values.pop()));
        }
        float res1 = values.pop();
        result.setText(""+res1);
    }
    public static boolean hasPrecedence(char op1, char op2)
    {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }

    public static Float applyOp(char op, Float b, Float a)
    {
        float ret = 0;
        switch (op)
        {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0)
                    throw new
                            UnsupportedOperationException("Cannot divide by zero");
                return a / b;
        }
        return ret;
    }
}
