package com.allen;

import org.apache.dubbo.common.serialize.support.SerializationOptimizer;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;


/**
 * 序列化性能分析：https://dubbo.apache.org/zh/docs/v2.7/user/serialization/
 */

public class SerializationOptimizerImpl implements SerializationOptimizer {
    @Override
    public Collection<Class> getSerializableClasses() {
        List<Class> classes = new LinkedList<Class>();
        classes.add(PersonInfo.class);
        classes.add(Object.class);
        return classes;
    }
}
