package com.bytedance.android.anniex.solutions.card.model;

import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.bytedance.android.anniex.solutions.card.util.JsonUtil;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: Actions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\u0018\u0000 \u00032\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\b"}, d2 = {"Lcom/bytedance/android/anniex/solutions/card/model/Actions;", "", "()V", "Companion", "ConditionBlock", "HighExec", "JSBAction", "Params", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class Actions {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: Actions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J9\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR$\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/anniex/solutions/card/model/Actions$JSBAction;", "", "method", "", "params", "", "highExec", "Lcom/bytedance/android/anniex/solutions/card/model/Actions$HighExec;", "(Ljava/lang/String;Ljava/util/Map;Lcom/bytedance/android/anniex/solutions/card/model/Actions$HighExec;)V", "getHighExec", "()Lcom/bytedance/android/anniex/solutions/card/model/Actions$HighExec;", "getMethod", "()Ljava/lang/String;", "getParams", "()Ljava/util/Map;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static final /* data */ class JSBAction {

        @SerializedName("callback")
        private final HighExec highExec;

        @SerializedName("method")
        private final String method;

        @SerializedName("params")
        private final Map<String, Object> params;

        public JSBAction() {
            this(null, null, null, 7, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ JSBAction copy$default(JSBAction jSBAction, String str, Map map, HighExec highExec, int i, Object obj) {
            if ((i & 1) != 0) {
                str = jSBAction.method;
            }
            if ((i & 2) != 0) {
                map = jSBAction.params;
            }
            if ((i & 4) != 0) {
                highExec = jSBAction.highExec;
            }
            return jSBAction.copy(str, map, highExec);
        }

        /* renamed from: component1, reason: from getter */
        public final String getMethod() {
            return this.method;
        }

        public final Map<String, Object> component2() {
            return this.params;
        }

        /* renamed from: component3, reason: from getter */
        public final HighExec getHighExec() {
            return this.highExec;
        }

        public final JSBAction copy(String method, Map<String, ? extends Object> params, HighExec highExec) {
            return new JSBAction(method, params, highExec);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof JSBAction)) {
                return false;
            }
            JSBAction jSBAction = (JSBAction) other;
            return Intrinsics.areEqual(this.method, jSBAction.method) && Intrinsics.areEqual(this.params, jSBAction.params) && Intrinsics.areEqual(this.highExec, jSBAction.highExec);
        }

        public int hashCode() {
            String str = this.method;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            Map<String, Object> map = this.params;
            int hashCode2 = (hashCode + (map == null ? 0 : map.hashCode())) * 31;
            HighExec highExec = this.highExec;
            return hashCode2 + (highExec != null ? highExec.hashCode() : 0);
        }

        public String toString() {
            return "JSBAction(method=" + this.method + ", params=" + this.params + ", highExec=" + this.highExec + ')';
        }

        public JSBAction(String str, Map<String, ? extends Object> map, HighExec highExec) {
            this.method = str;
            this.params = map;
            this.highExec = highExec;
        }

        public /* synthetic */ JSBAction(String str, Map map, HighExec highExec, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : map, (i & 4) != 0 ? null : highExec);
        }

        public final String getMethod() {
            return this.method;
        }

        public final Map<String, Object> getParams() {
            return this.params;
        }

        public final HighExec getHighExec() {
            return this.highExec;
        }
    }

    /* compiled from: Actions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0006J\u0017\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0004HÆ\u0003J-\u0010\r\u001a\u00020\u00002\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0004HÖ\u0001R$\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/anniex/solutions/card/model/Actions$Params;", "", "fields", "", "", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "(Ljava/util/Map;Ljava/lang/String;)V", "getFields", "()Ljava/util/Map;", "getType", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static final /* data */ class Params {

        @SerializedName("fields")
        private final Map<String, Object> fields;

        @SerializedName(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY)
        private final String type;

        /* JADX WARN: Multi-variable type inference failed */
        public Params() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Params copy$default(Params params, Map map, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                map = params.fields;
            }
            if ((i & 2) != 0) {
                str = params.type;
            }
            return params.copy(map, str);
        }

        public final Map<String, Object> component1() {
            return this.fields;
        }

        /* renamed from: component2, reason: from getter */
        public final String getType() {
            return this.type;
        }

        public final Params copy(Map<String, ? extends Object> fields, String type) {
            return new Params(fields, type);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Params)) {
                return false;
            }
            Params params = (Params) other;
            return Intrinsics.areEqual(this.fields, params.fields) && Intrinsics.areEqual(this.type, params.type);
        }

        public int hashCode() {
            Map<String, Object> map = this.fields;
            int hashCode = (map == null ? 0 : map.hashCode()) * 31;
            String str = this.type;
            return hashCode + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            return "Params(fields=" + this.fields + ", type=" + this.type + ')';
        }

        public Params(Map<String, ? extends Object> map, String str) {
            this.fields = map;
            this.type = str;
        }

        public /* synthetic */ Params(Map map, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : map, (i & 2) != 0 ? null : str);
        }

        public final Map<String, Object> getFields() {
            return this.fields;
        }

        public final String getType() {
            return this.type;
        }
    }

    /* compiled from: Actions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\tJ\u0011\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003J?\u0010\u0014\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/anniex/solutions/card/model/Actions$HighExec;", "", "expression", "", "Lcom/bytedance/android/anniex/solutions/card/model/Expression;", "ifBlock", "Lcom/bytedance/android/anniex/solutions/card/model/Actions$ConditionBlock;", "elseBlock", "thenBlock", "(Ljava/util/List;Lcom/bytedance/android/anniex/solutions/card/model/Actions$ConditionBlock;Lcom/bytedance/android/anniex/solutions/card/model/Actions$ConditionBlock;Lcom/bytedance/android/anniex/solutions/card/model/Actions$ConditionBlock;)V", "getElseBlock", "()Lcom/bytedance/android/anniex/solutions/card/model/Actions$ConditionBlock;", "getExpression", "()Ljava/util/List;", "getIfBlock", "getThenBlock", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static final /* data */ class HighExec {

        @SerializedName("else")
        private final ConditionBlock elseBlock;

        @SerializedName("expression")
        private final List<Expression> expression;

        @SerializedName("if")
        private final ConditionBlock ifBlock;

        @SerializedName("then")
        private final ConditionBlock thenBlock;

        public HighExec() {
            this(null, null, null, null, 15, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ HighExec copy$default(HighExec highExec, List list, ConditionBlock conditionBlock, ConditionBlock conditionBlock2, ConditionBlock conditionBlock3, int i, Object obj) {
            if ((i & 1) != 0) {
                list = highExec.expression;
            }
            if ((i & 2) != 0) {
                conditionBlock = highExec.ifBlock;
            }
            if ((i & 4) != 0) {
                conditionBlock2 = highExec.elseBlock;
            }
            if ((i & 8) != 0) {
                conditionBlock3 = highExec.thenBlock;
            }
            return highExec.copy(list, conditionBlock, conditionBlock2, conditionBlock3);
        }

        public final List<Expression> component1() {
            return this.expression;
        }

        /* renamed from: component2, reason: from getter */
        public final ConditionBlock getIfBlock() {
            return this.ifBlock;
        }

        /* renamed from: component3, reason: from getter */
        public final ConditionBlock getElseBlock() {
            return this.elseBlock;
        }

        /* renamed from: component4, reason: from getter */
        public final ConditionBlock getThenBlock() {
            return this.thenBlock;
        }

        public final HighExec copy(List<Expression> expression, ConditionBlock ifBlock, ConditionBlock elseBlock, ConditionBlock thenBlock) {
            return new HighExec(expression, ifBlock, elseBlock, thenBlock);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof HighExec)) {
                return false;
            }
            HighExec highExec = (HighExec) other;
            return Intrinsics.areEqual(this.expression, highExec.expression) && Intrinsics.areEqual(this.ifBlock, highExec.ifBlock) && Intrinsics.areEqual(this.elseBlock, highExec.elseBlock) && Intrinsics.areEqual(this.thenBlock, highExec.thenBlock);
        }

        public int hashCode() {
            List<Expression> list = this.expression;
            int hashCode = (list == null ? 0 : list.hashCode()) * 31;
            ConditionBlock conditionBlock = this.ifBlock;
            int hashCode2 = (hashCode + (conditionBlock == null ? 0 : conditionBlock.hashCode())) * 31;
            ConditionBlock conditionBlock2 = this.elseBlock;
            int hashCode3 = (hashCode2 + (conditionBlock2 == null ? 0 : conditionBlock2.hashCode())) * 31;
            ConditionBlock conditionBlock3 = this.thenBlock;
            return hashCode3 + (conditionBlock3 != null ? conditionBlock3.hashCode() : 0);
        }

        public String toString() {
            return "HighExec(expression=" + this.expression + ", ifBlock=" + this.ifBlock + ", elseBlock=" + this.elseBlock + ", thenBlock=" + this.thenBlock + ')';
        }

        public HighExec(List<Expression> list, ConditionBlock conditionBlock, ConditionBlock conditionBlock2, ConditionBlock conditionBlock3) {
            this.expression = list;
            this.ifBlock = conditionBlock;
            this.elseBlock = conditionBlock2;
            this.thenBlock = conditionBlock3;
        }

        public /* synthetic */ HighExec(List list, ConditionBlock conditionBlock, ConditionBlock conditionBlock2, ConditionBlock conditionBlock3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : conditionBlock, (i & 4) != 0 ? null : conditionBlock2, (i & 8) != 0 ? null : conditionBlock3);
        }

        public final List<Expression> getExpression() {
            return this.expression;
        }

        public final ConditionBlock getIfBlock() {
            return this.ifBlock;
        }

        public final ConditionBlock getElseBlock() {
            return this.elseBlock;
        }

        public final ConditionBlock getThenBlock() {
            return this.thenBlock;
        }
    }

    /* compiled from: Actions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\t\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/anniex/solutions/card/model/Actions$ConditionBlock;", "", "block", "", "Lcom/bytedance/android/anniex/solutions/card/model/Expression;", "(Ljava/util/List;)V", "getBlock", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static final /* data */ class ConditionBlock {

        @SerializedName("expression")
        private final List<Expression> block;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public ConditionBlock() {
            this(r0, 1, r0);
            List list = null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ConditionBlock copy$default(ConditionBlock conditionBlock, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = conditionBlock.block;
            }
            return conditionBlock.copy(list);
        }

        public final List<Expression> component1() {
            return this.block;
        }

        public final ConditionBlock copy(List<Expression> block) {
            return new ConditionBlock(block);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ConditionBlock) && Intrinsics.areEqual(this.block, ((ConditionBlock) other).block);
        }

        public int hashCode() {
            List<Expression> list = this.block;
            if (list == null) {
                return 0;
            }
            return list.hashCode();
        }

        public String toString() {
            return "ConditionBlock(block=" + this.block + ')';
        }

        public ConditionBlock(List<Expression> list) {
            this.block = list;
        }

        public /* synthetic */ ConditionBlock(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : list);
        }

        public final List<Expression> getBlock() {
            return this.block;
        }
    }

    /* compiled from: Actions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010$\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00060\u00042\u0006\u0010\u0007\u001a\u00020\u0005¨\u0006\b"}, d2 = {"Lcom/bytedance/android/anniex/solutions/card/model/Actions$Companion;", "", "()V", "parseLifecycleAction", "Lkotlin/Pair;", "", "", "jsonString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Pair<String, Map<String, Object>> parseLifecycleAction(String jsonString) {
            String str;
            Intrinsics.checkNotNullParameter(jsonString, "jsonString");
            String str2 = jsonString;
            int indexOf$default = StringsKt.indexOf$default(str2, "'", 0, false, 6, (Object) null) + 1;
            int indexOf$default2 = StringsKt.indexOf$default(str2, "',", 0, false, 6, (Object) null);
            if (indexOf$default == 0 || indexOf$default2 == -1) {
                str = "";
            } else {
                str = jsonString.substring(indexOf$default, indexOf$default2);
                Intrinsics.checkNotNullExpressionValue(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            }
            String str3 = str;
            Map<String, Object> emptyMap = MapsKt.emptyMap();
            int indexOf$default3 = StringsKt.indexOf$default(str2, "{", 0, false, 6, (Object) null);
            int indexOf$default4 = StringsKt.indexOf$default(str2, "}", 0, false, 6, (Object) null) + 1;
            if (indexOf$default3 != 0 && indexOf$default4 != -1) {
                String substring = jsonString.substring(indexOf$default3, indexOf$default4);
                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                emptyMap = JsonUtil.INSTANCE.safeToMap(new JSONObject(substring));
            }
            return new Pair<>(str3, emptyMap);
        }
    }
}
