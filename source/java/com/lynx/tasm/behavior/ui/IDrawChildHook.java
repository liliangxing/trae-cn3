package com.lynx.tasm.behavior.ui;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;

/* loaded from: classes7.dex */
public interface IDrawChildHook {

    /* loaded from: classes7.dex */
    public interface IDrawChildHookBinding {
        void bindDrawChildHook(IDrawChildHook iDrawChildHook);
    }

    void afterDispatchDraw(Canvas canvas);

    void afterDraw(Canvas canvas);

    void afterDrawChild(Canvas canvas, View view, long j);

    void beforeDispatchDraw(Canvas canvas);

    void beforeDraw(Canvas canvas);

    Rect beforeDrawChild(Canvas canvas, View view, long j);

    int getChildDrawingOrder(int i, int i2);

    boolean hasOverlappingRendering();

    void performLayoutChildrenUI();

    void performMeasureChildrenUI();
}
