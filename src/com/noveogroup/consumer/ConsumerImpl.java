package com.noveogroup.consumer;

import com.noveogroup.buffer.Buffer;
import com.noveogroup.data.Data;

public class ConsumerImpl implements Consumer, Runnable {
    private Buffer buffer;
    private long delay;

    public ConsumerImpl(Buffer buf, long delay) {
        this.delay = delay;
        this.buffer = buf;
        System.out.println("Consumer thread delay = " + delay);
    }

    @Override
    public void consumeData(Data data) {
        System.out.println("Consumed: " + data.getName());
    }

    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(delay);
                consumeData(buffer.get());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Consumer thread interrupted");
    }
}
