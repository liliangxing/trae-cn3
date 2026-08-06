package com.bytedance.sdk.xbridge.cn.auth.bean;

import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: JSBAuthStrategyConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\u0016\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J0\u0010\u0014\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0004HÖ\u0001R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/auth/bean/LynxAuthStrategyConfig;", "", "lynxSignVerifyWhiteList", "", "", "forceDegradeCodeList", "", "", "([Ljava/lang/String;Ljava/util/List;)V", "getForceDegradeCodeList", "()Ljava/util/List;", "setForceDegradeCodeList", "(Ljava/util/List;)V", "getLynxSignVerifyWhiteList", "()[Ljava/lang/String;", "setLynxSignVerifyWhiteList", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "component1", "component2", "copy", "([Ljava/lang/String;Ljava/util/List;)Lcom/bytedance/sdk/xbridge/cn/auth/bean/LynxAuthStrategyConfig;", "equals", "", "other", "hashCode", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final /* data */ class LynxAuthStrategyConfig {
    private List<Integer> forceDegradeCodeList;
    private String[] lynxSignVerifyWhiteList;

    /* JADX WARN: Multi-variable type inference failed */
    public LynxAuthStrategyConfig() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LynxAuthStrategyConfig copy$default(LynxAuthStrategyConfig lynxAuthStrategyConfig, String[] strArr, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            strArr = lynxAuthStrategyConfig.lynxSignVerifyWhiteList;
        }
        if ((i & 2) != 0) {
            list = lynxAuthStrategyConfig.forceDegradeCodeList;
        }
        return lynxAuthStrategyConfig.copy(strArr, list);
    }

    /* renamed from: component1, reason: from getter */
    public final String[] getLynxSignVerifyWhiteList() {
        return this.lynxSignVerifyWhiteList;
    }

    public final List<Integer> component2() {
        return this.forceDegradeCodeList;
    }

    public final LynxAuthStrategyConfig copy(String[] lynxSignVerifyWhiteList, List<Integer> forceDegradeCodeList) {
        Intrinsics.checkNotNullParameter(forceDegradeCodeList, "forceDegradeCodeList");
        return new LynxAuthStrategyConfig(lynxSignVerifyWhiteList, forceDegradeCodeList);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LynxAuthStrategyConfig)) {
            return false;
        }
        LynxAuthStrategyConfig lynxAuthStrategyConfig = (LynxAuthStrategyConfig) other;
        return Intrinsics.areEqual(this.lynxSignVerifyWhiteList, lynxAuthStrategyConfig.lynxSignVerifyWhiteList) && Intrinsics.areEqual(this.forceDegradeCodeList, lynxAuthStrategyConfig.forceDegradeCodeList);
    }

    public int hashCode() {
        String[] strArr = this.lynxSignVerifyWhiteList;
        return ((strArr == null ? 0 : Arrays.hashCode(strArr)) * 31) + this.forceDegradeCodeList.hashCode();
    }

    public String toString() {
        return "LynxAuthStrategyConfig(lynxSignVerifyWhiteList=" + Arrays.toString(this.lynxSignVerifyWhiteList) + ", forceDegradeCodeList=" + this.forceDegradeCodeList + ')';
    }

    public LynxAuthStrategyConfig(String[] strArr, List<Integer> list) {
        Intrinsics.checkNotNullParameter(list, "forceDegradeCodeList");
        this.lynxSignVerifyWhiteList = strArr;
        this.forceDegradeCodeList = list;
    }

    public final String[] getLynxSignVerifyWhiteList() {
        return this.lynxSignVerifyWhiteList;
    }

    public final void setLynxSignVerifyWhiteList(String[] strArr) {
        this.lynxSignVerifyWhiteList = strArr;
    }

    public /* synthetic */ LynxAuthStrategyConfig(String[] strArr, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : strArr, (i & 2) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final List<Integer> getForceDegradeCodeList() {
        return this.forceDegradeCodeList;
    }

    public final void setForceDegradeCodeList(List<Integer> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.forceDegradeCodeList = list;
    }
}
