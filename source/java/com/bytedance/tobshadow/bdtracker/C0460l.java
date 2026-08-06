package com.bytedance.tobshadow.bdtracker;

import com.bytedance.tobshadow.bdtracker.C0453k;

/* renamed from: com.bytedance.tobshadow.bdtracker.l */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class C0460l implements C0453k.d {

    /* renamed from: com.bytedance.tobshadow.bdtracker.l$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public class a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ C0467m f729a;

        public a(C0460l c0460l, C0467m c0467m) {
            this.f729a = c0467m;
        }

        /* JADX WARN: Code restructure failed: missing block: B:8:0x001f, code lost:
        
            if (r0.f505f.getBoolean("enter_background_not_send", false) != false) goto L11;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            C0467m c0467m = this.f729a;
            C0407d2 c0407d2 = c0467m.m523b("getConfig") ? null : c0467m.f788q.f835e;
            if (c0407d2 != null) {
                boolean z = c0407d2.f516q;
                if (z) {
                    return;
                }
                this.f729a.flush();
                this.f729a.m522b().mo637a();
            }
        }
    }

    @Override // com.bytedance.tobshadow.bdtracker.C0453k.d
    /* renamed from: a */
    public void mo499a(C0467m c0467m) {
        C0426g0.f610a.execute(new a(this, c0467m));
    }
}
