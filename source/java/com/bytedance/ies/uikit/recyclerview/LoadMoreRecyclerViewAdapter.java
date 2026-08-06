package com.bytedance.ies.uikit.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.ies.uikit.recyclerview.LoadingStatusView;
import com.bytedance.ugc.uikit.C1158R;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public abstract class LoadMoreRecyclerViewAdapter extends RecyclerViewWithFooterAdapter {
    private ILoadMore mLoadMoreListener;
    private LoadMoreViewHolder mLoadMoreViewHolder;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public interface ILoadMore {
        void loadMore(boolean z);
    }

    protected int getErrorLayoutForLoadMore() {
        return -1;
    }

    public void setLoadMoreListener(ILoadMore iLoadMore) {
        this.mLoadMoreListener = iLoadMore;
    }

    @Override // com.bytedance.ies.uikit.recyclerview.RecyclerViewWithFooterAdapter
    public void onBindFooterViewHolder(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder instanceof LoadMoreViewHolder) {
            ((LoadMoreViewHolder) viewHolder).bind();
            StaggeredGridLayoutManager.LayoutParams layoutParams = (RecyclerView.LayoutParams) this.mLoadMoreViewHolder.itemView.getLayoutParams();
            if (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
                layoutParams.setFullSpan(true);
            }
            this.mLoadMoreViewHolder.itemView.setLayoutParams(layoutParams);
        }
    }

    @Override // com.bytedance.ies.uikit.recyclerview.RecyclerViewWithFooterAdapter
    public RecyclerView.ViewHolder onCreateFooterViewHolder(ViewGroup viewGroup) {
        LoadingStatusView loadingStatusView = new LoadingStatusView(viewGroup.getContext());
        int footerHeight = getFooterHeight(viewGroup);
        int dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(C1158R.dimen.default_list_loadmore_progressbar);
        loadingStatusView.setLayoutParams(getFooterLayoutParams(-1, footerHeight));
        LoadingStatusView.Builder builder = new LoadingStatusView.Builder(viewGroup.getContext());
        builder.setUseProgressBar(dimensionPixelSize).setErrorText(C1158R.string.load_status_click_retry, new View.OnClickListener() { // from class: com.bytedance.ies.uikit.recyclerview.LoadMoreRecyclerViewAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (LoadMoreRecyclerViewAdapter.this.mLoadMoreListener != null) {
                    LoadMoreRecyclerViewAdapter.this.mLoadMoreListener.loadMore(true);
                }
            }
        });
        if (getErrorLayoutForLoadMore() > 0) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(getErrorLayoutForLoadMore(), viewGroup, false);
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.ies.uikit.recyclerview.LoadMoreRecyclerViewAdapter.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (LoadMoreRecyclerViewAdapter.this.mLoadMoreListener != null) {
                        LoadMoreRecyclerViewAdapter.this.mLoadMoreListener.loadMore(true);
                    }
                }
            });
            builder.setErrorView(inflate);
        }
        builder.setLoadingView(LayoutInflater.from(viewGroup.getContext()).inflate(getLoadingLayoutForLoadMore(), viewGroup, false));
        loadingStatusView.setBuilder(builder);
        LoadMoreViewHolder loadMoreViewHolder = new LoadMoreViewHolder(loadingStatusView);
        this.mLoadMoreViewHolder = loadMoreViewHolder;
        return loadMoreViewHolder;
    }

    protected int getLoadingLayoutForLoadMore() {
        return C1158R.layout.layout_loading_more;
    }

    protected RecyclerView.LayoutParams getFooterLayoutParams(int i, int i2) {
        return new RecyclerView.LayoutParams(i, i2);
    }

    protected int getFooterHeight(View view) {
        return view.getResources().getDimensionPixelSize(C1158R.dimen.default_list_loadmore_height);
    }

    @Override // com.bytedance.ies.uikit.recyclerview.RecyclerViewWithFooterAdapter
    public final int getItemCount() {
        if (getBasicItemCount() == 0) {
            return 0;
        }
        return super.getItemCount();
    }

    public void showLoadMoreLoading() {
        LoadMoreViewHolder loadMoreViewHolder = this.mLoadMoreViewHolder;
        if (loadMoreViewHolder == null) {
            return;
        }
        loadMoreViewHolder.showLoading();
    }

    public void showLoadMoreError() {
        LoadMoreViewHolder loadMoreViewHolder = this.mLoadMoreViewHolder;
        if (loadMoreViewHolder == null) {
            return;
        }
        loadMoreViewHolder.showError();
    }

    public void resetLoadMoreState() {
        LoadMoreViewHolder loadMoreViewHolder = this.mLoadMoreViewHolder;
        if (loadMoreViewHolder == null) {
            return;
        }
        loadMoreViewHolder.reset();
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    class LoadMoreViewHolder extends RecyclerView.ViewHolder {
        public LoadMoreViewHolder(View view) {
            super(view);
        }

        public void bind() {
            if (!((LoadingStatusView) this.itemView).isReset() || LoadMoreRecyclerViewAdapter.this.mLoadMoreListener == null) {
                return;
            }
            LoadMoreRecyclerViewAdapter.this.mLoadMoreListener.loadMore(false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void showLoading() {
            ((LoadingStatusView) this.itemView).showLoading();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void showError() {
            ((LoadingStatusView) this.itemView).showError();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void reset() {
            ((LoadingStatusView) this.itemView).reset();
        }
    }
}
