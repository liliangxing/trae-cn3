package com.bytedance.tobshadow.applog.log;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public final class EventBus extends Thread implements Handler.Callback {
    private static final int EMIT_EVENT_MSG = 1;
    public static AbsSingleton<EventBus> global = new AbsSingleton<EventBus>() { // from class: com.bytedance.tobshadow.applog.log.EventBus.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bytedance.tobshadow.applog.log.AbsSingleton
        public EventBus create(Object... objArr) {
            return new EventBus();
        }
    };
    private Handler eventHandler;
    private final Map<String, List<Subscription>> subscriptionMap = new ConcurrentHashMap();

    /* loaded from: classes5.dex */
    public interface DataFetcher {
        Object fetch();
    }

    /* loaded from: classes5.dex */
    public interface Subscription {
        void sub(Object obj);
    }

    public EventBus() {
        start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class MessageEvent {
        Object data;
        String event;

        MessageEvent(String str, Object obj) {
            this.event = str;
            this.data = obj;
        }
    }

    public void emit(String str, Object obj) {
        if (TextUtils.isEmpty(str) || !this.subscriptionMap.containsKey(str)) {
            return;
        }
        emit(new MessageEvent(str, obj));
    }

    public void emit(String str, DataFetcher dataFetcher) {
        if (TextUtils.isEmpty(str) || !this.subscriptionMap.containsKey(str) || dataFetcher == null) {
            return;
        }
        emit(new MessageEvent(str, dataFetcher.fetch()));
    }

    public synchronized void listen(String str, Subscription subscription) {
        List<Subscription> list = this.subscriptionMap.get(str);
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(subscription);
        this.subscriptionMap.put(str, list);
    }

    public synchronized void remove(String str, Subscription subscription) {
        List<Subscription> list = this.subscriptionMap.get(str);
        if (list != null && list.contains(subscription)) {
            list.remove(subscription);
            if (list.size() == 0) {
                this.subscriptionMap.remove(str);
            } else {
                this.subscriptionMap.put(str, list);
            }
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        Looper.prepare();
        this.eventHandler = new Handler(this);
        Looper.loop();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 1) {
            emitEvent((MessageEvent) message.obj);
        }
        return true;
    }

    private void emit(MessageEvent messageEvent) {
        Handler handler = this.eventHandler;
        if (handler != null) {
            handler.sendMessage(handler.obtainMessage(1, messageEvent));
        } else {
            emitEvent(messageEvent);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x007f A[Catch: all -> 0x00b4, TRY_LEAVE, TryCatch #0 {all -> 0x00b4, blocks: (B:7:0x0012, B:10:0x0021, B:12:0x0027, B:14:0x0031, B:16:0x003d, B:18:0x0075, B:19:0x0079, B:21:0x007f, B:24:0x008b, B:28:0x009c, B:30:0x00a1, B:31:0x00a4, B:37:0x00ae, B:34:0x00a8, B:42:0x0043, B:44:0x004d, B:46:0x0053, B:48:0x005d, B:50:0x0069), top: B:6:0x0012, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void emitEvent(MessageEvent messageEvent) {
        byte[] bArr;
        List<Subscription> list = this.subscriptionMap.get(messageEvent.event);
        if (list == null) {
            return;
        }
        HashSet hashSet = new HashSet();
        try {
            if ("applog_event_upload_eid".equals(messageEvent.event) && (messageEvent.data instanceof JSONObject) && ((JSONObject) messageEvent.data).has("$$EVENT_LOCAL_IDS")) {
                Object opt = ((JSONObject) messageEvent.data).opt("$$EVENT_LOCAL_IDS");
                if (opt instanceof Collection) {
                    hashSet.addAll((Collection) opt);
                }
            } else if ("applog_do_request_end".equals(messageEvent.event) && (messageEvent.data instanceof JSONObject) && ((JSONObject) messageEvent.data).has("responseByte")) {
                Object opt2 = ((JSONObject) messageEvent.data).opt("responseByte");
                if (opt2 instanceof byte[]) {
                    bArr = (byte[]) ((byte[]) opt2).clone();
                    for (Subscription subscription : list) {
                        if (messageEvent.data instanceof JSONObject) {
                            try {
                                JSONObject jSONObject = new JSONObject(messageEvent.data.toString());
                                if (!hashSet.isEmpty()) {
                                    jSONObject.put("$$EVENT_LOCAL_IDS", hashSet);
                                }
                                if (bArr != null) {
                                    jSONObject.put("responseByte", bArr);
                                }
                                subscription.sub(jSONObject);
                            } catch (JSONException unused) {
                                subscription.sub(messageEvent.data);
                            }
                        } else {
                            subscription.sub(messageEvent.data);
                        }
                    }
                }
            }
            bArr = null;
            while (r0.hasNext()) {
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
