package com.bytedance.trae.kmp.artifacts.video;

import com.bytedance.trae.kmp.artifacts.artifact.AndroidArtifactRepositoryProvider;
import com.bytedance.trae.kmp.artifacts.artifact.ArtifactOpenRequest;
import com.bytedance.trae.kmp.artifacts.artifact.ArtifactRendition;
import com.bytedance.trae.kmp.artifacts.artifact.ArtifactRepository;
import com.bytedance.trae.kmp.artifacts.artifact.ArtifactResourceRequest;
import com.bytedance.trae.kmp.artifacts.artifact.ArtifactResourceResult;
import com.bytedance.trae.kmp.artifacts.artifact.ArtifactSource;
import com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewActivity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* compiled from: VideoArtifactPreviewActivity.kt */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceResult;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewActivity$VideoArtifactPreviewViewModelFactory$create$1", f = "VideoArtifactPreviewActivity.kt", i = {}, l = {108}, m = "invokeSuspend", n = {}, s = {})
/* renamed from: com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewActivity$VideoArtifactPreviewViewModelFactory$create$1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
final class C0795xe59bdd2 extends SuspendLambda implements Function1<Continuation<? super ArtifactResourceResult>, Object> {
    int label;
    final /* synthetic */ VideoArtifactPreviewActivity.VideoArtifactPreviewViewModelFactory this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0795xe59bdd2(VideoArtifactPreviewActivity.VideoArtifactPreviewViewModelFactory videoArtifactPreviewViewModelFactory, Continuation<? super C0795xe59bdd2> continuation) {
        super(1, continuation);
        this.this$0 = videoArtifactPreviewViewModelFactory;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new C0795xe59bdd2(this.this$0, continuation);
    }

    public final Object invoke(Continuation<? super ArtifactResourceResult> continuation) {
        return create(continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        ArtifactOpenRequest artifactOpenRequest;
        ArtifactOpenRequest artifactOpenRequest2;
        ArtifactOpenRequest artifactOpenRequest3;
        ArtifactOpenRequest artifactOpenRequest4;
        ArtifactOpenRequest artifactOpenRequest5;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ArtifactRepository repository = AndroidArtifactRepositoryProvider.INSTANCE.getRepository();
            artifactOpenRequest = this.this$0.request;
            ArtifactSource source = artifactOpenRequest.getSource();
            artifactOpenRequest2 = this.this$0.request;
            String cliConversationId = artifactOpenRequest2.getCliConversationId();
            artifactOpenRequest3 = this.this$0.request;
            String conversationId = artifactOpenRequest3.getConversationId();
            artifactOpenRequest4 = this.this$0.request;
            String messageId = artifactOpenRequest4.getMessageId();
            artifactOpenRequest5 = this.this$0.request;
            this.label = 1;
            obj = repository.prepare(new ArtifactResourceRequest(source, cliConversationId, conversationId, messageId, artifactOpenRequest5.getFilePath(), ArtifactRendition.Original), (Continuation) this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return obj;
    }
}
