package com.bytedance.platform.horae.java_impl.sync;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.platform.horae.common.Logger;
import java.lang.ref.WeakReference;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class SyncScheduleCenter extends Handler {
    public static final int MIRROR_SIGNAL = 100;

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 100) {
            if (message.obj instanceof WeakReference) {
                Message message2 = (Message) ((WeakReference) message.obj).get();
                if (message2 != null && message2.arg2 == 9527) {
                    SyncServiceScheduleManager.getInstance().addPendingMessage(message2);
                    Logger.m205e("ServiceScheduleManager", message2.what + " is delayed 5 seconds and put it into emergency list!");
                    return;
                } else {
                    Logger.m205e("ServiceScheduleManager", "After 5 minutes followed message is already handled!");
                    return;
                }
            }
            return;
        }
        throw new IllegalArgumentException("UnSupport message is " + message.what);
    }

    public SyncScheduleCenter(Looper looper) {
        super(looper);
    }
}
