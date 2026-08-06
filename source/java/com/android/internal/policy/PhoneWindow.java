package com.android.internal.policy;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.InputQueue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

/* loaded from: classes2.dex */
public class PhoneWindow extends Window {
    @Override // android.view.Window
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
    }

    @Override // android.view.Window
    public void closeAllPanels() {
    }

    @Override // android.view.Window
    public void closePanel(int i) {
    }

    @Override // android.view.Window
    public View getCurrentFocus() {
        return null;
    }

    @Override // android.view.Window
    public View getDecorView() {
        return null;
    }

    @Override // android.view.Window
    public LayoutInflater getLayoutInflater() {
        return null;
    }

    @Override // android.view.Window
    public int getNavigationBarColor() {
        return 0;
    }

    @Override // android.view.Window
    public int getStatusBarColor() {
        return 0;
    }

    @Override // android.view.Window
    public int getVolumeControlStream() {
        return 0;
    }

    @Override // android.view.Window
    public void invalidatePanelMenu(int i) {
    }

    @Override // android.view.Window
    public boolean isFloating() {
        return false;
    }

    @Override // android.view.Window
    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return false;
    }

    @Override // android.view.Window
    protected void onActive() {
    }

    @Override // android.view.Window
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.view.Window
    public void openPanel(int i, KeyEvent keyEvent) {
    }

    @Override // android.view.Window
    public View peekDecorView() {
        return null;
    }

    @Override // android.view.Window
    public boolean performContextMenuIdentifierAction(int i, int i2) {
        return false;
    }

    @Override // android.view.Window
    public boolean performPanelIdentifierAction(int i, int i2, int i3) {
        return false;
    }

    @Override // android.view.Window
    public boolean performPanelShortcut(int i, int i2, KeyEvent keyEvent, int i3) {
        return false;
    }

    @Override // android.view.Window
    public void restoreHierarchyState(Bundle bundle) {
    }

    @Override // android.view.Window
    public Bundle saveHierarchyState() {
        return null;
    }

    @Override // android.view.Window
    public void setBackgroundDrawable(Drawable drawable) {
    }

    @Override // android.view.Window
    public void setChildDrawable(int i, Drawable drawable) {
    }

    @Override // android.view.Window
    public void setChildInt(int i, int i2) {
    }

    @Override // android.view.Window
    public void setContentView(int i) {
    }

    @Override // android.view.Window
    public void setContentView(View view) {
    }

    @Override // android.view.Window
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
    }

    @Override // android.view.Window
    public void setDecorCaptionShade(int i) {
    }

    @Override // android.view.Window
    public void setFeatureDrawable(int i, Drawable drawable) {
    }

    @Override // android.view.Window
    public void setFeatureDrawableAlpha(int i, int i2) {
    }

    @Override // android.view.Window
    public void setFeatureDrawableResource(int i, int i2) {
    }

    @Override // android.view.Window
    public void setFeatureDrawableUri(int i, Uri uri) {
    }

    @Override // android.view.Window
    public void setFeatureInt(int i, int i2) {
    }

    @Override // android.view.Window
    public void setNavigationBarColor(int i) {
    }

    @Override // android.view.Window
    public void setResizingCaptionDrawable(Drawable drawable) {
    }

    @Override // android.view.Window
    public void setStatusBarColor(int i) {
    }

    @Override // android.view.Window
    public void setTitle(CharSequence charSequence) {
    }

    @Override // android.view.Window
    public void setTitleColor(int i) {
    }

    @Override // android.view.Window
    public void setVolumeControlStream(int i) {
    }

    @Override // android.view.Window
    public boolean superDispatchGenericMotionEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.Window
    public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        return false;
    }

    @Override // android.view.Window
    public boolean superDispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return false;
    }

    @Override // android.view.Window
    public boolean superDispatchTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.Window
    public boolean superDispatchTrackballEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.Window
    public void takeInputQueue(InputQueue.Callback callback) {
    }

    @Override // android.view.Window
    public void takeKeyEvents(boolean z) {
    }

    @Override // android.view.Window
    public void takeSurface(SurfaceHolder.Callback2 callback2) {
    }

    @Override // android.view.Window
    public void togglePanel(int i, KeyEvent keyEvent) {
    }

    public PhoneWindow(Context context) {
        super(context);
    }
}
