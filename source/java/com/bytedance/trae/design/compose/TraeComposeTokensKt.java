package com.bytedance.trae.design.compose;

import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TraeComposeTokens.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a*\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\f0\u0010¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0002\u0010\u0012\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0004\"\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0004¨\u0006\u0013"}, d2 = {"LocalTraeColors", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Lcom/bytedance/trae/design/compose/TraeColors;", "getLocalTraeColors", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "LocalTraeTypography", "Lcom/bytedance/trae/design/compose/TraeTypography;", "getLocalTraeTypography", "LocalTraeDimens", "Lcom/bytedance/trae/design/compose/TraeDimens;", "getLocalTraeDimens", "TraeDesignTheme", "", "darkTheme", "", ReportConstant.COMMON_CONTENT, "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "design-system-compose_mainlandRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TraeComposeTokensKt {
    private static final ProvidableCompositionLocal<TraeColors> LocalTraeColors = CompositionLocalKt.staticCompositionLocalOf(new Function0() { // from class: com.bytedance.trae.design.compose.TraeComposeTokensKt$$ExternalSyntheticLambda0
        public final Object invoke() {
            TraeColors LocalTraeColors$lambda$0;
            LocalTraeColors$lambda$0 = TraeComposeTokensKt.LocalTraeColors$lambda$0();
            return LocalTraeColors$lambda$0;
        }
    });
    private static final ProvidableCompositionLocal<TraeTypography> LocalTraeTypography = CompositionLocalKt.staticCompositionLocalOf(new Function0() { // from class: com.bytedance.trae.design.compose.TraeComposeTokensKt$$ExternalSyntheticLambda1
        public final Object invoke() {
            TraeTypography LocalTraeTypography$lambda$1;
            LocalTraeTypography$lambda$1 = TraeComposeTokensKt.LocalTraeTypography$lambda$1();
            return LocalTraeTypography$lambda$1;
        }
    });
    private static final ProvidableCompositionLocal<TraeDimens> LocalTraeDimens = CompositionLocalKt.staticCompositionLocalOf(new Function0() { // from class: com.bytedance.trae.design.compose.TraeComposeTokensKt$$ExternalSyntheticLambda2
        public final Object invoke() {
            TraeDimens LocalTraeDimens$lambda$2;
            LocalTraeDimens$lambda$2 = TraeComposeTokensKt.LocalTraeDimens$lambda$2();
            return LocalTraeDimens$lambda$2;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TraeDesignTheme$lambda$3(boolean z, Function2 function2, int i, int i2, Composer composer, int i3) {
        TraeDesignTheme(z, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TraeColors LocalTraeColors$lambda$0() {
        return TraeColorTokens.INSTANCE.getLight();
    }

    public static final ProvidableCompositionLocal<TraeColors> getLocalTraeColors() {
        return LocalTraeColors;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TraeTypography LocalTraeTypography$lambda$1() {
        return TraeTypographyTokens.INSTANCE.getDefault();
    }

    public static final ProvidableCompositionLocal<TraeTypography> getLocalTraeTypography() {
        return LocalTraeTypography;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TraeDimens LocalTraeDimens$lambda$2() {
        return TraeDimenTokens.INSTANCE.getDefault();
    }

    public static final ProvidableCompositionLocal<TraeDimens> getLocalTraeDimens() {
        return LocalTraeDimens;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x005e, code lost:
    
        if ((r10 & 1) != 0) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TraeDesignTheme(final boolean z, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        int i3;
        Intrinsics.checkNotNullParameter(function2, ReportConstant.COMMON_CONTENT);
        Composer startRestartGroup = composer.startRestartGroup(-1406825424);
        if ((i & 6) == 0) {
            i3 = (((i2 & 1) == 0 && startRestartGroup.changed(z)) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i3 & 19) != 18 || !startRestartGroup.getSkipping()) {
            startRestartGroup.startDefaults();
            if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                startRestartGroup.skipToGroupEnd();
            } else {
                if ((i2 & 1) != 0) {
                    z = DarkThemeKt.isSystemInDarkTheme(startRestartGroup, 0);
                    i3 &= -15;
                }
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1406825424, i3, -1, "com.bytedance.trae.design.compose.TraeDesignTheme (TraeComposeTokens.kt:1412)");
                }
                ProvidedValue[] providedValueArr = new ProvidedValue[3];
                ProvidableCompositionLocal<TraeColors> providableCompositionLocal = LocalTraeColors;
                TraeColorTokens traeColorTokens = TraeColorTokens.INSTANCE;
                providedValueArr[0] = providableCompositionLocal.provides(z ? traeColorTokens.getDark() : traeColorTokens.getLight());
                providedValueArr[1] = LocalTraeTypography.provides(TraeTypographyTokens.INSTANCE.getDefault());
                providedValueArr[2] = LocalTraeDimens.provides(TraeDimenTokens.INSTANCE.getDefault());
                CompositionLocalKt.CompositionLocalProvider(providedValueArr, function2, startRestartGroup, (i3 & 112) | ProvidedValue.$stable);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.bytedance.trae.design.compose.TraeComposeTokensKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit TraeDesignTheme$lambda$3;
                    TraeDesignTheme$lambda$3 = TraeComposeTokensKt.TraeDesignTheme$lambda$3(z, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return TraeDesignTheme$lambda$3;
                }
            });
        }
    }
}
