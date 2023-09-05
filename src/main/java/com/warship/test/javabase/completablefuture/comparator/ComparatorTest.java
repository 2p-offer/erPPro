package com.warship.test.javabase.completablefuture.comparator;

/**
 * @author erp
 */
public class ComparatorTest {

    public static void main(String[] args) {
//        Map<String, MyObj> testMap = new HashMap<>();
//        testMap.put("1", new MyObj("1", 1));
//        testMap.put("3", new MyObj("3", 3));
//        testMap.put("4", new MyObj("4", 3));
//        testMap.put("2", new MyObj("2", 2));
//        final List<String> ans = testMap.values()
//                .stream()
//                .map(myObj -> new MyObj(myObj.getId(), myObj.getTime()))
//                .sorted(Comparator.<MyObj>comparingLong(obj -> obj.getTime())
//                        .thenComparing(MyObj::getId).reversed())
//                .limit(5)
//                .map(MyObj::getId)
//                .collect(Collectors.toList());
//        System.out.println(ans);
//
        double a = 41;
        double b = 11;
        System.out.println(b/a);

    }


    static class MyObj {

        public MyObj(String id, long time) {
            this.id = id;
            this.time = time;
        }

        String id;
        long time;

        @Override
        public String toString() {
            return "MyObj{" +
                    "id='" + id + '\'' +
                    ", time=" + time +
                    '}';
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public long getTime() {
            return time;
        }

        public void setTime(long time) {
            this.time = time;
        }
    }
}
