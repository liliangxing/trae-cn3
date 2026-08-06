package com.bytedance.pia.core.service;

import android.text.TextUtils;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedance.pia.core.PiaContext;
import com.bytedance.pia.core.api.IPiaEnv;
import com.bytedance.pia.core.api.PiaEnv;
import com.bytedance.pia.core.api.network.IPiaRetrofit;
import com.bytedance.pia.core.api.services.IPiaEnvService;
import com.bytedance.pia.core.api.utils.IFactory;
import com.bytedance.pia.core.runtime.PiaRuntime$Builder$$ExternalSyntheticLambda0;
import com.bytedance.pia.core.runtime.PluginRegistry;
import com.bytedance.pia.core.service.EnvService;
import com.bytedance.pia.core.spi.ConfigTask;
import com.bytedance.pia.core.utils.DefaultResourceLoader;
import com.bytedance.pia.core.utils.Logger;
import com.bytedance.pia.core.utils.ThreadUtil;
import com.bytedance.pia.core.worker.Polyfill;
import com.bytedance.pia.core.worker.Worker;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class EnvService implements IPiaEnvService {
    private static final String COMPAT_ENTRY = "com.bytedance.pia.core.CompatEntry";
    private static final String COMPAT_INITIALIZE = "initialize";
    private final Map<String, PiaEnv> environments;

    public static EnvService getInstance() {
        return InstanceHolder.INSTANCE;
    }

    private EnvService() {
        this.environments = new HashMap();
    }

    @Override // com.bytedance.pia.core.api.services.IPiaEnvService
    public void initialize(PiaEnv piaEnv) throws NullPointerException {
        Initializer initializer = Initializer.INSTANCE;
        Logger.m181i("[EnvService] initialize cost: start=" + initializer.startTime + ", end=" + initializer.endTime + LibrarianImpl.Constants.DOT);
        if (piaEnv == null) {
            return;
        }
        String nameSpace = piaEnv.getNameSpace();
        if (TextUtils.isEmpty(nameSpace)) {
            throw null;
        }
        this.environments.put(nameSpace, piaEnv);
    }

    @Override // com.bytedance.pia.core.api.services.IPiaEnvService
    public void initialize(IPiaEnv iPiaEnv) throws NullPointerException {
        PiaEnv piaEnv = new PiaEnv();
        piaEnv.setNameSpace(iPiaEnv.getNameSpace());
        piaEnv.setPiaMetricsObserverListFactory(iPiaEnv.getPiaMetricsObserverListFactory());
        piaEnv.setRetrofitFactory(iPiaEnv.getRetrofitFactory());
        piaEnv.setResourceLoaderFactory(iPiaEnv.getResourceLoaderFactory());
        piaEnv.setWorkerUserAgentFactory(iPiaEnv.getWorkerUserAgentFactory());
        initialize(piaEnv);
    }

    public PiaEnv getEnv(String str) {
        PiaEnv piaEnv = this.environments.get(str);
        return piaEnv == null ? new PiaEnv() : piaEnv;
    }

    public boolean exist(String str) {
        return this.environments.containsKey(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static class InstanceHolder {
        private static final EnvService INSTANCE = new EnvService();

        private InstanceHolder() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static class Initializer {
        private static final Initializer INSTANCE = new Initializer();
        private final long endTime;
        private final long startTime = System.currentTimeMillis();

        private Initializer() {
            ConfigTask.get().run();
            PiaContext.setApplicationContext(PiaEnv.Default.getApplicationContext());
            Worker.VmSdkUtil.initialize();
            if (PiaEnv.Default.getResourceLoaderFactory() == null) {
                PiaEnv.Default.setResourceLoaderFactory(new IFactory() { // from class: com.bytedance.pia.core.service.EnvService$Initializer$$ExternalSyntheticLambda0
                    @Override // com.bytedance.pia.core.api.utils.IFactory
                    public final Object create() {
                        return new DefaultResourceLoader();
                    }
                });
            }
            if (PiaEnv.Default.getRetrofitFactory() == null) {
                PiaEnv.Default.setRetrofitFactory(new IFactory() { // from class: com.bytedance.pia.core.service.EnvService$Initializer$$ExternalSyntheticLambda1
                    @Override // com.bytedance.pia.core.api.utils.IFactory
                    public final Object create() {
                        return EnvService.Initializer.lambda$new$0();
                    }
                });
            }
            ThreadUtil.runOnPia(new Runnable() { // from class: com.bytedance.pia.core.service.EnvService$Initializer$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    EnvService.Initializer.lambda$new$1();
                }
            });
            Runnable lazyInitializeTask = PiaEnv.Default.getLazyInitializeTask();
            if (lazyInitializeTask != null) {
                lazyInitializeTask.run();
            }
            PluginRegistry.add(new PluginRegistry.BaseRegistry());
            try {
                Class.forName(EnvService.COMPAT_ENTRY).getMethod(EnvService.COMPAT_INITIALIZE, new Class[0]).invoke(null, new Object[0]);
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            }
            this.endTime = System.currentTimeMillis();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ IPiaRetrofit lambda$new$0() {
            return new PiaRuntime$Builder$$ExternalSyntheticLambda0();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ void lambda$new$1() {
            if (Polyfill.getValue() == null) {
                Logger.m178e("Initialize worker polyfill failed!");
            } else {
                Logger.m181i("Initialize worker polyfill success.");
            }
        }
    }
}
