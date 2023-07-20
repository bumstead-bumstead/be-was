package webserver;

import exceptions.PathNotFoundException;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class URIHandlers {
    private Map<String, Method> map;

    public URIHandlers() {
        this.map = new HashMap<>();
    }

    public void addMapping(String path, Method method) {
        map.put(path, method);
    }

    public Method getMappedMethod(String path) {
        verifyMappedMethodExistence(path);
        return map.get(path);
    }

    private void verifyMappedMethodExistence(String path) {
        if (!map.containsKey(path)) {
            throw new PathNotFoundException();
        }
    }

    @Override
    public String toString() {
        return "URIHandlers{" +
                "map=" + map +
                '}';
    }
}
