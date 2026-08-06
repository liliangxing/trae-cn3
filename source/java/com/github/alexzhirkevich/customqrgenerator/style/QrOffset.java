package com.github.alexzhirkevich.customqrgenerator.style;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: QrOffset.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0015"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/style/QrOffset;", "Lcom/github/alexzhirkevich/customqrgenerator/style/IQrOffset;", "x", "", "y", "(FF)V", "getX", "()F", "getY", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "", "Companion", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final /* data */ class QrOffset implements IQrOffset {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final QrOffset Zero = new QrOffset(0.0f, 0.0f);
    private final float x;
    private final float y;

    public static /* synthetic */ QrOffset copy$default(QrOffset qrOffset, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = qrOffset.getX();
        }
        if ((i & 2) != 0) {
            f2 = qrOffset.getY();
        }
        return qrOffset.copy(f, f2);
    }

    public final float component1() {
        return getX();
    }

    public final float component2() {
        return getY();
    }

    public final QrOffset copy(float x, float y) {
        return new QrOffset(x, y);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QrOffset)) {
            return false;
        }
        QrOffset qrOffset = (QrOffset) other;
        return Intrinsics.areEqual((Object) Float.valueOf(getX()), (Object) Float.valueOf(qrOffset.getX())) && Intrinsics.areEqual((Object) Float.valueOf(getY()), (Object) Float.valueOf(qrOffset.getY()));
    }

    public int hashCode() {
        return (Float.hashCode(getX()) * 31) + Float.hashCode(getY());
    }

    public String toString() {
        return "QrOffset(x=" + getX() + ", y=" + getY() + ')';
    }

    public QrOffset(float f, float f2) {
        this.x = f;
        this.y = f2;
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.style.IQrOffset
    public float getX() {
        return this.x;
    }

    @Override // com.github.alexzhirkevich.customqrgenerator.style.IQrOffset
    public float getY() {
        return this.y;
    }

    /* compiled from: QrOffset.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/github/alexzhirkevich/customqrgenerator/style/QrOffset$Companion;", "", "()V", "Zero", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrOffset;", "getZero", "()Lcom/github/alexzhirkevich/customqrgenerator/style/QrOffset;", "custom_qr_generator_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final QrOffset getZero() {
            return QrOffset.Zero;
        }
    }
}
