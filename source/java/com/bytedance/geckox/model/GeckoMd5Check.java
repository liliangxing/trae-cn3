package com.bytedance.geckox.model;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GeckoManifest.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/bytedance/geckox/model/GeckoMd5Check;", "", "md5", "", "(Ljava/lang/String;)V", "getMd5", "()Ljava/lang/String;", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes3.dex */
public final /* data */ class GeckoMd5Check {
    private final String md5;

    public static /* synthetic */ GeckoMd5Check copy$default(GeckoMd5Check geckoMd5Check, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = geckoMd5Check.md5;
        }
        return geckoMd5Check.copy(str);
    }

    /* renamed from: component1, reason: from getter */
    public final String getMd5() {
        return this.md5;
    }

    public final GeckoMd5Check copy(String md5) {
        Intrinsics.checkParameterIsNotNull(md5, "md5");
        return new GeckoMd5Check(md5);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof GeckoMd5Check) && Intrinsics.areEqual(this.md5, ((GeckoMd5Check) other).md5);
        }
        return true;
    }

    public int hashCode() {
        String str = this.md5;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "GeckoMd5Check(md5=" + this.md5 + ")";
    }

    public GeckoMd5Check(String md5) {
        Intrinsics.checkParameterIsNotNull(md5, "md5");
        this.md5 = md5;
    }

    public final String getMd5() {
        return this.md5;
    }
}
