package com.bytedance.trae.im.model;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.push.helper.MultiProcessPushMessageDatabaseHelper;
import com.google.gson.annotations.SerializedName;
import com.ss.ttm.player.C;
import com.ss.ttm.utils.AVLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatMessage.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\bx\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bó\u0003\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b.\u0010/J\u000b\u0010[\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010a\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u00108J\u000b\u0010b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010f\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010?J\u0010\u0010g\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u00108J\u000b\u0010h\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010i\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010j\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010k\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010l\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010m\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010o\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010p\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010q\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010s\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010u\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010v\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010w\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010?J\u000b\u0010x\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010y\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010z\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010{\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010|\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010}\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010~\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010?J\u000b\u0010\u007f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010?J\u0011\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010?J\u0011\u0010\u0082\u0001\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u00108J\u0011\u0010\u0083\u0001\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u00108Jü\u0003\u0010\u0084\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0003\u0010\u0085\u0001J\u0015\u0010\u0086\u0001\u001a\u00020\u00102\t\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u000b\u0010\u0088\u0001\u001a\u00030\u0089\u0001HÖ\u0001J\n\u0010\u008a\u0001\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u00101R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u00101R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u00101R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u00101R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u00101R\u001a\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00109\u001a\u0004\b7\u00108R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u00101R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u00101R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u00101R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u00101R\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010@\u001a\u0004\b>\u0010?R\u001a\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00109\u001a\u0004\bA\u00108R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u00101R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bC\u00101R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u00101R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bE\u00101R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u00101R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u00101R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bH\u00101R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bI\u00101R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bJ\u00101R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bK\u00101R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bL\u00101R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bM\u00101R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bN\u00101R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bO\u00101R\u0018\u0010 \u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bP\u00101R\u001a\u0010!\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010@\u001a\u0004\bQ\u0010?R\u0018\u0010\"\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bR\u00101R\u0018\u0010#\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bS\u00101R\u0018\u0010$\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bT\u00101R\u0018\u0010%\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bU\u00101R\u0018\u0010&\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bV\u00101R\u0018\u0010'\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bW\u00101R\u001a\u0010(\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010@\u001a\u0004\b(\u0010?R\u0018\u0010)\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bX\u00101R\u001a\u0010*\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010@\u001a\u0004\b*\u0010?R\u001a\u0010+\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010@\u001a\u0004\b+\u0010?R\u001a\u0010,\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00109\u001a\u0004\bY\u00108R\u001a\u0010-\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00109\u001a\u0004\bZ\u00108¨\u0006\u008b\u0001"}, d2 = {"Lcom/bytedance/trae/im/model/ChatMessage;", "", "chatSessionId", "", "messageId", "turnId", "status", "messageType", "role", "messageIndex", "", "content", "replyToMessageId", "userMessageContext", "error", "revertible", "", "versionCode", "references", "contextMetadata", "searchReferenceData", "docReferences", "agentType", "agentId", "agentName", "agentAvatarId", "traceId", "createdAt", "createdAtMs", "feeUsage", "maxFeeUsage", "notifications", "modelSmartSelectionMeta", "fromAppendMsg", "shallowMementoType", "chatProcessVersion", "tokenUsage", "contextUsage", "agentProcessSupport", "fastRequestSavings", "isWorktree", "query", "isArchived", "isUserCanceled", "chatStartTime", "chatEndTime", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Long;)V", "getChatSessionId", "()Ljava/lang/String;", "getMessageId", "getTurnId", "getStatus", "getMessageType", "getRole", "getMessageIndex", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getContent", "getReplyToMessageId", "getUserMessageContext", "getError", "getRevertible", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getVersionCode", "getReferences", "getContextMetadata", "getSearchReferenceData", "getDocReferences", "getAgentType", "getAgentId", "getAgentName", "getAgentAvatarId", "getTraceId", "getCreatedAt", "getCreatedAtMs", "getFeeUsage", "getMaxFeeUsage", "getNotifications", "getModelSmartSelectionMeta", "getFromAppendMsg", "getShallowMementoType", "getChatProcessVersion", "getTokenUsage", "getContextUsage", "getAgentProcessSupport", "getFastRequestSavings", "getQuery", "getChatStartTime", "getChatEndTime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component40", "component41", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Long;)Lcom/bytedance/trae/im/model/ChatMessage;", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ChatMessage {

    @SerializedName("agent_avatar_id")
    private final String agentAvatarId;

    @SerializedName("agent_id")
    private final String agentId;

    @SerializedName("agent_name")
    private final String agentName;

    @SerializedName("agent_process_support")
    private final String agentProcessSupport;

    @SerializedName("agent_type")
    private final String agentType;

    @SerializedName("chat_end_time")
    private final Long chatEndTime;

    @SerializedName("chat_process_version")
    private final String chatProcessVersion;

    @SerializedName("chat_session_id")
    private final String chatSessionId;

    @SerializedName("chat_start_time")
    private final Long chatStartTime;

    @SerializedName("content")
    private final String content;

    @SerializedName("context_metadata")
    private final String contextMetadata;

    @SerializedName("context_usage")
    private final String contextUsage;

    @SerializedName("created_at")
    private final String createdAt;

    @SerializedName("created_at_ms")
    private final String createdAtMs;

    @SerializedName("doc_references")
    private final String docReferences;

    @SerializedName("error")
    private final String error;

    @SerializedName("fast_request_savings")
    private final String fastRequestSavings;

    @SerializedName("fee_usage")
    private final String feeUsage;

    @SerializedName("from_append_msg")
    private final Boolean fromAppendMsg;

    @SerializedName("is_archived")
    private final Boolean isArchived;

    @SerializedName("is_user_canceled")
    private final Boolean isUserCanceled;

    @SerializedName("is_worktree")
    private final Boolean isWorktree;

    @SerializedName("max_fee_usage")
    private final String maxFeeUsage;

    @SerializedName(MultiProcessPushMessageDatabaseHelper.COL_MESSAGE_ID)
    private final String messageId;

    @SerializedName("message_index")
    private final Long messageIndex;

    @SerializedName("message_type")
    private final String messageType;

    @SerializedName("model_smart_selection_meta")
    private final String modelSmartSelectionMeta;

    @SerializedName("notifications")
    private final String notifications;

    @SerializedName("query")
    private final String query;

    @SerializedName("references")
    private final String references;

    @SerializedName("reply_to_message_id")
    private final String replyToMessageId;

    @SerializedName("revertible")
    private final Boolean revertible;

    @SerializedName("role")
    private final String role;

    @SerializedName("search_reference_data")
    private final String searchReferenceData;

    @SerializedName("shallow_memento_type")
    private final String shallowMementoType;

    @SerializedName("status")
    private final String status;

    @SerializedName("token_usage")
    private final String tokenUsage;

    @SerializedName("trace_id")
    private final String traceId;

    @SerializedName("turn_id")
    private final String turnId;

    @SerializedName("user_message_context")
    private final String userMessageContext;

    @SerializedName("version_code")
    private final Long versionCode;

    public ChatMessage() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 511, null);
    }

    /* renamed from: component1, reason: from getter */
    public final String getChatSessionId() {
        return this.chatSessionId;
    }

    /* renamed from: component10, reason: from getter */
    public final String getUserMessageContext() {
        return this.userMessageContext;
    }

    /* renamed from: component11, reason: from getter */
    public final String getError() {
        return this.error;
    }

    /* renamed from: component12, reason: from getter */
    public final Boolean getRevertible() {
        return this.revertible;
    }

    /* renamed from: component13, reason: from getter */
    public final Long getVersionCode() {
        return this.versionCode;
    }

    /* renamed from: component14, reason: from getter */
    public final String getReferences() {
        return this.references;
    }

    /* renamed from: component15, reason: from getter */
    public final String getContextMetadata() {
        return this.contextMetadata;
    }

    /* renamed from: component16, reason: from getter */
    public final String getSearchReferenceData() {
        return this.searchReferenceData;
    }

    /* renamed from: component17, reason: from getter */
    public final String getDocReferences() {
        return this.docReferences;
    }

    /* renamed from: component18, reason: from getter */
    public final String getAgentType() {
        return this.agentType;
    }

    /* renamed from: component19, reason: from getter */
    public final String getAgentId() {
        return this.agentId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getMessageId() {
        return this.messageId;
    }

    /* renamed from: component20, reason: from getter */
    public final String getAgentName() {
        return this.agentName;
    }

    /* renamed from: component21, reason: from getter */
    public final String getAgentAvatarId() {
        return this.agentAvatarId;
    }

    /* renamed from: component22, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    /* renamed from: component23, reason: from getter */
    public final String getCreatedAt() {
        return this.createdAt;
    }

    /* renamed from: component24, reason: from getter */
    public final String getCreatedAtMs() {
        return this.createdAtMs;
    }

    /* renamed from: component25, reason: from getter */
    public final String getFeeUsage() {
        return this.feeUsage;
    }

    /* renamed from: component26, reason: from getter */
    public final String getMaxFeeUsage() {
        return this.maxFeeUsage;
    }

    /* renamed from: component27, reason: from getter */
    public final String getNotifications() {
        return this.notifications;
    }

    /* renamed from: component28, reason: from getter */
    public final String getModelSmartSelectionMeta() {
        return this.modelSmartSelectionMeta;
    }

    /* renamed from: component29, reason: from getter */
    public final Boolean getFromAppendMsg() {
        return this.fromAppendMsg;
    }

    /* renamed from: component3, reason: from getter */
    public final String getTurnId() {
        return this.turnId;
    }

    /* renamed from: component30, reason: from getter */
    public final String getShallowMementoType() {
        return this.shallowMementoType;
    }

    /* renamed from: component31, reason: from getter */
    public final String getChatProcessVersion() {
        return this.chatProcessVersion;
    }

    /* renamed from: component32, reason: from getter */
    public final String getTokenUsage() {
        return this.tokenUsage;
    }

    /* renamed from: component33, reason: from getter */
    public final String getContextUsage() {
        return this.contextUsage;
    }

    /* renamed from: component34, reason: from getter */
    public final String getAgentProcessSupport() {
        return this.agentProcessSupport;
    }

    /* renamed from: component35, reason: from getter */
    public final String getFastRequestSavings() {
        return this.fastRequestSavings;
    }

    /* renamed from: component36, reason: from getter */
    public final Boolean getIsWorktree() {
        return this.isWorktree;
    }

    /* renamed from: component37, reason: from getter */
    public final String getQuery() {
        return this.query;
    }

    /* renamed from: component38, reason: from getter */
    public final Boolean getIsArchived() {
        return this.isArchived;
    }

    /* renamed from: component39, reason: from getter */
    public final Boolean getIsUserCanceled() {
        return this.isUserCanceled;
    }

    /* renamed from: component4, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: component40, reason: from getter */
    public final Long getChatStartTime() {
        return this.chatStartTime;
    }

    /* renamed from: component41, reason: from getter */
    public final Long getChatEndTime() {
        return this.chatEndTime;
    }

    /* renamed from: component5, reason: from getter */
    public final String getMessageType() {
        return this.messageType;
    }

    /* renamed from: component6, reason: from getter */
    public final String getRole() {
        return this.role;
    }

    /* renamed from: component7, reason: from getter */
    public final Long getMessageIndex() {
        return this.messageIndex;
    }

    /* renamed from: component8, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* renamed from: component9, reason: from getter */
    public final String getReplyToMessageId() {
        return this.replyToMessageId;
    }

    public final ChatMessage copy(String chatSessionId, String messageId, String turnId, String status, String messageType, String role, Long messageIndex, String content, String replyToMessageId, String userMessageContext, String error, Boolean revertible, Long versionCode, String references, String contextMetadata, String searchReferenceData, String docReferences, String agentType, String agentId, String agentName, String agentAvatarId, String traceId, String createdAt, String createdAtMs, String feeUsage, String maxFeeUsage, String notifications, String modelSmartSelectionMeta, Boolean fromAppendMsg, String shallowMementoType, String chatProcessVersion, String tokenUsage, String contextUsage, String agentProcessSupport, String fastRequestSavings, Boolean isWorktree, String query, Boolean isArchived, Boolean isUserCanceled, Long chatStartTime, Long chatEndTime) {
        return new ChatMessage(chatSessionId, messageId, turnId, status, messageType, role, messageIndex, content, replyToMessageId, userMessageContext, error, revertible, versionCode, references, contextMetadata, searchReferenceData, docReferences, agentType, agentId, agentName, agentAvatarId, traceId, createdAt, createdAtMs, feeUsage, maxFeeUsage, notifications, modelSmartSelectionMeta, fromAppendMsg, shallowMementoType, chatProcessVersion, tokenUsage, contextUsage, agentProcessSupport, fastRequestSavings, isWorktree, query, isArchived, isUserCanceled, chatStartTime, chatEndTime);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChatMessage)) {
            return false;
        }
        ChatMessage chatMessage = (ChatMessage) other;
        return Intrinsics.areEqual(this.chatSessionId, chatMessage.chatSessionId) && Intrinsics.areEqual(this.messageId, chatMessage.messageId) && Intrinsics.areEqual(this.turnId, chatMessage.turnId) && Intrinsics.areEqual(this.status, chatMessage.status) && Intrinsics.areEqual(this.messageType, chatMessage.messageType) && Intrinsics.areEqual(this.role, chatMessage.role) && Intrinsics.areEqual(this.messageIndex, chatMessage.messageIndex) && Intrinsics.areEqual(this.content, chatMessage.content) && Intrinsics.areEqual(this.replyToMessageId, chatMessage.replyToMessageId) && Intrinsics.areEqual(this.userMessageContext, chatMessage.userMessageContext) && Intrinsics.areEqual(this.error, chatMessage.error) && Intrinsics.areEqual(this.revertible, chatMessage.revertible) && Intrinsics.areEqual(this.versionCode, chatMessage.versionCode) && Intrinsics.areEqual(this.references, chatMessage.references) && Intrinsics.areEqual(this.contextMetadata, chatMessage.contextMetadata) && Intrinsics.areEqual(this.searchReferenceData, chatMessage.searchReferenceData) && Intrinsics.areEqual(this.docReferences, chatMessage.docReferences) && Intrinsics.areEqual(this.agentType, chatMessage.agentType) && Intrinsics.areEqual(this.agentId, chatMessage.agentId) && Intrinsics.areEqual(this.agentName, chatMessage.agentName) && Intrinsics.areEqual(this.agentAvatarId, chatMessage.agentAvatarId) && Intrinsics.areEqual(this.traceId, chatMessage.traceId) && Intrinsics.areEqual(this.createdAt, chatMessage.createdAt) && Intrinsics.areEqual(this.createdAtMs, chatMessage.createdAtMs) && Intrinsics.areEqual(this.feeUsage, chatMessage.feeUsage) && Intrinsics.areEqual(this.maxFeeUsage, chatMessage.maxFeeUsage) && Intrinsics.areEqual(this.notifications, chatMessage.notifications) && Intrinsics.areEqual(this.modelSmartSelectionMeta, chatMessage.modelSmartSelectionMeta) && Intrinsics.areEqual(this.fromAppendMsg, chatMessage.fromAppendMsg) && Intrinsics.areEqual(this.shallowMementoType, chatMessage.shallowMementoType) && Intrinsics.areEqual(this.chatProcessVersion, chatMessage.chatProcessVersion) && Intrinsics.areEqual(this.tokenUsage, chatMessage.tokenUsage) && Intrinsics.areEqual(this.contextUsage, chatMessage.contextUsage) && Intrinsics.areEqual(this.agentProcessSupport, chatMessage.agentProcessSupport) && Intrinsics.areEqual(this.fastRequestSavings, chatMessage.fastRequestSavings) && Intrinsics.areEqual(this.isWorktree, chatMessage.isWorktree) && Intrinsics.areEqual(this.query, chatMessage.query) && Intrinsics.areEqual(this.isArchived, chatMessage.isArchived) && Intrinsics.areEqual(this.isUserCanceled, chatMessage.isUserCanceled) && Intrinsics.areEqual(this.chatStartTime, chatMessage.chatStartTime) && Intrinsics.areEqual(this.chatEndTime, chatMessage.chatEndTime);
    }

    public int hashCode() {
        String str = this.chatSessionId;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.messageId;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.turnId;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.status;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.messageType;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.role;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Long l = this.messageIndex;
        int hashCode7 = (hashCode6 + (l == null ? 0 : l.hashCode())) * 31;
        String str7 = this.content;
        int hashCode8 = (hashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.replyToMessageId;
        int hashCode9 = (hashCode8 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.userMessageContext;
        int hashCode10 = (hashCode9 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.error;
        int hashCode11 = (hashCode10 + (str10 == null ? 0 : str10.hashCode())) * 31;
        Boolean bool = this.revertible;
        int hashCode12 = (hashCode11 + (bool == null ? 0 : bool.hashCode())) * 31;
        Long l2 = this.versionCode;
        int hashCode13 = (hashCode12 + (l2 == null ? 0 : l2.hashCode())) * 31;
        String str11 = this.references;
        int hashCode14 = (hashCode13 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.contextMetadata;
        int hashCode15 = (hashCode14 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.searchReferenceData;
        int hashCode16 = (hashCode15 + (str13 == null ? 0 : str13.hashCode())) * 31;
        String str14 = this.docReferences;
        int hashCode17 = (hashCode16 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.agentType;
        int hashCode18 = (hashCode17 + (str15 == null ? 0 : str15.hashCode())) * 31;
        String str16 = this.agentId;
        int hashCode19 = (hashCode18 + (str16 == null ? 0 : str16.hashCode())) * 31;
        String str17 = this.agentName;
        int hashCode20 = (hashCode19 + (str17 == null ? 0 : str17.hashCode())) * 31;
        String str18 = this.agentAvatarId;
        int hashCode21 = (hashCode20 + (str18 == null ? 0 : str18.hashCode())) * 31;
        String str19 = this.traceId;
        int hashCode22 = (hashCode21 + (str19 == null ? 0 : str19.hashCode())) * 31;
        String str20 = this.createdAt;
        int hashCode23 = (hashCode22 + (str20 == null ? 0 : str20.hashCode())) * 31;
        String str21 = this.createdAtMs;
        int hashCode24 = (hashCode23 + (str21 == null ? 0 : str21.hashCode())) * 31;
        String str22 = this.feeUsage;
        int hashCode25 = (hashCode24 + (str22 == null ? 0 : str22.hashCode())) * 31;
        String str23 = this.maxFeeUsage;
        int hashCode26 = (hashCode25 + (str23 == null ? 0 : str23.hashCode())) * 31;
        String str24 = this.notifications;
        int hashCode27 = (hashCode26 + (str24 == null ? 0 : str24.hashCode())) * 31;
        String str25 = this.modelSmartSelectionMeta;
        int hashCode28 = (hashCode27 + (str25 == null ? 0 : str25.hashCode())) * 31;
        Boolean bool2 = this.fromAppendMsg;
        int hashCode29 = (hashCode28 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        String str26 = this.shallowMementoType;
        int hashCode30 = (hashCode29 + (str26 == null ? 0 : str26.hashCode())) * 31;
        String str27 = this.chatProcessVersion;
        int hashCode31 = (hashCode30 + (str27 == null ? 0 : str27.hashCode())) * 31;
        String str28 = this.tokenUsage;
        int hashCode32 = (hashCode31 + (str28 == null ? 0 : str28.hashCode())) * 31;
        String str29 = this.contextUsage;
        int hashCode33 = (hashCode32 + (str29 == null ? 0 : str29.hashCode())) * 31;
        String str30 = this.agentProcessSupport;
        int hashCode34 = (hashCode33 + (str30 == null ? 0 : str30.hashCode())) * 31;
        String str31 = this.fastRequestSavings;
        int hashCode35 = (hashCode34 + (str31 == null ? 0 : str31.hashCode())) * 31;
        Boolean bool3 = this.isWorktree;
        int hashCode36 = (hashCode35 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        String str32 = this.query;
        int hashCode37 = (hashCode36 + (str32 == null ? 0 : str32.hashCode())) * 31;
        Boolean bool4 = this.isArchived;
        int hashCode38 = (hashCode37 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
        Boolean bool5 = this.isUserCanceled;
        int hashCode39 = (hashCode38 + (bool5 == null ? 0 : bool5.hashCode())) * 31;
        Long l3 = this.chatStartTime;
        int hashCode40 = (hashCode39 + (l3 == null ? 0 : l3.hashCode())) * 31;
        Long l4 = this.chatEndTime;
        return hashCode40 + (l4 != null ? l4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ChatMessage(chatSessionId=");
        sb.append(this.chatSessionId).append(", messageId=").append(this.messageId).append(", turnId=").append(this.turnId).append(", status=").append(this.status).append(", messageType=").append(this.messageType).append(", role=").append(this.role).append(", messageIndex=").append(this.messageIndex).append(", content=").append(this.content).append(", replyToMessageId=").append(this.replyToMessageId).append(", userMessageContext=").append(this.userMessageContext).append(", error=").append(this.error).append(", revertible=");
        sb.append(this.revertible).append(", versionCode=").append(this.versionCode).append(", references=").append(this.references).append(", contextMetadata=").append(this.contextMetadata).append(", searchReferenceData=").append(this.searchReferenceData).append(", docReferences=").append(this.docReferences).append(", agentType=").append(this.agentType).append(", agentId=").append(this.agentId).append(", agentName=").append(this.agentName).append(", agentAvatarId=").append(this.agentAvatarId).append(", traceId=").append(this.traceId).append(", createdAt=").append(this.createdAt);
        sb.append(", createdAtMs=").append(this.createdAtMs).append(", feeUsage=").append(this.feeUsage).append(", maxFeeUsage=").append(this.maxFeeUsage).append(", notifications=").append(this.notifications).append(", modelSmartSelectionMeta=").append(this.modelSmartSelectionMeta).append(", fromAppendMsg=").append(this.fromAppendMsg).append(", shallowMementoType=").append(this.shallowMementoType).append(", chatProcessVersion=").append(this.chatProcessVersion).append(", tokenUsage=").append(this.tokenUsage).append(", contextUsage=").append(this.contextUsage).append(", agentProcessSupport=").append(this.agentProcessSupport).append(", fastRequestSavings=");
        sb.append(this.fastRequestSavings).append(", isWorktree=").append(this.isWorktree).append(", query=").append(this.query).append(", isArchived=").append(this.isArchived).append(", isUserCanceled=").append(this.isUserCanceled).append(", chatStartTime=").append(this.chatStartTime).append(", chatEndTime=").append(this.chatEndTime).append(')');
        return sb.toString();
    }

    public ChatMessage(String str, String str2, String str3, String str4, String str5, String str6, Long l, String str7, String str8, String str9, String str10, Boolean bool, Long l2, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, String str23, String str24, String str25, Boolean bool2, String str26, String str27, String str28, String str29, String str30, String str31, Boolean bool3, String str32, Boolean bool4, Boolean bool5, Long l3, Long l4) {
        this.chatSessionId = str;
        this.messageId = str2;
        this.turnId = str3;
        this.status = str4;
        this.messageType = str5;
        this.role = str6;
        this.messageIndex = l;
        this.content = str7;
        this.replyToMessageId = str8;
        this.userMessageContext = str9;
        this.error = str10;
        this.revertible = bool;
        this.versionCode = l2;
        this.references = str11;
        this.contextMetadata = str12;
        this.searchReferenceData = str13;
        this.docReferences = str14;
        this.agentType = str15;
        this.agentId = str16;
        this.agentName = str17;
        this.agentAvatarId = str18;
        this.traceId = str19;
        this.createdAt = str20;
        this.createdAtMs = str21;
        this.feeUsage = str22;
        this.maxFeeUsage = str23;
        this.notifications = str24;
        this.modelSmartSelectionMeta = str25;
        this.fromAppendMsg = bool2;
        this.shallowMementoType = str26;
        this.chatProcessVersion = str27;
        this.tokenUsage = str28;
        this.contextUsage = str29;
        this.agentProcessSupport = str30;
        this.fastRequestSavings = str31;
        this.isWorktree = bool3;
        this.query = str32;
        this.isArchived = bool4;
        this.isUserCanceled = bool5;
        this.chatStartTime = l3;
        this.chatEndTime = l4;
    }

    public /* synthetic */ ChatMessage(String str, String str2, String str3, String str4, String str5, String str6, Long l, String str7, String str8, String str9, String str10, Boolean bool, Long l2, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, String str23, String str24, String str25, Boolean bool2, String str26, String str27, String str28, String str29, String str30, String str31, Boolean bool3, String str32, Boolean bool4, Boolean bool5, Long l3, Long l4, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : l, (i & 128) != 0 ? null : str7, (i & 256) != 0 ? null : str8, (i & 512) != 0 ? null : str9, (i & 1024) != 0 ? null : str10, (i & 2048) != 0 ? null : bool, (i & 4096) != 0 ? null : l2, (i & 8192) != 0 ? null : str11, (i & 16384) != 0 ? null : str12, (i & 32768) != 0 ? null : str13, (i & 65536) != 0 ? null : str14, (i & 131072) != 0 ? null : str15, (i & 262144) != 0 ? null : str16, (i & 524288) != 0 ? null : str17, (i & 1048576) != 0 ? null : str18, (i & 2097152) != 0 ? null : str19, (i & 4194304) != 0 ? null : str20, (i & 8388608) != 0 ? null : str21, (i & 16777216) != 0 ? null : str22, (i & AVLogger.LEVEL_LOG_INFO) != 0 ? null : str23, (i & 67108864) != 0 ? null : str24, (i & 134217728) != 0 ? null : str25, (i & C.ENCODING_PCM_MU_LAW) != 0 ? null : bool2, (i & 536870912) != 0 ? null : str26, (i & 1073741824) != 0 ? null : str27, (i & Integer.MIN_VALUE) != 0 ? null : str28, (i2 & 1) != 0 ? null : str29, (i2 & 2) != 0 ? null : str30, (i2 & 4) != 0 ? null : str31, (i2 & 8) != 0 ? null : bool3, (i2 & 16) != 0 ? null : str32, (i2 & 32) != 0 ? null : bool4, (i2 & 64) != 0 ? null : bool5, (i2 & 128) != 0 ? null : l3, (i2 & 256) != 0 ? null : l4);
    }

    public final String getChatSessionId() {
        return this.chatSessionId;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final String getTurnId() {
        return this.turnId;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getMessageType() {
        return this.messageType;
    }

    public final String getRole() {
        return this.role;
    }

    public final Long getMessageIndex() {
        return this.messageIndex;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getReplyToMessageId() {
        return this.replyToMessageId;
    }

    public final String getUserMessageContext() {
        return this.userMessageContext;
    }

    public final String getError() {
        return this.error;
    }

    public final Boolean getRevertible() {
        return this.revertible;
    }

    public final Long getVersionCode() {
        return this.versionCode;
    }

    public final String getReferences() {
        return this.references;
    }

    public final String getContextMetadata() {
        return this.contextMetadata;
    }

    public final String getSearchReferenceData() {
        return this.searchReferenceData;
    }

    public final String getDocReferences() {
        return this.docReferences;
    }

    public final String getAgentType() {
        return this.agentType;
    }

    public final String getAgentId() {
        return this.agentId;
    }

    public final String getAgentName() {
        return this.agentName;
    }

    public final String getAgentAvatarId() {
        return this.agentAvatarId;
    }

    public final String getTraceId() {
        return this.traceId;
    }

    public final String getCreatedAt() {
        return this.createdAt;
    }

    public final String getCreatedAtMs() {
        return this.createdAtMs;
    }

    public final String getFeeUsage() {
        return this.feeUsage;
    }

    public final String getMaxFeeUsage() {
        return this.maxFeeUsage;
    }

    public final String getNotifications() {
        return this.notifications;
    }

    public final String getModelSmartSelectionMeta() {
        return this.modelSmartSelectionMeta;
    }

    public final Boolean getFromAppendMsg() {
        return this.fromAppendMsg;
    }

    public final String getShallowMementoType() {
        return this.shallowMementoType;
    }

    public final String getChatProcessVersion() {
        return this.chatProcessVersion;
    }

    public final String getTokenUsage() {
        return this.tokenUsage;
    }

    public final String getContextUsage() {
        return this.contextUsage;
    }

    public final String getAgentProcessSupport() {
        return this.agentProcessSupport;
    }

    public final String getFastRequestSavings() {
        return this.fastRequestSavings;
    }

    public final Boolean isWorktree() {
        return this.isWorktree;
    }

    public final String getQuery() {
        return this.query;
    }

    public final Boolean isArchived() {
        return this.isArchived;
    }

    public final Boolean isUserCanceled() {
        return this.isUserCanceled;
    }

    public final Long getChatStartTime() {
        return this.chatStartTime;
    }

    public final Long getChatEndTime() {
        return this.chatEndTime;
    }
}
