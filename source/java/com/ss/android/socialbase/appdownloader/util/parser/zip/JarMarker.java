package com.ss.android.socialbase.appdownloader.util.parser.zip;

import java.util.zip.ZipException;

/* loaded from: classes7.dex */
public final class JarMarker implements ZipExtraField {
    private static final ZipShort ID = new ZipShort(51966);
    private static final ZipShort NULL = new ZipShort(0);
    private static final byte[] NO_BYTES = new byte[0];
    private static final JarMarker DEFAULT = new JarMarker();

    public static JarMarker getInstance() {
        return DEFAULT;
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.zip.ZipExtraField
    public ZipShort getHeaderId() {
        return ID;
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.zip.ZipExtraField
    public ZipShort getLocalFileDataLength() {
        return NULL;
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.zip.ZipExtraField
    public ZipShort getCentralDirectoryLength() {
        return NULL;
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.zip.ZipExtraField
    public byte[] getLocalFileDataData() {
        return NO_BYTES;
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.zip.ZipExtraField
    public byte[] getCentralDirectoryData() {
        return NO_BYTES;
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.zip.ZipExtraField
    public void parseFromLocalFileData(byte[] bArr, int i, int i2) throws ZipException {
        if (i2 != 0) {
            throw new ZipException("JarMarker doesn't expect any data");
        }
    }
}
