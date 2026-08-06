package androidx.compose.p001ui.precompose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* compiled from: PreComposeView.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\u0006\u001a\u00020\u00072\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00070\t¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u000b\"\u001f\u0010\u0000\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\f"}, d2 = {"LocalPreComposeStatus", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/precompose/PreComposeStatus;", "getLocalPreComposeStatus", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "OnPreComposeUsed", "", StrategyConstants.CONTENT, "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class PreComposeViewKt {
    private static final ProvidableCompositionLocal<State<PreComposeStatus>> LocalPreComposeStatus = CompositionLocalKt.staticCompositionLocalOf(new Function0<State<? extends PreComposeStatus>>() { // from class: androidx.compose.ui.precompose.PreComposeViewKt$LocalPreComposeStatus$1
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final State<PreComposeStatus> m1835invoke() {
            return null;
        }
    });

    public static final ProvidableCompositionLocal<State<PreComposeStatus>> getLocalPreComposeStatus() {
        return LocalPreComposeStatus;
    }

    public static final void OnPreComposeUsed(final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-755775782);
        ComposerKt.sourceInformation(startRestartGroup, "C(OnPreComposeUsed)52@1750L7:PreComposeView.kt#hnx0ug");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!startRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-755775782, i2, -1, "androidx.compose.ui.precompose.OnPreComposeUsed (PreComposeView.kt:51)");
            }
            CompositionLocal compositionLocal = LocalPreComposeStatus;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(compositionLocal);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            State state = (State) consume;
            PreComposeStatus preComposeStatus = state != null ? (PreComposeStatus) state.getValue() : null;
            if (preComposeStatus == null || preComposeStatus.compareTo(PreComposeStatus.USED) >= 0) {
                startRestartGroup.startReplaceGroup(-1097575601);
                ComposerKt.sourceInformation(startRestartGroup, "54@1834L9");
                function2.invoke(startRestartGroup, Integer.valueOf(i2 & 14));
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(-1097551576);
                startRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.precompose.PreComposeViewKt$OnPreComposeUsed$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    PreComposeViewKt.OnPreComposeUsed(function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }
}
