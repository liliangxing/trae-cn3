package com.bytedance.trae.conversation.brainstorm;

import com.bytedance.sdk.xbridge.cn.media.utils.FConstants;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.bytedance.trae.conversation.brainstorm.model.BrainstormMessage;
import com.bytedance.trae.conversation.brainstorm.model.BrainstormSummary;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: BrainstormSummaryRepository.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0000\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0002\u0010\u0003JE\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072#\u0010\n\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000bH\u0082@¢\u0006\u0002\u0010\u0010J\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0002J&\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00072\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/BrainstormSummaryRepository;", "", "<init>", "()V", "gson", "Lcom/google/gson/Gson;", "subscribeSseAndCollect", "", "sessionId", "messageId", "onChunk", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "accumulated", "", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "extractTextFromEvent", "eventType", "data", "buildSummary", "Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary;", "fullText", "messages", "", "Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;", "durationMs", "", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class BrainstormSummaryRepository {
    public static final String AGENT_TYPE_SELECT_MODEL_NAME = "summary_mobile";
    public static final String AGENT_TYPE_VOICE_SUMMARY = "voice_summary";
    private static final String TAG = "BrainstormSummaryRepo";
    private final Gson gson = new Gson();

    /* JADX INFO: Access modifiers changed from: private */
    public final Object subscribeSseAndCollect(String str, String str2, Function1<? super String, Unit> function1, Continuation<? super String> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new BrainstormSummaryRepository$subscribeSseAndCollect$2(str, str2, this, function1, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String extractTextFromEvent(String eventType, String data) {
        JsonElement jsonElement;
        String asString;
        String asString2;
        JsonElement jsonElement2;
        JsonElement jsonElement3;
        String asString3;
        String str = null;
        if (Intrinsics.areEqual(eventType, "done") || Intrinsics.areEqual(eventType, "error")) {
            return null;
        }
        try {
            JsonObject jsonObject = (JsonObject) this.gson.fromJson(data, JsonObject.class);
            if (jsonObject != null && (jsonElement3 = jsonObject.get(ReportConstant.COMMON_CONTENT)) != null && (asString3 = jsonElement3.getAsString()) != null) {
                return asString3;
            }
            String asString4 = (jsonObject == null || (jsonElement2 = jsonObject.get("text")) == null) ? null : jsonElement2.getAsString();
            if (asString4 != null) {
                return asString4;
            }
            if (jsonObject != null && (jsonElement = jsonObject.get("delta")) != null) {
                if (jsonElement.isJsonObject()) {
                    JsonElement jsonElement4 = jsonElement.getAsJsonObject().get(ReportConstant.COMMON_CONTENT);
                    if (jsonElement4 != null && (asString2 = jsonElement4.getAsString()) != null) {
                        str = asString2;
                    }
                    JsonElement jsonElement5 = jsonElement.getAsJsonObject().get("text");
                    if (jsonElement5 != null) {
                        asString = jsonElement5.getAsString();
                    }
                } else {
                    asString = jsonElement.getAsString();
                }
                str = asString;
            }
            return str == null ? data : str;
        } catch (Throwable unused) {
            return data;
        }
    }

    private final BrainstormSummary buildSummary(String fullText, List<BrainstormMessage> messages, long durationMs) {
        long j = 60000;
        int i = (int) (durationMs / j);
        String sb = (i > 0 ? new StringBuilder().append(i).append("m ") : new StringBuilder()).append((int) ((durationMs % j) / 1000)).append('s').toString();
        List lines = StringsKt.lines(fullText);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(lines, 10));
        Iterator it = lines.iterator();
        while (it.hasNext()) {
            arrayList.add(StringsKt.trim((String) it.next()).toString());
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((String) obj).length() > 0) {
                arrayList2.add(obj);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        Iterator it2 = arrayList2.iterator();
        String str = "Brainstorm Summary";
        loop2: while (true) {
            Object obj2 = "key";
            while (it2.hasNext()) {
                String str2 = (String) it2.next();
                String lowerCase = str2.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                String str3 = lowerCase;
                Iterator it3 = it2;
                if (StringsKt.contains$default(str3, "action", false, 2, (Object) null) && StringsKt.contains$default(str3, "item", false, 2, (Object) null)) {
                    it2 = it3;
                    obj2 = "action";
                } else if (StringsKt.contains$default(str3, "key", false, 2, (Object) null) && (StringsKt.contains$default(str3, "point", false, 2, (Object) null) || StringsKt.contains$default(str3, "insight", false, 2, (Object) null) || StringsKt.contains$default(str3, "finding", false, 2, (Object) null))) {
                    it2 = it3;
                } else {
                    if (StringsKt.startsWith$default(lowerCase, "# ", false, 2, (Object) null) || StringsKt.startsWith$default(lowerCase, "## ", false, 2, (Object) null)) {
                        String obj3 = StringsKt.trim(StringsKt.trimStart(str2, new char[]{'#'})).toString();
                        if (Intrinsics.areEqual(str, "Brainstorm Summary")) {
                            if (obj3.length() > 0) {
                                str = obj3;
                            }
                        }
                    } else {
                        String obj4 = StringsKt.trim(new Regex("^☐\\s*").replace(new Regex("^\\d+[.):]\\s*").replace(StringsKt.removePrefix(StringsKt.removePrefix(str2, "-"), "*"), ""), "")).toString();
                        if (!(obj4.length() == 0)) {
                            if (Intrinsics.areEqual(obj2, "action")) {
                                arrayList4.add(obj4);
                            } else {
                                arrayList3.add(obj4);
                            }
                        }
                    }
                    it2 = it3;
                }
            }
            break loop2;
        }
        if (arrayList3.isEmpty()) {
            arrayList3.add(StringsKt.take(fullText, FConstants.URI_FAIL_CODE));
        }
        return new BrainstormSummary(str, arrayList3, arrayList4, sb, messages.size());
    }
}
