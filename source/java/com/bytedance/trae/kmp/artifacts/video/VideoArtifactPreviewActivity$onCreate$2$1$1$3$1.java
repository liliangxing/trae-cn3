package com.bytedance.trae.kmp.artifacts.video;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: VideoArtifactPreviewActivity.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
/* synthetic */ class VideoArtifactPreviewActivity$onCreate$2$1$1$3$1 extends FunctionReferenceImpl implements Function0<Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public VideoArtifactPreviewActivity$onCreate$2$1$1$3$1(Object obj) {
        super(0, obj, VideoArtifactPreviewViewModel.class, "onPlayerWindowReady", "onPlayerWindowReady()V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m865invoke();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: collision with other method in class */
    public final void m865invoke() {
        ((VideoArtifactPreviewViewModel) this.receiver).onPlayerWindowReady();
    }
}
