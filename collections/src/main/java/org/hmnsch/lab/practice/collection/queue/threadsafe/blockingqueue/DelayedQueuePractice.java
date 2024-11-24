package org.hmnsch.lab.practice.collection.queue.threadsafe.blockingqueue;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayedQueuePractice {
    public static void main(String[] args) throws InterruptedException {
        // unbounded
        // polled only if the delay of the element is passed
        // suitable for scheduling tasks
        // uses priority queue
        // queue of delayed task

        DelayQueue<DelayedTask> delayeds = new DelayQueue<>();
        delayeds.add(new DelayedTask("a", 25, TimeUnit.SECONDS));
        delayeds.add(new DelayedTask("b", 5, TimeUnit.SECONDS));
        delayeds.add(new DelayedTask("c", 10, TimeUnit.SECONDS));

        /*
        * DelayedTask{taskName='b', scheduledTime=1732436133070}
DelayedTask{taskName='c', scheduledTime=1732436138070}
DelayedTask{taskName='a', scheduledTime=1732436153070}
        * */
        while (!delayeds.isEmpty()) {
            System.out.println(delayeds.take());
        }

    }
}

class DelayedTask implements Delayed {

    String taskName;
    long scheduledTime;

    public DelayedTask(String taskName, long delay, TimeUnit timeUnit) {
        this.taskName = taskName;
        this.scheduledTime = System.currentTimeMillis() + timeUnit.toMillis(delay);
    }

    @Override
    public String toString() {
        return "DelayedTask{" +
                "taskName='" + taskName + '\'' +
                ", scheduledTime=" + scheduledTime +
                '}';
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return scheduledTime-System.currentTimeMillis();
    }

    @Override
    public int compareTo(Delayed o) {
        return Long.compare(scheduledTime, ((DelayedTask) o).scheduledTime);
    }
}
