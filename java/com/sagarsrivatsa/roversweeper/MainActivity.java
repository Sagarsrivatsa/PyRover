package com.sagarsrivatsa.roversweeper;

import android.bluetooth.BluetoothAssignedNumbers;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttSecurityException;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Button up,down,left,right,stop;
    //TextView tx;
    
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        up = (Button) findViewById(R.id.buttonup);
        down = (Button) findViewById(R.id.buttondo);
        left = (Button) findViewById(R.id.buttonle);
        right = (Button) findViewById(R.id.buttonri);
        stop = (Button) findViewById(R.id.buttonst);
      //  tx = (TextView) findViewById(R.id.textView);

        String clientId = MqttClient.generateClientId();
        final MqttAndroidClient client =
                new MqttAndroidClient(this.getApplicationContext(), "tcp://broker.hivemq.com:1883",
                        clientId);

        try {
            IMqttToken token = client.connect();
            token.setActionCallback(new IMqttActionListener() {
                @Override
                public void onSuccess(IMqttToken asyncActionToken) {
                    // We are connected
                    String TAG = null;
                    Log.d(TAG, "onSuccess");
                    Toast.makeText(MainActivity.this, "Connected", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
                    // Something went wrong e.g. connection timeout or firewall problems
                    String TAG = null;
                    Log.d(TAG, "onFailure");
                    Toast.makeText(MainActivity.this, "Not Connected", Toast.LENGTH_SHORT).show();

                }
            });
        } catch (MqttException e) {
            e.printStackTrace();
        }
        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String topic = "foo/bar2";
                String payload = "1";
                Toast.makeText(MainActivity.this, "Starting forward!!!!!", Toast.LENGTH_LONG).show();
                byte[] encodedPayload = new byte[0];
                try {
                    encodedPayload = payload.getBytes("UTF-8");
                    MqttMessage message = new MqttMessage(encodedPayload);
                    client.publish(topic, message);
                } catch (UnsupportedEncodingException | MqttException e) {
                    e.printStackTrace();
                }

            }
        });
        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String topic = "foo/bar2";
                String payload = "2";
                Toast.makeText(MainActivity.this, "Moving Backward", Toast.LENGTH_LONG).show();
                byte[] encodedPayload = new byte[1];
                try {
                    encodedPayload = payload.getBytes("UTF-8");
                    MqttMessage message = new MqttMessage(encodedPayload);
                    client.publish(topic, message);
                    //Log.e("down");
                } catch (UnsupportedEncodingException | MqttException e) {
                    e.printStackTrace();
                }

            }
        });
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String topic = "foo/bar2";
                String payload = "3";
                Toast.makeText(MainActivity.this, "Moving Right!", Toast.LENGTH_LONG).show();
                byte[] encodedPayload = new byte[2];
                try {
                    encodedPayload = payload.getBytes("UTF-8");
                    MqttMessage message = new MqttMessage(encodedPayload);
                    client.publish(topic, message);
                } catch (UnsupportedEncodingException | MqttException e) {
                    e.printStackTrace();
                }

            }
        });
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String topic = "foo/bar2";
                String payload = "4";
                Toast.makeText(MainActivity.this, "Moving left!", Toast.LENGTH_LONG).show();
                byte[] encodedPayload = new byte[3];
                try {
                    encodedPayload = payload.getBytes("UTF-8");
                    MqttMessage message = new MqttMessage(encodedPayload);
                    client.publish(topic, message);
                    //Log.e("left");
                } catch (UnsupportedEncodingException | MqttException e) {
                    e.printStackTrace();
                }

            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String topic = "foo/bar2";
                String payload = "0";
                ;//while(i--)
                Toast.makeText(MainActivity.this, "Stopping!!!!!", Toast.LENGTH_LONG).show();
                byte[] encodedPayload = new byte[4];
                try {
                    encodedPayload = payload.getBytes("UTF-8");
                    MqttMessage message = new MqttMessage(encodedPayload);
                    client.publish(topic, message);
                    //Log.e("left");
                } catch (UnsupportedEncodingException | MqttException e) {
                    e.printStackTrace();
                }

            }
        });
      /*  String topic2 = "foo/bar5";
        int qos = 1;
        try {
            IMqttToken subToken = client.subscribe(topic2, qos);
            client.setCallback(new MqttCallback() {
                @Override
                public void connectionLost(Throwable throwable) {
                    Toast.makeText(MainActivity.this,"Connection lost",Toast.LENGTH_SHORT).show();
                }

                @Override
                public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
                    byte[] i=mqttMessage.getPayload();
                    Toast.makeText(MainActivity.this,"Obstacle detected",Toast.LENGTH_SHORT).show();
                }

                @Override
                public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {

                }
            });} catch (MqttSecurityException e) {
            e.printStackTrace();
        } catch (MqttException e) {
            e.printStackTrace();
        }
        */
    }
}
