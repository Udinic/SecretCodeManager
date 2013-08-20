package com.udinic.secret_code_manager.fragments;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.widget.ArrayAdapter;

import com.udinic.secret_code_manager.R;

import java.util.ArrayList;
import java.util.List;

public class SecretCodesListFragment extends android.support.v4.app.ListFragment {
    public SecretCodesListFragment() {
        super();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            setListAdapter(new ArrayAdapter<SecretCode>(getActivity(), R.layout.list_item_secret_code, R.id.code, getSecretCodes()));
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    private List<SecretCode> getSecretCodes() throws PackageManager.NameNotFoundException {
        ArrayList<SecretCode> list = new ArrayList<SecretCode>();

//        ActivityInfo activityInfo[] = getActivity().getPackageManager().getPackageInfo("com.anydo", PackageManager.GET_RECEIVERS | PackageManager.GET_RESOLVED_FILTER).receivers;
//        for (ActivityInfo info : activityInfo) {
//            Log.d("udini", info.toString());
//        }

//        PackageManager pm = getActivity().getPackageManager();
//        Intent intent = new Intent().setAction("android.provider.Telephony.SECRET_CODE").setData(Uri.parse("android_secret_code://"));
//        List<ResolveInfo> list1 = pm.queryBroadcastReceivers(intent, PackageManager.GET_RESOLVED_FILTER);

        list.add(new SecretCode("83464", "com.anydo"));
        list.add(new SecretCode("4543", "com.udinic"));
        list.add(new SecretCode("4531", "com.udinicblabla"));

        return list;

    }

    private static class SecretCode {
        String code;
        String appPackage;


        public SecretCode(String code, String appPackage) {
            this.code = code;
            this.appPackage = appPackage;
        }
    }
}
