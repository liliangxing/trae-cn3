package com.bytedance.geckox.buffer;

import com.bytedance.android.live.core.setting.v2.tools.SettingV2Monitor;
import com.bytedance.forest.model.Timing;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;

/* compiled from: Buffer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H&J\b\u0010\b\u001a\u00020\tH&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tH&J\b\u0010\u000e\u001a\u00020\u0003H&J\b\u0010\u000f\u001a\u00020\u0003H\u0016J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H&J\b\u0010\u0011\u001a\u00020\u0012H&J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J \u0010\u0013\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tH&J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\tH&¨\u0006\u0015"}, d2 = {"Lcom/bytedance/geckox/buffer/Buffer;", "", Timing.SUFFIX_FINISH, "", "length", "", "persistence", "position", SettingV2Monitor.REPORT_TYPE_READ, "", "bytes", "", "off", "len", "release", "releaseAndDeleteSwap", "skip", "swap", "Ljava/io/File;", "write", "b", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes3.dex */
public interface Buffer {
    void finish();

    long length();

    void persistence() throws IOException;

    long position() throws IOException;

    void position(long position) throws IOException;

    int read() throws IOException;

    int read(byte[] bytes) throws IOException;

    int read(byte[] bytes, int off, int len) throws IOException;

    void release();

    void releaseAndDeleteSwap();

    long skip(long skip) throws IOException;

    File swap();

    int write(byte[] bytes, int off, int len) throws IOException;

    void write(int b) throws IOException;

    void write(byte[] bytes) throws IOException;

    /* compiled from: Buffer.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
        public static void finish(Buffer buffer) {
        }

        public static void releaseAndDeleteSwap(Buffer buffer) {
            buffer.release();
            buffer.swap().delete();
        }
    }
}
