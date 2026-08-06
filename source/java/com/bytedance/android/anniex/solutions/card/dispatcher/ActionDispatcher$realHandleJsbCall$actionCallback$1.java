package com.bytedance.android.anniex.solutions.card.dispatcher;

import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.android.anniex.solutions.card.AirSolutionContext;
import com.bytedance.android.anniex.solutions.card.dispatcher.ActionDispatcher;
import com.bytedance.android.anniex.solutions.card.model.Actions;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.LoggerContext;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ActionDispatcher.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001a\u0010\u0006\u001a\u00020\u00032\u0010\u0010\u0007\u001a\f\u0012\u0004\u0012\u00020\u0005\u0012\u0002\b\u00030\bH\u0016¨\u0006\t"}, d2 = {"com/bytedance/android/anniex/solutions/card/dispatcher/ActionDispatcher$realHandleJsbCall$actionCallback$1", "Lcom/bytedance/android/anniex/solutions/card/dispatcher/ActionDispatcher$ActionExecutorCallback;", "onFail", "", "reason", "", "onSuccess", StrategyConstants.RESULT, "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class ActionDispatcher$realHandleJsbCall$actionCallback$1 implements ActionDispatcher.ActionExecutorCallback {
    final /* synthetic */ String $actionName;
    final /* synthetic */ AirSolutionContext $airSolutionContext;
    final /* synthetic */ String $bridgeName;
    final /* synthetic */ Actions.HighExec $callback;
    final /* synthetic */ Map<String, Object> $realArguments;
    final /* synthetic */ ActionDispatcher this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ActionDispatcher$realHandleJsbCall$actionCallback$1(AirSolutionContext airSolutionContext, Actions.HighExec highExec, String str, ActionDispatcher actionDispatcher, Map<String, ? extends Object> map, String str2) {
        this.$airSolutionContext = airSolutionContext;
        this.$callback = highExec;
        this.$actionName = str;
        this.this$0 = actionDispatcher;
        this.$realArguments = map;
        this.$bridgeName = str2;
    }

    @Override // com.bytedance.android.anniex.solutions.card.dispatcher.ActionDispatcher.ActionExecutorCallback
    public void onSuccess(Map<String, ?> result) {
        Intrinsics.checkNotNullParameter(result, StrategyConstants.RESULT);
        this.$airSolutionContext.getDataCenter().getRuntimeData().put(this.$actionName, result);
        Actions.HighExec highExec = this.$callback;
        if (highExec != null) {
            this.this$0.handleHighExecAction(this.$realArguments, highExec, this.$airSolutionContext);
        }
    }

    @Override // com.bytedance.android.anniex.solutions.card.dispatcher.ActionDispatcher.ActionExecutorCallback
    public void onFail(String reason) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        HybridLogger.e$default(HybridLogger.INSTANCE, "AirSolution_ActionDispatcher", "jsb action failed, bridge name: " + this.$bridgeName + ", reason: " + reason, (Map) null, (LoggerContext) null, 12, (Object) null);
    }
}
