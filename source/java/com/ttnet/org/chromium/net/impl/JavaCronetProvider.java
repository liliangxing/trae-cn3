package com.ttnet.org.chromium.net.impl;

import android.content.Context;
import com.ttnet.org.chromium.net.CronetEngine;
import com.ttnet.org.chromium.net.CronetProvider;
import com.ttnet.org.chromium.net.ExperimentalCronetEngine;
import java.util.Arrays;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class JavaCronetProvider extends CronetProvider {
    @Override // com.ttnet.org.chromium.net.CronetProvider
    public String getName() {
        return CronetProvider.PROVIDER_NAME_FALLBACK;
    }

    @Override // com.ttnet.org.chromium.net.CronetProvider
    public boolean isEnabled() {
        return true;
    }

    public JavaCronetProvider(Context context) {
        super(context);
    }

    @Override // com.ttnet.org.chromium.net.CronetProvider
    public CronetEngine.Builder createBuilder(boolean z) {
        return new ExperimentalCronetEngine.Builder(new JavaCronetEngineBuilderImpl(this.mContext, z));
    }

    @Override // com.ttnet.org.chromium.net.CronetProvider
    public String getVersion() {
        return ImplVersion.getCronetVersion();
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{JavaCronetProvider.class, this.mContext});
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof JavaCronetProvider) && this.mContext.equals(((JavaCronetProvider) obj).mContext));
    }
}
