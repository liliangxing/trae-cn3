package com.ss.android.deviceregister.base.honor;

import android.os.Bundle;
import android.os.RemoteException;
import com.hihonor.cloudservice.oaid.IOAIDCallBack;
import com.ss.android.deviceregister.LogUtils;

/* loaded from: classes7.dex */
public class HonorOAIDLimitCallback extends IOAIDCallBack.Stub {
    private volatile boolean isLimit = false;

    @Override // com.hihonor.cloudservice.oaid.IOAIDCallBack
    public void basicTypes(int i, long j, boolean z, float f, double d, String str) throws RemoteException {
    }

    @Override // com.hihonor.cloudservice.oaid.IOAIDCallBack
    public void handleResult(int i, Bundle bundle) throws RemoteException {
        LogUtils.d("honor# ", "OAIDLimitCallback handleResult retCode= " + i + " retInfo= " + bundle);
        if (i != 0 || bundle == null) {
            return;
        }
        this.isLimit = bundle.getBoolean("oa_id_limit_state");
        LogUtils.d("honor# ", "OAIDLimitCallback handleResult success isLimit? " + this.isLimit);
    }

    public boolean isLimit() {
        return this.isLimit;
    }
}
