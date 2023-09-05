package com.warship.test.wrx.siweidaotu;

import com.alibaba.fastjson2.JSONObject;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * @author erp
 */
public class MindMapPosition {


    /** 所有的叶子节点 */
    static List<MindNode> leafNodes = new ArrayList<>();


    public void getMindNodePos() {
        List<MindNode> targetNodes = buildDataSource();
        MindNode fakeNode = new MindNode();
        fakeNode.nodes = targetNodes;
        fakeNode.nodes.get(0).x = 10;
    }

    /**
     * @param node 处理的节点
     * @param topX x 起始位置
     * @param topY y 起始位置
     * @return 这个节点以及所有子节点 触及到的最大的y值
     */
    private int dealSingalNode(MindNode node, int topX, int topY) {
        return 0;
    }


    private static void getLeafNodes(MindNode rootNode, int deep) {
        final List<MindNode> nodes = rootNode.nodes;
        if (nodes == null || rootNode.nodes.size() == 0) {
            setLeafPos(rootNode, leafNodes.size());
            leafNodes.add(rootNode);
            return;
        }

        for (int i = 0; i < nodes.size(); i++) {
            final MindNode tmpNode = nodes.get(i);
            tmpNode.setDeep(deep);
            getLeafNodes(tmpNode, deep + 1);
        }

    }

    private static void get(MindNode node) {
        if (node == null /*|| node.isGot()*/) {
            return;
        }
        final List<MindNode> sonNodes = node.nodes;
        if (sonNodes == null || sonNodes.size() == 0) {
            return;
        }

        for (int i = 0; i < sonNodes.size(); i++) {
            final MindNode sunNode = sonNodes.get(i);
            get(sunNode);
            if (sonNodes.size() % 2 == 0) {
                //偶数子节点
                node.setY((sonNodes.get(0).y + sonNodes.get(sonNodes.size() - 1).y) / 2);
            } else {
                //奇数子节点
                node.setY(sonNodes.get((sonNodes.size() - 1) / 2).y);
            }
            node.setX((node.deep - 1) * (NODE_WEIGHT + PARENT_SON_X));
        }
    }

    /** 父节点和子节点横向距离 */
    private static final int PARENT_SON_X = 10;

    /** 同级节点的y距离 */
    public static final int NODE_DISTANCE_Y = 100;

    /** 节点宽度 */
    public static final int NODE_WEIGHT = 1000;

    /** 节点高度 */
    public static final int NODE_HIGH = 10000;

    private static void setLeafPos(MindNode node, int size) {
        int x = (node.deep - 1) * (NODE_WEIGHT + PARENT_SON_X);
        int y = size * (NODE_HIGH + NODE_DISTANCE_Y);
        node.setX(x);
        node.setY(y);
    }


    private List<MindNode> buildDataSource() {


        MindNode node555 = new MindNode();
//        node111.setX(111);
//        node111.setY(111);
        node555.setId(555);

        MindNode node666 = new MindNode();
//        node111.setX(111);
//        node111.setY(111);
        node666.setId(666);
        MindNode node111 = new MindNode();
//        node111.setX(111);
//        node111.setY(111);
        node111.setId(111);
        node111.setNodes(Lists.newArrayList(node555));

        MindNode node222 = new MindNode();
//        node222.setX(222);
//        node222.setY(222);

        node222.setId(222);
//
        MindNode node333 = new MindNode();
//        node333.setX(333);
//        node333.setY(333);
        node333.setId(333);

        MindNode node444 = new MindNode();
//        node444.setX(444);
//        node444.setY(444);
        node444.setId(444);


        MindNode node11 = new MindNode();
//        node11.setX(11);
//        node11.setY(11);
        node11.setId(11);
        node11.setNodes(Lists.newArrayList(node111, node666, node222));

        MindNode node22 = new MindNode();
//        node22.setX(22);
//        node22.setY(22);
        node22.setId(22);
        node22.setNodes(Lists.newArrayList(node444,node333));

        MindNode node1 = new MindNode();
//        node1.setX(1);
//        node1.setY(1);
        node1.setId(1);
        node1.setNodes(Lists.newArrayList(node11, node22));


        return Lists.newArrayList(node1);
    }

    public static void main(String[] args) {
        MindMapPosition test = new MindMapPosition();
        final List<MindNode> mindNodes = test.buildDataSource();
        getLeafNodes(mindNodes.get(0), 1);
        get(mindNodes.get(0));
        System.out.println(JSONObject.toJSONString(mindNodes));
    }

    static class MindNode {

        private int id;

        private int x;

        private int y;

        private int deep;

        private List<MindNode> nodes;

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public List<MindNode> getNodes() {
            return nodes;
        }

        public void setNodes(List<MindNode> nodes) {
            this.nodes = nodes;
        }

        public int getDeep() {
            return deep;
        }

        public void setDeep(int deep) {
            this.deep = deep;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public boolean isGot() {
            return x > 0 && y > 0;
        }

        @Override
        public String toString() {
            return "MindNode{" +
                    "id=" + id +
                    ", x=" + x +
                    ", y=" + y +
                    ", deep=" + deep +
                    ", nodes=" + nodes +
                    '}';
        }
    }
}
