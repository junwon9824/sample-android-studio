package kplo.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextInputEditText TextinputEditText_email, TextinputEditText_Password;
            RelativeLayout Relativelayout_login;
    String emailOK="123@gmail.com";
    String passwordOK="1234";
    String inputemail="";
    String inputpassword="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextinputEditText_email=findViewById(R.id.TextinputEditText_email);
        TextinputEditText_Password=findViewById(R.id.TextinputEditText_Password);
        Relativelayout_login=findViewById(R.id.Relativelayout_login);

        Relativelayout_login.setClickable(false);
        TextinputEditText_email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d("won",s+","+count);
                if(s!=null)
                {

                    inputemail=s.toString();


                        Relativelayout_login.setEnabled(validation());

                }


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });




        TextinputEditText_Password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d("won",s+","+count);
                if(s!=null)
                {

                    inputpassword=s.toString();


                    Relativelayout_login.setEnabled(validation());

                }


            }



            @Override
            public void afterTextChanged(Editable s) {

            }
        });


//        Relativelayout_login.setClickable(true);
        Relativelayout_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email= TextinputEditText_email.getText().toString();
                String password= TextinputEditText_Password.getText().toString();

                Intent intent = new Intent(MainActivity.this,LoginResultActivity.class);
                intent.putExtra("email",email);
                intent.putExtra("password",password);
                startActivity(intent);
            }
        });



    }

    public boolean validation(){
        return inputemail.equals(emailOK)  && inputpassword.equals(passwordOK);

    }


}