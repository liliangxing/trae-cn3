package com.bytedance.push.sound;

import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.io.IOUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* loaded from: classes4.dex */
public class UrlConnectionSoundDownloader implements SoundDownloader {
    private static final int DEFAULT_CONNECT_TIMEOUT = 15000;
    private static final int DEFAULT_READ_TIMEOUT = 20000;
    private final String TAG = "UrlConnectionDownloader";

    @Override // com.bytedance.push.sound.SoundDownloader
    public boolean downLoadSound(String str, String str2) {
        Logger.i("UrlConnectionDownloader", "download url:" + str + " targetPath:" + str2);
        try {
            return downloadInternal(str, str2);
        } catch (Throwable unused) {
            return false;
        }
    }

    private boolean downloadInternal(String str, String str2) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setConnectTimeout(15000);
        httpURLConnection.setReadTimeout(20000);
        httpURLConnection.setUseCaches(true);
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode >= 300) {
            httpURLConnection.disconnect();
            throw new IOException(responseCode + " " + httpURLConnection.getResponseMessage());
        }
        InputStream inputStream = httpURLConnection.getInputStream();
        if (inputStream == null) {
            return false;
        }
        if (httpURLConnection.getHeaderFieldInt("Content-Length", -1) == 0) {
            IOUtils.close(inputStream);
            throw new IOException("Received response with 0 content-length header.");
        }
        FileOutputStream fileOutputStream = null;
        try {
            File file = new File(str2);
            if (file.exists() || file.createNewFile()) {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    byte[] bArr = new byte[2048];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read != -1) {
                            fileOutputStream2.write(bArr, 0, read);
                        } else {
                            fileOutputStream2.flush();
                            fileOutputStream2.close();
                            Logger.i("UrlConnectionDownloader", "download success");
                            IOUtils.close(inputStream);
                            IOUtils.close(fileOutputStream2);
                            return true;
                        }
                    }
                } catch (Throwable unused) {
                    fileOutputStream = fileOutputStream2;
                    IOUtils.close(inputStream);
                    if (fileOutputStream != null) {
                        IOUtils.close(fileOutputStream);
                    }
                    return false;
                }
            } else {
                IOUtils.close(inputStream);
                return false;
            }
        } catch (Throwable unused2) {
        }
    }
}
