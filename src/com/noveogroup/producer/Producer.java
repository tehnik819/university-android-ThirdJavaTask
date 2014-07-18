package com.noveogroup.producer;

import com.noveogroup.data.Data;

public interface Producer {
    Data produceData(int index);
}
