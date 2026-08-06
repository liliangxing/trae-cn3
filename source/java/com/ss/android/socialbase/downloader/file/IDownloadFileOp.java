package com.ss.android.socialbase.downloader.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public interface IDownloadFileOp {
    boolean canWrite();

    boolean delete();

    boolean exists();

    String getAbsolutePath();

    String getCanonicalPath() throws IOException;

    String getExtraMsg();

    File getFile();

    int getFileType();

    File getParentFile();

    String getPath();

    boolean isDirectory();

    long lastModified();

    long length();

    boolean mkdirs();

    FileInputStream obtainInputStream() throws IOException;

    FileOutputStream obtainOutputStream() throws IOException;

    boolean renameTo(DownloadFile downloadFile);

    boolean setLastModified(long j);
}
