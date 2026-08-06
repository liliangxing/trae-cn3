package com.bytedance.realx.video;

import android.opengl.GLES20;
import android.util.Log;
import java.nio.Buffer;
import java.nio.FloatBuffer;

/* loaded from: classes4.dex */
public class GlShader {
    private static final String TAG = "GlShader";
    private int program;

    private static int compileShader(int shaderType, String source) {
        int glCreateShader = GLES20.glCreateShader(shaderType);
        if (glCreateShader == 0) {
            throw new RuntimeException("glCreateShader() failed. GLES20 error: " + GLES20.glGetError());
        }
        GLES20.glShaderSource(glCreateShader, source);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = {0};
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] != 1) {
            Log.e(TAG, "Compile error " + GLES20.glGetShaderInfoLog(glCreateShader) + " in shader:\n" + source);
            throw new RuntimeException(GLES20.glGetShaderInfoLog(glCreateShader));
        }
        GlUtil.checkNoGLES2Error("compileShader");
        return glCreateShader;
    }

    public GlShader(String vertexSource, String fragmentSource) {
        int compileShader = compileShader(35633, vertexSource);
        int compileShader2 = compileShader(35632, fragmentSource);
        int glCreateProgram = GLES20.glCreateProgram();
        this.program = glCreateProgram;
        if (glCreateProgram == 0) {
            throw new RuntimeException("glCreateProgram() failed. GLES20 error: " + GLES20.glGetError());
        }
        GLES20.glAttachShader(glCreateProgram, compileShader);
        GLES20.glAttachShader(this.program, compileShader2);
        GLES20.glLinkProgram(this.program);
        int[] iArr = {0};
        GLES20.glGetProgramiv(this.program, 35714, iArr, 0);
        if (iArr[0] != 1) {
            Log.e(TAG, "Could not link program: " + GLES20.glGetProgramInfoLog(this.program));
            throw new RuntimeException(GLES20.glGetProgramInfoLog(this.program));
        }
        GLES20.glDeleteShader(compileShader);
        GLES20.glDeleteShader(compileShader2);
        GlUtil.checkNoGLES2Error("Creating GlShader");
    }

    public int getAttribLocation(String label) {
        int i = this.program;
        if (i == -1) {
            throw new RuntimeException("The program has been released");
        }
        int glGetAttribLocation = GLES20.glGetAttribLocation(i, label);
        if (glGetAttribLocation >= 0) {
            return glGetAttribLocation;
        }
        throw new RuntimeException("Could not locate '" + label + "' in program");
    }

    public void setVertexAttribArray(String label, int dimension, FloatBuffer buffer) {
        setVertexAttribArray(label, dimension, 0, buffer);
    }

    public void setVertexAttribArray(String label, int dimension, int stride, FloatBuffer buffer) {
        if (this.program == -1) {
            throw new RuntimeException("The program has been released");
        }
        int attribLocation = getAttribLocation(label);
        GLES20.glEnableVertexAttribArray(attribLocation);
        GLES20.glVertexAttribPointer(attribLocation, dimension, 5126, false, stride, (Buffer) buffer);
        GlUtil.checkNoGLES2Error("setVertexAttribArray");
    }

    public int getUniformLocation(String label) {
        int i = this.program;
        if (i == -1) {
            throw new RuntimeException("The program has been released");
        }
        int glGetUniformLocation = GLES20.glGetUniformLocation(i, label);
        if (glGetUniformLocation >= 0) {
            return glGetUniformLocation;
        }
        throw new RuntimeException("Could not locate uniform '" + label + "' in program");
    }

    public void useProgram() {
        int i = this.program;
        if (i == -1) {
            throw new RuntimeException("The program has been released");
        }
        GLES20.glUseProgram(i);
        GlUtil.checkNoGLES2Error("glUseProgram");
    }

    public void release() {
        Log.d(TAG, "Deleting shader.");
        int i = this.program;
        if (i != -1) {
            GLES20.glDeleteProgram(i);
            this.program = -1;
        }
    }
}
