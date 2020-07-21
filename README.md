# ThreadBase01
[show case doc](https://www.jianshu.com/p/e78c2c211a43)

print base threads from main function
```jsx
public static void main(String[] args) {
        //java虚拟机的线程管理接口
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        //获取线程信息的方法
        ThreadInfo[] threadInfos =
                threadMXBean.dumpAllThreads(false,false);
        for(ThreadInfo threadInfo:threadInfos){
            System.out.println(threadInfo.getThreadId()+":"+threadInfo.getThreadName());
        }
    }
```
