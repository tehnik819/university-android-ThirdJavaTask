package com.noveogroup.main;

import com.noveogroup.buffer.Buffer;
import com.noveogroup.buffer.BufferImpl;
import com.noveogroup.consumer.ConsumerImpl;
import com.noveogroup.producer.ProducerImpl;

public class Main {

    public static void main(String[] args) {
        Buffer buffer = new BufferImpl();
        ProducerImpl producer = new ProducerImpl(buffer, 1000);
        ConsumerImpl consumer = new ConsumerImpl(buffer, 1500);

        Thread prod = new Thread(producer);
        Thread cons = new Thread(consumer);
        prod.start();
        cons.start();

        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        prod.interrupt();
        cons.interrupt();
        try {
            prod.join();
            cons.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        buffer.print();
    }
}
