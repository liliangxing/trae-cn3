package com.lynx.tasm.service;

import java.util.Map;

/* loaded from: classes7.dex */
public interface ILynxTrailService extends IServiceProvider {
    Map<String, Object> getAllValues();

    Object objectValueForTrailKey(String str);

    String stringValueForTrailKey(String str);

    @Override // com.lynx.tasm.service.IServiceProvider
    default Class<? extends IServiceProvider> getServiceClass() {
        return ILynxTrailService.class;
    }
}
