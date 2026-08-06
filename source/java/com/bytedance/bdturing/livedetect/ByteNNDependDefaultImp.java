package com.bytedance.bdturing.livedetect;

/* loaded from: classes3.dex */
public class ByteNNDependDefaultImp implements IByteNNDepend {
    @Override // com.bytedance.bdturing.livedetect.IByteNNDepend
    public boolean isByteNNSoReady() {
        return true;
    }

    @Override // com.bytedance.bdturing.livedetect.IByteNNDepend
    public void loadLibrary(IByteNNLoadCallBack iByteNNLoadCallBack) {
        iByteNNLoadCallBack.onSuccess("");
    }
}
