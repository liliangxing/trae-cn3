package com.bytedance.push.third;

import com.bytedance.common.utility.StringUtils;
import com.bytedance.push.third.pushchannelsupport.BaseChannelSupportHelper;
import com.bytedance.push.utils.Logger;
import com.bytedance.push.utils.Singleton;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class PushChannel extends Singleton<IPushChannel> implements IPushChannel {
    private String mAdapterName;
    private BaseChannelSupportHelper mBaseChannelSupportHelper;
    private int mChannelId;
    private IPushAdapter mIPushAdapter;
    private String mSenderName;
    private boolean mIsSupport = false;
    private boolean mInited = false;

    @Override // com.bytedance.push.third.IPushChannel
    public boolean isSupport() {
        Logger.m274i("PushChannel", "[isSupport]channelId:" + this.mChannelId + " mInited:" + this.mInited + " mIsSupport:" + this.mIsSupport);
        if (!this.mInited) {
            this.mIsSupport = this.mBaseChannelSupportHelper.isSupportChannel(this.mIPushAdapter, this.mChannelId);
            Logger.m274i("PushChannel", "[isSupport]channelId:" + this.mChannelId + " mBaseChannelSupportHelper:" + this.mBaseChannelSupportHelper + " mIPushAdapter:" + this.mIPushAdapter + " invoke isSupportChannel result:" + this.mIsSupport);
            this.mInited = true;
        }
        return this.mIsSupport;
    }

    @Override // com.bytedance.push.third.IPushChannel
    public IPushAdapter getAdapterInstance() {
        return this.mIPushAdapter;
    }

    public PushChannel(int i, String str, String str2, BaseChannelSupportHelper baseChannelSupportHelper) {
        this.mChannelId = i;
        this.mAdapterName = str;
        this.mSenderName = str2;
        this.mBaseChannelSupportHelper = baseChannelSupportHelper;
    }

    @Override // com.bytedance.push.third.IPushChannel
    public String getChannelClassName() {
        return this.mAdapterName;
    }

    @Override // com.bytedance.push.third.IPushChannel
    public String getSenderName() {
        return this.mSenderName;
    }

    @Override // com.bytedance.push.third.IPushChannel
    public void resetInitStatus() {
        this.mInited = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.push.utils.Singleton
    public IPushChannel create(Object... objArr) {
        if (StringUtils.isEmpty(this.mAdapterName)) {
            return this;
        }
        try {
            Object newInstance = Class.forName(this.mAdapterName).newInstance();
            if (newInstance instanceof IPushAdapter) {
                this.mIPushAdapter = (IPushAdapter) newInstance;
            }
            Logger.m274i("PushManager", "load PushManagerImpl success: " + this.mAdapterName);
        } catch (Throwable th) {
            Logger.m271e("PushManager", "load PushManagerImpl exception: " + this.mAdapterName + " exception is:" + th);
        }
        return this;
    }
}
