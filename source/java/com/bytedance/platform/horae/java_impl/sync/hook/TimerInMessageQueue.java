package com.bytedance.platform.horae.java_impl.sync.hook;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.reflect.Method;

/* loaded from: classes4.dex */
public class TimerInMessageQueue extends OnHookItem {
    private static final int TIMER_TICK = 101;
    private static final long TIME_LONG_CHECK_INTERVAL = 3000;
    private TickHandler mTickHandler;
    private Method setAsynchronous;

    public TimerInMessageQueue(OnHookPointTrigger onHookPointTrigger) {
        super("TimerInMessageQueue", onHookPointTrigger);
    }

    /* loaded from: classes4.dex */
    public class TickHandler extends Handler {
        public TickHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what != 101) {
                return;
            }
            if (TimerInMessageQueue.this.mOnHookPointTrigger != null) {
                TimerInMessageQueue.this.mOnHookPointTrigger.onHookPointTrigger(TimerInMessageQueue.this.mChanel);
            }
            TimerInMessageQueue.this.sendTickMessage();
        }
    }

    @Override // com.bytedance.platform.horae.java_impl.sync.hook.OnHookItem
    public void onHook() {
        this.mTickHandler = new TickHandler(Looper.getMainLooper());
        sendTickMessage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendTickMessage() {
        Message obtainMessage = this.mTickHandler.obtainMessage(101);
        obtainMessage.setAsynchronous(true);
        this.mTickHandler.sendMessageDelayed(obtainMessage, 3000L);
    }
}
