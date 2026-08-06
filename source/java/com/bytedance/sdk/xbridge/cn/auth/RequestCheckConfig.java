package com.bytedance.sdk.xbridge.cn.auth;

import com.bytedance.librarian.LibrarianImpl;
import com.bytedance.sdk.xbridge.cn.auth.bean.RequestCheckAction;
import com.bytedance.sdk.xbridge.cn.auth.bean.RequestCheckResult;
import com.bytedance.sdk.xbridge.cn.auth.bean.RequestCheckUnit;
import com.bytedance.sdk.xbridge.cn.auth.repository.AuthStrategyRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: RequestCheckConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J,\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\n\u0012\f\u0012\n\u0018\u00010\u000bj\u0004\u0018\u0001`\f0\t2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005H\u0002J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0011\u001a\u00020\u0005H\u0002R*\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/auth/RequestCheckConfig;", "", "()V", "cachedUnits", "Ljava/util/HashMap;", "", "Lcom/bytedance/sdk/xbridge/cn/auth/bean/RequestCheckUnit;", "Lkotlin/collections/HashMap;", "performRule", "Lkotlin/Pair;", "", "Ljava/lang/Exception;", "Lkotlin/Exception;", "rule", "value", "requestCheckForMethod", "Lcom/bytedance/sdk/xbridge/cn/auth/bean/RequestCheckResult;", "method", "parameters", "Lorg/json/JSONObject;", "unitForMethod", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public final class RequestCheckConfig {
    private final HashMap<String, RequestCheckUnit> cachedUnits = new HashMap<>();

    public final RequestCheckResult requestCheckForMethod(String method, JSONObject parameters) {
        RequestCheckUnit unitForMethod;
        boolean z;
        boolean z2;
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        RequestCheckResult requestCheckResult = new RequestCheckResult(RequestCheckAction.DISABLE, true, null, null, null, 28, null);
        Map<String, Map<String, Object>> requestCheckMethods = AuthStrategyRepository.INSTANCE.getRequestCheckMethods();
        if (requestCheckMethods != null && requestCheckMethods.isEmpty()) {
            requestCheckResult.setAction(RequestCheckAction.TOGGLE_OFF);
            return requestCheckResult;
        }
        if (!(method.length() == 0) && (unitForMethod = unitForMethod(method)) != null) {
            requestCheckResult.setAction(unitForMethod.getAction());
            if (unitForMethod.getAction() == RequestCheckAction.DISABLE) {
                return requestCheckResult;
            }
            if (unitForMethod.getAction() != RequestCheckAction.CHECK && unitForMethod.getAction() != RequestCheckAction.REPORT_ONLY) {
                return requestCheckResult;
            }
            LinkedHashSet<String> linkedHashSet = new LinkedHashSet();
            Set<String> keySet = unitForMethod.getNeedMatches().keySet();
            Intrinsics.checkNotNullExpressionValue(keySet, "unit.needMatches.keys");
            linkedHashSet.addAll(keySet);
            Set<String> keySet2 = unitForMethod.getNeedExcludes().keySet();
            Intrinsics.checkNotNullExpressionValue(keySet2, "unit.needExcludes.keys");
            linkedHashSet.addAll(keySet2);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (String str : linkedHashSet) {
                Object obj = parameters;
                for (String str2 : StringsKt.split$default((CharSequence) str, new String[]{LibrarianImpl.Constants.DOT}, false, 0, 6, (Object) null)) {
                    if (obj == null || !(obj instanceof JSONObject)) {
                        break;
                    }
                    obj = ((JSONObject) obj).opt(str2);
                }
                if (obj != null) {
                    if (obj instanceof String) {
                        linkedHashMap.put(str, obj);
                    } else {
                        String simpleName = obj.getClass().getSimpleName();
                        Intrinsics.checkNotNullExpressionValue(simpleName, "value::class.java.simpleName");
                        linkedHashMap2.put(str, simpleName);
                    }
                } else {
                    linkedHashMap2.put(str, "null");
                }
            }
            if (!linkedHashMap.isEmpty()) {
                requestCheckResult.setTrackingInfo(linkedHashMap);
            }
            if (!linkedHashMap2.isEmpty()) {
                requestCheckResult.setTrackingWarn(linkedHashMap2);
            }
            String str3 = null;
            String str4 = null;
            Exception exc = null;
            loop2: while (true) {
                for (Map.Entry entry : linkedHashMap.entrySet()) {
                    String str5 = (String) entry.getKey();
                    String str6 = (String) entry.getValue();
                    if (!z) {
                        break loop2;
                    }
                    ArrayList<String> arrayList = unitForMethod.getNeedExcludes().get(str5);
                    if (arrayList != null) {
                        z2 = true;
                        for (String str7 : arrayList) {
                            if (z2) {
                                Pair<Boolean, Exception> performRule = performRule(str7, str6);
                                boolean booleanValue = performRule.component1().booleanValue();
                                Exception component2 = performRule.component2();
                                if (booleanValue) {
                                    str4 = str5 + " [exclude_reg]: " + str7;
                                    z2 = false;
                                }
                                if (component2 != null) {
                                    exc = component2;
                                }
                            }
                        }
                    } else {
                        z2 = true;
                    }
                    z = z && z2;
                    if (!z) {
                        break loop2;
                    }
                    ArrayList<String> arrayList2 = unitForMethod.getNeedMatches().get(str5);
                    boolean z3 = arrayList2 != null && arrayList2.isEmpty();
                    ArrayList<String> arrayList3 = unitForMethod.getNeedMatches().get(str5);
                    if (arrayList3 != null) {
                        for (String str8 : arrayList3) {
                            if (!z3) {
                                Pair<Boolean, Exception> performRule2 = performRule(str8, str6);
                                boolean booleanValue2 = performRule2.component1().booleanValue();
                                Exception component22 = performRule2.component2();
                                if (booleanValue2) {
                                    z3 = true;
                                }
                                if (component22 != null) {
                                    exc = component22;
                                }
                            }
                        }
                    }
                    if (!z3) {
                        str4 = str5 + " [match_reg] hit nothing";
                    }
                    z = z && z3;
                }
            }
            requestCheckResult.setCheckSuccess(z);
            if (str4 != null) {
                str3 = str4;
            } else if (exc != null) {
                str3 = exc.getMessage();
            }
            requestCheckResult.setDenyReason(str3);
            return requestCheckResult;
        }
        return requestCheckResult;
    }

    private final RequestCheckUnit unitForMethod(String method) {
        RequestCheckUnit create;
        RequestCheckUnit requestCheckUnit = this.cachedUnits.get(method);
        if (requestCheckUnit != null) {
            return requestCheckUnit;
        }
        Map<String, Map<String, Object>> requestCheckMethods = AuthStrategyRepository.INSTANCE.getRequestCheckMethods();
        Map<String, ? extends Object> map = requestCheckMethods != null ? requestCheckMethods.get(method) : null;
        if (map == null || (create = RequestCheckUnit.INSTANCE.create(map)) == null) {
            return null;
        }
        this.cachedUnits.put(method, create);
        return create;
    }

    private final Pair<Boolean, Exception> performRule(String rule, String value) {
        try {
            return new Pair<>(Boolean.valueOf(Pattern.compile(rule, 2).matcher(value).find()), null);
        } catch (PatternSyntaxException e) {
            return new Pair<>(false, e);
        }
    }
}
