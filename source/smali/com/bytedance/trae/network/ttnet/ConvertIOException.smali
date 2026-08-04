# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/network/ttnet/ConvertIOException;
.super Ljava/lang/Object;
.source "ConvertIOException.java"

.field public static final SC_BIND_EXCEPTION:I
.field public static final SC_CLIENT_PROTOCOL_EXCEPTION:I
.field public static final SC_CONNECT_EXCEPTION:I
.field public static final SC_CONNECT_TIMEOUT:I
.field public static final SC_EACCES:I
.field public static final SC_EADDRINUSE:I
.field public static final SC_EADDRNOTAVAIL:I
.field public static final SC_ECONNREFUSED:I
.field public static final SC_ECONNRESET:I
.field public static final SC_EDQUOT:I
.field public static final SC_EHOSTUNREACH:I
.field public static final SC_EIO:I
.field public static final SC_ENETUNREACH:I
.field public static final SC_ENOENT:I
.field public static final SC_EROFS:I
.field public static final SC_FILE_TOO_LARGE:I
.field public static final SC_IO_EXCEPTION:I
.field public static final SC_NO_HTTP_RESPONSE:I
.field public static final SC_NO_REOUTE_TO_HOST:I
.field public static final SC_NO_SPACE:I
.field public static final SC_PORT_UNREACHABLE:I
.field public static final SC_RESET_BY_PEER:I
.field public static final SC_SOCKET_EXCEPTION:I
.field public static final SC_SOCKET_TIMEOUT:I
.field public static final SC_TTNET_TIME_OUT:I
.field public static final SC_UNKNOWN:I
.field public static final SC_UNKNOWN_HOST:I
.field public static final TAG:Ljava/lang/String;


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static ConvertIOExceptionToStatus(java.lang.Throwable  java.lang.String[])int
    .registers 14
    # ins_size=2
    const-string v0, "SC_CONNECT_EXCEPTION ip "
    const-string v1, "SC_CONNECT_TIMEOUT ip "
    const-string v2, "SC_CONNECT_EXCEPTION "
    const-string v3, "SC_CONNECT_TIMEOUT "
    const/4 v4, 1
    if-nez v12, +003h
    return v4
    if-nez v13, +004h
    new-array v13, v4, [Ljava/lang/String;
    instance-of v5, v12, Lcom/bytedance/frameworks/baselib/network/http/exception/HttpResponseException;
    const/4 v6, 7
    const/16 v7, 8
    const/4 v8, 2
    const/4 v9, 3
    const/4 v10, 4
    if-eqz v5, +00bh
    move-object v4, v12
    check-cast v4, Lcom/bytedance/frameworks/baselib/network/http/exception/HttpResponseException;
    invoke-virtual v4, Lcom/bytedance/frameworks/baselib/network/http/exception/HttpResponseException;->getStatusCode()I
    move-result v4
    goto/16 +079h
    instance-of v5, v12, Lcom/bytedance/frameworks/baselib/network/http/util/DownloadFileTooLargeException;
    if-eqz v5, +006h
    const/16 v4, 20
    goto/16 +071h
    instance-of v5, v12, Lorg/apache/http/conn/ConnectTimeoutException;
    if-eqz v5, +005h
    move v4, v8
    goto/16 +06ah
    instance-of v5, v12, Ljava/net/SocketTimeoutException;
    if-eqz v5, +01bh
    invoke-virtual v12, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v4
    invoke-static v4, Lcom/bytedance/common/utility/StringUtils;->isEmpty(Ljava/lang/String;)Z
    move-result v4
    if-nez v4, +00fh
    invoke-virtual v12, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v4
    const-string v5, "connect timed out"
    invoke-virtual v4, v5, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z
    move-result v4
    if-eqz v4, +003h
    goto -1dh
    move v4, v9
    goto +4ch
    instance-of v5, v12, Ljava/net/BindException;
    if-eqz v5, +004h
    move v4, v6
    goto +46h
    instance-of v5, v12, Ljava/net/ConnectException;
    if-eqz v5, +004h
    move v4, v7
    goto +40h
    instance-of v5, v12, Ljava/net/NoRouteToHostException;
    if-eqz v5, +005h
    const/16 v4, 9
    goto +39h
    instance-of v5, v12, Ljava/net/PortUnreachableException;
    if-eqz v5, +005h
    const/16 v4, 10
    goto +32h
    instance-of v5, v12, Ljava/net/SocketException;
    if-eqz v5, +015h
    invoke-virtual v12, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v4
    if-eqz v4, +00dh
    const-string/jumbo v5, reset by peer
    invoke-virtual v4, v5, Ljava/lang/String;->indexOf(Ljava/lang/String;)I
    move-result v4
    if-ltz v4, +004h
    const/4 v4, 6
    goto +1dh
    const/4 v4, 5
    goto +1bh
    instance-of v5, v12, Ljava/net/UnknownHostException;
    if-eqz v5, +005h
    const/16 v4, 11
    goto +14h
    instance-of v5, v12, Lcom/bytedance/frameworks/baselib/network/http/exception/NoHttpResponseException;
    if-eqz v5, +005h
    const/16 v4, 18
    goto +dh
    instance-of v5, v12, Lcom/bytedance/frameworks/baselib/network/http/exception/ClientProtocolException;
    if-eqz v5, +005h
    const/16 v4, 19
    goto +6h
    instance-of v5, v12, Ljava/io/IOException;
    if-eqz v5, +003h
    move v4, v10
    const-string v5, "ConvertIOException"
    const/4 v11, 0
    if-ne v4, v8, +05fh
    invoke-virtual v12, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v12
    invoke-static Lcom/bytedance/common/utility/Logger;->debug()Z
    move-result v0
    if-eqz v0, +012h
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-static v5, v0, Lcom/bytedance/common/utility/Logger;->d(Ljava/lang/String; Ljava/lang/String;)V
    const-string v0, "Connect to +([\w\.\-]+)?/(\[([a-zA-Z0-9:]+)\]|(\d{1,3}(\.\d{1,3}){3,3})):(\d+) +timed out"
    invoke-static v0, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;
    move-result-object v0
    invoke-virtual v0, v12, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    move-result-object v12
    invoke-virtual v12, Ljava/util/regex/Matcher;->matches()Z
    move-result v0
    if-eqz v0, +01bh
    invoke-virtual v12, v9, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;
    move-result-object v0
    if-eqz v0, +009h
    invoke-virtual v12, v9, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;
    move-result-object v12
    aput-object v12, v13, v11
    goto +dh
    invoke-virtual v12, v10, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;
    move-result-object v0
    if-eqz v0, +008h
    invoke-virtual v12, v10, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;
    move-result-object v12
    aput-object v12, v13, v11
    invoke-static Lcom/bytedance/common/utility/Logger;->debug()Z
    move-result v12
    if-eqz v12, +13eh
    new-instance v12, Ljava/lang/StringBuilder;
    invoke-direct v12, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    aget-object v13, v13, v11
    invoke-virtual v12, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v12
    invoke-virtual v12, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v12
    invoke-static v5, v12, Lcom/bytedance/common/utility/Logger;->d(Ljava/lang/String; Ljava/lang/String;)V
    goto/16 +12ah
    if-ne v4, v7, +0bdh
    invoke-virtual v12, Ljava/lang/Throwable;->getCause()Ljava/lang/Throwable;
    move-result-object v12
    if-eqz v12, +122h
    instance-of v1, v12, Ljava/net/ConnectException;
    if-eqz v1, +11eh
    invoke-virtual v12, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v12
    invoke-static Lcom/bytedance/common/utility/Logger;->debug()Z
    move-result v1
    if-eqz v1, +012h
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-static v5, v1, Lcom/bytedance/common/utility/Logger;->d(Ljava/lang/String; Ljava/lang/String;)V
    const-string v1, "failed to connect to +([\w\.\-]+)?/(\[([a-zA-Z0-9:]+)\]|(\d{1,3}(\.\d{1,3}){3,3})) \(port \d+\)( +after \d+ms)?: +\w+ failed: (E[A-Z]+) .*"
    invoke-static v1, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;
    move-result-object v1
    invoke-virtual v1, v12, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    move-result-object v12
    invoke-virtual v12, Ljava/util/regex/Matcher;->matches()Z
    move-result v1
    if-eqz v1, +064h
    invoke-virtual v12, v9, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;
    move-result-object v1
    if-eqz v1, +009h
    invoke-virtual v12, v9, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;
    move-result-object v1
    aput-object v1, v13, v11
    goto +dh
    invoke-virtual v12, v10, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;
    move-result-object v1
    if-eqz v1, +008h
    invoke-virtual v12, v10, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;
    move-result-object v1
    aput-object v1, v13, v11
    invoke-virtual v12, v6, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;
    move-result-object v12
    if-eqz v12, +046h
    const-string v1, "ECONNRESET"
    invoke-virtual v1, v12, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +006h
    const/16 v1, 12
    move v4, v1
    goto +39h
    const-string v1, "ECONNREFUSED"
    invoke-virtual v1, v12, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +005h
    const/16 v1, 13
    goto -ch
    const-string v1, "EHOSTUNREACH"
    invoke-virtual v1, v12, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +005h
    const/16 v1, 14
    goto -17h
    const-string v1, "ENETUNREACH"
    invoke-virtual v1, v12, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +005h
    const/16 v1, 15
    goto -22h
    const-string v1, "EADDRNOTAVAIL"
    invoke-virtual v1, v12, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +005h
    const/16 v1, 16
    goto -2dh
    const-string v1, "EADDRINUSE"
    invoke-virtual v1, v12, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +006h
    const/16 v1, 17
    goto -38h
    const/4 v12, 0
    invoke-static Lcom/bytedance/common/utility/Logger;->debug()Z
    move-result v1
    if-eqz v1, +08bh
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    aget-object v13, v13, v11
    invoke-virtual v1, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v13
    const-string v0, " "
    invoke-virtual v13, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v13
    invoke-virtual v13, v12, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v12
    invoke-virtual v12, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v12
    invoke-static v5, v12, Lcom/bytedance/common/utility/Logger;->d(Ljava/lang/String; Ljava/lang/String;)V
    goto/16 +06dh
    if-ne v4, v10, +06bh
    invoke-virtual v12, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v13
    const-string v0, " EIO (I/O error)"
    invoke-virtual v13, v0, Ljava/lang/String;->indexOf(Ljava/lang/String;)I
    move-result v0
    if-lez v0, +006h
    const/16 v12, 37
    move v4, v12
    goto +5ah
    instance-of v12, v12, Ljava/io/FileNotFoundException;
    const/16 v0, 33
    if-eqz v12, +004h
    move v4, v0
    goto +52h
    const-string v12, " ENOENT "
    invoke-virtual v13, v12, Ljava/lang/String;->indexOf(Ljava/lang/String;)I
    move-result v12
    if-gtz v12, -008h
    const-string v12, "No such file or directory"
    invoke-virtual v13, v12, Ljava/lang/String;->indexOf(Ljava/lang/String;)I
    move-result v12
    if-lez v12, +003h
    goto -12h
    const-string v12, " ENOSPC "
    invoke-virtual v13, v12, Ljava/lang/String;->indexOf(Ljava/lang/String;)I
    move-result v12
    if-gtz v12, +037h
    const-string v12, "No space left on device"
    invoke-virtual v13, v12, Ljava/lang/String;->indexOf(Ljava/lang/String;)I
    move-result v12
    if-lez v12, +003h
    goto +2dh
    const-string v12, " EDQUOT "
    invoke-virtual v13, v12, Ljava/lang/String;->indexOf(Ljava/lang/String;)I
    move-result v12
    if-lez v12, +005h
    const/16 v12, 34
    goto -36h
    const-string v12, " EROFS "
    invoke-virtual v13, v12, Ljava/lang/String;->indexOf(Ljava/lang/String;)I
    move-result v12
    if-lez v12, +005h
    const/16 v12, 35
    goto -41h
    const-string v12, " EACCES "
    invoke-virtual v13, v12, Ljava/lang/String;->indexOf(Ljava/lang/String;)I
    move-result v12
    if-lez v12, +005h
    const/16 v12, 36
    goto -4ch
    const-string v12, "ERR_TTNET_REQUEST_TIMED_OUT"
    invoke-virtual v13, v12, Ljava/lang/String;->indexOf(Ljava/lang/String;)I
    move-result v12
    if-lez v12, +008h
    const/16 v12, 38
    goto -57h
    const/16 v12, 32
    goto -5ah
    return v4
    :try_start_0x9f
.end method
