package com.bytedance.memory.shrink;

import com.bytedance.memory.common.MemoryLog;
import com.bytedance.monitor.util.IoUtil;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: classes4.dex */
public class HprofBufferShrinker {
    public void shrink(File file, File file2) throws IOException {
        shrink(file, file2, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v1, types: [java.io.OutputStream, java.io.Closeable, java.io.BufferedOutputStream] */
    public void shrink(File file, File file2, boolean z) throws IOException {
        HprofClassInfoVisitor hprofClassInfoVisitor;
        FileInputStream fileInputStream;
        long currentTimeMillis = System.currentTimeMillis();
        FileInputStream fileInputStream2 = null;
        if (z) {
            hprofClassInfoVisitor = new HprofClassInfoVisitor();
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    new HprofReader(new BufferedInputStream(fileInputStream)).accept(new HprofVisitor(hprofClassInfoVisitor));
                    IoUtil.safeClose(fileInputStream);
                    MemoryLog.i("shrink::step1 cost=" + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
                } catch (Throwable th) {
                    th = th;
                    fileInputStream2 = fileInputStream;
                    IoUtil.safeClose(fileInputStream2);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } else {
            hprofClassInfoVisitor = null;
            fileInputStream = null;
        }
        try {
            FileInputStream fileInputStream3 = new FileInputStream(file);
            try {
                ?? bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
                try {
                    new HprofReader(new BufferedInputStream(fileInputStream3)).accept(new HprofVisitor(new HprofWriter(bufferedOutputStream, hprofClassInfoVisitor)));
                    IoUtil.safeClose((Closeable) bufferedOutputStream);
                    IoUtil.safeClose(fileInputStream3);
                    MemoryLog.i("shrink::total cost=" + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
                } catch (Throwable th3) {
                    th = th3;
                    fileInputStream2 = bufferedOutputStream;
                    fileInputStream = fileInputStream3;
                    IoUtil.safeClose(fileInputStream2);
                    IoUtil.safeClose(fileInputStream);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (Throwable th5) {
            th = th5;
        }
    }
}
