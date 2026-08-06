package com.bytedance.geckox.utils;

import android.content.Context;
import com.bytedance.geckox.GeckoGlobalConfig;
import com.bytedance.geckox.GeckoGlobalManager;
import com.bytedance.librarian.Librarian;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LibLoader.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/geckox/utils/LibLoader;", "", "()V", "loadLib", "", "name", "", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class LibLoader {
    public static final LibLoader INSTANCE = new LibLoader();

    private LibLoader() {
    }

    public final void loadLib(String name) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        GeckoGlobalManager inst = GeckoGlobalManager.inst();
        Intrinsics.checkExpressionValueIsNotNull(inst, "GeckoGlobalManager.inst()");
        GeckoGlobalConfig globalConfig = inst.getGlobalConfig();
        Context context = globalConfig != null ? globalConfig.getContext() : null;
        if (context == null) {
            System.loadLibrary(name);
        } else {
            Librarian.loadLibraryForModule(name, context);
        }
    }
}
