package com.lynx.tasm.service;

/* loaded from: classes7.dex */
public interface ILynxLogService extends IServiceProvider {

    /* loaded from: classes7.dex */
    public enum LogOutputChannelType {
        Native,
        Platform
    }

    long getDefaultWriteFunction();

    boolean getLogToSystemStatus();

    boolean isLogOutputByPlatform();

    void logByPlatform(int i, String str, String str2);

    void switchLogToSystem(boolean z);

    @Override // com.lynx.tasm.service.IServiceProvider
    default Class<? extends IServiceProvider> getServiceClass() {
        return ILynxLogService.class;
    }
}
