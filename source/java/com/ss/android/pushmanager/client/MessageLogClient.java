package com.ss.android.pushmanager.client;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.collection.ArrayUtils;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.push.utils.Logger;
import com.ss.android.message.PushThreadHandlerManager;
import com.ss.android.pushmanager.app.MessageAppHooks;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class MessageLogClient implements WeakHandler.IHandler {
    private static final String LOG_SERVICE = "com.ss.android.message.log.LogService";
    private static final String TAG = "MessageLogClient";
    private static MessageLogClient sMessageLogClient;
    private WeakReference<Context> mContextRef;
    private Handler mHandler;
    private Messenger mMessenger;
    private Messenger mService = null;
    private long mStartId = 0;
    private ServiceConnection mConnection = new ServiceConnection() { // from class: com.ss.android.pushmanager.client.MessageLogClient.1
        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            MessageLogClient.this.mService = null;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Logger.d(MessageLogClient.TAG, "[start]on LogService Connected");
            MessageLogClient.this.mService = new Messenger(iBinder);
            MessageLogClient.this.getMessageLog();
        }
    };

    public static void start(Context context) {
        if (context == null) {
            return;
        }
        Logger.d(TAG, "[start]");
        MessageLogClient messageLogClient = sMessageLogClient;
        if (messageLogClient == null) {
            Logger.d(TAG, "[start]init sMessageLogClient");
            sMessageLogClient = new MessageLogClient(context);
        } else if (messageLogClient.mService == null) {
            Logger.d(TAG, "[start]init sMessageLogClient.mService");
            sMessageLogClient.doBindService();
        }
    }

    public static void end(Context context) {
        MessageLogClient messageLogClient;
        if (context == null || (messageLogClient = sMessageLogClient) == null) {
            return;
        }
        messageLogClient.doUnbindService();
    }

    private MessageLogClient(Context context) {
        this.mContextRef = new WeakReference<>(context.getApplicationContext());
        Looper looper = PushThreadHandlerManager.inst().getLooper();
        this.mHandler = new WeakHandler(looper == null ? Looper.getMainLooper() : looper, this);
        this.mMessenger = new Messenger(this.mHandler);
        doBindService();
    }

    private void doBindService() {
        WeakReference<Context> weakReference = this.mContextRef;
        if (weakReference != null && weakReference.get() != null) {
            try {
                Logger.d(TAG, "doBindService");
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(this.mContextRef.get(), LOG_SERVICE));
                this.mContextRef.get().bindService(intent, this.mConnection, 1);
            } catch (Throwable unused) {
            }
        }
    }

    private void doUnbindService() {
        try {
            if (this.mService == null || this.mContextRef.get() == null) {
                return;
            }
            this.mContextRef.get().unbindService(this.mConnection);
        } catch (Throwable unused) {
        }
    }

    private void hanldeEnd() {
        if (Logger.debug()) {
            Logger.d("PushLog", "hanldeEnd");
        }
        if (this.mService != null) {
            try {
                doUnbindService();
                this.mService = null;
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00d9 A[Catch: all -> 0x0153, TryCatch #0 {all -> 0x0153, blocks: (B:3:0x000a, B:6:0x0012, B:7:0x0024, B:14:0x002d, B:16:0x0033, B:17:0x0038, B:19:0x003d, B:21:0x0048, B:23:0x004e, B:25:0x0064, B:26:0x007e, B:28:0x0084, B:30:0x0095, B:34:0x013a, B:35:0x009f, B:49:0x00cb, B:39:0x00d3, B:41:0x00d9, B:42:0x0112, B:44:0x0131, B:45:0x0133, B:53:0x0140, B:55:0x0146, B:57:0x014b, B:59:0x014f), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0131 A[Catch: all -> 0x0153, TryCatch #0 {all -> 0x0153, blocks: (B:3:0x000a, B:6:0x0012, B:7:0x0024, B:14:0x002d, B:16:0x0033, B:17:0x0038, B:19:0x003d, B:21:0x0048, B:23:0x004e, B:25:0x0064, B:26:0x007e, B:28:0x0084, B:30:0x0095, B:34:0x013a, B:35:0x009f, B:49:0x00cb, B:39:0x00d3, B:41:0x00d9, B:42:0x0112, B:44:0x0131, B:45:0x0133, B:53:0x0140, B:55:0x0146, B:57:0x014b, B:59:0x014f), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0110  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handleMsg(Message message) {
        JSONObject jSONObject;
        int i;
        long optLong;
        try {
            if (Logger.debug()) {
                Logger.d("PushLog", "msg.what = " + message.what);
            }
            int i2 = message.what;
            if (i2 != 0) {
                if (i2 != 2) {
                    return;
                }
                if (Logger.debug()) {
                    Logger.d("PushLog", "MSG_END_LOG");
                }
                hanldeEnd();
                return;
            }
            Logger.d(TAG, "[handleMsg] MSG_GET_LOG");
            if (MessageAppHooks.getPushHook() == null) {
                Logger.e("PushLog", "PushHook is null");
                return;
            }
            Bundle bundle = (Bundle) message.obj;
            String string = bundle.getString("events");
            boolean z = bundle.getBoolean("has_more");
            if (Logger.debug()) {
                Logger.d("PushLog", "events = " + string + " has_more = " + z);
            }
            if (!StringUtils.isEmpty(string)) {
                ArrayList arrayList = new ArrayList();
                JSONArray jSONArray = new JSONArray(string);
                int length = jSONArray.length();
                int i3 = 0;
                while (i3 < length) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                    if (optJSONObject == null) {
                        i = length;
                    } else {
                        String optString = optJSONObject.optString("category");
                        String optString2 = optJSONObject.optString("tag");
                        String optString3 = optJSONObject.optString("label");
                        long optLong2 = optJSONObject.optLong("value");
                        long optLong3 = optJSONObject.optLong("ext_value");
                        String optString4 = optJSONObject.optString("ext_json");
                        if (!TextUtils.isEmpty(optString4)) {
                            try {
                                jSONObject = new JSONObject(optString4);
                            } catch (Exception unused) {
                            }
                            JSONObject jSONObject2 = jSONObject;
                            if (Logger.debug()) {
                                i = length;
                            } else {
                                i = length;
                                Logger.d(TAG, "[handleMsg]tag = " + optString2 + " label = " + optString3 + " ext_json_str = " + optString4 + " ext_json = " + jSONObject2);
                            }
                            MessageAppHooks.getPushHook().onEvent(this.mContextRef.get(), optString, optString2, optString3, optLong2, optLong3, jSONObject2);
                            optLong = optJSONObject.optLong("_id");
                            if (optLong > this.mStartId) {
                                this.mStartId = optLong;
                            }
                            arrayList.add(Long.valueOf(optLong));
                        }
                        jSONObject = null;
                        JSONObject jSONObject22 = jSONObject;
                        if (Logger.debug()) {
                        }
                        MessageAppHooks.getPushHook().onEvent(this.mContextRef.get(), optString, optString2, optString3, optLong2, optLong3, jSONObject22);
                        optLong = optJSONObject.optLong("_id");
                        if (optLong > this.mStartId) {
                        }
                        arrayList.add(Long.valueOf(optLong));
                    }
                    i3++;
                    length = i;
                }
                if (arrayList.size() > 0) {
                    sendHanledMsg(arrayList);
                }
            }
            if (z) {
                getMessageLog();
            } else {
                hanldeEnd();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getMessageLog() {
        try {
            Message obtain = Message.obtain((Handler) null, 0);
            obtain.replyTo = this.mMessenger;
            Bundle bundle = new Bundle();
            bundle.putLong("start_id", this.mStartId);
            if (Logger.debug()) {
                Logger.d("PushLog", "start_id = " + this.mStartId);
            }
            obtain.obj = bundle;
            this.mService.send(obtain);
        } catch (Throwable th) {
            th.printStackTrace();
            hanldeEnd();
        }
    }

    private void sendHanledMsg(List<Long> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        try {
            Message obtain = Message.obtain((Handler) null, 1);
            obtain.replyTo = this.mMessenger;
            Bundle bundle = new Bundle();
            bundle.putLongArray("event_ids", ArrayUtils.toLongArray(list));
            if (Logger.debug()) {
                Logger.d("PushLog", "event_ids = " + list);
            }
            obtain.obj = bundle;
            this.mService.send(obtain);
        } catch (Throwable th) {
            th.printStackTrace();
            hanldeEnd();
        }
    }
}
