package com.lynx.jsbridge;

import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.LynxUpdateMeta;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.TemplateData;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.group.ILynxViewGroup;
import com.lynx.tasm.utils.UIThreadUtils;
import java.lang.ref.WeakReference;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class LynxEmbeddedModule extends LynxContextModule {
    public static final String NAME = "LynxEmbeddedModule";
    private WeakReference<ILynxViewGroup> mLynxViewGroupRef;

    public LynxEmbeddedModule(LynxContext lynxContext, Object obj) {
        super(lynxContext);
        if (obj instanceof ILynxViewGroup) {
            this.mLynxViewGroupRef = new WeakReference<>((ILynxViewGroup) obj);
        }
    }

    private LynxView getLynxViewById(int i) {
        ILynxViewGroup iLynxViewGroup;
        WeakReference<ILynxViewGroup> weakReference = this.mLynxViewGroupRef;
        if (weakReference == null || (iLynxViewGroup = weakReference.get()) == null) {
            return null;
        }
        return iLynxViewGroup.getLynxViewById(i);
    }

    @LynxMethod
    public void updateData(int i, final ReadableMap readableMap, final Callback callback, Callback callback2) {
        final LynxView lynxViewById = getLynxViewById(i);
        if (lynxViewById == null) {
            JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
            javaOnlyMap.put("message", "Cannot get related lynxView (ID: " + i + ")");
            callback2.invoke(javaOnlyMap);
            return;
        }
        UIThreadUtils.runOnUiThread(new Runnable() { // from class: com.lynx.jsbridge.LynxEmbeddedModule.1
            @Override // java.lang.Runnable
            public void run() {
                lynxViewById.updateMetaData(new LynxUpdateMeta.Builder().setUpdatedData(TemplateData.fromMap(readableMap.asHashMap())).build());
                callback.invoke(new Object[0]);
            }
        });
    }

    @LynxMethod
    public void getData(int i, final Callback callback, Callback callback2) {
        final LynxView lynxViewById = getLynxViewById(i);
        if (lynxViewById == null) {
            JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
            javaOnlyMap.put("message", "Cannot get related lynxView (ID: " + i + ")");
            callback2.invoke(javaOnlyMap);
            return;
        }
        UIThreadUtils.runOnUiThread(new Runnable() { // from class: com.lynx.jsbridge.LynxEmbeddedModule.2
            @Override // java.lang.Runnable
            public void run() {
                callback.invoke(lynxViewById.getTemplateData());
            }
        });
    }

    @LynxMethod
    public void setDataV2(final ReadableMap readableMap, final Callback callback, Callback callback2) {
        final LynxView lynxView = this.mLynxContext.getLynxView();
        if (lynxView == null) {
            JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
            javaOnlyMap.put("message", "Cannot get related lynxView.");
            callback2.invoke(javaOnlyMap);
            return;
        }
        UIThreadUtils.runOnUiThreadImmediately(new Runnable() { // from class: com.lynx.jsbridge.LynxEmbeddedModule.3
            @Override // java.lang.Runnable
            public void run() {
                lynxView.updateMetaData(new LynxUpdateMeta.Builder().setUpdatedData(TemplateData.fromMap(readableMap.asHashMap())).build());
                callback.invoke(new Object[0]);
            }
        });
    }

    @LynxMethod
    public void getDataV2(final Callback callback, Callback callback2) {
        final LynxView lynxView = this.mLynxContext.getLynxView();
        if (lynxView == null) {
            JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
            javaOnlyMap.put("message", "Cannot get related lynxView.");
            callback2.invoke(javaOnlyMap);
            return;
        }
        UIThreadUtils.runOnUiThreadImmediately(new Runnable() { // from class: com.lynx.jsbridge.LynxEmbeddedModule.4
            @Override // java.lang.Runnable
            public void run() {
                callback.invoke(lynxView.getTemplateData());
            }
        });
    }
}
