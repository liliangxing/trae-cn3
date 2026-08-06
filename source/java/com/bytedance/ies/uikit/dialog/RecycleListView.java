package com.bytedance.ies.uikit.dialog;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/* loaded from: classes4.dex */
public class RecycleListView extends ListView {
    boolean mRecycleOnMeasure;

    public RecycleListView(Context context) {
        super(context);
        this.mRecycleOnMeasure = true;
    }

    public RecycleListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRecycleOnMeasure = true;
    }

    public RecycleListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRecycleOnMeasure = true;
    }

    protected boolean recycleOnMeasure() {
        return this.mRecycleOnMeasure;
    }
}
