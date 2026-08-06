package com.lynx.tasm.behavior.p000ui.utils;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.RectF;
import android.view.View;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.PropsConstants;
import com.lynx.tasm.behavior.p000ui.LynxBaseUI;
import com.lynx.tasm.behavior.p000ui.LynxUI;
import com.lynx.tasm.behavior.p000ui.UIBody;
import com.lynx.tasm.behavior.p000ui.UIParent;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class LynxUIHelper {
    static final String TAG = "LynxUIHelper";

    /* JADX WARN: Type inference failed for: r6v1, types: [android.view.View] */
    public static PointF convertPointFromUIToRootUI(LynxBaseUI lynxBaseUI, PointF pointF) {
        View view;
        if (lynxBaseUI == null) {
            LLog.e(TAG, "convertPointFromUIToRootUI failed since descendant ui is null");
            return pointF;
        }
        LynxContext lynxContext = lynxBaseUI.getLynxContext();
        if (lynxContext == null) {
            LLog.e(TAG, "convertPointFromUIToRootUI failed since context is null");
            return pointF;
        }
        UIBody uIBody = lynxContext.getUIBody();
        if (uIBody == null) {
            LLog.e(TAG, "convertPointFromUIToRootUI failed since root ui is null");
            return pointF;
        }
        if (lynxBaseUI == uIBody) {
            return pointF;
        }
        PointF pointF2 = new PointF(pointF.x, pointF.y);
        if (lynxBaseUI.isFlatten()) {
            pointF2.x += lynxBaseUI.getLeft();
            pointF2.y += lynxBaseUI.getTop();
            if (lynxBaseUI.getDrawParent() == null) {
                LLog.e(TAG, "mDrawParent of flattenUI is null, which causes the value convertPointFromUIToRootUI returns is not the correct coordinates relative to the root ui!");
                return pointF;
            }
            view = ((LynxUI) lynxBaseUI.getDrawParent()).getView();
            pointF2.x -= view.getScrollX();
            pointF2.y -= view.getScrollY();
        } else {
            view = ((LynxUI) lynxBaseUI).getView();
        }
        return ViewHelper.convertPointFromViewToAnother(view, uIBody.getView(), pointF2);
    }

    public static PointF convertPointFromUIToScreen(LynxBaseUI lynxBaseUI, PointF pointF) {
        View view;
        if (lynxBaseUI == null) {
            LLog.e(TAG, "convertPointFromUIToScreen failed since ui is null");
            return pointF;
        }
        PointF pointF2 = new PointF(pointF.x, pointF.y);
        if (lynxBaseUI.isFlatten()) {
            pointF2.x += lynxBaseUI.getLeft();
            pointF2.y += lynxBaseUI.getTop();
            if (lynxBaseUI.getDrawParent() == null) {
                LLog.e(TAG, "mDrawParent of flattenUI is null, which causes the value convertPointFromUIToScreen returns is not the correct coordinates relative to the screen!");
                return pointF;
            }
            view = ((LynxUI) lynxBaseUI.getDrawParent()).getView();
            pointF2.x -= view.getScrollX();
            pointF2.y -= view.getScrollY();
        } else {
            view = ((LynxUI) lynxBaseUI).getView();
        }
        return ViewHelper.convertPointFromDescendantToAncestor(view, view.getRootView(), pointF2);
    }

    public static RectF convertRectFromUIToRootUI(LynxBaseUI lynxBaseUI, RectF rectF) {
        LynxContext lynxContext = lynxBaseUI.getLynxContext();
        if (lynxContext == null) {
            LLog.e(TAG, "convertRectFromUIToRootUI failed since context is null");
            return rectF;
        }
        UIBody uIBody = lynxContext.getUIBody();
        if (uIBody == null) {
            LLog.e(TAG, "convertRectFromUIToRootUI failed since rootUI is null");
            return rectF;
        }
        return convertRectFromUIToAnotherUI(lynxBaseUI, uIBody, rectF);
    }

    public static RectF convertRectFromUIToAnotherUI(LynxBaseUI lynxBaseUI, LynxBaseUI lynxBaseUI2, RectF rectF) {
        View view;
        View view2;
        float f;
        if (lynxBaseUI == null) {
            LLog.e(TAG, "convertRectFromUIToRootUI failed since descendant is null");
            return rectF;
        }
        if (lynxBaseUI2 == null) {
            LLog.e(TAG, "convertRectFromUIToRootUI failed since another ui is null");
            return rectF;
        }
        if (lynxBaseUI == lynxBaseUI2) {
            return rectF;
        }
        RectF rectF2 = new RectF(rectF.left, rectF.top, rectF.right, rectF.bottom);
        if (lynxBaseUI.isFlatten()) {
            rectF2.left += lynxBaseUI.getLeft();
            rectF2.top += lynxBaseUI.getTop();
            if (lynxBaseUI.getDrawParent() == null) {
                LLog.e(TAG, "mDrawParent of flattenUI is null, which causes the value convertRectFromUIToAnotherUI returns is not the correct coordinates relative to the another ui!");
                return rectF;
            }
            view = ((LynxUI) lynxBaseUI.getDrawParent()).getView();
            rectF2.left -= view.getScrollX();
            rectF2.top -= view.getScrollY();
            rectF2.right = rectF2.left + rectF.width();
            rectF2.bottom = rectF2.top + rectF.height();
        } else {
            view = ((LynxUI) lynxBaseUI).getView();
        }
        float f2 = 0.0f;
        if (lynxBaseUI2.isFlatten()) {
            float left = lynxBaseUI2.getLeft() + 0.0f;
            float top = lynxBaseUI2.getTop() + 0.0f;
            if (lynxBaseUI2.getDrawParent() == null) {
                LLog.e(TAG, "mDrawParent of flattenUI is null, which causes the value convertRectFromUIToAnotherUI returns is not the correct coordinates relative to the another ui!");
                return rectF;
            }
            view2 = ((LynxUI) lynxBaseUI2.getDrawParent()).getView();
            f2 = left - view2.getScrollX();
            f = top - view2.getScrollY();
        } else {
            view2 = ((LynxUI) lynxBaseUI2).getView();
            f = 0.0f;
        }
        RectF convertRectFromViewToAnother = ViewHelper.convertRectFromViewToAnother(view, view2, rectF2);
        convertRectFromViewToAnother.offset(-f2, -f);
        return convertRectFromViewToAnother;
    }

    public static RectF convertRectFromUIToScreen(LynxBaseUI lynxBaseUI, RectF rectF) {
        View view;
        if (lynxBaseUI == null) {
            LLog.e(TAG, "convertRectFromUIToScreen failed since ancestor or descendant is null");
            return rectF;
        }
        RectF rectF2 = new RectF(rectF.left, rectF.top, rectF.right, rectF.bottom);
        if (lynxBaseUI.isFlatten()) {
            rectF2.left += lynxBaseUI.getLeft();
            rectF2.top += lynxBaseUI.getTop();
            if (lynxBaseUI.getDrawParent() == null) {
                LLog.e(TAG, "mDrawParent of flattenUI is null, which causes the value convertRectFromUIToScreen returns is not the correct coordinates relative to the screen!");
                return rectF;
            }
            view = ((LynxUI) lynxBaseUI.getDrawParent()).getView();
            rectF2.left -= view.getScrollX();
            rectF2.top -= view.getScrollY();
            rectF2.right = rectF2.left + rectF.width();
            rectF2.bottom = rectF2.top + rectF.height();
        } else {
            view = ((LynxUI) lynxBaseUI).getView();
        }
        return ViewHelper.convertRectFromDescendantToAncestor(view, view.getRootView(), rectF2);
    }

    public static int px2dip(Context context, float f) {
        return (context == null || context.getResources() == null || context.getResources().getDisplayMetrics() == null) ? (int) f : (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5d);
    }

    public static LynxBaseUI getRelativeUI(LynxBaseUI lynxBaseUI, String str) {
        if (lynxBaseUI == null || str == null) {
            LLog.e(TAG, "getRelativeUI failed since ui or relativeID is null");
            return null;
        }
        UIParent parent = lynxBaseUI.getParent();
        while (true) {
            LynxBaseUI lynxBaseUI2 = (LynxBaseUI) parent;
            if (lynxBaseUI2 instanceof LynxBaseUI) {
                if (str.equals(lynxBaseUI2.getIdSelector())) {
                    return lynxBaseUI2;
                }
                parent = lynxBaseUI2.getParent();
            } else {
                if (lynxBaseUI.getLynxContext() == null) {
                    LLog.e(TAG, "getRelativeUI failed since context is null");
                    return null;
                }
                if (lynxBaseUI.getLynxContext().getLynxUIOwner() == null) {
                    LLog.e(TAG, "getRelativeUI failed since uiowner is null");
                    return null;
                }
                return lynxBaseUI.getLynxContext().getLynxUIOwner().findLynxUIByIdSelector(str);
            }
        }
    }

    public static RectF getRelativePositionInfo(LynxBaseUI lynxBaseUI, ReadableMap readableMap) {
        if (readableMap != null && readableMap.getBoolean(PropsConstants.ANDROID_ENABLE_TRANSFORM_PROPS, false)) {
            String string = (readableMap == null || !readableMap.hasKey("relativeTo") || readableMap.getString("relativeTo") == null) ? null : readableMap.getString("relativeTo");
            LynxBaseUI relativeUI = getRelativeUI(lynxBaseUI, string);
            if ("screen".equals(string)) {
                return convertRectFromUIToScreen(lynxBaseUI, new RectF(0.0f, 0.0f, lynxBaseUI.getWidth(), lynxBaseUI.getHeight()));
            }
            if (relativeUI != null) {
                return convertRectFromUIToAnotherUI(lynxBaseUI, relativeUI, new RectF(0.0f, 0.0f, lynxBaseUI.getWidth(), lynxBaseUI.getHeight()));
            }
            return convertRectFromUIToRootUI(lynxBaseUI, new RectF(0.0f, 0.0f, lynxBaseUI.getWidth(), lynxBaseUI.getHeight()));
        }
        return new RectF(lynxBaseUI.getBoundingClientRect());
    }
}
