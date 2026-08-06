package com.bytedance.ies.bullet.service.base.settings;

import com.bytedance.reparo.core.exception.PatchException;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CommonConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b.\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0003\b\u0086\u0003\n\u0002\u0010\t\n\u0002\b\u001d\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR$\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001b\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019R&\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0011\"\u0004\b \u0010\u0013R\u001e\u0010!\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0011R&\u0010#\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0011\"\u0004\b%\u0010\u0013R\"\u0010&\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b'\u0010\u0006\"\u0004\b(\u0010\bR\"\u0010)\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b*\u0010\u0017\"\u0004\b+\u0010\u0019R\"\u0010,\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b-\u0010\u0017\"\u0004\b.\u0010\u0019R&\u0010/\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0011\"\u0004\b1\u0010\u0013R\"\u00102\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b3\u0010\u0017\"\u0004\b4\u0010\u0019R&\u00105\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0011\"\u0004\b7\u0010\u0013R\"\u00108\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b9\u0010\u0017\"\u0004\b:\u0010\u0019R\u001e\u0010;\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\"\u0010@\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\bA\u0010\u0006\"\u0004\bB\u0010\bR \u0010C\u001a\u0004\u0018\u00010D8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR \u0010I\u001a\u0004\u0018\u00010J8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u001e\u0010O\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010=\"\u0004\bQ\u0010?R\"\u0010R\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\bS\u0010\u0006\"\u0004\bT\u0010\bR\"\u0010U\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\bV\u0010\u0006\"\u0004\bW\u0010\bR\"\u0010X\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\bY\u0010\u0006\"\u0004\bZ\u0010\bR\"\u0010[\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\\\u0010\u0006\"\u0004\b]\u0010\bR\"\u0010^\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b_\u0010\u0006\"\u0004\b`\u0010\bR\u001e\u0010a\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010=\"\u0004\bc\u0010?R\"\u0010d\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\be\u0010\u0006\"\u0004\bf\u0010\bR\"\u0010g\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\bh\u0010\u0006\"\u0004\bi\u0010\bR\"\u0010j\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\bk\u0010\u0006\"\u0004\bl\u0010\bR\"\u0010m\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\bn\u0010\u0006\"\u0004\bo\u0010\bR\"\u0010p\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\bq\u0010\u0006\"\u0004\br\u0010\bR\"\u0010s\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\bt\u0010\u0006\"\u0004\bu\u0010\bR\"\u0010v\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\bw\u0010\u0006\"\u0004\bx\u0010\bR\u001e\u0010y\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bz\u0010=\"\u0004\b{\u0010?R\u001e\u0010|\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b}\u0010=\"\u0004\b~\u0010?R$\u0010\u007f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\b\u0080\u0001\u0010\u0006\"\u0005\b\u0081\u0001\u0010\bR%\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\b\u0083\u0001\u0010\u0006\"\u0005\b\u0084\u0001\u0010\bR)\u0010\u0085\u0001\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0086\u0001\u0010\u0011\"\u0005\b\u0087\u0001\u0010\u0013R%\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\b\u0089\u0001\u0010\u0006\"\u0005\b\u008a\u0001\u0010\bR%\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\b\u008c\u0001\u0010\u0006\"\u0005\b\u008d\u0001\u0010\bR%\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\b\u008f\u0001\u0010\u0006\"\u0005\b\u0090\u0001\u0010\bR%\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\b\u0092\u0001\u0010\u0006\"\u0005\b\u0093\u0001\u0010\bR%\u0010\u0094\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\b\u0095\u0001\u0010\u0006\"\u0005\b\u0096\u0001\u0010\bR%\u0010\u0097\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\b\u0098\u0001\u0010\u0006\"\u0005\b\u0099\u0001\u0010\bR%\u0010\u009a\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\b\u009b\u0001\u0010\u0006\"\u0005\b\u009c\u0001\u0010\bR%\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\b\u009e\u0001\u0010\u0006\"\u0005\b\u009f\u0001\u0010\bR%\u0010 \u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\b¡\u0001\u0010\u0006\"\u0005\b¢\u0001\u0010\bR%\u0010£\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\b¤\u0001\u0010\u0006\"\u0005\b¥\u0001\u0010\bR%\u0010¦\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\b§\u0001\u0010\u0006\"\u0005\b¨\u0001\u0010\bR%\u0010©\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\bª\u0001\u0010\u0006\"\u0005\b«\u0001\u0010\bR!\u0010¬\u0001\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u00ad\u0001\u0010=\"\u0005\b®\u0001\u0010?R%\u0010¯\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\b°\u0001\u0010\u0006\"\u0005\b±\u0001\u0010\bR%\u0010²\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\b³\u0001\u0010\u0006\"\u0005\b´\u0001\u0010\bR%\u0010µ\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\b¶\u0001\u0010\u0006\"\u0005\b·\u0001\u0010\bR%\u0010¸\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\b¹\u0001\u0010\u0006\"\u0005\bº\u0001\u0010\bR%\u0010»\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\b¼\u0001\u0010\u0006\"\u0005\b½\u0001\u0010\bR%\u0010¾\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\b¿\u0001\u0010\u0006\"\u0005\bÀ\u0001\u0010\bR%\u0010Á\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\bÂ\u0001\u0010\u0006\"\u0005\bÃ\u0001\u0010\bR%\u0010Ä\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\bÅ\u0001\u0010\u0006\"\u0005\bÆ\u0001\u0010\bR%\u0010Ç\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\bÈ\u0001\u0010\u0006\"\u0005\bÉ\u0001\u0010\bR%\u0010Ê\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\bË\u0001\u0010\u0006\"\u0005\bÌ\u0001\u0010\bR!\u0010Í\u0001\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÎ\u0001\u0010=\"\u0005\bÏ\u0001\u0010?R!\u0010Ð\u0001\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÑ\u0001\u0010=\"\u0005\bÒ\u0001\u0010?R!\u0010Ó\u0001\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÔ\u0001\u0010=\"\u0005\bÕ\u0001\u0010?R%\u0010Ö\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\b×\u0001\u0010\u0006\"\u0005\bØ\u0001\u0010\bR%\u0010Ù\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\bÚ\u0001\u0010\u0006\"\u0005\bÛ\u0001\u0010\bR%\u0010Ü\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\bÝ\u0001\u0010\u0006\"\u0005\bÞ\u0001\u0010\bR%\u0010ß\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\bà\u0001\u0010\u0006\"\u0005\bá\u0001\u0010\bR%\u0010â\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\bã\u0001\u0010\u0006\"\u0005\bä\u0001\u0010\bR!\u0010å\u0001\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bæ\u0001\u0010=\"\u0005\bç\u0001\u0010?R\u0018\u0010è\u0001\u001a\u00020\u00048\u0006X\u0087D¢\u0006\t\n\u0000\u001a\u0005\bé\u0001\u0010=R%\u0010ê\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\bë\u0001\u0010\u0006\"\u0005\bì\u0001\u0010\bR%\u0010í\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\bî\u0001\u0010\u0006\"\u0005\bï\u0001\u0010\bR%\u0010ð\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\bñ\u0001\u0010\u0006\"\u0005\bò\u0001\u0010\bR%\u0010ó\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\bô\u0001\u0010\u0006\"\u0005\bõ\u0001\u0010\bR!\u0010ö\u0001\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b÷\u0001\u0010=\"\u0005\bø\u0001\u0010?R%\u0010ù\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\bú\u0001\u0010\u0006\"\u0005\bû\u0001\u0010\bR%\u0010ü\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\bý\u0001\u0010\u0006\"\u0005\bþ\u0001\u0010\bR%\u0010ÿ\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\b\u0080\u0002\u0010\u0006\"\u0005\b\u0081\u0002\u0010\bR%\u0010\u0082\u0002\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\b\u0083\u0002\u0010\u0006\"\u0005\b\u0084\u0002\u0010\bR%\u0010\u0085\u0002\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\b\u0086\u0002\u0010\u0006\"\u0005\b\u0087\u0002\u0010\bR%\u0010\u0088\u0002\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\b\u0089\u0002\u0010\u0006\"\u0005\b\u008a\u0002\u0010\bR%\u0010\u008b\u0002\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\b\u008c\u0002\u0010\u0006\"\u0005\b\u008d\u0002\u0010\bR%\u0010\u008e\u0002\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\b\u008f\u0002\u0010\u0006\"\u0005\b\u0090\u0002\u0010\bR%\u0010\u0091\u0002\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\b\u0092\u0002\u0010\u0006\"\u0005\b\u0093\u0002\u0010\bR%\u0010\u0094\u0002\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\b\u0095\u0002\u0010\u0006\"\u0005\b\u0096\u0002\u0010\bR%\u0010\u0097\u0002\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\b\u0098\u0002\u0010\u0006\"\u0005\b\u0099\u0002\u0010\bR%\u0010\u009a\u0002\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\b\u009b\u0002\u0010\u0006\"\u0005\b\u009c\u0002\u0010\bR%\u0010\u009d\u0002\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\b\u009e\u0002\u0010\u0006\"\u0005\b\u009f\u0002\u0010\bR%\u0010 \u0002\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\b¡\u0002\u0010\u0006\"\u0005\b¢\u0002\u0010\bR%\u0010£\u0002\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\b¤\u0002\u0010\u0006\"\u0005\b¥\u0002\u0010\bR%\u0010¦\u0002\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\b§\u0002\u0010\u0006\"\u0005\b¨\u0002\u0010\bR%\u0010©\u0002\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\bª\u0002\u0010\u0006\"\u0005\b«\u0002\u0010\bR%\u0010¬\u0002\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\b\u00ad\u0002\u0010\u0006\"\u0005\b®\u0002\u0010\bR%\u0010¯\u0002\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\b°\u0002\u0010\u0006\"\u0005\b±\u0002\u0010\bR%\u0010²\u0002\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\b³\u0002\u0010\u0006\"\u0005\b´\u0002\u0010\bR%\u0010µ\u0002\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\b¶\u0002\u0010\u0006\"\u0005\b·\u0002\u0010\bR%\u0010¸\u0002\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\b¹\u0002\u0010\u0006\"\u0005\bº\u0002\u0010\bR%\u0010»\u0002\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\b¼\u0002\u0010\u0006\"\u0005\b½\u0002\u0010\bR%\u0010¾\u0002\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\b¿\u0002\u0010\u0006\"\u0005\bÀ\u0002\u0010\bR%\u0010Á\u0002\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\bÂ\u0002\u0010\u0006\"\u0005\bÃ\u0002\u0010\bR%\u0010Ä\u0002\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\bÅ\u0002\u0010\u0006\"\u0005\bÆ\u0002\u0010\bR%\u0010Ç\u0002\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\bÈ\u0002\u0010\u0006\"\u0005\bÉ\u0002\u0010\bR%\u0010Ê\u0002\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\bË\u0002\u0010\u0006\"\u0005\bÌ\u0002\u0010\bR%\u0010Í\u0002\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\bÎ\u0002\u0010\u0006\"\u0005\bÏ\u0002\u0010\bR!\u0010Ð\u0002\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÑ\u0002\u0010=\"\u0005\bÒ\u0002\u0010?R%\u0010Ó\u0002\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\bÔ\u0002\u0010\u0006\"\u0005\bÕ\u0002\u0010\bR%\u0010Ö\u0002\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\b×\u0002\u0010\u0006\"\u0005\bØ\u0002\u0010\bR%\u0010Ù\u0002\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\bÚ\u0002\u0010\u0006\"\u0005\bÛ\u0002\u0010\bR%\u0010Ü\u0002\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\bÝ\u0002\u0010\u0006\"\u0005\bÞ\u0002\u0010\bR%\u0010ß\u0002\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\bà\u0002\u0010\u0006\"\u0005\bá\u0002\u0010\bR%\u0010â\u0002\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\bã\u0002\u0010\u0006\"\u0005\bä\u0002\u0010\bR%\u0010å\u0002\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\bæ\u0002\u0010\u0006\"\u0005\bç\u0002\u0010\bR%\u0010è\u0002\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\bé\u0002\u0010\u0006\"\u0005\bê\u0002\u0010\bR%\u0010ë\u0002\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\bì\u0002\u0010\u0006\"\u0005\bí\u0002\u0010\bR%\u0010î\u0002\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\bï\u0002\u0010\u0006\"\u0005\bð\u0002\u0010\bR%\u0010ñ\u0002\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\bò\u0002\u0010\u0006\"\u0005\bó\u0002\u0010\bR%\u0010ô\u0002\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\bõ\u0002\u0010\u0006\"\u0005\bö\u0002\u0010\bR%\u0010÷\u0002\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\bø\u0002\u0010\u0006\"\u0005\bù\u0002\u0010\bR%\u0010ú\u0002\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\bû\u0002\u0010\u0006\"\u0005\bü\u0002\u0010\bR%\u0010ý\u0002\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\bþ\u0002\u0010\u0006\"\u0005\bÿ\u0002\u0010\bR%\u0010\u0080\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\b\u0081\u0003\u0010\u0006\"\u0005\b\u0082\u0003\u0010\bR!\u0010\u0083\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0084\u0003\u0010=\"\u0005\b\u0085\u0003\u0010?R%\u0010\u0086\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\b\u0087\u0003\u0010\u0006\"\u0005\b\u0088\u0003\u0010\bR!\u0010\u0089\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008a\u0003\u0010=\"\u0005\b\u008b\u0003\u0010?R%\u0010\u008c\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\b\u008d\u0003\u0010\u0006\"\u0005\b\u008e\u0003\u0010\bR%\u0010\u008f\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\b\u0090\u0003\u0010\u0006\"\u0005\b\u0091\u0003\u0010\bR%\u0010\u0092\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\b\u0093\u0003\u0010\u0006\"\u0005\b\u0094\u0003\u0010\bR%\u0010\u0095\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\b\u0096\u0003\u0010\u0006\"\u0005\b\u0097\u0003\u0010\bR%\u0010\u0098\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\b\u0099\u0003\u0010\u0006\"\u0005\b\u009a\u0003\u0010\bR%\u0010\u009b\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\b\u009c\u0003\u0010\u0006\"\u0005\b\u009d\u0003\u0010\bR%\u0010\u009e\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\b\u009f\u0003\u0010\u0006\"\u0005\b \u0003\u0010\bR%\u0010¡\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\b¢\u0003\u0010\u0006\"\u0005\b£\u0003\u0010\bR%\u0010¤\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\b¥\u0003\u0010\u0006\"\u0005\b¦\u0003\u0010\bR%\u0010§\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\b¨\u0003\u0010\u0006\"\u0005\b©\u0003\u0010\bR%\u0010ª\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\b«\u0003\u0010\u0006\"\u0005\b¬\u0003\u0010\bR%\u0010\u00ad\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\b®\u0003\u0010\u0006\"\u0005\b¯\u0003\u0010\bR%\u0010°\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\b±\u0003\u0010\u0006\"\u0005\b²\u0003\u0010\bR%\u0010³\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\b´\u0003\u0010\u0006\"\u0005\bµ\u0003\u0010\bR#\u0010¶\u0003\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b·\u0003\u0010¸\u0003\"\u0006\b¹\u0003\u0010º\u0003R)\u0010»\u0003\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¼\u0003\u0010\u0011\"\u0005\b½\u0003\u0010\u0013R%\u0010¾\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\b¿\u0003\u0010\u0006\"\u0005\bÀ\u0003\u0010\bR%\u0010Á\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\bÂ\u0003\u0010\u0006\"\u0005\bÃ\u0003\u0010\bR%\u0010Ä\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\bÅ\u0003\u0010\u0006\"\u0005\bÆ\u0003\u0010\bR%\u0010Ç\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\bÈ\u0003\u0010\u0006\"\u0005\bÉ\u0003\u0010\bR%\u0010Ê\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\bË\u0003\u0010\u0006\"\u0005\bÌ\u0003\u0010\bR#\u0010Í\u0003\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÎ\u0003\u0010¸\u0003\"\u0006\bÏ\u0003\u0010º\u0003R$\u0010Ð\u0003\u001a\u00030Ñ\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÒ\u0003\u0010Ó\u0003\"\u0006\bÔ\u0003\u0010Õ\u0003R%\u0010Ö\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\b×\u0003\u0010\u0006\"\u0005\bØ\u0003\u0010\bR)\u0010Ù\u0003\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÚ\u0003\u0010\u0011\"\u0005\bÛ\u0003\u0010\u0013R!\u0010Ü\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÝ\u0003\u0010=\"\u0005\bÞ\u0003\u0010?R%\u0010ß\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\bà\u0003\u0010\u0006\"\u0005\bá\u0003\u0010\bR%\u0010â\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010\t\u001a\u0005\bã\u0003\u0010\u0006\"\u0005\bä\u0003\u0010\bR)\u0010å\u0003\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bæ\u0003\u0010\u0011\"\u0005\bç\u0003\u0010\u0013R'\u0010è\u0003\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bé\u0003\u0010\u0011\"\u0005\bê\u0003\u0010\u0013R!\u0010ë\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bì\u0003\u0010=\"\u0005\bí\u0003\u0010?¨\u0006î\u0003"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/settings/CommonConfig;", "", "()V", "annieFlowEnableUrlSessionId", "", "getAnnieFlowEnableUrlSessionId", "()Ljava/lang/Boolean;", "setAnnieFlowEnableUrlSessionId", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "annieXFixActivityDynamicProps", "getAnnieXFixActivityDynamicProps", "setAnnieXFixActivityDynamicProps", "annieXFlowBlackList", "", "", "getAnnieXFlowBlackList", "()Ljava/util/List;", "setAnnieXFlowBlackList", "(Ljava/util/List;)V", "annieXFlowCacheSize", "", "getAnnieXFlowCacheSize", "()Ljava/lang/Integer;", "setAnnieXFlowCacheSize", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "annieXFlowReleaseInternal", "getAnnieXFlowReleaseInternal", "setAnnieXFlowReleaseInternal", "annieXFlowWhiteList", "getAnnieXFlowWhiteList", "setAnnieXFlowWhiteList", "annieXLatchWhiteSchema", "getAnnieXLatchWhiteSchema", "annieXLiteBlackList", "getAnnieXLiteBlackList", "setAnnieXLiteBlackList", "annieXLiteExtraJSBFix", "getAnnieXLiteExtraJSBFix", "setAnnieXLiteExtraJSBFix", "annieXLitePageFixCloseAfterOpenInternal", "getAnnieXLitePageFixCloseAfterOpenInternal", "setAnnieXLitePageFixCloseAfterOpenInternal", "annieXLitePageFixCloseAfterOpenSuccessInternal", "getAnnieXLitePageFixCloseAfterOpenSuccessInternal", "setAnnieXLitePageFixCloseAfterOpenSuccessInternal", "annieXLiteWhiteList", "getAnnieXLiteWhiteList", "setAnnieXLiteWhiteList", "annieXLiveJSB2InstanceLimit", "getAnnieXLiveJSB2InstanceLimit", "setAnnieXLiveJSB2InstanceLimit", "annieXLiveTokenParamAdaptionList", "getAnnieXLiveTokenParamAdaptionList", "setAnnieXLiveTokenParamAdaptionList", "annieXStreamPrefetchChunkSize", "getAnnieXStreamPrefetchChunkSize", "setAnnieXStreamPrefetchChunkSize", "annieXWebcastPadFoldPopupHeightSwitch", "getAnnieXWebcastPadFoldPopupHeightSwitch", "()Z", "setAnnieXWebcastPadFoldPopupHeightSwitch", "(Z)V", "attachEngineToUiThread", "getAttachEngineToUiThread", "setAttachEngineToUiThread", "bridgeAuthRecoveryConfig", "Lcom/bytedance/ies/bullet/service/base/settings/BridgeAuthRecoveryConfig;", "getBridgeAuthRecoveryConfig", "()Lcom/bytedance/ies/bullet/service/base/settings/BridgeAuthRecoveryConfig;", "setBridgeAuthRecoveryConfig", "(Lcom/bytedance/ies/bullet/service/base/settings/BridgeAuthRecoveryConfig;)V", "bridgeExecute", "Lcom/bytedance/ies/bullet/service/base/settings/BridgeExecute;", "getBridgeExecute", "()Lcom/bytedance/ies/bullet/service/base/settings/BridgeExecute;", "setBridgeExecute", "(Lcom/bytedance/ies/bullet/service/base/settings/BridgeExecute;)V", "createLynxViewFromEngine", "getCreateLynxViewFromEngine", "setCreateLynxViewFromEngine", "disableActivityInfoRecord", "getDisableActivityInfoRecord", "setDisableActivityInfoRecord", "disableAddSessionId", "getDisableAddSessionId", "setDisableAddSessionId", "disableAnnieXPopupPadAdapter", "getDisableAnnieXPopupPadAdapter", "setDisableAnnieXPopupPadAdapter", "disableBridgeContainerLeak", "getDisableBridgeContainerLeak", "setDisableBridgeContainerLeak", "disableInvisibleViewMonitor", "getDisableInvisibleViewMonitor", "setDisableInvisibleViewMonitor", "disablePopupPadAdapter", "getDisablePopupPadAdapter", "setDisablePopupPadAdapter", "disablePopupStatusBarParams", "getDisablePopupStatusBarParams", "setDisablePopupStatusBarParams", "disableTouchOutsizeA11yFocus", "getDisableTouchOutsizeA11yFocus", "setDisableTouchOutsizeA11yFocus", "dropALogSwitch", "getDropALogSwitch", "setDropALogSwitch", "enableAnnieXBulletFallback", "getEnableAnnieXBulletFallback", "setEnableAnnieXBulletFallback", "enableAnnieXCardFixedLynxGroup", "getEnableAnnieXCardFixedLynxGroup", "setEnableAnnieXCardFixedLynxGroup", "enableAnnieXDialogHideAbleFix", "getEnableAnnieXDialogHideAbleFix", "setEnableAnnieXDialogHideAbleFix", "enableAnnieXDialogNestedScrollFix", "getEnableAnnieXDialogNestedScrollFix", "setEnableAnnieXDialogNestedScrollFix", "enableAnnieXEndToEndReport", "getEnableAnnieXEndToEndReport", "setEnableAnnieXEndToEndReport", "enableAnnieXFixDownloadWorkerJSByCDN", "getEnableAnnieXFixDownloadWorkerJSByCDN", "setEnableAnnieXFixDownloadWorkerJSByCDN", "enableAnnieXFlowPage", "getEnableAnnieXFlowPage", "setEnableAnnieXFlowPage", "enableAnnieXFlowPopup", "getEnableAnnieXFlowPopup", "setEnableAnnieXFlowPopup", "enableAnnieXFlowSwitchWhiteList", "getEnableAnnieXFlowSwitchWhiteList", "setEnableAnnieXFlowSwitchWhiteList", "enableAnnieXIgnoreJSB2Failure", "getEnableAnnieXIgnoreJSB2Failure", "setEnableAnnieXIgnoreJSB2Failure", "enableAnnieXJsbParamInNumberAdapterFix", "getEnableAnnieXJsbParamInNumberAdapterFix", "setEnableAnnieXJsbParamInNumberAdapterFix", "enableAnnieXLitePage", "getEnableAnnieXLitePage", "setEnableAnnieXLitePage", "enableAnnieXLitePageClose", "getEnableAnnieXLitePageClose", "setEnableAnnieXLitePageClose", "enableAnnieXLiveBcmChainFix", "getEnableAnnieXLiveBcmChainFix", "setEnableAnnieXLiveBcmChainFix", "enableAnnieXLiveCompactMode", "getEnableAnnieXLiveCompactMode", "setEnableAnnieXLiveCompactMode", "enableAnnieXLiveDialogClickMaskCloseFix", "getEnableAnnieXLiveDialogClickMaskCloseFix", "setEnableAnnieXLiveDialogClickMaskCloseFix", "enableAnnieXLiveJSBCodeFix", "getEnableAnnieXLiveJSBCodeFix", "setEnableAnnieXLiveJSBCodeFix", "enableAnnieXLiveLynxInitDataFix", "getEnableAnnieXLiveLynxInitDataFix", "setEnableAnnieXLiveLynxInitDataFix", "enableAnnieXLiveMethodFactoryFix", "getEnableAnnieXLiveMethodFactoryFix", "setEnableAnnieXLiveMethodFactoryFix", "enableAnnieXLiveMethodFactoryMapFix", "getEnableAnnieXLiveMethodFactoryMapFix", "setEnableAnnieXLiveMethodFactoryMapFix", "enableAnnieXLiveTypeSchemaFieldFix", "getEnableAnnieXLiveTypeSchemaFieldFix", "setEnableAnnieXLiveTypeSchemaFieldFix", "enableAnnieXLoadEngineExpFix", "getEnableAnnieXLoadEngineExpFix", "setEnableAnnieXLoadEngineExpFix", "enableAnnieXOrientationEvent", "getEnableAnnieXOrientationEvent", "setEnableAnnieXOrientationEvent", "enableAnnieXPadAdapterGravityFix", "getEnableAnnieXPadAdapterGravityFix", "setEnableAnnieXPadAdapterGravityFix", "enableAnnieXPadOrFoldPopupHeightFix", "getEnableAnnieXPadOrFoldPopupHeightFix", "setEnableAnnieXPadOrFoldPopupHeightFix", "enableAnnieXPageSoftInputModeDefault", "getEnableAnnieXPageSoftInputModeDefault", "setEnableAnnieXPageSoftInputModeDefault", "enableAnnieXPopupLoopMeasureFix", "getEnableAnnieXPopupLoopMeasureFix", "setEnableAnnieXPopupLoopMeasureFix", "enableAnnieXRealScreenSizeFix", "getEnableAnnieXRealScreenSizeFix", "setEnableAnnieXRealScreenSizeFix", "enableAnnieXUrlParamFix", "getEnableAnnieXUrlParamFix", "setEnableAnnieXUrlParamFix", "enableAnnieXWebKitKeyboardFix", "getEnableAnnieXWebKitKeyboardFix", "setEnableAnnieXWebKitKeyboardFix", "enableAnnieXWebcastInitDataThreadOpt", "getEnableAnnieXWebcastInitDataThreadOpt", "setEnableAnnieXWebcastInitDataThreadOpt", "enableAnnieXWebcastWebPopupSoftInputAdapter", "getEnableAnnieXWebcastWebPopupSoftInputAdapter", "setEnableAnnieXWebcastWebPopupSoftInputAdapter", "enableAnnieXWorkerMd5Check", "getEnableAnnieXWorkerMd5Check", "setEnableAnnieXWorkerMd5Check", "enableAnnieXWorkerTaskInitImmediately", "getEnableAnnieXWorkerTaskInitImmediately", "setEnableAnnieXWorkerTaskInitImmediately", "enableAnnieXWorkerTaskInitOnce", "getEnableAnnieXWorkerTaskInitOnce", "setEnableAnnieXWorkerTaskInitOnce", "enableAnniexFlowCancelFix", "getEnableAnniexFlowCancelFix", "setEnableAnniexFlowCancelFix", "enableBridgeCanRunInBackgroundFix", "getEnableBridgeCanRunInBackgroundFix", "setEnableBridgeCanRunInBackgroundFix", "enableBridgePreInit", "getEnableBridgePreInit", "setEnableBridgePreInit", "enableBridgeProviderRelease", "getEnableBridgeProviderRelease", "setEnableBridgeProviderRelease", "enableBridgeReleaseCode", "getEnableBridgeReleaseCode", "setEnableBridgeReleaseCode", "enableBulletContextRelease", "getEnableBulletContextRelease", "setEnableBulletContextRelease", "enableBulletPopupActivity", "getEnableBulletPopupActivity", "enableBulletPrerenderCallMonitor", "getEnableBulletPrerenderCallMonitor", "setEnableBulletPrerenderCallMonitor", "enableBulletPrerenderLynxPropsFix", "getEnableBulletPrerenderLynxPropsFix", "setEnableBulletPrerenderLynxPropsFix", "enableCardAppendPropsFix", "getEnableCardAppendPropsFix", "setEnableCardAppendPropsFix", "enableCardBidParamRegister", "getEnableCardBidParamRegister", "setEnableCardBidParamRegister", "enableCardBuilderPropsFix", "getEnableCardBuilderPropsFix", "setEnableCardBuilderPropsFix", "enableChangeLynxUrl", "getEnableChangeLynxUrl", "setEnableChangeLynxUrl", "enableClearTopEventNewUrlFix", "getEnableClearTopEventNewUrlFix", "setEnableClearTopEventNewUrlFix", "enableContextFreeLifeCycleFix", "getEnableContextFreeLifeCycleFix", "setEnableContextFreeLifeCycleFix", "enableCopyDataBugfix", "getEnableCopyDataBugfix", "setEnableCopyDataBugfix", "enableDevicePropsRollBack", "getEnableDevicePropsRollBack", "setEnableDevicePropsRollBack", "enableDialogRestoreInstanceState", "getEnableDialogRestoreInstanceState", "setEnableDialogRestoreInstanceState", "enableDpToPxRoundToIntFix", "getEnableDpToPxRoundToIntFix", "setEnableDpToPxRoundToIntFix", "enableDynamicLoadV8", "getEnableDynamicLoadV8", "setEnableDynamicLoadV8", "enableECStatefulMethodsFragmentSceneFix", "getEnableECStatefulMethodsFragmentSceneFix", "setEnableECStatefulMethodsFragmentSceneFix", "enableFixDestroyWithOutForestRelease", "getEnableFixDestroyWithOutForestRelease", "setEnableFixDestroyWithOutForestRelease", "enableFixDialogDestroy", "getEnableFixDialogDestroy", "setEnableFixDialogDestroy", "enableFixNeedOutAnimation", "getEnableFixNeedOutAnimation", "setEnableFixNeedOutAnimation", "enableFixedLynxGroup", "getEnableFixedLynxGroup", "setEnableFixedLynxGroup", "enableFlowPageAnnieInitFix", "getEnableFlowPageAnnieInitFix", "setEnableFlowPageAnnieInitFix", "enableFlowPageCloseFix", "getEnableFlowPageCloseFix", "setEnableFlowPageCloseFix", "enableFlowPageContextFix", "getEnableFlowPageContextFix", "setEnableFlowPageContextFix", "enableFlowUpdateContext", "getEnableFlowUpdateContext", "setEnableFlowUpdateContext", "enableForceBindBulletPopupService", "getEnableForceBindBulletPopupService", "setEnableForceBindBulletPopupService", "enableHybridMultiCustomReport", "getEnableHybridMultiCustomReport", "setEnableHybridMultiCustomReport", "enableIpadAdapter", "getEnableIpadAdapter", "setEnableIpadAdapter", "enableLitePageBidBehaviorOpt", "getEnableLitePageBidBehaviorOpt", "setEnableLitePageBidBehaviorOpt", "enableLitePageBidExpand", "getEnableLitePageBidExpand", "setEnableLitePageBidExpand", "enableLitePageBidOpt", "getEnableLitePageBidOpt", "setEnableLitePageBidOpt", "enableLitePageBridgeFix", "getEnableLitePageBridgeFix", "setEnableLitePageBridgeFix", "enableLitePageBusinessBehavior", "getEnableLitePageBusinessBehavior", "setEnableLitePageBusinessBehavior", "enableLitePageLiveInitFix", "getEnableLitePageLiveInitFix", "setEnableLitePageLiveInitFix", "enableLiveMethodFactoryRegisterMonitor", "getEnableLiveMethodFactoryRegisterMonitor", "setEnableLiveMethodFactoryRegisterMonitor", "enableLoadFailedOnUIThread", "getEnableLoadFailedOnUIThread", "setEnableLoadFailedOnUIThread", "enableLynx100ErrorFix", "getEnableLynx100ErrorFix", "setEnableLynx100ErrorFix", "enableLynxAnimax", "getEnableLynxAnimax", "setEnableLynxAnimax", "enableLynxCardLifeCycleFix", "getEnableLynxCardLifeCycleFix", "setEnableLynxCardLifeCycleFix", "enableLynxCardPrefetchWithBid", "getEnableLynxCardPrefetchWithBid", "setEnableLynxCardPrefetchWithBid", "enableLynxViewBuilderParamsFix", "getEnableLynxViewBuilderParamsFix", "setEnableLynxViewBuilderParamsFix", "enableOrientationGPFix", "getEnableOrientationGPFix", "setEnableOrientationGPFix", "enablePadAdapterChannelStyle", "getEnablePadAdapterChannelStyle", "setEnablePadAdapterChannelStyle", "enablePadAdapterUniformStyle", "getEnablePadAdapterUniformStyle", "setEnablePadAdapterUniformStyle", "enablePadUpdateFrameBottomFix", "getEnablePadUpdateFrameBottomFix", "setEnablePadUpdateFrameBottomFix", "enablePiaGlobalProps", "getEnablePiaGlobalProps", "setEnablePiaGlobalProps", "enablePopupSizeChange", "getEnablePopupSizeChange", "setEnablePopupSizeChange", "enablePrefetchDataGlobalProps", "getEnablePrefetchDataGlobalProps", "setEnablePrefetchDataGlobalProps", "enablePrefetchNetworkParams", "getEnablePrefetchNetworkParams", "setEnablePrefetchNetworkParams", "enablePrefetchUpdateContainerType", "getEnablePrefetchUpdateContainerType", "setEnablePrefetchUpdateContainerType", "enablePreloadBeforeLoad", "getEnablePreloadBeforeLoad", "setEnablePreloadBeforeLoad", "enableRemoveSamePageFix", "getEnableRemoveSamePageFix", "setEnableRemoveSamePageFix", "enableSLMonitorJSBErrorParams", "getEnableSLMonitorJSBErrorParams", "setEnableSLMonitorJSBErrorParams", "enableSafeAreaHeight", "getEnableSafeAreaHeight", "setEnableSafeAreaHeight", "enableSchemaNotParseLoop", "getEnableSchemaNotParseLoop", "setEnableSchemaNotParseLoop", "enableToutiaoGlobalPropsInject", "getEnableToutiaoGlobalPropsInject", "setEnableToutiaoGlobalPropsInject", "enableViewAttachStack", "getEnableViewAttachStack", "setEnableViewAttachStack", "enableWebKitViewUpdateGlobalProps", "getEnableWebKitViewUpdateGlobalProps", "setEnableWebKitViewUpdateGlobalProps", "enableWebcastLitePageGlobalPropsFix", "getEnableWebcastLitePageGlobalPropsFix", "setEnableWebcastLitePageGlobalPropsFix", "enableXBridgeParamProxyEnhancement", "getEnableXBridgeParamProxyEnhancement", "setEnableXBridgeParamProxyEnhancement", "enableXUploadImageUriFix", "getEnableXUploadImageUriFix", "setEnableXUploadImageUriFix", "enable_worker_event_reset", "getEnable_worker_event_reset", "setEnable_worker_event_reset", "extraLocationPermissionJudge", "getExtraLocationPermissionJudge", "setExtraLocationPermissionJudge", "fixAnnieResourceLoad", "getFixAnnieResourceLoad", "setFixAnnieResourceLoad", "fixBridgeStorage", "getFixBridgeStorage", "setFixBridgeStorage", "fixJsonLong2Double", "getFixJsonLong2Double", "setFixJsonLong2Double", "fixLynxKitViewLeak", "getFixLynxKitViewLeak", "setFixLynxKitViewLeak", "fixLynxUrlOfHdt", "getFixLynxUrlOfHdt", "setFixLynxUrlOfHdt", "fixMultiMediaQuery", "getFixMultiMediaQuery", "setFixMultiMediaQuery", "fixPiaWorkerStorageJSB", "getFixPiaWorkerStorageJSB", "setFixPiaWorkerStorageJSB", "fixPrefetchQueryObject", "getFixPrefetchQueryObject", "setFixPrefetchQueryObject", "hybridLoggerLevel", "getHybridLoggerLevel", "()I", "setHybridLoggerLevel", "(I)V", "ignoreHttpStatusCode", "getIgnoreHttpStatusCode", "setIgnoreHttpStatusCode", "latchSkipAuth", "getLatchSkipAuth", "setLatchSkipAuth", "latchSkipBpea", "getLatchSkipBpea", "setLatchSkipBpea", "lokiJsbLogDropSwitch", "getLokiJsbLogDropSwitch", "setLokiJsbLogDropSwitch", "lokiJsbOptSwitch", "getLokiJsbOptSwitch", "setLokiJsbOptSwitch", "lynxCdnCacheHttpUrl", "getLynxCdnCacheHttpUrl", "setLynxCdnCacheHttpUrl", "lynxEngineCacheNumber", "getLynxEngineCacheNumber", "setLynxEngineCacheNumber", "lynxEngineExpireTime", "", "getLynxEngineExpireTime", "()J", "setLynxEngineExpireTime", "(J)V", "mixJsbOptSwitch", "getMixJsbOptSwitch", "setMixJsbOptSwitch", "orientationOnLayoutChangeBlackList", "getOrientationOnLayoutChangeBlackList", "setOrientationOnLayoutChangeBlackList", "schemaIgnoreCachePolicyEnable", "getSchemaIgnoreCachePolicyEnable", "setSchemaIgnoreCachePolicyEnable", "switchBridgeDownloadToDownloader", "getSwitchBridgeDownloadToDownloader", "setSwitchBridgeDownloadToDownloader", "useRealSizeForScreenSizeInGlobalProps", "getUseRealSizeForScreenSizeInGlobalProps", "setUseRealSizeForScreenSizeInGlobalProps", "webForceDeeplinkUrls", "getWebForceDeeplinkUrls", "setWebForceDeeplinkUrls", "xOpenWhiteSchemas", "getXOpenWhiteSchemas", "setXOpenWhiteSchemas", "xSaveDataURLBroadcastWithFilePath", "getXSaveDataURLBroadcastWithFilePath", "setXSaveDataURLBroadcastWithFilePath", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class CommonConfig {

    @SerializedName("anniex_flow_enable_url_session")
    private Boolean annieFlowEnableUrlSessionId;

    @SerializedName("anniex_flow_black_list")
    private List<String> annieXFlowBlackList;

    @SerializedName("anniex_flow_cache_size")
    private Integer annieXFlowCacheSize;

    @SerializedName("anniex_flow_release_internal")
    private Integer annieXFlowReleaseInternal;

    @SerializedName("anniex_flow_white_list")
    private List<String> annieXFlowWhiteList;

    @SerializedName("anniex_lite_black_list")
    private List<String> annieXLiteBlackList;

    @SerializedName("anniex_lite_extra_jsb_fix")
    private Boolean annieXLiteExtraJSBFix;

    @SerializedName("anniex_lite_page_fix_close_after_open_internal")
    private Integer annieXLitePageFixCloseAfterOpenInternal;

    @SerializedName("anniex_lite_page_fix_close_after_open_success_internal")
    private Integer annieXLitePageFixCloseAfterOpenSuccessInternal;

    @SerializedName("anniex_lite_white_list")
    private List<String> annieXLiteWhiteList;

    @SerializedName("anniex_live_jsb2_instance_limit")
    private Integer annieXLiveJSB2InstanceLimit;

    @SerializedName("anniex_live_token_param_adaption_list")
    private List<String> annieXLiveTokenParamAdaptionList;

    @SerializedName("anniex_stream_prefetch_chunk_size")
    private Integer annieXStreamPrefetchChunkSize;

    @SerializedName("anniex_webcast_pad_fold_popup_height_switch")
    private boolean annieXWebcastPadFoldPopupHeightSwitch;

    @SerializedName("bridge_async_execute")
    private BridgeExecute bridgeExecute;

    @SerializedName("create_lynxView_from_engine")
    private boolean createLynxViewFromEngine;

    @SerializedName("disable_anniex_popup_pad_adapter")
    private Boolean disableAnnieXPopupPadAdapter;

    @SerializedName("disable_popup_status_bar_params")
    private Boolean disablePopupStatusBarParams;

    @SerializedName("disable_anniex_dialog_a11y_focus")
    private Boolean disableTouchOutsizeA11yFocus;

    @SerializedName("enable_anniex_bullet_fallback")
    private Boolean enableAnnieXBulletFallback;

    @SerializedName("enable_anniex_dialog_hideable_fix")
    private Boolean enableAnnieXDialogHideAbleFix;

    @SerializedName("enable_anniex_dialog_nested_scroll_fix")
    private Boolean enableAnnieXDialogNestedScrollFix;

    @SerializedName("enable_anniex_end_to_end_report")
    private boolean enableAnnieXEndToEndReport;

    @SerializedName("enable_anniex_fix_download_worker_js_by_cdn")
    private boolean enableAnnieXFixDownloadWorkerJSByCDN;

    @SerializedName("enable_anniex_ignore_jsb2_failure")
    private Boolean enableAnnieXIgnoreJSB2Failure;

    @SerializedName("enable_anniex_jsb_param_in_number_adapter_fix")
    private Boolean enableAnnieXJsbParamInNumberAdapterFix;

    @SerializedName("enable_anniex_lite_page_close")
    private Boolean enableAnnieXLitePageClose;

    @SerializedName("enable_anniex_live_bcm_chain_fix")
    private Boolean enableAnnieXLiveBcmChainFix;

    @SerializedName("enable_anniex_live_dialog_click_mask_close_fix")
    private Boolean enableAnnieXLiveDialogClickMaskCloseFix;

    @SerializedName("enable_anniex_live_jsb_code_fix")
    private Boolean enableAnnieXLiveJSBCodeFix;

    @SerializedName("enable_anniex_live_lynx_initdata_fix")
    private Boolean enableAnnieXLiveLynxInitDataFix;

    @SerializedName("enable_anniex_live_method_factory_fix")
    private Boolean enableAnnieXLiveMethodFactoryFix;

    @SerializedName("enable_anniex_live_method_factory_map_fix")
    private Boolean enableAnnieXLiveMethodFactoryMapFix;

    @SerializedName("enable_anniex_live_type_schema_field_fix")
    private Boolean enableAnnieXLiveTypeSchemaFieldFix;

    @SerializedName("enable_anniex_load_engine_exp_fix")
    private boolean enableAnnieXLoadEngineExpFix;

    @SerializedName("enable_anniex_orientation_event")
    private Boolean enableAnnieXOrientationEvent;

    @SerializedName("enable_anniex_pad_adapter_gravity_fix")
    private Boolean enableAnnieXPadAdapterGravityFix;

    @SerializedName("enable_anniex_pad_or_fold_popup_height_fix")
    private Boolean enableAnnieXPadOrFoldPopupHeightFix;

    @SerializedName("enable_anniex_page_soft_input_mode_default")
    private Boolean enableAnnieXPageSoftInputModeDefault;

    @SerializedName("enable_anniex_popup_loop_measure_fix")
    private Boolean enableAnnieXPopupLoopMeasureFix;

    @SerializedName("enable_anniex_real_screen_size_fix")
    private Boolean enableAnnieXRealScreenSizeFix;

    @SerializedName("enable_anniex_url_param_fix")
    private Boolean enableAnnieXUrlParamFix;

    @SerializedName("enable_anniex_web_kit_keyboard_fix")
    private Boolean enableAnnieXWebKitKeyboardFix;

    @SerializedName("enable_anniex_webcast_initdata_thread_opt")
    private Boolean enableAnnieXWebcastInitDataThreadOpt;

    @SerializedName("enable_anniex_webcast_web_popup_softinput_adapter")
    private Boolean enableAnnieXWebcastWebPopupSoftInputAdapter;

    @SerializedName("enable_anniex_worker_md5_check")
    private boolean enableAnnieXWorkerMd5Check;

    @SerializedName("enable_anniex_worker_task_page_init_immediately")
    private boolean enableAnnieXWorkerTaskInitImmediately;

    @SerializedName("enable_anniex_worker_task_init_once")
    private boolean enableAnnieXWorkerTaskInitOnce;

    @SerializedName("enable_anniex_flow_cancel_fix")
    private Boolean enableAnniexFlowCancelFix;

    @SerializedName("enable_bridge_can_run_in_background_fix")
    private Boolean enableBridgeCanRunInBackgroundFix;

    @SerializedName("enable_dp_to_px_round_to_int_fix")
    private Boolean enableDpToPxRoundToIntFix;

    @SerializedName("enable_ec_stateful_methods_fragment_scene_fix")
    private Boolean enableECStatefulMethodsFragmentSceneFix;

    @SerializedName("enable_fix_dialog_destroy")
    private Boolean enableFixDialogDestroy;

    @SerializedName("enable_fix_need_out_animation")
    private Boolean enableFixNeedOutAnimation;

    @SerializedName("enable_flow_page_annie_init_fix")
    private Boolean enableFlowPageAnnieInitFix;

    @SerializedName("enable_flow_page_close_fix")
    private Boolean enableFlowPageCloseFix;

    @SerializedName("enable_flow_page_context_fix")
    private Boolean enableFlowPageContextFix;

    @SerializedName("enable_flow_update_context")
    private Boolean enableFlowUpdateContext;

    @SerializedName("enable_force_bind_bullet_popup_service")
    private Boolean enableForceBindBulletPopupService;

    @SerializedName("enable_hybrid_multi_custom_report")
    private Boolean enableHybridMultiCustomReport;

    @SerializedName("enable_lite_page_bid_behavior_opt")
    private Boolean enableLitePageBidBehaviorOpt;

    @SerializedName("enable_lite_page_bid_expand")
    private Boolean enableLitePageBidExpand;

    @SerializedName("enable_lite_page_bid_opt")
    private Boolean enableLitePageBidOpt;

    @SerializedName("enable_lite_page_bridge_fix")
    private Boolean enableLitePageBridgeFix;

    @SerializedName("enable_lite_page_business_behavior")
    private Boolean enableLitePageBusinessBehavior;

    @SerializedName("enable_lite_page_live_init_fix")
    private Boolean enableLitePageLiveInitFix;

    @SerializedName("enable_live_method_factory_register_monitor")
    private Boolean enableLiveMethodFactoryRegisterMonitor;

    @SerializedName("enable_lynx_card_prefetch_with_bid")
    private Boolean enableLynxCardPrefetchWithBid;

    @SerializedName("enable_lynxview_builder_params_fix")
    private Boolean enableLynxViewBuilderParamsFix;

    @SerializedName("enable_orientation_global_props_fix")
    private Boolean enableOrientationGPFix;

    @SerializedName("enable_pad_adapter_channel_style")
    private Boolean enablePadAdapterChannelStyle;

    @SerializedName("enable_pad_adapter_uniform_style")
    private Boolean enablePadAdapterUniformStyle;

    @SerializedName("enable_pad_update_frame_bottom_fix")
    private Boolean enablePadUpdateFrameBottomFix;

    @SerializedName("enable_slmonitor_jsb_error_params")
    private Boolean enableSLMonitorJSBErrorParams;

    @SerializedName("enable_safe_area_height")
    private Boolean enableSafeAreaHeight;

    @SerializedName("enable_toutiao_globalprops_inject")
    private Boolean enableToutiaoGlobalPropsInject;

    @SerializedName("enable_view_attach_stack")
    private boolean enableViewAttachStack;

    @SerializedName("enable_webkitview_update_globalprops")
    private Boolean enableWebKitViewUpdateGlobalProps;

    @SerializedName("enable_xbridge_param_proxy_enhancement")
    private Boolean enableXBridgeParamProxyEnhancement;

    @SerializedName("enable_worker_event_reset")
    private Boolean enable_worker_event_reset;

    @SerializedName("fix_prefetch_query_object")
    private Boolean fixPrefetchQueryObject;

    @SerializedName("ignore_http_status_code")
    private List<Integer> ignoreHttpStatusCode;

    @SerializedName("orientation_on_layout_change_blacklist")
    private List<String> orientationOnLayoutChangeBlackList;

    @SerializedName("schema_ignore_cache_policy")
    private boolean schemaIgnoreCachePolicyEnable;

    @SerializedName("switch_bridge_download_to_downloader")
    private Boolean switchBridgeDownloadToDownloader;

    @SerializedName("bridge_auth_recovery")
    private BridgeAuthRecoveryConfig bridgeAuthRecoveryConfig = new BridgeAuthRecoveryConfig();

    @SerializedName("enable_ipad_adapter")
    private Boolean enableIpadAdapter = true;

    @SerializedName("enable_popup_size_change")
    private Boolean enablePopupSizeChange = true;

    @SerializedName("drop_alog")
    private Boolean dropALogSwitch = false;

    @SerializedName("enable_pia_globalProps")
    private Boolean enablePiaGlobalProps = true;

    @SerializedName("lynx_engine_expire_time")
    private long lynxEngineExpireTime = 15000;

    @SerializedName("lynx_engine_cache_number")
    private int lynxEngineCacheNumber = 5;

    @SerializedName("anniex_latch_white_schema")
    private final List<String> annieXLatchWhiteSchema = CollectionsKt.emptyList();

    @SerializedName("enable_webcast_lite_page_global_props_fix")
    private Boolean enableWebcastLitePageGlobalPropsFix = true;

    @SerializedName("attach_engine_to_ui_thread")
    private Boolean attachEngineToUiThread = true;

    @SerializedName("enable_prefetch_network_params")
    private Boolean enablePrefetchNetworkParams = true;

    @SerializedName("enable_bullet_popup_activity")
    private final boolean enableBulletPopupActivity = true;

    @SerializedName("web_force_deeplink_urls")
    private List<String> webForceDeeplinkUrls = CollectionsKt.emptyList();

    @SerializedName("disable_add_session_id")
    private Boolean disableAddSessionId = false;

    @SerializedName("enable_fixed_lynx_group")
    private Boolean enableFixedLynxGroup = true;

    @SerializedName("disable_invisible_view_monitor")
    private Boolean disableInvisibleViewMonitor = false;

    @SerializedName("fix_bridge_storage")
    private Boolean fixBridgeStorage = true;

    @SerializedName("fix_multi_media_query")
    private Boolean fixMultiMediaQuery = true;

    @SerializedName("enable_change_lynx_url")
    private Boolean enableChangeLynxUrl = true;

    @SerializedName("extra_location_permission_judge")
    private Boolean extraLocationPermissionJudge = true;

    @SerializedName("lynx_cdn_cache_http_url")
    private Boolean lynxCdnCacheHttpUrl = true;

    @SerializedName("use_real_size_for_screen_size_in_global_props")
    private Boolean useRealSizeForScreenSizeInGlobalProps = true;

    @SerializedName("x_open_white_schemas")
    private List<String> xOpenWhiteSchemas = CollectionsKt.listOf(new String[]{"sslocal://lynxview", "sslocal://webview", "sslocal://lynxview_popup", "sslocal://webview_popup", "aweme://lynxview", "aweme://webview", "aweme://lynxview_popup", "aweme://webview_popup", "bullet://bullet", "sslocal://flower/lynxview", "sslocal://flower/webview", "sslocal://polaris/lynxview", "sslocal://polaris/webview", "sslocal://polaris/lynx", "sslocal://polaris/lynx_page", "sslocal://polaris/lynx_popup", "sslocal://polaris/lynxview_popup", "sslocal://polaris/webview", "sslocal://polaris/webview_popup", "sslocal://polaris/proxy"});

    @SerializedName("x_save_data_url_broadcast_with_file_path")
    private boolean xSaveDataURLBroadcastWithFilePath = true;

    @SerializedName("hybrid_logger_level")
    private int hybridLoggerLevel = 4;

    @SerializedName("enable_bullet_context_release")
    private boolean enableBulletContextRelease = true;

    @SerializedName("disable_bridge_container_leak")
    private Boolean disableBridgeContainerLeak = false;

    @SerializedName("disable_activity_info_record_opt")
    private Boolean disableActivityInfoRecord = false;

    @SerializedName("enable_preload_before_load")
    private Boolean enablePreloadBeforeLoad = true;

    @SerializedName("enable_dynamic_load_v8")
    private Boolean enableDynamicLoadV8 = true;

    @SerializedName("latch_skip_bpea")
    private Boolean latchSkipBpea = true;

    @SerializedName("latch_skip_auth")
    private Boolean latchSkipAuth = true;

    @SerializedName("disable_popup_pad_adapter")
    private boolean disablePopupPadAdapter = true;

    @SerializedName("mix_jsb_opt_switch")
    private Boolean mixJsbOptSwitch = true;

    @SerializedName("annie_x_fix_activity_dynamic_props")
    private Boolean annieXFixActivityDynamicProps = true;

    @SerializedName("loki_jsb_opt_switch")
    private Boolean lokiJsbOptSwitch = true;

    @SerializedName("loki_jsb_log_drop_switch")
    private Boolean lokiJsbLogDropSwitch = true;

    @SerializedName("enable_bridge_provider_release")
    private Boolean enableBridgeProviderRelease = true;

    @SerializedName("fix_json_long_2_double")
    private Boolean fixJsonLong2Double = true;

    @SerializedName("fix_annie_resource_load")
    private Boolean fixAnnieResourceLoad = true;

    @SerializedName("fix_lynx_url_of_hdt")
    private Boolean fixLynxUrlOfHdt = true;

    @SerializedName("fix_pia_worker_storage_jsb")
    private Boolean fixPiaWorkerStorageJSB = true;

    @SerializedName("enable_bridge_pre_init")
    private Boolean enableBridgePreInit = false;

    @SerializedName("enable_bridge_release_code")
    private Boolean enableBridgeReleaseCode = true;

    @SerializedName("fix_lynx_kit_view_leak")
    private Boolean fixLynxKitViewLeak = true;

    @SerializedName("enable_anniex_live_compact_mode")
    private Boolean enableAnnieXLiveCompactMode = true;

    @SerializedName("enable_copy_data_bugfix")
    private Boolean enableCopyDataBugfix = true;

    @SerializedName("enable_load_failed_on_ui_thread")
    private Boolean enableLoadFailedOnUIThread = true;

    @SerializedName("enable_device_props_roll_back")
    private Boolean enableDevicePropsRollBack = true;

    @SerializedName("enable_card_bid_param_register")
    private Boolean enableCardBidParamRegister = true;

    @SerializedName("enable_card_append_props_fix")
    private Boolean enableCardAppendPropsFix = true;

    @SerializedName("enable_xupload_image_uri_fix")
    private Boolean enableXUploadImageUriFix = true;

    @SerializedName("enable_lynx_card_life_cycle_fix")
    private Boolean enableLynxCardLifeCycleFix = true;

    @SerializedName("enable_context_free_life_cycle_fix")
    private Boolean enableContextFreeLifeCycleFix = true;

    @SerializedName("enable_lynx_100_error_fix")
    private Boolean enableLynx100ErrorFix = true;

    @SerializedName("enable_prefetch_update_containertype")
    private Boolean enablePrefetchUpdateContainerType = true;

    @SerializedName("enable_bullet_prerender_lynx_props_fix")
    private Boolean enableBulletPrerenderLynxPropsFix = true;

    @SerializedName("enable_bullet_prerender_call_monitor")
    private Boolean enableBulletPrerenderCallMonitor = true;

    @SerializedName("enable_fix_destroy_without_forest_release")
    private Boolean enableFixDestroyWithOutForestRelease = true;

    @SerializedName("enable_schema_not_parse_loop")
    private boolean enableSchemaNotParseLoop = true;

    @SerializedName("enable_lynx_animax")
    private boolean enableLynxAnimax = true;

    @SerializedName("enable_card_builder_props_fix")
    private boolean enableCardBuilderPropsFix = true;

    @SerializedName("enable_anniex_card_fixed_lynx_group")
    private Boolean enableAnnieXCardFixedLynxGroup = true;

    @SerializedName("enable_clear_top_event_new_url_fix")
    private Boolean enableClearTopEventNewUrlFix = true;

    @SerializedName("enable_remove_same_page_fix")
    private Boolean enableRemoveSamePageFix = true;

    @SerializedName("enable_dialog_restore_instance_state")
    private Boolean enableDialogRestoreInstanceState = true;

    @SerializedName("enable_prefetch_data_global_props")
    private Boolean enablePrefetchDataGlobalProps = true;

    @SerializedName("enable_anniex_lite_page")
    private Boolean enableAnnieXLitePage = true;

    @SerializedName("enable_anniex_flow_page")
    private Boolean enableAnnieXFlowPage = true;

    @SerializedName("enable_annie_x_flow_popup")
    private Boolean enableAnnieXFlowPopup = true;

    @SerializedName("enable_annie_x_flow_switch_white_list")
    private List<String> enableAnnieXFlowSwitchWhiteList = CollectionsKt.emptyList();

    public CommonConfig() {
        Integer valueOf = Integer.valueOf(PatchException.ERR_LOAD_SO_MD5_NOT_MATCH);
        this.annieXLitePageFixCloseAfterOpenInternal = valueOf;
        this.annieXLitePageFixCloseAfterOpenSuccessInternal = valueOf;
        this.annieXStreamPrefetchChunkSize = 102400;
        this.enableLynxCardPrefetchWithBid = true;
        this.disablePopupStatusBarParams = true;
        this.enableAnnieXPageSoftInputModeDefault = true;
        this.enableAnnieXLiveDialogClickMaskCloseFix = true;
        this.annieXLiveTokenParamAdaptionList = CollectionsKt.listOf(new String[]{"/webcast/mono/h5/open_basic_h5_saas/template/pages/re_clock_in_popup.html", "/webcast/mono/lynx/revenue_gift_panel_saas/pages/task_touch/template.js"});
        this.enableECStatefulMethodsFragmentSceneFix = true;
        this.enableAnnieXPopupLoopMeasureFix = true;
        this.enableAnnieXLiveMethodFactoryFix = true;
        this.enableAnnieXLiveMethodFactoryMapFix = true;
        this.enableLiveMethodFactoryRegisterMonitor = true;
        this.enableAnnieXWebKitKeyboardFix = true;
        this.enableSafeAreaHeight = false;
        this.enableAnnieXLiveBcmChainFix = true;
        this.annieXFlowCacheSize = 3;
        this.annieXFlowReleaseInternal = 10000;
        this.annieFlowEnableUrlSessionId = true;
        this.enableSLMonitorJSBErrorParams = true;
        this.annieXFlowBlackList = CollectionsKt.emptyList();
        this.annieXLiteBlackList = CollectionsKt.emptyList();
        this.annieXFlowWhiteList = CollectionsKt.emptyList();
        this.annieXLiteWhiteList = CollectionsKt.emptyList();
        this.annieXLiteExtraJSBFix = true;
        this.enable_worker_event_reset = true;
        this.enableAnnieXEndToEndReport = true;
        this.enableAnnieXLoadEngineExpFix = true;
        this.enableAnnieXWorkerMd5Check = true;
        this.enableAnnieXFixDownloadWorkerJSByCDN = true;
        this.enableAnnieXWorkerTaskInitOnce = true;
        this.enableAnnieXWorkerTaskInitImmediately = true;
        this.enableViewAttachStack = true;
        this.enableBridgeCanRunInBackgroundFix = true;
        this.enableAnnieXDialogHideAbleFix = true;
        this.enableAnnieXDialogNestedScrollFix = true;
        this.disableTouchOutsizeA11yFocus = false;
        this.enableAnnieXPadAdapterGravityFix = true;
        this.enableAnnieXLiveTypeSchemaFieldFix = true;
        this.enableForceBindBulletPopupService = true;
        this.enableAnnieXWebcastWebPopupSoftInputAdapter = true;
        this.enableAnnieXWebcastInitDataThreadOpt = true;
        this.enableXBridgeParamProxyEnhancement = true;
        this.ignoreHttpStatusCode = CollectionsKt.listOf(412);
        this.switchBridgeDownloadToDownloader = true;
        this.enableFlowUpdateContext = true;
        this.annieXLiveJSB2InstanceLimit = 500;
        this.enableAnnieXRealScreenSizeFix = true;
        this.enableAnnieXJsbParamInNumberAdapterFix = true;
        this.enableWebKitViewUpdateGlobalProps = true;
        this.enableAnnieXOrientationEvent = true;
        this.enableLitePageBidExpand = true;
        this.enableFixNeedOutAnimation = true;
        this.enableAnnieXUrlParamFix = true;
        this.enableLitePageBidOpt = true;
        this.enableLitePageBidBehaviorOpt = true;
        this.enableLitePageBusinessBehavior = true;
        this.enableLitePageLiveInitFix = true;
        this.enableLitePageBridgeFix = true;
        this.enableFlowPageContextFix = true;
        this.enablePadUpdateFrameBottomFix = true;
        this.enableDpToPxRoundToIntFix = true;
        this.enablePadAdapterUniformStyle = true;
        this.enablePadAdapterChannelStyle = true;
        this.enableAnniexFlowCancelFix = true;
        this.enableAnnieXPadOrFoldPopupHeightFix = true;
        this.enableAnnieXIgnoreJSB2Failure = true;
        this.enableLynxViewBuilderParamsFix = true;
        this.fixPrefetchQueryObject = true;
        this.enableFlowPageCloseFix = true;
        this.enableFlowPageAnnieInitFix = true;
        this.enableOrientationGPFix = true;
        this.enableAnnieXLiveJSBCodeFix = true;
        this.disableAnnieXPopupPadAdapter = true;
        this.enableHybridMultiCustomReport = true;
        this.enableAnnieXLiveLynxInitDataFix = true;
        this.enableAnnieXLitePageClose = true;
        this.enableAnnieXBulletFallback = true;
        this.enableToutiaoGlobalPropsInject = true;
        this.enableFixDialogDestroy = true;
    }

    public final BridgeExecute getBridgeExecute() {
        return this.bridgeExecute;
    }

    public final void setBridgeExecute(BridgeExecute bridgeExecute) {
        this.bridgeExecute = bridgeExecute;
    }

    public final BridgeAuthRecoveryConfig getBridgeAuthRecoveryConfig() {
        return this.bridgeAuthRecoveryConfig;
    }

    public final void setBridgeAuthRecoveryConfig(BridgeAuthRecoveryConfig bridgeAuthRecoveryConfig) {
        this.bridgeAuthRecoveryConfig = bridgeAuthRecoveryConfig;
    }

    public final Boolean getEnableIpadAdapter() {
        return this.enableIpadAdapter;
    }

    public final void setEnableIpadAdapter(Boolean bool) {
        this.enableIpadAdapter = bool;
    }

    public final Boolean getEnablePopupSizeChange() {
        return this.enablePopupSizeChange;
    }

    public final void setEnablePopupSizeChange(Boolean bool) {
        this.enablePopupSizeChange = bool;
    }

    public final Boolean getDropALogSwitch() {
        return this.dropALogSwitch;
    }

    public final void setDropALogSwitch(Boolean bool) {
        this.dropALogSwitch = bool;
    }

    public final Boolean getEnablePiaGlobalProps() {
        return this.enablePiaGlobalProps;
    }

    public final void setEnablePiaGlobalProps(Boolean bool) {
        this.enablePiaGlobalProps = bool;
    }

    public final boolean getCreateLynxViewFromEngine() {
        return this.createLynxViewFromEngine;
    }

    public final void setCreateLynxViewFromEngine(boolean z) {
        this.createLynxViewFromEngine = z;
    }

    public final long getLynxEngineExpireTime() {
        return this.lynxEngineExpireTime;
    }

    public final void setLynxEngineExpireTime(long j) {
        this.lynxEngineExpireTime = j;
    }

    public final int getLynxEngineCacheNumber() {
        return this.lynxEngineCacheNumber;
    }

    public final void setLynxEngineCacheNumber(int i) {
        this.lynxEngineCacheNumber = i;
    }

    public final List<String> getAnnieXLatchWhiteSchema() {
        return this.annieXLatchWhiteSchema;
    }

    public final Boolean getEnableWebcastLitePageGlobalPropsFix() {
        return this.enableWebcastLitePageGlobalPropsFix;
    }

    public final void setEnableWebcastLitePageGlobalPropsFix(Boolean bool) {
        this.enableWebcastLitePageGlobalPropsFix = bool;
    }

    public final Boolean getAttachEngineToUiThread() {
        return this.attachEngineToUiThread;
    }

    public final void setAttachEngineToUiThread(Boolean bool) {
        this.attachEngineToUiThread = bool;
    }

    public final Boolean getEnablePrefetchNetworkParams() {
        return this.enablePrefetchNetworkParams;
    }

    public final void setEnablePrefetchNetworkParams(Boolean bool) {
        this.enablePrefetchNetworkParams = bool;
    }

    public final boolean getEnableBulletPopupActivity() {
        return this.enableBulletPopupActivity;
    }

    public final List<String> getWebForceDeeplinkUrls() {
        return this.webForceDeeplinkUrls;
    }

    public final void setWebForceDeeplinkUrls(List<String> list) {
        this.webForceDeeplinkUrls = list;
    }

    public final Boolean getDisableAddSessionId() {
        return this.disableAddSessionId;
    }

    public final void setDisableAddSessionId(Boolean bool) {
        this.disableAddSessionId = bool;
    }

    public final Boolean getEnableFixedLynxGroup() {
        return this.enableFixedLynxGroup;
    }

    public final void setEnableFixedLynxGroup(Boolean bool) {
        this.enableFixedLynxGroup = bool;
    }

    public final Boolean getDisableInvisibleViewMonitor() {
        return this.disableInvisibleViewMonitor;
    }

    public final void setDisableInvisibleViewMonitor(Boolean bool) {
        this.disableInvisibleViewMonitor = bool;
    }

    public final Boolean getFixBridgeStorage() {
        return this.fixBridgeStorage;
    }

    public final void setFixBridgeStorage(Boolean bool) {
        this.fixBridgeStorage = bool;
    }

    public final Boolean getFixMultiMediaQuery() {
        return this.fixMultiMediaQuery;
    }

    public final void setFixMultiMediaQuery(Boolean bool) {
        this.fixMultiMediaQuery = bool;
    }

    public final Boolean getEnableChangeLynxUrl() {
        return this.enableChangeLynxUrl;
    }

    public final void setEnableChangeLynxUrl(Boolean bool) {
        this.enableChangeLynxUrl = bool;
    }

    public final Boolean getExtraLocationPermissionJudge() {
        return this.extraLocationPermissionJudge;
    }

    public final void setExtraLocationPermissionJudge(Boolean bool) {
        this.extraLocationPermissionJudge = bool;
    }

    public final Boolean getLynxCdnCacheHttpUrl() {
        return this.lynxCdnCacheHttpUrl;
    }

    public final void setLynxCdnCacheHttpUrl(Boolean bool) {
        this.lynxCdnCacheHttpUrl = bool;
    }

    public final Boolean getUseRealSizeForScreenSizeInGlobalProps() {
        return this.useRealSizeForScreenSizeInGlobalProps;
    }

    public final void setUseRealSizeForScreenSizeInGlobalProps(Boolean bool) {
        this.useRealSizeForScreenSizeInGlobalProps = bool;
    }

    public final List<String> getXOpenWhiteSchemas() {
        return this.xOpenWhiteSchemas;
    }

    public final void setXOpenWhiteSchemas(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.xOpenWhiteSchemas = list;
    }

    public final boolean getXSaveDataURLBroadcastWithFilePath() {
        return this.xSaveDataURLBroadcastWithFilePath;
    }

    public final void setXSaveDataURLBroadcastWithFilePath(boolean z) {
        this.xSaveDataURLBroadcastWithFilePath = z;
    }

    public final int getHybridLoggerLevel() {
        return this.hybridLoggerLevel;
    }

    public final void setHybridLoggerLevel(int i) {
        this.hybridLoggerLevel = i;
    }

    public final boolean getSchemaIgnoreCachePolicyEnable() {
        return this.schemaIgnoreCachePolicyEnable;
    }

    public final void setSchemaIgnoreCachePolicyEnable(boolean z) {
        this.schemaIgnoreCachePolicyEnable = z;
    }

    public final boolean getEnableBulletContextRelease() {
        return this.enableBulletContextRelease;
    }

    public final void setEnableBulletContextRelease(boolean z) {
        this.enableBulletContextRelease = z;
    }

    public final Boolean getDisableBridgeContainerLeak() {
        return this.disableBridgeContainerLeak;
    }

    public final void setDisableBridgeContainerLeak(Boolean bool) {
        this.disableBridgeContainerLeak = bool;
    }

    public final Boolean getDisableActivityInfoRecord() {
        return this.disableActivityInfoRecord;
    }

    public final void setDisableActivityInfoRecord(Boolean bool) {
        this.disableActivityInfoRecord = bool;
    }

    public final Boolean getEnablePreloadBeforeLoad() {
        return this.enablePreloadBeforeLoad;
    }

    public final void setEnablePreloadBeforeLoad(Boolean bool) {
        this.enablePreloadBeforeLoad = bool;
    }

    public final Boolean getEnableDynamicLoadV8() {
        return this.enableDynamicLoadV8;
    }

    public final void setEnableDynamicLoadV8(Boolean bool) {
        this.enableDynamicLoadV8 = bool;
    }

    public final Boolean getLatchSkipBpea() {
        return this.latchSkipBpea;
    }

    public final void setLatchSkipBpea(Boolean bool) {
        this.latchSkipBpea = bool;
    }

    public final Boolean getLatchSkipAuth() {
        return this.latchSkipAuth;
    }

    public final void setLatchSkipAuth(Boolean bool) {
        this.latchSkipAuth = bool;
    }

    public final boolean getDisablePopupPadAdapter() {
        return this.disablePopupPadAdapter;
    }

    public final void setDisablePopupPadAdapter(boolean z) {
        this.disablePopupPadAdapter = z;
    }

    public final Boolean getMixJsbOptSwitch() {
        return this.mixJsbOptSwitch;
    }

    public final void setMixJsbOptSwitch(Boolean bool) {
        this.mixJsbOptSwitch = bool;
    }

    public final Boolean getAnnieXFixActivityDynamicProps() {
        return this.annieXFixActivityDynamicProps;
    }

    public final void setAnnieXFixActivityDynamicProps(Boolean bool) {
        this.annieXFixActivityDynamicProps = bool;
    }

    public final Boolean getLokiJsbOptSwitch() {
        return this.lokiJsbOptSwitch;
    }

    public final void setLokiJsbOptSwitch(Boolean bool) {
        this.lokiJsbOptSwitch = bool;
    }

    public final Boolean getLokiJsbLogDropSwitch() {
        return this.lokiJsbLogDropSwitch;
    }

    public final void setLokiJsbLogDropSwitch(Boolean bool) {
        this.lokiJsbLogDropSwitch = bool;
    }

    public final Boolean getEnableBridgeProviderRelease() {
        return this.enableBridgeProviderRelease;
    }

    public final void setEnableBridgeProviderRelease(Boolean bool) {
        this.enableBridgeProviderRelease = bool;
    }

    public final Boolean getFixJsonLong2Double() {
        return this.fixJsonLong2Double;
    }

    public final void setFixJsonLong2Double(Boolean bool) {
        this.fixJsonLong2Double = bool;
    }

    public final Boolean getFixAnnieResourceLoad() {
        return this.fixAnnieResourceLoad;
    }

    public final void setFixAnnieResourceLoad(Boolean bool) {
        this.fixAnnieResourceLoad = bool;
    }

    public final Boolean getFixLynxUrlOfHdt() {
        return this.fixLynxUrlOfHdt;
    }

    public final void setFixLynxUrlOfHdt(Boolean bool) {
        this.fixLynxUrlOfHdt = bool;
    }

    public final Boolean getFixPiaWorkerStorageJSB() {
        return this.fixPiaWorkerStorageJSB;
    }

    public final void setFixPiaWorkerStorageJSB(Boolean bool) {
        this.fixPiaWorkerStorageJSB = bool;
    }

    public final Boolean getEnableBridgePreInit() {
        return this.enableBridgePreInit;
    }

    public final void setEnableBridgePreInit(Boolean bool) {
        this.enableBridgePreInit = bool;
    }

    public final Boolean getEnableBridgeReleaseCode() {
        return this.enableBridgeReleaseCode;
    }

    public final void setEnableBridgeReleaseCode(Boolean bool) {
        this.enableBridgeReleaseCode = bool;
    }

    public final Boolean getFixLynxKitViewLeak() {
        return this.fixLynxKitViewLeak;
    }

    public final void setFixLynxKitViewLeak(Boolean bool) {
        this.fixLynxKitViewLeak = bool;
    }

    public final Boolean getEnableAnnieXLiveCompactMode() {
        return this.enableAnnieXLiveCompactMode;
    }

    public final void setEnableAnnieXLiveCompactMode(Boolean bool) {
        this.enableAnnieXLiveCompactMode = bool;
    }

    public final Boolean getEnableCopyDataBugfix() {
        return this.enableCopyDataBugfix;
    }

    public final void setEnableCopyDataBugfix(Boolean bool) {
        this.enableCopyDataBugfix = bool;
    }

    public final Boolean getEnableLoadFailedOnUIThread() {
        return this.enableLoadFailedOnUIThread;
    }

    public final void setEnableLoadFailedOnUIThread(Boolean bool) {
        this.enableLoadFailedOnUIThread = bool;
    }

    public final Boolean getEnableDevicePropsRollBack() {
        return this.enableDevicePropsRollBack;
    }

    public final void setEnableDevicePropsRollBack(Boolean bool) {
        this.enableDevicePropsRollBack = bool;
    }

    public final Boolean getEnableCardBidParamRegister() {
        return this.enableCardBidParamRegister;
    }

    public final void setEnableCardBidParamRegister(Boolean bool) {
        this.enableCardBidParamRegister = bool;
    }

    public final Boolean getEnableCardAppendPropsFix() {
        return this.enableCardAppendPropsFix;
    }

    public final void setEnableCardAppendPropsFix(Boolean bool) {
        this.enableCardAppendPropsFix = bool;
    }

    public final Boolean getEnableXUploadImageUriFix() {
        return this.enableXUploadImageUriFix;
    }

    public final void setEnableXUploadImageUriFix(Boolean bool) {
        this.enableXUploadImageUriFix = bool;
    }

    public final Boolean getEnableLynxCardLifeCycleFix() {
        return this.enableLynxCardLifeCycleFix;
    }

    public final void setEnableLynxCardLifeCycleFix(Boolean bool) {
        this.enableLynxCardLifeCycleFix = bool;
    }

    public final Boolean getEnableContextFreeLifeCycleFix() {
        return this.enableContextFreeLifeCycleFix;
    }

    public final void setEnableContextFreeLifeCycleFix(Boolean bool) {
        this.enableContextFreeLifeCycleFix = bool;
    }

    public final Boolean getEnableLynx100ErrorFix() {
        return this.enableLynx100ErrorFix;
    }

    public final void setEnableLynx100ErrorFix(Boolean bool) {
        this.enableLynx100ErrorFix = bool;
    }

    public final Boolean getEnablePrefetchUpdateContainerType() {
        return this.enablePrefetchUpdateContainerType;
    }

    public final void setEnablePrefetchUpdateContainerType(Boolean bool) {
        this.enablePrefetchUpdateContainerType = bool;
    }

    public final Boolean getEnableBulletPrerenderLynxPropsFix() {
        return this.enableBulletPrerenderLynxPropsFix;
    }

    public final void setEnableBulletPrerenderLynxPropsFix(Boolean bool) {
        this.enableBulletPrerenderLynxPropsFix = bool;
    }

    public final Boolean getEnableBulletPrerenderCallMonitor() {
        return this.enableBulletPrerenderCallMonitor;
    }

    public final void setEnableBulletPrerenderCallMonitor(Boolean bool) {
        this.enableBulletPrerenderCallMonitor = bool;
    }

    public final Boolean getEnableFixDestroyWithOutForestRelease() {
        return this.enableFixDestroyWithOutForestRelease;
    }

    public final void setEnableFixDestroyWithOutForestRelease(Boolean bool) {
        this.enableFixDestroyWithOutForestRelease = bool;
    }

    public final boolean getEnableSchemaNotParseLoop() {
        return this.enableSchemaNotParseLoop;
    }

    public final void setEnableSchemaNotParseLoop(boolean z) {
        this.enableSchemaNotParseLoop = z;
    }

    public final boolean getEnableLynxAnimax() {
        return this.enableLynxAnimax;
    }

    public final void setEnableLynxAnimax(boolean z) {
        this.enableLynxAnimax = z;
    }

    public final boolean getEnableCardBuilderPropsFix() {
        return this.enableCardBuilderPropsFix;
    }

    public final void setEnableCardBuilderPropsFix(boolean z) {
        this.enableCardBuilderPropsFix = z;
    }

    public final boolean getAnnieXWebcastPadFoldPopupHeightSwitch() {
        return this.annieXWebcastPadFoldPopupHeightSwitch;
    }

    public final void setAnnieXWebcastPadFoldPopupHeightSwitch(boolean z) {
        this.annieXWebcastPadFoldPopupHeightSwitch = z;
    }

    public final Boolean getEnableAnnieXCardFixedLynxGroup() {
        return this.enableAnnieXCardFixedLynxGroup;
    }

    public final void setEnableAnnieXCardFixedLynxGroup(Boolean bool) {
        this.enableAnnieXCardFixedLynxGroup = bool;
    }

    public final Boolean getEnableClearTopEventNewUrlFix() {
        return this.enableClearTopEventNewUrlFix;
    }

    public final void setEnableClearTopEventNewUrlFix(Boolean bool) {
        this.enableClearTopEventNewUrlFix = bool;
    }

    public final Boolean getEnableRemoveSamePageFix() {
        return this.enableRemoveSamePageFix;
    }

    public final void setEnableRemoveSamePageFix(Boolean bool) {
        this.enableRemoveSamePageFix = bool;
    }

    public final Boolean getEnableDialogRestoreInstanceState() {
        return this.enableDialogRestoreInstanceState;
    }

    public final void setEnableDialogRestoreInstanceState(Boolean bool) {
        this.enableDialogRestoreInstanceState = bool;
    }

    public final Boolean getEnablePrefetchDataGlobalProps() {
        return this.enablePrefetchDataGlobalProps;
    }

    public final void setEnablePrefetchDataGlobalProps(Boolean bool) {
        this.enablePrefetchDataGlobalProps = bool;
    }

    public final Boolean getEnableAnnieXLitePage() {
        return this.enableAnnieXLitePage;
    }

    public final void setEnableAnnieXLitePage(Boolean bool) {
        this.enableAnnieXLitePage = bool;
    }

    public final Boolean getEnableAnnieXFlowPage() {
        return this.enableAnnieXFlowPage;
    }

    public final void setEnableAnnieXFlowPage(Boolean bool) {
        this.enableAnnieXFlowPage = bool;
    }

    public final Boolean getEnableAnnieXFlowPopup() {
        return this.enableAnnieXFlowPopup;
    }

    public final void setEnableAnnieXFlowPopup(Boolean bool) {
        this.enableAnnieXFlowPopup = bool;
    }

    public final List<String> getEnableAnnieXFlowSwitchWhiteList() {
        return this.enableAnnieXFlowSwitchWhiteList;
    }

    public final void setEnableAnnieXFlowSwitchWhiteList(List<String> list) {
        this.enableAnnieXFlowSwitchWhiteList = list;
    }

    public final Integer getAnnieXLitePageFixCloseAfterOpenInternal() {
        return this.annieXLitePageFixCloseAfterOpenInternal;
    }

    public final void setAnnieXLitePageFixCloseAfterOpenInternal(Integer num) {
        this.annieXLitePageFixCloseAfterOpenInternal = num;
    }

    public final Integer getAnnieXLitePageFixCloseAfterOpenSuccessInternal() {
        return this.annieXLitePageFixCloseAfterOpenSuccessInternal;
    }

    public final void setAnnieXLitePageFixCloseAfterOpenSuccessInternal(Integer num) {
        this.annieXLitePageFixCloseAfterOpenSuccessInternal = num;
    }

    public final Integer getAnnieXStreamPrefetchChunkSize() {
        return this.annieXStreamPrefetchChunkSize;
    }

    public final void setAnnieXStreamPrefetchChunkSize(Integer num) {
        this.annieXStreamPrefetchChunkSize = num;
    }

    public final Boolean getEnableLynxCardPrefetchWithBid() {
        return this.enableLynxCardPrefetchWithBid;
    }

    public final void setEnableLynxCardPrefetchWithBid(Boolean bool) {
        this.enableLynxCardPrefetchWithBid = bool;
    }

    public final Boolean getDisablePopupStatusBarParams() {
        return this.disablePopupStatusBarParams;
    }

    public final void setDisablePopupStatusBarParams(Boolean bool) {
        this.disablePopupStatusBarParams = bool;
    }

    public final Boolean getEnableAnnieXPageSoftInputModeDefault() {
        return this.enableAnnieXPageSoftInputModeDefault;
    }

    public final void setEnableAnnieXPageSoftInputModeDefault(Boolean bool) {
        this.enableAnnieXPageSoftInputModeDefault = bool;
    }

    public final Boolean getEnableAnnieXLiveDialogClickMaskCloseFix() {
        return this.enableAnnieXLiveDialogClickMaskCloseFix;
    }

    public final void setEnableAnnieXLiveDialogClickMaskCloseFix(Boolean bool) {
        this.enableAnnieXLiveDialogClickMaskCloseFix = bool;
    }

    public final List<String> getAnnieXLiveTokenParamAdaptionList() {
        return this.annieXLiveTokenParamAdaptionList;
    }

    public final void setAnnieXLiveTokenParamAdaptionList(List<String> list) {
        this.annieXLiveTokenParamAdaptionList = list;
    }

    public final Boolean getEnableECStatefulMethodsFragmentSceneFix() {
        return this.enableECStatefulMethodsFragmentSceneFix;
    }

    public final void setEnableECStatefulMethodsFragmentSceneFix(Boolean bool) {
        this.enableECStatefulMethodsFragmentSceneFix = bool;
    }

    public final Boolean getEnableAnnieXPopupLoopMeasureFix() {
        return this.enableAnnieXPopupLoopMeasureFix;
    }

    public final void setEnableAnnieXPopupLoopMeasureFix(Boolean bool) {
        this.enableAnnieXPopupLoopMeasureFix = bool;
    }

    public final Boolean getEnableAnnieXLiveMethodFactoryFix() {
        return this.enableAnnieXLiveMethodFactoryFix;
    }

    public final void setEnableAnnieXLiveMethodFactoryFix(Boolean bool) {
        this.enableAnnieXLiveMethodFactoryFix = bool;
    }

    public final Boolean getEnableAnnieXLiveMethodFactoryMapFix() {
        return this.enableAnnieXLiveMethodFactoryMapFix;
    }

    public final void setEnableAnnieXLiveMethodFactoryMapFix(Boolean bool) {
        this.enableAnnieXLiveMethodFactoryMapFix = bool;
    }

    public final Boolean getEnableLiveMethodFactoryRegisterMonitor() {
        return this.enableLiveMethodFactoryRegisterMonitor;
    }

    public final void setEnableLiveMethodFactoryRegisterMonitor(Boolean bool) {
        this.enableLiveMethodFactoryRegisterMonitor = bool;
    }

    public final Boolean getEnableAnnieXWebKitKeyboardFix() {
        return this.enableAnnieXWebKitKeyboardFix;
    }

    public final void setEnableAnnieXWebKitKeyboardFix(Boolean bool) {
        this.enableAnnieXWebKitKeyboardFix = bool;
    }

    public final Boolean getEnableSafeAreaHeight() {
        return this.enableSafeAreaHeight;
    }

    public final void setEnableSafeAreaHeight(Boolean bool) {
        this.enableSafeAreaHeight = bool;
    }

    public final Boolean getEnableAnnieXLiveBcmChainFix() {
        return this.enableAnnieXLiveBcmChainFix;
    }

    public final void setEnableAnnieXLiveBcmChainFix(Boolean bool) {
        this.enableAnnieXLiveBcmChainFix = bool;
    }

    public final Integer getAnnieXFlowCacheSize() {
        return this.annieXFlowCacheSize;
    }

    public final void setAnnieXFlowCacheSize(Integer num) {
        this.annieXFlowCacheSize = num;
    }

    public final Integer getAnnieXFlowReleaseInternal() {
        return this.annieXFlowReleaseInternal;
    }

    public final void setAnnieXFlowReleaseInternal(Integer num) {
        this.annieXFlowReleaseInternal = num;
    }

    public final Boolean getAnnieFlowEnableUrlSessionId() {
        return this.annieFlowEnableUrlSessionId;
    }

    public final void setAnnieFlowEnableUrlSessionId(Boolean bool) {
        this.annieFlowEnableUrlSessionId = bool;
    }

    public final Boolean getEnableSLMonitorJSBErrorParams() {
        return this.enableSLMonitorJSBErrorParams;
    }

    public final void setEnableSLMonitorJSBErrorParams(Boolean bool) {
        this.enableSLMonitorJSBErrorParams = bool;
    }

    public final List<String> getAnnieXFlowBlackList() {
        return this.annieXFlowBlackList;
    }

    public final void setAnnieXFlowBlackList(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.annieXFlowBlackList = list;
    }

    public final List<String> getAnnieXLiteBlackList() {
        return this.annieXLiteBlackList;
    }

    public final void setAnnieXLiteBlackList(List<String> list) {
        this.annieXLiteBlackList = list;
    }

    public final List<String> getAnnieXFlowWhiteList() {
        return this.annieXFlowWhiteList;
    }

    public final void setAnnieXFlowWhiteList(List<String> list) {
        this.annieXFlowWhiteList = list;
    }

    public final List<String> getAnnieXLiteWhiteList() {
        return this.annieXLiteWhiteList;
    }

    public final void setAnnieXLiteWhiteList(List<String> list) {
        this.annieXLiteWhiteList = list;
    }

    public final Boolean getAnnieXLiteExtraJSBFix() {
        return this.annieXLiteExtraJSBFix;
    }

    public final void setAnnieXLiteExtraJSBFix(Boolean bool) {
        this.annieXLiteExtraJSBFix = bool;
    }

    public final Boolean getEnable_worker_event_reset() {
        return this.enable_worker_event_reset;
    }

    public final void setEnable_worker_event_reset(Boolean bool) {
        this.enable_worker_event_reset = bool;
    }

    public final boolean getEnableAnnieXEndToEndReport() {
        return this.enableAnnieXEndToEndReport;
    }

    public final void setEnableAnnieXEndToEndReport(boolean z) {
        this.enableAnnieXEndToEndReport = z;
    }

    public final boolean getEnableAnnieXLoadEngineExpFix() {
        return this.enableAnnieXLoadEngineExpFix;
    }

    public final void setEnableAnnieXLoadEngineExpFix(boolean z) {
        this.enableAnnieXLoadEngineExpFix = z;
    }

    public final boolean getEnableAnnieXWorkerMd5Check() {
        return this.enableAnnieXWorkerMd5Check;
    }

    public final void setEnableAnnieXWorkerMd5Check(boolean z) {
        this.enableAnnieXWorkerMd5Check = z;
    }

    public final boolean getEnableAnnieXFixDownloadWorkerJSByCDN() {
        return this.enableAnnieXFixDownloadWorkerJSByCDN;
    }

    public final void setEnableAnnieXFixDownloadWorkerJSByCDN(boolean z) {
        this.enableAnnieXFixDownloadWorkerJSByCDN = z;
    }

    public final boolean getEnableAnnieXWorkerTaskInitOnce() {
        return this.enableAnnieXWorkerTaskInitOnce;
    }

    public final void setEnableAnnieXWorkerTaskInitOnce(boolean z) {
        this.enableAnnieXWorkerTaskInitOnce = z;
    }

    public final boolean getEnableAnnieXWorkerTaskInitImmediately() {
        return this.enableAnnieXWorkerTaskInitImmediately;
    }

    public final void setEnableAnnieXWorkerTaskInitImmediately(boolean z) {
        this.enableAnnieXWorkerTaskInitImmediately = z;
    }

    public final boolean getEnableViewAttachStack() {
        return this.enableViewAttachStack;
    }

    public final void setEnableViewAttachStack(boolean z) {
        this.enableViewAttachStack = z;
    }

    public final Boolean getEnableBridgeCanRunInBackgroundFix() {
        return this.enableBridgeCanRunInBackgroundFix;
    }

    public final void setEnableBridgeCanRunInBackgroundFix(Boolean bool) {
        this.enableBridgeCanRunInBackgroundFix = bool;
    }

    public final Boolean getEnableAnnieXDialogHideAbleFix() {
        return this.enableAnnieXDialogHideAbleFix;
    }

    public final void setEnableAnnieXDialogHideAbleFix(Boolean bool) {
        this.enableAnnieXDialogHideAbleFix = bool;
    }

    public final Boolean getEnableAnnieXDialogNestedScrollFix() {
        return this.enableAnnieXDialogNestedScrollFix;
    }

    public final void setEnableAnnieXDialogNestedScrollFix(Boolean bool) {
        this.enableAnnieXDialogNestedScrollFix = bool;
    }

    public final Boolean getDisableTouchOutsizeA11yFocus() {
        return this.disableTouchOutsizeA11yFocus;
    }

    public final void setDisableTouchOutsizeA11yFocus(Boolean bool) {
        this.disableTouchOutsizeA11yFocus = bool;
    }

    public final Boolean getEnableAnnieXPadAdapterGravityFix() {
        return this.enableAnnieXPadAdapterGravityFix;
    }

    public final void setEnableAnnieXPadAdapterGravityFix(Boolean bool) {
        this.enableAnnieXPadAdapterGravityFix = bool;
    }

    public final Boolean getEnableAnnieXLiveTypeSchemaFieldFix() {
        return this.enableAnnieXLiveTypeSchemaFieldFix;
    }

    public final void setEnableAnnieXLiveTypeSchemaFieldFix(Boolean bool) {
        this.enableAnnieXLiveTypeSchemaFieldFix = bool;
    }

    public final Boolean getEnableForceBindBulletPopupService() {
        return this.enableForceBindBulletPopupService;
    }

    public final void setEnableForceBindBulletPopupService(Boolean bool) {
        this.enableForceBindBulletPopupService = bool;
    }

    public final Boolean getEnableAnnieXWebcastWebPopupSoftInputAdapter() {
        return this.enableAnnieXWebcastWebPopupSoftInputAdapter;
    }

    public final void setEnableAnnieXWebcastWebPopupSoftInputAdapter(Boolean bool) {
        this.enableAnnieXWebcastWebPopupSoftInputAdapter = bool;
    }

    public final Boolean getEnableAnnieXWebcastInitDataThreadOpt() {
        return this.enableAnnieXWebcastInitDataThreadOpt;
    }

    public final void setEnableAnnieXWebcastInitDataThreadOpt(Boolean bool) {
        this.enableAnnieXWebcastInitDataThreadOpt = bool;
    }

    public final Boolean getEnableXBridgeParamProxyEnhancement() {
        return this.enableXBridgeParamProxyEnhancement;
    }

    public final void setEnableXBridgeParamProxyEnhancement(Boolean bool) {
        this.enableXBridgeParamProxyEnhancement = bool;
    }

    public final List<Integer> getIgnoreHttpStatusCode() {
        return this.ignoreHttpStatusCode;
    }

    public final void setIgnoreHttpStatusCode(List<Integer> list) {
        this.ignoreHttpStatusCode = list;
    }

    public final Boolean getSwitchBridgeDownloadToDownloader() {
        return this.switchBridgeDownloadToDownloader;
    }

    public final void setSwitchBridgeDownloadToDownloader(Boolean bool) {
        this.switchBridgeDownloadToDownloader = bool;
    }

    public final Boolean getEnableFlowUpdateContext() {
        return this.enableFlowUpdateContext;
    }

    public final void setEnableFlowUpdateContext(Boolean bool) {
        this.enableFlowUpdateContext = bool;
    }

    public final Integer getAnnieXLiveJSB2InstanceLimit() {
        return this.annieXLiveJSB2InstanceLimit;
    }

    public final void setAnnieXLiveJSB2InstanceLimit(Integer num) {
        this.annieXLiveJSB2InstanceLimit = num;
    }

    public final Boolean getEnableAnnieXRealScreenSizeFix() {
        return this.enableAnnieXRealScreenSizeFix;
    }

    public final void setEnableAnnieXRealScreenSizeFix(Boolean bool) {
        this.enableAnnieXRealScreenSizeFix = bool;
    }

    public final Boolean getEnableAnnieXJsbParamInNumberAdapterFix() {
        return this.enableAnnieXJsbParamInNumberAdapterFix;
    }

    public final void setEnableAnnieXJsbParamInNumberAdapterFix(Boolean bool) {
        this.enableAnnieXJsbParamInNumberAdapterFix = bool;
    }

    public final Boolean getEnableWebKitViewUpdateGlobalProps() {
        return this.enableWebKitViewUpdateGlobalProps;
    }

    public final void setEnableWebKitViewUpdateGlobalProps(Boolean bool) {
        this.enableWebKitViewUpdateGlobalProps = bool;
    }

    public final List<String> getOrientationOnLayoutChangeBlackList() {
        return this.orientationOnLayoutChangeBlackList;
    }

    public final void setOrientationOnLayoutChangeBlackList(List<String> list) {
        this.orientationOnLayoutChangeBlackList = list;
    }

    public final Boolean getEnableAnnieXOrientationEvent() {
        return this.enableAnnieXOrientationEvent;
    }

    public final void setEnableAnnieXOrientationEvent(Boolean bool) {
        this.enableAnnieXOrientationEvent = bool;
    }

    public final Boolean getEnableLitePageBidExpand() {
        return this.enableLitePageBidExpand;
    }

    public final void setEnableLitePageBidExpand(Boolean bool) {
        this.enableLitePageBidExpand = bool;
    }

    public final Boolean getEnableFixNeedOutAnimation() {
        return this.enableFixNeedOutAnimation;
    }

    public final void setEnableFixNeedOutAnimation(Boolean bool) {
        this.enableFixNeedOutAnimation = bool;
    }

    public final Boolean getEnableAnnieXUrlParamFix() {
        return this.enableAnnieXUrlParamFix;
    }

    public final void setEnableAnnieXUrlParamFix(Boolean bool) {
        this.enableAnnieXUrlParamFix = bool;
    }

    public final Boolean getEnableLitePageBidOpt() {
        return this.enableLitePageBidOpt;
    }

    public final void setEnableLitePageBidOpt(Boolean bool) {
        this.enableLitePageBidOpt = bool;
    }

    public final Boolean getEnableLitePageBidBehaviorOpt() {
        return this.enableLitePageBidBehaviorOpt;
    }

    public final void setEnableLitePageBidBehaviorOpt(Boolean bool) {
        this.enableLitePageBidBehaviorOpt = bool;
    }

    public final Boolean getEnableLitePageBusinessBehavior() {
        return this.enableLitePageBusinessBehavior;
    }

    public final void setEnableLitePageBusinessBehavior(Boolean bool) {
        this.enableLitePageBusinessBehavior = bool;
    }

    public final Boolean getEnableLitePageLiveInitFix() {
        return this.enableLitePageLiveInitFix;
    }

    public final void setEnableLitePageLiveInitFix(Boolean bool) {
        this.enableLitePageLiveInitFix = bool;
    }

    public final Boolean getEnableLitePageBridgeFix() {
        return this.enableLitePageBridgeFix;
    }

    public final void setEnableLitePageBridgeFix(Boolean bool) {
        this.enableLitePageBridgeFix = bool;
    }

    public final Boolean getEnableFlowPageContextFix() {
        return this.enableFlowPageContextFix;
    }

    public final void setEnableFlowPageContextFix(Boolean bool) {
        this.enableFlowPageContextFix = bool;
    }

    public final Boolean getEnablePadUpdateFrameBottomFix() {
        return this.enablePadUpdateFrameBottomFix;
    }

    public final void setEnablePadUpdateFrameBottomFix(Boolean bool) {
        this.enablePadUpdateFrameBottomFix = bool;
    }

    public final Boolean getEnableDpToPxRoundToIntFix() {
        return this.enableDpToPxRoundToIntFix;
    }

    public final void setEnableDpToPxRoundToIntFix(Boolean bool) {
        this.enableDpToPxRoundToIntFix = bool;
    }

    public final Boolean getEnablePadAdapterUniformStyle() {
        return this.enablePadAdapterUniformStyle;
    }

    public final void setEnablePadAdapterUniformStyle(Boolean bool) {
        this.enablePadAdapterUniformStyle = bool;
    }

    public final Boolean getEnablePadAdapterChannelStyle() {
        return this.enablePadAdapterChannelStyle;
    }

    public final void setEnablePadAdapterChannelStyle(Boolean bool) {
        this.enablePadAdapterChannelStyle = bool;
    }

    public final Boolean getEnableAnniexFlowCancelFix() {
        return this.enableAnniexFlowCancelFix;
    }

    public final void setEnableAnniexFlowCancelFix(Boolean bool) {
        this.enableAnniexFlowCancelFix = bool;
    }

    public final Boolean getEnableAnnieXPadOrFoldPopupHeightFix() {
        return this.enableAnnieXPadOrFoldPopupHeightFix;
    }

    public final void setEnableAnnieXPadOrFoldPopupHeightFix(Boolean bool) {
        this.enableAnnieXPadOrFoldPopupHeightFix = bool;
    }

    public final Boolean getEnableAnnieXIgnoreJSB2Failure() {
        return this.enableAnnieXIgnoreJSB2Failure;
    }

    public final void setEnableAnnieXIgnoreJSB2Failure(Boolean bool) {
        this.enableAnnieXIgnoreJSB2Failure = bool;
    }

    public final Boolean getEnableLynxViewBuilderParamsFix() {
        return this.enableLynxViewBuilderParamsFix;
    }

    public final void setEnableLynxViewBuilderParamsFix(Boolean bool) {
        this.enableLynxViewBuilderParamsFix = bool;
    }

    public final Boolean getFixPrefetchQueryObject() {
        return this.fixPrefetchQueryObject;
    }

    public final void setFixPrefetchQueryObject(Boolean bool) {
        this.fixPrefetchQueryObject = bool;
    }

    public final Boolean getEnableFlowPageCloseFix() {
        return this.enableFlowPageCloseFix;
    }

    public final void setEnableFlowPageCloseFix(Boolean bool) {
        this.enableFlowPageCloseFix = bool;
    }

    public final Boolean getEnableFlowPageAnnieInitFix() {
        return this.enableFlowPageAnnieInitFix;
    }

    public final void setEnableFlowPageAnnieInitFix(Boolean bool) {
        this.enableFlowPageAnnieInitFix = bool;
    }

    public final Boolean getEnableOrientationGPFix() {
        return this.enableOrientationGPFix;
    }

    public final void setEnableOrientationGPFix(Boolean bool) {
        this.enableOrientationGPFix = bool;
    }

    public final Boolean getEnableAnnieXLiveJSBCodeFix() {
        return this.enableAnnieXLiveJSBCodeFix;
    }

    public final void setEnableAnnieXLiveJSBCodeFix(Boolean bool) {
        this.enableAnnieXLiveJSBCodeFix = bool;
    }

    public final Boolean getDisableAnnieXPopupPadAdapter() {
        return this.disableAnnieXPopupPadAdapter;
    }

    public final void setDisableAnnieXPopupPadAdapter(Boolean bool) {
        this.disableAnnieXPopupPadAdapter = bool;
    }

    public final Boolean getEnableHybridMultiCustomReport() {
        return this.enableHybridMultiCustomReport;
    }

    public final void setEnableHybridMultiCustomReport(Boolean bool) {
        this.enableHybridMultiCustomReport = bool;
    }

    public final Boolean getEnableAnnieXLiveLynxInitDataFix() {
        return this.enableAnnieXLiveLynxInitDataFix;
    }

    public final void setEnableAnnieXLiveLynxInitDataFix(Boolean bool) {
        this.enableAnnieXLiveLynxInitDataFix = bool;
    }

    public final Boolean getEnableAnnieXLitePageClose() {
        return this.enableAnnieXLitePageClose;
    }

    public final void setEnableAnnieXLitePageClose(Boolean bool) {
        this.enableAnnieXLitePageClose = bool;
    }

    public final Boolean getEnableAnnieXBulletFallback() {
        return this.enableAnnieXBulletFallback;
    }

    public final void setEnableAnnieXBulletFallback(Boolean bool) {
        this.enableAnnieXBulletFallback = bool;
    }

    public final Boolean getEnableToutiaoGlobalPropsInject() {
        return this.enableToutiaoGlobalPropsInject;
    }

    public final void setEnableToutiaoGlobalPropsInject(Boolean bool) {
        this.enableToutiaoGlobalPropsInject = bool;
    }

    public final Boolean getEnableFixDialogDestroy() {
        return this.enableFixDialogDestroy;
    }

    public final void setEnableFixDialogDestroy(Boolean bool) {
        this.enableFixDialogDestroy = bool;
    }
}
