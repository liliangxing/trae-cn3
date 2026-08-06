package com.bytedance.iesgurd.core;

import android.content.Context;
import com.bytedance.geckox.GeckoGlobalManager;
import com.bytedance.geckox.utils.FileUtils;
import com.bytedance.geckox.utils.GeckoExecutors;
import com.bytedance.iesgurd.meta.ChannelMetaManager;
import com.bytedance.ug.sdk.deeplink.EventConstants;
import java.io.File;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CacheManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0004R\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/bytedance/iesgurd/core/CacheManager;", "", "()V", "<set-?>", "Ljava/io/File;", "filePendingDelete", "getFilePendingDelete", "()Ljava/io/File;", "fileRoot", "getFileRoot", "inited", "", "deleteAll", "", "deletePendingFiles", EventConstants.PARAM_SOURCE_INIT, "context", "Landroid/content/Context;", "renameFileToPending", "file", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class CacheManager {
    public static final CacheManager INSTANCE = new CacheManager();
    private static File filePendingDelete;
    private static File fileRoot;
    private static boolean inited;

    private CacheManager() {
    }

    public static final /* synthetic */ File access$getFilePendingDelete$p(CacheManager cacheManager) {
        File file = filePendingDelete;
        if (file == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filePendingDelete");
        }
        return file;
    }

    public final File getFileRoot() {
        File file = fileRoot;
        if (file == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fileRoot");
        }
        return file;
    }

    public final File getFilePendingDelete() {
        File file = filePendingDelete;
        if (file == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filePendingDelete");
        }
        return file;
    }

    public final void init(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        fileRoot = new File(context.getFilesDir(), "gecko_offline_res_x");
        File file = fileRoot;
        if (file == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fileRoot");
        }
        filePendingDelete = new File(file, "pending_delete");
        inited = true;
    }

    public final void deletePendingFiles() {
        if (inited) {
            File file = filePendingDelete;
            if (file == null) {
                Intrinsics.throwUninitializedPropertyAccessException("filePendingDelete");
            }
            if (file.exists()) {
                GeckoExecutors.INSTANCE.getIoExecutor().execute(new Runnable() { // from class: com.bytedance.iesgurd.core.CacheManager$deletePendingFiles$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        File[] listFiles = CacheManager.INSTANCE.getFilePendingDelete().listFiles();
                        if (listFiles != null) {
                            for (File file2 : listFiles) {
                                FileUtils.delete(file2);
                            }
                        }
                    }
                });
            }
        }
    }

    public final boolean renameFileToPending(File file) {
        Intrinsics.checkParameterIsNotNull(file, "file");
        if (!inited) {
            return false;
        }
        File file2 = filePendingDelete;
        if (file2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filePendingDelete");
        }
        if (!file2.exists()) {
            File file3 = filePendingDelete;
            if (file3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("filePendingDelete");
            }
            if (!file3.mkdirs()) {
                return false;
            }
        }
        String str = file.getName() + '_' + System.currentTimeMillis();
        File file4 = filePendingDelete;
        if (file4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filePendingDelete");
        }
        return file.renameTo(new File(file4, str));
    }

    public final void deleteAll() {
        ChannelMetaManager.INSTANCE.removeAll();
        GeckoGlobalManager inst = GeckoGlobalManager.inst();
        Intrinsics.checkExpressionValueIsNotNull(inst, "GeckoGlobalManager.inst()");
        Iterator it = inst.getAccessKeyDirs().values().iterator();
        while (it.hasNext()) {
            INSTANCE.renameFileToPending(new File((String) it.next()));
        }
        deletePendingFiles();
    }
}
