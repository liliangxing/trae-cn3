package com.bytedance.gkfs.storage.io;

import kotlin.Metadata;

/* compiled from: GkFSBlockBuffer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"BLOCK_EXT", "", "BLOCK_REWRITE_BACKUP_SUFFIX", "BLOCK_REWRITE_TMP_SUFFIX", "CHUNK_FOLDER", "MAX_BLOCK_BUFFER_SIZE", "", "MAX_BLOCK_SIZE", "", "geckox_noasanRelease"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes3.dex */
public final class GkFSBlockBufferKt {
    public static final String BLOCK_EXT = "gkfsb";
    private static final String BLOCK_REWRITE_BACKUP_SUFFIX = "-backup";
    private static final String BLOCK_REWRITE_TMP_SUFFIX = "-rewriting";
    private static final String CHUNK_FOLDER = "gkfs_chunk";
    private static final int MAX_BLOCK_BUFFER_SIZE = 83886080;
    private static final long MAX_BLOCK_SIZE = 8388608;
}
