package com.bytedance.geckox.utils;

import com.bytedance.geckox.logger.GeckoLogger;
import java.io.Closeable;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* compiled from: CloseableUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/bytedance/geckox/utils/CloseableUtils;", "", "()V", "close", "", "closeable", "Ljava/io/Closeable;", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes3.dex */
public final class CloseableUtils {
    public static final CloseableUtils INSTANCE = new CloseableUtils();

    private CloseableUtils() {
    }

    @JvmStatic
    public static final boolean close(Closeable closeable) {
        if (closeable == null) {
            return true;
        }
        try {
            closeable.close();
            return true;
        } catch (IOException e) {
            GeckoLogger.e("close:", e);
            return false;
        }
    }
}
