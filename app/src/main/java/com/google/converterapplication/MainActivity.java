package com.google.converterapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button convert,reset;
    private EditText binary_edt,decimal_edt,octal_edt,hexa_edt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        convert = findViewById(R.id.cnvrtbtn);
        binary_edt=findViewById(R.id.binary_input);
        decimal_edt=findViewById(R.id.decimal_input);
        octal_edt=findViewById(R.id.octal_input);
        hexa_edt=findViewById(R.id.hexa_input);
        reset = findViewById(R.id.resetbtn);

        convert.setOnClickListener(v -> {

            if(binary_edt.getText().toString().trim().length()>0)
            {
                int dec = Integer.parseInt(binary_edt.getText().toString());
                int final_dec=global_bin_dec(dec);
                String suma_dec = Integer.toString(final_dec);
                decimal_edt.setText(suma_dec);

                int oct = Integer.parseInt(binary_edt.getText().toString());
                int binary_dec = global_bin_dec(oct);
                int dec_oct = global_dec_oct(binary_dec);
                octal_edt.setText(Integer.toString(dec_oct));

                int hexa = Integer.parseInt(binary_edt.getText().toString());
                int final_hexa=global_bin_dec(hexa);
                StringBuilder finally_hexa = global_dec_hexa(Integer.toString(final_hexa));
                hexa_edt.setText(finally_hexa);

            }
            else if(decimal_edt.getText().toString().trim().length()>0)
            {
                int bin = Integer.parseInt(decimal_edt.getText().toString());
                int final_bin=bin_to_dec(bin);
                String duplicate_bin = Integer.toString(final_bin);
                binary_edt.setText(duplicate_bin);

                int oct = Integer.parseInt(decimal_edt.getText().toString());
                int final_oct = oct_to_dec(oct);
                String duplicate_oct = Integer.toString(final_oct);
                octal_edt.setText(duplicate_oct);

                String hexa = decimal_edt.getText().toString();
                StringBuilder final_hexa = hexa_to_dec(hexa);
                hexa_edt.setText(final_hexa);
            }
            else if(octal_edt.getText().toString().trim().length()>0)
            {
                int bin =Integer.parseInt(octal_edt.getText().toString());
                int oct_bin  = ocatal_to_decimal(bin);
                int dec_bin = decimal_to_binary(oct_bin);
                String fially_bin = Integer.toString(dec_bin);
                binary_edt.setText(fially_bin);

                int dec = Integer.parseInt(octal_edt.getText().toString());
                int oct_dec = ocatal_to_decimal(dec);
                String finally_dec = Integer.toString(oct_dec);
                decimal_edt.setText(finally_dec);

                int hexa = Integer.parseInt(octal_edt.getText().toString());
                int hexa_bin = ocatal_to_decimal(hexa);
                int hexa_binary = decimal_to_binary(hexa_bin);
                int alter_bin_dec = global_bin_dec(hexa_binary);
                StringBuilder alter_dec_hexa=global_dec_hexa(Integer.toString(alter_bin_dec));
                hexa_edt.setText(alter_dec_hexa);
            }
            else if(hexa_edt.getText().toString().trim().length()>0)
            {
                String duplicate_bin = hexa_edt.getText().toString();
                int bin = Integer.parseInt(duplicate_bin,16);
                String final_binary = Integer.toBinaryString(bin);
                binary_edt.setText(final_binary);

                String duplicate_dec = hexa_edt.getText().toString();
                int final_dec = Integer.parseInt(duplicate_dec,16);
                decimal_edt.setText(Integer.toString(final_dec));

                String duplicate_octal = hexa_edt.getText().toString();
                int octal = Integer.parseInt(duplicate_octal,16);
                String final_oct = Integer.toOctalString(octal);
                octal_edt.setText(final_oct);

            }
            else
                Toast.makeText(this, "Please enter number in any field", Toast.LENGTH_SHORT).show();

            if(binary_edt.getText().toString().trim().length()>0 || decimal_edt.getText().toString().trim().length()>0 || octal_edt.getText().toString().trim().length()>0 || hexa_edt.getText().toString().trim().length()>0)
            {
                Toast.makeText(this, "Click Reset Button to check another number", Toast.LENGTH_SHORT).show();
            }
        });

        reset.setOnClickListener(v -> {
            binary_edt.getText().clear();
            decimal_edt.getText().clear();
            octal_edt.getText().clear();
            hexa_edt.getText().clear();
        });
    }

    private int global_dec_oct(int binary_dec) {
        StringBuilder octal = new StringBuilder();
        while(binary_dec!=0)
        {
            int rem = binary_dec%8;
            binary_dec=binary_dec/8;
            octal.append(rem);
        }
        octal.reverse();
        return Integer.parseInt(String.valueOf(octal));
    }

    private StringBuilder global_dec_hexa(String allter) {
        StringBuilder str_hexa = new StringBuilder();
        int dec = Integer.parseInt(String.valueOf(allter));
        while(dec!=0)
        {
            int rem = dec%16;
            dec=dec/16;
            if(rem==10)
                str_hexa.append("A");
            else if(rem==11)
                str_hexa.append("B");
            else if(rem==12)
                str_hexa.append("C");
            else if(rem==13)
                str_hexa.append("D");
            else if(rem==14)
                str_hexa.append("E");
            else if(rem==15)
                str_hexa.append("F");
            else
                str_hexa.append(rem);
        }
        str_hexa.reverse();
        return str_hexa;

    }
    private int global_bin_dec(int hexa_binary) {
        int element=0;
        int sum=0;
        while(hexa_binary!=0)
        {
            int rem=hexa_binary%10;
            hexa_binary=hexa_binary/10;
            sum= (int) (sum+(rem*(Math.pow(2,element))));
            element++;
        }
        return sum;
    }
    private int bin_oct(int final_oct) {
        StringBuilder str_oct=new StringBuilder();
        int octal=final_oct;
        while(octal!=0)
        {
            int rem = octal%8;
            octal=octal/8;
            str_oct.append(Integer.toString(rem));
        }
        str_oct.reverse();
        int duplicate_oct = Integer.parseInt(String.valueOf(str_oct));
        return  duplicate_oct;
    }



    private int bin_to_dec(int bin) {
        StringBuilder str_bin = new StringBuilder();
        int finally_bin;
        while(bin!=0)
        {
            int rem = bin%2;
            bin=bin/2;
            str_bin.append(rem);
        }
        str_bin.reverse();
        finally_bin=Integer.parseInt(String.valueOf(str_bin));
        return finally_bin;
    }
    private int oct_to_dec(int oct) {
        StringBuilder str_oct = new StringBuilder();
        int finally_oct;
        while(oct!=0)
        {
            int rem = oct%8;
            oct=oct/8;
            str_oct.append(rem);
        }
        str_oct.reverse();
        finally_oct=Integer.parseInt(String.valueOf(str_oct));
        return finally_oct;
    }
    private StringBuilder hexa_to_dec(String hexa) {
        StringBuilder str_hexa = new StringBuilder();
        int integer_hexa = Integer.parseInt(hexa);
        while(integer_hexa!=0)
        {

            int rem = integer_hexa%16;
            integer_hexa=integer_hexa/16;
            if(rem==10)
                str_hexa.append("A");
            else if(rem==11)
                str_hexa.append("B");
            else if(rem==12)
                str_hexa.append("C");
            else if(rem==13)
                str_hexa.append("D");
            else if(rem==14)
                str_hexa.append("E");
            else if(rem==15)
                str_hexa.append("F");
            else
                str_hexa.append(rem);

        }
        str_hexa.reverse();
        return str_hexa;
    }


    private int ocatal_to_decimal(int bin) {
        int sum= 0;
        int element =0;
        while(bin!=0)
        {
            int rem = bin%10;
            bin=bin/10;
            sum= (int) (sum+(rem*Math.pow(8,element)));
            element++;
        }
        return sum;
    }
    private int decimal_to_binary(int oct_bin) {
        StringBuilder str_bin = new StringBuilder();
        while(oct_bin!=0)
        {
            int rem=oct_bin%2;
            oct_bin=oct_bin/2;
            str_bin.append(rem);
        }
        str_bin.reverse();
        return Integer.parseInt(String.valueOf(str_bin));
    }
}