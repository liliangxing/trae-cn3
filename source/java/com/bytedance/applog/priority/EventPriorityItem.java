package com.bytedance.applog.priority;

import android.text.TextUtils;
import com.bytedance.applog.server.Api;
import com.bytedance.applog.throttle.BackoffController;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class EventPriorityItem {
    BackoffController mBackoffController;
    long mEventInterval;
    Map<String, List<Set<String>>> mEventParamKeyMap;
    Map<String, List<Map<String, Object>>> mEventParamKeyValueMap;
    int mIntervalMultiple;
    int mMaxPriority;
    int mPriority;
    int mPriorityVersion;
    String mReportHost;
    String mReportPath;
    String[] mPriorityUris = null;
    boolean mIsPriorityUrisInvalid = false;

    public int getPriority() {
        return this.mPriority;
    }

    public int getMaxPriority() {
        return this.mMaxPriority;
    }

    public int getPriorityVersion() {
        return this.mPriorityVersion;
    }

    public long getEventInterval() {
        return this.mEventInterval;
    }

    public BackoffController getBackoffController() {
        return this.mBackoffController;
    }

    public String[] getPriorityUris(String[] strArr, String str) {
        String[] strArr2;
        if (TextUtils.isEmpty(this.mReportHost) && TextUtils.isEmpty(this.mReportPath)) {
            return null;
        }
        if (this.mPriorityUris == null) {
            this.mPriorityUris = new String[strArr.length];
            for (int i = 0; i < strArr.length; i++) {
                int indexOf = strArr[i].indexOf(str);
                if (indexOf > 0) {
                    String substring = strArr[i].substring(0, indexOf);
                    String substring2 = strArr[i].substring(indexOf);
                    if (!TextUtils.isEmpty(this.mReportHost) && this.mReportHost.startsWith("https://") && !this.mReportHost.endsWith("/")) {
                        substring = this.mReportHost;
                    }
                    if (!TextUtils.isEmpty(this.mReportPath) && this.mReportPath.startsWith("/") && this.mReportPath.endsWith("/")) {
                        substring2 = this.mReportPath;
                    }
                    this.mPriorityUris[i] = substring + substring2;
                } else {
                    this.mPriorityUris[i] = strArr[i];
                }
            }
        }
        if (this.mIsPriorityUrisInvalid || (strArr2 = this.mPriorityUris) == null || strArr2.length <= 0) {
            return null;
        }
        return strArr2;
    }

    public void checkPriorityUrisValid(int i) {
        this.mIsPriorityUrisInvalid = Api.checkIfResp404(i);
    }

    public boolean isDefault() {
        return this.mPriority == -1;
    }
}
