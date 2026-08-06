package com.bytedance.trae.conversation.imageupload;

import com.bytedance.sync.SyncConstants;
import com.bytedance.trae.im.model.MessagePart;
import java.io.File;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.text.StringsKt;

/* compiled from: StoreKeyGenerator.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0002¨\u0006\u000f"}, d2 = {"Lcom/bytedance/trae/conversation/imageupload/StoreKeyGenerator;", "", "<init>", "()V", "generate", "", MessagePart.TYPE_FILE, "Ljava/io/File;", "userId", "region", "dim", "Lcom/bytedance/trae/conversation/imageupload/ImageDimension;", "randomString", "length", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class StoreKeyGenerator {
    public static final StoreKeyGenerator INSTANCE = new StoreKeyGenerator();

    private StoreKeyGenerator() {
    }

    public final String generate(File file, String userId, String region, ImageDimension dim) {
        Intrinsics.checkNotNullParameter(file, MessagePart.TYPE_FILE);
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(region, "region");
        long currentTimeMillis = System.currentTimeMillis();
        String randomString = randomString(12);
        String name = file.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        String lowerCase = StringsKt.substringAfterLast(name, '.', "png").toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return region + '/' + userId + "/image/" + currentTimeMillis + '_' + randomString + '_' + lowerCase + (dim != null ? SyncConstants.SEPARATOR + dim.getWidth() + 'x' + dim.getHeight() : "");
    }

    private final String randomString(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append("abcdefghijklmnopqrstuvwxyz0123456789".charAt(Random.Default.nextInt(36)));
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }
}
