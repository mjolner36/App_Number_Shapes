package com.example.appnumbershapes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    class Number{
        double number;
        public Number(double number){ this.number = number;}

        public boolean isTriangular(){
            boolean bool = false;
            if (Math.sqrt(number*8+1)%1==0) bool = true;
            return bool;
        }

        public boolean isSquare(){
            boolean bool = false;
            if (Math.sqrt(number)%1==0) bool = true;
            return bool;
        }
    }

    public void Click(View view){
        EditText numberEditText = (EditText) findViewById(R.id.numberEditText);
        String massage = numberEditText.getText().toString();

        if (numberEditText.getText().toString().isEmpty()){
            massage = "Please write number";
        }
        else{
            double number = Double.parseDouble(numberEditText.getText().toString());
            Number myNumber = new Number(number);

            if(myNumber.isSquare()&& myNumber.isTriangular()){massage += " is triangular and square";}
                else if (myNumber.isSquare()) {massage += " is square but not triangular";}
                    else if (myNumber.isTriangular()) {massage += " is triangular but not square";}
                        else  massage += " is neither triangular nor square";

        }
        Toast.makeText(this,massage,Toast.LENGTH_LONG).show();
    }
}