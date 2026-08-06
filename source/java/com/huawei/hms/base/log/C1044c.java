package com.huawei.hms.base.log;

import android.content.Context;
import android.util.Log;

/* compiled from: LogCatNode.java */
/* renamed from: com.huawei.hms.base.log.c */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1044c implements InterfaceC1045d {

    /* renamed from: a */
    private InterfaceC1045d f1114a;

    @Override // com.huawei.hms.base.log.InterfaceC1045d
    /* renamed from: a */
    public void mo1039a(Context context, String str) {
        InterfaceC1045d interfaceC1045d = this.f1114a;
        if (interfaceC1045d != null) {
            interfaceC1045d.mo1039a(context, str);
        }
    }

    @Override // com.huawei.hms.base.log.InterfaceC1045d
    /* renamed from: a */
    public void mo1040a(InterfaceC1045d interfaceC1045d) {
        this.f1114a = interfaceC1045d;
    }

    @Override // com.huawei.hms.base.log.InterfaceC1045d
    /* renamed from: a */
    public void mo1041a(String str, int i, String str2, String str3) {
        Log.println(i, "HMSSDK_" + str2, str3);
        InterfaceC1045d interfaceC1045d = this.f1114a;
        if (interfaceC1045d != null) {
            interfaceC1045d.mo1041a(str, i, str2, str3);
        }
    }
}
