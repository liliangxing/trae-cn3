package com.bytedance.vmsdk.jsbridge;

/* loaded from: classes6.dex */
public class ParamWrapper {
    private Class<? extends JSModule> moduleClass;
    private String name;
    private Object param;

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public Class<? extends JSModule> getModuleClass() {
        return this.moduleClass;
    }

    public void setModuleClass(Class<? extends JSModule> cls) {
        this.moduleClass = cls;
    }

    public Object getParam() {
        return this.param;
    }

    public void setParam(Object obj) {
        this.param = obj;
    }

    public String toString() {
        return "[" + this.moduleClass.getSimpleName() + " - " + this.name + "]";
    }
}
