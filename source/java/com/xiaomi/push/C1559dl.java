package com.xiaomi.push;

import android.content.Context;

/* renamed from: com.xiaomi.push.dl */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1559dl extends AbstractC1558dk {
    @Override // com.xiaomi.push.C1470ad.a
    /* renamed from: a */
    public String mo1133a() {
        return "23";
    }

    public C1559dl(Context context, int i) {
        super(context, i);
    }

    @Override // com.xiaomi.push.AbstractC1558dk
    /* renamed from: b */
    public String mo2049b() {
        StringBuilder sb = new StringBuilder("ram:");
        sb.append(C1682i.m3379a()).append(",rom:").append(C1682i.m3389b()).append("|ramOriginal:").append(C1682i.m3393c()).append(",romOriginal:").append(C1682i.m3396d());
        return sb.toString();
    }

    @Override // com.xiaomi.push.AbstractC1558dk
    /* renamed from: a */
    public EnumC1635gg mo2047a() {
        return EnumC1635gg.Storage;
    }
}
