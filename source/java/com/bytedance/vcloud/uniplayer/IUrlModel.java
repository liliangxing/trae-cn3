package com.bytedance.vcloud.uniplayer;

import java.util.List;
import kotlin.Metadata;

/* compiled from: PlayRequest.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\t\u001a\u00020\nH&J\n\u0010\u000b\u001a\u0004\u0018\u00010\u0005H\u0016J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\rH&J\b\u0010\u000e\u001a\u00020\nH&¨\u0006\u000f"}, d2 = {"Lcom/bytedance/vcloud/uniplayer/IUrlModel;", "", "getDataSize", "", "getDecryptionKey", "", "getDecryptionKeyNotEncoded", "getFileCheckSum", "getFileHash", "getHeight", "", "getUrlKey", "getUrlList", "", "getWidth", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes6.dex */
public interface IUrlModel {

    /* compiled from: PlayRequest.kt */
    @Metadata(k = 3, mv = {1, 7, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class DefaultImpls {
        public static long getDataSize(IUrlModel iUrlModel) {
            return 0L;
        }

        public static String getDecryptionKey(IUrlModel iUrlModel) {
            return null;
        }

        public static String getDecryptionKeyNotEncoded(IUrlModel iUrlModel) {
            return null;
        }

        public static String getFileCheckSum(IUrlModel iUrlModel) {
            return null;
        }

        public static String getFileHash(IUrlModel iUrlModel) {
            return null;
        }

        public static String getUrlKey(IUrlModel iUrlModel) {
            return null;
        }
    }

    long getDataSize();

    String getDecryptionKey();

    String getDecryptionKeyNotEncoded();

    String getFileCheckSum();

    String getFileHash();

    int getHeight();

    String getUrlKey();

    List<String> getUrlList();

    int getWidth();
}
