package com.bytedance.android.anniex.solutions.card.exec;

import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.android.anniex.solutions.card.AirActionConstant;
import com.bytedance.android.anniex.solutions.card.AirSolutionContext;
import com.bytedance.android.anniex.solutions.card.data.DataCenter;
import com.bytedance.android.anniex.solutions.card.model.Actions;
import com.bytedance.android.anniex.solutions.card.model.Option;
import com.bytedance.android.anniex.solutions.card.util.GsonUtil;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.LoggerContext;
import com.bytedance.sdk.xbridge.cn.platform.lynx.LynxConvertUtils;
import com.lynx.react.bridge.JavaOnlyMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: ParamExecutor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0016B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J>\u0010\t\u001a\u0004\u0018\u00010\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\r2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\rH\u0002J&\u0010\u000f\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0010\u001a\u00020\u00062\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\rJ$\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\rJ2\u0010\u0011\u001a\u00020\u00122\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\r2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\rR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/anniex/solutions/card/exec/ParamExecutor;", "", "airSolutionContext", "Lcom/bytedance/android/anniex/solutions/card/AirSolutionContext;", "(Lcom/bytedance/android/anniex/solutions/card/AirSolutionContext;)V", "TAG", "", "calcExecutor", "Lcom/bytedance/android/anniex/solutions/card/exec/CalcExecutor;", "handleMapParams", "param", "Lcom/bytedance/android/anniex/solutions/card/exec/ParamExecutor$InnerParam;", "mapParam", "", "realArguments", "handleOp", "optionStr", "preExecute", "Lcom/lynx/react/bridge/JavaOnlyMap;", "jsb", "Lcom/bytedance/android/anniex/solutions/card/model/Actions$JSBAction;", "fields", "InnerParam", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class ParamExecutor {
    private final String TAG;
    private final AirSolutionContext airSolutionContext;
    private final CalcExecutor calcExecutor;

    public ParamExecutor(AirSolutionContext airSolutionContext) {
        Intrinsics.checkNotNullParameter(airSolutionContext, "airSolutionContext");
        this.airSolutionContext = airSolutionContext;
        this.TAG = "AirSolution_ParamExecutor";
        this.calcExecutor = new CalcExecutor();
    }

    public final JavaOnlyMap preExecute(Actions.JSBAction jsb, Map<String, ? extends Object> realArguments) {
        Intrinsics.checkNotNullParameter(jsb, "jsb");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Map<String, Object> params = jsb.getParams();
        if (params != null) {
            return preExecute((Map<String, ? extends Object>) params, realArguments);
        }
        return LynxConvertUtils.convertMapToJavaOnlyMap$default(linkedHashMap, 0, 2, (Object) null);
    }

    public final JavaOnlyMap preExecute(Map<String, ? extends Object> fields, Map<String, ? extends Object> realArguments) {
        Intrinsics.checkNotNullParameter(fields, "fields");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<Map.Entry<String, ? extends Object>> it = fields.entrySet().iterator();
        while (true) {
            Unit unit = null;
            if (it.hasNext()) {
                Map.Entry<String, ? extends Object> next = it.next();
                Object value = next.getValue();
                Map<String, ? extends Object> map = value instanceof Map ? (Map) value : null;
                if (map != null) {
                    if (map.containsKey(AirActionConstant.ActionId.ACTION_ID)) {
                        linkedHashMap.put(next.getKey(), handleMapParams(new InnerParam(map), map, realArguments));
                    } else {
                        linkedHashMap.put(next.getKey(), preExecute(map, realArguments));
                    }
                    unit = Unit.INSTANCE;
                }
                if (unit == null) {
                    linkedHashMap.put(next.getKey(), next.getValue());
                }
            } else {
                return LynxConvertUtils.convertMapToJavaOnlyMap$default(linkedHashMap, 0, 2, (Object) null);
            }
        }
    }

    private final Object handleMapParams(InnerParam param, Map<String, ? extends Object> mapParam, Map<String, ? extends Object> realArguments) {
        Object defaultValue;
        Object value;
        if (realArguments != null) {
            if (param.getParams() != null) {
                String params = param.getParams();
                if (StringsKt.startsWith$default(params, AirActionConstant.DataCenter.ACTION_DATA, false, 2, (Object) null)) {
                    DataCenter.Companion companion = DataCenter.INSTANCE;
                    if (params == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                    String substring = params.substring(7);
                    Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
                    return companion.getMemberValue(substring, realArguments);
                }
            }
            if (param.getName() != null) {
                String name = param.getName();
                if (realArguments.containsKey(name)) {
                    return realArguments.get(name);
                }
            }
        }
        Object defaultValue2 = param.getDefaultValue();
        Map map = defaultValue2 instanceof Map ? (Map) defaultValue2 : null;
        if (map == null || (defaultValue = preExecute(MapsKt.mapOf(TuplesKt.to(AirActionConstant.ActionId.ACTION_ID_DEFAULT_VALUE, map)), realArguments).get(AirActionConstant.ActionId.ACTION_ID_DEFAULT_VALUE)) == null) {
            defaultValue = param.getDefaultValue();
        }
        String id = param.getId();
        if (id != null) {
            int hashCode = id.hashCode();
            if (hashCode == 109) {
                if (!id.equals(AirActionConstant.ActionId.ACTION_ID_MEMBER) || param.getParams() == null) {
                    return null;
                }
                value = this.airSolutionContext.getDataCenter().getValue(param.getParams());
                if (value == null) {
                    return defaultValue;
                }
                return value;
            }
            if (hashCode == 112) {
                if (!id.equals(AirActionConstant.ActionId.ACTION_ID_PARAMS) || param.getName() == null) {
                    return null;
                }
                value = this.airSolutionContext.getDataCenter().getRuntimeData().get(param.getName());
                if (value == null) {
                    return defaultValue;
                }
                return value;
            }
            if (hashCode == 3553 && id.equals(AirActionConstant.ActionId.ACTION_ID_OPERATOR)) {
                String jSONObject = new JSONObject(mapParam).toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject, "JSONObject(mapParam).toString()");
                value = handleOp(jSONObject, realArguments);
                if (value == null) {
                    return defaultValue;
                }
                return value;
            }
        }
        return null;
    }

    public final Object handleOp(String optionStr, Map<String, ? extends Object> realArguments) {
        Object obj;
        Object obj2;
        Intrinsics.checkNotNullParameter(optionStr, "optionStr");
        try {
            Result.Companion companion = Result.Companion;
            ParamExecutor paramExecutor = this;
            obj = Result.constructor-impl((Option) GsonUtil.INSTANCE.fromJson(optionStr, Option.class));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.exceptionOrNull-impl(obj) != null) {
            HybridLogger.e$default(HybridLogger.INSTANCE, this.TAG, "optionStr parse failed: optionStr: " + optionStr, (Map) null, (LoggerContext) null, 12, (Object) null);
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        Option option = (Option) obj;
        if (option != null && option.getParams() != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj3 : option.getParams()) {
                boolean z = obj3 instanceof Map;
                if (z) {
                    Map<String, ? extends Object> map = z ? (Map) obj3 : null;
                    if (map != null) {
                        arrayList.add(handleMapParams(new InnerParam(map), map, realArguments));
                    }
                } else {
                    arrayList.add(obj3);
                }
            }
            Option copy$default = Option.copy$default(option, null, null, arrayList, 3, null);
            try {
                Result.Companion companion3 = Result.Companion;
                ParamExecutor paramExecutor2 = this;
                Object calc = this.calcExecutor.calc(copy$default);
                HybridLogger.i$default(HybridLogger.INSTANCE, this.TAG, "CalcExecutor calc result: finalOption: " + copy$default + ", result: " + calc, (Map) null, (LoggerContext) null, 12, (Object) null);
                obj2 = Result.constructor-impl(calc);
            } catch (Throwable th2) {
                Result.Companion companion4 = Result.Companion;
                obj2 = Result.constructor-impl(ResultKt.createFailure(th2));
            }
            if (Result.exceptionOrNull-impl(obj2) != null) {
                HybridLogger.e$default(HybridLogger.INSTANCE, this.TAG, "CalcExecutor calc failure... option is " + copy$default, (Map) null, (LoggerContext) null, 12, (Object) null);
            }
            if (Result.isFailure-impl(obj2)) {
                return null;
            }
            return obj2;
        }
        return new Object();
    }

    /* compiled from: ParamExecutor.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u001b\u0012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003¢\u0006\u0002\u0010\u0005R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/anniex/solutions/card/exec/ParamExecutor$InnerParam;", "", "field", "", "", "(Ljava/util/Map;)V", "defaultValue", "getDefaultValue", "()Ljava/lang/Object;", "id", "getId", "()Ljava/lang/String;", StrategyConstants.NAME, "getName", "params", "getParams", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static final class InnerParam {
        private final Object defaultValue;
        private final String id;
        private final String name;
        private final String params;

        public InnerParam(Map<String, ? extends Object> map) {
            Intrinsics.checkNotNullParameter(map, "field");
            Object obj = map.get(AirActionConstant.ActionId.ACTION_ID);
            this.id = obj instanceof String ? (String) obj : null;
            Object obj2 = map.get(AirActionConstant.ActionId.ACTION_ID_NAME);
            this.name = obj2 instanceof String ? (String) obj2 : null;
            Object obj3 = map.get(AirActionConstant.ActionId.ACTION_ID_PARAMS);
            this.params = obj3 instanceof String ? (String) obj3 : null;
            this.defaultValue = map.get(AirActionConstant.ActionId.ACTION_ID_DEFAULT_VALUE);
        }

        public final String getId() {
            return this.id;
        }

        public final String getName() {
            return this.name;
        }

        public final String getParams() {
            return this.params;
        }

        public final Object getDefaultValue() {
            return this.defaultValue;
        }
    }
}
