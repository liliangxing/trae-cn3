package com.bytedance.kmp.network.websocket;

import com.example.interopdemo.websocket.NativeConnectionState;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NativeRawWsService.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"toRawState", "Lcom/bytedance/kmp/network/websocket/RawWebsocketState;", "Lcom/example/interopdemo/websocket/NativeConnectionState;", "network_service_release"}, k = 2, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NativeRawWsServiceKt {

    /* compiled from: NativeRawWsService.kt */
    @Metadata(k = 3, mv = {1, 7, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[NativeConnectionState.values().length];
            try {
                iArr[NativeConnectionState.UNKNOWN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[NativeConnectionState.CONNECTING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[NativeConnectionState.DISCONNECTING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[NativeConnectionState.FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[NativeConnectionState.CLOSED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[NativeConnectionState.CONNECTED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final RawWebsocketState toRawState(NativeConnectionState nativeConnectionState) {
        Intrinsics.checkNotNullParameter(nativeConnectionState, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[nativeConnectionState.ordinal()]) {
            case 1:
                return RawWebsocketState.CONNECTION_UNKNOWN;
            case 2:
                return RawWebsocketState.CONNECTING;
            case 3:
                return RawWebsocketState.DISCONNECTING;
            case 4:
                return RawWebsocketState.CONNECT_FAILED;
            case 5:
                return RawWebsocketState.CONNECT_CLOSED;
            case 6:
                return RawWebsocketState.CONNECTED;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
