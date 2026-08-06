package com.bytedance.bdinstall.honor;

import android.os.Bundle;
import android.os.RemoteException;
import com.bytedance.bdinstall.DrLog;
import com.bytedance.bdinstall.oaid.impl.IOAIDCallBack;

/* loaded from: classes3.dex */
public class HonorOAIDCallback extends IOAIDCallBack.Stub {
    private volatile String oaid = "";

    @Override // com.bytedance.bdinstall.oaid.impl.IOAIDCallBack
    public void basicTypes(int i, long j, boolean z, float f, double d, String str) throws RemoteException {
    }

    @Override // com.bytedance.bdinstall.oaid.impl.IOAIDCallBack
    public void handleResult(int i, Bundle bundle) throws RemoteException {
        DrLog.d("honor# OAIDCallBack handleResult retCode= " + i + " retInfo= " + bundle);
        if (i != 0 || bundle == null) {
            return;
        }
        this.oaid = bundle.getString("oa_id_flag");
        DrLog.d("honor# OAIDCallBack handleResult success " + this.oaid);
    }

    public String getOaid() {
        return this.oaid;
    }
}
