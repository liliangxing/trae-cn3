package com.bytedance.apm6.consumer.slardar.send.downgrade;

import android.content.Context;
import com.bytedance.apm6.consumer.slardar.send.downgrade.DowngradeInfo;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class DowngradeController {
    public static final String FIELD_LOG_TYPE = "log_type";
    public static final String FIELD_SERVICE = "service";
    private DowngradeDataStorage mDataStorage;
    public volatile DowngradeInfo mInfo;

    public void init(Context context) {
        DowngradeDataStorage downgradeDataStorage = new DowngradeDataStorage(context);
        this.mDataStorage = downgradeDataStorage;
        setDowngradeInfo(downgradeDataStorage.loadFromSp(), false);
    }

    public void setDowngradeInfo(DowngradeInfo downgradeInfo, boolean z) {
        DowngradeDataStorage downgradeDataStorage;
        if (downgradeInfo != null) {
            synchronized (this) {
                this.mInfo = downgradeInfo;
            }
            if (!z || (downgradeDataStorage = this.mDataStorage) == null) {
                return;
            }
            downgradeDataStorage.save(downgradeInfo);
        }
    }

    public boolean uploadEnabled(JSONObject jSONObject, int i) {
        boolean z = true;
        if (this.mInfo == null || System.currentTimeMillis() > this.mInfo.expireTime) {
            return true;
        }
        String valueOf = String.valueOf(i);
        String optString = jSONObject.optString("log_type");
        synchronized (this) {
            if (DowngradeInfo.LogType.SERVICE_MONITOR.logType.equals(optString)) {
                String optString2 = jSONObject.optString("service");
                DowngradeInfo.SubInfo subInfo = this.mInfo.mEventMap.get(DowngradeInfo.LogType.SERVICE_MONITOR);
                if (subInfo != null) {
                    JSONObject jSONObject2 = subInfo.aidMap.get(valueOf);
                    if (jSONObject2 != null && jSONObject2.optInt(optString2, -1) != -1) {
                        if (jSONObject2.optInt(optString2, -1) != 1) {
                            z = false;
                        }
                        return z;
                    }
                    return subInfo.defaultRate;
                }
            } else {
                DowngradeInfo.SubInfo subInfo2 = this.mInfo.mEventMap.get(DowngradeInfo.LogType.OTHER_LOG_TYPE);
                if (subInfo2 != null) {
                    JSONObject jSONObject3 = subInfo2.aidMap.get(valueOf);
                    if (jSONObject3 != null && jSONObject3.optInt(optString, -1) != -1) {
                        if (jSONObject3.optInt(optString, -1) != 1) {
                            z = false;
                        }
                        return z;
                    }
                    return subInfo2.defaultRate;
                }
            }
            return true;
        }
    }

    /* loaded from: classes3.dex */
    private static class SINGLETON {
        private static final DowngradeController sInstance = new DowngradeController();

        private SINGLETON() {
        }
    }

    public static DowngradeController getInstance() {
        return SINGLETON.sInstance;
    }
}
