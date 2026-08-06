package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.lynx.tasm.behavior.shadow.text.TextAttributes;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;

/* renamed from: com.xiaomi.push.bp */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1509bp extends C1511br {
    public C1509bp(String str, String str2, String[] strArr, String str3) {
        super(str, str2, strArr, str3);
    }

    /* renamed from: a */
    public static C1509bp m1691a(Context context, String str, int i) {
        AbstractC1417b.m1098b("delete  messages when db size is too bigger");
        String m1706a = C1515bv.m1703a(context).m1706a(str);
        if (TextUtils.isEmpty(m1706a)) {
            return null;
        }
        StringBuilder sb = new StringBuilder("rowDataId in (select ");
        sb.append("rowDataId from " + m1706a);
        sb.append(" order by createTimeStamp asc limit ?)");
        return new C1509bp(str, sb.toString(), new String[]{String.valueOf(i)}, "a job build to delete history message");
    }

    /* renamed from: a */
    private void m1692a(long j) {
        if (this.f1127a == null || this.f1127a.length <= 0) {
            return;
        }
        this.f1127a[0] = String.valueOf(j);
    }

    @Override // com.xiaomi.push.C1515bv.a
    /* renamed from: a */
    public void mo1693a(Context context, Object obj) {
        if (obj instanceof Long) {
            long longValue = ((Long) obj).longValue();
            long m1724a = C1519bz.m1724a(mo1711a());
            long j = C1507bn.f1093a;
            if (m1724a > j) {
                long j2 = (long) ((((m1724a - j) * 1.2d) / j) * longValue);
                m1692a(j2);
                C1506bm.m1678a(context).m1688a("begin delete " + j2 + "noUpload messages , because db size is " + m1724a + TextAttributes.INLINE_BLOCK_PLACEHOLDER);
                super.mo1693a(context, obj);
                return;
            }
            AbstractC1417b.m1098b("db size is suitable");
        }
    }
}
