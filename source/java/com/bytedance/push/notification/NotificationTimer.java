package com.bytedance.push.notification;

import com.bytedance.push.PushSupporter;
import com.bytedance.push.utils.Logger;
import com.ss.android.message.PushThreadHandlerManager;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class NotificationTimer extends TimerTask {
    public static volatile NotificationTimer notificationTimer;
    private final String TAG = "NotificationTimer";
    private final AtomicBoolean hasTimerTask = new AtomicBoolean(false);

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        Logger.m268d("NotificationTimer", "on NotificationTimer#run,handleMessageNotBeenShown");
        this.hasTimerTask.compareAndSet(true, false);
        PushSupporter.get().getMessageSpreadOutService().handleMessageNotBeenShown();
    }

    public static NotificationTimer getNotificationTimer() {
        if (notificationTimer == null) {
            synchronized (NotificationTimer.class) {
                if (notificationTimer == null) {
                    notificationTimer = new NotificationTimer();
                }
            }
        }
        return notificationTimer;
    }

    public void startNotificationShowTask(long j) {
        if (!this.hasTimerTask.compareAndSet(false, true)) {
            Logger.m268d("NotificationTimer", "[startNotificationShowTask] not start new timer task because cur has exists");
        } else {
            Logger.m268d("NotificationTimer", String.format("[startNotificationShowTask]handle message after %s", Long.valueOf(j)));
            PushThreadHandlerManager.inst().postRunnable(this, j);
        }
    }
}
