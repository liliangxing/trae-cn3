package com.bytedance.vmsdk.jsbridge;

import android.util.Log;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyArray;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class JSModuleWrapper {
    private static final String TAG = "VmsdkModuleWrapper";
    private final JSModule mModule;
    private final String mName;
    private final ArrayList<MethodDescriptor> mDescriptors = new ArrayList<>();
    private final ArrayList<AttributeDescriptor> mAttributeDescriptors = new ArrayList<>();

    public JSModuleWrapper(String str, JSModule jSModule) {
        this.mName = str;
        this.mModule = jSModule;
    }

    public JSModule getModule() {
        return this.mModule;
    }

    public String getName() {
        return this.mName;
    }

    private void findMethods() {
        HashSet hashSet = new HashSet();
        for (Method method : this.mModule.getClass().getDeclaredMethods()) {
            if (((JSMethod) method.getAnnotation(JSMethod.class)) != null) {
                String name = method.getName();
                if (hashSet.contains(name)) {
                    throw new IllegalArgumentException("Java Module " + getName() + " method name already registered: " + name);
                }
                hashSet.add(name);
                MethodDescriptor methodDescriptor = new MethodDescriptor();
                JSMethodWrapper jSMethodWrapper = new JSMethodWrapper(method);
                methodDescriptor.name = name;
                methodDescriptor.signature = jSMethodWrapper.getSignature();
                methodDescriptor.method = method;
                this.mDescriptors.add(methodDescriptor);
            }
        }
    }

    private void findAttributes() {
        HashSet hashSet = new HashSet();
        for (Field field : this.mModule.getClass().getDeclaredFields()) {
            if (((JSAttribute) field.getAnnotation(JSAttribute.class)) != null) {
                String name = field.getName();
                if (hashSet.contains(name)) {
                    throw new IllegalArgumentException("Java Module " + getName() + " attribute name already registered: " + name);
                }
                hashSet.add(name);
                AttributeDescriptor attributeDescriptor = new AttributeDescriptor();
                attributeDescriptor.name = name;
                attributeDescriptor.value = new JavaOnlyArray();
                try {
                    attributeDescriptor.value.add(field.get(this.mModule));
                } catch (IllegalAccessException e) {
                    Log.e(TAG, e.toString());
                }
                this.mAttributeDescriptors.add(attributeDescriptor);
            }
        }
    }

    public Collection<MethodDescriptor> getMethodDescriptors() {
        if (this.mDescriptors.isEmpty()) {
            try {
                findMethods();
            } catch (RuntimeException e) {
                Log.e(TAG, e.toString());
            }
        }
        return this.mDescriptors;
    }

    public Collection<AttributeDescriptor> getAttributeDescriptor() {
        if (this.mAttributeDescriptors.isEmpty()) {
            try {
                findAttributes();
            } catch (RuntimeException e) {
                Log.e(TAG, e.toString());
            }
        }
        return this.mAttributeDescriptors;
    }
}
