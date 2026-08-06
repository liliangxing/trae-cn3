package com.vivo.push.restructure.p021b;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.ss.ttm.player.MediaPlayer;
import com.vivo.push.restructure.C1313a;
import com.vivo.push.util.C1393t;
import java.util.ArrayList;
import java.util.List;

/* compiled from: PushSystemRelyImpl.java */
/* renamed from: com.vivo.push.restructure.b.f */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1336f implements InterfaceC1332b {
    @Override // com.vivo.push.util.InterfaceC1387n
    /* renamed from: b */
    public final boolean mo880b(Context context) {
        if (context == null) {
            return true;
        }
        try {
            return ((NotificationManager) context.getSystemService("notification")).areNotificationsEnabled();
        } catch (Exception e) {
            C1393t.m1035a("PushSystemRelyImpl", "isNotifySwitchOpen error", e);
            return true;
        }
    }

    @Override // com.vivo.push.util.InterfaceC1387n
    /* renamed from: a */
    public final List<String> mo879a(Context context) {
        if (C1393t.m1045b() && Looper.myLooper() == Looper.getMainLooper()) {
            Log.w("DebugUtil", "Operation: findAllCoreClientPush in main thread!", new Throwable());
        }
        List<ResolveInfo> list = null;
        if (!C1313a.m810a().m815e().mo873m().isAgreePrivacyStatement()) {
            C1393t.m1048d("PushSystemRelyImpl", " findAllCorePush  isAgreePrivacyStatement() is false ");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            list = context.getPackageManager().queryIntentServices(new Intent("com.vivo.pushservice.action.PUSH_SERVICE"), MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_MCHIP_SKIP_ADAPTIVE_WORKAROUND);
        } catch (Exception unused) {
        }
        if (list != null && list.size() > 0) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ResolveInfo resolveInfo = list.get(i);
                if (resolveInfo != null) {
                    String str = resolveInfo.serviceInfo.packageName;
                    if (!TextUtils.isEmpty(str)) {
                        arrayList.add(str);
                    }
                }
            }
        }
        if (arrayList.size() <= 0) {
            C1393t.m1048d("PushSystemRelyImpl", "get all push packages is null");
        }
        return arrayList;
    }
}
