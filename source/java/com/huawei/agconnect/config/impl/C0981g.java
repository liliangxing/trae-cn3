package com.huawei.agconnect.config.impl;

import android.content.Context;
import android.util.Log;
import com.bytedance.webx.event.EventManager;
import com.bytedance.webx.seclink.util.ReportUtil;
import com.huawei.agconnect.config.AesDecrypt;
import com.huawei.agconnect.config.IDecrypt;

/* renamed from: com.huawei.agconnect.config.impl.g */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C0981g implements AesDecrypt {

    /* renamed from: a */
    private final Context f844a;

    /* renamed from: b */
    private final String f845b;

    /* renamed from: c */
    private IDecrypt f846c;

    public C0981g(Context context, String str) {
        Log.d("AGC_FixedDecrypt", ReportUtil.Event.EVENT_INIT);
        this.f844a = context;
        this.f845b = str;
    }

    @Override // com.huawei.agconnect.config.AesDecrypt
    public String decrypt(String str, String str2) {
        if (this.f846c == null) {
            this.f846c = decryptComponent();
        }
        return this.f846c.decrypt(C0986l.m824a(this.f844a, this.f845b, "agc_", str), str2);
    }

    @Override // com.huawei.agconnect.config.AesDecrypt
    public IDecrypt decryptComponent() {
        return new C0980f(new C0978d(C0986l.m824a(this.f844a, this.f845b, "agc_", "/AD91D45E3E72DB6989DDCB13287E75061FABCB933D886E6C6ABEF0939B577138"), C0986l.m824a(this.f844a, this.f845b, "agc_", "/B314B3BF013DF5AC4134E880AF3D2B7C9FFBE8F0305EAC1C898145E2BCF1F21C"), C0986l.m824a(this.f844a, this.f845b, "agc_", "/C767BD8FDF53E53D059BE95B09E2A71056F5F180AECC62836B287ACA5793421B"), C0986l.m824a(this.f844a, this.f845b, "agc_", "/DCB3E6D4C2CF80F30D89CDBC412C964DA8381BB84668769391FBCC3E329AD0FD"), "PBKDF2WithHmacSHA1", EventManager.REGION_IN_OUT_ADJUST));
    }
}
