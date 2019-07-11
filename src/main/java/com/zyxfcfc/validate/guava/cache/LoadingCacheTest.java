package com.zyxfcfc.validate.guava.cache;

import com.google.common.base.MoreObjects;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import lombok.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author lihaibo
 * @version V1.0
 * @date 2019-07-01
 * @Description:
 */
public class LoadingCacheTest {

    public static void main(String args[]){
        //create a cache for employees based on their employee id
        LoadingCache employeeCache =
                CacheBuilder.newBuilder()
                        // maximum 100 records can be cached
                        .maximumSize(100)
                        // cache will expire after 30 minutes of access
                        .expireAfterAccess(30, TimeUnit.SECONDS)
                        // build the cacheloader
                        .build(new CacheLoader(){
                            @Override
                            public Object load(Object key) throws Exception {
                                return getFromDatabase(key.toString());
                            }
                        });

        try {
            //on first invocation, cache will be populated with corresponding
            //employee record
            System.out.println("Invocation #1");
            System.out.println(employeeCache.get("100"));
            System.out.println(employeeCache.get("103"));
            System.out.println(employeeCache.get("110"));
            //second invocation, data will be returned from cache

            //超过缓存时间则重新按照规则取值
            //TimeUnit.SECONDS.sleep(30);
            System.out.println("Invocation #2");
            System.out.println(employeeCache.get("100"));
            System.out.println(employeeCache.get("103"));
            System.out.println(employeeCache.get("110"));
            //throws InvalidCacheLoadException: CacheLoader returned null for key 200.
            //System.out.println(employeeCache.get("200"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Employee getFromDatabase(String empId){
        Employee e1 = new Employee("Mahesh", "Finance", "100");
        Employee e2 = new Employee("Rohan", "IT", "103");
        Employee e3 = new Employee("Sohan", "Admin", "110");

        Map database = new HashMap();
        database.put("100", e1);
        database.put("103", e2);
        database.put("110", e3);
        System.out.println("Database hit for" + empId);
        return (Employee)database.get(empId);
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@ToString
class Employee {
    String name;
    String dept;
    String emplD;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(Employee.class)
                //设置别名
                .add("Name", name)
                .add("Department", dept)
                .add("Emp Id", emplD).toString();
    }
}
