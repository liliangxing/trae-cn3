package ms.bd.c;

import androidx.collection.SieveCacheKt;
import com.bytedance.trae.utils.ApkUtil;
import com.ss.ttm.player.MediaPlayer;
import java.io.IOException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.LinkedHashMap;

/* loaded from: classes8.dex */
public abstract class f {
    public static d a(FileChannel fileChannel) {
        long size = fileChannel.size();
        if (size < 22) {
            throw new IOException((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "f72618", new byte[]{38, 100}));
        }
        long j = size - 22;
        long min = Math.min(j, 65535L);
        int i = 0;
        while (true) {
            long j2 = i;
            if (j2 > min) {
                throw new IOException((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "255618", new byte[]{114, 103}));
            }
            long j3 = j - j2;
            ByteBuffer allocate = ByteBuffer.allocate(4);
            fileChannel.position(j3);
            fileChannel.read(allocate);
            ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
            allocate.order(byteOrder);
            if (allocate.getInt(0) == 101010256) {
                ByteBuffer allocate2 = ByteBuffer.allocate(2);
                fileChannel.position(j3 + 20);
                fileChannel.read(allocate2);
                allocate2.order(byteOrder);
                short s = allocate2.getShort(0);
                if (s == i) {
                    ByteBuffer allocate3 = ByteBuffer.allocate(4);
                    allocate3.order(byteOrder);
                    fileChannel.position((fileChannel.size() - s) - 6);
                    fileChannel.read(allocate3);
                    long j4 = allocate3.getInt(0);
                    if (j4 >= 32) {
                        fileChannel.position(j4 - 24);
                        ByteBuffer allocate4 = ByteBuffer.allocate(24);
                        fileChannel.read(allocate4);
                        allocate4.order(byteOrder);
                        if (allocate4.getLong(8) == ApkUtil.APK_SIG_BLOCK_MAGIC_LO && allocate4.getLong(16) == ApkUtil.APK_SIG_BLOCK_MAGIC_HI) {
                            long j5 = allocate4.getLong(0);
                            if (j5 >= allocate4.capacity() && j5 <= 2147483639) {
                                int i2 = (int) (8 + j5);
                                long j6 = j4 - i2;
                                if (j6 >= 0) {
                                    fileChannel.position(j6);
                                    ByteBuffer allocate5 = ByteBuffer.allocate(i2);
                                    fileChannel.read(allocate5);
                                    allocate5.order(byteOrder);
                                    if (allocate5.getLong(0) == j5) {
                                        return new d(allocate5, Long.valueOf(j6));
                                    }
                                }
                            }
                        }
                        return null;
                    }
                    throw new e((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "150726", new byte[]{121}));
                }
            }
            i++;
        }
    }

    public static LinkedHashMap a(ByteBuffer byteBuffer) {
        if (byteBuffer.order() == ByteOrder.LITTLE_ENDIAN) {
            int capacity = byteBuffer.capacity() - 24;
            if (capacity < 8) {
                throw new IllegalArgumentException((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "bb94a0", new byte[]{39}));
            }
            byteBuffer.capacity();
            if (capacity > byteBuffer.capacity()) {
                throw new IllegalArgumentException((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "eee3fe", new byte[]{33}));
            }
            int limit = byteBuffer.limit();
            int position = byteBuffer.position();
            try {
                byteBuffer.position(0);
                byteBuffer.limit(capacity);
                byteBuffer.position(8);
                ByteBuffer slice = byteBuffer.slice();
                slice.order(byteBuffer.order());
                byteBuffer.position(0);
                byteBuffer.limit(limit);
                byteBuffer.position(position);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                while (slice.hasRemaining()) {
                    if (slice.remaining() < 8) {
                        throw new e((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "6d1bb9", new byte[]{113}));
                    }
                    long j = slice.getLong();
                    if (j < 4 || j > SieveCacheKt.NodeLinkMask) {
                        throw new e((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "797128", new byte[]{113}));
                    }
                    int i = (int) j;
                    int position2 = slice.position() + i;
                    if (i > slice.remaining()) {
                        throw new e((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "8e0ff5", new byte[]{113}));
                    }
                    Integer valueOf = Integer.valueOf(slice.getInt());
                    int i2 = i - 4;
                    if (i2 < 0) {
                        throw new IllegalArgumentException((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "82142c", new byte[]{123}));
                    }
                    int limit2 = slice.limit();
                    int position3 = slice.position();
                    int i3 = i2 + position3;
                    if (i3 < position3 || i3 > limit2) {
                        throw new BufferUnderflowException();
                    }
                    slice.limit(i3);
                    try {
                        ByteBuffer slice2 = slice.slice();
                        slice2.order(slice.order());
                        slice.position(i3);
                        slice.limit(limit2);
                        linkedHashMap.put(valueOf, slice2);
                        slice.position(position2);
                    } catch (Throwable th) {
                        slice.limit(limit2);
                        throw th;
                    }
                }
                return linkedHashMap;
            } catch (Throwable th2) {
                byteBuffer.position(0);
                byteBuffer.limit(limit);
                byteBuffer.position(position);
                throw th2;
            }
        }
        throw new IllegalArgumentException((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0L, "8333fb", new byte[]{120}));
    }
}
