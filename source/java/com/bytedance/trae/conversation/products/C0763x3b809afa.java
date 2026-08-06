package com.bytedance.trae.conversation.products;

import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HtmlArtifactRemoteArchiveUrlResolver.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.products.HtmlArtifactRemoteArchiveUrlResolver$wakeupSandboxAndWaitForReady$2", f = "HtmlArtifactRemoteArchiveUrlResolver.kt", i = {0}, l = {148, 149}, m = "invokeSuspend", n = {"ready"}, s = {"L$0"})
/* renamed from: com.bytedance.trae.conversation.products.HtmlArtifactRemoteArchiveUrlResolver$wakeupSandboxAndWaitForReady$2 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class C0763x3b809afa extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $chatSessionId;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ HtmlArtifactRemoteArchiveUrlResolver this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0763x3b809afa(HtmlArtifactRemoteArchiveUrlResolver htmlArtifactRemoteArchiveUrlResolver, String str, Continuation<? super C0763x3b809afa> continuation) {
        super(2, continuation);
        this.this$0 = htmlArtifactRemoteArchiveUrlResolver;
        this.$chatSessionId = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> c0763x3b809afa = new C0763x3b809afa(this.this$0, this.$chatSessionId, continuation);
        c0763x3b809afa.L$0 = obj;
        return c0763x3b809afa;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Deferred async$default;
        Object wakeupSandbox;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            async$default = BuildersKt.async$default((CoroutineScope) this.L$0, (CoroutineContext) null, CoroutineStart.UNDISPATCHED, new C0764x8d2b51c6(this.this$0, this.$chatSessionId, null), 1, (Object) null);
            this.L$0 = async$default;
            this.label = 1;
            wakeupSandbox = this.this$0.wakeupSandbox(this.$chatSessionId, (Continuation) this);
            if (wakeupSandbox == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                if (i == 2) {
                    ResultKt.throwOnFailure(obj);
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            async$default = (Deferred) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        this.L$0 = null;
        this.label = 2;
        obj = async$default.await((Continuation) this);
        return obj == coroutine_suspended ? coroutine_suspended : obj;
    }
}
