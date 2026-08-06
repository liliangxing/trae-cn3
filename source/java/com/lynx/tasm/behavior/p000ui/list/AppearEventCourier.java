package com.lynx.tasm.behavior.p000ui.list;

import androidx.recyclerview.widget.RecyclerView;
import com.lynx.tasm.EventEmitter;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class AppearEventCourier implements AppearEventCourierInterface {
    private EventEmitter mEventEmitter;
    private AppearEventCourierInterface mImpl;
    private RecyclerView mRecyclerView;
    private boolean mUseNew = false;

    public AppearEventCourier(EventEmitter eventEmitter, RecyclerView recyclerView) {
        this.mEventEmitter = eventEmitter;
        this.mRecyclerView = recyclerView;
        this.mImpl = new AppearEventCourierImpl(eventEmitter);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void setNewAppear(boolean z) {
        if (z == this.mUseNew) {
            return;
        }
        this.mUseNew = z;
        if (z) {
            this.mImpl = new AppearEventCourierImplV2(this.mEventEmitter, this.mRecyclerView);
        } else {
            this.mImpl = new AppearEventCourierImpl(this.mEventEmitter);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void setDisappear(boolean z) {
        AppearEventCourierInterface appearEventCourierInterface = this.mImpl;
        if (appearEventCourierInterface instanceof AppearEventCourierImpl) {
            ((AppearEventCourierImpl) appearEventCourierInterface).setDisappear(z);
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.list.AppearEventCourierInterface
    public void onListNodeAttached(ListViewHolder listViewHolder) {
        this.mImpl.onListNodeAttached(listViewHolder);
    }

    @Override // com.lynx.tasm.behavior.p000ui.list.AppearEventCourierInterface
    public void onListNodeDetached(ListViewHolder listViewHolder) {
        this.mImpl.onListNodeDetached(listViewHolder);
    }

    @Override // com.lynx.tasm.behavior.p000ui.list.AppearEventCourierInterface
    public void holderAttached(ListViewHolder listViewHolder) {
        this.mImpl.holderAttached(listViewHolder);
    }

    @Override // com.lynx.tasm.behavior.p000ui.list.AppearEventCourierInterface
    public void onListLayout() {
        this.mImpl.onListLayout();
    }
}
