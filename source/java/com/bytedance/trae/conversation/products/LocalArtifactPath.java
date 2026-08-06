package com.bytedance.trae.conversation.products;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: LocalArtifactPath.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/conversation/products/LocalArtifactPath;", "", "<init>", "()V", "FILES_PREFIX", "", "requestTarget", "rawPath", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class LocalArtifactPath {
    private static final String FILES_PREFIX = "files/";
    public static final LocalArtifactPath INSTANCE = new LocalArtifactPath();

    private LocalArtifactPath() {
    }

    public final String requestTarget(String rawPath) {
        Intrinsics.checkNotNullParameter(rawPath, "rawPath");
        String obj = StringsKt.trim(rawPath).toString();
        return (StringsKt.isBlank(obj) || StringsKt.startsWith$default(obj, FILES_PREFIX, false, 2, (Object) null)) ? obj : StringsKt.startsWith$default(obj, "/", false, 2, (Object) null) ? "files" + obj : FILES_PREFIX + obj;
    }
}
