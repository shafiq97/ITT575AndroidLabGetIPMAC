package com.example.getip_mac;

import androidx.appcompat.app.AppCompatActivity;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.text.format.Formatter;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtWifiInfo;
    Button btnInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtWifiInfo = (TextView) findViewById(R.id.idText);
        btnInfo = (Button) findViewById(R.id.idBtn);
    }

    public void getWifiInformation(View view){
        WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        int ip = wifiInfo.getIpAddress();
        String macAddress = wifiInfo.getMacAddress();
        String ipAddress = Formatter.formatIpAddress(ip);
        String info = "IP address: " + ipAddress + "\n" + "MAC address " + macAddress;
        txtWifiInfo.setText(info);

    }
}
