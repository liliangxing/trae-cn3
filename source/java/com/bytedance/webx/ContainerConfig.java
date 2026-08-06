package com.bytedance.webx;

import com.bytedance.webx.WebXEnv;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: classes6.dex */
public class ContainerConfig {
    private IContainer mAssignContainer;
    private HashMap<Class<? extends AbsExtension>, WebXEnv.IExtensionCreateListener> mExtensionCreateListenerMap;
    private Set<WebXEnv.IExtensionCreateListener> mExtensionCreateListeners;
    private Set<Class<? extends AbsExtension>> mExtensions;
    private Class<? extends IContainer> mNewContainerClass;
    private Class<? extends AbsPlugin>[] mPluginClazzs;

    private ContainerConfig() {
        this.mExtensions = new LinkedHashSet();
    }

    public IContainer getAssignContainer() {
        return this.mAssignContainer;
    }

    public Class<? extends IContainer> getNewContainerClass() {
        return this.mNewContainerClass;
    }

    public Set<Class<? extends AbsExtension>> getExtensions() {
        return this.mExtensions;
    }

    public Set<WebXEnv.IExtensionCreateListener> getExtensionCreateListeners() {
        return this.mExtensionCreateListeners;
    }

    public HashMap<Class<? extends AbsExtension>, WebXEnv.IExtensionCreateListener> getExtensionCreateListenerMap() {
        return this.mExtensionCreateListenerMap;
    }

    /* loaded from: classes6.dex */
    public static class Builder {
        ContainerConfig mContainerConfig = new ContainerConfig();

        public ContainerConfig build() {
            return this.mContainerConfig;
        }

        @SafeVarargs
        public final Builder addExtension(Class<? extends AbsExtension>... clsArr) {
            if (clsArr == null) {
                return this;
            }
            for (Class<? extends AbsExtension> cls : clsArr) {
                if (cls != null) {
                    this.mContainerConfig.mExtensions.add(cls);
                }
            }
            return this;
        }

        public Builder addExtension(Class<? extends AbsExtension> cls) {
            if (cls == null) {
                return this;
            }
            this.mContainerConfig.mExtensions.add(cls);
            return this;
        }

        public Builder addExtension(Class<? extends AbsExtension> cls, WebXEnv.IExtensionCreateListener iExtensionCreateListener) {
            if (cls == null) {
                return this;
            }
            this.mContainerConfig.mExtensions.add(cls);
            if (this.mContainerConfig.mExtensionCreateListenerMap == null) {
                this.mContainerConfig.mExtensionCreateListenerMap = new HashMap();
            }
            this.mContainerConfig.mExtensionCreateListenerMap.put(cls, iExtensionCreateListener);
            return this;
        }

        public Builder addExtensionCreateListener(WebXEnv.IExtensionCreateListener iExtensionCreateListener) {
            if (this.mContainerConfig.mExtensionCreateListeners == null) {
                this.mContainerConfig.mExtensionCreateListeners = new LinkedHashSet();
            }
            this.mContainerConfig.mExtensionCreateListeners.add(iExtensionCreateListener);
            return this;
        }

        @SafeVarargs
        public final Builder addPlugin(Class<? extends AbsPlugin>... clsArr) {
            this.mContainerConfig.mPluginClazzs = clsArr;
            return this;
        }

        public Builder assignContainer(IContainer iContainer) {
            this.mContainerConfig.mAssignContainer = iContainer;
            return this;
        }

        public Builder assignContainer(Class<? extends IContainer> cls) {
            this.mContainerConfig.mNewContainerClass = cls;
            return this;
        }
    }
}
