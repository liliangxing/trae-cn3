package com.bytedance.android.anniex.solutions.card.exec;

import com.bytedance.android.anniex.solutions.card.AirSolutionContext;
import com.bytedance.android.anniex.solutions.card.dispatcher.ActionDispatcher;
import com.bytedance.android.anniex.solutions.card.model.Actions;
import com.bytedance.android.anniex.solutions.card.model.Expression;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HighExecExecutor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J,\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0001\u0018\u00010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/anniex/solutions/card/exec/HighExecExecutor;", "", "airSolutionContext", "Lcom/bytedance/android/anniex/solutions/card/AirSolutionContext;", "(Lcom/bytedance/android/anniex/solutions/card/AirSolutionContext;)V", "execute", "", "actionDispatcher", "Lcom/bytedance/android/anniex/solutions/card/dispatcher/ActionDispatcher;", "highExec", "Lcom/bytedance/android/anniex/solutions/card/model/Actions$HighExec;", "realArguments", "", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class HighExecExecutor {
    private final AirSolutionContext airSolutionContext;

    public HighExecExecutor(AirSolutionContext airSolutionContext) {
        Intrinsics.checkNotNullParameter(airSolutionContext, "airSolutionContext");
        this.airSolutionContext = airSolutionContext;
    }

    public final void execute(ActionDispatcher actionDispatcher, Actions.HighExec highExec, Map<String, ? extends Object> realArguments) {
        List<Expression> block;
        List<Expression> block2;
        Intrinsics.checkNotNullParameter(actionDispatcher, "actionDispatcher");
        Intrinsics.checkNotNullParameter(highExec, "highExec");
        List<Expression> expression = highExec.getExpression();
        if (expression != null) {
            Iterator<T> it = expression.iterator();
            while (it.hasNext()) {
                this.airSolutionContext.getExpressionExecutor().execute(actionDispatcher, (Expression) it.next(), realArguments);
            }
        }
        Actions.ConditionBlock ifBlock = highExec.getIfBlock();
        if (ifBlock != null) {
            if (this.airSolutionContext.getExpressionExecutor().simpleIfExecute(ifBlock.getBlock(), realArguments)) {
                Actions.ConditionBlock thenBlock = highExec.getThenBlock();
                if (thenBlock == null || (block2 = thenBlock.getBlock()) == null) {
                    return;
                }
                Iterator<T> it2 = block2.iterator();
                while (it2.hasNext()) {
                    this.airSolutionContext.getExpressionExecutor().execute(actionDispatcher, (Expression) it2.next(), realArguments);
                }
                return;
            }
            Actions.ConditionBlock elseBlock = highExec.getElseBlock();
            if (elseBlock == null || (block = elseBlock.getBlock()) == null) {
                return;
            }
            Iterator<T> it3 = block.iterator();
            while (it3.hasNext()) {
                this.airSolutionContext.getExpressionExecutor().execute(actionDispatcher, (Expression) it3.next(), realArguments);
            }
        }
    }
}
