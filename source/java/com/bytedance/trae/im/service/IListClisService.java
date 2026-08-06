package com.bytedance.trae.im.service;

import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import com.bytedance.sdk.account.api.OauthTokenTriggerScene;
import com.bytedance.timonbase.pipeline.TimonPipeline;
import com.bytedance.trae.network.DebugSettings;
import com.bytedance.trae.network.TraeHttpConnection;
import com.bytedance.trae.network.response.BizResponse;
import com.bytedance.trae.network.response.HttpDataResult;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

/* compiled from: IListClisService.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016J2\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\b2\b\b\u0003\u0010\t\u001a\u00020\bH§@¢\u0006\u0002\u0010\nJ\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0003H§@¢\u0006\u0002\u0010\rJ\u001e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\b\b\u0001\u0010\u0010\u001a\u00020\u0011H§@¢\u0006\u0002\u0010\u0012J\u001e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\b\b\u0001\u0010\u0010\u001a\u00020\u0014H§@¢\u0006\u0002\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/bytedance/trae/im/service/IListClisService;", "", "listClis", "Lcom/bytedance/trae/network/response/BizResponse;", "Lcom/bytedance/trae/im/service/ListClisResponse;", TimonPipeline.KEY_SOURCE, "", "pageSize", "", "pageIndex", "(Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getOnboardingState", "Lcom/bytedance/trae/im/service/OnboardingStateResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "renameCli", "Lcom/bytedance/trae/im/service/CliMutationResponse;", OauthTokenTriggerScene.REQUEST, "Lcom/bytedance/trae/im/service/RenameCliRequest;", "(Lcom/bytedance/trae/im/service/RenameCliRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unregisterCli", "Lcom/bytedance/trae/im/service/UnregisterCliRequest;", "(Lcom/bytedance/trae/im/service/UnregisterCliRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface IListClisService {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @GET("api/solo_hub/v1/user/onboarding/state")
    Object getOnboardingState(Continuation<? super BizResponse<OnboardingStateResponse>> continuation);

    @GET("api/solo_hub/v1/clis")
    Object listClis(@Query("source") String str, @Query("page_size") int i, @Query("page_index") int i2, Continuation<? super BizResponse<ListClisResponse>> continuation);

    @POST("api/solo_hub/v1/clis/rename")
    Object renameCli(@Body RenameCliRequest renameCliRequest, Continuation<? super BizResponse<CliMutationResponse>> continuation);

    @POST("api/solo_hub/v1/clis/unregister")
    Object unregisterCli(@Body UnregisterCliRequest unregisterCliRequest, Continuation<? super BizResponse<CliMutationResponse>> continuation);

    /* compiled from: IListClisService.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Object listClis$default(IListClisService iListClisService, String str, int i, int i2, Continuation continuation, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: listClis");
            }
            if ((i3 & 1) != 0) {
                str = CliListSource.REGISTERED.getValue();
            }
            if ((i3 & 2) != 0) {
                i = 100;
            }
            if ((i3 & 4) != 0) {
                i2 = 0;
            }
            return iListClisService.listClis(str, i, i2, continuation);
        }
    }

    /* compiled from: IListClisService.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JK\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\r\"\u0004\b\u0000\u0010\u000e2/\u0010\u000f\u001a+\b\u0001\u0012\u0004\u0012\u00020\u0011\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u000e\u0018\u00010\u00130\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0010¢\u0006\u0002\b\u0014H\u0086@¢\u0006\u0002\u0010\u0015R \u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/bytedance/trae/im/service/IListClisService$Companion;", "", "<init>", "()V", "DEFAULT_HEADERS", "", "", "getDEFAULT_HEADERS", "()Ljava/util/Map;", "SUCCESS_CODES", "", "", "safeCall", "Lcom/bytedance/trae/network/response/HttpDataResult;", "T", "call", "Lkotlin/Function2;", "Lcom/bytedance/trae/im/service/IListClisService;", "Lkotlin/coroutines/Continuation;", "Lcom/bytedance/trae/network/response/BizResponse;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final Set<Long> SUCCESS_CODES = SetsKt.setOf(200L);

        private Companion() {
        }

        private final Map<String, String> getDEFAULT_HEADERS() {
            return DebugSettings.buildDefaultHeaders$default(DebugSettings.INSTANCE, (Map) null, 1, (Object) null);
        }

        public final <T> Object safeCall(Function2<? super IListClisService, ? super Continuation<? super BizResponse<T>>, ? extends Object> function2, Continuation<? super HttpDataResult<? extends T>> continuation) {
            return TraeHttpConnection.safeCall$default(TraeHttpConnection.INSTANCE, "base", IListClisService.class, getDEFAULT_HEADERS(), function2, (String) null, SUCCESS_CODES, continuation, 16, (Object) null);
        }
    }
}
