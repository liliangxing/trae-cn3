package com.bytedance.geckox.model;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.keva.KevaImpl;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GeckoManifest.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006J\u0015\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\u001f\u0010\n\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0004HÖ\u0001R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/geckox/model/GeckoManifest;", "", KevaImpl.PrivateConstants.FILES_DIR_NAME, "", "", "Lcom/bytedance/geckox/model/GeckoMd5Check;", "(Ljava/util/Map;)V", "getFiles", "()Ljava/util/Map;", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes3.dex */
public final /* data */ class GeckoManifest {
    private final Map<String, GeckoMd5Check> files;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GeckoManifest copy$default(GeckoManifest geckoManifest, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            map = geckoManifest.files;
        }
        return geckoManifest.copy(map);
    }

    public final Map<String, GeckoMd5Check> component1() {
        return this.files;
    }

    public final GeckoManifest copy(Map<String, GeckoMd5Check> files) {
        Intrinsics.checkParameterIsNotNull(files, "files");
        return new GeckoManifest(files);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof GeckoManifest) && Intrinsics.areEqual(this.files, ((GeckoManifest) other).files);
        }
        return true;
    }

    public int hashCode() {
        Map<String, GeckoMd5Check> map = this.files;
        if (map != null) {
            return map.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "GeckoManifest(files=" + this.files + ")";
    }

    public GeckoManifest(Map<String, GeckoMd5Check> files) {
        Intrinsics.checkParameterIsNotNull(files, "files");
        this.files = files;
    }

    public final Map<String, GeckoMd5Check> getFiles() {
        return this.files;
    }
}
