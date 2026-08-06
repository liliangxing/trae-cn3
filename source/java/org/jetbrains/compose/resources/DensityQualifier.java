package org.jetbrains.compose.resources;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: Qualifier.kt */
@InternalResourceApi
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0087\u0081\u0002\u0018\u0000 \u000f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lorg/jetbrains/compose/resources/DensityQualifier;", "Lorg/jetbrains/compose/resources/Qualifier;", "", "dpi", "", "<init>", "(Ljava/lang/String;II)V", "getDpi", "()I", "LDPI", "MDPI", "HDPI", "XHDPI", "XXHDPI", "XXXHDPI", "Companion", "library_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes9.dex */
public final class DensityQualifier implements Qualifier {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DensityQualifier[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final int dpi;
    public static final DensityQualifier LDPI = new DensityQualifier("LDPI", 0, 120);
    public static final DensityQualifier MDPI = new DensityQualifier("MDPI", 1, 160);
    public static final DensityQualifier HDPI = new DensityQualifier("HDPI", 2, 240);
    public static final DensityQualifier XHDPI = new DensityQualifier("XHDPI", 3, 320);
    public static final DensityQualifier XXHDPI = new DensityQualifier("XXHDPI", 4, 480);
    public static final DensityQualifier XXXHDPI = new DensityQualifier("XXXHDPI", 5, 640);

    private static final /* synthetic */ DensityQualifier[] $values() {
        return new DensityQualifier[]{LDPI, MDPI, HDPI, XHDPI, XXHDPI, XXXHDPI};
    }

    public static EnumEntries<DensityQualifier> getEntries() {
        return $ENTRIES;
    }

    private DensityQualifier(String str, int i, int i2) {
        this.dpi = i2;
    }

    public final int getDpi() {
        return this.dpi;
    }

    static {
        DensityQualifier[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        INSTANCE = new Companion(null);
    }

    /* compiled from: Qualifier.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lorg/jetbrains/compose/resources/DensityQualifier$Companion;", "", "<init>", "()V", "selectByValue", "Lorg/jetbrains/compose/resources/DensityQualifier;", "dpi", "", "selectByDensity", "density", "", "library_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes9.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DensityQualifier selectByValue(int dpi) {
            return dpi <= DensityQualifier.LDPI.getDpi() ? DensityQualifier.LDPI : dpi <= DensityQualifier.MDPI.getDpi() ? DensityQualifier.MDPI : dpi <= DensityQualifier.HDPI.getDpi() ? DensityQualifier.HDPI : dpi <= DensityQualifier.XHDPI.getDpi() ? DensityQualifier.XHDPI : dpi <= DensityQualifier.XXHDPI.getDpi() ? DensityQualifier.XXHDPI : DensityQualifier.XXXHDPI;
        }

        public final DensityQualifier selectByDensity(float density) {
            double d = density;
            if (d <= 0.75d) {
                return DensityQualifier.LDPI;
            }
            if (d <= 1.0d) {
                return DensityQualifier.MDPI;
            }
            if (d <= 1.5d) {
                return DensityQualifier.HDPI;
            }
            if (d <= 2.0d) {
                return DensityQualifier.XHDPI;
            }
            if (d <= 3.0d) {
                return DensityQualifier.XXHDPI;
            }
            return DensityQualifier.XXXHDPI;
        }
    }

    public static DensityQualifier valueOf(String str) {
        return (DensityQualifier) Enum.valueOf(DensityQualifier.class, str);
    }

    public static DensityQualifier[] values() {
        return (DensityQualifier[]) $VALUES.clone();
    }
}
