package  com.warship.leedcode.daily._21_03;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class _3_23_NestedIterator implements Iterator<Integer> {

    List<Integer> container;
    int index = -1;

    public _3_23_NestedIterator(List<_3_23_NestedInteger> nestedList) {
        if (nestedList == null) {
            return;
        }
        container = new ArrayList<>();
        appendContainer(nestedList);
    }

    private void appendContainer(List<_3_23_NestedInteger> nestedList) {
        for (_3_23_NestedInteger tmp : nestedList) {
            if (tmp.isInteger()) {
                container.add(tmp.getInteger());
            } else {
                appendContainer(tmp.getList());
            }
        }
    }

    @Override
    public Integer next() {
        index++;
        return container.get(index);
    }

    @Override
    public boolean hasNext() {
        return index >= container.size();
    }

    /**
     *     List<Integer> container;
     *     int index = -1;
     *
     *     public NestedIterator(List<NestedInteger> nestedList) {
     *         if (nestedList == null) {
     *             return;
     *         }
     *         container = new ArrayList<>();
     *         appendContainer(nestedList);
     *     }
     *
     *     private void appendContainer(List<NestedInteger> nestedList) {
     *         for (NestedInteger tmp : nestedList) {
     *             if (tmp.isInteger()) {
     *                 container.add(tmp.getInteger());
     *             } else {
     *                 appendContainer(tmp.getList());
     *             }
     *         }
     *     }
     *
     *     @Override
     *     public Integer next() {
     *         index++;
     *         return container.get(index);
     *     }
     *
     *     @Override
     *     public boolean hasNext() {
     *         return index < container.size()-1;
     *     }
     */
}


