package com.bytedance.bdinstall.oaid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.bdinstall.oaid.ServiceBlockBinder;
import com.bytedance.bdinstall.oaid.impl.IDidAidlInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class ASUSOaidImpl extends BaseOaidImpl<IDidAidlInterface> {
    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public String getName() {
        return "ASUS";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ASUSOaidImpl() {
        super("com.asus.msa.SupplementaryDID");
    }

    @Override // com.bytedance.bdinstall.oaid.BaseOaidImpl
    protected ServiceBlockBinder.ServiceBindedListener<IDidAidlInterface, String> buildServiceImpl() {
        return new ServiceBlockBinder.ServiceBindedListener<IDidAidlInterface, String>() { // from class: com.bytedance.bdinstall.oaid.ASUSOaidImpl.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.bytedance.bdinstall.oaid.ServiceBlockBinder.ServiceBindedListener
            public IDidAidlInterface asInterface(IBinder iBinder) {
                return IDidAidlInterface.Stub.asInterface(iBinder);
            }

            @Override // com.bytedance.bdinstall.oaid.ServiceBlockBinder.ServiceBindedListener
            public String fetchResult(IDidAidlInterface iDidAidlInterface) throws Exception {
                if (iDidAidlInterface == null) {
                    return null;
                }
                return iDidAidlInterface.getOAID();
            }
        };
    }

    @Override // com.bytedance.bdinstall.oaid.BaseOaidImpl
    protected Intent buildIntent(Context context) {
        Intent intent = new Intent();
        intent.setAction("com.asus.msa.action.ACCESS_DID");
        intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
        return intent;
    }
}
