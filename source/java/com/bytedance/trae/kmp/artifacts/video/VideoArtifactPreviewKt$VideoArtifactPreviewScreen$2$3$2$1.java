package com.bytedance.trae.kmp.artifacts.video;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: VideoArtifactPreview.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewKt$VideoArtifactPreviewScreen$2$3$2$1", f = "VideoArtifactPreview.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
final class VideoArtifactPreviewKt$VideoArtifactPreviewScreen$2$3$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $onPlayerCreationFailed;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoArtifactPreviewKt$VideoArtifactPreviewScreen$2$3$2$1(Function0<Unit> function0, Continuation<? super VideoArtifactPreviewKt$VideoArtifactPreviewScreen$2$3$2$1> continuation) {
        super(2, continuation);
        this.$onPlayerCreationFailed = function0;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VideoArtifactPreviewKt$VideoArtifactPreviewScreen$2$3$2$1(this.$onPlayerCreationFailed, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.$onPlayerCreationFailed.invoke();
        return Unit.INSTANCE;
    }
}
