package com.ss.android.socialbase.appdownloader.util.parser.manifest;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes7.dex */
public class ExtDataInput extends DataInputDelegate {
    public ExtDataInput(InputStream inputStream) {
        this((DataInput) new DataInputStream(inputStream));
    }

    public ExtDataInput(DataInput dataInput) {
        super(dataInput);
    }

    public int[] readIntArray(int i) throws IOException {
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = readInt();
        }
        return iArr;
    }

    public void skipInt() throws IOException {
        skipBytes(4);
    }

    public void skipShort() throws IOException {
        skipBytes(2);
    }

    public void skipCheckShort(short s) throws IOException {
        short readShort = readShort();
        if (readShort != s) {
            throw new IOException(String.format("Expected: 0x%08x, got: 0x%08x", Short.valueOf(s), Short.valueOf(readShort)));
        }
    }

    public void skipCheckByte(byte b) throws IOException {
        byte readByte = readByte();
        if (readByte != b) {
            throw new IOException(String.format("Expected: 0x%08x, got: 0x%08x", Byte.valueOf(b), Byte.valueOf(readByte)));
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.manifest.DataInputDelegate, java.io.DataInput
    public final int skipBytes(int i) throws IOException {
        int i2 = 0;
        while (i2 < i) {
            int skipBytes = super.skipBytes(i - i2);
            if (skipBytes <= 0) {
                break;
            }
            i2 += skipBytes;
        }
        return i2;
    }

    public String readNullEndedString(int i, boolean z) throws IOException {
        int i2;
        short readShort;
        StringBuilder sb = new StringBuilder(16);
        while (true) {
            i2 = i - 1;
            if (i == 0 || (readShort = readShort()) == 0) {
                break;
            }
            sb.append((char) readShort);
            i = i2;
        }
        if (z) {
            skipBytes(i2 * 2);
        }
        return sb.toString();
    }
}
