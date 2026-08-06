package com.bytedance.tobshadow.bdtracker;

import com.bytedance.tobshadow.bdtracker.InterfaceC0400c3;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* renamed from: com.bytedance.tobshadow.bdtracker.m3 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class C0471m3 implements InterfaceC0478n3 {

    /* renamed from: a */
    public final long f813a;

    public C0471m3(long j) {
        this.f813a = j;
    }

    @Override // com.bytedance.tobshadow.bdtracker.InterfaceC0392b3
    /* renamed from: a */
    public List<String> mo256a() {
        return C0411e.m348a();
    }

    @Override // com.bytedance.tobshadow.bdtracker.InterfaceC0400c3
    /* renamed from: a */
    public void mo257a(JSONObject jSONObject) {
        Intrinsics.checkParameterIsNotNull(jSONObject, "params");
        C0411e.m355a((InterfaceC0478n3) this, jSONObject);
    }

    @Override // com.bytedance.tobshadow.bdtracker.InterfaceC0400c3
    /* renamed from: b */
    public String mo258b() {
        return "sdk_init";
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
        return "sdk_usage";
    }

    @Override // com.bytedance.tobshadow.bdtracker.InterfaceC0392b3
    /* renamed from: f */
    public List<Number> mo262f() {
        return C0411e.m377d();
    }

    @Override // com.bytedance.tobshadow.bdtracker.InterfaceC0400c3
    /* renamed from: g */
    public Object mo263g() {
        return Long.valueOf(m528h());
    }

    /* renamed from: h */
    public long m528h() {
        return this.f813a;
    }
}
