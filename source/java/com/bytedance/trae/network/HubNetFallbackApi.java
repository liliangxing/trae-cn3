package com.bytedance.trae.network;

import com.bytedance.push.Configuration;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.MaxLength;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import com.bytedance.trae.network.response.BizResponse;
import com.bytedance.trae.network.response.HttpDataResult;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;

/* compiled from: HubNetFallbackApi.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013JJ\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0001\u0010\f\u001a\u00020\u000bH§@¢\u0006\u0002\u0010\rJ\u001e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\b\b\u0001\u0010\u0010\u001a\u00020\u0011H§@¢\u0006\u0002\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/bytedance/trae/network/HubNetFallbackApi;", "", "poll", "Lcom/bytedance/trae/network/response/BizResponse;", "Lcom/bytedance/trae/network/FallbackPollResponse;", "frontierId", "", "deviceId", "", "fromDownSeqId", "limit", "", "maxLength", "(JLjava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", Configuration.NOTIFICATION_ID, "Lcom/bytedance/trae/network/FallbackPushResponse;", "request", "Lcom/bytedance/trae/network/FallbackPushRequest;", "(Lcom/bytedance/trae/network/FallbackPushRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "ttnet_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface HubNetFallbackApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final String SSE_POLL_PATH = "api/solo_hub/v1/wsmessages/sse/poll";

    @GET("api/solo_hub/v1/wsmessages/poll")
    Object poll(@Query("frontier_id") long j, @Query("device_id") String str, @Query("from_down_seq_id") Long l, @Query("limit") Integer num, @MaxLength int i, Continuation<? super BizResponse<FallbackPollResponse>> continuation);

    @POST("api/solo_hub/v1/wsmessages/push")
    Object push(@Body FallbackPushRequest fallbackPushRequest, Continuation<? super BizResponse<FallbackPushResponse>> continuation);

    /* compiled from: HubNetFallbackApi.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JN\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000f2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0080@¢\u0006\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/bytedance/trae/network/HubNetFallbackApi$Companion;", "", "<init>", "()V", "SSE_POLL_PATH", "", "POLL_SUCCESS_CODES", "", "", "getPOLL_SUCCESS_CODES$ttnet_mainlandRelease", "()Ljava/util/Set;", "pollRawCall", "Lcom/bytedance/trae/network/response/HttpDataResult;", "Lcom/bytedance/trae/network/FallbackPollResponse;", "headers", "", "frontierId", "deviceId", "fromDownSeqId", "limit", "", "pollRawCall$ttnet_mainlandRelease", "(Ljava/util/Map;JLjava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ttnet_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final Set<Long> POLL_SUCCESS_CODES = SetsKt.setOf(200L);
        public static final String SSE_POLL_PATH = "api/solo_hub/v1/wsmessages/sse/poll";

        private Companion() {
        }

        public final Set<Long> getPOLL_SUCCESS_CODES$ttnet_mainlandRelease() {
            return POLL_SUCCESS_CODES;
        }

        public final Object pollRawCall$ttnet_mainlandRelease(Map<String, String> map, long j, String str, Long l, Integer num, Continuation<? super HttpDataResult<FallbackPollResponse>> continuation) {
            Object safeCall;
            safeCall = TraeHttpConnection.INSTANCE.safeCall("hub_fallback", HubNetFallbackApi.class, (Map<String, String>) map, new HubNetFallbackApi$Companion$pollRawCall$2(j, str, l, num, null), (r17 & 16) != 0 ? null : null, (Set<Long>) ((r17 & 32) != 0 ? BizResponse.INSTANCE.getDEFAULT_SUCCESS_CODES() : POLL_SUCCESS_CODES), continuation);
            return safeCall;
        }
    }

    /* compiled from: HubNetFallbackApi.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Object poll$default(HubNetFallbackApi hubNetFallbackApi, long j, String str, Long l, Integer num, int i, Continuation continuation, int i2, Object obj) {
            if (obj == null) {
                return hubNetFallbackApi.poll(j, str, (i2 & 4) != 0 ? null : l, (i2 & 8) != 0 ? 20 : num, i, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: poll");
        }
    }
}
