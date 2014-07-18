package com.noveogroup.buffer;

import com.noveogroup.data.Data;

public interface Buffer {
    void push(Data data) throws InterruptedException;
    Data get() throws InterruptedException;
    void print();
}
