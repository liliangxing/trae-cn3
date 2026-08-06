package com.bytedance.trae.home.solo.setting.p010ui.components;

import androidx.compose.foundation.ImageKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.layout.ContentScale;
import com.bytedance.kmp.image.KImage_androidKt;
import com.bytedance.kmp.image.options.ImageOptions;
import com.bytedance.kmp.image.options.ImagePlaceholder;
import com.bytedance.kmp.image.options.ImageScaleType;
import com.bytedance.kmp.image.options.UrlSource;
import com.bytedance.trae.home.generated.resources.Drawable0_commonMainKt;
import com.bytedance.trae.home.generated.resources.Res;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.compose.resources.ImageResources_androidKt;

/* compiled from: SettingsAvatar.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"SettingsAvatar", "", "avatarUrl", "", "modifier", "Landroidx/compose/ui/Modifier;", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "impl_mainlandRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class SettingsAvatarKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsAvatar$lambda$0(String str, Modifier modifier, int i, int i2, Composer composer, int i3) {
        SettingsAvatar(str, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsAvatar$lambda$1(String str, Modifier modifier, int i, int i2, Composer composer, int i3) {
        SettingsAvatar(str, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void SettingsAvatar(final String str, final Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Intrinsics.checkNotNullParameter(str, "avatarUrl");
        Composer startRestartGroup = composer.startRestartGroup(1895162476);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(modifier) ? 32 : 16;
        }
        if ((i3 & 19) != 18 || !startRestartGroup.getSkipping()) {
            if (i4 != 0) {
                modifier = (Modifier) Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1895162476, i3, -1, "com.bytedance.trae.home.solo.setting.ui.components.SettingsAvatar (SettingsAvatar.kt:19)");
            }
            startRestartGroup.startReplaceGroup(129263519);
            if (StringsKt.isBlank(str)) {
                ImageKt.Image(ImageResources_androidKt.painterResource(Drawable0_commonMainKt.getCmp_trae_default_avatar(Res.drawable.INSTANCE), startRestartGroup, 0), (String) null, modifier, (Alignment) null, ContentScale.Companion.getCrop(), 0.0f, (ColorFilter) null, startRestartGroup, ((i3 << 3) & 896) | 24624, 104);
                startRestartGroup.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: com.bytedance.trae.home.solo.setting.ui.components.SettingsAvatarKt$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj, Object obj2) {
                            Unit SettingsAvatar$lambda$0;
                            SettingsAvatar$lambda$0 = SettingsAvatarKt.SettingsAvatar$lambda$0(str, modifier, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            return SettingsAvatar$lambda$0;
                        }
                    });
                    return;
                }
                return;
            }
            startRestartGroup.endReplaceGroup();
            ImagePlaceholder ofResource$default = ImagePlaceholder.Companion.ofResource$default(ImagePlaceholder.Companion, Drawable0_commonMainKt.getCmp_trae_default_avatar(Res.drawable.INSTANCE), (ImageScaleType) null, 2, (Object) null);
            KImage_androidKt.KImage(new UrlSource(str), (String) null, (Alignment) null, ImageOptions.Companion.newInstance().scaleType(ImageScaleType.Companion.getCENTER_CROP()).borderAsCircle().loadingPlaceHolder(ofResource$default).errorPlaceHolder(ofResource$default), modifier, startRestartGroup, (i3 << 9) & 57344, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup2 = startRestartGroup.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.updateScope(new Function2() { // from class: com.bytedance.trae.home.solo.setting.ui.components.SettingsAvatarKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit SettingsAvatar$lambda$1;
                    SettingsAvatar$lambda$1 = SettingsAvatarKt.SettingsAvatar$lambda$1(str, modifier, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return SettingsAvatar$lambda$1;
                }
            });
        }
    }
}
