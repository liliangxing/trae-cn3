package com.bytedance.push.utils;

import android.content.Context;
import android.util.Base64;
import com.bytedance.push.PushSupporter;
import com.bytedance.trae.kmp.artifacts.artifact.ArtifactRepository;
import java.io.File;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class MessageUtils {
    static final int BYTE_TYPE_COMPRESS = 1;
    static final int BYTE_TYPE_COMPRESS_ENCRYPT = 3;
    static final int BYTE_TYPE_DEFAULT = 0;
    static final int BYTE_TYPE_ENCRYPT = 2;

    public static JSONObject getMessage(byte[] bArr, boolean z) throws DataFormatException, IOException {
        String str;
        byte[] bArr2 = new byte[ArtifactRepository.IO_CHUNK_SIZE];
        char c = (char) bArr[0];
        if (c == 'a') {
            if (Logger.debug()) {
                Logger.m268d("PushService getMessage", "uncopress message");
            }
            str = new String(bArr, 1, bArr.length - 1);
        } else if (c == 'c') {
            Inflater inflater = new Inflater();
            if (z) {
                inflater.setInput(Base64.decode(bArr, 1, bArr.length - 1, 0));
            } else {
                inflater.setInput(bArr, 1, bArr.length - 1);
            }
            if (Logger.debug()) {
                Logger.m268d("PushService getMessage", "copress message");
            }
            synchronized (bArr2) {
                int inflate = inflater.inflate(bArr2);
                inflater.end();
                str = (inflate <= 0 || inflate >= 65536) ? null : new String(bArr2, 0, inflate, "UTF-8");
            }
        } else {
            if (Logger.debug()) {
                Logger.m268d("PushService", "onMessage : ".concat(new String(bArr, 0, bArr.length)));
            }
            str = null;
        }
        if (str == null) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (JSONException e) {
            e.printStackTrace();
            if (!Logger.debug()) {
                return null;
            }
            Logger.m268d("PushService", "onMessage : ".concat(new String(bArr, 0, bArr.length)));
            return null;
        }
    }

    public static String getMessageV2(int i, byte[] bArr, boolean z) throws DataFormatException, IOException {
        String str;
        byte b = bArr[0];
        char c = (char) b;
        byte[] bytes = new String(bArr, 1, bArr.length - 1).getBytes();
        if (c == 'a') {
            return new String(bytes, 0, bytes.length);
        }
        if (b == 0) {
            if (Logger.debug()) {
                Logger.m268d("PushService getMessage", "uncopress message");
            }
            str = new String(bytes, 0, bytes.length);
        } else if (b == 2 || b == 3) {
            if (Logger.debug()) {
                Logger.m268d("PushService getMessageV2", "encrypt message");
            }
            bytes = EncryptUtils.decrypt(bytes);
            PushSupporter.monitor().monitorDecryptResult(i, bytes == null ? 1 : 0);
            if (bytes == null) {
                return null;
            }
            str = new String(bytes, 0, bytes.length);
            if (b == 3) {
                bytes = str.getBytes();
            }
        } else {
            str = null;
        }
        if (b == 1 || b == 3) {
            Inflater inflater = new Inflater();
            if (z) {
                inflater.setInput(Base64.decode(bytes, 0, bytes.length, 0));
            } else {
                inflater.setInput(bytes, 0, bytes.length);
            }
            if (Logger.debug()) {
                Logger.m268d("PushService getMessage", "copress message");
            }
            byte[] bArr2 = new byte[ArtifactRepository.IO_CHUNK_SIZE];
            synchronized (bArr2) {
                int inflate = inflater.inflate(bArr2);
                inflater.end();
                if (inflate > 0 && inflate < 65536) {
                    str = new String(bArr2, 0, inflate, "UTF-8");
                }
            }
        } else if (Logger.debug()) {
            Logger.m268d("PushService", "onMessage : ".concat(new String(bArr, 0, bArr.length)));
        }
        return str;
    }

    public static void deletePreObserverFile(Context context) throws IOException {
        if (context == null) {
            return;
        }
        deleteFiles(context, new String[]{"lockFile", "lockFile1", "lockFile2"});
        deleteFiles(context, new String[]{"observerFile", "observerFile1", "observerFile2"});
    }

    public static void deleteFiles(Context context, String[] strArr) {
        if (context == null || strArr == null) {
            return;
        }
        try {
            String path = getPath(context);
            if (path == null) {
                return;
            }
            for (String str : strArr) {
                File file = new File(path + "/files/" + str);
                if (file.exists()) {
                    file.delete();
                }
            }
        } catch (Exception unused) {
        }
    }

    public static String getPath(Context context) {
        File filesDir;
        File parentFile;
        if (context == null || (filesDir = context.getFilesDir()) == null || !filesDir.exists() || (parentFile = filesDir.getParentFile()) == null || !parentFile.exists()) {
            return null;
        }
        return parentFile.getAbsolutePath();
    }
}
