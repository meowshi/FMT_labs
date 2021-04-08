public class URLDepthPair {
    private String URL;
    private int depth;
    
    public URLDepthPair(String u, int d) {
        URL = u;
        depth = d;
    }

    public String getURL() {
        return URL;
    }

    public int getDepth() {
        return depth;
    }
    
    public String toString() {
        return "URL: " + URL + ", depth: " + depth;
    }
}
