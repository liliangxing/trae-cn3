package ms.bd.p001c;

import android.app.Activity;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.ArrayMap;
import com.bytedance.mobsec.metasec.ml.MSManagerUtils;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import net.openid.appauth.BuildConfig;

/* renamed from: ms.bd.c.n */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public abstract class AbstractC0177n {

    /* renamed from: a */
    public static volatile int f246a = -1;

    /* renamed from: b */
    public static volatile String f247b = "";

    /* renamed from: c */
    public static volatile String f248c;

    /* renamed from: d */
    public static final HashMap f249d = new HashMap(3);

    /* renamed from: e */
    public static boolean f250e = false;

    /* renamed from: f */
    public static final HandlerThread f251f = new HandlerThread((String) AbstractC0190p2.m166a(16777217, 0, 0, "62adef", new byte[]{42, 35, 1, 20, 81}));

    /* renamed from: g */
    public static final AtomicBoolean f252g = new AtomicBoolean(true);

    /* renamed from: h */
    public static Handler f253h = null;

    /* renamed from: a */
    public static int m148a() {
        try {
            return m151b() != null ? 1 : 0;
        } catch (Throwable unused) {
            return -1;
        }
    }

    /* renamed from: b */
    public static Activity m151b() {
        try {
            Class<?> cls = Class.forName((String) AbstractC0190p2.m166a(16777217, 0, 0L, "6e355a", new byte[]{38, 105, 68, 83, 5, Byte.MAX_VALUE, 49, 10, 99, 117, 55, 41, 97, 66, 30, Byte.MAX_VALUE, 35, 77, 118, 124, 19, 111, 82, 68, 11, 114}));
            Object invoke = cls.getMethod((String) AbstractC0190p2.m166a(16777217, 0, 0L, "8b2db9", new byte[]{42, 117, 83, 2, 88, 32, 47, 98, 96, 32, 32, 118, 72, 4, 68, 26, 51, 81, 102, 53, 45}), null).invoke(null, null);
            Field declaredField = cls.getDeclaredField((String) AbstractC0190p2.m166a(16777217, 0, 0L, "4ea5eb", new byte[]{40, 70, 17, 85, 83, 99, 62, 80, 57, 96, 54}));
            declaredField.setAccessible(true);
            ArrayMap arrayMap = (ArrayMap) declaredField.get(invoke);
            if (arrayMap.size() < 1) {
                return null;
            }
            for (Object obj : arrayMap.values()) {
                Class<?> cls2 = obj.getClass();
                Field declaredField2 = cls2.getDeclaredField((String) AbstractC0190p2.m166a(16777217, 0, 0L, "3d81c5", new byte[]{49, 114, 68, 85, 76, 39, 52}));
                declaredField2.setAccessible(true);
                if (!declaredField2.getBoolean(obj)) {
                    Field declaredField3 = cls2.getDeclaredField((String) AbstractC0190p2.m166a(16777217, 0, 0L, "e9fd31", new byte[]{117, 56, 1, 25, 26, 47, 114, 1}));
                    declaredField3.setAccessible(true);
                    return (Activity) declaredField3.get(obj);
                }
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: a */
    public static void m150a(Activity activity) {
        try {
            Field declaredField = Class.forName((String) AbstractC0190p2.m166a(16777217, 0, 0L, "ffca17", new byte[]{118, 106, 20, 7, 1, 41, 97, 9, 51, 33, 103, 42, 49, 22, 26, 41, 115, 78, 38, 40})).getDeclaredField((String) AbstractC0190p2.m166a(16777217, 0, 0L, "d50414", new byte[]{120, 5, 70, 70, 11, 49, 117, 17, 115}));
            declaredField.setAccessible(true);
            String obj = declaredField.get(activity).toString();
            String className = activity.getComponentName().getClassName();
            if (className.contains(obj)) {
                return;
            }
            AbstractC0190p2.m166a(16777222, 0, 0L, className + ((String) AbstractC0190p2.m166a(16777217, 0, 0L, "a71127", new byte[]{43})) + obj, null);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public static void m149a(int i) {
        String str;
        HashMap hashMap = f249d;
        if (hashMap == null || hashMap.size() <= 0) {
            str = null;
        } else {
            Iterator it = hashMap.entrySet().iterator();
            str = BuildConfig.FLAVOR;
            int i2 = 0;
            while (it.hasNext()) {
                int scenePageName = ((MSManagerUtils.ScenePageNameCallback) ((Map.Entry) it.next()).getValue()).getScenePageName();
                if (scenePageName != 0) {
                    if (i2 > 0) {
                        str = str + ((String) AbstractC0190p2.m166a(16777217, 0, 0L, "17b7f4", new byte[]{31}));
                    }
                    str = str + scenePageName;
                    i2++;
                }
            }
        }
        String str2 = str;
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        AbstractC0190p2.m166a(16777223, i, System.currentTimeMillis(), str2, null);
    }
}
