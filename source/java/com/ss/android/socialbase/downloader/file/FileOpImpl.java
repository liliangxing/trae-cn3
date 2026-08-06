package com.ss.android.socialbase.downloader.file;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.utils.DownloadDirUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
class FileOpImpl implements IDownloadFileOp {
    private File file;
    private boolean isSecurity;

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public String getExtraMsg() {
        return "";
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public int getFileType() {
        return 1;
    }

    public FileOpImpl(File file) {
        this.isSecurity = true;
        this.file = file;
        this.isSecurity = DownloadDirUtils.isSavePathSecurity(file.getPath());
    }

    public FileOpImpl(String str, String str2, boolean z) {
        this.isSecurity = true;
        if (!TextUtils.isEmpty(str2)) {
            this.file = new File(str, str2);
        } else {
            this.file = new File(str);
        }
        if (z) {
            this.isSecurity = DownloadDirUtils.isSavePathSecurity(str);
        }
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public long length() {
        return this.file.length();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public boolean exists() {
        return this.file.exists();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public boolean isDirectory() {
        return this.file.isDirectory();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public boolean mkdirs() {
        return this.file.mkdirs();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public boolean delete() {
        if (this.isSecurity) {
            return this.file.delete();
        }
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public String getPath() {
        return this.file.getPath();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public File getFile() {
        return this.file;
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public boolean canWrite() {
        return this.file.canWrite();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public boolean setLastModified(long j) {
        return this.file.setLastModified(j);
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public long lastModified() {
        return this.file.lastModified();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public FileInputStream obtainInputStream() throws IOException {
        if (!this.file.isFile()) {
            throw new IOException(this.file.getAbsolutePath() + " Fail to obtain InputStream, file type error");
        }
        return new FileInputStream(this.file);
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public FileOutputStream obtainOutputStream() throws IOException {
        return new FileOutputStream(this.file);
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public File getParentFile() {
        return this.file.getParentFile();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public String getAbsolutePath() {
        return this.file.getAbsolutePath();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public String getCanonicalPath() throws IOException {
        return this.file.getCanonicalPath();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public boolean renameTo(DownloadFile downloadFile) {
        return this.file.renameTo(downloadFile.getFile());
    }
}
