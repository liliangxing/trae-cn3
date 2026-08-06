package com.bytedance.trae.conversation.chat.checkpoint;

import android.graphics.Typeface;
import android.os.Build;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CheckpointTypefaces.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\bJ\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0005H\u0003JG\u0010\f\u001a\u0002H\r\"\u0004\b\u0000\u0010\r2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\r0\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\r0\u0012H\u0000¢\u0006\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointTypefaces;", "", "<init>", "()V", "FIGMA_MEDIUM_WEIGHT", "", "FIGMA_SEMIBOLD_WEIGHT", "defaultMedium", "Landroid/graphics/Typeface;", "defaultSemibold", "createDefaultWeight", "weight", "createForSdk", ExifInterface.GPS_DIRECTION_TRUE, "sdkInt", "weightedFactory", "Lkotlin/Function1;", "fallbackFactory", "Lkotlin/Function0;", "createForSdk$conversation_mainlandRelease", "(IILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CheckpointTypefaces {
    private static final int FIGMA_MEDIUM_WEIGHT = 510;
    private static final int FIGMA_SEMIBOLD_WEIGHT = 590;
    public static final CheckpointTypefaces INSTANCE = new CheckpointTypefaces();

    private CheckpointTypefaces() {
    }

    public final Typeface defaultMedium() {
        return createDefaultWeight(510);
    }

    public final Typeface defaultSemibold() {
        return createDefaultWeight(590);
    }

    private final Typeface createDefaultWeight(int weight) {
        Object createForSdk$conversation_mainlandRelease = createForSdk$conversation_mainlandRelease(Build.VERSION.SDK_INT, weight, new Function1() { // from class: com.bytedance.trae.conversation.chat.checkpoint.CheckpointTypefaces$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Typeface createDefaultWeight$lambda$0;
                createDefaultWeight$lambda$0 = CheckpointTypefaces.createDefaultWeight$lambda$0(((Integer) obj).intValue());
                return createDefaultWeight$lambda$0;
            }
        }, new Function0() { // from class: com.bytedance.trae.conversation.chat.checkpoint.CheckpointTypefaces$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Typeface typeface;
                typeface = Typeface.DEFAULT_BOLD;
                return typeface;
            }
        });
        Intrinsics.checkNotNullExpressionValue(createForSdk$conversation_mainlandRelease, "createForSdk(...)");
        return (Typeface) createForSdk$conversation_mainlandRelease;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Typeface createDefaultWeight$lambda$0(int i) {
        return Typeface.create(Typeface.DEFAULT, i, false);
    }

    public final <T> T createForSdk$conversation_mainlandRelease(int sdkInt, int weight, Function1<? super Integer, ? extends T> weightedFactory, Function0<? extends T> fallbackFactory) {
        Intrinsics.checkNotNullParameter(weightedFactory, "weightedFactory");
        Intrinsics.checkNotNullParameter(fallbackFactory, "fallbackFactory");
        if (sdkInt >= 28) {
            return weightedFactory.invoke(Integer.valueOf(weight));
        }
        return fallbackFactory.invoke();
    }
}
