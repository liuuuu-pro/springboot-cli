package com.boot.cli.ai.server.service.mapper;

import com.boot.cli.common.core.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
public class GoogleAiSchemaMapper {

    private final ObjectMapper objectMapper;

    public GoogleAiSchemaMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public String schemaToString(Map<String, Object> schema) {
        if (schema == null) {
            throw new ServiceException("Schema不能为空");
        }

        try {
            Map<String, Object> processedSchema = processMap(schema);
            return objectMapper.writeValueAsString(processedSchema);
        } catch (Exception e) {
            log.error("Schema转换异常", e);
            throw new ServiceException("Schema转换异常");
        }
    }

    private Map<String, Object> processMap(Map<String, Object> source) {
        Map<String, Object> target = new LinkedHashMap<>(source.size());

        for (Map.Entry<String, Object> entry : source.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            if ("type".equals(key) && value instanceof String str) {
                target.put(key, str.toUpperCase());
            } else {
                target.put(key, processValue(value));
            }
        }
        return target;
    }

    private Object processValue(Object value) {
        if (value instanceof Map<?, ?> map) {
            return processMap(castToMap(map));
        }
        if (value instanceof List<?> list) {
            return processList(list);
        }
        return value;
    }

    private List<Object> processList(List<?> list) {
        List<Object> newList = new ArrayList<>(list.size());
        for (Object item : list) {
            newList.add(processValue(item));
        }
        return newList;
    }

    @SuppressWarnings("unchecked")
    private Map<String, Object> castToMap(Map<?, ?> map) {
        return (Map<String, Object>) map;
    }
}