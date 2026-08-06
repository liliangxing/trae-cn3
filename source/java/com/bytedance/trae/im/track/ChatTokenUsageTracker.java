package com.bytedance.trae.im.track;

import com.bytedance.trae.im.service.ChatEventPayload;
import com.bytedance.trae.im.track.ChatFirstTokenTracker;
import com.bytedance.trae.platform.service.ApmService;
import com.bytedance.trae.utils.logger.TraeLogUtil;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: ChatTokenUsageTracker.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001eB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005H\u0002J \u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0017H\u0002J\u000e\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R4\u0010\u0007\u001a&\u0012\f\u0012\n \t*\u0004\u0018\u00010\u00050\u0005 \t*\u0012\u0012\f\u0012\n \t*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\n0\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00100\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/bytedance/trae/im/track/ChatTokenUsageTracker;", "", "<init>", "()V", "TAG", "", "EVENT_NAME", "reportedTaskIds", "", "kotlin.jvm.PlatformType", "", "Ljava/util/Set;", "lastTokenUsageTimes", "Ljava/util/concurrent/ConcurrentHashMap;", "", "cumulativeTokenUsage", "Lcom/bytedance/trae/im/track/ChatTokenUsageTracker$CumulativeTokenUsage;", "onTokenUsage", "", "taskId", "payload", "Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;", "parseServerTimingMetrics", "Lorg/json/JSONObject;", "serverTimingInfo", "flattenJsonObject", "obj", "prefix", "result", "clear", "CumulativeTokenUsage", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ChatTokenUsageTracker {
    private static final String EVENT_NAME = "icube_ai_chat_token_usage";
    private static final String TAG = "ChatTokenUsageTracker";
    public static final ChatTokenUsageTracker INSTANCE = new ChatTokenUsageTracker();
    private static final Set<String> reportedTaskIds = Collections.newSetFromMap(new ConcurrentHashMap());
    private static final ConcurrentHashMap<String, Long> lastTokenUsageTimes = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, CumulativeTokenUsage> cumulativeTokenUsage = new ConcurrentHashMap<>();

    private ChatTokenUsageTracker() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ChatTokenUsageTracker.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/bytedance/trae/im/track/ChatTokenUsageTracker$CumulativeTokenUsage;", "", "completionTokens", "", "reasoningTokens", "<init>", "(II)V", "getCompletionTokens", "()I", "setCompletionTokens", "(I)V", "getReasoningTokens", "setReasoningTokens", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class CumulativeTokenUsage {
        private int completionTokens;
        private int reasoningTokens;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public CumulativeTokenUsage() {
            this(r2, r2, 3, null);
            int i = 0;
        }

        public static /* synthetic */ CumulativeTokenUsage copy$default(CumulativeTokenUsage cumulativeTokenUsage, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = cumulativeTokenUsage.completionTokens;
            }
            if ((i3 & 2) != 0) {
                i2 = cumulativeTokenUsage.reasoningTokens;
            }
            return cumulativeTokenUsage.copy(i, i2);
        }

        /* renamed from: component1, reason: from getter */
        public final int getCompletionTokens() {
            return this.completionTokens;
        }

        /* renamed from: component2, reason: from getter */
        public final int getReasoningTokens() {
            return this.reasoningTokens;
        }

        public final CumulativeTokenUsage copy(int completionTokens, int reasoningTokens) {
            return new CumulativeTokenUsage(completionTokens, reasoningTokens);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CumulativeTokenUsage)) {
                return false;
            }
            CumulativeTokenUsage cumulativeTokenUsage = (CumulativeTokenUsage) other;
            return this.completionTokens == cumulativeTokenUsage.completionTokens && this.reasoningTokens == cumulativeTokenUsage.reasoningTokens;
        }

        public int hashCode() {
            return (Integer.hashCode(this.completionTokens) * 31) + Integer.hashCode(this.reasoningTokens);
        }

        public String toString() {
            return "CumulativeTokenUsage(completionTokens=" + this.completionTokens + ", reasoningTokens=" + this.reasoningTokens + ')';
        }

        public CumulativeTokenUsage(int i, int i2) {
            this.completionTokens = i;
            this.reasoningTokens = i2;
        }

        public /* synthetic */ CumulativeTokenUsage(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2);
        }

        public final int getCompletionTokens() {
            return this.completionTokens;
        }

        public final void setCompletionTokens(int i) {
            this.completionTokens = i;
        }

        public final int getReasoningTokens() {
            return this.reasoningTokens;
        }

        public final void setReasoningTokens(int i) {
            this.reasoningTokens = i;
        }
    }

    public final void onTokenUsage(String taskId, ChatEventPayload.TokenUsage payload) {
        Double d;
        Long l;
        int i;
        CumulativeTokenUsage putIfAbsent;
        Set set;
        Iterator<String> it;
        boolean z;
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        Intrinsics.checkNotNullParameter(payload, "payload");
        Set<String> set2 = reportedTaskIds;
        if (!set2.add(taskId)) {
            TraeLogUtil.INSTANCE.d(TAG, "onTokenUsage: already reported for taskId=" + taskId + ", skip");
            return;
        }
        ChatFirstTokenTracker.FirstTokenReportedContext reportedContext = ChatFirstTokenTracker.INSTANCE.getReportedContext(taskId);
        if (reportedContext == null) {
            TraeLogUtil.INSTANCE.d(TAG, "onTokenUsage: no firstToken context for taskId=" + taskId + ", skip");
            set2.remove(taskId);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Integer completionTokens = payload.getCompletionTokens();
        int intValue = completionTokens != null ? completionTokens.intValue() : 0;
        Integer reasoningTokens = payload.getReasoningTokens();
        int intValue2 = reasoningTokens != null ? reasoningTokens.intValue() : 0;
        int i2 = intValue + intValue2;
        Long l2 = lastTokenUsageTimes.get(taskId);
        long longValue = l2 != null ? l2.longValue() : reportedContext.getFirstTokenTime();
        if (i2 > 0) {
            l = Long.valueOf(currentTimeMillis - longValue);
            d = l.longValue() > 0 ? Double.valueOf(l.longValue() / i2) : null;
        } else {
            d = null;
            l = null;
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject metrics = reportedContext.getMetrics();
        Set of = SetsKt.setOf(new String[]{"fe_", "rs_", "svr_"});
        Iterator<String> keys = metrics.keys();
        Intrinsics.checkNotNullExpressionValue(keys, "keys(...)");
        while (keys.hasNext()) {
            String next = keys.next();
            Set set3 = of;
            if (!(set3 instanceof Collection) || !set3.isEmpty()) {
                Iterator it2 = set3.iterator();
                while (it2.hasNext()) {
                    String str = (String) it2.next();
                    Intrinsics.checkNotNull(next);
                    Iterator it3 = it2;
                    set = of;
                    it = keys;
                    if (StringsKt.startsWith$default(next, str, false, 2, (Object) null)) {
                        z = true;
                        break;
                    } else {
                        it2 = it3;
                        of = set;
                        keys = it;
                    }
                }
            }
            set = of;
            it = keys;
            z = false;
            if (!z) {
                jSONObject.put(next, metrics.get(next));
            }
            of = set;
            keys = it;
        }
        JSONObject parseServerTimingMetrics = parseServerTimingMetrics(reportedContext.getServerTimingInfo());
        JSONObject jSONObject2 = new JSONObject();
        Iterator<String> keys2 = jSONObject.keys();
        Intrinsics.checkNotNullExpressionValue(keys2, "keys(...)");
        while (keys2.hasNext()) {
            String next2 = keys2.next();
            jSONObject2.put(next2, jSONObject.get(next2));
        }
        Iterator<String> keys3 = parseServerTimingMetrics.keys();
        Intrinsics.checkNotNullExpressionValue(keys3, "keys(...)");
        while (keys3.hasNext()) {
            String next3 = keys3.next();
            jSONObject2.put(next3, parseServerTimingMetrics.get(next3));
        }
        jSONObject2.put("completionTokens", intValue);
        jSONObject2.put("reasoningTokens", intValue2);
        Integer totalTokens = payload.getTotalTokens();
        jSONObject2.put("totalTokens", totalTokens != null ? totalTokens.intValue() : 0);
        Integer cacheCreationInputTokens = payload.getCacheCreationInputTokens();
        jSONObject2.put("cacheCreationInputTokens", cacheCreationInputTokens != null ? cacheCreationInputTokens.intValue() : 0);
        Integer cacheReadInputTokens = payload.getCacheReadInputTokens();
        jSONObject2.put("cacheReadInputTokens", cacheReadInputTokens != null ? cacheReadInputTokens.intValue() : 0);
        Integer lastTurnTotalTokens = payload.getLastTurnTotalTokens();
        jSONObject2.put("lastTurnTotalTokens", lastTurnTotalTokens != null ? lastTurnTotalTokens.intValue() : 0);
        Integer promptTokensTotal = payload.getPromptTokensTotal();
        jSONObject2.put("promptTokensTotal", promptTokensTotal != null ? promptTokensTotal.intValue() : 0);
        Integer promptTokens = payload.getPromptTokens();
        jSONObject2.put("promptTokens", promptTokens != null ? promptTokens.intValue() : 0);
        Integer completionTokensTotal = payload.getCompletionTokensTotal();
        jSONObject2.put("completionTokensTotal", completionTokensTotal != null ? completionTokensTotal.intValue() : 0);
        if (d != null) {
            jSONObject2.put("tpot", d.doubleValue());
        }
        if (l != null) {
            jSONObject2.put("outputDuration", l.longValue());
        }
        DefaultConstructorMarker defaultConstructorMarker = null;
        ApmService.INSTANCE.monitorEventForSlardar(EVENT_NAME, reportedContext.getCategories(), jSONObject2, (JSONObject) null);
        lastTokenUsageTimes.put(taskId, Long.valueOf(currentTimeMillis));
        ConcurrentHashMap<String, CumulativeTokenUsage> concurrentHashMap = cumulativeTokenUsage;
        CumulativeTokenUsage cumulativeTokenUsage2 = concurrentHashMap.get(taskId);
        if (cumulativeTokenUsage2 == null && (putIfAbsent = concurrentHashMap.putIfAbsent(taskId, (cumulativeTokenUsage2 = new CumulativeTokenUsage((i = 0), i, 3, defaultConstructorMarker)))) != null) {
            cumulativeTokenUsage2 = putIfAbsent;
        }
        CumulativeTokenUsage cumulativeTokenUsage3 = cumulativeTokenUsage2;
        cumulativeTokenUsage3.setCompletionTokens(cumulativeTokenUsage3.getCompletionTokens() + intValue);
        cumulativeTokenUsage3.setReasoningTokens(cumulativeTokenUsage3.getReasoningTokens() + intValue2);
    }

    private final JSONObject parseServerTimingMetrics(String serverTimingInfo) {
        JSONObject jSONObject = new JSONObject();
        String str = serverTimingInfo;
        if (str == null || StringsKt.isBlank(str)) {
            return jSONObject;
        }
        try {
            flattenJsonObject(new JSONObject(serverTimingInfo), "", jSONObject);
        } catch (Throwable th) {
            TraeLogUtil.INSTANCE.d(TAG, "parseServerTimingMetrics: parse error, serverTimingInfo=" + serverTimingInfo + ", e=" + th);
        }
        return jSONObject;
    }

    private final void flattenJsonObject(JSONObject obj, String prefix, JSONObject result) {
        Iterator<String> keys = obj.keys();
        Intrinsics.checkNotNullExpressionValue(keys, "keys(...)");
        while (keys.hasNext()) {
            String next = keys.next();
            String str = prefix.length() == 0 ? next : prefix + "__" + next;
            Object obj2 = obj.get(next);
            if (obj2 instanceof Number) {
                result.put(str, obj2);
            } else if (obj2 instanceof JSONObject) {
                Intrinsics.checkNotNull(str);
                INSTANCE.flattenJsonObject((JSONObject) obj2, str, result);
            }
        }
    }

    public final void clear(String taskId) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        try {
            reportedTaskIds.remove(taskId);
            lastTokenUsageTimes.remove(taskId);
            cumulativeTokenUsage.remove(taskId);
        } catch (Throwable unused) {
        }
    }
}
