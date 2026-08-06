package org.chromium.wschannel;

import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.channel.IWsChannelClient;
import com.ttnet.org.chromium.net.impl.CronetFrontierClient;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
final class PrivateProtocolCallbackImpl implements CronetFrontierClient.IConnectionCallback {
    private static final String TAG = "CronetFrontierConnection";
    private IWsChannelClient mClient;
    private CronetFrontierConnection mConnection;

    private static int privateProtocolStateAdapter(int i) {
        if (i == 2) {
            return 4;
        }
        if (i == 3) {
            return 2;
        }
        if (i != 4) {
            return i;
        }
        return 3;
    }

    public PrivateProtocolCallbackImpl(IWsChannelClient iWsChannelClient, CronetFrontierConnection cronetFrontierConnection) {
        this.mClient = iWsChannelClient;
        this.mConnection = cronetFrontierConnection;
    }

    private boolean shouldIgnoreStateCallback(int i) {
        if ((i != 2 && i != 3 && i != 4) || !this.mConnection.isFallbackTaskRunning()) {
            return false;
        }
        if (!Logger.debug()) {
            return true;
        }
        Logger.d(TAG, "Wait fallback task running and ignore state:" + i);
        return true;
    }

    public void onConnectionStateChanged(int i, String str) {
        int privateProtocolStateAdapter = privateProtocolStateAdapter(i);
        if (Logger.debug()) {
            Logger.d(TAG, "PP onConnectionStateChanged state:" + privateProtocolStateAdapter + " url:" + str);
        }
        if (privateProtocolStateAdapter == 4) {
            this.mConnection.setFirstStreamReady(false);
        }
        if (shouldIgnoreStateCallback(privateProtocolStateAdapter)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", 1);
            jSONObject.put("private_protocol_enable", 1);
            jSONObject.put("state", privateProtocolStateAdapter);
            jSONObject.put("url", str);
            this.mClient.onConnection(jSONObject);
        } catch (Throwable unused) {
        }
    }

    public void onConnectionError(int i, String str, String str2) {
        int privateProtocolStateAdapter = privateProtocolStateAdapter(i);
        if (Logger.debug()) {
            Logger.d(TAG, "PP onConnectionError state:" + privateProtocolStateAdapter + " url:" + str + " error:" + str2);
        }
        if (shouldIgnoreStateCallback(privateProtocolStateAdapter)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", 0);
            jSONObject.put("private_protocol_enable", 1);
            jSONObject.put("state", privateProtocolStateAdapter);
            jSONObject.put("url", str);
            jSONObject.put("error", str2);
            if (DestroyTimeoutControl.isConnectionTimeout(str2, false)) {
                jSONObject.put("error_code", -192);
                if (Logger.debug()) {
                    Logger.d(TAG, "PP connection timeout.");
                }
            }
            this.mClient.onConnection(jSONObject);
        } catch (Throwable unused) {
        }
    }

    public static String extractConnectionId(String str) {
        try {
            return new JSONObject(str).optString("connection_id");
        } catch (Exception unused) {
            return "";
        }
    }

    public void onTrafficChanged(String str, long j, long j2, boolean z) {
        try {
            TrafficChangedObservable.inst().onTrafficChanged(str, j, j2, z);
        } catch (Throwable unused) {
        }
    }
}
