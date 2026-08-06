package com.google.protobuf;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import sun.misc.Unsafe;

/* loaded from: classes6.dex */
final class UnsafeUtil {
    private static final Unsafe UNSAFE = getUnsafe();
    private static final boolean HAS_UNSAFE_BYTEBUFFER_OPERATIONS = supportsUnsafeByteBufferOperations();
    private static final boolean HAS_UNSAFE_ARRAY_OPERATIONS = supportsUnsafeArrayOperations();
    private static final long ARRAY_BASE_OFFSET = byteArrayBaseOffset();
    private static final long BUFFER_ADDRESS_OFFSET = fieldOffset(field(Buffer.class, "address"));

    private UnsafeUtil() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean hasUnsafeArrayOperations() {
        return HAS_UNSAFE_ARRAY_OPERATIONS;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean hasUnsafeByteBufferOperations() {
        return HAS_UNSAFE_BYTEBUFFER_OPERATIONS;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long getArrayBaseOffset() {
        return ARRAY_BASE_OFFSET;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte getByte(byte[] bArr, long j) {
        return UNSAFE.getByte(bArr, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void putByte(byte[] bArr, long j, byte b) {
        UNSAFE.putByte(bArr, j, b);
    }

    static void copyMemory(byte[] bArr, long j, byte[] bArr2, long j2, long j3) {
        UNSAFE.copyMemory(bArr, j, bArr2, j2, j3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long getLong(byte[] bArr, long j) {
        return UNSAFE.getLong(bArr, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte getByte(long j) {
        return UNSAFE.getByte(j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void putByte(long j, byte b) {
        UNSAFE.putByte(j, b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long getLong(long j) {
        return UNSAFE.getLong(j);
    }

    static void copyMemory(long j, long j2, long j3) {
        UNSAFE.copyMemory(j, j2, j3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long addressOffset(ByteBuffer byteBuffer) {
        return UNSAFE.getLong(byteBuffer, BUFFER_ADDRESS_OFFSET);
    }

    private static Unsafe getUnsafe() {
        try {
            return (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>() { // from class: com.google.protobuf.UnsafeUtil.1
                @Override // java.security.PrivilegedExceptionAction
                public Unsafe run() throws Exception {
                    for (Field field : Unsafe.class.getDeclaredFields()) {
                        field.setAccessible(true);
                        Object obj = field.get(null);
                        if (Unsafe.class.isInstance(obj)) {
                            return (Unsafe) Unsafe.class.cast(obj);
                        }
                    }
                    return null;
                }
            });
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean supportsUnsafeArrayOperations() {
        Unsafe unsafe = UNSAFE;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("arrayBaseOffset", Class.class);
            cls.getMethod("getByte", Object.class, Long.TYPE);
            cls.getMethod("putByte", Object.class, Long.TYPE, Byte.TYPE);
            cls.getMethod("getLong", Object.class, Long.TYPE);
            cls.getMethod("copyMemory", Object.class, Long.TYPE, Object.class, Long.TYPE, Long.TYPE);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean supportsUnsafeByteBufferOperations() {
        Unsafe unsafe = UNSAFE;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            cls.getMethod("getByte", Long.TYPE);
            cls.getMethod("getLong", Object.class, Long.TYPE);
            cls.getMethod("putByte", Long.TYPE, Byte.TYPE);
            cls.getMethod("getLong", Long.TYPE);
            cls.getMethod("copyMemory", Long.TYPE, Long.TYPE, Long.TYPE);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static int byteArrayBaseOffset() {
        if (HAS_UNSAFE_ARRAY_OPERATIONS) {
            return UNSAFE.arrayBaseOffset(byte[].class);
        }
        return -1;
    }

    private static long fieldOffset(Field field) {
        Unsafe unsafe;
        if (field == null || (unsafe = UNSAFE) == null) {
            return -1L;
        }
        return unsafe.objectFieldOffset(field);
    }

    private static Field field(Class<?> cls, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }
}
