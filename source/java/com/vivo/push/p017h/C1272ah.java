package com.vivo.push.p017h;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.AbstractC1400v;
import com.vivo.push.C1306m;
import com.vivo.push.p010b.C1225v;
import com.vivo.push.p010b.C1228y;
import com.vivo.push.restructure.C1313a;
import com.vivo.push.util.C1373ah;
import com.vivo.push.util.C1379f;
import com.vivo.push.util.C1393t;
import com.vivo.push.util.NotifyAdapterUtil;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OnUndoMsgReceiveTask.java */
/* renamed from: com.vivo.push.h.ah */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1272ah extends AbstractC1266ab {
    /* JADX INFO: Access modifiers changed from: package-private */
    public C1272ah(AbstractC1400v abstractC1400v) {
        super(abstractC1400v);
    }

    @Override // com.vivo.push.AbstractRunnableC1352s
    /* renamed from: a */
    protected final void mo702a(AbstractC1400v abstractC1400v) {
        C1225v c1225v = (C1225v) abstractC1400v;
        if (C1306m.m762a().m792g() && !m707a(C1373ah.m965c(this.f625a), c1225v.m631f(), c1225v.m633k())) {
            C1393t.m1048d("OnUndoMsgTask", " vertify msg is error ");
            C1228y c1228y = new C1228y(1021L);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("messageID", String.valueOf(c1225v.m632h()));
            String mo854a = C1313a.m810a().m815e().mo854a();
            if (!TextUtils.isEmpty(mo854a)) {
                hashMap.put("remoteAppId", mo854a);
            }
            c1228y.m636a(hashMap);
            C1306m.m762a().m776a(c1228y);
            return;
        }
        boolean repealNotifyById = NotifyAdapterUtil.repealNotifyById(this.f625a, c1225v.m630e());
        C1393t.m1048d("OnUndoMsgTask", "undo message " + c1225v.m630e() + ", " + repealNotifyById);
        if (repealNotifyById) {
            C1393t.m1043b(this.f625a, "回收client通知成功, 上报埋点 1031, messageId = " + c1225v.m630e());
            Context context = this.f625a;
            C1379f.m994a(c1225v.m630e(), 1031L);
        } else {
            C1393t.m1048d("OnUndoMsgTask", "undo message fail，messageId = " + c1225v.m630e());
            C1393t.m1047c(this.f625a, "回收client通知失败，messageId = " + c1225v.m630e());
        }
    }
}
