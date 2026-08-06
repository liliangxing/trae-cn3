package com.bytedance.ug.sdk.share.api.callback;

import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.bytedance.ug.sdk.share.api.panel.IPanelItem;
import com.bytedance.ug.sdk.share.impl.p009ui.panel.ISharePanel;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface PanelItemsCallback {

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static abstract class EmptySharePanelItemsCallback implements PanelItemsCallback {
        @Override // com.bytedance.ug.sdk.share.api.callback.PanelItemsCallback
        public void resetPanelItem(ISharePanel iSharePanel, List<List<IPanelItem>> list) {
        }

        @Override // com.bytedance.ug.sdk.share.api.callback.PanelItemsCallback
        public void resetPanelItemOriginalData(ShareContent shareContent) {
        }

        @Override // com.bytedance.ug.sdk.share.api.callback.PanelItemsCallback
        public void resetPanelItemServerData(ShareContent shareContent) {
        }
    }

    void resetPanelItem(ISharePanel iSharePanel, List<List<IPanelItem>> list);

    void resetPanelItemOriginalData(ShareContent shareContent);

    void resetPanelItemServerData(ShareContent shareContent);
}
