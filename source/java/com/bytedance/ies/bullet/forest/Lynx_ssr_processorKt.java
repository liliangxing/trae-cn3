package com.bytedance.ies.bullet.forest;

import java.io.InputStream;
import kotlin.Metadata;

/* compiled from: lynx_ssr_processor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002¨\u0006\u0003"}, d2 = {"readInt", "", "Ljava/io/InputStream;", "anniex_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class Lynx_ssr_processorKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final int readInt(InputStream inputStream) {
        return ((inputStream.read() & 255) << 24) + ((inputStream.read() & 255) << 16) + ((inputStream.read() & 255) << 8) + (inputStream.read() & 255);
    }
}
