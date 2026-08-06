package com.lynx.tasm.ui.image;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes7.dex */
public class ImageRequestJobScheduler extends HandlerThread {
    private static volatile ImageRequestJobScheduler sInstance;
    private List<Runnable> mCacheAsyncRunnableList;
    private List<Runnable> mCacheRunnableList;
    private Handler mImageAsyncHandler;
    private Handler mImageBgHandler;

    public static ImageRequestJobScheduler instance() {
        if (sInstance == null) {
            synchronized (ImageRequestJobScheduler.class) {
                if (sInstance == null) {
                    sInstance = new ImageRequestJobScheduler();
                }
            }
        }
        return sInstance;
    }

    private ImageRequestJobScheduler() {
        super("Lynx_image");
        start();
    }

    @Override // android.os.HandlerThread
    protected void onLooperPrepared() {
        super.onLooperPrepared();
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.lynx.tasm.ui.image.ImageRequestJobScheduler.1
            @Override // java.lang.Runnable
            public void run() {
                ImageRequestJobScheduler.this.handleLooperPreparedOnUIThread();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleLooperPreparedOnUIThread() {
        this.mImageAsyncHandler = new Handler(getLooper());
        this.mImageBgHandler = new Handler(Looper.myLooper());
        List<Runnable> list = this.mCacheRunnableList;
        if (list != null && !list.isEmpty()) {
            Iterator<Runnable> it = this.mCacheRunnableList.iterator();
            while (it.hasNext()) {
                this.mImageBgHandler.post(it.next());
            }
            this.mCacheRunnableList.clear();
        }
        List<Runnable> list2 = this.mCacheAsyncRunnableList;
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        Iterator<Runnable> it2 = this.mCacheAsyncRunnableList.iterator();
        while (it2.hasNext()) {
            this.mImageAsyncHandler.post(it2.next());
        }
        this.mCacheAsyncRunnableList.clear();
    }

    public void schedule(Runnable runnable) {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            return;
        }
        Handler handler = this.mImageBgHandler;
        if (handler == null) {
            if (this.mCacheRunnableList == null) {
                this.mCacheRunnableList = new LinkedList();
            }
            this.mCacheRunnableList.add(runnable);
            return;
        }
        handler.post(runnable);
    }

    public void scheduleAsync(Runnable runnable) {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            return;
        }
        Handler handler = this.mImageAsyncHandler;
        if (handler == null) {
            if (this.mCacheAsyncRunnableList == null) {
                this.mCacheAsyncRunnableList = new LinkedList();
            }
            this.mCacheAsyncRunnableList.add(runnable);
            return;
        }
        handler.post(runnable);
    }
}
