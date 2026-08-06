package com.ss.ttm.player;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import com.ss.ttm.player.ITTRenderView;
import com.ss.ttm.player.TTAVWindowClient;
import com.ss.ttm.player.TTWindowClient;
import com.ss.vcbkit.VLog;
import java.lang.ref.WeakReference;
import java.util.Objects;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class TTWindowClient implements TTAVWindowClient {
    private WindowClientOnInfoCallback mOnInfoCallback;
    private ITTRenderView mRenderView;
    private long mCWindowShellHandle = 0;
    private long mNativeWindowHandle = 0;
    private ClientType mClientType = ClientType.UN_KNOWN;
    private WeakReference<TTPlayer> mTTPlayerRef = null;
    private WeakReference<MediaPlayerClient> mMediaPlayerClientRef = null;
    private WeakReference<TTAVWindowClient.ExternalInterface> mExternalRef = null;
    private int mWindowUsage = 0;
    private final ReentrantLock mLock = new ReentrantLock();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public enum ClientType {
        UN_KNOWN,
        TT_PLAYER,
        C_WINDOW_SHELL,
        OTHER,
        EXTERNAL
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface WindowClientOnInfoCallback {
        void onInfo(int what, int parameter);
    }

    private native long nativeCreateWindow(Surface surface, TTWindowClient callback);

    private native void nativeOnNewWindowAvailable(long shellHandle, long windowHandle);

    private native void nativeOnWindowChanged(long handle, int width, int height, int needCrop);

    private native void nativeOnWindowDestroyed(long handle, boolean dec);

    private native void nativeSetWindowUsage(long handle, int usage);

    private native void nativeWindowBindPlayer(long handle, long playerHandle);

    private native void nativeWindowHandleIncRef(long windowHandle);

    public TTWindowClient(ITTRenderView renderView, WindowClientOnInfoCallback onInfoCallback) {
        this.mOnInfoCallback = null;
        this.mRenderView = null;
        this.mRenderView = renderView;
        this.mOnInfoCallback = onInfoCallback;
    }

    public void bindPlayer(TTPlayer player) {
        this.mLock.lock();
        try {
            TTPlayer tTPlayer = getTTPlayer();
            VLog.m248i(TTPlayerViewHelper.TT_PLAYER_VIEW_TAG, "ttmn client bind player  " + TTPlayerViewHelper.objectToString(this) + ", curr: " + TTPlayerViewHelper.objectToString(tTPlayer) + ", target: " + TTPlayerViewHelper.objectToString(player));
            if (player != tTPlayer) {
                if (ClientType.TT_PLAYER != this.mClientType) {
                    windowDestroyInternal();
                }
                this.mClientType = ClientType.TT_PLAYER;
                clearAllWeakReference();
                windowChangeBindInternal();
                if (player != null) {
                    setTTPlayer(player);
                    long j = this.mNativeWindowHandle;
                    if (0 != j) {
                        nativeWindowBindPlayer(j, player.getNativePlayer());
                        nativeSetWindowUsage(this.mNativeWindowHandle, this.mWindowUsage);
                        nativeOnWindowChanged(this.mNativeWindowHandle, this.mRenderView.getView().getWidth(), this.mRenderView.getView().getHeight(), 1);
                    }
                }
            }
        } finally {
            this.mLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.TTAVWindowClient
    public void bindMediaClient(MediaPlayerClient client) {
        this.mLock.lock();
        try {
            MediaPlayerClient mediaPlayerClient = getMediaPlayerClient();
            VLog.m248i(TTPlayerViewHelper.TT_PLAYER_VIEW_TAG, "ttmn client bind media client " + TTPlayerViewHelper.objectToString(this) + ",  curr: " + TTPlayerViewHelper.objectToString(client) + ", target: " + TTPlayerViewHelper.objectToString(mediaPlayerClient));
            if (mediaPlayerClient != client) {
                windowDestroyInternal();
                this.mClientType = ClientType.OTHER;
                clearAllWeakReference();
                windowChangeBindInternal();
                if (client != null) {
                    setMediaPlayerClient(client);
                    Surface surface = this.mRenderView.getSurface();
                    if (surface != null) {
                        client.setSurface(surface);
                    }
                }
            }
        } finally {
            this.mLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.TTAVWindowClient
    public void unbindMediaClient(MediaPlayerClient client) {
        this.mLock.lock();
        try {
            MediaPlayerClient mediaPlayerClient = getMediaPlayerClient();
            if (mediaPlayerClient != null && mediaPlayerClient == client) {
                mediaPlayerClient.setSurfaceTimeOut(null, 0);
                WeakReference<MediaPlayerClient> weakReference = this.mMediaPlayerClientRef;
                if (weakReference != null) {
                    weakReference.clear();
                    this.mMediaPlayerClientRef = null;
                }
            }
        } finally {
            this.mLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.TTAVWindowClient
    public void bindExternal(TTAVWindowClient.ExternalInterface external) {
        this.mLock.lock();
        try {
            TTAVWindowClient.ExternalInterface external2 = getExternal();
            VLog.m248i(TTPlayerViewHelper.TT_PLAYER_VIEW_TAG, "ttmn client bind external " + TTPlayerViewHelper.objectToString(this) + ",  curr: " + TTPlayerViewHelper.objectToString(external2) + ", target: " + TTPlayerViewHelper.objectToString(external));
            if (external != external2) {
                windowDestroyInternal();
                this.mClientType = ClientType.EXTERNAL;
                clearAllWeakReference();
                windowChangeBindInternal();
                if (external != null) {
                    setExternal(external);
                    Surface surface = this.mRenderView.getSurface();
                    if (surface != null) {
                        external.onNewWindowAvailable(surface);
                        external.onWindowChanged(this.mRenderView.getView().getWidth(), this.mRenderView.getView().getHeight());
                    }
                }
            }
        } finally {
            this.mLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.TTAVWindowClient
    public void unbindExternal(TTAVWindowClient.ExternalInterface external) {
        this.mLock.lock();
        try {
            TTAVWindowClient.ExternalInterface external2 = getExternal();
            if (external2 != null && external2 == external) {
                external2.onWindowDestroyed();
                WeakReference<TTAVWindowClient.ExternalInterface> weakReference = this.mExternalRef;
                if (weakReference != null) {
                    weakReference.clear();
                    this.mExternalRef = null;
                }
            }
        } finally {
            this.mLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.TTAVWindowClient
    public void setWindowUsage(int usage) {
        this.mLock.lock();
        try {
            this.mWindowUsage = usage;
            long j = this.mNativeWindowHandle;
            if (j != 0) {
                nativeSetWindowUsage(j, usage);
            }
        } finally {
            this.mLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.TTAVWindowClient
    public void updateVideoSize(final int width, final int height) {
        VLog.m248i(TTPlayerViewHelper.TT_PLAYER_VIEW_TAG, "ttmn client updateVideoSize " + TTPlayerViewHelper.objectToString(this) + ",  width: " + width + ", height: " + height);
        if (this.mOnInfoCallback == null) {
            return;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            Handler handler = new Handler(Looper.getMainLooper());
            final WindowClientOnInfoCallback windowClientOnInfoCallback = this.mOnInfoCallback;
            if (windowClientOnInfoCallback != null) {
                handler.postAtFrontOfQueue(new Runnable() { // from class: com.ss.ttm.player.TTWindowClient$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        TTWindowClient.WindowClientOnInfoCallback.this.onInfo(5, (width << 16) + height);
                    }
                });
                return;
            }
            return;
        }
        this.mOnInfoCallback.onInfo(5, (width << 16) + height);
    }

    @Override // com.ss.ttm.player.TTAVWindowClient
    public void snapshotBitmap(boolean highQuality, final TTAVWindowClient.SnapshotListener listener) {
        this.mLock.lock();
        if (listener != null) {
            try {
                if (this.mRenderView != null) {
                    ITTRenderView iTTRenderView = this.mRenderView;
                    Objects.requireNonNull(listener);
                    iTTRenderView.snapshotBitmap(highQuality, new ITTRenderView.SnapshotCallback() { // from class: com.ss.ttm.player.TTWindowClient$$ExternalSyntheticLambda2
                        @Override // com.ss.ttm.player.ITTRenderView.SnapshotCallback
                        public final void onResult(int i, Bitmap bitmap) {
                            TTAVWindowClient.SnapshotListener.this.onResult(i, bitmap);
                        }
                    });
                }
            } finally {
                this.mLock.unlock();
            }
        }
    }

    public void onNewWindowAvailable(Surface surface) {
        VLog.m248i(TTPlayerViewHelper.TT_PLAYER_VIEW_TAG, "ttmn client available  " + TTPlayerViewHelper.objectToString(this) + ", type: " + this.mClientType + ", surface: " + TTPlayerViewHelper.objectToString(surface));
        this.mLock.lock();
        try {
            newWindowAvailableInternal(surface);
        } finally {
            this.mLock.unlock();
        }
    }

    public void onWindowChanged(int width, int height, boolean needCrop) {
        VLog.m248i(TTPlayerViewHelper.TT_PLAYER_VIEW_TAG, "ttmn client changed " + TTPlayerViewHelper.objectToString(this) + ", type: " + this.mClientType + ", w: " + width + ", h: " + height + ", crop: " + needCrop);
        this.mLock.lock();
        try {
            windowChangedInternal(width, height, needCrop);
        } finally {
            this.mLock.unlock();
        }
    }

    public void onWindowDestroyed() {
        VLog.m248i(TTPlayerViewHelper.TT_PLAYER_VIEW_TAG, "ttmn client destroyed type:  " + TTPlayerViewHelper.objectToString(this) + ", " + this.mClientType);
        this.mLock.lock();
        try {
            windowDestroyInternal();
            nativeOnWindowDestroyed(this.mNativeWindowHandle, true);
            this.mNativeWindowHandle = 0L;
        } finally {
            this.mLock.unlock();
        }
    }

    protected void onInfo(final int what, final int parameter) {
        VLog.m248i(TTPlayerViewHelper.TT_PLAYER_VIEW_TAG, "ttmn client onInfo " + TTPlayerViewHelper.objectToString(this) + ", what: " + what + ", parameter: " + parameter);
        Handler handler = new Handler(Looper.getMainLooper());
        final WindowClientOnInfoCallback windowClientOnInfoCallback = this.mOnInfoCallback;
        if (windowClientOnInfoCallback != null) {
            handler.postAtFrontOfQueue(new Runnable() { // from class: com.ss.ttm.player.TTWindowClient$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    TTWindowClient.WindowClientOnInfoCallback.this.onInfo(what, parameter);
                }
            });
        }
    }

    private void setTTPlayer(TTPlayer player) {
        this.mTTPlayerRef = new WeakReference<>(player);
    }

    private TTPlayer getTTPlayer() {
        WeakReference<TTPlayer> weakReference = this.mTTPlayerRef;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x000d, code lost:
    
        if (r5 != r4.mCWindowShellHandle) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private long setWindowShellHandle(long handle, boolean clean) {
        this.mLock.lock();
        if (clean) {
            try {
            } finally {
                this.mLock.unlock();
            }
        }
        this.mCWindowShellHandle = handle;
        if (0 != handle) {
            this.mClientType = ClientType.C_WINDOW_SHELL;
            if (this.mRenderView != null) {
                windowChangeBindInternal();
                long j = this.mNativeWindowHandle;
                if (0 != j) {
                    nativeWindowHandleIncRef(j);
                    return this.mNativeWindowHandle;
                }
            }
        }
        return 0L;
    }

    private void setMediaPlayerClient(MediaPlayerClient client) {
        this.mMediaPlayerClientRef = new WeakReference<>(client);
    }

    private MediaPlayerClient getMediaPlayerClient() {
        WeakReference<MediaPlayerClient> weakReference = this.mMediaPlayerClientRef;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private void setExternal(TTAVWindowClient.ExternalInterface external) {
        this.mExternalRef = new WeakReference<>(external);
    }

    private TTAVWindowClient.ExternalInterface getExternal() {
        WeakReference<TTAVWindowClient.ExternalInterface> weakReference = this.mExternalRef;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private boolean reCreateNativeWindow(Surface surface) {
        if (surface == null) {
            return false;
        }
        long j = this.mNativeWindowHandle;
        if (0 != j) {
            nativeOnWindowDestroyed(j, true);
            this.mNativeWindowHandle = 0L;
        }
        long nativeCreateWindow = nativeCreateWindow(surface, this);
        this.mNativeWindowHandle = nativeCreateWindow;
        return 0 != nativeCreateWindow;
    }

    private void clearAllWeakReference() {
        WeakReference<TTPlayer> weakReference = this.mTTPlayerRef;
        if (weakReference != null) {
            weakReference.clear();
            this.mTTPlayerRef = null;
        }
        WeakReference<MediaPlayerClient> weakReference2 = this.mMediaPlayerClientRef;
        if (weakReference2 != null) {
            weakReference2.clear();
            this.mMediaPlayerClientRef = null;
        }
        WeakReference<TTAVWindowClient.ExternalInterface> weakReference3 = this.mExternalRef;
        if (weakReference3 != null) {
            weakReference3.clear();
            this.mExternalRef = null;
        }
    }

    private void newWindowAvailableInternal(Surface surface) {
        TTAVWindowClient.ExternalInterface external;
        if (surface == null) {
            return;
        }
        if (!reCreateNativeWindow(surface)) {
            VLog.m248i(TTPlayerViewHelper.TT_PLAYER_VIEW_TAG, "create window failed " + this.mNativeWindowHandle + " surface:" + surface);
            return;
        }
        int i = C09811.$SwitchMap$com$ss$ttm$player$TTWindowClient$ClientType[this.mClientType.ordinal()];
        if (i == 1) {
            TTPlayer tTPlayer = getTTPlayer();
            if (tTPlayer != null) {
                nativeWindowBindPlayer(this.mNativeWindowHandle, tTPlayer.getNativePlayer());
                nativeSetWindowUsage(this.mNativeWindowHandle, this.mWindowUsage);
                return;
            }
            return;
        }
        if (i == 2) {
            long j = this.mCWindowShellHandle;
            if (0 != j) {
                nativeOnNewWindowAvailable(j, this.mNativeWindowHandle);
                return;
            }
            return;
        }
        if (i != 3) {
            if (i == 4 && (external = getExternal()) != null) {
                external.onNewWindowAvailable(surface);
                return;
            }
            return;
        }
        MediaPlayerClient mediaPlayerClient = getMediaPlayerClient();
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setSurface(surface);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.ss.ttm.player.TTWindowClient$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static /* synthetic */ class C09811 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$ttm$player$TTWindowClient$ClientType;

        static {
            int[] iArr = new int[ClientType.values().length];
            $SwitchMap$com$ss$ttm$player$TTWindowClient$ClientType = iArr;
            try {
                iArr[ClientType.TT_PLAYER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ss$ttm$player$TTWindowClient$ClientType[ClientType.C_WINDOW_SHELL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ss$ttm$player$TTWindowClient$ClientType[ClientType.OTHER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ss$ttm$player$TTWindowClient$ClientType[ClientType.EXTERNAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private void windowChangedInternal(int i, int i2, boolean z) {
        int i3 = C09811.$SwitchMap$com$ss$ttm$player$TTWindowClient$ClientType[this.mClientType.ordinal()];
        if (i3 != 3) {
            if (i3 == 4) {
                TTAVWindowClient.ExternalInterface external = getExternal();
                if (external != null) {
                    external.onWindowChanged(i, i2);
                    return;
                }
                return;
            }
            long j = this.mNativeWindowHandle;
            if (0 == j) {
                return;
            }
            nativeOnWindowChanged(j, i, i2, z ? 1 : 0);
        }
    }

    private void windowDestroyInternal() {
        int i = C09811.$SwitchMap$com$ss$ttm$player$TTWindowClient$ClientType[this.mClientType.ordinal()];
        if (i == 3) {
            MediaPlayerClient mediaPlayerClient = getMediaPlayerClient();
            if (mediaPlayerClient != null) {
                mediaPlayerClient.setSurface(null);
                return;
            }
            return;
        }
        if (i == 4) {
            TTAVWindowClient.ExternalInterface external = getExternal();
            if (external != null) {
                external.onWindowDestroyed();
                return;
            }
            return;
        }
        long j = this.mNativeWindowHandle;
        if (j != 0) {
            nativeOnWindowDestroyed(j, false);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r0v4 */
    private void windowChangeBindInternal() {
        if (this.mOnInfoCallback == null) {
            return;
        }
        final ?? r0 = this.mClientType == ClientType.EXTERNAL ? 1 : 0;
        VLog.m248i(TTPlayerViewHelper.TT_PLAYER_VIEW_TAG, "ttmn client bing changed neededFixedSize: " + ((boolean) r0) + " type:" + this.mClientType);
        if (Looper.myLooper() != Looper.getMainLooper()) {
            Handler handler = new Handler(Looper.getMainLooper());
            final WindowClientOnInfoCallback windowClientOnInfoCallback = this.mOnInfoCallback;
            if (windowClientOnInfoCallback != null) {
                handler.postAtFrontOfQueue(new Runnable() { // from class: com.ss.ttm.player.TTWindowClient$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        TTWindowClient.lambda$windowChangeBindInternal$2(TTWindowClient.WindowClientOnInfoCallback.this, r0);
                    }
                });
                return;
            }
            return;
        }
        this.mOnInfoCallback.onInfo(7, 0);
        this.mOnInfoCallback.onInfo(6, r0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$windowChangeBindInternal$2(WindowClientOnInfoCallback windowClientOnInfoCallback, boolean z) {
        windowClientOnInfoCallback.onInfo(7, 0);
        windowClientOnInfoCallback.onInfo(6, z ? 1 : 0);
    }
}
