package com.bytedance.android.anniex.solutions.card.data;

import com.bytedance.android.anniex.solutions.card.AirActionConstant;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: DataCenter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000f\u001a\u00020\u0005R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001f\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u001d\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/anniex/solutions/card/data/DataCenter;", "", "()V", "globalProps", "", "", "getGlobalProps", "()Ljava/util/Map;", "initData", "getInitData", "runtimeData", "Ljava/util/concurrent/ConcurrentHashMap;", "getRuntimeData", "()Ljava/util/concurrent/ConcurrentHashMap;", "getValue", "key", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class DataCenter {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Map<String, Object> initData = new LinkedHashMap();
    private final Map<String, Object> globalProps = new LinkedHashMap();
    private final ConcurrentHashMap<String, Object> runtimeData = new ConcurrentHashMap<>();

    public final Map<String, Object> getInitData() {
        return this.initData;
    }

    public final Map<String, Object> getGlobalProps() {
        return this.globalProps;
    }

    public final ConcurrentHashMap<String, Object> getRuntimeData() {
        return this.runtimeData;
    }

    public final Object getValue(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (StringsKt.startsWith$default(key, AirActionConstant.DataCenter.INIT_DATA, false, 2, (Object) null)) {
            Companion companion = INSTANCE;
            String substring = key.substring(7);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
            return companion.getMemberValue(substring, this.initData);
        }
        if (StringsKt.startsWith$default(key, AirActionConstant.DataCenter.GLOBAL_PROPS, false, 2, (Object) null)) {
            Companion companion2 = INSTANCE;
            String substring2 = key.substring(14);
            Intrinsics.checkNotNullExpressionValue(substring2, "(this as java.lang.String).substring(startIndex)");
            return companion2.getMemberValue(substring2, this.globalProps);
        }
        return INSTANCE.getMemberValue(key, this.runtimeData);
    }

    /* compiled from: DataCenter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0002J\u001a\u0010\b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\t\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0001J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\u0005¨\u0006\r"}, d2 = {"Lcom/bytedance/android/anniex/solutions/card/data/DataCenter$Companion;", "", "()V", "getArrayIndex", "strIdx", "", "arr", "", "getMemberValue", "input", "map", "getShortKey", "key", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getShortKey(String key) {
            Intrinsics.checkNotNullParameter(key, "key");
            int lastIndexOf$default = StringsKt.lastIndexOf$default(key, '.', 0, false, 6, (Object) null);
            if (lastIndexOf$default == -1) {
                return null;
            }
            String substring = key.substring(lastIndexOf$default + 1);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
            return substring;
        }

        private final Object getArrayIndex(String strIdx, List<?> arr) {
            int parseInt = Integer.parseInt(strIdx);
            if (parseInt < arr.size()) {
                return arr.get(parseInt);
            }
            return null;
        }

        public final Object getMemberValue(String input, Object map) {
            String substring;
            Intrinsics.checkNotNullParameter(input, "input");
            if (StringsKt.startsWith$default(input, "$", false, 2, (Object) null)) {
                input = input.substring(2);
                Intrinsics.checkNotNullExpressionValue(input, "(this as java.lang.String).substring(startIndex)");
            }
            int indexOf$default = StringsKt.indexOf$default(input, ".", 0, false, 6, (Object) null);
            if (indexOf$default == -1) {
                substring = "";
            } else if (input != null) {
                substring = input.substring(0, indexOf$default);
                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            } else {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            int i = indexOf$default + 1;
            if (input != null) {
                String substring2 = input.substring(i);
                Intrinsics.checkNotNullExpressionValue(substring2, "(this as java.lang.String).substring(startIndex)");
                if (map instanceof Map) {
                    if (substring.length() == 0) {
                        return ((Map) map).get(input);
                    }
                    Map map2 = (Map) map;
                    if (map2.containsKey(substring)) {
                        Object obj = map2.get(substring);
                        if (obj != null) {
                            return DataCenter.INSTANCE.getMemberValue(substring2, obj);
                        }
                        return null;
                    }
                }
                if (map instanceof String) {
                    if (Intrinsics.areEqual(input, "length")) {
                        return Integer.valueOf(((String) map).length());
                    }
                    int parseInt = Integer.parseInt(input);
                    String str = (String) map;
                    if (parseInt < str.length()) {
                        return String.valueOf(str.charAt(parseInt));
                    }
                    return null;
                }
                if (!(map instanceof List)) {
                    return null;
                }
                if (Intrinsics.areEqual(input, "length")) {
                    return Integer.valueOf(((List) map).size());
                }
                if (indexOf$default < 0) {
                    return getArrayIndex(input, (List) map);
                }
                Object arrayIndex = getArrayIndex(substring, (List) map);
                if (arrayIndex == null) {
                    return null;
                }
                Companion companion = DataCenter.INSTANCE;
                if (input != null) {
                    String substring3 = input.substring(i);
                    Intrinsics.checkNotNullExpressionValue(substring3, "(this as java.lang.String).substring(startIndex)");
                    return companion.getMemberValue(substring3, arrayIndex);
                }
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
    }
}
