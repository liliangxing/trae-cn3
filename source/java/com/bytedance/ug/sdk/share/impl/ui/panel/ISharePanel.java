package com.bytedance.ug.sdk.share.impl.ui.panel;

import android.view.View;
import com.bytedance.ug.sdk.share.api.panel.IPanelItem;
import com.bytedance.ug.sdk.share.api.panel.PanelContent;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes4.dex */
public interface ISharePanel {

    /* loaded from: classes4.dex */
    public interface ISharePanelCallback extends Serializable {
        void onClick(View view, boolean z, IPanelItem iPanelItem);

        void onDismiss();
    }

    void dismiss();

    void dismissLoadingView();

    void initSharePanel(PanelContent panelContent, List<List<IPanelItem>> list, ISharePanelCallback iSharePanelCallback);

    boolean isShowing();

    void show();

    void showLoadingView();
}
