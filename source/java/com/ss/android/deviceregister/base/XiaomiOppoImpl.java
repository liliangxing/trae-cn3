package com.ss.android.deviceregister.base;

import android.content.Context;
import com.ss.android.deviceregister.LogUtils;
import com.ss.android.deviceregister.base.OaidApi;
import java.lang.reflect.Method;

/* loaded from: classes7.dex */
final class XiaomiOppoImpl implements OaidApi {
    private static Class<?> sClass;
    private static Method sGetOAID;
    private static Object sIdProviderImpl;

    @Override // com.ss.android.deviceregister.base.OaidApi
    public String getName(Context context) {
        return "Xiaomi";
    }

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            sClass = cls;
            sIdProviderImpl = cls.newInstance();
            sGetOAID = sClass.getMethod("getOAID", Context.class);
        } catch (Exception e) {
            LogUtils.e(LogUtils.TAG, "Api#static reflect exception! " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isSupport() {
        return (sClass == null || sIdProviderImpl == null || sGetOAID == null) ? false : true;
    }

    @Override // com.ss.android.deviceregister.base.OaidApi
    public boolean support(Context context) {
        return isSupport();
    }

    @Override // com.ss.android.deviceregister.base.OaidApi
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
