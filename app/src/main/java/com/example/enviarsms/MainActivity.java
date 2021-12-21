package com.example.enviarsms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button enviar = findViewById(R.id.buttonSend);
    }


    
    public void enviarSMS (){
        EditText tel = findViewById(R.id.edTlf);
        EditText men = findViewById(R.id.edmensaje);
        String telefono = String.valueOf(tel.getText());
        String mensaje = String.valueOf(men.getText());
        try{
            SmsManager smsManager= SmsManager.getDefault();
            smsManager.sendTextMessage(telefono, null, mensaje,null, null);
            Toast.makeText(getApplicationContext(), "SMS enviado", Toast.LENGTH_SHORT).show();
        } catch (Exception e){
            Toast.makeText(getApplicationContext(), "SMS no enviado, inténtelo de nuevo", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }
}