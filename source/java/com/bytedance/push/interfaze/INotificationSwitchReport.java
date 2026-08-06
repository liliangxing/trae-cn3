package com.bytedance.push.interfaze;

import android.content.Context;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface INotificationSwitchReport {
    void tryUpdateNoticeStateByAlliance(Context context);

    void tryUpdateNoticeStateByPolling(Context context, ISupport iSupport);
}
