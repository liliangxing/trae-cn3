package com.bytedance.trae.im.log;

import com.bytedance.trae.im.model.ParsedChatMessage;
import com.bytedance.trae.im.model.ParsedPlanItem;
import com.bytedance.trae.im.model.ParsedPlanItemMessage;
import com.bytedance.trae.im.model.ParsedTaskContent;
import com.bytedance.trae.im.model.ParsedToolCallInfo;
import com.bytedance.trae.utils.logger.TraeLogUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* compiled from: IMLog.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001cB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013J\u0018\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0018\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0018\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/bytedance/trae/im/log/IMLog;", "", "<init>", "()V", "AGENT_FLOW_TAG", "", "MAX_LOG_LENGTH", "", "MAX_VALUE_LENGTH", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "gson$delegate", "Lkotlin/Lazy;", "logParsedChatMessage", "", "label", "message", "Lcom/bytedance/trae/im/model/ParsedChatMessage;", "logFullJson", "logPlanItems", "truncateValues", "element", "Lcom/google/gson/JsonElement;", "logLongText", "prefix", "text", "ParsedContentTypeAdapter", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class IMLog {
    private static final String AGENT_FLOW_TAG = "AgentDataFlowNew";
    private static final int MAX_LOG_LENGTH = 4000;
    private static final int MAX_VALUE_LENGTH = 500;
    public static final IMLog INSTANCE = new IMLog();

    /* renamed from: gson$delegate, reason: from kotlin metadata */
    private static final Lazy gson = LazyKt.lazy(new Function0() { // from class: com.bytedance.trae.im.log.IMLog$$ExternalSyntheticLambda0
        public final Object invoke() {
            Gson gson_delegate$lambda$0;
            gson_delegate$lambda$0 = IMLog.gson_delegate$lambda$0();
            return gson_delegate$lambda$0;
        }
    });

    private IMLog() {
    }

    private final Gson getGson() {
        Object value = gson.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (Gson) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Gson gson_delegate$lambda$0() {
        return new GsonBuilder().registerTypeAdapter(Object.class, new ParsedContentTypeAdapter()).setPrettyPrinting().create();
    }

    public final void logParsedChatMessage(String label, ParsedChatMessage message) {
        Intrinsics.checkNotNullParameter(label, "label");
        Intrinsics.checkNotNullParameter(message, "message");
        try {
            logFullJson(label, message);
            logPlanItems(label, message);
        } catch (Exception e) {
            TraeLogUtil.INSTANCE.d(AGENT_FLOW_TAG, "[" + label + "] logParsedChatMessage error: " + e.getMessage());
        }
    }

    private final void logFullJson(String label, ParsedChatMessage message) {
        JsonElement jsonTree = getGson().toJsonTree(message);
        Intrinsics.checkNotNull(jsonTree);
        truncateValues(jsonTree);
        String json = getGson().toJson(jsonTree);
        TraeLogUtil.INSTANCE.d(AGENT_FLOW_TAG, "[" + label + "] ParsedChatMessage fullJson (msgId=" + message.getMessageId() + ", role=" + message.getRole() + ", totalLen=" + json.length() + ')');
        Intrinsics.checkNotNull(json);
        logLongText("[" + label + "] fullJson", json);
    }

    private final void logPlanItems(String label, ParsedChatMessage message) {
        ParsedToolCallInfo toolCallInfo;
        ParsedTaskContent taskContent = message.getTaskContent();
        if (taskContent == null) {
            TraeLogUtil.INSTANCE.d(AGENT_FLOW_TAG, "[" + label + "] PlanItems: no taskContent (role=" + message.getRole() + ')');
            return;
        }
        List<ParsedPlanItemMessage> messages = taskContent.getMessages();
        List<ParsedPlanItemMessage> list = messages;
        int i = 0;
        if (list == null || list.isEmpty()) {
            TraeLogUtil.INSTANCE.d(AGENT_FLOW_TAG, "[" + label + "] PlanItems: empty (taskId=" + taskContent.getTaskId() + ')');
            return;
        }
        TraeLogUtil.INSTANCE.d(AGENT_FLOW_TAG, "[" + label + "] PlanItems: count=" + messages.size() + ", taskId=" + taskContent.getTaskId());
        for (Object obj : messages) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            ParsedPlanItemMessage parsedPlanItemMessage = (ParsedPlanItemMessage) obj;
            String str = "[" + label + "] PlanItem[" + i + '/' + messages.size() + ']';
            IMLog iMLog = INSTANCE;
            JsonElement jsonTree = iMLog.getGson().toJsonTree(parsedPlanItemMessage);
            Intrinsics.checkNotNull(jsonTree);
            iMLog.truncateValues(jsonTree);
            String json = iMLog.getGson().toJson(jsonTree);
            TraeLogUtil traeLogUtil = TraeLogUtil.INSTANCE;
            StringBuilder append = new StringBuilder().append(str).append(" (id=");
            ParsedPlanItem planItem = parsedPlanItemMessage.getPlanItem();
            String str2 = null;
            StringBuilder append2 = append.append(planItem != null ? planItem.getId() : null).append(", toolCall=");
            ParsedPlanItem planItem2 = parsedPlanItemMessage.getPlanItem();
            if (planItem2 != null && (toolCallInfo = planItem2.getToolCallInfo()) != null) {
                str2 = toolCallInfo.getName();
            }
            traeLogUtil.d(AGENT_FLOW_TAG, append2.append(str2).append(')').toString());
            Intrinsics.checkNotNull(json);
            iMLog.logLongText(str, json);
            i = i2;
        }
    }

    private final void truncateValues(JsonElement element) {
        if (element.isJsonObject()) {
            JsonObject asJsonObject = element.getAsJsonObject();
            Set keySet = asJsonObject.keySet();
            Intrinsics.checkNotNullExpressionValue(keySet, "keySet(...)");
            for (String str : CollectionsKt.toList(keySet)) {
                JsonElement jsonElement = asJsonObject.get(str);
                if (jsonElement.isJsonPrimitive() && jsonElement.getAsJsonPrimitive().isString()) {
                    String asString = jsonElement.getAsString();
                    if (asString.length() > 500) {
                        StringBuilder sb = new StringBuilder();
                        Intrinsics.checkNotNull(asString);
                        asJsonObject.addProperty(str, sb.append(StringsKt.take(asString, 500)).append("…(truncated, total=").append(asString.length()).append(')').toString());
                    }
                } else {
                    Intrinsics.checkNotNull(jsonElement);
                    truncateValues(jsonElement);
                }
            }
            return;
        }
        if (element.isJsonArray()) {
            JsonArray asJsonArray = element.getAsJsonArray();
            int size = asJsonArray.size();
            for (int i = 0; i < size; i++) {
                JsonElement jsonElement2 = asJsonArray.get(i);
                if (jsonElement2.isJsonPrimitive() && jsonElement2.getAsJsonPrimitive().isString()) {
                    String asString2 = jsonElement2.getAsString();
                    if (asString2.length() > 500) {
                        StringBuilder sb2 = new StringBuilder();
                        Intrinsics.checkNotNull(asString2);
                        asJsonArray.set(i, new JsonPrimitive(sb2.append(StringsKt.take(asString2, 500)).append("…(truncated, total=").append(asString2.length()).append(')').toString()));
                    }
                } else {
                    Intrinsics.checkNotNull(jsonElement2);
                    truncateValues(jsonElement2);
                }
            }
        }
    }

    private final void logLongText(String prefix, String text) {
        if (text.length() <= 4000) {
            TraeLogUtil.INSTANCE.d(AGENT_FLOW_TAG, prefix + ": " + text);
            return;
        }
        int length = ((text.length() + 4000) - 1) / 4000;
        int i = 0;
        int i2 = 1;
        while (i < text.length()) {
            int coerceAtMost = RangesKt.coerceAtMost(i + 4000, text.length());
            TraeLogUtil traeLogUtil = TraeLogUtil.INSTANCE;
            StringBuilder append = new StringBuilder().append(prefix).append(" [part ").append(i2).append('/').append(length).append("]: ");
            String substring = text.substring(i, coerceAtMost);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            traeLogUtil.d(AGENT_FLOW_TAG, append.append(substring).toString());
            i2++;
            i = coerceAtMost;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: IMLog.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\"\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0012H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/trae/im/log/IMLog$ParsedContentTypeAdapter;", "Lcom/google/gson/JsonSerializer;", "", "Lcom/google/gson/JsonDeserializer;", "<init>", "()V", "innerGson", "Lcom/google/gson/Gson;", "serialize", "Lcom/google/gson/JsonElement;", "src", "typeOfSrc", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonSerializationContext;", "deserialize", "json", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class ParsedContentTypeAdapter implements JsonSerializer<Object>, JsonDeserializer<Object> {
        private final Gson innerGson = new Gson();

        public JsonElement serialize(Object src, Type typeOfSrc, JsonSerializationContext context) {
            Intrinsics.checkNotNullParameter(typeOfSrc, "typeOfSrc");
            Intrinsics.checkNotNullParameter(context, "context");
            if (src instanceof String) {
                return new JsonPrimitive((String) src);
            }
            if (src instanceof ParsedTaskContent) {
                JsonElement jsonTree = this.innerGson.toJsonTree(src, ParsedTaskContent.class);
                Intrinsics.checkNotNullExpressionValue(jsonTree, "toJsonTree(...)");
                return jsonTree;
            }
            JsonElement serialize = context.serialize(src);
            Intrinsics.checkNotNullExpressionValue(serialize, "serialize(...)");
            return serialize;
        }

        public Object deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
            Intrinsics.checkNotNullParameter(json, "json");
            Intrinsics.checkNotNullParameter(typeOfT, "typeOfT");
            Intrinsics.checkNotNullParameter(context, "context");
            if (json.isJsonPrimitive() && json.getAsJsonPrimitive().isString()) {
                return json.getAsString();
            }
            if (json.isJsonObject()) {
                return this.innerGson.fromJson(json, ParsedTaskContent.class);
            }
            return null;
        }
    }
}
