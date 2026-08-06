package com.lynx.jsbridge.jsi;

import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes6.dex */
public abstract class AbsLynxJSIObjectDescriptor implements ILynxJSIObjectDescriptor {
    private volatile String[] mFields = null;
    private volatile ConcurrentHashMap<String, LynxJSPropertyDescriptor> mFieldInfos = null;

    protected abstract ConcurrentHashMap<String, LynxJSPropertyDescriptor> createFieldInfos();

    @Override // com.lynx.jsbridge.jsi.ILynxJSIObjectDescriptor
    public abstract String getClassName();

    @Override // com.lynx.jsbridge.jsi.ILynxJSIObjectDescriptor
    public String[] getFields() {
        String[] strArr;
        ensureFieldInfos();
        if (this.mFields != null) {
            return this.mFields;
        }
        synchronized (this) {
            if (this.mFields == null) {
                this.mFields = (String[]) this.mFieldInfos.keySet().toArray(new String[0]);
            }
            strArr = this.mFields;
        }
        return strArr;
    }

    @Override // com.lynx.jsbridge.jsi.ILynxJSIObjectDescriptor
    public String[] getLynxObjectDescriptorInfo(String str) {
        ensureFieldInfos();
        LynxJSPropertyDescriptor lynxJSPropertyDescriptor = this.mFieldInfos.get(str);
        if (lynxJSPropertyDescriptor != null) {
            return new String[]{lynxJSPropertyDescriptor.fieldName, lynxJSPropertyDescriptor.fieldJNIDescriptor};
        }
        return null;
    }

    private void ensureFieldInfos() {
        if (this.mFieldInfos != null) {
            return;
        }
        synchronized (this) {
            if (this.mFieldInfos != null) {
                return;
            }
            this.mFieldInfos = createFieldInfos();
        }
    }

    @Override // com.lynx.jsbridge.jsi.ILynxJSIObjectDescriptor
    public void warmUp() {
        ensureFieldInfos();
    }
}
