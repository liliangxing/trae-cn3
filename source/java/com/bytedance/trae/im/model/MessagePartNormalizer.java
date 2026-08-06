package com.bytedance.trae.im.model;

import com.bytedance.sdk.account.save.database.DBData;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: MessagePartNormalizer.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u0006\u0010\u0013\u001a\u00020\u0011J\"\u0010\u0014\u001a\u0004\u0018\u00010\u00112\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\b\b\u0002\u0010\u0016\u001a\u00020\u0011J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0017\u001a\u00020\fJ\u0012\u0010\u0018\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0019\u001a\u00020\u000eH\u0002J\u0010\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u0011H\u0002J\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u00112\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u0011*\u00020\u001e2\u0006\u0010 \u001a\u00020\u0011H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006!"}, d2 = {"Lcom/bytedance/trae/im/model/MessagePartNormalizer;", "", "<init>", "()V", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "gson$delegate", "Lkotlin/Lazy;", "parseContent", "", "Lcom/bytedance/trae/im/model/MessagePart;", ReportConstant.COMMON_CONTENT, "Lcom/google/gson/JsonElement;", "parseContentString", "rawContent", "", "parseQuery", "queryString", "extractText", "parts", "separator", "part", "normalizePart", "element", "textPart", "text", "textFromData", "data", "Lcom/google/gson/JsonObject;", "getStringOrNull", "key", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class MessagePartNormalizer {
    public static final MessagePartNormalizer INSTANCE = new MessagePartNormalizer();

    /* renamed from: gson$delegate, reason: from kotlin metadata */
    private static final Lazy gson = LazyKt.lazy(new Function0() { // from class: com.bytedance.trae.im.model.MessagePartNormalizer$$ExternalSyntheticLambda0
        public final Object invoke() {
            Gson gson_delegate$lambda$0;
            gson_delegate$lambda$0 = MessagePartNormalizer.gson_delegate$lambda$0();
            return gson_delegate$lambda$0;
        }
    });

    private MessagePartNormalizer() {
    }

    private final Gson getGson() {
        return (Gson) gson.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Gson gson_delegate$lambda$0() {
        return new Gson();
    }

    public final List<MessagePart> parseContent(JsonElement content) {
        Object obj;
        ArrayList listOf;
        if (content == null || content.isJsonNull()) {
            return null;
        }
        try {
            Result.Companion companion = Result.Companion;
            MessagePartNormalizer messagePartNormalizer = this;
            if (content.isJsonArray()) {
                Iterable<JsonElement> asJsonArray = content.getAsJsonArray();
                Intrinsics.checkNotNullExpressionValue(asJsonArray, "getAsJsonArray(...)");
                ArrayList arrayList = new ArrayList();
                for (JsonElement jsonElement : asJsonArray) {
                    Intrinsics.checkNotNull(jsonElement);
                    MessagePart normalizePart = normalizePart(jsonElement);
                    if (normalizePart != null) {
                        arrayList.add(normalizePart);
                    }
                }
                ArrayList arrayList2 = arrayList;
                if (arrayList2.isEmpty()) {
                    arrayList2 = null;
                }
                listOf = arrayList2;
            } else if (content.isJsonObject()) {
                MessagePart normalizePart2 = normalizePart(content);
                if (normalizePart2 != null) {
                    listOf = CollectionsKt.listOf(normalizePart2);
                }
                listOf = null;
            } else {
                if (content.isJsonPrimitive()) {
                    String asString = content.getAsString();
                    Intrinsics.checkNotNull(asString);
                    if (!(asString.length() > 0)) {
                        asString = null;
                    }
                    if (asString != null) {
                        listOf = CollectionsKt.listOf(textPart(asString));
                    }
                }
                listOf = null;
            }
            obj = Result.constructor-impl(listOf);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        return (List) (Result.isFailure-impl(obj) ? null : obj);
    }

    public final List<MessagePart> parseContentString(String rawContent) {
        Object obj;
        Intrinsics.checkNotNullParameter(rawContent, "rawContent");
        String str = rawContent;
        String obj2 = StringsKt.trim(str).toString();
        if (!StringsKt.startsWith$default(obj2, "{", false, 2, (Object) null) && !StringsKt.startsWith$default(obj2, "[", false, 2, (Object) null)) {
            if (!(str.length() > 0)) {
                rawContent = null;
            }
            if (rawContent != null) {
                return CollectionsKt.listOf(INSTANCE.textPart(rawContent));
            }
            return null;
        }
        try {
            Result.Companion companion = Result.Companion;
            MessagePartNormalizer messagePartNormalizer = this;
            obj = Result.constructor-impl((JsonElement) getGson().fromJson(obj2, JsonElement.class));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        List<MessagePart> parseContent = parseContent((JsonElement) obj);
        if (parseContent != null) {
            return parseContent;
        }
        if (!(str.length() > 0)) {
            rawContent = null;
        }
        if (rawContent != null) {
            return CollectionsKt.listOf(INSTANCE.textPart(rawContent));
        }
        return null;
    }

    public final List<MessagePart> parseQuery(String queryString) {
        Object obj;
        Intrinsics.checkNotNullParameter(queryString, "queryString");
        String str = queryString;
        String obj2 = StringsKt.trim(str).toString();
        if (!StringsKt.startsWith$default(obj2, "[", false, 2, (Object) null) && !StringsKt.startsWith$default(obj2, "{", false, 2, (Object) null)) {
            if (!(str.length() > 0)) {
                queryString = null;
            }
            if (queryString != null) {
                return CollectionsKt.listOf(INSTANCE.textPart(queryString));
            }
            return null;
        }
        try {
            Result.Companion companion = Result.Companion;
            MessagePartNormalizer messagePartNormalizer = this;
            obj = Result.constructor-impl(parseContent((JsonElement) getGson().fromJson(obj2, JsonElement.class)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        return (List) (Result.isFailure-impl(obj) ? null : obj);
    }

    public static /* synthetic */ String extractText$default(MessagePartNormalizer messagePartNormalizer, List list, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "";
        }
        return messagePartNormalizer.extractText(list, str);
    }

    public final String extractText(List<MessagePart> parts, String separator) {
        Intrinsics.checkNotNullParameter(separator, "separator");
        List<MessagePart> list = parts;
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : parts) {
            if (Intrinsics.areEqual(((MessagePart) obj).getType(), "text")) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String extractText = INSTANCE.extractText((MessagePart) it.next());
            if (extractText != null) {
                arrayList2.add(extractText);
            }
        }
        String joinToString$default = CollectionsKt.joinToString$default(arrayList2, separator, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        return joinToString$default.length() == 0 ? null : joinToString$default;
    }

    public final String extractText(MessagePart part) {
        Intrinsics.checkNotNullParameter(part, "part");
        return textFromData(part.getData());
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0034, code lost:
    
        if (r3 != null) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final MessagePart normalizePart(JsonElement element) {
        JsonObject jsonObject;
        JsonObject jsonObject2;
        if (!element.isJsonObject()) {
            return null;
        }
        JsonObject asJsonObject = element.getAsJsonObject();
        Intrinsics.checkNotNull(asJsonObject);
        String stringOrNull = getStringOrNull(asJsonObject, DBData.FIELD_TYPE);
        JsonElement jsonElement = asJsonObject.get("data");
        if (jsonElement != null) {
            if (!jsonElement.isJsonObject()) {
                jsonElement = null;
            }
            if (jsonElement != null) {
                JsonObject asJsonObject2 = jsonElement.getAsJsonObject();
                if (asJsonObject2 != null) {
                    jsonObject = asJsonObject2.deepCopy();
                }
            }
        }
        jsonObject = new JsonObject();
        Set entrySet = asJsonObject.entrySet();
        Intrinsics.checkNotNullExpressionValue(entrySet, "entrySet(...)");
        ArrayList<Map.Entry> arrayList = new ArrayList();
        for (Object obj : entrySet) {
            if (!Intrinsics.areEqual(((Map.Entry) obj).getKey(), DBData.FIELD_TYPE)) {
                arrayList.add(obj);
            }
        }
        for (Map.Entry entry : arrayList) {
            Intrinsics.checkNotNull(entry);
            jsonObject.add((String) entry.getKey(), ((JsonElement) entry.getValue()).deepCopy());
        }
        if (!(jsonObject.size() > 0)) {
            jsonObject = null;
        }
        if (Intrinsics.areEqual(stringOrNull, "text")) {
            String textFromData = textFromData(jsonObject);
            if (textFromData == null && (textFromData = getStringOrNull(asJsonObject, ReportConstant.COMMON_CONTENT)) == null && (textFromData = getStringOrNull(asJsonObject, "text_content")) == null) {
                textFromData = getStringOrNull(asJsonObject, "text");
            }
            if (jsonObject == null || (jsonObject2 = jsonObject.deepCopy()) == null) {
                jsonObject2 = new JsonObject();
            }
            String str = textFromData;
            if (!(str == null || str.length() == 0) && !jsonObject2.has(ReportConstant.COMMON_CONTENT)) {
                jsonObject2.addProperty(ReportConstant.COMMON_CONTENT, textFromData);
            }
            return new MessagePart(stringOrNull, jsonObject2.size() > 0 ? jsonObject2 : null);
        }
        String str2 = stringOrNull;
        if ((str2 == null || str2.length() == 0) && jsonObject == null) {
            return null;
        }
        return new MessagePart(stringOrNull, jsonObject);
    }

    private final MessagePart textPart(String text) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(ReportConstant.COMMON_CONTENT, text);
        return new MessagePart("text", jsonObject);
    }

    private final String textFromData(JsonObject data) {
        String stringOrNull;
        if (data != null && (stringOrNull = getStringOrNull(data, ReportConstant.COMMON_CONTENT)) != null) {
            return stringOrNull;
        }
        String stringOrNull2 = data != null ? getStringOrNull(data, "text_content") : null;
        if (stringOrNull2 != null) {
            return stringOrNull2;
        }
        if (data != null) {
            return getStringOrNull(data, "text");
        }
        return null;
    }

    private final String getStringOrNull(JsonObject jsonObject, String str) {
        JsonElement jsonElement = jsonObject.get(str);
        if (jsonElement == null) {
            return null;
        }
        if (!jsonElement.isJsonPrimitive()) {
            jsonElement = null;
        }
        if (jsonElement != null) {
            return jsonElement.getAsString();
        }
        return null;
    }
}
