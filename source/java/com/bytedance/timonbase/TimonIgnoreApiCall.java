package com.bytedance.timonbase;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.TransportInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Process;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.bytedance.sdk.account.platform.onekey.bpea.BpeaManager;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TimonIgnoreApiCall.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004J\u0016\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004J%\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0011¢\u0006\u0002\u0010\u0012J\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0016\u001a\u00020\u0017J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\b\u001a\u0004\u0018\u00010\tJ\"\u0010\u001a\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001dH\u0007J \u0010\u001a\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0007J\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007J+\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00040\u00112\u0006\u0010%\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010&J+\u0010 \u001a\u00020!2\u0006\u0010'\u001a\u00020(2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00040\u00112\u0006\u0010%\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010)J\u0018\u0010*\u001a\u00020+2\u0006\u0010\"\u001a\u00020#2\u0006\u0010\n\u001a\u00020\u0004H\u0007J\u0018\u0010,\u001a\u00020+2\u0006\u0010'\u001a\u00020(2\u0006\u0010\n\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/bytedance/timonbase/TimonIgnoreApiCall;", "", "()V", "GET_CONNECTION_INFO_ID", "", "IGNORE_FLAG", "checkPermission", "", "context", "Landroid/content/Context;", "permission", "checkSelfPermission", "exec", "Ljava/lang/Process;", "runtime", "Ljava/lang/Runtime;", "args", "", "(Ljava/lang/Runtime;[Ljava/lang/Object;)Ljava/lang/Process;", "getAppList", "", "Landroid/content/pm/PackageInfo;", "pm", "Landroid/content/pm/PackageManager;", BpeaManager.getConnectionInfo, "Landroid/net/wifi/WifiInfo;", "getPackageInfo", "packageName", "flag", "Landroid/content/pm/PackageManager$PackageInfoFlags;", "getTransportInfo", "Landroid/net/TransportInfo;", "requestPermissions", "", "activity", "Landroid/app/Activity;", "permissions", "requestCode", "(Landroid/app/Activity;[Ljava/lang/String;I)V", "fragment", "Landroid/app/Fragment;", "(Landroid/app/Fragment;[Ljava/lang/String;I)V", "shouldShowRequestPermissionRationale", "", "shouldShowRequestPermissionRationaleByFragment", "timonbase_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TimonIgnoreApiCall {
    public static final TimonIgnoreApiCall INSTANCE = new TimonIgnoreApiCall();
    private static final String IGNORE_FLAG = IGNORE_FLAG;
    private static final String IGNORE_FLAG = IGNORE_FLAG;
    private static final String GET_CONNECTION_INFO_ID = String.valueOf(102301);

    private TimonIgnoreApiCall() {
    }

    public final Process exec(Runtime runtime, Object[] args) {
        Intrinsics.checkParameterIsNotNull(runtime, "runtime");
        Intrinsics.checkParameterIsNotNull(args, "args");
        Object firstOrNull = ArraysKt.firstOrNull(args);
        if (firstOrNull instanceof String) {
            int length = args.length;
            if (length == 1) {
                return runtime.exec((String) firstOrNull);
            }
            if (length == 2) {
                String str = (String) firstOrNull;
                Object obj = args[1];
                if (obj != null) {
                    return runtime.exec(str, (String[]) obj);
                }
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
            }
            if (length != 3) {
                return null;
            }
            String str2 = (String) firstOrNull;
            Object obj2 = args[1];
            if (obj2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
            }
            String[] strArr = (String[]) obj2;
            Object obj3 = args[2];
            if (obj3 != null) {
                return runtime.exec(str2, strArr, (File) obj3);
            }
            throw new TypeCastException("null cannot be cast to non-null type java.io.File");
        }
        if (!(firstOrNull instanceof Object[])) {
            return null;
        }
        int length2 = args.length;
        if (length2 == 1) {
            return runtime.exec((String[]) firstOrNull);
        }
        if (length2 == 2) {
            String[] strArr2 = (String[]) firstOrNull;
            Object obj4 = args[1];
            if (obj4 != null) {
                return runtime.exec(strArr2, (String[]) obj4);
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
        }
        if (length2 != 3) {
            return null;
        }
        String[] strArr3 = (String[]) firstOrNull;
        Object obj5 = args[1];
        if (obj5 == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
        }
        String[] strArr4 = (String[]) obj5;
        Object obj6 = args[2];
        if (obj6 != null) {
            return runtime.exec(strArr3, strArr4, (File) obj6);
        }
        throw new TypeCastException("null cannot be cast to non-null type java.io.File");
    }

    public final PackageInfo getPackageInfo(PackageManager pm, String packageName, int flag) {
        Intrinsics.checkParameterIsNotNull(packageName, "packageName");
        if (pm == null) {
            return new PackageInfo();
        }
        PackageInfo packageInfo = pm.getPackageInfo(packageName, flag);
        Intrinsics.checkExpressionValueIsNotNull(packageInfo, "pm.getPackageInfo(packageName, flag)");
        return packageInfo;
    }

    public final PackageInfo getPackageInfo(PackageManager pm, String packageName, PackageManager.PackageInfoFlags flag) {
        Intrinsics.checkParameterIsNotNull(packageName, "packageName");
        Intrinsics.checkParameterIsNotNull(flag, "flag");
        if (pm == null) {
            return new PackageInfo();
        }
        PackageInfo packageInfo = pm.getPackageInfo(packageName, flag);
        Intrinsics.checkExpressionValueIsNotNull(packageInfo, "pm.getPackageInfo(packageName, flag)");
        return packageInfo;
    }

    public final List<PackageInfo> getAppList(PackageManager pm) {
        Intrinsics.checkParameterIsNotNull(pm, "pm");
        List<PackageInfo> installedPackages = pm.getInstalledPackages(0);
        Intrinsics.checkExpressionValueIsNotNull(installedPackages, "pm.getInstalledPackages(0)");
        return installedPackages;
    }

    public final WifiInfo getConnectionInfo(Context context) {
        Context applicationContext;
        try {
            String str = GET_CONNECTION_INFO_ID;
            TimonIgnoreToken.add(str, IGNORE_FLAG);
            Object systemService = (context == null || (applicationContext = context.getApplicationContext()) == null) ? null : applicationContext.getSystemService(OnekeyLoginConstants.NETWORK_TYPE_WIFI_STR);
            if (!(systemService instanceof WifiManager)) {
                systemService = null;
            }
            WifiManager wifiManager = (WifiManager) systemService;
            WifiInfo connectionInfo = wifiManager != null ? wifiManager.getConnectionInfo() : null;
            TimonIgnoreToken.remove(str);
            return connectionInfo;
        } catch (Throwable unused) {
            TimonIgnoreToken.remove(GET_CONNECTION_INFO_ID);
            return null;
        }
    }

    public final TransportInfo getTransportInfo(Context context) {
        Context applicationContext;
        Object systemService = (context == null || (applicationContext = context.getApplicationContext()) == null) ? null : applicationContext.getSystemService("connectivity");
        if (!(systemService instanceof ConnectivityManager)) {
            systemService = null;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        NetworkCapabilities networkCapabilities = connectivityManager != null ? connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork()) : null;
        if (networkCapabilities != null) {
            return networkCapabilities.getTransportInfo();
        }
        return null;
    }

    public final int checkPermission(Context context, String permission) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(permission, "permission");
        return context.checkPermission(permission, Process.myPid(), Process.myUid());
    }

    public final int checkSelfPermission(Context context, String permission) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(permission, "permission");
        return context.checkSelfPermission(permission);
    }

    public final void requestPermissions(Activity activity, String[] permissions, int requestCode) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        Intrinsics.checkParameterIsNotNull(permissions, "permissions");
        activity.requestPermissions(permissions, requestCode);
    }

    public final void requestPermissions(Fragment fragment, String[] permissions, int requestCode) {
        Intrinsics.checkParameterIsNotNull(fragment, "fragment");
        Intrinsics.checkParameterIsNotNull(permissions, "permissions");
        fragment.requestPermissions(permissions, requestCode);
    }

    public final boolean shouldShowRequestPermissionRationale(Activity activity, String permission) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        Intrinsics.checkParameterIsNotNull(permission, "permission");
        return activity.shouldShowRequestPermissionRationale(permission);
    }

    public final boolean shouldShowRequestPermissionRationaleByFragment(Fragment fragment, String permission) {
        Intrinsics.checkParameterIsNotNull(fragment, "fragment");
        Intrinsics.checkParameterIsNotNull(permission, "permission");
        return fragment.shouldShowRequestPermissionRationale(permission);
    }
}
