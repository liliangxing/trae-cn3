package com.bytedance.trae.conversation.products;

import android.util.Log;
import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.QueryMap;
import com.bytedance.sdk.account.api.AccountErrorCode;
import com.bytedance.trae.network.TraeHttpConnection;
import com.bytedance.trae.network.response.BizResponse;
import com.bytedance.trae.network.response.HttpDataResult;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: IGetArtifactListApi.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u0000 \t2\u00020\u0001:\u0001\tJ*\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006H§@¢\u0006\u0002\u0010\b¨\u0006\n"}, d2 = {"Lcom/bytedance/trae/conversation/products/IGetArtifactListApi;", "", "getArtifactList", "Lcom/bytedance/trae/network/response/BizResponse;", "Lcom/bytedance/trae/conversation/products/GetArtifactListData;", "query", "", "", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface IGetArtifactListApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @GET("api/solo_hub/v1/conversations/artifacts")
    Object getArtifactList(@QueryMap Map<String, String> map, Continuation<? super BizResponse<GetArtifactListData>> continuation);

    /* compiled from: IGetArtifactListApi.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JK\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0000\u0010\u00062/\u0010\u0007\u001a+\b\u0001\u0012\u0004\u0012\u00020\t\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0006\u0018\u00010\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b¢\u0006\u0002\b\fH\u0086@¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/trae/conversation/products/IGetArtifactListApi$Companion;", "", "<init>", "()V", "safeCall", "Lcom/bytedance/trae/network/response/HttpDataResult;", "T", "call", "Lkotlin/Function2;", "Lcom/bytedance/trae/conversation/products/IGetArtifactListApi;", "Lkotlin/coroutines/Continuation;", "Lcom/bytedance/trae/network/response/BizResponse;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0066 A[Catch: all -> 0x0032, CancellationException -> 0x0036, TryCatch #2 {CancellationException -> 0x0036, all -> 0x0032, blocks: (B:10:0x002e, B:11:0x0062, B:13:0x0066, B:16:0x0081, B:19:0x0096, B:21:0x0092, B:25:0x0044), top: B:7:0x002a }] */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0081 A[Catch: all -> 0x0032, CancellationException -> 0x0036, TryCatch #2 {CancellationException -> 0x0036, all -> 0x0032, blocks: (B:10:0x002e, B:11:0x0062, B:13:0x0066, B:16:0x0081, B:19:0x0096, B:21:0x0092, B:25:0x0044), top: B:7:0x002a }] */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0041  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x002c  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final <T> Object safeCall(Function2<? super IGetArtifactListApi, ? super Continuation<? super BizResponse<T>>, ? extends Object> function2, Continuation<? super HttpDataResult<? extends T>> continuation) {
            IGetArtifactListApi$Companion$safeCall$1 iGetArtifactListApi$Companion$safeCall$1;
            int i;
            BizResponse bizResponse;
            try {
                if (continuation instanceof IGetArtifactListApi$Companion$safeCall$1) {
                    iGetArtifactListApi$Companion$safeCall$1 = (IGetArtifactListApi$Companion$safeCall$1) continuation;
                    if ((iGetArtifactListApi$Companion$safeCall$1.label & Integer.MIN_VALUE) != 0) {
                        iGetArtifactListApi$Companion$safeCall$1.label -= Integer.MIN_VALUE;
                        Object obj = iGetArtifactListApi$Companion$safeCall$1.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        i = iGetArtifactListApi$Companion$safeCall$1.label;
                        if (i != 0) {
                            ResultKt.throwOnFailure(obj);
                            IGetArtifactListApi iGetArtifactListApi = (IGetArtifactListApi) TraeHttpConnection.createService$default(TraeHttpConnection.INSTANCE, "artifact_list", IGetArtifactListApi.class, (Converter.Factory) null, (String) null, (Map) null, false, 60, (Object) null);
                            iGetArtifactListApi$Companion$safeCall$1.label = 1;
                            obj = function2.invoke(iGetArtifactListApi, iGetArtifactListApi$Companion$safeCall$1);
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
                        return new HttpDataResult.Success(new BizResponse(bizResponse.getCode() == 200 ? 0L : bizResponse.getCode(), bizResponse.getMsg(), (String) null, (String) null, bizResponse.getData(), (String) null, 44, (DefaultConstructorMarker) null), (Throwable) null);
                    }
                }
                if (i != 0) {
                }
                bizResponse = (BizResponse) obj;
                if (bizResponse != null) {
                }
            } catch (CancellationException e) {
                CancellationException cancellationException = e;
                Log.e("IGetArtifactListApi", "CancellationException", cancellationException);
                return new HttpDataResult.Error(-1001, "", cancellationException, (String) null, 8, (DefaultConstructorMarker) null);
            } catch (Throwable th) {
                Log.e("IGetArtifactListApi", "Error", th);
                return new HttpDataResult.Error(-1000, "", th, (String) null, 8, (DefaultConstructorMarker) null);
            }
            iGetArtifactListApi$Companion$safeCall$1 = new IGetArtifactListApi$Companion$safeCall$1(this, continuation);
            Object obj2 = iGetArtifactListApi$Companion$safeCall$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i = iGetArtifactListApi$Companion$safeCall$1.label;
        }
    }
}
