package ms.bd.p001c;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Map;

/* renamed from: ms.bd.c.z1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public abstract class AbstractC0239z1 {
    protected static String LIBNAME;

    /* renamed from: a */
    public static synchronized void m214a(Context context, int i, Map<String, String> map) {
        String[] strArr;
        synchronized (AbstractC0239z1.class) {
            AbstractC0180n2.f269f.f199a.set(0);
            AbstractC0180n2.m154a(context, LIBNAME);
            ArrayList arrayList = new ArrayList();
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)) {
                        arrayList.add(key);
                        arrayList.add(value);
                    }
                }
                strArr = (String[]) arrayList.toArray(new String[0]);
            } else {
                strArr = null;
            }
            String[] strArr2 = strArr;
            C0158j2 c0158j2 = AbstractC0180n2.f269f;
            int i2 = (((byte) i) & 15) << 28;
            int i3 = 0;
            for (int i4 = 0; i4 < c0158j2.f199a.size(); i4++) {
                if (c0158j2.f199a.get(i4)) {
                    i3 |= 1 << i4;
                }
            }
            AbstractC0190p2.m166a(83886081, i2 | i3, 0L, null, strArr2);
        }
    }
}
