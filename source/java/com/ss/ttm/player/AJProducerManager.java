package com.ss.ttm.player;

import android.media.ImageReader;
import android.os.Build;
import android.os.Handler;
import android.view.Surface;
import com.ss.ttm.utils.AVLogger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes7.dex */
public class AJProducerManager {
    private static final int DEFAULT_MAX_CACHE_SIZE = 2;
    public static final int DEFAULT_MAX_IMAGE = 2;
    public static final int IMAGEREADER_STATUS = 1;
    public static final int IMAGEREADER_STATUS_CLOSE = 1;
    public static final int IMAGEREADER_STATUS_OPEN = 2;
    private static int MaxImages = 2;
    public static final int NATIVE_WINDOW_API_CPU = 2;
    public static final int NATIVE_WINDOW_API_EGL = 1;
    public static final int NATIVE_WINDOW_API_MEDIA = 3;
    public static final int NATIVE_WINDOW_API_NONE = 0;
    private static final String TAG = "AJProducerManager";
    private static HashMap<Long, ImageReaderListenerWrapper> mIRLWrapperMap = new HashMap<>();
    private static ArrayList<AJImageReaderProducer> mFreeIRProducerList = new ArrayList<>();
    private static ArrayList<AJImageReaderProducer> mUsingIRProducerList = new ArrayList<>();

    /* loaded from: classes7.dex */
    private static class ImageReaderListenerWrapper {
        public Handler handler;
        public ImageReader.OnImageAvailableListener listener;

        public ImageReaderListenerWrapper(ImageReader.OnImageAvailableListener listener, Handler handler) {
            this.listener = listener;
            this.handler = handler;
        }
    }

    public static void setMaxImages(int maxImages) {
        if (maxImages <= 0) {
            maxImages = 2;
        }
        MaxImages = maxImages;
    }

    public static synchronized void setOnImageAvailableListener(long playerId, ImageReader.OnImageAvailableListener listener, Handler handler) {
        synchronized (AJProducerManager.class) {
            AVLogger.d(TAG, "setOnImageAvailableListener,playerId:" + playerId + ",listener:" + listener + ",handler:" + handler);
            if (playerId == 0) {
                return;
            }
            if (listener == null) {
                mIRLWrapperMap.remove(Long.valueOf(playerId));
            } else {
                mIRLWrapperMap.put(Long.valueOf(playerId), new ImageReaderListenerWrapper(listener, handler));
            }
            Iterator<AJImageReaderProducer> it = mUsingIRProducerList.iterator();
            while (it.hasNext()) {
                AJImageReaderProducer next = it.next();
                if (next.mUsingPlayerId == playerId) {
                    next.setOnImageAvailableListener(listener, handler);
                }
            }
        }
    }

    public static synchronized Surface getAvailableSurface(long playerId, int apiType, int producerType) {
        synchronized (AJProducerManager.class) {
            if (playerId == 0) {
                return null;
            }
            ImageReaderListenerWrapper imageReaderListenerWrapper = mIRLWrapperMap.get(Long.valueOf(playerId));
            if (imageReaderListenerWrapper == null) {
                AVLogger.w(TAG, "no listener,playerId:" + playerId);
                return null;
            }
            Iterator<AJImageReaderProducer> it = mUsingIRProducerList.iterator();
            while (it.hasNext()) {
                AJImageReaderProducer next = it.next();
                if (next.mUsingPlayerId == playerId && next.mApiType == apiType) {
                    return next.getSurface();
                }
            }
            Iterator<AJImageReaderProducer> it2 = mFreeIRProducerList.iterator();
            while (it2.hasNext()) {
                AJImageReaderProducer next2 = it2.next();
                if ((apiType == 2 && next2.mApiType == 2) || (apiType != 2 && next2.mApiType != 2)) {
                    it2.remove();
                    next2.mUsingPlayerId = playerId;
                    mUsingIRProducerList.add(next2);
                    next2.setOnImageAvailableListener(imageReaderListenerWrapper.listener, imageReaderListenerWrapper.handler);
                    return next2.getSurface();
                }
            }
            AJImageReaderProducer aJImageReaderProducer = new AJImageReaderProducer(playerId, MaxImages, apiType);
            mUsingIRProducerList.add(aJImageReaderProducer);
            aJImageReaderProducer.setOnImageAvailableListener(imageReaderListenerWrapper.listener, imageReaderListenerWrapper.handler);
            return aJImageReaderProducer.getSurface();
        }
    }

    public static synchronized void releaseSurface(long playerId, int apiType) {
        synchronized (AJProducerManager.class) {
            Iterator<AJImageReaderProducer> it = mUsingIRProducerList.iterator();
            while (it.hasNext()) {
                AJImageReaderProducer next = it.next();
                if (next.mUsingPlayerId == playerId && next.mApiType == apiType) {
                    it.remove();
                    next.setOnImageAvailableListener(null, null);
                    next.mUsingPlayerId = 0L;
                    if (mFreeIRProducerList.size() >= 2) {
                        mFreeIRProducerList.remove(0).release();
                    }
                    mFreeIRProducerList.add(next);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void notifyImageReaderStatus(ImageReader.OnImageAvailableListener listener, int status) {
        if (listener != null) {
            try {
                listener.getClass().getDeclaredMethod("setIntOption", Integer.TYPE, Integer.TYPE).invoke(listener, 1, Integer.valueOf(status));
            } catch (Exception unused) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class AJImageReaderProducer {
        private int mApiType;
        private ImageReader mImageReader;
        private ImageReader.OnImageAvailableListener mListener;
        private long mUsingPlayerId;

        public AJImageReaderProducer(long playerId, int maxImages, int apiType) {
            this.mApiType = 0;
            this.mUsingPlayerId = 0L;
            if (Build.VERSION.SDK_INT >= 29) {
                this.mImageReader = ImageReader.newInstance(1, 1, 35, maxImages <= 0 ? 2 : maxImages, 304L);
            } else {
                this.mImageReader = ImageReader.newInstance(1, 1, 35, maxImages <= 0 ? 2 : maxImages);
            }
            this.mApiType = apiType;
            this.mUsingPlayerId = playerId;
            AVLogger.d(AJProducerManager.TAG, "new:" + this);
        }

        public void setOnImageAvailableListener(ImageReader.OnImageAvailableListener listener, Handler handler) {
            ImageReader imageReader = this.mImageReader;
            if (imageReader != null) {
                imageReader.setOnImageAvailableListener(listener, handler);
                AVLogger.d(AJProducerManager.TAG, "setOnImageAvailableListener:" + this + ",handler:" + handler);
                if (listener != null) {
                    AJProducerManager.notifyImageReaderStatus(listener, 2);
                } else {
                    AJProducerManager.notifyImageReaderStatus(this.mListener, 1);
                }
                this.mListener = listener;
            }
        }

        public Surface getSurface() {
            ImageReader imageReader = this.mImageReader;
            if (imageReader == null) {
                return null;
            }
            return imageReader.getSurface();
        }

        public void release() {
            ImageReader imageReader = this.mImageReader;
            if (imageReader != null) {
                imageReader.close();
                this.mImageReader = null;
            }
        }

        public String toString() {
            return "[" + super.toString() + ",pid:" + this.mUsingPlayerId + ",reader:" + this.mImageReader + "]";
        }
    }
}
