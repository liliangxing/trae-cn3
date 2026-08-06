package com.bytedance.ug.sdk.share.api.panel;

import android.app.Activity;
import com.bytedance.ug.sdk.share.api.callback.OnPanelActionCallback;
import com.bytedance.ug.sdk.share.api.callback.PanelItemsCallback;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.bytedance.ug.sdk.share.impl.config.ShareConfigManager;
import com.bytedance.ug.sdk.share.impl.manager.ShareSdkManager;
import com.bytedance.ug.sdk.share.impl.ui.panel.ISharePanel;
import java.io.Serializable;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class PanelContent implements Serializable {
    private Activity mActivity;
    private String mCancelText;
    private boolean mIsDisableGetShareInfo;
    private OnPanelActionCallback mOnPanelActionCallback;
    private ISharePanel mPanel;
    private String mPanelId;
    private PanelItemsCallback mPanelItemsCallback;
    private JSONObject mRequestData;
    private String mResourceId;
    private ShareContent mShareContent;

    private PanelContent() {
    }

    public Activity getActivity() {
        return this.mActivity;
    }

    public OnPanelActionCallback getOnPanelActionCallback() {
        return this.mOnPanelActionCallback;
    }

    public PanelItemsCallback getPanelItemsCallback() {
        return this.mPanelItemsCallback;
    }

    public ShareContent getShareContent() {
        return this.mShareContent;
    }

    public String getCancelText() {
        return this.mCancelText;
    }

    public String getPanelId() {
        return this.mPanelId;
    }

    public ISharePanel getPanel() {
        return this.mPanel;
    }

    public String getResourceId() {
        return this.mResourceId;
    }

    public JSONObject getRequestData() {
        return this.mRequestData;
    }

    public boolean isDisableGetShareInfo() {
        if (ShareConfigManager.getInstance().isLocalMode()) {
            return true;
        }
        return this.mIsDisableGetShareInfo;
    }

    /* loaded from: classes4.dex */
    public static class PanelContentBuilder {
        private PanelContent panelContent;

        public PanelContentBuilder(Activity activity) {
            PanelContent panelContent = new PanelContent();
            this.panelContent = panelContent;
            panelContent.mActivity = activity;
        }

        public PanelContentBuilder withPanel(ISharePanel iSharePanel) {
            this.panelContent.mPanel = iSharePanel;
            return this;
        }

        public PanelContentBuilder withPanelActionCallback(OnPanelActionCallback onPanelActionCallback) {
            this.panelContent.mOnPanelActionCallback = onPanelActionCallback;
            return this;
        }

        public PanelContentBuilder withShareContent(ShareContent shareContent) {
            this.panelContent.mShareContent = shareContent;
            return this;
        }

        public PanelContentBuilder withCancelBtnText(String str) {
            this.panelContent.mCancelText = str;
            return this;
        }

        public PanelContentBuilder withPanelId(String str) {
            this.panelContent.mPanelId = str;
            return this;
        }

        public PanelContentBuilder withResourceId(String str) {
            this.panelContent.mResourceId = str;
            return this;
        }

        public PanelContentBuilder withRequestData(JSONObject jSONObject) {
            this.panelContent.mRequestData = jSONObject;
            return this;
        }

        public PanelContentBuilder withDisableGetShreInfo(boolean z) {
            this.panelContent.mIsDisableGetShareInfo = z;
            return this;
        }

        public PanelContentBuilder withPanelItemsCallback(PanelItemsCallback panelItemsCallback) {
            this.panelContent.mPanelItemsCallback = panelItemsCallback;
            return this;
        }

        public PanelContent build() {
            if (this.panelContent.getShareContent() != null) {
                ShareSdkManager.getInstance().setShareEventCallback(this.panelContent.getShareContent().getEventCallBack());
            }
            return this.panelContent;
        }
    }
}
