package com.unicom.online.account.kernel;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.lang.reflect.Method;

/* loaded from: classes7.dex */
public final class x {
    public static boolean a(Context context, String str) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return false;
            }
            NetworkInfo.State state = connectivityManager.getNetworkInfo(5).getState();
            aa.b("TYPE_MOBILE_HIPRI network state: ".concat(String.valueOf(state)));
            if (state.compareTo(NetworkInfo.State.CONNECTED) != 0 && state.compareTo(NetworkInfo.State.CONNECTING) != 0) {
                Method method = ConnectivityManager.class.getMethod("startUsingNetworkFeature", Integer.TYPE, String.class);
                method.setAccessible(true);
                int intValue = ((Integer) method.invoke(connectivityManager, 0, "enableHIPRI")).intValue();
                aa.b("startUsingNetworkFeature for enableHIPRI result: ".concat(String.valueOf(intValue)));
                if (-1 == intValue) {
                    aa.b("Wrong result of startUsingNetworkFeature, maybe problems");
                    return false;
                }
                if (intValue == 0) {
                    aa.b("No need to perform additional network settings");
                    return true;
                }
                int d = ac.d(str);
                if (-1 == d) {
                    aa.b("Wrong host address transformation, result was -1");
                    return false;
                }
                for (int i = 0; i < 5; i++) {
                    try {
                        if (connectivityManager.getNetworkInfo(5).getState().compareTo(NetworkInfo.State.CONNECTED) == 0) {
                            break;
                        }
                        Thread.sleep(500L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        return false;
                    }
                }
                Method method2 = ConnectivityManager.class.getMethod("requestRouteToHost", Integer.TYPE, Integer.TYPE);
                method2.setAccessible(true);
                boolean booleanValue = ((Boolean) method2.invoke(connectivityManager, 5, Integer.valueOf(d))).booleanValue();
                aa.b("requestRouteToHost result: ".concat(String.valueOf(booleanValue)));
                return booleanValue;
            }
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
