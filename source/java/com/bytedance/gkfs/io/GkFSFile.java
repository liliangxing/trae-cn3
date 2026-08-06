package com.bytedance.gkfs.io;

import com.bytedance.gkfs.GeckoFileSystem;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GkFSFile.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/bytedance/gkfs/io/GkFSFile;", "Ljava/io/File;", "path", "", "(Ljava/lang/String;)V", "delete", "", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class GkFSFile extends File {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GkFSFile(String str) {
        super(str);
        Intrinsics.checkParameterIsNotNull(str, "path");
    }

    @Override // java.io.File
    public boolean delete() {
        return GeckoFileSystem.INSTANCE.delete(this);
    }
}
