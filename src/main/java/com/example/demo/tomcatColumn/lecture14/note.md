

### 总体流程

应用程序：

```
LimiLatch --> Acceptor(监听请求，接收请求返回channel) 
--> poller(本质是selector,一旦 channnel就绪，生成 socketProcessor,提交给 Executor)
--> Executor(内部多个 socketProcessor，run 方法调用 Http11Processor)
--> Http11Processor(调用 NioSocketWrapper,读写数据)
```


内核：接收队列 + 发送队列(一个个数据包)