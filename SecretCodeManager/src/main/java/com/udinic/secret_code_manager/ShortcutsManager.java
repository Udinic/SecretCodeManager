package com.udinic.secret_code_manager;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import java.net.URISyntaxException;

public class ShortcutsManager {

    public final static String SCHEME_NAME = "udinic";
    public final static String SCHEME_AUTHORITY = "secret_code";
    public final static String SCHEME_PARAM = "code";

    private static void removeShortcut(Context context, String shortcutUri) {
        Intent intent = null;
        try {
            intent = Intent.parseUri(shortcutUri, 0);
        } catch (URISyntaxException e) {
        }
        intent.setAction("com.android.launcher.permission.UNINSTALL_SHORTCUT");
        context.sendBroadcast(intent);
    }


    public static void addShortcut(Context context, String activityName) {
        addShortcut(context, context.getString(R.string.app_name), activityName);
    }

    public static void addSecretShortcut(Context context, String shortcutName, String secret) {

        String shortcutUri;

        Intent shortcutIntent = new Intent();
        ComponentName comp = new ComponentName(context.getPackageName(), SecretCodeActivator.class.getName());
        shortcutIntent.setComponent(comp);

        // Example: udinic://secret_code?code=2312
        shortcutIntent.setData(Uri.parse(SCHEME_NAME + "://"+SCHEME_AUTHORITY+"?"+SCHEME_PARAM+"=" + secret));
        shortcutIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        Intent intent = new Intent();

        intent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, shortcutIntent);
        intent.putExtra(Intent.EXTRA_SHORTCUT_NAME, shortcutName);
//        intent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, Intent.ShortcutIconResource.fromContext(context, R.drawable.icon));
        intent.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
        shortcutUri = intent.toUri(Context.MODE_WORLD_WRITEABLE);

        removeShortcut(context, shortcutUri);

        context.sendBroadcast(intent);
	}

    public static void addShortcut(Context context, String shortcutName, String activityName) {

        String shortcutUri;

        Intent shortcutIntent = new Intent();
        ComponentName comp = new ComponentName(context.getPackageName(), activityName);
        shortcutIntent.setComponent(comp);
        shortcutIntent.setAction(Intent.ACTION_MAIN);
        shortcutIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        shortcutIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        Intent intent = new Intent();

        intent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, shortcutIntent);
        intent.putExtra(Intent.EXTRA_SHORTCUT_NAME, shortcutName);
//        intent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, Intent.ShortcutIconResource.fromContext(context, R.drawable.icon));
        intent.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
        shortcutUri = intent.toUri(Context.MODE_WORLD_WRITEABLE);

        removeShortcut(context, shortcutUri);

        context.sendBroadcast(intent);
	}

//    public static void addShortcutForPopupsDemo(Context context, String shortcutName, boolean storageOnly){
//        Intent popupIntent = new Intent();
//        popupIntent.setComponent(new ComponentName(context.getPackageName(), AnydoNotificationsActivity.class.getName()));
//        popupIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        popupIntent.setAction(Intent.ACTION_MAIN);
//        popupIntent.putExtra(AnydoNotificationsActivity.INTENT_ARG_IS_DEMO, true);
//        popupIntent.putExtra(AnydoNotificationsActivity.INTENT_ARG_DIALOG_FOR_STORAGE, storageOnly);
//
//        Intent intent = new Intent();
//        intent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, popupIntent);
//        intent.putExtra(Intent.EXTRA_SHORTCUT_NAME, shortcutName);
//        intent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, Intent.ShortcutIconResource.fromContext(context, R.drawable.icon));
//        intent.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
//        String shortcutUri = intent.toUri(Context.MODE_WORLD_WRITEABLE);
//
//        removeShortcut(context, shortcutUri);
//
//        context.sendBroadcast(intent);
//
//    }
//    public static void addShortcutForPopup(Context context, String shortcutName, int dialogMask){
//
//        Intent popupIntent = new Intent();
//        popupIntent.setComponent(new ComponentName(context.getPackageName(), AnydoNotificationsActivity.class.getName()));
//        popupIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        popupIntent.setAction(Intent.ACTION_MAIN);
//        popupIntent.putExtra(AnydoNotificationsActivity.INTENT_ARG_DIALOG_ID, dialogMask);
//        popupIntent.putExtra(AnydoNotificationsActivity.INTENT_ARG_DIALOG_EXAMPLE_MODE, true);
//
//        Intent intent = new Intent();
//        intent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, popupIntent);
//        intent.putExtra(Intent.EXTRA_SHORTCUT_NAME, shortcutName);
//        intent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, Intent.ShortcutIconResource.fromContext(context, R.drawable.icon));
//        intent.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
//        String shortcutUri = intent.toUri(Context.MODE_WORLD_WRITEABLE);
//
//        removeShortcut(context, shortcutUri);
//
//        context.sendBroadcast(intent);
//	}


}
