package com.ss.android.socialbase.appdownloader.util.parser.manifest;

import java.io.EOFException;
import java.io.IOException;
import java.math.BigInteger;
import java.util.logging.Logger;

/* loaded from: classes7.dex */
public class ARSCHeader {
    private static final Logger LOGGER = Logger.getLogger(ARSCHeader.class.getName());
    public static final short RES_NONE_TYPE = -1;
    public static final short RES_NULL_TYPE = 0;
    public static final short RES_STRING_POOL_TYPE = 1;
    public static final short RES_TABLE_TYPE = 2;
    public static final short RES_XML_CDATA_TYPE = 260;
    public static final short RES_XML_END_ELEMENT_TYPE = 259;
    public static final short RES_XML_END_NAMESPACE_TYPE = 257;
    public static final short RES_XML_FIRST_CHUNK_TYPE = 256;
    public static final short RES_XML_LAST_CHUNK_TYPE = 383;
    public static final short RES_XML_RESOURCE_MAP_TYPE = 384;
    public static final short RES_XML_START_ELEMENT_TYPE = 258;
    public static final short RES_XML_START_NAMESPACE_TYPE = 256;
    public static final short RES_XML_TYPE = 3;
    public static final short XML_TYPE_LIBRARY = 515;
    public static final short XML_TYPE_OVERLAY = 516;
    public static final short XML_TYPE_OVERLAY_POLICY = 517;
    public static final short XML_TYPE_PACKAGE = 512;
    public static final short XML_TYPE_SPEC_TYPE = 514;
    public static final short XML_TYPE_STAGED_ALIAS = 518;
    public static final short XML_TYPE_TYPE = 513;
    public final int chunkSize;
    public final int endPosition;
    public final int headerSize;
    public final int startPosition;
    public final short type;

    public ARSCHeader(short s, int i, int i2, int i3) {
        this.type = s;
        this.headerSize = i;
        this.chunkSize = i2;
        this.startPosition = i3;
        this.endPosition = i3 + i2;
    }

    public static ARSCHeader read(ExtCountingDataInput extCountingDataInput) throws IOException {
        int position = extCountingDataInput.position();
        try {
            return new ARSCHeader(extCountingDataInput.readShort(), extCountingDataInput.readShort(), extCountingDataInput.readInt(), position);
        } catch (EOFException unused) {
            return new ARSCHeader((short) -1, 0, 0, extCountingDataInput.position());
        }
    }

    public void checkForUnreadHeader(ExtCountingDataInput extCountingDataInput) throws IOException {
        int position = extCountingDataInput.position() - this.startPosition;
        int i = this.headerSize - position;
        if (i > 0) {
            byte[] bArr = new byte[i];
            extCountingDataInput.readFully(bArr);
            BigInteger bigInteger = new BigInteger(1, bArr);
            if (bigInteger.equals(BigInteger.ZERO)) {
                LOGGER.fine(String.format("Chunk header size (%d), read (%d), but exceeding bytes are all zero.", Integer.valueOf(this.headerSize), Integer.valueOf(position)));
            } else {
                LOGGER.warning(String.format("Chunk header size (%d), read (%d). Exceeding bytes: 0x%X.", Integer.valueOf(this.headerSize), Integer.valueOf(position), bigInteger));
            }
        }
    }

    public void skipChunk(ExtDataInput extDataInput) throws IOException {
        extDataInput.skipBytes(this.chunkSize - this.headerSize);
    }
}
