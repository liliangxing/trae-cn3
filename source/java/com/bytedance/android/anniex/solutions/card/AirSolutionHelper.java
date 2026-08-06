package com.bytedance.android.anniex.solutions.card;

import com.bytedance.android.anniex.model.AnnieXLynxModel;
import com.bytedance.android.anniex.p026ui.AnnieXLynxView;
import com.bytedance.android.anniex.solutions.card.actions.AnnieXLynxViewExtension;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.LoggerContext;
import com.bytedance.sdk.xbridge.cn.platform.lynx.LynxBDXBridge;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AirSolutionHelper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u0004J\u001f\u0010\u000e\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/anniex/solutions/card/AirSolutionHelper;", "", "()V", "getAirSolution", "Lcom/bytedance/android/anniex/solutions/card/AirSolution;", "lynxView", "Lcom/bytedance/android/anniex/ui/AnnieXLynxView;", "lynxBDXBridge", "Lcom/bytedance/sdk/xbridge/cn/platform/lynx/LynxBDXBridge;", "lynxViewModel", "Lcom/bytedance/android/anniex/model/AnnieXLynxModel;", "setTapHandler", "", "airSolution", "setUpAirSolution", "(Lcom/bytedance/android/anniex/ui/AnnieXLynxView;Lcom/bytedance/android/anniex/solutions/card/AirSolution;)Lkotlin/Unit;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AirSolutionHelper {
    public static final AirSolutionHelper INSTANCE = new AirSolutionHelper();

    private AirSolutionHelper() {
    }

    public final AirSolution getAirSolution(AnnieXLynxView lynxView, LynxBDXBridge lynxBDXBridge, AnnieXLynxModel lynxViewModel) {
        Intrinsics.checkNotNullParameter(lynxView, "lynxView");
        Intrinsics.checkNotNullParameter(lynxBDXBridge, "lynxBDXBridge");
        Intrinsics.checkNotNullParameter(lynxViewModel, "lynxViewModel");
        try {
            Result.Companion companion = Result.Companion;
            AirSolutionHelper airSolutionHelper = this;
            String queryParameter = lynxViewModel.getOriginalUri().getQueryParameter("air_action_strategy");
            if ((queryParameter != null ? Integer.parseInt(queryParameter) : 0) == 1) {
                return new AirSolution(lynxView, lynxBDXBridge);
            }
            return null;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            if (Result.exceptionOrNull-impl(Result.constructor-impl(ResultKt.createFailure(th))) != null) {
                HybridLogger.e$default(HybridLogger.INSTANCE, "AirSolution", "air_action_strategy is illegal. schema:" + lynxViewModel.getOriginalUri(), (Map) null, (LoggerContext) null, 12, (Object) null);
            }
            return null;
        }
    }

    public final Unit setUpAirSolution(AnnieXLynxView lynxView, AirSolution airSolution) {
        Intrinsics.checkNotNullParameter(lynxView, "lynxView");
        if (airSolution == null) {
            return null;
        }
        airSolution.setup(lynxView);
        return Unit.INSTANCE;
    }

    public final void setTapHandler(AnnieXLynxView lynxView, AirSolution airSolution) {
        Intrinsics.checkNotNullParameter(lynxView, "lynxView");
        if (airSolution != null) {
            AnnieXLynxViewExtension.INSTANCE.setTapHandler(lynxView, airSolution);
        }
    }
}
