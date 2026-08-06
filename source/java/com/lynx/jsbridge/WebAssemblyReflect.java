package com.lynx.jsbridge;

import com.lynx.tasm.base.LLog;

/* loaded from: classes6.dex */
public class WebAssemblyReflect {
    public static long getWasmRegister() {
        try {
            return ((Long) Class.forName("com.bytedance.vmsdk.wasm.RegisterWebAssembly").getMethod("registerWebAssembly", new Class[0]).invoke(null, new Object[0])).longValue();
        } catch (Exception e) {
            LLog.e("lynx", "No webassembly found in the host [ " + e.getMessage() + ", " + e.getCause() + " ]");
            return 0L;
        }
    }
}
