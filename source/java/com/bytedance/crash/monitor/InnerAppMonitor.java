package com.bytedance.crash.monitor;

import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.apm.entity.UploadInfo;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.Global;
import com.bytedance.crash.ICommonParams;
import com.bytedance.crash.diagnose.NpthMonitor;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.util.NpthLog;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class InnerAppMonitor extends AppMonitor {
    private boolean isUpdatedStartTime;
    private final ICommonParams mICommonParams;
    private String oldVersionName;
    private final updateLock mCommonParamLock = new updateLock();
    private final updateLock mDeviceIdLock = new updateLock();
    private final updateLock mUserIdLock = new updateLock();
    private int mGetUserIdCount = 3;
    private Runnable getUserIdTask = new Runnable() { // from class: com.bytedance.crash.monitor.InnerAppMonitor.1
        @Override // java.lang.Runnable
        public void run() {
            InnerAppMonitor.access$010(InnerAppMonitor.this);
            if (InnerAppMonitor.this.mUserId == 0) {
                InnerAppMonitor.this.doUpdateUserId();
            }
            if (InnerAppMonitor.this.mGetUserIdCount <= 0 || InnerAppMonitor.this.mUserId != 0) {
                return;
            }
            DefaultWorkThread.postDelayed(InnerAppMonitor.this.getUserIdTask, WsConstants.EXIT_DELAY_TIME);
        }
    };

    static /* synthetic */ int access$010(InnerAppMonitor innerAppMonitor) {
        int i = innerAppMonitor.mGetUserIdCount;
        innerAppMonitor.mGetUserIdCount = i - 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public InnerAppMonitor(ICommonParams iCommonParams) {
        this.mICommonParams = iCommonParams;
        DefaultWorkThread.post(new InitParamsUpdateTask());
        DefaultWorkThread.postDelayed(this.getUserIdTask, WsConstants.EXIT_DELAY_TIME);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    class InitParamsUpdateTask implements Runnable {
        private static final int MAX_COUNT = 120;
        private static final int MINUTES = 60000;
        private static final int SECONDS = 1000;
        private int mCount;

        InitParamsUpdateTask() {
        }

        private long getDelay() {
            int i = this.mCount + 1;
            this.mCount = i;
            if (i > 120) {
                return -1L;
            }
            if (i < 30) {
                return 2000L;
            }
            return i < 60 ? PerfConsts.DEFAULT_SERIOUS_BLOCK_INTERVAL_MS : UploadInfo.DEFAULT_SEND_DURATION;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (InnerAppMonitor.this.mDeviceId == null) {
                InnerAppMonitor.this.doUpdateDeviceId();
            }
            if (InnerAppMonitor.this.mAppId == null || InnerAppMonitor.this.mChannel == null || InnerAppMonitor.this.mVersionName == null || InnerAppMonitor.this.mVersionCode == 0 || InnerAppMonitor.this.oldVersionName == null) {
                InnerAppMonitor.this.doUpdateCommonParams();
            }
            if (InnerAppMonitor.this.mDeviceId == null || InnerAppMonitor.this.mAppId == null || InnerAppMonitor.this.mChannel == null || InnerAppMonitor.this.oldVersionName == null || InnerAppMonitor.this.mVersionName == null || InnerAppMonitor.this.mVersionCode == 0) {
                long delay = getDelay();
                if (delay >= 0) {
                    DefaultWorkThread.postDelayed(this, delay);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class updateLock {
        updateLock() {
        }

        void waitUpdateTask(long j) {
            synchronized (this) {
                try {
                    wait(j);
                } catch (Throwable unused) {
                }
            }
        }

        void notifyWaitTask() {
            synchronized (this) {
                notifyAll();
            }
        }
    }

    void doUpdateAppStartTime(Map<String, Object> map) {
        Object obj;
        try {
            if (this.isUpdatedStartTime || (obj = map.get("app_start_time")) == null) {
                return;
            }
            long parseLong = parseLong(obj);
            if (parseLong > 0) {
                this.isUpdatedStartTime = true;
                Global.setAppStartTime(Long.valueOf(parseLong));
            }
        } catch (Throwable unused) {
        }
    }

    void doUpdateCommonParams() {
        Object obj;
        PackageInfo packageInfo;
        Object obj2;
        try {
            Map<String, Object> commonParams = this.mICommonParams.getCommonParams();
            if (this.mAppId == null && (obj2 = commonParams.get("aid")) != null) {
                setAppId(String.valueOf(obj2));
            }
            doUpdateAppStartTime(commonParams);
            if (this.mChannel == null) {
                Object obj3 = commonParams.get("channel");
                if (obj3 instanceof String) {
                    setChannel((String) obj3);
                }
            }
            if (this.mVersionName == null || this.mVersionCode == 0 || this.oldVersionName == null) {
                Object obj4 = commonParams.get("app_version");
                Object obj5 = commonParams.get("version_code");
                Object obj6 = commonParams.get("version_name");
                if (obj6 instanceof String) {
                    this.oldVersionName = (String) obj6;
                }
                String str = this.oldVersionName;
                if (str != null) {
                    obj4 = str;
                }
                if (obj4 instanceof String) {
                    if (obj5 == null) {
                        packageInfo = Global.getContext().getPackageManager().getPackageInfo(Global.getContext().getPackageName(), 128);
                        obj = Integer.valueOf(packageInfo.versionCode);
                    } else {
                        obj = obj5;
                        packageInfo = null;
                    }
                    long parseLong = parseLong(commonParams.get("manifest_version_code"));
                    long parseLong2 = parseLong(commonParams.get("update_version_code"));
                    if (parseLong2 == 0) {
                        if (packageInfo == null) {
                            try {
                                packageInfo = Global.getContext().getPackageManager().getPackageInfo(Global.getContext().getPackageName(), 128);
                            } catch (Throwable unused) {
                            }
                        }
                        Object obj7 = packageInfo.applicationInfo.metaData != null ? packageInfo.applicationInfo.metaData.get("UPDATE_VERSION_CODE") : null;
                        if (obj7 == null) {
                            obj7 = Long.valueOf(parseLong(commonParams.get("version_code")));
                        }
                        parseLong2 = parseLong(obj7);
                    }
                    if ((obj instanceof Long) || (obj instanceof Integer) || (obj instanceof String)) {
                        try {
                            long parseLong3 = parseLong(obj);
                            if (parseLong <= 0) {
                                parseLong = parseLong3;
                            }
                            setVersion(parseLong3, parseLong2, parseLong, (String) obj4);
                        } catch (Throwable th) {
                            NpthMonitor.reportInnerException(th);
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            NpthLog.m232e(th2);
        }
    }

    @Override // com.bytedance.crash.monitor.AppMonitor, com.bytedance.crash.monitor.EventMonitor
    public Map<String, Object> getCommParams() {
        ICommonParams iCommonParams = this.mICommonParams;
        HashMap hashMap = null;
        if (iCommonParams != null) {
            Map<String, Object> commonParams = iCommonParams.getCommonParams();
            if (commonParams != null) {
                hashMap = new HashMap(commonParams);
                if (hashMap.containsKey("version_name")) {
                    try {
                        if (!hashMap.containsKey("app_version")) {
                            hashMap.put("app_version", hashMap.get("version_name"));
                            hashMap.put("app_version_from_name", "1");
                        }
                    } catch (Throwable unused) {
                    }
                }
                hashMap.remove("release_build");
            }
            String sessionId = this.mICommonParams.getSessionId();
            long userId = this.mICommonParams.getUserId();
            if (sessionId != null || userId > 0) {
                if (hashMap == null) {
                    hashMap = new HashMap();
                }
                if (sessionId != null) {
                    hashMap.put("session_id", sessionId);
                }
                if (userId > 0) {
                    hashMap.put("user_id", Long.valueOf(userId));
                }
            }
        }
        return hashMap;
    }

    public String getSessionId() {
        ICommonParams iCommonParams = this.mICommonParams;
        if (iCommonParams == null) {
            return null;
        }
        return iCommonParams.getSessionId();
    }

    public ICommonParams getICommonParams() {
        return this.mICommonParams;
    }

    private long parseLong(Object obj) {
        if (obj == null) {
            return 0L;
        }
        try {
            return Long.parseLong(String.valueOf(obj));
        } catch (Exception unused) {
            return 0L;
        }
    }

    void updateCommonParams() {
        if (DefaultWorkThread.getThread() == Thread.currentThread()) {
            doUpdateCommonParams();
        } else {
            DefaultWorkThread.post(new Runnable() { // from class: com.bytedance.crash.monitor.InnerAppMonitor.2
                @Override // java.lang.Runnable
                public void run() {
                    InnerAppMonitor.this.doUpdateCommonParams();
                    InnerAppMonitor.this.mCommonParamLock.notifyWaitTask();
                }
            });
            this.mCommonParamLock.waitUpdateTask(200L);
        }
    }

    void doUpdateDeviceId() {
        try {
            String deviceId = this.mICommonParams.getDeviceId();
            NpthLog.m234i("ConfigManager", "doUpdateDeviceId:" + deviceId);
            if (deviceId != null) {
                setDeviceId(deviceId);
            }
        } catch (Throwable th) {
            NpthMonitor.reportInnerException(th);
        }
    }

    void updateDeviceId() {
        if (DefaultWorkThread.getThread() == Thread.currentThread()) {
            doUpdateDeviceId();
        } else {
            DefaultWorkThread.post(new Runnable() { // from class: com.bytedance.crash.monitor.InnerAppMonitor.3
                @Override // java.lang.Runnable
                public void run() {
                    InnerAppMonitor.this.doUpdateDeviceId();
                    InnerAppMonitor.this.mDeviceIdLock.notifyWaitTask();
                }
            });
            this.mDeviceIdLock.waitUpdateTask(100L);
        }
    }

    void doUpdateUserId() {
        try {
            long userId = this.mICommonParams.getUserId();
            if (userId != 0) {
                setUserId(userId);
            }
        } catch (Throwable th) {
            NpthMonitor.reportInnerException(th);
        }
    }

    void updateUserId() {
        if (DefaultWorkThread.getThread() == Thread.currentThread()) {
            doUpdateUserId();
        } else {
            DefaultWorkThread.post(new Runnable() { // from class: com.bytedance.crash.monitor.InnerAppMonitor.4
                @Override // java.lang.Runnable
                public void run() {
                    InnerAppMonitor.this.doUpdateUserId();
                    InnerAppMonitor.this.mUserIdLock.notifyWaitTask();
                }
            });
            this.mUserIdLock.waitUpdateTask(200L);
        }
    }

    @Override // com.bytedance.crash.monitor.CrashListener, com.bytedance.crash.monitor.EventMonitor
    public String getAppId() {
        if (this.mAppId == null) {
            updateCommonParams();
        }
        return super.getAppId();
    }

    @Override // com.bytedance.crash.monitor.CrashListener, com.bytedance.crash.monitor.EventMonitor
    public String getChannel() {
        if (this.mChannel == null) {
            updateCommonParams();
        }
        return super.getChannel();
    }

    @Override // com.bytedance.crash.monitor.CrashListener, com.bytedance.crash.monitor.EventMonitor
    public AppVersionModel getVersion() {
        if (this.mVersionName == null || this.mVersionCode == 0) {
            updateCommonParams();
        }
        return super.getVersion();
    }

    @Override // com.bytedance.crash.monitor.CrashListener, com.bytedance.crash.monitor.EventMonitor
    public long getVersionCode() {
        if (this.mVersionName == null || this.mVersionCode == 0) {
            updateCommonParams();
        }
        return super.getVersionCode();
    }

    @Override // com.bytedance.crash.monitor.CrashListener, com.bytedance.crash.monitor.EventMonitor
    public long getUpdateVersionCode() {
        if (this.mVersionName == null || this.mVersionCode == 0) {
            updateCommonParams();
        }
        return super.getUpdateVersionCode();
    }

    @Override // com.bytedance.crash.monitor.CrashListener, com.bytedance.crash.monitor.EventMonitor
    public long getManifestVersionCode() {
        if (this.mVersionName == null || this.mVersionCode == 0) {
            updateCommonParams();
        }
        return super.getManifestVersionCode();
    }

    @Override // com.bytedance.crash.monitor.CrashListener, com.bytedance.crash.monitor.EventMonitor
    public String getVersionName() {
        if (this.mVersionName == null || this.mVersionCode == 0) {
            updateCommonParams();
        }
        return super.getVersionName();
    }

    @Override // com.bytedance.crash.monitor.CrashListener, com.bytedance.crash.monitor.EventMonitor
    public String getDeviceId(String str) {
        if (TextUtils.isEmpty(this.mDeviceId)) {
            updateDeviceId();
        }
        return super.getDeviceId(str);
    }

    @Override // com.bytedance.crash.monitor.CrashListener, com.bytedance.crash.monitor.EventMonitor
    public long getUserId() {
        if (this.mUserId == 0) {
            updateUserId();
        }
        return super.getUserId();
    }

    protected void setAppId(String str) {
        this.mAppId = str;
        this.mCacheManager.setAppId(str);
    }

    protected void setVersion(long j, long j2, long j3, String str) {
        this.mUpdateVersionCode = j2;
        this.mVersionCode = j;
        this.mVersionName = str;
        this.mManifestVersionCode = j3;
        this.mCacheManager.setVersion(j, j2, j3, str);
        Global.setAppVersion(j, j2, j3, str);
    }
}
