package com.lynx.tasm.behavior.p000ui;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class ViewGroupDrawingOrderHelper {
    private int[] mDrawingOrderIndices;
    private int mNumberOfChildrenWithZIndex = 0;
    private final ViewGroup mViewGroup;

    public ViewGroupDrawingOrderHelper(ViewGroup viewGroup) {
        this.mViewGroup = viewGroup;
    }

    public int[] getDrawingOrderIndices() {
        return this.mDrawingOrderIndices;
    }

    public void handleAddView(View view) {
        if (UIGroup.getViewZIndex(view) != null) {
            this.mNumberOfChildrenWithZIndex++;
        }
        this.mDrawingOrderIndices = null;
    }

    public void handleRemoveView(View view) {
        if (UIGroup.getViewZIndex(view) != null) {
            this.mNumberOfChildrenWithZIndex--;
        }
        this.mDrawingOrderIndices = null;
    }

    public boolean shouldEnableCustomDrawingOrder() {
        return this.mNumberOfChildrenWithZIndex > 0;
    }

    public int getChildDrawingOrder(int i, int i2) {
        prepareChildDrawingOrder();
        return this.mDrawingOrderIndices[i2];
    }

    public void prepareChildDrawingOrder() {
        int childCount = this.mViewGroup.getChildCount();
        if (this.mDrawingOrderIndices == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < childCount; i++) {
                arrayList.add(this.mViewGroup.getChildAt(i));
            }
            Collections.sort(arrayList, new Comparator<View>() { // from class: com.lynx.tasm.behavior.ui.ViewGroupDrawingOrderHelper.1
                @Override // java.util.Comparator
                public int compare(View view, View view2) {
                    Integer viewZIndex = UIGroup.getViewZIndex(view);
                    if (viewZIndex == null) {
                        viewZIndex = r0;
                    }
                    Integer viewZIndex2 = UIGroup.getViewZIndex(view2);
                    return viewZIndex.intValue() - (viewZIndex2 != null ? viewZIndex2 : 0).intValue();
                }
            });
            this.mDrawingOrderIndices = new int[childCount];
            for (int i2 = 0; i2 < childCount; i2++) {
                this.mDrawingOrderIndices[i2] = this.mViewGroup.indexOfChild((View) arrayList.get(i2));
            }
        }
    }

    public void update() {
        this.mNumberOfChildrenWithZIndex = 0;
        for (int i = 0; i < this.mViewGroup.getChildCount(); i++) {
            if (UIGroup.getViewZIndex(this.mViewGroup.getChildAt(i)) != null) {
                this.mNumberOfChildrenWithZIndex++;
            }
        }
        this.mDrawingOrderIndices = null;
    }
}
