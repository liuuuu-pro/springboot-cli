package com.boot.cli.ai.server.service.mapper;

import com.boot.cli.common.core.exception.ServiceException;
import com.boot.cli.common.core.util.Json;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Slf4j
@Component
public class GoogleAiSchemaMapper {

    @Autowired
    private ObjectMapper objectMapper;

    public String schemaToString(Map<String, Object> schema) {
        try {
            Map<String, Object> newSchema = cloneSchema(schema);
            schemaUpperCase(newSchema);
            return objectMapper.writeValueAsString(newSchema);
        } catch (Exception e) {
            log.error("Schema转换异常:{}", Json.to(schema), e);
            throw new ServiceException("Schema转换异常");
        }
    }

    private Map<String, Object> cloneSchema(Map<String, Object> schema) {
        try {
            String json = objectMapper.writeValueAsString(schema);
            return objectMapper.readValue(json, Map.class);
        } catch (Exception e) {
            log.error("Schema处理异常:{}", Json.to(schema), e);
            throw new ServiceException("Schema处理异常");
        }
    }

    private static void schemaUpperCase(Map<String, Object> map) {
        if (map == null) return;

        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            if ("type".equals(key) && value instanceof String) {
                entry.setValue(((String) value).toUpperCase());
            } else if (value instanceof Map) {
                schemaUpperCase((Map<String, Object>) value);
            } else if (value instanceof List) {
                List<?> list = (List<?>) value;
                for (Object item : list) {
                    if (item instanceof Map) {
                        schemaUpperCase((Map<String, Object>) item);
                    }
                }
            }
        }
    }

}
