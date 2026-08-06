package com.bytedance.tobshadow.bdtracker;

import org.json.JSONObject;

/* renamed from: com.bytedance.tobshadow.bdtracker.p0 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0489p0 extends AbstractC0461l0 {

    /* renamed from: i */
    public static final long[] f906i = {1000};

    /* renamed from: g */
    public final String f907g;

    /* renamed from: h */
    public int f908h;

    public C0489p0(C0475n0 c0475n0, String str) {
        super(c0475n0);
        this.f908h = 0;
        this.f907g = str;
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0461l0
    /* renamed from: c */
    public boolean mo485c() {
        int i = this.f735f.f782k.m470a((JSONObject) null, this.f907g) ? 0 : this.f908h + 1;
        this.f908h = i;
        if (i > 3) {
            this.f735f.setRangersEventVerifyEnable(false, this.f907g);
        }
        return true;
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0461l0
    /* renamed from: d */
    public String mo486d() {
        return "RangersEventVerify";
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0461l0
    /* renamed from: e */
    public long[] mo487e() {
        return f906i;
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0461l0
    /* renamed from: f */
    public boolean mo488f() {
        return true;
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0461l0
    /* renamed from: g */
    public long mo489g() {
        return 1000L;
    }
}
