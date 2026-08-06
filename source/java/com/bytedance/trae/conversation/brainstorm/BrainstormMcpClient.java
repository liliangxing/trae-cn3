package com.bytedance.trae.conversation.brainstorm;

import android.util.Log;
import com.bytedance.sdk.account.api.OauthTokenTriggerScene;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.bytedance.tracing.log.Fields;
import com.bytedance.trae.im.service.ISendMessageService;
import com.bytedance.trae.im.service.SendMessageResponse;
import com.bytedance.trae.network.response.HttpDataResult;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* compiled from: BrainstormMcpClient.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u0000  2\u00020\u0001:\u0003\u001e\u001f B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0005H\u0002J \u0010\u0014\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0016H\u0082@¢\u0006\u0002\u0010\u0017J&\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010\u001bJ\u0006\u0010\u001c\u001a\u00020\u000fJ\u0006\u0010\u001d\u001a\u00020\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient;", "", "sessionManager", "Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;", "sessionId", "", "<init>", "(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;Ljava/lang/String;)V", "gson", "Lcom/google/gson/Gson;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "currentJob", "Lkotlinx/coroutines/Job;", "handleBotMessage", "", "botMessage", "parseRtcLlmRequest", "Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$RtcLlmRequest;", "json", "postMessage", "requestBody", "Lcom/google/gson/JsonObject;", "(Ljava/lang/String;Lcom/google/gson/JsonObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "subscribeSseAndForward", "messageId", "chatId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancel", "release", "RtcLlmRequest", "RtcSseEvent", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class BrainstormMcpClient {
    private static final String TAG = "BrainstormMcpClient";
    private Job currentJob;
    private final Gson gson;
    private final CoroutineScope scope;
    private final String sessionId;
    private final BMVoiceChatSessionManager sessionManager;

    public BrainstormMcpClient(BMVoiceChatSessionManager bMVoiceChatSessionManager, String str) {
        Intrinsics.checkNotNullParameter(bMVoiceChatSessionManager, "sessionManager");
        Intrinsics.checkNotNullParameter(str, "sessionId");
        this.sessionManager = bMVoiceChatSessionManager;
        this.sessionId = str;
        this.gson = new Gson();
        this.scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO()));
    }

    public final void handleBotMessage(String botMessage) {
        Intrinsics.checkNotNullParameter(botMessage, "botMessage");
        Job job = this.currentJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.currentJob = BuildersKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new BrainstormMcpClient$handleBotMessage$1(this, botMessage, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RtcLlmRequest parseRtcLlmRequest(String json) {
        try {
            return (RtcLlmRequest) this.gson.fromJson(json, RtcLlmRequest.class);
        } catch (Throwable th) {
            Log.e(TAG, "parseRtcLlmRequest failed: " + th.getMessage());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object postMessage(String str, JsonObject jsonObject, Continuation<? super String> continuation) {
        BrainstormMcpClient$postMessage$1 brainstormMcpClient$postMessage$1;
        int i;
        JsonElement jsonElement;
        JsonObject asJsonObject;
        JsonElement jsonElement2;
        HttpDataResult.Success success;
        if (continuation instanceof BrainstormMcpClient$postMessage$1) {
            brainstormMcpClient$postMessage$1 = (BrainstormMcpClient$postMessage$1) continuation;
            if ((brainstormMcpClient$postMessage$1.label & Integer.MIN_VALUE) != 0) {
                brainstormMcpClient$postMessage$1.label -= Integer.MIN_VALUE;
                Object obj = brainstormMcpClient$postMessage$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = brainstormMcpClient$postMessage$1.label;
                boolean z = true;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Iterable asJsonArray = jsonObject.getAsJsonArray("messages");
                    String asString = (asJsonArray == null || (jsonElement = (JsonElement) CollectionsKt.lastOrNull(asJsonArray)) == null || (asJsonObject = jsonElement.getAsJsonObject()) == null || (jsonElement2 = asJsonObject.get(ReportConstant.COMMON_CONTENT)) == null) ? null : jsonElement2.getAsString();
                    if (asString == null) {
                        asString = "";
                    }
                    ISendMessageService.Companion companion = ISendMessageService.INSTANCE;
                    BrainstormMcpClient$postMessage$result$1 brainstormMcpClient$postMessage$result$1 = new BrainstormMcpClient$postMessage$result$1(str, asString, null);
                    brainstormMcpClient$postMessage$1.label = 1;
                    obj = companion.safeCall(brainstormMcpClient$postMessage$result$1, brainstormMcpClient$postMessage$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                success = (HttpDataResult) obj;
                if (!(success instanceof HttpDataResult.Success)) {
                    HttpDataResult.Success success2 = success;
                    SendMessageResponse sendMessageResponse = (SendMessageResponse) success2.getBizResp().getData();
                    r4 = sendMessageResponse != null ? sendMessageResponse.getMessageId() : null;
                    String str2 = r4;
                    if (str2 != null && !StringsKt.isBlank(str2)) {
                        z = false;
                    }
                    if (z) {
                        Log.e(TAG, "postMessage: messageId is empty, resp=" + success2.getBizResp());
                    }
                } else {
                    if (!(success instanceof HttpDataResult.Error)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    HttpDataResult.Error error = (HttpDataResult.Error) success;
                    Log.e(TAG, "postMessage failed: code=" + error.getCode() + ", msg=" + error.getMsg(), error.getThrowable());
                }
                return r4;
            }
        }
        brainstormMcpClient$postMessage$1 = new BrainstormMcpClient$postMessage$1(this, continuation);
        Object obj2 = brainstormMcpClient$postMessage$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = brainstormMcpClient$postMessage$1.label;
        boolean z2 = true;
        if (i != 0) {
        }
        success = (HttpDataResult) obj2;
        if (!(success instanceof HttpDataResult.Success)) {
        }
        return r4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object subscribeSseAndForward(String str, String str2, String str3, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new BrainstormMcpClient$subscribeSseAndForward$2(str, str2, this, str3, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final void cancel() {
        Job job = this.currentJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.currentJob = null;
    }

    public final void release() {
        cancel();
        Job job = this.scope.getCoroutineContext().get(Job.Key);
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
    }

    /* compiled from: BrainstormMcpClient.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$RtcLlmRequest;", "", "chatId", "", "signature", OauthTokenTriggerScene.REQUEST, "Lcom/google/gson/JsonObject;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/google/gson/JsonObject;)V", "getChatId", "()Ljava/lang/String;", "getSignature", "getRequest", "()Lcom/google/gson/JsonObject;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class RtcLlmRequest {

        @SerializedName("chat_id")
        private final String chatId;

        @SerializedName(OauthTokenTriggerScene.REQUEST)
        private final JsonObject request;

        @SerializedName("signature")
        private final String signature;

        public RtcLlmRequest() {
            this(null, null, null, 7, null);
        }

        public static /* synthetic */ RtcLlmRequest copy$default(RtcLlmRequest rtcLlmRequest, String str, String str2, JsonObject jsonObject, int i, Object obj) {
            if ((i & 1) != 0) {
                str = rtcLlmRequest.chatId;
            }
            if ((i & 2) != 0) {
                str2 = rtcLlmRequest.signature;
            }
            if ((i & 4) != 0) {
                jsonObject = rtcLlmRequest.request;
            }
            return rtcLlmRequest.copy(str, str2, jsonObject);
        }

        /* renamed from: component1, reason: from getter */
        public final String getChatId() {
            return this.chatId;
        }

        /* renamed from: component2, reason: from getter */
        public final String getSignature() {
            return this.signature;
        }

        /* renamed from: component3, reason: from getter */
        public final JsonObject getRequest() {
            return this.request;
        }

        public final RtcLlmRequest copy(String chatId, String signature, JsonObject request) {
            return new RtcLlmRequest(chatId, signature, request);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RtcLlmRequest)) {
                return false;
            }
            RtcLlmRequest rtcLlmRequest = (RtcLlmRequest) other;
            return Intrinsics.areEqual(this.chatId, rtcLlmRequest.chatId) && Intrinsics.areEqual(this.signature, rtcLlmRequest.signature) && Intrinsics.areEqual(this.request, rtcLlmRequest.request);
        }

        public int hashCode() {
            String str = this.chatId;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.signature;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            JsonObject jsonObject = this.request;
            return hashCode2 + (jsonObject != null ? jsonObject.hashCode() : 0);
        }

        public String toString() {
            return "RtcLlmRequest(chatId=" + this.chatId + ", signature=" + this.signature + ", request=" + this.request + ')';
        }

        public RtcLlmRequest(String str, String str2, JsonObject jsonObject) {
            this.chatId = str;
            this.signature = str2;
            this.request = jsonObject;
        }

        public /* synthetic */ RtcLlmRequest(String str, String str2, JsonObject jsonObject, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : jsonObject);
        }

        public final String getChatId() {
            return this.chatId;
        }

        public final String getSignature() {
            return this.signature;
        }

        public final JsonObject getRequest() {
            return this.request;
        }
    }

    /* compiled from: BrainstormMcpClient.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$RtcSseEvent;", "", "chatId", "", Fields.EVENT, "data", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getChatId", "()Ljava/lang/String;", "getEvent", "getData", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class RtcSseEvent {

        @SerializedName("chat_id")
        private final String chatId;

        @SerializedName("data")
        private final String data;

        @SerializedName(Fields.EVENT)
        private final String event;

        public static /* synthetic */ RtcSseEvent copy$default(RtcSseEvent rtcSseEvent, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = rtcSseEvent.chatId;
            }
            if ((i & 2) != 0) {
                str2 = rtcSseEvent.event;
            }
            if ((i & 4) != 0) {
                str3 = rtcSseEvent.data;
            }
            return rtcSseEvent.copy(str, str2, str3);
        }

        /* renamed from: component1, reason: from getter */
        public final String getChatId() {
            return this.chatId;
        }

        /* renamed from: component2, reason: from getter */
        public final String getEvent() {
            return this.event;
        }

        /* renamed from: component3, reason: from getter */
        public final String getData() {
            return this.data;
        }

        public final RtcSseEvent copy(String chatId, String event, String data) {
            Intrinsics.checkNotNullParameter(chatId, "chatId");
            Intrinsics.checkNotNullParameter(event, Fields.EVENT);
            Intrinsics.checkNotNullParameter(data, "data");
            return new RtcSseEvent(chatId, event, data);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RtcSseEvent)) {
                return false;
            }
            RtcSseEvent rtcSseEvent = (RtcSseEvent) other;
            return Intrinsics.areEqual(this.chatId, rtcSseEvent.chatId) && Intrinsics.areEqual(this.event, rtcSseEvent.event) && Intrinsics.areEqual(this.data, rtcSseEvent.data);
        }

        public int hashCode() {
            return (((this.chatId.hashCode() * 31) + this.event.hashCode()) * 31) + this.data.hashCode();
        }

        public String toString() {
            return "RtcSseEvent(chatId=" + this.chatId + ", event=" + this.event + ", data=" + this.data + ')';
        }

        public RtcSseEvent(String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, "chatId");
            Intrinsics.checkNotNullParameter(str2, Fields.EVENT);
            Intrinsics.checkNotNullParameter(str3, "data");
            this.chatId = str;
            this.event = str2;
            this.data = str3;
        }

        public final String getChatId() {
            return this.chatId;
        }

        public final String getEvent() {
            return this.event;
        }

        public final String getData() {
            return this.data;
        }
    }
}
