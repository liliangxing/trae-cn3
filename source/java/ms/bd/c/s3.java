package ms.bd.c;

import java.util.function.Consumer;
import org.json.JSONException;

/* loaded from: classes8.dex */
public final class s3 implements Consumer {
    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        try {
            v3.e.put(String.valueOf((Integer) obj), System.currentTimeMillis());
        } catch (JSONException unused) {
        }
    }
}
