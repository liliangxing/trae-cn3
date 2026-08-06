package com.bytedance.webx;

import com.bytedance.webx.context.IContext;
import com.bytedance.webx.context.IContextItem;
import com.bytedance.webx.core.IExtendableControl;
import com.bytedance.webx.event.AbsListenerStub;
import com.bytedance.webx.event.EventManager;

/* loaded from: classes6.dex */
public abstract class AbsExtension<T> implements IContextItem {
    public static CreateHelper sCreateHelper = new CreateHelper();
    protected IContext mContext;
    protected WebXEnv mEnv;
    private boolean mIsApproveDefault;
    private boolean mIsEnable = true;
    private String mName = null;
    private boolean mIsApprove = true;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void onCreateExtendable(CreateHelper createHelper);

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDestroyExtendable() {
    }

    /* loaded from: classes6.dex */
    public static class CreateHelper {
        public void bindExtension(IExtendableControl iExtendableControl, AbsExtension absExtension) {
            iExtendableControl.getExtendableContext().addExtensionInstance(absExtension);
        }

        public void bindExtensionNeverCast(IExtendableControl iExtendableControl, AbsExtension absExtension) {
            iExtendableControl.getExtendableContext().addExtensionInstanceNeverCast(absExtension);
        }
    }

    public void init(WebXEnv webXEnv) {
        this.mEnv = webXEnv;
    }

    public void setContext(IContext iContext) {
        this.mContext = iContext;
    }

    public IContext getContext() {
        return this.mContext;
    }

    public T getExtendable() {
        return (T) getContext().getOrigin();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void afterCreateExtendable() {
        this.mIsApproveDefault = this.mIsApprove;
    }

    public void initMatchable(String str) {
        this.mName = str;
    }

    protected void register(String str, AbsListenerStub absListenerStub) {
        EventManager.register(this.mContext, str, absListenerStub);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void register(String str, AbsListenerStub absListenerStub, int i) {
        EventManager.register(this.mContext, str, absListenerStub, i);
    }

    public void setEnable(boolean z) {
        this.mIsEnable = z;
    }

    public boolean isEnable() {
        return this.mIsEnable;
    }

    public String getName() {
        return this.mName;
    }

    public boolean isMatchable() {
        return this.mName != null;
    }

    public void setApprove(boolean z) {
        this.mIsApprove = z;
    }

    public boolean isApprove() {
        return this.mIsApprove;
    }

    public boolean getApproveDefault() {
        return this.mIsApproveDefault;
    }
}
