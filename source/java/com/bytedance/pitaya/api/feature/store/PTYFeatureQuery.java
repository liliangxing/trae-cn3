package com.bytedance.pitaya.api.feature.store;

import com.bytedance.android.anniex.solutions.card.AirActionConstant;
import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.mt.protector.ThrowableDisposer;
import com.bytedance.pitaya.jniwrapper.ReflectionCall;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PTYFeatureQuery.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003JS\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u0007HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006#"}, d2 = {"Lcom/bytedance/pitaya/api/feature/store/PTYFeatureQuery;", "Lcom/bytedance/pitaya/jniwrapper/ReflectionCall;", "returnFeatureName", "", "featureName", "subFeatureName", AirActionConstant.ActionId.ACTION_ID_NAME, "", "queryType", ThrowableDisposer.ConfItem.RETURN_TYPE, "extParams", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;)V", "getExtParams", "()Ljava/lang/String;", "getFeatureName", "getN", "()I", "getQueryType", "getReturnFeatureName", "getReturnType", "getSubFeatureName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "toString", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class PTYFeatureQuery implements ReflectionCall {
    private final String extParams;
    private final String featureName;
    private final int n;
    private final int queryType;
    private final String returnFeatureName;
    private final int returnType;
    private final String subFeatureName;

    public static /* synthetic */ PTYFeatureQuery copy$default(PTYFeatureQuery pTYFeatureQuery, String str, String str2, String str3, int i, int i2, int i3, String str4, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = pTYFeatureQuery.returnFeatureName;
        }
        if ((i4 & 2) != 0) {
            str2 = pTYFeatureQuery.featureName;
        }
        String str5 = str2;
        if ((i4 & 4) != 0) {
            str3 = pTYFeatureQuery.subFeatureName;
        }
        String str6 = str3;
        if ((i4 & 8) != 0) {
            i = pTYFeatureQuery.n;
        }
        int i5 = i;
        if ((i4 & 16) != 0) {
            i2 = pTYFeatureQuery.queryType;
        }
        int i6 = i2;
        if ((i4 & 32) != 0) {
            i3 = pTYFeatureQuery.returnType;
        }
        int i7 = i3;
        if ((i4 & 64) != 0) {
            str4 = pTYFeatureQuery.extParams;
        }
        return pTYFeatureQuery.copy(str, str5, str6, i5, i6, i7, str4);
    }

    /* renamed from: component1, reason: from getter */
    public final String getReturnFeatureName() {
        return this.returnFeatureName;
    }

    /* renamed from: component2, reason: from getter */
    public final String getFeatureName() {
        return this.featureName;
    }

    /* renamed from: component3, reason: from getter */
    public final String getSubFeatureName() {
        return this.subFeatureName;
    }

    /* renamed from: component4, reason: from getter */
    public final int getN() {
        return this.n;
    }

    /* renamed from: component5, reason: from getter */
    public final int getQueryType() {
        return this.queryType;
    }

    /* renamed from: component6, reason: from getter */
    public final int getReturnType() {
        return this.returnType;
    }

    /* renamed from: component7, reason: from getter */
    public final String getExtParams() {
        return this.extParams;
    }

    public final PTYFeatureQuery copy(String returnFeatureName, String featureName, String subFeatureName, int n, int queryType, int returnType, String extParams) {
        Intrinsics.checkNotNullParameter(returnFeatureName, "returnFeatureName");
        Intrinsics.checkNotNullParameter(featureName, "featureName");
        return new PTYFeatureQuery(returnFeatureName, featureName, subFeatureName, n, queryType, returnType, extParams);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PTYFeatureQuery)) {
            return false;
        }
        PTYFeatureQuery pTYFeatureQuery = (PTYFeatureQuery) other;
        return Intrinsics.areEqual(this.returnFeatureName, pTYFeatureQuery.returnFeatureName) && Intrinsics.areEqual(this.featureName, pTYFeatureQuery.featureName) && Intrinsics.areEqual(this.subFeatureName, pTYFeatureQuery.subFeatureName) && this.n == pTYFeatureQuery.n && this.queryType == pTYFeatureQuery.queryType && this.returnType == pTYFeatureQuery.returnType && Intrinsics.areEqual(this.extParams, pTYFeatureQuery.extParams);
    }

    public int hashCode() {
        int hashCode = ((this.returnFeatureName.hashCode() * 31) + this.featureName.hashCode()) * 31;
        String str = this.subFeatureName;
        int hashCode2 = (((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + Integer.hashCode(this.n)) * 31) + Integer.hashCode(this.queryType)) * 31) + Integer.hashCode(this.returnType)) * 31;
        String str2 = this.extParams;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "PTYFeatureQuery(returnFeatureName=" + this.returnFeatureName + ", featureName=" + this.featureName + ", subFeatureName=" + this.subFeatureName + ", n=" + this.n + ", queryType=" + this.queryType + ", returnType=" + this.returnType + ", extParams=" + this.extParams + ')';
    }

    public PTYFeatureQuery(String returnFeatureName, String featureName, String str, int i, int i2, int i3, String str2) {
        Intrinsics.checkNotNullParameter(returnFeatureName, "returnFeatureName");
        Intrinsics.checkNotNullParameter(featureName, "featureName");
        this.returnFeatureName = returnFeatureName;
        this.featureName = featureName;
        this.subFeatureName = str;
        this.n = i;
        this.queryType = i2;
        this.returnType = i3;
        this.extParams = str2;
    }

    public /* synthetic */ PTYFeatureQuery(String str, String str2, String str3, int i, int i2, int i3, String str4, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i4 & 4) != 0 ? null : str3, (i4 & 8) != 0 ? 0 : i, i2, i3, (i4 & 64) != 0 ? null : str4);
    }

    public final String getReturnFeatureName() {
        return this.returnFeatureName;
    }

    public final String getFeatureName() {
        return this.featureName;
    }

    public final String getSubFeatureName() {
        return this.subFeatureName;
    }

    public final int getN() {
        return this.n;
    }

    public final int getQueryType() {
        return this.queryType;
    }

    public final int getReturnType() {
        return this.returnType;
    }

    public final String getExtParams() {
        return this.extParams;
    }
}
