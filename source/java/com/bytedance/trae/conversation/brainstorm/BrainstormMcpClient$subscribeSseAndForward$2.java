package com.bytedance.trae.conversation.brainstorm;

import android.util.Log;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Response;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.trae.conversation.brainstorm.BrainstormMcpClient;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.im.service.ISendMessageService;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BrainstormMcpClient.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.brainstorm.BrainstormMcpClient$subscribeSseAndForward$2", f = "BrainstormMcpClient.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class BrainstormMcpClient$subscribeSseAndForward$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $chatId;
    final /* synthetic */ String $messageId;
    final /* synthetic */ String $sessionId;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ BrainstormMcpClient this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BrainstormMcpClient$subscribeSseAndForward$2(String str, String str2, BrainstormMcpClient brainstormMcpClient, String str3, Continuation<? super BrainstormMcpClient$subscribeSseAndForward$2> continuation) {
        super(2, continuation);
        this.$sessionId = str;
        this.$messageId = str2;
        this.this$0 = brainstormMcpClient;
        this.$chatId = str3;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> brainstormMcpClient$subscribeSseAndForward$2 = new BrainstormMcpClient$subscribeSseAndForward$2(this.$sessionId, this.$messageId, this.this$0, this.$chatId, continuation);
        brainstormMcpClient$subscribeSseAndForward$2.L$0 = obj;
        return brainstormMcpClient$subscribeSseAndForward$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        SsResponse execute;
        Gson gson;
        BMVoiceChatSessionManager bMVoiceChatSessionManager;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        final CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        Call<Response> subscribeSseEvents = ISendMessageService.INSTANCE.createService(MapsKt.mapOf(TuplesKt.to("Accept", "text/event-stream"))).subscribeSseEvents(this.$sessionId, this.$messageId);
        try {
            execute = subscribeSseEvents.execute();
        } catch (CancellationException unused) {
            Log.d("BrainstormMcpClient", "SSE subscription cancelled");
            subscribeSseEvents.cancel();
        } catch (Throwable th) {
            Log.e("BrainstormMcpClient", "subscribeSse error", th);
        }
        if (!execute.isSuccessful()) {
            Log.e("BrainstormMcpClient", "subscribeSse failed: " + execute.code());
            return Unit.INSTANCE;
        }
        TypedInput body = execute.raw().getBody();
        if (body == null) {
            Log.e("BrainstormMcpClient", "subscribeSse: response body is null");
            return Unit.INSTANCE;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(body.in(), Charsets.UTF_8));
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = "";
        final StringBuilder sb = new StringBuilder();
        final BrainstormMcpClient brainstormMcpClient = this.this$0;
        final String str = this.$chatId;
        TextStreamsKt.forEachLine(bufferedReader, new Function1() { // from class: com.bytedance.trae.conversation.brainstorm.BrainstormMcpClient$subscribeSseAndForward$2$$ExternalSyntheticLambda0
            public final Object invoke(Object obj2) {
                Unit invokeSuspend$lambda$1;
                invokeSuspend$lambda$1 = BrainstormMcpClient$subscribeSseAndForward$2.invokeSuspend$lambda$1(coroutineScope, objectRef, sb, brainstormMcpClient, str, (String) obj2);
                return invokeSuspend$lambda$1;
            }
        });
        if (sb.length() > 0) {
            gson = this.this$0.gson;
            String str2 = this.$chatId;
            String str3 = (String) objectRef.element;
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
            String json = gson.toJson(new BrainstormMcpClient.RtcSseEvent(str2, str3, sb2));
            bMVoiceChatSessionManager = this.this$0.sessionManager;
            Intrinsics.checkNotNull(json);
            bMVoiceChatSessionManager.sendServerMessage(json);
            Log.d("BrainstormMcpClient", "forwarded final SSE event: type=" + ((String) objectRef.element));
        }
        Log.d("BrainstormMcpClient", "SSE stream completed for chatId=" + this.$chatId);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$1(CoroutineScope coroutineScope, Ref.ObjectRef objectRef, StringBuilder sb, BrainstormMcpClient brainstormMcpClient, String str, String str2) {
        Gson gson;
        BMVoiceChatSessionManager bMVoiceChatSessionManager;
        if (!CoroutineScopeKt.isActive(coroutineScope)) {
            return Unit.INSTANCE;
        }
        if (StringsKt.startsWith$default(str2, "event:", false, 2, (Object) null)) {
            objectRef.element = StringsKt.trim(StringsKt.removePrefix(str2, "event:")).toString();
        } else if (StringsKt.startsWith$default(str2, "data:", false, 2, (Object) null)) {
            if (sb.length() > 0) {
                sb.append("\n");
            }
            sb.append(StringsKt.trim(StringsKt.removePrefix(str2, "data:")).toString());
        } else if (StringsKt.isBlank(str2)) {
            if (sb.length() > 0) {
                gson = brainstormMcpClient.gson;
                String str3 = (String) objectRef.element;
                String sb2 = sb.toString();
                Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
                String json = gson.toJson(new BrainstormMcpClient.RtcSseEvent(str, str3, sb2));
                bMVoiceChatSessionManager = brainstormMcpClient.sessionManager;
                Intrinsics.checkNotNull(json);
                bMVoiceChatSessionManager.sendServerMessage(json);
                Log.d("BrainstormMcpClient", "forwarded SSE event: type=" + ((String) objectRef.element) + ", length=" + sb.length());
                objectRef.element = "";
                StringsKt.clear(sb);
            }
        }
        return Unit.INSTANCE;
    }
}
