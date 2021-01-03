package com.example.hp15_bs.fruitsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        final EditText passwordEd = findViewById(R.id.passwordEd);
        final EditText confirmPasswordEd = findViewById(R.id.confirmPasswordEd);
        final Button signUp = findViewById(R.id.signUp);
        final EditText nameEd = findViewById(R.id.nameEd);
        final EditText phoneEd = findViewById(R.id.phoneEd);

      signUp.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              String name = nameEd.getText().toString();
              String phone = phoneEd.getText().toString();
              String password = passwordEd.getText().toString();
              String confirmPassword = confirmPasswordEd.getText().toString();
              if(name != null && !name.trim().equals("")) {
                  if (phone != null && !phone.trim().equals("")) {
                      if(password != null && !password.trim().equals("")) {
                          if (confirmPassword != null && !confirmPassword.trim().equals("")) {
                              if (password.equals(confirmPassword)) {
                                  Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                                  intent.putExtra("phone",phone.toString());
                                  intent.putExtra("password",password.toString());
                                  startActivity(intent);

                                  Intent person = new Intent(getApplicationContext(),Person.class);
                                  person.putExtra("name",name);
                                  person.putExtra("phone",phone);
                                  startActivity(person);

                              } else {
                                  Toast toast = Toast.makeText(getApplicationContext(),"Password does not Identical",Toast.LENGTH_SHORT);
                                  toast.show();
                              }
                          }else {
                              Toast toast = Toast.makeText(getApplicationContext(),"Please confirm your password",Toast.LENGTH_SHORT);
                              toast.show();
                          }
                      }else {
                          Toast toast = Toast.makeText(getApplicationContext(),"Enter the password",Toast.LENGTH_SHORT);
                          toast.show();
                      }
                  }else {
                      Toast toast = Toast.makeText(getApplicationContext(),"Enter your phone",Toast.LENGTH_SHORT);
                      toast.show();
                  }
              }else {
                  Toast toast = Toast.makeText(getApplicationContext(),"Enter your name",Toast.LENGTH_SHORT);
                  toast.show();
              }
          }
      });

    }
}
