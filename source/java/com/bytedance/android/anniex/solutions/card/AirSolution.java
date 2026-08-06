package com.bytedance.android.anniex.solutions.card;

import com.bytedance.android.anniex.p026ui.AnnieXLynxView;
import com.bytedance.android.anniex.solutions.card.AirActionConstant;
import com.bytedance.android.anniex.solutions.card.dispatcher.ActionDispatcher;
import com.bytedance.android.anniex.solutions.card.model.Actions;
import com.bytedance.android.anniex.solutions.card.model.MetaContent;
import com.bytedance.android.anniex.solutions.card.util.GsonUtil;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.LoggerContext;
import com.bytedance.sdk.xbridge.cn.platform.lynx.LynxBDXBridge;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.TemplateData;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AirSolution.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J$\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0018J\u000e\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u001dJ\u001a\u0010\u001e\u001a\u00020\u00142\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\b\u0002\u0010!\u001a\u00020\u0010J&\u0010\u001e\u001a\u00020\u00142\u0014\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00182\b\b\u0002\u0010!\u001a\u00020\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/bytedance/android/anniex/solutions/card/AirSolution;", "", "lynxView", "Lcom/bytedance/android/anniex/ui/AnnieXLynxView;", "lynxBDXBridge", "Lcom/bytedance/sdk/xbridge/cn/platform/lynx/LynxBDXBridge;", "(Lcom/bytedance/android/anniex/ui/AnnieXLynxView;Lcom/bytedance/sdk/xbridge/cn/platform/lynx/LynxBDXBridge;)V", "actionDispatcher", "Lcom/bytedance/android/anniex/solutions/card/dispatcher/ActionDispatcher;", "getActionDispatcher", "()Lcom/bytedance/android/anniex/solutions/card/dispatcher/ActionDispatcher;", "airSolutionContext", "Lcom/bytedance/android/anniex/solutions/card/AirSolutionContext;", "getAirSolutionContext", "()Lcom/bytedance/android/anniex/solutions/card/AirSolutionContext;", "isInit", "", "metaContent", "Lcom/bytedance/android/anniex/solutions/card/model/MetaContent;", "dispatchAction", "", "actionName", "", "actionData", "", "dispatchLifecycle", "lifecycle", "Lcom/bytedance/android/anniex/solutions/card/AirActionConstant$AirSolutionLifecycle;", "setup", "Lcom/lynx/tasm/LynxView;", "updateInitData", "templateData", "Lcom/lynx/tasm/TemplateData;", "reset", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AirSolution {
    private final ActionDispatcher actionDispatcher;
    private final AirSolutionContext airSolutionContext;
    private volatile boolean isInit;
    private final AnnieXLynxView lynxView;
    private MetaContent metaContent;

    /* compiled from: AirSolution.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AirActionConstant.AirSolutionLifecycle.values().length];
            try {
                iArr[AirActionConstant.AirSolutionLifecycle.OnShow.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AirActionConstant.AirSolutionLifecycle.OnHide.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AirActionConstant.AirSolutionLifecycle.OnViewLoad.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public AirSolution(AnnieXLynxView annieXLynxView, LynxBDXBridge lynxBDXBridge) {
        Intrinsics.checkNotNullParameter(annieXLynxView, "lynxView");
        Intrinsics.checkNotNullParameter(lynxBDXBridge, "lynxBDXBridge");
        this.lynxView = annieXLynxView;
        this.airSolutionContext = new AirSolutionContext();
        this.actionDispatcher = new ActionDispatcher(annieXLynxView, lynxBDXBridge);
    }

    public final AirSolutionContext getAirSolutionContext() {
        return this.airSolutionContext;
    }

    public final ActionDispatcher getActionDispatcher() {
        return this.actionDispatcher;
    }

    public final void setup(LynxView lynxView) {
        JavaOnlyMap props;
        Object obj;
        Intrinsics.checkNotNullParameter(lynxView, "lynxView");
        if (this.isInit) {
            return;
        }
        LynxBaseUI findUIByIdSelector = lynxView.findUIByIdSelector(AirActionConstant.META_ROOT);
        if (findUIByIdSelector != null && (props = findUIByIdSelector.getProps()) != null) {
            String string = props.getString(AirActionConstant.META_DATA);
            try {
                Result.Companion companion = Result.Companion;
                AirSolution airSolution = this;
                GsonUtil gsonUtil = GsonUtil.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(string, "metaDataStr");
                this.metaContent = (MetaContent) gsonUtil.fromJson(string, MetaContent.class);
                obj = Result.constructor-impl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            if (Result.exceptionOrNull-impl(obj) != null) {
                HybridLogger.e$default(HybridLogger.INSTANCE, "AirSolution", "meta-data parse failed: metaDataStr: " + string, (Map) null, (LoggerContext) null, 12, (Object) null);
            }
            Result.box-impl(obj);
        }
        MetaContent metaContent = this.metaContent;
        if (metaContent != null) {
            this.airSolutionContext.setUp(metaContent);
            this.isInit = true;
        }
    }

    public static /* synthetic */ void updateInitData$default(AirSolution airSolution, TemplateData templateData, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        airSolution.updateInitData(templateData, z);
    }

    public final void updateInitData(TemplateData templateData, boolean reset) {
        boolean z = false;
        if (templateData != null && templateData.isEmpty()) {
            z = true;
        }
        if (z) {
            return;
        }
        Map<? extends String, ? extends Object> map = templateData != null ? templateData.toMap() : null;
        Map<? extends String, ? extends Object> map2 = map instanceof Map ? map : null;
        if (map2 != null) {
            if (reset) {
                this.airSolutionContext.getDataCenter().getInitData().clear();
            }
            this.airSolutionContext.getDataCenter().getInitData().putAll(map2);
        }
    }

    public static /* synthetic */ void updateInitData$default(AirSolution airSolution, Map map, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        airSolution.updateInitData((Map<String, ? extends Object>) map, z);
    }

    public final void updateInitData(Map<String, ? extends Object> templateData, boolean reset) {
        Intrinsics.checkNotNullParameter(templateData, "templateData");
        if (templateData.isEmpty()) {
            return;
        }
        if (reset) {
            this.airSolutionContext.getDataCenter().getInitData().clear();
        }
        this.airSolutionContext.getDataCenter().getInitData().putAll(templateData);
    }

    public final void dispatchLifecycle(AirActionConstant.AirSolutionLifecycle lifecycle) {
        Actions.HighExec onShow;
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        AirSolutionHelper.INSTANCE.setUpAirSolution(this.lynxView, this);
        int i = WhenMappings.$EnumSwitchMapping$0[lifecycle.ordinal()];
        if (i == 1) {
            MetaContent metaContent = this.metaContent;
            if (metaContent != null) {
                onShow = metaContent.getOnShow();
            }
            onShow = null;
        } else if (i == 2) {
            MetaContent metaContent2 = this.metaContent;
            if (metaContent2 != null) {
                onShow = metaContent2.getOnHide();
            }
            onShow = null;
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            MetaContent metaContent3 = this.metaContent;
            if (metaContent3 != null) {
                onShow = metaContent3.getOnViewLoad();
            }
            onShow = null;
        }
        if (onShow != null) {
            this.actionDispatcher.handleHighExecAction(null, onShow, this.airSolutionContext);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void dispatchAction$default(AirSolution airSolution, String str, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            map = MapsKt.emptyMap();
        }
        airSolution.dispatchAction(str, map);
    }

    public final void dispatchAction(String actionName, Map<String, ? extends Object> actionData) {
        Intrinsics.checkNotNullParameter(actionName, "actionName");
        Intrinsics.checkNotNullParameter(actionData, "actionData");
        AirSolutionHelper.INSTANCE.setUpAirSolution(this.lynxView, this);
        this.actionDispatcher.handleLifecycle(actionName, actionData, this.airSolutionContext);
    }
}
