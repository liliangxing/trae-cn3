package com.bytedance.applog.bdinstall;

import android.content.Context;
import com.bytedance.bdinstall.IBDInstallApi;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class BdInstallBridge {
    public static void addRegisterCustomHeader(IBDInstallApi iBDInstallApi, Context context, JSONObject jSONObject) {
        iBDInstallApi.addRegisterCustomHeader(context, jSONObject);
    }
}
