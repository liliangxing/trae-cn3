package com.ss.android.deviceregister.base;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.provider.Settings;
import android.text.TextUtils;
import com.bytedance.bdinstall.oaid.impl.IDeviceIdManager;
import com.ss.android.deviceregister.base.OaidApi;
import com.ss.android.deviceregister.base.ServiceBlockBinder;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class CoolpadOaidImpl extends BaseOaidImpl<IDeviceIdManager> {
    private static final String DEVICEIDMANAGER_SERVICE_CLASSNAME = "com.coolpad.deviceidsupport.DeviceIdService";
    private static final String DEVICEIDMANAGER_SERVICE_PACKAGENAME = "com.coolpad.deviceidsupport";
    private final Context mContext;

    @Override // com.ss.android.deviceregister.base.OaidApi
    public String getName(Context context) {
        return "coolpad";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CoolpadOaidImpl(Context context) {
        super(DEVICEIDMANAGER_SERVICE_PACKAGENAME);
        this.mContext = context;
    }

    @Override // com.ss.android.deviceregister.base.BaseOaidImpl, com.ss.android.deviceregister.base.OaidApi
    public OaidApi.Result getOaid(Context context) {
        try {
            String string = Settings.Global.getString(context.getContentResolver(), "coolos.oaid");
            if (!TextUtils.isEmpty(string)) {
                OaidApi.Result result = new OaidApi.Result();
                result.oaid = string;
                return result;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return super.getOaid(context);
    }

    @Override // com.ss.android.deviceregister.base.BaseOaidImpl
    protected ServiceBlockBinder.ServiceBindedListener<IDeviceIdManager, String> buildServiceImpl() {
        return new ServiceBlockBinder.ServiceBindedListener<IDeviceIdManager, String>() { // from class: com.ss.android.deviceregister.base.CoolpadOaidImpl.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.ss.android.deviceregister.base.ServiceBlockBinder.ServiceBindedListener
            public IDeviceIdManager asInterface(IBinder iBinder) {
                return IDeviceIdManager.Stub.asInterface(iBinder);
            }

            @Override // com.ss.android.deviceregister.base.ServiceBlockBinder.ServiceBindedListener
            public String fetchResult(IDeviceIdManager iDeviceIdManager) throws Exception {
                if (iDeviceIdManager == null) {
                    return null;
                }
                return iDeviceIdManager.getOAID(CoolpadOaidImpl.this.mContext.getPackageName());
            }
        };
    }

    @Override // com.ss.android.deviceregister.base.BaseOaidImpl
    protected Intent buildIntent(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(DEVICEIDMANAGER_SERVICE_PACKAGENAME, DEVICEIDMANAGER_SERVICE_CLASSNAME));
        return intent;
    }
}
