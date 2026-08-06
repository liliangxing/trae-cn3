package com.bytedance.ug.sdk.share.impl.p009ui.panel;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.share_ui.R;
import com.bytedance.ug.sdk.share.api.callback.GetImageCallback;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.bytedance.ug.sdk.share.api.panel.IPanelItem;
import com.bytedance.ug.sdk.share.api.panel.PanelContent;
import com.bytedance.ug.sdk.share.impl.config.ShareConfigManager;
import com.bytedance.ug.sdk.share.impl.network.model.ShareInfo;
import com.bytedance.ug.sdk.share.impl.p009ui.panel.ISharePanel;
import com.bytedance.ug.sdk.share.impl.p009ui.utils.DebouncingOnClickListener;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class GeneralSharePanelAdapter extends RecyclerView.Adapter<PanelItemViewHolder> {
    protected Context mContext;
    protected LayoutInflater mInflater;
    protected PanelContent mPanelContent;
    protected Resources mRes;
    protected ShareContent mShareContent;
    protected List<ShareInfo> mShareInfoList;
    private ISharePanel.ISharePanelCallback mSharePanelCallback;
    protected List<IPanelItem> mData = new ArrayList();
    protected DebouncingOnClickListener mOnClickListener = new DebouncingOnClickListener() { // from class: com.bytedance.ug.sdk.share.impl.ui.panel.GeneralSharePanelAdapter.1
        @Override // com.bytedance.ug.sdk.share.impl.p009ui.utils.DebouncingOnClickListener
        public void doClick(View view) {
            Object tag = view.getTag();
            if (tag instanceof PanelItemViewHolder) {
                IPanelItem item = GeneralSharePanelAdapter.this.getItem(((PanelItemViewHolder) tag).getLayoutPosition());
                if (GeneralSharePanelAdapter.this.mSharePanelCallback != null) {
                    GeneralSharePanelAdapter.this.mSharePanelCallback.onClick(view, true, item);
                }
            }
        }
    };

    public GeneralSharePanelAdapter(Context context, List<IPanelItem> list, PanelContent panelContent, ISharePanel.ISharePanelCallback iSharePanelCallback) {
        this.mInflater = LayoutInflater.from(context);
        this.mContext = context;
        this.mRes = context.getResources();
        if (list != null && !list.isEmpty()) {
            this.mData.addAll(list);
        }
        if (this.mShareContent == null) {
            this.mShareContent = new ShareContent.Builder().build();
        }
        this.mShareContent = panelContent.getShareContent();
        this.mPanelContent = panelContent;
        this.mShareInfoList = new ArrayList();
        this.mSharePanelCallback = iSharePanelCallback;
    }

    public PanelItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = this.mInflater.inflate(getItemLayout(), viewGroup, false);
        inflate.setOnClickListener(this.mOnClickListener);
        return new PanelItemViewHolder(inflate);
    }

    public int getItemLayout() {
        return R.layout.share_sdk_detail_more_item;
    }

    public void onBindViewHolder(final PanelItemViewHolder panelItemViewHolder, int i) {
        IPanelItem item = getItem(i);
        if (item == null) {
            return;
        }
        if (item.getIconId() != 0) {
            panelItemViewHolder.icon.setImageDrawable(ContextCompat.getDrawable(this.mContext, item.getIconId()));
        } else if (!TextUtils.isEmpty(item.getIconUrl())) {
            ShareConfigManager.getInstance().getImageBitmap(item.getIconUrl(), new GetImageCallback() { // from class: com.bytedance.ug.sdk.share.impl.ui.panel.GeneralSharePanelAdapter.2
                @Override // com.bytedance.ug.sdk.share.api.callback.GetImageCallback
                public void onFailed() {
                }

                @Override // com.bytedance.ug.sdk.share.api.callback.GetImageCallback
                public void onSuccess(final Bitmap bitmap) {
                    if (bitmap == null || bitmap.isRecycled()) {
                        return;
                    }
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.ug.sdk.share.impl.ui.panel.GeneralSharePanelAdapter.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            panelItemViewHolder.icon.setImageBitmap(bitmap);
                        }
                    });
                }
            });
        }
        if (item.getTextId() > 0) {
            panelItemViewHolder.text.setText(item.getTextId());
        } else if (!TextUtils.isEmpty(item.getTextStr())) {
            panelItemViewHolder.text.setText(item.getTextStr());
        }
        panelItemViewHolder.itemView.setTag(panelItemViewHolder);
        panelItemViewHolder.itemView.setAlpha(1.0f);
        item.setItemView(panelItemViewHolder.itemView, panelItemViewHolder.icon, panelItemViewHolder.text);
    }

    public int getItemCount() {
        return this.mData.size();
    }

    protected IPanelItem getItem(int i) {
        if (i < 0 || i >= this.mData.size()) {
            return null;
        }
        return this.mData.get(i);
    }
}
