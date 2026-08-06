package com.bytedance.trae.kmp.artifact;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KmpArtifactIo.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\n\u001a\u00020\u0007R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedance/trae/kmp/artifact/KmpArtifactIo;", "", "<init>", "()V", "binaryDownloadClient", "Lcom/bytedance/trae/kmp/artifact/KmpBinaryDownloadClient;", "artifactFileSystem", "Lcom/bytedance/trae/kmp/artifact/KmpArtifactFileSystem;", "configure", "", "fileSystem", "base_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class KmpArtifactIo {
    private static KmpArtifactFileSystem artifactFileSystem;
    private static KmpBinaryDownloadClient binaryDownloadClient;
    public static final KmpArtifactIo INSTANCE = new KmpArtifactIo();
    public static final int $stable = 8;

    private KmpArtifactIo() {
    }

    public final void configure(KmpBinaryDownloadClient binaryDownloadClient2, KmpArtifactFileSystem artifactFileSystem2) {
        Intrinsics.checkNotNullParameter(binaryDownloadClient2, "binaryDownloadClient");
        Intrinsics.checkNotNullParameter(artifactFileSystem2, "artifactFileSystem");
        binaryDownloadClient = binaryDownloadClient2;
        artifactFileSystem = artifactFileSystem2;
    }

    public final KmpBinaryDownloadClient binaryDownloadClient() {
        KmpBinaryDownloadClient kmpBinaryDownloadClient = binaryDownloadClient;
        if (kmpBinaryDownloadClient != null) {
            return kmpBinaryDownloadClient;
        }
        throw new IllegalStateException("KmpArtifactIo binary download client is not configured".toString());
    }

    public final KmpArtifactFileSystem fileSystem() {
        KmpArtifactFileSystem kmpArtifactFileSystem = artifactFileSystem;
        if (kmpArtifactFileSystem != null) {
            return kmpArtifactFileSystem;
        }
        throw new IllegalStateException("KmpArtifactIo filesystem is not configured".toString());
    }
}
