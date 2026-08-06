package com.bytedance.push.msg.callback;

import android.os.SystemClock;
import android.text.TextUtils;

/* loaded from: classes4.dex */
class ClickHelper {
    private long mLastClickTimeStamp;
    private String mLastPushMsg;
    private String mLastPushType;

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isDoubleClick(String str, String str2) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (TextUtils.equals(this.mLastPushType, str2) && elapsedRealtime - this.mLastClickTimeStamp <= 1000 && TextUtils.equals(this.mLastPushMsg, str)) {
            return true;
        }
        this.mLastPushMsg = str;
        this.mLastPushType = str2;
        this.mLastClickTimeStamp = elapsedRealtime;
        return false;
    }
}
