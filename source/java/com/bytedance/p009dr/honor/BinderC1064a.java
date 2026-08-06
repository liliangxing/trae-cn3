package com.bytedance.p009dr.honor;

import android.os.Bundle;
import com.bytedance.bdinstall.honor.HonorKeys;
import com.bytedance.p009dr.aidl.InterfaceC1059f;
import com.bytedance.tobshadow.applog.log.LoggerImpl;
import com.bytedance.tobshadow.bdtracker.a;

/* renamed from: com.bytedance.dr.honor.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class BinderC1064a extends InterfaceC1059f.a {

    /* renamed from: a */
    public volatile String f167a = "";

    @Override // com.bytedance.p009dr.aidl.InterfaceC1059f
    /* renamed from: a */
    public void mo250a(int i, long j, boolean z, float f, double d, String str) {
    }

    @Override // com.bytedance.p009dr.aidl.InterfaceC1059f
    /* renamed from: a */
    public void mo251a(int i, Bundle bundle) {
        LoggerImpl.global().debug("honor# OAIDCallBack handleResult retCode= " + i + " retInfo= " + bundle, new Object[0]);
        if (i != 0 || bundle == null) {
            return;
        }
        this.f167a = bundle.getString(HonorKeys.KEY_OA_ID_FLAG);
        LoggerImpl.global().debug(a.a("honor# OAIDCallBack handleResult success ").append(this.f167a).toString(), new Object[0]);
    }
}
