package com.vivo.push.p017h;

import android.content.Context;
import android.content.Intent;
import com.ss.ttm.player.C0968C;
import com.vivo.push.util.C1393t;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NotifyOpenClientClickTask.java */
/* renamed from: com.vivo.push.h.f */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class RunnableC1280f implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Context f468a;

    /* renamed from: b */
    final /* synthetic */ Map f469b;

    /* renamed from: c */
    final /* synthetic */ C1279e f470c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1280f(C1279e c1279e, Context context, Map map) {
        this.f470c = c1279e;
        this.f468a = context;
        this.f469b = map;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Intent launchIntentForPackage = this.f468a.getPackageManager().getLaunchIntentForPackage(this.f468a.getPackageName());
        if (launchIntentForPackage != null) {
            launchIntentForPackage.setFlags(C0968C.ENCODING_PCM_MU_LAW);
            C1279e.m718b(launchIntentForPackage, this.f469b);
            this.f468a.startActivity(launchIntentForPackage);
            return;
        }
        C1393t.m1034a("NotifyOpenClientTask", "LaunchIntent is null");
    }
}
