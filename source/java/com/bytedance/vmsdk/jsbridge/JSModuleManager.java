package com.bytedance.vmsdk.jsbridge;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes6.dex */
public class JSModuleManager {
    Context mContext;
    ConcurrentHashMap<String, JSModuleWrapper> mModulesByName;
    private final ConcurrentHashMap<String, ParamWrapper> wrappers = new ConcurrentHashMap<>();

    public JSModuleManager(Context context) {
        this.mContext = context;
    }

    public void registerModule(String str, Class<? extends JSModule> cls, Object obj) {
        ParamWrapper paramWrapper = new ParamWrapper();
        paramWrapper.setName(str);
        paramWrapper.setModuleClass(cls);
        paramWrapper.setParam(obj);
        ParamWrapper paramWrapper2 = this.wrappers.get(str);
        if (paramWrapper2 != null) {
            Log.e("VmsdkModuleManager", "Duplicated VmsdkModule For Name: " + str + ", " + paramWrapper2 + " will be override");
        }
        this.wrappers.put(str, paramWrapper);
        Log.v("VmsdkModuleManager", "registered module with name: " + str + " class" + cls);
    }

    public void addModuleParamWrapper(List<ParamWrapper> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        for (ParamWrapper paramWrapper : list) {
            String name = paramWrapper.getName();
            ParamWrapper paramWrapper2 = this.wrappers.get(name);
            if (paramWrapper2 != null) {
                Log.e("VmsdkModuleManager", "Duplicated VmsdkModule For Name: " + name + ", " + paramWrapper2 + " will be override");
            }
            this.wrappers.put(name, paramWrapper);
        }
    }

    private void getModuleExceptionReport(Exception exc) {
        Log.e("VmsdkModuleManager", "get Module failed" + exc);
    }

    public JSModuleWrapper getModule(String str) {
        JSModule jSModule;
        if (str == null) {
            Log.e("VmsdkModuleManager", "getModule failed, name is null");
            return null;
        }
        if (this.mModulesByName == null) {
            this.mModulesByName = new ConcurrentHashMap<>();
        }
        if (this.mModulesByName.get(str) != null) {
            return this.mModulesByName.get(str);
        }
        ParamWrapper paramWrapper = this.wrappers.get(str);
        if (paramWrapper == null) {
            return null;
        }
        Class<? extends JSModule> moduleClass = paramWrapper.getModuleClass();
        try {
        } catch (IllegalAccessException e) {
            getModuleExceptionReport(e);
        } catch (InstantiationException e2) {
            getModuleExceptionReport(e2);
        } catch (NoSuchMethodException e3) {
            getModuleExceptionReport(e3);
        } catch (InvocationTargetException e4) {
            getModuleExceptionReport(e4);
        } catch (Exception e5) {
            getModuleExceptionReport(e5);
        }
        if (paramWrapper.getParam() == null) {
            for (Constructor<?> constructor : moduleClass.getConstructors()) {
                Class<?>[] parameterTypes = constructor.getParameterTypes();
                if (parameterTypes.length == 1 && Context.class.equals(parameterTypes[0])) {
                    jSModule = (JSModule) constructor.newInstance(this.mContext);
                    break;
                }
                if (parameterTypes.length == 2 && Context.class.equals(parameterTypes[0]) && Object.class.equals(parameterTypes[1])) {
                    jSModule = (JSModule) constructor.newInstance(this.mContext, null);
                    break;
                }
            }
            jSModule = null;
        } else {
            if (moduleClass != null) {
                jSModule = moduleClass.getConstructor(Context.class, Object.class).newInstance(this.mContext, paramWrapper.getParam());
            }
            jSModule = null;
        }
        if (jSModule == null) {
            Log.v("VmsdkModuleManager", "getModule" + str + "failed");
            return null;
        }
        JSModuleWrapper jSModuleWrapper = new JSModuleWrapper(str, jSModule);
        this.mModulesByName.put(str, jSModuleWrapper);
        return jSModuleWrapper;
    }

    private JSModuleWrapper moduleWrapperForName(String str) {
        return getModule(str);
    }

    public void destroy() {
        this.mContext = null;
        ConcurrentHashMap<String, JSModuleWrapper> concurrentHashMap = this.mModulesByName;
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
            this.mModulesByName = null;
        }
        this.wrappers.clear();
    }
}
