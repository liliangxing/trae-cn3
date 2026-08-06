package com.lynx.jsbridge;

/* loaded from: classes6.dex */
public class WebAssemblyBridge {
    private static native void nativeInitWasm(long j);

    public static void initWasmRegisterFunc(long j) {
        nativeInitWasm(j);
    }

    public static boolean initWasm() {
        long wasmRegister = WebAssemblyReflect.getWasmRegister();
        if (wasmRegister == 0) {
            return false;
        }
        initWasmRegisterFunc(wasmRegister);
        return true;
    }
}
