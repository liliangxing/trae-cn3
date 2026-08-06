package com.bytedance.tobshadow.bdtracker;

import com.bytedance.sdk.account.VcdNetConstants;
import com.bytedance.sdk.xbridge.cn.media.utils.FConstants;
import com.bytedance.tobshadow.bdtracker.InterfaceC0400c3;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* renamed from: com.bytedance.tobshadow.bdtracker.k3 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class C0457k3 implements InterfaceC0400c3 {

    /* renamed from: a */
    public int f717a;

    /* renamed from: b */
    public Integer f718b;

    /* renamed from: c */
    public String f719c;

    /* renamed from: d */
    public String f720d;

    /* renamed from: e */
    public long f721e;

    @Override // com.bytedance.tobshadow.bdtracker.InterfaceC0392b3
    /* renamed from: a */
    public List<String> mo256a() {
        if (this.f718b == null) {
            return C0411e.m348a();
        }
        return CollectionsKt.listOf(new String[]{"metrics_category", "metrics_name", "err_underlying_code"});
    }

    @Override // com.bytedance.tobshadow.bdtracker.InterfaceC0400c3
    /* renamed from: a */
    public void mo257a(JSONObject jSONObject) {
        Intrinsics.checkParameterIsNotNull(jSONObject, "params");
        if (this.f719c != null) {
            jSONObject.put("err_code", VcdNetConstants.API_VCD_GET_AUTH_ACCOUNT);
            jSONObject.put("err_message", this.f719c);
            jSONObject.put("err_underlying_code", this.f718b);
        }
        jSONObject.put("dim_success", this.f717a);
    }

    @Override // com.bytedance.tobshadow.bdtracker.InterfaceC0400c3
    /* renamed from: b */
    public String mo258b() {
        String str = this.f720d;
        if (str != null) {
            if (StringsKt.contains$default(str, "?", false, 2, (Object) null)) {
                str = str.substring(0, StringsKt.indexOf$default(str, "?", 0, false, 6, (Object) null));
                Intrinsics.checkExpressionValueIsNotNull(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            }
            if (str != null) {
                return str;
            }
        }
        return "";
    }

    @Override // com.bytedance.tobshadow.bdtracker.InterfaceC0392b3
    /* renamed from: c */
    public int mo259c() {
        return 23;
    }

    @Override // com.bytedance.tobshadow.bdtracker.InterfaceC0400c3
    /* renamed from: d */
    public JSONObject mo260d() {
        return InterfaceC0400c3.a.m293a(this);
    }

    @Override // com.bytedance.tobshadow.bdtracker.InterfaceC0400c3
    /* renamed from: e */
    public String mo261e() {
        return "network_service";
    }

    @Override // com.bytedance.tobshadow.bdtracker.InterfaceC0392b3
    /* renamed from: f */
    public List<Integer> mo262f() {
        return CollectionsKt.listOf(new Integer[]{0, Integer.valueOf(FConstants.URI_FAIL_CODE), 1000, 1500, 2000, 2500, 5000});
    }

    @Override // com.bytedance.tobshadow.bdtracker.InterfaceC0400c3
    /* renamed from: g */
    public Object mo263g() {
        return Long.valueOf(this.f721e);
    }
}
