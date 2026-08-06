package com.ss.ttm.player;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import android.view.Surface;
import com.xiaomi.mipush.sdk.Constants;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: classes7.dex */
public final class DummySurface extends Surface {
    public static final int CACHE_MODE_ALL = 1;
    public static final int CACHE_MODE_DYNAMIC_EXCEPTION = 2;
    public static final int CACHE_MODE_DYNAMIC_EXCEPTION_OTHER = 3;
    public static final int CACHE_MODE_FORBIDDEN_EXCEPTION = 4;
    public static final int CACHE_MODE_FORBIDDEN_EXCEPTION_OTHER = 5;
    public static final int EVENT_SETOUTPUTSSURFACE_EXCEPTION = 1;
    public static final int EVENT_SETOUTPUTSSURFACE_EXCEPTION_OTHER = 2;
    private static final String EXTENSION_PROTECTED_CONTENT = "EGL_EXT_protected_content";
    private static final String EXTENSION_SURFACELESS_CONTEXT = "EGL_KHR_surfaceless_context";
    private static final int MAX_CAPACITY_CACHES = 2;
    private static int SetOutputSurfaceExceptionCounter = 0;
    private static volatile int SetOutputSurfaceExceptionLimit = 1;
    private static int SetOutputSurfaceExceptionOtherCounter = 0;
    private static volatile int SetOutputSurfaceExceptionOtherLimit = 1;
    private static final String TAG = "DummySurface";
    private static int secureMode;
    private static boolean secureModeInitialized;
    private volatile boolean cached;
    private boolean hasSetOutputSurfaceException;
    private boolean hasSetOutputSurfaceExceptionOther;
    public final boolean secure;
    private final DummySurfaceThread thread;
    private boolean threadReleased;
    private static final ConcurrentLinkedQueue<DummySurface> caches = new ConcurrentLinkedQueue<>();
    private static volatile boolean useDummySurfaceCaches = false;
    private static volatile int cacheMode = 1;

    private static void assertApiLevel17OrHigher() {
    }

    public static void useCaches(boolean useDummySurfaceCaches2) {
        useCaches(useDummySurfaceCaches2, 1);
    }

    public static void useCaches(boolean useDummySurfaceCaches2, int mode) {
        useCaches(useDummySurfaceCaches2, mode, SetOutputSurfaceExceptionLimit);
    }

    public static void useCaches(boolean useDummySurfaceCaches2, int mode, int limit) {
        Log.d(TAG, "useCaches:" + useDummySurfaceCaches2 + Constants.COLON_SEPARATOR + mode + Constants.COLON_SEPARATOR + limit);
        useDummySurfaceCaches = useDummySurfaceCaches2;
        cacheMode = mode;
        if (mode == 4) {
            SetOutputSurfaceExceptionLimit = limit;
        } else if (mode == 5) {
            SetOutputSurfaceExceptionOtherLimit = limit;
        }
        if (useDummySurfaceCaches) {
            return;
        }
        while (true) {
            ConcurrentLinkedQueue<DummySurface> concurrentLinkedQueue = caches;
            if (concurrentLinkedQueue.isEmpty()) {
                return;
            }
            DummySurface poll = concurrentLinkedQueue.poll();
            if (poll != null) {
                poll.release();
            }
        }
    }

    public static synchronized boolean isSecureSupported(Context context) {
        boolean z;
        synchronized (DummySurface.class) {
            if (!secureModeInitialized) {
                secureMode = getSecureModeV24(context);
                secureModeInitialized = true;
            }
            z = secureMode != 0;
        }
        return z;
    }

    public static DummySurface newInstanceV17(boolean secure) {
        DummySurface poll;
        if (useDummySurfaceCaches && !secure && (poll = caches.poll()) != null) {
            poll.cached = false;
            Log.d(TAG, "get cached DummySurface@" + poll.hashCode());
            return poll;
        }
        return newInstanceV17Internal(secure);
    }

    private static DummySurface newInstanceV17Internal(boolean secure) {
        Log.d(TAG, "create DummySurface internal:" + secure);
        assertApiLevel17OrHigher();
        return new DummySurfaceThread().init(secure ? secureMode : 0);
    }

    private DummySurface(DummySurfaceThread thread, SurfaceTexture surfaceTexture, boolean secure) {
        super(surfaceTexture);
        this.cached = false;
        this.hasSetOutputSurfaceException = false;
        this.hasSetOutputSurfaceExceptionOther = false;
        this.thread = thread;
        this.secure = secure;
    }

    public void addEvent(int event) {
        if (event == 1) {
            this.hasSetOutputSurfaceException = true;
            this.hasSetOutputSurfaceExceptionOther = true;
        } else {
            if (event != 2) {
                return;
            }
            this.hasSetOutputSurfaceExceptionOther = true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0065  */
    @Override // android.view.Surface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void release() {
        boolean z = false;
        boolean z2 = useDummySurfaceCaches && caches.size() <= 2 && !this.secure && isValid();
        if (z2) {
            if ((cacheMode != 2 || !this.hasSetOutputSurfaceException) && (cacheMode != 3 || !this.hasSetOutputSurfaceExceptionOther)) {
                if (cacheMode == 4 && this.hasSetOutputSurfaceException) {
                    int i = SetOutputSurfaceExceptionCounter + 1;
                    SetOutputSurfaceExceptionCounter = i;
                    if (i >= SetOutputSurfaceExceptionLimit) {
                        useCaches(false);
                    }
                } else if (cacheMode == 5 && this.hasSetOutputSurfaceExceptionOther) {
                    int i2 = SetOutputSurfaceExceptionOtherCounter + 1;
                    SetOutputSurfaceExceptionOtherCounter = i2;
                    if (i2 >= SetOutputSurfaceExceptionOtherLimit) {
                        useCaches(false);
                    }
                }
            }
            if (z) {
                releaseInternal();
                return;
            } else {
                if (this.cached) {
                    return;
                }
                caches.add(this);
                this.cached = true;
                Log.d(TAG, "cache DummySurface@" + hashCode());
                return;
            }
        }
        z = z2;
        if (z) {
        }
    }

    private void releaseInternal() {
        Log.d(TAG, "release DummySurface internal@" + hashCode());
        super.release();
        synchronized (this.thread) {
            if (!this.threadReleased) {
                this.thread.release();
                this.threadReleased = true;
            }
        }
    }

    private static int getSecureModeV24(Context context) {
        String eglQueryString;
        if ((Build.VERSION.SDK_INT >= 26 || !("samsung".equals(Build.MANUFACTURER) || "XT1650".equals(Build.MODEL))) && (eglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373)) != null && eglQueryString.contains(EXTENSION_PROTECTED_CONTENT)) {
            return eglQueryString.contains(EXTENSION_SURFACELESS_CONTEXT) ? 1 : 2;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class DummySurfaceThread extends HandlerThread implements Handler.Callback {
        private static final int MSG_INIT = 1;
        private static final int MSG_RELEASE = 2;
        private EGLSurfaceTexture eglSurfaceTexture;
        private Handler handler;
        private Error initError;
        private RuntimeException initException;
        private DummySurface surface;

        public DummySurfaceThread() {
            super("dummySurface");
        }

        public DummySurface init(int secureMode) {
            boolean z;
            start();
            this.handler = new Handler(getLooper(), this);
            this.eglSurfaceTexture = new EGLSurfaceTexture(this.handler);
            synchronized (this) {
                z = false;
                this.handler.obtainMessage(1, secureMode, 0).sendToTarget();
                while (this.surface == null && this.initException == null && this.initError == null) {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                        z = true;
                    }
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
            RuntimeException runtimeException = this.initException;
            if (runtimeException != null) {
                throw runtimeException;
            }
            Error error = this.initError;
            if (error != null) {
                throw error;
            }
            DummySurface dummySurface = this.surface;
            dummySurface.getClass();
            return dummySurface;
        }

        public void release() {
            Handler handler = this.handler;
            handler.getClass();
            handler.sendEmptyMessage(2);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message msg) {
            int i = msg.what;
            try {
                if (i != 1) {
                    if (i != 2) {
                        return true;
                    }
                    try {
                        releaseInternal();
                    } finally {
                        try {
                            return true;
                        } finally {
                        }
                    }
                    return true;
                }
                try {
                    initInternal(msg.arg1);
                    synchronized (this) {
                        notify();
                    }
                } catch (Error e) {
                    Log.e(DummySurface.TAG, "Failed to initialize dummy surface", e);
                    this.initError = e;
                    synchronized (this) {
                        notify();
                    }
                } catch (RuntimeException e2) {
                    Log.e(DummySurface.TAG, "Failed to initialize dummy surface", e2);
                    this.initException = e2;
                    synchronized (this) {
                        notify();
                    }
                }
                return true;
            } catch (Throwable th) {
                synchronized (this) {
                    notify();
                    throw th;
                }
            }
        }

        private void initInternal(int secureMode) {
            EGLSurfaceTexture eGLSurfaceTexture = this.eglSurfaceTexture;
            eGLSurfaceTexture.getClass();
            eGLSurfaceTexture.init(secureMode);
            this.surface = new DummySurface(this, this.eglSurfaceTexture.getSurfaceTexture(), secureMode != 0);
        }

        private void releaseInternal() {
            EGLSurfaceTexture eGLSurfaceTexture = this.eglSurfaceTexture;
            eGLSurfaceTexture.getClass();
            eGLSurfaceTexture.release();
        }
    }
}
