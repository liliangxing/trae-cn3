package com.bytedance.trae.im.service;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.client.Response;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Path;
import com.bytedance.retrofit2.http.Query;
import com.bytedance.retrofit2.http.Streaming;
import com.bytedance.sdk.account.api.OauthTokenTriggerScene;
import com.bytedance.trae.network.DebugSettings;
import com.bytedance.trae.network.TraeHttpConnection;
import com.bytedance.trae.network.response.BizResponse;
import com.bytedance.trae.network.response.HttpDataResult;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ISendMessageService.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eJ(\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH§@¢\u0006\u0002\u0010\tJ\"\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\r\u001a\u00020\u0006H'¨\u0006\u000f"}, d2 = {"Lcom/bytedance/trae/im/service/ISendMessageService;", "", "sendMessage", "Lcom/bytedance/trae/network/response/BizResponse;", "Lcom/bytedance/trae/im/service/SendMessageResponse;", "chatSessionId", "", OauthTokenTriggerScene.REQUEST, "Lcom/bytedance/trae/im/service/SendMessageRequest;", "(Ljava/lang/String;Lcom/bytedance/trae/im/service/SendMessageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "subscribeSseEvents", "Lcom/bytedance/retrofit2/Call;", "Lcom/bytedance/retrofit2/client/Response;", "messageId", "Companion", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface ISendMessageService {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @POST("api/solo_hub/v1/conversations/{chat_session_id}/messages")
    Object sendMessage(@Path("chat_session_id") String str, @Body SendMessageRequest sendMessageRequest, Continuation<? super BizResponse<SendMessageResponse>> continuation);

    @GET("api/solo_hub/v1/chat_sessions/{chat_session_id}/events")
    @Streaming
    Call<Response> subscribeSseEvents(@Path("chat_session_id") String chatSessionId, @Query("message_id") String messageId);

    /* compiled from: ISendMessageService.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\t\u001a\u00020\n2\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005JK\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\r\"\u0004\b\u0000\u0010\u000e2/\u0010\u000f\u001a+\b\u0001\u0012\u0004\u0012\u00020\n\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u000e\u0018\u00010\u00120\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0010¢\u0006\u0002\b\u0013H\u0086@¢\u0006\u0002\u0010\u0014R \u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/trae/im/service/ISendMessageService$Companion;", "", "<init>", "()V", "DEFAULT_HEADERS", "", "", "getDEFAULT_HEADERS", "()Ljava/util/Map;", "createService", "Lcom/bytedance/trae/im/service/ISendMessageService;", "extraHeaders", "safeCall", "Lcom/bytedance/trae/network/response/HttpDataResult;", "T", "call", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "Lcom/bytedance/trae/network/response/BizResponse;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        private final Map<String, String> getDEFAULT_HEADERS() {
            return DebugSettings.buildDefaultHeaders$default(DebugSettings.INSTANCE, (Map) null, 1, (Object) null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ISendMessageService createService$default(Companion companion, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                map = MapsKt.emptyMap();
            }
            return companion.createService(map);
        }

        public final ISendMessageService createService(Map<String, String> extraHeaders) {
            Intrinsics.checkNotNullParameter(extraHeaders, "extraHeaders");
            return (ISendMessageService) TraeHttpConnection.createService$default(TraeHttpConnection.INSTANCE, "send_message", ISendMessageService.class, (Converter.Factory) null, (String) null, MapsKt.plus(getDEFAULT_HEADERS(), extraHeaders), false, 12, (Object) null);
        }

        public final <T> Object safeCall(Function2<? super ISendMessageService, ? super Continuation<? super BizResponse<T>>, ? extends Object> function2, Continuation<? super HttpDataResult<? extends T>> continuation) {
            return TraeHttpConnection.safeCall$default(TraeHttpConnection.INSTANCE, "send_message", ISendMessageService.class, getDEFAULT_HEADERS(), function2, (String) null, (Set) null, continuation, 48, (Object) null);
        }
    }
}
