package com.vivo.push.p017h;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.AbstractC1400v;
import com.vivo.push.C1306m;
import com.vivo.push.C1357t;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.p010b.C1211h;
import com.vivo.push.p010b.C1220q;
import com.vivo.push.p010b.C1228y;
import com.vivo.push.restructure.C1313a;
import com.vivo.push.util.C1366aa;
import com.vivo.push.util.C1373ah;
import com.vivo.push.util.C1379f;
import com.vivo.push.util.C1393t;
import java.util.HashMap;

/* compiled from: OnNotificationArrivedReceiveTask.java */
/* renamed from: com.vivo.push.h.u */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1295u extends AbstractC1266ab {

    /* compiled from: OnNotificationArrivedReceiveTask.java */
    /* renamed from: com.vivo.push.h.u$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface a {
        /* renamed from: a */
        void mo735a();

        /* renamed from: b */
        void mo736b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1295u(AbstractC1400v abstractC1400v) {
        super(abstractC1400v);
    }

    @Override // com.vivo.push.AbstractRunnableC1352s
    /* renamed from: a */
    protected final void mo702a(AbstractC1400v abstractC1400v) {
        if (abstractC1400v == null) {
            C1393t.m1034a("OnNotificationArrivedTask", "command is null");
            return;
        }
        C1220q c1220q = (C1220q) abstractC1400v;
        boolean m932d = C1366aa.m932d(this.f625a, this.f625a.getPackageName());
        if (!m932d && !c1220q.m624g()) {
            C1228y c1228y = new C1228y(2101L);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("messageID", String.valueOf(c1220q.m632h()));
            String mo854a = C1313a.m810a().m815e().mo854a();
            if (!TextUtils.isEmpty(mo854a)) {
                hashMap.put("remoteAppId", mo854a);
            }
            c1228y.m636a(hashMap);
            C1306m.m762a().m776a(c1228y);
            C1393t.m1048d("OnNotificationArrivedTask", "PushMessageReceiver " + this.f625a.getPackageName() + " isMsgNoShowOnForeground :" + c1220q.m632h());
            return;
        }
        C1306m.m762a().m776a(new C1211h(String.valueOf(c1220q.m632h())));
        if (C1306m.m762a().m792g() && !m707a(C1373ah.m965c(this.f625a), c1220q.m623f(), c1220q.m633k())) {
            C1228y c1228y2 = new C1228y(1021L);
            HashMap<String, String> hashMap2 = new HashMap<>();
            hashMap2.put("messageID", String.valueOf(c1220q.m632h()));
            String mo854a2 = C1313a.m810a().m815e().mo854a();
            if (!TextUtils.isEmpty(mo854a2)) {
                hashMap2.put("remoteAppId", mo854a2);
            }
            c1228y2.m636a(hashMap2);
            C1306m.m762a().m776a(c1228y2);
            C1393t.m1048d("OnNotificationArrivedTask", "vertifyMsg not match =" + c1220q.m632h());
            return;
        }
        InsideNotificationItem m622e = c1220q.m622e();
        if (m622e != null) {
            C1393t.m1048d("OnNotificationArrivedTask", "targetType is " + m622e.getTargetType() + " ; target is " + m622e.getTargetContent());
            C1357t.m917b(new RunnableC1296v(this, m622e, c1220q, m932d));
            return;
        }
        C1393t.m1034a("OnNotificationArrivedTask", "notify is null");
        C1393t.m1047c(this.f625a, "通知内容为空，" + c1220q.m632h());
        Context context = this.f625a;
        C1379f.m994a(c1220q.m632h(), 1027L);
    }
}
