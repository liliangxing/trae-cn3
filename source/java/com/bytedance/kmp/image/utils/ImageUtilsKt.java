package com.bytedance.kmp.image.utils;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import com.bytedance.kmp.image.options.ColorSource;
import com.bytedance.kmp.image.options.ImageBlurOption;
import com.bytedance.kmp.image.options.ImageBorderOption;
import com.bytedance.kmp.image.options.ImageScaleType;
import com.bytedance.kmp.image.options.KImageSource;
import com.bytedance.kmp.image.options.LocalResourceSource;
import com.bytedance.kmp.image.options.Priority;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.imagepipeline.blurhash.BlurHashConfig;
import com.facebook.imagepipeline.common.Priority;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ImageUtils.kt */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u000e\u0010\u0003\u001a\u0004\u0018\u00010\u0004*\u0004\u0018\u00010\u0005\u001a\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0007*\u00020\u00022\u0006\u0010\b\u001a\u00020\t\u001a\n\u0010\n\u001a\u00020\u000b*\u00020\f\u001a\u000e\u0010\r\u001a\u0004\u0018\u00010\u000e*\u0004\u0018\u00010\u000f\u001a\u0013\u0010\u0010\u001a\u00020\u0011*\u0004\u0018\u00010\u0012H\u0007¢\u0006\u0002\u0010\u0013¨\u0006\u0014"}, d2 = {"getResourceId", "", "Lcom/bytedance/kmp/image/options/KImageSource;", "toBlurHashConfig", "Lcom/facebook/imagepipeline/blurhash/BlurHashConfig;", "Lcom/bytedance/kmp/image/options/ImageBlurOption;", "toDrawable", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "toFrescoPriority", "Lcom/facebook/imagepipeline/common/Priority;", "Lcom/bytedance/kmp/image/options/Priority;", "toFrescoScaleType", "Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;", "Lcom/bytedance/kmp/image/options/ImageScaleType;", "toRoundingParams", "Lcom/facebook/drawee/generic/RoundingParams;", "Lcom/bytedance/kmp/image/options/ImageBorderOption;", "(Lcom/bytedance/kmp/image/options/ImageBorderOption;Landroidx/compose/runtime/Composer;I)Lcom/facebook/drawee/generic/RoundingParams;", "kmpimage_release"}, k = 2, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ImageUtilsKt {
    public static final ScalingUtils.ScaleType toFrescoScaleType(ImageScaleType imageScaleType) {
        ContentScale scaleType = imageScaleType != null ? imageScaleType.getScaleType() : null;
        if (Intrinsics.areEqual(scaleType, ContentScale.Companion.getCrop())) {
            return ScalingUtils.ScaleType.CENTER_CROP;
        }
        if (Intrinsics.areEqual(scaleType, ContentScale.Companion.getFit())) {
            return ScalingUtils.ScaleType.FIT_CENTER;
        }
        if (Intrinsics.areEqual(scaleType, ContentScale.Companion.getInside())) {
            return ScalingUtils.ScaleType.CENTER_INSIDE;
        }
        if (Intrinsics.areEqual(scaleType, ContentScale.Companion.getFillBounds())) {
            return ScalingUtils.ScaleType.FIT_XY;
        }
        return null;
    }

    public static final int getResourceId(KImageSource kImageSource) {
        Intrinsics.checkNotNullParameter(kImageSource, "<this>");
        if (kImageSource instanceof LocalResourceSource) {
            return ((LocalResourceSource) kImageSource).getResource().getId();
        }
        return 0;
    }

    public static final Drawable toDrawable(KImageSource kImageSource, Context context) {
        Intrinsics.checkNotNullParameter(kImageSource, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        if (kImageSource instanceof LocalResourceSource) {
            return context.getDrawable(((LocalResourceSource) kImageSource).getResource().getId());
        }
        if (kImageSource instanceof ColorSource) {
            return new ColorDrawable((int) ((ColorSource) kImageSource).getColor());
        }
        return null;
    }

    public static final RoundingParams toRoundingParams(ImageBorderOption imageBorderOption, Composer composer, int i) {
        composer.startReplaceGroup(1344577841);
        ComposerKt.sourceInformation(composer, "C(toRoundingParams)*67@2082L7:ImageUtils.kt#m2l8z6");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1344577841, i, -1, "com.bytedance.kmp.image.utils.toRoundingParams (ImageUtils.kt:62)");
        }
        if (imageBorderOption == null) {
            RoundingParams roundingParams = new RoundingParams();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return roundingParams;
        }
        RoundingParams roundingParams2 = new RoundingParams();
        CompositionLocal localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Density density = (Density) consume;
        roundingParams2.setCornersRadius(density.toPx-0680j_4(imageBorderOption.m654getRadiusD9Ej5fM()));
        roundingParams2.setBorder(ColorKt.toArgb-8_81llA(imageBorderOption.m652getBorderColor0d7_KjU()), density.toPx-0680j_4(imageBorderOption.m653getBorderWidthD9Ej5fM()));
        if (imageBorderOption.getAsCircle()) {
            roundingParams2.setRoundAsCircle(true);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return roundingParams2;
    }

    public static final BlurHashConfig toBlurHashConfig(ImageBlurOption imageBlurOption) {
        if (imageBlurOption == null) {
            return null;
        }
        return new BlurHashConfig(imageBlurOption.getRadius(), imageBlurOption.getRadius());
    }

    public static final Priority toFrescoPriority(com.bytedance.kmp.image.options.Priority priority) {
        Intrinsics.checkNotNullParameter(priority, "<this>");
        if (priority instanceof Priority.Low) {
            return com.facebook.imagepipeline.common.Priority.LOW;
        }
        if (priority instanceof Priority.Normal) {
            return com.facebook.imagepipeline.common.Priority.MEDIUM;
        }
        if (priority instanceof Priority.High) {
            return com.facebook.imagepipeline.common.Priority.HIGH;
        }
        throw new NoWhenBranchMatchedException();
    }
}
