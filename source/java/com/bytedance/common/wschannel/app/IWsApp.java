package com.bytedance.common.wschannel.app;

import android.os.Parcelable;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public interface IWsApp extends Parcelable {
    boolean disableFallbackWSEnabled();

    int getAppId();

    String getAppKey();

    int getAppVersion();

    int getChannelId();

    List<String> getConnectUrls();

    String getDeviceId();

    String getExtra();

    int getFPID();

    Map<String, String> getHeaders();

    String getInstallId();

    int getPlatform();

    String getPrivateProtocolUrl();

    List<Integer> getServiceIdList();

    int getTransportMode();

    boolean newPrivateProtocolEnabled();

    void parseFromJson(JSONObject jSONObject);

    JSONObject toJson() throws JSONException;
}
