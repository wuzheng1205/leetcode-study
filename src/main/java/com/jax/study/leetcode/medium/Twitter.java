package com.jax.study.leetcode.medium;

import java.util.*;

/**
 * 待优化
 */
class Twitter {

    private Map<Integer, Set<Integer>> followMap;

    private LinkedList<Tweet> userTweetes;

    /**
     * Initialize your data structure here.
     */
    public Twitter() {
        followMap = new HashMap<>();
        userTweetes = new LinkedList<>();
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        userTweetes.addFirst(new Tweet(tweetId, userId, System.currentTimeMillis()));
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> followList = followMap.get(userId);
        if (followList == null) {
            followList = new HashSet<>();
        }
        LinkedList<Integer> top10TweetList = new LinkedList<>();
        for (Tweet userTweet : userTweetes) {
            if (top10TweetList.size() == 10) {
                break;
            }
            if (userTweet.postUserId == userId || followList.contains(userTweet.postUserId)) {
                top10TweetList.addLast(userTweet.tweetId);
            }
        }
        return top10TweetList;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        Set<Integer> followList = getFollowList(followerId);
        followList.add(followeeId);
        followMap.put(followerId, followList);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followList = getFollowList(followerId);
        followList.remove(followeeId);
        followMap.put(followerId, followList);
    }

    private Set<Integer> getFollowList(int followerId) {
        Set<Integer> followList;
        if (followMap.get(followerId) == null) {
            followList = new HashSet<>();
        } else {
            followList = followMap.get(followerId);
        }
        return followList;
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();

// 用户1发送了一条新推文 (用户id = 1, 推文id = 5).
        twitter.postTweet(1, 5);

// 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
        System.out.println(twitter.getNewsFeed(1));

// 用户1关注了用户2.
        twitter.follow(1, 2);

// 用户2发送了一个新推文 (推文id = 6).
        twitter.postTweet(2, 6);

// 用户1的获取推文应当返回一个列表，其中包含两个推文，id分别为 -> [6, 5].
// 推文id6应当在推文id5之前，因为它是在5之后发送的.
        System.out.println(twitter.getNewsFeed(1));

// 用户1取消关注了用户2.
        twitter.unfollow(1, 2);

// 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
// 因为用户1已经不再关注用户2.
        System.out.println(twitter.getNewsFeed(1));
    }
}

class Tweet {
    public int tweetId;
    public int postUserId;
    public long postTime;

    public Tweet(int tweetId, int postUserId, long postTime) {
        this.tweetId = tweetId;
        this.postUserId = postUserId;
        this.postTime = postTime;
    }
}