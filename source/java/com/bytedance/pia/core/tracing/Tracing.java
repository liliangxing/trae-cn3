package com.bytedance.pia.core.tracing;

import com.bytedance.pia.core.api.utils.IConsumer;
import com.bytedance.pia.core.utils.GsonUtils;
import com.bytedance.pia.core.utils.ThreadUtil;
import com.google.gson.JsonArray;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class Tracing {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final List<Event> buffer = new ArrayList();
    private final Set<Subscriber> subscribers = new HashSet();
    private final AtomicLong tracingID = new AtomicLong(0);

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public interface Subscriber extends IConsumer<Event> {
        boolean isFinished();
    }

    public void trace(EventName eventName) {
        traceWithArgs(eventName).flush();
    }

    public Event traceWithArgs(EventName eventName) {
        return traceWithArgs(eventName, System.currentTimeMillis());
    }

    public Event traceWithArgs(EventName eventName, long j) {
        return new Event(eventName, j);
    }

    public JsonArray consume(boolean z) {
        JsonArray asJsonArray = GsonUtils.getGson().toJsonTree(this.buffer).getAsJsonArray();
        if (z) {
            this.buffer.clear();
        }
        return asJsonArray;
    }

    public void subscribe(final Subscriber subscriber) {
        ThreadUtil.runOnPia(new Runnable() { // from class: com.bytedance.pia.core.tracing.Tracing$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                Tracing.this.m767lambda$subscribe$0$combytedancepiacoretracingTracing(subscriber);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$subscribe$0$com-bytedance-pia-core-tracing-Tracing, reason: not valid java name */
    public /* synthetic */ void m767lambda$subscribe$0$combytedancepiacoretracingTracing(Subscriber subscriber) {
        Iterator<Event> it = this.buffer.iterator();
        while (it.hasNext()) {
            subscriber.accept(it.next());
            if (subscriber.isFinished()) {
                break;
            }
        }
        if (subscriber.isFinished()) {
            return;
        }
        this.subscribers.add(subscriber);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void flush(final Event event, final boolean z) {
        ThreadUtil.runOnPia(new Runnable() { // from class: com.bytedance.pia.core.tracing.Tracing$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                Tracing.this.m766lambda$flush$1$combytedancepiacoretracingTracing(event, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$flush$1$com-bytedance-pia-core-tracing-Tracing, reason: not valid java name */
    public /* synthetic */ void m766lambda$flush$1$combytedancepiacoretracingTracing(Event event, boolean z) {
        if (event.hasFlushed) {
            return;
        }
        event.hasFlushed = true;
        if (!z) {
            Iterator<Event> it = this.buffer.iterator();
            while (it.hasNext()) {
                if (it.next().name == event.name) {
                    return;
                }
            }
        }
        this.buffer.add(event);
        Iterator<Subscriber> it2 = this.subscribers.iterator();
        while (it2.hasNext()) {
            Subscriber next = it2.next();
            next.accept(event);
            if (next.isFinished()) {
                it2.remove();
            }
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public class Event {

        @SerializedName("args")
        public final Map<String, Object> args;

        @GsonUtils.Exclude
        private boolean hasFlushed;

        /* renamed from: id */
        @SerializedName("id")
        public long f73id;

        @SerializedName("name")
        public final EventName name;

        @SerializedName("ts")
        public final Long timestamp;

        private Event(EventName eventName, long j) {
            this.f73id = Tracing.this.tracingID.getAndIncrement();
            this.hasFlushed = false;
            this.name = eventName;
            this.timestamp = Long.valueOf(j);
            this.args = new HashMap();
        }

        public Event appendArg(String str, Object obj) {
            this.args.put(str, obj);
            return this;
        }

        public void flush() {
            Tracing.this.flush(this, true);
        }

        public void flush(boolean z) {
            Tracing.this.flush(this, z);
        }
    }
}
