package com.bytedance.bdinstall.honor;

import android.os.Bundle;
import android.os.RemoteException;
import com.bytedance.bdinstall.DrLog;
import com.bytedance.bdinstall.oaid.impl.IOAIDCallBack;

/* loaded from: classes3.dex */
public class HonorOAIDLimitCallback extends IOAIDCallBack.Stub {
    private volatile boolean isLimit = false;

    @Override // com.bytedance.bdinstall.oaid.impl.IOAIDCallBack
    public void basicTypes(int i, long j, boolean z, float f, double d, String str) throws RemoteException {
    }

    @Override // com.bytedance.bdinstall.oaid.impl.IOAIDCallBack
    public void handleResult(int i, Bundle bundle) throws RemoteException {
        DrLog.d("honor# OAIDLimitCallback handleResult retCode= " + i + " retInfo= " + bundle);
        if (i != 0 || bundle == null) {
            return;
        }
        this.isLimit = bundle.getBoolean("oa_id_limit_state");
        DrLog.d("honor# OAIDLimitCallback handleResult success isLimit? " + this.isLimit);
    }

    public boolean isLimit() {
        return this.isLimit;
    }
}
