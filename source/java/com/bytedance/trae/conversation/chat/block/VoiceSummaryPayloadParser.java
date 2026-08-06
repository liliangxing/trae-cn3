package com.bytedance.trae.conversation.chat.block;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: VoiceSummaryPayloadParser.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0010\u0010\r\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0012\u001a\u00020\tH\u0002J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0012\u001a\u00020\tH\u0002J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0015\u001a\u00020\fH\u0002J\"\u0010\u0014\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\tH\u0002J\u0016\u0010\u0019\u001a\u0004\u0018\u00010\t*\u00020\f2\u0006\u0010\u001a\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayloadParser;", "", "<init>", "()V", "gson", "Lcom/google/gson/Gson;", "parseThought", "Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayload;", "thought", "", "parseParams", "params", "Lcom/google/gson/JsonObject;", "extractSummaryText", "summaryElement", "Lcom/google/gson/JsonElement;", "parseSummaryElement", "buildPlainMarkdownPayload", "rawValue", "parseJsonStringPayload", "buildPayload", "json", "header", "markdown", "bottom", "getStringOrNull", "name", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class VoiceSummaryPayloadParser {
    public static final VoiceSummaryPayloadParser INSTANCE = new VoiceSummaryPayloadParser();
    private static final Gson gson = new Gson();

    private VoiceSummaryPayloadParser() {
    }

    public final VoiceSummaryPayload parseThought(String thought) {
        String obj;
        if (thought != null && (obj = StringsKt.trim(thought).toString()) != null) {
            if (!StringsKt.startsWith$default(obj, "{", false, 2, (Object) null)) {
                obj = null;
            }
            if (obj != null) {
                return parseJsonStringPayload(obj);
            }
        }
        return null;
    }

    public final VoiceSummaryPayload parseParams(JsonObject params) {
        if (params == null) {
            return null;
        }
        if (params.has("header") || params.has("bottom")) {
            return buildPayload(params);
        }
        JsonElement jsonElement = params.get("summary");
        if (jsonElement == null) {
            return null;
        }
        return parseSummaryElement(jsonElement);
    }

    public final String extractSummaryText(JsonElement summaryElement) {
        Object obj;
        String markdown;
        if (summaryElement == null) {
            return "";
        }
        if (summaryElement.isJsonObject()) {
            JsonObject asJsonObject = summaryElement.getAsJsonObject();
            Intrinsics.checkNotNullExpressionValue(asJsonObject, "getAsJsonObject(...)");
            markdown = getStringOrNull(asJsonObject, "summary");
            if (markdown == null) {
                return "";
            }
        } else {
            if (!summaryElement.isJsonPrimitive()) {
                return "";
            }
            try {
                Result.Companion companion = Result.Companion;
                VoiceSummaryPayloadParser voiceSummaryPayloadParser = this;
                obj = Result.constructor-impl(summaryElement.getAsString());
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            if (Result.isFailure-impl(obj)) {
                obj = null;
            }
            String str = (String) obj;
            String str2 = str != null ? str : "";
            VoiceSummaryPayload parseJsonStringPayload = parseJsonStringPayload(str2);
            if (parseJsonStringPayload == null || (markdown = parseJsonStringPayload.getMarkdown()) == null) {
                return str2;
            }
        }
        return markdown;
    }

    private final VoiceSummaryPayload parseSummaryElement(JsonElement summaryElement) {
        Object obj;
        if (summaryElement.isJsonObject()) {
            JsonObject asJsonObject = summaryElement.getAsJsonObject();
            Intrinsics.checkNotNullExpressionValue(asJsonObject, "getAsJsonObject(...)");
            return buildPayload(asJsonObject);
        }
        if (!summaryElement.isJsonPrimitive()) {
            return null;
        }
        try {
            Result.Companion companion = Result.Companion;
            VoiceSummaryPayloadParser voiceSummaryPayloadParser = this;
            obj = Result.constructor-impl(summaryElement.getAsString());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        String str = (String) (Result.isFailure-impl(obj) ? null : obj);
        if (str == null) {
            str = "";
        }
        VoiceSummaryPayload parseJsonStringPayload = parseJsonStringPayload(str);
        return parseJsonStringPayload == null ? buildPlainMarkdownPayload(str) : parseJsonStringPayload;
    }

    private final VoiceSummaryPayload buildPlainMarkdownPayload(String rawValue) {
        if (!(!StringsKt.isBlank(rawValue))) {
            rawValue = null;
        }
        if (rawValue == null) {
            return null;
        }
        return new VoiceSummaryPayload("", rawValue, "");
    }

    private final VoiceSummaryPayload parseJsonStringPayload(String rawValue) {
        Object obj;
        String obj2 = StringsKt.trim(rawValue).toString();
        if (!StringsKt.startsWith$default(obj2, "{", false, 2, (Object) null)) {
            return null;
        }
        try {
            Result.Companion companion = Result.Companion;
            VoiceSummaryPayloadParser voiceSummaryPayloadParser = this;
            obj = Result.constructor-impl((JsonObject) gson.fromJson(obj2, JsonObject.class));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        JsonObject jsonObject = (JsonObject) (Result.isFailure-impl(obj) ? null : obj);
        if (jsonObject != null) {
            return buildPayload(jsonObject);
        }
        Map<String, String> parseTopLevelStrings = LenientJsonObjectParser.INSTANCE.parseTopLevelStrings(obj2);
        String str = parseTopLevelStrings.get("header");
        if (str == null) {
            str = "";
        }
        String str2 = parseTopLevelStrings.get("summary");
        if (str2 == null) {
            str2 = "";
        }
        String str3 = parseTopLevelStrings.get("bottom");
        return buildPayload(str, str2, str3 != null ? str3 : "");
    }

    private final VoiceSummaryPayload buildPayload(JsonObject json) {
        String stringOrNull = getStringOrNull(json, "header");
        if (stringOrNull == null) {
            stringOrNull = "";
        }
        String stringOrNull2 = getStringOrNull(json, "summary");
        if (stringOrNull2 == null) {
            stringOrNull2 = "";
        }
        String stringOrNull3 = getStringOrNull(json, "bottom");
        return buildPayload(stringOrNull, stringOrNull2, stringOrNull3 != null ? stringOrNull3 : "");
    }

    private final VoiceSummaryPayload buildPayload(String header, String markdown, String bottom) {
        if (StringsKt.isBlank(markdown)) {
            return null;
        }
        return new VoiceSummaryPayload(header, markdown, bottom);
    }

    private final String getStringOrNull(JsonObject jsonObject, String str) {
        Object obj;
        JsonElement jsonElement = jsonObject.get(str);
        if (jsonElement == null || !jsonElement.isJsonPrimitive()) {
            return null;
        }
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.constructor-impl(jsonElement.getAsString());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        return (String) (Result.isFailure-impl(obj) ? null : obj);
    }
}
