package com.bytedance.bdinstall.oaid;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.bdinstall.oaid.ServiceBlockBinder;
import com.bytedance.bdinstall.oaid.impl.IDeviceIdService;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class SamsungOaidImpl extends BaseOaidImpl<IDeviceIdService> {
    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public String getName() {
        return "Samsung";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SamsungOaidImpl() {
        super("com.samsung.android.deviceidservice");
    }

    @Override // com.bytedance.bdinstall.oaid.BaseOaidImpl
    protected ServiceBlockBinder.ServiceBindedListener<IDeviceIdService, String> buildServiceImpl() {
        return new ServiceBlockBinder.ServiceBindedListener<IDeviceIdService, String>() { // from class: com.bytedance.bdinstall.oaid.SamsungOaidImpl.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.bytedance.bdinstall.oaid.ServiceBlockBinder.ServiceBindedListener
            public IDeviceIdService asInterface(IBinder iBinder) {
                return IDeviceIdService.Stub.asInterface(iBinder);
            }

            @Override // com.bytedance.bdinstall.oaid.ServiceBlockBinder.ServiceBindedListener
            public String fetchResult(IDeviceIdService iDeviceIdService) throws Exception {
                return iDeviceIdService.getOAID();
            }
        };
    }

    @Override // com.bytedance.bdinstall.oaid.BaseOaidImpl
    protected Intent buildIntent(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        return intent;
    }
}
