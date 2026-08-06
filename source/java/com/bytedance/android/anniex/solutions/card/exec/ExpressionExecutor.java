package com.bytedance.android.anniex.solutions.card.exec;

import com.bytedance.android.anniex.solutions.card.AirActionConstant;
import com.bytedance.android.anniex.solutions.card.AirSolutionContext;
import com.bytedance.android.anniex.solutions.card.dispatcher.ActionDispatcher;
import com.bytedance.android.anniex.solutions.card.model.Expression;
import com.lynx.react.bridge.JavaOnlyMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: ExpressionExecutor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J,\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0001\u0018\u00010\fJ\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\nH\u0002J,\u0010\u000f\u001a\u00020\u00102\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00112\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0001\u0018\u00010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/anniex/solutions/card/exec/ExpressionExecutor;", "", "airSolutionContext", "Lcom/bytedance/android/anniex/solutions/card/AirSolutionContext;", "(Lcom/bytedance/android/anniex/solutions/card/AirSolutionContext;)V", "execute", "", "actionDispatcher", "Lcom/bytedance/android/anniex/solutions/card/dispatcher/ActionDispatcher;", "expression", "Lcom/bytedance/android/anniex/solutions/card/model/Expression;", "realArguments", "", "", "expressionToOptionStr", "simpleIfExecute", "", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class ExpressionExecutor {
    private final AirSolutionContext airSolutionContext;

    public ExpressionExecutor(AirSolutionContext airSolutionContext) {
        Intrinsics.checkNotNullParameter(airSolutionContext, "airSolutionContext");
        this.airSolutionContext = airSolutionContext;
    }

    public final void execute(ActionDispatcher actionDispatcher, Expression expression, Map<String, ? extends Object> realArguments) {
        String name;
        Intrinsics.checkNotNullParameter(actionDispatcher, "actionDispatcher");
        Intrinsics.checkNotNullParameter(expression, "expression");
        if (!Intrinsics.areEqual(expression.getId(), AirActionConstant.ActionId.ACTION_ID_CALL) || (name = expression.getName()) == null) {
            return;
        }
        JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
        Object param = expression.getParam();
        Map<String, ? extends Object> map = param instanceof Map ? (Map) param : null;
        if (map != null) {
            javaOnlyMap = this.airSolutionContext.getParamEE().preExecute(map, realArguments);
        }
        if (Intrinsics.areEqual(AirActionConstant.ActionId.ACTION_ID_NAME_SET_DATA, name)) {
            actionDispatcher.updateData(this.airSolutionContext, (Map) javaOnlyMap);
        } else {
            actionDispatcher.handleLifecycle(name, (Map) javaOnlyMap, this.airSolutionContext);
        }
    }

    public final boolean simpleIfExecute(List<Expression> expression, Map<String, ? extends Object> realArguments) {
        if (expression == null) {
            return false;
        }
        Expression expression2 = expression.get(0);
        if (Intrinsics.areEqual(AirActionConstant.ActionId.ACTION_ID_OPERATOR, expression2.getId())) {
            Object handleOp = this.airSolutionContext.getParamEE().handleOp(expressionToOptionStr(expression2), realArguments);
            Boolean bool = handleOp instanceof Boolean ? (Boolean) handleOp : null;
            if (bool != null) {
                return bool.booleanValue();
            }
        }
        return false;
    }

    private final String expressionToOptionStr(Expression expression) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String id = expression.getId();
        if (id != null) {
            linkedHashMap.put(AirActionConstant.ActionId.ACTION_ID, id);
        }
        String name = expression.getName();
        if (name != null) {
            linkedHashMap.put(AirActionConstant.ActionId.ACTION_ID_NAME, name);
        }
        Object param = expression.getParam();
        if (param != null) {
            linkedHashMap.put(AirActionConstant.ActionId.ACTION_ID_PARAMS, param);
        }
        String jSONObject = new JSONObject(linkedHashMap).toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "JSONObject(resMap).toString()");
        return jSONObject;
    }
}
