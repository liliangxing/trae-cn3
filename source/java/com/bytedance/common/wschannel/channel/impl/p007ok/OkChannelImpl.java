package com.bytedance.common.wschannel.channel.impl.p007ok;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.common.wschannel.WsChannelSdk;
import com.bytedance.common.wschannel.WsChannelSettings;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.channel.IWsChannelClient;
import com.bytedance.common.wschannel.channel.impl.p007ok.WsOkClient;
import com.bytedance.common.wschannel.channel.impl.p007ok.policy.RetryTimesPolicy;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class OkChannelImpl implements IWsChannelClient, WeakHandler.IHandler {
    private static final String MSBridgeMethod = "a";
    private static final String MSBridgeOV = "com.bytedance.mobsec.metasec.ov.MSB";
    public static final String TAG = "WsChannelSdk_ok";
    private static final int T_WSCHANNEL_INIT = 2;
    public static long sInitMSSdkMilliDuration;
    private final int mChannelId;
    private Map<String, Object> mConfigMap = new HashMap();
    private Context mContext;
    private Handler mHandler;
    private boolean mHasInit;
    private ContentObserver mOkChannelEnableObserver;
    private List<String> mUrls;
    private WsOkClient mWsClient;

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message message) {
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onMessage(WsChannelMsg wsChannelMsg) {
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onServiceConnectEvent(int i, boolean z, String str) {
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public boolean privateProtocolEnabled() {
        return false;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public boolean privateProtocolProxyEnabled() {
        return false;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void registerService(int i) {
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public boolean sendMessage(WsChannelMsg wsChannelMsg) {
        return false;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void unregisterService(int i) {
    }

    public OkChannelImpl(int i, Handler handler) {
        this.mChannelId = i;
        this.mHandler = handler;
        this.mOkChannelEnableObserver = new ContentObserver(this.mHandler) { // from class: com.bytedance.common.wschannel.channel.impl.ok.OkChannelImpl.1
            @Override // android.database.ContentObserver
            public void onChange(boolean z) {
                super.onChange(z);
                OkChannelImpl okChannelImpl = OkChannelImpl.this;
                if (okChannelImpl.okChannelEnable(okChannelImpl.mContext)) {
                    OkChannelImpl okChannelImpl2 = OkChannelImpl.this;
                    okChannelImpl2.openConnection(okChannelImpl2.mConfigMap, OkChannelImpl.this.mUrls);
                } else {
                    OkChannelImpl.this.stopConnection();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean okChannelEnable(Context context) {
        return WsChannelSettings.inst(context).isOkChannelEnable();
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void init(Context context, IWsChannelClient iWsChannelClient) {
        if (this.mHasInit) {
            return;
        }
        this.mHasInit = true;
        Log.d(TAG, "init() , channelId = " + this.mChannelId);
        this.mContext = context.getApplicationContext();
        initMSSdk(context);
        WsOkClient build = new WsOkClient.Builder(context).retryPolicy(new RetryTimesPolicy(context)).heartBeatPolicy(WsChannelSdk.getHeartBeatPolicy(this.mChannelId)).build();
        this.mWsClient = build;
        build.setWsStatusListener(new WsStatusChangedListener(this.mContext, this.mWsClient, iWsChannelClient));
        observerSpChanged(context);
    }

    private void initMSSdk(Context context) {
        Class<?> cls;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            cls = Class.forName(MSBridgeOV);
        } catch (ClassNotFoundException unused) {
            Log.d(TAG, "MSSdk Class -com.bytedance.mobsec.metasec.ov.MSB- not found, init fail.");
            sInitMSSdkMilliDuration = -1L;
            cls = null;
        }
        if (cls == null) {
            return;
        }
        try {
            cls.getMethod(MSBridgeMethod, Context.class, Integer.TYPE, Map.class).invoke(cls, context, 2, null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        sInitMSSdkMilliDuration = System.currentTimeMillis() - currentTimeMillis;
    }

    public static long getsInitMSSdkMilliDuration() {
        return sInitMSSdkMilliDuration;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void destroy() {
        Log.d(TAG, "destroy() , channelId = " + this.mChannelId);
        this.mWsClient.destroy();
        unregisterObserver();
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onAppStateChanged(int i) {
        if (okChannelEnable(this.mContext)) {
            Log.d(TAG, "onAppStateChanged(), channelId = " + this.mChannelId);
            this.mWsClient.onAppStateChanged(i == 1);
        }
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onNetworkStateChanged(int i) {
        if (okChannelEnable(this.mContext)) {
            Log.d(TAG, "onNetworkStateChanged(), channelId = " + this.mChannelId);
            this.mWsClient.onNetworkStateChanged(i);
        }
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public boolean isConnected() {
        return this.mWsClient.isConnected();
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void openConnection(Map<String, Object> map, List<String> list) {
        if (map != null) {
            this.mConfigMap.putAll(map);
        }
        this.mUrls = list;
        if (okChannelEnable(this.mContext)) {
            this.mWsClient.connect(map, list);
        }
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void stopConnection() {
        Log.d(TAG, "stopConnection(),channelId = " + this.mChannelId);
        this.mWsClient.stopConnect();
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onParameterChange(Map<String, Object> map, List<String> list) {
        if (map != null) {
            this.mConfigMap.putAll(map);
        }
        this.mUrls = list;
        if (okChannelEnable(this.mContext)) {
            Log.d(TAG, "onParameterChange(),channelId = " + this.mChannelId);
            this.mWsClient.onParameterChange(map, list);
        }
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public boolean sendMessage(byte[] bArr) {
        if (!okChannelEnable(this.mContext)) {
            return false;
        }
        Log.d(TAG, "sendMessage(),channelId = " + this.mChannelId);
        return this.mWsClient.sendMessage(bArr);
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onMessage(byte[] bArr) {
        Log.d(TAG, "onMessage(),channel = " + this.mChannelId);
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onConnection(JSONObject jSONObject) {
        Log.d(TAG, "onConnection()");
    }

    private void observerSpChanged(Context context) {
        try {
            context.getContentResolver().registerContentObserver(WsChannelMultiProcessSharedProvider.getContentUri(context, WsConstants.KEY_OK_IMPL_ENABLE, WsChannelMultiProcessSharedProvider.BOOLEAN_TYPE), true, this.mOkChannelEnableObserver);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void unregisterObserver() {
        try {
            Context context = this.mContext;
            if (context != null) {
                context.getContentResolver().unregisterContentObserver(this.mOkChannelEnableObserver);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
