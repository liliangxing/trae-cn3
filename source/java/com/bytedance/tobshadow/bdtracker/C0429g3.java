package com.bytedance.tobshadow.bdtracker;

import com.bytedance.tobshadow.applog.monitor.MonitorSampling;
import com.bytedance.tobshadow.bdtracker.InterfaceC0400c3;
import com.bytedance.tracing.log.Fields;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* renamed from: com.bytedance.tobshadow.bdtracker.g3 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class C0429g3 implements InterfaceC0436h3 {

    /* renamed from: a */
    public int f634a = -1;

    /* renamed from: b */
    public final long f635b;

    /* renamed from: c */
    public final String f636c;

    /* renamed from: d */
    public final long f637d;

    public C0429g3(long j, String str, long j2) {
        this.f635b = j;
        this.f636c = str;
        this.f637d = j2;
    }

    @Override // com.bytedance.tobshadow.bdtracker.InterfaceC0392b3
    /* renamed from: a */
    public List<String> mo256a() {
        return this.f634a == -1 ? CollectionsKt.listOf(new String[]{"metrics_category", "metrics_name", "dims_0", "launch_id", "process_id"}) : CollectionsKt.listOf(new String[]{"metrics_category", "metrics_name", "dims_0", "launch_id", "process_id", "err_code"});
    }

    @Override // com.bytedance.tobshadow.bdtracker.InterfaceC0400c3
    /* renamed from: a */
    public void mo257a(JSONObject jSONObject) {
        Intrinsics.checkParameterIsNotNull(jSONObject, "params");
        jSONObject.put("dims_0", this.f635b);
        jSONObject.put("process_id", this.f636c);
        jSONObject.put("launch_id", MonitorSampling.INSTANCE.getGlobalColdLaunchId$agent_liteChinaRelease());
        if (this.f635b == 13) {
            jSONObject.put("err_code", this.f634a);
        }
    }

    @Override // com.bytedance.tobshadow.bdtracker.InterfaceC0400c3
    /* renamed from: b */
    public String mo258b() {
        return "event_process";
    }

    @Override // com.bytedance.tobshadow.bdtracker.InterfaceC0392b3
    /* renamed from: c */
    public int mo259c() {
        return 7;
    }

    @Override // com.bytedance.tobshadow.bdtracker.InterfaceC0400c3
    /* renamed from: d */
    public JSONObject mo260d() {
        return InterfaceC0400c3.a.m293a(this);
    }

    @Override // com.bytedance.tobshadow.bdtracker.InterfaceC0400c3
    /* renamed from: e */
    public String mo261e() {
        return Fields.EVENT;
    }

    @Override // com.bytedance.tobshadow.bdtracker.InterfaceC0392b3
    /* renamed from: f */
    public List<Number> mo262f() {
        return C0411e.m377d();
    }

    @Override // com.bytedance.tobshadow.bdtracker.InterfaceC0400c3
    /* renamed from: g */
    public Object mo263g() {
        return Long.valueOf(this.f637d);
    }
}
