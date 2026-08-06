package com.bytedance.crash.monitor;

import android.text.TextUtils;
import com.bytedance.crash.AttachUserData;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.UserDataCenter;
import com.bytedance.crash.event.EnsureDeliverer;
import com.bytedance.crash.event.EventDeliverer;
import com.bytedance.crash.service.ICrashBodyExtensionDumper;
import com.bytedance.crash.util.JSONUtils;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class EventMonitor {
    private ICrashBodyExtensionDumper bodyDumper;
    protected EnsureDeliverer ensureDeliver;
    protected EventDeliverer eventDeliverer;
    protected volatile String mAppId;
    protected volatile String mChannel;
    protected volatile String mDeviceId;
    protected JSONObject mMPParams;
    protected volatile long mManifestVersionCode;
    protected volatile long mUpdateVersionCode;
    protected final UserDataCenter mUserDataCenter;
    protected volatile long mUserId;
    protected volatile long mVersionCode;
    protected volatile String mVersionName;

    public Map<String, Object> getCommParams() {
        return null;
    }

    public String getTobUserId() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public EventMonitor(String str, String str2, long j, long j2, long j3) {
        this(new UserDataCenter(), str, str2, j, j2, j3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public EventMonitor(UserDataCenter userDataCenter, String str, String str2, long j, long j2, long j3) {
        this.mAppId = str;
        this.mVersionName = str2;
        this.mVersionCode = j;
        this.mManifestVersionCode = j3;
        this.mUpdateVersionCode = j2;
        this.mUserDataCenter = userDataCenter;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public EventMonitor(UserDataCenter userDataCenter) {
        this.mUserDataCenter = userDataCenter;
    }

    public void reportEnsure(String str, Throwable th) {
        getEnsureDeliver().reportThrowable(th, str);
    }

    public EnsureDeliverer getEnsureDeliver() {
        if (this.ensureDeliver == null) {
            synchronized (this) {
                if (this.ensureDeliver == null) {
                    this.ensureDeliver = new EnsureDeliverer(this);
                }
            }
        }
        return this.ensureDeliver;
    }

    public void reportEvent(String str, int i, JSONObject jSONObject, JSONObject jSONObject2) {
        getEventDeliverer().reportEvent(str, i, jSONObject, jSONObject2);
    }

    public EventDeliverer getEventDeliverer() {
        if (this.eventDeliverer == null) {
            synchronized (this) {
                if (this.eventDeliverer == null) {
                    this.eventDeliverer = new EventDeliverer(this);
                }
            }
        }
        return this.eventDeliverer;
    }

    public UserDataCenter getUserDataCenter() {
        return this.mUserDataCenter;
    }

    public String getAppId() {
        return this.mAppId;
    }

    public String getChannel() {
        return this.mChannel;
    }

    public String getDeviceId(String str) {
        return TextUtils.isEmpty(this.mDeviceId) ? str : this.mDeviceId;
    }

    public long getUserId() {
        return this.mUserId;
    }

    public JSONObject getMPParams() {
        return this.mMPParams;
    }

    public AppVersionModel getVersion() {
        return new AppVersionModel(this.mVersionCode, this.mUpdateVersionCode, 0L, this.mVersionName);
    }

    public void setChannel(String str) {
        this.mChannel = str;
    }

    public void setDeviceId(String str) {
        this.mDeviceId = str;
    }

    public void setUserId(long j) {
        this.mUserId = j;
    }

    public void setMPParams(Map<String, Object> map) {
        if (map == null) {
            this.mMPParams = null;
            return;
        }
        if (this.mMPParams == null) {
            this.mMPParams = new JSONObject();
        }
        JSONUtils.jsonPutAll(this.mMPParams, map);
    }

    public void addAttachUserData(AttachUserData attachUserData, CrashType crashType) {
        this.mUserDataCenter.addAttachUserData(attachUserData, crashType);
    }

    public void addAttachLongUserData(AttachUserData attachUserData, CrashType crashType) {
        this.mUserDataCenter.addAttachUserData(attachUserData, crashType);
    }

    public void removeAttachUserData(AttachUserData attachUserData, CrashType crashType) {
        this.mUserDataCenter.removeAttachUserData(crashType, attachUserData);
    }

    public void removeAttachLongUserData(AttachUserData attachUserData, CrashType crashType) {
        this.mUserDataCenter.removeAttachUserData(crashType, attachUserData);
    }

    public void addTags(Map<? extends String, ? extends String> map) {
        this.mUserDataCenter.addCustomTags(map);
    }

    public void addTag(String str, String str2) {
        this.mUserDataCenter.addCustomTag(str, str2);
    }

    public void removeTag(String str) {
        this.mUserDataCenter.removeCustomTag(str);
    }

    public void registerBodyHeaderDumper(ICrashBodyExtensionDumper iCrashBodyExtensionDumper) {
        this.bodyDumper = iCrashBodyExtensionDumper;
    }

    public ICrashBodyExtensionDumper getBodyDumper() {
        return this.bodyDumper;
    }

    public long getVersionCode() {
        return this.mVersionCode;
    }

    public long getUpdateVersionCode() {
        return this.mUpdateVersionCode;
    }

    public long getManifestVersionCode() {
        return this.mManifestVersionCode;
    }

    public String getVersionName() {
        return this.mVersionName;
    }
}
