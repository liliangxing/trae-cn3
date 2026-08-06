package androidx.compose.foundation.text.selection;

import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.geometry.Offset;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SelectionMagnifier.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class SelectionMagnifierKt$animatedSelectionMagnifier$1 implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ Function0<Offset> $magnifierCenter;
    final /* synthetic */ Function1<Function0<Offset>, Modifier> $platformMagnifier;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SelectionMagnifierKt$animatedSelectionMagnifier$1(Function0<Offset> function0, Function1<? super Function0<Offset>, ? extends Modifier> function1) {
        this.$magnifierCenter = function0;
        this.$platformMagnifier = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    public final Modifier invoke(Modifier modifier, Composer composer, int i) {
        final State rememberAnimatedMagnifierPosition;
        composer.startReplaceGroup(759876635);
        ComposerKt.sourceInformation(composer, "C64@2538L70,65@2647L18:SelectionMagnifier.kt#eksfi3");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(759876635, i, -1, "androidx.compose.foundation.text.selection.animatedSelectionMagnifier.<anonymous> (SelectionMagnifier.kt:64)");
        }
        rememberAnimatedMagnifierPosition = SelectionMagnifierKt.rememberAnimatedMagnifierPosition(this.$magnifierCenter, composer, 0);
        Function1<Function0<Offset>, Modifier> function1 = this.$platformMagnifier;
        ComposerKt.sourceInformationMarkerStart(composer, 97010317, "CC(remember):SelectionMagnifier.kt#9igjgp");
        boolean changed = composer.changed(rememberAnimatedMagnifierPosition);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function0() { // from class: androidx.compose.foundation.text.selection.SelectionMagnifierKt$animatedSelectionMagnifier$1$$ExternalSyntheticLambda0
                public final Object invoke() {
                    Offset invoke$lambda$2$lambda$1;
                    invoke$lambda$2$lambda$1 = SelectionMagnifierKt$animatedSelectionMagnifier$1.invoke$lambda$2$lambda$1(State.this);
                    return invoke$lambda$2$lambda$1;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        Modifier modifier2 = (Modifier) function1.invoke((Function0) rememberedValue);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return modifier2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Offset invoke$lambda$2$lambda$1(State state) {
        return Offset.m4582boximpl(invoke$lambda$0(state));
    }

    private static final long invoke$lambda$0(State<Offset> state) {
        return state.getValue().m4603unboximpl();
    }
}
