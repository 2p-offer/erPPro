package com.warship.test.productandconsume;

import com.alibaba.fastjson2.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ProductConsumeTest {


    public static void main(String[] args) {

        final BlockingQueue<Item> container = new LinkedBlockingQueue<>();

        Thread product = new Thread(() -> {
            int i = 0;
            while (true) {
                Item item = new Item(i, "name:" + i);
                container.add(item);
                System.out.println("ProductConsumeTest >> product ,size:" + container.size() + ",item :" + item.toString());
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;
            }
        });

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);

        executorService.scheduleAtFixedRate(() -> {
            int currentSize = container.size();
            List<Item> list = new ArrayList<>();
            for (int i = 0; i < currentSize; i++) {
                list.add(container.poll());
            }
            System.out.println("ProductConsumeTest >> consume ,currentSize:" + currentSize + ",result:" + JSONObject.toJSONString(list));


        }, 10, 10, TimeUnit.SECONDS);

        product.start();
    }
}
