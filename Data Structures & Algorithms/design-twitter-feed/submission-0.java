class Twitter {
    private Map<Integer, Node> userTweetMap = new HashMap<>();
    private Map<Integer, Set<Integer>> userFollowMap=new HashMap<>();
    public Twitter() {
        
    }
    
    public void postTweet(int userId, int tweetId) {
        Node node = Node.addHead(userTweetMap.get(userId), new Node( new Tweet(tweetId)));
        userTweetMap.put(userId, node);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        //get all followee
        Set<Integer> set = userFollowMap.get(userId);
        List<Integer> ans = new ArrayList<>();
        if(set==null || set.isEmpty()){
            set = new HashSet<>();
        }
        set.add(userId);

         PriorityQueue<Node> pq=new PriorityQueue<>((a, b) -> b.t.timeStamp-a.t.timeStamp);
        for(int i: set){
            if(userTweetMap.get(i)!=null){
                 pq.offer(userTweetMap.get(i));
            }
        }
        for(int i=0;i<10&& !pq.isEmpty();i++){
            Node n = pq.poll();
            ans.add(n.t.tweetId);
            if(n.next!= null){
                pq.offer(n.next);
            }
        }
        return ans;

    }
    
    public void follow(int followerId, int followeeId) {
        userFollowMap.computeIfAbsent(followerId, f-> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        userFollowMap.computeIfAbsent(followerId, f-> new HashSet<>()).remove(followeeId);
    }
}

class Tweet{
    private static int increamental = 0;
    int tweetId;
    int timeStamp;
    public Tweet(int tweetId){
        this.tweetId=tweetId;
        this.timeStamp=increamental++;
    }
}

class Node{
    Tweet t;
    Node next;
    public Node(Tweet t){
        this.t=t;
    }

    public static Node addHead(Node head, Node node){
        if(head==null){
            return node;
        }
        node.next=head;
        return node;
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */