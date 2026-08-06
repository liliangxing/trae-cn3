package com.vivo.push.p017h;

import com.ss.android.socialbase.appdownloader.constants.InstallErrorCode;
import com.vivo.push.AbstractC1400v;
import com.vivo.push.AbstractRunnableC1352s;

/* compiled from: PushClientTaskFactory.java */
/* renamed from: com.vivo.push.h.ai */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1273ai {
    /* JADX WARN: Failed to find 'out' block for switch in B:8:0x0013. Please report as an issue. */
    /* renamed from: a */
    public static AbstractRunnableC1352s m713a(AbstractC1400v abstractC1400v) {
        AbstractRunnableC1352s c1272ah;
        int m1067b = abstractC1400v.m1067b();
        if (m1067b == 20) {
            c1272ah = new C1272ah(abstractC1400v);
        } else if (m1067b == 100) {
            c1272ah = new C1276b(abstractC1400v);
        } else if (m1067b != 101) {
            switch (m1067b) {
                case 0:
                    break;
                case 1:
                    c1272ah = new C1267ac(abstractC1400v);
                    break;
                case 2:
                    c1272ah = new C1286l(abstractC1400v);
                    break;
                case 3:
                    c1272ah = new C1294t(abstractC1400v);
                    break;
                case 4:
                    c1272ah = new C1295u(abstractC1400v);
                    break;
                case 5:
                    c1272ah = new C1298x(abstractC1400v);
                    break;
                case 6:
                    c1272ah = new C1300z(abstractC1400v);
                    break;
                case 7:
                    c1272ah = new C1292r(abstractC1400v);
                    break;
                case 8:
                    c1272ah = new C1290p(abstractC1400v);
                    break;
                case 9:
                    c1272ah = new C1285k(abstractC1400v);
                    break;
                case 10:
                    c1272ah = new C1282h(abstractC1400v);
                    break;
                case 11:
                    c1272ah = new C1270af(abstractC1400v);
                    break;
                case 12:
                    c1272ah = new C1284j(abstractC1400v);
                    break;
                default:
                    switch (m1067b) {
                        case 2000:
                        case 2001:
                        case 2002:
                        case InstallErrorCode.ERROR_NO_INSTALL_PERMISSION /* 2003 */:
                        case InstallErrorCode.ERROR_CANCELED /* 2004 */:
                        case InstallErrorCode.ERROR_TTMD5 /* 2005 */:
                        case 2008:
                        case 2009:
                        case 2010:
                        case 2011:
                        case 2012:
                        case 2013:
                        case 2014:
                        case 2015:
                            break;
                        case InstallErrorCode.ERROR_SIGNATURE /* 2006 */:
                            c1272ah = new C1264a(abstractC1400v);
                            break;
                        case InstallErrorCode.ERROR_NEED_UPGRADE /* 2007 */:
                            c1272ah = new C1275ak(abstractC1400v);
                            break;
                        default:
                            return null;
                    }
            }
            c1272ah = new C1274aj(abstractC1400v);
        } else {
            c1272ah = new C1277c(abstractC1400v);
        }
        return c1272ah;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x0010. Please report as an issue. */
    /* renamed from: b */
    public static AbstractC1266ab m714b(AbstractC1400v abstractC1400v) {
        AbstractC1266ab c1272ah;
        int m1067b = abstractC1400v.m1067b();
        if (m1067b == 20) {
            c1272ah = new C1272ah(abstractC1400v);
        } else if (m1067b == 2016) {
            c1272ah = new C1289o(abstractC1400v);
        } else if (m1067b != 2023) {
            switch (m1067b) {
                case 1:
                    c1272ah = new C1267ac(abstractC1400v);
                    break;
                case 2:
                    c1272ah = new C1286l(abstractC1400v);
                    break;
                case 3:
                    c1272ah = new C1294t(abstractC1400v);
                    break;
                case 4:
                    c1272ah = new C1295u(abstractC1400v);
                    break;
                case 5:
                    c1272ah = new C1298x(abstractC1400v);
                    break;
                case 6:
                    c1272ah = new C1300z(abstractC1400v);
                    break;
                case 7:
                    c1272ah = new C1292r(abstractC1400v);
                    break;
                case 8:
                    c1272ah = new C1290p(abstractC1400v);
                    break;
                case 9:
                    c1272ah = new C1285k(abstractC1400v);
                    break;
                case 10:
                    c1272ah = new C1282h(abstractC1400v);
                    break;
                case 11:
                    c1272ah = new C1270af(abstractC1400v);
                    break;
                default:
                    return null;
            }
        } else {
            c1272ah = new C1299y(abstractC1400v);
        }
        return c1272ah;
    }
}
