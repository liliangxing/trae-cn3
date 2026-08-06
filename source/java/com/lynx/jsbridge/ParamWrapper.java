package com.lynx.jsbridge;

/* loaded from: classes6.dex */
public class ParamWrapper {
    private Class<? extends LynxModule> mModuleClass;
    private String mName;
    private Object mParam;

    public String getName() {
        return this.mName;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public Class<? extends LynxModule> getModuleClass() {
        return this.mModuleClass;
    }

    public void setModuleClass(Class<? extends LynxModule> cls) {
        this.mModuleClass = cls;
    }

    public Object getParam() {
        return this.mParam;
    }

    public void setParam(Object obj) {
        this.mParam = obj;
    }

    public String toString() {
        return "[" + this.mModuleClass.getSimpleName() + " - " + this.mName + "]";
    }
}
