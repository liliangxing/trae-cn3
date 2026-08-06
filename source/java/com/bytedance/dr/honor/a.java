package com.bytedance.dr.honor;

import android.os.Bundle;
import com.bytedance.dr.aidl.f;
import com.bytedance.tobshadow.applog.log.LoggerImpl;

/* loaded from: classes3.dex */
public class a extends f.a {
    public volatile String a = "";

    @Override // com.bytedance.dr.aidl.f
    public void a(int i, long j, boolean z, float f, double d, String str) {
    }

    @Override // com.bytedance.dr.aidl.f
    public void a(int i, Bundle bundle) {
        LoggerImpl.global().debug("honor# OAIDCallBack handleResult retCode= " + i + " retInfo= " + bundle, new Object[0]);
        if (i != 0 || bundle == null) {
            return;
        }
        this.a = bundle.getString("oa_id_flag");
        LoggerImpl.global().debug(com.bytedance.tobshadow.bdtracker.a.a("honor# OAIDCallBack handleResult success ").append(this.a).toString(), new Object[0]);
    }
}
