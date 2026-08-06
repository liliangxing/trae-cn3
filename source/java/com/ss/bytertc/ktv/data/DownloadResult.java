package com.ss.bytertc.ktv.data;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes7.dex */
public class DownloadResult {
    public String filePath;
    public DownloadFileType fileType;
    public String musicId;

    public DownloadResult(String musicId, DownloadFileType fileType, String filePath) {
        this.musicId = musicId;
        this.fileType = fileType;
        this.filePath = filePath;
    }

    public String toString() {
        return "DownloadResult{musicId='" + this.musicId + "', fileType=" + this.fileType + (DownloadFileType.MUSIC == this.fileType ? "" : ", filePath='" + this.filePath + '\'') + AbstractJsonLexerKt.END_OBJ;
    }
}
