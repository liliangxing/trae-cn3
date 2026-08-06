package com.bytedance.crash.dumper.tools;

import androidx.collection.SieveCacheKt;
import bytedance.jvm.time.Year;
import com.ss.mediakit.medialoader.AVMDLDataLoader;
import ms.bd.c.c2;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class CachedStringDumper extends BaseStringDumper {
    private static final int DEFAULT_CACHE_SIZE = 1024;
    private static final int MIN_CACHE_SIZE = 128;
    private final char[] mCacheArray;
    private int mPosition;
    private static final char[] MIN_INT = {'-', '2', '1', '4', '7', '4', '8', '3', '6', '4', '8'};
    private static final char[] MIN_LONG = {'-', '9', '2', '2', '3', '3', '7', '2', '0', '3', '6', '8', '5', '4', '7', '7', '5', '8', '0', '8'};
    private static final int[] sTable = {9, 99, 999, AVMDLDataLoader.KeyIsEnableEventInfo, c2.COLLECT_MODE_DEFAULT, 999999, 9999999, 99999999, Year.MAX_VALUE, Integer.MAX_VALUE};
    private static final AppendableCharArray sAppendableCharArray = new AppendableCharArray();
    private static final AppendableByteArray sAppendableByteArray = new AppendableByteArray();
    private static final AppendableStringArray sAppendableStringArray = new AppendableStringArray();

    private static int stringSize(long j) {
        long j2 = 10;
        for (int i = 1; i < 19; i++) {
            if (j < j2) {
                return i;
            }
            j2 *= 10;
        }
        return 19;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CachedStringDumper(String str) {
        char[] cArr;
        int i = 1024;
        try {
            cArr = new char[1024];
        } catch (Throwable unused) {
            i = 128;
            cArr = new char[128];
        }
        this.mCacheArray = cArr;
        this.mPosition = 0;
        this.mDumpImpl = createImpl(str, i);
    }

    char[] getCharArray() {
        return this.mCacheArray;
    }

    int getPosition() {
        return this.mPosition;
    }

    void setPosition(int i) {
        this.mPosition = i;
    }

    void dumpCacheArray() {
        IStringDumperImpl iStringDumperImpl = this.mDumpImpl;
        char[] cArr = this.mCacheArray;
        iStringDumperImpl.dumpCharArray(cArr, cArr.length);
    }

    private static int stringSize(int i) {
        for (int i2 = 0; i2 < 10; i2++) {
            if (i <= sTable[i2]) {
                return i2 + 1;
            }
        }
        return 11;
    }

    private static void appendInt(int i, char[] cArr, int i2) {
        while (i >= 65536) {
            int i3 = i / 100;
            int i4 = i - (((i3 << 6) + (i3 << 5)) + (i3 << 2));
            int i5 = i4 / 10;
            int i6 = i2 - 1;
            cArr[i6] = (char) ((i4 - (i5 * 10)) + 48);
            i2 = i6 - 1;
            cArr[i2] = (char) (i5 + 48);
            i = i3;
        }
        while (i != 0) {
            int i7 = (52429 * i) >>> 19;
            i2--;
            cArr[i2] = (char) ((i - ((i7 << 3) + (i7 << 1))) + 48);
            i = i7;
        }
    }

    private static void appendLong(long j, char[] cArr, int i) {
        while (j > SieveCacheKt.NodeLinkMask) {
            long j2 = j / 100;
            int i2 = (int) (j - (((j2 << 6) + (j2 << 5)) + (j2 << 2)));
            int i3 = i2 / 10;
            int i4 = i - 1;
            cArr[i4] = (char) ((i2 - (i3 * 10)) + 48);
            i = i4 - 1;
            cArr[i] = (char) (i3 + 48);
            j = j2;
        }
        appendInt((int) j, cArr, i);
    }

    private void appendChar(char c) {
        char[] cArr = this.mCacheArray;
        int i = this.mPosition;
        cArr[i] = c;
        int i2 = i + 1;
        this.mPosition = i2;
        if (i2 == cArr.length) {
            IStringDumperImpl iStringDumperImpl = this.mDumpImpl;
            char[] cArr2 = this.mCacheArray;
            iStringDumperImpl.dumpCharArray(cArr2, cArr2.length);
            this.mPosition = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.crash.dumper.tools.BaseStringDumper
    public void append(int i) {
        if (i == Integer.MIN_VALUE) {
            append(MIN_INT);
            return;
        }
        if (i < 0) {
            i = -i;
            appendChar('-');
        }
        if (i < 100) {
            if (i < 10) {
                appendChar((char) (i + 48));
                return;
            }
            int i2 = i / 10;
            appendChar((char) (i2 + 48));
            appendChar((char) ((i - (i2 * 10)) + 48));
            return;
        }
        int stringSize = stringSize(i);
        if (this.mPosition + stringSize >= this.mCacheArray.length) {
            this.mDumpImpl.dumpCharArray(this.mCacheArray, this.mPosition);
            this.mPosition = 0;
        }
        int i3 = this.mPosition + stringSize;
        this.mPosition = i3;
        appendInt(i, this.mCacheArray, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.crash.dumper.tools.BaseStringDumper
    public void append(long j) {
        if (j == Long.MIN_VALUE) {
            append(MIN_LONG);
            return;
        }
        if (j < 0) {
            j = -j;
            appendChar('-');
        }
        if (j < 100) {
            if (j < 10) {
                appendChar((char) (j + 48));
                return;
            }
            long j2 = j / 10;
            appendChar((char) (j2 + 48));
            appendChar((char) ((j - (10 * j2)) + 48));
            return;
        }
        int stringSize = stringSize(j);
        if (this.mPosition + stringSize >= this.mCacheArray.length) {
            this.mDumpImpl.dumpCharArray(this.mCacheArray, this.mPosition);
            this.mPosition = 0;
        }
        int i = this.mPosition + stringSize;
        this.mPosition = i;
        appendLong(j, this.mCacheArray, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.crash.dumper.tools.BaseStringDumper
    public void append(char c) {
        appendChar(c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.crash.dumper.tools.BaseStringDumper
    public void flush() {
        if (this.mPosition > 0) {
            this.mDumpImpl.dumpCharArray(this.mCacheArray, this.mPosition);
            this.mPosition = 0;
        }
        this.mDumpImpl.flush();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.crash.dumper.tools.BaseStringDumper
    public void release() {
        flush();
        this.mDumpImpl.release();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static abstract class AppendableArray<A> {
        abstract void arrayCopy(A a, int i, char[] cArr, int i2, int i3);

        abstract int length(A a);

        AppendableArray() {
        }

        void append(CachedStringDumper cachedStringDumper, A a) {
            int i;
            int length = length(a);
            char[] charArray = cachedStringDumper.getCharArray();
            int i2 = length;
            int position = cachedStringDumper.getPosition();
            int i3 = 0;
            while (true) {
                i = i2 + position;
                if (i < charArray.length) {
                    break;
                }
                int length2 = charArray.length - position;
                arrayCopy(a, i3, charArray, position, length2);
                cachedStringDumper.dumpCacheArray();
                if (position != 0) {
                    cachedStringDumper.setPosition(0);
                    position = 0;
                }
                i3 += length2;
                i2 -= length2;
            }
            if (i2 > 0) {
                arrayCopy(a, i3, charArray, position, i2);
                cachedStringDumper.setPosition(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class AppendableCharArray extends AppendableArray<char[]> {
        AppendableCharArray() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.bytedance.crash.dumper.tools.CachedStringDumper.AppendableArray
        public void arrayCopy(char[] cArr, int i, char[] cArr2, int i2, int i3) {
            System.arraycopy(cArr, i, cArr2, i2, i3);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.bytedance.crash.dumper.tools.CachedStringDumper.AppendableArray
        public int length(char[] cArr) {
            return cArr.length;
        }
    }

    /* loaded from: classes3.dex */
    static class AppendableByteArray extends AppendableArray<byte[]> {
        AppendableByteArray() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.bytedance.crash.dumper.tools.CachedStringDumper.AppendableArray
        public void arrayCopy(byte[] bArr, int i, char[] cArr, int i2, int i3) {
            for (int i4 = 0; i4 < i3; i4++) {
                cArr[i2 + i4] = (char) bArr[i + i4];
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.bytedance.crash.dumper.tools.CachedStringDumper.AppendableArray
        public int length(byte[] bArr) {
            return bArr.length;
        }
    }

    /* loaded from: classes3.dex */
    static class AppendableStringArray extends AppendableArray<String> {
        AppendableStringArray() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.bytedance.crash.dumper.tools.CachedStringDumper.AppendableArray
        public void arrayCopy(String str, int i, char[] cArr, int i2, int i3) {
            str.getChars(i, i3 + i, cArr, i2);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.bytedance.crash.dumper.tools.CachedStringDumper.AppendableArray
        public int length(String str) {
            return str.length();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.crash.dumper.tools.BaseStringDumper
    public void append(char[] cArr) {
        sAppendableCharArray.append(this, cArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.crash.dumper.tools.BaseStringDumper
    public void append(byte[] bArr) {
        sAppendableByteArray.append(this, bArr);
    }

    @Override // com.bytedance.crash.dumper.tools.BaseStringDumper
    public void append(String str) {
        sAppendableStringArray.append(this, str);
    }
}
