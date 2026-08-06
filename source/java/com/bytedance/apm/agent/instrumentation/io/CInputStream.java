package com.bytedance.apm.agent.instrumentation.io;

import java.io.InputStream;

/* loaded from: classes3.dex */
public final class CInputStream extends CInputStreamParent {
    public CInputStream(InputStream inputStream) {
        this(inputStream, false);
    }

    public CInputStream(InputStream inputStream, boolean z) {
        super(inputStream, z);
    }
}
