package com.bytedance.sync;

import com.bytedance.sync.interfaze.ISendInterceptor;
import com.bytedance.sync.interfaze.OnDataUpdateListener;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class SyncBiz {
    public final long bizId;
    final ICommonParamProvider commonParamProvider;
    final List<OnDataUpdateListener> listeners;
    final List<ISendInterceptor> mSendListeners;

    public SyncBiz(Builder builder) {
        this.bizId = builder.businessId;
        this.commonParamProvider = builder.commonParamProvider;
        this.listeners = builder.listeners;
        this.mSendListeners = builder.sendListeners;
    }

    /* loaded from: classes5.dex */
    public static class Builder {
        private final long businessId;
        private ICommonParamProvider commonParamProvider;
        private final List<OnDataUpdateListener> listeners = new ArrayList();
        private final List<ISendInterceptor> sendListeners = new ArrayList();

        public Builder(long j) {
            this.businessId = j;
        }

        public Builder setCommonParam(ICommonParamProvider iCommonParamProvider) {
            this.commonParamProvider = iCommonParamProvider;
            return this;
        }

        public Builder addOnUpdateListener(OnDataUpdateListener onDataUpdateListener) {
            this.listeners.add(onDataUpdateListener);
            return this;
        }

        public Builder addSendInterceptor(ISendInterceptor iSendInterceptor) {
            this.sendListeners.add(iSendInterceptor);
            return this;
        }

        public SyncBiz build() {
            if (this.businessId < 0) {
                throw new IllegalArgumentException("bizId < 0");
            }
            return new SyncBiz(this);
        }
    }
}
