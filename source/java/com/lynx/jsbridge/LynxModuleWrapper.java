package com.lynx.jsbridge;

import android.content.Context;
import com.lynx.jsbridge.LynxModule;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.LynxSubErrorCode;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.utils.UIThreadUtils;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class LynxModuleWrapper {
    private static final String TAG = "LynxModuleWrapper";
    private LynxModule.AuthValidator mAuthValidator;
    private final LynxModule mModule;
    private final String mName;
    private WeakReference<Context> mWeakContext;
    private final ArrayList<MethodDescriptor> mDescriptors = new ArrayList<>();
    private final ArrayList<AttributeDescriptor> mAttributeDescriptors = new ArrayList<>();

    public LynxModuleWrapper(String str, LynxModule lynxModule) {
        this.mName = str;
        this.mModule = lynxModule;
    }

    public void setLynxContext(WeakReference<Context> weakReference) {
        this.mWeakContext = weakReference;
    }

    public LynxModule getModule() {
        return this.mModule;
    }

    public String getName() {
        return this.mName;
    }

    public void setAuthValidator(LynxModule.AuthValidator authValidator) {
        this.mAuthValidator = authValidator;
    }

    public boolean hasAuthValidator() {
        return this.mAuthValidator != null;
    }

    public boolean verify(String str, String str2, JavaOnlyArray javaOnlyArray) {
        LynxModule.AuthValidator authValidator = this.mAuthValidator;
        if (authValidator == null) {
            return true;
        }
        return authValidator.verify(str, str2, javaOnlyArray);
    }

    private void findMethods() {
        HashSet hashSet = new HashSet();
        for (Method method : this.mModule.getClass().getDeclaredMethods()) {
            if (((LynxMethod) method.getAnnotation(LynxMethod.class)) != null) {
                String name = method.getName();
                if (hashSet.contains(name)) {
                    throw new IllegalArgumentException("Java Module " + getName() + " method name already registered: " + name);
                }
                hashSet.add(name);
                MethodDescriptor methodDescriptor = new MethodDescriptor();
                LynxMethodWrapper lynxMethodWrapper = new LynxMethodWrapper(method);
                methodDescriptor.name = name;
                methodDescriptor.signature = lynxMethodWrapper.getSignature();
                methodDescriptor.method = method;
                this.mDescriptors.add(methodDescriptor);
            }
        }
    }

    private void findAttributes() {
        HashSet hashSet = new HashSet();
        for (Field field : this.mModule.getClass().getDeclaredFields()) {
            if (((LynxAttribute) field.getAnnotation(LynxAttribute.class)) != null) {
                String name = field.getName();
                if (hashSet.contains(name)) {
                    throw new IllegalArgumentException("Java Module " + getName() + " attribute name already registered: " + name);
                }
                hashSet.add(name);
                JavaOnlyArray javaOnlyArray = new JavaOnlyArray();
                try {
                    javaOnlyArray.add(field.get(this.mModule));
                } catch (IllegalAccessException e) {
                    LLog.m2577e(TAG, e.toString());
                }
                this.mAttributeDescriptors.add(new AttributeDescriptor(name, javaOnlyArray));
            }
        }
    }

    public Collection<MethodDescriptor> getMethodDescriptors() {
        if (this.mDescriptors.isEmpty()) {
            try {
                findMethods();
            } catch (RuntimeException e) {
                UIThreadUtils.runOnUiThread(new Runnable() { // from class: com.lynx.jsbridge.LynxModuleWrapper.1
                    @Override // java.lang.Runnable
                    public void run() {
                        LynxContext lynxContext;
                        if (LynxModuleWrapper.this.mWeakContext == null || (lynxContext = (Context) LynxModuleWrapper.this.mWeakContext.get()) == null || !(lynxContext instanceof LynxContext)) {
                            return;
                        }
                        LynxError lynxError = new LynxError(LynxSubErrorCode.E_NATIVE_MODULES_EXCEPTION, "NativeModules: GetMethodDescriptors error!moduleName: " + LynxModuleWrapper.this.mName + " exception: " + e.toString());
                        lynxError.setLogBoxOnly(true);
                        lynxContext.handleLynxError(lynxError);
                    }
                });
                LLog.m2577e(TAG, e.toString());
            }
        }
        return this.mDescriptors;
    }

    public Collection<AttributeDescriptor> getAttributeDescriptor() {
        if (this.mAttributeDescriptors.isEmpty()) {
            try {
                findAttributes();
            } catch (RuntimeException e) {
                UIThreadUtils.runOnUiThread(new Runnable() { // from class: com.lynx.jsbridge.LynxModuleWrapper.2
                    @Override // java.lang.Runnable
                    public void run() {
                        LynxContext lynxContext;
                        if (LynxModuleWrapper.this.mWeakContext == null || (lynxContext = (Context) LynxModuleWrapper.this.mWeakContext.get()) == null || !(lynxContext instanceof LynxContext)) {
                            return;
                        }
                        LynxError lynxError = new LynxError(LynxSubErrorCode.E_NATIVE_MODULES_EXCEPTION, "NativeModules: getAttributeDescriptors error!moduleName: " + LynxModuleWrapper.this.mName + " exception: " + e.toString());
                        lynxError.setLogBoxOnly(true);
                        lynxContext.handleLynxError(lynxError);
                    }
                });
                LLog.m2577e(TAG, e.toString());
            }
        }
        return this.mAttributeDescriptors;
    }

    public void destroy() {
        LynxModule lynxModule = this.mModule;
        if (lynxModule != null) {
            lynxModule.destroy();
        }
    }
}
