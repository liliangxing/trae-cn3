package com.ss.android.deviceregister.base;

import android.content.Context;
import com.bytedance.helios.statichook.api.ExtraInfo;
import com.bytedance.helios.statichook.api.HeliosApiHook;
import com.bytedance.helios.statichook.api.Result;
import com.ss.android.deviceregister.DeviceRegisterManager;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class Oaid {
    private static Oaid sOaid;
    private final Context mContext;

    /* renamed from: com_ss_android_deviceregister_base_Oaid_com_bytedance_bdinstall_oaid_Oaid_getOaidId */
    private static String m99x7ac9548d(com.bytedance.bdinstall.oaid.Oaid oaid) {
        HeliosApiHook heliosApiHook = new HeliosApiHook();
        Object[] objArr = new Object[0];
        ExtraInfo extraInfo = new ExtraInfo(false, "()Ljava/lang/String;");
        Result preInvoke = heliosApiHook.preInvoke(10000008, "com/bytedance/bdinstall/oaid/Oaid", "getOaidId", oaid, objArr, "java.lang.String", extraInfo);
        if (preInvoke.isIntercept()) {
            heliosApiHook.postInvoke(10000008, "com/bytedance/bdinstall/oaid/Oaid", "getOaidId", oaid, objArr, (Object) null, extraInfo, false);
            return (String) preInvoke.getReturnValue();
        }
        String oaidId = oaid.getOaidId();
        heliosApiHook.postInvoke(10000008, "com/bytedance/bdinstall/oaid/Oaid", "getOaidId", oaid, objArr, oaidId, extraInfo, true);
        return oaidId;
    }

    public static Oaid instance(Context context) {
        if (sOaid == null) {
            synchronized (Oaid.class) {
                if (sOaid == null) {
                    sOaid = new Oaid(context);
                }
            }
        }
        return sOaid;
    }

    private Oaid(Context context) {
        this.mContext = context.getApplicationContext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, String> getOaid(long j) {
        if (DeviceRegisterManager.getSwitchToBdtracker()) {
            return com.bytedance.bdinstall.oaid.Oaid.instance(this.mContext).getOaid(j);
        }
        return OaidWrapper.instance(this.mContext).getOaid(j);
    }

    public String getOaidId() {
        if (DeviceRegisterManager.getSwitchToBdtracker()) {
            return m99x7ac9548d(com.bytedance.bdinstall.oaid.Oaid.instance(this.mContext));
        }
        return OaidWrapper.instance(this.mContext).getOaidId();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean maySupport() {
        if (DeviceRegisterManager.getSwitchToBdtracker()) {
            return com.bytedance.bdinstall.oaid.Oaid.instance(this.mContext).maySupport();
        }
        return OaidWrapper.instance(this.mContext).maySupport();
    }
}
