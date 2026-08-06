package com.bytedance.bdturing.livedetect;

import android.app.AlertDialog;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.bytedance.bdturing.C0603R;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class TuringBaseLiveDetectActivity extends AppCompatActivity {
    protected static final int CAMERA_PERMISSION_REQUEST_CODE = 1;
    private AlertDialog alertDialog = null;
    protected ImageView ivLoading;
    private CameraPermissionCallBack mPermissionCallback;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public interface CameraPermissionCallBack {
        public static final int CODE_DISABLE = 1;
        public static final int CODE_FORBIDDEN = 2;
        public static final int GRANT_STATE_ALREADY = 1;
        public static final int GRANT_STATE_BY_QUERY = 2;

        void onDenied(int i);

        void onForbidden();

        void onGRanted(int i);
    }

    public void showLoadingDlg() {
        showLoadingDlg("");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void showLoadingDlg(String str) {
        TextView textView;
        try {
            dismissLoadingDlg();
            AlertDialog create = new AlertDialog.Builder(this).create();
            this.alertDialog = create;
            create.getWindow().setBackgroundDrawable(new ColorDrawable());
            this.alertDialog.setCanceledOnTouchOutside(false);
            this.alertDialog.show();
            View inflate = View.inflate(this, C0603R.layout.turing_layout_loading_alert, null);
            if (!TextUtils.isEmpty(str) && (textView = (TextView) inflate.findViewById(C0603R.id.tv_loading)) != null) {
                textView.setText(str);
            }
            this.alertDialog.setContentView(inflate);
            RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setDuration(1000L);
            rotateAnimation.setRepeatCount(-1);
            rotateAnimation.setInterpolator(new LinearInterpolator());
            this.alertDialog.findViewById(C0603R.id.loading).startAnimation(rotateAnimation);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dismissLoadingDlg() {
        try {
            AlertDialog alertDialog = this.alertDialog;
            if (alertDialog == null || !alertDialog.isShowing()) {
                return;
            }
            this.alertDialog.findViewById(C0603R.id.loading).clearAnimation();
            this.alertDialog.dismiss();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void checkCameraPermission(CameraPermissionCallBack cameraPermissionCallBack) {
        this.mPermissionCallback = cameraPermissionCallBack;
        if (ContextCompat.checkSelfPermission(this, "android.permission.CAMERA") == 0) {
            if (cameraPermissionCallBack != null) {
                cameraPermissionCallBack.onGRanted(1);
            }
        } else {
            if (!ActivityCompat.shouldShowRequestPermissionRationale(this, "android.permission.CAMERA") && !LiveDetectService.getInstance().isRequestCameraPermissionFirstTime()) {
                CameraPermissionCallBack cameraPermissionCallBack2 = this.mPermissionCallback;
                if (cameraPermissionCallBack2 != null) {
                    cameraPermissionCallBack2.onForbidden();
                    return;
                }
                return;
            }
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.CAMERA"}, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void startLoading() {
        runOnUiThread(new Runnable() { // from class: com.bytedance.bdturing.livedetect.TuringBaseLiveDetectActivity.1
            @Override // java.lang.Runnable
            public void run() {
                if (TuringBaseLiveDetectActivity.this.ivLoading == null) {
                    return;
                }
                TuringBaseLiveDetectActivity.this.ivLoading.setVisibility(0);
                RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
                rotateAnimation.setDuration(1000L);
                rotateAnimation.setRepeatCount(-1);
                rotateAnimation.setInterpolator(new LinearInterpolator());
                TuringBaseLiveDetectActivity.this.ivLoading.startAnimation(rotateAnimation);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void stopLoading() {
        runOnUiThread(new Runnable() { // from class: com.bytedance.bdturing.livedetect.TuringBaseLiveDetectActivity.2
            @Override // java.lang.Runnable
            public void run() {
                if (TuringBaseLiveDetectActivity.this.ivLoading == null) {
                    return;
                }
                TuringBaseLiveDetectActivity.this.ivLoading.clearAnimation();
                TuringBaseLiveDetectActivity.this.ivLoading.setVisibility(4);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            LiveDetectService.getInstance().updatePermissionState();
            if (iArr.length > 0 && iArr[0] == 0) {
                CameraPermissionCallBack cameraPermissionCallBack = this.mPermissionCallback;
                if (cameraPermissionCallBack != null) {
                    cameraPermissionCallBack.onGRanted(2);
                    return;
                }
                return;
            }
            int i2 = ActivityCompat.shouldShowRequestPermissionRationale(this, "android.permission.CAMERA") ? 1 : 2;
            CameraPermissionCallBack cameraPermissionCallBack2 = this.mPermissionCallback;
            if (cameraPermissionCallBack2 != null) {
                cameraPermissionCallBack2.onDenied(i2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        dismissLoadingDlg();
        stopLoading();
    }
}
