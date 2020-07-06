package com.example.calculator;

import android.view.View;

public class numpad {

    int ret;
    static int returnInt(View v)
    {
        int i = v.getId();

        if(i==R.id.num0)
        {
            return 0;
        }
        else if(i==R.id.num1)
        {
            return 1;
        }
        else if(i==R.id.num2)
        {
            return 2;
        }
        else if(i==R.id.num3)
        {
            return 3;
        }
        else if(i==R.id.num4)
        {
            return 4;
        }
        else if(i==R.id.num5)
        {
            return 5;
        }
        else if(i==R.id.num6)
        {
            return 6;
        }
        else if(i==R.id.num7)
        {
            return 7;
        }
        else if(i==R.id.num8)
        {
            return 8;
        }
        else if(i==R.id.num9)
        {
            return 9;
        }
        return -2;
    }
}
