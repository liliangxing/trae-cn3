package com.bytedance.reparo.core;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class PatchConfigCell {
    private Class mConfigClass;
    private String mConfigClassDexPath;
    private List<Constructor> mConfigConstructors;
    private List<Method> mConfigMethods;

    public PatchConfigCell(Class cls, String str) {
        this.mConfigClass = cls;
        this.mConfigClassDexPath = str;
    }

    public void addConfigConstructor(Constructor constructor) {
        if (constructor != null) {
            if (this.mConfigConstructors == null) {
                this.mConfigConstructors = new ArrayList();
            }
            this.mConfigConstructors.add(constructor);
        }
    }

    public void addConfigMethod(Method method) {
        if (method != null) {
            if (this.mConfigMethods == null) {
                this.mConfigMethods = new ArrayList();
            }
            this.mConfigMethods.add(method);
        }
    }

    public Class getConfigClass() {
        return this.mConfigClass;
    }

    public String getConfigClassDexPath() {
        return this.mConfigClassDexPath;
    }

    public List<Constructor> getConfigConstructors() {
        return this.mConfigConstructors;
    }

    public List<Method> getConfigMethods() {
        return this.mConfigMethods;
    }
}
