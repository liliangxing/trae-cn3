package com.huawei.hms.push;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.huawei.hms.support.log.HMSLog;
import java.lang.reflect.Field;

/* compiled from: ResourceLoader.java */
/* renamed from: com.huawei.hms.push.s */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1232s {
    /* renamed from: a */
    public static int m2037a(Context context, String str, String str2) {
        try {
            int identifier = context.getResources().getIdentifier(str2, str, context.getPackageName());
            if (identifier == 0) {
                Field field = Class.forName(context.getPackageName() + ".R$" + str).getField(str2);
                identifier = Integer.parseInt(field.get(field.getName()).toString());
                if (identifier == 0) {
                    HMSLog.m2120i("ResourceLoader", "Error-resourceType=" + str + "--resourceName=" + str2 + "--resourceId =" + identifier);
                }
            }
            return identifier;
        } catch (ClassNotFoundException e) {
            HMSLog.m2119e("ResourceLoader", "!!!! ResourceLoader: ClassNotFoundException-resourceType=" + str + "--resourceName=" + str2, e);
            return 0;
        } catch (IllegalAccessException e2) {
            HMSLog.m2119e("ResourceLoader", "!!!! ResourceLoader: IllegalAccessException-resourceType=" + str + "--resourceName=" + str2, e2);
            return 0;
        } catch (NoSuchFieldException e3) {
            HMSLog.m2119e("ResourceLoader", "!!!! ResourceLoader: NoSuchFieldException-resourceType=" + str + "--resourceName=" + str2, e3);
            return 0;
        } catch (NumberFormatException e4) {
            HMSLog.m2119e("ResourceLoader", "!!!! ResourceLoader: NumberFormatException-resourceType=" + str + "--resourceName=" + str2, e4);
            return 0;
        } catch (IllegalArgumentException e5) {
            HMSLog.m2119e("ResourceLoader", "!!!! ResourceLoader: IllegalArgumentException-resourceType=" + str + "--resourceName=" + str2, e5);
            return 0;
        }
    }

    /* renamed from: a */
    public static int m2036a(Context context, String str) {
        Bundle bundle;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
                return 0;
            }
            return bundle.getInt(str);
        } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
            HMSLog.m2121w("ResourceLoader", "load meta data resource failed.");
            return 0;
        }
    }
}
