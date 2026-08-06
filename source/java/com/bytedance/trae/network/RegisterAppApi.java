package com.bytedance.trae.network;

import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.trae.network.response.BizResponse;
import com.bytedance.trae.network.response.HttpDataResult;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;

/* compiled from: RegisterAppApi.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \b2\u00020\u0001:\u0001\bJ\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/trae/network/RegisterAppApi;", "", "fetchApp", "Lcom/bytedance/trae/network/response/BizResponse;", "Lcom/bytedance/trae/network/RegisterAppResponse;", "request", "Lcom/bytedance/trae/network/RegisterAppRequest;", "(Lcom/bytedance/trae/network/RegisterAppRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "ttnet_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface RegisterAppApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @POST("api/solo_hub/v1/apps/register")
    Object fetchApp(@Body RegisterAppRequest registerAppRequest, Continuation<? super BizResponse<RegisterAppResponse>> continuation);

    /* compiled from: RegisterAppApi.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0086@¢\u0006\u0002\u0010\u0014R \u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/bytedance/trae/network/RegisterAppApi$Companion;", "", "<init>", "()V", "DEFAULT_HEADERS", "", "", "getDEFAULT_HEADERS", "()Ljava/util/Map;", "TOB_REGISTER_SUCCESS_CODES", "", "", "getTOB_REGISTER_SUCCESS_CODES", "()Ljava/util/Set;", "safeCall", "Lcom/bytedance/trae/network/response/HttpDataResult;", "Lcom/bytedance/trae/network/RegisterAppResponse;", "request", "Lcom/bytedance/trae/network/RegisterAppRequest;", "successCodes", "(Lcom/bytedance/trae/network/RegisterAppRequest;Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ttnet_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final Set<Long> TOB_REGISTER_SUCCESS_CODES = SetsKt.setOf(new Long[]{0L, 200L});

        private Companion() {
        }

        private final Map<String, String> getDEFAULT_HEADERS() {
            return DebugSettings.buildDefaultHeaders$default(DebugSettings.INSTANCE, null, 1, null);
        }

        public final Set<Long> getTOB_REGISTER_SUCCESS_CODES() {
            return TOB_REGISTER_SUCCESS_CODES;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Object safeCall$default(Companion companion, RegisterAppRequest registerAppRequest, Set set, Continuation continuation, int i, Object obj) {
            if ((i & 2) != 0) {
                set = BizResponse.INSTANCE.getDEFAULT_SUCCESS_CODES();
            }
            return companion.safeCall(registerAppRequest, set, continuation);
        }

        public final Object safeCall(RegisterAppRequest registerAppRequest, Set<Long> set, Continuation<? super HttpDataResult<RegisterAppResponse>> continuation) {
            Object safeCall;
            safeCall = TraeHttpConnection.INSTANCE.safeCall("base", RegisterAppApi.class, (Map<String, String>) getDEFAULT_HEADERS(), new RegisterAppApi$Companion$safeCall$2(registerAppRequest, null), (r17 & 16) != 0 ? null : null, (Set<Long>) ((r17 & 32) != 0 ? BizResponse.INSTANCE.getDEFAULT_SUCCESS_CODES() : set), continuation);
            return safeCall;
        }
    }
}
