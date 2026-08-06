package com.bytedance.android.anniex.optimize.prehandle.model;

import com.bytedance.forest.model.PreloadConfig;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PreHandleConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0005j\b\u0012\u0004\u0012\u00020\u0003`\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0005j\b\u0012\u0004\u0012\u00020\u0003`\u0006HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0005j\b\u0012\u0004\u0012\u00020\u0003`\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR*\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0005j\b\u0012\u0004\u0012\u00020\u0003`\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/anniex/optimize/prehandle/model/PreHandleConfig;", "", "optSchema", "", "preHandleMethodsWithOutParam", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "(Ljava/lang/String;Ljava/util/HashSet;)V", "getOptSchema", "()Ljava/lang/String;", "setOptSchema", "(Ljava/lang/String;)V", "getPreHandleMethodsWithOutParam", "()Ljava/util/HashSet;", "setPreHandleMethodsWithOutParam", "(Ljava/util/HashSet;)V", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class PreHandleConfig {
    private String optSchema;
    private HashSet<String> preHandleMethodsWithOutParam;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PreHandleConfig copy$default(PreHandleConfig preHandleConfig, String str, HashSet hashSet, int i, Object obj) {
        if ((i & 1) != 0) {
            str = preHandleConfig.optSchema;
        }
        if ((i & 2) != 0) {
            hashSet = preHandleConfig.preHandleMethodsWithOutParam;
        }
        return preHandleConfig.copy(str, hashSet);
    }

    /* renamed from: component1, reason: from getter */
    public final String getOptSchema() {
        return this.optSchema;
    }

    public final HashSet<String> component2() {
        return this.preHandleMethodsWithOutParam;
    }

    public final PreHandleConfig copy(String optSchema, HashSet<String> preHandleMethodsWithOutParam) {
        Intrinsics.checkNotNullParameter(optSchema, "optSchema");
        Intrinsics.checkNotNullParameter(preHandleMethodsWithOutParam, "preHandleMethodsWithOutParam");
        return new PreHandleConfig(optSchema, preHandleMethodsWithOutParam);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PreHandleConfig)) {
            return false;
        }
        PreHandleConfig preHandleConfig = (PreHandleConfig) other;
        return Intrinsics.areEqual(this.optSchema, preHandleConfig.optSchema) && Intrinsics.areEqual(this.preHandleMethodsWithOutParam, preHandleConfig.preHandleMethodsWithOutParam);
    }

    public int hashCode() {
        return (this.optSchema.hashCode() * 31) + this.preHandleMethodsWithOutParam.hashCode();
    }

    public String toString() {
        return "PreHandleConfig(optSchema=" + this.optSchema + ", preHandleMethodsWithOutParam=" + this.preHandleMethodsWithOutParam + ')';
    }

    public PreHandleConfig(String optSchema, HashSet<String> preHandleMethodsWithOutParam) {
        Intrinsics.checkNotNullParameter(optSchema, "optSchema");
        Intrinsics.checkNotNullParameter(preHandleMethodsWithOutParam, "preHandleMethodsWithOutParam");
        this.optSchema = optSchema;
        this.preHandleMethodsWithOutParam = preHandleMethodsWithOutParam;
    }

    public final String getOptSchema() {
        return this.optSchema;
    }

    public final void setOptSchema(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.optSchema = str;
    }

    public final HashSet<String> getPreHandleMethodsWithOutParam() {
        return this.preHandleMethodsWithOutParam;
    }

    public final void setPreHandleMethodsWithOutParam(HashSet<String> hashSet) {
        Intrinsics.checkNotNullParameter(hashSet, "<set-?>");
        this.preHandleMethodsWithOutParam = hashSet;
    }
}
