package com.ss.android.deviceregister.base;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.asus.msa.SupplementaryDID.IDidAidlInterface;
import com.ss.android.deviceregister.base.ServiceBlockBinder;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class ASUSOaidImpl extends BaseOaidImpl<IDidAidlInterface> {
    @Override // com.ss.android.deviceregister.base.OaidApi
    public String getName(Context context) {
        return "ASUS";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ASUSOaidImpl() {
        super("com.asus.msa.SupplementaryDID");
    }

    @Override // com.ss.android.deviceregister.base.BaseOaidImpl
    protected ServiceBlockBinder.ServiceBindedListener<IDidAidlInterface, String> buildServiceImpl() {
        return new ServiceBlockBinder.ServiceBindedListener<IDidAidlInterface, String>() { // from class: com.ss.android.deviceregister.base.ASUSOaidImpl.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.ss.android.deviceregister.base.ServiceBlockBinder.ServiceBindedListener
            public IDidAidlInterface asInterface(IBinder iBinder) {
                return IDidAidlInterface.Stub.asInterface(iBinder);
            }

            @Override // com.ss.android.deviceregister.base.ServiceBlockBinder.ServiceBindedListener
            public String fetchResult(IDidAidlInterface iDidAidlInterface) throws Exception {
                if (iDidAidlInterface == null) {
                    return null;
                }
                return iDidAidlInterface.getOAID();
            }
        };
    }

    @Override // com.ss.android.deviceregister.base.BaseOaidImpl
    protected Intent buildIntent(Context context) {
        Intent intent = new Intent();
        intent.setAction("com.asus.msa.action.ACCESS_DID");
        intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
        return intent;
    }
}
