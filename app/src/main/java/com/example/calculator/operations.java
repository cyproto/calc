package com.example.calculator;

import android.view.View;

public class operations {


    static char returnOp(View v)
    {
        int Op;
        Op = v.getId();
        if(Op==R.id.buttonplus)
        {
            return '+';
        }
        else if(Op==R.id.buttonminus)
        {
            return '-';
        }
        else if(Op==R.id.buttonmult)
        {
            return '*';
        }
        else if(Op==R.id.buttondiv)
        {
            return '/';
        }
        else if(Op==R.id.decpoint)
        {
            return '.';
        }
        return 0;
    }
}
