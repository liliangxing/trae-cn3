package com.bytedance.trae.kmp.artifact;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KmpArtifactIo.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÇ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\r\u001a\u00020\u000eH×\u0001J\t\u0010\u000f\u001a\u00020\u0003H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/bytedance/trae/kmp/artifact/KmpFileReference;", "", "path", "", "<init>", "(Ljava/lang/String;)V", "getPath", "()Ljava/lang/String;", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "base_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class KmpFileReference {
    public static final int $stable = 0;
    private final String path;

    public static /* synthetic */ KmpFileReference copy$default(KmpFileReference kmpFileReference, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = kmpFileReference.path;
        }
        return kmpFileReference.copy(str);
    }

    /* renamed from: component1, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    public final KmpFileReference copy(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        return new KmpFileReference(path);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof KmpFileReference) && Intrinsics.areEqual(this.path, ((KmpFileReference) other).path);
    }

    public int hashCode() {
        return this.path.hashCode();
    }

    public String toString() {
        return "KmpFileReference(path=" + this.path + ')';
    }

    public KmpFileReference(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        this.path = path;
    }

    public final String getPath() {
        return this.path;
    }
}
