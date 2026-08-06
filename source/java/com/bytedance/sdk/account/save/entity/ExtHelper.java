package com.bytedance.sdk.account.save.entity;

import android.text.TextUtils;
import com.bytedance.sdk.account.save.SaveConstants;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class ExtHelper {
    public static String encode(Ext ext) {
        if (ext == null) {
            return null;
        }
        try {
            Integer countryCode = ext.getCountryCode();
            JSONObject jSONObject = new JSONObject();
            if (countryCode != null) {
                jSONObject.put(SaveConstants.ExtKey.COUNTRY_CODE, countryCode);
            }
            return jSONObject.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003e A[Catch: Exception -> 0x004a, TRY_LEAVE, TryCatch #0 {Exception -> 0x004a, blocks: (B:2:0x0000, B:4:0x0006, B:6:0x001a, B:8:0x0026, B:14:0x003e, B:16:0x0030), top: B:1:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Ext decode(String str) {
        char c;
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            Ext ext = new Ext();
            if (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next)) {
                    if (next.hashCode() == 1481071862 && next.equals(SaveConstants.ExtKey.COUNTRY_CODE)) {
                        c = 0;
                        if (c != 0) {
                            ext.setCountryCode(Integer.valueOf(jSONObject.optInt(next)));
                        }
                    }
                    c = 65535;
                    if (c != 0) {
                    }
                }
            }
            return ext;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
