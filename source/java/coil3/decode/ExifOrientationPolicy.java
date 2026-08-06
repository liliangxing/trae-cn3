package coil3.decode;

import coil3.util.Utils_commonKt;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSource;

/* compiled from: ExifOrientationPolicy.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u0000 \b2\u00020\u0001:\u0001\bJ\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2 = {"Lcoil3/decode/ExifOrientationPolicy;", "", "supports", "", DBDefinition.MIME_TYPE, "", "source", "Lokio/BufferedSource;", "Companion", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface ExifOrientationPolicy {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final ExifOrientationPolicy IGNORE = new ExifOrientationPolicy() { // from class: coil3.decode.ExifOrientationPolicy$$ExternalSyntheticLambda0
        @Override // coil3.decode.ExifOrientationPolicy
        public final boolean supports(String str, BufferedSource bufferedSource) {
            boolean IGNORE$lambda$0;
            IGNORE$lambda$0 = ExifOrientationPolicy.IGNORE$lambda$0(str, bufferedSource);
            return IGNORE$lambda$0;
        }
    };
    public static final ExifOrientationPolicy RESPECT_PERFORMANCE = new ExifOrientationPolicy() { // from class: coil3.decode.ExifOrientationPolicy$$ExternalSyntheticLambda1
        @Override // coil3.decode.ExifOrientationPolicy
        public final boolean supports(String str, BufferedSource bufferedSource) {
            boolean RESPECT_PERFORMANCE$lambda$1;
            RESPECT_PERFORMANCE$lambda$1 = ExifOrientationPolicy.RESPECT_PERFORMANCE$lambda$1(str, bufferedSource);
            return RESPECT_PERFORMANCE$lambda$1;
        }
    };
    public static final ExifOrientationPolicy RESPECT_ALL = new ExifOrientationPolicy() { // from class: coil3.decode.ExifOrientationPolicy$$ExternalSyntheticLambda2
        @Override // coil3.decode.ExifOrientationPolicy
        public final boolean supports(String str, BufferedSource bufferedSource) {
            boolean RESPECT_ALL$lambda$2;
            RESPECT_ALL$lambda$2 = ExifOrientationPolicy.RESPECT_ALL$lambda$2(str, bufferedSource);
            return RESPECT_ALL$lambda$2;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    static boolean IGNORE$lambda$0(String str, BufferedSource bufferedSource) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static boolean RESPECT_ALL$lambda$2(String str, BufferedSource bufferedSource) {
        return true;
    }

    boolean supports(String mimeType, BufferedSource source);

    /* compiled from: ExifOrientationPolicy.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001R\u0013\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001R\u0013\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001¨\u0006\b"}, d2 = {"Lcoil3/decode/ExifOrientationPolicy$Companion;", "", "<init>", "()V", "IGNORE", "Lcoil3/decode/ExifOrientationPolicy;", "RESPECT_PERFORMANCE", "RESPECT_ALL", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static boolean RESPECT_PERFORMANCE$lambda$1(String str, BufferedSource bufferedSource) {
        return str != null && (Intrinsics.areEqual(str, Utils_commonKt.MIME_TYPE_JPEG) || Intrinsics.areEqual(str, Utils_commonKt.MIME_TYPE_WEBP) || Intrinsics.areEqual(str, Utils_commonKt.MIME_TYPE_HEIC) || Intrinsics.areEqual(str, Utils_commonKt.MIME_TYPE_HEIF));
    }
}
