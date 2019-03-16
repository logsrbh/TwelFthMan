package com.example.saurabh.twelfthman;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class sign_up extends AppCompatActivity {
    EditText edittextusername, edittextpassword, edittextconfirmpass ;
    Button buttonCreateAccount;
    LoginDatabaseAdapter loginDatabaseAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        loginDatabaseAdapter = new LoginDatabaseAdapter(this);
        loginDatabaseAdapter=loginDatabaseAdapter.open();
        edittextusername = findViewById(R.id.edittextusername);
        edittextpassword = findViewById(R.id.edittextpassword);
        edittextconfirmpass = findViewById(R.id.edittextconfirmpass);

        buttonCreateAccount=findViewById(R.id.buttonCresteAccount);
        buttonCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             String UserName = edittextusername.getText().toString();
             String Password = edittextpassword.getText().toString();
             String ConfirmPassword = edittextconfirmpass.getText().toString();


         if (UserName.equals("") || Password.equals("") || ConfirmPassword.equals(""))
         {
             Toast.makeText(getApplicationContext(),"Field Vaccent",Toast.LENGTH_LONG).show();
             return;
         }

         if (!Password.equals(ConfirmPassword))
         {
            Toast.makeText(getApplicationContext(),"Password does not match",Toast.LENGTH_LONG)
                    .show();
            return;
         }
          else
              loginDatabaseAdapter.insertEntry(UserName, Password);
                Toast.makeText(getApplicationContext(),"Account Successfully Created",
                        Toast.LENGTH_LONG).show();
            }
        });
    }
        protected void onDestroy(){
                super.onDestroy();
                loginDatabaseAdapter.close();
    }

    }

