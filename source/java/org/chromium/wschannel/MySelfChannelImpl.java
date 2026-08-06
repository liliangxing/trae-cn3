package org.chromium.wschannel;

import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.wschannel.channel.IWsChannelClient;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.ttnet.org.chromium.net.impl.UserAgent;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class MySelfChannelImpl implements IWsChannelClient, WeakHandler.IHandler {
    private static final String TAG = "MySelfChannelImpl";
    private static String WSCHANNEL_ACTION_BACK;
    private static String WSCHANNEL_ACTION_FORE;
    private static String sPackageName;
    private static volatile String sUserAgent;
    private Context mContext;
    private CronetFrontierConnection mFrontierConnection;
    private IWsChannelClient mWsChannelClient;

    public void onNetworkStateChanged(int i) {
    }

    public void init(Context context, IWsChannelClient iWsChannelClient) {
        if (Logger.debug()) {
            Logger.d(TAG, "MySelfChannelImpl init");
        }
        this.mContext = context;
        sPackageName = context.getPackageName();
        this.mWsChannelClient = iWsChannelClient;
        this.mFrontierConnection = new CronetFrontierConnection(this);
        if (TextUtils.isEmpty(sUserAgent)) {
            try {
                sUserAgent = UserAgent.from(context);
            } catch (Throwable unused) {
            }
        }
        WSCHANNEL_ACTION_BACK = this.mContext.getPackageName() + ".wschannel.APP_BACKGROUND";
        WSCHANNEL_ACTION_FORE = this.mContext.getPackageName() + ".wschannel.APP_FOREGROUND";
    }

    public static String getDefaultUserAgent() {
        return sUserAgent;
    }

    public void destroy() {
        CronetFrontierConnection cronetFrontierConnection = this.mFrontierConnection;
        if (cronetFrontierConnection != null) {
            cronetFrontierConnection.destroyConnection();
        }
    }

    public void onAppStateChanged(int i) {
        Intent intent = new Intent();
        if (i == 1) {
            intent.setAction(WSCHANNEL_ACTION_FORE);
            if (!TextUtils.isEmpty(sPackageName)) {
                intent.setPackage(sPackageName);
            }
            this.mContext.sendBroadcast(intent);
            return;
        }
        if (i == 2) {
            intent.setAction(WSCHANNEL_ACTION_BACK);
            if (!TextUtils.isEmpty(sPackageName)) {
                intent.setPackage(sPackageName);
            }
            this.mContext.sendBroadcast(intent);
        }
    }

    public boolean isConnected() {
        CronetFrontierConnection cronetFrontierConnection = this.mFrontierConnection;
        if (cronetFrontierConnection != null) {
            return cronetFrontierConnection.isConnected();
        }
        return false;
    }

    public void openConnection(Map<String, Object> map, List<String> list) {
        CronetFrontierConnection cronetFrontierConnection = this.mFrontierConnection;
        if (cronetFrontierConnection != null) {
            cronetFrontierConnection.startConnection(map, list);
        }
    }

    public void stopConnection() {
        CronetFrontierConnection cronetFrontierConnection = this.mFrontierConnection;
        if (cronetFrontierConnection != null) {
            cronetFrontierConnection.stopConnection();
        }
    }

    public void onParameterChange(Map<String, Object> map, List<String> list) {
        CronetFrontierConnection cronetFrontierConnection = this.mFrontierConnection;
        if (cronetFrontierConnection != null) {
            cronetFrontierConnection.stopConnection();
        }
        openConnection(map, list);
    }

    public boolean sendMessage(byte[] bArr) {
        if (Logger.debug()) {
            Logger.d(TAG, "WS sendMessage data:" + bArr.toString());
        }
        CronetFrontierConnection cronetFrontierConnection = this.mFrontierConnection;
        if (cronetFrontierConnection == null) {
            return false;
        }
        if (cronetFrontierConnection.privateProtocolEnabled() && this.mFrontierConnection.privateProtocolProxyEnabled()) {
            return this.mFrontierConnection.sendMessageWithPrivateProtocolProxy(bArr);
        }
        return this.mFrontierConnection.sendMessageWithWebSocket(bArr);
    }

    public boolean sendMessage(WsChannelMsg wsChannelMsg) {
        if (Logger.debug()) {
            Logger.d(TAG, "PP data:" + wsChannelMsg.toString());
        }
        CronetFrontierConnection cronetFrontierConnection = this.mFrontierConnection;
        if (cronetFrontierConnection == null) {
            return false;
        }
        return cronetFrontierConnection.sendMessageWithPrivateProtocol(wsChannelMsg);
    }

    public void onMessage(byte[] bArr) {
        IWsChannelClient iWsChannelClient = this.mWsChannelClient;
        if (iWsChannelClient != null) {
            iWsChannelClient.onMessage(bArr);
        }
    }

    public void onConnection(JSONObject jSONObject) {
        if (this.mWsChannelClient != null) {
            try {
                jSONObject.put("channel_type", 1);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.mWsChannelClient.onConnection(jSONObject);
        }
    }

    public void onServiceConnectEvent(int i, boolean z, String str) {
        IWsChannelClient iWsChannelClient = this.mWsChannelClient;
        if (iWsChannelClient != null) {
            iWsChannelClient.onServiceConnectEvent(i, z, str);
        }
    }

    public boolean privateProtocolEnabled() {
        CronetFrontierConnection cronetFrontierConnection = this.mFrontierConnection;
        if (cronetFrontierConnection != null) {
            return cronetFrontierConnection.privateProtocolEnabled();
        }
        return false;
    }

    public boolean privateProtocolProxyEnabled() {
        CronetFrontierConnection cronetFrontierConnection = this.mFrontierConnection;
        if (cronetFrontierConnection != null) {
            return cronetFrontierConnection.privateProtocolProxyEnabled();
        }
        return false;
    }

    public void onMessage(WsChannelMsg wsChannelMsg) {
        IWsChannelClient iWsChannelClient = this.mWsChannelClient;
        if (iWsChannelClient != null) {
            iWsChannelClient.onMessage(wsChannelMsg);
        }
    }

    public void registerService(int i) {
        CronetFrontierConnection cronetFrontierConnection = this.mFrontierConnection;
        if (cronetFrontierConnection != null) {
            cronetFrontierConnection.registerService(i);
        }
    }

    public void unregisterService(int i) {
        CronetFrontierConnection cronetFrontierConnection = this.mFrontierConnection;
        if (cronetFrontierConnection != null) {
            cronetFrontierConnection.unregisterService(i);
        }
    }

    public void handleMsg(Message message) {
        if (Logger.debug()) {
            Logger.d(TAG, "handleMsg data:" + message.toString());
        }
    }
}
