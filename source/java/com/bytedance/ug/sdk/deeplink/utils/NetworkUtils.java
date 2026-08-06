package com.bytedance.ug.sdk.deeplink.utils;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.ttnet.utils.RetrofitUtils;
import com.bytedance.ug.sdk.deeplink.ZlinkProviderManager;
import com.bytedance.ug.sdk.deeplink.callback.CallBackForFetchScheme;
import com.bytedance.ug.sdk.deeplink.interfaces.INetwork;
import com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter;
import com.ss.android.ugc.quota.BDNetworkTagManager;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class NetworkUtils {
    private static String TAG = "NetworkUtils";

    private NetworkUtils() {
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    private static class InstanceHolder {
        private static NetworkUtils sNetworkUtils = new NetworkUtils();

        private InstanceHolder() {
        }
    }

    public static NetworkUtils getInstance() {
        return InstanceHolder.sNetworkUtils;
    }

    public String getSecureUrl(String str) {
        return (TextUtils.isEmpty(str) || !str.startsWith("http") || str.startsWith("https")) ? str : "https" + str.substring(4);
    }

    private Map<String, String> addNetworkTagToHeader(Map<String, String> map) {
        try {
            BDNetworkTagContextProviderAdapter bDNetworkTagContextProviderAdapter = new BDNetworkTagContextProviderAdapter() { // from class: com.bytedance.ug.sdk.deeplink.utils.NetworkUtils.1
                public int triggerType() {
                    return 0;
                }

                public boolean markAsNewUser() {
                    return super.markAsNewUser();
                }
            };
            Map hashMap = map == null ? new HashMap() : map;
            Pair buildBDNetworkTag = BDNetworkTagManager.getInstance().buildBDNetworkTag(bDNetworkTagContextProviderAdapter);
            hashMap.put(buildBDNetworkTag.first, buildBDNetworkTag.second);
            return hashMap;
        } catch (Exception unused) {
            return map;
        }
    }

    public String executeGetRequest(String str, Map<String, String> map, boolean z, long j) {
        INetwork iNetwork = (INetwork) ZlinkProviderManager.getProvider(INetwork.class);
        if (iNetwork == null) {
            return null;
        }
        try {
            return iNetwork.get(str, addNetworkTagToHeader(map), z, j);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public void fetchScheme(String str, String str2, int i, CallBackForFetchScheme callBackForFetchScheme) {
        INetwork iNetwork = (INetwork) ZlinkProviderManager.getProvider(INetwork.class);
        if (iNetwork != null) {
            try {
                iNetwork.fetchScheme(str, str2, i, callBackForFetchScheme);
            } catch (Throwable th) {
                Logger.m447e(TAG, th.getMessage());
            }
        }
    }

    public String executePostRequest(String str) {
        return executePostRequest(str, new HashMap(), new byte[0], 0L, null);
    }

    public String executePostRequest(String str, Map<String, String> map, byte[] bArr, long j, JSONObject jSONObject) {
        return executePostRequest(str, map, bArr, j, false, RetrofitUtils.CONTENT_TYPE_JSON, true, jSONObject);
    }

    public String executePostRequest(String str, Map<String, String> map, byte[] bArr, long j, boolean z, String str2, boolean z2, JSONObject jSONObject) {
        INetwork iNetwork = (INetwork) ZlinkProviderManager.getProvider(INetwork.class);
        if (iNetwork == null) {
            return null;
        }
        try {
            return iNetwork.post(str, addNetworkTagToHeader(map), bArr, j, z, str2, z2);
        } catch (Throwable th) {
            th.printStackTrace();
            JSONUtils.safePutString(jSONObject, "code", th.getMessage());
            return null;
        }
    }
}
