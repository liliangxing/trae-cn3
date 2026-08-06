package org.jetbrains.compose.resources;

import android.content.Context;
import android.content.res.AssetManager;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.text.font.AndroidFontKt;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontVariation;
import androidx.compose.ui.text.font.FontWeight;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FontResources.android.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a+\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Font", "Landroidx/compose/ui/text/font/Font;", "resource", "Lorg/jetbrains/compose/resources/FontResource;", "weight", "Landroidx/compose/ui/text/font/FontWeight;", "style", "Landroidx/compose/ui/text/font/FontStyle;", "Font-DnXFreY", "(Lorg/jetbrains/compose/resources/FontResource;Landroidx/compose/ui/text/font/FontWeight;ILandroidx/compose/runtime/Composer;II)Landroidx/compose/ui/text/font/Font;", "library_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes9.dex */
public final class FontResources_androidKt {
    /* renamed from: Font-DnXFreY, reason: not valid java name */
    public static final Font m0FontDnXFreY(FontResource fontResource, FontWeight fontWeight, int i, Composer composer, int i2, int i3) {
        Intrinsics.checkNotNullParameter(fontResource, "resource");
        composer.startReplaceableGroup(1348157200);
        if ((i3 & 2) != 0) {
            fontWeight = FontWeight.Companion.getNormal();
        }
        FontWeight fontWeight2 = fontWeight;
        if ((i3 & 4) != 0) {
            i = FontStyle.Companion.getNormal-_-LCdwA();
        }
        int i4 = i;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1348157200, i2, -1, "org.jetbrains.compose.resources.Font (FontResources.android.kt:15)");
        }
        String path = fontResource.getPath();
        CompositionLocal localContext = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(localContext);
        ComposerKt.sourceInformationMarkerEnd(composer);
        AssetManager assets = ((Context) consume).getAssets();
        Intrinsics.checkNotNullExpressionValue(assets, "getAssets(...)");
        Font font = AndroidFontKt.Font-MuC2MFs$default(path, assets, fontWeight2, i4, (FontVariation.Settings) null, 16, (Object) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return font;
    }
}
