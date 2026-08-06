package com.bytedance.upc.common.utils;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Binder;
import com.bytedance.ss.reflector.IReflector;
import com.bytedance.ss.reflector.ReflectorFactory;
import com.bytedance.upc.common.ICommonBusinessService;
import com.bytedance.upc.common.log.LogUtils;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class ClipBoardUtils {
    public static final int OP_READ_CLIPBOARD = 29;
    private static boolean sCheckOpsMethodReflected;
    private static IReflector reflector = ReflectorFactory.getReflector();
    private static AppOpsManager appOpsManager = null;
    private static Object appOpsServiceObj = null;
    private static Method checkOperationMethod = null;

    private static boolean isAllowPermission(int i) {
        return (i == 1 || i == 2) ? false : true;
    }

    public static int checkOp(Context context, int i) {
        Object systemService = context.getSystemService("appops");
        try {
            return ((Integer) systemService.getClass().getDeclaredMethod("checkOp", Integer.TYPE, Integer.TYPE, String.class).invoke(systemService, Integer.valueOf(i), Integer.valueOf(Binder.getCallingUid()), context.getPackageName())).intValue();
        } catch (Throwable th) {
            LogUtils.m8e(th);
            return -1;
        }
    }

    public static boolean canReadClipMiuiV12() {
        return checkOpNoThrowOverMiuiV12(29);
    }

    public static void initAppOpsMethod() {
        if (sCheckOpsMethodReflected) {
            return;
        }
        try {
            Field field = reflector.getField(AppOpsManager.class, "mService");
            field.setAccessible(true);
            AppOpsManager appOpsManager2 = (AppOpsManager) getContext().getSystemService("appops");
            appOpsManager = appOpsManager2;
            appOpsServiceObj = field.get(appOpsManager2);
            checkOperationMethod = reflector.getMethod(reflector.getClass("com.android.internal.app.IAppOpsService$Stub$Proxy"), "checkOperation", new Class[]{Integer.TYPE, Integer.TYPE, String.class});
        } catch (Exception unused) {
        }
        sCheckOpsMethodReflected = true;
    }

    private static int checkOpNoThrowOverMiuiV12(int i, int i2, String str) {
        Object obj;
        Method method;
        initAppOpsMethod();
        try {
            if (!RomUtils.getInstance().isHigherMi12V2() || (obj = appOpsServiceObj) == null || (method = checkOperationMethod) == null) {
                return 0;
            }
            return ((Integer) method.invoke(obj, Integer.valueOf(i), Integer.valueOf(i2), str)).intValue();
        } catch (Exception unused) {
            return 0;
        }
    }

    private static boolean checkOpNoThrowOverMiuiV12(int i) {
        ApplicationInfo applicationInfo = getContext().getApplicationInfo();
        return isAllowPermission(checkOpNoThrowOverMiuiV12(i, applicationInfo.uid, applicationInfo.packageName));
    }

    private static Context getContext() {
        return ((ICommonBusinessService) ServiceManager.get().getService(ICommonBusinessService.class)).getContext();
    }
}
