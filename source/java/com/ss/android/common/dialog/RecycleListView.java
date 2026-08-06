package com.ss.android.common.dialog;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/* loaded from: classes7.dex */
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
