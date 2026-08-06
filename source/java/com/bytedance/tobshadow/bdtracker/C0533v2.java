package com.bytedance.tobshadow.bdtracker;

import android.content.Context;
import android.os.Looper;
import com.bytedance.applog.aggregation.IAggregation;
import com.bytedance.applog.aggregation.IAggregationFlushCallback;
import com.bytedance.applog.aggregation.IMetricsTracker;
import com.bytedance.applog.aggregation.Metrics;
import com.bytedance.applog.aggregation.MetricsSQLiteCache;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ \u0010\u0015\u001a\u00020\u00162\u0018\u0010\u0017\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u0019\u0012\u0004\u0012\u00020\u00160\u0018J\u000e\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001dR\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR'\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00110\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000e\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/bytedance/tobshadow/applog/monitor/MetricsTrackerHelper;", "", "looper", "Landroid/os/Looper;", "appId", "", "context", "Landroid/content/Context;", "(Landroid/os/Looper;Ljava/lang/String;Landroid/content/Context;)V", "aggregation", "Lcom/bytedance/applog/aggregation/IAggregation;", "getAggregation", "()Lcom/bytedance/applog/aggregation/IAggregation;", "aggregation$delegate", "Lkotlin/Lazy;", "trackMap", "", "Lcom/bytedance/applog/aggregation/IMetricsTracker;", "getTrackMap", "()Ljava/util/Map;", "trackMap$delegate", "flush", "", "callback", "Lkotlin/Function1;", "", "Lcom/bytedance/applog/aggregation/Metrics;", "metricsTracker", "data", "Lcom/bytedance/tobshadow/applog/monitor/model/BaseTrace;", "agent_liteChinaRelease"}, k = 1, mv = {1, 1, 16})
/* renamed from: com.bytedance.tobshadow.bdtracker.v2 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class C0533v2 {

    /* renamed from: c */
    public static final /* synthetic */ KProperty[] f1115c = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(C0533v2.class), "aggregation", "getAggregation()Lcom/bytedance/applog/aggregation/IAggregation;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(C0533v2.class), "trackMap", "getTrackMap()Ljava/util/Map;"))};

    /* renamed from: a */
    public final Lazy f1116a;

    /* renamed from: b */
    public final Lazy f1117b;

    /* renamed from: com.bytedance.tobshadow.bdtracker.v2$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class a extends Lambda implements Function0<IAggregation> {

        /* renamed from: a */
        public final /* synthetic */ String f1118a;

        /* renamed from: b */
        public final /* synthetic */ Context f1119b;

        /* renamed from: c */
        public final /* synthetic */ Looper f1120c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, Context context, Looper looper) {
            super(0);
            this.f1118a = str;
            this.f1119b = context;
            this.f1120c = looper;
        }

        public Object invoke() {
            return IAggregation.Companion.newInstance(new MetricsSQLiteCache(this.f1119b, C0380a.m252a("applog-aggregation-").append(this.f1118a).toString()), this.f1120c);
        }
    }

    /* renamed from: com.bytedance.tobshadow.bdtracker.v2$b */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class b implements IAggregationFlushCallback {

        /* renamed from: a */
        public final /* synthetic */ Function1 f1121a;

        public b(Function1 function1) {
            this.f1121a = function1;
        }

        public void onFinish(List<Metrics> list) {
            Intrinsics.checkParameterIsNotNull(list, "metrics");
            this.f1121a.invoke(list);
        }
    }

    /* renamed from: com.bytedance.tobshadow.bdtracker.v2$c */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class c extends Lambda implements Function0<Map<String, IMetricsTracker>> {

        /* renamed from: a */
        public static final c f1122a = new c();

        public c() {
            super(0);
        }

        public Object invoke() {
            return new LinkedHashMap();
        }
    }

    public C0533v2(Looper looper, String str, Context context) {
        Intrinsics.checkParameterIsNotNull(looper, "looper");
        Intrinsics.checkParameterIsNotNull(str, "appId");
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.f1116a = LazyKt.lazy(new a(str, context, looper));
        this.f1117b = LazyKt.lazy(c.f1122a);
    }

    /* renamed from: a */
    public final void m718a(Function1<? super List<Metrics>, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "callback");
        Lazy lazy = this.f1116a;
        KProperty kProperty = f1115c[0];
        ((IAggregation) lazy.getValue()).flush(new b(function1));
    }

    /* renamed from: a */
    public final IMetricsTracker m717a(InterfaceC0400c3 interfaceC0400c3) {
        Intrinsics.checkParameterIsNotNull(interfaceC0400c3, "data");
        Lazy lazy = this.f1117b;
        KProperty[] kPropertyArr = f1115c;
        KProperty kProperty = kPropertyArr[1];
        IMetricsTracker iMetricsTracker = (IMetricsTracker) ((Map) lazy.getValue()).get(Intrinsics.stringPlus(Reflection.getOrCreateKotlinClass(interfaceC0400c3.getClass()).getSimpleName(), interfaceC0400c3.mo256a()));
        if (iMetricsTracker != null) {
            return iMetricsTracker;
        }
        Lazy lazy2 = this.f1116a;
        KProperty kProperty2 = kPropertyArr[0];
        IAggregation iAggregation = (IAggregation) lazy2.getValue();
        String simpleName = interfaceC0400c3.getClass().getSimpleName();
        Intrinsics.checkExpressionValueIsNotNull(simpleName, "data::class.java.simpleName");
        IMetricsTracker newMetricsTracker = iAggregation.newMetricsTracker(simpleName, interfaceC0400c3.mo259c(), interfaceC0400c3.mo256a(), interfaceC0400c3.mo262f());
        Lazy lazy3 = this.f1117b;
        KProperty kProperty3 = kPropertyArr[1];
        ((Map) lazy3.getValue()).put(Intrinsics.stringPlus(Reflection.getOrCreateKotlinClass(interfaceC0400c3.getClass()).getSimpleName(), interfaceC0400c3.mo256a()), newMetricsTracker);
        return newMetricsTracker;
    }
}
