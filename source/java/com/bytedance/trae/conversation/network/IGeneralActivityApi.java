package com.bytedance.trae.conversation.network;

import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.sdk.account.api.AccountErrorCode;
import com.bytedance.trae.network.HostResolver;
import com.bytedance.trae.network.HostType;
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

/* compiled from: ICustomActivityApi.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007J\u0018\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/conversation/network/IGeneralActivityApi;", "", "getGeneralActivities", "Lcom/bytedance/trae/conversation/network/GeneralActivityResponse;", "body", "Lcom/bytedance/trae/conversation/network/MobileActivityRequest;", "(Lcom/bytedance/trae/conversation/network/MobileActivityRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface IGeneralActivityApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @POST("trae/api/v2/pay/mobile_activity")
    Object getGeneralActivities(@Body MobileActivityRequest mobileActivityRequest, Continuation<? super GeneralActivityResponse> continuation);

    /* compiled from: ICustomActivityApi.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J?\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052)\u0010\u0007\u001a%\b\u0001\u0012\u0004\u0012\u00020\t\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b¢\u0006\u0002\b\fH\u0086@¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/trae/conversation/network/IGeneralActivityApi$Companion;", "", "<init>", "()V", "safeCall", "Lcom/bytedance/trae/network/response/HttpDataResult;", "Lcom/bytedance/trae/conversation/network/GeneralActivityData;", "call", "Lkotlin/Function2;", "Lcom/bytedance/trae/conversation/network/IGeneralActivityApi;", "Lkotlin/coroutines/Continuation;", "Lcom/bytedance/trae/conversation/network/GeneralActivityResponse;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0062 A[Catch: all -> 0x002a, CancellationException -> 0x002d, TryCatch #2 {CancellationException -> 0x002d, all -> 0x002a, blocks: (B:10:0x0026, B:11:0x005e, B:13:0x0062, B:16:0x007d, B:21:0x003b), top: B:7:0x0022 }] */
        /* JADX WARN: Removed duplicated region for block: B:16:0x007d A[Catch: all -> 0x002a, CancellationException -> 0x002d, TRY_LEAVE, TryCatch #2 {CancellationException -> 0x002d, all -> 0x002a, blocks: (B:10:0x0026, B:11:0x005e, B:13:0x0062, B:16:0x007d, B:21:0x003b), top: B:7:0x0022 }] */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0038  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object safeCall(Function2<? super IGeneralActivityApi, ? super Continuation<? super GeneralActivityResponse>, ? extends Object> function2, Continuation<? super HttpDataResult<GeneralActivityData>> continuation) {
            IGeneralActivityApi$Companion$safeCall$1 iGeneralActivityApi$Companion$safeCall$1;
            int i;
            GeneralActivityResponse generalActivityResponse;
            try {
                if (continuation instanceof IGeneralActivityApi$Companion$safeCall$1) {
                    iGeneralActivityApi$Companion$safeCall$1 = (IGeneralActivityApi$Companion$safeCall$1) continuation;
                    if ((iGeneralActivityApi$Companion$safeCall$1.label & Integer.MIN_VALUE) != 0) {
                        iGeneralActivityApi$Companion$safeCall$1.label -= Integer.MIN_VALUE;
                        Object obj = iGeneralActivityApi$Companion$safeCall$1.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        i = iGeneralActivityApi$Companion$safeCall$1.label;
                        if (i != 0) {
                            ResultKt.throwOnFailure(obj);
                            IGeneralActivityApi iGeneralActivityApi = (IGeneralActivityApi) TraeHttpConnection.createService$default(TraeHttpConnection.INSTANCE, "general_activity", IGeneralActivityApi.class, (Converter.Factory) null, HostResolver.INSTANCE.getBaseUrl(HostType.LOGIN), (Map) null, false, 52, (Object) null);
                            iGeneralActivityApi$Companion$safeCall$1.label = 1;
                            obj = function2.invoke(iGeneralActivityApi, iGeneralActivityApi$Companion$safeCall$1);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                        }
                        generalActivityResponse = (GeneralActivityResponse) obj;
                        if (generalActivityResponse != null) {
                            return new HttpDataResult.Error(AccountErrorCode.CommonError.COMMON_ERROR_REQUEST_API, "Response is null", new Exception("Response is null"), (String) null, 8, (DefaultConstructorMarker) null);
                        }
                        return new HttpDataResult.Success(new BizResponse(0L, (String) null, (String) null, (String) null, generalActivityResponse.getData(), (String) null, 47, (DefaultConstructorMarker) null), (Throwable) null);
                    }
                }
                if (i != 0) {
                }
                generalActivityResponse = (GeneralActivityResponse) obj;
                if (generalActivityResponse != null) {
                }
            } catch (CancellationException e) {
                return new HttpDataResult.Error(-1001, "", e, (String) null, 8, (DefaultConstructorMarker) null);
            } catch (Throwable th) {
                return new HttpDataResult.Error(-1000, "", th, (String) null, 8, (DefaultConstructorMarker) null);
            }
            iGeneralActivityApi$Companion$safeCall$1 = new IGeneralActivityApi$Companion$safeCall$1(this, continuation);
            Object obj2 = iGeneralActivityApi$Companion$safeCall$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i = iGeneralActivityApi$Companion$safeCall$1.label;
        }
    }
}
