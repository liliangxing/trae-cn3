package com.bytedance.trae.kmp.artifacts.video;

import com.bytedance.trae.kmp.artifacts.artifact.ArtifactResourceResult;
import com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewState;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VideoArtifactPreviewViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewViewModel$prepare$1", f = "VideoArtifactPreviewViewModel.kt", i = {}, l = {237, 245}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class VideoArtifactPreviewViewModel$prepare$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ VideoArtifactPreviewViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoArtifactPreviewViewModel$prepare$1(VideoArtifactPreviewViewModel videoArtifactPreviewViewModel, Continuation<? super VideoArtifactPreviewViewModel$prepare$1> continuation) {
        super(2, continuation);
        this.this$0 = videoArtifactPreviewViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VideoArtifactPreviewViewModel$prepare$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        MutableStateFlow mutableStateFlow;
        Function1 function1;
        MutableStateFlow mutableStateFlow2;
        Object handleReady;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                function1 = this.this$0.prepareOriginal;
                this.label = 1;
                obj = function1.invoke(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
            }
            ArtifactResourceResult artifactResourceResult = (ArtifactResourceResult) obj;
            if (artifactResourceResult instanceof ArtifactResourceResult.Ready) {
                this.label = 2;
                handleReady = this.this$0.handleReady((ArtifactResourceResult.Ready) artifactResourceResult, (Continuation) this);
                if (handleReady == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (artifactResourceResult instanceof ArtifactResourceResult.Failed) {
                mutableStateFlow2 = this.this$0._state;
                mutableStateFlow2.setValue(new VideoArtifactPreviewState.Failed(-1));
            } else {
                throw new NoWhenBranchMatchedException();
            }
            return Unit.INSTANCE;
        } catch (CancellationException e) {
            throw e;
        } catch (Throwable unused) {
            mutableStateFlow = this.this$0._state;
            mutableStateFlow.setValue(new VideoArtifactPreviewState.Failed(-1));
            return Unit.INSTANCE;
        }
    }
}
