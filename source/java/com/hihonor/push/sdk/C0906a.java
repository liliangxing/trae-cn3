package com.hihonor.push.sdk;

import android.util.Log;
import org.json.JSONException;

/* renamed from: com.hihonor.push.sdk.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C0906a implements InterfaceC0936k0<HonorPushDataMsg> {

    /* renamed from: a */
    public final /* synthetic */ HonorMessageService f683a;

    public C0906a(HonorMessageService honorMessageService) {
        this.f683a = honorMessageService;
    }

    @Override // com.hihonor.push.sdk.InterfaceC0936k0
    /* renamed from: a */
    public void mo731a(C0908a1<HonorPushDataMsg> c0908a1) {
        if (c0908a1.m738e()) {
            HonorPushDataMsg m736c = c0908a1.m736c();
            if (m736c != null) {
                Log.i("HonorMessageService", "onMessageReceived. msgId is " + m736c.getMsgId());
                this.f683a.onMessageReceived(m736c);
                return;
            } else {
                Log.i("HonorMessageService", "parse remote data failed.");
                return;
            }
        }
        boolean z = c0908a1.m735b() instanceof JSONException;
    }
}
