package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.net.impl.CronetLogger;

/* loaded from: classes7.dex */
public final class NoOpLogger extends CronetLogger {
    @Override // com.ttnet.org.chromium.net.impl.CronetLogger
    public void logCronetEngineCreation(int i, CronetLogger.CronetEngineBuilderInfo cronetEngineBuilderInfo, CronetLogger.CronetVersion cronetVersion, CronetLogger.CronetSource cronetSource) {
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetLogger
    public void logCronetTrafficInfo(int i, CronetLogger.CronetTrafficInfo cronetTrafficInfo) {
    }
}
