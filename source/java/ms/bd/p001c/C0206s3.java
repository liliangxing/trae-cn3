package ms.bd.p001c;

import java.util.function.Consumer;
import org.json.JSONException;

/* renamed from: ms.bd.c.s3 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class C0206s3 implements Consumer {
    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        try {
            C0221v3.f439e.put(String.valueOf((Integer) obj), System.currentTimeMillis());
        } catch (JSONException unused) {
        }
    }
}
