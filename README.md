### MoonChat
使用WebSocket实现私聊、群聊和世界频道。

体验地址：（待定）
#### 模块划分
<img src="module.png"/>

#### 实体格式
消息格式：
{src, dest, srcname, msg, time}。

其中，src表示消息发送者的uid，dest表示消息接收者的uid。
