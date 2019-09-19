package com.cjj.springcloud.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.env.OriginTrackedMapPropertySource;
import org.springframework.boot.env.PropertySourceLoader;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @Author: cjj
 * @Date: 2019/9/18 0018 下午 2:38
 * @Description：解决从git获取配置信息乱码问题
 */
@Slf4j
public class MyPropertiesHandler implements PropertySourceLoader {

    @Override
    public String[] getFileExtensions() {
        return new String[]{"properties", "xml"};
    }

    @Override
    public List<PropertySource<?>> load(String s, Resource resource) throws IOException {
        Properties properties = this.getProperties(resource);
        return properties.isEmpty()? Collections.emptyList():Collections.singletonList(new OriginTrackedMapPropertySource(s, properties));
    }

    private Properties getProperties(Resource resource) {
        Properties properties = new Properties();
        InputStream inputStream = null;
        try {
            inputStream = resource.getInputStream();
            properties.load(new InputStreamReader(inputStream, "utf-8"));
            inputStream.close();
        } catch (IOException e) {
            log.error("load inputstream failure...", e);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    log.error("close IO failure ....", e);
                }
            }
        }
        return properties;
    }
}
