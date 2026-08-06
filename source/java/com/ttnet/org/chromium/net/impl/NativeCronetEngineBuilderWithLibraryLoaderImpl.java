package com.ttnet.org.chromium.net.impl;

import android.content.Context;
import com.ttnet.org.chromium.net.CronetEngine;
import com.ttnet.org.chromium.net.impl.VersionSafeCallbacks;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class NativeCronetEngineBuilderWithLibraryLoaderImpl extends NativeCronetEngineBuilderImpl {
    private VersionSafeCallbacks.LibraryLoader mLibraryLoader;

    public NativeCronetEngineBuilderWithLibraryLoaderImpl(Context context, boolean z) {
        super(context, z);
    }

    @Override // com.ttnet.org.chromium.net.impl.NativeCronetEngineBuilderImpl, com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl, com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setLibraryLoader(CronetEngine.Builder.LibraryLoader libraryLoader) {
        this.mLibraryLoader = new VersionSafeCallbacks.LibraryLoader(libraryLoader);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl
    public VersionSafeCallbacks.LibraryLoader libraryLoader() {
        return this.mLibraryLoader;
    }
}
