package com.bytedance.applog.priority.original;

import com.bytedance.android.monitorV2.constant.MonitorConstant;
import com.bytedance.applog.forward.EventForwardLoader;
import com.bytedance.applog.priority.PriorityCallback;
import com.bytedance.applog.priority.original.Model;
import com.bytedance.applog.server.Api;
import com.bytedance.bdturing.methods.JsCallParser;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* compiled from: Common.kt */
@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007\u001a\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0002\u001a\u0016\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0013\u001a\u000e\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0007\u001a\u0014\u0010\u0016\u001a\u00020\r2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\r0\u0018\u001a6\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\b\u001a\u00020\t\u001a:\u0010 \u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00072\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00130\"2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\b\u001a\u00020\t\"\u001a\u0010\u0000\u001a\u00020\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0004\b\u0004\u0010\u0005¨\u0006$"}, d2 = {"getUft8StringSizeByChars", "", "getGetUft8StringSizeByChars", "()Z", "setGetUft8StringSizeByChars", "(Z)V", "buildPriorityReportUrl", "", "groupId", "", "reportHost", "reportPath", "gcdMin1", "", "a", "b", "getEventNameFromJson", "eventType", "json", "Lorg/json/JSONObject;", "getUtf8StringSize", "input", "minInterval", "intervals", "", "stageEvent", "", JsCallParser.VALUE_CALLBACK, "Lcom/bytedance/applog/priority/PriorityCallback;", MonitorConstant.STAGE, "priorityName", "Lcom/bytedance/applog/priority/original/Model$PriorityName;", "stageEvents", EventForwardLoader.KEY_EVENT_FORWARD_EVENTS, "", "Lcom/bytedance/applog/priority/original/Model$EventKey;", "priority_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class CommonKt {
    private static boolean getUft8StringSizeByChars = true;

    /* compiled from: Common.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Model.EventType.values().length];
            iArr[Model.EventType.V3.ordinal()] = 1;
            iArr[Model.EventType.V1.ordinal()] = 2;
            iArr[Model.EventType.LogData.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final void stageEvents(PriorityCallback priorityCallback, String str, Map<Model.EventKey, ? extends JSONObject> map, Model.PriorityName priorityName, int i) {
        Intrinsics.checkNotNullParameter(priorityCallback, JsCallParser.VALUE_CALLBACK);
        Intrinsics.checkNotNullParameter(str, MonitorConstant.STAGE);
        Intrinsics.checkNotNullParameter(map, EventForwardLoader.KEY_EVENT_FORWARD_EVENTS);
        Intrinsics.checkNotNullParameter(priorityName, "priorityName");
        if (priorityCallback.isStageEnabled()) {
            for (Map.Entry<Model.EventKey, ? extends JSONObject> entry : map.entrySet()) {
                Model.EventKey key = entry.getKey();
                stageEvent(priorityCallback, str, key.getEventType().getType(), entry.getValue(), priorityName, i);
            }
        }
    }

    public static final void stageEvent(PriorityCallback priorityCallback, String str, int i, JSONObject jSONObject, Model.PriorityName priorityName, int i2) {
        Intrinsics.checkNotNullParameter(priorityCallback, JsCallParser.VALUE_CALLBACK);
        Intrinsics.checkNotNullParameter(str, MonitorConstant.STAGE);
        Intrinsics.checkNotNullParameter(jSONObject, "json");
        Intrinsics.checkNotNullParameter(priorityName, "priorityName");
        if (priorityCallback.isStageEnabled() && jSONObject.optInt("event_stained") > 0) {
            priorityCallback.monitorStage(str, priorityName.name(), i2, i, getEventNameFromJson(i, jSONObject), jSONObject.optString(SqliteDatabaseKt.colMonitorId), jSONObject.optLong(Api.KEY_LOCAL_TIME_MS, System.currentTimeMillis()));
        }
    }

    public static final String getEventNameFromJson(int i, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "json");
        int i2 = WhenMappings.$EnumSwitchMapping$0[Model.EventType.INSTANCE.getEventType(i).ordinal()];
        if (i2 == 1) {
            String optString = jSONObject.optString("event");
            Intrinsics.checkNotNullExpressionValue(optString, "{\n            json.optString(\"event\")\n        }");
            return optString;
        }
        if (i2 == 2) {
            String optString2 = jSONObject.optString(Api.COL_TAG);
            Intrinsics.checkNotNullExpressionValue(optString2, "{\n            json.optString(\"tag\")\n        }");
            return optString2;
        }
        if (i2 != 3) {
            return "";
        }
        String optString3 = jSONObject.optString("log_type");
        Intrinsics.checkNotNullExpressionValue(optString3, "{\n            json.optString(\"log_type\")\n        }");
        return optString3;
    }

    public static final long minInterval(List<Long> list) {
        Intrinsics.checkNotNullParameter(list, "intervals");
        int size = list.size();
        if (size == 0) {
            return Long.MAX_VALUE;
        }
        if (size == 1) {
            return RangesKt.coerceAtLeast(1L, list.get(0).longValue());
        }
        return gcdMin1(list.get(0).longValue(), minInterval(list.subList(1, list.size())));
    }

    private static final long gcdMin1(long j, long j2) {
        long coerceAtLeast = RangesKt.coerceAtLeast(1L, j);
        long coerceAtLeast2 = RangesKt.coerceAtLeast(1L, j2);
        while (true) {
            long j3 = coerceAtLeast;
            coerceAtLeast = coerceAtLeast2;
            if (coerceAtLeast == 0) {
                return j3;
            }
            coerceAtLeast2 = j3 % coerceAtLeast;
        }
    }

    public static final boolean getGetUft8StringSizeByChars() {
        return getUft8StringSizeByChars;
    }

    public static final void setGetUft8StringSizeByChars(boolean z) {
        getUft8StringSizeByChars = z;
    }

    public static final int getUtf8StringSize(String str) {
        Intrinsics.checkNotNullParameter(str, "input");
        int i = 0;
        if (str.length() == 0) {
            return 0;
        }
        if (!getUft8StringSizeByChars) {
            byte[] bytes = str.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            return bytes.length;
        }
        int i2 = 0;
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt <= 127) {
                i2++;
            } else if (charAt <= 2047) {
                i2 += 2;
            } else if (Character.isHighSurrogate(charAt)) {
                i2 += 4;
                i++;
            } else {
                i2 += 3;
            }
            i++;
        }
        return i2;
    }

    public static final String buildPriorityReportUrl(int i, String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "reportHost");
        Intrinsics.checkNotNullParameter(str2, "reportPath");
        return str + str2 + "?app_log_priority=" + i;
    }
}
