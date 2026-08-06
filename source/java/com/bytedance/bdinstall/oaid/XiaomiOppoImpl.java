package com.bytedance.bdinstall.oaid;

import android.content.Context;
import com.bytedance.bdinstall.DrLog;
import com.bytedance.bdinstall.oaid.OaidApi;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
final class XiaomiOppoImpl implements OaidApi {
    private static Class<?> sClass;
    private static Method sGetOAID;
    private static Object sIdProviderImpl;

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public String getName() {
        return "Xiaomi";
    }

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            sClass = cls;
            sIdProviderImpl = cls.newInstance();
            sGetOAID = sClass.getMethod("getOAID", Context.class);
        } catch (Exception e) {
            DrLog.e("Oaid#static reflect exception! " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isSupport() {
        return (sClass == null || sIdProviderImpl == null || sGetOAID == null) ? false : true;
    }

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public boolean support(Context context) {
        return isSupport();
    }

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public OaidApi.Result getOaid(Context context) {
        try {
            OaidApi.Result result = new OaidApi.Result();
            result.oaid = invokeMethod(context, sGetOAID);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String invokeMethod(Context context, Method method) {
        Object obj = sIdProviderImpl;
        if (obj == null || method == null) {
            return null;
        }
        try {
            Object invoke = method.invoke(obj, context);
            if (invoke != null) {
                return (String) invoke;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
