package com.bytedance.trae.kmp.artifact;

import android.content.Context;
import java.io.File;
import java.net.URI;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidKmpArtifactIo.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0014\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000¨\u0006\t"}, d2 = {"configureAndroidKmpArtifactIo", "", "context", "Landroid/content/Context;", "resolveForDownload", "Ljava/io/File;", "Lcom/bytedance/trae/kmp/artifact/AndroidKmpArtifactFileSystem;", "file", "Lcom/bytedance/trae/kmp/artifact/KmpFileReference;", "base_mainlandRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class AndroidKmpArtifactIoKt {
    public static final void configureAndroidKmpArtifactIo(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        AndroidKmpArtifactFileSystem androidKmpArtifactFileSystem = new AndroidKmpArtifactFileSystem(new File(context.getCacheDir(), AndroidKmpArtifactFileSystem.ROOT_DIRECTORY_NAME));
        KmpArtifactIo.INSTANCE.configure(new AndroidKmpBinaryDownloadClient(context, androidKmpArtifactFileSystem), androidKmpArtifactFileSystem);
    }

    public static final File resolveForDownload(AndroidKmpArtifactFileSystem androidKmpArtifactFileSystem, KmpFileReference kmpFileReference) {
        Intrinsics.checkNotNullParameter(androidKmpArtifactFileSystem, "<this>");
        Intrinsics.checkNotNullParameter(kmpFileReference, "file");
        return new File(new URI(androidKmpArtifactFileSystem.localUri(kmpFileReference)));
    }
}
