package com.lynx.canvas;

import android.content.Context;
import android.view.MotionEvent;
import com.lynx.tasm.DefaultLogicExecutor;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.krypton.ICanvasManager;
import com.lynx.tasm.behavior.ui.krypton.LynxKryptonHelper;
import com.lynx.tasm.behavior.ui.krypton.LynxKryptonModule;
import com.lynx.tasm.event.LynxEventDetail;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class UISurfaceCanvas extends LynxUI<UICanvasSurfaceView> {
    private static final String TAG = "UISurfaceCanvas";
    private String mName;

    public boolean dispatchEvent(LynxEventDetail lynxEventDetail) {
        return false;
    }

    public UISurfaceCanvas(LynxContext lynxContext) {
        this(lynxContext, null);
    }

    public UISurfaceCanvas(LynxContext lynxContext, Object obj) {
        super(lynxContext, obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public UICanvasSurfaceView createView(Context context) {
        if (getOrTryCreateCanvasManager() != null) {
            this.mView = new UICanvasSurfaceView(context);
            return (UICanvasSurfaceView) this.mView;
        }
        throw new RuntimeException("Canvas environment has not setup!!");
    }

    public void destroy() {
        super.destroy();
        ((UICanvasSurfaceView) this.mView).destroy();
    }

    public void layout() {
        super.layout();
        ((UICanvasSurfaceView) this.mView).notifyLayout(getBoundingClientRect());
    }

    @LynxProp(name = DefaultLogicExecutor.GLOBAL_EVENT_NAME)
    public void setName(String str) {
        super.setName(str);
        LynxKryptonModule extensionModuleByKey = getLynxContext().getExtensionModuleByKey("LynxKryptonModule");
        if (extensionModuleByKey == null) {
            return;
        }
        LynxKryptonHelper lynxKryptonHelper = extensionModuleByKey.getLynxKryptonHelper();
        if (str == null || lynxKryptonHelper == null) {
            return;
        }
        ((UICanvasSurfaceView) this.mView).setup(str, ((CanvasManager) lynxKryptonHelper.getCanvasManager()).getKryptonApp());
        if (this.mName == null) {
            this.mName = str;
            String str2 = "url:" + getLynxContext().getTemplateUrl() + ", tag_name:" + str;
            LLog.m2578i(TAG, "set tag to canvas view: " + str2);
            ((UICanvasSurfaceView) this.mView).setTag(str2);
        }
    }

    public boolean dispatchTouch(MotionEvent motionEvent) {
        if (!isUserInteractionEnabled()) {
            return false;
        }
        return ((UICanvasSurfaceView) this.mView).dispatchTouch(motionEvent, getLynxContext().getUIBody().getBoundingClientRect(), getBoundingClientRect());
    }

    private CanvasManager getOrTryCreateCanvasManager() {
        LynxKryptonHelper lynxKryptonHelper;
        getLynxContext();
        LynxKryptonModule extensionModuleByKey = getLynxContext().getExtensionModuleByKey("LynxKryptonModule");
        if (extensionModuleByKey == null || (lynxKryptonHelper = extensionModuleByKey.getLynxKryptonHelper()) == null) {
            return null;
        }
        ICanvasManager canvasManager = lynxKryptonHelper.getCanvasManager();
        if (canvasManager != null) {
            LLog.m2578i(TAG, "Canvas manager is already created.");
            return (CanvasManager) canvasManager;
        }
        LLog.m2578i(TAG, "Setup canvas environment from UISurfaceCanvas in lazy mode.");
        lynxKryptonHelper.setupCanvasIfCanvasViewCreated();
        return (CanvasManager) lynxKryptonHelper.getCanvasManager();
    }
}
