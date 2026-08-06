package com.lynx.tasm.behavior.p000ui.frame;

import android.content.Context;
import android.util.AttributeSet;
import com.lynx.tasm.LynxLoadMeta;
import com.lynx.tasm.LynxTemplateRender;
import com.lynx.tasm.LynxUpdateMeta;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.LynxViewBuilder;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.p000ui.UIBody;
import java.lang.ref.WeakReference;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class LynxFrameView extends UIBody.UIBodyView {
    private LynxTemplateRender mRender;
    private WeakReference<LynxView> mRootView;
    private String mUrl;

    public LynxFrameView(Context context) {
        super(context);
        this.mRootView = null;
        init(context);
    }

    public LynxFrameView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        init(context);
    }

    private void init(Context context) {
        LynxView uIBodyView = ((LynxContext) context).getUIBodyView();
        if (uIBodyView != null) {
            LynxViewBuilder lynxViewBuilder = uIBodyView.getLynxViewBuilder();
            this.mLynxUIRender = lynxViewBuilder.createLynxUIRenderer();
            this.mRender = new LynxTemplateRender(context, this, lynxViewBuilder);
            if (uIBodyView instanceof LynxView) {
                this.mRootView = new WeakReference<>(uIBodyView);
            } else if (uIBodyView instanceof LynxFrameView) {
                this.mRootView = new WeakReference<>(((LynxFrameView) uIBodyView).getRootView());
            }
        }
    }

    @Override // android.view.View
    public LynxView getRootView() {
        WeakReference<LynxView> weakReference = this.mRootView;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void loadBundle(TemplateBundle templateBundle) {
        LynxLoadMeta.Builder builder = new LynxLoadMeta.Builder();
        builder.setUrl(this.mUrl);
        builder.setTemplateBundle(templateBundle);
        this.mRender.loadTemplate(builder.build());
    }

    public void updateViewport(int i, int i2) {
        this.mRender.updateViewport(i, i2);
    }

    public void updateMetaData(LynxUpdateMeta lynxUpdateMeta) {
        this.mRender.updateMetaData(lynxUpdateMeta);
    }

    public void setUrl(String str) {
        this.mUrl = str;
    }

    @Override // com.lynx.tasm.behavior.ui.UIBody.UIBodyView
    public void runOnTasmThread(Runnable runnable) {
        this.mRender.runOnTasmThread(runnable);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        this.mRender.onMeasure(i, i2);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.mRender.onLayout(z, i, i2, i3, i4);
    }

    @Override // com.lynx.tasm.behavior.ui.UIBody.UIBodyView
    public void setAttachLynxPageUICallback(UIBody.UIBodyView.attachLynxPageUICallback attachlynxpageuicallback) {
        LynxTemplateRender lynxTemplateRender = this.mRender;
        if (lynxTemplateRender != null) {
            lynxTemplateRender.setAttachLynxPageUICallback(attachlynxpageuicallback);
        }
    }

    @Override // com.lynx.tasm.behavior.ui.UIBody.UIBodyView
    public LynxViewBuilder getLynxViewBuilder() {
        LynxTemplateRender lynxTemplateRender = this.mRender;
        if (lynxTemplateRender != null) {
            return lynxTemplateRender.getLynxViewBuilder();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void destroy() {
        this.mRender.destroy();
    }
}
