package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.Closeables;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Throwables;
import com.facebook.common.memory.ByteArrayPool;
import com.facebook.common.memory.PooledByteArrayBufferedInputStream;
import com.facebook.common.util.StreamUtil;
import com.facebook.imagepipeline.image.EncodedImage;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class ProgressiveAwebpParser {
    private static final int BUFFER_SIZE = 16384;
    private static final int NOT_AWEBP = -1;
    private static final int READ_ANIM_I_BYTE = 3;
    private static final int READ_ANIM_M_BYTE = 4;
    private static final int READ_ANMF_F_BYTE = 6;
    private static final int READ_ANMF_M_BYTE = 5;
    private static final int READ_A_BYTE = 1;
    private static final int READ_FIRST_WEBP_BYTE = 0;
    private static final int READ_N_BYTE = 2;
    private int mBestScanEndOffset;
    private final ByteArrayPool mByteArrayPool;
    private int mBytesParsed;
    private boolean mEndMarkerRead;
    private int mParserState = 0;
    private int mBestScanNumber = -1;

    public ProgressiveAwebpParser(ByteArrayPool byteArrayPool) {
        this.mByteArrayPool = (ByteArrayPool) Preconditions.checkNotNull(byteArrayPool);
    }

    public boolean parseMoreData(EncodedImage encodedImage) {
        if (this.mParserState == -1 || encodedImage.getSize() <= this.mBytesParsed) {
            return false;
        }
        PooledByteArrayBufferedInputStream pooledByteArrayBufferedInputStream = new PooledByteArrayBufferedInputStream(encodedImage.getInputStream(), this.mByteArrayPool.get(16384), this.mByteArrayPool);
        try {
            StreamUtil.skip(pooledByteArrayBufferedInputStream, this.mBytesParsed);
            return doParseMoreData(pooledByteArrayBufferedInputStream);
        } catch (IOException e) {
            Throwables.propagate(e);
            return false;
        } finally {
            Closeables.closeQuietly(pooledByteArrayBufferedInputStream);
        }
    }

    private boolean doParseMoreData(InputStream inputStream) {
        int i;
        int read;
        int i2 = this.mBestScanNumber;
        while (this.mParserState != -1 && (read = inputStream.read()) != -1) {
            try {
                int i3 = this.mBytesParsed + 1;
                this.mBytesParsed = i3;
                if (!this.mEndMarkerRead) {
                    switch (this.mParserState) {
                        case 0:
                        case 4:
                        case 6:
                            if (i3 == 13 && read != 86) {
                                this.mParserState = -1;
                                break;
                            } else if (i3 == 14 && read != 80) {
                                this.mParserState = -1;
                                break;
                            } else if (i3 == 15 && read != 56) {
                                this.mParserState = -1;
                                break;
                            } else if (i3 == 16 && read != 88) {
                                this.mParserState = -1;
                                break;
                            } else if (i3 == 21 && (read & 2) != 2) {
                                this.mParserState = -1;
                                break;
                            } else if (read != 65) {
                                break;
                            } else {
                                this.mParserState = 1;
                                break;
                            }
                        case 1:
                            if (read == 78) {
                                this.mParserState = 2;
                                break;
                            } else {
                                this.mParserState = 0;
                                break;
                            }
                        case 2:
                            if (read != 73) {
                                if (read == 77) {
                                    this.mParserState = 5;
                                    break;
                                } else {
                                    this.mParserState = 0;
                                    break;
                                }
                            } else {
                                this.mParserState = 3;
                                break;
                            }
                        case 3:
                            if (read == 77) {
                                this.mParserState = 4;
                                break;
                            } else {
                                this.mParserState = 0;
                                break;
                            }
                        case 5:
                            if (read == 70) {
                                this.mParserState = 6;
                                this.mBestScanEndOffset = i3;
                                this.mBestScanNumber++;
                                break;
                            } else {
                                this.mParserState = 0;
                                break;
                            }
                    }
                } else {
                    this.mParserState = -1;
                    this.mEndMarkerRead = false;
                    return false;
                }
            } catch (IOException e) {
                Throwables.propagate(e);
            }
        }
        return (this.mParserState == -1 || (i = this.mBestScanNumber) == i2 || i <= 0) ? false : true;
    }

    public int getBestScanNumber() {
        return this.mBestScanNumber;
    }

    public int getBestScanEndOffset() {
        return this.mBestScanEndOffset;
    }
}
