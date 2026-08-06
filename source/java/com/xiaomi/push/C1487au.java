package com.xiaomi.push;

import android.net.NetworkInfo;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.xiaomi.push.au */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1487au {

    /* renamed from: a */
    private final NetworkInfo f1019a;

    /* renamed from: a */
    private final ConcurrentHashMap<String, Object> f1020a = new ConcurrentHashMap<>();

    public C1487au(NetworkInfo networkInfo) {
        this.f1019a = networkInfo;
    }

    /* renamed from: a */
    private <T> T m1556a(String str) {
        char c;
        Object valueOf;
        if (!this.f1020a.containsKey(str)) {
            synchronized (str) {
                if (!this.f1020a.contains(str)) {
                    switch (str.hashCode()) {
                        case -830707388:
                            if (str.equals("getSubtype")) {
                                c = 2;
                                break;
                            }
                            c = 65535;
                            break;
                        case -75106384:
                            if (str.equals("getType")) {
                                c = 0;
                                break;
                            }
                            c = 65535;
                            break;
                        case -66906641:
                            if (str.equals("getSubtypeName")) {
                                c = 3;
                                break;
                            }
                            c = 65535;
                            break;
                        case 599209215:
                            if (str.equals("isConnected")) {
                                c = 4;
                                break;
                            }
                            c = 65535;
                            break;
                        case 711698955:
                            if (str.equals("getDetailedState")) {
                                c = 6;
                                break;
                            }
                            c = 65535;
                            break;
                        case 1401392731:
                            if (str.equals("getTypeName")) {
                                c = 1;
                                break;
                            }
                            c = 65535;
                            break;
                        case 1965583067:
                            if (str.equals("getState")) {
                                c = 5;
                                break;
                            }
                            c = 65535;
                            break;
                        default:
                            c = 65535;
                            break;
                    }
                    switch (c) {
                        case 0:
                            valueOf = Integer.valueOf(this.f1019a.getType());
                            break;
                        case 1:
                            valueOf = this.f1019a.getTypeName();
                            break;
                        case 2:
                            valueOf = Integer.valueOf(this.f1019a.getSubtype());
                            break;
                        case 3:
                            valueOf = this.f1019a.getSubtypeName();
                            break;
                        case 4:
                            valueOf = Boolean.valueOf(this.f1019a.isConnected());
                            break;
                        case 5:
                            valueOf = this.f1019a.getState();
                            break;
                        case 6:
                            valueOf = this.f1019a.getDetailedState();
                            break;
                        default:
                            valueOf = null;
                            break;
                    }
                    if (valueOf != null) {
                        this.f1020a.put(str, valueOf);
                    }
                }
            }
        }
        return (T) this.f1020a.get(str);
    }

    /* renamed from: a */
    public int m1557a() {
        return ((Integer) m1556a("getType")).intValue();
    }

    /* renamed from: b */
    public int m1562b() {
        return ((Integer) m1556a("getSubtype")).intValue();
    }

    /* renamed from: a */
    public String m1560a() {
        return (String) m1556a("getTypeName");
    }

    /* renamed from: b */
    public String m1563b() {
        return (String) m1556a("getSubtypeName");
    }

    /* renamed from: a */
    public boolean m1561a() {
        return ((Boolean) m1556a("isConnected")).booleanValue();
    }

    /* renamed from: a */
    public NetworkInfo.State m1559a() {
        return (NetworkInfo.State) m1556a("getState");
    }

    /* renamed from: a */
    public NetworkInfo.DetailedState m1558a() {
        return (NetworkInfo.DetailedState) m1556a("getDetailedState");
    }
}
