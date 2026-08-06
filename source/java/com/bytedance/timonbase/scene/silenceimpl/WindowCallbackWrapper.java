package com.bytedance.timonbase.scene.silenceimpl;

import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import com.bytedance.bdturing.methods.JsCallParser;
import com.bytedance.webx.core.webview.WebViewContainer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WindowCallbackWrapper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\tH\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0016J\b\u0010\u0015\u001a\u00020\u0010H\u0016J\u0018\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u001d\u001a\u00020\u0010H\u0016J\u0018\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0018\u0010!\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0018\u0010\"\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\"\u0010#\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010$\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010%\u001a\u00020\u0005H\u0016J\u0010\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020'H\u0017J\u0010\u0010(\u001a\u00020\u00102\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u0010+\u001a\u00020\u00102\u0006\u0010,\u001a\u00020\u0005H\u0016J\u0012\u0010-\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0002\u001a\u00020.H\u0016J\u001a\u0010-\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0002\u001a\u00020.2\u0006\u0010/\u001a\u00020\u0018H\u0017R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/bytedance/timonbase/scene/silenceimpl/WindowCallbackWrapper;", "Landroid/view/Window$Callback;", JsCallParser.VALUE_CALLBACK, "(Landroid/view/Window$Callback;)V", "dispatchGenericMotionEvent", "", "event", "Landroid/view/MotionEvent;", WebViewContainer.EVENT_dispatchKeyEvent, "Landroid/view/KeyEvent;", "dispatchKeyShortcutEvent", "dispatchPopulateAccessibilityEvent", "Landroid/view/accessibility/AccessibilityEvent;", WebViewContainer.EVENT_dispatchTouchEvent, "dispatchTrackballEvent", "onActionModeFinished", "", "mode", "Landroid/view/ActionMode;", "onActionModeStarted", WebViewContainer.EVENT_onAttachedToWindow, "onContentChanged", "onCreatePanelMenu", "featureId", "", "menu", "Landroid/view/Menu;", "onCreatePanelView", "Landroid/view/View;", "onDetachedFromWindow", "onMenuItemSelected", "item", "Landroid/view/MenuItem;", "onMenuOpened", "onPanelClosed", "onPreparePanel", "view", "onSearchRequested", "searchEvent", "Landroid/view/SearchEvent;", "onWindowAttributesChanged", "attrs", "Landroid/view/WindowManager$LayoutParams;", "onWindowFocusChanged", "hasFocus", "onWindowStartingActionMode", "Landroid/view/ActionMode$Callback;", "type", "timonbase_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes5.dex */
public final class WindowCallbackWrapper implements Window.Callback {
    private final Window.Callback callback;

    public WindowCallbackWrapper(Window.Callback callback) {
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        this.callback = callback;
    }

    @Override // android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent event) {
        Intrinsics.checkParameterIsNotNull(event, "event");
        InputEventHappenRecordHolder.INSTANCE.keyEventHappen();
        return this.callback.dispatchKeyEvent(event);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent event) {
        Intrinsics.checkParameterIsNotNull(event, "event");
        InputEventHappenRecordHolder.INSTANCE.shortKeyShortCutEventHappen();
        return this.callback.dispatchKeyShortcutEvent(event);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent event) {
        Intrinsics.checkParameterIsNotNull(event, "event");
        if (event.getAction() == 0) {
            InputEventHappenRecordHolder.INSTANCE.touchEventHappen();
        }
        return this.callback.dispatchTouchEvent(event);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchTrackballEvent(MotionEvent event) {
        Intrinsics.checkParameterIsNotNull(event, "event");
        return this.callback.dispatchTrackballEvent(event);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchGenericMotionEvent(MotionEvent event) {
        Intrinsics.checkParameterIsNotNull(event, "event");
        return this.callback.dispatchGenericMotionEvent(event);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        Intrinsics.checkParameterIsNotNull(event, "event");
        return this.callback.dispatchPopulateAccessibilityEvent(event);
    }

    @Override // android.view.Window.Callback
    public View onCreatePanelView(int featureId) {
        return this.callback.onCreatePanelView(featureId);
    }

    @Override // android.view.Window.Callback
    public boolean onCreatePanelMenu(int featureId, Menu menu) {
        Intrinsics.checkParameterIsNotNull(menu, "menu");
        return this.callback.onCreatePanelMenu(featureId, menu);
    }

    @Override // android.view.Window.Callback
    public boolean onPreparePanel(int featureId, View view, Menu menu) {
        Intrinsics.checkParameterIsNotNull(menu, "menu");
        return this.callback.onPreparePanel(featureId, view, menu);
    }

    @Override // android.view.Window.Callback
    public boolean onMenuOpened(int featureId, Menu menu) {
        Intrinsics.checkParameterIsNotNull(menu, "menu");
        return this.callback.onMenuOpened(featureId, menu);
    }

    @Override // android.view.Window.Callback
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        Intrinsics.checkParameterIsNotNull(item, "item");
        return this.callback.onMenuItemSelected(featureId, item);
    }

    @Override // android.view.Window.Callback
    public void onWindowAttributesChanged(WindowManager.LayoutParams attrs) {
        Intrinsics.checkParameterIsNotNull(attrs, "attrs");
        this.callback.onWindowAttributesChanged(attrs);
    }

    @Override // android.view.Window.Callback
    public void onContentChanged() {
        this.callback.onContentChanged();
    }

    @Override // android.view.Window.Callback
    public void onWindowFocusChanged(boolean hasFocus) {
        this.callback.onWindowFocusChanged(hasFocus);
    }

    @Override // android.view.Window.Callback
    public void onAttachedToWindow() {
        this.callback.onAttachedToWindow();
    }

    @Override // android.view.Window.Callback
    public void onDetachedFromWindow() {
        this.callback.onDetachedFromWindow();
    }

    @Override // android.view.Window.Callback
    public void onPanelClosed(int featureId, Menu menu) {
        Intrinsics.checkParameterIsNotNull(menu, "menu");
        this.callback.onPanelClosed(featureId, menu);
    }

    @Override // android.view.Window.Callback
    public boolean onSearchRequested() {
        return this.callback.onSearchRequested();
    }

    @Override // android.view.Window.Callback
    public boolean onSearchRequested(SearchEvent searchEvent) {
        Intrinsics.checkParameterIsNotNull(searchEvent, "searchEvent");
        return this.callback.onSearchRequested(searchEvent);
    }

    @Override // android.view.Window.Callback
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        return this.callback.onWindowStartingActionMode(callback);
    }

    @Override // android.view.Window.Callback
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int type) {
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        return this.callback.onWindowStartingActionMode(callback, type);
    }

    @Override // android.view.Window.Callback
    public void onActionModeStarted(ActionMode mode) {
        Intrinsics.checkParameterIsNotNull(mode, "mode");
        this.callback.onActionModeStarted(mode);
    }

    @Override // android.view.Window.Callback
    public void onActionModeFinished(ActionMode mode) {
        Intrinsics.checkParameterIsNotNull(mode, "mode");
        this.callback.onActionModeFinished(mode);
    }
}
