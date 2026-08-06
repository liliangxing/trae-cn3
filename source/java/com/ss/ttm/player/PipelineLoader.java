package com.ss.ttm.player;

/* loaded from: classes7.dex */
public class PipelineLoader {
    private long mHandle;

    private native void _load(long mHandle, String paramsJson);

    /* JADX INFO: Access modifiers changed from: package-private */
    public PipelineLoader(long handle) {
        this.mHandle = handle;
    }

    public void load(PipelineLoadParams params) {
        String jsonString;
        if (this.mHandle == 0 || params == null || (jsonString = params.toJsonString()) == null || jsonString.isEmpty()) {
            return;
        }
        _load(this.mHandle, jsonString);
    }
}
