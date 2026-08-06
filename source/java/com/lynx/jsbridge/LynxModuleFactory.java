package com.lynx.jsbridge;

import android.content.Context;
import com.lynx.jsbridge.LynxModule;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxViewClient;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.utils.UIThreadUtils;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class LynxModuleFactory {
    private static final String TAG = "LynxModuleFactory";
    private LynxModule.AuthValidator mAuthValidator;
    private Object mLynxModuleExtraData;
    private LynxViewClient mLynxViewClient;
    private Map<String, LynxModuleWrapper> mModulesByName;
    private WeakReference<Context> mWeakContext;
    private long mNativePtr = 0;
    private boolean mIsLynxViewDestroying = false;
    private boolean mHasDestroyed = false;
    private final ConcurrentHashMap<String, ParamWrapper> mWrappers = new ConcurrentHashMap<>();

    private native boolean nativeRetainJniObject(long j);

    public LynxModuleFactory(Context context) {
        setContext(context);
    }

    public void setContext(Context context) {
        if (context instanceof LynxContext) {
            this.mLynxViewClient = ((LynxContext) context).getLynxViewClient();
        }
        this.mWeakContext = new WeakReference<>(context);
    }

    private Map<String, ParamWrapper> getWrappers() {
        return this.mWrappers;
    }

    public void setLynxModuleExtraData(Object obj) {
        this.mLynxModuleExtraData = obj;
    }

    public void registerModule(String str, Class<? extends LynxModule> cls, Object obj) {
        ParamWrapper paramWrapper = new ParamWrapper();
        paramWrapper.setName(str);
        paramWrapper.setModuleClass(cls);
        paramWrapper.setParam(obj);
        ParamWrapper paramWrapper2 = this.mWrappers.get(str);
        if (paramWrapper2 != null) {
            LLog.m2577e(TAG, "Duplicated LynxModule For Name: " + str + ", " + paramWrapper2 + " will be override");
        }
        this.mWrappers.put(str, paramWrapper);
        LLog.m2579v(TAG, "registered module with name: " + str + " class" + cls);
    }

    public void addModuleParamWrapper(List<ParamWrapper> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        for (ParamWrapper paramWrapper : list) {
            String name = paramWrapper.getName();
            ParamWrapper paramWrapper2 = this.mWrappers.get(name);
            if (paramWrapper2 != null) {
                LLog.m2577e(TAG, "Duplicated LynxModule For Name: " + name + ", " + paramWrapper2 + " will be override");
            }
            this.mWrappers.put(name, paramWrapper);
        }
    }

    public void addModuleParamWrapperIfAbsent(List<ParamWrapper> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        for (ParamWrapper paramWrapper : list) {
            String name = paramWrapper.getName();
            if (this.mWrappers.containsKey(name)) {
                LLog.m2580w(TAG, "Duplicated LynxModule For Name: " + name + ", will be ignored");
            }
            this.mWrappers.putIfAbsent(name, paramWrapper);
        }
    }

    public void registerModuleAuthValidator(LynxModule.AuthValidator authValidator) {
        this.mAuthValidator = authValidator;
    }

    private void getModuleExceptionReport(Exception exc) {
        LLog.m2577e(TAG, "get Module failed" + exc);
    }

    public LynxModuleWrapper getModule(String str) {
        LynxModule lynxModule;
        boolean isAssignableFrom;
        LynxContext lynxContext;
        if (str == null) {
            LLog.m2577e(TAG, "getModule failed, name is null");
            return null;
        }
        if (this.mModulesByName == null) {
            this.mModulesByName = new HashMap();
        }
        if (this.mModulesByName.get(str) != null) {
            return this.mModulesByName.get(str);
        }
        ParamWrapper paramWrapper = this.mWrappers.get(str);
        if (paramWrapper == null && (paramWrapper = LynxEnv.inst().getModuleFactory().getWrappers().get(str)) == null) {
            return null;
        }
        Class<? extends LynxModule> moduleClass = paramWrapper.getModuleClass();
        try {
            isAssignableFrom = LynxContextModule.class.isAssignableFrom(moduleClass);
            lynxContext = (Context) this.mWeakContext.get();
        } catch (IllegalAccessException e) {
            getModuleExceptionReport(e);
        } catch (InstantiationException e2) {
            getModuleExceptionReport(e2);
        } catch (NoSuchMethodException e3) {
            getModuleExceptionReport(e3);
        } catch (InvocationTargetException e4) {
            getModuleExceptionReport(e4);
            LLog.m2577e(TAG, "get TargetException " + e4.getTargetException());
        } catch (Exception e5) {
            getModuleExceptionReport(e5);
        }
        if (lynxContext == null) {
            LLog.m2577e(TAG, moduleClass.getCanonicalName() + " called with Null context");
            return null;
        }
        if (isAssignableFrom) {
            if (!(lynxContext instanceof LynxContext)) {
                throw new Exception(moduleClass.getCanonicalName() + " must be created with LynxContext");
            }
            if (paramWrapper.getParam() == null) {
                for (Constructor<?> constructor : moduleClass.getConstructors()) {
                    Class<?>[] parameterTypes = constructor.getParameterTypes();
                    if (parameterTypes.length == 1 && LynxContext.class.equals(parameterTypes[0])) {
                        lynxModule = (LynxModule) constructor.newInstance(lynxContext);
                        break;
                    }
                    if (parameterTypes.length == 2 && LynxContext.class.equals(parameterTypes[0]) && Object.class.equals(parameterTypes[1])) {
                        lynxModule = (LynxModule) constructor.newInstance(lynxContext, null);
                        break;
                    }
                }
                lynxModule = null;
            } else {
                lynxModule = moduleClass.getConstructor(LynxContext.class, Object.class).newInstance(lynxContext, paramWrapper.getParam());
            }
        } else if (paramWrapper.getParam() == null) {
            for (Constructor<?> constructor2 : moduleClass.getConstructors()) {
                Class<?>[] parameterTypes2 = constructor2.getParameterTypes();
                if (parameterTypes2.length == 1 && Context.class.equals(parameterTypes2[0])) {
                    lynxModule = (LynxModule) constructor2.newInstance(lynxContext);
                    break;
                }
                if (parameterTypes2.length == 2 && Context.class.equals(parameterTypes2[0]) && Object.class.equals(parameterTypes2[1])) {
                    lynxModule = (LynxModule) constructor2.newInstance(lynxContext, null);
                    break;
                }
            }
            lynxModule = null;
        } else {
            lynxModule = moduleClass.getConstructor(Context.class, Object.class).newInstance(lynxContext, paramWrapper.getParam());
        }
        if (lynxModule == null) {
            LLog.m2579v(TAG, "getModule" + str + "failed");
            return null;
        }
        lynxModule.setExtraData(this.mLynxModuleExtraData);
        LynxModuleWrapper lynxModuleWrapper = new LynxModuleWrapper(str, lynxModule);
        lynxModuleWrapper.setAuthValidator(this.mAuthValidator);
        lynxModuleWrapper.setLynxContext(this.mWeakContext);
        this.mModulesByName.put(str, lynxModuleWrapper);
        return lynxModuleWrapper;
    }

    public void markLynxViewIsDestroying() {
        this.mIsLynxViewDestroying = true;
    }

    public void retainJniObject() {
        if (nativeRetainJniObject(this.mNativePtr)) {
            return;
        }
        LLog.m2577e(TAG, "LynxModuleFactory try to retainJniObject failed");
        destroy();
    }

    public long getNativePtr() {
        return this.mNativePtr;
    }

    private LynxModuleWrapper moduleWrapperForName(String str) {
        return getModule(str);
    }

    private void setNativePtr(long j) {
        this.mNativePtr = j;
    }

    public void destroy() {
        if (this.mHasDestroyed) {
            return;
        }
        this.mHasDestroyed = true;
        Map<String, LynxModuleWrapper> map = this.mModulesByName;
        if (map != null) {
            Iterator<LynxModuleWrapper> it = map.values().iterator();
            while (it.hasNext()) {
                it.next().destroy();
            }
        }
        if (this.mIsLynxViewDestroying) {
            UIThreadUtils.runOnUiThread(new Runnable() { // from class: com.lynx.jsbridge.LynxModuleFactory.1
                @Override // java.lang.Runnable
                public void run() {
                    if (LynxModuleFactory.this.mLynxViewClient != null) {
                        LLog.m2578i(LynxModuleFactory.TAG, "lynx invoke onLynxViewAndJSRuntimeDestroy");
                        LynxModuleFactory.this.mLynxViewClient.onLynxViewAndJSRuntimeDestroy();
                    }
                }
            });
        }
        this.mNativePtr = 0L;
        this.mModulesByName = null;
        this.mWrappers.clear();
    }
}
