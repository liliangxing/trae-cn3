package com.bytedance.tobshadow.bdtracker;

import com.bytedance.tracing.log.Fields;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* renamed from: com.bytedance.tobshadow.bdtracker.v3 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class C0534v3 extends AbstractC0485o3 {

    /* renamed from: e */
    public AtomicInteger f1123e;

    /* renamed from: f */
    public AtomicInteger f1124f;

    /* renamed from: g */
    public AtomicInteger f1125g;

    /* renamed from: h */
    public AtomicInteger f1126h;

    /* renamed from: i */
    public AtomicInteger f1127i;

    /* renamed from: j */
    public AtomicInteger f1128j;

    /* renamed from: k */
    public AtomicInteger f1129k;

    /* renamed from: l */
    public AtomicInteger f1130l;

    /* renamed from: m */
    public AtomicInteger f1131m;

    /* renamed from: n */
    public AtomicInteger f1132n;

    /* renamed from: o */
    public AtomicInteger f1133o;

    /* renamed from: p */
    public List<C0527u3> f1134p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0534v3(C0467m c0467m) {
        super(c0467m);
        Intrinsics.checkParameterIsNotNull(c0467m, "applog");
        this.f1123e = new AtomicInteger();
        this.f1124f = new AtomicInteger();
        this.f1125g = new AtomicInteger();
        this.f1126h = new AtomicInteger();
        this.f1127i = new AtomicInteger();
        this.f1128j = new AtomicInteger();
        this.f1129k = new AtomicInteger();
        this.f1130l = new AtomicInteger();
        this.f1131m = new AtomicInteger();
        this.f1132n = new AtomicInteger(1);
        this.f1133o = new AtomicInteger();
        this.f1134p = new ArrayList();
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0485o3
    /* renamed from: a */
    public String mo588a() {
        return "report";
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0485o3
    /* renamed from: a */
    public void mo589a(JSONObject jSONObject) {
        Intrinsics.checkParameterIsNotNull(jSONObject, "params");
        C0467m c0467m = this.f894d;
        try {
            jSONObject.put("start_time", this.f891a);
            jSONObject.put("end_time", this.f892b);
            jSONObject.put("net", this.f1123e.get());
            jSONObject.put("f_net", this.f1124f.get());
            jSONObject.put("f_5xx", this.f1125g.get());
            jSONObject.put("f_4xx", this.f1126h.get());
            jSONObject.put("f_data", this.f1127i.get());
            jSONObject.put("make_event", this.f1129k.get());
            jSONObject.put("net_event", this.f1130l.get());
            jSONObject.put("f_net_event", this.f1131m.get());
            jSONObject.put(Fields.EVENT, this.f1128j.get());
            jSONObject.put("pre_event", this.f1133o.get());
            jSONObject.put("sampling", C0411e.m349a((List) this.f1134p));
        } catch (Throwable th) {
            c0467m.f764D.error(7, "Run task failed", th, new Object[0]);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x003a, code lost:
    
        if (r6 != null) goto L18;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0010. Please report as an issue. */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final <T> void m719a(String str, T t) {
        AtomicInteger atomicInteger;
        Integer num;
        int i;
        Intrinsics.checkParameterIsNotNull(str, "key");
        C0467m c0467m = this.f894d;
        try {
            this.f893c = true;
            switch (str.hashCode()) {
                case -1283983389:
                    if (str.equals("f_data")) {
                        atomicInteger = this.f1127i;
                        boolean z = t instanceof Integer;
                        Object obj = t;
                        if (!z) {
                            obj = (T) null;
                        }
                        num = (Integer) obj;
                        if (num != null) {
                            i = num.intValue();
                            atomicInteger.addAndGet(i);
                            return;
                        }
                        i = 0;
                        atomicInteger.addAndGet(i);
                        return;
                    }
                    return;
                case 108957:
                    if (str.equals("net")) {
                        atomicInteger = this.f1123e;
                        boolean z2 = t instanceof Integer;
                        Object obj2 = t;
                        if (!z2) {
                            obj2 = (T) null;
                        }
                        num = (Integer) obj2;
                        if (num != null) {
                            i = num.intValue();
                            atomicInteger.addAndGet(i);
                            return;
                        }
                        i = 0;
                        atomicInteger.addAndGet(i);
                        return;
                    }
                    return;
                case 96891546:
                    if (str.equals(Fields.EVENT)) {
                        atomicInteger = this.f1128j;
                        boolean z3 = t instanceof Integer;
                        Object obj3 = t;
                        if (!z3) {
                            obj3 = (T) null;
                        }
                        num = (Integer) obj3;
                        if (num != null) {
                            i = num.intValue();
                            atomicInteger.addAndGet(i);
                            return;
                        }
                        i = 0;
                        atomicInteger.addAndGet(i);
                        return;
                    }
                    return;
                case 97083099:
                    if (str.equals("f_4xx")) {
                        atomicInteger = this.f1126h;
                        boolean z4 = t instanceof Integer;
                        Object obj4 = t;
                        if (!z4) {
                            obj4 = (T) null;
                        }
                        num = (Integer) obj4;
                        if (num != null) {
                            i = num.intValue();
                            atomicInteger.addAndGet(i);
                            return;
                        }
                        i = 0;
                        atomicInteger.addAndGet(i);
                        return;
                    }
                    return;
                case 97084060:
                    if (str.equals("f_5xx")) {
                        atomicInteger = this.f1125g;
                        boolean z5 = t instanceof Integer;
                        Object obj5 = t;
                        if (!z5) {
                            obj5 = (T) null;
                        }
                        num = (Integer) obj5;
                        if (num != null) {
                            i = num.intValue();
                            atomicInteger.addAndGet(i);
                            return;
                        }
                        i = 0;
                        atomicInteger.addAndGet(i);
                        return;
                    }
                    return;
                case 97138244:
                    if (str.equals("f_net")) {
                        atomicInteger = this.f1124f;
                        boolean z6 = t instanceof Integer;
                        Object obj6 = t;
                        if (!z6) {
                            obj6 = (T) null;
                        }
                        num = (Integer) obj6;
                        if (num != null) {
                            i = num.intValue();
                            atomicInteger.addAndGet(i);
                            return;
                        }
                        i = 0;
                        atomicInteger.addAndGet(i);
                        return;
                    }
                    return;
                case 587804937:
                    if (str.equals("make_event")) {
                        atomicInteger = this.f1129k;
                        boolean z7 = t instanceof Integer;
                        Object obj7 = t;
                        if (!z7) {
                            obj7 = (T) null;
                        }
                        num = (Integer) obj7;
                        if (num != null) {
                            i = num.intValue();
                            atomicInteger.addAndGet(i);
                            return;
                        }
                        i = 0;
                        atomicInteger.addAndGet(i);
                        return;
                    }
                    return;
                case 1272203487:
                    if (str.equals("f_net_event")) {
                        atomicInteger = this.f1131m;
                        boolean z8 = t instanceof Integer;
                        Object obj8 = t;
                        if (!z8) {
                            obj8 = (T) null;
                        }
                        num = (Integer) obj8;
                        if (num != null) {
                            i = num.intValue();
                            atomicInteger.addAndGet(i);
                            return;
                        }
                        i = 0;
                        atomicInteger.addAndGet(i);
                        return;
                    }
                    return;
                case 1366562168:
                    if (str.equals("net_event")) {
                        atomicInteger = this.f1130l;
                        boolean z9 = t instanceof Integer;
                        Object obj9 = t;
                        if (!z9) {
                            obj9 = (T) null;
                        }
                        num = (Integer) obj9;
                        break;
                    } else {
                        return;
                    }
                case 1975570407:
                    if (str.equals("sampling") && (t instanceof C0527u3)) {
                        this.f1134p.add(t);
                        return;
                    }
                    return;
                default:
                    return;
            }
        } catch (Throwable th) {
            c0467m.f764D.error(7, "Run task failed", th, new Object[0]);
        }
    }
}
