package com.bytedance.vmsdk.wasm;

import android.util.Log;

/* loaded from: classes6.dex */
public class RegisterWebAssembly {
    private static native long loadWasmFactory();

    public static long registerWebAssembly() {
        try {
            Log.i("vmsdk", "Loading libwasm.so ...");
            System.loadLibrary("wasm");
            return loadWasmFactory();
        } catch (Exception e) {
            Log.e("vmsdk", "No libwasm.so found in the host [ " + e.getMessage() + ", " + e.getCause() + " ]");
            return 0L;
        }
    }
}
