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
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ICancelNotifyApi.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \b2\u00020\u0001:\u0001\bJ\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/trae/im/service/ICancelNotifyApi;", "", "cancelNotify", "Lcom/bytedance/trae/network/response/BizResponse;", "Lcom/bytedance/trae/im/service/CancelNotifyResponse;", OauthTokenTriggerScene.REQUEST, "Lcom/bytedance/trae/im/service/CancelNotifyRequest;", "(Lcom/bytedance/trae/im/service/CancelNotifyRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface ICancelNotifyApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @POST("api/solo_hub/v1/apps/cancel_notify")
    Object cancelNotify(@Body CancelNotifyRequest cancelNotifyRequest, Continuation<? super BizResponse<CancelNotifyResponse>> continuation);

    /* compiled from: ICancelNotifyApi.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JK\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0000\u0010\u00062/\u0010\u0007\u001a+\b\u0001\u0012\u0004\u0012\u00020\t\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0006\u0018\u00010\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b¢\u0006\u0002\b\fH\u0086@¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/trae/im/service/ICancelNotifyApi$Companion;", "", "<init>", "()V", "safeCall", "Lcom/bytedance/trae/network/response/HttpDataResult;", "T", "call", "Lkotlin/Function2;", "Lcom/bytedance/trae/im/service/ICancelNotifyApi;", "Lkotlin/coroutines/Continuation;", "Lcom/bytedance/trae/network/response/BizResponse;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x005a A[Catch: all -> 0x002a, CancellationException -> 0x002d, TryCatch #2 {CancellationException -> 0x002d, all -> 0x002a, blocks: (B:10:0x0026, B:11:0x0056, B:13:0x005a, B:16:0x0075, B:21:0x003a), top: B:7:0x0022 }] */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0075 A[Catch: all -> 0x002a, CancellationException -> 0x002d, TRY_LEAVE, TryCatch #2 {CancellationException -> 0x002d, all -> 0x002a, blocks: (B:10:0x0026, B:11:0x0056, B:13:0x005a, B:16:0x0075, B:21:0x003a), top: B:7:0x0022 }] */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final <T> Object safeCall(Function2<? super ICancelNotifyApi, ? super Continuation<? super BizResponse<T>>, ? extends Object> function2, Continuation<? super HttpDataResult<? extends T>> continuation) {
            ICancelNotifyApi$Companion$safeCall$1 iCancelNotifyApi$Companion$safeCall$1;
            int i;
            BizResponse bizResponse;
            try {
                if (continuation instanceof ICancelNotifyApi$Companion$safeCall$1) {
                    iCancelNotifyApi$Companion$safeCall$1 = (ICancelNotifyApi$Companion$safeCall$1) continuation;
                    if ((iCancelNotifyApi$Companion$safeCall$1.label & Integer.MIN_VALUE) != 0) {
                        iCancelNotifyApi$Companion$safeCall$1.label -= Integer.MIN_VALUE;
                        Object obj = iCancelNotifyApi$Companion$safeCall$1.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        i = iCancelNotifyApi$Companion$safeCall$1.label;
                        if (i != 0) {
                            ResultKt.throwOnFailure(obj);
                            ICancelNotifyApi iCancelNotifyApi = (ICancelNotifyApi) TraeHttpConnection.createService$default(TraeHttpConnection.INSTANCE, "cancel_notify", ICancelNotifyApi.class, (Converter.Factory) null, (String) null, (Map) null, false, 60, (Object) null);
                            iCancelNotifyApi$Companion$safeCall$1.label = 1;
                            obj = function2.invoke(iCancelNotifyApi, iCancelNotifyApi$Companion$safeCall$1);
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
            iCancelNotifyApi$Companion$safeCall$1 = new ICancelNotifyApi$Companion$safeCall$1(this, continuation);
            Object obj2 = iCancelNotifyApi$Companion$safeCall$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i = iCancelNotifyApi$Companion$safeCall$1.label;
        }
    }
}
