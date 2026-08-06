package com.bytedance.crash.monitor;

import android.text.TextUtils;
import com.bytedance.crash.CrashInfoCallback;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.Global;
import com.bytedance.crash.IANRCallback;
import com.bytedance.crash.IAnrUploadCallback;
import com.bytedance.crash.ICrashCallback;
import com.bytedance.crash.ICrashFilter;
import com.bytedance.crash.IOOMCallback;
import com.bytedance.crash.IPreANRCallback;
import com.bytedance.crash.UserDataCenter;
import com.bytedance.crash.runtime.DefaultWorkThread;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class CrashListener extends EventMonitor {
    private static final ArrayList<CrashListener> sCrashListenerList = new ArrayList<>();
    private AppVersionModel cacheAppVersion;
    protected final CacheManager mCacheManager;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CrashListener(UserDataCenter userDataCenter) {
        super(userDataCenter);
        sCrashListenerList.add(this);
        this.mCacheManager = new CacheManager(Global.getRootDirectory());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CrashListener(UserDataCenter userDataCenter, final String str, final String str2, final long j) {
        super(userDataCenter, str, str2, j, 0L, 0L);
        sCrashListenerList.add(this);
        CacheManager cacheManager = new CacheManager(Global.getRootDirectory(), str);
        this.mCacheManager = cacheManager;
        if (DefaultWorkThread.isCurrentThread()) {
            cacheManager.setAppId(str);
            cacheManager.setVersion(j, 0L, 0L, str2);
        } else {
            DefaultWorkThread.post(new Runnable() { // from class: com.bytedance.crash.monitor.CrashListener.1
                @Override // java.lang.Runnable
                public void run() {
                    CrashListener.this.mCacheManager.setAppId(str);
                    CrashListener.this.mCacheManager.setVersion(j, 0L, 0L, str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CrashListener(final String str, final String str2, final long j) {
        super(str, str2, j, 0L, 0L);
        sCrashListenerList.add(this);
        CacheManager cacheManager = new CacheManager(Global.getRootDirectory(), str);
        this.mCacheManager = cacheManager;
        if (DefaultWorkThread.isCurrentThread()) {
            cacheManager.setAppId(str);
            cacheManager.setVersion(j, 0L, 0L, str2);
        } else {
            DefaultWorkThread.post(new Runnable() { // from class: com.bytedance.crash.monitor.CrashListener.2
                @Override // java.lang.Runnable
                public void run() {
                    CrashListener.this.mCacheManager.setAppId(str);
                    CrashListener.this.mCacheManager.setVersion(j, 0L, 0L, str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ArrayList<CrashListener> getCrashListenerList() {
        return sCrashListenerList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CrashListener getCrashListenerByAid(String str) {
        Iterator<CrashListener> it = sCrashListenerList.iterator();
        while (it.hasNext()) {
            CrashListener next = it.next();
            if (str.equals(next.getAppId())) {
                return next;
            }
        }
        return null;
    }

    @Override // com.bytedance.crash.monitor.EventMonitor
    public String getAppId() {
        return this.mAppId != null ? this.mAppId : this.mCacheManager.getAppId();
    }

    @Override // com.bytedance.crash.monitor.EventMonitor
    public String getChannel() {
        return this.mChannel != null ? this.mChannel : this.mCacheManager.getChannel();
    }

    @Override // com.bytedance.crash.monitor.EventMonitor
    public String getDeviceId(String str) {
        if (!TextUtils.isEmpty(this.mDeviceId)) {
            return this.mDeviceId;
        }
        String deviceId = this.mCacheManager.getDeviceId();
        return TextUtils.isEmpty(deviceId) ? str : deviceId;
    }

    @Override // com.bytedance.crash.monitor.EventMonitor
    public long getUserId() {
        return this.mUserId != 0 ? this.mUserId : this.mCacheManager.getUserId();
    }

    @Override // com.bytedance.crash.monitor.EventMonitor
    public AppVersionModel getVersion() {
        AppVersionModel appVersionModel = this.cacheAppVersion;
        if (appVersionModel != null) {
            return appVersionModel;
        }
        if (this.mVersionName != null && this.mVersionCode != 0) {
            this.cacheAppVersion = new AppVersionModel(this.mVersionCode, this.mUpdateVersionCode, this.mManifestVersionCode, this.mVersionName);
        } else {
            this.cacheAppVersion = this.mCacheManager.getVersion();
        }
        return this.cacheAppVersion;
    }

    @Override // com.bytedance.crash.monitor.EventMonitor
    public long getVersionCode() {
        return getVersion().getVersionCode();
    }

    @Override // com.bytedance.crash.monitor.EventMonitor
    public long getUpdateVersionCode() {
        return getVersion().getUpdateVersionCode();
    }

    @Override // com.bytedance.crash.monitor.EventMonitor
    public long getManifestVersionCode() {
        return getVersion().getManifestVersionCode();
    }

    @Override // com.bytedance.crash.monitor.EventMonitor
    public String getVersionName() {
        return getVersion().getVersionName();
    }

    public String getAppId(long j) {
        return this.mCacheManager.getAppId(j);
    }

    public String getChannel(long j) {
        return this.mCacheManager.getChannel(j);
    }

    public String getDeviceId(long j) {
        String deviceId = this.mCacheManager.getDeviceId(j);
        return TextUtils.isEmpty(deviceId) ? "0" : deviceId;
    }

    public long getUserId(long j) {
        return this.mCacheManager.getUserId(j);
    }

    public AppVersionModel getVersion(long j) {
        return this.mCacheManager.getVersion(j);
    }

    @Override // com.bytedance.crash.monitor.EventMonitor
    public void setChannel(String str) {
        this.mChannel = str;
        this.mCacheManager.setChannel(str);
    }

    @Override // com.bytedance.crash.monitor.EventMonitor
    public void setDeviceId(String str) {
        this.mDeviceId = str;
        this.mCacheManager.setDeviceId(str);
    }

    @Override // com.bytedance.crash.monitor.EventMonitor
    public void setUserId(long j) {
        this.mUserId = j;
        this.mCacheManager.setUserId(j);
    }

    public void registerInnerSdk(String str, String str2) {
        this.mUserDataCenter.registerInnerSdkInfo(str, str2);
    }

    public void registerExternalSdk(int i, String str) {
        this.mUserDataCenter.registerSdkInfo(i, str);
    }

    public void registerCrashCallback(ICrashCallback iCrashCallback, CrashType crashType) {
        this.mUserDataCenter.addCrashCallback(iCrashCallback, crashType);
    }

    public void registerCrashInfoCallback(CrashInfoCallback crashInfoCallback, CrashType crashType) {
        this.mUserDataCenter.addCrashInfoCallback(crashInfoCallback, crashType);
    }

    public void registerOOMCallback(IOOMCallback iOOMCallback) {
        this.mUserDataCenter.addOOMCallback(iOOMCallback);
    }

    public void registerANRCallback(IANRCallback iANRCallback) {
        this.mUserDataCenter.addANRCallback(iANRCallback);
    }

    public void registerHprofCallback(IOOMCallback iOOMCallback) {
        this.mUserDataCenter.addHprofCallback(iOOMCallback);
    }

    public void removeHprofCallback(IOOMCallback iOOMCallback) {
        this.mUserDataCenter.removeHprofCallback(iOOMCallback);
    }

    public void unregisterCrashCallback(ICrashCallback iCrashCallback, CrashType crashType) {
        this.mUserDataCenter.removeCrashCallback(iCrashCallback, crashType);
    }

    public void unregisterOOMCallback(IOOMCallback iOOMCallback, CrashType crashType) {
        this.mUserDataCenter.removeOOMCallback(iOOMCallback);
    }

    public void setCrashFilter(ICrashFilter iCrashFilter) {
        this.mUserDataCenter.setCrashFilter(iCrashFilter);
    }

    public void registerPreANRCallback(IPreANRCallback iPreANRCallback) {
        this.mUserDataCenter.addPreANRCallback(iPreANRCallback);
    }

    public void unregisterPreANRCallback(IPreANRCallback iPreANRCallback) {
        this.mUserDataCenter.removePreANRCallback(iPreANRCallback);
    }

    public void registerAnrUploadCallback(IAnrUploadCallback iAnrUploadCallback) {
        this.mUserDataCenter.addAnrUploadCallback(iAnrUploadCallback);
    }
}
