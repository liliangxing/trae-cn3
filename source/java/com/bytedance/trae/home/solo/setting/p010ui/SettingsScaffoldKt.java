package com.bytedance.trae.home.solo.setting.p010ui;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import com.bytedance.trae.design.compose.TraeColors;
import com.bytedance.trae.design.compose.TraeTheme;
import com.bytedance.trae.kmp.ui.KmpClickHandler;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SettingsScaffold.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0002\u001a\"\u0010\u0003\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0000¨\u0006\n"}, d2 = {"settingsEntryPalette", "Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;", "(Landroidx/compose/runtime/Composer;I)Lcom/bytedance/trae/home/solo/setting/ui/SettingsEntryPalette;", "noRippleClickable", "Landroidx/compose/ui/Modifier;", "clickHandler", "Lcom/bytedance/trae/kmp/ui/KmpClickHandler;", "onClick", "Lkotlin/Function0;", "", "impl_mainlandRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class SettingsScaffoldKt {
    public static final SettingsEntryPalette settingsEntryPalette(Composer composer, int i) {
        composer.startReplaceGroup(-983321225);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-983321225, i, -1, "com.bytedance.trae.home.solo.setting.ui.settingsEntryPalette (SettingsScaffold.kt:36)");
        }
        TraeColors colors = TraeTheme.INSTANCE.getColors(composer, TraeTheme.$stable);
        SettingsEntryPalette settingsEntryPalette = new SettingsEntryPalette(colors.mo1593getBgBgBaseSecondary0d7_KjU(), colors.mo1592getBgBgBaseDefault0d7_KjU(), colors.mo1806getTextTextDefault0d7_KjU(), colors.mo1813getTextTextTertiary0d7_KjU(), colors.mo1599getBgBgBrandPopup0d7_KjU(), colors.mo1804getTextTextBrand0d7_KjU(), colors.mo1606getBgBgOverlayL20d7_KjU(), colors.mo1811getTextTextSecondary0d7_KjU(), colors.mo1794getStatusSuccessDefault0d7_KjU(), colors.mo1773getSpecialWhite0d7_KjU(), colors.mo1601getBgBgInvert0d7_KjU(), colors.mo1809getTextTextOnaccent0d7_KjU(), colors.mo1788getStatusPrimaryDefault0d7_KjU(), colors.mo1773getSpecialWhite0d7_KjU(), colors.mo1606getBgBgOverlayL20d7_KjU(), colors.mo1751getIconIconDefault0d7_KjU(), colors.mo1758getIconIconTertiary0d7_KjU(), colors.mo1613getBorderBorderNeutralL10d7_KjU(), colors.mo1610getBgBgWhite0d7_KjU(), null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return settingsEntryPalette;
    }

    public static final Modifier noRippleClickable(Modifier modifier, KmpClickHandler kmpClickHandler, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(kmpClickHandler, "clickHandler");
        Intrinsics.checkNotNullParameter(function0, "onClick");
        return ComposedModifierKt.composed$default(modifier, (Function1) null, new SettingsScaffoldKt$noRippleClickable$1(kmpClickHandler, function0), 1, (Object) null);
    }
}
