package com.bytedance.watson.assist.file;

import com.bytedance.watson.assist.utils.DebugLog;
import java.io.File;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes6.dex */
public abstract class BaseStatFile {
    private String mPath;
    protected FileStatInfo mLastInfo = null;
    private File mFile = null;

    protected FileStatInfo doRead(File file) {
        return null;
    }

    public BaseStatFile(String str) {
        this.mPath = str;
    }

    public FileStatInfo refresh() {
        if (this.mPath == null) {
            DebugLog.w("refresh and path null");
            return null;
        }
        if (this.mFile == null) {
            this.mFile = new File(this.mPath);
        }
        FileStatInfo doRead = doRead(this.mFile);
        this.mLastInfo = doRead;
        return doRead;
    }

    public FileStatInfo getInfo() {
        return this.mLastInfo;
    }

    public String toString() {
        return "BaseStatFile{mPath='" + this.mPath + "', mFile=" + this.mFile + ", mLastInfo=" + this.mLastInfo + AbstractJsonLexerKt.END_OBJ;
    }
}
