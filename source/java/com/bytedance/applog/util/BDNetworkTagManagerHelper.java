package com.bytedance.applog.util;

import com.ss.android.ugc.quota.BDNetworkTagManager;
import java.util.Map;

/* loaded from: classes3.dex */
public class BDNetworkTagManagerHelper {
    public static void addHeader(Map<String, String> map, boolean z) {
        map.put(BDNetworkTagManager.KEY_BD_NETWORK_REQUEST_TAG, "t=0;n=" + (z ? 1 : 0));
    }
}
