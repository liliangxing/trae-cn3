package com.vivo.push.p017h;

import com.vivo.push.AbstractC1400v;
import com.vivo.push.p010b.C1221r;

/* compiled from: OnNotifyGuideDialogResultTask.java */
/* renamed from: com.vivo.push.h.y */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1299y extends AbstractC1266ab {
    /* JADX INFO: Access modifiers changed from: package-private */
    public C1299y(AbstractC1400v abstractC1400v) {
        super(abstractC1400v);
    }

    @Override // com.vivo.push.AbstractRunnableC1352s
    /* renamed from: a */
    protected final void mo702a(AbstractC1400v abstractC1400v) {
        int m625e = ((C1221r) abstractC1400v).m625e();
        if (this.f454b != null) {
            this.f454b.onNotifyGuideDialogResult(m625e);
        }
    }
}
