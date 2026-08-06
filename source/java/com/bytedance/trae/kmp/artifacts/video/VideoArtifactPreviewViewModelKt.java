package com.bytedance.trae.kmp.artifacts.video;

import kotlin.Metadata;
import kotlin.text.StringsKt;

/* compiled from: VideoArtifactPreviewViewModel.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002¨\u0006\u0003"}, d2 = {"isLocalMediaSource", "", "", "artifacts_mainlandRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class VideoArtifactPreviewViewModelKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isLocalMediaSource(String str) {
        return StringsKt.startsWith$default(str, "file:", false, 2, (Object) null) || StringsKt.startsWith$default(str, "/", false, 2, (Object) null);
    }
}
