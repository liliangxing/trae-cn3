package com.bytedance.trae.im.service;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.ExtraInfo;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.sdk.account.api.OauthTokenTriggerScene;
import com.bytedance.trae.im.service.IRevertCheckTaskApi;
import com.bytedance.trae.network.DebugSettings;
import com.bytedance.trae.network.TraeHttpConnection;
import com.bytedance.trae.network.response.BizResponse;
import com.bytedance.trae.network.response.HttpDataResult;
import com.bytedance.ttnet.http.RequestContext;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IRevertCheckTaskApi.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \b2\u00020\u0001:\u0001\bJ&\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0001H'¨\u0006\t"}, d2 = {"Lcom/bytedance/trae/im/service/IRevertCheckTaskApi;", "", "revertCheckTaskRaw", "Lcom/bytedance/retrofit2/Call;", "", OauthTokenTriggerScene.REQUEST, "Lcom/bytedance/trae/im/service/RevertCheckTaskRequest;", "extraInfo", "Companion", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface IRevertCheckTaskApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @POST("api/solo_hub/v1/conversations/tasks/revert_check")
    Call<String> revertCheckTaskRaw(@Body RevertCheckTaskRequest request, @ExtraInfo Object extraInfo);

    /* compiled from: IRevertCheckTaskApi.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0086@¢\u0006\u0002\u0010\u0011R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/trae/im/service/IRevertCheckTaskApi$Companion;", "", "<init>", "()V", "SUCCESS_CODES", "", "", "DEFAULT_HEADERS", "", "", "getDEFAULT_HEADERS", "()Ljava/util/Map;", "revertCheckTaskRawCall", "Lcom/bytedance/trae/network/response/HttpDataResult;", "Lcom/bytedance/trae/im/service/RevertCheckTaskResponse;", OauthTokenTriggerScene.REQUEST, "Lcom/bytedance/trae/im/service/RevertCheckTaskRequest;", "(Lcom/bytedance/trae/im/service/RevertCheckTaskRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final Set<Long> SUCCESS_CODES = BizResponse.Companion.getDEFAULT_SUCCESS_CODES();

        private Companion() {
        }

        private final Map<String, String> getDEFAULT_HEADERS() {
            return DebugSettings.buildDefaultHeaders$default(DebugSettings.INSTANCE, (Map) null, 1, (Object) null);
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0039  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object revertCheckTaskRawCall(final RevertCheckTaskRequest revertCheckTaskRequest, Continuation<? super HttpDataResult<RevertCheckTaskResponse>> continuation) {
            IRevertCheckTaskApi$Companion$revertCheckTaskRawCall$1 iRevertCheckTaskApi$Companion$revertCheckTaskRawCall$1;
            int i;
            HttpDataResult httpResultPreservingBizError;
            if (continuation instanceof IRevertCheckTaskApi$Companion$revertCheckTaskRawCall$1) {
                iRevertCheckTaskApi$Companion$revertCheckTaskRawCall$1 = (IRevertCheckTaskApi$Companion$revertCheckTaskRawCall$1) continuation;
                if ((iRevertCheckTaskApi$Companion$revertCheckTaskRawCall$1.label & Integer.MIN_VALUE) != 0) {
                    iRevertCheckTaskApi$Companion$revertCheckTaskRawCall$1.label -= Integer.MIN_VALUE;
                    IRevertCheckTaskApi$Companion$revertCheckTaskRawCall$1 iRevertCheckTaskApi$Companion$revertCheckTaskRawCall$12 = iRevertCheckTaskApi$Companion$revertCheckTaskRawCall$1;
                    Object obj = iRevertCheckTaskApi$Companion$revertCheckTaskRawCall$12.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = iRevertCheckTaskApi$Companion$revertCheckTaskRawCall$12.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        Map<String, String> default_headers = getDEFAULT_HEADERS();
                        Set<Long> set = SUCCESS_CODES;
                        Function2 function2 = new Function2() { // from class: com.bytedance.trae.im.service.IRevertCheckTaskApi$Companion$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj2, Object obj3) {
                                Call revertCheckTaskRawCall$lambda$0;
                                revertCheckTaskRawCall$lambda$0 = IRevertCheckTaskApi.Companion.revertCheckTaskRawCall$lambda$0(RevertCheckTaskRequest.this, (IRevertCheckTaskApi) obj2, (RequestContext) obj3);
                                return revertCheckTaskRawCall$lambda$0;
                            }
                        };
                        iRevertCheckTaskApi$Companion$revertCheckTaskRawCall$12.label = 1;
                        obj = TraeHttpConnection.rawBizCallWithBody$default(TraeHttpConnection.INSTANCE, "revert_check_task", IRevertCheckTaskApi.class, RevertCheckTaskResponse.class, (String) null, (String) null, default_headers, true, set, false, function2, iRevertCheckTaskApi$Companion$revertCheckTaskRawCall$12, 280, (Object) null);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    httpResultPreservingBizError = IRevertCheckTaskApiKt.toHttpResultPreservingBizError((TraeHttpConnection.RawBizCallResult) obj);
                    return httpResultPreservingBizError;
                }
            }
            iRevertCheckTaskApi$Companion$revertCheckTaskRawCall$1 = new IRevertCheckTaskApi$Companion$revertCheckTaskRawCall$1(this, continuation);
            IRevertCheckTaskApi$Companion$revertCheckTaskRawCall$1 iRevertCheckTaskApi$Companion$revertCheckTaskRawCall$122 = iRevertCheckTaskApi$Companion$revertCheckTaskRawCall$1;
            Object obj2 = iRevertCheckTaskApi$Companion$revertCheckTaskRawCall$122.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i = iRevertCheckTaskApi$Companion$revertCheckTaskRawCall$122.label;
            if (i != 0) {
            }
            httpResultPreservingBizError = IRevertCheckTaskApiKt.toHttpResultPreservingBizError((TraeHttpConnection.RawBizCallResult) obj2);
            return httpResultPreservingBizError;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Call revertCheckTaskRawCall$lambda$0(RevertCheckTaskRequest revertCheckTaskRequest, IRevertCheckTaskApi iRevertCheckTaskApi, RequestContext requestContext) {
            Intrinsics.checkNotNullParameter(iRevertCheckTaskApi, "$this$rawBizCallWithBody");
            Intrinsics.checkNotNullParameter(requestContext, "requestContext");
            return iRevertCheckTaskApi.revertCheckTaskRaw(revertCheckTaskRequest, requestContext);
        }
    }
}
