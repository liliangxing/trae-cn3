package com.bytedance.trae.kmp.artifact;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidKmpArtifactIo.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
/* synthetic */ class AndroidKmpArtifactFileSystem$list$3 extends FunctionReferenceImpl implements Function1<File, KmpFileReference> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public AndroidKmpArtifactFileSystem$list$3(Object obj) {
        super(1, obj, AndroidKmpArtifactFileSystem.class, "reference", "reference(Ljava/io/File;)Lcom/bytedance/trae/kmp/artifact/KmpFileReference;", 0);
    }

    public final KmpFileReference invoke(File file) {
        KmpFileReference reference;
        Intrinsics.checkNotNullParameter(file, "p0");
        reference = ((AndroidKmpArtifactFileSystem) this.receiver).reference(file);
        return reference;
    }
}
