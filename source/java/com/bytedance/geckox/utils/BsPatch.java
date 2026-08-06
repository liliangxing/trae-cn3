package com.bytedance.geckox.utils;

import java.io.File;
import java.io.FileNotFoundException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BsPatch.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tJ!\u0010\u0003\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\tH\u0082 ¨\u0006\f"}, d2 = {"Lcom/bytedance/geckox/utils/BsPatch;", "", "()V", "patch", "", "full", "Ljava/io/File;", "destDir", "destFileName", "", "", "dest", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class BsPatch {
    public static final BsPatch INSTANCE = new BsPatch();

    private final native int patch(String full, String dest, String patch) throws Exception;

    static {
        LibLoader.INSTANCE.loadLib("geckox_bspatch");
    }

    private BsPatch() {
    }

    public final void patch(File full, File patch, File destDir, String destFileName) throws Exception {
        Intrinsics.checkParameterIsNotNull(full, "full");
        Intrinsics.checkParameterIsNotNull(patch, "patch");
        Intrinsics.checkParameterIsNotNull(destDir, "destDir");
        Intrinsics.checkParameterIsNotNull(destFileName, "destFileName");
        if (!full.exists()) {
            throw new FileNotFoundException("full package not exist：" + full.getAbsolutePath());
        }
        if (!patch.exists()) {
            throw new FileNotFoundException("patch package not exist：" + patch.getAbsolutePath());
        }
        FileUtils.INSTANCE.createDir$geckox_noasanRelease(destDir);
        File file = new File(destDir, destFileName);
        file.delete();
        String absolutePath = full.getAbsolutePath();
        Intrinsics.checkExpressionValueIsNotNull(absolutePath, "full.absolutePath");
        String absolutePath2 = file.getAbsolutePath();
        Intrinsics.checkExpressionValueIsNotNull(absolutePath2, "dest.absolutePath");
        String absolutePath3 = patch.getAbsolutePath();
        Intrinsics.checkExpressionValueIsNotNull(absolutePath3, "patch.absolutePath");
        int patch2 = patch(absolutePath, absolutePath2, absolutePath3);
        if (patch2 != 0) {
            throw new RuntimeException("patch failed: " + patch2 + ", " + full.getAbsolutePath() + ", " + patch.getAbsolutePath() + ", " + file.getAbsolutePath());
        }
    }
}
