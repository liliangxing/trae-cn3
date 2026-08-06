package com.bytedance.kmp.image.options;

import androidx.compose.ui.graphics.FilterQuality;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ImageFilterQuality.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0007\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u000b"}, d2 = {"Lcom/bytedance/kmp/image/options/ImageFilterQuality;", "", "value", "", "(I)V", "getValue", "()I", "getCoilFilterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "getCoilFilterQuality-f-v9h1I", "Companion", "kmpimage_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ImageFilterQuality {
    public static final int $stable = 0;
    private final int value;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ImageFilterQuality None = new ImageFilterQuality(0);
    private static final ImageFilterQuality Low = new ImageFilterQuality(1);
    private static final ImageFilterQuality Medium = new ImageFilterQuality(2);
    private static final ImageFilterQuality High = new ImageFilterQuality(3);

    private ImageFilterQuality(int i) {
        this.value = i;
    }

    /* compiled from: ImageFilterQuality.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/bytedance/kmp/image/options/ImageFilterQuality$Companion;", "", "()V", "High", "Lcom/bytedance/kmp/image/options/ImageFilterQuality;", "getHigh", "()Lcom/bytedance/kmp/image/options/ImageFilterQuality;", "Low", "getLow", "Medium", "getMedium", "None", "getNone", "kmpimage_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ImageFilterQuality getNone() {
            return ImageFilterQuality.None;
        }

        public final ImageFilterQuality getLow() {
            return ImageFilterQuality.Low;
        }

        public final ImageFilterQuality getMedium() {
            return ImageFilterQuality.Medium;
        }

        public final ImageFilterQuality getHigh() {
            return ImageFilterQuality.High;
        }
    }

    public final int getValue() {
        return this.value;
    }

    /* renamed from: getCoilFilterQuality-f-v9h1I, reason: not valid java name */
    public final int m7742getCoilFilterQualityfv9h1I() {
        int i = this.value;
        if (i == 1) {
            return FilterQuality.INSTANCE.m4446getLowfv9h1I();
        }
        if (i == 2) {
            return FilterQuality.INSTANCE.m4447getMediumfv9h1I();
        }
        if (i == 3) {
            return FilterQuality.INSTANCE.m4445getHighfv9h1I();
        }
        return FilterQuality.INSTANCE.m4448getNonefv9h1I();
    }
}
