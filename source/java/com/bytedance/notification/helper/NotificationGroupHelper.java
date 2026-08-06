package com.bytedance.notification.helper;

import android.text.TextUtils;
import com.bytedance.push.utils.Logger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
public class NotificationGroupHelper {
    private static volatile NotificationGroupHelper instance;
    private final String TAG = "NotificationGroupHelper";
    private final Map<String, Boolean> mHasShowSummaryForGroup = new ConcurrentHashMap();
    private final Map<String, Integer> mNotificationGroupCount = new ConcurrentHashMap();
    private final Map<String, Integer> mSummaryNotificationId = new ConcurrentHashMap();

    public static NotificationGroupHelper getInstance() {
        if (instance == null) {
            synchronized (NotificationGroupHelper.class) {
                if (instance == null) {
                    instance = new NotificationGroupHelper();
                }
            }
        }
        return instance;
    }

    private NotificationGroupHelper() {
    }

    public void onNotificationShow(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Logger.d("NotificationGroupHelper", "on notification show , group is " + str);
        synchronized (this.mNotificationGroupCount) {
            Integer num = this.mNotificationGroupCount.get(str);
            if (num == null) {
                num = 0;
            }
            this.mNotificationGroupCount.put(str, Integer.valueOf(num.intValue() + 1));
        }
    }

    public void onNotificationDelete(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Logger.d("NotificationGroupHelper", "on notification delete , group is " + str);
        synchronized (this.mNotificationGroupCount) {
            Integer num = this.mNotificationGroupCount.get(str);
            if (num == null || num.intValue() == 0) {
                num = 1;
            }
            this.mNotificationGroupCount.put(str, Integer.valueOf(num.intValue() - 1));
        }
    }

    public void onSummaryDelete(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Logger.d("NotificationGroupHelper", "on summary notification delete , group is " + str);
        this.mHasShowSummaryForGroup.put(str, false);
    }

    public boolean shouldShowGroupSummaryNotification(String str, int i) {
        Boolean bool;
        Integer num = this.mNotificationGroupCount.get(str);
        if (num != null && num.intValue() == i && ((bool = this.mHasShowSummaryForGroup.get(str)) == null || !bool.booleanValue())) {
            this.mHasShowSummaryForGroup.put(str, true);
            Logger.d("NotificationGroupHelper", "need show summary notification for  " + str);
            return true;
        }
        Logger.d("NotificationGroupHelper", "need't show summary notification for  " + str + " groupCount is " + num + " groupFoldNum is " + i);
        return false;
    }
}
