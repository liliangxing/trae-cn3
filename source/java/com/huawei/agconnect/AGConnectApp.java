package com.huawei.agconnect;

import android.content.Context;
import com.huawei.agconnect.config.impl.C0975a;

@Deprecated
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public abstract class AGConnectApp {
    public static AGConnectApp getInstance() {
        return C0975a.m788a();
    }

    private static AGConnectApp getInstance(String str) {
        return C0975a.m791a(str);
    }

    public static AGConnectApp initialize(Context context) {
        return C0975a.m789a(context);
    }

    private static AGConnectApp initialize(Context context, String str) {
        return C0975a.m790a(context, str);
    }

    public abstract void setApiKey(String str);

    public abstract void setAppId(String str);

    public abstract void setClientId(String str);

    public abstract void setClientSecret(String str);

    public abstract void setCpId(String str);

    public abstract void setCustomAuthProvider(CustomAuthProvider customAuthProvider);

    public abstract void setCustomCredentialsProvider(CustomCredentialsProvider customCredentialsProvider);

    public abstract void setParam(String str, String str2);

    public abstract void setProductId(String str);
}
