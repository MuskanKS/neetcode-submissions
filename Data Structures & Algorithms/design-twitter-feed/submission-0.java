
class Twitter {

    // Stores each user's tweets
    private Map<Integer, List<Tweet>> tweets;

    // Stores whom each user follows
    private Map<Integer, Set<Integer>> following;

    // Gives every tweet a unique posting time
    private int timestamp;

    // Represents one tweet
    class Tweet {
        int tweetId;
        int time;

        Tweet(int tweetId, int time) {
            this.tweetId = tweetId;
            this.time = time;
        }
    }

    public Twitter() {
        tweets = new HashMap<>();
        following = new HashMap<>();
        timestamp = 0;
    }

    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId, new ArrayList<>());

        tweets.get(userId).add(new Tweet(tweetId, timestamp++));
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> maxHeap =
            new PriorityQueue<>((a, b) -> b.time - a.time);

        // Include the user's own tweets
        addTweetsToHeap(userId, maxHeap);

        // Include tweets from followed users
        Set<Integer> users = following.getOrDefault(
            userId, new HashSet<>()
        );

        for (int followeeId : users) {
            addTweetsToHeap(followeeId, maxHeap);
        }

        List<Integer> feed = new ArrayList<>();

        // Get at most 10 newest tweets
        while (!maxHeap.isEmpty() && feed.size() < 10) {
            feed.add(maxHeap.poll().tweetId);
        }

        return feed;
    }

    private void addTweetsToHeap(
        int userId, PriorityQueue<Tweet> maxHeap
    ) {
        List<Tweet> userTweets = tweets.get(userId);

        if (userTweets != null) {
            for (Tweet tweet : userTweets) {
                maxHeap.offer(tweet);
            }
        }
    }

    public void follow(int followerId, int followeeId) {
        following.putIfAbsent(followerId, new HashSet<>());
        following.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (following.containsKey(followerId)) {
            following.get(followerId).remove(followeeId);
        }
    }
}