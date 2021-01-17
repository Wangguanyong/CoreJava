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

### 线程属性
1. 中断线程，interrupt方法。设置线程为中断状态，线程通过Thread.currentThread.isIntterrupted()获取是否中断。
当线程处于阻塞状态时，如果此时中断线程，会触发InterruptedException异常。
    
    `java.lang.Thread`:

    - void interrupt() //向线程发送中断请求
    - static boolean interrupted() //检测是否中断，并且会清除中断标志，静态方法
    - static boolean isInterrupted() //检测是否被中断，不改变中断状态。
    - static Thread currentThread,返回当前正在执行的Thread对象
    

2. 守护线程，守护线程的唯一用途是为其他线程提供服务。
    - void setDaemon

3. 线程名：t.setName("thread_name")
4. 未捕获异常的处理器
5. 线程优先级：
 - void setPriority(int newPriority) //设置优先级
 - static int MIN_PRIORITY
 - static int NORMAL_PRIORITY
 - static int MAX_PRIORITY

### 同步
1. 锁对象
    1. synchronized 
    2. ReentrantLock

`java.util.concurrent.locks.lock`
 - void lock()
 - void unlock()
 
2. 条件对象， Condition
 - 判断条件while(cond)->等待激活cond.await()->执行；状态改变->signalAll/signal
 - signalAll只是发出通知，等待线程解除阻塞但并不激活，需要去争夺锁，获取到锁的对象才能运行，且只有条件满足后
 才能继续运行。当状态发生有可能使await的线程继续运行时才发出signal。
 
 `java.util.concurrent.locks.Lock`
 - Condition newCondition() //返回与这个锁相关的条件变量
 `java.util.concurrent.locks.Condition`
 - void await() //将线程放入这个条件的等待集
 - void signal() //解除该条件等待集中的所有线程的阻塞状态
 
3. synchronized关键字
java对象有一个内部锁，使用synchronized关键字可以使用这个锁，保护具有这个关键字的方法。内部锁还具有一个内部条件。
调用wait/notifyAll可以使用。  

4. 同步块：synchronized(obj)可以获得obj的内部锁，实现同步。

5. volatile关键字：指令重排，内存缓存。可见性。volatile可以保证可见性，但是不保证原子性。

6. final变量的构造过程是线程安全的。
7. 原子性： `java.util.concurrent.atomic`,例如AtomicInteger提供了incrementAndGet和decrementAndGet进行原子性的自增自减。
8. 死锁。
9. 线程局部变量tls。
 `java.lang.ThreadLocal<T>`:
  - T get() //得到这个线程的当前值。
  - void set(T t) //为这个线程设置一个新值
  - void remove() //删除对应这个线程的值
  - `static <S> ThreadLocal<S> withInitial(Supplier<? extends S> supplier)` //创建一个线程局部变量，
  其初始值通过调用给定的提供者生成。
  
  
### 线程安全的集合
对共享数据结构（map，set，list等），可以通过锁来保护，但是选择线程安全的实现类更容易使用。

1. 阻塞队列