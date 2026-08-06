package com.bytedance.push.notification;

import android.os.SystemClock;
import android.text.TextUtils;

/* loaded from: classes4.dex */
class DebouncingClickHelper {
    private long mLastClickTimeStamp;
    private String mLastPushMsg;
    private int mLastPushType;

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isDeboundClick(String str, int i) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (this.mLastPushType == i && elapsedRealtime - this.mLastClickTimeStamp <= 1000 && TextUtils.equals(this.mLastPushMsg, str)) {
            return true;
        }
        this.mLastPushMsg = str;
        this.mLastPushType = i;
        this.mLastClickTimeStamp = elapsedRealtime;
        return false;
    }
}
