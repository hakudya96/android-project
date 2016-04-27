package mybasiccalculator.basiccalc.com.android_calculator;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Nirav on 27-04-2016.
 */
public class SplashScreen extends AppCompatActivity {

    Button login;
    EditText username,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences preferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        if (TextUtils.isEmpty(preferences.getString("uname", null))) {
            setContentView(R.layout.splash_screen);
            init();
        }
        else
        {
            Intent intent=new Intent(SplashScreen.this,MainActivity.class);
            startActivity(intent);
        }
    }

    private void init()
    {
        login=(Button)findViewById(R.id.login);
        username=(EditText)findViewById(R.id.uname);
        pass=(EditText)findViewById(R.id.pass);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.getText().toString().equals("hardik")&&pass.getText().toString().equals("128"))
                {
                    Toast.makeText(SplashScreen.this,"Login passed",Toast.LENGTH_SHORT).show();
                    SharedPreferences preferences=getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor=preferences.edit();
                    editor.putString("uname", username.getText().toString());
                    editor.commit();
                    Intent intent=new Intent(SplashScreen.this,MainActivity.class);
                    startActivity(intent);
                }

                else
                {
                    Toast.makeText(SplashScreen.this,"Check your username or password",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
