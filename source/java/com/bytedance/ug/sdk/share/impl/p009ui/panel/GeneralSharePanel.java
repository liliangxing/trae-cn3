package com.bytedance.ug.sdk.share.impl.p009ui.panel;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.share_ui.R;
import com.bytedance.ug.sdk.share.api.p008ui.IShareProgressView;
import com.bytedance.ug.sdk.share.api.panel.IPanelItem;
import com.bytedance.ug.sdk.share.api.panel.PanelContent;
import com.bytedance.ug.sdk.share.impl.config.ShareConfigManager;
import com.bytedance.ug.sdk.share.impl.p009ui.panel.ISharePanel;
import com.bytedance.ug.sdk.share.impl.p009ui.utils.UIUtils;
import com.bytedance.ug.sdk.share.impl.utils.Logger;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class GeneralSharePanel extends SSDialog implements ISharePanel {
    protected TextView mCancelBtn;
    protected String mCancelText;
    protected int mDlgPortraitWidth;
    protected PanelContent mPanelContent;
    private List<List<IPanelItem>> mPanelItemRows;
    protected ViewGroup mPanelRowsView;
    protected IShareProgressView mProgressDialog;
    protected Resources mResources;
    protected ViewGroup mRootView;
    private ISharePanel.ISharePanelCallback mSharePanelCallback;
    protected Window mWindow;

    public GeneralSharePanel(Activity activity) {
        super(activity, R.style.share_sdk_detail_more_dlg);
        this.mCancelText = "";
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.share_sdk_base_action_dialog);
        setCanceledOnTouchOutside(true);
        initWindow();
        initViews();
        initData();
    }

    @Override // com.bytedance.ug.sdk.share.impl.p009ui.panel.SSDialog, android.app.Dialog, android.content.DialogInterface, com.bytedance.ug.sdk.share.impl.p009ui.panel.ISharePanel
    public void dismiss() {
        super.dismiss();
        ISharePanel.ISharePanelCallback iSharePanelCallback = this.mSharePanelCallback;
        if (iSharePanelCallback != null) {
            iSharePanelCallback.onDismiss();
        }
    }

    @Override // com.bytedance.ug.sdk.share.impl.p009ui.panel.ISharePanel
    public void initSharePanel(PanelContent panelContent, List<List<IPanelItem>> list, ISharePanel.ISharePanelCallback iSharePanelCallback) {
        this.mContext = panelContent.getActivity();
        this.mResources = this.mContext.getResources();
        this.mPanelContent = panelContent;
        if (panelContent != null && !TextUtils.isEmpty(panelContent.getCancelText())) {
            this.mCancelText = panelContent.getCancelText();
        }
        this.mPanelItemRows = list;
        this.mSharePanelCallback = iSharePanelCallback;
    }

    @Override // com.bytedance.ug.sdk.share.impl.p009ui.panel.ISharePanel
    public void showLoadingView() {
        if (this.mProgressDialog == null) {
            if (this.mPanelContent.getShareContent() != null) {
                this.mProgressDialog = this.mPanelContent.getShareContent().getShareProgressView();
            }
            if (this.mProgressDialog == null) {
                this.mProgressDialog = ShareConfigManager.getInstance().getShareProgressView(this.mContext);
            }
        }
        IShareProgressView iShareProgressView = this.mProgressDialog;
        if (iShareProgressView == null || iShareProgressView.isShowing()) {
            return;
        }
        this.mProgressDialog.show();
    }

    @Override // com.bytedance.ug.sdk.share.impl.p009ui.panel.ISharePanel
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

    protected void initWindow() {
        Window window = getWindow();
        this.mWindow = window;
        if (window != null) {
            Display defaultDisplay = window.getWindowManager().getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getSize(point);
            this.mDlgPortraitWidth = Math.min(point.x, point.y);
            this.mWindow.setLayout(-1, -2);
            this.mWindow.setGravity(80);
            if (this.mWindow.getAttributes().gravity == 80) {
                this.mWindow.setWindowAnimations(R.style.share_sdk_bottom_dialog_animation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initData() {
        List<List<IPanelItem>> list = this.mPanelItemRows;
        if (list == null || list.size() == 0) {
            return;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.mPanelItemRows.size(); i2++) {
            View addRecyclerView = addRecyclerView(this.mPanelItemRows.get(i2));
            if (addRecyclerView != null) {
                this.mPanelRowsView.addView(addRecyclerView, i, new FrameLayout.LayoutParams(-1, -2));
                i++;
                if (this.mPanelItemRows.size() > 1 && i2 != this.mPanelItemRows.size() - 1) {
                    View view = new View(this.mContext);
                    view.setBackgroundColor(ContextCompat.getColor(this.mContext, R.color.share_sdk_panel_line));
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                    layoutParams.height = 1;
                    this.mPanelRowsView.addView(view, i, layoutParams);
                    i++;
                }
            }
        }
    }

    protected View addRecyclerView(List<IPanelItem> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        final RecyclerView recyclerView = new RecyclerView(this.mContext);
        recyclerView.setMinimumHeight((int) UIUtils.dip2Px(this.mContext, 108.0f));
        recyclerView.setLayoutManager(new LinearLayoutManager(this.mContext, 0, false));
        recyclerView.setHasFixedSize(true);
        final GeneralSharePanelAdapter generalSharePanelAdapter = new GeneralSharePanelAdapter(this.mContext, list, this.mPanelContent, this.mSharePanelCallback);
        recyclerView.post(new Runnable() { // from class: com.bytedance.ug.sdk.share.impl.ui.panel.GeneralSharePanel.1
            @Override // java.lang.Runnable
            public void run() {
                int width = recyclerView.getWidth();
                if (width == 0) {
                    width = GeneralSharePanel.this.mDlgPortraitWidth;
                }
                int dimensionPixelSize = GeneralSharePanel.this.mResources.getDimensionPixelSize(R.dimen.share_sdk_share_rv_padding_new);
                int dimension = (int) (((width - dimensionPixelSize) - (GeneralSharePanel.this.mResources.getDimension(R.dimen.share_sdk_share_item_width) * 4.5f)) / 4.0f);
                int dimensionPixelOffset = GeneralSharePanel.this.mResources.getDimensionPixelOffset(R.dimen.share_sdk_share_item_min_space);
                if (dimensionPixelSize < dimensionPixelOffset) {
                    dimensionPixelSize = dimensionPixelOffset;
                }
                if (dimension < dimensionPixelOffset) {
                    dimension = dimensionPixelOffset;
                }
                recyclerView.addItemDecoration(new SpacesItemDecoration(dimension, dimensionPixelSize));
                recyclerView.setAdapter(generalSharePanelAdapter);
                GeneralSharePanel.this.mCancelBtn.setTextColor(ContextCompat.getColorStateList(GeneralSharePanel.this.mContext, R.color.share_sdk_ssxinzi1_selector));
                UIUtils.setViewBackgroundWithPadding(GeneralSharePanel.this.mCancelBtn, ContextCompat.getDrawable(GeneralSharePanel.this.mContext, R.drawable.share_sdk_share_action_dialog_cancel_btn_bg));
                if (recyclerView != null) {
                    generalSharePanelAdapter.notifyDataSetChanged();
                }
            }
        });
        return recyclerView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initViews() {
        this.mRootView = (ViewGroup) findViewById(R.id.dialog_root);
        this.mCancelBtn = (TextView) findViewById(R.id.cancel_btn);
        this.mPanelRowsView = (ViewGroup) findViewById(R.id.panel_rows);
        this.mCancelBtn.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.ug.sdk.share.impl.ui.panel.GeneralSharePanel.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GeneralSharePanel.this.isViewValid()) {
                    GeneralSharePanel.this.dismiss();
                }
            }
        });
        if (TextUtils.isEmpty(this.mCancelText)) {
            return;
        }
        this.mCancelBtn.setText(this.mCancelText);
    }
}
