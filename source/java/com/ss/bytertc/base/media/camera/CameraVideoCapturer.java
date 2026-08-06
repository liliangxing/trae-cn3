package com.ss.bytertc.base.media.camera;

import android.media.MediaRecorder;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedance.realx.base.RXLogging;
import com.ss.bytertc.base.media.SurfaceTextureHelper;
import com.ss.bytertc.base.media.VideoCapturer;
import com.ss.bytertc.base.media.camera.CameraEnumerationAndroid;

/* loaded from: classes7.dex */
public interface CameraVideoCapturer extends VideoCapturer {

    /* loaded from: classes7.dex */
    public interface CameraEventsHandler {
        void onCameraClosed();

        void onCameraConfig(int width, int height, CameraEnumerationAndroid.CaptureFormat.FramerateRange FramerateRange);

        void onCameraDisconnected();

        void onCameraError(String errorDescription);

        void onCameraFreezed(String errorDescription);

        void onCameraOpening(String cameraName);

        void onFirstFrameAvailable();
    }

    /* loaded from: classes7.dex */
    public interface CameraSwitchHandler {
        void onCameraSwitchDone(boolean isFrontCamera);

        void onCameraSwitchError(String errorDescription);
    }

    @Deprecated
    /* loaded from: classes7.dex */
    public interface MediaRecorderHandler {
        void onMediaRecorderError(String errorDescription);

        void onMediaRecorderSuccess();
    }

    void setOrientationMode(ORIENTATION_MODE orientationMode);

    void switchCamera(CameraSwitchHandler switchEventsHandler);

    @Deprecated
    default void addMediaRecorderToCamera(MediaRecorder mediaRecorder, MediaRecorderHandler resultHandler) {
        throw new UnsupportedOperationException("Deprecated and not implemented.");
    }

    @Deprecated
    default void removeMediaRecorderFromCamera(MediaRecorderHandler resultHandler) {
        throw new UnsupportedOperationException("Deprecated and not implemented.");
    }

    /* loaded from: classes7.dex */
    public enum ORIENTATION_MODE {
        ORIENTATION_MODE_ADAPTIVE(0),
        ORIENTATION_MODE_FIXED_LANDSCAPE(1),
        ORIENTATION_MODE_FIXED_PORTRAIT(2);

        private int value;

        ORIENTATION_MODE(int v) {
            this.value = v;
        }

        public static ORIENTATION_MODE convertFromInt(int v) {
            return values()[v];
        }

        public int getValue() {
            return this.value;
        }
    }

    /* loaded from: classes7.dex */
    public static class CameraStatistics {
        private static final int CAMERA_FREEZE_REPORT_TIMOUT_MS = 4000;
        private static final int CAMERA_OBSERVER_PERIOD_MS = 2000;
        private static final String TAG = "CameraStatistics";
        private final Runnable cameraObserver;
        private final CameraEventsHandler eventsHandler;
        private int frameCount;
        private int freezePeriodCount;
        private final SurfaceTextureHelper surfaceTextureHelper;

        static /* synthetic */ int access$104(CameraStatistics cameraStatistics) {
            int i = cameraStatistics.freezePeriodCount + 1;
            cameraStatistics.freezePeriodCount = i;
            return i;
        }

        public CameraStatistics(SurfaceTextureHelper surfaceTextureHelper, CameraEventsHandler eventsHandler) {
            Runnable runnable = new Runnable() { // from class: com.ss.bytertc.base.media.camera.CameraVideoCapturer.CameraStatistics.1
                @Override // java.lang.Runnable
                public void run() {
                    RXLogging.i(CameraStatistics.TAG, "Camera fps: " + Math.round((CameraStatistics.this.frameCount * 1000.0f) / 2000.0f) + LibrarianImpl.Constants.DOT);
                    if (CameraStatistics.this.frameCount != 0) {
                        CameraStatistics.this.freezePeriodCount = 0;
                    } else {
                        CameraStatistics.access$104(CameraStatistics.this);
                        if (CameraStatistics.this.freezePeriodCount * 2000 >= 4000 && CameraStatistics.this.eventsHandler != null) {
                            RXLogging.e(CameraStatistics.TAG, "Camera freezed.");
                            if (CameraStatistics.this.surfaceTextureHelper.isTextureInUse()) {
                                CameraStatistics.this.eventsHandler.onCameraFreezed("Camera failure. Client must return video buffers.");
                                return;
                            } else {
                                CameraStatistics.this.eventsHandler.onCameraFreezed("Camera failure.");
                                return;
                            }
                        }
                    }
                    CameraStatistics.this.frameCount = 0;
                    CameraStatistics.this.surfaceTextureHelper.getHandler().postDelayed(this, 2000L);
                }
            };
            this.cameraObserver = runnable;
            if (surfaceTextureHelper == null) {
                throw new IllegalArgumentException("SurfaceTextureHelper is null");
            }
            this.surfaceTextureHelper = surfaceTextureHelper;
            this.eventsHandler = eventsHandler;
            this.frameCount = 0;
            this.freezePeriodCount = 0;
            surfaceTextureHelper.getHandler().postDelayed(runnable, 2000L);
        }

        private void checkThread() {
            if (Thread.currentThread() != this.surfaceTextureHelper.getHandler().getLooper().getThread()) {
                throw new IllegalStateException("Wrong thread");
            }
        }

        public void addFrame() {
            checkThread();
            this.frameCount++;
        }

        public void release() {
            this.surfaceTextureHelper.getHandler().removeCallbacks(this.cameraObserver);
        }
    }
}
