package com.bytedance.tobshadow.bdtracker;

import android.text.TextUtils;
import com.bytedance.tobshadow.bdtracker.InterfaceC0400c3;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* renamed from: com.bytedance.tobshadow.bdtracker.a3 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class C0384a3 implements InterfaceC0478n3 {

    /* renamed from: a */
    public final long f435a = 1;

    /* renamed from: b */
    public String f436b;

    /* renamed from: c */
    public long f437c;

    public C0384a3(String str, long j) {
        this.f436b = str;
        this.f437c = j;
    }

    @Override // com.bytedance.tobshadow.bdtracker.InterfaceC0392b3
    /* renamed from: a */
    public List<String> mo256a() {
        if (TextUtils.isEmpty(this.f436b)) {
            return C0411e.m348a();
        }
        return CollectionsKt.listOf(new String[]{"metrics_category", "metrics_name", "api_name"});
    }

    @Override // com.bytedance.tobshadow.bdtracker.InterfaceC0400c3
    /* renamed from: a */
    public void mo257a(JSONObject jSONObject) {
        Intrinsics.checkParameterIsNotNull(jSONObject, "params");
        jSONObject.put("api_name", this.f436b);
        jSONObject.put("api_time", this.f437c);
    }

    @Override // com.bytedance.tobshadow.bdtracker.InterfaceC0400c3
    /* renamed from: b */
    public String mo258b() {
        return "api_usage";
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
        return Long.valueOf(m264h());
    }

    /* renamed from: h */
    public long m264h() {
        return this.f435a;
    }
}
