package com.manager.business;

import com.manager.domain.enums.PriorityTaskEnum;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PriorityBusiness {

    public List<String> getAll() {
        return Arrays.asList(
                PriorityTaskEnum.LOW.get(),
                PriorityTaskEnum.NORMAL.get(),
                PriorityTaskEnum.MEDIUM.get(),
                PriorityTaskEnum.HIGH.get());
    }
}
