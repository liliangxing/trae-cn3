package com.bytedance.tobshadow.applog.exposure;

import com.bytedance.tobshadow.bdtracker.C0380a;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B?\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00050\t¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\u0015\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00050\tHÆ\u0003JF\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00050\tHÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00050\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014¨\u0006#"}, d2 = {"Lcom/bytedance/tobshadow/applog/exposure/ViewExposureConfig;", "Lcom/bytedance/tobshadow/applog/exposure/IExposureConfig;", "areaRatio", "", "visualDiagnosis", "", "stayTriggerTime", "", "exposureCallback", "Lkotlin/Function1;", "Lcom/bytedance/tobshadow/applog/exposure/ViewExposureParam;", "(Ljava/lang/Float;Ljava/lang/Boolean;JLkotlin/jvm/functions/Function1;)V", "getAreaRatio", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getExposureCallback", "()Lkotlin/jvm/functions/Function1;", "getStayTriggerTime", "()J", "getVisualDiagnosis", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Float;Ljava/lang/Boolean;JLkotlin/jvm/functions/Function1;)Lcom/bytedance/tobshadow/applog/exposure/ViewExposureConfig;", "equals", "other", "", "hashCode", "", "toString", "", "agent_liteChinaRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final /* data */ class ViewExposureConfig implements IExposureConfig {

    /* renamed from: a */
    public final Float f389a;

    /* renamed from: b */
    public final Boolean f390b;

    /* renamed from: c */
    public final long f391c;

    /* renamed from: d */
    public final Function1<ViewExposureParam, Boolean> f392d;

    /* renamed from: com.bytedance.tobshadow.applog.exposure.ViewExposureConfig$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class C0357a extends Lambda implements Function1<ViewExposureParam, Boolean> {

        /* renamed from: a */
        public static final C0357a f393a = new C0357a();

        public C0357a() {
            super(1);
        }

        public Object invoke(Object obj) {
            Intrinsics.checkParameterIsNotNull((ViewExposureParam) obj, "it");
            return true;
        }
    }

    public ViewExposureConfig() {
        this(null, null, 0L, null, 15, null);
    }

    public ViewExposureConfig(Float f) {
        this(f, null, 0L, null, 14, null);
    }

    public ViewExposureConfig(Float f, Boolean bool) {
        this(f, bool, 0L, null, 12, null);
    }

    public ViewExposureConfig(Float f, Boolean bool, long j) {
        this(f, bool, j, null, 8, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ViewExposureConfig(Float f, Boolean bool, long j, Function1<? super ViewExposureParam, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "exposureCallback");
        this.f389a = f;
        this.f390b = bool;
        this.f391c = j;
        this.f392d = function1;
    }

    public /* synthetic */ ViewExposureConfig(Float f, Boolean bool, long j, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : f, (i & 2) != 0 ? false : bool, (i & 4) != 0 ? 0L : j, (i & 8) != 0 ? C0357a.f393a : function1);
    }

    public static /* synthetic */ ViewExposureConfig copy$default(ViewExposureConfig viewExposureConfig, Float f, Boolean bool, long j, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            f = viewExposureConfig.f389a;
        }
        if ((i & 2) != 0) {
            bool = viewExposureConfig.f390b;
        }
        Boolean bool2 = bool;
        if ((i & 4) != 0) {
            j = viewExposureConfig.f391c;
        }
        long j2 = j;
        if ((i & 8) != 0) {
            function1 = viewExposureConfig.f392d;
        }
        return viewExposureConfig.copy(f, bool2, j2, function1);
    }

    /* renamed from: component1, reason: from getter */
    public final Float getF389a() {
        return this.f389a;
    }

    /* renamed from: component2, reason: from getter */
    public final Boolean getF390b() {
        return this.f390b;
    }

    /* renamed from: component3, reason: from getter */
    public final long getF391c() {
        return this.f391c;
    }

    public final Function1<ViewExposureParam, Boolean> component4() {
        return this.f392d;
    }

    public final ViewExposureConfig copy(Float areaRatio, Boolean visualDiagnosis, long stayTriggerTime, Function1<? super ViewExposureParam, Boolean> exposureCallback) {
        Intrinsics.checkParameterIsNotNull(exposureCallback, "exposureCallback");
        return new ViewExposureConfig(areaRatio, visualDiagnosis, stayTriggerTime, exposureCallback);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ViewExposureConfig)) {
            return false;
        }
        ViewExposureConfig viewExposureConfig = (ViewExposureConfig) other;
        return Intrinsics.areEqual(this.f389a, viewExposureConfig.f389a) && Intrinsics.areEqual(this.f390b, viewExposureConfig.f390b) && this.f391c == viewExposureConfig.f391c && Intrinsics.areEqual(this.f392d, viewExposureConfig.f392d);
    }

    public final Float getAreaRatio() {
        return this.f389a;
    }

    public final Function1<ViewExposureParam, Boolean> getExposureCallback() {
        return this.f392d;
    }

    public final long getStayTriggerTime() {
        return this.f391c;
    }

    public final Boolean getVisualDiagnosis() {
        return this.f390b;
    }

    public int hashCode() {
        Float f = this.f389a;
        int hashCode = (f != null ? f.hashCode() : 0) * 31;
        Boolean bool = this.f390b;
        int hashCode2 = (hashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        long j = this.f391c;
        int i = (hashCode2 + ((int) (j ^ (j >>> 32)))) * 31;
        Function1<ViewExposureParam, Boolean> function1 = this.f392d;
        return i + (function1 != null ? function1.hashCode() : 0);
    }

    public String toString() {
        return C0380a.m252a("ViewExposureConfig(areaRatio=").append(this.f389a).append(", visualDiagnosis=").append(this.f390b).append(", stayTriggerTime=").append(this.f391c).append(", exposureCallback=").append(this.f392d).append(")").toString();
    }
}
