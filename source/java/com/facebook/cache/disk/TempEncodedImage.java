package com.facebook.cache.disk;

import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.EncodedImage;
import java.io.FileInputStream;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class TempEncodedImage extends EncodedImage {
    private int offset;

    public TempEncodedImage(Supplier<FileInputStream> supplier) {
        super(supplier);
    }

    public TempEncodedImage(Supplier<FileInputStream> supplier, int i) {
        super(supplier, i);
    }

    public TempEncodedImage(CloseableReference<PooledByteBuffer> closeableReference) {
        super(closeableReference);
    }

    public void setOffset(int i) {
        this.offset = i;
    }

    public int getOffset() {
        return this.offset;
    }
}
