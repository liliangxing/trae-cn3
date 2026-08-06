package com.bytedance.bdinstall.oaid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.provider.Settings;
import android.text.TextUtils;
import com.bytedance.bdinstall.oaid.OaidApi;
import com.bytedance.bdinstall.oaid.ServiceBlockBinder;
import com.bytedance.bdinstall.oaid.impl.IDeviceIdManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class CoolpadOaidImpl extends BaseOaidImpl<IDeviceIdManager> {
    private static final String DEVICEIDMANAGER_SERVICE_CLASSNAME = "com.coolpad.deviceidsupport.DeviceIdService";
    private static final String DEVICEIDMANAGER_SERVICE_PACKAGENAME = "com.coolpad.deviceidsupport";
    private final Context mContext;

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public String getName() {
        return "coolpad";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CoolpadOaidImpl(Context context) {
        super(DEVICEIDMANAGER_SERVICE_PACKAGENAME);
        this.mContext = context;
    }

    @Override // com.bytedance.bdinstall.oaid.BaseOaidImpl, com.bytedance.bdinstall.oaid.OaidApi
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

    @Override // com.bytedance.bdinstall.oaid.BaseOaidImpl
    protected ServiceBlockBinder.ServiceBindedListener<IDeviceIdManager, String> buildServiceImpl() {
        return new ServiceBlockBinder.ServiceBindedListener<IDeviceIdManager, String>() { // from class: com.bytedance.bdinstall.oaid.CoolpadOaidImpl.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.bytedance.bdinstall.oaid.ServiceBlockBinder.ServiceBindedListener
            public IDeviceIdManager asInterface(IBinder iBinder) {
                return IDeviceIdManager.Stub.asInterface(iBinder);
            }

            @Override // com.bytedance.bdinstall.oaid.ServiceBlockBinder.ServiceBindedListener
            public String fetchResult(IDeviceIdManager iDeviceIdManager) throws Exception {
                if (iDeviceIdManager == null) {
                    return null;
                }
                return iDeviceIdManager.getOAID(CoolpadOaidImpl.this.mContext.getPackageName());
            }
        };
    }

    @Override // com.bytedance.bdinstall.oaid.BaseOaidImpl
    protected Intent buildIntent(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(DEVICEIDMANAGER_SERVICE_PACKAGENAME, DEVICEIDMANAGER_SERVICE_CLASSNAME));
        return intent;
    }
}
