package ms.bd.p001c;

import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.io.encoding.Base64;

/* renamed from: ms.bd.c.f4 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class C0136f4 implements NetworkParams.AddSecurityFactorProcessCallback {

    /* renamed from: a */
    public final /* synthetic */ C0142g4 f167a;

    public C0136f4(C0142g4 c0142g4) {
        this.f167a = c0142g4;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x017e A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Map onCallToAddSecurityFactor(String str, Map map) {
        int i;
        String[] strArr;
        Object obj;
        HashMap hashMap = new HashMap();
        if (str == null || map == null) {
            return hashMap;
        }
        String lowerCase = str.toLowerCase();
        if (!lowerCase.contains((String) AbstractC0190p2.m166a(16777217, 0, 0L, "576259", new byte[]{44, 33, 81, 86})) && !lowerCase.contains((String) AbstractC0190p2.m166a(16777217, 0, 0L, "09dd01", new byte[]{41, 47, 3, 0, 28})) && !lowerCase.contains((String) AbstractC0190p2.m166a(16777217, 0, 0L, "8eea0a", new byte[]{62, 116}))) {
            throw new RuntimeException((String) AbstractC0190p2.m166a(16777217, 0, 0L, "165999", new byte[]{41, 32, 6, 64, 19, Base64.padSymbol, 38, 87, 102, 108, 96, 60, 82, 89, 22, 97, 58, 3, 112, 121, 51, 123, 81, 94, 21}));
        }
        C0106a4 m70a = C0106a4.m70a();
        synchronized (m70a) {
            if (m70a.f130b == null) {
                int i2 = m70a.f129a;
                m70a.f129a = i2 + 1;
                if (i2 >= 30) {
                    m70a.f129a = 0;
                    m70a.f130b = new Throwable();
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = map.entrySet().iterator();
        while (true) {
            strArr = null;
            r10 = null;
            String str2 = null;
            if (!it.hasNext()) {
                break;
            }
            Map.Entry entry = (Map.Entry) it.next();
            String str3 = (String) entry.getKey();
            if (entry.getValue() != null && ((List) entry.getValue()).size() > 0) {
                str2 = (String) ((List) entry.getValue()).get(0);
            }
            if (str3 != null && str2 != null) {
                arrayList.add(str3);
                arrayList.add(str2);
            }
        }
        if (!lowerCase.startsWith((String) AbstractC0190p2.m166a(16777217, 0, 0L, "27a6e1", new byte[]{43, 33, 6, 82}))) {
            if (lowerCase.startsWith((String) AbstractC0190p2.m166a(16777217, 0, 0L, "a145af", new byte[]{103, 32}))) {
                arrayList.add((String) AbstractC0190p2.m166a(16777217, 0, 0L, "ae5312", new byte[]{69, 85, 106}));
                arrayList.add(str);
                obj = AbstractC0190p2.m166a(100663297, 0, this.f167a.f180a, null, (String[]) arrayList.toArray(new String[0]));
            }
            if (strArr != null) {
                return hashMap;
            }
            HashMap hashMap2 = new HashMap();
            for (i = 0; i < strArr.length; i += 2) {
                hashMap2.put(strArr[i], strArr[i + 1]);
            }
            return hashMap2;
        }
        obj = AbstractC0190p2.m166a(50331649, 0, this.f167a.f180a, str, (String[]) arrayList.toArray(new String[0]));
        strArr = (String[]) obj;
        if (strArr != null) {
        }
    }
}
