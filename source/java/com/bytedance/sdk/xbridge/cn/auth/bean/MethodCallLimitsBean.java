package com.bytedance.sdk.xbridge.cn.auth.bean;

import com.bytedance.forest.model.PreloadConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BridgeCallRecord.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007HÆ\u0003J8\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/auth/bean/MethodCallLimitsBean;", "", "runtime_call_count", "", "runtime_call_frequency", "", "url", "", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;)V", "getRuntime_call_count", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getRuntime_call_frequency", "()Ljava/lang/String;", "getUrl", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;)Lcom/bytedance/sdk/xbridge/cn/auth/bean/MethodCallLimitsBean;", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class MethodCallLimitsBean {
    private final Integer runtime_call_count;
    private final String runtime_call_frequency;
    private final List<String> url;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MethodCallLimitsBean copy$default(MethodCallLimitsBean methodCallLimitsBean, Integer num, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            num = methodCallLimitsBean.runtime_call_count;
        }
        if ((i & 2) != 0) {
            str = methodCallLimitsBean.runtime_call_frequency;
        }
        if ((i & 4) != 0) {
            list = methodCallLimitsBean.url;
        }
        return methodCallLimitsBean.copy(num, str, list);
    }

    /* renamed from: component1, reason: from getter */
    public final Integer getRuntime_call_count() {
        return this.runtime_call_count;
    }

    /* renamed from: component2, reason: from getter */
    public final String getRuntime_call_frequency() {
        return this.runtime_call_frequency;
    }

    public final List<String> component3() {
        return this.url;
    }

    public final MethodCallLimitsBean copy(Integer runtime_call_count, String runtime_call_frequency, List<String> url) {
        return new MethodCallLimitsBean(runtime_call_count, runtime_call_frequency, url);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MethodCallLimitsBean)) {
            return false;
        }
        MethodCallLimitsBean methodCallLimitsBean = (MethodCallLimitsBean) other;
        return Intrinsics.areEqual(this.runtime_call_count, methodCallLimitsBean.runtime_call_count) && Intrinsics.areEqual(this.runtime_call_frequency, methodCallLimitsBean.runtime_call_frequency) && Intrinsics.areEqual(this.url, methodCallLimitsBean.url);
    }

    public int hashCode() {
        Integer num = this.runtime_call_count;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.runtime_call_frequency;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        List<String> list = this.url;
        return hashCode2 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "MethodCallLimitsBean(runtime_call_count=" + this.runtime_call_count + ", runtime_call_frequency=" + this.runtime_call_frequency + ", url=" + this.url + ')';
    }

    public MethodCallLimitsBean(Integer num, String str, List<String> list) {
        this.runtime_call_count = num;
        this.runtime_call_frequency = str;
        this.url = list;
    }

    public final Integer getRuntime_call_count() {
        return this.runtime_call_count;
    }

    public final String getRuntime_call_frequency() {
        return this.runtime_call_frequency;
    }

    public final List<String> getUrl() {
        return this.url;
    }
}
