package com.bytedance.common.wschannel.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.app.IWsApp;
import com.bytedance.common.wschannel.utils.Utils;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class SsWsApp implements IWsApp, Parcelable {
    public static final Parcelable.Creator<SsWsApp> CREATOR = new Parcelable.Creator<SsWsApp>() { // from class: com.bytedance.common.wschannel.model.SsWsApp.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SsWsApp createFromParcel(Parcel parcel) {
            return new SsWsApp(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SsWsApp[] newArray(int i) {
            return new SsWsApp[i];
        }
    };
    private String appKey;
    private int channelId;
    private String extra;
    private int fPid;
    private Map<String, String> headers;
    private int mAppId;
    private int mAppVersion;
    private String mDeviceId;
    boolean mDisableFallbackWs;
    private String mInstallId;
    int mMode;
    boolean mNewPrivateProtocolEnabled;
    private int mPlatform;
    String mPrivateProtocolUrl;
    List<Integer> mServiceIdList;
    private List<String> urls;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public int getFPID() {
        return this.fPid;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public String getExtra() {
        return this.extra;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public List<String> getConnectUrls() {
        return this.urls;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public boolean newPrivateProtocolEnabled() {
        return this.mNewPrivateProtocolEnabled;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public List<Integer> getServiceIdList() {
        return this.mServiceIdList;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public String getPrivateProtocolUrl() {
        return this.mPrivateProtocolUrl;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public int getTransportMode() {
        return this.mMode;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public boolean disableFallbackWSEnabled() {
        return this.mDisableFallbackWs;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public String getAppKey() {
        return this.appKey;
    }

    protected SsWsApp() {
        this.headers = new HashMap();
        this.urls = new ArrayList();
        this.mServiceIdList = new ArrayList();
    }

    private SsWsApp(int i, int i2, String str, String str2, List<String> list, int i3, int i4, int i5, String str3, String str4, boolean z, List<Integer> list2, String str5, int i6, boolean z2, SsWsAppBuilder ssWsAppBuilder) {
        this.headers = new HashMap();
        this.urls = new ArrayList();
        this.mServiceIdList = new ArrayList();
        this.mAppId = i2;
        this.channelId = i;
        this.mDeviceId = str;
        this.mInstallId = str2;
        if (list != null) {
            this.urls.addAll(list);
        }
        this.mAppVersion = i3;
        this.mPlatform = i4;
        this.fPid = i5;
        this.appKey = str3;
        this.extra = str4;
        if (ssWsAppBuilder.headers != null) {
            this.headers.putAll(ssWsAppBuilder.headers);
        }
        this.mNewPrivateProtocolEnabled = z;
        this.mServiceIdList = list2;
        this.mPrivateProtocolUrl = str5;
        this.mMode = i6;
        this.mDisableFallbackWs = z2;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public int getChannelId() {
        return this.channelId;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public int getAppId() {
        return this.mAppId;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public String getDeviceId() {
        return this.mDeviceId;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public String getInstallId() {
        return this.mInstallId;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public int getAppVersion() {
        return this.mAppVersion;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public int getPlatform() {
        return this.mPlatform;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public Map<String, String> getHeaders() {
        return this.headers;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public JSONObject toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(WsConstants.KEY_CHANNEL_ID, this.channelId);
        jSONObject.put("app_id", this.mAppId);
        jSONObject.put("device_id", this.mDeviceId);
        jSONObject.put("install_id", this.mInstallId);
        JSONArray jSONArray = new JSONArray();
        List<String> list = this.urls;
        if (list != null) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next());
            }
        }
        jSONObject.put("headers", Utils.mapToJson(this.headers));
        jSONObject.put(MonitorConstants.URLS, jSONArray);
        jSONObject.put("app_version", this.mAppVersion);
        jSONObject.put("platform", this.mPlatform);
        jSONObject.put(WsConstants.KEY_FPID, this.fPid);
        jSONObject.put("app_kay", this.appKey);
        jSONObject.put("extra", this.extra);
        jSONObject.put(WsConstants.KEY_PRIVATE_PROTOCOL_ENABLE, this.mNewPrivateProtocolEnabled);
        JSONArray jSONArray2 = new JSONArray();
        List<Integer> list2 = this.mServiceIdList;
        if (list2 != null) {
            Iterator<Integer> it2 = list2.iterator();
            while (it2.hasNext()) {
                jSONArray2.put(it2.next());
            }
        }
        jSONObject.put(WsConstants.KEY_SERVICE_ID_LIST, jSONArray2);
        jSONObject.put(WsConstants.KEY_PRIVATE_PROTOCOL_URL, this.mPrivateProtocolUrl);
        jSONObject.put(WsConstants.KEY_TRANSPORT_MODE, this.mMode);
        jSONObject.put(WsConstants.KEY_DISABLE_FALLBACK_WEBSOCKET, this.mDisableFallbackWs);
        return jSONObject;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public void parseFromJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.channelId = jSONObject.optInt(WsConstants.KEY_CHANNEL_ID);
        this.mAppId = jSONObject.optInt("app_id");
        this.mDeviceId = jSONObject.optString("device_id");
        this.mInstallId = jSONObject.optString("install_id");
        this.mAppVersion = jSONObject.optInt("app_version");
        this.mPlatform = jSONObject.optInt("platform");
        this.fPid = jSONObject.optInt(WsConstants.KEY_FPID);
        this.appKey = jSONObject.optString("app_kay");
        this.extra = jSONObject.optString("extra");
        JSONArray optJSONArray = jSONObject.optJSONArray(MonitorConstants.URLS);
        this.urls.clear();
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                this.urls.add(optJSONArray.optString(i));
            }
        }
        this.mNewPrivateProtocolEnabled = jSONObject.optBoolean(WsConstants.KEY_PRIVATE_PROTOCOL_ENABLE);
        JSONArray optJSONArray2 = jSONObject.optJSONArray(WsConstants.KEY_SERVICE_ID_LIST);
        this.mServiceIdList.clear();
        if (optJSONArray2 != null) {
            int length2 = optJSONArray2.length();
            for (int i2 = 0; i2 < length2; i2++) {
                this.mServiceIdList.add(Integer.valueOf(optJSONArray2.optInt(i2)));
            }
        }
        this.mPrivateProtocolUrl = jSONObject.optString(WsConstants.KEY_PRIVATE_PROTOCOL_URL);
        this.mMode = jSONObject.optInt(WsConstants.KEY_TRANSPORT_MODE);
        this.mDisableFallbackWs = jSONObject.optBoolean(WsConstants.KEY_DISABLE_FALLBACK_WEBSOCKET);
        this.headers.clear();
        this.headers.putAll(Utils.jsonToMap(jSONObject.optJSONObject("headers")));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SsWsApp ssWsApp = (SsWsApp) obj;
        if (this.channelId != ssWsApp.channelId || this.mAppId != ssWsApp.mAppId || this.mAppVersion != ssWsApp.mAppVersion || this.mPlatform != ssWsApp.mPlatform || this.fPid != ssWsApp.fPid || !this.headers.equals(ssWsApp.headers)) {
            return false;
        }
        List<String> list = this.urls;
        if (list == null ? ssWsApp.urls != null : !list.equals(ssWsApp.urls)) {
            return false;
        }
        String str = this.extra;
        if (str == null ? ssWsApp.extra != null : !str.equals(ssWsApp.extra)) {
            return false;
        }
        String str2 = this.mDeviceId;
        if (str2 == null ? ssWsApp.mDeviceId != null : !str2.equals(ssWsApp.mDeviceId)) {
            return false;
        }
        String str3 = this.mInstallId;
        if (str3 == null ? ssWsApp.mInstallId != null : !str3.equals(ssWsApp.mInstallId)) {
            return false;
        }
        String str4 = this.appKey;
        String str5 = ssWsApp.appKey;
        return str4 != null ? str4.equals(str5) : str5 == null;
    }

    public int hashCode() {
        int hashCode = this.headers.hashCode() * 31;
        List<String> list = this.urls;
        int hashCode2 = (((hashCode + (list != null ? list.hashCode() : 0)) * 31) + this.channelId) * 31;
        String str = this.extra;
        int hashCode3 = (((hashCode2 + (str != null ? str.hashCode() : 0)) * 31) + this.mAppId) * 31;
        String str2 = this.mDeviceId;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.mInstallId;
        int hashCode5 = (((((((hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.mAppVersion) * 31) + this.mPlatform) * 31) + this.fPid) * 31;
        String str4 = this.appKey;
        return hashCode5 + (str4 != null ? str4.hashCode() : 0);
    }

    /* loaded from: classes3.dex */
    public static class SsWsAppBuilder {
        private int channelId;
        private Map<String, String> headers;
        private int mAppId;
        private String mAppKey;
        private int mAppVersion;
        private String mDeviceId;
        boolean mDisableFallbackWS;
        private String mExtra;
        private int mFpid;
        private String mInstallId;
        int mMode;
        boolean mNewPrivateProtocolEnabled;
        private int mPlatform;
        String mPrivateProtocolUrl;
        List<Integer> mServiceIdList = new ArrayList();
        private List<String> urls;

        public SsWsAppBuilder setAppId(int i) {
            this.mAppId = i;
            return this;
        }

        public SsWsAppBuilder setDeviceId(String str) {
            this.mDeviceId = str;
            return this;
        }

        public SsWsAppBuilder setInstallId(String str) {
            this.mInstallId = str;
            return this;
        }

        public SsWsAppBuilder setAppVersion(int i) {
            this.mAppVersion = i;
            return this;
        }

        public SsWsAppBuilder setPlatform(int i) {
            this.mPlatform = i;
            return this;
        }

        public SsWsAppBuilder setExtra(String str) {
            this.mExtra = str;
            return this;
        }

        public SsWsAppBuilder setFPID(int i) {
            this.mFpid = i;
            return this;
        }

        public SsWsAppBuilder setAppKey(String str) {
            this.mAppKey = str;
            return this;
        }

        public SsWsApp build() {
            return new SsWsApp(this.channelId, this.mAppId, this.mDeviceId, this.mInstallId, this.urls, this.mAppVersion, this.mPlatform, this.mFpid, this.mAppKey, this.mExtra, this.mNewPrivateProtocolEnabled, this.mServiceIdList, this.mPrivateProtocolUrl, this.mMode, this.mDisableFallbackWS, this);
        }

        public SsWsApp buildFromJson(JSONObject jSONObject) {
            SsWsApp ssWsApp = new SsWsApp();
            ssWsApp.parseFromJson(jSONObject);
            return ssWsApp;
        }

        public SsWsAppBuilder setChannelId(int i) {
            this.channelId = i;
            return this;
        }

        public SsWsAppBuilder setConnectUrls(List<String> list) {
            this.urls = list;
            return this;
        }

        public SsWsAppBuilder setHeaders(Map<String, String> map) {
            this.headers = map;
            return this;
        }

        public SsWsAppBuilder enableNewPrivateProtocol(boolean z) {
            this.mNewPrivateProtocolEnabled = z;
            return this;
        }

        public SsWsAppBuilder setServiceIdList(List<Integer> list) {
            this.mServiceIdList = list;
            return this;
        }

        public SsWsAppBuilder setPrivateProtocolUrl(String str) {
            this.mPrivateProtocolUrl = str;
            return this;
        }

        public SsWsAppBuilder setTransportMode(int i) {
            this.mMode = i;
            return this;
        }

        public SsWsAppBuilder disableFallbackWS(boolean z) {
            this.mDisableFallbackWS = z;
            return this;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.headers.size());
        for (Map.Entry<String, String> entry : this.headers.entrySet()) {
            parcel.writeString(entry.getKey());
            parcel.writeString(entry.getValue());
        }
        parcel.writeStringList(this.urls);
        parcel.writeInt(this.channelId);
        parcel.writeString(this.extra);
        parcel.writeInt(this.mAppId);
        parcel.writeString(this.mDeviceId);
        parcel.writeString(this.mInstallId);
        parcel.writeInt(this.mAppVersion);
        parcel.writeInt(this.mPlatform);
        parcel.writeInt(this.fPid);
        parcel.writeString(this.appKey);
        parcel.writeByte(this.mNewPrivateProtocolEnabled ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.mServiceIdList.size());
        Iterator<Integer> it = this.mServiceIdList.iterator();
        while (it.hasNext()) {
            parcel.writeInt(it.next().intValue());
        }
        parcel.writeString(this.mPrivateProtocolUrl);
        parcel.writeInt(this.mMode);
        parcel.writeByte(this.mDisableFallbackWs ? (byte) 1 : (byte) 0);
    }

    protected SsWsApp(Parcel parcel) {
        this.headers = new HashMap();
        this.urls = new ArrayList();
        this.mServiceIdList = new ArrayList();
        int readInt = parcel.readInt();
        this.headers = new HashMap(readInt);
        for (int i = 0; i < readInt; i++) {
            this.headers.put(parcel.readString(), parcel.readString());
        }
        this.urls = parcel.createStringArrayList();
        this.channelId = parcel.readInt();
        this.extra = parcel.readString();
        this.mAppId = parcel.readInt();
        this.mDeviceId = parcel.readString();
        this.mInstallId = parcel.readString();
        this.mAppVersion = parcel.readInt();
        this.mPlatform = parcel.readInt();
        this.fPid = parcel.readInt();
        this.appKey = parcel.readString();
        this.mNewPrivateProtocolEnabled = parcel.readByte() != 0;
        int readInt2 = parcel.readInt();
        for (int i2 = 0; i2 < readInt2; i2++) {
            this.mServiceIdList.add(Integer.valueOf(parcel.readInt()));
        }
        this.mPrivateProtocolUrl = parcel.readString();
        this.mMode = parcel.readInt();
        this.mDisableFallbackWs = parcel.readByte() != 0;
    }
}
