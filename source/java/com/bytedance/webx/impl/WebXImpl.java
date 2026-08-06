package com.bytedance.webx.impl;

import com.bytedance.webx.IManager;
import com.bytedance.webx.WebX;
import com.bytedance.webx.WebXEnv;
import com.bytedance.webx.base.logger.WLog;
import com.bytedance.webx.core.IExtendableControl;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

/* loaded from: classes6.dex */
public class WebXImpl implements IWebX {
    private static String TAG = "WebXImpl";
    private HashMap<Class<? extends IManager>, IManager> mContainerManagers = new HashMap<>();
    private String mNameSpace;

    public WebXImpl(String str) {
        this.mNameSpace = str;
    }

    @Override // com.bytedance.webx.impl.IWebX
    public <T extends IManager> T getContainerManager(Class<T> cls) {
        T t = (T) this.mContainerManagers.get(cls);
        if (t == null) {
            synchronized (WebX.class) {
                t = (T) this.mContainerManagers.get(cls);
                if (t == null) {
                    WebXEnv webXEnv = WebXEnv.get(this.mNameSpace, cls);
                    if (webXEnv == null) {
                        throw new Error("nameSpace " + this.mNameSpace + "& class " + cls.getCanonicalName() + " 's env is null");
                    }
                    IManager createContainerManager = createContainerManager(webXEnv);
                    HashMap<Class<? extends IManager>, IManager> hashMap = new HashMap<>(this.mContainerManagers);
                    hashMap.put(cls, createContainerManager);
                    this.mContainerManagers = hashMap;
                    t = (T) createContainerManager;
                }
            }
        }
        return t;
    }

    private static IManager createContainerManager(WebXEnv webXEnv) {
        IManager iManager = (IManager) newInstance(webXEnv.getManagerClazz());
        if (!(iManager instanceof IExtendableControl)) {
            return null;
        }
        IExtendableControl iExtendableControl = (IExtendableControl) iManager;
        iExtendableControl.init(webXEnv);
        iExtendableControl.getExtendableContext().firstAddExtension(webXEnv.mManagerExtensionClazzs);
        return iManager;
    }

    public static <T> T newInstance(Class<? extends T> cls) {
        Constructor<?> constructor;
        try {
            Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
            int length = declaredConstructors.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    constructor = null;
                    break;
                }
                constructor = declaredConstructors[i];
                if (constructor.getParameterTypes().length == 0) {
                    break;
                }
                i++;
            }
            if (constructor == null) {
                throw new RuntimeException();
            }
            try {
                try {
                    constructor.setAccessible(true);
                    return (T) constructor.newInstance(new Object[0]);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            } catch (IllegalAccessException e2) {
                throw new RuntimeException(e2);
            } catch (InstantiationException e3) {
                throw new RuntimeException(e3);
            }
        } catch (Throwable th) {
            String str = cls + "'s new instance return null";
            WLog.e(TAG, str, th);
            WebXEnv.onError(str, th);
            return null;
        }
    }
}
