package com.ss.ttm.player;

import android.content.Context;
import android.media.ImageReader;
import android.net.Uri;
import android.os.Handler;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.ss.ttm.player.MediaPlayer;
import com.ss.ttm.utils.AVLogger;
import com.ss.ttm.utils.HardWareInfo;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class TTMediaPlayer implements MediaPlayer {
    protected MediaPlayerClient mClient;
    protected int mPlayerType = 0;

    @Override // com.ss.ttm.player.MediaPlayer
    public void setCacheFile(String path, int mode) {
    }

    static {
        TTVersion.saveVersionInfo();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00b6 A[Catch: all -> 0x00da, TryCatch #1 {, blocks: (B:4:0x000b, B:6:0x001b, B:15:0x00b6, B:17:0x00bc, B:18:0x00c4, B:23:0x00cc, B:27:0x00d6, B:34:0x00a7, B:36:0x00b0, B:9:0x0095, B:11:0x009b, B:31:0x00a1), top: B:3:0x000b, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00d4 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00d6 A[Catch: all -> 0x00da, TRY_ENTER, TRY_LEAVE, TryCatch #1 {, blocks: (B:4:0x000b, B:6:0x001b, B:15:0x00b6, B:17:0x00bc, B:18:0x00c4, B:23:0x00cc, B:27:0x00d6, B:34:0x00a7, B:36:0x00b0, B:9:0x0095, B:11:0x009b, B:31:0x00a1), top: B:3:0x000b, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final synchronized TTMediaPlayer create(Context context) {
        MediaPlayerClient mediaPlayerClient;
        synchronized (TTMediaPlayer.class) {
            TTMediaPlayer tTMediaPlayer = new TTMediaPlayer();
            if (TTPlayerConfiger.isPrintInfo()) {
                AVLogger.m239d(TTPlayerConfiger.TAG, "ttplayer:" + TTPlayerConfiger.getValue(1, false) + ",ipc:" + TTPlayerConfiger.getValue(2, false) + ",crashed:" + TTPlayerConfiger.getValue(7, false) + ",cpu family" + HardWareInfo.getCpuFamily() + ",debug:false,timeout count:" + TTPlayerConfiger.getValue(10, 0) + ",forbid create os player:" + TTPlayerConfiger.getValue(11, false));
                AVLogger.m239d(TTPlayerConfiger.TAG, "version info:" + TTPlayerConfiger.getValue(15, "not find version info"));
            }
            try {
            } catch (Throwable th) {
                th.printStackTrace();
                if (!TTPlayerConfiger.getValue(7, false)) {
                    TTPlayerConfiger.setValue(7, true);
                }
            }
            if (TTPlayerConfiger.isOnTTPlayer() || TTPlayerConfiger.getValue(11, false)) {
                mediaPlayerClient = TTPlayerClient.create(tTMediaPlayer, context, null, null);
                if (mediaPlayerClient == null) {
                    if (TTPlayerConfiger.isPrintInfo()) {
                        AVLogger.m239d(TTPlayerConfiger.TAG, "---------->ttplayer off<------------");
                    }
                    if (TTPlayerConfiger.getValue(11, false)) {
                        return null;
                    }
                    mediaPlayerClient = OSPlayerClient.create(tTMediaPlayer, context);
                    tTMediaPlayer.mPlayerType = 0;
                }
                if (mediaPlayerClient != null) {
                    return null;
                }
                tTMediaPlayer.mClient = mediaPlayerClient;
                return tTMediaPlayer;
            }
            mediaPlayerClient = null;
            if (mediaPlayerClient == null) {
            }
            if (mediaPlayerClient != null) {
            }
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public boolean isOSPlayer() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        return mediaPlayerClient == null || mediaPlayerClient.getType() == 0;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public int getPlayerType() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            return mediaPlayerClient.getType();
        }
        return 0;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    @Deprecated
    public void prevClose() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.prevClose();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void release() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.release();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void releaseAsync() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.releaseAsync();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void start() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.start();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void pause() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.pause();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void reset() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.reset();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void stop() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.stop();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void prepare() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.prepare();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void prepareAsync() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.prepareAsync();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void preDemux() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.preDemux();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public PipelineLoader prepareMix(PipelineLoadParams params) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            return mediaPlayerClient.prepareMix(params);
        }
        return null;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public int getCurrentPosition() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            return mediaPlayerClient.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public int getVideoHeight() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            return mediaPlayerClient.getVideoHeight();
        }
        return 0;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public int getVideoWidth() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            return mediaPlayerClient.getVideoWidth();
        }
        return 0;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public int getDuration() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            return mediaPlayerClient.getDuration();
        }
        return 0;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public int getVideoType() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            return mediaPlayerClient.getVideoType();
        }
        return 0;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setPanoVideoControlModel(int model) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setPanoVideoControlModel(model);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setDisplay(SurfaceHolder surfaceHolder) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setDisplay(surfaceHolder);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setSurface(Surface surface) {
        MediaPlayerClient mediaPlayerClient;
        if (surface == null || !surface.isValid() || (mediaPlayerClient = this.mClient) == null) {
            return;
        }
        mediaPlayerClient.setSurface(surface);
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setWindowClient(TTAVWindowClient client) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient == null) {
            return;
        }
        mediaPlayerClient.setWindowClient(client);
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setSurfaceTimeOut(Surface surface, int timeoutMs) {
        MediaPlayerClient mediaPlayerClient;
        if (surface == null || !surface.isValid() || (mediaPlayerClient = this.mClient) == null) {
            return;
        }
        mediaPlayerClient.setSurfaceTimeOut(surface, timeoutMs);
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setDataSource(Context context, Uri uri, Map<String, String> headers) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setDataSource(context, uri, headers);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setDataSource(String path) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setDataSource(path);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setDataSource(Context context, Uri uri) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setDataSource(context, uri);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setDataSource(FileDescriptor fd, long offset, long length) throws IllegalStateException, IllegalArgumentException, IOException {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setDataSource(fd, offset, length);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setDataSource(IMediaDataSource dataSource) throws IllegalArgumentException, IOException {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setDataSource(dataSource);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public String getDataSource() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            return mediaPlayerClient.getDataSource();
        }
        return null;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public boolean isPlaying() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            return mediaPlayerClient.isPlaying();
        }
        return false;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public boolean isLooping() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            return mediaPlayerClient.isLooping();
        }
        return false;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setLooping(boolean b) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setLooping(b);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setVolume(float left, float right) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setVolume(left, right);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void mouseEvent(int action, int deltaX, int deltaY) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.mouseEvent(action, deltaX, deltaY);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void seekTo(int msec) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.seekTo(msec);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setScreenOnWhilePlaying(boolean screenOn) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setScreenOnWhilePlaying(screenOn);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setOnLogListener(MediaPlayer.OnLogListener listener) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setOnLogListener(listener);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setOnBufferingUpdateListener(MediaPlayer.OnBufferingUpdateListener listener) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setOnBufferingUpdateListener(listener);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setOnCompletionListener(MediaPlayer.OnCompletionListener listener) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setOnCompletionListener(listener);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setOnErrorListener(MediaPlayer.OnErrorListener listener) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setOnErrorListener(listener);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setOnInfoListener(MediaPlayer.OnInfoListener listener) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setOnInfoListener(listener);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setOnExternInfoListener(MediaPlayer.OnExternInfoListener listener) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setOnExternInfoListener(listener);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setOnSARChangedListener(MediaPlayer.onSARChangedListener listener) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setOnSARChangedListener(listener);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setOnPreparedListener(MediaPlayer.OnPreparedListener listener) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setOnPreparedListener(listener);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setOnSeekCompleteListener(MediaPlayer.OnSeekCompleteListener listener) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setOnSeekCompleteListener(listener);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setOnVideoSizeChangedListener(MediaPlayer.OnVideoSizeChangedListener listener) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setOnVideoSizeChangedListener(listener);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setIntOption(int key, int value) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setIntOption(key, value);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setWakeMode(Context context, int mode) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setWakeMode(context, mode);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setIsMute(boolean isMute) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setIsMute(isMute);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public boolean isMute() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            return mediaPlayerClient.isMute();
        }
        return false;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setStringOption(int key, String value) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setStringOption(key, value);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public int getIntOption(int key, int dValue) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        return mediaPlayerClient != null ? mediaPlayerClient.getIntOption(key, dValue) : dValue;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public String getStringOption(int key) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            return mediaPlayerClient.getStringOption(key);
        }
        return null;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public long getLongOption(int key, long dValue) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        return mediaPlayerClient != null ? mediaPlayerClient.getLongOption(key, dValue) : dValue;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public long setLongOption(int key, long value) {
        if (this.mClient != null) {
            return r0.setLongOption(key, value);
        }
        return -1L;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public float getFloatOption(int key, float dValue) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        return mediaPlayerClient != null ? mediaPlayerClient.getFloatOption(key, dValue) : dValue;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public int setFloatOption(int key, float value) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            return mediaPlayerClient.setFloatOption(key, value);
        }
        return -1;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setTraitObject(int type, TraitObject traitObject) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setTraitObject(type, traitObject);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void rotateCamera(float angleX, float angleY) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.rotateCamera(angleX, angleY);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void takeScreenshot(MediaPlayer.OnScreenshotListener listener) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.takeScreenshot(listener);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void switchStream(int bitrate, int streamType) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.switchStream(bitrate, streamType);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setPlaybackParams(PlaybackParams params) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setPlaybackParams(params);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void selectTrack(int index) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient == null || index != 0) {
            return;
        }
        mediaPlayerClient.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_SET_RADIO_MODE, 0);
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void deselectTrack(int index) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null && index == 0) {
            mediaPlayerClient.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_SET_RADIO_MODE, 1);
        } else if (mediaPlayerClient != null) {
            mediaPlayerClient.setIntOption(65, (index << 8) | 0);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public int getSelectedTrack(int trackType) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            return mediaPlayerClient.getSelectedTrack(trackType);
        }
        return -1;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public MediaPlayer.TrackInfo[] getTrackInfo() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            return mediaPlayerClient.getTrackInfo();
        }
        return null;
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setMediaTransport(MediaTransport transport) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setMediaTransport(transport);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setIntOptionArray(int[] keys, int[] values) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setIntOptionArray(keys, values);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setLongOptionArray(int[] keys, long[] values) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setLongOptionArray(keys, values);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setFloatOptionArray(int[] keys, float[] values) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setFloatOptionArray(keys, values);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setStringOptionArray(int[] keys, String[] values) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setStringOptionArray(keys, values);
        }
    }

    public void setUnSupportSampleRates(int[] sampleRates) {
        if (!isOSPlayer() && (sampleRates.length) > 0) {
            int length = MEDIA_PLAYER_SUPPORT_SAMPLERATES.length;
            int i = 0;
            for (int i2 : sampleRates) {
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    }
                    if (MEDIA_PLAYER_SUPPORT_SAMPLERATES[i3] == i2) {
                        i |= 1 << i3;
                        break;
                    }
                    i3++;
                }
            }
            MediaPlayerClient mediaPlayerClient = this.mClient;
            if (mediaPlayerClient != null) {
                mediaPlayerClient.setIntOption(111, i);
            }
        }
    }

    @Override // com.ss.ttm.player.MediaPlayer
    public void setOnImageAvailableListener(ImageReader.OnImageAvailableListener listener, Handler handler) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient == null) {
            mediaPlayerClient.setOnImageAvailableListener(listener, handler);
        }
    }
}
