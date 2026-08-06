package com.bytedance.trae.conversation.products;

import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: ArtifactPreviewActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.products.ArtifactPreviewActivity$loadMarkdownPreview$1$content$1", f = "ArtifactPreviewActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
final class ArtifactPreviewActivity$loadMarkdownPreview$1$content$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ String $fileUrl;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ArtifactPreviewActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArtifactPreviewActivity$loadMarkdownPreview$1$content$1(ArtifactPreviewActivity artifactPreviewActivity, String str, Continuation<? super ArtifactPreviewActivity$loadMarkdownPreview$1$content$1> continuation) {
        super(2, continuation);
        this.this$0 = artifactPreviewActivity;
        this.$fileUrl = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> artifactPreviewActivity$loadMarkdownPreview$1$content$1 = new ArtifactPreviewActivity$loadMarkdownPreview$1$content$1(this.this$0, this.$fileUrl, continuation);
        artifactPreviewActivity$loadMarkdownPreview$1$content$1.L$0 = obj;
        return artifactPreviewActivity$loadMarkdownPreview$1$content$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        String fetchTextViaTTNet;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        ArtifactPreviewActivity artifactPreviewActivity = this.this$0;
        String str = this.$fileUrl;
        try {
            Result.Companion companion = Result.Companion;
            fetchTextViaTTNet = artifactPreviewActivity.fetchTextViaTTNet(str);
            obj2 = Result.constructor-impl(fetchTextViaTTNet);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj2 = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj2)) {
            return null;
        }
        return obj2;
    }
}
