package com.noveogroup.buffer;

import com.noveogroup.data.Data;

import java.util.LinkedList;

public class BufferImpl implements Buffer {
    private final int max = 5;
    private LinkedList<Data> buffer;
    private int count;

    public BufferImpl() {
        this.count = 0;
        this.buffer = new LinkedList<Data>();
    }

    @Override
    public synchronized void push(Data data) throws InterruptedException {
        while(count == max) {
            System.out.println("Wait in push");
            wait();
        }
        buffer.add(data);
        count++;
        notify();
    }

    @Override
    public synchronized Data get() throws InterruptedException {
        while(count == 0) {
            wait();
            System.out.println("Wait in get");
        }
        Data data = buffer.remove();
        count--;
        notify();
        return data;
    }

    @Override
    public void print() {
        System.out.println("Buffer:");
        for(int i = 0;i < buffer.size();i++)
            System.out.println(buffer.get(i).getName());
    }
}
