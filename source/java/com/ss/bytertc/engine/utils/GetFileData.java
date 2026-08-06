package com.ss.bytertc.engine.utils;

import android.content.Context;
import android.net.Uri;
import com.ss.bytertc.base.utils.RtcContextUtils;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes7.dex */
public class GetFileData {
    public static ByteBuffer readFile(String srcUri) {
        Context applicationContext = RtcContextUtils.getApplicationContext();
        if (srcUri.startsWith("/assets/") && applicationContext != null) {
            return getAssets(applicationContext, srcUri.substring(8));
        }
        if (!srcUri.startsWith("content://") || applicationContext == null) {
            return null;
        }
        return getOthers(applicationContext, srcUri);
    }

    public static ByteBuffer getOthers(Context context, String srcUri) {
        try {
            InputStream openInputStream = context.getContentResolver().openInputStream(Uri.parse(srcUri));
            if (openInputStream == null) {
                return null;
            }
            byte[] bArr = new byte[openInputStream.available()];
            int read = openInputStream.read(bArr);
            openInputStream.close();
            if (read <= 0) {
                return null;
            }
            return convertDirectBuffer(ByteBuffer.wrap(bArr));
        } catch (Exception unused) {
            return null;
        }
    }

    public static ByteBuffer getAssets(Context context, String srcUri) {
        try {
            InputStream open = context.getResources().getAssets().open(srcUri);
            if (open == null) {
                return null;
            }
            byte[] bArr = new byte[open.available()];
            int read = open.read(bArr);
            open.close();
            if (read <= 0) {
                return null;
            }
            return convertDirectBuffer(ByteBuffer.wrap(bArr));
        } catch (IOException unused) {
            return null;
        }
    }

    private static ByteBuffer convertDirectBuffer(ByteBuffer buffer) {
        if (buffer == null) {
            return null;
        }
        if (buffer.isDirect()) {
            return buffer;
        }
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(buffer.remaining());
        allocateDirect.position(0);
        allocateDirect.put(buffer);
        allocateDirect.rewind();
        return allocateDirect;
    }
}
