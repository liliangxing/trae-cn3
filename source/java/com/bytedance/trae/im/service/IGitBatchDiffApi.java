package com.bytedance.trae.im.service;

import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.sdk.account.api.AccountErrorCode;
import com.bytedance.sdk.account.api.OauthTokenTriggerScene;
import com.bytedance.trae.network.TraeHttpConnection;
import com.bytedance.trae.network.response.BizResponse;
import com.bytedance.trae.network.response.HttpDataResult;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: IDiffViewApi.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \b2\u00020\u0001:\u0001\bJ\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/trae/im/service/IGitBatchDiffApi;", "", "batchDiff", "Lcom/bytedance/trae/network/response/BizResponse;", "Lcom/bytedance/trae/im/service/GitBatchDiffResponse;", OauthTokenTriggerScene.REQUEST, "Lcom/bytedance/trae/im/service/GitBatchDiffRequest;", "(Lcom/bytedance/trae/im/service/GitBatchDiffRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface IGitBatchDiffApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @POST("git/batch-diff")
    Object batchDiff(@Body GitBatchDiffRequest gitBatchDiffRequest, Continuation<? super BizResponse<GitBatchDiffResponse>> continuation);

    /* compiled from: IDiffViewApi.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Jc\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\n2/\u0010\u000b\u001a+\b\u0001\u0012\u0004\u0012\u00020\r\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000f0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00010\f¢\u0006\u0002\b\u0010H\u0086@¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/trae/im/service/IGitBatchDiffApi$Companion;", "", "<init>", "()V", "safeCall", "Lcom/bytedance/trae/network/response/HttpDataResult;", "Lcom/bytedance/trae/im/service/GitBatchDiffResponse;", "explorerUrl", "", "extraHeaders", "", "call", "Lkotlin/Function2;", "Lcom/bytedance/trae/im/service/IGitBatchDiffApi;", "Lkotlin/coroutines/Continuation;", "Lcom/bytedance/trae/network/response/BizResponse;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/String;Ljava/util/Map;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0062 A[Catch: all -> 0x002e, CancellationException -> 0x0031, TryCatch #2 {CancellationException -> 0x0031, all -> 0x002e, blocks: (B:10:0x002a, B:11:0x005e, B:13:0x0062, B:16:0x007d, B:21:0x003e), top: B:7:0x0026 }] */
        /* JADX WARN: Removed duplicated region for block: B:16:0x007d A[Catch: all -> 0x002e, CancellationException -> 0x0031, TRY_LEAVE, TryCatch #2 {CancellationException -> 0x0031, all -> 0x002e, blocks: (B:10:0x002a, B:11:0x005e, B:13:0x0062, B:16:0x007d, B:21:0x003e), top: B:7:0x0026 }] */
        /* JADX WARN: Removed duplicated region for block: B:20:0x003b  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0028  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object safeCall(String str, Map<String, String> map, Function2<? super IGitBatchDiffApi, ? super Continuation<? super BizResponse<GitBatchDiffResponse>>, ? extends Object> function2, Continuation<? super HttpDataResult<GitBatchDiffResponse>> continuation) {
            IGitBatchDiffApi$Companion$safeCall$1 iGitBatchDiffApi$Companion$safeCall$1;
            int i;
            BizResponse bizResponse;
            try {
                if (continuation instanceof IGitBatchDiffApi$Companion$safeCall$1) {
                    iGitBatchDiffApi$Companion$safeCall$1 = (IGitBatchDiffApi$Companion$safeCall$1) continuation;
                    if ((iGitBatchDiffApi$Companion$safeCall$1.label & Integer.MIN_VALUE) != 0) {
                        iGitBatchDiffApi$Companion$safeCall$1.label -= Integer.MIN_VALUE;
                        Object obj = iGitBatchDiffApi$Companion$safeCall$1.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        i = iGitBatchDiffApi$Companion$safeCall$1.label;
                        if (i != 0) {
                            ResultKt.throwOnFailure(obj);
                            IGitBatchDiffApi iGitBatchDiffApi = (IGitBatchDiffApi) TraeHttpConnection.createService$default(TraeHttpConnection.INSTANCE, "git_batch_diff", IGitBatchDiffApi.class, (Converter.Factory) null, str, map, false, 36, (Object) null);
                            iGitBatchDiffApi$Companion$safeCall$1.label = 1;
                            obj = function2.invoke(iGitBatchDiffApi, iGitBatchDiffApi$Companion$safeCall$1);
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
                            return new HttpDataResult.Error(AccountErrorCode.CommonError.COMMON_ERROR_REQUEST_API, "GitBatchDiffResponse is null", new Exception("GitBatchDiffResponse is null"), (String) null, 8, (DefaultConstructorMarker) null);
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
            iGitBatchDiffApi$Companion$safeCall$1 = new IGitBatchDiffApi$Companion$safeCall$1(this, continuation);
            Object obj2 = iGitBatchDiffApi$Companion$safeCall$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i = iGitBatchDiffApi$Companion$safeCall$1.label;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Object safeCall$default(Companion companion, String str, Map map, Function2 function2, Continuation continuation, int i, Object obj) {
            if ((i & 2) != 0) {
                map = MapsKt.emptyMap();
            }
            return companion.safeCall(str, map, function2, continuation);
        }
    }
}
