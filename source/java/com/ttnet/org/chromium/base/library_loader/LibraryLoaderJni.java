package com.ttnet.org.chromium.base.library_loader;

import com.ttnet.org.chromium.base.JniStaticTestMocker;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;
import com.ttnet.org.chromium.base.annotations.MainDex;
import com.ttnet.org.chromium.base.library_loader.LibraryLoader;
import com.ttnet.org.chromium.base.natives.GEN_JNI;

/* JADX INFO: Access modifiers changed from: package-private */
@MainDex
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class LibraryLoaderJni implements LibraryLoader.Natives {
    public static final JniStaticTestMocker<LibraryLoader.Natives> TEST_HOOKS = new JniStaticTestMocker<LibraryLoader.Natives>() { // from class: com.ttnet.org.chromium.base.library_loader.LibraryLoaderJni.1
        @Override // com.ttnet.org.chromium.base.JniStaticTestMocker
        public void setInstanceForTesting(LibraryLoader.Natives natives) {
            if (GEN_JNI.TESTING_ENABLED) {
                LibraryLoader.Natives unused = LibraryLoaderJni.testInstance = natives;
                return;
            }
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
        }
    };
    private static LibraryLoader.Natives testInstance;

    LibraryLoaderJni() {
    }

    @Override // com.ttnet.org.chromium.base.library_loader.LibraryLoader.Natives
    public boolean libraryLoaded(int i) {
        return GEN_JNI.m318xc4dfbf10(i);
    }

    @Override // com.ttnet.org.chromium.base.library_loader.LibraryLoader.Natives
    public void registerNonMainDexJni() {
        GEN_JNI.m319x2c41aa61();
    }

    public static LibraryLoader.Natives get() {
        if (GEN_JNI.TESTING_ENABLED) {
            LibraryLoader.Natives natives = testInstance;
            if (natives != null) {
                return natives;
            }
            if (GEN_JNI.REQUIRE_MOCK) {
                throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.base.library_loader.LibraryLoader.Natives. The current configuration requires all native implementations to have a mock instance.");
            }
        }
        NativeLibraryLoadedStatus.checkLoaded(true);
        return new LibraryLoaderJni();
    }
}
