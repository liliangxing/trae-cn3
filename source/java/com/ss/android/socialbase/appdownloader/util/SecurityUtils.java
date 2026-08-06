package com.ss.android.socialbase.appdownloader.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Process;
import android.telephony.TelephonyManager;
import androidx.core.content.ContextCompat;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.ss.android.socialbase.appdownloader.AppDownloader;
import com.ss.android.socialbase.appdownloader.depend.IPrivacyPolicyCallback;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class SecurityUtils {
    private static final String TAG = "SecurityUtils";
    private static Boolean isSecure;

    public static boolean isSecure() {
        Boolean bool = isSecure;
        return bool == null || bool.booleanValue();
    }

    public static synchronized void init(Context context) {
        synchronized (SecurityUtils.class) {
            if (isSecure == null) {
                try {
                    IPrivacyPolicyCallback privacyPolicyCallback = AppDownloader.getInstance().getPrivacyPolicyCallback();
                    boolean z = false;
                    if (privacyPolicyCallback != null && !privacyPolicyCallback.isUserAgreePrivacyPolicy()) {
                        isSecure = false;
                        Logger.globalError(TAG, "init", "Before UserAgreePrivacyPolicy");
                        return;
                    }
                    if (!isRoot() && !isDebug(context) && !isUsbCharging(context) && hasSimCard(context) && !isFridaExist() && !isXposedExist(context)) {
                        z = true;
                    }
                    isSecure = Boolean.valueOf(z);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static boolean isRoot() {
        if (getRoSecureProp() == 0) {
            return true;
        }
        return isSUExist();
    }

    public static boolean isDebug(Context context) {
        try {
            return (context.getApplicationInfo().flags & 2) != 0;
        } catch (Exception unused) {
            return false;
        }
    }

    private static int getRoSecureProp() {
        String str = null;
        try {
            Object invoke = Class.forName("android.os.SystemProperties").getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(null, decode("726f2e736563757265"));
            if (invoke != null) {
                str = (String) invoke;
            }
        } catch (Exception unused) {
        }
        return (str != null && "0".equals(str)) ? 0 : 1;
    }

    private static boolean isSUExist() {
        try {
            String[] strArr = {decode("2f7362696e2f7375"), decode("2f73797374656d2f62696e2f7375"), decode("2f73797374656d2f7862696e2f7375"), decode("2f646174612f6c6f63616c2f7862696e2f7375"), decode("2f646174612f6c6f63616c2f62696e2f7375"), decode("2f73797374656d2f73642f7862696e2f7375"), decode("2f73797374656d2f62696e2f6661696c736166652f7375"), decode("2f646174612f6c6f63616c2f7375")};
            for (int i = 0; i < 8; i++) {
                if (new File(strArr[i]).exists()) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static boolean isUsbCharging(Context context) {
        RomUtils.isEmui();
        Intent m116x7a3361c7 = m116x7a3361c7(context, null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        return m116x7a3361c7 != null && m116x7a3361c7.getIntExtra("plugged", -1) == 2;
    }

    public static boolean hasSimCard(Context context) {
        try {
            int simState = ((TelephonyManager) context.getSystemService("phone")).getSimState();
            return (simState == 1 || simState == 0) ? false : true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean isFridaExist() {
        try {
            InetAddress.getByName(decode("3132372e302e302e31"));
            new Socket("3132372e302e302e31", Integer.parseInt(decode("3237303432")));
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean isXposedExist(Context context) {
        return findHookAppFile() || findHookAppName(context);
    }

    private static boolean findHookAppFile() {
        try {
            HashSet<String> hashSet = new HashSet();
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/" + Process.myPid() + "/maps"));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                if (readLine.endsWith(".so") || readLine.endsWith(".jar")) {
                    hashSet.add(readLine.substring(readLine.lastIndexOf(" ") + 1));
                }
            }
            bufferedReader.close();
            for (String str : hashSet) {
                if (str.contains(decode("636f6d2e73617572696b2e737562737472617465")) || str.contains(decode("58706f7365644272696467652e6a6172")) || str.contains(decode("6c696273616e64686f6f6b2e656478702e736f"))) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean findHookAppName(Context context) {
        List asList = Arrays.asList(decode("64652e726f62762e616e64726f69642e78706f736564"), decode("636f6d2e746f706a6f686e77752e6d616769736b"), decode("696f2e76612e6578706f736564"), decode("636f6d2e77696e642e636f74746572"), decode("6f72672e6d656f776361742e656478706f7365642e6d616e61676572"), decode("6d652e7765697368752e657870"), decode("636f6d2e73617572696b2e737562737472617465"));
        PackageManager packageManager = context.getPackageManager();
        Iterator it = asList.iterator();
        while (it.hasNext()) {
            if (packageManager.getPackageInfo((String) it.next(), 0) != null) {
                return true;
            }
        }
        return false;
    }

    private static String decode(String str) {
        return DownloadUtils.hexToString(str);
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator"})
    /* renamed from: INVOKEVIRTUAL_com_ss_android_socialbase_appdownloader_util_SecurityUtils_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver */
    public static Intent m116x7a3361c7(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen()) {
            ReceiverRegisterCrashOptimizer.doHWReceiverFix();
        }
        try {
            if (ReceiverRegisterCrashOptimizer.doRegisterHandler()) {
                ReceiverRegisterLancet.initHandler();
                Context context2 = context;
                return context.registerReceiver(broadcastReceiver, intentFilter, null, ReceiverRegisterLancet.sReceiverHandler);
            }
            if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null && ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(intentFilter)) {
                ReceiverRegisterLancet.initProxyHandler();
                Context context3 = context;
                return ContextCompat.registerReceiver(context, broadcastReceiver, intentFilter, (String) null, ReceiverRegisterLancet.sProxyHandler, 2);
            }
            return context.registerReceiver(broadcastReceiver, intentFilter);
        } catch (Exception e) {
            if (!ReceiverRegisterCrashOptimizer.fixedOpen()) {
                throw e;
            }
            return ReceiverRegisterCrashOptimizer.registerReceiver(broadcastReceiver, intentFilter);
        }
    }
}
