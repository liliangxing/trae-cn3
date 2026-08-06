package com.bytedance.webx.blankdetect.screenshot;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.webx.core.webview.WebViewContainer;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;

/* loaded from: classes6.dex */
public class ViewContentShot extends FastScreenShot {
    private static Method onDrawMethod;
    private ShotListener shotListener = null;

    /* loaded from: classes6.dex */
    public interface ShotListener {
        boolean watch(Bitmap bitmap);
    }

    public void setShotListener(ShotListener shotListener) {
        this.shotListener = shotListener;
    }

    public ViewContentShot() {
        initOnDrawMethod();
    }

    public void setScale(float f) {
        this.scale = f;
    }

    @Override // com.bytedance.webx.blankdetect.screenshot.FastScreenShot
    protected void tryDraw(View view, Bitmap bitmap) {
        Canvas canvas = new Canvas(bitmap);
        view.computeScroll();
        canvas.translate(-view.getScrollX(), -view.getScrollY());
        draw(view, canvas, bitmap);
    }

    protected void draw(View view, Canvas canvas, Bitmap bitmap) {
        LinkedList linkedList = new LinkedList();
        linkedList.offer(view);
        while (!linkedList.isEmpty()) {
            View view2 = (View) linkedList.poll();
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    linkedList.offer(viewGroup.getChildAt(i));
                }
            }
            reflectCallOnDraw(view2, canvas);
            ShotListener shotListener = this.shotListener;
            if (shotListener != null && !shotListener.watch(bitmap)) {
                linkedList.clear();
            }
        }
    }

    private boolean reflectCallOnDraw(View view, Canvas canvas) {
        try {
            onDrawMethod.invoke(view, canvas);
            return true;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return false;
        } catch (InvocationTargetException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    private void initOnDrawMethod() {
        if (onDrawMethod == null) {
            try {
                Method declaredMethod = View.class.getDeclaredMethod(WebViewContainer.EVENT_onDraw, Canvas.class);
                onDrawMethod = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
    }
}
