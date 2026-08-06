package com.bytedance.pia.core;

import com.bytedance.pia.core.bridge.BridgeRegistry;
import com.bytedance.pia.core.plugins.CompatPluginRegistry;
import com.bytedance.pia.core.runtime.PluginRegistry;
import com.bytedance.pia.core.utils.Logger;
import com.bytedance.pia.nsr.bridge.PiaNsrMethod;
import com.bytedance.pia.page.bridge.PiaPostWorkerMessageMethod;
import com.bytedance.pia.snapshot.bridge.PiaRemoveSnapshot;
import com.bytedance.pia.snapshot.bridge.PiaSaveSnapshotMethod;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class CompatEntry {
    public static void initialize() {
        Logger.m181i("Initialize PIA-Core-Compat.");
        PluginRegistry.add(new CompatPluginRegistry());
        BridgeRegistry.GLOBAL_METHODS.put(PiaNsrMethod.NAME, PiaNsrMethod.getMethod());
        BridgeRegistry.GLOBAL_METHODS.put(PiaSaveSnapshotMethod.NAME, PiaSaveSnapshotMethod.getMethod());
        BridgeRegistry.GLOBAL_METHODS.put(PiaRemoveSnapshot.NAME, PiaRemoveSnapshot.getMethod());
        BridgeRegistry.GLOBAL_METHODS.put(PiaPostWorkerMessageMethod.NAME, PiaPostWorkerMessageMethod.getMethod());
    }
}
