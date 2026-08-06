package com.bytedance.trae.kmp.artifacts.video;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VideoArtifactPreviewActivity.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public /* synthetic */ class VideoArtifactPreviewActivity$onCreate$2$1$1$2$1 extends FunctionReferenceImpl implements Function1<VideoArtifactPlayer, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public VideoArtifactPreviewActivity$onCreate$2$1$1$2$1(Object obj) {
        super(1, obj, VideoArtifactPreviewViewModel.class, "detachPlayer", "detachPlayer(Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPlayer;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((VideoArtifactPlayer) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(VideoArtifactPlayer videoArtifactPlayer) {
        Intrinsics.checkNotNullParameter(videoArtifactPlayer, "p0");
        ((VideoArtifactPreviewViewModel) this.receiver).detachPlayer(videoArtifactPlayer);
    }
}
