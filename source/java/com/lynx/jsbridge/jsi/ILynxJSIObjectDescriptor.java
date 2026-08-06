package com.lynx.jsbridge.jsi;

/* loaded from: classes6.dex */
public interface ILynxJSIObjectDescriptor {
    String getClassName();

    String[] getFields();

    String[] getLynxObjectDescriptorInfo(String str);

    void warmUp();
}
