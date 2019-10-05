package com.jiejie.mall.common.utils;



import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.cglib.core.Converter;
import org.springframework.util.CollectionUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.math.BigDecimal;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Collector;
import java.util.stream.Stream;

/**
 * @desc bean对象的拷贝
 */
public class BeanCopyUtil {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(BeanCopyUtil.class);
    public BeanCopyUtil() {
    }

    public static <T> List<T> copyList(Class<T> dest, List orig) {
        if (CollectionUtils.isEmpty(orig)) {
            return new ArrayList();
        } else {
            BeanCopier beanCopier = BeanCopier.create(orig.get(0).getClass(), dest, false);
            ArrayList resultList = new ArrayList(orig.size());

            try {
                Iterator var4 = orig.iterator();

                while(var4.hasNext()) {
                    Object o = var4.next();
                    if (o != null) {
                        T destObject = dest.newInstance();
                        beanCopier.copy(o, destObject, (Converter)null);
                        resultList.add(destObject);
                    }
                }

                return resultList;
            } catch (Exception var7) {
                log.error("copyList error", var7);
                return resultList;
            }
        }
    }

    public static <D, O> List<D> copyList(Class<D> dest, List<O> orig, Consumer<D> d) {
        if (CollectionUtils.isEmpty(orig)) {
            return new ArrayList();
        } else {
            BeanCopier beanCopier = BeanCopier.create(orig.get(0).getClass(), dest, false);
            ArrayList resultList = new ArrayList(orig.size());

            try {
                Iterator var5 = orig.iterator();

                while(var5.hasNext()) {
                    Object o = var5.next();
                    if (o != null) {
                        D destObject = dest.newInstance();
                        beanCopier.copy(o, destObject, (Converter)null);
                        if (d != null) {
                            d.accept(destObject);
                        }

                        resultList.add(destObject);
                    }
                }
            } catch (Exception var8) {
                log.error("copyList error", var8);
            }

            return resultList;
        }
    }

    public static <D, O> List<D> copyList(Class<D> dest, List<O> orig, BiConsumer<O, D> d) {
        if (CollectionUtils.isEmpty(orig)) {
            return new ArrayList();
        } else {
            BeanCopier beanCopier = BeanCopier.create(orig.get(0).getClass(), dest, false);
            ArrayList resultList = new ArrayList(orig.size());

            try {
                Iterator<O> var5 = orig.iterator();

                while(var5.hasNext()) {
                    O o = var5.next();
                    if (o != null) {
                        D destObject = dest.newInstance();
                        beanCopier.copy(o, destObject, (Converter)null);
                        if (d != null) {
                            d.accept(o, destObject);
                        }

                        resultList.add(destObject);
                    }
                }
            } catch (Exception var8) {
                log.error("copyList error", var8);
            }

            return resultList;
        }
    }

    public static <T> List<T> copyListAndDetail(Class<T> dest, List orig, Map<String, String> transformKey) {
        return copyListAndDetail(dest, orig, transformKey, (BiConsumer)null);
    }

    public static <T, C> List<T> copyListAndDetail(Class<T> dest, List orig, Map<String, String> transformKey, BiConsumer<T, C> consumer) {
        try {
            List<T> resultList = new ArrayList();
            if (orig != null && orig.size() > 0) {
                Field[] originFields = null;
                Field[] destFields = null;
                int i = 0;
                if (!CollectionUtils.isEmpty(transformKey)) {
                    originFields = new Field[transformKey.size()];
                    destFields = new Field[transformKey.size()];
                    Class origClass = orig.get(0).getClass();
                    Set<Map.Entry<String, String>> entries = transformKey.entrySet();

                    for(Iterator iterator = entries.iterator(); iterator.hasNext(); ++i) {
                        Map.Entry<String, String> entry = (Map.Entry)iterator.next();
                        String key = (String)entry.getKey();
                        String value = (String)entry.getValue();
                        originFields[i] = origClass.getDeclaredField(key);
                        destFields[i] = dest.getDeclaredField(value);
                    }

                    AccessibleObject.setAccessible(originFields, true);
                    AccessibleObject.setAccessible(destFields, true);
                }

                Iterator var18 = orig.iterator();

                while(true) {
                    Object o;
                    Object destObject;
                    do {
                        if (!var18.hasNext()) {
                            if (originFields != null && destFields != null) {
                                AccessibleObject.setAccessible(originFields, false);
                                AccessibleObject.setAccessible(destFields, false);
                            }

                            return resultList;
                        }

                        o = var18.next();
                        destObject = dest.newInstance();
                    } while(o == null);

                    copyProperties(destObject, o);

                    for(int a = 0; a < i; ++a) {
                        Field originField = originFields[a];
                        List o1 = (List)originField.get(o);
                        Field destField = destFields[a];
                        Class childClass = (Class)((ParameterizedType)destField.getGenericType()).getActualTypeArguments()[0];
                        List destList = copyList(childClass, o1,(T) destObject, consumer);
                        destField.set(destObject, destList);
                    }

                    resultList.add((T)destObject);
                }
            } else {
                return resultList;
            }
        } catch (Exception var17) {
            log.error("copyListAndDetail error", var17);
            return null;
        }
    }

    private static <T, O> List<T> copyList(Class<T> dest, List orig, O out, BiConsumer<O, T> consumer) {
        if (CollectionUtils.isEmpty(orig)) {
            return new ArrayList();
        } else {
            BeanCopier beanCopier = BeanCopier.create(orig.get(0).getClass(), dest, false);
            ArrayList resultList = new ArrayList(orig.size());

            try {
                Iterator var6 = orig.iterator();

                while(var6.hasNext()) {
                    Object o = var6.next();
                    if (o != null) {
                        T destObject = dest.newInstance();
                        beanCopier.copy(o, destObject, (Converter)null);
                        resultList.add(destObject);
                        if (out != null && consumer != null) {
                            consumer.accept(out, destObject);
                        }
                    }
                }

                return resultList;
            } catch (Exception var9) {
                log.error("copyList error", var9);
                return resultList;
            }
        }
    }

    public static <T> T copyProperties(Class<T> dest, Object... orig) {
        if (orig == null) {
            return null;
        } else {
            try {
                T destObject = dest.newInstance();
                Object[] var3 = orig;
                int var4 = orig.length;

                for(int var5 = 0; var5 < var4; ++var5) {
                    Object o = var3[var5];
                    copyProperties(destObject, o);
                }

                return destObject;
            } catch (Exception var7) {
                log.error("copyProperties error", var7);
                return null;
            }
        }
    }

    public static <T> T copyProperties(Class<T> dest, Object orig) {
        if (orig == null) {
            return null;
        } else {
            try {
                T destObject = dest.newInstance();
                copyProperties(destObject, orig);
                return destObject;
            } catch (Exception var3) {
                log.error("copyProperties error", var3);
                return null;
            }
        }
    }

    public static void copyProperties(Object dest, Object orig) {
        try {
            BeanCopier copier = BeanCopier.create(orig.getClass(), dest.getClass(), false);
            copier.copy(orig, dest, (Converter)null);
        } catch (Exception var3) {
            log.error("copyProperties error", var3);
        }

    }

    public static void populate(Object bean, Map properties) {
        try {
            BeanMap beanMap = BeanMap.create(bean);
            beanMap.putAll(properties);
        } catch (Exception var3) {
            log.error("populate bean property error", var3);
        }

    }

    public static <T> T populate(Class<T> c, Map properties) {
        try {
            T o = c.newInstance();
            BeanMap beanMap = BeanMap.create(o);
            beanMap.putAll(properties);
            return (T)beanMap.getBean();
        } catch (Exception var4) {
            log.error("populate bean property error", var4);
            return null;
        }
    }

    public static <T> List<T> populateList(Class<T> dest, List<Map<String, Object>> orig) {
        if (CollectionUtils.isEmpty(orig)) {
            return new ArrayList();
        } else {
            ArrayList resultList = new ArrayList(orig.size());

            try {
                BeanMap beanMap = BeanMap.create(dest.newInstance());
                Iterator var4 = orig.iterator();

                while(var4.hasNext()) {
                    Map o = (Map)var4.next();
                    if (o != null) {
                        T destObject = dest.newInstance();
                        beanMap.setBean(destObject);
                        beanMap.putAll(o);
                        resultList.add(destObject);
                    }
                }

                return resultList;
            } catch (Exception var7) {
                log.error("copyList error", var7);
                return resultList;
            }
        }
    }

    public static <T> T getSingleResult(List<T> list) {
        if (CollectionUtils.isEmpty(list)) {
            return null;
        } else if (list.size() == 1) {
            return list.get(0);
        } else {
            throw new BusinessException("加载到多余条数");
        }
    }

    public static <T> T getFirstResult(List<T> list) {
        return CollectionUtils.isEmpty(list) ? null : list.get(0);
    }

    public static <K, V, T> Map<K, V> transformListToMap(List<T> stat, Collector<T, Map, Map> collector) {
        Map<K, V> hashMap = null;
        if (!CollectionUtils.isEmpty(stat)) {
            Stream<T> stream = null;
            if (stat.size() > 1000) {
                stream = stat.parallelStream();
            } else {
                stream = stat.stream();
            }

            hashMap = (Map)stream.collect(collector);
        }

        return hashMap;
    }

    public static <T> Map<String, T> getAssemblyResult(Map<String, T> finalResult, Map<String, T> intoResult, Class<T> c, String[] params) throws InvocationTargetException, IllegalAccessException {
        if (!CollectionUtils.isEmpty(intoResult)) {
            Iterator var4 = intoResult.entrySet().iterator();

            while(true) {
                while(var4.hasNext()) {
                    Map.Entry<String, T> entry = (Map.Entry)var4.next();
                    String key = (String)entry.getKey();
                    T value = entry.getValue();
                    T statPerDayOrder = finalResult.get(key);
                    if (statPerDayOrder == null) {
                        finalResult.put(key, value);
                    } else {
                        String[] var9 = params;
                        int var10 = params.length;

                        for(int var11 = 0; var11 < var10; ++var11) {
                            String param = var9[var11];
                            PropertyDescriptor propertyDescriptor = BeanUtils.getPropertyDescriptor(c, param);
                            Method readMethod = propertyDescriptor.getReadMethod();
                            Method writeMethod = propertyDescriptor.getWriteMethod();
                            Object oldValue = readMethod.invoke(statPerDayOrder);
                            Object paramValue = readMethod.invoke(value);
                            if (oldValue != null && paramValue != null) {
                                if (BigDecimal.class.isInstance(paramValue)) {
                                    BigDecimal old = (BigDecimal)oldValue;
                                    paramValue = old.add((BigDecimal)paramValue);
                                } else if (Integer.class.isInstance(paramValue)) {
                                    Integer old = (Integer)oldValue;
                                    paramValue = old + (Integer)paramValue;
                                } else if (Long.class.isInstance(paramValue)) {
                                    Long old = (Long)oldValue;
                                    paramValue = old + (Long)paramValue;
                                }
                            }

                            writeMethod.invoke(statPerDayOrder, paramValue);
                        }
                    }
                }

                return finalResult;
            }
        } else {
            return finalResult;
        }
    }

}
