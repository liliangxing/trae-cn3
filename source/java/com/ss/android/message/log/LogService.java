package com.ss.android.message.log;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import com.bytedance.common.utility.collection.ArrayUtils;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.push.utils.Logger;
import com.ss.android.message.PushThreadHandlerManager;
import com.ss.android.pushmanager.app.MessageAppHooks;
import org.json.JSONArray;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class LogService extends Service implements WeakHandler.IHandler {
    public static final int MSG_END_LOG = 2;
    public static final int MSG_GET_LOG = 0;
    public static final int MSG_LOG_HANDLED = 1;
    public static final int PAGE_COUNT = 5;
    private Messenger mMessenger;

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        Logger.d("PushLog", "onUnBind " + this);
        return super.onUnbind(intent);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        Logger.d("PushLog", "onBind " + this);
        return this.mMessenger.getBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Logger.d("PushLog", "onCreate " + this);
        try {
            MessageAppHooks.InitHook initHook = MessageAppHooks.getInitHook();
            if (initHook != null) {
                initHook.tryInit(this);
            }
        } catch (Throwable unused) {
        }
        this.mMessenger = new Messenger((Handler) new WeakHandler(PushThreadHandlerManager.inst().getLooper(), this));
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        int onStartCommand = super.onStartCommand(intent, i, i2);
        MessageAppHooks.PushHook pushHook = MessageAppHooks.getPushHook();
        if (pushHook == null || !pushHook.needControlFlares()) {
            return onStartCommand;
        }
        return 2;
    }

    public void handleMsg(Message message) {
        DBHelper dBHelper;
        try {
            try {
                dBHelper = DBHelper.getInstance(this);
            } catch (Exception e) {
                e.printStackTrace();
                dBHelper = null;
            }
            Logger.d("PushLog", "handleMsg msg.what = " + message.what);
            int i = message.what;
            if (i == 0) {
                if (message.replyTo != null) {
                    Messenger messenger = message.replyTo;
                    long j = ((Bundle) message.obj).getLong("start_id", 0L);
                    if (dBHelper == null) {
                        messenger.send(Message.obtain((Handler) null, 2));
                        return;
                    }
                    JSONArray events = dBHelper.getEvents(j, 5);
                    if (events == null) {
                        messenger.send(Message.obtain((Handler) null, 2));
                        return;
                    }
                    Message obtain = Message.obtain((Handler) null, 0);
                    Bundle bundle = new Bundle();
                    bundle.putString("events", events.toString());
                    if (events.length() >= 5) {
                        bundle.putBoolean("has_more", true);
                    } else {
                        bundle.putBoolean("has_more", false);
                    }
                    Logger.d("PushLog", "events = " + bundle.get("events") + " has_more = " + bundle.get("has_more"));
                    obtain.obj = bundle;
                    messenger.send(obtain);
                    return;
                }
                return;
            }
            if (i == 1 && message.replyTo != null) {
                Messenger messenger2 = message.replyTo;
                long[] longArray = ((Bundle) message.obj).getLongArray("event_ids");
                if (longArray != null) {
                    Logger.d("PushLog", "event_ids = " + ArrayUtils.toList(longArray));
                    if (dBHelper == null) {
                        messenger2.send(Message.obtain((Handler) null, 2));
                        return;
                    }
                    for (long j2 : longArray) {
                        dBHelper.deleteEvent(j2);
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
