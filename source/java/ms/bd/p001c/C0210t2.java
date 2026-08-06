package ms.bd.p001c;

import android.text.TextUtils;
import com.bytedance.mobsec.metasec.ml.MSManagerUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* renamed from: ms.bd.c.t2 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class C0210t2 {

    /* renamed from: b */
    public static final C0210t2 f400b = new C0210t2();

    /* renamed from: a */
    public final ArrayList f401a = new ArrayList();

    /* renamed from: a */
    public final String m193a(int i, String str, String str2) {
        synchronized (this.f401a) {
            if (this.f401a.size() >= 1 && !TextUtils.isEmpty(str)) {
                Iterator it = this.f401a.iterator();
                while (it.hasNext()) {
                    Map map = (Map) it.next();
                    if (map != null && !map.isEmpty() && map.containsKey(str)) {
                        ((MSManagerUtils.IMsBundleCallback) map.get(str)).callBack(i, str, str2);
                        it.remove();
                    }
                }
                return (String) AbstractC0190p2.m166a(16777217, 0, 0L, "4e8a69", new byte[]{117});
            }
            return (String) AbstractC0190p2.m166a(16777217, 0, 0L, "3124f0", new byte[]{114});
        }
    }
}
