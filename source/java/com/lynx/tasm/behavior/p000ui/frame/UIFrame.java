package com.lynx.tasm.behavior.p000ui.frame;

import android.content.Context;
import android.graphics.Rect;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.LynxUpdateMeta;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.TemplateData;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.PropsConstants;
import com.lynx.tasm.behavior.p000ui.LynxBaseUI;
import com.lynx.tasm.behavior.p000ui.LynxUI;
import com.lynx.tasm.behavior.p000ui.UIBody;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class UIFrame extends LynxUI<LynxFrameView> {
    private static final String TAG = "UIFrame";

    public UIFrame(LynxContext lynxContext) {
        this(lynxContext, null);
    }

    public UIFrame(LynxContext lynxContext, Object obj) {
        super(lynxContext, obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.lynx.tasm.behavior.p000ui.LynxUI
    public LynxFrameView createView(Context context) {
        return new LynxFrameView(this.mContext);
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void updateExtraData(Object obj) {
        LynxFrameView view;
        if (!(obj instanceof TemplateBundle) || (view = getView()) == null) {
            return;
        }
        attachPageUICallback();
        view.loadBundle((TemplateBundle) obj);
    }

    private void attachPageUICallback() {
        LynxFrameView view = getView();
        if (view == null) {
            return;
        }
        view.setAttachLynxPageUICallback(new UIBody.UIBodyView.attachLynxPageUICallback() { // from class: com.lynx.tasm.behavior.ui.frame.UIFrame.1
            private final WeakReference<LynxBaseUI> mPageUI;

            {
                this.mPageUI = new WeakReference<>(UIFrame.this);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.lynx.tasm.behavior.ui.UIBody.UIBodyView.attachLynxPageUICallback
            public void attachLynxPageUI(WeakReference<Object> weakReference) {
                if (weakReference.get() instanceof UIBody) {
                    UIBody uIBody = (UIBody) weakReference.get();
                    if (uIBody.getLynxContext() == null) {
                        return;
                    }
                    uIBody.getLynxContext().EnsureEventDispatcher();
                    LynxBaseUI lynxBaseUI = this.mPageUI.get();
                    if (lynxBaseUI == null) {
                        return;
                    }
                    if (lynxBaseUI.getChildrenLynxPageUI() == null) {
                        lynxBaseUI.setChildrenLynxPageUI(new HashMap<>());
                    }
                    lynxBaseUI.getChildrenLynxPageUI().put(String.valueOf(System.identityHashCode(lynxBaseUI)), uIBody);
                    if (lynxBaseUI.getLynxContext() != null && lynxBaseUI.getLynxContext().getLynxUIOwner() != null && lynxBaseUI.getLynxContext().getLynxUIOwner().getRootUI() != null) {
                        uIBody.setParentLynxPageUI(lynxBaseUI.getLynxContext().getLynxUIOwner().getRootUI());
                    }
                    if (uIBody.getView() != 0) {
                        ((UIBody.UIBodyView) uIBody.getView()).setIsChildLynxPageUI(true);
                    }
                }
            }
        });
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void onNodeRemoved() {
        super.onNodeRemoved();
        LynxFrameView view = getView();
        if (view != null) {
            view.destroy();
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void updateLayout(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, Rect rect) {
        super.updateLayout(i, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16, rect);
        LynxFrameView view = getView();
        if (view != null) {
            view.updateViewport(i3, i4);
        }
    }

    @LynxProp(name = "data")
    public void setData(ReadableMap readableMap) {
        if (!(readableMap instanceof JavaOnlyMap)) {
            LLog.e(TAG, "prop date is not a JavaOnlyMap");
            return;
        }
        LynxFrameView view = getView();
        if (view == null) {
            return;
        }
        view.updateMetaData(new LynxUpdateMeta.Builder().setUpdatedData(TemplateData.fromMap((JavaOnlyMap) readableMap)).build());
    }

    @LynxProp(name = PropsConstants.SRC)
    public void setSrc(String str) {
        LynxFrameView view = getView();
        if (view == null) {
            return;
        }
        view.setUrl(str);
    }
}
