package com.lynx.tasm.behavior.p000ui.image;

import com.lynx.tasm.LynxError;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.p000ui.text.AbsInlineImageSpan;
import com.lynx.tasm.behavior.shadow.text.AbsInlineImageShadowNode;
import com.lynx.tasm.utils.UIThreadUtils;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class InlineImageShadowNode extends AbsInlineImageShadowNode {
    LynxImageManager mLynxImageManager;

    @Override // com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode, com.lynx.tasm.behavior.shadow.ShadowNode
    public void setContext(LynxContext lynxContext) {
        super.setContext(lynxContext);
        this.mLynxImageManager = new LynxImageManager(this.mContext) { // from class: com.lynx.tasm.behavior.ui.image.InlineImageShadowNode.1
            @Override // com.lynx.tasm.behavior.p000ui.image.LynxImageManager
            public void invalidate() {
                InlineImageShadowNode.this.markDirty();
            }

            @Override // com.lynx.tasm.behavior.p000ui.image.LynxImageManager
            protected void onImageLoadSuccess(int i, int i2) {
                InlineImageShadowNode.this.notifyLoadSuccessIfNeeded(i, i2);
            }

            @Override // com.lynx.tasm.behavior.p000ui.image.LynxImageManager
            protected void onImageLoadError(LynxError lynxError, int i, int i2) {
                InlineImageShadowNode.this.notifyErrorIfNeeded(lynxError.getSummaryMessage());
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    public void onDestroy() {
        super.onDestroy();
        UIThreadUtils.runOnUiThreadImmediately(new Runnable() { // from class: com.lynx.tasm.behavior.ui.image.InlineImageShadowNode.2
            @Override // java.lang.Runnable
            public void run() {
                if (InlineImageShadowNode.this.mLynxImageManager != null) {
                    InlineImageShadowNode.this.mLynxImageManager.destroy();
                }
            }
        });
    }

    @Override // com.lynx.tasm.behavior.shadow.text.AbsInlineImageShadowNode
    public void setSource(String str) {
        this.mLynxImageManager.setSrc(str);
    }

    @Override // com.lynx.tasm.behavior.shadow.text.AbsInlineImageShadowNode
    public void setMode(String str) {
        this.mLynxImageManager.setMode(str);
    }

    @Override // com.lynx.tasm.behavior.shadow.text.AbsInlineImageShadowNode
    public AbsInlineImageSpan generateInlineImageSpan() {
        return new InlineImageSpan((int) Math.ceil(getStyle().getWidth()), (int) Math.ceil(getStyle().getHeight()), getStyle().getMargins(), this.mLynxImageManager);
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    public void onAfterUpdateTransaction() {
        this.mLynxImageManager.updateRedirectCheckResult();
        markDirty();
    }
}
