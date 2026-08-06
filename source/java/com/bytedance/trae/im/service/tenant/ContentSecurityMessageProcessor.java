package com.bytedance.trae.im.service.tenant;

import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.bytedance.trae.im.model.MessagePart;
import com.bytedance.trae.im.service.tenant.ContentSecurityFilterResult;
import com.bytedance.trae.im.service.tenant.ContentSecurityMessageProcessResult;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContentSecurityMessageProcessor.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fJ\u000e\u0010\u0011\u001a\u0004\u0018\u00010\r*\u00020\u0012H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessor;", "", "<init>", "()V", "gson", "Lcom/google/gson/Gson;", "queryPartListType", "Ljava/lang/reflect/Type;", "kotlin.jvm.PlatformType", "Ljava/lang/reflect/Type;", "processQuery", "Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessResult;", "query", "", "rules", "", "Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;", "textContent", "Lcom/bytedance/trae/im/model/MessagePart;", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ContentSecurityMessageProcessor {
    public static final ContentSecurityMessageProcessor INSTANCE = new ContentSecurityMessageProcessor();
    private static final Gson gson = new Gson();
    private static final Type queryPartListType = new TypeToken<List<? extends MessagePart>>() { // from class: com.bytedance.trae.im.service.tenant.ContentSecurityMessageProcessor$queryPartListType$1
    }.getType();

    private ContentSecurityMessageProcessor() {
    }

    public final ContentSecurityMessageProcessResult processQuery(String query, List<ContentSecurityRule> rules) {
        Object obj;
        Intrinsics.checkNotNullParameter(query, "query");
        Intrinsics.checkNotNullParameter(rules, "rules");
        if (rules.isEmpty()) {
            return ContentSecurityMessageProcessResult.Passed.INSTANCE;
        }
        try {
            Result.Companion companion = Result.Companion;
            ContentSecurityMessageProcessor contentSecurityMessageProcessor = this;
            obj = Result.constructor-impl((List) gson.fromJson(query, queryPartListType));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        List list = (List) obj;
        if (list == null) {
            return ContentSecurityMessageProcessResult.Passed.INSTANCE;
        }
        List list2 = list;
        ArrayList arrayList = new ArrayList();
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            String textContent = INSTANCE.textContent((MessagePart) it.next());
            if (textContent != null) {
                arrayList.add(textContent);
            }
        }
        String joinToString$default = CollectionsKt.joinToString$default(arrayList, "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        if (joinToString$default.length() == 0) {
            return ContentSecurityMessageProcessResult.Passed.INSTANCE;
        }
        ContentSecurityFilterResult filter$default = ContentSecurityFilter.filter$default(ContentSecurityFilter.INSTANCE, joinToString$default, rules, 0, 0, 12, null);
        if (Intrinsics.areEqual(filter$default, ContentSecurityFilterResult.Passed.INSTANCE)) {
            return ContentSecurityMessageProcessResult.Passed.INSTANCE;
        }
        if (filter$default instanceof ContentSecurityFilterResult.Blocked) {
            return new ContentSecurityMessageProcessResult.Blocked((ContentSecurityFilterResult.Blocked) filter$default);
        }
        if (filter$default instanceof ContentSecurityFilterResult.Error) {
            return new ContentSecurityMessageProcessResult.Error((ContentSecurityFilterResult.Error) filter$default);
        }
        if (!(filter$default instanceof ContentSecurityFilterResult.Desensitized)) {
            throw new NoWhenBranchMatchedException();
        }
        List createListBuilder = CollectionsKt.createListBuilder();
        JsonObject jsonObject = new JsonObject();
        ContentSecurityFilterResult.Desensitized desensitized = (ContentSecurityFilterResult.Desensitized) filter$default;
        jsonObject.addProperty(ReportConstant.COMMON_CONTENT, desensitized.getProcessedContent());
        Unit unit = Unit.INSTANCE;
        createListBuilder.add(new MessagePart("text", jsonObject));
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : list2) {
            if (!Intrinsics.areEqual(((MessagePart) obj2).getType(), "text")) {
                arrayList2.add(obj2);
            }
        }
        createListBuilder.addAll(arrayList2);
        String json = gson.toJson(CollectionsKt.build(createListBuilder));
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        return new ContentSecurityMessageProcessResult.Desensitized(json, desensitized.getProcessedContent());
    }

    private final String textContent(MessagePart messagePart) {
        JsonObject data;
        JsonElement jsonElement;
        if (!Intrinsics.areEqual(messagePart.getType(), "text") || (data = messagePart.getData()) == null || (jsonElement = data.get(ReportConstant.COMMON_CONTENT)) == null) {
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
