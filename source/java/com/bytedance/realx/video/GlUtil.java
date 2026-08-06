package com.bytedance.realx.video;

import android.opengl.GLES20;
import android.util.Log;
import com.bytedance.realx.base.RXLogging;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* loaded from: classes4.dex */
public class GlUtil {
    private GlUtil() {
    }

    public static void checkNoGLES2Error(String msg) {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            Log.e("checkNoGLES2Error", msg + "error: " + glGetError);
            RXLogging.e("checkNoGLES2Error", msg + "error: " + glGetError);
            if (glGetError != 1285) {
                throw new RuntimeException(msg + ": GLES20 error: " + glGetError);
            }
        }
    }

    public static void clearGLES2Error(String msg) {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            Log.w("clearGLES2Error", msg + "clear opengl error: " + glGetError);
            RXLogging.w("clearGLES2Error", msg + "clear opengl error: " + glGetError);
        }
    }

    public static FloatBuffer createFloatBuffer(float[] coords) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(coords.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        asFloatBuffer.put(coords);
        asFloatBuffer.position(0);
        return asFloatBuffer;
    }

    public static int generateTexture(int target) {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        int i = iArr[0];
        GLES20.glBindTexture(target, i);
        GLES20.glTexParameterf(target, 10241, 9729.0f);
        GLES20.glTexParameterf(target, 10240, 9729.0f);
        GLES20.glTexParameterf(target, 10242, 33071.0f);
        GLES20.glTexParameterf(target, 10243, 33071.0f);
        checkNoGLES2Error("generateTexture");
        return i;
    }
}
