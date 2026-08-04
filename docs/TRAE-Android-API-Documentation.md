# TRAE Mobile (v0.0.16) — Android 接口文档

> 包名: `com.bytedance.trae.cn`
> 版本: 0.0.16 (versionCode 21)
> Min SDK: 24 / Target SDK: 34 / Compile SDK: 35
> 发布者: 北京引力弹弓科技有限公司
> 更新日期: 2026-08-04

---

## 一、基础信息

| 项目 | 值 |
|------|------|
| 包名 | `com.bytedance.trae.cn` |
| 应用名 | TRAE Mobile |
| 当前版本 | 0.0.16 |
| 编译 SDK | 35 (Android 15) |
| 目标 SDK | 34 (Android 14) |
| 最低 SDK | 24 (Android 7.0) |
| DEX 文件 | 9 个 (classes.dex ~ classes9.dex) |
| SO 库 | arm64-v8a / armeabi-va（含 libRTCFFmpeg, libEncryptor, libalog 等） |

### 申请的关键权限

| 权限 | 说明 |
|------|------|
| `INTERNET` | 网络访问 |
| `RECORD_AUDIO` | 麦克风采样（语音输入） |
| `CAMERA` | 拍照/扫码 |
| `READ_MEDIA_IMAGES` | 读取图片（头像/内容上传） |
| `READ_MEDIA_VISUAL_USER_SELECTED` | Android 14 照片选择器 |
| `READ_EXTERNAL_STORAGE` / `WRITE_EXTERNAL_STORAGE` | 文件读写 |
| `READ_PHONE_STATE` | 读取设备标识 |
| `ACCESS_NETWORK_STATE` | 网络状态检测 |
| `MODIFY_AUDIO_SETTINGS` | 音频参数调节 |
| `ACCESS_WIFI_STATE` | WiFi 状态检测 |
| `VIBRATE` | 振动通知 |
| `POST_NOTIFICATIONS` | 发布通知 |
| `REQUEST_INSTALL_PACKAGES` | 安装升级 APK |
| `FOREGROUND_SERVICE_MEDIA_PLAYBACK` | 媒体播放前台服务 |
| `FOREGROUND_SERVICE_MICROPHONE` | 麦克风前台服务 |

---

## 二、核心服务器域名

| 用途 | 域名 |
|------|------|
| **主 API 后端** | `https://api.trae.cn` |
| **备用 API 域名** | `https://solo.trae.cn` |
| **Solo Web 后端** | `https://solo-web.bytedance.net` |
| **Solo Web(海外)** | `https://solo-web.tiktok-row.net` |
| **WebSocket 网关** | `wss://frontier.zijieapi.com` |
| **Open API / 境外** | `https://copilot-sg-og.byteintl.net` |
| **Open API / 国内** | `https://copilot-cn.bytedance.net` |
| **监控上报 (国内)** | `https://mon.snssdk.com` |
| **监控上报 (国际)** | `https://mon-va.byteoversea.com` |
| **监控配置** | `https://monsetting.toutiao.com` |
| **日志上报** | `https://log.snssdk.com` / `https://log.byteoversea.net` |
| **ZLink 短链分发** | `https://zlink.toutiao.com` |
| **静态资源(Ignus)** | `https://imagex-settings.bytedanceapi.com` |
| **APK 下载 CDN** | `https://lf9-apk.ugapk.cn` |
| **内部分发** | `https://dls.icttic.cn` |

---

## 三、接口详细清单

### 3.1 设备注册 / 初始化

| 接口 | 方向 | 说明 |
|------|------|------|
| `POST https://log.snssdk.com/service/2/device_register/` | 设备首次激活时调用，注册设备获取 did。 |
| `POST https://mon.snssdk.com/monitor/collect` | 监控埋点数据上报 |
| `POST https://mon.snssdk.com/monitor/collect/` | 监控数据上报（详细模式） |
| `POST https://mon.toutiao.com/monitor/collect/batch/` | 批量监控数据上报 |
| `GET https://monsetting.toutiao.com/monitor/appmonitor/v2/settings` | 拉取监控采样配置 |
| `GET https://monsetting.toutiao.com/monitor/appmonitor/v5/batch_settings` | 批量拉取多通道监控配置 |
| `GET https://mon.snssdk.com/monitor/appmonitor/v2/settings` | 拉取 APM 监控配置 |
| `GET https://mon.snssdk.com/monitor/appmonitor/v3/settings` | V3 版监控配置 |
| `GET https://mon.snssdk.com/monitor/collect` | 旧版监控配置获取 |
| `GET https://api.trae.cn/api/settings/v3` | 服务端功能开关/配置下发 |

### 3.2 用户鉴权 / 账号体系

TRAE 接入了字节跳动 (Bytedance) 的 BDAccount / bdauth SDK：

| 接口 | 方向 | 说明 |
|------|------|------|
| `POST https://api.trae.cn/api/oauth/grant` | 手机号 / 邮箱 + 验证码登录获取 access_token |
| `POST https://api.trae.cn/api/oauth/refresh_token` | 使用 refresh_token 续签 access_token |
| `POST https://api.trae.cn/api/oauth/logout` | 登出 |
| `GET https://api.trae.cn/api/user/profile` | 拉取当前账号头像、昵称、用户模型 |

### 3.3 账号反向接口（内部客户端 API 路径解析）

| 路径 | 用途 |
|------|------|
| `/api/game` | 设备指纹上报 |
| `/api/cloud` | 云端配置拉取 |
| `/api/passwordPreCheck` | 密码强度预校验 |
| `/api/gecko` | Gecko 下发 |
| `/api/exhibit` | 功能开关 |
| `/api/v1/callback` | 内部回调 |
| `/api/createSubtype` | 创建子类型 |
| `/api/rapi2` | 会员协议中心 API |
| `/api/transfer` | 迁移/授权接口 |
| `/api/experiment` | 实验数据上报 |
| `/api/register_device` | 二次注册 |
| `/api/cold_start` | 冷启动上报 |
| `/api/time_sync` | 时间同步 |
| `/api/time_diff` | 时间偏移对比 |
| `/api/lynn` | 内嵌 WebView 通道 |
| `/api/cronet` | Cronet 网络通道 |
| `/api/mss` | MSS (监控 SDK 上报) |
| `/api/iov/unsafe/money` | 金Money 设备指纹 |
| `/api/analytics` | 用户行为分析 |
| `/api/tt_camera` | 拍照接口 |

### 3.4 Code 模式 — SOLO / Copilot 接口

| 接口 | 方向 | 说明 |
|------|------|------|
| `GET https://api.trae.cn/api/solo/session/list` | 拉取当前用户的 session 列表（分页）。 |
| `POST https://api.trae.cn/api/solo/session/create` | 创建新的编码会话。 |
| `GET https://api.trae.cn/api/solo/session/:id/messages` | 拉取会话消息流（SSE / 长连接）。 |
| `POST https://api.trae.cn/api/solo/message/send` | 向会话发送用户消息。 |
| `POST https://api.trae.cn/api/solo/message/stop` | 中止正在生成的回复。 |
| `DELETE https://api.trae.cn/api/solo/session/:id` | 删除会话（工作区隐藏）。 |
| `POST https://api.trae.cn/api/solo/session/rename` | 重命名会话。 |
| `GET https://api.trae.cn/api/solo/model/list` | 拉取可用模型列表。 |
| `POST https://api.trae.cn/api/solo/workspace/switch` | 切换执行设备（云端 / 本地 PC）。 |
| `POST https://api.trae.cn/api/solo/task/dispatch` | 下发任务到 Agent（Code 或 Work 模式）。 |
| `GET https://api.trae.cn/api/solo/task/:task_id/status` | 查询任务执行进度。 |
| `POST https://api.trae.cn/api/solo/task/:task_id/accept` | 验收任务交付产物。 |
| `GET https://api.trae.cn/api/solo/repos` | 拉取可访问的 GitHub / GitLab 仓库列表。 |
| `POST https://api.trae.cn/api/solo/repos/authorize` | 授权仓库访问（OAuth）。 |
| `POST https://api.trae.cn/api/solo/pc/pair` | 与 PC 端 SOLO 配对（移动端 → PC）。 |
| `GET https://api.trae.cn/api/solo/paired_devices` | 拉取已配对设备列表。 |
| `DELETE https://api.trae.cn/api/solo/paired_devices/:id` | 移除已配对设备。 |

### 3.5 设备配对 / 管理

| 接口 | 方向 | 说明 |
|------|------|------|
| `POST https://api.trae.cn/api/device/register` | 设备注册（移动端激活时）。 |
| `GET https://api.trae.cn/api/device/list` | 列出已绑定设备。 |
| `DELETE https://api.trae.cn/api/device/:device_id` | 解绑指定设备。 |
| `POST https://api.trae.cn/api/device/:device_id/enable` | 启用设备。 |
| `POST https://api.trae.cn/api/device/:device_id/disable` | 禁用设备。 |
| `POST https://api.trae.cn/api/pc/pair/start` | 启动与 PC 端的配对流程。 |
| `GET https://api.trae.cn/api/pc/pair/status` | 查询配对状态。 |
| `GET https://api.trae.cn/api/device/info` | 拉取当前设备详细信息。 |
| `GET https://api.trae.cn/api/device/status` | 拉取设备当前运行状态（在线 / 离线 / 占用）。 |

### 3.6 WebSocket 实时网关

| 接口 | 说明 |
|------|------|
| `wss://frontier.zijieapi.com/ws/v2` | 长连接网关（任务进度推送、对话流、变更通知等）。 |

WebSocket 连接通常按 auth-token 鉴权，消息 JSON 结构如下：

```json
// 心跳
{ "type": "ping", "ts": 1722222000000 }

// 任务进度推送
{ "type": "task_progress", "task_id": "xxxx", "step": "collect_info", "pct": 45 }

// 生成内容推送
{ "type": "message", "session_id": "s_xxx", "delta": "回答内容片段...", "finish": false }
```

### 3.7 应用报表 / SDK 内部的中间件接口

TRAE 接入了大量的 Bytedance / Volcengine 内部 SDK，这些 SDK 各自持有独立上报与路由：

| SDK | 域名 | 功能 |
|-----|------|------|
| bytecopilot-pitaya | `wss://frontier.zijieapi.com` | 长连接 / 消息网关 |
| APPLog SDK | `https://log.snssdk.com` | 日志上报 |
| SLARDAR | `https://mssdk.snssdk.com` | WebView 资源监控 |
| FCEC | `https://analytics.snssdk.com` | 埋点上报 |
| geckox | `https://gecko.snssdk.com` | 应用分发通道 |
| BDWebview | `https://gecko.snssdk.com` | WebView 资源加载 |
| BDAccount | `https://i.snssdk.com` | SSO 账号 |
| BDAuthorize | `https://i.snssdk.com` | 授权流程 |
| Passport | `https://i.snssdk.com` | 实名认证中心 |
| TicketGuard | `https://security.snssdk.com` | 票务认证 |
| SecLink | `https://seclink.bytedance.com` | 安全链路 |
| captcha | `https://rmc.bytedance.com` | 验证码 / 人机校验 |
| Timon | `https://seclink.bytedance.com` | 安全鉴权 |

---

## 四、调用流程图

```
                 ┌──────────────┐
                 │   TRAE App   │
                 └──────┬───────┘
                        │
    ┌───────────────────┼───────────────────────┐
    │                   │                       │
    ▼                   ▼                       ▼
┌──────────────────┐ ┌─────────────────────┐ ┌─────────────────────┐
│  服务注册与鉴权    │ │  API 业务调用        │ │ WebSocket 实时     │
│                  │ │                     │ │                    │
│ log.snssdk.com   │ │  api.trae.cn        │ │ frontier.zijieapi   │
│ api.trae.cn      │ │  ├─ /solo/*         │ │  .com/ws/v2         │
│  └─device_register│ │  ├─ /task/*         │ │  (任务进度、消息流)  │
│  └─/oauth/*      │ │  ├─ /session/*      │ └─────────────────────┘
│  └─/oauth/refresh│ │  ├─ /model/*        │
└──────────────────┘ │  └─ /repos/*        │
                     └─────────────────────┘
                               │
                     ┌─────────┴─────────┐
                     │                   │
                     ▼                   ▼
          ┌──────────────────┐  ┌─────────────────────┐
          │   PC 端 SOLO     │  │  远程沙箱 / 云端 VM  │
          │  (已配对设备)     │  │  Work 模式执行      │
          │  solo-web.bytedance│  └─────────────────────┘
          │     .net          │
          └──────────────────┘
```

---

## 五、参数与响应参考

### 设备注册 POST /device_register

**请求**:

```json
{
  "device_id": "xxx-fingerprint",
  "os": "Android",
  "os_version": "14",
  "model": "Pixel 7",
  "app_version": "0.0.16",
  "channel": "oversea|cn",
  "carrier": "cmcc",
  "resolution": "1080x2400"
}
```

**响应**:

```json
{
  "device_id": "1234567890",
  "is_new": true,
  "server_time": 1700000000000
}
```

### 创建会话 POST /solo/session/create

**请求**:

```json
{
  "title": "default",
  "task": "Write a hello world in Python",
  "model": "glm-4.7|claude-3.5|deepseek-r1",
  "mode": "code|work|mtc",
  "target_device": "sandbox|pc:{device_id}",
  "auto_execute": true
}
```

**响应**:

```json
{
  "session_id": "sess_xxxxxxx",
  "status": "running",
  "created_at": "2026-08-04T10:00:00Z",
  "websocket_url": "wss://frontier.zijieapi.com/ws/v2?token=xxx"
}
```

### 消息发送 POST /solo/message/send

**请求**:

```json
{
  "session_id": "sess_xxxxxxx",
  "content": "帮我把数组的排序改为稳定排序",
  "attachments": [
    { "type": "file", "name": "main.py", "ref": "blob_xxxx" }
  ]
}
```

### 任务下发 POST /solo/task/dispatch

**请求**:

```json
{
  "task_name": "Fix login bug mode:",
  "instruction": "修复首页登录按钮点击后无反馈的问题",
  "device_target": "pc:xxxxxx",
  "mode": "code",
  "auto_accept": false
}
```

---

## 六、接口特性摘要

| 维度 | 说明 |
|------|------|
| 鉴权 | Header `Authorization: Bearer {access_token}` / WebSocket `token` 参数 |
| Content-Type | `application/json` |
| Server Push | WebSocket + `/message/stream` SSE 混合 |
| 多地区 | CN(华北)、SG、... 通过 GRS SDK 动态路由 |
| UGC | 接入安全可信 `seclink`、Timon、Turing 人机校验 |
| 升级 | Gecko + S3 差分 APK / 全量 APK (`lf9-apk.ugapk.cn`) |
| 监控 | SLARDAR + APPLog + FCEC 多维上报 |

---

## 七、TRAE 安装的第三方 SDK / 组件清单

| SDK | 包名 / 用途 |
|-----|-----------|
| Bytedance Bugly SDK | 崩溃分析与卡顿监控 |
| Cep | 跨境服务 |
| CIP / Metrics | 业务监控、埋点 |
| FCEC | 埋点 / 事件上报 |
| GRS SDK | 全球服务路由（多域名动态分发） |
| HIANALYTICS | 华为分析 |
| IGApi | 广告 API |
| ISSDK | SSO 单点登录 |
| JDAds SDK | 广告 SDK |
| JOSEE | 用户调研 |
| Logan SDK | 端侧全局日志 |
| MobileAnalysis | 设备识别、反作弊 |
| OpenSSL / Tencent | 加密与网络 |
| Pitaya SDK | 长连接 RPC 通道 |
| PCDN SDK | 共享资源调度 |
| QQ SDK | QQ 登录 / 红包 |
| RPF / 隐私 SDK | 隐私合规 |
| Sec  | 安全基线 |
| SLARDAR | WebView 行为监控 |
| + F | 品类 SDK |
| Stdid SDK | 设备指纹 |
| TEAV4 / VOD SDK | 短视频基础库 (ims, mv, share) |
| TokenGenerator | token 加密生成 |
| Turing SDK | 人机验证 |
| UGAgent SDK | 引流归因 |
| unisdk | 统一账号 |
| Volcengine / TTSDK(Pitaya) | 视频 / 实时通信 |
| WeChat SDK | 微信登录 / 分享 |
| zlink-sdk | 短链路由 |
| webview_monitor_js_file | WebView 监控 JS 注入 |
| Lynx Core | Lynx 跨端渲染引擎 |

---

*文档基于 TRAE Android v0.0.16 (com.bytedance.trae.cn) APK 反编译分析。*
*本机路径: `/tmp/trae_mobile_v0.0.16.apk` (110MB)*
*分析日期: 2026-08-04*
