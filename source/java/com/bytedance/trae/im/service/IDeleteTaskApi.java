package com.bytedance.trae.im.service;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.ExtraInfo;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.sdk.account.api.OauthTokenTriggerScene;
import com.bytedance.trae.im.service.IDeleteTaskApi;
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

/* compiled from: IDeleteTaskApi.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \b2\u00020\u0001:\u0001\bJ&\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0001H'¨\u0006\t"}, d2 = {"Lcom/bytedance/trae/im/service/IDeleteTaskApi;", "", "deleteTaskRaw", "Lcom/bytedance/retrofit2/Call;", "", OauthTokenTriggerScene.REQUEST, "Lcom/bytedance/trae/im/service/DeleteTaskRequest;", "extraInfo", "Companion", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface IDeleteTaskApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @POST("api/solo_hub/v1/conversations/tasks/delete")
    Call<String> deleteTaskRaw(@Body DeleteTaskRequest request, @ExtraInfo Object extraInfo);

    /* compiled from: IDeleteTaskApi.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0086@¢\u0006\u0002\u0010\u0011R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/trae/im/service/IDeleteTaskApi$Companion;", "", "<init>", "()V", "SUCCESS_CODES", "", "", "DEFAULT_HEADERS", "", "", "getDEFAULT_HEADERS", "()Ljava/util/Map;", "deleteTaskRawCall", "Lcom/bytedance/trae/network/response/HttpDataResult;", "Lcom/bytedance/trae/im/service/DeleteTaskResponse;", OauthTokenTriggerScene.REQUEST, "Lcom/bytedance/trae/im/service/DeleteTaskRequest;", "(Lcom/bytedance/trae/im/service/DeleteTaskRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
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
        public final Object deleteTaskRawCall(final DeleteTaskRequest deleteTaskRequest, Continuation<? super HttpDataResult<DeleteTaskResponse>> continuation) {
            IDeleteTaskApi$Companion$deleteTaskRawCall$1 iDeleteTaskApi$Companion$deleteTaskRawCall$1;
            int i;
            HttpDataResult httpResultPreservingBizError;
            if (continuation instanceof IDeleteTaskApi$Companion$deleteTaskRawCall$1) {
                iDeleteTaskApi$Companion$deleteTaskRawCall$1 = (IDeleteTaskApi$Companion$deleteTaskRawCall$1) continuation;
                if ((iDeleteTaskApi$Companion$deleteTaskRawCall$1.label & Integer.MIN_VALUE) != 0) {
                    iDeleteTaskApi$Companion$deleteTaskRawCall$1.label -= Integer.MIN_VALUE;
                    IDeleteTaskApi$Companion$deleteTaskRawCall$1 iDeleteTaskApi$Companion$deleteTaskRawCall$12 = iDeleteTaskApi$Companion$deleteTaskRawCall$1;
                    Object obj = iDeleteTaskApi$Companion$deleteTaskRawCall$12.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = iDeleteTaskApi$Companion$deleteTaskRawCall$12.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        Map<String, String> default_headers = getDEFAULT_HEADERS();
                        Set<Long> set = SUCCESS_CODES;
                        Function2 function2 = new Function2() { // from class: com.bytedance.trae.im.service.IDeleteTaskApi$Companion$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj2, Object obj3) {
                                Call deleteTaskRawCall$lambda$0;
                                deleteTaskRawCall$lambda$0 = IDeleteTaskApi.Companion.deleteTaskRawCall$lambda$0(DeleteTaskRequest.this, (IDeleteTaskApi) obj2, (RequestContext) obj3);
                                return deleteTaskRawCall$lambda$0;
                            }
                        };
                        iDeleteTaskApi$Companion$deleteTaskRawCall$12.label = 1;
                        obj = TraeHttpConnection.rawBizCallWithBody$default(TraeHttpConnection.INSTANCE, "delete_task", IDeleteTaskApi.class, DeleteTaskResponse.class, (String) null, (String) null, default_headers, true, set, false, function2, iDeleteTaskApi$Companion$deleteTaskRawCall$12, 280, (Object) null);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    httpResultPreservingBizError = IDeleteTaskApiKt.toHttpResultPreservingBizError((TraeHttpConnection.RawBizCallResult) obj);
                    return httpResultPreservingBizError;
                }
            }
            iDeleteTaskApi$Companion$deleteTaskRawCall$1 = new IDeleteTaskApi$Companion$deleteTaskRawCall$1(this, continuation);
            IDeleteTaskApi$Companion$deleteTaskRawCall$1 iDeleteTaskApi$Companion$deleteTaskRawCall$122 = iDeleteTaskApi$Companion$deleteTaskRawCall$1;
            Object obj2 = iDeleteTaskApi$Companion$deleteTaskRawCall$122.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i = iDeleteTaskApi$Companion$deleteTaskRawCall$122.label;
            if (i != 0) {
            }
            httpResultPreservingBizError = IDeleteTaskApiKt.toHttpResultPreservingBizError((TraeHttpConnection.RawBizCallResult) obj2);
            return httpResultPreservingBizError;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Call deleteTaskRawCall$lambda$0(DeleteTaskRequest deleteTaskRequest, IDeleteTaskApi iDeleteTaskApi, RequestContext requestContext) {
            Intrinsics.checkNotNullParameter(iDeleteTaskApi, "$this$rawBizCallWithBody");
            Intrinsics.checkNotNullParameter(requestContext, "requestContext");
            return iDeleteTaskApi.deleteTaskRaw(deleteTaskRequest, requestContext);
        }
    }
}
