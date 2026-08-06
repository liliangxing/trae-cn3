package com.bytedance.ug.sdk.share.impl.p009ui.panel;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bytedance.ug.sdk.share.api.callback.IExecuteListener;
import com.bytedance.ug.sdk.share.api.callback.ShareInfoCallback;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.bytedance.ug.sdk.share.api.panel.IPanelItem;
import com.bytedance.ug.sdk.share.api.panel.PanelContent;
import com.bytedance.ug.sdk.share.api.panel.PanelItemType;
import com.bytedance.ug.sdk.share.api.panel.ShareChannelType;
import com.bytedance.ug.sdk.share.impl.config.ShareConfigManager;
import com.bytedance.ug.sdk.share.impl.event.MonitorEvent;
import com.bytedance.ug.sdk.share.impl.event.ShareEvent;
import com.bytedance.ug.sdk.share.impl.manager.ShareSdkManager;
import com.bytedance.ug.sdk.share.impl.network.model.ShareInfo;
import com.bytedance.ug.sdk.share.impl.p009ui.panel.ISharePanel;
import com.bytedance.ug.sdk.share.impl.utils.ShareUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class SharePanelProxy {
    private ISharePanel.ISharePanelCallback mCallback;
    private View mClickView;
    protected WeakReference<Activity> mContextRef;
    private IPanelItem mCurrentPanelItem;
    private boolean mIsShareIconClicked;
    protected PanelContent mPanelContent;
    protected ShareContent mShareContent;
    private List<ShareInfo> mShareInfoList;
    private ISharePanel mSharePanel;
    private volatile boolean mIsWaitingShareInfo = false;
    private volatile boolean mIsClickedShareItem = false;

    public SharePanelProxy(PanelContent panelContent, ISharePanel iSharePanel) {
        this.mSharePanel = iSharePanel;
        this.mPanelContent = panelContent;
        if (panelContent == null) {
            return;
        }
        ShareContent shareContent = panelContent.getShareContent();
        this.mShareContent = shareContent;
        if (shareContent == null) {
            return;
        }
        shareContent.setPanelId(this.mPanelContent.getPanelId());
        this.mShareContent.setResourceId(this.mPanelContent.getResourceId());
        ShareUtils.appendShareToken(this.mShareContent);
        this.mContextRef = new WeakReference<>(panelContent.getActivity());
        this.mShareInfoList = new ArrayList();
        this.mCallback = new ISharePanel.ISharePanelCallback() { // from class: com.bytedance.ug.sdk.share.impl.ui.panel.SharePanelProxy.1
            @Override // com.bytedance.ug.sdk.share.impl.ui.panel.ISharePanel.ISharePanelCallback
            public void onClick(View view, boolean z, IPanelItem iPanelItem) {
                MonitorEvent.mPanelClickTime = System.currentTimeMillis();
                if (SharePanelProxy.this.mPanelContent.getOnPanelActionCallback() != null) {
                    SharePanelProxy.this.mPanelContent.getOnPanelActionCallback().onPanelClick(iPanelItem);
                }
                SharePanelProxy.this.mIsShareIconClicked = true;
                SharePanelProxy.this.mClickView = view;
                if (SharePanelProxy.this.mIsWaitingShareInfo) {
                    if (SharePanelProxy.this.mSharePanel != null) {
                        SharePanelProxy.this.mSharePanel.showLoadingView();
                    }
                    SharePanelProxy.this.mCurrentPanelItem = iPanelItem;
                    SharePanelProxy.this.mIsClickedShareItem = true;
                    return;
                }
                SharePanelProxy.this.doShare(view, z, iPanelItem);
            }

            @Override // com.bytedance.ug.sdk.share.impl.ui.panel.ISharePanel.ISharePanelCallback
            public void onDismiss() {
                if (SharePanelProxy.this.mPanelContent.getOnPanelActionCallback() != null) {
                    SharePanelProxy.this.mPanelContent.getOnPanelActionCallback().onPanelDismiss(SharePanelProxy.this.mIsShareIconClicked);
                }
            }
        };
        List<IPanelItem> panelItems = ShareSdkManager.getInstance().getPanelItems(this.mPanelContent.getPanelId());
        ArrayList arrayList = new ArrayList();
        arrayList.add(panelItems);
        if (this.mPanelContent.getPanelItemsCallback() != null) {
            this.mPanelContent.getPanelItemsCallback().resetPanelItem(this.mSharePanel, arrayList);
        }
        this.mSharePanel.initSharePanel(panelContent, arrayList, this.mCallback);
    }

    public void dismiss() {
        ISharePanel iSharePanel;
        Activity activity = this.mContextRef.get();
        if (activity == null || activity.isFinishing() || (iSharePanel = this.mSharePanel) == null || !iSharePanel.isShowing()) {
            return;
        }
        try {
            this.mSharePanel.dismiss();
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doShare(final View view, boolean z, final IPanelItem iPanelItem) {
        if (iPanelItem == null) {
            return;
        }
        ShareContent m987clone = this.mShareContent.m987clone();
        PanelItemType itemType = iPanelItem.getItemType();
        if (itemType instanceof ShareChannelType) {
            MonitorEvent.monitorPanelClick(0, System.currentTimeMillis() - MonitorEvent.mPanelClickTime);
            m987clone.setShareChannelType((ShareChannelType) itemType);
            if (this.mPanelContent.getPanelItemsCallback() != null) {
                this.mPanelContent.getPanelItemsCallback().resetPanelItemOriginalData(m987clone);
            }
            ShareContent shareContent = getShareContent(m987clone);
            if (this.mPanelContent.getPanelItemsCallback() != null) {
                this.mPanelContent.getPanelItemsCallback().resetPanelItemServerData(shareContent);
            }
            IExecuteListener iExecuteListener = new IExecuteListener() { // from class: com.bytedance.ug.sdk.share.impl.ui.panel.SharePanelProxy.2
                @Override // com.bytedance.ug.sdk.share.api.callback.IExecuteListener
                public void continueExecute(final ShareContent shareContent2) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.ug.sdk.share.impl.ui.panel.SharePanelProxy.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SharePanelProxy.this.onItemClick(iPanelItem, view, shareContent2);
                        }
                    });
                }
            };
            if (shareContent.getShareChanelType() != ShareChannelType.COPY_LINK) {
                ShareUtils.appendShareToken(shareContent, shareContent.getShareToken());
            }
            if (this.mPanelContent.getOnPanelActionCallback() == null || !this.mPanelContent.getOnPanelActionCallback().interceptPanelClick(iPanelItem, shareContent, iExecuteListener)) {
                onItemClick(iPanelItem, view, shareContent);
            }
            ShareEvent.sendShareChannelClick(shareContent, true);
        } else {
            if (this.mPanelContent.getPanelItemsCallback() != null) {
                this.mPanelContent.getPanelItemsCallback().resetPanelItemOriginalData(m987clone);
            }
            if (m987clone.getShareChanelType() != ShareChannelType.COPY_LINK) {
                ShareUtils.appendShareToken(m987clone, m987clone.getShareToken());
            }
            ShareContent applyTokenInfo = applyTokenInfo(m987clone);
            IExecuteListener iExecuteListener2 = new IExecuteListener() { // from class: com.bytedance.ug.sdk.share.impl.ui.panel.SharePanelProxy.3
                @Override // com.bytedance.ug.sdk.share.api.callback.IExecuteListener
                public void continueExecute(final ShareContent shareContent2) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.ug.sdk.share.impl.ui.panel.SharePanelProxy.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SharePanelProxy.this.onItemClick(iPanelItem, view, shareContent2);
                        }
                    });
                }
            };
            if (this.mPanelContent.getOnPanelActionCallback() == null || !this.mPanelContent.getOnPanelActionCallback().interceptPanelClick(iPanelItem, applyTokenInfo, iExecuteListener2)) {
                onItemClick(iPanelItem, view, applyTokenInfo);
            }
            ShareSdkManager.getInstance().resetShareEventCallback();
            ShareEvent.sendShareChannelClick(applyTokenInfo, false, iPanelItem.getTextStr());
        }
        if (z) {
            dismiss();
        }
    }

    protected void onItemClick(IPanelItem iPanelItem, View view, ShareContent shareContent) {
        Activity activity = this.mContextRef.get();
        if (activity != null) {
            iPanelItem.onItemClick(activity, view, shareContent);
        }
    }

    public boolean show() {
        Activity activity = this.mContextRef.get();
        if (activity == null || activity.isFinishing()) {
            return false;
        }
        ISharePanel iSharePanel = this.mSharePanel;
        if (iSharePanel != null) {
            iSharePanel.show();
        }
        if (this.mPanelContent.getOnPanelActionCallback() != null) {
            this.mPanelContent.getOnPanelActionCallback().onPanelShow();
        }
        if (ShareConfigManager.getInstance().isEnableGetShareInfo() && !this.mPanelContent.isDisableGetShareInfo()) {
            getShareInfo();
        }
        ShareEvent.sendShowPanelEvent(this.mShareContent);
        return true;
    }

    private void getShareInfo() {
        ShareSdkManager.getInstance().getShareInfo(this.mPanelContent.getPanelId(), this.mPanelContent.getResourceId(), this.mShareContent.getShareToken(), this.mShareContent, this.mPanelContent.getRequestData(), new ShareInfoCallback() { // from class: com.bytedance.ug.sdk.share.impl.ui.panel.SharePanelProxy.4
            @Override // com.bytedance.ug.sdk.share.api.callback.ShareInfoCallback
            public void onSuccess(List<ShareInfo> list) {
                SharePanelProxy.this.mIsWaitingShareInfo = false;
                if (list != null) {
                    for (ShareInfo shareInfo : list) {
                        if (shareInfo != null) {
                            SharePanelProxy.this.mShareInfoList.add(shareInfo);
                        }
                    }
                }
                if (SharePanelProxy.this.mIsClickedShareItem) {
                    if (SharePanelProxy.this.mSharePanel != null) {
                        SharePanelProxy.this.mSharePanel.dismissLoadingView();
                    }
                    SharePanelProxy sharePanelProxy = SharePanelProxy.this;
                    sharePanelProxy.doShare(sharePanelProxy.mClickView, true, SharePanelProxy.this.mCurrentPanelItem);
                    SharePanelProxy.this.mIsClickedShareItem = false;
                }
            }

            @Override // com.bytedance.ug.sdk.share.api.callback.ShareInfoCallback
            public void onFailed() {
                SharePanelProxy.this.mIsWaitingShareInfo = false;
                if (SharePanelProxy.this.mIsClickedShareItem) {
                    if (SharePanelProxy.this.mSharePanel != null) {
                        SharePanelProxy.this.mSharePanel.dismissLoadingView();
                    }
                    SharePanelProxy sharePanelProxy = SharePanelProxy.this;
                    sharePanelProxy.doShare(sharePanelProxy.mClickView, true, SharePanelProxy.this.mCurrentPanelItem);
                    SharePanelProxy.this.mIsClickedShareItem = false;
                }
            }
        });
        this.mIsWaitingShareInfo = true;
    }

    protected ShareContent getShareContent(ShareContent shareContent) {
        ShareChannelType shareChanelType;
        if (shareContent == null || (shareChanelType = shareContent.getShareChanelType()) == null) {
            return null;
        }
        for (ShareInfo shareInfo : this.mShareInfoList) {
            ShareChannelType shareItemType = ShareChannelType.getShareItemType(shareInfo.getChannel());
            if (shareItemType != null && shareItemType == shareChanelType) {
                return ShareInfo.applyToShareModel(shareInfo, shareContent);
            }
        }
        return shareContent;
    }

    private ShareContent applyTokenInfo(ShareContent shareContent) {
        if (shareContent == null) {
            return null;
        }
        for (ShareInfo shareInfo : this.mShareInfoList) {
            ShareChannelType shareItemType = ShareChannelType.getShareItemType(shareInfo.getChannel());
            if (shareItemType == ShareChannelType.WX || shareItemType == ShareChannelType.WX_TIMELINE || shareItemType == ShareChannelType.QQ || shareItemType == ShareChannelType.QZONE) {
                return ShareInfo.applyTokenToShareModel(shareInfo, shareContent);
            }
        }
        return shareContent;
    }
}
