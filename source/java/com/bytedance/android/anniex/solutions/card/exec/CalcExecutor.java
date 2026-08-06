package com.bytedance.android.anniex.solutions.card.exec;

import androidx.webkit.ProxyConfig;
import com.bytedance.android.anniex.solutions.card.AirActionConstant;
import com.bytedance.android.anniex.solutions.card.model.Option;
import com.bytedance.android.anniex.solutions.card.model.OptionKt;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.LoggerContext;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CalcExecutor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/anniex/solutions/card/exec/CalcExecutor;", "", "()V", "calc", "option", "Lcom/bytedance/android/anniex/solutions/card/model/Option;", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class CalcExecutor {
    private static final String TAG = "AirSolution_CalcExecutor";

    public final Object calc(Option option) {
        Intrinsics.checkNotNullParameter(option, "option");
        if (Intrinsics.areEqual(option.getType(), AirActionConstant.ActionId.ACTION_ID_OPERATOR)) {
            List<Object> params = option.getParams();
            if (params == null) {
                return new Object();
            }
            if (Intrinsics.areEqual(option.getName(), "!")) {
                if (!params.isEmpty() && OptionKt.toBool(params.get(0))) {
                    r2 = false;
                }
                return Boolean.valueOf(r2);
            }
            if (Intrinsics.areEqual(option.getName(), "&&")) {
                if (params.isEmpty()) {
                    return false;
                }
                List<Object> list = params;
                if (!(list instanceof Collection) || !list.isEmpty()) {
                    Iterator<T> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        if (!OptionKt.toBool(it.next())) {
                            r2 = false;
                            break;
                        }
                    }
                }
                return Boolean.valueOf(r2);
            }
            if (Intrinsics.areEqual(option.getName(), "||")) {
                if (params.isEmpty()) {
                    return false;
                }
                List<Object> list2 = params;
                if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                    Iterator<T> it2 = list2.iterator();
                    while (it2.hasNext()) {
                        if (OptionKt.toBool(it2.next())) {
                            break;
                        }
                    }
                }
                r2 = false;
                return Boolean.valueOf(r2);
            }
            if (params.size() < 2) {
                HybridLogger.e$default(HybridLogger.INSTANCE, TAG, "error: size less then 2, " + params, (Map) null, (LoggerContext) null, 12, (Object) null);
                return new Object();
            }
            if (Intrinsics.areEqual(option.getName(), "t")) {
                if (params.size() >= 3) {
                    return OptionKt.toBool(params.get(0)) ? params.get(1) : params.get(2);
                }
                HybridLogger.e$default(HybridLogger.INSTANCE, TAG, "error: size less then 3, " + params, (Map) null, (LoggerContext) null, 12, (Object) null);
                return new Object();
            }
            if (!(params.get(0) instanceof Number) || !(params.get(1) instanceof Number)) {
                Object obj = params.get(0);
                Object obj2 = params.get(1);
                String name = option.getName();
                if (name != null) {
                    int hashCode = name.hashCode();
                    if (hashCode != 43) {
                        if (hashCode != 61) {
                            if (hashCode == 1084 && name.equals("!=")) {
                                return Boolean.valueOf(!Intrinsics.areEqual(obj, obj2));
                            }
                        } else if (name.equals("=")) {
                            return Boolean.valueOf(Intrinsics.areEqual(obj, obj2));
                        }
                    } else if (name.equals("+")) {
                        return ((obj instanceof String) || (obj2 instanceof String)) ? new StringBuilder().append(obj).append(obj2).toString() : new Object();
                    }
                }
                return false;
            }
            Object obj3 = params.get(0);
            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Number");
            double doubleValue = ((Number) obj3).doubleValue();
            Object obj4 = params.get(1);
            Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.Number");
            double doubleValue2 = ((Number) obj4).doubleValue();
            String name2 = option.getName();
            if (name2 != null) {
                int hashCode2 = name2.hashCode();
                if (hashCode2 != 42) {
                    if (hashCode2 != 43) {
                        if (hashCode2 != 45) {
                            if (hashCode2 != 47) {
                                if (hashCode2 != 1084) {
                                    if (hashCode2 != 1921) {
                                        if (hashCode2 != 1983) {
                                            switch (hashCode2) {
                                                case 60:
                                                    if (name2.equals("<")) {
                                                        return Boolean.valueOf(doubleValue < doubleValue2);
                                                    }
                                                    break;
                                                case 61:
                                                    if (name2.equals("=")) {
                                                        return Boolean.valueOf(doubleValue == doubleValue2);
                                                    }
                                                    break;
                                                case 62:
                                                    if (name2.equals(">")) {
                                                        return Boolean.valueOf(doubleValue > doubleValue2);
                                                    }
                                                    break;
                                            }
                                        } else if (name2.equals(">=")) {
                                            return Boolean.valueOf(doubleValue >= doubleValue2);
                                        }
                                    } else if (name2.equals("<=")) {
                                        return Boolean.valueOf(doubleValue <= doubleValue2);
                                    }
                                } else if (name2.equals("!=")) {
                                    return Boolean.valueOf(!(doubleValue == doubleValue2));
                                }
                            } else if (name2.equals("/")) {
                                return Double.valueOf(doubleValue / doubleValue2);
                            }
                        } else if (name2.equals("-")) {
                            return Double.valueOf(doubleValue - doubleValue2);
                        }
                    } else if (name2.equals("+")) {
                        return Double.valueOf(doubleValue + doubleValue2);
                    }
                } else if (name2.equals(ProxyConfig.MATCH_ALL_SCHEMES)) {
                    return Double.valueOf(doubleValue * doubleValue2);
                }
            }
        }
        return new Object();
    }
}
