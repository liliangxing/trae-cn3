package com.bytedance.common.wschannel.client;

import android.content.Context;
import android.os.Parcelable;
import com.bytedance.common.wschannel.model.SsWsApp;
import com.bytedance.common.wschannel.model.WsChannelMsg;

/* loaded from: classes3.dex */
public interface WsChannelApi {

    /* loaded from: classes3.dex */
    public static class ServiceHolder {
        String key;
        Parcelable obj;
        int what;
    }

    void onEnterToBackground(Context context);

    void onEnterToForeground(Context context);

    void onParameterChange(Context context, SsWsApp ssWsApp);

    void onTrimMemory(Context context, int i);

    void registerApp(Context context, SsWsApp ssWsApp);

    void registerServiceId(Context context, int i, int i2);

    void sendPayload(Context context, WsChannelMsg wsChannelMsg);

    void tryStartPushProcess(Context context, boolean z);

    void tryStartPushProcess(Context context, boolean z, boolean z2);

    void unRegisterApp(Context context, int i);

    void unregisterServiceId(Context context, int i, int i2);
}
