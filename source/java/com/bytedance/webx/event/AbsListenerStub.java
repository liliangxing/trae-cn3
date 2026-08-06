package com.bytedance.webx.event;

import com.bytedance.webx.AbsExtension;
import com.bytedance.webx.context.IContext;
import com.bytedance.webx.context.IContextItem;

/* loaded from: classes6.dex */
public abstract class AbsListenerStub<T extends IContextItem> {
    private T mExtendable;
    private IContext mExtendableContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract AbsExtension getExtension();

    /* JADX INFO: Access modifiers changed from: protected */
    public T getExtendable() {
        if (this.mExtendable == null) {
            this.mExtendable = (T) getExtension().getExtendable();
        }
        return this.mExtendable;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public IContext getExtendableContext() {
        if (this.mExtendableContext == null) {
            this.mExtendableContext = getExtension().getContext();
        }
        return this.mExtendableContext;
    }
}
