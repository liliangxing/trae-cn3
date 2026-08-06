package com.bytedance.trae.kmp.artifacts.video;

import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import com.bytedance.trae.login.activity.PhoneBindActivity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VideoArtifactPreview.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class VideoArtifactPreviewKt$VideoProgressBar$2$1 implements PointerInputEventHandler {
    final /* synthetic */ long $durationMs;
    final /* synthetic */ Function1<Long, Unit> $onDragPosition;
    final /* synthetic */ Function1<Long, Unit> $onSeek;
    final /* synthetic */ MutableState<Long> $pendingSeekMs$delegate;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public VideoArtifactPreviewKt$VideoProgressBar$2$1(Function1<? super Long, Unit> function1, long j, MutableState<Long> mutableState, Function1<? super Long, Unit> function12) {
        this.$onDragPosition = function1;
        this.$durationMs = j;
        this.$pendingSeekMs$delegate = mutableState;
        this.$onSeek = function12;
    }

    public final Object invoke(final PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        final Function1<Long, Unit> function1 = this.$onDragPosition;
        final long j = this.$durationMs;
        final MutableState<Long> mutableState = this.$pendingSeekMs$delegate;
        Function1 function12 = new Function1() { // from class: com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewKt$VideoProgressBar$2$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit invoke$lambda$0;
                invoke$lambda$0 = VideoArtifactPreviewKt$VideoProgressBar$2$1.invoke$lambda$0(pointerInputScope, function1, j, mutableState, (Offset) obj);
                return invoke$lambda$0;
            }
        };
        final Function1<Long, Unit> function13 = this.$onSeek;
        final MutableState<Long> mutableState2 = this.$pendingSeekMs$delegate;
        Function0 function0 = new Function0() { // from class: com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewKt$VideoProgressBar$2$1$$ExternalSyntheticLambda1
            public final Object invoke() {
                Unit invoke$lambda$1;
                invoke$lambda$1 = VideoArtifactPreviewKt$VideoProgressBar$2$1.invoke$lambda$1(function13, mutableState2);
                return invoke$lambda$1;
            }
        };
        final Function1<Long, Unit> function14 = this.$onDragPosition;
        final long j2 = this.$durationMs;
        final MutableState<Long> mutableState3 = this.$pendingSeekMs$delegate;
        Object detectHorizontalDragGestures$default = DragGestureDetectorKt.detectHorizontalDragGestures$default(pointerInputScope, function12, function0, (Function0) null, new Function2() { // from class: com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewKt$VideoProgressBar$2$1$$ExternalSyntheticLambda2
            public final Object invoke(Object obj, Object obj2) {
                Unit invoke$lambda$2;
                invoke$lambda$2 = VideoArtifactPreviewKt$VideoProgressBar$2$1.invoke$lambda$2(pointerInputScope, function14, j2, mutableState3, (PointerInputChange) obj, ((Float) obj2).floatValue());
                return invoke$lambda$2;
            }
        }, continuation, 4, (Object) null);
        return detectHorizontalDragGestures$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? detectHorizontalDragGestures$default : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$0(PointerInputScope pointerInputScope, Function1 function1, long j, MutableState mutableState, Offset offset) {
        long VideoProgressBar$targetFor;
        long VideoProgressBar$lambda$86;
        VideoProgressBar$targetFor = VideoArtifactPreviewKt.VideoProgressBar$targetFor(j, Float.intBitsToFloat((int) (offset.unbox-impl() >> 32)), (int) (pointerInputScope.getSize-YbymL2g() >> 32));
        VideoArtifactPreviewKt.VideoProgressBar$lambda$87(mutableState, VideoProgressBar$targetFor);
        VideoProgressBar$lambda$86 = VideoArtifactPreviewKt.VideoProgressBar$lambda$86(mutableState);
        function1.invoke(Long.valueOf(VideoProgressBar$lambda$86));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$2(PointerInputScope pointerInputScope, Function1 function1, long j, MutableState mutableState, PointerInputChange pointerInputChange, float f) {
        long VideoProgressBar$targetFor;
        long VideoProgressBar$lambda$86;
        Intrinsics.checkNotNullParameter(pointerInputChange, PhoneBindActivity.MODE_CHANGE);
        pointerInputChange.consume();
        VideoProgressBar$targetFor = VideoArtifactPreviewKt.VideoProgressBar$targetFor(j, Float.intBitsToFloat((int) (pointerInputChange.getPosition-F1C5BW0() >> 32)), (int) (pointerInputScope.getSize-YbymL2g() >> 32));
        VideoArtifactPreviewKt.VideoProgressBar$lambda$87(mutableState, VideoProgressBar$targetFor);
        VideoProgressBar$lambda$86 = VideoArtifactPreviewKt.VideoProgressBar$lambda$86(mutableState);
        function1.invoke(Long.valueOf(VideoProgressBar$lambda$86));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1(Function1 function1, MutableState mutableState) {
        long VideoProgressBar$lambda$86;
        VideoProgressBar$lambda$86 = VideoArtifactPreviewKt.VideoProgressBar$lambda$86(mutableState);
        function1.invoke(Long.valueOf(VideoProgressBar$lambda$86));
        return Unit.INSTANCE;
    }
}
