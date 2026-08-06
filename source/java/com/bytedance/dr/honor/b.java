package com.bytedance.dr.honor;

import android.os.Bundle;
import com.bytedance.dr.aidl.f;
import com.bytedance.tobshadow.applog.log.LoggerImpl;

/* loaded from: classes3.dex */
public class b extends f.a {
    public volatile boolean a = false;

    @Override // com.bytedance.dr.aidl.f
    public void a(int i, long j, boolean z, float f, double d, String str) {
    }

    @Override // com.bytedance.dr.aidl.f
    public void a(int i, Bundle bundle) {
        LoggerImpl.global().debug("honor# OAIDLimitCallback handleResult retCode= " + i + " retInfo= " + bundle, new Object[0]);
        if (i != 0 || bundle == null) {
            return;
        }
        this.a = bundle.getBoolean("oa_id_limit_state");
        LoggerImpl.global().debug(com.bytedance.tobshadow.bdtracker.a.a("honor# OAIDLimitCallback handleResult success isLimit? ").append(this.a).toString(), new Object[0]);
    }
}
