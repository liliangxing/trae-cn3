package com.bytedance.trae.conversation.network;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.http.ExtraInfo;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.QueryMap;
import com.bytedance.sdk.account.api.AccountErrorCode;
import com.bytedance.trae.conversation.network.IGetSkillListApi;
import com.bytedance.trae.network.DebugSettings;
import com.bytedance.trae.network.TraeHttpConnection;
import com.bytedance.trae.network.response.BizResponse;
import com.bytedance.trae.network.response.HttpDataResult;
import com.bytedance.ttnet.http.RequestContext;
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

/* compiled from: IGetSkillListApi.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \f2\u00020\u0001:\u0001\fJ*\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006H§@¢\u0006\u0002\u0010\bJ2\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\n2\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00062\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0001H'¨\u0006\r"}, d2 = {"Lcom/bytedance/trae/conversation/network/IGetSkillListApi;", "", "listSkills", "Lcom/bytedance/trae/conversation/network/RemoteResponse;", "Lcom/bytedance/trae/conversation/network/ListSkillsData;", "query", "", "", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "listSkillsFromHubRaw", "Lcom/bytedance/retrofit2/Call;", "extraInfo", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface IGetSkillListApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @GET("api/remote/v1/skills")
    Object listSkills(@QueryMap Map<String, String> map, Continuation<? super RemoteResponse<ListSkillsData>> continuation);

    @GET("api/solo_hub/v1/clis/skills")
    Call<String> listSkillsFromHubRaw(@QueryMap Map<String, String> query, @ExtraInfo Object extraInfo);

    /* compiled from: IGetSkillListApi.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bH\u0086@¢\u0006\u0002\u0010\u0010J_\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00120\r\"\u0004\b\u0000\u0010\u00122\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b2/\u0010\u0014\u001a+\b\u0001\u0012\u0004\u0012\u00020\u0016\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0012\u0018\u00010\u00180\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0015¢\u0006\u0002\b\u0019H\u0086@¢\u0006\u0002\u0010\u001aR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/bytedance/trae/conversation/network/IGetSkillListApi$Companion;", "", "<init>", "()V", "SUCCESS_CODES", "", "", "DEFAULT_HEADERS", "", "", "getDEFAULT_HEADERS", "()Ljava/util/Map;", "listSkillsFromHub", "Lcom/bytedance/trae/network/response/HttpDataResult;", "Lcom/bytedance/trae/conversation/network/ListSkillsData;", "query", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "safeCall", "T", "headers", "call", "Lkotlin/Function2;", "Lcom/bytedance/trae/conversation/network/IGetSkillListApi;", "Lkotlin/coroutines/Continuation;", "Lcom/bytedance/trae/conversation/network/RemoteResponse;", "Lkotlin/ExtensionFunctionType;", "(Ljava/util/Map;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final Set<Long> SUCCESS_CODES = SetsKt.setOf(200L);

        private Companion() {
        }

        private final Map<String, String> getDEFAULT_HEADERS() {
            return DebugSettings.buildDefaultHeaders$default(DebugSettings.INSTANCE, (Map) null, 1, (Object) null);
        }

        public final Object listSkillsFromHub(final Map<String, String> map, Continuation<? super HttpDataResult<ListSkillsData>> continuation) {
            return TraeHttpConnection.rawBizCall$default(TraeHttpConnection.INSTANCE, "skills", IGetSkillListApi.class, ListSkillsData.class, (String) null, (String) null, getDEFAULT_HEADERS(), true, SUCCESS_CODES, true, new Function2() { // from class: com.bytedance.trae.conversation.network.IGetSkillListApi$Companion$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Call listSkillsFromHub$lambda$0;
                    listSkillsFromHub$lambda$0 = IGetSkillListApi.Companion.listSkillsFromHub$lambda$0(map, (IGetSkillListApi) obj, (RequestContext) obj2);
                    return listSkillsFromHub$lambda$0;
                }
            }, continuation, 24, (Object) null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Call listSkillsFromHub$lambda$0(Map map, IGetSkillListApi iGetSkillListApi, RequestContext requestContext) {
            Intrinsics.checkNotNullParameter(iGetSkillListApi, "$this$rawBizCall");
            Intrinsics.checkNotNullParameter(requestContext, "requestContext");
            return iGetSkillListApi.listSkillsFromHubRaw(map, requestContext);
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x005c A[Catch: all -> 0x002a, CancellationException -> 0x002d, TryCatch #2 {CancellationException -> 0x002d, all -> 0x002a, blocks: (B:10:0x0026, B:11:0x0058, B:13:0x005c, B:16:0x0077, B:21:0x003b), top: B:7:0x0022 }] */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0077 A[Catch: all -> 0x002a, CancellationException -> 0x002d, TRY_LEAVE, TryCatch #2 {CancellationException -> 0x002d, all -> 0x002a, blocks: (B:10:0x0026, B:11:0x0058, B:13:0x005c, B:16:0x0077, B:21:0x003b), top: B:7:0x0022 }] */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0038  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final <T> Object safeCall(Map<String, String> map, Function2<? super IGetSkillListApi, ? super Continuation<? super RemoteResponse<T>>, ? extends Object> function2, Continuation<? super HttpDataResult<? extends T>> continuation) {
            IGetSkillListApi$Companion$safeCall$1 iGetSkillListApi$Companion$safeCall$1;
            int i;
            RemoteResponse remoteResponse;
            try {
                if (continuation instanceof IGetSkillListApi$Companion$safeCall$1) {
                    iGetSkillListApi$Companion$safeCall$1 = (IGetSkillListApi$Companion$safeCall$1) continuation;
                    if ((iGetSkillListApi$Companion$safeCall$1.label & Integer.MIN_VALUE) != 0) {
                        iGetSkillListApi$Companion$safeCall$1.label -= Integer.MIN_VALUE;
                        Object obj = iGetSkillListApi$Companion$safeCall$1.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        i = iGetSkillListApi$Companion$safeCall$1.label;
                        if (i != 0) {
                            ResultKt.throwOnFailure(obj);
                            IGetSkillListApi iGetSkillListApi = (IGetSkillListApi) TraeHttpConnection.createService$default(TraeHttpConnection.INSTANCE, "skills", IGetSkillListApi.class, (Converter.Factory) null, (String) null, (Map) null, false, 60, (Object) null);
                            iGetSkillListApi$Companion$safeCall$1.label = 1;
                            obj = function2.invoke(iGetSkillListApi, iGetSkillListApi$Companion$safeCall$1);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                        }
                        remoteResponse = (RemoteResponse) obj;
                        if (remoteResponse != null) {
                            return new HttpDataResult.Error(AccountErrorCode.CommonError.COMMON_ERROR_REQUEST_API, "BizResponse is null", new Exception("BizResponse is null"), (String) null, 8, (DefaultConstructorMarker) null);
                        }
                        return new HttpDataResult.Success(new BizResponse(remoteResponse.getCode(), remoteResponse.getMsg(), (String) null, (String) null, remoteResponse.getData(), (String) null, 44, (DefaultConstructorMarker) null), (Throwable) null);
                    }
                }
                if (i != 0) {
                }
                remoteResponse = (RemoteResponse) obj;
                if (remoteResponse != null) {
                }
            } catch (CancellationException e) {
                return new HttpDataResult.Error(-1001, "", e, (String) null, 8, (DefaultConstructorMarker) null);
            } catch (Throwable th) {
                return new HttpDataResult.Error(-1000, "", th, (String) null, 8, (DefaultConstructorMarker) null);
            }
            iGetSkillListApi$Companion$safeCall$1 = new IGetSkillListApi$Companion$safeCall$1(this, continuation);
            Object obj2 = iGetSkillListApi$Companion$safeCall$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i = iGetSkillListApi$Companion$safeCall$1.label;
        }
    }
}
