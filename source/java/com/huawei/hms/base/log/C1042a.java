package com.huawei.hms.base.log;

import android.content.Context;
import com.huawei.hms.support.log.HMSExtLogger;

/* compiled from: ExtLogNode.java */
/* renamed from: com.huawei.hms.base.log.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1042a implements InterfaceC1045d {

    /* renamed from: a */
    private final HMSExtLogger f1109a;

    /* renamed from: b */
    private InterfaceC1045d f1110b;

    public C1042a(HMSExtLogger hMSExtLogger) {
        this.f1109a = hMSExtLogger;
    }

    @Override // com.huawei.hms.base.log.InterfaceC1045d
    /* renamed from: a */
    public void mo1039a(Context context, String str) {
        InterfaceC1045d interfaceC1045d = this.f1110b;
        if (interfaceC1045d != null) {
            interfaceC1045d.mo1039a(context, str);
        }
    }

    @Override // com.huawei.hms.base.log.InterfaceC1045d
    /* renamed from: a */
    public void mo1040a(InterfaceC1045d interfaceC1045d) {
        this.f1110b = interfaceC1045d;
    }

    @Override // com.huawei.hms.base.log.InterfaceC1045d
    /* renamed from: a */
    public void mo1041a(String str, int i, String str2, String str3) {
        HMSExtLogger hMSExtLogger = this.f1109a;
        if (hMSExtLogger != null) {
            if (i == 3) {
                hMSExtLogger.m2110d(str2, str3);
            } else if (i == 4) {
                hMSExtLogger.m2112i(str2, str3);
            } else if (i != 5) {
                hMSExtLogger.m2111e(str2, str3);
            } else {
                hMSExtLogger.m2113w(str2, str3);
            }
        }
        InterfaceC1045d interfaceC1045d = this.f1110b;
        if (interfaceC1045d != null) {
            interfaceC1045d.mo1041a(str, i, str2, str3);
        }
    }
}
