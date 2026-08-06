package com.bytedance.ies.argus.bean;

import com.bytedance.applog.server.Api;
import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.ies.argus.util.ArgusGsonUtils;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: StrategyRule.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0080\b\u0018\u00002\u00020\u0001:\u0002\"#B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003JA\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\b\u0010!\u001a\u00020\u0003H\u0016R\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011¨\u0006$"}, d2 = {"Lcom/bytedance/ies/argus/bean/StrategyRule;", "", Api.KEY_ENCRYPT_RESP_KEY, "", "version", "expr", "exprMd5", "byteCodeMd5", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "byteCodeAddress", "", "getByteCodeAddress", "()Ljava/lang/Long;", "setByteCodeAddress", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getByteCodeMd5", "()Ljava/lang/String;", "getExpr", "getExprMd5", "getKey", "getVersion", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "Builder", "StrategyRuleInfo", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final /* data */ class StrategyRule {
    private Long byteCodeAddress;
    private final String byteCodeMd5;
    private final String expr;
    private final String exprMd5;
    private final String key;
    private final String version;

    public static /* synthetic */ StrategyRule copy$default(StrategyRule strategyRule, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = strategyRule.key;
        }
        if ((i & 2) != 0) {
            str2 = strategyRule.version;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = strategyRule.expr;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = strategyRule.exprMd5;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = strategyRule.byteCodeMd5;
        }
        return strategyRule.copy(str, str6, str7, str8, str5);
    }

    /* renamed from: component1, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    /* renamed from: component2, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    /* renamed from: component3, reason: from getter */
    public final String getExpr() {
        return this.expr;
    }

    /* renamed from: component4, reason: from getter */
    public final String getExprMd5() {
        return this.exprMd5;
    }

    /* renamed from: component5, reason: from getter */
    public final String getByteCodeMd5() {
        return this.byteCodeMd5;
    }

    public final StrategyRule copy(String key, String version, String expr, String exprMd5, String byteCodeMd5) {
        Intrinsics.checkNotNullParameter(key, Api.KEY_ENCRYPT_RESP_KEY);
        Intrinsics.checkNotNullParameter(version, "version");
        return new StrategyRule(key, version, expr, exprMd5, byteCodeMd5);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StrategyRule)) {
            return false;
        }
        StrategyRule strategyRule = (StrategyRule) other;
        return Intrinsics.areEqual(this.key, strategyRule.key) && Intrinsics.areEqual(this.version, strategyRule.version) && Intrinsics.areEqual(this.expr, strategyRule.expr) && Intrinsics.areEqual(this.exprMd5, strategyRule.exprMd5) && Intrinsics.areEqual(this.byteCodeMd5, strategyRule.byteCodeMd5);
    }

    public int hashCode() {
        int hashCode = ((this.key.hashCode() * 31) + this.version.hashCode()) * 31;
        String str = this.expr;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.exprMd5;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.byteCodeMd5;
        return hashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public StrategyRule(String str, String str2, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(str, Api.KEY_ENCRYPT_RESP_KEY);
        Intrinsics.checkNotNullParameter(str2, "version");
        this.key = str;
        this.version = str2;
        this.expr = str3;
        this.exprMd5 = str4;
        this.byteCodeMd5 = str5;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getVersion() {
        return this.version;
    }

    public final String getExpr() {
        return this.expr;
    }

    public final String getExprMd5() {
        return this.exprMd5;
    }

    public final String getByteCodeMd5() {
        return this.byteCodeMd5;
    }

    public final Long getByteCodeAddress() {
        return this.byteCodeAddress;
    }

    public final void setByteCodeAddress(Long l) {
        this.byteCodeAddress = l;
    }

    public String toString() {
        return "key=" + this.key + ", ver=" + this.version + ", exprMd5=" + this.exprMd5 + ", bMd5=" + this.byteCodeMd5;
    }

    /* compiled from: StrategyRule.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ies/argus/bean/StrategyRule$Builder;", "", "()V", "build", "Lcom/bytedance/ies/argus/bean/StrategyRule;", Api.KEY_ENCRYPT_RESP_KEY, "", "version", "ruleData", "Lorg/json/JSONObject;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class Builder {
        public final StrategyRule build(String key, String version, JSONObject ruleData) {
            Intrinsics.checkNotNullParameter(key, Api.KEY_ENCRYPT_RESP_KEY);
            Intrinsics.checkNotNullParameter(version, "version");
            if (ruleData == null) {
                return null;
            }
            StrategyRuleInfo strategyRuleInfo = (StrategyRuleInfo) ArgusGsonUtils.INSTANCE.safelyFromJSONObjectToClass(ruleData, StrategyRuleInfo.class);
            return new StrategyRule(key, version, strategyRuleInfo != null ? strategyRuleInfo.getExpr() : null, strategyRuleInfo != null ? strategyRuleInfo.getExprMd5() : null, strategyRuleInfo != null ? strategyRuleInfo.getByteCodeMd5() : null);
        }
    }

    /* compiled from: StrategyRule.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ies/argus/bean/StrategyRule$StrategyRuleInfo;", "", "expr", "", "exprMd5", "byteCodeMd5", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getByteCodeMd5", "()Ljava/lang/String;", "getExpr", "getExprMd5", "component1", "component2", "component3", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final /* data */ class StrategyRuleInfo {

        @SerializedName("b_md5")
        private final String byteCodeMd5;

        @SerializedName("expr")
        private final String expr;

        @SerializedName("expr_md5")
        private final String exprMd5;

        public StrategyRuleInfo() {
            this(null, null, null, 7, null);
        }

        public static /* synthetic */ StrategyRuleInfo copy$default(StrategyRuleInfo strategyRuleInfo, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = strategyRuleInfo.expr;
            }
            if ((i & 2) != 0) {
                str2 = strategyRuleInfo.exprMd5;
            }
            if ((i & 4) != 0) {
                str3 = strategyRuleInfo.byteCodeMd5;
            }
            return strategyRuleInfo.copy(str, str2, str3);
        }

        /* renamed from: component1, reason: from getter */
        public final String getExpr() {
            return this.expr;
        }

        /* renamed from: component2, reason: from getter */
        public final String getExprMd5() {
            return this.exprMd5;
        }

        /* renamed from: component3, reason: from getter */
        public final String getByteCodeMd5() {
            return this.byteCodeMd5;
        }

        public final StrategyRuleInfo copy(String expr, String exprMd5, String byteCodeMd5) {
            return new StrategyRuleInfo(expr, exprMd5, byteCodeMd5);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StrategyRuleInfo)) {
                return false;
            }
            StrategyRuleInfo strategyRuleInfo = (StrategyRuleInfo) other;
            return Intrinsics.areEqual(this.expr, strategyRuleInfo.expr) && Intrinsics.areEqual(this.exprMd5, strategyRuleInfo.exprMd5) && Intrinsics.areEqual(this.byteCodeMd5, strategyRuleInfo.byteCodeMd5);
        }

        public int hashCode() {
            String str = this.expr;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.exprMd5;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.byteCodeMd5;
            return hashCode2 + (str3 != null ? str3.hashCode() : 0);
        }

        public String toString() {
            return "StrategyRuleInfo(expr=" + this.expr + ", exprMd5=" + this.exprMd5 + ", byteCodeMd5=" + this.byteCodeMd5 + ')';
        }

        public StrategyRuleInfo(String str, String str2, String str3) {
            this.expr = str;
            this.exprMd5 = str2;
            this.byteCodeMd5 = str3;
        }

        public /* synthetic */ StrategyRuleInfo(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
        }

        public final String getExpr() {
            return this.expr;
        }

        public final String getExprMd5() {
            return this.exprMd5;
        }

        public final String getByteCodeMd5() {
            return this.byteCodeMd5;
        }
    }
}
