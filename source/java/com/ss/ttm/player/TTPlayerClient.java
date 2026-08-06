package com.ss.ttm.player;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.ImageReader;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.os.PowerManager;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.lynx.tasm.core.ResManager;
import com.ss.android.socialbase.downloader.file.DownloadFileUtils;
import com.ss.android.update.UpdateDialogNewBase;
import com.ss.ttm.net.AVResolver;
import com.ss.ttm.player.MediaPlayer;
import com.ss.ttm.utils.AVErrorInfo;
import com.ss.ttm.utils.AVLogger;
import com.ss.ttm.utils.AVTime;
import com.ss.ttm.utils.OnceConfig;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class TTPlayerClient extends MediaPlayerClient implements Handler.Callback, ISurfaceListener {
    public static final int KEY_IS_CONFIG_PARAMS_OPTION = 100;
    private static final String TAG = "TTPlayerClient";
    private String mBufferingInfo;
    private TTSurfaceCallback mCallback;
    private int mCodecAndSurfaceReuse;
    private HashMap<Integer, Integer> mConfigParams;
    private boolean mConnectedCpu;
    private Context mContext;
    private int mCrashType;
    private final StringBuilder mCrashedInfo;
    private int mDisablePlayerStayAwake;
    private int mErrorCode;
    private Handler mHandler;
    private int mIgnoreSurfaceCreated;
    private MediaPlayer.OnLogListener mLogListener;
    private int mMediaCodecStopTimeOutMs;
    private MediaPlayer.OnBufferingUpdateListener mOnBufferingUpdateListener;
    private MediaPlayer.OnCompletionListener mOnCompletionListener;
    private MediaPlayer.OnErrorListener mOnErrorListener;
    private MediaPlayer.OnExternInfoListener mOnExternInfoListener;
    private MediaPlayer.OnInfoListener mOnInfoListener;
    private MediaPlayer.OnPreparedListener mOnPreparedListener;
    private MediaPlayer.onSARChangedListener mOnSARChangedListener;
    private MediaPlayer.OnSeekCompleteListener mOnSeekCompleteListener;
    private MediaPlayer.OnVideoSizeChangedListener mOnVideoSizeChangedListener;
    private ITTPlayerRef mPlayer;
    private final ReentrantReadWriteLock.ReadLock mReadLock;
    private final ReentrantReadWriteLock mReadWritedLock;
    private volatile boolean mRealsedSurface;
    private int mRtcPlay;
    private boolean mScreenOnWhilePlaying;
    private boolean mStayAwake;
    private SurfaceHolder mSurfaceHolder;
    private String mUri;
    private String mVoiceInfo;
    private PowerManager.WakeLock mWakeLock;
    private MediaPlayer mWrapper;
    private final ReentrantReadWriteLock.WriteLock mWriteLock;
    private boolean mSeekComplete = true;
    private LinkedList<String> mLogInfo = new LinkedList<>();
    private int mPlayLifeId = -1;
    private final ReentrantLock mReentrantLock = new ReentrantLock();
    private final ReentrantLock mReentrantLockInRtc = new ReentrantLock();

    @Override // com.ss.ttm.player.MediaPlayerClient
    public int getSelectedTrack(int trackType) {
        if (trackType == 2) {
            return 1;
        }
        if (trackType == 1) {
            return 0;
        }
        return trackType == 4 ? 2 : -1;
    }

    static {
        TTVersion.saveVersionInfo();
    }

    public static TTPlayerClient create(MediaPlayer wrapper, Context context) {
        return create(wrapper, context, null, null);
    }

    public static TTPlayerClient create(MediaPlayer wrapper, Context context, HashMap<Integer, Integer> configParams) {
        return create(wrapper, context, configParams, null);
    }

    public static synchronized TTPlayerClient create(MediaPlayer wrapper, Context context, HashMap<Integer, Integer> configParams, OnceConfig config) {
        File cacheDir;
        synchronized (TTPlayerClient.class) {
            TTVersion.saveVersionInfo();
            if (context != null) {
                context = context.getApplicationContext();
            }
            TTPlayerClient tTPlayerClient = new TTPlayerClient(context, configParams, config);
            ITTPlayerRef create = ITTPlayerRef.create(context, tTPlayerClient, configParams, config);
            if (create == null) {
                return null;
            }
            tTPlayerClient.mPlayer = create;
            tTPlayerClient.mWrapper = wrapper;
            Context context2 = tTPlayerClient.mContext;
            if (context2 != null && (cacheDir = context2.getCacheDir()) != null) {
                String path = cacheDir.getPath();
                if (!path.isEmpty()) {
                    tTPlayerClient.setStringOption(MediaPlayer.MEDIA_PLAYER_OPTION_RTM_DUMP_DIR, path);
                }
            }
            return tTPlayerClient;
        }
    }

    public static void setGlobalIntOptionForKey(int key, int value) {
        ITTPlayerRef.setGlobalIntOptionForKey(key, value);
    }

    public static void setGlobalStringOptionForKey(int key, String value) {
        ITTPlayerRef.setGlobalStringOptionForKey(key, value);
    }

    public static long getDemuxerFactory(int version) {
        return TTPlayer.getDemuxerFactory(version);
    }

    private TTPlayerClient(Context context, HashMap<Integer, Integer> configParams, OnceConfig config) {
        this.mRealsedSurface = false;
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.mReadWritedLock = reentrantReadWriteLock;
        this.mReadLock = reentrantReadWriteLock.readLock();
        this.mWriteLock = reentrantReadWriteLock.writeLock();
        this.mErrorCode = 0;
        this.mRtcPlay = 0;
        this.mCrashedInfo = new StringBuilder(1024);
        this.mCrashType = -1;
        this.mDisablePlayerStayAwake = 0;
        this.mMediaCodecStopTimeOutMs = -1;
        this.mCodecAndSurfaceReuse = 0;
        this.mIgnoreSurfaceCreated = 0;
        this.mConnectedCpu = false;
        this.mConfigParams = configParams;
        this.mRealsedSurface = false;
        this.mCallback = new TTSurfaceCallback(this);
        this.mContext = context;
        if (Looper.myLooper() != null) {
            this.mHandler = new Handler(this);
        } else {
            this.mHandler = new Handler(Looper.getMainLooper(), this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isValid() {
        ITTPlayerRef iTTPlayerRef = this.mPlayer;
        return iTTPlayerRef != null && iTTPlayerRef.isValid();
    }

    protected void updateLifeId() {
        try {
            this.mReentrantLock.lock();
            this.mPlayLifeId = this.mPlayer.getLifeId();
            AVLogger.m239d(TAG, "reset.mPlayLifeId" + this.mPlayLifeId);
        } finally {
            if (this.mReentrantLock.isLocked()) {
                this.mReentrantLock.unlock();
            }
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    @Deprecated
    public void prevClose() {
        String str = TAG;
        AVLogger.m239d(str, "prev close start");
        this.mRealsedSurface = true;
        SurfaceHolder surfaceHolder = this.mSurfaceHolder;
        if (surfaceHolder != null) {
            surfaceHolder.removeCallback(this.mCallback);
        }
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.prevClose();
            }
            this.mReadLock.unlock();
            AVLogger.m239d(str, "prev close end");
        } catch (Throwable th) {
            this.mReadLock.unlock();
            throw th;
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void releaseAsync() {
        String str = TAG;
        AVLogger.m239d(str, "prev close start");
        this.mRealsedSurface = true;
        SurfaceHolder surfaceHolder = this.mSurfaceHolder;
        if (surfaceHolder != null) {
            surfaceHolder.removeCallback(this.mCallback);
        }
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.prevClose();
            }
            this.mReadLock.unlock();
            AVLogger.m239d(str, "prev close end");
            new Thread(new Runnable() { // from class: com.ss.ttm.player.TTPlayerClient.1
                @Override // java.lang.Runnable
                public void run() {
                    TTPlayerClient.this.release();
                }
            }).start();
        } catch (Throwable th) {
            this.mReadLock.unlock();
            throw th;
        }
    }

    public void close() {
        String str = TAG;
        AVLogger.m239d(str, "close start");
        this.mRealsedSurface = true;
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.close();
            }
            this.mReadLock.unlock();
            AVLogger.m239d(str, "close end");
        } catch (Throwable th) {
            this.mReadLock.unlock();
            throw th;
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void release() {
        String playerErrorInfo;
        stayAwake(false);
        updateSurfaceScreenOn();
        this.mWriteLock.lock();
        try {
            ITTPlayerRef iTTPlayerRef = this.mPlayer;
            this.mPlayer = null;
            this.mPlayLifeId = -1;
            if (iTTPlayerRef != null) {
                iTTPlayerRef.release();
            }
            SurfaceHolder surfaceHolder = this.mSurfaceHolder;
            if (surfaceHolder != null) {
                surfaceHolder.removeCallback(this.mCallback);
                this.mSurfaceHolder = null;
                this.mRealsedSurface = true;
            }
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
                this.mHandler = null;
            }
            if (this.mLogListener != null && (playerErrorInfo = getPlayerErrorInfo()) != null && !playerErrorInfo.isEmpty()) {
                this.mLogListener.onLogInfo(this.mWrapper, playerErrorInfo);
            }
            this.mContext = null;
            AVLogger.m239d(TAG, "release end");
        } finally {
            this.mWriteLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void start() {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.start();
                updateLifeId();
                this.mRtcPlay = this.mPlayer.getIntOption(800, 0);
            }
            this.mReadLock.unlock();
            stayAwake(true);
        } catch (Throwable th) {
            this.mReadLock.unlock();
            throw th;
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void pause() {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.pause();
            }
            this.mReadLock.unlock();
            stayAwake(false);
        } catch (Throwable th) {
            this.mReadLock.unlock();
            throw th;
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void preDemux() {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.preDemux();
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public PipelineLoader prepareMix(PipelineLoadParams params) {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                return this.mPlayer.prepareMix(params);
            }
            this.mReadLock.unlock();
            return null;
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void reset() {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.reset();
                SurfaceHolder surfaceHolder = this.mSurfaceHolder;
                if (surfaceHolder != null && this.mCodecAndSurfaceReuse == 0) {
                    this.mPlayer.setSurfaceTimeOut(surfaceHolder.getSurface(), 0);
                }
                this.mHandler.removeCallbacksAndMessages(null);
                this.mErrorCode = 0;
                this.mLogInfo.clear();
                updateLifeId();
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void stop() {
        SurfaceHolder surfaceHolder;
        this.mReadLock.lock();
        try {
            if (isValid()) {
                if (this.mConnectedCpu && this.mCodecAndSurfaceReuse == 1 && (surfaceHolder = this.mSurfaceHolder) != null) {
                    surfaceHolder.removeCallback(this.mCallback);
                    this.mSurfaceHolder = null;
                    this.mPlayer.setSurfaceTimeOut(null, 0);
                    this.mConnectedCpu = false;
                    AVLogger.Warn(TAG, this, "testlog: mConnected Cpu " + this.mConnectedCpu);
                }
                this.mPlayer.stop();
            }
            this.mReadLock.unlock();
            stayAwake(false);
        } catch (Throwable th) {
            this.mReadLock.unlock();
            throw th;
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void prepare() {
        prepareAsync();
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void prepareAsync() {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mErrorCode = 0;
                this.mLogInfo.clear();
                if (this.mRealsedSurface) {
                    this.mPlayer.setSurfaceTimeOut(this.mSurfaceHolder.getSurface(), 0);
                    this.mRealsedSurface = false;
                }
                this.mPlayer.prepare();
                updateLifeId();
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void takeScreenshot(MediaPlayer.OnScreenshotListener listener) {
        if (this.mPlayer == null || listener == null) {
            return;
        }
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setNotifyState(15L);
                this.mPlayer.setOnScreenshotListener(listener);
                this.mPlayer.takeScreenshot();
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void switchStream(int bitrate, int streamType) {
        if (this.mPlayer != null) {
            this.mReadLock.lock();
            try {
                if (isValid()) {
                    this.mPlayer.switchStream(bitrate, streamType);
                }
            } finally {
                this.mReadLock.unlock();
            }
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public int getCurrentPosition() {
        this.mReadLock.lock();
        try {
            return isValid() ? this.mPlayer.getIntOption(2, 0) : 0;
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public int getVideoHeight() {
        this.mReadLock.lock();
        try {
            return isValid() ? this.mPlayer.getIntOption(4, 0) : 0;
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public int getVideoWidth() {
        this.mReadLock.lock();
        try {
            return isValid() ? this.mPlayer.getIntOption(3, 0) : 0;
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public int getDuration() {
        this.mReadLock.lock();
        try {
            return isValid() ? this.mPlayer.getIntOption(1, 0) : 0;
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setDisplay(SurfaceHolder surfaceHolder) {
        Surface surface;
        SurfaceHolder surfaceHolder2;
        if (this.mCodecAndSurfaceReuse != 0 && (surfaceHolder2 = this.mSurfaceHolder) == surfaceHolder && surfaceHolder2 != null) {
            AVLogger.m239d(TAG, "surfaceholder already setted");
            return;
        }
        SurfaceHolder surfaceHolder3 = this.mSurfaceHolder;
        if (surfaceHolder3 != null) {
            surfaceHolder3.removeCallback(this.mCallback);
        }
        this.mSurfaceHolder = surfaceHolder;
        if (surfaceHolder != null) {
            surfaceHolder.addCallback(this.mCallback);
            surface = this.mSurfaceHolder.getSurface();
        } else {
            surface = null;
        }
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setSurfaceTimeOut(surface, 0);
            }
            this.mReadLock.unlock();
            updateSurfaceScreenOn();
        } catch (Throwable th) {
            this.mReadLock.unlock();
            throw th;
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setDataSource(Context context, Uri uri, Map<String, String> headers) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException {
        if (uri == null) {
            return;
        }
        setDataSource(context, uri);
        if (headers == null || headers.size() == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            sb.append(entry.getKey()).append(": ").append(entry.getValue()).append("\r\n");
        }
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setStringOption(20, sb.toString());
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0056, code lost:
    
        if (0 != 0) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005e, code lost:
    
        setDataSource(r4.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0065, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005b, code lost:
    
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0059, code lost:
    
        if (0 != 0) goto L30;
     */
    @Override // com.ss.ttm.player.MediaPlayerClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setDataSource(Context context, Uri uri) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException {
        if (uri == null) {
            return;
        }
        if ("content".equals(uri.getScheme()) && "settings".equals(uri.getAuthority()) && (uri = RingtoneManager.getActualDefaultRingtoneUri(context, RingtoneManager.getDefaultType(uri))) == null) {
            throw new FileNotFoundException("Can't resolve default ringtone");
        }
        AssetFileDescriptor assetFileDescriptor = null;
        try {
            AssetFileDescriptor openAssetFileDescriptor = context.getContentResolver().openAssetFileDescriptor(uri, DownloadFileUtils.MODE_READ);
            if (openAssetFileDescriptor == null) {
                if (openAssetFileDescriptor != null) {
                    openAssetFileDescriptor.close();
                }
            } else {
                setDataSource(openAssetFileDescriptor.getFileDescriptor());
                if (openAssetFileDescriptor != null) {
                    openAssetFileDescriptor.close();
                }
            }
        } catch (IOException unused) {
        } catch (SecurityException unused2) {
        } catch (Throwable th) {
            if (0 != 0) {
                assetFileDescriptor.close();
            }
            throw th;
        }
    }

    public void setDataSource(FileDescriptor fd) throws IOException {
        ParcelFileDescriptor dup = ParcelFileDescriptor.dup(fd);
        try {
            ITTPlayerRef iTTPlayerRef = this.mPlayer;
            if (iTTPlayerRef != null) {
                iTTPlayerRef.setDataSourceFd(dup.getFd());
            }
        } finally {
            if (dup != null) {
                dup.close();
            }
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setDataSource(FileDescriptor fd, long offset, long length) throws IllegalStateException, IllegalArgumentException, IOException {
        setDataSource(fd);
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setLongOption(135, offset);
                this.mPlayer.setLongOption(136, length);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setDataSource(String path) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException {
        if (path.toLowerCase(Locale.US).indexOf("://") <= 0) {
            this.mUri = ResManager.FILE_SCHEME + path;
        } else {
            this.mUri = path;
        }
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setDataSource(this.mUri);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setDataSource(IMediaDataSource dataSource) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException {
        if (dataSource == null) {
            throw new IllegalArgumentException("null mediadatasource pointer.");
        }
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setDataSource(dataSource);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public String getDataSource() {
        return this.mUri;
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public boolean isPlaying() {
        this.mReadLock.lock();
        try {
            boolean z = false;
            if (isValid()) {
                if (this.mPlayer.getIntOption(6, 0) == 1) {
                    z = true;
                }
            }
            return z;
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public boolean isLooping() {
        this.mReadLock.lock();
        try {
            boolean z = false;
            if (isValid()) {
                if (this.mPlayer.getIntOption(5, 0) == 1) {
                    z = true;
                }
            }
            return z;
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setLooping(boolean b) {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setLooping(b ? 1 : 0);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setVolume(float left, float right) {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setVolume(left, right);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void mouseEvent(int action, int deltaX, int deltaY) {
        int i = 1;
        if (action != 0) {
            if (action != 1) {
                i = 2;
                if (action != 2) {
                    i = 0;
                }
            } else {
                i = 3;
            }
        }
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.mouseEvent(i, deltaX, deltaY);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void rotateCamera(float angleX, float angleY) {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.rotateCamera(angleX, angleY);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void seekTo(int msec, int flag) {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mSeekComplete = false;
                this.mPlayer.seekTo(msec, flag);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void seekTo(int msec) {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mSeekComplete = false;
                this.mPlayer.seekTo(msec);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public int getIntOption(int key, int dValue) {
        if (key == 5000) {
            return this.mErrorCode;
        }
        if (key == 26) {
            return this.mCrashType;
        }
        this.mReadLock.lock();
        try {
            if (isValid()) {
                dValue = this.mPlayer.getIntOption(key, dValue);
            }
            return dValue;
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public int setIntOption(int key, int value) {
        int i = 0;
        if (key == 1301) {
            if (Looper.myLooper() != null) {
                this.mHandler = new Handler(this);
            } else {
                this.mHandler = new Handler(Looper.getMainLooper(), this);
            }
            return 0;
        }
        if (key == 41) {
            AVResolver.HOST_MAX_CACHE_TIME = value;
            return 0;
        }
        if (key == 5003) {
            this.mDisablePlayerStayAwake = value;
            return 0;
        }
        if (key == 952) {
            this.mMediaCodecStopTimeOutMs = value;
            return 0;
        }
        if (key == 1007) {
            this.mCodecAndSurfaceReuse = value;
        } else if (key == 1036) {
            this.mIgnoreSurfaceCreated = value;
        } else if (key == 984) {
            if (value != 0) {
                if (value == 1) {
                    value = 16777216;
                } else if (value == 2) {
                    value = AVLogger.LEVEL_LOG_INFO;
                } else {
                    i = AVLogger.LEVEL_LOG_INFO_KILL;
                    if (value != 3 && value != 4) {
                        if (value == 5) {
                            value = AVLogger.LEVEL_LOG_WARN;
                        } else if (value == 6) {
                            value = AVLogger.LEVEL_LOG_ERROR;
                        }
                    }
                }
                AVLogger.setLogLevel(value);
            }
            value = i;
            AVLogger.setLogLevel(value);
        } else if (key == 1501) {
            AVLogger.setLogLevel(value);
        } else if (key == 1502) {
            AVLogger.setLogLevel(value);
        }
        this.mReadLock.lock();
        try {
            return isValid() ? this.mPlayer.setIntOption(key, value) : -1;
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public int setStringOption(int key, String value) {
        this.mReadLock.lock();
        try {
            return isValid() ? this.mPlayer.setStringOption(key, value) : -1;
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public String getStringOption(int key) {
        if (key == 5001) {
            return getPlayerCrashedInfo();
        }
        if (key == 5002) {
            LinkedList<String> linkedList = this.mLogInfo;
            if (linkedList == null || linkedList.size() == 0) {
                return null;
            }
            return getPlayerErrorInfo();
        }
        this.mReadLock.lock();
        try {
            return isValid() ? this.mPlayer.getStringOption(key) : null;
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public int setLongOption(int key, long value) {
        this.mReadLock.lock();
        try {
            return isValid() ? this.mPlayer.setLongOption(key, value) : -1;
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public long getLongOption(int key, long dValue) {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                dValue = this.mPlayer.getLongOption(key, dValue);
            }
            return dValue;
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public float getFloatOption(int key, float dValue) {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                dValue = this.mPlayer.getFloatOption(key, dValue);
            }
            return dValue;
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public int setFloatOption(int key, float value) {
        this.mReadLock.lock();
        try {
            return isValid() ? this.mPlayer.setFloatOption(key, value) : -1;
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public Object getObjectOption(int key) {
        this.mReadLock.lock();
        try {
            return isValid() ? this.mPlayer.getObjectOption(key) : null;
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public int setIntOptionArray(int[] keys, int[] values) {
        this.mReadLock.lock();
        try {
            return isValid() ? this.mPlayer.setIntOptionArray(keys, values) : -1;
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public int setLongOptionArray(int[] keys, long[] values) {
        this.mReadLock.lock();
        try {
            return isValid() ? this.mPlayer.setLongOptionArray(keys, values) : -1;
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public int setFloatOptionArray(int[] keys, float[] values) {
        this.mReadLock.lock();
        try {
            return isValid() ? this.mPlayer.setFloatOptionArray(keys, values) : -1;
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public int setStringOptionArray(int[] keys, String[] values) {
        this.mReadLock.lock();
        try {
            return isValid() ? this.mPlayer.setStringOptionArray(keys, values) : -1;
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public int getVideoType() {
        this.mReadLock.lock();
        try {
            return isValid() ? this.mPlayer.getIntOption(11, 0) : 0;
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setPanoVideoControlModel(int model) {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setIntOption(11, model);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public boolean isMute() {
        this.mReadLock.lock();
        try {
            boolean z = false;
            if (isValid()) {
                if (this.mPlayer.getIntOption(12, 0) == 1) {
                    z = true;
                }
            }
            return z;
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setIsMute(boolean isMute) {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setIntOption(12, isMute ? 1 : 0);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setSurface(Surface surface) {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setSurfaceTimeOut(surface, 0);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setWindowClient(TTAVWindowClient client) {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setWindowClient(client);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setSurfaceTimeOut(Surface surface, int timeoutMs) {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setSurfaceTimeOut(surface, timeoutMs);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setCacheFile(String path, int mode) {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setCacheFile(path, mode);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setScreenOnWhilePlaying(boolean screenOn) {
        if (this.mScreenOnWhilePlaying != screenOn) {
            if (screenOn && this.mSurfaceHolder == null) {
                AVLogger.Warn(TAG, this, "setScreenOnWhilePlaying(true) is ineffective without a SurfaceHolder");
            }
            this.mScreenOnWhilePlaying = screenOn;
            updateSurfaceScreenOn();
        }
    }

    public void updateSurfaceScreenOn() {
        SurfaceHolder surfaceHolder = this.mSurfaceHolder;
        if (surfaceHolder == null || this.mDisablePlayerStayAwake != 0) {
            return;
        }
        surfaceHolder.setKeepScreenOn(this.mScreenOnWhilePlaying && this.mStayAwake);
    }

    private void stayAwake(boolean awake) {
        PowerManager.WakeLock wakeLock = this.mWakeLock;
        if (wakeLock != null) {
            if (awake && !wakeLock.isHeld()) {
                this.mWakeLock.acquire();
            } else if (!awake && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        }
        this.mStayAwake = awake;
        updateSurfaceScreenOn();
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setWakeMode(Context context, int mode) {
        boolean z;
        PowerManager.WakeLock wakeLock = this.mWakeLock;
        if (wakeLock != null) {
            if (wakeLock.isHeld()) {
                this.mWakeLock.release();
                z = true;
            } else {
                z = false;
            }
            this.mWakeLock = null;
        } else {
            z = false;
        }
        PowerManager.WakeLock newWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(mode | C0968C.ENCODING_PCM_A_LAW, TTPlayerClient.class.getName());
        this.mWakeLock = newWakeLock;
        if (newWakeLock != null) {
            newWakeLock.setReferenceCounted(false);
            if (z) {
                this.mWakeLock.acquire();
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:11:0x001e. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:13:0x0024. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:14:0x0027. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:15:0x002a. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:16:0x002d. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:17:0x0030. Please report as an issue. */
    public void handleNotify(int lifeId, int what, int parameter, String info) {
        if (what != 0) {
            if (what == 12) {
                AVLogger.m239d(TAG, "handleNotify -------------->>>>>>>update seek complete:what:" + what + ",parameter:" + parameter);
                sendSeekCompleted(lifeId);
                return;
            }
            if (what == 13) {
                String str = TAG;
                AVLogger.m239d(str, "handleNotify -------------->>>>>>>Completed:what:" + what + ",parameter:" + parameter);
                stayAwake(false);
                AVLogger.m239d(str, "life:" + lifeId + ",plifeId:" + this.mPlayLifeId);
                sendSeekCompleted(lifeId);
                sendCompletioned(lifeId);
                return;
            }
            if (what != 84) {
                if (what != 85) {
                    switch (what) {
                        case 0:
                        case 45:
                            break;
                        case 32:
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                        case 38:
                        case 39:
                        case 41:
                        case 42:
                        case 47:
                        case 49:
                        case 82:
                        case 88:
                        case 91:
                        case 92:
                        case 111:
                        case 1000:
                            break;
                        case 33:
                        case 40:
                        case 43:
                        case 44:
                        case 87:
                        case 90:
                            break;
                        case 20000:
                            AVLogger.m239d(TAG, "handleNotify -------------->>>>>>>Completed:what:" + what + ",parameter:" + parameter);
                            if (this.mErrorCode == -2139062143) {
                                return;
                            }
                            this.mErrorCode = MediaPlayer.MEDIA_PLAYER_CRASHED_ERROR;
                            this.mWriteLock.lock();
                            try {
                                ITTPlayerRef iTTPlayerRef = this.mPlayer;
                                if (iTTPlayerRef != null) {
                                    this.mPlayer = null;
                                    iTTPlayerRef.invalid();
                                    this.mWriteLock.unlock();
                                    HashMap<Integer, Integer> hashMap = this.mConfigParams;
                                    if (hashMap != null && hashMap.get(100).intValue() == 1) {
                                        this.mConfigParams.put(7, 1);
                                    } else {
                                        TTPlayerConfiger.setValue(7, true);
                                    }
                                    stayAwake(false);
                                    sendSeekCompleted(lifeId);
                                    sendErrorInfo(parameter, lifeId);
                                    sendCompletioned(lifeId);
                                    return;
                                }
                                return;
                            } finally {
                                this.mWriteLock.unlock();
                            }
                        default:
                            switch (what) {
                                case 2:
                                    if (this.mOnPreparedListener != null) {
                                        AVLogger.m239d(TAG, "handleNotify --------------->>>>>>Prepared:what:" + what + ",parameter:" + parameter);
                                        this.mOnPreparedListener.onPrepared(this.mWrapper);
                                        return;
                                    }
                                    return;
                                case 3:
                                    if (parameter == 100) {
                                        AVLogger.m239d(TAG, "handleNotify -------------->>>>>>>update buffer:what:" + what + ",parameter:" + parameter);
                                    }
                                    MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener = this.mOnBufferingUpdateListener;
                                    if (onBufferingUpdateListener != null) {
                                        onBufferingUpdateListener.onBufferingUpdate(this.mWrapper, parameter);
                                        return;
                                    }
                                    return;
                                case 4:
                                case 5:
                                case 7:
                                case 8:
                                case 9:
                                case 10:
                                    break;
                                case 6:
                                    MediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener = this.mOnVideoSizeChangedListener;
                                    if (onVideoSizeChangedListener != null) {
                                        onVideoSizeChangedListener.onVideoSizeChanged(this.mWrapper, 65535 & parameter, parameter >> 16);
                                        return;
                                    }
                                    return;
                                default:
                                    switch (what) {
                                        case 19:
                                            break;
                                        case 20:
                                        case 21:
                                        case 22:
                                        case 24:
                                        case 25:
                                        case 26:
                                        case 27:
                                        case 28:
                                        case 29:
                                        case 30:
                                            break;
                                        case 23:
                                            int i = 65535 & parameter;
                                            int i2 = parameter >> 16;
                                            AVLogger.m239d(TAG, "handleNotify --------------->>>>>>IsSARChange:what:" + what + ",num:" + i + ",den:" + i2);
                                            MediaPlayer.onSARChangedListener onsarchangedlistener = this.mOnSARChangedListener;
                                            if (onsarchangedlistener != null) {
                                                onsarchangedlistener.onSARChanged(this.mWrapper, i, i2);
                                                return;
                                            }
                                            return;
                                        default:
                                            switch (what) {
                                                default:
                                                    switch (what) {
                                                        case 57:
                                                        case 58:
                                                            break;
                                                        case 59:
                                                            break;
                                                        default:
                                                            switch (what) {
                                                                case 61:
                                                                case 62:
                                                                    break;
                                                                case 63:
                                                                    break;
                                                                default:
                                                                    switch (what) {
                                                                        case 65:
                                                                        case 66:
                                                                        case 67:
                                                                            break;
                                                                        case 68:
                                                                            break;
                                                                        default:
                                                                            switch (what) {
                                                                                case 70:
                                                                                case 71:
                                                                                case 72:
                                                                                    break;
                                                                                case 73:
                                                                                    this.mConnectedCpu = true;
                                                                                    notifyInfo(what, parameter);
                                                                                    return;
                                                                                default:
                                                                                    return;
                                                                            }
                                                                    }
                                                            }
                                                    }
                                                case 51:
                                                case 52:
                                                case 53:
                                                case 54:
                                                    notifyInfo(what, parameter);
                                                    return;
                                            }
                                    }
                            }
                    }
                }
                onExternInfo(what, parameter, info);
                return;
            }
            notifyInfo(what, parameter);
            return;
        }
        String str2 = TAG;
        AVLogger.m239d(str2, "handleNotify -------------->>>>>>>Error:what:" + what + ",parameter:" + parameter);
        stayAwake(false);
        if (parameter == -499989) {
            HashMap<Integer, Integer> hashMap2 = this.mConfigParams;
            if (hashMap2 != null && hashMap2.get(100).intValue() == 1) {
                this.mConfigParams.put(8, 1);
            } else {
                TTPlayerConfiger.setValue(8, true);
            }
        }
        AVLogger.m239d(str2, "life:" + lifeId + ",plifeId:" + this.mPlayLifeId);
        sendSeekCompleted(lifeId);
        sendErrorInfo(parameter, lifeId);
    }

    private void onExternInfo(int what, int parameter, String info) {
        if (this.mRtcPlay != 0) {
            try {
                this.mReentrantLockInRtc.lock();
                MediaPlayer.OnExternInfoListener onExternInfoListener = this.mOnExternInfoListener;
                if (onExternInfoListener != null && info != null) {
                    onExternInfoListener.onExternInfo(this.mWrapper, what, info);
                    this.mOnExternInfoListener.onExternInfo2(this.mWrapper, what, parameter, info);
                }
                return;
            } finally {
                this.mReentrantLockInRtc.unlock();
            }
        }
        MediaPlayer.OnExternInfoListener onExternInfoListener2 = this.mOnExternInfoListener;
        if (onExternInfoListener2 == null || info == null) {
            return;
        }
        onExternInfoListener2.onExternInfo(this.mWrapper, what, info);
        this.mOnExternInfoListener.onExternInfo2(this.mWrapper, what, parameter, info);
    }

    private void notifyInfo(int what, int parameter) {
        int i;
        if (this.mOnInfoListener == null) {
            return;
        }
        if (what == 4) {
            AVLogger.m239d(TAG, "handleNotify --------------->>>>>>info buffering  start:what:" + what + "");
            i = 701;
        } else if (what == 5) {
            AVLogger.m239d(TAG, "handleNotify --------------->>>>>>info buffering  end:what:" + what + "");
            i = 702;
        } else if (what == 41) {
            AVLogger.m239d(TAG, "handleNotify --------------->>>>>>info rtc video decode stall:what:" + what + "");
            i = MediaPlayer.MEDIA_INFO_RTC_VIDEO_DECODE_STALL;
        } else if (what == 42) {
            AVLogger.m239d(TAG, "handleNotify --------------->>>>>>info rtc audio decode stall:what:" + what + "");
            i = MediaPlayer.MEDIA_INFO_RTC_AUDIO_DECODE_STALL;
        } else if (what == 57) {
            i = MediaPlayer.MEDIA_NO_AVRENDER_START;
        } else if (what == 58) {
            i = MediaPlayer.MEDIA_NO_AVRENDER_END;
        } else if (what == 61) {
            i = MediaPlayer.MEDIA_STARTTIME_NO_VIDEO_FRAME;
        } else if (what != 62) {
            switch (what) {
                case 7:
                    AVLogger.m239d(TAG, "handleNotify --------------->>>>>>info rendering start:what:" + what + "");
                    i = 3;
                    break;
                case 8:
                    i = 801;
                    break;
                case 9:
                    i = 802;
                    break;
                case 10:
                    i = 901;
                    break;
                default:
                    switch (what) {
                        case 20:
                            i = MediaPlayer.MEDIA_INFO_ROTATION_CHANGED;
                            break;
                        case 21:
                            i = MediaPlayer.MEDIA_INFO_STREAM_CHANGED;
                            break;
                        case 22:
                            i = MediaPlayer.MEDIA_INFO_DEVICE_OPENED;
                            break;
                        case 23:
                            i = MediaPlayer.MEDIA_INFO_SAR_CHANGED;
                            break;
                        case 24:
                            i = MediaPlayer.MEDIA_INFO_SPEED_CHANGED;
                            break;
                        case 25:
                            i = MediaPlayer.MEDIA_INFO_FIRST_FRAME_AFTER_SEEK;
                            break;
                        case 26:
                            i = MediaPlayer.MEDIA_INFO_VIDEO_STREAM_BITRATE_CHANGED;
                            break;
                        case 27:
                            AVLogger.m239d(TAG, "handleNotify --------------->>>>>>info video render stall:what:" + what + "");
                            i = MediaPlayer.MEDIA_INFO_AUDIO_RENDER_STALL;
                            break;
                        case 28:
                            AVLogger.m239d(TAG, "handleNotify --------------->>>>>>info audio render stall:what:" + what + "");
                            i = MediaPlayer.MEDIA_INFO_VIDEO_RENDER_STALL;
                            break;
                        case 29:
                            AVLogger.m239d(TAG, "handleNotify --------------->>>>>>info audio rendering start:what:" + what + "");
                            i = MediaPlayer.MEDIA_INFO_AUDIO_RENDER_START;
                            break;
                        case 30:
                            AVLogger.m239d(TAG, "handleNotify --------------->>>>>>info ready for display:what:" + what + "");
                            i = MediaPlayer.MEDIA_INFO_VIDEO_READY_FOR_DISPLAY;
                            break;
                        case 32:
                            i = MediaPlayer.MEDIA_INFO_SILENCE_DETECTED;
                            break;
                        case 47:
                            AVLogger.m239d(TAG, "handleNotify --------------->>>>>>info preBuffering  start:what:" + what + "");
                            i = MediaPlayer.MEDIA_INFO_PREBUFFERING_START;
                            break;
                        case 82:
                            i = MediaPlayer.MEDIA_INFO_VIDEO_ABNORMAL_OCCURED;
                            break;
                        case 84:
                            i = MediaPlayer.MEDIA_INFO_RENDER_EXCEPTION;
                            break;
                        case 88:
                            i = MediaPlayer.MEDIA_INFO_VIDEO_RENDER_DEVICE_CHANGED;
                            break;
                        case 91:
                            i = MediaPlayer.MEDIA_INFO_AUDIO_DECODE_ERROR_CONSUMED;
                            break;
                        case 92:
                            i = MediaPlayer.MEDIA_INFO_VIDEO_SR_MODE_CHANGE;
                            break;
                        case 111:
                            i = MediaPlayer.MEDIA_INFO_PLAY_LOOP_END;
                            break;
                        case 1000:
                            i = MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP;
                            break;
                        default:
                            switch (what) {
                                case 34:
                                    AVLogger.m239d(TAG, "handleNotify --------------->>>>>>info video demuxer stall:what:" + what + "");
                                    i = MediaPlayer.MEDIA_INFO_VIDEO_DEMUX_STALL;
                                    break;
                                case 35:
                                    AVLogger.m239d(TAG, "handleNotify --------------->>>>>>info audio demuxer stall:what:" + what + "");
                                    i = MediaPlayer.MEDIA_INFO_AUDIO_DEMUX_STALL;
                                    break;
                                case 36:
                                    AVLogger.m239d(TAG, "handleNotify --------------->>>>>>info video decode stall:what:" + what + "");
                                    i = MediaPlayer.MEDIA_INFO_VIDEO_DECODE_STALL;
                                    break;
                                case 37:
                                    AVLogger.m239d(TAG, "handleNotify --------------->>>>>>info audio decode stall:what:" + what + "");
                                    i = MediaPlayer.MEDIA_INFO_AUDIO_DECODE_STALL;
                                    break;
                                case 38:
                                    i = MediaPlayer.MEDIA_INFO_POSITION_UPDATE;
                                    break;
                                case 39:
                                    AVLogger.m239d(TAG, "handleNotify --------------->>>>>>info audio pts back:what:" + what + "");
                                    i = MediaPlayer.MEDIA_INFO_AUDIO_PTS_BACK;
                                    break;
                                default:
                                    switch (what) {
                                        case 49:
                                            i = MediaPlayer.MEDIA_INFO_BARRAGE_MASK_INFO;
                                            break;
                                        case 50:
                                            i = MediaPlayer.MEDIA_INFO_SUBTITLE_INFO;
                                            break;
                                        case 51:
                                            i = MediaPlayer.MEDIA_INFO_AVOUTSYNC_START;
                                            break;
                                        case 52:
                                            i = MediaPlayer.MEDIA_INFO_AVOUTSYNC_END;
                                            break;
                                        case 53:
                                            AVLogger.m239d(TAG, "handleNotify --------------->>>>>>formater start:what:" + what + "");
                                            i = MediaPlayer.MEDIA_INFO_FORMATER_START;
                                            break;
                                        case 54:
                                            AVLogger.m239d(TAG, "handleNotify --------------->>>>>>decoder start:what:" + what + "");
                                            i = MediaPlayer.MEDIA_INFO_DECODER_START;
                                            break;
                                        default:
                                            switch (what) {
                                                case 65:
                                                    i = MediaPlayer.MEDIA_INFO_PRECISE_PAUSED;
                                                    break;
                                                case 66:
                                                    i = MediaPlayer.MEDIA_INFO_ABR_GET_PREDICT;
                                                    break;
                                                case 67:
                                                    i = MediaPlayer.MEDIA_INFO_LIVE_VIDEO_RENDER_START;
                                                    break;
                                                default:
                                                    switch (what) {
                                                        case 70:
                                                            i = MediaPlayer.MEDIA_INFO_VIDEO_SECOND_FRAME;
                                                            break;
                                                        case 71:
                                                            i = MediaPlayer.MEDIA_INFO_LIVE_FIRST_FRAME_AFTER_SURFACE_CHANGE;
                                                            break;
                                                        case 72:
                                                            i = MediaPlayer.MEDIA_INFO_FIRST_AVSYNC_FRAME;
                                                            break;
                                                        case 73:
                                                            i = MediaPlayer.MEDIA_INFO_REFRESH_SURFACE;
                                                            break;
                                                        default:
                                                            i = -1;
                                                            break;
                                                    }
                                            }
                                    }
                            }
                    }
            }
        } else {
            i = MediaPlayer.MEDIA_INFO_INFO_ID_CHANGED;
        }
        this.mOnInfoListener.onInfo(this.mWrapper, i, parameter);
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setOnLogListener(MediaPlayer.OnLogListener listener) {
        this.mLogListener = listener;
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setOnBufferingUpdateListener(MediaPlayer.OnBufferingUpdateListener listener) {
        this.mOnBufferingUpdateListener = listener;
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setNotifyState(3L);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setOnCompletionListener(MediaPlayer.OnCompletionListener listener) {
        this.mOnCompletionListener = listener;
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setNotifyState(13L);
                this.mPlayer.setNotifyState(111L);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setOnErrorListener(MediaPlayer.OnErrorListener listener) {
        this.mOnErrorListener = listener;
        long[] jArr = {0, 45};
        this.mReadLock.lock();
        try {
            if (isValid()) {
                for (int i = 0; i < 2; i++) {
                    this.mPlayer.setNotifyState(jArr[i]);
                }
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setOnInfoListener(MediaPlayer.OnInfoListener listener) {
        this.mOnInfoListener = listener;
        long[] jArr = {1, 4, 5, 7, 8, 9, 10, 21, 22, 20, 24, 25, 26, 28, 27, 29, 32, 34, 35, 36, 37, 38, 39, 41, 42, 50, 49, 47, 51, 52, 53, 54, 30, 57, 58, 61, 62, 65, 66, 67, 70, 71, 72, 73, 82, 84, 88, 91, 92};
        this.mReadLock.lock();
        try {
            if (isValid()) {
                for (int i = 0; i < 49; i++) {
                    this.mPlayer.setNotifyState(jArr[i]);
                }
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setOnExternInfoListener(MediaPlayer.OnExternInfoListener listener) {
        this.mOnExternInfoListener = listener;
        long[] jArr = {63, 59, 19, 33, 40, 43, 44, 68, 85, 87, 90};
        this.mReadLock.lock();
        try {
            if (isValid()) {
                for (int i = 0; i < 11; i++) {
                    this.mPlayer.setNotifyState(jArr[i]);
                }
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setFrameMetadataListener(FrameMetadataListener listener) {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setFrameMetadataListener(listener);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setStrategyParamsTransport(StrategyParamsTransport transport) {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setStrategyParamsTransport(transport);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setOnPreparedListener(MediaPlayer.OnPreparedListener listener) {
        this.mOnPreparedListener = listener;
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setNotifyState(2L);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setOnSeekCompleteListener(MediaPlayer.OnSeekCompleteListener listener) {
        this.mOnSeekCompleteListener = listener;
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setNotifyState(12L);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setOnVideoSizeChangedListener(MediaPlayer.OnVideoSizeChangedListener listener) {
        this.mOnVideoSizeChangedListener = listener;
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setNotifyState(6L);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setOnSARChangedListener(MediaPlayer.onSARChangedListener listener) {
        this.mOnSARChangedListener = listener;
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setNotifyState(23L);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setLoadControl(LoadControl control) {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setLoadControl(control);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setMaskInfo(MaskInfo maskInfo) {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setMaskInfo(maskInfo);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setAIBarrageInfo(MaskInfo barrageInfo) {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setAIBarrageInfo(barrageInfo);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public String getSubtitleContent(int queryTime) {
        this.mReadLock.lock();
        try {
            return isValid() ? this.mPlayer.getSubtitleContent(queryTime) : null;
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setSubInfo(SubInfo subInfo) {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setSubInfo(subInfo);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setMediaTransport(MediaTransport transport) {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setMediaTransport(transport);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setAudioProcessor(AudioProcessor processor) {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setAudioProcessor(processor);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setABRStrategy(ABRStrategy abrStrategy) {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setABRStrategy(abrStrategy);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setTraitObject(int type, TraitObject traitObject) {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setTraitObject(type, traitObject);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setupMediaCodec() {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setupMediaCodec();
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPlayLogInfo(int type, int errorCode, String info) {
        if (type == 2) {
            if (errorCode == 1) {
                this.mVoiceInfo = info;
                return;
            } else {
                if (errorCode == 0) {
                    this.mBufferingInfo = info;
                    return;
                }
                return;
            }
        }
        if (type == 0) {
            this.mErrorCode = errorCode;
        }
        if (info != null) {
            if (this.mLogInfo.size() > 40) {
                this.mLogInfo.removeFirst();
            }
            this.mLogInfo.addLast(String.format(Locale.US, "%s&&time:%d", info, Long.valueOf(System.currentTimeMillis())));
        }
    }

    private void sendSeekCompleted(int lifeId) {
        MediaPlayer.OnSeekCompleteListener onSeekCompleteListener;
        if (this.mSeekComplete || (onSeekCompleteListener = this.mOnSeekCompleteListener) == null) {
            return;
        }
        this.mSeekComplete = true;
        if (lifeId >= this.mPlayLifeId) {
            onSeekCompleteListener.onSeekComplete(this.mWrapper);
        }
    }

    private void sendCompletioned(int lifeId) {
        try {
            this.mReentrantLock.lock();
            MediaPlayer.OnCompletionListener onCompletionListener = this.mOnCompletionListener;
            if (onCompletionListener != null && lifeId >= this.mPlayLifeId) {
                onCompletionListener.onCompletion(this.mWrapper);
            }
        } finally {
            if (this.mReentrantLock.isLocked()) {
                this.mReentrantLock.unlock();
            }
        }
    }

    private void sendErrorInfo(int parameter, int lifeId) {
        try {
            this.mReentrantLock.lock();
            MediaPlayer.OnErrorListener onErrorListener = this.mOnErrorListener;
            if (onErrorListener != null && lifeId >= this.mPlayLifeId) {
                int i = this.mErrorCode;
                if (i != 0) {
                    parameter = i;
                } else if (parameter == 0) {
                    parameter = -1048575;
                }
                onErrorListener.onError(this.mWrapper, parameter, 0);
            }
        } finally {
            if (this.mReentrantLock.isLocked()) {
                this.mReentrantLock.unlock();
            }
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message msg) {
        if (msg.what != 3) {
            AVLogger.m239d(TAG, "handleMessage send message prev.thread id:" + Thread.currentThread().getId());
        }
        handleNotify(msg.arg2, msg.what, msg.arg1, msg.obj instanceof String ? (String) msg.obj : null);
        if (msg.what == 3) {
            return true;
        }
        AVLogger.m239d(TAG, "handleMessage send message after.thread id:" + Thread.currentThread().getId());
        return true;
    }

    private void onPlayerNotifyWithoutLock(int lifeId, int what, int parameter, String info) {
        if (this.mHandler == null) {
            AVLogger.m239d(TAG, "onPlayerNotify send message play is null:thread id" + Thread.currentThread().getId());
            return;
        }
        if (what == 40 && info != null) {
            handleNotify(lifeId, what, parameter, info);
            return;
        }
        if (what != 3) {
            AVLogger.m239d(TAG, "onPlayerNotify send message prev.thread id:" + Thread.currentThread().getId());
        }
        Message obtainMessage = this.mHandler.obtainMessage(what, parameter, lifeId);
        obtainMessage.obj = info;
        obtainMessage.sendToTarget();
        if (what != 3) {
            AVLogger.m239d(TAG, "onPlayerNotify send message after.thread id:" + Thread.currentThread().getId());
        }
    }

    public void onPlayerNotify(int lifeId, int what, int parameter, String info) {
        if (what != 3) {
            AVLogger.m239d(TAG, "onPlayerNotify send message start .thread id:" + Thread.currentThread().getId());
        }
        onPlayerNotifyWithoutLock(lifeId, what, parameter, info);
    }

    @Override // com.ss.ttm.player.ISurfaceListener
    public void onSurfaceCreated(SurfaceHolder holder) {
        AVLogger.m239d(TAG, "onSurfaceCreated");
        this.mSurfaceHolder = holder;
        if (this.mRealsedSurface || this.mIgnoreSurfaceCreated == 1) {
            return;
        }
        this.mReadLock.lock();
        try {
            if (isValid()) {
                SurfaceHolder surfaceHolder = this.mSurfaceHolder;
                if (holder != surfaceHolder) {
                    if (surfaceHolder != null) {
                        surfaceHolder.removeCallback(this.mCallback);
                    }
                    this.mSurfaceHolder = holder;
                    if (holder != null) {
                        holder.addCallback(this.mCallback);
                    }
                }
                this.mPlayer.setSurfaceTimeOut(holder.getSurface(), 0);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.ISurfaceListener
    public void onSurfaceChanged(SurfaceHolder holder) {
        AVLogger.m239d(TAG, "surface is change");
    }

    @Override // com.ss.ttm.player.ISurfaceListener
    public void onSurfaceDestroyed(SurfaceHolder holder) {
        String str = TAG;
        AVLogger.m239d(str, "surface is destory");
        if (this.mRealsedSurface) {
            AVLogger.m239d(str, "TTIPMediaPlayer player is will release");
            return;
        }
        if (this.mMediaCodecStopTimeOutMs > 0) {
            try {
                AVThreadPool.addTask(new Callable<String>() { // from class: com.ss.ttm.player.TTPlayerClient.2
                    @Override // java.util.concurrent.Callable
                    public String call() {
                        try {
                            TTPlayerClient.this.mReadLock.lockInterruptibly();
                            try {
                                if (TTPlayerClient.this.isValid()) {
                                    TTPlayerClient.this.mPlayer.setSurfaceTimeOut(null, 0);
                                }
                                TTPlayerClient.this.mReadLock.unlock();
                                return "OK";
                            } catch (Throwable th) {
                                TTPlayerClient.this.mReadLock.unlock();
                                throw th;
                            }
                        } catch (InterruptedException unused) {
                            AVLogger.Error(TTPlayerClient.TAG, this, "mPlayer setsurface null failed.");
                            return "OK";
                        }
                    }
                }).get(this.mMediaCodecStopTimeOutMs, TimeUnit.MILLISECONDS);
                return;
            } catch (InterruptedException | ExecutionException | TimeoutException unused) {
                AVLogger.Error(TAG, this, "set surface time out");
                return;
            }
        }
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setSurfaceTimeOut(null, 0);
            }
            this.mReadLock.unlock();
            AVLogger.m239d(str, "TTIPMediaPlayer player set surface");
        } catch (Throwable th) {
            this.mReadLock.unlock();
            throw th;
        }
    }

    private String getPlayerCrashedInfo() {
        Context context;
        String crashFileContext;
        String crashFileContext2;
        int value = TTPlayerConfiger.getValue(18, 1);
        StringBuilder sb = new StringBuilder();
        ITTPlayerRef iTTPlayerRef = this.mPlayer;
        if (iTTPlayerRef == null) {
            context = this.mContext;
        } else {
            context = iTTPlayerRef.getContext();
        }
        if (context == null) {
            return "context is null";
        }
        if (value > 1) {
            String existsCrashFilePath = TTCrashUtil.existsCrashFilePath(context);
            if (existsCrashFilePath != null && (crashFileContext2 = TTCrashUtil.getCrashFileContext(context, existsCrashFilePath, sb)) != null) {
                TTCrashUtil.deleteCrashFile(this.mContext, existsCrashFilePath);
                this.mCrashType = 1;
                if (TTPlayerConfiger.getValue(5, false)) {
                    AVLogger.m239d(TAG, "<TTPlayerIPClient,getCrashedInfo>find breakpad file");
                }
                return crashFileContext2;
            }
            AVErrorInfo.setupPhoneInfo(context, sb);
        }
        String value2 = TTPlayerConfiger.getValue(19, (String) null);
        if (value2 != null && (crashFileContext = TTCrashUtil.getCrashFileContext(this.mContext, value2, sb)) != null) {
            TTCrashUtil.deleteCrashFile(this.mContext, value2);
            this.mCrashType = 1;
            if (TTPlayerConfiger.getValue(5, false)) {
                AVLogger.m239d(TAG, "<TTPlayerIPClient,getCrashedInfo>find breakpad file");
            }
            return crashFileContext;
        }
        sb.append("\ncreate time:" + AVTime.getFormatNow());
        sb.append("\nport version:").append(value);
        sb.append("\nstart service info:").append(TTPlayerConfiger.getValue(16, "not find service start info"));
        sb.append("\nstop service info:").append(TTPlayerConfiger.getValue(12, "not find service stop info"));
        sb.append("\ncrash:").append(TTPlayerConfiger.getValue(7, false));
        sb.append("\nsdk info:").append(TTPlayerConfiger.getValue(15, "not find sdk info"));
        sb.append("\ntimeout count:").append(TTPlayerConfiger.getValue(10, -1));
        sb.append("\nforeground:").append(TTPlayerConfiger.getValue(21, -1));
        sb.append("\non screen:").append(TTPlayerConfiger.getValue(22, -1));
        sb.append("\n battery info:").append(TTPlayerConfiger.getValue(23, "not find"));
        sb.append("\nurl:").append(this.mUri);
        sb.append("\ncrash:\r\n").append((CharSequence) this.mCrashedInfo);
        this.mCrashType = 0;
        if (value > 1) {
            if (TTPlayerConfiger.getValue(5, false)) {
                AVLogger.m239d(TAG, "<TTPlayerIPClient,getCrashedInfo>" + sb.toString());
            }
            return TTCrashUtil.getBase64SampleCrash(sb.toString());
        }
        return sb.toString();
    }

    protected void onCrashedInfo(String info) {
        if (this.mCrashedInfo.length() < 1024) {
            this.mCrashedInfo.append(info).append(UpdateDialogNewBase.TYPE);
        }
    }

    private String getPlayerErrorInfo() {
        try {
            StringBuilder sb = new StringBuilder();
            LinkedList<String> linkedList = this.mLogInfo;
            if ((linkedList != null && linkedList.size() > 0) || this.mBufferingInfo != null || this.mVoiceInfo != null) {
                AVErrorInfo.setupErrorInfo(this.mContext, sb, "error", "play error", this.mUri);
                Iterator<String> it = this.mLogInfo.iterator();
                while (it.hasNext()) {
                    sb.append(it.next()).append(UpdateDialogNewBase.TYPE);
                }
                String str = this.mBufferingInfo;
                if (str != null) {
                    sb.append(str).append(UpdateDialogNewBase.TYPE);
                    this.mBufferingInfo = null;
                }
                String str2 = this.mVoiceInfo;
                if (str2 != null) {
                    sb.append(str2).append(UpdateDialogNewBase.TYPE);
                    this.mVoiceInfo = null;
                }
            }
            return sb.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public int getType() {
        this.mReadLock.lock();
        try {
            return isValid() ? this.mPlayer.getType() : 0;
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setPlaybackParams(PlaybackParams params) {
        this.mReadLock.lock();
        try {
            if (isValid() && params != null && params.getSpeed() != -1.0f) {
                this.mPlayer.setFloatOption(60, params.getSpeed());
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void selectTrack(int index) {
        this.mReadLock.lock();
        ITTPlayerRef iTTPlayerRef = this.mPlayer;
        if (iTTPlayerRef != null && index == 0) {
            iTTPlayerRef.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_SET_RADIO_MODE, 0);
        }
        this.mReadLock.unlock();
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void deselectTrack(int index) {
        this.mReadLock.lock();
        ITTPlayerRef iTTPlayerRef = this.mPlayer;
        if (iTTPlayerRef != null && index == 0) {
            iTTPlayerRef.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_SET_RADIO_MODE, 1);
        } else if (iTTPlayerRef != null) {
            iTTPlayerRef.setIntOption(65, (index << 8) | 0);
        }
        this.mReadLock.unlock();
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public MediaPlayer.TrackInfo[] getTrackInfo() {
        this.mReadLock.lock();
        try {
            return isValid() ? this.mPlayer.getTrackInfo() : null;
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setOnImageAvailableListener(ImageReader.OnImageAvailableListener listener, Handler handler) {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setOnImageAvailableListener(listener, handler);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }
}
