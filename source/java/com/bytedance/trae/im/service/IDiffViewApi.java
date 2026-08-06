package com.bytedance.trae.im.service;

import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Path;
import com.bytedance.retrofit2.http.Query;
import com.bytedance.sdk.account.api.AccountErrorCode;
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
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u0000 \b2\u00020\u0001:\u0001\bJ\"\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/trae/im/service/IDiffViewApi;", "", "getDiffView", "Lcom/bytedance/trae/im/service/DiffViewResponse;", "fileName", "", "chatSessionId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface IDiffViewApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @GET("diffview/{file_name}")
    Object getDiffView(@Path("file_name") String str, @Query("chat_session_id") String str2, Continuation<? super DiffViewResponse> continuation);

    /* compiled from: IDiffViewApi.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J]\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\n2)\u0010\u000b\u001a%\b\u0001\u0012\u0004\u0012\u00020\r\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00010\f¢\u0006\u0002\b\u000fH\u0086@¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/trae/im/service/IDiffViewApi$Companion;", "", "<init>", "()V", "safeCall", "Lcom/bytedance/trae/network/response/HttpDataResult;", "Lcom/bytedance/trae/im/service/DiffViewResponse;", "explorerUrl", "", "extraHeaders", "", "call", "Lkotlin/Function2;", "Lcom/bytedance/trae/im/service/IDiffViewApi;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/String;Ljava/util/Map;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0066 A[Catch: all -> 0x0030, CancellationException -> 0x0033, TryCatch #2 {CancellationException -> 0x0033, all -> 0x0030, blocks: (B:10:0x002c, B:11:0x0061, B:13:0x0066, B:16:0x0082, B:21:0x0041), top: B:7:0x0028 }] */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0082 A[Catch: all -> 0x0030, CancellationException -> 0x0033, TRY_LEAVE, TryCatch #2 {CancellationException -> 0x0033, all -> 0x0030, blocks: (B:10:0x002c, B:11:0x0061, B:13:0x0066, B:16:0x0082, B:21:0x0041), top: B:7:0x0028 }] */
        /* JADX WARN: Removed duplicated region for block: B:20:0x003e  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x002a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object safeCall(String str, Map<String, String> map, Function2<? super IDiffViewApi, ? super Continuation<? super DiffViewResponse>, ? extends Object> function2, Continuation<? super HttpDataResult<DiffViewResponse>> continuation) {
            IDiffViewApi$Companion$safeCall$1 iDiffViewApi$Companion$safeCall$1;
            int i;
            DiffViewResponse diffViewResponse;
            try {
                if (continuation instanceof IDiffViewApi$Companion$safeCall$1) {
                    iDiffViewApi$Companion$safeCall$1 = (IDiffViewApi$Companion$safeCall$1) continuation;
                    if ((iDiffViewApi$Companion$safeCall$1.label & Integer.MIN_VALUE) != 0) {
                        iDiffViewApi$Companion$safeCall$1.label -= Integer.MIN_VALUE;
                        Object obj = iDiffViewApi$Companion$safeCall$1.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        i = iDiffViewApi$Companion$safeCall$1.label;
                        if (i != 0) {
                            ResultKt.throwOnFailure(obj);
                            IDiffViewApi iDiffViewApi = (IDiffViewApi) TraeHttpConnection.createService$default(TraeHttpConnection.INSTANCE, "diff_view", IDiffViewApi.class, (Converter.Factory) null, str, map, false, 36, (Object) null);
                            iDiffViewApi$Companion$safeCall$1.label = 1;
                            obj = function2.invoke(iDiffViewApi, iDiffViewApi$Companion$safeCall$1);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                        }
                        diffViewResponse = (DiffViewResponse) obj;
                        if (diffViewResponse != null) {
                            return new HttpDataResult.Error(AccountErrorCode.CommonError.COMMON_ERROR_REQUEST_API, "DiffViewResponse is null", new Exception("DiffViewResponse is null"), (String) null, 8, (DefaultConstructorMarker) null);
                        }
                        return new HttpDataResult.Success(new BizResponse(0L, (String) null, (String) null, (String) null, diffViewResponse, (String) null, 47, (DefaultConstructorMarker) null), (Throwable) null);
                    }
                }
                if (i != 0) {
                }
                diffViewResponse = (DiffViewResponse) obj;
                if (diffViewResponse != null) {
                }
            } catch (CancellationException e) {
                return new HttpDataResult.Error(-1001, "", e, (String) null, 8, (DefaultConstructorMarker) null);
            } catch (Throwable th) {
                return new HttpDataResult.Error(-1000, "", th, (String) null, 8, (DefaultConstructorMarker) null);
            }
            iDiffViewApi$Companion$safeCall$1 = new IDiffViewApi$Companion$safeCall$1(this, continuation);
            Object obj2 = iDiffViewApi$Companion$safeCall$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i = iDiffViewApi$Companion$safeCall$1.label;
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
