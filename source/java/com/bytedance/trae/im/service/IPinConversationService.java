package com.bytedance.trae.im.service;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.ExtraInfo;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.sdk.account.api.OauthTokenTriggerScene;
import com.bytedance.trae.im.service.IPinConversationService;
import com.bytedance.trae.network.DebugSettings;
import com.bytedance.trae.network.TraeHttpConnection;
import com.bytedance.trae.network.response.BizResponse;
import com.bytedance.trae.network.response.HttpDataResult;
import com.bytedance.ttnet.http.RequestContext;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IPinConversationService.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 \t2\u00020\u0001:\u0001\tJ&\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0001H'J&\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0001H'¨\u0006\n"}, d2 = {"Lcom/bytedance/trae/im/service/IPinConversationService;", "", "pinRaw", "Lcom/bytedance/retrofit2/Call;", "", OauthTokenTriggerScene.REQUEST, "Lcom/bytedance/trae/im/service/PinConversationRequest;", "extraInfo", "unpinRaw", "Companion", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface IPinConversationService {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @POST("api/solo_hub/v1/conversations/pin")
    Call<String> pinRaw(@Body PinConversationRequest request, @ExtraInfo Object extraInfo);

    @POST("api/solo_hub/v1/conversations/unpin")
    Call<String> unpinRaw(@Body PinConversationRequest request, @ExtraInfo Object extraInfo);

    /* compiled from: IPinConversationService.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0086@¢\u0006\u0002\u0010\u0011J\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0086@¢\u0006\u0002\u0010\u0011J\u001b\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00142\u0006\u0010\u0015\u001a\u00020\tH\u0000¢\u0006\u0002\b\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/bytedance/trae/im/service/IPinConversationService$Companion;", "", "<init>", "()V", "SUCCESS_CODES", "", "", "DEFAULT_HEADERS", "", "", "getDEFAULT_HEADERS", "()Ljava/util/Map;", "pinRawCall", "Lcom/bytedance/trae/network/response/HttpDataResult;", "Lcom/bytedance/trae/im/service/PinConversationResponse;", OauthTokenTriggerScene.REQUEST, "Lcom/bytedance/trae/im/service/PinConversationRequest;", "(Lcom/bytedance/trae/im/service/PinConversationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unpinRawCall", "parseRawBody", "Lcom/bytedance/trae/network/response/BizResponse;", "bodyStr", "parseRawBody$im_mainlandRelease", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final Set<Long> SUCCESS_CODES = SetsKt.setOf(200L);

        private Companion() {
        }

        private final Map<String, String> getDEFAULT_HEADERS() {
            return DebugSettings.buildDefaultHeaders$default(DebugSettings.INSTANCE, (Map) null, 1, (Object) null);
        }

        public final Object pinRawCall(final PinConversationRequest pinConversationRequest, Continuation<? super HttpDataResult<PinConversationResponse>> continuation) {
            return TraeHttpConnection.rawBizCall$default(TraeHttpConnection.INSTANCE, "pin_conversation", IPinConversationService.class, (String) null, (String) null, getDEFAULT_HEADERS(), true, SUCCESS_CODES, false, false, new Function2() { // from class: com.bytedance.trae.im.service.IPinConversationService$Companion$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    BizResponse pinRawCall$lambda$0;
                    pinRawCall$lambda$0 = IPinConversationService.Companion.pinRawCall$lambda$0((String) obj, (SsResponse) obj2);
                    return pinRawCall$lambda$0;
                }
            }, new Function2() { // from class: com.bytedance.trae.im.service.IPinConversationService$Companion$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Call pinRawCall$lambda$1;
                    pinRawCall$lambda$1 = IPinConversationService.Companion.pinRawCall$lambda$1(PinConversationRequest.this, (IPinConversationService) obj, (RequestContext) obj2);
                    return pinRawCall$lambda$1;
                }
            }, continuation, 396, (Object) null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final BizResponse pinRawCall$lambda$0(String str, SsResponse ssResponse) {
            Intrinsics.checkNotNullParameter(str, "body");
            Intrinsics.checkNotNullParameter(ssResponse, "<unused var>");
            return $$INSTANCE.parseRawBody$im_mainlandRelease(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Call pinRawCall$lambda$1(PinConversationRequest pinConversationRequest, IPinConversationService iPinConversationService, RequestContext requestContext) {
            Intrinsics.checkNotNullParameter(iPinConversationService, "$this$rawBizCall");
            Intrinsics.checkNotNullParameter(requestContext, "requestContext");
            return iPinConversationService.pinRaw(pinConversationRequest, requestContext);
        }

        public final Object unpinRawCall(final PinConversationRequest pinConversationRequest, Continuation<? super HttpDataResult<PinConversationResponse>> continuation) {
            return TraeHttpConnection.rawBizCall$default(TraeHttpConnection.INSTANCE, "pin_conversation", IPinConversationService.class, (String) null, (String) null, getDEFAULT_HEADERS(), true, SUCCESS_CODES, false, false, new Function2() { // from class: com.bytedance.trae.im.service.IPinConversationService$Companion$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    BizResponse unpinRawCall$lambda$2;
                    unpinRawCall$lambda$2 = IPinConversationService.Companion.unpinRawCall$lambda$2((String) obj, (SsResponse) obj2);
                    return unpinRawCall$lambda$2;
                }
            }, new Function2() { // from class: com.bytedance.trae.im.service.IPinConversationService$Companion$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Call unpinRawCall$lambda$3;
                    unpinRawCall$lambda$3 = IPinConversationService.Companion.unpinRawCall$lambda$3(PinConversationRequest.this, (IPinConversationService) obj, (RequestContext) obj2);
                    return unpinRawCall$lambda$3;
                }
            }, continuation, 396, (Object) null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final BizResponse unpinRawCall$lambda$2(String str, SsResponse ssResponse) {
            Intrinsics.checkNotNullParameter(str, "body");
            Intrinsics.checkNotNullParameter(ssResponse, "<unused var>");
            return $$INSTANCE.parseRawBody$im_mainlandRelease(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Call unpinRawCall$lambda$3(PinConversationRequest pinConversationRequest, IPinConversationService iPinConversationService, RequestContext requestContext) {
            Intrinsics.checkNotNullParameter(iPinConversationService, "$this$rawBizCall");
            Intrinsics.checkNotNullParameter(requestContext, "requestContext");
            return iPinConversationService.unpinRaw(pinConversationRequest, requestContext);
        }

        public final BizResponse<PinConversationResponse> parseRawBody$im_mainlandRelease(String bodyStr) {
            Intrinsics.checkNotNullParameter(bodyStr, "bodyStr");
            Object fromJson = TraeHttpConnection.INSTANCE.getHttpGson().fromJson(bodyStr, TypeToken.getParameterized(BizResponse.class, new Type[]{PinConversationResponse.class}).getType());
            BizResponse<PinConversationResponse> bizResponse = (BizResponse) fromJson;
            bizResponse.setupSuccessCodes(SUCCESS_CODES);
            Intrinsics.checkNotNullExpressionValue(fromJson, "apply(...)");
            return bizResponse;
        }
    }
}
