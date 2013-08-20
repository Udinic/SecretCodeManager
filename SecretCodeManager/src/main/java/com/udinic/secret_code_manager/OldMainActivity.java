package com.udinic.secret_code_manager;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import static com.udinic.secret_code_manager.ShortcutsManager.addSecretShortcut;

public class OldMainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.open).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callSecret("83464");
            }
        });

        findViewById(R.id.shortcut).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createShortcut("udini", "83464");
            }
        });
    }

    private void createShortcut(String name, String secret) {
        addSecretShortcut(this, name, secret);
    }

    private void callSecret(String secret) {
        sendBroadcast(new Intent("android.provider.Telephony.SECRET_CODE", Uri.parse("android_secret_code://" + secret)));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
