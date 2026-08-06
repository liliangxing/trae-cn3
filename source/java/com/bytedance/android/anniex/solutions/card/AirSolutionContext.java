package com.bytedance.android.anniex.solutions.card;

import com.bytedance.android.anniex.solutions.card.data.DataCenter;
import com.bytedance.android.anniex.solutions.card.exec.ExpressionExecutor;
import com.bytedance.android.anniex.solutions.card.exec.HighExecExecutor;
import com.bytedance.android.anniex.solutions.card.exec.ParamExecutor;
import com.bytedance.android.anniex.solutions.card.model.Actions;
import com.bytedance.android.anniex.solutions.card.model.MetaContent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AirSolutionContext.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010\u0019\u001a\u00020\u001aR:\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00042\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R:\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00042\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\tR\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001b\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lcom/bytedance/android/anniex/solutions/card/AirSolutionContext;", "", "()V", "<set-?>", "", "", "Lcom/bytedance/android/anniex/solutions/card/model/Actions$JSBAction;", "actions", "getActions", "()Ljava/util/Map;", "dataCenter", "Lcom/bytedance/android/anniex/solutions/card/data/DataCenter;", "getDataCenter", "()Lcom/bytedance/android/anniex/solutions/card/data/DataCenter;", "expressionExecutor", "Lcom/bytedance/android/anniex/solutions/card/exec/ExpressionExecutor;", "getExpressionExecutor", "()Lcom/bytedance/android/anniex/solutions/card/exec/ExpressionExecutor;", "highEE", "Lcom/bytedance/android/anniex/solutions/card/exec/HighExecExecutor;", "getHighEE", "()Lcom/bytedance/android/anniex/solutions/card/exec/HighExecExecutor;", "Lcom/bytedance/android/anniex/solutions/card/model/Actions$HighExec;", "highExecActions", "getHighExecActions", "metaContent", "Lcom/bytedance/android/anniex/solutions/card/model/MetaContent;", "paramEE", "Lcom/bytedance/android/anniex/solutions/card/exec/ParamExecutor;", "getParamEE", "()Lcom/bytedance/android/anniex/solutions/card/exec/ParamExecutor;", "setUp", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AirSolutionContext {
    private Map<String, Actions.JSBAction> actions;
    private Map<String, Actions.HighExec> highExecActions;
    private MetaContent metaContent;
    private final DataCenter dataCenter = new DataCenter();
    private final ParamExecutor paramEE = new ParamExecutor(this);
    private final HighExecExecutor highEE = new HighExecExecutor(this);
    private final ExpressionExecutor expressionExecutor = new ExpressionExecutor(this);

    public final Map<String, Actions.JSBAction> getActions() {
        return this.actions;
    }

    public final Map<String, Actions.HighExec> getHighExecActions() {
        return this.highExecActions;
    }

    public final DataCenter getDataCenter() {
        return this.dataCenter;
    }

    public final ParamExecutor getParamEE() {
        return this.paramEE;
    }

    public final HighExecExecutor getHighEE() {
        return this.highEE;
    }

    public final ExpressionExecutor getExpressionExecutor() {
        return this.expressionExecutor;
    }

    public final void setUp(MetaContent metaContent) {
        Intrinsics.checkNotNullParameter(metaContent, "metaContent");
        this.metaContent = metaContent;
        this.actions = metaContent.getJsb();
        this.highExecActions = metaContent.getActions();
        Map<String, Object> data = metaContent.getData();
        if (data != null) {
            this.dataCenter.getInitData().putAll(data);
        }
    }
}
