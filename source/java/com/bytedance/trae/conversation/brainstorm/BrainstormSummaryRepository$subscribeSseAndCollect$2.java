package com.bytedance.trae.conversation.brainstorm;

import android.util.Log;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Response;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.im.service.ISendMessageService;
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
/* compiled from: BrainstormSummaryRepository.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.brainstorm.BrainstormSummaryRepository$subscribeSseAndCollect$2", f = "BrainstormSummaryRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class BrainstormSummaryRepository$subscribeSseAndCollect$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ String $messageId;
    final /* synthetic */ Function1<String, Unit> $onChunk;
    final /* synthetic */ String $sessionId;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ BrainstormSummaryRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public BrainstormSummaryRepository$subscribeSseAndCollect$2(String str, String str2, BrainstormSummaryRepository brainstormSummaryRepository, Function1<? super String, Unit> function1, Continuation<? super BrainstormSummaryRepository$subscribeSseAndCollect$2> continuation) {
        super(2, continuation);
        this.$sessionId = str;
        this.$messageId = str2;
        this.this$0 = brainstormSummaryRepository;
        this.$onChunk = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> brainstormSummaryRepository$subscribeSseAndCollect$2 = new BrainstormSummaryRepository$subscribeSseAndCollect$2(this.$sessionId, this.$messageId, this.this$0, this.$onChunk, continuation);
        brainstormSummaryRepository$subscribeSseAndCollect$2.L$0 = obj;
        return brainstormSummaryRepository$subscribeSseAndCollect$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        String extractTextFromEvent;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        final CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        Call<Response> subscribeSseEvents = ISendMessageService.INSTANCE.createService(MapsKt.mapOf(TuplesKt.to("Accept", "text/event-stream"))).subscribeSseEvents(this.$sessionId, this.$messageId);
        try {
            SsResponse execute = subscribeSseEvents.execute();
            if (!execute.isSuccessful()) {
                Log.e("BrainstormSummaryRepo", "subscribeSse failed: " + execute.code());
                return null;
            }
            TypedInput body = execute.raw().getBody();
            if (body == null) {
                Log.e("BrainstormSummaryRepo", "subscribeSse: response body is null");
                return null;
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(body.in(), Charsets.UTF_8));
            final StringBuilder sb = new StringBuilder();
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = "";
            final StringBuilder sb2 = new StringBuilder();
            final BrainstormSummaryRepository brainstormSummaryRepository = this.this$0;
            final Function1<String, Unit> function1 = this.$onChunk;
            TextStreamsKt.forEachLine(bufferedReader, new Function1() { // from class: com.bytedance.trae.conversation.brainstorm.BrainstormSummaryRepository$subscribeSseAndCollect$2$$ExternalSyntheticLambda0
                public final Object invoke(Object obj2) {
                    Unit invokeSuspend$lambda$1;
                    invokeSuspend$lambda$1 = BrainstormSummaryRepository$subscribeSseAndCollect$2.invokeSuspend$lambda$1(coroutineScope, objectRef, sb2, brainstormSummaryRepository, sb, function1, (String) obj2);
                    return invokeSuspend$lambda$1;
                }
            });
            if (sb2.length() > 0) {
                BrainstormSummaryRepository brainstormSummaryRepository2 = this.this$0;
                String str = (String) objectRef.element;
                String sb3 = sb2.toString();
                Intrinsics.checkNotNullExpressionValue(sb3, "toString(...)");
                extractTextFromEvent = brainstormSummaryRepository2.extractTextFromEvent(str, sb3);
                if (extractTextFromEvent != null) {
                    sb.append(extractTextFromEvent);
                    Function1<String, Unit> function12 = this.$onChunk;
                    if (function12 != null) {
                        String sb4 = sb.toString();
                        Intrinsics.checkNotNullExpressionValue(sb4, "toString(...)");
                        function12.invoke(sb4);
                    }
                }
            }
            return sb.toString();
        } catch (CancellationException unused) {
            Log.d("BrainstormSummaryRepo", "SSE subscription cancelled");
            subscribeSseEvents.cancel();
            return null;
        } catch (Throwable th) {
            Log.e("BrainstormSummaryRepo", "subscribeSse error", th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$1(CoroutineScope coroutineScope, Ref.ObjectRef objectRef, StringBuilder sb, BrainstormSummaryRepository brainstormSummaryRepository, StringBuilder sb2, Function1 function1, String str) {
        String extractTextFromEvent;
        if (!CoroutineScopeKt.isActive(coroutineScope)) {
            return Unit.INSTANCE;
        }
        if (StringsKt.startsWith$default(str, "event:", false, 2, (Object) null)) {
            objectRef.element = StringsKt.trim(StringsKt.removePrefix(str, "event:")).toString();
        } else {
            if (StringsKt.startsWith$default(str, "data:", false, 2, (Object) null)) {
                if ((sb.length() > 0 ? 1 : 0) != 0) {
                    sb.append("\n");
                }
                sb.append(StringsKt.trim(StringsKt.removePrefix(str, "data:")).toString());
            } else if (StringsKt.isBlank(str)) {
                if (sb.length() > 0) {
                    String str2 = (String) objectRef.element;
                    String sb3 = sb.toString();
                    Intrinsics.checkNotNullExpressionValue(sb3, "toString(...)");
                    extractTextFromEvent = brainstormSummaryRepository.extractTextFromEvent(str2, sb3);
                    if (extractTextFromEvent != null) {
                        sb2.append(extractTextFromEvent);
                        if (function1 != null) {
                            String sb4 = sb2.toString();
                            Intrinsics.checkNotNullExpressionValue(sb4, "toString(...)");
                            function1.invoke(sb4);
                        }
                    }
                    Log.d("BrainstormSummaryRepo", "SSE event: type=" + ((String) objectRef.element) + ", chunkLen=" + (extractTextFromEvent != null ? extractTextFromEvent.length() : 0));
                    objectRef.element = "";
                    StringsKt.clear(sb);
                }
            }
        }
        return Unit.INSTANCE;
    }
}
