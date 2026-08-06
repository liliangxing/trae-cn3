package com.bytedance.gkfs.storage;

import android.system.Os;
import android.system.OsConstants;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: GkFSChunkStorage.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u0018\u0010\u0004\u001a\f\u0012\u0004\u0012\u00020\u00060\u0005j\u0002`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000*\u0018\b\u0000\u0010\b\"\b\u0012\u0004\u0012\u00020\u00060\u00052\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\t"}, d2 = {"PAGE_SIZE", "", "TAG", "", "UnReadableChunkProvider", "Lkotlin/Function0;", "Ljava/io/InputStream;", "Lcom/bytedance/gkfs/storage/ChunkReaderProvider;", "ChunkReaderProvider", "geckox_noasanRelease"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes3.dex */
public final class GkFSChunkStorageKt {
    private static final String TAG = "GkFSChunkStorage";
    private static final int PAGE_SIZE = (int) Os.sysconf(OsConstants._SC_PAGE_SIZE);
    private static final Function0<InputStream> UnReadableChunkProvider = new Function0<FileInputStream>() { // from class: com.bytedance.gkfs.storage.GkFSChunkStorageKt$UnReadableChunkProvider$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final FileInputStream invoke() {
            return new FileInputStream(new File(""));
        }
    };
}
