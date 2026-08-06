package com.bytedance.kmp.image.options;

import android.graphics.ColorFilter;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ImageColorFilter.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/kmp/image/options/ImageColorFilter;", "", "()V", "platformColorFilter", "Landroid/graphics/ColorFilter;", "Lcom/bytedance/kmp/image/options/PlatformColorFilter;", "getPlatformColorFilter", "()Landroid/graphics/ColorFilter;", "setPlatformColorFilter", "(Landroid/graphics/ColorFilter;)V", "Companion", "kmpimage_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ImageColorFilter {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private ColorFilter platformColorFilter;

    public final ColorFilter getPlatformColorFilter() {
        return this.platformColorFilter;
    }

    public final void setPlatformColorFilter(ColorFilter colorFilter) {
        this.platformColorFilter = colorFilter;
    }

    /* compiled from: ImageColorFilter.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\"\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\rH\u0007J$\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J$\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0016"}, d2 = {"Lcom/bytedance/kmp/image/options/ImageColorFilter$Companion;", "", "()V", "colorMatrix", "Lcom/bytedance/kmp/image/options/ImageColorFilter;", "array", "", "lighting", "multiply", "Landroidx/compose/ui/graphics/Color;", "add", "lighting--OWjLjI", "(JJ)Lcom/bytedance/kmp/image/options/ImageColorFilter;", "", "tint", "color", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "tint-xETnrds", "(JI)Lcom/bytedance/kmp/image/options/ImageColorFilter;", "tint-GB0RdKg", "(II)Lcom/bytedance/kmp/image/options/ImageColorFilter;", "kmpimage_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ImageColorFilter colorMatrix(float[] array) {
            Intrinsics.checkNotNullParameter(array, "array");
            ImageColorFilter imageColorFilter = new ImageColorFilter();
            imageColorFilter.setPlatformColorFilter(ImageColorFilter_androidKt.fromColorMatrix(array));
            return imageColorFilter;
        }

        /* renamed from: tint-xETnrds$default, reason: not valid java name */
        public static /* synthetic */ ImageColorFilter m656tintxETnrds$default(Companion companion, long j, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = BlendMode.Companion.getSrcIn-0nO6VwU();
            }
            return companion.m659tintxETnrds(j, i);
        }

        /* renamed from: tint-xETnrds, reason: not valid java name */
        public final ImageColorFilter m659tintxETnrds(long color, int blendMode) {
            ImageColorFilter imageColorFilter = new ImageColorFilter();
            imageColorFilter.setPlatformColorFilter(ImageColorFilter_androidKt.m663fromTintxETnrds(color, blendMode));
            return imageColorFilter;
        }

        /* renamed from: tint-GB0RdKg$default, reason: not valid java name */
        public static /* synthetic */ ImageColorFilter m655tintGB0RdKg$default(Companion companion, int i, int i2, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                i2 = BlendMode.Companion.getSrcIn-0nO6VwU();
            }
            return companion.m658tintGB0RdKg(i, i2);
        }

        /* renamed from: tint-GB0RdKg, reason: not valid java name */
        public final ImageColorFilter m658tintGB0RdKg(int color, int blendMode) {
            return m659tintxETnrds(ColorKt.Color(color), blendMode);
        }

        public final ImageColorFilter lighting(int multiply, int add) {
            return m657lightingOWjLjI(ColorKt.Color(multiply), ColorKt.Color(add));
        }

        /* renamed from: lighting--OWjLjI, reason: not valid java name */
        public final ImageColorFilter m657lightingOWjLjI(long multiply, long add) {
            ImageColorFilter imageColorFilter = new ImageColorFilter();
            imageColorFilter.setPlatformColorFilter(ImageColorFilter_androidKt.m662fromLightingOWjLjI(multiply, add));
            return imageColorFilter;
        }
    }
}
