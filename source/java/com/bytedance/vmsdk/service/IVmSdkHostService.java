package com.bytedance.vmsdk.service;

/* loaded from: classes6.dex */
public interface IVmSdkHostService extends IService {
    String getLynxPluginName();

    String getV8PluginName();

    String getVmSdkPluginName();

    boolean isPluginInstalled(String str);

    boolean isVmSdkPluginSettingsEnable();

    boolean loadPlugin(String str);

    boolean setAsHostClassLoader(String str);

    boolean setAsPluginClassLoader(String str);
}
