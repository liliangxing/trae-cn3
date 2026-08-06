package com.vivo.push.p010b;

import android.text.TextUtils;
import com.vivo.push.AbstractC1400v;
import com.vivo.push.C1232d;

/* compiled from: MsgArriveCommand.java */
/* renamed from: com.vivo.push.b.h */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1211h extends AbstractC1400v {

    /* renamed from: a */
    private String f347a;

    /* renamed from: b */
    private String f348b;

    public C1211h() {
        super(2013);
    }

    public C1211h(String str) {
        this();
        this.f347a = str;
    }

    public C1211h(String str, String str2) {
        this(str);
        this.f348b = str2;
    }

    @Override // com.vivo.push.AbstractC1400v
    /* renamed from: c */
    protected final void mo582c(C1232d c1232d) {
        c1232d.m654a("MsgArriveCommand.MSG_TAG", this.f347a);
        if (TextUtils.isEmpty(this.f348b)) {
            return;
        }
        c1232d.m654a("MsgArriveCommand.NODE_INFO", this.f348b);
    }

    @Override // com.vivo.push.AbstractC1400v
    /* renamed from: d */
    protected final void mo583d(C1232d c1232d) {
        this.f347a = c1232d.m650a("MsgArriveCommand.MSG_TAG");
        this.f348b = c1232d.m650a("MsgArriveCommand.NODE_INFO");
    }
}
