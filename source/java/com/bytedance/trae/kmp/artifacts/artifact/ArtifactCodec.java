package com.bytedance.trae.kmp.artifacts.artifact;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ArtifactCodec.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001:\u0002\r\u000eB\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005J\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005J\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec;", "", "<init>", "()V", "magicV1", "", "magicV2", "magicV2WithZeroPrefix", "xorKeyV2", "decode", "bytes", "encodeV1ForTest", "encodeV2ForTest", "Decoder", "Mode", "artifacts_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ArtifactCodec {
    public static final ArtifactCodec INSTANCE = new ArtifactCodec();
    private static final byte[] magicV1 = {-122, -82, -58, 27};
    private static final byte[] magicV2 = {27, -58, -82, -122};
    private static final byte[] magicV2WithZeroPrefix = {0, 0, 0, 0, 27, -58, -82, -122};
    private static final byte[] xorKeyV2 = {-22, -97, -70, -58, -107, -55, -123, -22, -99, -119, 32, -31, -75, -69, -62, -89, 32, -22, -99, -119, -58, -107, -30, -126, -84, 32, -61, -97, -30, -126, -84, -62, -89, -22, -99, -119, 33};
    public static final int $stable = 8;

    private ArtifactCodec() {
    }

    public final byte[] decode(byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        Decoder decoder = new Decoder();
        return ArraysKt.plus(decoder.decode(bytes), decoder.finish());
    }

    public final byte[] encodeV1ForTest(byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return ArraysKt.plus(magicV1, bytes);
    }

    public final byte[] encodeV2ForTest(byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        byte[] bArr = magicV2;
        ArrayList arrayList = new ArrayList(bytes.length);
        int length = bytes.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            byte b = bytes[i];
            byte[] bArr2 = xorKeyV2;
            arrayList.add(Byte.valueOf((byte) (bArr2[i2 % bArr2.length] ^ b)));
            i++;
            i2++;
        }
        return ArraysKt.plus(bArr, CollectionsKt.toByteArray(arrayList));
    }

    /* compiled from: ArtifactCodec.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005J\u0006\u0010\f\u001a\u00020\u0005J\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000e\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Decoder;", "", "<init>", "()V", "pendingHeader", "", "mode", "Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Mode;", "payloadOffset", "", "decode", "chunk", "finish", "transform", "bytes", "detectMode", "artifacts_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Decoder {
        public static final int $stable = 8;
        private Mode mode;
        private int payloadOffset;
        private byte[] pendingHeader = new byte[0];

        /* compiled from: ArtifactCodec.kt */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[Mode.values().length];
                try {
                    iArr[Mode.f122V1.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Mode.f123V2.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[Mode.Plain.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[Mode.Waiting.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public final byte[] decode(byte[] chunk) {
            int length;
            boolean startsWith;
            Intrinsics.checkNotNullParameter(chunk, "chunk");
            if (chunk.length == 0) {
                return new byte[0];
            }
            Mode mode = this.mode;
            if (mode != null) {
                return transform(chunk, mode);
            }
            byte[] plus = ArraysKt.plus(this.pendingHeader, chunk);
            this.pendingHeader = plus;
            Mode detectMode = detectMode(plus);
            if (detectMode == null) {
                if (this.pendingHeader.length < ArtifactCodec.magicV2WithZeroPrefix.length) {
                    return new byte[0];
                }
                this.mode = Mode.Plain;
                byte[] bArr = this.pendingHeader;
                this.pendingHeader = new byte[0];
                return bArr;
            }
            if (detectMode == Mode.Waiting) {
                return new byte[0];
            }
            this.mode = detectMode;
            int i = WhenMappings.$EnumSwitchMapping$0[detectMode.ordinal()];
            if (i == 1) {
                length = ArtifactCodec.magicV1.length;
            } else if (i == 2) {
                startsWith = ArtifactCodecKt.startsWith(this.pendingHeader, ArtifactCodec.magicV2WithZeroPrefix);
                length = startsWith ? ArtifactCodec.magicV2WithZeroPrefix.length : ArtifactCodec.magicV2.length;
            } else {
                if (i != 3 && i != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                length = 0;
            }
            byte[] bArr2 = this.pendingHeader;
            byte[] copyOfRange = ArraysKt.copyOfRange(bArr2, length, bArr2.length);
            this.pendingHeader = new byte[0];
            return transform(copyOfRange, detectMode);
        }

        public final byte[] finish() {
            if (this.mode != null) {
                return new byte[0];
            }
            this.mode = Mode.Plain;
            byte[] bArr = this.pendingHeader;
            this.pendingHeader = new byte[0];
            return bArr;
        }

        private final byte[] transform(byte[] bytes, Mode mode) {
            int i = WhenMappings.$EnumSwitchMapping$0[mode.ordinal()];
            if (i == 1) {
                return bytes;
            }
            int i2 = 0;
            if (i != 2) {
                if (i == 3) {
                    return bytes;
                }
                if (i == 4) {
                    return new byte[0];
                }
                throw new NoWhenBranchMatchedException();
            }
            ArrayList arrayList = new ArrayList(bytes.length);
            int length = bytes.length;
            int i3 = 0;
            while (i2 < length) {
                arrayList.add(Byte.valueOf((byte) (ArtifactCodec.xorKeyV2[(this.payloadOffset + i3) % ArtifactCodec.xorKeyV2.length] ^ bytes[i2])));
                i2++;
                i3++;
            }
            byte[] byteArray = CollectionsKt.toByteArray(arrayList);
            this.payloadOffset += bytes.length;
            return byteArray;
        }

        private final Mode detectMode(byte[] bytes) {
            boolean startsWith;
            boolean startsWith2;
            boolean startsWith3;
            boolean startsWith4;
            boolean startsWith5;
            boolean startsWith6;
            startsWith = ArtifactCodecKt.startsWith(bytes, ArtifactCodec.magicV2WithZeroPrefix);
            if (startsWith) {
                return Mode.f123V2;
            }
            startsWith2 = ArtifactCodecKt.startsWith(bytes, ArtifactCodec.magicV2);
            if (startsWith2) {
                return Mode.f123V2;
            }
            startsWith3 = ArtifactCodecKt.startsWith(bytes, ArtifactCodec.magicV1);
            if (startsWith3) {
                return Mode.f122V1;
            }
            startsWith4 = ArtifactCodecKt.startsWith(ArtifactCodec.magicV2WithZeroPrefix, bytes);
            if (!startsWith4) {
                startsWith5 = ArtifactCodecKt.startsWith(ArtifactCodec.magicV2, bytes);
                if (!startsWith5) {
                    startsWith6 = ArtifactCodecKt.startsWith(ArtifactCodec.magicV1, bytes);
                    if (!startsWith6) {
                        if (bytes.length >= ArtifactCodec.magicV1.length) {
                            return Mode.Plain;
                        }
                        return null;
                    }
                }
            }
            return Mode.Waiting;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: ArtifactCodec.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCodec$Mode;", "", "<init>", "(Ljava/lang/String;I)V", "Waiting", "V1", "V2", "Plain", "artifacts_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Mode {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Mode[] $VALUES;
        public static final Mode Waiting = new Mode("Waiting", 0);

        /* renamed from: V1 */
        public static final Mode f122V1 = new Mode("V1", 1);

        /* renamed from: V2 */
        public static final Mode f123V2 = new Mode("V2", 2);
        public static final Mode Plain = new Mode("Plain", 3);

        private static final /* synthetic */ Mode[] $values() {
            return new Mode[]{Waiting, f122V1, f123V2, Plain};
        }

        public static EnumEntries<Mode> getEntries() {
            return $ENTRIES;
        }

        private Mode(String str, int i) {
        }

        static {
            Mode[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        public static Mode valueOf(String str) {
            return (Mode) Enum.valueOf(Mode.class, str);
        }

        public static Mode[] values() {
            return (Mode[]) $VALUES.clone();
        }
    }
}
