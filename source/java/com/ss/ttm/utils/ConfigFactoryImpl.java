package com.ss.ttm.utils;

/* loaded from: classes7.dex */
public class ConfigFactoryImpl implements ConfigFactory {
    @Override // com.ss.ttm.utils.ConfigFactory
    public ConfigAPI createConfig(long handle, int t) {
        return new ConfigImpl(handle, t);
    }
}
