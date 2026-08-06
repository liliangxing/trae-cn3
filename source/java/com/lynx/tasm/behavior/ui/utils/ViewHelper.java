package com.lynx.tasm.behavior.ui.utils;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import com.lynx.tasm.base.LLog;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public class ViewHelper {
    static final String TAG = "ViewHelper";

    public static void setBackground(View view, Drawable drawable) {
        view.setBackground(drawable);
    }

    public static boolean viewIsParentOfAnotherView(View view, View view2) {
        if (view == null || view2 == null || !(view instanceof ViewGroup)) {
            return false;
        }
        while (view2.getParent() != null) {
            if (view2.getParent() != view) {
                if (!(view2.getParent() instanceof View)) {
                    break;
                }
                view2 = (View) view2.getParent();
            } else {
                return true;
            }
        }
        return false;
    }

    public static PointF convertPointFromAncestorToDescendant(View view, View view2, PointF pointF) {
        if (view == null || view2 == null) {
            LLog.e(TAG, "convertPointFromAncestorToDescendant failed since ancestor or descendant is null");
            return pointF;
        }
        if (view == view2) {
            return pointF;
        }
        float[] fArr = {pointF.x, pointF.y};
        ArrayList arrayList = new ArrayList();
        while (view2 != null && view2 != view) {
            arrayList.add(view2);
            view2 = (View) view2.getParent();
        }
        Matrix matrix = new Matrix();
        int size = arrayList.size() - 1;
        while (size >= 0) {
            View view3 = (View) arrayList.get(size);
            fArr[0] = fArr[0] + view.getScrollX();
            fArr[1] = fArr[1] + view.getScrollY();
            fArr[0] = fArr[0] - view3.getLeft();
            fArr[1] = fArr[1] - view3.getTop();
            if (!view3.getMatrix().isIdentity()) {
                matrix.reset();
                if (view3.getMatrix().invert(matrix)) {
                    float[] fArr2 = {fArr[0], fArr[1]};
                    matrix.mapPoints(fArr2);
                    fArr[0] = fArr2[0];
                    fArr[1] = fArr2[1];
                } else {
                    fArr[0] = Float.MAX_VALUE;
                    fArr[1] = Float.MAX_VALUE;
                }
            }
            size--;
            view = view3;
        }
        return new PointF(fArr[0], fArr[1]);
    }

    public static PointF convertPointFromDescendantToAncestor(View view, View view2, PointF pointF) {
        if (view2 == null || view == null) {
            LLog.e(TAG, "convertPointFromAncestorToDescendant failed since view or another is null");
            return pointF;
        }
        if (view2 == view) {
            return pointF;
        }
        float[] fArr = {pointF.x, pointF.y};
        if (!view.getMatrix().isIdentity()) {
            view.getMatrix().mapPoints(fArr);
        }
        while (true) {
            if (view == view2) {
                break;
            }
            View view3 = (View) view.getParent();
            if (view3 == null) {
                LLog.e(TAG, "convertPointFromDescendantToAncestor failed, parent is null.");
                break;
            }
            fArr[0] = fArr[0] + view.getLeft();
            fArr[1] = fArr[1] + view.getTop();
            fArr[0] = fArr[0] - view3.getScrollX();
            fArr[1] = fArr[1] - view3.getScrollY();
            if (!view3.getMatrix().isIdentity()) {
                view3.getMatrix().mapPoints(fArr);
            }
            view = view3;
        }
        return new PointF(fArr[0], fArr[1]);
    }

    public static PointF convertPointFromViewToAnother(View view, View view2, PointF pointF) {
        if (view == null || view2 == null) {
            LLog.e(TAG, "convertPointFromAncestorToDescendant failed since view or another is null");
            return pointF;
        }
        if (view == view2) {
            return pointF;
        }
        if (viewIsParentOfAnotherView(view, view2)) {
            return convertPointFromAncestorToDescendant(view, view2, pointF);
        }
        if (viewIsParentOfAnotherView(view2, view)) {
            return convertPointFromDescendantToAncestor(view, view2, pointF);
        }
        return convertPointFromAncestorToDescendant(view2.getRootView(), view2, convertPointFromDescendantToAncestor(view, view.getRootView(), pointF));
    }

    public static RectF convertRectFromAncestorToDescendant(View view, View view2, RectF rectF) {
        if (view == null || view2 == null) {
            LLog.e(TAG, "convertPointFromAncestorToDescendant failed since ancestor or descendant is null");
            return rectF;
        }
        if (view == view2) {
            return rectF;
        }
        PointF pointF = new PointF(rectF.left, rectF.top);
        PointF pointF2 = new PointF(rectF.right, rectF.top);
        PointF pointF3 = new PointF(rectF.left, rectF.bottom);
        PointF pointF4 = new PointF(rectF.right, rectF.bottom);
        PointF convertPointFromAncestorToDescendant = convertPointFromAncestorToDescendant(view, view2, pointF);
        PointF convertPointFromAncestorToDescendant2 = convertPointFromAncestorToDescendant(view, view2, pointF2);
        PointF convertPointFromAncestorToDescendant3 = convertPointFromAncestorToDescendant(view, view2, pointF3);
        PointF convertPointFromAncestorToDescendant4 = convertPointFromAncestorToDescendant(view, view2, pointF4);
        RectF rectF2 = new RectF();
        rectF2.left = Math.min(Math.min(convertPointFromAncestorToDescendant.x, convertPointFromAncestorToDescendant2.x), Math.min(convertPointFromAncestorToDescendant3.x, convertPointFromAncestorToDescendant4.x));
        rectF2.top = Math.min(Math.min(convertPointFromAncestorToDescendant.y, convertPointFromAncestorToDescendant2.y), Math.min(convertPointFromAncestorToDescendant3.y, convertPointFromAncestorToDescendant4.y));
        rectF2.right = Math.max(Math.max(convertPointFromAncestorToDescendant.x, convertPointFromAncestorToDescendant2.x), Math.max(convertPointFromAncestorToDescendant3.x, convertPointFromAncestorToDescendant4.x));
        rectF2.bottom = Math.max(Math.max(convertPointFromAncestorToDescendant.y, convertPointFromAncestorToDescendant2.y), Math.max(convertPointFromAncestorToDescendant3.y, convertPointFromAncestorToDescendant4.y));
        return rectF2;
    }

    public static RectF convertRectFromDescendantToAncestor(View view, View view2, RectF rectF) {
        if (view2 == null || view == null) {
            LLog.e(TAG, "convertPointFromAncestorToDescendant failed since ancestor or descendant is null");
            return rectF;
        }
        if (view2 == view) {
            return rectF;
        }
        PointF pointF = new PointF(rectF.left, rectF.top);
        PointF pointF2 = new PointF(rectF.right, rectF.top);
        PointF pointF3 = new PointF(rectF.left, rectF.bottom);
        PointF pointF4 = new PointF(rectF.right, rectF.bottom);
        PointF convertPointFromDescendantToAncestor = convertPointFromDescendantToAncestor(view, view2, pointF);
        PointF convertPointFromDescendantToAncestor2 = convertPointFromDescendantToAncestor(view, view2, pointF2);
        PointF convertPointFromDescendantToAncestor3 = convertPointFromDescendantToAncestor(view, view2, pointF3);
        PointF convertPointFromDescendantToAncestor4 = convertPointFromDescendantToAncestor(view, view2, pointF4);
        RectF rectF2 = new RectF();
        rectF2.left = Math.min(Math.min(convertPointFromDescendantToAncestor.x, convertPointFromDescendantToAncestor2.x), Math.min(convertPointFromDescendantToAncestor3.x, convertPointFromDescendantToAncestor4.x));
        rectF2.top = Math.min(Math.min(convertPointFromDescendantToAncestor.y, convertPointFromDescendantToAncestor2.y), Math.min(convertPointFromDescendantToAncestor3.y, convertPointFromDescendantToAncestor4.y));
        rectF2.right = Math.max(Math.max(convertPointFromDescendantToAncestor.x, convertPointFromDescendantToAncestor2.x), Math.max(convertPointFromDescendantToAncestor3.x, convertPointFromDescendantToAncestor4.x));
        rectF2.bottom = Math.max(Math.max(convertPointFromDescendantToAncestor.y, convertPointFromDescendantToAncestor2.y), Math.max(convertPointFromDescendantToAncestor3.y, convertPointFromDescendantToAncestor4.y));
        return rectF2;
    }

    public static RectF convertRectFromViewToAnother(View view, View view2, RectF rectF) {
        if (view == null || view2 == null) {
            LLog.e(TAG, "convertRectFromViewToAnother failed since view or another is null");
            return rectF;
        }
        if (view == view2) {
            return rectF;
        }
        if (viewIsParentOfAnotherView(view, view2)) {
            return convertRectFromAncestorToDescendant(view, view2, rectF);
        }
        if (viewIsParentOfAnotherView(view2, view)) {
            return convertRectFromDescendantToAncestor(view, view2, rectF);
        }
        return convertRectFromAncestorToDescendant(view2.getRootView(), view2, convertRectFromDescendantToAncestor(view, view.getRootView(), rectF));
    }

    public static void measureView(View view, int i, int i2) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(i2, 1073741824));
    }
}
