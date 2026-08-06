package com.vivo.push.ups;

import android.content.Context;
import android.os.Bundle;
import com.vivo.push.PushClient;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class VUpsManager {
    public void onCommandResult(Context context, Bundle bundle) {
    }

    public static VUpsManager getInstance() {
        return C1359a.f635a;
    }

    /* renamed from: com.vivo.push.ups.VUpsManager$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    private static class C1359a {

        /* renamed from: a */
        private static VUpsManager f635a = new VUpsManager();
    }

    public void registerToken(Context context, String str, String str2, String str3, UPSRegisterCallback uPSRegisterCallback) {
        PushClient.getInstance(context).turnOnPush(new C1360a(this, uPSRegisterCallback));
    }

    public void unRegisterToken(Context context, UPSRegisterCallback uPSRegisterCallback) {
        PushClient.getInstance(context).turnOffPush(new C1361b(this, uPSRegisterCallback));
    }

    public void turnOnPush(Context context, UPSTurnCallback uPSTurnCallback) {
        PushClient.getInstance(context).turnOnPush(new C1362c(this, uPSTurnCallback));
    }

    public void turnOffPush(Context context, UPSTurnCallback uPSTurnCallback) {
        PushClient.getInstance(context).turnOffPush(new C1363d(this, uPSTurnCallback));
    }
}
