package com.lynx.tasm.service.security;

import com.lynx.tasm.service.IServiceProvider;
import java.nio.ByteBuffer;

/* loaded from: classes7.dex */
public interface ILynxSecurityService extends IServiceProvider {

    /* loaded from: classes7.dex */
    public enum LynxTasmType {
        TYPE_TEMPLATE,
        TYPE_DYNAMIC_COMPONENT
    }

    SecurityResult verifyTASM(ILynxSecurityTarget iLynxSecurityTarget, byte[] bArr, ByteBuffer byteBuffer, String str, LynxTasmType lynxTasmType);

    @Override // com.lynx.tasm.service.IServiceProvider
    default Class<? extends IServiceProvider> getServiceClass() {
        return ILynxSecurityService.class;
    }
}
