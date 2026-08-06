package com.bytedance.pia.core.api;

import android.content.Context;
import com.bytedance.pia.core.api.PiaEnv;
import com.bytedance.pia.core.api.monitor.IPiaMetricsObserver;
import com.bytedance.pia.core.api.network.IPiaRetrofit;
import com.bytedance.pia.core.api.resource.IResourceLoader;
import com.bytedance.pia.core.api.utils.IFactory;
import java.util.List;

@Deprecated
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface IPiaEnv {
    String getNameSpace();

    default IFactory<String> getWorkerUserAgentFactory() {
        return Default.getWorkerUserAgentFactory();
    }

    default IFactory<IResourceLoader> getResourceLoaderFactory() {
        return Default.getResourceLoaderFactory();
    }

    default List<IFactory<IPiaMetricsObserver>> getPiaMetricsObserverListFactory() {
        return Default.getPiaMetricsObserverList();
    }

    default IFactory<IPiaRetrofit> getRetrofitFactory() {
        return Default.getRetrofitFactory();
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static class Default {
        private Default() {
        }

        public static Context getApplicationContext() {
            return PiaEnv.Default.getApplicationContext();
        }

        public static void setApplicationContext(Context context) {
            PiaEnv.Default.setApplicationContext(context);
        }

        public static Runnable getLazyInitializeTask() {
            return PiaEnv.Default.getLazyInitializeTask();
        }

        public static void setLazyInitializeTask(Runnable runnable) {
            PiaEnv.Default.setLazyInitializeTask(runnable);
        }

        public static IFactory<String> getWorkerUserAgentFactory() {
            return PiaEnv.Default.getWorkerUserAgentFactory();
        }

        public static void setWorkerUserAgentFactory(IFactory<String> iFactory) {
            PiaEnv.Default.setWorkerUserAgentFactory(iFactory);
        }

        public static IFactory<IResourceLoader> getResourceLoaderFactory() {
            return PiaEnv.Default.getResourceLoaderFactory();
        }

        public static void setResourceLoaderFactory(IFactory<IResourceLoader> iFactory) {
            PiaEnv.Default.setResourceLoaderFactory(iFactory);
        }

        public static IFactory<IPiaRetrofit> getRetrofitFactory() {
            return PiaEnv.Default.getRetrofitFactory();
        }

        public static void setRetrofitFactory(IFactory<IPiaRetrofit> iFactory) {
            PiaEnv.Default.setRetrofitFactory(iFactory);
        }

        public static void registerPiaMetricObserver(IFactory<IPiaMetricsObserver> iFactory) {
            PiaEnv.Default.registerPiaMetricObserver(iFactory);
        }

        public static List<IFactory<IPiaMetricsObserver>> getPiaMetricsObserverList() {
            return PiaEnv.Default.getPiaMetricsObserverList();
        }
    }
}
