package com.bytedance.pia.core.bridge;

import android.text.TextUtils;
import com.bytedance.pia.core.api.bridge.PiaMethod;
import com.bytedance.pia.core.bridge.methods.BootGet;
import com.bytedance.pia.core.bridge.methods.CacheGetContentMethod;
import com.bytedance.pia.core.bridge.methods.CacheGetHeadersMethod;
import com.bytedance.pia.core.bridge.methods.CacheRemoveMethod;
import com.bytedance.pia.core.bridge.methods.CacheSaveMethod;
import com.bytedance.pia.core.bridge.methods.CacheUpdateManifestMethod;
import com.bytedance.pia.core.bridge.methods.SettingGet;
import com.bytedance.pia.core.bridge.methods.TracingGet;
import com.bytedance.pia.core.bridge.methods.TracingSet;
import com.bytedance.pia.core.bridge.methods.WorkerCreate;
import com.bytedance.pia.core.bridge.methods.WorkerPostMessage;
import com.bytedance.pia.core.bridge.methods.WorkerRunTask;
import com.bytedance.pia.core.bridge.methods.WorkerTerminate;
import com.bytedance.pia.core.utils.ThreadUtil;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class BridgeRegistry {
    public static final Map<String, PiaMethod<?, ?>> GLOBAL_METHODS;
    private final Map<String, PiaMethod<?, ?>> methods = new HashMap();

    static {
        HashMap hashMap = new HashMap();
        GLOBAL_METHODS = hashMap;
        hashMap.put(SettingGet.NAME, SettingGet.METHOD);
        hashMap.put(WorkerCreate.NAME, WorkerCreate.METHOD);
        hashMap.put(WorkerPostMessage.NAME, WorkerPostMessage.METHOD);
        hashMap.put(WorkerTerminate.NAME, WorkerTerminate.METHOD);
        hashMap.put(WorkerRunTask.NAME, WorkerRunTask.METHOD);
        hashMap.put(BootGet.NAME, BootGet.METHOD);
        hashMap.put(CacheSaveMethod.NAME, CacheSaveMethod.getMethod());
        hashMap.put(CacheGetContentMethod.NAME, CacheGetContentMethod.getMethod());
        hashMap.put(CacheRemoveMethod.NAME, CacheRemoveMethod.getMethod());
        hashMap.put(CacheGetHeadersMethod.NAME, CacheGetHeadersMethod.getMethod());
        hashMap.put(CacheUpdateManifestMethod.NAME, CacheUpdateManifestMethod.METHOD);
        hashMap.put(TracingGet.NAME, TracingGet.METHOD);
        hashMap.put(TracingSet.NAME, TracingSet.METHOD);
    }

    public void register(final PiaMethod<?, ?> piaMethod) {
        ThreadUtil.runOnPia(new Runnable() { // from class: com.bytedance.pia.core.bridge.BridgeRegistry$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                BridgeRegistry.this.m732lambda$register$0$combytedancepiacorebridgeBridgeRegistry(piaMethod);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$register$0$com-bytedance-pia-core-bridge-BridgeRegistry, reason: not valid java name */
    public /* synthetic */ void m732lambda$register$0$combytedancepiacorebridgeBridgeRegistry(PiaMethod piaMethod) {
        if (TextUtils.isEmpty(piaMethod.getName())) {
            return;
        }
        this.methods.put(piaMethod.getName(), piaMethod);
    }

    public PiaMethod<?, ?> get(String str, PiaMethod.Scope scope) {
        if (str == null) {
            return null;
        }
        PiaMethod<?, ?> piaMethod = this.methods.get(str);
        if (piaMethod == null) {
            piaMethod = GLOBAL_METHODS.get(str);
        }
        if (piaMethod == null) {
            return null;
        }
        if (PiaMethod.Scope.All == piaMethod.getScope() || piaMethod.getScope() == scope) {
            return piaMethod;
        }
        return null;
    }
}
