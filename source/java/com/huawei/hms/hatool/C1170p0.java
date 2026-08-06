package com.huawei.hms.hatool;

import com.huawei.hms.framework.common.BundleUtil;
import java.util.Calendar;
import java.util.UUID;

/* renamed from: com.huawei.hms.hatool.p0 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1170p0 {

    /* renamed from: a */
    private long f1532a = 1800000;

    /* renamed from: b */
    private volatile boolean f1533b = false;

    /* renamed from: c */
    private a f1534c = null;

    /* renamed from: com.huawei.hms.hatool.p0$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    private class a {

        /* renamed from: a */
        String f1535a = UUID.randomUUID().toString().replace("-", "");

        /* renamed from: b */
        boolean f1536b;

        /* renamed from: c */
        private long f1537c;

        a(long j) {
            this.f1535a += BundleUtil.UNDERLINE_TAG + j;
            this.f1537c = j;
            this.f1536b = true;
            C1170p0.this.f1533b = false;
        }

        /* renamed from: a */
        private boolean m1679a(long j, long j2) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(j);
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTimeInMillis(j2);
            return (calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6)) ? false : true;
        }

        /* renamed from: b */
        private void m1680b(long j) {
            C1182v.m1781c("hmsSdk", "getNewSession() session is flush!");
            String uuid = UUID.randomUUID().toString();
            this.f1535a = uuid;
            this.f1535a = uuid.replace("-", "");
            this.f1535a += BundleUtil.UNDERLINE_TAG + j;
            this.f1537c = j;
            this.f1536b = true;
        }

        /* renamed from: b */
        private boolean m1681b(long j, long j2) {
            return j2 - j >= C1170p0.this.f1532a;
        }

        /* renamed from: a */
        void m1682a(long j) {
            if (C1170p0.this.f1533b) {
                C1170p0.this.f1533b = false;
                m1680b(j);
            } else if (m1681b(this.f1537c, j) || m1679a(this.f1537c, j)) {
                m1680b(j);
            } else {
                this.f1537c = j;
                this.f1536b = false;
            }
        }
    }

    /* renamed from: a */
    public String m1676a() {
        a aVar = this.f1534c;
        if (aVar != null) {
            return aVar.f1535a;
        }
        C1182v.m1786f("hmsSdk", "getSessionName(): session not prepared. onEvent() must be called first.");
        return "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m1677a(long j) {
        a aVar = this.f1534c;
        if (aVar != null) {
            aVar.m1682a(j);
        } else {
            C1182v.m1781c("hmsSdk", "Session is first flush");
            this.f1534c = new a(j);
        }
    }

    /* renamed from: b */
    public boolean m1678b() {
        a aVar = this.f1534c;
        if (aVar != null) {
            return aVar.f1536b;
        }
        C1182v.m1786f("hmsSdk", "isFirstEvent(): session not prepared. onEvent() must be called first.");
        return false;
    }
}
