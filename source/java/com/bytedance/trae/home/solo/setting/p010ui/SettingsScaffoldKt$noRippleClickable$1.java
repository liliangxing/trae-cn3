package com.bytedance.trae.home.solo.setting.p010ui;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.Role;
import com.bytedance.trae.kmp.ui.KmpClickHandler;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SettingsScaffold.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
final class SettingsScaffoldKt$noRippleClickable$1 implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ KmpClickHandler $clickHandler;
    final /* synthetic */ Function0<Unit> $onClick;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SettingsScaffoldKt$noRippleClickable$1(KmpClickHandler kmpClickHandler, Function0<Unit> function0) {
        this.$clickHandler = kmpClickHandler;
        this.$onClick = function0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x005d, code lost:
    
        if (r7 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Modifier invoke(Modifier modifier, Composer composer, int i) {
        Object obj;
        Intrinsics.checkNotNullParameter(modifier, "$this$composed");
        composer.startReplaceGroup(918065666);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(918065666, i, -1, "com.bytedance.trae.home.solo.setting.ui.noRippleClickable.<anonymous> (SettingsScaffold.kt:65)");
        }
        composer.startReplaceGroup(414186839);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = InteractionSourceKt.MutableInteractionSource();
            composer.updateRememberedValue(rememberedValue);
        }
        MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) rememberedValue;
        composer.endReplaceGroup();
        composer.startReplaceGroup(414189587);
        boolean changedInstance = composer.changedInstance(this.$clickHandler) | composer.changed(this.$onClick);
        final KmpClickHandler kmpClickHandler = this.$clickHandler;
        final Function0<Unit> function0 = this.$onClick;
        Object rememberedValue2 = composer.rememberedValue();
        if (!changedInstance) {
            obj = rememberedValue2;
        }
        Function0 function02 = new Function0() { // from class: com.bytedance.trae.home.solo.setting.ui.SettingsScaffoldKt$noRippleClickable$1$$ExternalSyntheticLambda0
            public final Object invoke() {
                Unit invoke$lambda$2$lambda$1;
                invoke$lambda$2$lambda$1 = SettingsScaffoldKt$noRippleClickable$1.invoke$lambda$2$lambda$1(kmpClickHandler, function0);
                return invoke$lambda$2$lambda$1;
            }
        };
        composer.updateRememberedValue(function02);
        obj = function02;
        composer.endReplaceGroup();
        Modifier modifier2 = ClickableKt.clickable-O2vRcR0$default(modifier, mutableInteractionSource, (Indication) null, false, (String) null, (Role) null, (Function0) obj, 28, (Object) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return modifier2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$2$lambda$1(KmpClickHandler kmpClickHandler, Function0 function0) {
        kmpClickHandler.tryHandle(function0);
        return Unit.INSTANCE;
    }
}
