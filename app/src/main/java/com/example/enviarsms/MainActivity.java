package com.example.enviarsms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestPermissions(new String[]{Manifest.permission.SEND_SMS},200);
        verificarPermiso();
        Button enviar = findViewById(R.id.buttonSend);
        enviar.setOnClickListener(this::onClick);

    }

    public void onClick(View v){
        EditText tel = findViewById(R.id.edTlf);
        EditText men = findViewById(R.id.edmensaje);
        String telefono = String.valueOf(tel.getText());
        String mensaje = String.valueOf(men.getText());
        enviarSMS(telefono, mensaje);
    }

    private void verificarPermiso(){
        int permiso = ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS);
        if (permiso ==PackageManager.PERMISSION_GRANTED){
            Toast.makeText(getApplicationContext(), "Permiso Concecido", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "NO hay permiso", Toast.LENGTH_SHORT).show();

        }
    }

    
    public void enviarSMS (String telefono, String mensaje){

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