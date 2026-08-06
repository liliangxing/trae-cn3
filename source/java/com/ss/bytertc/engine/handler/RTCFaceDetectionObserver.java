package com.ss.bytertc.engine.handler;

import com.ss.bytertc.engine.InternalExpressDetectInfo;
import com.ss.bytertc.engine.InternalRectangle;
import com.ss.bytertc.engine.video.ExpressionDetectInfo;
import com.ss.bytertc.engine.video.ExpressionDetectResult;
import com.ss.bytertc.engine.video.FaceDetectionResult;
import com.ss.bytertc.engine.video.IFaceDetectionObserver;
import com.ss.bytertc.engine.video.RTCVideoEffect;
import com.ss.bytertc.engine.video.Rectangle;
import java.lang.ref.WeakReference;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class RTCFaceDetectionObserver {
    private static final String TAG = "RTCFaceDetectionObserver";
    private WeakReference<RTCVideoEffect> mVideoEffect;

    public RTCFaceDetectionObserver(RTCVideoEffect videoEffect) {
        this.mVideoEffect = new WeakReference<>(videoEffect);
    }

    void OnFaceDetectResult(int detect_result, int image_width, int image_height, int face_count, InternalRectangle[] faces, long timestamp) {
        RTCVideoEffect rTCVideoEffect;
        WeakReference<RTCVideoEffect> weakReference = this.mVideoEffect;
        IFaceDetectionObserver faceDetectionObserver = (weakReference == null || (rTCVideoEffect = weakReference.get()) == null) ? null : rTCVideoEffect.getFaceDetectionObserver();
        if (faceDetectionObserver == null) {
            return;
        }
        FaceDetectionResult faceDetectionResult = new FaceDetectionResult();
        faceDetectionResult.imageWidth = image_width;
        faceDetectionResult.imageHeight = image_height;
        faceDetectionResult.frameTimestampUs = timestamp;
        faceDetectionResult.detectResult = detect_result;
        if (faces != null && faces.length > 0) {
            faceDetectionResult.faces = new Rectangle[faces.length];
            for (int i = 0; i < face_count; i++) {
                faceDetectionResult.faces[i] = new Rectangle(faces[i].f97x, faces[i].f98y, faces[i].width, faces[i].height);
            }
        } else {
            faceDetectionResult.faces = null;
        }
        faceDetectionObserver.onFaceDetectResult(faceDetectionResult);
    }

    void OnExpressionDetectResult(int ret, int faceCount, InternalExpressDetectInfo[] faces) {
        RTCVideoEffect rTCVideoEffect;
        WeakReference<RTCVideoEffect> weakReference = this.mVideoEffect;
        IFaceDetectionObserver faceDetectionObserver = (weakReference == null || (rTCVideoEffect = weakReference.get()) == null) ? null : rTCVideoEffect.getFaceDetectionObserver();
        if (faceDetectionObserver == null) {
            return;
        }
        ExpressionDetectResult expressionDetectResult = new ExpressionDetectResult();
        expressionDetectResult.detectResult = ret;
        if (expressionDetectResult.detectResult != 0) {
            expressionDetectResult.detectInfo = null;
        } else if (faces != null && faceCount > 0) {
            expressionDetectResult.detectInfo = new ExpressionDetectInfo[faceCount];
            expressionDetectResult.faceCount = faceCount;
            for (int i = 0; i < faceCount; i++) {
                InternalExpressDetectInfo internalExpressDetectInfo = faces[i];
                expressionDetectResult.detectInfo[i] = new ExpressionDetectInfo(internalExpressDetectInfo.age, internalExpressDetectInfo.boyProb, internalExpressDetectInfo.attractive, internalExpressDetectInfo.happyScore, internalExpressDetectInfo.sadScore, internalExpressDetectInfo.angryScore, internalExpressDetectInfo.surpriseScore, internalExpressDetectInfo.arousal, internalExpressDetectInfo.valence);
            }
        } else {
            expressionDetectResult.detectInfo = null;
        }
        faceDetectionObserver.onExpressionDetectResult(expressionDetectResult);
    }
}
