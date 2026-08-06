package com.bytedance.trae.im.service;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.http.ExtraInfo;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Path;
import com.bytedance.trae.im.service.IChatSessionApi;
import com.bytedance.trae.network.HostResolver;
import com.bytedance.trae.network.HostType;
import com.bytedance.trae.network.TraeHttpConnection;
import com.bytedance.trae.network.response.BizResponse;
import com.bytedance.trae.network.response.HttpDataResult;
import com.bytedance.ttnet.http.RequestContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IChatSessionApi.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u0000 \f2\u00020\u0001:\u0001\fJ&\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00042\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0001H'J&\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00042\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0001H'J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0001\u0010\u0005\u001a\u00020\u0004H§@¢\u0006\u0002\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/bytedance/trae/im/service/IChatSessionApi;", "", "getChatSessionRaw", "Lcom/bytedance/retrofit2/Call;", "", "chatSessionId", "extraInfo", "wakeupSandboxRaw", "wakeupSandbox", "Lcom/bytedance/trae/network/response/BizResponse;", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface IChatSessionApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @GET("api/remote/v1/chat_sessions/{chat_session_id}")
    Call<String> getChatSessionRaw(@Path("chat_session_id") String chatSessionId, @ExtraInfo Object extraInfo);

    @POST("api/remote/v1/chat_sessions/{chat_session_id}/wakeup_sandbox")
    Object wakeupSandbox(@Path("chat_session_id") String str, Continuation<? super BizResponse<Unit>> continuation);

    @POST("api/remote/v1/chat_sessions/{chat_session_id}/wakeup_sandbox")
    Call<String> wakeupSandboxRaw(@Path("chat_session_id") String chatSessionId, @ExtraInfo Object extraInfo);

    /* compiled from: IChatSessionApi.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0019B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\u000eJ\u001b\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\r\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\u0012J\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0016\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\u0017J\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00110\u00142\u0006\u0010\u0016\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/bytedance/trae/im/service/IChatSessionApi$Companion;", "", "<init>", "()V", "BASE_URL", "", "getBASE_URL", "()Ljava/lang/String;", "SUCCESS_CODES", "", "", "parseChatSessionRawBody", "Lcom/bytedance/trae/im/service/IChatSessionApi$Companion$ChatSessionRawParseResult;", "bodyStr", "parseChatSessionRawBody$im_mainlandRelease", "parseWakeupSandboxRawBody", "Lcom/bytedance/trae/network/response/BizResponse;", "", "parseWakeupSandboxRawBody$im_mainlandRelease", "getChatSessionRawCall", "Lcom/bytedance/trae/network/response/HttpDataResult;", "Lcom/bytedance/trae/im/service/ChatSessionResponse;", "chatSessionId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "wakeupSandboxRawCall", "ChatSessionRawParseResult", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final Set<Long> SUCCESS_CODES = SetsKt.setOf(0L);

        private Companion() {
        }

        private final String getBASE_URL() {
            return HostResolver.INSTANCE.getBaseUrl(HostType.REMOTE);
        }

        /* compiled from: IChatSessionApi.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B/\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\tHÆ\u0003J9\u0010\u0017\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\tHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/bytedance/trae/im/service/IChatSessionApi$Companion$ChatSessionRawParseResult;", "", "bizResp", "Lcom/bytedance/trae/network/response/BizResponse;", "Lcom/bytedance/trae/im/service/ChatSessionResponse;", "dataPresent", "", "hasSandboxKey", "sandboxJson", "", "<init>", "(Lcom/bytedance/trae/network/response/BizResponse;ZZLjava/lang/String;)V", "getBizResp", "()Lcom/bytedance/trae/network/response/BizResponse;", "getDataPresent", "()Z", "getHasSandboxKey", "getSandboxJson", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public static final /* data */ class ChatSessionRawParseResult {
            private final BizResponse<ChatSessionResponse> bizResp;
            private final boolean dataPresent;
            private final boolean hasSandboxKey;
            private final String sandboxJson;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ ChatSessionRawParseResult copy$default(ChatSessionRawParseResult chatSessionRawParseResult, BizResponse bizResponse, boolean z, boolean z2, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    bizResponse = chatSessionRawParseResult.bizResp;
                }
                if ((i & 2) != 0) {
                    z = chatSessionRawParseResult.dataPresent;
                }
                if ((i & 4) != 0) {
                    z2 = chatSessionRawParseResult.hasSandboxKey;
                }
                if ((i & 8) != 0) {
                    str = chatSessionRawParseResult.sandboxJson;
                }
                return chatSessionRawParseResult.copy(bizResponse, z, z2, str);
            }

            public final BizResponse<ChatSessionResponse> component1() {
                return this.bizResp;
            }

            /* renamed from: component2, reason: from getter */
            public final boolean getDataPresent() {
                return this.dataPresent;
            }

            /* renamed from: component3, reason: from getter */
            public final boolean getHasSandboxKey() {
                return this.hasSandboxKey;
            }

            /* renamed from: component4, reason: from getter */
            public final String getSandboxJson() {
                return this.sandboxJson;
            }

            public final ChatSessionRawParseResult copy(BizResponse<ChatSessionResponse> bizResp, boolean dataPresent, boolean hasSandboxKey, String sandboxJson) {
                Intrinsics.checkNotNullParameter(bizResp, "bizResp");
                return new ChatSessionRawParseResult(bizResp, dataPresent, hasSandboxKey, sandboxJson);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ChatSessionRawParseResult)) {
                    return false;
                }
                ChatSessionRawParseResult chatSessionRawParseResult = (ChatSessionRawParseResult) other;
                return Intrinsics.areEqual(this.bizResp, chatSessionRawParseResult.bizResp) && this.dataPresent == chatSessionRawParseResult.dataPresent && this.hasSandboxKey == chatSessionRawParseResult.hasSandboxKey && Intrinsics.areEqual(this.sandboxJson, chatSessionRawParseResult.sandboxJson);
            }

            public int hashCode() {
                int hashCode = ((((this.bizResp.hashCode() * 31) + Boolean.hashCode(this.dataPresent)) * 31) + Boolean.hashCode(this.hasSandboxKey)) * 31;
                String str = this.sandboxJson;
                return hashCode + (str == null ? 0 : str.hashCode());
            }

            public String toString() {
                return "ChatSessionRawParseResult(bizResp=" + this.bizResp + ", dataPresent=" + this.dataPresent + ", hasSandboxKey=" + this.hasSandboxKey + ", sandboxJson=" + this.sandboxJson + ')';
            }

            public ChatSessionRawParseResult(BizResponse<ChatSessionResponse> bizResponse, boolean z, boolean z2, String str) {
                Intrinsics.checkNotNullParameter(bizResponse, "bizResp");
                this.bizResp = bizResponse;
                this.dataPresent = z;
                this.hasSandboxKey = z2;
                this.sandboxJson = str;
            }

            public final BizResponse<ChatSessionResponse> getBizResp() {
                return this.bizResp;
            }

            public final boolean getDataPresent() {
                return this.dataPresent;
            }

            public final boolean getHasSandboxKey() {
                return this.hasSandboxKey;
            }

            public final String getSandboxJson() {
                return this.sandboxJson;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0081  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0089  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0093  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0083  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0041  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final ChatSessionRawParseResult parseChatSessionRawBody$im_mainlandRelease(String bodyStr) {
            JsonObject jsonObject;
            ChatSessionResponse chatSessionResponse;
            JsonElement jsonElement;
            Intrinsics.checkNotNullParameter(bodyStr, "bodyStr");
            BizResponse bizResponse = (BizResponse) TraeHttpConnection.INSTANCE.getHttpGson().fromJson(bodyStr, TypeToken.getParameterized(BizResponse.class, new Type[]{JsonElement.class}).getType());
            JsonElement jsonElement2 = (JsonElement) bizResponse.getData();
            String str = null;
            if (jsonElement2 != null) {
                JsonElement jsonElement3 = jsonElement2.isJsonObject() ? jsonElement2 : null;
                if (jsonElement3 != null) {
                    jsonObject = jsonElement3.getAsJsonObject();
                    if (jsonElement2 != null) {
                        JsonElement jsonElement4 = jsonElement2.isJsonNull() ^ true ? jsonElement2 : null;
                        if (jsonElement4 != null) {
                            chatSessionResponse = (ChatSessionResponse) TraeHttpConnection.INSTANCE.getHttpGson().fromJson(jsonElement4, ChatSessionResponse.class);
                            BizResponse bizResponse2 = new BizResponse(bizResponse.getCode(), bizResponse.getMsg(), bizResponse.getMessage(), bizResponse.getPayload(), chatSessionResponse, bizResponse.getActivityMessage());
                            bizResponse2.setupSuccessCodes(SUCCESS_CODES);
                            boolean z = jsonElement2 != null;
                            boolean z2 = jsonObject == null && jsonObject.has("sandbox");
                            if (jsonObject != null && (jsonElement = jsonObject.get("sandbox")) != null) {
                                str = jsonElement.toString();
                            }
                            return new ChatSessionRawParseResult(bizResponse2, z, z2, str);
                        }
                    }
                    chatSessionResponse = null;
                    BizResponse bizResponse22 = new BizResponse(bizResponse.getCode(), bizResponse.getMsg(), bizResponse.getMessage(), bizResponse.getPayload(), chatSessionResponse, bizResponse.getActivityMessage());
                    bizResponse22.setupSuccessCodes(SUCCESS_CODES);
                    if (jsonElement2 != null) {
                    }
                    if (jsonObject == null) {
                    }
                    if (jsonObject != null) {
                        str = jsonElement.toString();
                    }
                    return new ChatSessionRawParseResult(bizResponse22, z, z2, str);
                }
            }
            jsonObject = null;
            if (jsonElement2 != null) {
            }
            chatSessionResponse = null;
            BizResponse bizResponse222 = new BizResponse(bizResponse.getCode(), bizResponse.getMsg(), bizResponse.getMessage(), bizResponse.getPayload(), chatSessionResponse, bizResponse.getActivityMessage());
            bizResponse222.setupSuccessCodes(SUCCESS_CODES);
            if (jsonElement2 != null) {
            }
            if (jsonObject == null) {
            }
            if (jsonObject != null) {
            }
            return new ChatSessionRawParseResult(bizResponse222, z, z2, str);
        }

        public final BizResponse<Unit> parseWakeupSandboxRawBody$im_mainlandRelease(String bodyStr) {
            Intrinsics.checkNotNullParameter(bodyStr, "bodyStr");
            BizResponse bizResponse = (BizResponse) TraeHttpConnection.INSTANCE.getHttpGson().fromJson(bodyStr, TypeToken.getParameterized(BizResponse.class, new Type[]{JsonElement.class}).getType());
            BizResponse<Unit> bizResponse2 = new BizResponse<>(bizResponse.getCode(), bizResponse.getMsg(), bizResponse.getMessage(), bizResponse.getPayload(), (Object) null, bizResponse.getActivityMessage(), 16, (DefaultConstructorMarker) null);
            bizResponse2.setupSuccessCodes(SUCCESS_CODES);
            return bizResponse2;
        }

        public final Object getChatSessionRawCall(final String str, Continuation<? super HttpDataResult<ChatSessionResponse>> continuation) {
            return TraeHttpConnection.rawBizCall$default(TraeHttpConnection.INSTANCE, "chat_session", IChatSessionApi.class, "api/remote/v1/chat_sessions/" + str, getBASE_URL(), (Map) null, false, (Set) null, true, false, new Function2() { // from class: com.bytedance.trae.im.service.IChatSessionApi$Companion$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    BizResponse chatSessionRawCall$lambda$4;
                    chatSessionRawCall$lambda$4 = IChatSessionApi.Companion.getChatSessionRawCall$lambda$4((String) obj, (SsResponse) obj2);
                    return chatSessionRawCall$lambda$4;
                }
            }, new Function2() { // from class: com.bytedance.trae.im.service.IChatSessionApi$Companion$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Call chatSessionRawCall$lambda$5;
                    chatSessionRawCall$lambda$5 = IChatSessionApi.Companion.getChatSessionRawCall$lambda$5(str, (IChatSessionApi) obj, (RequestContext) obj2);
                    return chatSessionRawCall$lambda$5;
                }
            }, continuation, 368, (Object) null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final BizResponse getChatSessionRawCall$lambda$4(String str, SsResponse ssResponse) {
            Intrinsics.checkNotNullParameter(str, "body");
            Intrinsics.checkNotNullParameter(ssResponse, "<unused var>");
            return $$INSTANCE.parseChatSessionRawBody$im_mainlandRelease(str).getBizResp();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Call getChatSessionRawCall$lambda$5(String str, IChatSessionApi iChatSessionApi, RequestContext requestContext) {
            Intrinsics.checkNotNullParameter(iChatSessionApi, "$this$rawBizCall");
            Intrinsics.checkNotNullParameter(requestContext, "requestContext");
            return iChatSessionApi.getChatSessionRaw(str, requestContext);
        }

        public final Object wakeupSandboxRawCall(final String str, Continuation<? super HttpDataResult<Unit>> continuation) {
            return TraeHttpConnection.rawBizCall$default(TraeHttpConnection.INSTANCE, "chat_session", IChatSessionApi.class, (String) null, getBASE_URL(), (Map) null, false, (Set) null, true, false, new Function2() { // from class: com.bytedance.trae.im.service.IChatSessionApi$Companion$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    BizResponse wakeupSandboxRawCall$lambda$6;
                    wakeupSandboxRawCall$lambda$6 = IChatSessionApi.Companion.wakeupSandboxRawCall$lambda$6((String) obj, (SsResponse) obj2);
                    return wakeupSandboxRawCall$lambda$6;
                }
            }, new Function2() { // from class: com.bytedance.trae.im.service.IChatSessionApi$Companion$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Call wakeupSandboxRawCall$lambda$7;
                    wakeupSandboxRawCall$lambda$7 = IChatSessionApi.Companion.wakeupSandboxRawCall$lambda$7(str, (IChatSessionApi) obj, (RequestContext) obj2);
                    return wakeupSandboxRawCall$lambda$7;
                }
            }, continuation, 372, (Object) null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final BizResponse wakeupSandboxRawCall$lambda$6(String str, SsResponse ssResponse) {
            Intrinsics.checkNotNullParameter(str, "body");
            Intrinsics.checkNotNullParameter(ssResponse, "<unused var>");
            return $$INSTANCE.parseWakeupSandboxRawBody$im_mainlandRelease(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Call wakeupSandboxRawCall$lambda$7(String str, IChatSessionApi iChatSessionApi, RequestContext requestContext) {
            Intrinsics.checkNotNullParameter(iChatSessionApi, "$this$rawBizCall");
            Intrinsics.checkNotNullParameter(requestContext, "requestContext");
            return iChatSessionApi.wakeupSandboxRaw(str, requestContext);
        }
    }
}
