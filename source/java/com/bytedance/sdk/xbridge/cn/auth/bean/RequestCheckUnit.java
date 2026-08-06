package com.bytedance.sdk.xbridge.cn.auth.bean;

import com.bytedance.sdk.xbridge.cn.auth.repository.AuthStrategyRepository;
import com.bytedance.trae.im.model.MessagePart;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RequestCheckUnit.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u001b\b\u0002\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\u0010\u0005J.\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00042\u000e\u0010\u001d\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003H\u0002R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bRL\u0010\f\u001a4\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u000e0\rj\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00040\u000ej\b\u0012\u0004\u0012\u00020\u0004`\u0010`\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014RL\u0010\u0015\u001a4\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u000e0\rj\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00040\u000ej\b\u0012\u0004\u0012\u00020\u0004`\u0010`\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/auth/bean/RequestCheckUnit;", "", "dictionary", "", "", "(Ljava/util/Map;)V", "action", "Lcom/bytedance/sdk/xbridge/cn/auth/bean/RequestCheckAction;", "getAction", "()Lcom/bytedance/sdk/xbridge/cn/auth/bean/RequestCheckAction;", "setAction", "(Lcom/bytedance/sdk/xbridge/cn/auth/bean/RequestCheckAction;)V", "needExcludes", "Ljava/util/HashMap;", "Ljava/util/ArrayList;", "Lkotlin/collections/HashMap;", "Lkotlin/collections/ArrayList;", "getNeedExcludes", "()Ljava/util/HashMap;", "setNeedExcludes", "(Ljava/util/HashMap;)V", "needMatches", "getNeedMatches", "setNeedMatches", "extractRegExpression", "", "match", "", MessagePart.TYPE_RULE, "settings", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class RequestCheckUnit {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private RequestCheckAction action;
    private HashMap<String, ArrayList<String>> needExcludes;
    private HashMap<String, ArrayList<String>> needMatches;

    public /* synthetic */ RequestCheckUnit(Map map, DefaultConstructorMarker defaultConstructorMarker) {
        this(map);
    }

    private RequestCheckUnit(Map<String, ? extends Object> map) {
        RequestCheckAction requestCheckAction;
        this.action = RequestCheckAction.DISABLE;
        this.needMatches = new HashMap<>();
        this.needExcludes = new HashMap<>();
        Object obj = map.get("action");
        Double d = obj instanceof Double ? (Double) obj : null;
        double doubleValue = d != null ? d.doubleValue() : 0.0d;
        RequestCheckAction[] values = RequestCheckAction.values();
        int length = values.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                requestCheckAction = null;
                break;
            }
            requestCheckAction = values[i];
            if (requestCheckAction.getValue() == ((int) doubleValue)) {
                break;
            } else {
                i++;
            }
        }
        if (requestCheckAction != null) {
            this.action = requestCheckAction;
        }
        HashMap requestCheckSettings = AuthStrategyRepository.INSTANCE.getRequestCheckSettings();
        requestCheckSettings = requestCheckSettings == null ? new HashMap() : requestCheckSettings;
        Object obj2 = map.get("settings");
        Map map2 = obj2 instanceof Map ? (Map) obj2 : null;
        if (map2 != null) {
            for (Map.Entry entry : map2.entrySet()) {
                Object key = entry.getKey();
                Object value = entry.getValue();
                if (key instanceof String) {
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    if (value instanceof String) {
                        String str = (String) value;
                        arrayList.addAll(extractRegExpression(true, str, requestCheckSettings));
                        arrayList2.addAll(extractRegExpression(false, str, requestCheckSettings));
                    } else if (value instanceof List) {
                        for (Object obj3 : (List) value) {
                            if (obj3 instanceof String) {
                                String str2 = (String) obj3;
                                arrayList.addAll(extractRegExpression(true, str2, requestCheckSettings));
                                arrayList2.addAll(extractRegExpression(false, str2, requestCheckSettings));
                            }
                        }
                    }
                    this.needMatches.put(key, arrayList);
                    this.needExcludes.put(key, arrayList2);
                }
            }
        }
    }

    public final RequestCheckAction getAction() {
        return this.action;
    }

    public final void setAction(RequestCheckAction requestCheckAction) {
        Intrinsics.checkNotNullParameter(requestCheckAction, "<set-?>");
        this.action = requestCheckAction;
    }

    public final HashMap<String, ArrayList<String>> getNeedMatches() {
        return this.needMatches;
    }

    public final void setNeedMatches(HashMap<String, ArrayList<String>> hashMap) {
        Intrinsics.checkNotNullParameter(hashMap, "<set-?>");
        this.needMatches = hashMap;
    }

    public final HashMap<String, ArrayList<String>> getNeedExcludes() {
        return this.needExcludes;
    }

    public final void setNeedExcludes(HashMap<String, ArrayList<String>> hashMap) {
        Intrinsics.checkNotNullParameter(hashMap, "<set-?>");
        this.needExcludes = hashMap;
    }

    /* compiled from: RequestCheckUnit.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/auth/bean/RequestCheckUnit$Companion;", "", "()V", "create", "Lcom/bytedance/sdk/xbridge/cn/auth/bean/RequestCheckUnit;", "dictionary", "", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final RequestCheckUnit create(Map<String, ? extends Object> dictionary) {
            Intrinsics.checkNotNullParameter(dictionary, "dictionary");
            DefaultConstructorMarker defaultConstructorMarker = null;
            if (AuthStrategyRepository.INSTANCE.getRequestCheckSettings() != null) {
                return new RequestCheckUnit(dictionary, defaultConstructorMarker);
            }
            return null;
        }
    }

    private final List<String> extractRegExpression(boolean match, String rule, Map<?, ?> settings) {
        if (!settings.isEmpty()) {
            if (!(rule.length() == 0)) {
                Object obj = settings.get(rule);
                Map map = obj instanceof Map ? (Map) obj : null;
                if (map != null) {
                    String str = match ? "match_reg" : "exclude_reg";
                    Object obj2 = map.get(str);
                    String str2 = obj2 instanceof String ? (String) obj2 : null;
                    if (str2 != null) {
                        return str2.length() > 0 ? CollectionsKt.listOf(str2) : CollectionsKt.emptyList();
                    }
                    Object obj3 = map.get(str);
                    List list = obj3 instanceof List ? (List) obj3 : null;
                    if (list != null) {
                        ArrayList arrayList = new ArrayList();
                        for (Object obj4 : list) {
                            if (obj4 instanceof String) {
                                arrayList.add(obj4);
                            }
                        }
                        ArrayList arrayList2 = new ArrayList();
                        for (Object obj5 : arrayList) {
                            if (((String) obj5).length() > 0) {
                                arrayList2.add(obj5);
                            }
                        }
                        return arrayList2;
                    }
                }
                return CollectionsKt.emptyList();
            }
        }
        return CollectionsKt.emptyList();
    }
}
