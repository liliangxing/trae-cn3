package com.bytedance.webx;

import android.content.Context;
import android.util.Pair;
import com.bytedance.webx.IExtension;
import com.bytedance.webx.addr.AddressParam;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class WebXEnv {
    public static final String DEFAULT_NAMESPACE = "";
    private static Context sContext;
    private static GlobalConfig sGlobalConfig;
    private static Map<String, List<Pair<Class<? extends IManager>, InitBuilder>>> sWebXEnvBuildersMap = new HashMap();
    private static Map<String, Map<Class<? extends IManager>, WebXEnv>> sWebXEnvsMap = new HashMap();
    public LinkedHashSet<Class<? extends AbsExtension>> mContainerExtensionClazzs;
    public LinkedHashSet<IExtensionCreateListener> mExtensionCreateListeners;
    public HashMap<Class<? extends AbsExtension>, LinkedHashSet<IExtensionCreateListener>> mExtensionCreateListenersMap;
    private Class<? extends IManager> mManagerClazz;
    public LinkedHashSet<Class<? extends AbsExtension>> mManagerExtensionClazzs;
    private String mNameSpace;
    public HashSet<AddressParam.UriMatcher> mUriMatchs;

    /* loaded from: classes6.dex */
    public interface IErrorListener {
        void onError(String str, Throwable th);
    }

    /* loaded from: classes6.dex */
    public interface IExtensionCreateListener {
        void onExtensionCreate(AbsExtension absExtension);
    }

    /* loaded from: classes6.dex */
    public static class GlobalConfig {
        private IErrorListener mErrorListener;
        private boolean mIsEnableTrace;
    }

    public static void initGlobal(Context context) {
        if (sContext != null) {
            return;
        }
        sContext = context.getApplicationContext();
        sGlobalConfig = new GlobalConfig();
    }

    public static void initGlobal(Context context, GlobalBuilder globalBuilder) {
        if (sContext != null) {
            return;
        }
        sContext = context.getApplicationContext();
        sGlobalConfig = globalBuilder.build();
    }

    public static Context getAppContext() {
        return sContext;
    }

    public static boolean isEnableTrace() {
        return sGlobalConfig.mIsEnableTrace;
    }

    public static void onError(String str, Throwable th) {
        sGlobalConfig.mErrorListener.onError(str, th);
    }

    /* loaded from: classes6.dex */
    public static class GlobalBuilder {
        private GlobalConfig mGlobalConfig = new GlobalConfig();

        public GlobalBuilder setEnableTrace(boolean z) {
            this.mGlobalConfig.mIsEnableTrace = z;
            return this;
        }

        public GlobalBuilder setErrorListener(IErrorListener iErrorListener) {
            this.mGlobalConfig.mErrorListener = iErrorListener;
            return this;
        }

        public GlobalConfig build() {
            if (this.mGlobalConfig.mErrorListener == null) {
                this.mGlobalConfig.mErrorListener = new IErrorListener() { // from class: com.bytedance.webx.WebXEnv.GlobalBuilder.1
                    @Override // com.bytedance.webx.WebXEnv.IErrorListener
                    public void onError(String str, Throwable th) {
                    }
                };
            }
            return this.mGlobalConfig;
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class InitBuilder {
        private Class mManagerClass;

        protected abstract void onInit(Builder builder);

        public Class getManagerClass() {
            return this.mManagerClass;
        }
    }

    public static <T extends IManager> void initInstance(Class<T> cls) {
        initInstance(cls, new InitBuilder() { // from class: com.bytedance.webx.WebXEnv.1
            @Override // com.bytedance.webx.WebXEnv.InitBuilder
            protected void onInit(Builder builder) {
            }
        });
    }

    public static <T extends IManager> void initInstance(Class<T> cls, InitBuilder initBuilder) {
        initInstance("", cls, initBuilder);
    }

    public static <T extends IManager> void initInstance(String str, Class<T> cls, InitBuilder initBuilder) {
        List<Pair<Class<? extends IManager>, InitBuilder>> list = sWebXEnvBuildersMap.get(str);
        if (list == null) {
            synchronized (WebXEnv.class) {
                list = sWebXEnvBuildersMap.get(str);
                if (list == null) {
                    list = new ArrayList<>();
                    sWebXEnvBuildersMap.put(str, list);
                }
            }
        }
        Pair<Class<? extends IManager>, InitBuilder> pair = new Pair<>(cls, initBuilder);
        synchronized (WebXEnv.class) {
            list.add(pair);
        }
    }

    public static WebXEnv get(Class<? extends IManager> cls) {
        return get("", cls);
    }

    public static WebXEnv get(String str, Class<? extends IManager> cls) {
        Map<Class<? extends IManager>, WebXEnv> map = sWebXEnvsMap.get(str);
        if (map == null) {
            synchronized (WebXEnv.class) {
                map = sWebXEnvsMap.get(str);
                if (map == null) {
                    map = new Hashtable<>();
                    sWebXEnvsMap.put(str, map);
                }
            }
        }
        WebXEnv webXEnv = map.get(cls);
        if (webXEnv != null) {
            return webXEnv;
        }
        synchronized (WebXEnv.class) {
            WebXEnv webXEnv2 = map.get(cls);
            if (webXEnv2 != null) {
                return webXEnv2;
            }
            Builder builder = new Builder();
            List<Pair<Class<? extends IManager>, InitBuilder>> list = sWebXEnvBuildersMap.get(str);
            if (list == null) {
                return null;
            }
            for (Pair<Class<? extends IManager>, InitBuilder> pair : list) {
                if (((Class) pair.first).equals(cls)) {
                    InitBuilder initBuilder = (InitBuilder) pair.second;
                    initBuilder.mManagerClass = cls;
                    initBuilder.onInit(builder);
                    initBuilder.mManagerClass = null;
                }
            }
            WebXEnv build = builder.build(str, cls);
            map.put(cls, build);
            return build;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T extends IManager> WebXEnv(String str, Class<T> cls, LinkedHashSet<Class<? extends AbsExtension>> linkedHashSet, LinkedHashSet<Class<? extends AbsExtension>> linkedHashSet2) {
        this.mNameSpace = str;
        this.mManagerClazz = cls;
        this.mManagerExtensionClazzs = linkedHashSet;
        this.mContainerExtensionClazzs = linkedHashSet2;
    }

    public String getNameSpace() {
        return this.mNameSpace;
    }

    public Class<? extends IManager> getManagerClazz() {
        return this.mManagerClazz;
    }

    /* loaded from: classes6.dex */
    public static class Builder {
        private LinkedHashSet<Class<? extends AbsExtension>> mManagerExtensionClazzs = new LinkedHashSet<>();
        private LinkedHashSet<Class<? extends AbsExtension>> mContainerExtensionClazzs = new LinkedHashSet<>();
        private LinkedHashSet<IExtensionCreateListener> mExtensionCreateListeners = new LinkedHashSet<>();
        private HashMap<Class<? extends AbsExtension>, LinkedHashSet<IExtensionCreateListener>> mExtensionCreateListenersMap = new HashMap<>();
        private HashSet<AddressParam.UriMatcher> mUriMatchs = new HashSet<>();

        /* loaded from: classes6.dex */
        public interface IUrlMatcherConfig {
            String getConfig();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public <T extends IManager> WebXEnv build(String str, Class<T> cls) {
            WebXEnv webXEnv = new WebXEnv(str, cls, this.mManagerExtensionClazzs, this.mContainerExtensionClazzs);
            webXEnv.mExtensionCreateListeners = this.mExtensionCreateListeners;
            webXEnv.mExtensionCreateListenersMap = this.mExtensionCreateListenersMap;
            webXEnv.mUriMatchs = this.mUriMatchs;
            return webXEnv;
        }

        public Builder addExtension(Class<? extends AbsExtension> cls) {
            LinkedHashSet<Class<? extends AbsExtension>> linkedHashSet;
            if (cls == null) {
                return this;
            }
            if (IExtension.IManagerExtension.class.isAssignableFrom(cls)) {
                linkedHashSet = this.mManagerExtensionClazzs;
            } else if (IExtension.IContainerExtension.class.isAssignableFrom(cls)) {
                linkedHashSet = this.mContainerExtensionClazzs;
            } else {
                throw new Error();
            }
            linkedHashSet.add(cls);
            return this;
        }

        public Builder addExtension(Class<? extends AbsExtension> cls, IExtensionCreateListener iExtensionCreateListener) {
            if (cls == null) {
                return this;
            }
            addExtension(cls);
            LinkedHashSet<IExtensionCreateListener> linkedHashSet = this.mExtensionCreateListenersMap.get(cls);
            if (linkedHashSet == null) {
                linkedHashSet = new LinkedHashSet<>();
                this.mExtensionCreateListenersMap.put(cls, linkedHashSet);
            }
            linkedHashSet.add(iExtensionCreateListener);
            return this;
        }

        @SafeVarargs
        public final Builder addExtension(Class<? extends AbsExtension>... clsArr) {
            if (clsArr == null) {
                return this;
            }
            for (Class<? extends AbsExtension> cls : clsArr) {
                addExtension(cls);
            }
            return this;
        }

        public Builder addExtensionCreateListener(IExtensionCreateListener iExtensionCreateListener) {
            this.mExtensionCreateListeners.add(iExtensionCreateListener);
            return this;
        }

        public Builder addUriMatchConfig(IUrlMatcherConfig iUrlMatcherConfig) {
            if (iUrlMatcherConfig == null) {
                return this;
            }
            this.mUriMatchs.add(new AddressParam.UriMatcher(iUrlMatcherConfig));
            return this;
        }
    }
}
