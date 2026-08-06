package com.lynx.tasm.behavior.render;

import android.view.ViewGroup;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.p000ui.UIBody;
import com.lynx.tasm.behavior.p000ui.scroll.AndroidScrollView;
import com.lynx.tasm.behavior.p000ui.scroll.UIScrollView;
import com.lynx.tasm.behavior.p000ui.view.AndroidView;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class PlatformRendererContext {
    private LynxContext mContext;
    private long mNativePtr;
    WeakReference<UIBody.UIBodyView> mRootView;
    HashMap<Integer, ViewGroup> mViewHolder = new HashMap<>();

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static final class PlatformRendererType {
        public static final int kPage = 2;
        public static final int kScroll = 3;
        public static final int kUnknown = 0;
        public static final int kView = 1;
    }

    public void getDrawingList(int i, DisplayList displayList) {
    }

    native long nativeCreateEmbeddedViewContext(PlatformRendererContext platformRendererContext);

    public PlatformRendererContext(UIBody.UIBodyView uIBodyView, LynxContext lynxContext) {
        this.mRootView = null;
        this.mContext = null;
        this.mNativePtr = 0L;
        if (uIBodyView != null) {
            this.mRootView = new WeakReference<>(uIBodyView);
        }
        this.mContext = lynxContext;
        this.mNativePtr = nativeCreateEmbeddedViewContext(this);
    }

    public void setRootView(UIBody.UIBodyView uIBodyView) {
        this.mRootView = new WeakReference<>(uIBodyView);
    }

    public long getNativePtr() {
        return this.mNativePtr;
    }

    public void createPlatformRenderer(int i, int i2) {
        if (i2 == 1) {
            this.mViewHolder.put(Integer.valueOf(i), new AndroidView(this.mContext));
            return;
        }
        if (i2 != 2) {
            if (i2 != 3) {
                return;
            }
            this.mViewHolder.put(Integer.valueOf(i), new AndroidScrollView(this.mContext, new UIScrollView(this.mContext)));
            return;
        }
        UIBody.UIBodyView uIBodyView = this.mRootView.get();
        if (uIBodyView != null) {
            uIBodyView.mSign = i;
            this.mViewHolder.put(Integer.valueOf(i), uIBodyView);
        }
    }

    public void destroyPlatformRenderer(int i) {
        this.mViewHolder.remove(Integer.valueOf(i));
    }

    public void insertPlatformRenderer(int i, int i2, int i3) {
        ViewGroup viewGroup = this.mViewHolder.get(Integer.valueOf(i));
        ViewGroup viewGroup2 = this.mViewHolder.get(Integer.valueOf(i2));
        if (viewGroup == null || viewGroup2 == null) {
            return;
        }
        int childCount = viewGroup.getChildCount();
        if (i3 == -1 || i3 >= childCount) {
            viewGroup.addView(viewGroup2);
        } else {
            viewGroup.addView(viewGroup2, i3);
        }
    }

    public void invalidatePlatformRenderer(int i) {
        ViewGroup viewGroup = this.mViewHolder.get(Integer.valueOf(i));
        if (viewGroup != null) {
            viewGroup.invalidate();
        }
    }

    public void removePlatformRendererFromParent(int i) {
        ViewGroup viewGroup;
        ViewGroup viewGroup2 = this.mViewHolder.get(Integer.valueOf(i));
        if (viewGroup2 == null || (viewGroup = (ViewGroup) viewGroup2.getParent()) == null) {
            return;
        }
        viewGroup.removeView(viewGroup2);
    }
}
