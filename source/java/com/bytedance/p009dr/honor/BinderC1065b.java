package com.bytedance.p009dr.honor;

import android.os.Bundle;
import com.bytedance.bdinstall.honor.HonorKeys;
import com.bytedance.p009dr.aidl.InterfaceC1059f;
import com.bytedance.tobshadow.applog.log.LoggerImpl;
import com.bytedance.tobshadow.bdtracker.a;

/* renamed from: com.bytedance.dr.honor.b */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class BinderC1065b extends InterfaceC1059f.a {

    /* renamed from: a */
    public volatile boolean f168a = false;

    @Override // com.bytedance.p009dr.aidl.InterfaceC1059f
    /* renamed from: a */
    public void mo250a(int i, long j, boolean z, float f, double d, String str) {
    }

    @Override // com.bytedance.p009dr.aidl.InterfaceC1059f
    /* renamed from: a */
    public void mo251a(int i, Bundle bundle) {
        LoggerImpl.global().debug("honor# OAIDLimitCallback handleResult retCode= " + i + " retInfo= " + bundle, new Object[0]);
        if (i != 0 || bundle == null) {
            return;
        }
        this.f168a = bundle.getBoolean(HonorKeys.KEY_OA_ID_LIMIT_STATE);
        LoggerImpl.global().debug(a.a("honor# OAIDLimitCallback handleResult success isLimit? ").append(this.f168a).toString(), new Object[0]);
    }
}
