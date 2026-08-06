package com.ttnet.org.chromium.net.impl;

import android.content.Context;
import com.ttnet.org.chromium.net.CronetEngine;
import com.ttnet.org.chromium.net.CronetProvider;
import com.ttnet.org.chromium.net.ExperimentalCronetEngine;
import java.util.Arrays;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class NativeCronetProvider extends CronetProvider {
    @Override // com.ttnet.org.chromium.net.CronetProvider
    public String getName() {
        return CronetProvider.PROVIDER_NAME_APP_PACKAGED;
    }

    @Override // com.ttnet.org.chromium.net.CronetProvider
    public boolean isEnabled() {
        return true;
    }

    public NativeCronetProvider(Context context) {
        super(context);
    }

    @Override // com.ttnet.org.chromium.net.CronetProvider
    public CronetEngine.Builder createBuilder(boolean z) {
        return new ExperimentalCronetEngine.Builder(new NativeCronetEngineBuilderWithLibraryLoaderImpl(this.mContext, z));
    }

    @Override // com.ttnet.org.chromium.net.CronetProvider
    public String getVersion() {
        return ImplVersion.getCronetVersion();
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{NativeCronetProvider.class, this.mContext});
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof NativeCronetProvider) && this.mContext.equals(((NativeCronetProvider) obj).mContext));
    }
}
