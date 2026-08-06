package com.ss.android.socialbase.appdownloader.util.parser.manifest;

/* loaded from: classes7.dex */
public final class NamespaceStack {
    private int[] m_data = new int[32];
    private int m_dataLength;
    private int m_depth;

    public void reset() {
        this.m_dataLength = 0;
        this.m_depth = 0;
    }

    public int getCurrentCount() {
        int i = this.m_dataLength;
        if (i == 0) {
            return 0;
        }
        return this.m_data[i - 1];
    }

    public int getAccumulatedCount(int i) {
        int i2 = 0;
        if (this.m_dataLength != 0 && i >= 0) {
            int i3 = this.m_depth;
            if (i > i3) {
                i = i3;
            }
            int i4 = 0;
            while (i != 0) {
                int i5 = this.m_data[i4];
                i2 += i5;
                i4 += (i5 * 2) + 2;
                i--;
            }
        }
        return i2;
    }

    public void push(int i, int i2) {
        if (this.m_depth == 0) {
            increaseDepth();
        }
        ensureDataCapacity(2);
        int i3 = this.m_dataLength;
        int i4 = i3 - 1;
        int[] iArr = this.m_data;
        int i5 = iArr[i4];
        int i6 = (i4 - 1) - (i5 * 2);
        int i7 = i5 + 1;
        iArr[i6] = i7;
        iArr[i4] = i;
        iArr[i4 + 1] = i2;
        iArr[i4 + 2] = i7;
        this.m_dataLength = i3 + 2;
    }

    public boolean pop() {
        int i;
        int[] iArr;
        int i2;
        int i3 = this.m_dataLength;
        if (i3 == 0 || (i2 = (iArr = this.m_data)[i3 - 1]) == 0) {
            return false;
        }
        int i4 = i2 - 1;
        int i5 = i - 2;
        iArr[i5] = i4;
        iArr[i5 - ((i4 * 2) + 1)] = i4;
        this.m_dataLength = i3 - 2;
        return true;
    }

    public int getPrefix(int i) {
        return get(i, true);
    }

    public int getUri(int i) {
        return get(i, false);
    }

    public int findPrefix(int i) {
        return find(i, false);
    }

    public int getDepth() {
        return this.m_depth;
    }

    public void increaseDepth() {
        ensureDataCapacity(2);
        int i = this.m_dataLength;
        int[] iArr = this.m_data;
        iArr[i] = 0;
        iArr[i + 1] = 0;
        this.m_dataLength = i + 2;
        this.m_depth++;
    }

    public void decreaseDepth() {
        int i = this.m_dataLength;
        if (i == 0) {
            return;
        }
        int i2 = i - 1;
        int i3 = this.m_data[i2] * 2;
        if ((i2 - 1) - i3 == 0) {
            return;
        }
        this.m_dataLength = i - (i3 + 2);
        this.m_depth--;
    }

    private void ensureDataCapacity(int i) {
        int[] iArr = this.m_data;
        int length = iArr.length;
        int i2 = this.m_dataLength;
        int i3 = length - i2;
        if (i3 > i) {
            return;
        }
        int[] iArr2 = new int[(iArr.length + i3) * 2];
        System.arraycopy(iArr, 0, iArr2, 0, i2);
        this.m_data = iArr2;
    }

    private int find(int i, boolean z) {
        int i2 = this.m_dataLength;
        if (i2 == 0) {
            return -1;
        }
        int i3 = i2 - 1;
        for (int i4 = this.m_depth; i4 != 0; i4--) {
            i3 -= 2;
            for (int i5 = this.m_data[i3]; i5 != 0; i5--) {
                if (z) {
                    int[] iArr = this.m_data;
                    if (iArr[i3] == i) {
                        return iArr[i3 + 1];
                    }
                } else {
                    int[] iArr2 = this.m_data;
                    if (iArr2[i3 + 1] == i) {
                        return iArr2[i3];
                    }
                }
                i3 -= 2;
            }
        }
        return -1;
    }

    private int get(int i, boolean z) {
        if (this.m_dataLength != 0 && i >= 0) {
            int i2 = 0;
            for (int i3 = this.m_depth; i3 != 0; i3--) {
                int[] iArr = this.m_data;
                int i4 = iArr[i2];
                if (i < i4) {
                    int i5 = i2 + (i * 2) + 1;
                    if (!z) {
                        i5++;
                    }
                    return iArr[i5];
                }
                i -= i4;
                i2 += (i4 * 2) + 2;
            }
        }
        return -1;
    }
}
