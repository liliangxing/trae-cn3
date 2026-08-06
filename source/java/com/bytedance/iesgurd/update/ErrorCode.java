package com.bytedance.iesgurd.update;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;

/* compiled from: ErrorCode.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/iesgurd/update/ErrorCode;", "", "code", "", "(Ljava/lang/String;II)V", "getCode", "()I", "UNEXPECTED", "DOWNLOAD", "DOWNLOAD_CHECK", "DOWNLOAD_OTHER", "UNZIP", "MERGE_PATCH", "MERGE_PATCH_CHECK", "MERGE_PATCH_LOCK", "MERGE_PATCH_NO_LOCAL", "BYTE_PATCH_LOCK", "DECOMPRESS_ZSTD", "DECOMPRESS_ZSTD_CHECK", "RENAME_SINGLE", "RENAME", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes4.dex */
public enum ErrorCode {
    UNEXPECTED(-999),
    DOWNLOAD(100),
    DOWNLOAD_CHECK(101),
    DOWNLOAD_OTHER(102),
    UNZIP(200),
    MERGE_PATCH(300),
    MERGE_PATCH_CHECK(301),
    MERGE_PATCH_LOCK(302),
    MERGE_PATCH_NO_LOCAL(303),
    BYTE_PATCH_LOCK(MediaPlayer.MEDIA_PLAYER_OPTION_BUFFERING_END_IGNORE_VIDEO),
    DECOMPRESS_ZSTD(400),
    DECOMPRESS_ZSTD_CHECK(401),
    RENAME_SINGLE(410),
    RENAME(500);

    private final int code;

    ErrorCode(int i) {
        this.code = i;
    }

    public final int getCode() {
        return this.code;
    }
}
