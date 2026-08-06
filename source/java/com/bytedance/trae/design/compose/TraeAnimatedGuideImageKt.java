package com.bytedance.trae.design.compose;

import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.unit.Dp;
import com.bytedance.kmp.image.KImage_androidKt;
import com.bytedance.kmp.image.options.AnimatedImageOptions;
import com.bytedance.kmp.image.options.ImageAnimationController;
import com.bytedance.kmp.image.options.ImageOptions;
import com.bytedance.kmp.image.options.ImageScaleType;
import com.bytedance.kmp.image.options.LocalResourceSource;
import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.DrawableResource;

/* compiled from: TraeAnimatedGuideImage.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a+\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"TraeAnimatedGuideImage", "", "resource", "Lorg/jetbrains/compose/resources/DrawableResource;", "modifier", "Landroidx/compose/ui/Modifier;", "cornerRadius", "Landroidx/compose/ui/unit/Dp;", "TraeAnimatedGuideImage-6a0pyJM", "(Lorg/jetbrains/compose/resources/DrawableResource;Landroidx/compose/ui/Modifier;FLandroidx/compose/runtime/Composer;II)V", "design-system-compose_mainlandRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TraeAnimatedGuideImageKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TraeAnimatedGuideImage_6a0pyJM$lambda$2(DrawableResource drawableResource, Modifier modifier, float f, int i, int i2, Composer composer, int i3) {
        m1581TraeAnimatedGuideImage6a0pyJM(drawableResource, modifier, f, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x009b, code lost:
    
        if (r1 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L55;
     */
    /* renamed from: TraeAnimatedGuideImage-6a0pyJM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1581TraeAnimatedGuideImage6a0pyJM(final DrawableResource drawableResource, Modifier modifier, float f, Composer composer, final int i, final int i2) {
        int i3;
        Object obj;
        Intrinsics.checkNotNullParameter(drawableResource, "resource");
        Composer startRestartGroup = composer.startRestartGroup(-285274387);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(drawableResource) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(modifier) ? 32 : 16;
        }
        int i5 = i2 & 4;
        if (i5 != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= startRestartGroup.changed(f) ? StatusBarUtils.FLAG_NOTCH_SUPPORT : 128;
        }
        if ((i3 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (i4 != 0) {
                modifier = (Modifier) Modifier.Companion;
            }
            if (i5 != 0) {
                f = Dp.constructor-impl(20);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-285274387, i3, -1, "com.bytedance.trae.design.compose.TraeAnimatedGuideImage (TraeAnimatedGuideImage.kt:22)");
            }
            startRestartGroup.startReplaceGroup(-2047180901);
            boolean z = (i3 & 14) == 4;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (!z) {
                obj = rememberedValue;
            }
            ImageOptions animateImageOptions = ImageOptions.Companion.newInstance().scaleType(ImageScaleType.Companion.getCENTER_CROP()).animateImageOptions(AnimatedImageOptions.Companion.newInstance().onControllerReady(new Function1() { // from class: com.bytedance.trae.design.compose.TraeAnimatedGuideImageKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj2) {
                    Unit TraeAnimatedGuideImage_6a0pyJM$lambda$1$lambda$0;
                    TraeAnimatedGuideImage_6a0pyJM$lambda$1$lambda$0 = TraeAnimatedGuideImageKt.TraeAnimatedGuideImage_6a0pyJM$lambda$1$lambda$0((ImageAnimationController) obj2);
                    return TraeAnimatedGuideImage_6a0pyJM$lambda$1$lambda$0;
                }
            }));
            startRestartGroup.updateRememberedValue(animateImageOptions);
            obj = animateImageOptions;
            startRestartGroup.endReplaceGroup();
            KImage_androidKt.KImage(new LocalResourceSource(drawableResource), (String) null, (Alignment) null, (ImageOptions) obj, ClipKt.clip(modifier, RoundedCornerShapeKt.RoundedCornerShape-0680j_4(f)), startRestartGroup, 48, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        final Modifier modifier2 = modifier;
        final float f2 = f;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.bytedance.trae.design.compose.TraeAnimatedGuideImageKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj2, Object obj3) {
                    Unit TraeAnimatedGuideImage_6a0pyJM$lambda$2;
                    TraeAnimatedGuideImage_6a0pyJM$lambda$2 = TraeAnimatedGuideImageKt.TraeAnimatedGuideImage_6a0pyJM$lambda$2(drawableResource, modifier2, f2, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                    return TraeAnimatedGuideImage_6a0pyJM$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TraeAnimatedGuideImage_6a0pyJM$lambda$1$lambda$0(ImageAnimationController imageAnimationController) {
        Intrinsics.checkNotNullParameter(imageAnimationController, "controller");
        imageAnimationController.setRepeatCount(-1);
        imageAnimationController.start();
        return Unit.INSTANCE;
    }
}
