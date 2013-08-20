package com.udinic.secret_code_manager;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by Udini on 8/19/13.
 */
public class SecretCodeActivator extends Activity {

    private static final String ACTION_START_SECRET = "ACTION_START_SECRET_CODE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Uri date = getIntent().getData();
        String code = date.getQueryParameter(ShortcutsManager.SCHEME_PARAM);
        if (date.getAuthority().equals("secret_code") && code != null) {
            Log.i("SecretCodeActivator", "Strating secret code [" + code + "]");
            sendBroadcast(new Intent("android.provider.Telephony.SECRET_CODE", Uri.parse("android_secret_code://" + code)));
        }
        finish();
    }

}
