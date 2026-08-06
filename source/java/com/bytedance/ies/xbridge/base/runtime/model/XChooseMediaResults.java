package com.bytedance.ies.xbridge.base.runtime.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: XChooseMediaResults.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\nB\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ies/xbridge/base/runtime/model/XChooseMediaResults;", "", "()V", "tempFiles", "", "Lcom/bytedance/ies/xbridge/base/runtime/model/XChooseMediaResults$FileInfo;", "getTempFiles", "()Ljava/util/List;", "setTempFiles", "(Ljava/util/List;)V", "FileInfo", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class XChooseMediaResults {
    private List<FileInfo> tempFiles;

    /* compiled from: XChooseMediaResults.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\r\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ies/xbridge/base/runtime/model/XChooseMediaResults$FileInfo;", "", "tempFilePath", "", "size", "", "mediaType", "binaryData", "", "(Ljava/lang/String;JLjava/lang/String;[B)V", "base64Data", "getBase64Data", "()Ljava/lang/String;", "setBase64Data", "(Ljava/lang/String;)V", "getBinaryData", "()[B", "getMediaType", "getSize", "()J", "getTempFilePath", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class FileInfo {
        private String base64Data;
        private final byte[] binaryData;
        private final String mediaType;
        private final long size;
        private final String tempFilePath;

        public FileInfo(String tempFilePath, long j, String mediaType, byte[] bArr) {
            Intrinsics.checkNotNullParameter(tempFilePath, "tempFilePath");
            Intrinsics.checkNotNullParameter(mediaType, "mediaType");
            this.tempFilePath = tempFilePath;
            this.size = j;
            this.mediaType = mediaType;
            this.binaryData = bArr;
        }

        public /* synthetic */ FileInfo(String str, long j, String str2, byte[] bArr, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, j, str2, (i & 8) != 0 ? null : bArr);
        }

        public final byte[] getBinaryData() {
            return this.binaryData;
        }

        public final String getMediaType() {
            return this.mediaType;
        }

        public final long getSize() {
            return this.size;
        }

        public final String getTempFilePath() {
            return this.tempFilePath;
        }

        public final String getBase64Data() {
            return this.base64Data;
        }

        public final void setBase64Data(String str) {
            this.base64Data = str;
        }
    }

    public final List<FileInfo> getTempFiles() {
        return this.tempFiles;
    }

    public final void setTempFiles(List<FileInfo> list) {
        this.tempFiles = list;
    }
}
