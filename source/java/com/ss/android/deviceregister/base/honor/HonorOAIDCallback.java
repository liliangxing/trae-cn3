package com.ss.android.deviceregister.base.honor;

import android.os.Bundle;
import android.os.RemoteException;
import com.hihonor.cloudservice.oaid.IOAIDCallBack;
import com.ss.android.deviceregister.LogUtils;

/* loaded from: classes7.dex */
public class HonorOAIDCallback extends IOAIDCallBack.Stub {
    private volatile String oaid = "";

    @Override // com.hihonor.cloudservice.oaid.IOAIDCallBack
    public void basicTypes(int i, long j, boolean z, float f, double d, String str) throws RemoteException {
    }

    @Override // com.hihonor.cloudservice.oaid.IOAIDCallBack
    public void handleResult(int i, Bundle bundle) throws RemoteException {
        LogUtils.d("honor# ", "OAIDCallBack handleResult retCode= " + i + " retInfo= " + bundle);
        if (i != 0 || bundle == null) {
            return;
        }
        this.oaid = bundle.getString("oa_id_flag");
        LogUtils.d("honor# ", "OAIDCallBack handleResult success " + this.oaid);
    }

    public String getOaid() {
        return this.oaid;
    }
}
