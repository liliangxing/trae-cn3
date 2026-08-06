package com.ss.bytertc.engine;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import android.webkit.URLUtil;
import com.bytedance.realx.base.ContextUtils;
import com.bytedance.realx.base.RXLogging;
import com.ss.android.socialbase.downloader.file.DownloadFileUtils;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.ByteBuffer;
import java.util.Vector;

/* loaded from: classes7.dex */
class RtcAudioFileDecoder {
    private static final int MAX_DECODER_RETRY_COUNT = 100;
    private static final String TAG = "RtcAudioFileDecoder";
    private boolean eoInputStream;
    private boolean eoOutputStream;
    private byte[] mDecodedData;
    private MediaExtractor mExtractor;
    private long mFileLength;
    private ByteBuffer[] mInputBuffers;
    private MediaCodec mMediaCodec;
    private ByteBuffer[] mOutputBuffers;
    private int mRetryCount;
    private Vector<Integer> mTrackIds;
    private MediaFormat mUsedTrackFormat;
    private int mUsedTrackIdx;
    private HttpURLConnection oc;
    private int mSampleRate = 0;
    private int mChannels = 0;

    RtcAudioFileDecoder() {
        RXLogging.e(TAG, "AudioMix RtcAudioFileDecoder");
    }

    boolean init(String fileName, int useTrack) {
        try {
            RXLogging.i(TAG, "Try to decode audio file : " + fileName);
            this.mTrackIds = new Vector<>();
            if (URLUtil.isNetworkUrl(fileName)) {
                if (!checkUrlEncoded(fileName)) {
                    fileName = encodeUrl(fileName);
                }
                if (fileName == null || !isAvailableOnlineURL(fileName)) {
                    return false;
                }
            }
            this.mRetryCount = 0;
            this.mExtractor = new MediaExtractor();
            Context applicationContext = ContextUtils.getApplicationContext();
            if (fileName.startsWith("/assets/") && applicationContext != null) {
                AssetFileDescriptor openFd = applicationContext.getAssets().openFd(fileName.substring(8));
                this.mExtractor.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
            } else if (fileName.startsWith("content://") && applicationContext != null) {
                this.mExtractor.setDataSource(applicationContext.getContentResolver().openFileDescriptor(Uri.parse(fileName), DownloadFileUtils.MODE_READ).getFileDescriptor());
            } else {
                this.mExtractor.setDataSource(fileName);
            }
            int trackCount = this.mExtractor.getTrackCount();
            for (int i = 0; i < trackCount; i++) {
                this.mExtractor.unselectTrack(i);
            }
            if (useTrack + 1 > trackCount) {
                RXLogging.e(TAG, "useTrack > trackCount");
                return false;
            }
            this.mChannels = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < trackCount; i3++) {
                MediaFormat trackFormat = this.mExtractor.getTrackFormat(i3);
                String string = trackFormat.getString("mime");
                if (string.contains("audio/")) {
                    if (useTrack == i2) {
                        this.mExtractor.selectTrack(i3);
                        MediaCodec createDecoderByType = MediaCodec.createDecoderByType(string);
                        this.mMediaCodec = createDecoderByType;
                        createDecoderByType.configure(trackFormat, (Surface) null, (MediaCrypto) null, 0);
                        this.mUsedTrackFormat = trackFormat;
                        this.mUsedTrackIdx = i2;
                    }
                    i2++;
                    this.mTrackIds.addElement(new Integer(i3));
                    int integer = trackFormat.getInteger(com.ss.ttm.player.MediaFormat.KEY_CHANNEL_COUNT);
                    if (integer > this.mChannels) {
                        this.mChannels = integer;
                    }
                }
            }
            MediaCodec mediaCodec = this.mMediaCodec;
            if (mediaCodec != null) {
                mediaCodec.start();
                this.mSampleRate = this.mUsedTrackFormat.getInteger(com.ss.ttm.player.MediaFormat.KEY_SAMPLE_RATE);
                this.mFileLength = this.mUsedTrackFormat.getLong("durationUs");
                return true;
            }
            RXLogging.e(TAG, "mMediaCodec is null");
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            RXLogging.e(TAG, "Error when creating audio file decode, error:" + e.getMessage());
            RXLogging.e(TAG, "stack track: " + Log.getStackTraceString(e));
            return false;
        }
    }

    public int getChannelCount() {
        return this.mChannels;
    }

    public int getSampleRate() {
        return this.mSampleRate;
    }

    public long getFileLength() {
        return this.mFileLength / 1000;
    }

    public long getCurrentFilePosition() {
        try {
            return this.mExtractor.getSampleTime() / 1000;
        } catch (Exception e) {
            e.printStackTrace();
            RXLogging.e(TAG, "Error when getCurrentFilePosition");
            return 0L;
        }
    }

    public int getUsedTrackIdx() {
        return this.mUsedTrackIdx;
    }

    public int getAudioTrackCount() {
        Vector<Integer> vector = this.mTrackIds;
        if (vector == null) {
            return 0;
        }
        return vector.size();
    }

    public void disConnectURL() {
        RXLogging.e(TAG, "disConnectURL");
        HttpURLConnection httpURLConnection = this.oc;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    public boolean selectTrack(int trackIdx) {
        try {
            Vector<Integer> vector = this.mTrackIds;
            if (vector == null || trackIdx + 1 > vector.size() || this.mUsedTrackIdx == trackIdx) {
                return false;
            }
            MediaExtractor mediaExtractor = this.mExtractor;
            if (mediaExtractor != null && this.mMediaCodec != null) {
                MediaFormat trackFormat = mediaExtractor.getTrackFormat(this.mTrackIds.get(trackIdx).intValue());
                if (this.mSampleRate != trackFormat.getInteger(com.ss.ttm.player.MediaFormat.KEY_SAMPLE_RATE)) {
                    RXLogging.e(TAG, "mSampleRate = " + this.mSampleRate + ", used_SampleRate = " + trackFormat.getInteger(com.ss.ttm.player.MediaFormat.KEY_SAMPLE_RATE));
                    return false;
                }
                long sampleTime = this.mExtractor.getSampleTime();
                RXLogging.e(TAG, "++current_postion = " + sampleTime);
                this.mExtractor.unselectTrack(this.mTrackIds.get(this.mUsedTrackIdx).intValue());
                this.mMediaCodec.stop();
                trackFormat.getString("mime");
                this.mExtractor.selectTrack(this.mTrackIds.get(trackIdx).intValue());
                this.mExtractor.seekTo(sampleTime, 2);
                this.mMediaCodec.configure(trackFormat, (Surface) null, (MediaCrypto) null, 0);
                this.mMediaCodec.start();
                this.mUsedTrackFormat = trackFormat;
                this.mUsedTrackIdx = trackIdx;
                return true;
            }
            RXLogging.e(TAG, "mExtractor or mMediaCodec is null, mExtractor = " + this.mExtractor + ", mMediaCodec = " + this.mMediaCodec);
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            RXLogging.e(TAG, "Error when selectTrack");
            return false;
        }
    }

    public void setCurrentFilePosition(long position) {
        if (this.eoOutputStream) {
            try {
                this.mMediaCodec.flush();
            } catch (Exception e) {
                e.printStackTrace();
                RXLogging.e(TAG, "Error when setCurrentFilePosition, mMediaCodec.flush");
            }
        }
        try {
            this.mExtractor.seekTo(position * 1000, 2);
            this.eoInputStream = false;
            this.eoOutputStream = false;
        } catch (Exception e2) {
            e2.printStackTrace();
            RXLogging.e(TAG, "Error when setCurrentFilePosition, mExtractor.seekTo");
        }
    }

    public boolean readAudioData() {
        MediaCodec mediaCodec;
        int dequeueInputBuffer;
        int i;
        try {
            mediaCodec = this.mMediaCodec;
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (mediaCodec != null && this.mExtractor != null) {
            if (!this.eoInputStream && (dequeueInputBuffer = mediaCodec.dequeueInputBuffer(0L)) >= 0) {
                ByteBuffer inputBuffer = this.mMediaCodec.getInputBuffer(dequeueInputBuffer);
                int readSampleData = inputBuffer != null ? this.mExtractor.readSampleData(inputBuffer, 0) : 0;
                if (readSampleData <= 0) {
                    this.eoInputStream = true;
                    i = 0;
                } else {
                    i = readSampleData;
                }
                long sampleTime = this.mExtractor.getSampleTime();
                int sampleFlags = this.mExtractor.getSampleFlags();
                if (this.eoInputStream) {
                    sampleFlags |= 4;
                }
                this.mMediaCodec.queueInputBuffer(dequeueInputBuffer, 0, i, sampleTime, sampleFlags);
                this.mExtractor.advance();
            }
            if (!this.eoOutputStream) {
                MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                int dequeueOutputBuffer = this.mMediaCodec.dequeueOutputBuffer(bufferInfo, 0L);
                this.mDecodedData = null;
                if (dequeueOutputBuffer == -3 || dequeueOutputBuffer == -2) {
                    this.mDecodedData = new byte[0];
                } else if (dequeueOutputBuffer == -1) {
                    int i2 = this.mRetryCount + 1;
                    this.mRetryCount = i2;
                    if (i2 >= 100 && (Build.BRAND.toLowerCase().contains("meizu") || Build.MANUFACTURER.toLowerCase().contains("meizu") || Build.BRAND.toLowerCase().contains("vivo") || Build.MANUFACTURER.toLowerCase().contains("vivo"))) {
                        RXLogging.e(TAG, "EAGAIN count=" + this.mRetryCount + " presentationTimeUs=" + bufferInfo.presentationTimeUs + " totalUs=" + this.mFileLength + " Force EOS");
                        this.eoOutputStream = true;
                        this.mRetryCount = 0;
                    }
                    this.mDecodedData = new byte[0];
                    Thread.sleep(3L);
                } else {
                    this.mRetryCount = 0;
                    if (dequeueOutputBuffer >= 0) {
                        if ((bufferInfo.flags & 4) == 4) {
                            this.eoOutputStream = true;
                        }
                        ByteBuffer outputBuffer = this.mMediaCodec.getOutputBuffer(dequeueOutputBuffer);
                        int integer = this.mUsedTrackFormat.getInteger(com.ss.ttm.player.MediaFormat.KEY_CHANNEL_COUNT);
                        int i3 = this.mChannels;
                        if (integer != i3 && i3 == 2) {
                            this.mDecodedData = new byte[outputBuffer.limit() * 2];
                            for (int i4 = 0; i4 < bufferInfo.size / 2; i4++) {
                                int i5 = i4 * 4;
                                this.mDecodedData[i5] = outputBuffer.get();
                                byte[] bArr = this.mDecodedData;
                                bArr[i5 + 2] = bArr[i5];
                                int i6 = i5 + 1;
                                bArr[i6] = outputBuffer.get();
                                byte[] bArr2 = this.mDecodedData;
                                bArr2[i5 + 3] = bArr2[i6];
                            }
                            outputBuffer.clear();
                        } else if (integer == i3) {
                            byte[] bArr3 = new byte[outputBuffer.limit()];
                            this.mDecodedData = bArr3;
                            outputBuffer.get(bArr3, bufferInfo.offset, bufferInfo.size);
                            outputBuffer.clear();
                        }
                        this.mMediaCodec.releaseOutputBuffer(dequeueOutputBuffer, false);
                    }
                }
            }
            return this.eoOutputStream;
        }
        return this.eoInputStream;
    }

    public void uninit() {
        try {
            MediaCodec mediaCodec = this.mMediaCodec;
            if (mediaCodec != null) {
                mediaCodec.stop();
                this.mMediaCodec.release();
                this.mMediaCodec = null;
            }
            MediaExtractor mediaExtractor = this.mExtractor;
            if (mediaExtractor != null) {
                mediaExtractor.release();
                this.mExtractor = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            RXLogging.e(TAG, "Error when releasing audio file stream" + e.getMessage());
        }
        this.eoOutputStream = false;
        this.eoInputStream = false;
    }

    public byte[] getDecodedData() {
        return this.mDecodedData;
    }

    private boolean checkInfoChange() {
        boolean z;
        try {
            MediaFormat outputFormat = this.mMediaCodec.getOutputFormat();
            int integer = outputFormat.getInteger(com.ss.ttm.player.MediaFormat.KEY_SAMPLE_RATE);
            int integer2 = outputFormat.getInteger(com.ss.ttm.player.MediaFormat.KEY_CHANNEL_COUNT);
            if (this.mSampleRate == integer && this.mChannels == integer2) {
                z = false;
                this.mSampleRate = integer;
                this.mChannels = integer2;
                return z;
            }
            z = true;
            this.mSampleRate = integer;
            this.mChannels = integer2;
            return z;
        } catch (Exception e) {
            e.printStackTrace();
            RXLogging.e(TAG, "Error when checking file's new format");
            return false;
        }
    }

    private boolean isAvailableOnlineURL(String path) {
        boolean z;
        RXLogging.e(TAG, "isAvailableOnlineURL");
        this.oc = null;
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(path).openConnection();
                this.oc = httpURLConnection;
                httpURLConnection.setUseCaches(false);
                this.oc.setConnectTimeout(4000);
                RXLogging.e(TAG, "connect done....");
                int responseCode = this.oc.getResponseCode();
                if (200 == responseCode) {
                    z = true;
                } else {
                    RXLogging.e(TAG, "url is not available, error:" + responseCode);
                    z = false;
                }
                InputStream inputStream = this.oc.getInputStream();
                if (inputStream != null) {
                    inputStream.close();
                }
                HttpURLConnection httpURLConnection2 = this.oc;
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                return z;
            } catch (Exception e) {
                e.printStackTrace();
                RXLogging.e(TAG, "++Error when test online url: " + e.getMessage());
                HttpURLConnection httpURLConnection3 = this.oc;
                if (httpURLConnection3 == null) {
                    return false;
                }
                httpURLConnection3.disconnect();
                return false;
            }
        } catch (Throwable th) {
            HttpURLConnection httpURLConnection4 = this.oc;
            if (httpURLConnection4 != null) {
                httpURLConnection4.disconnect();
            }
            throw th;
        }
    }

    private boolean checkUrlEncoded(String path) {
        try {
            return !TextUtils.equals(path, URLDecoder.decode(path, "UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
            RXLogging.e(TAG, "Error when releasing audio file stream");
            return false;
        }
    }

    private String encodeUrl(String path) {
        RXLogging.e(TAG, "encodedUrl");
        try {
            URL url = new URL(path);
            return new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), url.getQuery(), url.getRef()).toASCIIString();
        } catch (Exception e) {
            e.printStackTrace();
            return path;
        }
    }
}
