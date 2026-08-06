package com.bytedance.ug.sdk.share.impl.model;

import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.ug.sdk.share.api.panel.IPanelItem;

/* loaded from: classes4.dex */
public abstract class BaseShareItem implements IPanelItem {
    protected int mItemIconId;
    protected String mItemTextStr;

    public void setItemTextStr(String str) {
        this.mItemTextStr = str;
    }

    public void setItemIconId(int i) {
        this.mItemIconId = i;
    }

    @Override // com.bytedance.ug.sdk.share.api.panel.IPanelItem
    public void setItemView(final View view, ImageView imageView, TextView textView) {
        if (view == null) {
            return;
        }
        final float alpha = view.getAlpha();
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.ug.sdk.share.impl.model.BaseShareItem.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    view.setAlpha(alpha * 0.5f);
                    return false;
                }
                if (action != 1 && action != 3) {
                    return false;
                }
                view.setAlpha(alpha);
                return false;
            }
        });
    }
}
