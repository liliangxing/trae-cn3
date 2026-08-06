package com.bytedance.forest.model;

import java.io.InputStream;
import kotlin.Metadata;

/* compiled from: InMemoryByteBuffer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/forest/model/BytesProvider;", "", "isMultiProvider", "", "provideInputStream", "Ljava/io/InputStream;", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes3.dex */
public interface BytesProvider {

    /* compiled from: InMemoryByteBuffer.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
        public static boolean isMultiProvider(BytesProvider bytesProvider) {
            return false;
        }
    }

    boolean isMultiProvider();

    InputStream provideInputStream();
}
