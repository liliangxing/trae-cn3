package com.bytedance.ug.sdk.share.impl.share.exposure;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.ug.sdk.share.api.callback.ExposedPanelActionCallback;
import com.bytedance.ug.sdk.share.api.callback.ExposedPanelItemsCallback;
import com.bytedance.ug.sdk.share.api.callback.IExecuteListener;
import com.bytedance.ug.sdk.share.api.callback.ShareInfoCallback;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.bytedance.ug.sdk.share.api.p008ui.IShareProgressView;
import com.bytedance.ug.sdk.share.api.panel.ShareChannelType;
import com.bytedance.ug.sdk.share.api.panel.exposure.ExposedPanelContent;
import com.bytedance.ug.sdk.share.impl.config.ShareConfigManager;
import com.bytedance.ug.sdk.share.impl.event.MonitorEvent;
import com.bytedance.ug.sdk.share.impl.event.ShareEvent;
import com.bytedance.ug.sdk.share.impl.manager.ShareSdkManager;
import com.bytedance.ug.sdk.share.impl.network.model.ShareInfo;
import com.bytedance.ug.sdk.share.impl.share.StrategyDispatcher;
import com.bytedance.ug.sdk.share.impl.utils.Logger;
import com.bytedance.ug.sdk.share.impl.utils.ShareUtils;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ExposedShare {
    private Activity mActivity;
    private JSONObject mData;
    private boolean mDisableGetShareInfo;
    private boolean mIsForceUpdate;
    private ExposedPanelActionCallback mPanelActionCallback;
    private ExposedPanelContent mPanelContent;
    private String mPanelId;
    private ExposedPanelItemsCallback mPanelItemsCallback;
    protected IShareProgressView mProgressDialog;
    private String mResourceId;
    private ShareContent mShareContent;

    public ExposedShare(ExposedPanelContent exposedPanelContent) {
        MonitorEvent.mPanelClickTime = System.currentTimeMillis();
        if (exposedPanelContent == null) {
            return;
        }
        this.mPanelContent = exposedPanelContent;
        this.mActivity = exposedPanelContent.getActivity();
        this.mPanelId = this.mPanelContent.getPanelId();
        this.mResourceId = this.mPanelContent.getResourceId();
        ShareContent shareContent = this.mPanelContent.getShareContent();
        this.mShareContent = shareContent;
        shareContent.setFrom("exposed");
        this.mShareContent.setPanelId(this.mPanelId);
        this.mShareContent.setResourceId(this.mResourceId);
        this.mData = this.mPanelContent.getData();
        this.mDisableGetShareInfo = this.mPanelContent.isDisableGetShareInfo();
        this.mPanelActionCallback = this.mPanelContent.getPanelActionCallback();
        this.mPanelItemsCallback = this.mPanelContent.getItemsCallback();
        this.mIsForceUpdate = this.mPanelContent.isForceUpdate();
    }

    public void share() {
        ShareEvent.sendShowPanelEvent(this.mShareContent);
        ShareEvent.sendShareChannelClick(this.mShareContent, true);
        MonitorEvent.monitorPanelClick(0, System.currentTimeMillis() - MonitorEvent.mPanelClickTime);
        ShareContent shareContent = this.mShareContent;
        if (shareContent == null) {
            return;
        }
        ShareSdkManager.getInstance().setCurrentShareChannelType(shareContent.getShareChanelType());
        ShareUtils.appendShareToken(this.mShareContent);
        if (isNeedGetShareInfo()) {
            getShareInfo();
        } else {
            doShare();
        }
    }

    private boolean isNeedGetShareInfo() {
        if (this.mDisableGetShareInfo) {
            return false;
        }
        return this.mIsForceUpdate || this.mPanelContent.getShareInfoList() == null || this.mPanelContent.getShareInfoList().size() == 0;
    }

    private void getShareInfo() {
        ExposedPanelActionCallback exposedPanelActionCallback = this.mPanelActionCallback;
        if (exposedPanelActionCallback != null && !exposedPanelActionCallback.showLoading()) {
            showLoadingView();
        }
        ShareSdkManager.getInstance().getShareInfo(this.mPanelId, this.mResourceId, this.mShareContent.getShareToken(), this.mShareContent, this.mData, new ShareInfoCallback() { // from class: com.bytedance.ug.sdk.share.impl.share.exposure.ExposedShare.1
            @Override // com.bytedance.ug.sdk.share.api.callback.ShareInfoCallback
            public void onSuccess(List<ShareInfo> list) {
                ExposedShare.this.mPanelContent.setShareInfoList(list);
                if (ExposedShare.this.mPanelActionCallback != null && !ExposedShare.this.mPanelActionCallback.dismissLoading()) {
                    ExposedShare.this.dismissLoadingView();
                }
                ExposedShare.this.doShare();
            }

            @Override // com.bytedance.ug.sdk.share.api.callback.ShareInfoCallback
            public void onFailed() {
                if (ExposedShare.this.mPanelActionCallback != null && !ExposedShare.this.mPanelActionCallback.dismissLoading()) {
                    ExposedShare.this.dismissLoadingView();
                }
                ExposedShare.this.doShare();
            }
        });
    }

    private void showLoadingView() {
        if (this.mProgressDialog == null) {
            IShareProgressView shareProgressView = this.mShareContent.getShareProgressView();
            this.mProgressDialog = shareProgressView;
            if (shareProgressView == null) {
                this.mProgressDialog = ShareConfigManager.getInstance().getShareProgressView(this.mActivity);
            }
        }
        IShareProgressView iShareProgressView = this.mProgressDialog;
        if (iShareProgressView == null || iShareProgressView.isShowing()) {
            return;
        }
        this.mProgressDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissLoadingView() {
        try {
            try {
                IShareProgressView iShareProgressView = this.mProgressDialog;
                if (iShareProgressView != null && iShareProgressView.isShowing()) {
                    this.mProgressDialog.dismiss();
                }
            } catch (Exception e) {
                Logger.m465e(e.toString());
            }
        } finally {
            this.mProgressDialog = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doShare() {
        ShareContent shareContent = this.mShareContent;
        if (shareContent == null || shareContent.getShareChanelType() == null) {
            return;
        }
        ShareContent m987clone = this.mShareContent.m987clone();
        ShareChannelType shareChanelType = m987clone.getShareChanelType();
        ExposedPanelItemsCallback exposedPanelItemsCallback = this.mPanelItemsCallback;
        if (exposedPanelItemsCallback != null) {
            exposedPanelItemsCallback.resetPanelItemOriginalData(m987clone);
        }
        if (this.mPanelContent.getShareInfoList() != null) {
            Iterator<ShareInfo> it = this.mPanelContent.getShareInfoList().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ShareInfo next = it.next();
                ShareChannelType shareItemType = ShareChannelType.getShareItemType(next.getChannel());
                if (shareItemType != null && shareItemType == shareChanelType) {
                    m987clone = ShareInfo.applyToShareModel(next, m987clone);
                    break;
                }
            }
        }
        ExposedPanelItemsCallback exposedPanelItemsCallback2 = this.mPanelItemsCallback;
        if (exposedPanelItemsCallback2 != null) {
            exposedPanelItemsCallback2.resetPanelItemServerData(m987clone);
        }
        IExecuteListener iExecuteListener = new IExecuteListener() { // from class: com.bytedance.ug.sdk.share.impl.share.exposure.ExposedShare.2
            @Override // com.bytedance.ug.sdk.share.api.callback.IExecuteListener
            public void continueExecute(final ShareContent shareContent2) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.ug.sdk.share.impl.share.exposure.ExposedShare.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ExposedShare.this.handleShare(shareContent2);
                    }
                });
            }
        };
        ExposedPanelActionCallback exposedPanelActionCallback = this.mPanelActionCallback;
        if (exposedPanelActionCallback == null || !exposedPanelActionCallback.interceptPanelClick(m987clone, iExecuteListener)) {
            handleShare(m987clone);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleShare(ShareContent shareContent) {
        if (shareContent.getShareChanelType() != ShareChannelType.COPY_LINK) {
            ShareUtils.appendShareToken(shareContent, shareContent.getShareToken());
        }
        if (StrategyDispatcher.dispatchStrategy(this.mActivity, shareContent)) {
            ShareEvent.sendShareSuccessEvent(shareContent, ShareUtils.isRealH5Share(shareContent));
            MonitorEvent.monitorPanelClick(1, System.currentTimeMillis() - MonitorEvent.mPanelClickTime);
        } else {
            MonitorEvent.monitorPanelClick(3, System.currentTimeMillis() - MonitorEvent.mPanelClickTime);
        }
    }
}
