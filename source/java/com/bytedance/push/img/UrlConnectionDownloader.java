package com.bytedance.push.img;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.bytedance.common.utility.io.IOUtils;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* loaded from: classes4.dex */
public class UrlConnectionDownloader implements ImageDownloader {
    private static final int DEFAULT_CONNECT_TIMEOUT = 15000;
    private static final int DEFAULT_READ_TIMEOUT = 20000;
    private static final int MARKER = 65536;

    @Override // com.bytedance.push.img.ImageDownloader
    public Bitmap downloadImage(Request request) {
        try {
            return huntImage(request);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private Bitmap huntImage(Request request) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(request.uri.toString()).openConnection();
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
            return null;
        }
        try {
            if (httpURLConnection.getHeaderFieldInt("Content-Length", -1) == 0) {
                IOUtils.close(inputStream);
                throw new IOException("Received response with 0 content-length header.");
            }
            return decodeStream(inputStream, request);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            IOUtils.close(inputStream);
        }
    }

    private Bitmap decodeStream(InputStream inputStream, Request request) throws IOException {
        MarkableInputStream markableInputStream = new MarkableInputStream(inputStream);
        long savePosition = markableInputStream.savePosition(65536);
        BitmapFactory.Options createBitmapOptions = createBitmapOptions(request);
        boolean requiresInSampleSize = requiresInSampleSize(createBitmapOptions);
        boolean isWebPFile = Utils.isWebPFile(markableInputStream);
        markableInputStream.reset(savePosition);
        if (isWebPFile) {
            byte[] byteArray = Utils.toByteArray(markableInputStream);
            if (requiresInSampleSize) {
                BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length, createBitmapOptions);
                calculateInSampleSize(request.targetWidth, request.targetHeight, createBitmapOptions);
            }
            return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length, createBitmapOptions);
        }
        if (requiresInSampleSize) {
            BitmapFactory.decodeStream(markableInputStream, null, createBitmapOptions);
            calculateInSampleSize(request.targetWidth, request.targetHeight, createBitmapOptions);
            markableInputStream.reset(savePosition);
        }
        Bitmap decodeStream = BitmapFactory.decodeStream(markableInputStream, null, createBitmapOptions);
        if (decodeStream != null) {
            return decodeStream;
        }
        throw new IOException("Failed to decode stream.");
    }

    private static void calculateInSampleSize(int i, int i2, BitmapFactory.Options options) {
        calculateInSampleSize(i, i2, options.outWidth, options.outHeight, options);
    }

    private static void calculateInSampleSize(int i, int i2, int i3, int i4, BitmapFactory.Options options) {
        int floor;
        if (i4 > i2 || i3 > i) {
            int floor2 = (int) Math.floor(i4 / i2);
            floor = (int) Math.floor(i3 / i);
            if (floor2 < floor) {
                floor = floor2;
            }
        } else {
            floor = 1;
        }
        options.inSampleSize = floor;
        options.inJustDecodeBounds = false;
    }

    private static BitmapFactory.Options createBitmapOptions(Request request) {
        boolean hasSize = request.hasSize();
        boolean z = request.config != null;
        if (!hasSize && !z) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = hasSize;
        if (z) {
            options.inPreferredConfig = request.config;
        }
        return options;
    }

    private static boolean requiresInSampleSize(BitmapFactory.Options options) {
        return options != null && options.inJustDecodeBounds;
    }
}
