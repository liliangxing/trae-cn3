package com.bytedance.ttnet;

import com.bytedance.frameworks.baselib.network.http.cronet.impl.SsCronetHttpClient;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class TTNetworkQualityEstimator {
    public static int getNetworkQualityLevel() {
        try {
            SsCronetHttpClient cronetHttpClient = getCronetHttpClient();
            if (cronetHttpClient != null) {
                return cronetHttpClient.getNetworkQualityLevel();
            }
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int getEffectiveHttpRttMs() {
        try {
            SsCronetHttpClient cronetHttpClient = getCronetHttpClient();
            if (cronetHttpClient != null) {
                return cronetHttpClient.getEffectiveHttpRttMs();
            }
            return -1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static int getEffectiveTransportRttMs() {
        try {
            SsCronetHttpClient cronetHttpClient = getCronetHttpClient();
            if (cronetHttpClient != null) {
                return cronetHttpClient.getEffectiveTransportRttMs();
            }
            return -1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static int getEffectiveRxThroughputKbps() {
        try {
            SsCronetHttpClient cronetHttpClient = getCronetHttpClient();
            if (cronetHttpClient != null) {
                return cronetHttpClient.getEffectiveRxThroughputKbps();
            }
            return -1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    private static SsCronetHttpClient getCronetHttpClient() throws Exception {
        if (HttpClient.isCronetClientEnable()) {
            return SsCronetHttpClient.inst(TTNetInit.getTTNetDepend().getContext());
        }
        throw new UnsupportedOperationException("Cronet is not enabled");
    }
}
