package com.ss.android.socialbase.appdownloader.util.parser.manifest;

/* loaded from: classes7.dex */
public class ResID {
    public final int entry;
    public final int id;
    public final int pkgId;
    public final int type;

    public ResID(int i, int i2, int i3) {
        this(i, i2, i3, (i << 24) + (i2 << 16) + i3);
    }

    public ResID(int i) {
        this((i >> 24) & 255, (i >> 16) & 255, 65535 & i, i);
    }

    public ResID(int i, int i2, int i3, int i4) {
        this.pkgId = i == 0 ? 2 : i;
        this.type = i2;
        this.entry = i3;
        this.id = i4;
    }

    public String toString() {
        return String.format("0x%08x", Integer.valueOf(this.id));
    }

    public int hashCode() {
        return 527 + this.id;
    }

    public boolean equals(Object obj) {
        return obj != null && getClass() == obj.getClass() && this.id == ((ResID) obj).id;
    }
}
