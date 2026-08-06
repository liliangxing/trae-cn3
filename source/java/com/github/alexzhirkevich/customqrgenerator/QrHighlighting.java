package com.github.alexzhirkevich.customqrgenerator;

import com.bytedance.forest.model.PreloadConfig;
import com.github.alexzhirkevich.customqrgenerator.HighlightingType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: QrHighlighting.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0005\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/QrHighlighting;", "Lcom/github/alexzhirkevich/customqrgenerator/IAnchorsHighlighting;", "cornerEyes", "Lcom/github/alexzhirkevich/customqrgenerator/HighlightingType;", "versionEyes", "timingLines", "alpha", "", "(Lcom/github/alexzhirkevich/customqrgenerator/HighlightingType;Lcom/github/alexzhirkevich/customqrgenerator/HighlightingType;Lcom/github/alexzhirkevich/customqrgenerator/HighlightingType;F)V", "getAlpha", "()F", "getCornerEyes", "()Lcom/github/alexzhirkevich/customqrgenerator/HighlightingType;", "getTimingLines", "getVersionEyes", "component1", "component2", "component3", "component4", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final /* data */ class QrHighlighting implements IAnchorsHighlighting {
    private final float alpha;
    private final HighlightingType cornerEyes;
    private final HighlightingType timingLines;
    private final HighlightingType versionEyes;

    public QrHighlighting() {
        this(null, null, null, 0.0f, 15, null);
    }

    public static /* synthetic */ QrHighlighting copy$default(QrHighlighting qrHighlighting, HighlightingType highlightingType, HighlightingType highlightingType2, HighlightingType highlightingType3, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            highlightingType = qrHighlighting.getCornerEyes();
        }
        if ((i & 2) != 0) {
            highlightingType2 = qrHighlighting.getVersionEyes();
        }
        if ((i & 4) != 0) {
            highlightingType3 = qrHighlighting.getTimingLines();
        }
        if ((i & 8) != 0) {
            f = qrHighlighting.getAlpha();
        }
        return qrHighlighting.copy(highlightingType, highlightingType2, highlightingType3, f);
    }

    public final HighlightingType component1() {
        return getCornerEyes();
    }

    public final HighlightingType component2() {
        return getVersionEyes();
    }

    public final HighlightingType component3() {
        return getTimingLines();
    }

    public final float component4() {
        return getAlpha();
    }

    public final QrHighlighting copy(HighlightingType cornerEyes, HighlightingType versionEyes, HighlightingType timingLines, float alpha) {
        Intrinsics.checkNotNullParameter(cornerEyes, "cornerEyes");
        Intrinsics.checkNotNullParameter(versionEyes, "versionEyes");
        Intrinsics.checkNotNullParameter(timingLines, "timingLines");
        return new QrHighlighting(cornerEyes, versionEyes, timingLines, alpha);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QrHighlighting)) {
            return false;
        }
        QrHighlighting qrHighlighting = (QrHighlighting) other;
        return Intrinsics.areEqual(getCornerEyes(), qrHighlighting.getCornerEyes()) && Intrinsics.areEqual(getVersionEyes(), qrHighlighting.getVersionEyes()) && Intrinsics.areEqual(getTimingLines(), qrHighlighting.getTimingLines()) && Intrinsics.areEqual((Object) Float.valueOf(getAlpha()), (Object) Float.valueOf(qrHighlighting.getAlpha()));
    }

    public int hashCode() {
        return (((((getCornerEyes().hashCode() * 31) + getVersionEyes().hashCode()) * 31) + getTimingLines().hashCode()) * 31) + Float.hashCode(getAlpha());
    }

    public String toString() {
        return "QrHighlighting(cornerEyes=" + getCornerEyes() + ", versionEyes=" + getVersionEyes() + ", timingLines=" + getTimingLines() + ", alpha=" + getAlpha() + ')';
    }

    public QrHighlighting(HighlightingType cornerEyes, HighlightingType versionEyes, HighlightingType timingLines, float f) {
        Intrinsics.checkNotNullParameter(cornerEyes, "cornerEyes");
        Intrinsics.checkNotNullParameter(versionEyes, "versionEyes");
        Intrinsics.checkNotNullParameter(timingLines, "timingLines");
        this.cornerEyes = cornerEyes;
        this.versionEyes = versionEyes;
        this.timingLines = timingLines;
        this.alpha = f;
    }

    public /* synthetic */ QrHighlighting(HighlightingType.None none, HighlightingType.None none2, HighlightingType.None none3, float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? HighlightingType.None.INSTANCE : none, (i & 2) != 0 ? HighlightingType.None.INSTANCE : none2, (i & 4) != 0 ? HighlightingType.None.INSTANCE : none3, (i & 8) != 0 ? 0.75f : f);
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.IAnchorsHighlighting
    public HighlightingType getCornerEyes() {
        return this.cornerEyes;
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.IAnchorsHighlighting
    public HighlightingType getVersionEyes() {
        return this.versionEyes;
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.IAnchorsHighlighting
    public HighlightingType getTimingLines() {
        return this.timingLines;
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.IAnchorsHighlighting
    public float getAlpha() {
        return this.alpha;
    }
}
