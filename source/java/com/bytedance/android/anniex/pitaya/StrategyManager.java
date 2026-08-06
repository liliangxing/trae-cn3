package com.bytedance.android.anniex.pitaya;

import com.bytedance.forest.model.PreloadConfig;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* compiled from: StrategyManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\tB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u0005H\u0007R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/android/anniex/pitaya/StrategyManager;", "", "()V", "strategyConfigs", "", "", "Lcom/bytedance/android/anniex/pitaya/StrategyManager$Strategy;", "getStrategy", "key", "Strategy", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public final class StrategyManager {
    public static final StrategyManager INSTANCE = new StrategyManager();
    private static final Map<String, Strategy> strategyConfigs = new LinkedHashMap();

    private StrategyManager() {
    }

    @JvmStatic
    public static final Strategy getStrategy(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (Intrinsics.areEqual(key, "caijing_half_blank_detection")) {
            return new Strategy("caijing_half_blank_detection", true, null, 4, null);
        }
        return null;
    }

    /* compiled from: StrategyManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\b\u0010\u001d\u001a\u00020\u0003H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/anniex/pitaya/StrategyManager$Strategy;", "", "name", "", "enable", "", "extra", "Lorg/json/JSONObject;", "(Ljava/lang/String;ZLorg/json/JSONObject;)V", "getEnable", "()Z", "setEnable", "(Z)V", "getExtra", "()Lorg/json/JSONObject;", "setExtra", "(Lorg/json/JSONObject;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class Strategy {
        private boolean enable;
        private JSONObject extra;
        private String name;

        public Strategy() {
            this(null, false, null, 7, null);
        }

        public static /* synthetic */ Strategy copy$default(Strategy strategy, String str, boolean z, JSONObject jSONObject, int i, Object obj) {
            if ((i & 1) != 0) {
                str = strategy.name;
            }
            if ((i & 2) != 0) {
                z = strategy.enable;
            }
            if ((i & 4) != 0) {
                jSONObject = strategy.extra;
            }
            return strategy.copy(str, z, jSONObject);
        }

        /* renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getEnable() {
            return this.enable;
        }

        /* renamed from: component3, reason: from getter */
        public final JSONObject getExtra() {
            return this.extra;
        }

        public final Strategy copy(String name, boolean enable, JSONObject extra) {
            Intrinsics.checkNotNullParameter(name, "name");
            return new Strategy(name, enable, extra);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Strategy)) {
                return false;
            }
            Strategy strategy = (Strategy) other;
            return Intrinsics.areEqual(this.name, strategy.name) && this.enable == strategy.enable && Intrinsics.areEqual(this.extra, strategy.extra);
        }

        public int hashCode() {
            int hashCode = ((this.name.hashCode() * 31) + Boolean.hashCode(this.enable)) * 31;
            JSONObject jSONObject = this.extra;
            return hashCode + (jSONObject == null ? 0 : jSONObject.hashCode());
        }

        public Strategy(String name, boolean z, JSONObject jSONObject) {
            Intrinsics.checkNotNullParameter(name, "name");
            this.name = name;
            this.enable = z;
            this.extra = jSONObject;
        }

        public /* synthetic */ Strategy(String str, boolean z, JSONObject jSONObject, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? false : z, (i & 4) != 0 ? null : jSONObject);
        }

        public final String getName() {
            return this.name;
        }

        public final void setName(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.name = str;
        }

        public final boolean getEnable() {
            return this.enable;
        }

        public final void setEnable(boolean z) {
            this.enable = z;
        }

        public final JSONObject getExtra() {
            return this.extra;
        }

        public final void setExtra(JSONObject jSONObject) {
            this.extra = jSONObject;
        }

        public String toString() {
            return "Strategy {name: " + this.name + ", enable: " + this.enable + ", extra: " + this.extra + AbstractJsonLexerKt.END_OBJ;
        }
    }
}
