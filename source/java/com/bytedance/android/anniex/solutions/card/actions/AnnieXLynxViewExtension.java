package com.bytedance.android.anniex.solutions.card.actions;

import android.view.View;
import com.bytedance.android.anniex.p026ui.AnnieXLynxView;
import com.bytedance.android.anniex.solutions.card.AirActionConstant;
import com.bytedance.android.anniex.solutions.card.AirSolution;
import com.bytedance.android.anniex.solutions.card.model.Actions;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.LoggerContext;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnieXLynxViewExtension.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0012\u0010\u000b\u001a\u00020\u0004*\u00020\u00062\u0006\u0010\t\u001a\u00020\n¨\u0006\f"}, d2 = {"Lcom/bytedance/android/anniex/solutions/card/actions/AnnieXLynxViewExtension;", "", "()V", "innerSetTapHandler", "", "view", "Lcom/bytedance/android/anniex/ui/AnnieXLynxView;", "ui", "Lcom/lynx/tasm/behavior/ui/LynxBaseUI;", "airSolution", "Lcom/bytedance/android/anniex/solutions/card/AirSolution;", "setTapHandler", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXLynxViewExtension {
    public static final AnnieXLynxViewExtension INSTANCE = new AnnieXLynxViewExtension();

    private AnnieXLynxViewExtension() {
    }

    public final void setTapHandler(AnnieXLynxView annieXLynxView, AirSolution airSolution) {
        Unit unit;
        Intrinsics.checkNotNullParameter(annieXLynxView, "<this>");
        Intrinsics.checkNotNullParameter(airSolution, "airSolution");
        LynxBaseUI lynxUIRoot = annieXLynxView.getLynxUIRoot();
        if (lynxUIRoot != null) {
            INSTANCE.innerSetTapHandler(annieXLynxView, lynxUIRoot, airSolution);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            HybridLogger.e$default(HybridLogger.INSTANCE, "AirSolution", "setTapHandler: annieXLynxView: " + annieXLynxView + ", lynxUIRoot is null!", (Map) null, (LoggerContext) null, 12, (Object) null);
        }
    }

    private final void innerSetTapHandler(AnnieXLynxView view, LynxBaseUI ui, final AirSolution airSolution) {
        final LynxUI lynxUI = ui instanceof LynxUI ? (LynxUI) ui : null;
        if (lynxUI != null) {
            lynxUI.getView().setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.android.anniex.solutions.card.actions.AnnieXLynxViewExtension$innerSetTapHandler$1$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    String string = lynxUI.getProps().getString(AirActionConstant.BIND_TAP);
                    if (string != null) {
                        AirSolution airSolution2 = airSolution;
                        Pair<String, Map<String, Object>> parseLifecycleAction = Actions.INSTANCE.parseLifecycleAction(string);
                        airSolution2.dispatchAction((String) parseLifecycleAction.getFirst(), (Map) parseLifecycleAction.getSecond());
                    }
                    Object parent = view2.getParent();
                    View view3 = parent instanceof View ? (View) parent : null;
                    if (view3 == null || lynxUI.getProps().containsKey(AirActionConstant.X_STOP)) {
                        return;
                    }
                    view3.performClick();
                }
            });
        }
        if (ui.getChildren().size() > 0) {
            int size = ui.getChildren().size();
            for (int i = 0; i < size; i++) {
                LynxBaseUI childAt = ui.getChildAt(i);
                if (childAt != null) {
                    innerSetTapHandler(view, childAt, airSolution);
                }
            }
        }
    }
}
