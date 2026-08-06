package ms.bd.p001c;

import android.content.Context;
import android.location.LocationManager;
import java.lang.reflect.Field;
import java.lang.reflect.Proxy;
import net.openid.appauth.BuildConfig;

/* renamed from: ms.bd.c.w1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public abstract class AbstractC0224w1 {
    /* renamed from: a */
    public static C0229x1 m206a(Context context, String str) {
        Field field;
        Object obj;
        Class<?>[] interfaces;
        try {
            LocationManager locationManager = (LocationManager) context.getSystemService((String) AbstractC0190p2.m166a(16777217, 0, 0L, "5184cb", new byte[]{40, 60, 72, 65, 72, 124, 57, 30}));
            if (locationManager == null) {
                return new C0229x1(-10, BuildConfig.FLAVOR, BuildConfig.FLAVOR, null);
            }
            Field[] declaredFields = locationManager.getClass().getDeclaredFields();
            if (declaredFields == null) {
                return new C0229x1(-20, BuildConfig.FLAVOR, BuildConfig.FLAVOR, null);
            }
            int length = declaredFields.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    field = null;
                    obj = null;
                    break;
                }
                field = declaredFields[i];
                field.setAccessible(true);
                try {
                    obj = field.get(locationManager);
                    if (obj != null && !(obj instanceof String) && (interfaces = obj.getClass().getInterfaces()) != null && interfaces.length != 0 && str.equals(interfaces[0].getName())) {
                        break;
                    }
                    i++;
                } catch (IllegalAccessException unused) {
                    return new C0229x1(-21, BuildConfig.FLAVOR, BuildConfig.FLAVOR, null);
                }
            }
            if (obj == null) {
                return new C0229x1(-22, BuildConfig.FLAVOR, BuildConfig.FLAVOR, null);
            }
            return new C0229x1(obj instanceof Proxy ? 1 : 0, field.getName(), obj.getClass().getName(), null);
        } catch (Throwable unused2) {
            return new C0229x1(-11, BuildConfig.FLAVOR, BuildConfig.FLAVOR, null);
        }
    }
}
