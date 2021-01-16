### 线程创建
1. 实现Runable接口
2. 创建Thread t(r)
3. 启动，t.start()

### 线程状态
1. new 新建
2. Runnable 可运行
3. Blocked 阻塞, 获取锁
4. Waiting 等待, wait通知
5. Time waiting 计时等待, 等待超时,Ojbect.wait(), Lock.tryLock Condition.await
6. Terminated 终止

Thread.yield() 交出运行权

`java.lang.Thread`: 

- void join() //等待终止指定线程
- void join(long mills) //具有超时的等待终止
- Thread.State getState() //获取状态
- void stop() //legacy, 停止线程
- void suspend() //legacy, 暂停线程
- void resume() //legacy, 恢复线程



