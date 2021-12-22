package CyC2018.Leetcode.DataStructure.Hash;

import java.util.HashMap;

public class Leetcode_535_TinyURL {

    HashMap<Integer, String> url_map = new HashMap<>();
    int index = 0;

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        url_map.put(index, longUrl);
        return "http://tinyurl.com/" + index++;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return url_map.get(Integer.parseInt(shortUrl.replace("http://tinyurl.com/", "")));
    }
}
