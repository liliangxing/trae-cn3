package com.bytedance.ies.argus.bean;

import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.ies.argus.bean.AspectConfigItem;
import com.bytedance.ies.argus.util.ArgusGsonUtils;
import com.bytedance.trae.conversation.voice.subtask.SubTaskRequestMessage;
import com.google.gson.annotations.SerializedName;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: StrategyRule.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001:\u0003!\"#B3\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0002\u0010\nJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ\u0017\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007HÆ\u0003J<\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020\bHÖ\u0001R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR$\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006$"}, d2 = {"Lcom/bytedance/ies/argus/bean/AspectConfigItem;", "", "switch", "", "async", "", "rawRules", "", "", "Lcom/bytedance/ies/argus/bean/AspectConfigItem$AspectRuleItem;", "(ILjava/lang/Boolean;Ljava/util/Map;)V", "getAsync", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getRawRules", "()Ljava/util/Map;", StrategyConstants.RULES, "", "getRules", "()Ljava/util/List;", "setRules", "(Ljava/util/List;)V", "getSwitch", "()I", "component1", "component2", "component3", "copy", "(ILjava/lang/Boolean;Ljava/util/Map;)Lcom/bytedance/ies/argus/bean/AspectConfigItem;", "equals", PreloadConfig.KEY_OTHER, "hashCode", "toString", "AspectRuleItem", "Builder", "StrategyRuleType", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AspectConfigItem {

    @SerializedName("async")
    private final Boolean async;

    @SerializedName(StrategyConstants.RULES)
    private final Map<String, AspectRuleItem> rawRules;
    private List<AspectRuleItem> rules;

    @SerializedName("switch")
    private final int switch;

    public AspectConfigItem() {
        this(0, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AspectConfigItem copy$default(AspectConfigItem aspectConfigItem, int i, Boolean bool, Map map, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = aspectConfigItem.switch;
        }
        if ((i2 & 2) != 0) {
            bool = aspectConfigItem.async;
        }
        if ((i2 & 4) != 0) {
            map = aspectConfigItem.rawRules;
        }
        return aspectConfigItem.copy(i, bool, map);
    }

    /* renamed from: component1, reason: from getter */
    public final int getSwitch() {
        return this.switch;
    }

    /* renamed from: component2, reason: from getter */
    public final Boolean getAsync() {
        return this.async;
    }

    public final Map<String, AspectRuleItem> component3() {
        return this.rawRules;
    }

    public final AspectConfigItem copy(int r2, Boolean async, Map<String, AspectRuleItem> rawRules) {
        return new AspectConfigItem(r2, async, rawRules);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AspectConfigItem)) {
            return false;
        }
        AspectConfigItem aspectConfigItem = (AspectConfigItem) other;
        return this.switch == aspectConfigItem.switch && Intrinsics.areEqual(this.async, aspectConfigItem.async) && Intrinsics.areEqual(this.rawRules, aspectConfigItem.rawRules);
    }

    public int hashCode() {
        int hashCode = Integer.hashCode(this.switch) * 31;
        Boolean bool = this.async;
        int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        Map<String, AspectRuleItem> map = this.rawRules;
        return hashCode2 + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        return "AspectConfigItem(switch=" + this.switch + ", async=" + this.async + ", rawRules=" + this.rawRules + ')';
    }

    public AspectConfigItem(int i, Boolean bool, Map<String, AspectRuleItem> map) {
        this.switch = i;
        this.async = bool;
        this.rawRules = map;
        this.rules = CollectionsKt.emptyList();
    }

    public /* synthetic */ AspectConfigItem(int i, Boolean bool, Map map, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 2 : i, (i2 & 2) != 0 ? null : bool, (i2 & 4) != 0 ? null : map);
    }

    public final int getSwitch() {
        return this.switch;
    }

    public final Boolean getAsync() {
        return this.async;
    }

    public final Map<String, AspectRuleItem> getRawRules() {
        return this.rawRules;
    }

    public final List<AspectRuleItem> getRules() {
        return this.rules;
    }

    public final void setRules(List<AspectRuleItem> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.rules = list;
    }

    /* compiled from: StrategyRule.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006J*\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t0\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0002¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ies/argus/bean/AspectConfigItem$Builder;", "", "()V", "build", "Lcom/bytedance/ies/argus/bean/AspectConfigItem;", "data", "Lorg/json/JSONObject;", "initRules", "", "Lcom/bytedance/ies/argus/bean/AspectConfigItem$AspectRuleItem;", "rawRules", "", "", "defaultSwitch", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Builder {
        public final AspectConfigItem build(JSONObject data) {
            Map<String, AspectRuleItem> rawRules;
            Intrinsics.checkNotNullParameter(data, "data");
            AspectConfigItem aspectConfigItem = (AspectConfigItem) ArgusGsonUtils.INSTANCE.safelyFromJSONObjectToClass(data, AspectConfigItem.class);
            if (aspectConfigItem != null && (rawRules = aspectConfigItem.getRawRules()) != null) {
                aspectConfigItem.setRules(initRules(rawRules, aspectConfigItem.getSwitch()));
            }
            return aspectConfigItem;
        }

        private final List<AspectRuleItem> initRules(Map<String, AspectRuleItem> rawRules, int defaultSwitch) {
            for (Map.Entry<String, AspectRuleItem> entry : rawRules.entrySet()) {
                String key = entry.getKey();
                AspectRuleItem value = entry.getValue();
                value.setName(key);
                if (value.getSwitch() == null) {
                    value.setSwitch(Integer.valueOf(defaultSwitch));
                }
            }
            return CollectionsKt.toList(CollectionsKt.sortedWith(rawRules.values(), new Comparator<T>() { // from class: com.bytedance.ies.argus.bean.AspectConfigItem$Builder$initRules$$inlined$sortedBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(Integer.valueOf(((AspectConfigItem.AspectRuleItem) t).getIndex()), Integer.valueOf(((AspectConfigItem.AspectRuleItem) t2).getIndex()));
                }
            }));
        }
    }

    /* compiled from: StrategyRule.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\u0018\u00002\u00020\u0001B3\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ies/argus/bean/AspectConfigItem$AspectRuleItem;", "", "version", "", "switch", "", "index", "ruleType", "(Ljava/lang/String;Ljava/lang/Integer;ILjava/lang/String;)V", "getIndex", "()I", "name", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getRuleType", "getSwitch", "()Ljava/lang/Integer;", "setSwitch", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getVersion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class AspectRuleItem {

        @SerializedName("index")
        private final int index;
        private String name;

        @SerializedName("type")
        private final String ruleType;

        @SerializedName("switch")
        private Integer switch;

        @SerializedName("version")
        private final String version;

        public AspectRuleItem() {
            this(null, null, 0, null, 15, null);
        }

        public AspectRuleItem(String str, Integer num, int i, String str2) {
            this.version = str;
            this.switch = num;
            this.index = i;
            this.ruleType = str2;
        }

        public final String getVersion() {
            return this.version;
        }

        public final Integer getSwitch() {
            return this.switch;
        }

        public final void setSwitch(Integer num) {
            this.switch = num;
        }

        public final int getIndex() {
            return this.index;
        }

        public /* synthetic */ AspectRuleItem(String str, Integer num, int i, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : num, (i2 & 4) != 0 ? 0 : i, (i2 & 8) != 0 ? StrategyRuleType.UNSET.getStr() : str2);
        }

        public final String getRuleType() {
            return this.ruleType;
        }

        public final String getName() {
            return this.name;
        }

        public final void setName(String str) {
            this.name = str;
        }
    }

    /* compiled from: StrategyRule.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ies/argus/bean/AspectConfigItem$StrategyRuleType;", "", "str", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getStr", "()Ljava/lang/String;", "CLIENT", "TTM", "UNSET", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes3.dex */
    public enum StrategyRuleType {
        CLIENT(SubTaskRequestMessage.EXECUTOR_CLIENT),
        TTM(ArgusStrategyName.TTMACHINE),
        UNSET("unset");

        private final String str;

        StrategyRuleType(String str) {
            this.str = str;
        }

        public final String getStr() {
            return this.str;
        }
    }
}
