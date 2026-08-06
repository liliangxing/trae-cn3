package com.bytedance.trae.conversation.brainstorm;

import android.util.Log;
import com.bytedance.sdk.account.api.OauthTokenTriggerScene;
import com.bytedance.trae.conversation.brainstorm.BrainstormMcpClient;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.conversation.voice.VoiceChatApiPaths;
import com.google.gson.JsonObject;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: BrainstormMcpClient.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.brainstorm.BrainstormMcpClient$handleBotMessage$1", f = "BrainstormMcpClient.kt", i = {0}, l = {77, 84}, m = "invokeSuspend", n = {OauthTokenTriggerScene.REQUEST}, s = {"L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
final class BrainstormMcpClient$handleBotMessage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $botMessage;
    Object L$0;
    int label;
    final /* synthetic */ BrainstormMcpClient this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BrainstormMcpClient$handleBotMessage$1(BrainstormMcpClient brainstormMcpClient, String str, Continuation<? super BrainstormMcpClient$handleBotMessage$1> continuation) {
        super(2, continuation);
        this.this$0 = brainstormMcpClient;
        this.$botMessage = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BrainstormMcpClient$handleBotMessage$1(this.this$0, this.$botMessage, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x008a A[Catch: all -> 0x001a, CancellationException -> 0x010a, TryCatch #2 {CancellationException -> 0x010a, all -> 0x001a, blocks: (B:6:0x0015, B:13:0x0029, B:14:0x00cc, B:16:0x00d0, B:18:0x00d8, B:21:0x00f6, B:25:0x0031, B:27:0x003b, B:29:0x0043, B:31:0x005c, B:32:0x0064, B:34:0x007e, B:39:0x008a, B:41:0x0092, B:43:0x00ad, B:45:0x00b5), top: B:2:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0092 A[Catch: all -> 0x001a, CancellationException -> 0x010a, TryCatch #2 {CancellationException -> 0x010a, all -> 0x001a, blocks: (B:6:0x0015, B:13:0x0029, B:14:0x00cc, B:16:0x00d0, B:18:0x00d8, B:21:0x00f6, B:25:0x0031, B:27:0x003b, B:29:0x0043, B:31:0x005c, B:32:0x0064, B:34:0x007e, B:39:0x008a, B:41:0x0092, B:43:0x00ad, B:45:0x00b5), top: B:2:0x000f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        BrainstormMcpClient.RtcLlmRequest parseRtcLlmRequest;
        boolean z;
        BMVoiceChatSessionManager bMVoiceChatSessionManager;
        String str;
        Object postMessage;
        BrainstormMcpClient.RtcLlmRequest rtcLlmRequest;
        String str2;
        Object subscribeSseAndForward;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
        } catch (CancellationException unused) {
            Log.d("BrainstormMcpClient", "handleBotMessage cancelled");
        } catch (Throwable th) {
            Log.e("BrainstormMcpClient", "handleBotMessage error", th);
        }
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            parseRtcLlmRequest = this.this$0.parseRtcLlmRequest(this.$botMessage);
            if (parseRtcLlmRequest == null) {
                Log.e("BrainstormMcpClient", "handleBotMessage: failed to parse RTCLLMRequest");
                return Unit.INSTANCE;
            }
            StringBuilder append = new StringBuilder("handleBotMessage: chat_id=").append(parseRtcLlmRequest.getChatId()).append(", signature=");
            String signature = parseRtcLlmRequest.getSignature();
            Log.d("BrainstormMcpClient", append.append(signature != null ? StringsKt.take(signature, 20) : null).append("...").toString());
            String signature2 = parseRtcLlmRequest.getSignature();
            String str3 = signature2;
            if (str3 != null && !StringsKt.isBlank(str3)) {
                z = false;
                if (z) {
                    bMVoiceChatSessionManager = this.this$0.sessionManager;
                    bMVoiceChatSessionManager.setServerParams(signature2, VoiceChatApiPaths.INSTANCE.getHOST());
                    Log.d("BrainstormMcpClient", "setServerParams done");
                    JsonObject request = parseRtcLlmRequest.getRequest();
                    if (request == null) {
                        Log.e("BrainstormMcpClient", "handleBotMessage: request body is null");
                        return Unit.INSTANCE;
                    }
                    BrainstormMcpClient brainstormMcpClient = this.this$0;
                    str = brainstormMcpClient.sessionId;
                    this.L$0 = parseRtcLlmRequest;
                    this.label = 1;
                    postMessage = brainstormMcpClient.postMessage(str, request, (Continuation) this);
                    if (postMessage == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    rtcLlmRequest = parseRtcLlmRequest;
                    obj = postMessage;
                } else {
                    Log.e("BrainstormMcpClient", "handleBotMessage: signature is empty, skip setServerParams");
                    return Unit.INSTANCE;
                }
            }
            z = true;
            if (z) {
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            rtcLlmRequest = (BrainstormMcpClient.RtcLlmRequest) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        String str4 = (String) obj;
        if (str4 == null) {
            Log.e("BrainstormMcpClient", "handleBotMessage: POST /messages failed");
            return Unit.INSTANCE;
        }
        Log.d("BrainstormMcpClient", "POST /messages success: messageId=" + str4);
        BrainstormMcpClient brainstormMcpClient2 = this.this$0;
        str2 = brainstormMcpClient2.sessionId;
        String chatId = rtcLlmRequest.getChatId();
        if (chatId == null) {
            chatId = "";
        }
        this.L$0 = null;
        this.label = 2;
        subscribeSseAndForward = brainstormMcpClient2.subscribeSseAndForward(str2, str4, chatId, (Continuation) this);
        if (subscribeSseAndForward == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
