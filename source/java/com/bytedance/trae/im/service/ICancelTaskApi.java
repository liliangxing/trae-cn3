package com.bytedance.trae.im.service;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.ExtraInfo;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.sdk.account.api.AccountErrorCode;
import com.bytedance.sdk.account.api.OauthTokenTriggerScene;
import com.bytedance.trae.im.service.ICancelTaskApi;
import com.bytedance.trae.network.DebugSettings;
import com.bytedance.trae.network.TraeHttpConnection;
import com.bytedance.trae.network.response.BizResponse;
import com.bytedance.trae.network.response.HttpDataResult;
import com.bytedance.trae.utils.logger.TraeLogUtil;
import com.bytedance.ttnet.http.RequestContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ICancelTaskApi.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u0000 \f2\u00020\u0001:\u0001\fJ\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007J&\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t2\b\b\u0001\u0010\u0005\u001a\u00020\u00062\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0001H'¨\u0006\r"}, d2 = {"Lcom/bytedance/trae/im/service/ICancelTaskApi;", "", "cancelTask", "Lcom/bytedance/trae/network/response/BizResponse;", "Lcom/bytedance/trae/im/service/CancelTaskResponse;", OauthTokenTriggerScene.REQUEST, "Lcom/bytedance/trae/im/service/CancelTaskRequest;", "(Lcom/bytedance/trae/im/service/CancelTaskRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelTaskRaw", "Lcom/bytedance/retrofit2/Call;", "", "extraInfo", "Companion", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface ICancelTaskApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @POST("api/solo_hub/v1/conversations/tasks/cancel")
    Object cancelTask(@Body CancelTaskRequest cancelTaskRequest, Continuation<? super BizResponse<CancelTaskResponse>> continuation);

    @POST("api/solo_hub/v1/conversations/tasks/cancel")
    Call<String> cancelTaskRaw(@Body CancelTaskRequest request, @ExtraInfo Object extraInfo);

    /* compiled from: ICancelTaskApi.kt */
    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0086@¢\u0006\u0002\u0010\u0011JK\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0013\"\u0004\b\u0000\u0010\u00142/\u0010\u0015\u001a+\b\u0001\u0012\u0004\u0012\u00020\u0017\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0014\u0018\u00010\u00190\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0016¢\u0006\u0002\b\u001aH\u0086@¢\u0006\u0002\u0010\u001bJ\u0019\u0010\u001c\u001a\u0004\u0018\u00010\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0002\u0010\u001eJ\u0014\u0010\u001f\u001a\u0004\u0018\u00010\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/bytedance/trae/im/service/ICancelTaskApi$Companion;", "", "<init>", "()V", "TAG", "", "DEFAULT_HEADERS", "", "getDEFAULT_HEADERS", "()Ljava/util/Map;", "SUCCESS_CODES", "", "", "cancelTaskRawCall", "Lcom/bytedance/trae/im/service/CancelTaskRawResult;", OauthTokenTriggerScene.REQUEST, "Lcom/bytedance/trae/im/service/CancelTaskRequest;", "(Lcom/bytedance/trae/im/service/CancelTaskRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "safeCall", "Lcom/bytedance/trae/network/response/HttpDataResult;", "T", "call", "Lkotlin/Function2;", "Lcom/bytedance/trae/im/service/ICancelTaskApi;", "Lkotlin/coroutines/Continuation;", "Lcom/bytedance/trae/network/response/BizResponse;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "parseBizCode", "bodyStr", "(Ljava/lang/String;)Ljava/lang/Long;", "parseBizMsg", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final Set<Long> SUCCESS_CODES = SetsKt.setOf(200L);
        private static final String TAG = "ICancelTaskApi";

        private Companion() {
        }

        private final Map<String, String> getDEFAULT_HEADERS() {
            return DebugSettings.buildDefaultHeaders$default(DebugSettings.INSTANCE, (Map) null, 1, (Object) null);
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x003b  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object cancelTaskRawCall(final CancelTaskRequest cancelTaskRequest, Continuation<? super CancelTaskRawResult> continuation) {
            ICancelTaskApi$Companion$cancelTaskRawCall$1 iCancelTaskApi$Companion$cancelTaskRawCall$1;
            int i;
            Companion companion;
            if (continuation instanceof ICancelTaskApi$Companion$cancelTaskRawCall$1) {
                iCancelTaskApi$Companion$cancelTaskRawCall$1 = (ICancelTaskApi$Companion$cancelTaskRawCall$1) continuation;
                if ((iCancelTaskApi$Companion$cancelTaskRawCall$1.label & Integer.MIN_VALUE) != 0) {
                    iCancelTaskApi$Companion$cancelTaskRawCall$1.label -= Integer.MIN_VALUE;
                    ICancelTaskApi$Companion$cancelTaskRawCall$1 iCancelTaskApi$Companion$cancelTaskRawCall$12 = iCancelTaskApi$Companion$cancelTaskRawCall$1;
                    Object obj = iCancelTaskApi$Companion$cancelTaskRawCall$12.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = iCancelTaskApi$Companion$cancelTaskRawCall$12.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        TraeLogUtil.INSTANCE.d(TAG, "POST tasks/cancel rawCall: convId=" + cancelTaskRequest.getConversationId() + ", taskId=" + cancelTaskRequest.getTaskId());
                        Map<String, String> default_headers = getDEFAULT_HEADERS();
                        Set<Long> set = SUCCESS_CODES;
                        Function2 function2 = new Function2() { // from class: com.bytedance.trae.im.service.ICancelTaskApi$Companion$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj2, Object obj3) {
                                Call cancelTaskRawCall$lambda$0;
                                cancelTaskRawCall$lambda$0 = ICancelTaskApi.Companion.cancelTaskRawCall$lambda$0(CancelTaskRequest.this, (ICancelTaskApi) obj2, (RequestContext) obj3);
                                return cancelTaskRawCall$lambda$0;
                            }
                        };
                        iCancelTaskApi$Companion$cancelTaskRawCall$12.L$0 = this;
                        iCancelTaskApi$Companion$cancelTaskRawCall$12.label = 1;
                        obj = TraeHttpConnection.rawBizCallWithBody$default(TraeHttpConnection.INSTANCE, "cancel_task", ICancelTaskApi.class, CancelTaskResponse.class, (String) null, (String) null, default_headers, true, set, false, function2, iCancelTaskApi$Companion$cancelTaskRawCall$12, 280, (Object) null);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        companion = this;
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        companion = (Companion) iCancelTaskApi$Companion$cancelTaskRawCall$12.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    TraeHttpConnection.RawBizCallResult rawBizCallResult = (TraeHttpConnection.RawBizCallResult) obj;
                    return new CancelTaskRawResult(rawBizCallResult.getResult(), companion.parseBizCode(rawBizCallResult.getBody()), companion.parseBizMsg(rawBizCallResult.getBody()));
                }
            }
            iCancelTaskApi$Companion$cancelTaskRawCall$1 = new ICancelTaskApi$Companion$cancelTaskRawCall$1(this, continuation);
            ICancelTaskApi$Companion$cancelTaskRawCall$1 iCancelTaskApi$Companion$cancelTaskRawCall$122 = iCancelTaskApi$Companion$cancelTaskRawCall$1;
            Object obj2 = iCancelTaskApi$Companion$cancelTaskRawCall$122.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i = iCancelTaskApi$Companion$cancelTaskRawCall$122.label;
            if (i != 0) {
            }
            TraeHttpConnection.RawBizCallResult rawBizCallResult2 = (TraeHttpConnection.RawBizCallResult) obj2;
            return new CancelTaskRawResult(rawBizCallResult2.getResult(), companion.parseBizCode(rawBizCallResult2.getBody()), companion.parseBizMsg(rawBizCallResult2.getBody()));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Call cancelTaskRawCall$lambda$0(CancelTaskRequest cancelTaskRequest, ICancelTaskApi iCancelTaskApi, RequestContext requestContext) {
            Intrinsics.checkNotNullParameter(iCancelTaskApi, "$this$rawBizCallWithBody");
            Intrinsics.checkNotNullParameter(requestContext, "requestContext");
            return iCancelTaskApi.cancelTaskRaw(cancelTaskRequest, requestContext);
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x005a A[Catch: all -> 0x002a, CancellationException -> 0x002d, TryCatch #2 {CancellationException -> 0x002d, all -> 0x002a, blocks: (B:10:0x0026, B:11:0x0056, B:13:0x005a, B:16:0x0075, B:21:0x003a), top: B:7:0x0022 }] */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0075 A[Catch: all -> 0x002a, CancellationException -> 0x002d, TRY_LEAVE, TryCatch #2 {CancellationException -> 0x002d, all -> 0x002a, blocks: (B:10:0x0026, B:11:0x0056, B:13:0x005a, B:16:0x0075, B:21:0x003a), top: B:7:0x0022 }] */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final <T> Object safeCall(Function2<? super ICancelTaskApi, ? super Continuation<? super BizResponse<T>>, ? extends Object> function2, Continuation<? super HttpDataResult<? extends T>> continuation) {
            ICancelTaskApi$Companion$safeCall$1 iCancelTaskApi$Companion$safeCall$1;
            int i;
            BizResponse bizResponse;
            try {
                if (continuation instanceof ICancelTaskApi$Companion$safeCall$1) {
                    iCancelTaskApi$Companion$safeCall$1 = (ICancelTaskApi$Companion$safeCall$1) continuation;
                    if ((iCancelTaskApi$Companion$safeCall$1.label & Integer.MIN_VALUE) != 0) {
                        iCancelTaskApi$Companion$safeCall$1.label -= Integer.MIN_VALUE;
                        Object obj = iCancelTaskApi$Companion$safeCall$1.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        i = iCancelTaskApi$Companion$safeCall$1.label;
                        if (i != 0) {
                            ResultKt.throwOnFailure(obj);
                            ICancelTaskApi iCancelTaskApi = (ICancelTaskApi) TraeHttpConnection.createService$default(TraeHttpConnection.INSTANCE, "cancel_task", ICancelTaskApi.class, (Converter.Factory) null, (String) null, (Map) null, false, 60, (Object) null);
                            iCancelTaskApi$Companion$safeCall$1.label = 1;
                            obj = function2.invoke(iCancelTaskApi, iCancelTaskApi$Companion$safeCall$1);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                        }
                        bizResponse = (BizResponse) obj;
                        if (bizResponse != null) {
                            return new HttpDataResult.Error(AccountErrorCode.CommonError.COMMON_ERROR_REQUEST_API, "BizResponse is null", new Exception("BizResponse is null"), (String) null, 8, (DefaultConstructorMarker) null);
                        }
                        return new HttpDataResult.Success(bizResponse, (Throwable) null);
                    }
                }
                if (i != 0) {
                }
                bizResponse = (BizResponse) obj;
                if (bizResponse != null) {
                }
            } catch (CancellationException e) {
                return new HttpDataResult.Error(-1001, "", e, (String) null, 8, (DefaultConstructorMarker) null);
            } catch (Throwable th) {
                return new HttpDataResult.Error(-1000, "", th, (String) null, 8, (DefaultConstructorMarker) null);
            }
            iCancelTaskApi$Companion$safeCall$1 = new ICancelTaskApi$Companion$safeCall$1(this, continuation);
            Object obj2 = iCancelTaskApi$Companion$safeCall$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i = iCancelTaskApi$Companion$safeCall$1.label;
        }

        private final Long parseBizCode(String bodyStr) {
            String str = bodyStr;
            if (str == null || str.length() == 0) {
                return null;
            }
            try {
                JsonElement jsonElement = JsonParser.parseString(bodyStr).getAsJsonObject().get("code");
                if (jsonElement != null) {
                    return Long.valueOf(jsonElement.getAsLong());
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }

        private final String parseBizMsg(String bodyStr) {
            String asString;
            String str = bodyStr;
            if (str == null || str.length() == 0) {
                return null;
            }
            try {
                JsonObject asJsonObject = JsonParser.parseString(bodyStr).getAsJsonObject();
                JsonElement jsonElement = asJsonObject.get("msg");
                if (jsonElement != null && (asString = jsonElement.getAsString()) != null) {
                    return asString;
                }
                JsonElement jsonElement2 = asJsonObject.get("message");
                if (jsonElement2 != null) {
                    return jsonElement2.getAsString();
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
    }
}
