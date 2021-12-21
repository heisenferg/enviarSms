package com.example.enviarsms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.EditText;
import android.widget.Toast;

public class MyReceiverSms extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        SmsMessage[] msg = null;
        String origen = null;
        String meg = null;

        if (bundle != null){
            Object [] pdus = (Object[]) bundle.get("pdus");
            msg = new SmsMessage[pdus.length];
            for (int i =0; i<msg.length; i++){
                String format = bundle.getString("format");
                msg[i] = SmsMessage.createFromPdu((byte[])pdus[i],format);
                origen = msg[i].getOriginatingAddress();
                meg = msg[i].getMessageBody().toString();

            }
            Toast.makeText(context, "Recibido SMS de " + origen + ":" + meg, Toast.LENGTH_LONG).show();//this.clearAbortBroadcast();
            this.clearAbortBroadcast();
        }
    }
}
