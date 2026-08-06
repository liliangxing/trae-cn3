package com.bytedance.trae.kmp.artifact;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidKmpArtifactIo.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
/* synthetic */ class AndroidKmpArtifactFileSystem$list$2 extends FunctionReferenceImpl implements Function1<File, Boolean> {
    public static final AndroidKmpArtifactFileSystem$list$2 INSTANCE = new AndroidKmpArtifactFileSystem$list$2();

    AndroidKmpArtifactFileSystem$list$2() {
        super(1, File.class, "isFile", "isFile()Z", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(File p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return Boolean.valueOf(p0.isFile());
    }
}
