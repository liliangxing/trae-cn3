package com.bytedance.kmp.image.options;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.kmp.image.options.KImageSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KImageSource.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\t\u001a\u00020\u0005HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\t\u0010\u0011\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/kmp/image/options/ColorSource;", "Lcom/bytedance/kmp/image/options/KImageSource;", "color", "Lcom/bytedance/kmp/image/options/ImageColor;", "(Lcom/bytedance/kmp/image/options/ImageColor;)V", "", "(J)V", "getColor", "()J", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "getType", "", "hashCode", "toString", "", "kmpimage_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class ColorSource implements KImageSource {
    public static final int $stable = 0;
    private final long color;

    public static /* synthetic */ ColorSource copy$default(ColorSource colorSource, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = colorSource.color;
        }
        return colorSource.copy(j);
    }

    /* renamed from: component1, reason: from getter */
    public final long getColor() {
        return this.color;
    }

    public final ColorSource copy(long color) {
        return new ColorSource(color);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ColorSource) && this.color == ((ColorSource) other).color;
    }

    @Override // com.bytedance.kmp.image.options.KImageSource
    public int getType() {
        return 4;
    }

    public int hashCode() {
        return Long.hashCode(this.color);
    }

    public String toString() {
        return "ColorSource(color=" + this.color + ')';
    }

    public ColorSource(long j) {
        this.color = j;
    }

    @Override // com.bytedance.kmp.image.options.KImageSource
    public boolean isLocalSource() {
        return KImageSource.DefaultImpls.isLocalSource(this);
    }

    public final long getColor() {
        return this.color;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ColorSource(ImageColor color) {
        this(color.getColor());
        Intrinsics.checkNotNullParameter(color, "color");
    }
}
