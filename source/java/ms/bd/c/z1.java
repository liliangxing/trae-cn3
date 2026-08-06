package ms.bd.c;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes8.dex */
public abstract class z1 {
    protected static String LIBNAME;

    public static synchronized void a(Context context, int i, Map<String, String> map) {
        String[] strArr;
        synchronized (z1.class) {
            n2.f.a.set(0);
            n2.a(context, LIBNAME);
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
            j2 j2Var = n2.f;
            int i2 = (((byte) i) & 15) << 28;
            int i3 = 0;
            for (int i4 = 0; i4 < j2Var.a.size(); i4++) {
                if (j2Var.a.get(i4)) {
                    i3 |= 1 << i4;
                }
            }
            p2.a(83886081, i2 | i3, 0L, null, strArr2);
        }
    }
}
