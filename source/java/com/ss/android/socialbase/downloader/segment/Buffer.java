package com.ss.android.socialbase.downloader.segment;

/* loaded from: classes7.dex */
public final class Buffer {
    public final byte[] data;
    public Buffer next;
    IOutput output;
    public int size;

    public Buffer(int i) {
        this.data = new byte[i];
    }
}
