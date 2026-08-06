package com.bytedance.tobshadow.applog.exposure.scroll;

import com.bytedance.tobshadow.applog.exposure.IExposureConfig;
import com.bytedance.tobshadow.applog.exposure.ViewExposureParam;
import com.bytedance.tobshadow.bdtracker.C0380a;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005HÆ\u0003J)\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/bytedance/tobshadow/applog/exposure/scroll/ScrollObserveConfig;", "Lcom/bytedance/tobshadow/applog/exposure/IExposureConfig;", "minOffset", "", "scrollCallback", "Lkotlin/Function1;", "Lcom/bytedance/tobshadow/applog/exposure/ViewExposureParam;", "", "(ILkotlin/jvm/functions/Function1;)V", "getMinOffset", "()I", "getScrollCallback", "()Lkotlin/jvm/functions/Function1;", "component1", "component2", "copy", "equals", "other", "", "hashCode", "toString", "", "agent_liteChinaRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final /* data */ class ScrollObserveConfig implements IExposureConfig {

    /* renamed from: a */
    public final int f408a;

    /* renamed from: b */
    public final Function1<ViewExposureParam, Boolean> f409b;

    /* renamed from: com.bytedance.tobshadow.applog.exposure.scroll.ScrollObserveConfig$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class C0361a extends Lambda implements Function1<ViewExposureParam, Boolean> {

        /* renamed from: a */
        public static final C0361a f410a = new C0361a();

        public C0361a() {
            super(1);
        }

        public Object invoke(Object obj) {
            Intrinsics.checkParameterIsNotNull((ViewExposureParam) obj, "it");
            return true;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ScrollObserveConfig() {
        this(0, r0, 3, r0);
        Function1 function1 = null;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ScrollObserveConfig(int i) {
        this(i, r0, 2, r0);
        Function1 function1 = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ScrollObserveConfig(int i, Function1<? super ViewExposureParam, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "scrollCallback");
        this.f408a = i;
        this.f409b = function1;
    }

    public /* synthetic */ ScrollObserveConfig(int i, Function1 function1, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 30 : i, (i2 & 2) != 0 ? C0361a.f410a : function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ScrollObserveConfig copy$default(ScrollObserveConfig scrollObserveConfig, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = scrollObserveConfig.f408a;
        }
        if ((i2 & 2) != 0) {
            function1 = scrollObserveConfig.f409b;
        }
        return scrollObserveConfig.copy(i, function1);
    }

    /* renamed from: component1, reason: from getter */
    public final int getF408a() {
        return this.f408a;
    }

    public final Function1<ViewExposureParam, Boolean> component2() {
        return this.f409b;
    }

    public final ScrollObserveConfig copy(int minOffset, Function1<? super ViewExposureParam, Boolean> scrollCallback) {
        Intrinsics.checkParameterIsNotNull(scrollCallback, "scrollCallback");
        return new ScrollObserveConfig(minOffset, scrollCallback);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ScrollObserveConfig)) {
            return false;
        }
        ScrollObserveConfig scrollObserveConfig = (ScrollObserveConfig) other;
        return this.f408a == scrollObserveConfig.f408a && Intrinsics.areEqual(this.f409b, scrollObserveConfig.f409b);
    }

    public final int getMinOffset() {
        return this.f408a;
    }

    public final Function1<ViewExposureParam, Boolean> getScrollCallback() {
        return this.f409b;
    }

    public int hashCode() {
        int i = this.f408a * 31;
        Function1<ViewExposureParam, Boolean> function1 = this.f409b;
        return i + (function1 != null ? function1.hashCode() : 0);
    }

    public String toString() {
        return C0380a.m252a("ScrollObserveConfig(minOffset=").append(this.f408a).append(", scrollCallback=").append(this.f409b).append(")").toString();
    }
}
