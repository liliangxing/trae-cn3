package com.bytedance.ug.sdk.share.api.panel.exposure;

import android.app.Activity;
import com.bytedance.ug.sdk.share.api.callback.ExposedPanelActionCallback;
import com.bytedance.ug.sdk.share.api.callback.ExposedPanelItemsCallback;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.bytedance.ug.sdk.share.impl.config.ShareConfigManager;
import com.bytedance.ug.sdk.share.impl.manager.ShareSdkManager;
import com.bytedance.ug.sdk.share.impl.network.model.ShareInfo;
import java.util.List;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ExposedPanelContent {
    private ExposedPanelActionCallback mActionCallback;
    private Activity mActivity;
    private ExposedPanelItemsCallback mExposedPanelItemsCallback;
    private boolean mIsDisableGetShareInfo;
    private boolean mIsForceUpdate;
    private String mPanelId;
    private JSONObject mRequestData;
    private String mResourceId;
    private ShareContent mShareContent;
    private List<ShareInfo> mShareInfoList;

    private ExposedPanelContent() {
    }

    public Activity getActivity() {
        return this.mActivity;
    }

    public ExposedPanelItemsCallback getItemsCallback() {
        return this.mExposedPanelItemsCallback;
    }

    public List<ShareInfo> getShareInfoList() {
        return this.mShareInfoList;
    }

    public void setShareInfoList(List<ShareInfo> list) {
        this.mShareInfoList = list;
    }

    public ShareContent getShareContent() {
        return this.mShareContent;
    }

    public String getPanelId() {
        return this.mPanelId;
    }

    public String getResourceId() {
        return this.mResourceId;
    }

    public JSONObject getData() {
        return this.mRequestData;
    }

    public ExposedPanelActionCallback getPanelActionCallback() {
        return this.mActionCallback;
    }

    public boolean isDisableGetShareInfo() {
        if (ShareConfigManager.getInstance().isLocalMode()) {
            return true;
        }
        return this.mIsDisableGetShareInfo;
    }

    public boolean isForceUpdate() {
        return this.mIsForceUpdate;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static class PanelContentBuilder {
        private ExposedPanelContent panelContent;

        public PanelContentBuilder(Activity activity) {
            ExposedPanelContent exposedPanelContent = new ExposedPanelContent();
            this.panelContent = exposedPanelContent;
            exposedPanelContent.mActivity = activity;
        }

        public PanelContentBuilder withShareContent(ShareContent shareContent) {
            this.panelContent.mShareContent = shareContent;
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

        public PanelContentBuilder withForceUpdate(boolean z) {
            this.panelContent.mIsForceUpdate = z;
            return this;
        }

        public PanelContentBuilder withPanelActionCallback(ExposedPanelActionCallback exposedPanelActionCallback) {
            this.panelContent.mActionCallback = exposedPanelActionCallback;
            return this;
        }

        public PanelContentBuilder withPanelItemsCallback(ExposedPanelItemsCallback exposedPanelItemsCallback) {
            this.panelContent.mExposedPanelItemsCallback = exposedPanelItemsCallback;
            return this;
        }

        public PanelContentBuilder withShareInfoList(List<ShareInfo> list) {
            this.panelContent.mShareInfoList = list;
            return this;
        }

        public ExposedPanelContent build() {
            if (this.panelContent.getShareContent() != null) {
                ShareSdkManager.getInstance().setShareEventCallback(this.panelContent.getShareContent().getEventCallBack());
            }
            return this.panelContent;
        }
    }
}
