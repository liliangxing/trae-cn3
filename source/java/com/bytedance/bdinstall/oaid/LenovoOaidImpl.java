package com.bytedance.bdinstall.oaid;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.bdinstall.oaid.ServiceBlockBinder;
import com.bytedance.bdinstall.oaid.impl.IDeviceidInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class LenovoOaidImpl extends BaseOaidImpl<IDeviceidInterface> {
    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public String getName() {
        return "Lenovo";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LenovoOaidImpl() {
        super("com.zui.deviceidservice");
    }

    @Override // com.bytedance.bdinstall.oaid.BaseOaidImpl
    protected ServiceBlockBinder.ServiceBindedListener<IDeviceidInterface, String> buildServiceImpl() {
        return new ServiceBlockBinder.ServiceBindedListener<IDeviceidInterface, String>() { // from class: com.bytedance.bdinstall.oaid.LenovoOaidImpl.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.bytedance.bdinstall.oaid.ServiceBlockBinder.ServiceBindedListener
            public IDeviceidInterface asInterface(IBinder iBinder) {
                return IDeviceidInterface.Stub.asInterface(iBinder);
            }

            @Override // com.bytedance.bdinstall.oaid.ServiceBlockBinder.ServiceBindedListener
            public String fetchResult(IDeviceidInterface iDeviceidInterface) throws Exception {
                if (iDeviceidInterface == null) {
                    return null;
                }
                return iDeviceidInterface.getOAID();
            }
        };
    }

    @Override // com.bytedance.bdinstall.oaid.BaseOaidImpl
    protected Intent buildIntent(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        return intent;
    }
}
