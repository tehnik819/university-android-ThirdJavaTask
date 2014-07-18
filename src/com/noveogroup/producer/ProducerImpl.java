package com.noveogroup.producer;

import com.noveogroup.buffer.Buffer;
import com.noveogroup.data.Data;
import com.noveogroup.data.StringData;

public class ProducerImpl implements Runnable, Producer  {
    private Buffer buffer;
    private long delay;

    public ProducerImpl(Buffer buf, long delay) {
        this.buffer = buf;
        this.delay = delay;
        System.out.println("Producer thread delay = " + delay);
    }

    @Override
    public void run() {
        int i = 0;
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(delay);
                buffer.push(produceData(i));
                i++;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Producer thread interrupted");
    }

    @Override
    public Data produceData(int index) {
        Data data = new StringData("String number " + String.valueOf(index));
        System.out.println("Produced: " + data.getName());
        return data;
    }
}
