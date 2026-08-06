package com.bytedance.tobshadow.bdtracker;

import android.text.TextUtils;
import com.bytedance.tobshadow.bdtracker.InterfaceC0400c3;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* renamed from: com.bytedance.tobshadow.bdtracker.l3 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class C0464l3 implements InterfaceC0408d3 {

    /* renamed from: a */
    public final Throwable f738a;

    public C0464l3(Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "throwable");
        this.f738a = th;
    }

    @Override // com.bytedance.tobshadow.bdtracker.InterfaceC0392b3
    /* renamed from: a */
    public List<String> mo256a() {
        if (TextUtils.isEmpty(this.f738a.getMessage())) {
            return C0411e.m348a();
        }
        return CollectionsKt.listOf(new String[]{"metrics_category", "metrics_name", "err_underlying_code"});
    }

    @Override // com.bytedance.tobshadow.bdtracker.InterfaceC0400c3
    /* renamed from: a */
    public void mo257a(JSONObject jSONObject) {
        Intrinsics.checkParameterIsNotNull(jSONObject, "params");
        StringWriter stringWriter = new StringWriter();
        this.f738a.printStackTrace(new PrintWriter(stringWriter));
        String message = this.f738a.getMessage();
        if (message == null) {
            message = "unknown";
        }
        jSONObject.put("err_underlying_code", message);
        jSONObject.put("err_message", stringWriter.toString());
    }

    @Override // com.bytedance.tobshadow.bdtracker.InterfaceC0400c3
    /* renamed from: b */
    public String mo258b() {
        return "sdk_exception";
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
        return "data_statistics";
    }

    @Override // com.bytedance.tobshadow.bdtracker.InterfaceC0392b3
    /* renamed from: f */
    public List<Number> mo262f() {
        return C0411e.m377d();
    }

    @Override // com.bytedance.tobshadow.bdtracker.InterfaceC0400c3
    /* renamed from: g */
    public Object mo263g() {
        return 1;
    }
}
