package com.bytedance.bdinstall.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.bdinstall.DrLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class NetUtils {
    public static boolean isNetReady(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isAvailable();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static List<Pair<String, String>> parseResponseHeaders(Map<String, List<String>> map) {
        ArrayList arrayList = new ArrayList();
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                for (int i = 0; i < entry.getValue().size(); i++) {
                    if (!TextUtils.isEmpty(entry.getKey())) {
                        arrayList.add(new Pair(entry.getKey(), entry.getValue().get(i)));
                    }
                }
            }
            DrLog.d("NetUtils#parseHeaders" + arrayList);
        }
        return arrayList;
    }

    public static List<Pair<String, String>> parseRequestHeaders(Map<String, String> map) {
        ArrayList arrayList = new ArrayList();
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                arrayList.add(new Pair(entry.getKey(), entry.getValue()));
            }
            DrLog.d("NetUtils#parseHeaders" + arrayList);
        }
        return arrayList;
    }
}
