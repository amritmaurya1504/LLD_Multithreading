package com.lld.designPatterns.structural.proxy;

// Subject Interface: common for Real and Proxy
interface VideoDownloader {
    void downloadVideo(String videoUrl);
}

// RealSubject: does the real work (expensive operation)
class RealVideoDownloader implements VideoDownloader {
    @Override
    public void downloadVideo(String videoUrl) {
        System.out.println("Downloading video from YouTube: " + videoUrl);
    }
}

// Proxy: controls access to RealVideoDownloader
class ProxyVideoDownloader implements VideoDownloader {
    private RealVideoDownloader realDownloader = new RealVideoDownloader();
    private java.util.Set<String> downloadedVideos = new java.util.HashSet<>();

    @Override
    public void downloadVideo(String videoUrl) {
        if (downloadedVideos.contains(videoUrl)) {
            System.out.println("Fetching video from cache: " + videoUrl);
        } else {
            realDownloader.downloadVideo(videoUrl); // call actual service
            downloadedVideos.add(videoUrl);
        }
    }
}


public class Main {
    public static void main(String[] args) {
        VideoDownloader downloader = new ProxyVideoDownloader();

        // First time: goes to real service
        downloader.downloadVideo("video1.mp4");

        // Second time: comes from proxy cache
        downloader.downloadVideo("video1.mp4");

        // New video: real service again
        downloader.downloadVideo("video2.mp4");
    }
}
