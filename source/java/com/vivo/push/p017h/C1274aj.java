package com.vivo.push.p017h;

import com.ss.android.socialbase.appdownloader.constants.InstallErrorCode;
import com.vivo.push.AbstractC1400v;
import com.vivo.push.AbstractRunnableC1352s;
import com.vivo.push.C1306m;
import com.vivo.push.model.C1307a;
import com.vivo.push.p009a.C1200a;
import com.vivo.push.p010b.C1206c;
import com.vivo.push.p010b.C1208e;
import com.vivo.push.p010b.C1227x;
import com.vivo.push.restructure.C1313a;
import com.vivo.push.util.C1366aa;
import com.vivo.push.util.C1376c;
import com.vivo.push.util.C1393t;
import com.vivo.push.util.C1398y;
import com.vivo.push.util.C1399z;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SendCommandTask.java */
/* renamed from: com.vivo.push.h.aj */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1274aj extends AbstractRunnableC1352s {
    /* JADX INFO: Access modifiers changed from: package-private */
    public C1274aj(AbstractC1400v abstractC1400v) {
        super(abstractC1400v);
    }

    @Override // com.vivo.push.AbstractRunnableC1352s
    /* renamed from: a */
    protected final void mo702a(AbstractC1400v abstractC1400v) {
        if (this.f625a == null) {
            C1393t.m1048d("SendCommandTask", "SendCommandTask " + abstractC1400v + " ; mContext is Null");
            return;
        }
        if (abstractC1400v == null) {
            C1393t.m1048d("SendCommandTask", "SendCommandTask pushCommand is Null");
            return;
        }
        C1307a m924a = C1366aa.m924a(this.f625a, C1313a.m810a().m816f());
        int m1067b = abstractC1400v.m1067b();
        if (m1067b != 2009) {
            if (m1067b == 2011) {
                C1393t.m1048d("SendCommandTask", "SendCommandTask pushCommand is " + ((C1227x) abstractC1400v).m635e());
            } else {
                switch (m1067b) {
                    case 2002:
                    case InstallErrorCode.ERROR_NO_INSTALL_PERMISSION /* 2003 */:
                    case InstallErrorCode.ERROR_CANCELED /* 2004 */:
                    case InstallErrorCode.ERROR_TTMD5 /* 2005 */:
                        if (m924a == null || m924a.m808c()) {
                            C1306m.m762a().m778a(((C1206c) abstractC1400v).m592g(), 1005);
                            break;
                        } else {
                            C1206c c1206c = (C1206c) abstractC1400v;
                            int m1057a = C1398y.m1057a(c1206c);
                            if (m1057a != 0) {
                                C1306m.m762a().m778a(c1206c.m592g(), m1057a);
                                return;
                            }
                        }
                        break;
                }
            }
        } else if (C1393t.m1045b()) {
            C1306m.m762a();
            C1313a.m810a().m815e().mo864e();
            C1376c c1376c = new C1376c();
            c1376c.m982a(this.f625a, "com.vivo.push_preferences.hybridapptoken_v1");
            c1376c.m990b();
            new C1399z(this.f625a).m990b();
        }
        if (m924a == null) {
            C1393t.m1048d("SendCommandTask", "SendCommandTask " + abstractC1400v + " ; pushPkgInfo is Null");
            return;
        }
        String m802a = m924a.m802a();
        if (m924a.m808c()) {
            try {
                C1306m.m762a().m778a(((C1206c) abstractC1400v).m592g(), 1004);
            } catch (Exception e) {
                e.printStackTrace();
            }
            abstractC1400v = new C1208e();
            C1393t.m1048d("SendCommandTask", "SendCommandTask " + abstractC1400v + " ; pkgName is InBlackList ");
        }
        C1200a.m577a(this.f625a, m802a, abstractC1400v);
    }
}
