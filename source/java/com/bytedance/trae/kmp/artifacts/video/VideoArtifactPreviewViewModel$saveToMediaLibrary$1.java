package com.bytedance.trae.kmp.artifacts.video;

import com.bytedance.memory.shrink.HprofMemoryConstants;
import com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewState;
import com.bytedance.trae.kmp.host.KmpMediaLibrary;
import com.bytedance.trae.kmp.host.KmpMediaLibrarySaveResult;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: VideoArtifactPreviewViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewViewModel$saveToMediaLibrary$1", f = "VideoArtifactPreviewViewModel.kt", i = {}, l = {HprofMemoryConstants.HPROF_HEAPDUMP_ROOT_JNI_MONITOR}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
final class VideoArtifactPreviewViewModel$saveToMediaLibrary$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<KmpMediaLibrarySaveResult, Unit> $onComplete;
    final /* synthetic */ VideoArtifactPreviewState.Ready $ready;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ VideoArtifactPreviewViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public VideoArtifactPreviewViewModel$saveToMediaLibrary$1(Function1<? super KmpMediaLibrarySaveResult, Unit> function1, VideoArtifactPreviewState.Ready ready, VideoArtifactPreviewViewModel videoArtifactPreviewViewModel, Continuation<? super VideoArtifactPreviewViewModel$saveToMediaLibrary$1> continuation) {
        super(2, continuation);
        this.$onComplete = function1;
        this.$ready = ready;
        this.this$0 = videoArtifactPreviewViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VideoArtifactPreviewViewModel$saveToMediaLibrary$1(this.$onComplete, this.$ready, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Function1<KmpMediaLibrarySaveResult, Unit> function1;
        Throwable th;
        Function1<KmpMediaLibrarySaveResult, Unit> function12;
        KmpMediaLibrarySaveResult kmpMediaLibrarySaveResult;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Function1<KmpMediaLibrarySaveResult, Unit> function13 = this.$onComplete;
                try {
                    this.L$0 = function13;
                    this.L$1 = function13;
                    this.label = 1;
                    Object saveLocalFile = KmpMediaLibrary.INSTANCE.saveLocalFile(this.$ready.getLocalSource(), this.this$0.getRequest().getTitle(), "video/mp4", (Continuation) this);
                    if (saveLocalFile == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    function12 = function13;
                    obj = saveLocalFile;
                    function1 = function12;
                } catch (Throwable th2) {
                    function1 = function13;
                    th = th2;
                    kmpMediaLibrarySaveResult = new KmpMediaLibrarySaveResult(false, th.getMessage());
                    function12 = function1;
                    function12.invoke(kmpMediaLibrarySaveResult);
                    return Unit.INSTANCE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                function12 = (Function1) this.L$1;
                function1 = (Function1) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (Throwable th3) {
                    th = th3;
                    kmpMediaLibrarySaveResult = new KmpMediaLibrarySaveResult(false, th.getMessage());
                    function12 = function1;
                    function12.invoke(kmpMediaLibrarySaveResult);
                    return Unit.INSTANCE;
                }
            }
            kmpMediaLibrarySaveResult = (KmpMediaLibrarySaveResult) obj;
            function12.invoke(kmpMediaLibrarySaveResult);
            return Unit.INSTANCE;
        } catch (CancellationException e) {
            throw e;
        }
    }
}
