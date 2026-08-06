package com.lynx.canvas.camera;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.view.WindowManager;
import com.lynx.canvas.KryptonCamera;
import com.lynx.canvas.KryptonLLog;
import com.ss.ttm.player.MediaPlayer;
import java.io.IOException;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class KryptonDefaultCamera implements KryptonCamera {
    private static final int CAMERA_RETRY_TIMES = 3;
    private static final String TAG = "Camera default";
    private Camera mCamera;
    private Camera.CameraInfo mCameraInfo;
    private final Context mContext;
    private int mHeight;
    private final Invoker mInvoker;
    private int mWidth;
    private int mCameraId = -1;
    private int mFacing = 0;

    /* loaded from: classes6.dex */
    public interface Invoker {
        Camera openCamera(int i) throws RuntimeException;

        void releaseCamera(Camera camera);
    }

    public KryptonDefaultCamera(Context context, Invoker invoker) {
        this.mContext = context;
        this.mInvoker = invoker;
    }

    private boolean checkNoDefault(KryptonCamera.Config config) {
        if (config != null && config.extraJson != null) {
            try {
                return new JSONObject(config.extraJson).optBoolean("noDefault");
            } catch (JSONException e) {
                KryptonLLog.w(TAG, "parse extraJson failed " + e.toString());
            }
        }
        return false;
    }

    @Override // com.lynx.canvas.KryptonCamera
    public boolean requestWithConfig(KryptonCamera.Config config) {
        if (checkNoDefault(config)) {
            KryptonLLog.e(TAG, "the use of default camera is not allowed when noDefault is set to true");
            return false;
        }
        if (config != null && "back".equals(config.faceMode)) {
            this.mFacing = 0;
        } else {
            this.mFacing = 1;
        }
        int i = 0;
        while (true) {
            if (i >= Camera.getNumberOfCameras()) {
                break;
            }
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(i, cameraInfo);
            if (cameraInfo.facing == this.mFacing) {
                this.mCameraId = i;
                this.mCameraInfo = cameraInfo;
                break;
            }
            i++;
        }
        Camera openCamera = openCamera(this.mCameraId);
        this.mCamera = openCamera;
        if (openCamera == null) {
            KryptonLLog.e(TAG, "open failed");
            return false;
        }
        openCamera.setDisplayOrientation(getCameraDisplayOrientation(this.mCameraInfo));
        Camera.Parameters parameters = this.mCamera.getParameters();
        KryptonCamera.CustomSize customSize = config != null ? config.size : null;
        if (customSize != null && customSize.width > 0 && customSize.height > 0) {
            KryptonCamera.CustomSize optimalPreviewSize = getOptimalPreviewSize(parameters.getSupportedPreviewSizes(), customSize.width, customSize.height);
            if (optimalPreviewSize == null) {
                KryptonLLog.e(TAG, "Get preview size failed with high resolution");
                return false;
            }
            this.mWidth = optimalPreviewSize.width;
            this.mHeight = optimalPreviewSize.height;
        } else if (config != null && "high".equals(config.resolution)) {
            KryptonCamera.CustomSize optimalPreviewSize2 = getOptimalPreviewSize(parameters.getSupportedPreviewSizes(), 720.0f, 1280.0f);
            if (optimalPreviewSize2 == null) {
                KryptonLLog.e(TAG, "Get preview size failed with high resolution");
                return false;
            }
            this.mWidth = optimalPreviewSize2.width;
            this.mHeight = optimalPreviewSize2.height;
        } else if (config != null && "low".equals(config.resolution)) {
            KryptonLLog.i(TAG, "low");
            this.mWidth = 288;
            this.mHeight = 352;
        } else {
            KryptonLLog.i(TAG, "default");
            this.mWidth = 480;
            this.mHeight = 640;
        }
        KryptonLLog.i(TAG, "use camera with landscape preview size (" + this.mHeight + "," + this.mWidth + ")");
        parameters.setPreviewSize(this.mHeight, this.mWidth);
        parameters.setPreviewFormat(17);
        if (config.autoFocus && parameters.getSupportedFocusModes().contains("continuous-picture")) {
            parameters.setFocusMode("continuous-picture");
        }
        try {
            this.mCamera.setParameters(parameters);
            return true;
        } catch (Exception e) {
            KryptonLLog.e(TAG, "setParameters failed " + e.getMessage());
            return false;
        }
    }

    private KryptonCamera.CustomSize getOptimalPreviewSize(List<Camera.Size> list, float f, float f2) {
        Camera.Size size = null;
        for (Camera.Size size2 : list) {
            if (size2.height <= f && (size == null || size2.height > size.height)) {
                KryptonLLog.i(TAG, "update max supported size to (" + size2.width + "," + size2.height + ")");
                size = size2;
            }
        }
        if (size == null) {
            KryptonLLog.e(TAG, "find max supported preview size error");
            return null;
        }
        return new KryptonCamera.CustomSize(size.height, size.width);
    }

    private Camera openCamera(int i) {
        if (i < 0) {
            return null;
        }
        for (int i2 = 0; i2 < 3; i2++) {
            try {
                Invoker invoker = this.mInvoker;
                if (invoker != null) {
                    return invoker.openCamera(i);
                }
                return Camera.open(i);
            } catch (Exception e) {
                KryptonLLog.e(TAG, "open exception:" + e.toString());
                try {
                    Thread.sleep(i2 * 100);
                } catch (InterruptedException e2) {
                    KryptonLLog.e(TAG, "thread sleep exception:" + e2.toString());
                }
            }
        }
        return null;
    }

    @Override // com.lynx.canvas.KryptonCamera
    public int getWidth() {
        return this.mWidth;
    }

    @Override // com.lynx.canvas.KryptonCamera
    public int getHeight() {
        return this.mHeight;
    }

    @Override // com.lynx.canvas.KryptonCamera
    public void setupPreviewTexture(SurfaceTexture surfaceTexture) {
        Camera camera = this.mCamera;
        if (camera == null) {
            return;
        }
        try {
            camera.setPreviewTexture(surfaceTexture);
        } catch (IOException e) {
            KryptonLLog.e(TAG, "setPreviewTexture exception:" + e.toString());
        }
    }

    @Override // com.lynx.canvas.KryptonCamera
    public void play() {
        Camera camera = this.mCamera;
        if (camera == null) {
            return;
        }
        camera.startPreview();
    }

    @Override // com.lynx.canvas.KryptonCamera
    public void pause() {
        Camera camera = this.mCamera;
        if (camera == null) {
            return;
        }
        camera.stopPreview();
        this.mCamera.lock();
    }

    @Override // com.lynx.canvas.KryptonCamera
    public void release() {
        Camera camera = this.mCamera;
        if (camera == null) {
            return;
        }
        Invoker invoker = this.mInvoker;
        if (invoker != null) {
            invoker.releaseCamera(camera);
        } else {
            camera.release();
        }
        this.mCamera = null;
    }

    @Override // com.lynx.canvas.KryptonCamera
    public void focus() {
        Camera camera = this.mCamera;
        if (camera == null) {
            return;
        }
        camera.autoFocus(null);
    }

    private int getCameraDisplayOrientation(Camera.CameraInfo cameraInfo) {
        int rotation = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getRotation();
        int i = 0;
        if (rotation != 0) {
            if (rotation == 1) {
                i = 90;
            } else if (rotation == 2) {
                i = 180;
            } else if (rotation == 3) {
                i = 270;
            }
        }
        if (cameraInfo.facing == 1) {
            return (360 - ((cameraInfo.orientation + i) % MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL)) % MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL;
        }
        return ((cameraInfo.orientation - i) + MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL) % MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL;
    }
}
