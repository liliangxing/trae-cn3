package com.bytedance.memory.shrink;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import kotlin.UByte;

/* loaded from: classes4.dex */
public final class MemoryIOUtil {
    public static final String UTF_8 = "UTF-8";

    public static int readLEInt(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        int read2 = inputStream.read();
        int read3 = inputStream.read();
        int read4 = inputStream.read();
        if ((read | read2 | read3 | read4) >= 0) {
            return (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
        }
        throw new EOFException();
    }

    public static short readLEShort(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        int read2 = inputStream.read();
        if ((read | read2) >= 0) {
            return (short) ((read2 << 8) | read);
        }
        throw new EOFException();
    }

    public static long readLELong(InputStream inputStream) throws IOException {
        readFully(inputStream, new byte[8], 0, 8L);
        return (r1[7] << 56) + ((r1[6] & UByte.MAX_VALUE) << 48) + ((r1[5] & UByte.MAX_VALUE) << 40) + ((r1[4] & UByte.MAX_VALUE) << 32) + ((r1[3] & UByte.MAX_VALUE) << 24) + ((r1[2] & UByte.MAX_VALUE) << 16) + ((r1[1] & UByte.MAX_VALUE) << 8) + (r1[0] & UByte.MAX_VALUE);
    }

    public static short readBEShort(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        int read2 = inputStream.read();
        if ((read | read2) >= 0) {
            return (short) (read2 | (read << 8));
        }
        throw new EOFException();
    }

    public static long readBELong(InputStream inputStream) throws IOException {
        readFully(inputStream, new byte[8], 0, 8L);
        return (r1[0] << 56) + ((r1[1] & UByte.MAX_VALUE) << 48) + ((r1[2] & UByte.MAX_VALUE) << 40) + ((r1[3] & UByte.MAX_VALUE) << 32) + ((r1[4] & UByte.MAX_VALUE) << 24) + ((r1[5] & UByte.MAX_VALUE) << 16) + ((r1[6] & UByte.MAX_VALUE) << 8) + (r1[7] & UByte.MAX_VALUE);
    }

    public static int readBEInt(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        int read2 = inputStream.read();
        int read3 = inputStream.read();
        int read4 = inputStream.read();
        if ((read | read2 | read3 | read4) >= 0) {
            return (read << 24) + (read2 << 16) + (read3 << 8) + read4;
        }
        throw new EOFException();
    }

    public static void readFully(InputStream inputStream, byte[] bArr, int i, long j) throws IOException {
        int i2 = 0;
        while (true) {
            long j2 = i2;
            if (j2 >= j) {
                return;
            }
            int read = inputStream.read(bArr, i2, (int) (j - j2));
            if (read < 0) {
                throw new EOFException();
            }
            i2 += read;
        }
    }

    public static String readNullTerminatedString(InputStream inputStream) throws IOException {
        StringBuilder sb = new StringBuilder();
        int read = inputStream.read();
        int i = 0;
        while (read != 0) {
            sb.append((char) read);
            i++;
            if (i <= 2048) {
                read = inputStream.read();
            } else {
                throw new IOException("Bad string data which causes result to be too long.");
            }
        }
        return sb.toString();
    }

    public static String readString(InputStream inputStream, long j) throws IOException {
        byte[] bArr = new byte[(int) j];
        readFully(inputStream, bArr, 0, j);
        return new String(bArr, Charset.forName("UTF-8"));
    }

    public static HprofID readID(InputStream inputStream, int i) throws IOException {
        byte[] bArr = new byte[i];
        readFully(inputStream, bArr, 0, i);
        return new HprofID(bArr);
    }

    /* renamed from: com.bytedance.memory.shrink.MemoryIOUtil$1, reason: invalid class name */
    /* loaded from: classes4.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$memory$shrink$BaseType;

        static {
            int[] iArr = new int[BaseType.values().length];
            $SwitchMap$com$bytedance$memory$shrink$BaseType = iArr;
            try {
                iArr[BaseType.OBJECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$bytedance$memory$shrink$BaseType[BaseType.BOOLEAN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$bytedance$memory$shrink$BaseType[BaseType.CHAR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$bytedance$memory$shrink$BaseType[BaseType.FLOAT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$bytedance$memory$shrink$BaseType[BaseType.DOUBLE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$bytedance$memory$shrink$BaseType[BaseType.BYTE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$bytedance$memory$shrink$BaseType[BaseType.SHORT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$bytedance$memory$shrink$BaseType[BaseType.INT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$bytedance$memory$shrink$BaseType[BaseType.LONG.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public static Object readValue(InputStream inputStream, BaseType baseType, int i) throws IOException {
        switch (AnonymousClass1.$SwitchMap$com$bytedance$memory$shrink$BaseType[baseType.ordinal()]) {
            case 1:
                return readID(inputStream, i);
            case 2:
                return Boolean.valueOf(inputStream.read() != 0);
            case 3:
                return Character.valueOf((char) readBEShort(inputStream));
            case 4:
                return Float.valueOf(Float.intBitsToFloat(readBEInt(inputStream)));
            case 5:
                return Double.valueOf(Double.longBitsToDouble(readBELong(inputStream)));
            case 6:
                return Byte.valueOf((byte) inputStream.read());
            case 7:
                return Short.valueOf(readBEShort(inputStream));
            case 8:
                return Integer.valueOf(readBEInt(inputStream));
            case 9:
                return Long.valueOf(readBELong(inputStream));
            default:
                return null;
        }
    }

    public static void skip(InputStream inputStream, long j) throws IOException {
        long j2 = 0;
        while (j2 < j) {
            long skip = inputStream.skip(j - j2);
            if (skip < 0) {
                throw new EOFException();
            }
            j2 += skip;
        }
    }

    public static int skipValue(InputStream inputStream, BaseType baseType, int i) throws IOException {
        int size = baseType.getSize(i);
        skip(inputStream, size);
        return size;
    }

    public static void writeLEShort(OutputStream outputStream, int i) throws IOException {
        outputStream.write(i & 255);
        outputStream.write((i >>> 8) & 255);
    }

    public static void writeLEInt(OutputStream outputStream, int i) throws IOException {
        outputStream.write(i & 255);
        outputStream.write((i >>> 8) & 255);
        outputStream.write((i >>> 16) & 255);
        outputStream.write((i >>> 24) & 255);
    }

    public static void writeBEShort(OutputStream outputStream, int i) throws IOException {
        outputStream.write((i >>> 8) & 255);
        outputStream.write(i & 255);
    }

    public static void writeBEInt(OutputStream outputStream, int i) throws IOException {
        outputStream.write((i >>> 24) & 255);
        outputStream.write((i >>> 16) & 255);
        outputStream.write((i >>> 8) & 255);
        outputStream.write(i & 255);
    }

    public static void writeLELong(OutputStream outputStream, long j) throws IOException {
        outputStream.write(new byte[]{(byte) j, (byte) (j >>> 8), (byte) (j >>> 16), (byte) (j >>> 24), (byte) (j >>> 32), (byte) (j >>> 40), (byte) (j >>> 48), (byte) (j >>> 56)}, 0, 8);
    }

    public static void writeBELong(OutputStream outputStream, long j) throws IOException {
        outputStream.write(new byte[]{(byte) (j >>> 56), (byte) (j >>> 48), (byte) (j >>> 40), (byte) (j >>> 32), (byte) (j >>> 24), (byte) (j >>> 16), (byte) (j >>> 8), (byte) j}, 0, 8);
    }

    public static void writeString(OutputStream outputStream, String str) throws IOException {
        byte[] bytes = str.getBytes(Charset.forName("UTF-8"));
        outputStream.write(bytes, 0, bytes.length);
    }

    public static void writeNullTerminatedString(OutputStream outputStream, String str) throws IOException {
        outputStream.write(str.getBytes(Charset.forName("UTF-8")));
        outputStream.write(0);
    }

    public static void writeID(OutputStream outputStream, HprofID hprofID) throws IOException {
        outputStream.write(hprofID.getBytes());
    }

    public static void writeValue(OutputStream outputStream, Object obj) throws IOException {
        if (obj == null) {
            throw new IllegalArgumentException("value is null.");
        }
        if (obj instanceof HprofID) {
            writeID(outputStream, (HprofID) obj);
            return;
        }
        if ((obj instanceof Boolean) || Boolean.TYPE.isAssignableFrom(obj.getClass())) {
            outputStream.write(((Boolean) obj).booleanValue() ? 1 : 0);
            return;
        }
        if ((obj instanceof Character) || Character.TYPE.isAssignableFrom(obj.getClass())) {
            writeBEShort(outputStream, ((Character) obj).charValue());
            return;
        }
        if ((obj instanceof Float) || Float.TYPE.isAssignableFrom(obj.getClass())) {
            writeBEInt(outputStream, Float.floatToRawIntBits(((Float) obj).floatValue()));
            return;
        }
        if ((obj instanceof Double) || Double.TYPE.isAssignableFrom(obj.getClass())) {
            writeBELong(outputStream, Double.doubleToRawLongBits(((Double) obj).doubleValue()));
            return;
        }
        if ((obj instanceof Byte) || Byte.TYPE.isAssignableFrom(obj.getClass())) {
            outputStream.write(((Byte) obj).byteValue());
            return;
        }
        if ((obj instanceof Short) || Short.TYPE.isAssignableFrom(obj.getClass())) {
            writeBEShort(outputStream, ((Short) obj).shortValue());
            return;
        }
        if ((obj instanceof Integer) || Integer.TYPE.isAssignableFrom(obj.getClass())) {
            writeBEInt(outputStream, ((Integer) obj).intValue());
        } else {
            if ((obj instanceof Long) || Long.TYPE.isAssignableFrom(obj.getClass())) {
                writeBELong(outputStream, ((Long) obj).longValue());
                return;
            }
            throw new IllegalArgumentException("bad value type: " + obj.getClass().getName());
        }
    }

    public static void writeEmptyValue(OutputStream outputStream, Object obj) throws IOException {
        if (obj == null) {
            throw new IllegalArgumentException("value is null.");
        }
        if (obj instanceof HprofID) {
            writeID(outputStream, (HprofID) obj);
            return;
        }
        if ((obj instanceof Boolean) || Boolean.TYPE.isAssignableFrom(obj.getClass())) {
            outputStream.write(0);
            return;
        }
        if ((obj instanceof Character) || Character.TYPE.isAssignableFrom(obj.getClass())) {
            writeBEShort(outputStream, 0);
            return;
        }
        if ((obj instanceof Float) || Float.TYPE.isAssignableFrom(obj.getClass())) {
            writeBEInt(outputStream, 0);
            return;
        }
        if ((obj instanceof Double) || Double.TYPE.isAssignableFrom(obj.getClass())) {
            writeBELong(outputStream, 0L);
            return;
        }
        if ((obj instanceof Byte) || Byte.TYPE.isAssignableFrom(obj.getClass())) {
            outputStream.write(0);
            return;
        }
        if ((obj instanceof Short) || Short.TYPE.isAssignableFrom(obj.getClass())) {
            writeBEShort(outputStream, 0);
            return;
        }
        if ((obj instanceof Integer) || Integer.TYPE.isAssignableFrom(obj.getClass())) {
            writeBEInt(outputStream, 0);
        } else {
            if ((obj instanceof Long) || Long.TYPE.isAssignableFrom(obj.getClass())) {
                writeBELong(outputStream, 0L);
                return;
            }
            throw new IllegalArgumentException("bad value type: " + obj.getClass().getName());
        }
    }

    public static void skip(OutputStream outputStream, long j) throws IOException {
        byte[] bArr = new byte[4096];
        for (int i = 0; i < (j >> 12); i++) {
            outputStream.write(bArr);
        }
        outputStream.write(bArr, 0, (int) (j & 4095));
    }

    private MemoryIOUtil() {
        throw new UnsupportedOperationException();
    }
}
