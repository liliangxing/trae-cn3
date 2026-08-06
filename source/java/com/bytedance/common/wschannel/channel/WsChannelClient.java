package com.bytedance.common.wschannel.channel;

import android.content.Context;
import android.os.Handler;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.channel.impl.p007ok.OkChannelImpl;
import com.bytedance.common.wschannel.model.ServiceConnectEvent;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class WsChannelClient implements IWsChannelClient {
    private static final String CRONET_CHANNEL_IMPL_CLASS = "org.chromium.wschannel.MySelfChannelImpl";
    private static final String MYSELF_CHANNEL_IMPL_CLASS = "com.b.c.ws.MySelfChannelImpl";
    private static final String TAG = "WsChannelClient";
    private static String sMyselfChannelImplClass = "";
    private final int mChannelId;
    private final Handler mHandler;
    private IMessageHandler mMessageHandler;
    private List<String> mUrls;
    private boolean mUseCronetPlugin = true;
    private IWsChannelClient mWsChannelImpl;

    public static void setMyselfChannelImplClass(String str) {
        sMyselfChannelImplClass = str;
    }

    public boolean isOkChannelImpl() {
        return this.mWsChannelImpl instanceof OkChannelImpl;
    }

    private WsChannelClient(int i, IMessageHandler iMessageHandler, Handler handler) {
        this.mChannelId = i;
        this.mMessageHandler = iMessageHandler;
        this.mHandler = handler;
        try {
            tryResolveMySelfChannelImpl();
            if (this.mUseCronetPlugin) {
                Logger.m190d(TAG, "use cronet to connect");
            } else {
                Logger.m190d(TAG, "use PushManager to connect");
            }
        } catch (ClassNotFoundException unused) {
            Logger.m190d(TAG, "don't find plugin or plugin download failed");
        } catch (Throwable th) {
            th.printStackTrace();
            Logger.m190d(TAG, "don't find plugin");
        }
        if (this.mWsChannelImpl == null) {
            Logger.m190d(TAG, "use okhttp to connect");
            this.mWsChannelImpl = new OkChannelImpl(i, handler);
        }
    }

    public static WsChannelClient newInstance(int i, IMessageHandler iMessageHandler, Handler handler) {
        return new WsChannelClient(i, iMessageHandler, handler);
    }

    private void tryResolveMySelfChannelImpl() throws Exception {
        if (this.mWsChannelImpl == null) {
            Class<?> checkClass = !StringUtils.isEmpty(sMyselfChannelImplClass) ? checkClass(sMyselfChannelImplClass) : null;
            if (checkClass == null) {
                checkClass = checkClass(CRONET_CHANNEL_IMPL_CLASS);
                this.mUseCronetPlugin = true;
            }
            if (checkClass == null) {
                checkClass = checkClass(MYSELF_CHANNEL_IMPL_CLASS);
                this.mUseCronetPlugin = false;
            }
            if (checkClass == null) {
                throw new ClassNotFoundException("plugin class not found");
            }
            Object newInstance = checkClass.newInstance();
            if (newInstance instanceof IWsChannelClient) {
                this.mWsChannelImpl = (IWsChannelClient) newInstance;
            }
        }
    }

    private Class<?> checkClass(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void init(Context context, IWsChannelClient iWsChannelClient) {
        IWsChannelClient iWsChannelClient2 = this.mWsChannelImpl;
        if (iWsChannelClient2 != null) {
            try {
                iWsChannelClient2.init(context, iWsChannelClient);
            } catch (Throwable th) {
                if (!(this.mWsChannelImpl instanceof OkChannelImpl)) {
                    th.printStackTrace();
                    Logger.m190d(TAG, "cronet socket init failed，use okhttp to connect");
                    OkChannelImpl okChannelImpl = new OkChannelImpl(this.mChannelId, this.mHandler);
                    this.mWsChannelImpl = okChannelImpl;
                    okChannelImpl.init(context, iWsChannelClient);
                    return;
                }
                throw th;
            }
        }
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void destroy() {
        synchronized (this) {
            IWsChannelClient iWsChannelClient = this.mWsChannelImpl;
            if (iWsChannelClient != null) {
                iWsChannelClient.destroy();
                if (!(this.mWsChannelImpl instanceof OkChannelImpl)) {
                    JSONObject jSONObject = new JSONObject();
                    List<String> list = this.mUrls;
                    String str = (list == null || list.size() < 1) ? "" : this.mUrls.get(0);
                    try {
                        jSONObject.put("type", 0);
                        jSONObject.put("state", 3);
                        jSONObject.put("url", str);
                        jSONObject.put(WsConstants.KEY_CHANNEL_TYPE, 1);
                        onConnectionInternal(jSONObject);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onAppStateChanged(int i) {
        IWsChannelClient iWsChannelClient = this.mWsChannelImpl;
        if (iWsChannelClient != null) {
            iWsChannelClient.onAppStateChanged(i);
        }
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onNetworkStateChanged(int i) {
        IWsChannelClient iWsChannelClient = this.mWsChannelImpl;
        if (iWsChannelClient != null) {
            iWsChannelClient.onNetworkStateChanged(i);
        }
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public boolean isConnected() {
        IWsChannelClient iWsChannelClient = this.mWsChannelImpl;
        if (iWsChannelClient != null) {
            return iWsChannelClient.isConnected();
        }
        return false;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void openConnection(Map<String, Object> map, List<String> list) {
        IWsChannelClient iWsChannelClient = this.mWsChannelImpl;
        if (iWsChannelClient != null) {
            iWsChannelClient.openConnection(map, list);
        }
        this.mUrls = list;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void stopConnection() {
        IWsChannelClient iWsChannelClient = this.mWsChannelImpl;
        if (iWsChannelClient != null) {
            iWsChannelClient.stopConnection();
        }
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onParameterChange(Map<String, Object> map, List<String> list) {
        IWsChannelClient iWsChannelClient = this.mWsChannelImpl;
        if (iWsChannelClient != null) {
            iWsChannelClient.onParameterChange(map, list);
        }
        this.mUrls = list;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public boolean sendMessage(byte[] bArr) {
        IWsChannelClient iWsChannelClient = this.mWsChannelImpl;
        if (iWsChannelClient != null) {
            return iWsChannelClient.sendMessage(bArr);
        }
        return false;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onMessage(byte[] bArr) {
        IMessageHandler iMessageHandler = this.mMessageHandler;
        if (iMessageHandler != null) {
            iMessageHandler.onMessage(this.mChannelId, bArr);
        }
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onConnection(JSONObject jSONObject) {
        synchronized (this) {
            onConnectionInternal(jSONObject);
        }
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onServiceConnectEvent(int i, boolean z, String str) {
        IMessageHandler iMessageHandler = this.mMessageHandler;
        if (iMessageHandler != null) {
            iMessageHandler.onServiceConnectEvent(new ServiceConnectEvent(this.mChannelId, i, z, str));
        }
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public boolean privateProtocolEnabled() {
        IWsChannelClient iWsChannelClient = this.mWsChannelImpl;
        if (iWsChannelClient != null) {
            return iWsChannelClient.privateProtocolEnabled();
        }
        return false;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public boolean privateProtocolProxyEnabled() {
        IWsChannelClient iWsChannelClient = this.mWsChannelImpl;
        if (iWsChannelClient != null) {
            return iWsChannelClient.privateProtocolProxyEnabled();
        }
        return false;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public boolean sendMessage(WsChannelMsg wsChannelMsg) {
        IWsChannelClient iWsChannelClient = this.mWsChannelImpl;
        if (iWsChannelClient != null) {
            return iWsChannelClient.sendMessage(wsChannelMsg);
        }
        return false;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onMessage(WsChannelMsg wsChannelMsg) {
        IMessageHandler iMessageHandler = this.mMessageHandler;
        if (iMessageHandler != null) {
            iMessageHandler.onMessage(this.mChannelId, wsChannelMsg);
        }
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void registerService(int i) {
        IWsChannelClient iWsChannelClient = this.mWsChannelImpl;
        if (iWsChannelClient != null) {
            iWsChannelClient.registerService(i);
        }
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void unregisterService(int i) {
        IWsChannelClient iWsChannelClient = this.mWsChannelImpl;
        if (iWsChannelClient != null) {
            iWsChannelClient.unregisterService(i);
        }
    }

    private void onConnectionInternal(JSONObject jSONObject) {
        IMessageHandler iMessageHandler = this.mMessageHandler;
        if (iMessageHandler != null) {
            iMessageHandler.onConnection(this, this.mChannelId, jSONObject);
        }
    }
}
