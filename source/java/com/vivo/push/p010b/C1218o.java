package com.vivo.push.p010b;

import android.text.TextUtils;
import com.vivo.push.C1232d;
import com.vivo.push.model.UnvarnishedMessage;

/* compiled from: OnMessageReceiveCommand.java */
/* renamed from: com.vivo.push.b.o */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1218o extends AbstractC1226w {

    /* renamed from: a */
    protected UnvarnishedMessage f361a;

    @Override // com.vivo.push.p010b.C1223t, com.vivo.push.AbstractC1400v
    public final String toString() {
        return "OnMessageCommand";
    }

    public C1218o() {
        super(3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.p010b.AbstractC1226w, com.vivo.push.p010b.C1223t, com.vivo.push.AbstractC1400v
    /* renamed from: c */
    public final void mo582c(C1232d c1232d) {
        super.mo582c(c1232d);
        c1232d.m654a("msg_v1", this.f361a.unpackToJson());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.p010b.AbstractC1226w, com.vivo.push.p010b.C1223t, com.vivo.push.AbstractC1400v
    /* renamed from: d */
    public final void mo583d(C1232d c1232d) {
        super.mo583d(c1232d);
        String m650a = c1232d.m650a("msg_v1");
        if (TextUtils.isEmpty(m650a)) {
            return;
        }
        UnvarnishedMessage unvarnishedMessage = new UnvarnishedMessage(m650a);
        this.f361a = unvarnishedMessage;
        unvarnishedMessage.setMsgId(m632h());
        this.f361a.setTransmissionMessageEventType(c1232d.m658b("transmission_message_event_type", 0));
    }

    /* renamed from: e */
    public final String m607e() {
        UnvarnishedMessage unvarnishedMessage = this.f361a;
        if (unvarnishedMessage == null) {
            return null;
        }
        return unvarnishedMessage.unpackToJson();
    }

    /* renamed from: f */
    public final UnvarnishedMessage m608f() {
        return this.f361a;
    }
}
