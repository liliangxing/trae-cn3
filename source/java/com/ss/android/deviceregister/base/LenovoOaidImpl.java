package com.ss.android.deviceregister.base;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.ss.android.deviceregister.base.ServiceBlockBinder;
import com.zui.deviceidservice.IDeviceidInterface;

/* loaded from: classes7.dex */
final class LenovoOaidImpl extends BaseOaidImpl<IDeviceidInterface> {
    @Override // com.ss.android.deviceregister.base.OaidApi
    public String getName(Context context) {
        return "Lenovo";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LenovoOaidImpl() {
        super("com.zui.deviceidservice");
    }

    @Override // com.ss.android.deviceregister.base.BaseOaidImpl
    protected ServiceBlockBinder.ServiceBindedListener<IDeviceidInterface, String> buildServiceImpl() {
        return new ServiceBlockBinder.ServiceBindedListener<IDeviceidInterface, String>() { // from class: com.ss.android.deviceregister.base.LenovoOaidImpl.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.ss.android.deviceregister.base.ServiceBlockBinder.ServiceBindedListener
            public IDeviceidInterface asInterface(IBinder iBinder) {
                return IDeviceidInterface.Stub.asInterface(iBinder);
            }

            @Override // com.ss.android.deviceregister.base.ServiceBlockBinder.ServiceBindedListener
            public String fetchResult(IDeviceidInterface iDeviceidInterface) throws Exception {
                if (iDeviceidInterface == null) {
                    return null;
                }
                return iDeviceidInterface.getOAID();
            }
        };
    }

    @Override // com.ss.android.deviceregister.base.BaseOaidImpl
    protected Intent buildIntent(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        return intent;
    }
}
