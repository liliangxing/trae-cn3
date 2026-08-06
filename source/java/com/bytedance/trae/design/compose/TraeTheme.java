package com.bytedance.trae.design.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import kotlin.Metadata;

/* compiled from: TraeComposeTokens.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t8G¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r8G¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/trae/design/compose/TraeTheme;", "", "<init>", "()V", "colors", "Lcom/bytedance/trae/design/compose/TraeColors;", "getColors", "(Landroidx/compose/runtime/Composer;I)Lcom/bytedance/trae/design/compose/TraeColors;", "typography", "Lcom/bytedance/trae/design/compose/TraeTypography;", "getTypography", "(Landroidx/compose/runtime/Composer;I)Lcom/bytedance/trae/design/compose/TraeTypography;", "dimens", "Lcom/bytedance/trae/design/compose/TraeDimens;", "getDimens", "(Landroidx/compose/runtime/Composer;I)Lcom/bytedance/trae/design/compose/TraeDimens;", "design-system-compose_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TraeTheme {
    public static final int $stable = 0;
    public static final TraeTheme INSTANCE = new TraeTheme();

    private TraeTheme() {
    }

    public final TraeColors getColors(Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-204283094, i, -1, "com.bytedance.trae.design.compose.TraeTheme.<get-colors> (TraeComposeTokens.kt:1425)");
        }
        CompositionLocal localTraeColors = TraeComposeTokensKt.getLocalTraeColors();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(localTraeColors);
        ComposerKt.sourceInformationMarkerEnd(composer);
        TraeColors traeColors = (TraeColors) consume;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return traeColors;
    }

    public final TraeTypography getTypography(Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(595971209, i, -1, "com.bytedance.trae.design.compose.TraeTheme.<get-typography> (TraeComposeTokens.kt:1430)");
        }
        CompositionLocal localTraeTypography = TraeComposeTokensKt.getLocalTraeTypography();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(localTraeTypography);
        ComposerKt.sourceInformationMarkerEnd(composer);
        TraeTypography traeTypography = (TraeTypography) consume;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return traeTypography;
    }

    public final TraeDimens getDimens(Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(133588956, i, -1, "com.bytedance.trae.design.compose.TraeTheme.<get-dimens> (TraeComposeTokens.kt:1435)");
        }
        CompositionLocal localTraeDimens = TraeComposeTokensKt.getLocalTraeDimens();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(localTraeDimens);
        ComposerKt.sourceInformationMarkerEnd(composer);
        TraeDimens traeDimens = (TraeDimens) consume;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return traeDimens;
    }
}
