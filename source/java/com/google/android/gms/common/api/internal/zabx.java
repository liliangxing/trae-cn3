package com.google.android.gms.common.api.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
/* loaded from: classes6.dex */
public final class zabx extends BroadcastReceiver {
    Context zaa;
    private final zabw zab;

    public zabx(zabw zabwVar) {
        this.zab = zabwVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Uri data = intent.getData();
        if ("com.google.android.gms".equals(data != null ? data.getSchemeSpecificPart() : null)) {
            this.zab.zaa();
            zab();
        }
    }

    public final void zaa(Context context) {
        this.zaa = context;
    }

    public final synchronized void zab() {
        Context context = this.zaa;
        if (context != null) {
            INVOKEVIRTUAL_com_google_android_gms_common_api_internal_zabx_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(context, this);
        }
        this.zaa = null;
    }

    @Proxy("unregisterReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    public static void INVOKEVIRTUAL_com_google_android_gms_common_api_internal_zabx_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(Context context, BroadcastReceiver broadcastReceiver) {
        ReceiverRegisterLancet.loge(broadcastReceiver, false);
        context.unregisterReceiver(broadcastReceiver);
    }
}
