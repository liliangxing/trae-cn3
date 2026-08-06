package com.ttnet.org.chromium.base.library_loader;

import com.ttnet.org.chromium.base.library_loader.Linker;
import com.ttnet.org.chromium.base.library_loader.ModernLinker;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
class ModernLinkerJni implements ModernLinker.Natives {
    private static final String TAG = "ModernLinkerJni";

    private static native int nativeGetRelroSharingResult();

    private static native boolean nativeLoadLibrary(String str, Linker.LibInfo libInfo, boolean z);

    private static native boolean nativeUseRelros(long j, Linker.LibInfo libInfo);

    @Override // com.ttnet.org.chromium.base.library_loader.ModernLinker.Natives
    public boolean loadLibrary(String str, Linker.LibInfo libInfo, boolean z) {
        return nativeLoadLibrary(str, libInfo, z);
    }

    @Override // com.ttnet.org.chromium.base.library_loader.ModernLinker.Natives
    public boolean useRelros(long j, Linker.LibInfo libInfo) {
        return nativeUseRelros(j, libInfo);
    }

    @Override // com.ttnet.org.chromium.base.library_loader.ModernLinker.Natives
    public int getRelroSharingResult() {
        return nativeGetRelroSharingResult();
    }

    public static void reportDlopenExtTime(long j) {
        ModernLinker.reportDlopenExtTime(j);
    }

    public static void reportIteratePhdrTime(long j) {
        ModernLinker.reportIteratePhdrTime(j);
    }
}
