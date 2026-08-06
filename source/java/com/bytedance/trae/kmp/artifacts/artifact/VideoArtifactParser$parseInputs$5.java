package com.bytedance.trae.kmp.artifacts.artifact;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ArtifactModels.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public /* synthetic */ class VideoArtifactParser$parseInputs$5 extends FunctionReferenceImpl implements Function1<VideoArtifactFileInput, VideoArtifactDescriptor> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public VideoArtifactParser$parseInputs$5(Object obj) {
        super(1, obj, VideoArtifactParser.class, "descriptor", "descriptor(Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactFileInput;)Lcom/bytedance/trae/kmp/artifacts/artifact/VideoArtifactDescriptor;", 0);
    }

    public final VideoArtifactDescriptor invoke(VideoArtifactFileInput videoArtifactFileInput) {
        VideoArtifactDescriptor descriptor;
        Intrinsics.checkNotNullParameter(videoArtifactFileInput, "p0");
        descriptor = ((VideoArtifactParser) this.receiver).descriptor(videoArtifactFileInput);
        return descriptor;
    }
}
