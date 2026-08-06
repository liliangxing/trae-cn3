package com.bytedance.ttnet.utils;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.frameworks.baselib.network.config.TTCookieConfig;
import com.bytedance.frameworks.baselib.network.http.util.BoeUtils;
import com.bytedance.frameworks.baselib.network.http.util.LRUCache;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedance.retrofit2.Retrofit;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class TtnetUtil {
    private static final String LOG_TAG = "TtnetUtil";
    private static final int RECEIVER_NOT_EXPORTED = 4;
    private static volatile boolean mDisableOkHttpDispatch;

    private TtnetUtil() {
    }

    public static void setBroadcastReceiverEnabled(Context context, Class<? extends BroadcastReceiver> cls, boolean z) {
        int i = z ? 1 : 2;
        try {
            if (Logger.debug()) {
                Logger.d(LOG_TAG, (z ? "enabling" : "disabling") + " connectivity receiver");
            }
            context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, cls), i, 1);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0032, code lost:
    
        if (r2 == null) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String outputThrowableStackTrace(Throwable th) {
        PrintWriter printWriter;
        String str = null;
        if (th == null) {
            return null;
        }
        try {
            StringWriter stringWriter = new StringWriter();
            printWriter = new PrintWriter(stringWriter);
            try {
                th.printStackTrace(printWriter);
                Throwable cause = th.getCause();
                if (cause != null) {
                    cause.printStackTrace(printWriter);
                    Throwable cause2 = cause.getCause();
                    if (cause2 != null) {
                        cause2.printStackTrace(printWriter);
                    }
                }
                str = stringWriter.toString();
            } catch (Throwable th2) {
                th = th2;
                try {
                    th.printStackTrace();
                } catch (Throwable th3) {
                    if (printWriter != null) {
                        printWriter.close();
                    }
                    throw th3;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            printWriter = null;
        }
        printWriter.close();
        return str;
    }

    public static boolean isMatchAllowHost(String str, String str2) {
        if (StringUtils.isEmpty(str) || StringUtils.isEmpty(str2)) {
            return false;
        }
        if (str.equalsIgnoreCase(str2)) {
            return true;
        }
        String lowerCase = str.toLowerCase();
        if (str2.startsWith(LibrarianImpl.Constants.DOT)) {
            return lowerCase.endsWith(str2.toLowerCase());
        }
        return lowerCase.endsWith(LibrarianImpl.Constants.DOT + str2.toLowerCase());
    }

    public static boolean inCookieHostList(String str, List<String> list) {
        if (!StringUtils.isEmpty(str) && !Lists.isEmpty(list)) {
            for (String str2 : list) {
                if (!StringUtils.isEmpty(str2)) {
                    if (TTCookieConfig.isDisableCookieHostMatchFix()) {
                        if (str.endsWith(str2)) {
                            return true;
                        }
                    } else if (isMatchAllowHost(str, str2)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void parseShareCookieHostList(String str, List<String> list) {
        if (StringUtils.isEmpty(str) || list == null) {
            return;
        }
        for (String str2 : str.split(",")) {
            if (!StringUtils.isEmpty(str2) && !inCookieHostList(str2, list)) {
                list.add(str2.trim());
            }
        }
    }

    public static void safeAddInterceptorInRetrofitCache(LRUCache<String, Retrofit> lRUCache, Interceptor interceptor) {
        if (lRUCache == null || lRUCache.size() <= 0) {
            return;
        }
        Map map = lRUCache.map();
        Collection values = map.values();
        synchronized (map) {
            Iterator it = values.iterator();
            while (it.hasNext()) {
                List<Interceptor> interceptors = ((Retrofit) it.next()).interceptors();
                if (interceptors != null && !interceptors.contains(interceptor)) {
                    interceptors.add(interceptor);
                }
            }
        }
    }

    public static void safeRemoveInterceptorInRetrofitCache(LRUCache<String, Retrofit> lRUCache, Interceptor interceptor) {
        if (lRUCache == null || lRUCache.size() <= 0) {
            return;
        }
        Map map = lRUCache.map();
        Collection values = map.values();
        synchronized (map) {
            Iterator it = values.iterator();
            while (it.hasNext()) {
                List<Interceptor> interceptors = ((Retrofit) it.next()).interceptors();
                if (interceptors != null) {
                    interceptors.remove(interceptor);
                }
            }
        }
    }

    public static void setDisableOkHttpDispatch(boolean z) {
        mDisableOkHttpDispatch = z;
    }

    public static boolean getDisableOkHttpDispatch() {
        return mDisableOkHttpDispatch;
    }

    public static void enableOkhttpBoeProxy(boolean z) {
        BoeUtils.enableOkhttpBoeProxy(z);
    }

    public static void setOkhttpBypassBoeJson(String str) {
        BoeUtils.setOkhttpBypassBoeJson(str);
    }

    public static Intent registerNonExportedBroadcastReceiver(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        return registerBroadcastReceiver(context, broadcastReceiver, intentFilter, null, null, 4);
    }

    public static Intent registerNonExportedBroadcastReceiver(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, Handler handler) {
        return registerBroadcastReceiver(context, broadcastReceiver, intentFilter, null, handler, 4);
    }

    private static Intent registerBroadcastReceiver(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i) {
        if (Build.VERSION.SDK_INT >= 26) {
            return m445x7fcf9ef(context, broadcastReceiver, intentFilter, str, handler, i);
        }
        return m444x7fcf9ef(context, broadcastReceiver, intentFilter, str, handler);
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.iab.omid.library.bytedance.b.b"})
    /* renamed from: INVOKEVIRTUAL_com_bytedance_ttnet_utils_TtnetUtil_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver */
    public static Intent m444x7fcf9ef(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen()) {
            ReceiverRegisterCrashOptimizer.doHWReceiverFix();
        }
        try {
            return context.registerReceiver(broadcastReceiver, intentFilter, str, handler);
        } catch (Exception e) {
            if (!ReceiverRegisterCrashOptimizer.fixedOpen()) {
                throw e;
            }
            return ReceiverRegisterCrashOptimizer.registerReceiver(broadcastReceiver, intentFilter, str, handler);
        }
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.iab.omid.library.bytedance.b.b"})
    /* renamed from: INVOKEVIRTUAL_com_bytedance_ttnet_utils_TtnetUtil_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver */
    public static Intent m445x7fcf9ef(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen()) {
            ReceiverRegisterCrashOptimizer.doHWReceiverFix();
        }
        try {
            return context.registerReceiver(broadcastReceiver, intentFilter, str, handler, i);
        } catch (Exception e) {
            if (!ReceiverRegisterCrashOptimizer.fixedOpen()) {
                throw e;
            }
            return ReceiverRegisterCrashOptimizer.registerReceiver(broadcastReceiver, intentFilter, str, handler, i);
        }
    }
}
