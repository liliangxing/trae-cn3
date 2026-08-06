package com.bytedance.pia.core;

import com.bytedance.pia.core.tracing.EventName;
import com.bytedance.pia.core.tracing.Tracing;
import com.bytedance.pia.core.utils.GsonUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class TracingAdapter implements Tracing.Subscriber {
    private static final List<EventName> SUBSCRIBED_EVENTS = Arrays.asList(EventName.NavigateStart, EventName.WorkerEnvironmentInitializeStart, EventName.WorkerEnvironmentInitializeEnd, EventName.WorkerScriptRequestStart, EventName.WorkerScriptRequestEnd, EventName.WorkerExecuteStart);
    private final JsonObject result = new JsonObject();
    private final Set<EventName> subscribedEvents = new HashSet(SUBSCRIBED_EVENTS);

    /* JADX INFO: Access modifiers changed from: protected */
    public void onFinished() {
    }

    public JsonObject getResult() {
        return this.result;
    }

    @Override // com.bytedance.pia.core.api.utils.IConsumer
    public void accept(Tracing.Event event) {
        if (!isFinished() && this.subscribedEvents.contains(event.name)) {
            this.subscribedEvents.remove(event.name);
            switch (C04211.$SwitchMap$com$bytedance$pia$core$tracing$EventName[event.name.ordinal()]) {
                case 1:
                    put(event, "NAVS", "t");
                    break;
                case 2:
                    put(event, "WEI", "s");
                    break;
                case 3:
                    put(event, "WEI", "e");
                    break;
                case 4:
                    put(event, "RW", "s");
                    break;
                case 5:
                    put(event, "RW", "e");
                    break;
                case 6:
                    put(event, "WR", "t");
                    break;
            }
            if (isFinished()) {
                onFinished();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.pia.core.TracingAdapter$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static /* synthetic */ class C04211 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$pia$core$tracing$EventName;

        static {
            int[] iArr = new int[EventName.values().length];
            $SwitchMap$com$bytedance$pia$core$tracing$EventName = iArr;
            try {
                iArr[EventName.NavigateStart.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$bytedance$pia$core$tracing$EventName[EventName.WorkerEnvironmentInitializeStart.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$bytedance$pia$core$tracing$EventName[EventName.WorkerEnvironmentInitializeEnd.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$bytedance$pia$core$tracing$EventName[EventName.WorkerScriptRequestStart.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$bytedance$pia$core$tracing$EventName[EventName.WorkerScriptRequestEnd.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$bytedance$pia$core$tracing$EventName[EventName.WorkerExecuteStart.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private void put(Tracing.Event event, String str, String str2) {
        JsonObject jsonObject;
        JsonElement jsonElement = this.result.get(str);
        if (jsonElement != null && jsonElement.isJsonObject()) {
            jsonObject = jsonElement.getAsJsonObject();
        } else {
            jsonObject = new JsonObject();
        }
        jsonObject.addProperty(str2, event.timestamp);
        JsonElement jsonTree = GsonUtils.getGson().toJsonTree(event.args);
        if (jsonTree.isJsonObject()) {
            for (Map.Entry entry : jsonTree.getAsJsonObject().entrySet()) {
                jsonObject.add((String) entry.getKey(), (JsonElement) entry.getValue());
            }
        }
        this.result.add(str, jsonObject);
    }

    @Override // com.bytedance.pia.core.tracing.Tracing.Subscriber
    public boolean isFinished() {
        return this.subscribedEvents.isEmpty();
    }
}
