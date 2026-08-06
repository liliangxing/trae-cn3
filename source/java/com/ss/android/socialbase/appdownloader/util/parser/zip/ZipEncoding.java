package com.ss.android.socialbase.appdownloader.util.parser.zip;

import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes7.dex */
public interface ZipEncoding {
    boolean canEncode(String str);

    String decode(byte[] bArr) throws IOException;

    ByteBuffer encode(String str) throws IOException;
}
