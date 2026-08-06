package ms.bd.c;

import java.io.Closeable;
import java.io.IOException;

/* loaded from: classes8.dex */
public abstract class u0 {
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }
}
