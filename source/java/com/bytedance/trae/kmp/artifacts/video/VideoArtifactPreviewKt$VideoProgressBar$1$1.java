package com.bytedance.trae.kmp.artifacts.video;

import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VideoArtifactPreview.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class VideoArtifactPreviewKt$VideoProgressBar$1$1 implements PointerInputEventHandler {
    final /* synthetic */ long $durationMs;
    final /* synthetic */ Function1<Long, Unit> $onSeek;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public VideoArtifactPreviewKt$VideoProgressBar$1$1(Function1<? super Long, Unit> function1, long j) {
        this.$onSeek = function1;
        this.$durationMs = j;
    }

    public final Object invoke(final PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        final Function1<Long, Unit> function1 = this.$onSeek;
        final long j = this.$durationMs;
        Object detectTapGestures$default = TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, (Function1) null, (Function1) null, (Function3) null, new Function1() { // from class: com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewKt$VideoProgressBar$1$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit invoke$lambda$0;
                invoke$lambda$0 = VideoArtifactPreviewKt$VideoProgressBar$1$1.invoke$lambda$0(function1, pointerInputScope, j, (Offset) obj);
                return invoke$lambda$0;
            }
        }, continuation, 7, (Object) null);
        return detectTapGestures$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? detectTapGestures$default : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$0(Function1 function1, PointerInputScope pointerInputScope, long j, Offset offset) {
        long VideoProgressBar$targetFor;
        VideoProgressBar$targetFor = VideoArtifactPreviewKt.VideoProgressBar$targetFor(j, Float.intBitsToFloat((int) (offset.unbox-impl() >> 32)), (int) (pointerInputScope.getSize-YbymL2g() >> 32));
        function1.invoke(Long.valueOf(VideoProgressBar$targetFor));
        return Unit.INSTANCE;
    }
}
