package com.bytedance.sysoptimizer.javahook;

/* loaded from: classes5.dex */
public interface OriginMethodKey {
    public static final String KEY_ARRAYLIST_INIT = "java.util.ArrayList()V";
    public static final String KEY_ARRAYLIST_REMOVE = "java.util.ArrayList.remove(I)Ljava/lang/Object;";
    public static final String KEY_ARRAYLIST_REMOVE_1 = "java.util.ArrayList.remove(Ljava/lang/Object;)Z";
    public static final String KEY_Activity_setTheme = "android.app.Activity.setTheme(I)V";
    public static final String KEY_DISPLAYLISTENERDELEGATE_INIT = "android.hardware.display.DisplayManagerGlobal$DisplayListenerDelegate(Landroid/hardware/display/DisplayManager$DisplayListener;Landroid/os/Looper;J)V";
    public static final String KEY_DISPLAYLISTENERDELEGATE_INIT_1 = "android.hardware.display.DisplayManagerGlobal$DisplayListenerDelegate(Landroid/hardware/display/DisplayManager$DisplayListener;Landroid/os/Looper;)V";
    public static final String KEY_DISPLAYLISTENERDELEGATE_INIT_2 = "android.hardware.display.DisplayManagerGlobal$DisplayListenerDelegate(Landroid/hardware/display/DisplayManager$DisplayListener;Ljava/util/concurrent/Executor;)V";
    public static final String KEY_DISPLAYMANAGER_REGISTERDISPLAYLISTENER = "android.hardware.display.DisplayManager.registerDisplayListener(Landroid/hardware/display/DisplayManager$DisplayListener;Landroid/os/Handler;)V";
    public static final String KEY_DecorView_INIT = "com.android.internal.policy.DecorView(Landroid/content/Context;ILcom/android/internal/policy/PhoneWindow;Landroid/view/WindowManager$LayoutParams;)V";
    public static final String KEY_FRAMEDATA_UPDATE = "android.view.Choreographer$FrameData.update(JLandroid/view/DisplayEventReceiver$VsyncEventData;)Landroid/view/Choreographer$FrameTimeline;";
    public static final String KEY_GET_METHOD = "java.lang.Class.getMethod(Ljava/lang/String;[Ljava/lang/Class;Z)Ljava/lang/reflect/Method;";
    public static final String KEY_PHONEWINDOW_INSTALLDECOR = "com.android.internal.policy.PhoneWindow.installDecor()V";
    public static final String KEY_POST_SYNC_BARRIER = "android.os.MessageQueue.postSyncBarrier()I";
    public static final String KEY_POST_SYNC_BARRIER_2 = "android.os.MessageQueue.postSyncBarrier(J)I";
    public static final String KEY_PROCESS_KILLPROCESS = "android.os.Process.killProcess(I)V";
    public static final String KEY_RECYCLE = "android.graphics.Bitmap.recycle()V";
    public static final String KEY_REMOVE_SYNC_BARRIER = "android.os.MessageQueue.removeSyncBarrier(I)V";
    public static final String KEY_SURFACE_INIT = "android.view.Surface()V";
    public static final String KEY_SURFACE_INIT_1 = "android.view.Surface(J)V";
    public static final String KEY_SURFACE_INIT_2 = "android.view.Surface(Landroid/graphics/SurfaceTexture;)V";
    public static final String KEY_SURFACE_INIT_3 = "android.view.Surface(Landroid/view/SurfaceControl;)V";
    public static final String KEY_SYSTEM_EXIT = "java.lang.System.exit(I)V";
    public static final String KEY_Thread_INIT = "java.lang.Thread()V";
    public static final String KEY_Thread_INIT_1 = "java.lang.Thread(Ljava/lang/Runnable;)V";
    public static final String KEY_VIEWGROUP_REMOVEALLVIEWS = "android.view.ViewGroup.removeAllViews()V";
    public static final String KEY_VIEWGROUP_REMOVEALLVIEWSINLAYOUT = "android.view.ViewGroup.removeAllViewsInLayout()V";
    public static final String KEY_VIEWGROUP_REMOVEVIEW = "android.view.ViewGroup.removeView(Landroid/view/View;)V";
    public static final String KEY_VIEWGROUP_REMOVEVIEWAT = "android.view.ViewGroup.removeViewAt(I)V";
    public static final String KEY_VIEWGROUP_REMOVEVIEWINLAYOUT = "android.view.ViewGroup.removeViewInLayout(Landroid/view/View;)V";
    public static final String KEY_VIEWGROUP_REMOVEVIEWS = "android.view.ViewGroup.removeViews(II)V";
    public static final String KEY_VIEWGROUP_REMOVEVIEWSINLAYOUT = "android.view.ViewGroup.removeViewsInLayout(II)V";
    public static final String KEY_VIEWROOTIMPL_INIT = "android.view.ViewRootImpl(Landroid/content/Context;Landroid/view/Display;)V";
    public static final String KEY_VIEWROOTIMPL_INIT_1 = "android.view.ViewRootImpl(Landroid/content/Context;Landroid/view/Display;Landroid/view/IWindowSession;Landroid/view/WindowLayout;)V";
    public static final String KEY_VIEWROOTIMPL_INIT_2 = "android.view.ViewRootImpl(Landroid/content/Context;Landroid/view/Display;Landroid/view/IWindowSession;)V";
    public static final String KEY_VIEWROOTIMPL_INIT_3 = "android.view.ViewRootImpl(Landroid/content/Context;Landroid/view/Display;Landroid/view/IWindowSession;Z)V";
    public static final String KEY_VIEW_GETMATRIX = "android.view.View.getMatrix()Landroid/graphics/Matrix;";
}
