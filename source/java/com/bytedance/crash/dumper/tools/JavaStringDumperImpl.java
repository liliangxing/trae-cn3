package com.bytedance.crash.dumper.tools;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: classes3.dex */
class JavaStringDumperImpl implements IStringDumperImpl {
    private final FileOutputStream mFileOutputStream;

    public static JavaStringDumperImpl create(String str) {
        return new JavaStringDumperImpl(str);
    }

    private JavaStringDumperImpl(String str) {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(new File(str));
        } catch (IOException unused) {
            fileOutputStream = null;
        }
        this.mFileOutputStream = fileOutputStream;
    }

    @Override // com.bytedance.crash.dumper.tools.IStringDumperImpl
    public void dumpCharArray(char[] cArr, int i) {
        dumpString(new StringBuilder().append(cArr).toString());
    }

    @Override // com.bytedance.crash.dumper.tools.IStringDumperImpl
    public void dumpByteArray(byte[] bArr, int i) {
        FileOutputStream fileOutputStream = this.mFileOutputStream;
        if (fileOutputStream != null) {
            try {
                fileOutputStream.write(bArr);
            } catch (IOException unused) {
            }
        }
    }

    @Override // com.bytedance.crash.dumper.tools.IStringDumperImpl
    public void dumpString(String str) {
        FileOutputStream fileOutputStream = this.mFileOutputStream;
        if (fileOutputStream != null) {
            try {
                fileOutputStream.write(str.getBytes());
            } catch (IOException unused) {
            }
        }
    }

    @Override // com.bytedance.crash.dumper.tools.IStringDumperImpl
    public void dumpInt(int i) {
        dumpString(Integer.toString(i));
    }

    @Override // com.bytedance.crash.dumper.tools.IStringDumperImpl
    public void dumpLong(long j) {
        dumpString(Long.toString(j));
    }

    @Override // com.bytedance.crash.dumper.tools.IStringDumperImpl
    public void release() {
        FileOutputStream fileOutputStream = this.mFileOutputStream;
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    @Override // com.bytedance.crash.dumper.tools.IStringDumperImpl
    public void flush() {
        FileOutputStream fileOutputStream = this.mFileOutputStream;
        if (fileOutputStream != null) {
            try {
                fileOutputStream.flush();
            } catch (IOException unused) {
            }
        }
    }
}
