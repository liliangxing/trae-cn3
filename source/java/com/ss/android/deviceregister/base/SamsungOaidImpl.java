package com.ss.android.deviceregister.base;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.samsung.android.deviceidservice.IDeviceIdService;
import com.ss.android.deviceregister.base.ServiceBlockBinder;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class SamsungOaidImpl extends BaseOaidImpl<IDeviceIdService> {
    @Override // com.ss.android.deviceregister.base.OaidApi
    public String getName(Context context) {
        return "Samsung";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SamsungOaidImpl() {
        super("com.samsung.android.deviceidservice");
    }

    @Override // com.ss.android.deviceregister.base.BaseOaidImpl
    protected ServiceBlockBinder.ServiceBindedListener<IDeviceIdService, String> buildServiceImpl() {
        return new ServiceBlockBinder.ServiceBindedListener<IDeviceIdService, String>() { // from class: com.ss.android.deviceregister.base.SamsungOaidImpl.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.ss.android.deviceregister.base.ServiceBlockBinder.ServiceBindedListener
            public IDeviceIdService asInterface(IBinder iBinder) {
                return IDeviceIdService.Stub.asInterface(iBinder);
            }

            @Override // com.ss.android.deviceregister.base.ServiceBlockBinder.ServiceBindedListener
            public String fetchResult(IDeviceIdService iDeviceIdService) throws Exception {
                return iDeviceIdService.getOAID();
            }
        };
    }

    @Override // com.ss.android.deviceregister.base.BaseOaidImpl
    protected Intent buildIntent(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        return intent;
    }
}
