package com.lynx.tasm.service;

import com.lynx.tasm.provider.ILynxResourceRequestOperation;

/* loaded from: classes7.dex */
public interface ILynxResourceServiceRequestOperation extends ILynxResourceRequestOperation {
    @Override // com.lynx.tasm.provider.ILynxResourceRequestOperation
    void cancel();

    ILynxResourceServiceResponse execute();
}
