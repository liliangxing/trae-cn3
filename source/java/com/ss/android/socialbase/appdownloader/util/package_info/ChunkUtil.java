package com.ss.android.socialbase.appdownloader.util.package_info;

import com.bytedance.librarian.LibrarianImpl;
import java.io.IOException;

/* loaded from: classes7.dex */
public class ChunkUtil {
    ChunkUtil() {
    }

    public static final void readCheckType(IntReader intReader, int i) throws IOException {
        int readInt = intReader.readInt();
        if (readInt != i) {
            throw new IOException("Expected chunk of type 0x" + Integer.toHexString(i) + ", read 0x" + Integer.toHexString(readInt) + LibrarianImpl.Constants.DOT);
        }
    }
}
