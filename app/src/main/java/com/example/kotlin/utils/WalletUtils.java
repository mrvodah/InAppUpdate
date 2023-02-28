package com.example.kotlin.utils;

import android.content.Context;

import com.bellid.mobile.seitc.api.SeitcKit;
import com.bellid.mobile.seitc.api.SeitcKitFactory;

import java.util.Properties;

public class WalletUtils {

    private static SeitcKit seitcKit;

    public static synchronized SeitcKit getSeitcKit(Context context) {
        if (seitcKit == null) {
            seitcKit = SeitcKitFactory.getSeitcKit(context.getApplicationContext(), getProperties(context));
        }
        return seitcKit;
    }

    public static Properties getProperties(Context context) {
        return PropertiesUtil.instance(context).getProperties();
    }

}
