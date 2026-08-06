package com.bytedance.trae.conversation.products;

import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* compiled from: HtmlArtifactRemoteArchiveUrlResolver.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "statusUpdate", "Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatusUpdate;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.products.HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1$update$1", f = "HtmlArtifactRemoteArchiveUrlResolver.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* renamed from: com.bytedance.trae.conversation.products.HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1$update$1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
final class C0762xc0a52683 extends SuspendLambda implements Function2<RealtimeSandboxStatusUpdate, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $chatSessionId;
    final /* synthetic */ Ref.ObjectRef<RealtimeSandboxStatusUpdate> $lastAnyUpdate;
    final /* synthetic */ Ref.ObjectRef<RealtimeSandboxStatusUpdate> $lastMatchingUpdate;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ HtmlArtifactRemoteArchiveUrlResolver this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0762xc0a52683(Ref.ObjectRef<RealtimeSandboxStatusUpdate> objectRef, String str, Ref.ObjectRef<RealtimeSandboxStatusUpdate> objectRef2, HtmlArtifactRemoteArchiveUrlResolver htmlArtifactRemoteArchiveUrlResolver, Continuation<? super C0762xc0a52683> continuation) {
        super(2, continuation);
        this.$lastAnyUpdate = objectRef;
        this.$chatSessionId = str;
        this.$lastMatchingUpdate = objectRef2;
        this.this$0 = htmlArtifactRemoteArchiveUrlResolver;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> c0762xc0a52683 = new C0762xc0a52683(this.$lastAnyUpdate, this.$chatSessionId, this.$lastMatchingUpdate, this.this$0, continuation);
        c0762xc0a52683.L$0 = obj;
        return c0762xc0a52683;
    }

    public final Object invoke(RealtimeSandboxStatusUpdate realtimeSandboxStatusUpdate, Continuation<? super Unit> continuation) {
        return create(realtimeSandboxStatusUpdate, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        String describeForLog;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        RealtimeSandboxStatusUpdate realtimeSandboxStatusUpdate = (RealtimeSandboxStatusUpdate) this.L$0;
        this.$lastAnyUpdate.element = realtimeSandboxStatusUpdate;
        boolean matches = realtimeSandboxStatusUpdate.matches(this.$chatSessionId);
        if (matches) {
            this.$lastMatchingUpdate.element = realtimeSandboxStatusUpdate;
        }
        HtmlArtifactRemoteArchiveUrlResolver htmlArtifactRemoteArchiveUrlResolver = this.this$0;
        StringBuilder append = new StringBuilder("ws sandbox status update: waitingChatSessionId=").append(this.$chatSessionId).append(", matches=").append(matches).append(", ");
        describeForLog = this.this$0.describeForLog(realtimeSandboxStatusUpdate);
        htmlArtifactRemoteArchiveUrlResolver.logD(append.append(describeForLog).toString());
        return Unit.INSTANCE;
    }
}
