package com.bytedance.trae.im.service;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.ExtraInfo;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.sdk.account.api.OauthTokenTriggerScene;
import com.bytedance.trae.im.service.ICreateAgentTask;
import com.bytedance.trae.im.service.tenant.TenantUserConfigRepository;
import com.bytedance.trae.network.DebugSettings;
import com.bytedance.trae.network.TraeHttpConnection;
import com.bytedance.trae.network.response.BizResponse;
import com.bytedance.trae.network.response.HttpDataResult;
import com.bytedance.trae.utils.logger.TraeLogUtil;
import com.bytedance.ttnet.http.RequestContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* compiled from: ICreateAgentTask.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u0000 \f2\u00020\u0001:\u0001\fJ\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007J&\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t2\b\b\u0001\u0010\u0005\u001a\u00020\u00062\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0001H'¨\u0006\r"}, d2 = {"Lcom/bytedance/trae/im/service/ICreateAgentTask;", "", "createAgentTask", "Lcom/bytedance/trae/network/response/BizResponse;", "Lcom/bytedance/trae/im/service/CreateTaskResponse;", OauthTokenTriggerScene.REQUEST, "Lcom/bytedance/trae/im/service/CreateTaskRequest;", "(Lcom/bytedance/trae/im/service/CreateTaskRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createAgentTaskRaw", "Lcom/bytedance/retrofit2/Call;", "", "extraInfo", "Companion", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface ICreateAgentTask {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @POST("api/solo_hub/v1/conversations/tasks/create")
    Object createAgentTask(@Body CreateTaskRequest createTaskRequest, Continuation<? super BizResponse<CreateTaskResponse>> continuation);

    @POST("api/solo_hub/v1/conversations/tasks/create")
    Call<String> createAgentTaskRaw(@Body CreateTaskRequest request, @ExtraInfo Object extraInfo);

    /* compiled from: ICreateAgentTask.kt */
    @Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JK\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\r\"\u0004\b\u0000\u0010\u000e2/\u0010\u000f\u001a+\b\u0001\u0012\u0004\u0012\u00020\u0011\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u000e\u0018\u00010\u00130\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0010¢\u0006\u0002\b\u0014H\u0086@¢\u0006\u0002\u0010\u0015J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0086@¢\u0006\u0002\u0010\u001bJ\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010\u0006H\u0002J\u0014\u0010 \u001a\u0004\u0018\u00010\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010\u001e\u001a\u00020\u0006H\u0002R \u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/bytedance/trae/im/service/ICreateAgentTask$Companion;", "", "<init>", "()V", "DEFAULT_HEADERS", "", "", "getDEFAULT_HEADERS", "()Ljava/util/Map;", "SUCCESS_CODES", "", "", "safeCall", "Lcom/bytedance/trae/network/response/HttpDataResult;", "T", "call", "Lkotlin/Function2;", "Lcom/bytedance/trae/im/service/ICreateAgentTask;", "Lkotlin/coroutines/Continuation;", "Lcom/bytedance/trae/network/response/BizResponse;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "TAG", "createAgentTaskRawCall", "Lcom/bytedance/trae/im/service/CreateTaskRawResult;", OauthTokenTriggerScene.REQUEST, "Lcom/bytedance/trae/im/service/CreateTaskRequest;", "(Lcom/bytedance/trae/im/service/CreateTaskRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "parseErrorDetail", "Lcom/bytedance/trae/im/service/CreateTaskErrorDetail;", "bodyStr", "message", "parseErrorDetailFromMessage", "parseErrorData", "Lcom/google/gson/JsonObject;", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final Set<Long> SUCCESS_CODES = SetsKt.setOf(200L);
        private static final String TAG = "ICreateAgentTask";

        private Companion() {
        }

        private final Map<String, String> getDEFAULT_HEADERS() {
            return DebugSettings.buildDefaultHeaders$default(DebugSettings.INSTANCE, (Map) null, 1, (Object) null);
        }

        public final <T> Object safeCall(Function2<? super ICreateAgentTask, ? super Continuation<? super BizResponse<T>>, ? extends Object> function2, Continuation<? super HttpDataResult<? extends T>> continuation) {
            return TraeHttpConnection.safeCall$default(TraeHttpConnection.INSTANCE, "base", ICreateAgentTask.class, getDEFAULT_HEADERS(), function2, (String) null, (Set) null, continuation, 48, (Object) null);
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x00d9  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x00fd  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x00dc  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0043  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x002d  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object createAgentTaskRawCall(final CreateTaskRequest createTaskRequest, Continuation<? super CreateTaskRawResult> continuation) {
            ICreateAgentTask$Companion$createAgentTaskRawCall$1 iCreateAgentTask$Companion$createAgentTaskRawCall$1;
            int i;
            String str;
            Object obj;
            Companion companion;
            JsonObject jsonObject;
            String body;
            CreateTaskErrorDetail parseErrorDetail;
            if (continuation instanceof ICreateAgentTask$Companion$createAgentTaskRawCall$1) {
                iCreateAgentTask$Companion$createAgentTaskRawCall$1 = (ICreateAgentTask$Companion$createAgentTaskRawCall$1) continuation;
                if ((iCreateAgentTask$Companion$createAgentTaskRawCall$1.label & Integer.MIN_VALUE) != 0) {
                    iCreateAgentTask$Companion$createAgentTaskRawCall$1.label -= Integer.MIN_VALUE;
                    ICreateAgentTask$Companion$createAgentTaskRawCall$1 iCreateAgentTask$Companion$createAgentTaskRawCall$12 = iCreateAgentTask$Companion$createAgentTaskRawCall$1;
                    Object obj2 = iCreateAgentTask$Companion$createAgentTaskRawCall$12.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = iCreateAgentTask$Companion$createAgentTaskRawCall$12.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj2);
                        TenantUserConfigRepository.INSTANCE.triggerRefreshIfNeeded("create_task");
                        TraeLogUtil.INSTANCE.d(TAG, "POST /api/solo_hub/v1/conversations/tasks/create rawCall: conversationId=" + createTaskRequest.getConversationId() + ", cliId=" + createTaskRequest.getCliId() + ", cliType=" + createTaskRequest.getCliType());
                        TraeLogUtil.INSTANCE.d(TAG, "POST /api/solo_hub/v1/conversations/tasks/create requestBody=" + TraeHttpConnection.INSTANCE.getHttpGson().toJson(createTaskRequest));
                        Map<String, String> default_headers = getDEFAULT_HEADERS();
                        Set<Long> set = SUCCESS_CODES;
                        Function2 function2 = new Function2() { // from class: com.bytedance.trae.im.service.ICreateAgentTask$Companion$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj3, Object obj4) {
                                Call createAgentTaskRawCall$lambda$0;
                                createAgentTaskRawCall$lambda$0 = ICreateAgentTask.Companion.createAgentTaskRawCall$lambda$0(CreateTaskRequest.this, (ICreateAgentTask) obj3, (RequestContext) obj4);
                                return createAgentTaskRawCall$lambda$0;
                            }
                        };
                        iCreateAgentTask$Companion$createAgentTaskRawCall$12.L$0 = this;
                        iCreateAgentTask$Companion$createAgentTaskRawCall$12.label = 1;
                        str = TAG;
                        Object rawBizCallWithBody$default = TraeHttpConnection.rawBizCallWithBody$default(TraeHttpConnection.INSTANCE, "base", ICreateAgentTask.class, CreateTaskResponse.class, (String) null, (String) null, default_headers, true, set, false, function2, iCreateAgentTask$Companion$createAgentTaskRawCall$12, 280, (Object) null);
                        if (rawBizCallWithBody$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj = rawBizCallWithBody$default;
                        companion = this;
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        Companion companion2 = (Companion) iCreateAgentTask$Companion$createAgentTaskRawCall$12.L$0;
                        ResultKt.throwOnFailure(obj2);
                        obj = obj2;
                        companion = companion2;
                        str = TAG;
                    }
                    TraeHttpConnection.RawBizCallResult rawBizCallResult = (TraeHttpConnection.RawBizCallResult) obj;
                    HttpDataResult.Success result = rawBizCallResult.getResult();
                    jsonObject = null;
                    HttpDataResult.Success success = !(result instanceof HttpDataResult.Success) ? result : null;
                    body = rawBizCallResult.getBody();
                    parseErrorDetail = (body != null || success == null) ? null : companion.parseErrorDetail(body, success.getBizResp().getMessage());
                    if (body != null && success != null) {
                        jsonObject = companion.parseErrorData(body);
                    }
                    if (parseErrorDetail != null) {
                        TraeLogUtil.INSTANCE.d(str, "rawCall: errorDetail blockReason=" + parseErrorDetail.getBlockReason() + ", limit=" + parseErrorDetail.getLimit() + ", running=" + parseErrorDetail.getRunning());
                    }
                    return new CreateTaskRawResult(rawBizCallResult.getResult(), parseErrorDetail, jsonObject);
                }
            }
            iCreateAgentTask$Companion$createAgentTaskRawCall$1 = new ICreateAgentTask$Companion$createAgentTaskRawCall$1(this, continuation);
            ICreateAgentTask$Companion$createAgentTaskRawCall$1 iCreateAgentTask$Companion$createAgentTaskRawCall$122 = iCreateAgentTask$Companion$createAgentTaskRawCall$1;
            Object obj22 = iCreateAgentTask$Companion$createAgentTaskRawCall$122.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i = iCreateAgentTask$Companion$createAgentTaskRawCall$122.label;
            if (i != 0) {
            }
            TraeHttpConnection.RawBizCallResult rawBizCallResult2 = (TraeHttpConnection.RawBizCallResult) obj;
            HttpDataResult.Success result2 = rawBizCallResult2.getResult();
            jsonObject = null;
            if (!(result2 instanceof HttpDataResult.Success)) {
            }
            body = rawBizCallResult2.getBody();
            if (body != null) {
            }
            if (body != null) {
                jsonObject = companion.parseErrorData(body);
            }
            if (parseErrorDetail != null) {
            }
            return new CreateTaskRawResult(rawBizCallResult2.getResult(), parseErrorDetail, jsonObject);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Call createAgentTaskRawCall$lambda$0(CreateTaskRequest createTaskRequest, ICreateAgentTask iCreateAgentTask, RequestContext requestContext) {
            Intrinsics.checkNotNullParameter(iCreateAgentTask, "$this$rawBizCallWithBody");
            Intrinsics.checkNotNullParameter(requestContext, "requestContext");
            return iCreateAgentTask.createAgentTaskRaw(createTaskRequest, requestContext);
        }

        private final CreateTaskErrorDetail parseErrorDetail(String bodyStr, String message) {
            try {
                JsonObject asJsonObject = JsonParser.parseString(bodyStr).getAsJsonObject();
                if (asJsonObject.has("error")) {
                    JsonObject asJsonObject2 = asJsonObject.getAsJsonObject("error");
                    JsonElement jsonElement = asJsonObject2.get("block_reason");
                    int asInt = jsonElement != null ? jsonElement.getAsInt() : 0;
                    JsonElement jsonElement2 = asJsonObject2.get("limit");
                    int asInt2 = jsonElement2 != null ? jsonElement2.getAsInt() : 0;
                    JsonElement jsonElement3 = asJsonObject2.get("running");
                    return new CreateTaskErrorDetail(asInt, asInt2, jsonElement3 != null ? jsonElement3.getAsInt() : 0);
                }
                return parseErrorDetailFromMessage(message);
            } catch (Exception unused) {
                return parseErrorDetailFromMessage(message);
            }
        }

        private final CreateTaskErrorDetail parseErrorDetailFromMessage(String message) {
            List groupValues;
            String str;
            Integer intOrNull;
            List groupValues2;
            String str2;
            Integer intOrNull2;
            List groupValues3;
            String str3;
            String str4 = message;
            int i = 0;
            if (str4 == null || str4.length() == 0) {
                return null;
            }
            MatchResult find$default = Regex.find$default(new Regex("block_reason=(\\d+)"), str4, 0, 2, (Object) null);
            Integer intOrNull3 = (find$default == null || (groupValues3 = find$default.getGroupValues()) == null || (str3 = (String) CollectionsKt.getOrNull(groupValues3, 1)) == null) ? null : StringsKt.toIntOrNull(str3);
            MatchResult find$default2 = Regex.find$default(new Regex("limit=(\\d+)"), str4, 0, 2, (Object) null);
            int intValue = (find$default2 == null || (groupValues2 = find$default2.getGroupValues()) == null || (str2 = (String) CollectionsKt.getOrNull(groupValues2, 1)) == null || (intOrNull2 = StringsKt.toIntOrNull(str2)) == null) ? 0 : intOrNull2.intValue();
            MatchResult find$default3 = Regex.find$default(new Regex("running=(\\d+)"), str4, 0, 2, (Object) null);
            if (find$default3 != null && (groupValues = find$default3.getGroupValues()) != null && (str = (String) CollectionsKt.getOrNull(groupValues, 1)) != null && (intOrNull = StringsKt.toIntOrNull(str)) != null) {
                i = intOrNull.intValue();
            }
            if (intOrNull3 != null) {
                return new CreateTaskErrorDetail(intOrNull3.intValue(), intValue, i);
            }
            return null;
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x004b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final JsonObject parseErrorData(String bodyStr) {
            Object obj;
            JsonElement parseString;
            JsonObject jsonObject;
            JsonObject asJsonObject;
            JsonElement jsonElement;
            try {
                Result.Companion companion = Result.Companion;
                Companion companion2 = this;
                parseString = JsonParser.parseString(bodyStr);
            } catch (Throwable th) {
                Result.Companion companion3 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            if (parseString != null) {
                if (!parseString.isJsonObject()) {
                    parseString = null;
                }
                if (parseString != null && (asJsonObject = parseString.getAsJsonObject()) != null && (jsonElement = asJsonObject.get("data")) != null) {
                    if (!jsonElement.isJsonObject()) {
                        jsonElement = null;
                    }
                    if (jsonElement != null) {
                        jsonObject = jsonElement.getAsJsonObject();
                        obj = Result.constructor-impl(jsonObject);
                        return (JsonObject) (Result.isFailure-impl(obj) ? null : obj);
                    }
                }
            }
            jsonObject = null;
            obj = Result.constructor-impl(jsonObject);
            return (JsonObject) (Result.isFailure-impl(obj) ? null : obj);
        }
    }
}
