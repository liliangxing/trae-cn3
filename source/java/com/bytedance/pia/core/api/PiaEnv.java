package com.bytedance.pia.core.api;

import android.content.Context;
import com.bytedance.pia.core.api.bridge.PiaMethod;
import com.bytedance.pia.core.api.monitor.IPiaMetricsObserver;
import com.bytedance.pia.core.api.network.IPiaRetrofit;
import com.bytedance.pia.core.api.resource.IResourceLoader;
import com.bytedance.pia.core.api.security.ISecurityDelegate;
import com.bytedance.pia.core.api.utils.IFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class PiaEnv {
    private String nameSpace = "";
    private IFactory<String> workerUserAgentFactory = Default.getWorkerUserAgentFactory();
    private IFactory<IResourceLoader> resourceLoaderFactory = Default.getResourceLoaderFactory();
    private List<IFactory<IPiaMetricsObserver>> piaMetricsObserverListFactory = Default.getPiaMetricsObserverList();
    private IFactory<IPiaRetrofit> retrofitFactory = Default.getRetrofitFactory();
    private IFactory<Set<PiaMethod<?, ?>>> piaMethodsFactory = Default.getPiaMethodsFactory();
    private IFactory<Map<String, ?>> globalPropsFactory = Default.getGlobalPropsFactory();
    private IFactory<Map<String, String>> sensitiveHeaderFactory = Default.getSensitiveHeaderFactory();
    private IFactory<ISecurityDelegate> securityFactory = Default.getSecurityFactory();

    public String getNameSpace() {
        return this.nameSpace;
    }

    public void setNameSpace(String str) {
        this.nameSpace = str;
    }

    public IFactory<String> getWorkerUserAgentFactory() {
        IFactory<String> iFactory = this.workerUserAgentFactory;
        return iFactory == null ? Default.getWorkerUserAgentFactory() : iFactory;
    }

    public void setWorkerUserAgentFactory(IFactory<String> iFactory) {
        this.workerUserAgentFactory = iFactory;
    }

    public IFactory<IResourceLoader> getResourceLoaderFactory() {
        IFactory<IResourceLoader> iFactory = this.resourceLoaderFactory;
        return iFactory == null ? Default.getResourceLoaderFactory() : iFactory;
    }

    public void setResourceLoaderFactory(IFactory<IResourceLoader> iFactory) {
        this.resourceLoaderFactory = iFactory;
    }

    public List<IFactory<IPiaMetricsObserver>> getPiaMetricsObserverListFactory() {
        return this.piaMetricsObserverListFactory;
    }

    public void setPiaMetricsObserverListFactory(List<IFactory<IPiaMetricsObserver>> list) {
        this.piaMetricsObserverListFactory = list;
    }

    public IFactory<IPiaRetrofit> getRetrofitFactory() {
        IFactory<IPiaRetrofit> iFactory = this.retrofitFactory;
        return iFactory == null ? Default.getRetrofitFactory() : iFactory;
    }

    public void setRetrofitFactory(IFactory<IPiaRetrofit> iFactory) {
        this.retrofitFactory = iFactory;
    }

    public IFactory<Set<PiaMethod<?, ?>>> getPiaMethodsFactory() {
        return this.piaMethodsFactory;
    }

    public void setPiaMethodsFactory(IFactory<Set<PiaMethod<?, ?>>> iFactory) {
        this.piaMethodsFactory = iFactory;
    }

    public IFactory<Map<String, ?>> getGlobalPropsFactory() {
        IFactory<Map<String, ?>> iFactory = this.globalPropsFactory;
        return iFactory == null ? Default.getGlobalPropsFactory() : iFactory;
    }

    public void setGlobalPropsFactory(IFactory<Map<String, ?>> iFactory) {
        this.globalPropsFactory = iFactory;
    }

    public IFactory<Map<String, String>> getSensitiveHeaderFactory() {
        IFactory<Map<String, String>> iFactory = this.sensitiveHeaderFactory;
        return iFactory == null ? Default.getSensitiveHeaderFactory() : iFactory;
    }

    public void setSensitiveHeaderFactory(IFactory<Map<String, String>> iFactory) {
        this.sensitiveHeaderFactory = iFactory;
    }

    public IFactory<ISecurityDelegate> getSecurityFactory() {
        IFactory<ISecurityDelegate> iFactory = this.securityFactory;
        return iFactory == null ? Default.getSecurityFactory() : iFactory;
    }

    public void setSecurityFactory(IFactory<ISecurityDelegate> iFactory) {
        this.securityFactory = iFactory;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static class Default {
        private static volatile Context gApplicationContext;
        private static volatile IFactory<Map<String, ?>> gGlobalPropsFactory;
        private static volatile Runnable gLazyInitializeTask;
        private static volatile IFactory<Set<PiaMethod<?, ?>>> gPiaMethodsFactory;
        private static final List<IFactory<IPiaMetricsObserver>> gPiaMetricsObserverList = new ArrayList();
        private static volatile IFactory<IResourceLoader> gResourceLoaderFactory;
        private static volatile IFactory<IPiaRetrofit> gRetrofitFactory;
        private static volatile IFactory<ISecurityDelegate> gSecurityFactory;
        private static volatile IFactory<Map<String, String>> gSensitiveHeaderFactory;
        private static volatile IPiaSettingsProvider gSettingsProvider;
        private static volatile IFactory<String> gWorkerUserAgentFactory;

        private Default() {
        }

        public static Context getApplicationContext() {
            return gApplicationContext;
        }

        public static void setApplicationContext(Context context) {
            if (context == null || gApplicationContext != null) {
                return;
            }
            gApplicationContext = context;
        }

        public static Runnable getLazyInitializeTask() {
            return gLazyInitializeTask;
        }

        public static void setLazyInitializeTask(Runnable runnable) {
            if (runnable == null || gLazyInitializeTask != null) {
                return;
            }
            gLazyInitializeTask = runnable;
        }

        public static IPiaSettingsProvider getSettingsProvider() {
            return gSettingsProvider;
        }

        public static void setSettingsProvider(IPiaSettingsProvider iPiaSettingsProvider) {
            if (iPiaSettingsProvider == null || gSettingsProvider != null) {
                return;
            }
            gSettingsProvider = iPiaSettingsProvider;
        }

        public static IFactory<String> getWorkerUserAgentFactory() {
            return gWorkerUserAgentFactory;
        }

        public static void setWorkerUserAgentFactory(IFactory<String> iFactory) {
            if (iFactory == null || gWorkerUserAgentFactory != null) {
                return;
            }
            gWorkerUserAgentFactory = iFactory;
        }

        public static IFactory<IResourceLoader> getResourceLoaderFactory() {
            return gResourceLoaderFactory;
        }

        public static void setResourceLoaderFactory(IFactory<IResourceLoader> iFactory) {
            if (iFactory == null || gResourceLoaderFactory != null) {
                return;
            }
            gResourceLoaderFactory = iFactory;
        }

        public static IFactory<IPiaRetrofit> getRetrofitFactory() {
            return gRetrofitFactory;
        }

        public static void setRetrofitFactory(IFactory<IPiaRetrofit> iFactory) {
            if (iFactory == null || gRetrofitFactory != null) {
                return;
            }
            gRetrofitFactory = iFactory;
        }

        public static void registerPiaMetricObserver(IFactory<IPiaMetricsObserver> iFactory) {
            gPiaMetricsObserverList.add(iFactory);
        }

        public static List<IFactory<IPiaMetricsObserver>> getPiaMetricsObserverList() {
            return gPiaMetricsObserverList;
        }

        public static IFactory<Set<PiaMethod<?, ?>>> getPiaMethodsFactory() {
            return gPiaMethodsFactory;
        }

        public static void setPiaMethodsFactory(IFactory<Set<PiaMethod<?, ?>>> iFactory) {
            if (iFactory == null || gPiaMethodsFactory != null) {
                return;
            }
            gPiaMethodsFactory = iFactory;
        }

        public static IFactory<Map<String, ?>> getGlobalPropsFactory() {
            return gGlobalPropsFactory;
        }

        public static void setGlobalPropsFactory(IFactory<Map<String, ?>> iFactory) {
            if (iFactory == null || gGlobalPropsFactory != null) {
                return;
            }
            gGlobalPropsFactory = iFactory;
        }

        public static IFactory<Map<String, String>> getSensitiveHeaderFactory() {
            return gSensitiveHeaderFactory;
        }

        public static void setSensitiveHeaderFactory(IFactory<Map<String, String>> iFactory) {
            if (iFactory == null || gSensitiveHeaderFactory != null) {
                return;
            }
            gSensitiveHeaderFactory = iFactory;
        }

        public static IFactory<ISecurityDelegate> getSecurityFactory() {
            return gSecurityFactory;
        }

        public static void setSecurityFactory(IFactory<ISecurityDelegate> iFactory) {
            if (iFactory == null || gSecurityFactory != null) {
                return;
            }
            gSecurityFactory = iFactory;
        }
    }
}
