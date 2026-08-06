package com.bytedance.common.wschannel.client;

import android.content.Context;
import android.os.Message;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsChannelSettings;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.client.WsChannelApi;
import com.bytedance.common.wschannel.model.IntegerParcelable;
import com.bytedance.common.wschannel.model.ServiceParcelable;
import com.bytedance.common.wschannel.model.SsWsApp;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.bytedance.common.wschannel.server.MainChannelManager;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class WsChannelSingleProcessImpl implements WsChannelApi {
    @Override // com.bytedance.common.wschannel.client.WsChannelApi
    public void onTrimMemory(Context context, int i) {
    }

    @Override // com.bytedance.common.wschannel.client.WsChannelApi
    public void tryStartPushProcess(Context context, boolean z) {
    }

    @Override // com.bytedance.common.wschannel.client.WsChannelApi
    public void tryStartPushProcess(Context context, boolean z, boolean z2) {
    }

    private void sendAppState(Context context, int i) {
        if (context == null || i <= 0 || i > 3) {
            return;
        }
        if (Logger.debug()) {
            Logger.m190d("WsChannelSdk", "sendAppState appState = " + i);
        }
        if (WsChannelSettings.inst(context).isEnable()) {
            Message message = new Message();
            message.what = 2;
            message.arg1 = i;
            MainChannelManager.inst(context).handleMsg(message);
        }
    }

    @Override // com.bytedance.common.wschannel.client.WsChannelApi
    public void onEnterToForeground(Context context) {
        sendAppState(context, 1);
    }

    @Override // com.bytedance.common.wschannel.client.WsChannelApi
    public void sendPayload(Context context, WsChannelMsg wsChannelMsg) {
        WsChannelApi.ServiceHolder serviceHolder = new WsChannelApi.ServiceHolder();
        serviceHolder.key = WsConstants.KEY_PAYLOAD;
        serviceHolder.obj = wsChannelMsg;
        serviceHolder.what = 5;
        sendMsg(context, serviceHolder);
    }

    @Override // com.bytedance.common.wschannel.client.WsChannelApi
    public void registerApp(Context context, SsWsApp ssWsApp) {
        WsChannelApi.ServiceHolder serviceHolder = new WsChannelApi.ServiceHolder();
        serviceHolder.key = WsConstants.KEY_WS_APP;
        serviceHolder.obj = ssWsApp;
        serviceHolder.what = 0;
        sendMsg(context, serviceHolder);
    }

    private void sendMsg(Context context, WsChannelApi.ServiceHolder serviceHolder) {
        Message obtain = Message.obtain();
        obtain.what = serviceHolder.what;
        obtain.getData().putParcelable(serviceHolder.key, serviceHolder.obj);
        MainChannelManager.inst(context).handleMsg(obtain);
    }

    @Override // com.bytedance.common.wschannel.client.WsChannelApi
    public void unRegisterApp(Context context, int i) {
        WsChannelApi.ServiceHolder serviceHolder = new WsChannelApi.ServiceHolder();
        serviceHolder.key = WsConstants.KEY_WS_APP;
        serviceHolder.obj = new IntegerParcelable(i);
        serviceHolder.what = 1;
        sendMsg(context, serviceHolder);
    }

    @Override // com.bytedance.common.wschannel.client.WsChannelApi
    public void onParameterChange(Context context, SsWsApp ssWsApp) {
        if (WsChannelSettings.inst(context).isEnable()) {
            WsChannelApi.ServiceHolder serviceHolder = new WsChannelApi.ServiceHolder();
            serviceHolder.key = WsConstants.KEY_WS_APP;
            serviceHolder.obj = ssWsApp;
            serviceHolder.what = 4;
            sendMsg(context, serviceHolder);
        }
    }

    @Override // com.bytedance.common.wschannel.client.WsChannelApi
    public void onEnterToBackground(Context context) {
        sendAppState(context, 2);
    }

    @Override // com.bytedance.common.wschannel.client.WsChannelApi
    public void registerServiceId(Context context, int i, int i2) {
        WsChannelApi.ServiceHolder serviceHolder = new WsChannelApi.ServiceHolder();
        serviceHolder.key = WsConstants.KEY_WS_APP;
        serviceHolder.obj = new ServiceParcelable(i, i2);
        serviceHolder.what = 12;
        sendMsg(context, serviceHolder);
    }

    @Override // com.bytedance.common.wschannel.client.WsChannelApi
    public void unregisterServiceId(Context context, int i, int i2) {
        WsChannelApi.ServiceHolder serviceHolder = new WsChannelApi.ServiceHolder();
        serviceHolder.key = WsConstants.KEY_WS_APP;
        serviceHolder.obj = new ServiceParcelable(i, i2);
        serviceHolder.what = 13;
        sendMsg(context, serviceHolder);
    }
}
