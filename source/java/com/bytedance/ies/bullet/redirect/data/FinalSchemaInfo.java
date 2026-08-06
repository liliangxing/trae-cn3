package com.bytedance.ies.bullet.redirect.data;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FinalSchemaInfo.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ies/bullet/redirect/data/FinalSchemaInfo;", "", "location", "", "(Ljava/lang/String;)V", "getLocation", "()Ljava/lang/String;", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class FinalSchemaInfo {
    private final String location;

    public static /* synthetic */ FinalSchemaInfo copy$default(FinalSchemaInfo finalSchemaInfo, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = finalSchemaInfo.location;
        }
        return finalSchemaInfo.copy(str);
    }

    /* renamed from: component1, reason: from getter */
    public final String getLocation() {
        return this.location;
    }

    public final FinalSchemaInfo copy(String location) {
        Intrinsics.checkNotNullParameter(location, "location");
        return new FinalSchemaInfo(location);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof FinalSchemaInfo) && Intrinsics.areEqual(this.location, ((FinalSchemaInfo) other).location);
    }

    public int hashCode() {
        return this.location.hashCode();
    }

    public String toString() {
        return "FinalSchemaInfo(location=" + this.location + ')';
    }

    public FinalSchemaInfo(String location) {
        Intrinsics.checkNotNullParameter(location, "location");
        this.location = location;
    }

    public final String getLocation() {
        return this.location;
    }
}
