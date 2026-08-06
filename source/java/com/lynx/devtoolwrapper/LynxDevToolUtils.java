package com.lynx.devtoolwrapper;

import com.lynx.tasm.INativeLibraryLoader;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.service.ILynxDevToolService;
import com.lynx.tasm.service.LynxServiceCenter;
import java.util.HashSet;
import java.util.Set;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class LynxDevToolUtils {
    private static final ILynxDevToolService DEVTOOL_SERVICE = LynxServiceCenter.inst().getService(ILynxDevToolService.class);
    private static final String TAG = "LynxDevToolUtils";

    public static void setDevToolLibraryLoader(INativeLibraryLoader iNativeLibraryLoader) {
        ILynxDevToolService iLynxDevToolService = DEVTOOL_SERVICE;
        if (iLynxDevToolService != null) {
            iLynxDevToolService.devtoolEnvSetDevToolLibraryLoader(iNativeLibraryLoader);
        } else {
            LLog.m2577e(TAG, "failed to get DevToolService");
        }
    }

    public static void setDevtoolEnv(String str, Object obj) {
        ILynxDevToolService iLynxDevToolService = DEVTOOL_SERVICE;
        if (iLynxDevToolService != null) {
            iLynxDevToolService.setDevtoolEnv(str, obj);
        } else {
            LLog.m2577e(TAG, "failed to get DevToolService");
        }
    }

    public static void setDevtoolEnv(String str, Set<String> set) {
        ILynxDevToolService iLynxDevToolService = DEVTOOL_SERVICE;
        if (iLynxDevToolService != null) {
            iLynxDevToolService.setDevtoolGroupEnv(str, set);
        } else {
            LLog.m2577e(TAG, "failed to get DevToolService");
        }
    }

    public static Object getDevtoolEnv(String str, Object obj) {
        if (obj instanceof Boolean) {
            ILynxDevToolService iLynxDevToolService = DEVTOOL_SERVICE;
            if (iLynxDevToolService != null) {
                return Boolean.valueOf(iLynxDevToolService.getDevtoolBooleanEnv(str, (Boolean) obj));
            }
            LLog.m2577e(TAG, "failed to get DevToolService");
            return obj;
        }
        if (obj instanceof Integer) {
            ILynxDevToolService iLynxDevToolService2 = DEVTOOL_SERVICE;
            if (iLynxDevToolService2 != null) {
                return iLynxDevToolService2.getDevtoolIntEnv(str, (Integer) obj);
            }
            LLog.m2577e(TAG, "failed to get DevToolService");
            return obj;
        }
        LLog.m2577e(TAG, "value type error! key: " + str + ", value: " + obj.toString());
        return obj;
    }

    public static Set<String> getDevtoolEnv(String str) {
        Set<String> set;
        ILynxDevToolService iLynxDevToolService = DEVTOOL_SERVICE;
        if (iLynxDevToolService != null) {
            set = iLynxDevToolService.getDevtoolGroupEnv(str);
        } else {
            LLog.m2577e(TAG, "failed to get DevToolService");
            set = null;
        }
        return set != null ? set : new HashSet();
    }
}
