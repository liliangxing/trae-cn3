package com.lynx.tasm.common;

import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.TemplateData;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.base.trace.TraceEventDef;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.UByte;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class LepusBuffer implements MessageCodec {
    private static final byte BYTE_ARRAY = 9;
    private static final byte DOUBLE = 5;
    private static final byte FALSE = 2;
    public static final LepusBuffer INSTANCE = new LepusBuffer();
    private static final byte INT = 3;
    private static final byte LIST = 7;
    private static final boolean LITTLE_ENDIAN;
    private static final byte LONG = 4;
    private static final byte MAP = 8;
    private static final byte NULL = 0;
    private static final byte STRING = 6;
    private static final String TAG = "LepusBuffer";
    private static final byte TEMPLATE_DATA = 10;
    private static final String TRACE_DECODE_MESSAGE = "LepusBuffer::DecodeMessage";
    private static final byte TRUE = 1;
    private static final byte UNDEFINED = 100;
    private static final Charset UTF8;

    @Deprecated
    public void setDebug(boolean z) {
    }

    static {
        LITTLE_ENDIAN = ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN;
        UTF8 = Charset.forName("UTF8");
    }

    @Override // com.lynx.tasm.common.MessageCodec
    public ByteBuffer encodeMessage(Object obj) {
        TraceEvent.beginSection(TraceEventDef.LEPUS_BUFFER_ENCODE_MESSAGE);
        if (obj == null) {
            TraceEvent.endSection(TraceEventDef.LEPUS_BUFFER_ENCODE_MESSAGE);
            return null;
        }
        ExposedByteArrayOutputStream exposedByteArrayOutputStream = new ExposedByteArrayOutputStream();
        try {
            writeValue(exposedByteArrayOutputStream, obj);
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(exposedByteArrayOutputStream.size());
            allocateDirect.put(exposedByteArrayOutputStream.buffer(), 0, exposedByteArrayOutputStream.size());
            TraceEvent.endSection(TraceEventDef.LEPUS_BUFFER_ENCODE_MESSAGE);
            return allocateDirect;
        } catch (IllegalArgumentException e) {
            LynxError lynxError = new LynxError(e.toString(), -3);
            LynxEnv.inst().getLynxViewClient().onReceivedError(lynxError);
            LLog.e(TAG, lynxError.toString());
            TraceEvent.endSection(TraceEventDef.LEPUS_BUFFER_ENCODE_MESSAGE);
            return null;
        }
    }

    @Override // com.lynx.tasm.common.MessageCodec
    public Object decodeMessage(ByteBuffer byteBuffer) {
        TraceEvent.beginSection("LepusBuffer::DecodeMessage");
        if (byteBuffer == null) {
            TraceEvent.endSection("LepusBuffer::DecodeMessage");
            return null;
        }
        try {
            byteBuffer.order(ByteOrder.nativeOrder());
            Object readValue = readValue(byteBuffer);
            if (byteBuffer.hasRemaining()) {
                throw new IllegalArgumentException("Message corrupted");
            }
            TraceEvent.endSection("LepusBuffer::DecodeMessage");
            return readValue;
        } catch (IllegalArgumentException e) {
            LynxError lynxError = new LynxError(e.toString(), -3);
            if (LynxEnv.inst().getLynxViewClient() != null) {
                LynxEnv.inst().getLynxViewClient().onReceivedError(lynxError);
            }
            TraceEvent.endSection("LepusBuffer::DecodeMessage");
            return null;
        }
    }

    protected static void writeSize(ByteArrayOutputStream byteArrayOutputStream, int i) {
        if (i < 254) {
            byteArrayOutputStream.write(i);
        } else if (i <= 65535) {
            byteArrayOutputStream.write(254);
            writeChar(byteArrayOutputStream, i);
        } else {
            byteArrayOutputStream.write(255);
            writeInt(byteArrayOutputStream, i);
        }
    }

    protected static void writeChar(ByteArrayOutputStream byteArrayOutputStream, int i) {
        if (LITTLE_ENDIAN) {
            byteArrayOutputStream.write(i);
            byteArrayOutputStream.write(i >>> 8);
        } else {
            byteArrayOutputStream.write(i >>> 8);
            byteArrayOutputStream.write(i);
        }
    }

    protected static void writeInt(ByteArrayOutputStream byteArrayOutputStream, int i) {
        if (LITTLE_ENDIAN) {
            byteArrayOutputStream.write(i);
            byteArrayOutputStream.write(i >>> 8);
            byteArrayOutputStream.write(i >>> 16);
            byteArrayOutputStream.write(i >>> 24);
            return;
        }
        byteArrayOutputStream.write(i >>> 24);
        byteArrayOutputStream.write(i >>> 16);
        byteArrayOutputStream.write(i >>> 8);
        byteArrayOutputStream.write(i);
    }

    protected static void writeLong(ByteArrayOutputStream byteArrayOutputStream, long j) {
        if (LITTLE_ENDIAN) {
            byteArrayOutputStream.write((byte) j);
            byteArrayOutputStream.write((byte) (j >>> 8));
            byteArrayOutputStream.write((byte) (j >>> 16));
            byteArrayOutputStream.write((byte) (j >>> 24));
            byteArrayOutputStream.write((byte) (j >>> 32));
            byteArrayOutputStream.write((byte) (j >>> 40));
            byteArrayOutputStream.write((byte) (j >>> 48));
            byteArrayOutputStream.write((byte) (j >>> 56));
            return;
        }
        byteArrayOutputStream.write((byte) (j >>> 56));
        byteArrayOutputStream.write((byte) (j >>> 48));
        byteArrayOutputStream.write((byte) (j >>> 40));
        byteArrayOutputStream.write((byte) (j >>> 32));
        byteArrayOutputStream.write((byte) (j >>> 24));
        byteArrayOutputStream.write((byte) (j >>> 16));
        byteArrayOutputStream.write((byte) (j >>> 8));
        byteArrayOutputStream.write((byte) j);
    }

    protected static void writeDouble(ByteArrayOutputStream byteArrayOutputStream, double d) {
        writeLong(byteArrayOutputStream, Double.doubleToLongBits(d));
    }

    protected static void writeBytes(ByteArrayOutputStream byteArrayOutputStream, byte[] bArr) {
        writeSize(byteArrayOutputStream, bArr.length);
        byteArrayOutputStream.write(bArr, 0, bArr.length);
    }

    protected static void writeAlignment(ByteArrayOutputStream byteArrayOutputStream, int i) {
        int size = byteArrayOutputStream.size() % i;
        if (size != 0) {
            for (int i2 = 0; i2 < i - size; i2++) {
                byteArrayOutputStream.write(0);
            }
        }
    }

    protected void writeValue(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
        recursiveWriteValue(byteArrayOutputStream, obj, new LinkedList<>());
    }

    private void recursiveWriteValue(ByteArrayOutputStream byteArrayOutputStream, Object obj, LinkedList<Object> linkedList) {
        if (obj == null || obj.equals(null)) {
            byteArrayOutputStream.write(0);
            return;
        }
        if (obj instanceof Boolean) {
            byteArrayOutputStream.write(((Boolean) obj).booleanValue() ? 1 : 2);
            return;
        }
        if (obj instanceof Number) {
            if ((obj instanceof Integer) || (obj instanceof Short) || (obj instanceof Byte)) {
                byteArrayOutputStream.write(3);
                writeInt(byteArrayOutputStream, ((Number) obj).intValue());
                return;
            }
            if (obj instanceof Long) {
                byteArrayOutputStream.write(4);
                writeLong(byteArrayOutputStream, ((Long) obj).longValue());
                return;
            } else if ((obj instanceof Float) || (obj instanceof Double)) {
                byteArrayOutputStream.write(5);
                writeAlignment(byteArrayOutputStream, 8);
                writeDouble(byteArrayOutputStream, ((Number) obj).doubleValue());
                return;
            } else {
                byteArrayOutputStream.write(0);
                LLog.e(TAG, "Unsupported Number type: " + obj.getClass() + " value: " + obj);
                return;
            }
        }
        if (obj instanceof String) {
            byteArrayOutputStream.write(6);
            writeBytes(byteArrayOutputStream, ((String) obj).getBytes(UTF8));
            return;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            if (!list.isEmpty() && shallowContains(linkedList, obj)) {
                byteArrayOutputStream.write(0);
                LLog.DTHROW(new IllegalArgumentException("writeValue has cycle array!"));
                return;
            }
            linkedList.addLast(obj);
            byteArrayOutputStream.write(7);
            writeSize(byteArrayOutputStream, list.size());
            Iterator it = list.iterator();
            while (it.hasNext()) {
                recursiveWriteValue(byteArrayOutputStream, it.next(), linkedList);
            }
            linkedList.removeLast();
            return;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (!map.isEmpty() && shallowContains(linkedList, obj)) {
                byteArrayOutputStream.write(0);
                LLog.DTHROW(new IllegalArgumentException("writeValue has cycle dict!"));
                return;
            }
            linkedList.addLast(obj);
            byteArrayOutputStream.write(8);
            writeSize(byteArrayOutputStream, map.size());
            for (Map.Entry entry : map.entrySet()) {
                recursiveWriteValue(byteArrayOutputStream, entry.getKey(), linkedList);
                recursiveWriteValue(byteArrayOutputStream, entry.getValue(), linkedList);
            }
            linkedList.removeLast();
            return;
        }
        if (obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj;
            if (jSONObject.length() > 0 && shallowContains(linkedList, obj)) {
                byteArrayOutputStream.write(0);
                LLog.DTHROW(new IllegalArgumentException("writeValue has cycle JSONObject!"));
                return;
            }
            linkedList.addLast(obj);
            byteArrayOutputStream.write(8);
            writeSize(byteArrayOutputStream, jSONObject.length());
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                recursiveWriteValue(byteArrayOutputStream, next, linkedList);
                recursiveWriteValue(byteArrayOutputStream, jSONObject.opt(next), linkedList);
            }
            linkedList.removeLast();
            return;
        }
        if (obj instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) obj;
            if (jSONArray.length() > 0 && shallowContains(linkedList, obj)) {
                byteArrayOutputStream.write(0);
                LLog.DTHROW(new IllegalArgumentException("writeValue has cycle JSONArray!"));
                return;
            }
            linkedList.addLast(obj);
            byteArrayOutputStream.write(7);
            writeSize(byteArrayOutputStream, jSONArray.length());
            for (int i = 0; i < jSONArray.length(); i++) {
                recursiveWriteValue(byteArrayOutputStream, jSONArray.opt(i), linkedList);
            }
            linkedList.removeLast();
            return;
        }
        if (obj instanceof byte[]) {
            byteArrayOutputStream.write(9);
            writeBytes(byteArrayOutputStream, (byte[]) obj);
        } else {
            if (obj instanceof TemplateData) {
                TemplateData templateData = (TemplateData) obj;
                templateData.flush();
                byteArrayOutputStream.write(10);
                writeLong(byteArrayOutputStream, templateData.getNativePtr());
                return;
            }
            byteArrayOutputStream.write(0);
            LLog.e(TAG, "Unsupported type: " + obj.getClass() + " value: " + obj);
        }
    }

    private static boolean shallowContains(Collection<Object> collection, Object obj) {
        if (obj == null) {
            return false;
        }
        Iterator<Object> it = collection.iterator();
        while (it.hasNext()) {
            if (obj == it.next()) {
                return true;
            }
        }
        return false;
    }

    protected static int readSize(ByteBuffer byteBuffer) {
        if (!byteBuffer.hasRemaining()) {
            throw new IllegalArgumentException("Message corrupted");
        }
        int i = byteBuffer.get() & UByte.MAX_VALUE;
        if (i < 254) {
            return i;
        }
        if (i == 254) {
            return byteBuffer.getChar();
        }
        return byteBuffer.getInt();
    }

    protected static byte[] readBytes(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[readSize(byteBuffer)];
        byteBuffer.get(bArr);
        return bArr;
    }

    protected static void readAlignment(ByteBuffer byteBuffer, int i) {
        int position = byteBuffer.position() % i;
        if (position != 0) {
            byteBuffer.position((byteBuffer.position() + i) - position);
        }
    }

    protected final Object readValue(ByteBuffer byteBuffer) {
        if (!byteBuffer.hasRemaining()) {
            throw new IllegalArgumentException("Message corrupted");
        }
        return readValueOfType(byteBuffer.get(), byteBuffer);
    }

    protected Object readValueOfType(byte b, ByteBuffer byteBuffer) {
        if (b != 100) {
            int i = 0;
            switch (b) {
                case 0:
                    break;
                case 1:
                    return true;
                case 2:
                    return false;
                case 3:
                    readAlignment(byteBuffer, 8);
                    return Integer.valueOf(byteBuffer.getInt());
                case 4:
                    readAlignment(byteBuffer, 8);
                    return Long.valueOf(byteBuffer.getLong());
                case 5:
                    readAlignment(byteBuffer, 8);
                    return Double.valueOf(byteBuffer.getDouble());
                case 6:
                    return new String(readBytes(byteBuffer), UTF8);
                case 7:
                    int readSize = readSize(byteBuffer);
                    ArrayList arrayList = new ArrayList(readSize);
                    while (i < readSize) {
                        arrayList.add(readValue(byteBuffer));
                        i++;
                    }
                    return arrayList;
                case 8:
                    int readSize2 = readSize(byteBuffer);
                    HashMap hashMap = new HashMap();
                    while (i < readSize2) {
                        hashMap.put(readValue(byteBuffer), readValue(byteBuffer));
                        i++;
                    }
                    return hashMap;
                default:
                    throw new IllegalArgumentException("Message corrupted");
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class ExposedByteArrayOutputStream extends ByteArrayOutputStream {
        ExposedByteArrayOutputStream() {
        }

        byte[] buffer() {
            return this.buf;
        }
    }
}
