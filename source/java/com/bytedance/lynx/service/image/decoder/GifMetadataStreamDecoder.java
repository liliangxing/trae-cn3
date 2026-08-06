package com.bytedance.lynx.service.image.decoder;

import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.UByte;

/* loaded from: classes4.dex */
class GifMetadataStreamDecoder implements GifMetadataDecoder {
    private static final int CONTROL_INDEX_DELAY = 1;
    private static final int CONTROL_INDEX_DISPOSE = 0;
    private static final int MAX_BLOCK_SIZE = 256;
    private static final String NETSCAPE = "NETSCAPE2.0";
    private final InputStream mInputStream;
    private final byte[] block = new byte[256];
    private final List<int[]> mFrameControls = new ArrayList();
    private int mLoopCount = 0;
    private boolean mDecoded = false;

    public GifMetadataStreamDecoder(InputStream inputStream) {
        this.mInputStream = inputStream;
    }

    @Override // com.bytedance.lynx.service.image.decoder.GifMetadataDecoder
    public void decode() throws IOException {
        if (this.mDecoded) {
            throw new IllegalStateException("decode called multiple times");
        }
        this.mDecoded = true;
        readGifInfo();
    }

    @Override // com.bytedance.lynx.service.image.decoder.GifMetadataDecoder
    public int getFrameCount() {
        if (!this.mDecoded) {
            throw new IllegalStateException("getFrameCount called before decode");
        }
        return this.mFrameControls.size();
    }

    @Override // com.bytedance.lynx.service.image.decoder.GifMetadataDecoder
    public int getLoopCount() {
        if (!this.mDecoded) {
            throw new IllegalStateException("getLoopCount called before decode");
        }
        return this.mLoopCount;
    }

    @Override // com.bytedance.lynx.service.image.decoder.GifMetadataDecoder
    public AnimatedDrawableFrameInfo.DisposalMethod getFrameDisposal(int i) {
        if (!this.mDecoded) {
            throw new IllegalStateException("getFrameDisposal called before decode");
        }
        int i2 = this.mFrameControls.get(i)[0];
        if (i2 == 2) {
            return AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND;
        }
        if (i2 == 3) {
            return AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_PREVIOUS;
        }
        return AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_DO_NOT;
    }

    @Override // com.bytedance.lynx.service.image.decoder.GifMetadataDecoder
    public int getFrameDurationMs(int i) {
        if (!this.mDecoded) {
            throw new IllegalStateException("getFrameDurationMS called before decode");
        }
        return this.mFrameControls.get(i)[1];
    }

    private void readGifInfo() throws IOException {
        validateAndIgnoreHeader();
        int[] iArr = {0, 0};
        boolean z = false;
        while (!z) {
            int readNextByte = readNextByte();
            if (readNextByte == 33) {
                int readNextByte2 = readNextByte();
                if (readNextByte2 == 1) {
                    addFrame(iArr);
                    skipExtension();
                } else if (readNextByte2 == 249) {
                    readGraphicsControlExtension(iArr);
                } else if (readNextByte2 == 255) {
                    readBlock();
                    if (isNetscape()) {
                        readNetscapeExtension();
                    } else {
                        skipExtension();
                    }
                } else {
                    skipExtension();
                }
            } else if (readNextByte == 44) {
                addFrame(iArr);
                skipImage();
            } else {
                if (readNextByte != 59) {
                    throw new IOException("Unknown block header [" + Integer.toHexString(readNextByte) + "]");
                }
                z = true;
            }
        }
    }

    private void addFrame(int[] iArr) {
        this.mFrameControls.add(Arrays.copyOf(iArr, iArr.length));
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void validateAndIgnoreHeader() throws IOException {
        boolean z;
        readIntoBlock(0, 6);
        byte[] bArr = this.block;
        if ('G' == ((char) bArr[0]) && 'I' == ((char) bArr[1]) && 'F' == ((char) bArr[2]) && '8' == ((char) bArr[3])) {
            byte b = bArr[4];
            if (('7' == ((char) b) || '9' == ((char) b)) && 'a' == ((char) bArr[5])) {
                z = true;
                if (z) {
                    throw new IOException("Illegal header for gif");
                }
                readTwoByteInt();
                readTwoByteInt();
                int readNextByte = readNextByte();
                boolean z2 = (readNextByte & 128) != 0;
                int i = 2 << (readNextByte & 7);
                readNextByte();
                readNextByte();
                if (z2) {
                    ignoreColorTable(i);
                    return;
                }
                return;
            }
        }
        z = false;
        if (z) {
        }
    }

    private void ignoreColorTable(int i) throws IOException {
        int i2 = i * 3;
        for (int i3 = 0; i3 < i2; i3++) {
            readNextByte();
        }
    }

    private int readBlock() throws IOException {
        int readNextByte = readNextByte();
        int i = 0;
        if (readNextByte > 0) {
            while (i < readNextByte) {
                i += readIntoBlock(i, readNextByte - i);
            }
        }
        return i;
    }

    private void skipExtension() throws IOException {
        do {
        } while (readBlock() > 0);
    }

    private void skipImage() throws IOException {
        readTwoByteInt();
        readTwoByteInt();
        readTwoByteInt();
        readTwoByteInt();
        int readNextByte = readNextByte();
        if ((readNextByte & 128) != 0) {
            ignoreColorTable(2 << (readNextByte & 7));
        }
        readNextByte();
        skipExtension();
    }

    private boolean isNetscape() {
        if (this.block.length > 11) {
            return false;
        }
        for (int i = 0; i < 11; i++) {
            if (NETSCAPE.charAt(i) != ((char) this.block[i])) {
                return false;
            }
        }
        return true;
    }

    private void readNetscapeExtension() throws IOException {
        int readBlock;
        do {
            readBlock = readBlock();
            byte[] bArr = this.block;
            if (bArr[0] == 1) {
                this.mLoopCount = (bArr[1] & UByte.MAX_VALUE) | ((bArr[2] & UByte.MAX_VALUE) << 8);
            }
        } while (readBlock > 0);
    }

    private void readGraphicsControlExtension(int[] iArr) throws IOException {
        readNextByte();
        iArr[0] = (readNextByte() & 28) >> 2;
        iArr[1] = readTwoByteInt() * 10;
        readNextByte();
        readNextByte();
    }

    private int readNextByte() throws IOException {
        int read = this.mInputStream.read();
        if (read != -1) {
            return read;
        }
        throw new EOFException("Unexpected end of gif file");
    }

    private int readTwoByteInt() throws IOException {
        return readNextByte() | (readNextByte() << 8);
    }

    private int readIntoBlock(int i, int i2) throws IOException {
        int read = this.mInputStream.read(this.block, i, i2);
        if (read != -1) {
            return read;
        }
        throw new EOFException("Unexpected end of gif file");
    }
}
