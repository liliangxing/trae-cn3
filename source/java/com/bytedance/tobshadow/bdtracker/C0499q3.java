package com.bytedance.tobshadow.bdtracker;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;

/* renamed from: com.bytedance.tobshadow.bdtracker.q3 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class C0499q3 extends AbstractC0485o3 {

    /* renamed from: e */
    public AtomicInteger f946e;

    /* renamed from: f */
    public List<C0492p3> f947f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0499q3(C0467m c0467m) {
        super(c0467m);
        Intrinsics.checkParameterIsNotNull(c0467m, "applog");
        this.f946e = new AtomicInteger();
        this.f947f = new ArrayList();
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0485o3
    /* renamed from: a */
    public String mo588a() {
        return "exception";
    }

    /* renamed from: a */
    public final void m618a(StringBuilder sb, Throwable th) {
        sb.append(th.toString());
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (stackTrace == null) {
            stackTrace = new StackTraceElement[0];
        }
        if (stackTrace.length > 3) {
            stackTrace = (StackTraceElement[]) ArraysKt.sliceArray(stackTrace, RangesKt.until(0, 3));
        }
        for (StackTraceElement stackTraceElement : stackTrace) {
            sb.append("\n\tat ").append(stackTraceElement);
        }
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0485o3
    /* renamed from: a */
    public void mo589a(JSONObject jSONObject) {
        Intrinsics.checkParameterIsNotNull(jSONObject, "params");
        C0467m c0467m = this.f894d;
        try {
            jSONObject.put("start_time", this.f891a);
            jSONObject.put("end_time", this.f892b);
            jSONObject.put("count", this.f946e.get());
            jSONObject.put("sampling", C0411e.m349a((List) this.f947f));
        } catch (Throwable th) {
            c0467m.f764D.error(7, "Run task failed", th, new Object[0]);
        }
    }

    /* renamed from: a */
    public final void m619a(Throwable th, String str) {
        Intrinsics.checkParameterIsNotNull(th, "t");
        Intrinsics.checkParameterIsNotNull(str, "tag");
        C0467m c0467m = this.f894d;
        try {
            this.f893c = true;
            this.f946e.incrementAndGet();
            List<C0492p3> list = this.f947f;
            long currentTimeMillis = System.currentTimeMillis();
            StringBuilder sb = new StringBuilder();
            while (th != null) {
                m618a(sb, th);
                th = th.getCause();
            }
            String sb2 = sb.toString();
            Intrinsics.checkExpressionValueIsNotNull(sb2, "stringBuilder.toString()");
            list.add(new C0492p3(currentTimeMillis, sb2, str));
        } catch (Throwable th2) {
            c0467m.f764D.error(7, "Run task failed", th2, new Object[0]);
        }
    }
}
