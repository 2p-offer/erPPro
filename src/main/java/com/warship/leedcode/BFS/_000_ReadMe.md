> BFS 是什么？

广度优先搜索

> BFS 解决那类问题？

最短路径问题，以及..

> BFS 的核心思路？

1. 一个queue，是核心数据结构，存储可以作为下一步的起点的所有节点
2. 一个集合，visited。存储我们已经访问过的节点，防止走回头路导致死循环
3. 一个以当前节点为起点，获取所有下一步集合的方法。用于决定我们下一步可能去往哪里


``` java
  int BFS(Node start,Node end){
        Queue<Node> queue = new LinkedList<Node>(); // 核心队列
        Set<Node> visited = new HashSet<>;  //别走回头路
        queue.offer(start);
        visited.add(start);
        int step = 0;
        while(!queue.isEmpty()){
            int size = queue.size();//在这时候，我们确定这一步【当前step】我们可以当做起点的个数
            for(int i = 0 ; i < size;i++){
                Node cur = queue.poll();
                if(cur.equals(target)){//出口
                    return step;
                }       
                for(Node no : cur.childs()){//获取下一步的所有可能
                    if(!visited.contains(no)){
                        queue.offer(no);
                        visited.add(no);
                    }
                }       
            }   
            step++;//结果累加    
        }   
}
```

