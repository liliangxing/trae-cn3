package com.ss.android.socialbase.appdownloader.util.parser.zip;

import java.util.zip.ZipException;

/* loaded from: classes7.dex */
public interface ZipExtraField {
    byte[] getCentralDirectoryData();

    ZipShort getCentralDirectoryLength();

    ZipShort getHeaderId();

    byte[] getLocalFileDataData();

    ZipShort getLocalFileDataLength();

    void parseFromLocalFileData(byte[] bArr, int i, int i2) throws ZipException;
}
