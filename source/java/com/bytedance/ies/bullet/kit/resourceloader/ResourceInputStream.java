package com.bytedance.ies.bullet.kit.resourceloader;

import com.bytedance.ies.bullet.kit.resourceloader.loggger.RLLogger;
import com.bytedance.ies.bullet.kit.resourceloader.memory.MemoryManager;
import com.bytedance.ies.bullet.service.base.ResourceInfo;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ResourceInputStream.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0002\u0010\u0005J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\rH\u0016J\b\u0010\u0012\u001a\u00020\u0007H\u0016J\u0014\u0010\u0013\u001a\u00020\u000f2\n\u0010\u0014\u001a\u00060\u0015j\u0002`\u0016H\u0002J\b\u0010\u0017\u001a\u00020\rH\u0016J\u0012\u0010\u0017\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\"\u0010\u0017\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\rH\u0016J\b\u0010\u001c\u001a\u00020\u000fH\u0016J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/bytedance/ies/bullet/kit/resourceloader/ResourceInputStream;", "Ljava/io/InputStream;", "info", "Lcom/bytedance/ies/bullet/service/base/ResourceInfo;", "origin", "(Lcom/bytedance/ies/bullet/service/base/ResourceInfo;Ljava/io/InputStream;)V", "dataValid", "", "originData", "", "", "success", "available", "", "close", "", "mark", "readlimit", "markSupported", "onException", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "read", "b", "", "off", "len", "reset", "skip", "", "n", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ResourceInputStream extends InputStream {
    private boolean dataValid;
    private final ResourceInfo info;
    private final InputStream origin;
    private List<Byte> originData;
    private boolean success;

    public ResourceInputStream(ResourceInfo resourceInfo, InputStream inputStream) {
        Intrinsics.checkNotNullParameter(resourceInfo, "info");
        Intrinsics.checkNotNullParameter(inputStream, "origin");
        this.info = resourceInfo;
        this.origin = inputStream;
        this.success = true;
        this.originData = new ArrayList();
        this.dataValid = true;
    }

    @Override // java.io.InputStream
    public int read() {
        try {
            int read = this.origin.read();
            if (!this.info.getEnableMemory()) {
                this.dataValid = false;
                return read;
            }
            if (read != -1 && MemoryManager.INSTANCE.getInstance().getByteArrayCache(this.info) == null) {
                try {
                    this.originData.add(Byte.valueOf((byte) read));
                } catch (OutOfMemoryError unused) {
                    this.originData.clear();
                    this.dataValid = false;
                }
            }
            return read;
        } catch (Exception e) {
            onException(e);
            throw e;
        }
    }

    private final void onException(Exception e) {
        this.success = false;
        RLLogger.INSTANCE.m23e("ResourceInputStream: onException", e);
    }

    @Override // java.io.InputStream
    public int read(byte[] b) {
        try {
            int read = this.origin.read(b);
            if (!this.info.getEnableMemory()) {
                this.dataValid = false;
                return read;
            }
            if (b != null) {
                if ((!(b.length == 0)) && read > 0 && MemoryManager.INSTANCE.getInstance().getByteArrayCache(this.info) == null) {
                    try {
                        if (read == b.length) {
                            this.originData.addAll(ArraysKt.toList(b));
                        } else {
                            this.originData.addAll(ArraysKt.toList(b).subList(0, read));
                        }
                    } catch (OutOfMemoryError unused) {
                        this.originData.clear();
                        this.dataValid = false;
                    }
                }
            }
            return read;
        } catch (Exception e) {
            onException(e);
            throw e;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] b, int off, int len) {
        try {
            int read = this.origin.read(b, off, len);
            if (!this.info.getEnableMemory()) {
                this.dataValid = false;
                return read;
            }
            if (b != null) {
                if ((!(b.length == 0)) && read > 0 && MemoryManager.INSTANCE.getInstance().getByteArrayCache(this.info) == null) {
                    try {
                        if (read == b.length) {
                            this.originData.addAll(ArraysKt.toList(b));
                        } else {
                            this.originData.addAll(ArraysKt.toList(b).subList(0, read));
                        }
                    } catch (OutOfMemoryError unused) {
                        this.originData.clear();
                        this.dataValid = false;
                    }
                }
            }
            return read;
        } catch (Exception e) {
            onException(e);
            throw e;
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            this.origin.close();
            if (this.success) {
                if ((Intrinsics.areEqual(this.info.getResTag(), "template") || Intrinsics.areEqual(this.info.getResTag(), "external_js")) && this.dataValid) {
                    MemoryManager.INSTANCE.getInstance().updateByteArrayCache(this.info, this.originData);
                }
            }
        } catch (Exception e) {
            onException(e);
            throw e;
        }
    }

    @Override // java.io.InputStream
    public long skip(long n) {
        try {
            return this.origin.skip(n);
        } catch (Exception e) {
            onException(e);
            throw e;
        }
    }

    @Override // java.io.InputStream
    public int available() {
        try {
            return this.origin.available();
        } catch (Exception e) {
            onException(e);
            throw e;
        }
    }

    @Override // java.io.InputStream
    public void mark(int readlimit) {
        try {
            this.origin.mark(readlimit);
        } catch (Exception e) {
            onException(e);
            throw e;
        }
    }

    @Override // java.io.InputStream
    public void reset() {
        try {
            this.origin.reset();
        } catch (Exception e) {
            onException(e);
            throw e;
        }
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        try {
            return this.origin.markSupported();
        } catch (Exception e) {
            onException(e);
            throw e;
        }
    }
}
